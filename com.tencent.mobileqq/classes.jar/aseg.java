import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoRoamingManager.2;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class aseg
  extends asdc<CameraEmotionData>
{
  private anrh jdField_a_of_type_Anrh = new aseh(this);
  HashMap<CameraEmotionData, asej> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  volatile String b = null;
  private volatile String c = "";
  
  public aseg(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anrh);
  }
  
  protected int a()
  {
    return 70;
  }
  
  public long a(String paramString)
  {
    long l = 0L;
    try
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        l = paramString.length();
      }
      return l;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public alsn a(String paramString)
  {
    int j = 0;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    label53:
    for (;;)
    {
      try
      {
        BitmapFactory.decodeFile(paramString, localOptions);
        int i = localOptions.outHeight;
        int k;
        QLog.e("CameraEmoRoamingManager", 1, "getImageSize has exception", paramString);
      }
      catch (Exception paramString)
      {
        try
        {
          k = localOptions.outWidth;
          j = k;
          return new alsn(j, i);
        }
        catch (Exception paramString)
        {
          break label53;
        }
        paramString = paramString;
        i = 0;
      }
    }
  }
  
  protected ansq<CameraEmotionData> a()
  {
    return (anrf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CAMERA_EMOTICON_HANDLER);
  }
  
  protected asda<CameraEmotionData> a()
  {
    return (asen)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CAMERA_EMOTION_DB_MANAGER);
  }
  
  public String a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.c = SharePreferenceUtils.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "camera_emo_list_version");
      this.jdField_a_of_type_Boolean = true;
    }
    return this.c;
  }
  
  public void a(int paramInt, CameraEmotionData paramCameraEmotionData)
  {
    asej localasej = (asej)this.jdField_a_of_type_JavaUtilHashMap.get(paramCameraEmotionData);
    if (localasej != null)
    {
      localasej.a(paramInt, paramCameraEmotionData);
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramCameraEmotionData);
    }
  }
  
  public void a(CameraEmotionData paramCameraEmotionData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.d("CameraEmoRoamingManager", 1, "realUploadCustomEmoticon start, app is null");
      a(100, paramCameraEmotionData);
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QLog.d("CameraEmoRoamingManager", 1, "realUploadCustomEmoticon start, net not support");
      a(12, paramCameraEmotionData);
      return;
    }
    QLog.d("CameraEmoRoamingManager", 1, "realUploadCustomEmoticon start");
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mFileType = 24;
    localTransferRequest.mCommandId = 70;
    localTransferRequest.mRichTag = "camera_emo_upload";
    localTransferRequest.mSelfUin = this.jdField_a_of_type_JavaLangString;
    localTransferRequest.mPeerUin = this.jdField_a_of_type_JavaLangString;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mUniseq = paramCameraEmotionData.emoId;
    localTransferRequest.mLocalPath = paramCameraEmotionData.emoPath;
    Bdh_extinfo.CommFileExtReq localCommFileExtReq = new Bdh_extinfo.CommFileExtReq();
    localCommFileExtReq.uint32_action_type.set(0);
    localCommFileExtReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramCameraEmotionData.resid.getBytes()));
    localTransferRequest.mExtentionInfo = localCommFileExtReq.toByteArray();
    paramCameraEmotionData = new asei(this, ThreadManagerV2.getSubThreadLooper(), paramCameraEmotionData);
    paramCameraEmotionData.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().addHandle(paramCameraEmotionData);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(localTransferRequest);
  }
  
  public void a(CameraEmotionData paramCameraEmotionData, asej paramasej)
  {
    if (StringUtil.isEmpty(paramCameraEmotionData.emoPath))
    {
      QLog.d("CameraEmoRoamingManager", 1, "uploadCameraEmo error, path is null");
      paramasej.a(10, paramCameraEmotionData);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.d("CameraEmoRoamingManager", 1, "uploadCameraEmo, app is null");
      paramasej.a(100, paramCameraEmotionData);
      return;
    }
    long l = a(paramCameraEmotionData.emoPath);
    alsn localalsn = a(paramCameraEmotionData.emoPath);
    if ((StringUtil.isEmpty(paramCameraEmotionData.md5)) || (l == 0L) || (localalsn.b() == 0) || (localalsn.a() == 0))
    {
      QLog.d("CameraEmoRoamingManager", 1, new Object[] { "uploadCameraEmo params error, md5:", paramCameraEmotionData.md5, " size:", Long.valueOf(l), " width:", Integer.valueOf(localalsn.a()), " height:", Integer.valueOf(localalsn.b()) });
      paramasej.a(14, paramCameraEmotionData);
      return;
    }
    QLog.d("CameraEmoRoamingManager", 1, "uploadCameraEmo start");
    this.jdField_a_of_type_JavaUtilHashMap.put(paramCameraEmotionData, paramasej);
    ((anrf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CAMERA_EMOTICON_HANDLER)).a(paramCameraEmotionData, localalsn.a(), localalsn.b(), l);
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    SharePreferenceUtils.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "camera_emo_list_version", paramString);
    this.c = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "";; str = "has_value")
    {
      this.b = str;
      SharePreferenceUtils.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "camera_emo_guide_tag", this.b);
      bhhr.a("camera_emo_guide_again_tag", Boolean.valueOf(paramBoolean));
      return;
    }
  }
  
  public void b(CameraEmotionData paramCameraEmotionData)
  {
    paramCameraEmotionData.increaseClickNum();
    a().b(paramCameraEmotionData);
  }
  
  public boolean b()
  {
    if ((this.b == null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      this.b = SharePreferenceUtils.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "camera_emo_guide_tag");
      if (this.b == null) {
        this.b = "";
      }
    }
    return ((StringUtil.isEmpty(this.b)) || (((Boolean)bhhr.a("camera_emo_guide_again_tag", Boolean.valueOf(true))).booleanValue())) && (c());
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    anrf localanrf;
    do
    {
      return;
      localanrf = (anrf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CAMERA_EMOTICON_HANDLER);
    } while (localanrf == null);
    ThreadManager.post(new CameraEmoRoamingManager.2(this, (asen)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CAMERA_EMOTION_DB_MANAGER), localanrf), 5, null, true);
  }
  
  public void c(CameraEmotionData paramCameraEmotionData)
  {
    paramCameraEmotionData.increaseExposeNum();
    a().b(paramCameraEmotionData);
  }
  
  public boolean c()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_Anrh != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anrh);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      a(15, (CameraEmotionData)((Map.Entry)localIterator.next()).getKey());
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aseg
 * JD-Core Version:    0.7.0.1
 */