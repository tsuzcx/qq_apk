import android.text.TextUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class amoz
  extends anol
{
  public String a(anop paramanop)
  {
    paramanop = ((ampe)paramanop.a).jdField_d_of_type_JavaLangString;
    if (AudioHelper.e()) {
      QLog.w(ampn.a, 1, "getUnzipDirPath, path[" + paramanop + "]");
    }
    return paramanop;
  }
  
  public boolean a(anop paramanop)
  {
    ampe localampe = (ampe)paramanop.a;
    localampe.jdField_d_of_type_Int = 0;
    boolean bool1 = super.a(paramanop);
    String str1 = "ARPromotionRDHandler, needDownload[" + bool1 + "], zipItem[" + localampe;
    String str4;
    File localFile;
    boolean bool2;
    String str3;
    if (bool1)
    {
      str4 = awjn.a("20180426_803_worldcupXXX", localampe.b);
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
        str1 = bhli.a(localFile);
        str3 = str3 + "], preMd5[" + str1;
        if (TextUtils.equals(localampe.b, str1))
        {
          str1 = str3 + alpo.a(2131701102);
          bool2 = bdcs.d(str4, b(paramanop));
          bool1 = super.a(paramanop);
          paramanop = str1 + ", copyFile[" + bool2 + "], reCheck[" + bool1 + "]";
          if (!bool1) {
            localampe.jdField_d_of_type_Int = 1;
          }
          QLog.w(ampn.a, 1, paramanop);
          return bool1;
        }
      }
      catch (Exception localException)
      {
        str2 = "Exception";
        continue;
        paramanop = str3 + alpo.a(2131701101);
        continue;
      }
      paramanop = str3;
      continue;
      paramanop = str2;
    }
  }
  
  public boolean a(anop paramanop, boolean paramBoolean)
  {
    return false;
  }
  
  public String b(anop paramanop)
  {
    paramanop = ((ampe)paramanop.a).c;
    if (AudioHelper.e()) {
      QLog.w(ampn.a, 1, "getDownloadPath, path[" + paramanop + "]");
    }
    return paramanop;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amoz
 * JD-Core Version:    0.7.0.1
 */