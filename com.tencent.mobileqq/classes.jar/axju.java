import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

class axju
  implements bapx
{
  axju(axjt paramaxjt, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, String paramString3) {}
  
  public void onResp(baqw parambaqw)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager_PTV", 2, "onResp resultcode: " + parambaqw.c + " threadid=" + Thread.currentThread().getId());
    }
    File localFile = new File(axjt.jdField_a_of_type_JavaIoFile, "temp_ptv_template_zip");
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip !zipfile.exists()");
      }
      ajnh.a(0);
      return;
    }
    Object localObject = "";
    try
    {
      parambaqw = bdcs.c(localFile.getPath());
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(parambaqw))) {}
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        try
        {
          ndr.a(localFile, this.b);
          parambaqw = new File(this.c);
          if (!parambaqw.exists()) {
            break label330;
          }
          parambaqw = axjt.a(parambaqw);
          localObject = axjt.a(null, parambaqw, this.jdField_a_of_type_Axjt.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig);
          if ((localObject != null) && (!((List)localObject).isEmpty())) {
            break;
          }
          axjt.a(parambaqw, "ptv_template_new.cfg");
          if (QLog.isColorLevel()) {
            QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip null == infos || infos.isEmpty()");
          }
          ajnh.a(-4);
          return;
          localUnsatisfiedLinkError = localUnsatisfiedLinkError;
          parambaqw = (baqw)localObject;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localUnsatisfiedLinkError.printStackTrace();
          parambaqw = (baqw)localObject;
        }
        catch (Exception parambaqw)
        {
          ajnh.a(-3);
          bdiv.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 0);
          if (!QLog.isColorLevel()) {
            continue;
          }
          parambaqw.printStackTrace();
          continue;
        }
        ajnh.a(-2);
      }
      axjt.a(parambaqw, "ptv_template_new.cfg");
      this.jdField_a_of_type_Axjt.c(false);
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip finsh configContent=" + parambaqw);
      }
      ajnh.a(1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(new Intent("action_brocassreceiver_for_ptv"));
      return;
    }
    label330:
    if (QLog.isColorLevel()) {
      QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip !jsonFile.exists()");
    }
    bdiv.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 0);
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axju
 * JD-Core Version:    0.7.0.1
 */