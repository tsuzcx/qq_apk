import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

class avff
  implements bdvw
{
  avff(avfb paramavfb, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void onResp(bdwt parambdwt)
  {
    if (parambdwt.jdField_a_of_type_Int == 3)
    {
      QLog.d("qqidentification_server", 2, "identification res download repeating ");
      return;
    }
    if (parambdwt.jdField_a_of_type_Int == 0)
    {
      parambdwt = parambdwt.jdField_a_of_type_Bdws.c;
      String str = bgmg.c(parambdwt);
      if ((str == null) || (!str.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))) {}
    }
    for (;;)
    {
      try
      {
        bgmg.a(parambdwt, this.b, false);
        QLog.d("qqidentification_server", 1, "downloadRes.onResp download succ but unzip is failed");
      }
      catch (IOException localIOException1)
      {
        try
        {
          avfb.a(this.jdField_a_of_type_Avfb).a();
          avfb.a(this.jdField_a_of_type_Avfb, null);
          bool = true;
          bgmg.d(parambdwt);
          if (QLog.isColorLevel()) {
            QLog.d("qqidentification_server", 2, "downloadRes.onResp download path : " + this.b);
          }
          QLog.d("qqidentification_server", 1, new Object[] { "download face res success : ", Boolean.valueOf(bool) });
          if (bool)
          {
            bgsg.c(this.b);
            bgsg.b(this.jdField_a_of_type_Int);
            bgsg.c(avez.b());
          }
          avfb.a(this.jdField_a_of_type_Avfb, 1, bool);
          return;
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            boolean bool = true;
          }
        }
        localIOException1 = localIOException1;
        bool = false;
      }
      continue;
      QLog.d("qqidentification_server", 1, "downloadRes.onResp download succ but md5 is mismatched ");
      if (QLog.isColorLevel()) {
        QLog.d("qqidentification_server", 2, "downloadRes.onResp download succ but md5 is mismatched,fileSize = " + bgmg.a(parambdwt) + ",md5 = " + localIOException1 + ",url = " + this.c);
      }
      bool = false;
      continue;
      QLog.d("qqidentification_server", 1, "downloadRes.onResp failed  isSuccess is false");
      bool = false;
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avff
 * JD-Core Version:    0.7.0.1
 */