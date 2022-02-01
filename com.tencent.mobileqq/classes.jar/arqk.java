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

public class arqk
  extends arpg<CameraEmotionData>
{
  private anio jdField_a_of_type_Anio = new arql(this);
  HashMap<CameraEmotionData, arqn> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  volatile String b;
  private volatile String c;
  
  public arqk(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anio);
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
  
  public allk a(String paramString)
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
          return new allk(j, i);
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
  
  protected anjw<CameraEmotionData> a()
  {
    return (anim)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(160);
  }
  
  protected arpe<CameraEmotionData> a()
  {
    return (arqr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333);
  }
  
  public String a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_JavaLangString = bgjb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "camera_emo_list_version");
      this.jdField_a_of_type_Boolean = true;
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a(int paramInt, CameraEmotionData paramCameraEmotionData)
  {
    arqn localarqn = (arqn)this.jdField_a_of_type_JavaUtilHashMap.get(paramCameraEmotionData);
    if (localarqn != null)
    {
      localarqn.a(paramInt, paramCameraEmotionData);
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
    if (!bgnt.d(BaseApplication.getContext()))
    {
      QLog.d("CameraEmoRoamingManager", 1, "realUploadCustomEmoticon start, net not support");
      a(12, paramCameraEmotionData);
      return;
    }
    QLog.d("CameraEmoRoamingManager", 1, "realUploadCustomEmoticon start");
    bdzn localbdzn = new bdzn();
    localbdzn.jdField_b_of_type_Int = 24;
    localbdzn.jdField_c_of_type_Int = 70;
    localbdzn.jdField_a_of_type_JavaLangString = "camera_emo_upload";
    localbdzn.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbdzn.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localbdzn.jdField_a_of_type_Boolean = true;
    localbdzn.jdField_a_of_type_Long = paramCameraEmotionData.emoId;
    localbdzn.i = paramCameraEmotionData.emoPath;
    Bdh_extinfo.CommFileExtReq localCommFileExtReq = new Bdh_extinfo.CommFileExtReq();
    localCommFileExtReq.uint32_action_type.set(0);
    localCommFileExtReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramCameraEmotionData.resid.getBytes()));
    localbdzn.jdField_a_of_type_ArrayOfByte = localCommFileExtReq.toByteArray();
    paramCameraEmotionData = new arqm(this, ThreadManagerV2.getSubThreadLooper(), paramCameraEmotionData);
    paramCameraEmotionData.addFilter(new Class[] { bdsp.class });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramCameraEmotionData);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbdzn);
  }
  
  public void a(CameraEmotionData paramCameraEmotionData, arqn paramarqn)
  {
    if (bgsp.a(paramCameraEmotionData.emoPath))
    {
      QLog.d("CameraEmoRoamingManager", 1, "uploadCameraEmo error, path is null");
      paramarqn.a(10, paramCameraEmotionData);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.d("CameraEmoRoamingManager", 1, "uploadCameraEmo, app is null");
      paramarqn.a(100, paramCameraEmotionData);
      return;
    }
    long l = a(paramCameraEmotionData.emoPath);
    allk localallk = a(paramCameraEmotionData.emoPath);
    if ((bgsp.a(paramCameraEmotionData.md5)) || (l == 0L) || (localallk.b() == 0) || (localallk.a() == 0))
    {
      QLog.d("CameraEmoRoamingManager", 1, new Object[] { "uploadCameraEmo params error, md5:", paramCameraEmotionData.md5, " size:", Long.valueOf(l), " width:", Integer.valueOf(localallk.a()), " height:", Integer.valueOf(localallk.b()) });
      paramarqn.a(14, paramCameraEmotionData);
      return;
    }
    QLog.d("CameraEmoRoamingManager", 1, "uploadCameraEmo start");
    this.jdField_a_of_type_JavaUtilHashMap.put(paramCameraEmotionData, paramarqn);
    ((anim)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(160)).a(paramCameraEmotionData, localallk.a(), localallk.b(), l);
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    bgjb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "camera_emo_list_version", paramString);
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "";; str = "has_value")
    {
      this.jdField_b_of_type_JavaLangString = str;
      bgjb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "camera_emo_guide_tag", this.jdField_b_of_type_JavaLangString);
      bgsg.a("camera_emo_guide_again_tag", Boolean.valueOf(paramBoolean));
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
      this.jdField_b_of_type_JavaLangString = bgjb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "camera_emo_guide_tag");
      if (this.jdField_b_of_type_JavaLangString == null) {
        this.jdField_b_of_type_JavaLangString = "";
      }
    }
    return ((bgsp.a(this.jdField_b_of_type_JavaLangString)) || (((Boolean)bgsg.a("camera_emo_guide_again_tag", Boolean.valueOf(true))).booleanValue())) && (c());
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    anim localanim;
    do
    {
      return;
      localanim = (anim)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(160);
    } while (localanim == null);
    ThreadManager.post(new CameraEmoRoamingManager.2(this, (arqr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333), localanim), 5, null, true);
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
    if ((this.jdField_a_of_type_Anio != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anio);
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
 * Qualified Name:     arqk
 * JD-Core Version:    0.7.0.1
 */