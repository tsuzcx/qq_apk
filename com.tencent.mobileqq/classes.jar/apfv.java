import android.text.TextUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class apfv
  extends aqgp
{
  public String a(aqgt paramaqgt)
  {
    paramaqgt = ((apga)paramaqgt.a).jdField_d_of_type_JavaLangString;
    if (AudioHelper.f()) {
      QLog.w(apgj.a, 1, "getUnzipDirPath, path[" + paramaqgt + "]");
    }
    return paramaqgt;
  }
  
  public boolean a(aqgt paramaqgt)
  {
    apga localapga = (apga)paramaqgt.a;
    localapga.jdField_d_of_type_Int = 0;
    boolean bool1 = super.a(paramaqgt);
    String str1 = "ARPromotionRDHandler, needDownload[" + bool1 + "], zipItem[" + localapga;
    String str4;
    File localFile;
    boolean bool2;
    String str3;
    if (bool1)
    {
      str4 = azuz.a("20180426_803_worldcupXXX", localapga.b);
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
        str1 = bleb.a(localFile);
        str3 = str3 + "], preMd5[" + str1;
        if (TextUtils.equals(localapga.b, str1))
        {
          str1 = str3 + anzj.a(2131699646);
          bool2 = bhmi.d(str4, b(paramaqgt));
          bool1 = super.a(paramaqgt);
          paramaqgt = str1 + ", copyFile[" + bool2 + "], reCheck[" + bool1 + "]";
          if (!bool1) {
            localapga.jdField_d_of_type_Int = 1;
          }
          QLog.w(apgj.a, 1, paramaqgt);
          return bool1;
        }
      }
      catch (Exception localException)
      {
        str2 = "Exception";
        continue;
        paramaqgt = str3 + anzj.a(2131699645);
        continue;
      }
      paramaqgt = str3;
      continue;
      paramaqgt = str2;
    }
  }
  
  public boolean a(aqgt paramaqgt, boolean paramBoolean)
  {
    return false;
  }
  
  public String b(aqgt paramaqgt)
  {
    paramaqgt = ((apga)paramaqgt.a).c;
    if (AudioHelper.f()) {
      QLog.w(apgj.a, 1, "getDownloadPath, path[" + paramaqgt + "]");
    }
    return paramaqgt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apfv
 * JD-Core Version:    0.7.0.1
 */