import android.text.TextUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class anzh
  extends apaa
{
  public String a(apae paramapae)
  {
    paramapae = ((anzm)paramapae.a).jdField_d_of_type_JavaLangString;
    if (AudioHelper.f()) {
      QLog.w(anzv.a, 1, "getUnzipDirPath, path[" + paramapae + "]");
    }
    return paramapae;
  }
  
  public boolean a(apae paramapae)
  {
    anzm localanzm = (anzm)paramapae.a;
    localanzm.jdField_d_of_type_Int = 0;
    boolean bool1 = super.a(paramapae);
    String str1 = "ARPromotionRDHandler, needDownload[" + bool1 + "], zipItem[" + localanzm;
    String str4;
    File localFile;
    boolean bool2;
    String str3;
    if (bool1)
    {
      str4 = ayjo.a("20180426_803_worldcupXXX", localanzm.b);
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
        str1 = bjkf.a(localFile);
        str3 = str3 + "], preMd5[" + str1;
        if (TextUtils.equals(localanzm.b, str1))
        {
          str1 = str3 + amtj.a(2131699881);
          bool2 = FileUtils.copyFile(str4, b(paramapae));
          bool1 = super.a(paramapae);
          paramapae = str1 + ", copyFile[" + bool2 + "], reCheck[" + bool1 + "]";
          if (!bool1) {
            localanzm.jdField_d_of_type_Int = 1;
          }
          QLog.w(anzv.a, 1, paramapae);
          return bool1;
        }
      }
      catch (Exception localException)
      {
        str2 = "Exception";
        continue;
        paramapae = str3 + amtj.a(2131699880);
        continue;
      }
      paramapae = str3;
      continue;
      paramapae = str2;
    }
  }
  
  public boolean a(apae paramapae, boolean paramBoolean)
  {
    return false;
  }
  
  public String b(apae paramapae)
  {
    paramapae = ((anzm)paramapae.a).c;
    if (AudioHelper.f()) {
      QLog.w(anzv.a, 1, "getDownloadPath, path[" + paramapae + "]");
    }
    return paramapae;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anzh
 * JD-Core Version:    0.7.0.1
 */