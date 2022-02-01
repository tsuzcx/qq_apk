import android.text.TextUtils;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class bmxh
  implements INetEngine.INetEngineListener
{
  bmxh(bmxg parambmxg, String paramString1, String paramString2, bmxj parambmxj, String paramString3, String paramString4, bmxi parambmxi) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfigSimplifier_PTV", 2, "onResp resultcode: " + paramNetResp.mHttpCode + " threadid=" + Thread.currentThread().getId());
    }
    File localFile = new File(this.jdField_a_of_type_JavaLangString, this.b);
    if (!localFile.exists()) {
      if (QLog.isColorLevel()) {
        QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip !zipfile.exists()");
      }
    }
    label249:
    do
    {
      for (;;)
      {
        return;
        paramNetResp = "";
        try
        {
          String str = FileUtils.calcMd5(localFile.getPath());
          paramNetResp = str;
          if ((TextUtils.isEmpty(this.jdField_a_of_type_Bmxj.c)) || (!this.jdField_a_of_type_Bmxj.c.equalsIgnoreCase(paramNetResp))) {}
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            try
            {
              npo.a(localFile, this.c);
              paramNetResp = new File(this.d);
              if (!paramNetResp.exists()) {
                break label249;
              }
              paramNetResp = boba.a(paramNetResp);
              if ((this.jdField_a_of_type_Bmxi == null) || (paramNetResp == null)) {
                break;
              }
              this.jdField_a_of_type_Bmxi.a(paramNetResp);
              return;
              localUnsatisfiedLinkError = localUnsatisfiedLinkError;
              QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", localUnsatisfiedLinkError);
            }
            catch (IOException paramNetResp)
            {
              QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", paramNetResp);
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.e("ConfigSimplifier_PTV", 2, new Object[] { "parseFilterConfigZip error, md5:", this.jdField_a_of_type_Bmxj.c, " ", paramNetResp });
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip !jsonFile.exists()");
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxh
 * JD-Core Version:    0.7.0.1
 */