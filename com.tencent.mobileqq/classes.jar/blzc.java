import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class blzc
  implements baug
{
  blzc(blzb paramblzb, String paramString1, String paramString2, blze paramblze, String paramString3, String paramString4, blzd paramblzd) {}
  
  public void onResp(bavf parambavf)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfigSimplifier_PTV", 2, "onResp resultcode: " + parambavf.c + " threadid=" + Thread.currentThread().getId());
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
        parambavf = "";
        try
        {
          String str = bdhb.c(localFile.getPath());
          parambavf = str;
          if ((TextUtils.isEmpty(this.jdField_a_of_type_Blze.c)) || (!this.jdField_a_of_type_Blze.c.equalsIgnoreCase(parambavf))) {}
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            try
            {
              ndr.a(localFile, this.c);
              parambavf = new File(this.d);
              if (!parambavf.exists()) {
                break label249;
              }
              parambavf = bnpl.a(parambavf);
              if ((this.jdField_a_of_type_Blzd == null) || (parambavf == null)) {
                break;
              }
              this.jdField_a_of_type_Blzd.a(parambavf);
              return;
              localUnsatisfiedLinkError = localUnsatisfiedLinkError;
              QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", localUnsatisfiedLinkError);
            }
            catch (IOException parambavf)
            {
              QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", parambavf);
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.e("ConfigSimplifier_PTV", 2, new Object[] { "parseFilterConfigZip error, md5:", this.jdField_a_of_type_Blze.c, " ", parambavf });
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip !jsonFile.exists()");
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzc
 * JD-Core Version:    0.7.0.1
 */