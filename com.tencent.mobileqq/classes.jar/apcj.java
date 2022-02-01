import android.text.TextUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class apcj
  extends aqde
{
  public String a(aqdi paramaqdi)
  {
    paramaqdi = ((apco)paramaqdi.a).jdField_d_of_type_JavaLangString;
    if (AudioHelper.f()) {
      QLog.w(apcx.a, 1, "getUnzipDirPath, path[" + paramaqdi + "]");
    }
    return paramaqdi;
  }
  
  public boolean a(aqdi paramaqdi)
  {
    apco localapco = (apco)paramaqdi.a;
    localapco.jdField_d_of_type_Int = 0;
    boolean bool1 = super.a(paramaqdi);
    String str1 = "ARPromotionRDHandler, needDownload[" + bool1 + "], zipItem[" + localapco;
    String str4;
    File localFile;
    boolean bool2;
    String str3;
    if (bool1)
    {
      str4 = azoj.a("20180426_803_worldcupXXX", localapco.b);
      if (!TextUtils.isEmpty(str4))
      {
        localFile = new File(str4);
        bool2 = localFile.exists();
        str3 = str1 + "], prePath[" + str4 + "], exists[" + bool2;
        if (!bool2) {}
      }
    }
    for (;;)
    {
      String str2;
      try
      {
        str1 = bkvq.a(localFile);
        str3 = str3 + "], preMd5[" + str1;
        if (TextUtils.equals(localapco.b, str1))
        {
          str1 = str3 + anvx.a(2131700232);
          bool2 = FileUtils.copyFile(str4, b(paramaqdi));
          bool1 = super.a(paramaqdi);
          paramaqdi = str1 + ", copyFile[" + bool2 + "], reCheck[" + bool1 + "]";
          if (!bool1) {
            localapco.jdField_d_of_type_Int = 1;
          }
          QLog.w(apcx.a, 1, paramaqdi);
          return bool1;
        }
      }
      catch (Exception localException)
      {
        str2 = "Exception";
        continue;
        paramaqdi = str3 + anvx.a(2131700231);
        continue;
      }
      paramaqdi = str3;
      continue;
      paramaqdi = str2;
    }
  }
  
  public boolean a(aqdi paramaqdi, boolean paramBoolean)
  {
    return false;
  }
  
  public String b(aqdi paramaqdi)
  {
    paramaqdi = ((apco)paramaqdi.a).c;
    if (AudioHelper.f()) {
      QLog.w(apcx.a, 1, "getDownloadPath, path[" + paramaqdi + "]");
    }
    return paramaqdi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apcj
 * JD-Core Version:    0.7.0.1
 */