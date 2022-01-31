import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aogr
  extends aofk
{
  aogr(aogq paramaogq, aogv paramaogv, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, Bundle paramBundle)
  {
    super.a(paramBoolean, paramLong, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aogq.jdField_a_of_type_JavaLangString + " start DiscUploadTaskExcuter isSuccess:" + paramBoolean + " retCode:" + paramLong + " retMsg:" + paramString6);
    }
    if (!paramBoolean)
    {
      if ((paramLong == -100001L) || (paramLong == -100002L))
      {
        this.jdField_a_of_type_Aogv.a(aofz.a(this.jdField_a_of_type_Aogq.jdField_a_of_type_Long, false), true);
        return;
      }
      this.jdField_a_of_type_Aogv.a(aofz.a(this.jdField_a_of_type_Aogq.jdField_a_of_type_Long, false), false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aogq.jdField_a_of_type_JavaLangString + " start upload Discfile");
    }
    paramBoolean = aonj.e(aofz.a(this.jdField_a_of_type_Aogq.jdField_a_of_type_Aofz));
    paramString5 = paramBundle.getString("strHttpsDomain");
    int i = paramBundle.getShort("httpsPort");
    paramString2 = "";
    if (apdq.b(aofz.a(this.jdField_a_of_type_Aogq.jdField_a_of_type_Aofz))) {
      paramString2 = paramBundle.getString("strHttpsDomain");
    }
    paramString1 = new aofm(aofz.a(this.jdField_a_of_type_Aogq.jdField_a_of_type_Aofz), paramString3, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aogq.jdField_a_of_type_Long, paramString4, paramInt, paramBoolean, paramString5, i, this.jdField_a_of_type_Aogq.b, paramString2, new aogs(this, paramString1));
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aogq.jdField_a_of_type_JavaLangString + " add to rsCenter");
    }
    aogq.a(this.jdField_a_of_type_Aogq, apck.a().longValue());
    aofz.a(this.jdField_a_of_type_Aogq.jdField_a_of_type_Aofz).a().a(aogq.a(this.jdField_a_of_type_Aogq), paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aogr
 * JD-Core Version:    0.7.0.1
 */