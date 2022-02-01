import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

class avxi
  implements beuq
{
  avxi(avxe paramavxe, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void onResp(bevm parambevm)
  {
    if (parambevm.jdField_a_of_type_Int == 3)
    {
      QLog.d("qqidentification_server", 2, "identification res download repeating ");
      return;
    }
    if (parambevm.jdField_a_of_type_Int == 0)
    {
      parambevm = parambevm.jdField_a_of_type_Bevl.c;
      String str = bhmi.c(parambevm);
      if ((str == null) || (!str.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))) {}
    }
    for (;;)
    {
      try
      {
        bhmi.a(parambevm, this.b, false);
        QLog.d("qqidentification_server", 1, "downloadRes.onResp download succ but unzip is failed");
      }
      catch (IOException localIOException1)
      {
        try
        {
          avxe.a(this.jdField_a_of_type_Avxe).a();
          avxe.a(this.jdField_a_of_type_Avxe, null);
          bool = true;
          bhmi.d(parambevm);
          if (QLog.isColorLevel()) {
            QLog.d("qqidentification_server", 2, "downloadRes.onResp download path : " + this.b);
          }
          QLog.d("qqidentification_server", 1, new Object[] { "download face res success : ", Boolean.valueOf(bool) });
          if (bool)
          {
            bhsi.c(this.b);
            bhsi.b(this.jdField_a_of_type_Int);
            bhsi.c(avxc.b());
          }
          avxe.a(this.jdField_a_of_type_Avxe, 1, bool);
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
        QLog.d("qqidentification_server", 2, "downloadRes.onResp download succ but md5 is mismatched,fileSize = " + bhmi.a(parambevm) + ",md5 = " + localIOException1 + ",url = " + this.c);
      }
      bool = false;
      continue;
      QLog.d("qqidentification_server", 1, new Object[] { "downloadRes.onResp failed  isSuccess is false, code is : ", Integer.valueOf(parambevm.b), " msg : ", parambevm.jdField_a_of_type_JavaLangString });
      bool = false;
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avxi
 * JD-Core Version:    0.7.0.1
 */