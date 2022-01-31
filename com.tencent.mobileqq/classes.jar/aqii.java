import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

class aqii
  implements axrt
{
  aqii(aqif paramaqif, String paramString1, String paramString2, String paramString3) {}
  
  public void onResp(axsq paramaxsq)
  {
    int i = 1;
    if (paramaxsq.jdField_a_of_type_Int == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqidentification_server", 2, "identification res download repeating ");
      }
      return;
    }
    boolean bool;
    if (paramaxsq.jdField_a_of_type_Int == 0)
    {
      paramaxsq = paramaxsq.jdField_a_of_type_Axsp.c;
      String str1 = bace.c(paramaxsq);
      String str2 = this.jdField_a_of_type_JavaLangString;
      if ((str1 != null) && (str1.equalsIgnoreCase(this.b)))
      {
        try
        {
          bace.a(paramaxsq, str2, false);
          bool = true;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            label78:
            QLog.d("qqidentification_server", 1, "downloadRes.onResp download succ but unzip is failed");
            bool = false;
          }
        }
        bace.d(paramaxsq);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqidentification_server", 2, "downloadRes.onResp download succ isSuccess = " + this.jdField_a_of_type_JavaLangString);
      }
      if (bool)
      {
        QLog.d("qqidentification_server", 1, "no res,download success");
        baig.c(this.jdField_a_of_type_JavaLangString);
      }
      paramaxsq = new EIPCResult();
      if (bool) {
        i = 0;
      }
      paramaxsq.code = i;
      this.jdField_a_of_type_Aqif.callbackResult(aqif.b(this.jdField_a_of_type_Aqif), paramaxsq);
      aqif.a(this.jdField_a_of_type_Aqif).set(false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("qqidentification_server", 2, "downloadRes.onResp download result = " + bool);
      return;
      QLog.d("qqidentification_server", 1, "downloadRes.onResp download succ but md5 is mismatched ");
      if (QLog.isColorLevel()) {
        QLog.d("qqidentification_server", 2, "downloadRes.onResp download succ but md5 is mismatched,fileSize = " + bace.a(paramaxsq) + ",md5 = " + localIOException + ",url = " + this.c);
      }
      bool = false;
      break label78;
      if (QLog.isColorLevel()) {
        QLog.d("qqidentification_server", 2, "downloadRes.onResp failed ");
      }
      bool = false;
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqii
 * JD-Core Version:    0.7.0.1
 */