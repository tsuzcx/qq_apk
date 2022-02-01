import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class atjq
  extends atib
{
  atjq(atjp paramatjp, atju paramatju, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, Bundle paramBundle)
  {
    super.a(paramBoolean, paramLong, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Atjp.jdField_a_of_type_JavaLangString + " start DiscUploadTaskExcuter isSuccess:" + paramBoolean + " retCode:" + paramLong + " retMsg:" + paramString6);
    }
    if (!paramBoolean)
    {
      if ((paramLong == -100001L) || (paramLong == -100002L))
      {
        this.jdField_a_of_type_Atju.a(atiy.a(this.jdField_a_of_type_Atjp.jdField_a_of_type_Long, false), true);
        return;
      }
      this.jdField_a_of_type_Atju.a(atiy.a(this.jdField_a_of_type_Atjp.jdField_a_of_type_Long, false), false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Atjp.jdField_a_of_type_JavaLangString + " start upload Discfile");
    }
    paramBoolean = atpj.e(atiy.a(this.jdField_a_of_type_Atjp.jdField_a_of_type_Atiy));
    paramString2 = "";
    int i = 0;
    paramString5 = "";
    if (paramBundle != null)
    {
      paramString2 = paramBundle.getString("strHttpsDomain");
      i = paramBundle.getShort("httpsPort");
      paramString5 = paramBundle.getString("strHttpsDomain");
    }
    paramString1 = new atid(atiy.a(this.jdField_a_of_type_Atjp.jdField_a_of_type_Atiy), paramString3, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Atjp.jdField_a_of_type_Long, paramString4, paramInt, paramBoolean, paramString2, i, this.jdField_a_of_type_Atjp.b, paramString5, new atjr(this, paramString1));
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Atjp.jdField_a_of_type_JavaLangString + " add to rsCenter");
    }
    atjp.a(this.jdField_a_of_type_Atjp, auea.a().longValue());
    atiy.a(this.jdField_a_of_type_Atjp.jdField_a_of_type_Atiy).getFileManagerRSCenter().a(atjp.a(this.jdField_a_of_type_Atjp), paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atjq
 * JD-Core Version:    0.7.0.1
 */