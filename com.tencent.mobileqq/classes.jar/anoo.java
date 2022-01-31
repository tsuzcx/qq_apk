import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.util.ConfigSimplifier;
import dov.com.qq.im.capture.util.ConfigSimplifier.ConfigDownloadCallback;
import dov.com.qq.im.capture.util.ConfigSimplifier.ZipConfig;
import dov.com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import java.io.File;
import java.io.IOException;

public class anoo
  implements INetEngine.INetEngineListener
{
  public anoo(ConfigSimplifier paramConfigSimplifier, String paramString1, String paramString2, ConfigSimplifier.ZipConfig paramZipConfig, String paramString3, String paramString4, ConfigSimplifier.ConfigDownloadCallback paramConfigDownloadCallback) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfigSimplifier_PTV", 2, "onResp resultcode: " + paramNetResp.c + " threadid=" + Thread.currentThread().getId());
    }
    File localFile = new File(this.jdField_a_of_type_JavaLangString, this.b);
    if (!localFile.exists()) {
      if (QLog.isColorLevel()) {
        QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip !zipfile.exists()");
      }
    }
    do
    {
      return;
      String str = "";
      try
      {
        paramNetResp = FileUtils.b(localFile.getPath());
        if ((TextUtils.isEmpty(this.jdField_a_of_type_DovComQqImCaptureUtilConfigSimplifier$ZipConfig.c)) || (!this.jdField_a_of_type_DovComQqImCaptureUtilConfigSimplifier$ZipConfig.c.equalsIgnoreCase(paramNetResp))) {}
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        try
        {
          do
          {
            ZipUtils.a(localFile, this.c);
            paramNetResp = new File(this.d);
            if (!paramNetResp.exists()) {
              break;
            }
            paramNetResp = CapturePtvTemplateManager.a(paramNetResp);
            this.jdField_a_of_type_DovComQqImCaptureUtilConfigSimplifier$ConfigDownloadCallback.a(paramNetResp);
            return;
            localUnsatisfiedLinkError = localUnsatisfiedLinkError;
            paramNetResp = str;
          } while (!QLog.isColorLevel());
          localUnsatisfiedLinkError.printStackTrace();
          paramNetResp = str;
        }
        catch (IOException paramNetResp)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              paramNetResp.printStackTrace();
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip !jsonFile.exists()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anoo
 * JD-Core Version:    0.7.0.1
 */