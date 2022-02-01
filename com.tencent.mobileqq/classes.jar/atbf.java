import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class atbf
  extends aszq
{
  atbf(atbe paramatbe, atbj paramatbj, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, Bundle paramBundle)
  {
    super.a(paramBoolean, paramLong, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Atbe.jdField_a_of_type_JavaLangString + " start DiscUploadTaskExcuter isSuccess:" + paramBoolean + " retCode:" + paramLong + " retMsg:" + paramString6);
    }
    if (!paramBoolean)
    {
      if ((paramLong == -100001L) || (paramLong == -100002L))
      {
        this.jdField_a_of_type_Atbj.a(atan.a(this.jdField_a_of_type_Atbe.jdField_a_of_type_Long, false), true);
        return;
      }
      this.jdField_a_of_type_Atbj.a(atan.a(this.jdField_a_of_type_Atbe.jdField_a_of_type_Long, false), false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Atbe.jdField_a_of_type_JavaLangString + " start upload Discfile");
    }
    paramBoolean = atgz.e(atan.a(this.jdField_a_of_type_Atbe.jdField_a_of_type_Atan));
    paramString2 = "";
    int i = 0;
    paramString5 = "";
    if (paramBundle != null)
    {
      paramString2 = paramBundle.getString("strHttpsDomain");
      i = paramBundle.getShort("httpsPort");
      paramString5 = paramBundle.getString("strHttpsDomain");
    }
    paramString1 = new aszs(atan.a(this.jdField_a_of_type_Atbe.jdField_a_of_type_Atan), paramString3, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Atbe.jdField_a_of_type_Long, paramString4, paramInt, paramBoolean, paramString2, i, this.jdField_a_of_type_Atbe.b, paramString5, new atbg(this, paramString1));
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Atbe.jdField_a_of_type_JavaLangString + " add to rsCenter");
    }
    atbe.a(this.jdField_a_of_type_Atbe, atvo.a().longValue());
    atan.a(this.jdField_a_of_type_Atbe.jdField_a_of_type_Atan).a().a(atbe.a(this.jdField_a_of_type_Atbe), paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbf
 * JD-Core Version:    0.7.0.1
 */