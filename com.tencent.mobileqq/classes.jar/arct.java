import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

class arct
  implements aysc
{
  arct(arcq paramarcq, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void onResp(aysz paramaysz)
  {
    int i = 1;
    if (paramaysz.jdField_a_of_type_Int == 3)
    {
      QLog.d("qqidentification_server", 2, "identification res download repeating ");
      return;
    }
    boolean bool;
    if (paramaysz.jdField_a_of_type_Int == 0)
    {
      paramaysz = paramaysz.jdField_a_of_type_Aysy.c;
      String str1 = bbdx.c(paramaysz);
      String str2 = this.jdField_a_of_type_JavaLangString;
      if ((str1 != null) && (str1.equalsIgnoreCase(this.b)))
      {
        try
        {
          bbdx.a(paramaysz, str2, false);
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
        bbdx.d(paramaysz);
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
        bbkb.c(this.jdField_a_of_type_JavaLangString);
        bbkb.b(this.jdField_a_of_type_Int);
        bbkb.c(arco.b());
      }
      paramaysz = new EIPCResult();
      if (bool) {
        i = 0;
      }
      paramaysz.code = i;
      this.jdField_a_of_type_Arcq.callbackResult(arcq.b(this.jdField_a_of_type_Arcq), paramaysz);
      arcq.a(this.jdField_a_of_type_Arcq).set(false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("qqidentification_server", 2, "downloadRes.onResp download result = " + bool);
      return;
      QLog.d("qqidentification_server", 1, "downloadRes.onResp download succ but md5 is mismatched ");
      if (QLog.isColorLevel()) {
        QLog.d("qqidentification_server", 2, "downloadRes.onResp download succ but md5 is mismatched,fileSize = " + bbdx.a(paramaysz) + ",md5 = " + localIOException + ",url = " + this.c);
      }
      bool = false;
      break label72;
      QLog.d("qqidentification_server", 1, "downloadRes.onResp failed  isSuccess is false");
      bool = false;
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arct
 * JD-Core Version:    0.7.0.1
 */