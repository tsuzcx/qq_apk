import android.text.TextUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aosf
  extends apsz
{
  public String a(aptd paramaptd)
  {
    paramaptd = ((aosk)paramaptd.a).jdField_d_of_type_JavaLangString;
    if (AudioHelper.f()) {
      QLog.w(aost.a, 1, "getUnzipDirPath, path[" + paramaptd + "]");
    }
    return paramaptd;
  }
  
  public boolean a(aptd paramaptd)
  {
    aosk localaosk = (aosk)paramaptd.a;
    localaosk.jdField_d_of_type_Int = 0;
    boolean bool1 = super.a(paramaptd);
    String str1 = "ARPromotionRDHandler, needDownload[" + bool1 + "], zipItem[" + localaosk;
    String str4;
    File localFile;
    boolean bool2;
    String str3;
    if (bool1)
    {
      str4 = azcm.a("20180426_803_worldcupXXX", localaosk.b);
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
        str1 = bkcx.a(localFile);
        str3 = str3 + "], preMd5[" + str1;
        if (TextUtils.equals(localaosk.b, str1))
        {
          str1 = str3 + anni.a(2131699539);
          bool2 = bgmg.d(str4, b(paramaptd));
          bool1 = super.a(paramaptd);
          paramaptd = str1 + ", copyFile[" + bool2 + "], reCheck[" + bool1 + "]";
          if (!bool1) {
            localaosk.jdField_d_of_type_Int = 1;
          }
          QLog.w(aost.a, 1, paramaptd);
          return bool1;
        }
      }
      catch (Exception localException)
      {
        str2 = "Exception";
        continue;
        paramaptd = str3 + anni.a(2131699538);
        continue;
      }
      paramaptd = str3;
      continue;
      paramaptd = str2;
    }
  }
  
  public boolean a(aptd paramaptd, boolean paramBoolean)
  {
    return false;
  }
  
  public String b(aptd paramaptd)
  {
    paramaptd = ((aosk)paramaptd.a).c;
    if (AudioHelper.f()) {
      QLog.w(aost.a, 1, "getDownloadPath, path[" + paramaptd + "]");
    }
    return paramaptd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aosf
 * JD-Core Version:    0.7.0.1
 */