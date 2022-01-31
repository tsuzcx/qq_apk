import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class bjjf
  implements aysc
{
  bjjf(bjje parambjje, String paramString1, String paramString2, bjjh parambjjh, String paramString3, String paramString4, bjjg parambjjg) {}
  
  public void onResp(aysz paramaysz)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfigSimplifier_PTV", 2, "onResp resultcode: " + paramaysz.c + " threadid=" + Thread.currentThread().getId());
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
        paramaysz = "";
        try
        {
          String str = bbdx.c(localFile.getPath());
          paramaysz = str;
          if ((TextUtils.isEmpty(this.jdField_a_of_type_Bjjh.c)) || (!this.jdField_a_of_type_Bjjh.c.equalsIgnoreCase(paramaysz))) {}
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            try
            {
              nav.a(localFile, this.c);
              paramaysz = new File(this.d);
              if (!paramaysz.exists()) {
                break label249;
              }
              paramaysz = bkzp.a(paramaysz);
              if ((this.jdField_a_of_type_Bjjg == null) || (paramaysz == null)) {
                break;
              }
              this.jdField_a_of_type_Bjjg.a(paramaysz);
              return;
              localUnsatisfiedLinkError = localUnsatisfiedLinkError;
              QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", localUnsatisfiedLinkError);
            }
            catch (IOException paramaysz)
            {
              QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", paramaysz);
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.e("ConfigSimplifier_PTV", 2, new Object[] { "parseFilterConfigZip error, md5:", this.jdField_a_of_type_Bjjh.c, " ", paramaysz });
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip !jsonFile.exists()");
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjjf
 * JD-Core Version:    0.7.0.1
 */