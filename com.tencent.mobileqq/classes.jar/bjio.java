import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class bjio
  implements aysa
{
  bjio(bjin parambjin, String paramString1, String paramString2, bjiq parambjiq, String paramString3, String paramString4, bjip parambjip) {}
  
  public void onResp(aysx paramaysx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfigSimplifier_PTV", 2, "onResp resultcode: " + paramaysx.c + " threadid=" + Thread.currentThread().getId());
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
        paramaysx = "";
        try
        {
          String str = bbdj.c(localFile.getPath());
          paramaysx = str;
          if ((TextUtils.isEmpty(this.jdField_a_of_type_Bjiq.c)) || (!this.jdField_a_of_type_Bjiq.c.equalsIgnoreCase(paramaysx))) {}
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            try
            {
              nay.a(localFile, this.c);
              paramaysx = new File(this.d);
              if (!paramaysx.exists()) {
                break label249;
              }
              paramaysx = bkyy.a(paramaysx);
              if ((this.jdField_a_of_type_Bjip == null) || (paramaysx == null)) {
                break;
              }
              this.jdField_a_of_type_Bjip.a(paramaysx);
              return;
              localUnsatisfiedLinkError = localUnsatisfiedLinkError;
              QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", localUnsatisfiedLinkError);
            }
            catch (IOException paramaysx)
            {
              QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", paramaysx);
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.e("ConfigSimplifier_PTV", 2, new Object[] { "parseFilterConfigZip error, md5:", this.jdField_a_of_type_Bjiq.c, " ", paramaysx });
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip !jsonFile.exists()");
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjio
 * JD-Core Version:    0.7.0.1
 */