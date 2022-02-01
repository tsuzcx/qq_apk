import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class bosg
  implements bdvw
{
  bosg(bosf parambosf, String paramString1, String paramString2, bosi parambosi, String paramString3, String paramString4, bosh parambosh) {}
  
  public void onResp(bdwt parambdwt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfigSimplifier_PTV", 2, "onResp resultcode: " + parambdwt.c + " threadid=" + Thread.currentThread().getId());
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
        parambdwt = "";
        try
        {
          String str = bgmg.c(localFile.getPath());
          parambdwt = str;
          if ((TextUtils.isEmpty(this.jdField_a_of_type_Bosi.c)) || (!this.jdField_a_of_type_Bosi.c.equalsIgnoreCase(parambdwt))) {}
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            try
            {
              nmk.a(localFile, this.c);
              parambdwt = new File(this.d);
              if (!parambdwt.exists()) {
                break label249;
              }
              parambdwt = bqgc.a(parambdwt);
              if ((this.jdField_a_of_type_Bosh == null) || (parambdwt == null)) {
                break;
              }
              this.jdField_a_of_type_Bosh.a(parambdwt);
              return;
              localUnsatisfiedLinkError = localUnsatisfiedLinkError;
              QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", localUnsatisfiedLinkError);
            }
            catch (IOException parambdwt)
            {
              QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", parambdwt);
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.e("ConfigSimplifier_PTV", 2, new Object[] { "parseFilterConfigZip error, md5:", this.jdField_a_of_type_Bosi.c, " ", parambdwt });
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip !jsonFile.exists()");
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bosg
 * JD-Core Version:    0.7.0.1
 */