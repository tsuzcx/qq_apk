import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.FaceScanNativeSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class asbx
  extends asbv
{
  private int a;
  private boolean d;
  
  public asbx(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.ar.face.so_v8.4.1_32", paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "FaceScanNativeSoDownloadHandler construct,STR_RES_NAME = qq.android.ar.face.so_v8.4.1_32,AppSetting.IS_CPU_64_BIT = false");
    }
  }
  
  public int a()
  {
    return 10061;
  }
  
  public Class<? extends XmlData> a()
  {
    return FaceScanNativeSoData.class;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    this.jdField_a_of_type_Int = ((int)(100L * paramLong1 / paramLong2));
    apgm.a(1, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "download progress: " + this.jdField_a_of_type_Int);
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean) {
      apgm.a(1, false);
    }
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "download finish: " + paramBoolean);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "download success: " + paramString);
    }
    int i = apgp.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "download success: " + paramString + ",ret = " + i);
    }
    if (i != 0)
    {
      g();
      f();
      apgm.a(1, false);
    }
    for (;;)
    {
      super.a(paramString);
      return;
      apgm.a(1, true);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008358", "0X8008358", 0, 0, "", "", "so", "");
      HashMap localHashMap = new HashMap();
      localHashMap.put("res_type", "so");
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "FaceResDownloadSuccess", true, 0L, 0L, localHashMap, "", true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.d) {
      this.d = paramBoolean;
    }
    super.a(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "download restart userClick" + paramBoolean);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return "prd";
  }
  
  public void b()
  {
    boolean bool = FileUtil.deleteFile(new File(apgp.a()));
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "deleteUnZipFile ret: " + bool);
    }
  }
  
  public void b(XmlData paramXmlData)
  {
    super.b(paramXmlData);
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "download begin");
    }
  }
  
  public boolean b()
  {
    if (this.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceScanNativeSoDownloadHandler", 2, "isNetValid2Download by user ");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "isNetValid2Download by startup ");
    }
    return super.b();
  }
  
  public boolean e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "downloadResource,isDownloadReqedByUser = " + this.d);
    }
    if (!this.d)
    {
      if (!apgm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FaceScanNativeSoDownloadHandler", 2, "pre download config disable ");
        }
        return false;
      }
      if (BaseActivity.sTopActivity == null) {
        break label115;
      }
    }
    label115:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceScanNativeSoDownloadHandler", 2, "downloadResource later " + bool);
      }
      if (bool) {
        break;
      }
      return super.e();
    }
  }
  
  public void f()
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("face_scan_sp", 4).edit().putInt("face_scan_native_so_version", b()).apply();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "restoreState");
    }
    a().loadState = 0;
    a().Version = 0;
    asbl.a(a(), new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbx
 * JD-Core Version:    0.7.0.1
 */