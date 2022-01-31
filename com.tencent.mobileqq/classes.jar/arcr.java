import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

class arcr
  implements aysa
{
  arcr(arco paramarco, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void onResp(aysx paramaysx)
  {
    int i = 1;
    if (paramaysx.jdField_a_of_type_Int == 3)
    {
      QLog.d("qqidentification_server", 2, "identification res download repeating ");
      return;
    }
    boolean bool;
    if (paramaysx.jdField_a_of_type_Int == 0)
    {
      paramaysx = paramaysx.jdField_a_of_type_Aysw.c;
      String str1 = bbdj.c(paramaysx);
      String str2 = this.jdField_a_of_type_JavaLangString;
      if ((str1 != null) && (str1.equalsIgnoreCase(this.b)))
      {
        try
        {
          bbdj.a(paramaysx, str2, false);
          bool = true;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            label72:
            QLog.d("qqidentification_server", 1, "downloadRes.onResp download succ but unzip is failed");
            bool = false;
          }
        }
        bbdj.d(paramaysx);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqidentification_server", 1, "downloadRes.onResp download path : " + this.jdField_a_of_type_JavaLangString);
      }
      if (bool)
      {
        QLog.d("qqidentification_server", 1, "no res,download success");
        bbjn.c(this.jdField_a_of_type_JavaLangString);
        bbjn.b(this.jdField_a_of_type_Int);
        bbjn.c(arcm.b());
      }
      paramaysx = new EIPCResult();
      if (bool) {
        i = 0;
      }
      paramaysx.code = i;
      this.jdField_a_of_type_Arco.callbackResult(arco.b(this.jdField_a_of_type_Arco), paramaysx);
      arco.a(this.jdField_a_of_type_Arco).set(false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("qqidentification_server", 2, "downloadRes.onResp download result = " + bool);
      return;
      QLog.d("qqidentification_server", 1, "downloadRes.onResp download succ but md5 is mismatched ");
      if (QLog.isColorLevel()) {
        QLog.d("qqidentification_server", 2, "downloadRes.onResp download succ but md5 is mismatched,fileSize = " + bbdj.a(paramaysx) + ",md5 = " + localIOException + ",url = " + this.c);
      }
      bool = false;
      break label72;
      QLog.d("qqidentification_server", 1, "downloadRes.onResp failed  isSuccess is false");
      bool = false;
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arcr
 * JD-Core Version:    0.7.0.1
 */