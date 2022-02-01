import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

class bbex
  implements beuq
{
  bbex(bbew parambbew, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, String paramString3) {}
  
  public void onResp(bevm parambevm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager_PTV", 2, "onResp resultcode: " + parambevm.c + " threadid=" + Thread.currentThread().getId());
    }
    File localFile = new File(bbew.jdField_a_of_type_JavaIoFile, "temp_ptv_template_zip");
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip !zipfile.exists()");
      }
      alwe.a(0);
      return;
    }
    Object localObject = "";
    try
    {
      parambevm = bhmi.c(localFile.getPath());
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(parambevm))) {}
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        try
        {
          nof.a(localFile, this.b);
          parambevm = new File(this.c);
          if (!parambevm.exists()) {
            break label330;
          }
          parambevm = bbew.a(parambevm);
          localObject = bbew.a(null, parambevm, this.jdField_a_of_type_Bbew.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig);
          if ((localObject != null) && (!((List)localObject).isEmpty())) {
            break;
          }
          bbew.a(parambevm, "ptv_template_new.cfg");
          if (QLog.isColorLevel()) {
            QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip null == infos || infos.isEmpty()");
          }
          alwe.a(-4);
          return;
          localUnsatisfiedLinkError = localUnsatisfiedLinkError;
          parambevm = (bevm)localObject;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localUnsatisfiedLinkError.printStackTrace();
          parambevm = (bevm)localObject;
        }
        catch (Exception parambevm)
        {
          alwe.a(-3);
          bhsi.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 0);
          if (!QLog.isColorLevel()) {
            continue;
          }
          parambevm.printStackTrace();
          continue;
        }
        alwe.a(-2);
      }
      bbew.a(parambevm, "ptv_template_new.cfg");
      this.jdField_a_of_type_Bbew.c(false);
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip finsh configContent=" + parambevm);
      }
      alwe.a(1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(new Intent("action_brocassreceiver_for_ptv"));
      return;
    }
    label330:
    if (QLog.isColorLevel()) {
      QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip !jsonFile.exists()");
    }
    bhsi.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 0);
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbex
 * JD-Core Version:    0.7.0.1
 */