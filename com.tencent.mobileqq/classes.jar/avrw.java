import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

class avrw
  implements aysc
{
  avrw(avrv paramavrv, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, String paramString3) {}
  
  public void onResp(aysz paramaysz)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager_PTV", 2, "onResp resultcode: " + paramaysz.c + " threadid=" + Thread.currentThread().getId());
    }
    File localFile = new File(avrv.jdField_a_of_type_JavaIoFile, "temp_ptv_template_zip");
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip !zipfile.exists()");
      }
      ahvx.a(0);
      return;
    }
    Object localObject = "";
    try
    {
      paramaysz = bbdx.c(localFile.getPath());
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramaysz))) {}
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        try
        {
          nav.a(localFile, this.b);
          paramaysz = new File(this.c);
          if (!paramaysz.exists()) {
            break label330;
          }
          paramaysz = avrv.a(paramaysz);
          localObject = avrv.a(null, paramaysz, this.jdField_a_of_type_Avrv.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig);
          if ((localObject != null) && (!((List)localObject).isEmpty())) {
            break;
          }
          avrv.a(paramaysz, "ptv_template_new.cfg");
          if (QLog.isColorLevel()) {
            QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip null == infos || infos.isEmpty()");
          }
          ahvx.a(-4);
          return;
          localUnsatisfiedLinkError = localUnsatisfiedLinkError;
          paramaysz = (aysz)localObject;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localUnsatisfiedLinkError.printStackTrace();
          paramaysz = (aysz)localObject;
        }
        catch (Exception paramaysz)
        {
          ahvx.a(-3);
          bbkb.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 0);
          if (!QLog.isColorLevel()) {
            continue;
          }
          paramaysz.printStackTrace();
          continue;
        }
        ahvx.a(-2);
      }
      avrv.a(paramaysz, "ptv_template_new.cfg");
      this.jdField_a_of_type_Avrv.c(false);
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip finsh configContent=" + paramaysz);
      }
      ahvx.a(1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(new Intent("action_brocassreceiver_for_ptv"));
      return;
    }
    label330:
    if (QLog.isColorLevel()) {
      QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip !jsonFile.exists()");
    }
    bbkb.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 0);
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avrw
 * JD-Core Version:    0.7.0.1
 */