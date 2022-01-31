import android.text.TextUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class amto
  extends ansu
{
  public String a(ansy paramansy)
  {
    paramansy = ((amtt)paramansy.a).jdField_d_of_type_JavaLangString;
    if (AudioHelper.e()) {
      QLog.w(amuc.a, 1, "getUnzipDirPath, path[" + paramansy + "]");
    }
    return paramansy;
  }
  
  public boolean a(ansy paramansy)
  {
    amtt localamtt = (amtt)paramansy.a;
    localamtt.jdField_d_of_type_Int = 0;
    boolean bool1 = super.a(paramansy);
    String str1 = "ARPromotionRDHandler, needDownload[" + bool1 + "], zipItem[" + localamtt;
    String str4;
    File localFile;
    boolean bool2;
    String str3;
    if (bool1)
    {
      str4 = awnw.a("20180426_803_worldcupXXX", localamtt.b);
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
        str1 = bhpp.a(localFile);
        str3 = str3 + "], preMd5[" + str1;
        if (TextUtils.equals(localamtt.b, str1))
        {
          str1 = str3 + alud.a(2131701114);
          bool2 = bdhb.d(str4, b(paramansy));
          bool1 = super.a(paramansy);
          paramansy = str1 + ", copyFile[" + bool2 + "], reCheck[" + bool1 + "]";
          if (!bool1) {
            localamtt.jdField_d_of_type_Int = 1;
          }
          QLog.w(amuc.a, 1, paramansy);
          return bool1;
        }
      }
      catch (Exception localException)
      {
        str2 = "Exception";
        continue;
        paramansy = str3 + alud.a(2131701113);
        continue;
      }
      paramansy = str3;
      continue;
      paramansy = str2;
    }
  }
  
  public boolean a(ansy paramansy, boolean paramBoolean)
  {
    return false;
  }
  
  public String b(ansy paramansy)
  {
    paramansy = ((amtt)paramansy.a).c;
    if (AudioHelper.e()) {
      QLog.w(amuc.a, 1, "getDownloadPath, path[" + paramansy + "]");
    }
    return paramansy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amto
 * JD-Core Version:    0.7.0.1
 */