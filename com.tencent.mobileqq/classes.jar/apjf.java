import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoRoamingManager.2;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class apjf
  extends apib<CameraEmotionData>
{
  private alku jdField_a_of_type_Alku = new apjg(this);
  HashMap<CameraEmotionData, apji> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  volatile String b;
  private volatile String c;
  
  public apjf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alku);
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
  
  public ajof a(String paramString)
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
          return new ajof(j, i);
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
  
  protected ally<CameraEmotionData> a()
  {
    return (alks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(160);
  }
  
  protected aphz<CameraEmotionData> a()
  {
    return (apjm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333);
  }
  
  public String a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_JavaLangString = bczr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "camera_emo_list_version");
      this.jdField_a_of_type_Boolean = true;
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a(int paramInt, CameraEmotionData paramCameraEmotionData)
  {
    apji localapji = (apji)this.jdField_a_of_type_JavaUtilHashMap.get(paramCameraEmotionData);
    if (localapji != null)
    {
      localapji.a(paramInt, paramCameraEmotionData);
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
    if (!bdee.d(BaseApplication.getContext()))
    {
      QLog.d("CameraEmoRoamingManager", 1, "realUploadCustomEmoticon start, net not support");
      a(12, paramCameraEmotionData);
      return;
    }
    QLog.d("CameraEmoRoamingManager", 1, "realUploadCustomEmoticon start");
    baub localbaub = new baub();
    localbaub.jdField_b_of_type_Int = 24;
    localbaub.jdField_c_of_type_Int = 70;
    localbaub.jdField_a_of_type_JavaLangString = "camera_emo_upload";
    localbaub.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbaub.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbaub.jdField_a_of_type_Boolean = true;
    localbaub.jdField_a_of_type_Long = paramCameraEmotionData.emoId;
    localbaub.i = paramCameraEmotionData.emoPath;
    Bdh_extinfo.CommFileExtReq localCommFileExtReq = new Bdh_extinfo.CommFileExtReq();
    localCommFileExtReq.uint32_action_type.set(0);
    localCommFileExtReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramCameraEmotionData.resid.getBytes()));
    localbaub.jdField_a_of_type_ArrayOfByte = localCommFileExtReq.toByteArray();
    paramCameraEmotionData = new apjh(this, ThreadManagerV2.getSubThreadLooper(), paramCameraEmotionData);
    paramCameraEmotionData.addFilter(new Class[] { bamp.class });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramCameraEmotionData);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbaub);
  }
  
  public void a(CameraEmotionData paramCameraEmotionData, apji paramapji)
  {
    if (bdje.a(paramCameraEmotionData.emoPath))
    {
      QLog.d("CameraEmoRoamingManager", 1, "uploadCameraEmo error, path is null");
      paramapji.a(10, paramCameraEmotionData);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.d("CameraEmoRoamingManager", 1, "uploadCameraEmo, app is null");
      paramapji.a(100, paramCameraEmotionData);
      return;
    }
    long l = a(paramCameraEmotionData.emoPath);
    ajof localajof = a(paramCameraEmotionData.emoPath);
    if ((bdje.a(paramCameraEmotionData.md5)) || (l == 0L) || (localajof.b() == 0) || (localajof.a() == 0))
    {
      QLog.d("CameraEmoRoamingManager", 1, new Object[] { "uploadCameraEmo params error, md5:", paramCameraEmotionData.md5, " size:", Long.valueOf(l), " width:", Integer.valueOf(localajof.a()), " height:", Integer.valueOf(localajof.b()) });
      paramapji.a(14, paramCameraEmotionData);
      return;
    }
    QLog.d("CameraEmoRoamingManager", 1, "uploadCameraEmo start");
    this.jdField_a_of_type_JavaUtilHashMap.put(paramCameraEmotionData, paramapji);
    ((alks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(160)).a(paramCameraEmotionData, localajof.a(), localajof.b(), l);
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    bczr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "camera_emo_list_version", paramString);
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "";; str = "has_value")
    {
      this.jdField_b_of_type_JavaLangString = str;
      bczr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "camera_emo_guide_tag", this.jdField_b_of_type_JavaLangString);
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
    if ((this.jdField_b_of_type_JavaLangString == null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      this.jdField_b_of_type_JavaLangString = bczr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "camera_emo_guide_tag");
      if (this.jdField_b_of_type_JavaLangString == null) {
        this.jdField_b_of_type_JavaLangString = "";
      }
    }
    return (bdje.a(this.jdField_b_of_type_JavaLangString)) && (c());
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    alks localalks;
    do
    {
      return;
      localalks = (alks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(160);
    } while (localalks == null);
    ThreadManager.post(new CameraEmoRoamingManager.2(this, (apjm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333), localalks), 5, null, true);
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
    if ((this.jdField_a_of_type_Alku != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alku);
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
 * Qualified Name:     apjf
 * JD-Core Version:    0.7.0.1
 */