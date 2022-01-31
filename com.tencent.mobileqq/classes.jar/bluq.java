import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class bluq
  implements bapx
{
  bluq(blup paramblup, String paramString1, String paramString2, blus paramblus, String paramString3, String paramString4, blur paramblur) {}
  
  public void onResp(baqw parambaqw)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfigSimplifier_PTV", 2, "onResp resultcode: " + parambaqw.c + " threadid=" + Thread.currentThread().getId());
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
        parambaqw = "";
        try
        {
          String str = bdcs.c(localFile.getPath());
          parambaqw = str;
          if ((TextUtils.isEmpty(this.jdField_a_of_type_Blus.c)) || (!this.jdField_a_of_type_Blus.c.equalsIgnoreCase(parambaqw))) {}
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            try
            {
              ndr.a(localFile, this.c);
              parambaqw = new File(this.d);
              if (!parambaqw.exists()) {
                break label249;
              }
              parambaqw = bnkz.a(parambaqw);
              if ((this.jdField_a_of_type_Blur == null) || (parambaqw == null)) {
                break;
              }
              this.jdField_a_of_type_Blur.a(parambaqw);
              return;
              localUnsatisfiedLinkError = localUnsatisfiedLinkError;
              QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", localUnsatisfiedLinkError);
            }
            catch (IOException parambaqw)
            {
              QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", parambaqw);
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.e("ConfigSimplifier_PTV", 2, new Object[] { "parseFilterConfigZip error, md5:", this.jdField_a_of_type_Blus.c, " ", parambaqw });
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip !jsonFile.exists()");
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bluq
 * JD-Core Version:    0.7.0.1
 */