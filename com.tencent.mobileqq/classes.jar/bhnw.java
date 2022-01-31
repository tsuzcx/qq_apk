import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class bhnw
  implements axrt
{
  bhnw(bhnv parambhnv, String paramString1, String paramString2, bhny parambhny, String paramString3, String paramString4, bhnx parambhnx) {}
  
  public void onResp(axsq paramaxsq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfigSimplifier_PTV", 2, "onResp resultcode: " + paramaxsq.c + " threadid=" + Thread.currentThread().getId());
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
        paramaxsq = "";
        try
        {
          String str = bace.c(localFile.getPath());
          paramaxsq = str;
          if ((TextUtils.isEmpty(this.jdField_a_of_type_Bhny.c)) || (!this.jdField_a_of_type_Bhny.c.equalsIgnoreCase(paramaxsq))) {}
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            try
            {
              mpx.a(localFile, this.c);
              paramaxsq = new File(this.d);
              if (!paramaxsq.exists()) {
                break label249;
              }
              paramaxsq = bjin.a(paramaxsq);
              if ((this.jdField_a_of_type_Bhnx == null) || (paramaxsq == null)) {
                break;
              }
              this.jdField_a_of_type_Bhnx.a(paramaxsq);
              return;
              localUnsatisfiedLinkError = localUnsatisfiedLinkError;
              QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", localUnsatisfiedLinkError);
            }
            catch (IOException paramaxsq)
            {
              QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", paramaxsq);
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.e("ConfigSimplifier_PTV", 2, new Object[] { "parseFilterConfigZip error, md5:", this.jdField_a_of_type_Bhny.c, " ", paramaxsq });
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip !jsonFile.exists()");
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhnw
 * JD-Core Version:    0.7.0.1
 */