import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class bpub
  implements beuq
{
  bpub(bpua parambpua, String paramString1, String paramString2, bpud parambpud, String paramString3, String paramString4, bpuc parambpuc) {}
  
  public void onResp(bevm parambevm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfigSimplifier_PTV", 2, "onResp resultcode: " + parambevm.c + " threadid=" + Thread.currentThread().getId());
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
        parambevm = "";
        try
        {
          String str = bhmi.c(localFile.getPath());
          parambevm = str;
          if ((TextUtils.isEmpty(this.jdField_a_of_type_Bpud.c)) || (!this.jdField_a_of_type_Bpud.c.equalsIgnoreCase(parambevm))) {}
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            try
            {
              nof.a(localFile, this.c);
              parambevm = new File(this.d);
              if (!parambevm.exists()) {
                break label249;
              }
              parambevm = brhn.a(parambevm);
              if ((this.jdField_a_of_type_Bpuc == null) || (parambevm == null)) {
                break;
              }
              this.jdField_a_of_type_Bpuc.a(parambevm);
              return;
              localUnsatisfiedLinkError = localUnsatisfiedLinkError;
              QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", localUnsatisfiedLinkError);
            }
            catch (IOException parambevm)
            {
              QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", parambevm);
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.e("ConfigSimplifier_PTV", 2, new Object[] { "parseFilterConfigZip error, md5:", this.jdField_a_of_type_Bpud.c, " ", parambevm });
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip !jsonFile.exists()");
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpub
 * JD-Core Version:    0.7.0.1
 */