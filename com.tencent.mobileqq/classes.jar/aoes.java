import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aoes
  extends aofk
{
  aoes(aoer paramaoer, aoex paramaoex, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, Bundle paramBundle)
  {
    super.a(paramBoolean, paramLong, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aoer.jdField_a_of_type_JavaLangString + " start DiscUploadTaskExcuter isSuccess:" + paramBoolean + " retCode:" + paramLong + " retMsg:" + paramString6);
    }
    if (!paramBoolean)
    {
      if ((paramLong == -100001L) || (paramLong == -100002L))
      {
        this.jdField_a_of_type_Aoex.a(aoea.a(this.jdField_a_of_type_Aoer.jdField_a_of_type_Long, false), true);
        return;
      }
      this.jdField_a_of_type_Aoex.a(aoea.a(this.jdField_a_of_type_Aoer.jdField_a_of_type_Long, false), false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aoer.jdField_a_of_type_JavaLangString + " start upload Discfile");
    }
    paramBoolean = aonj.e(aoea.a(this.jdField_a_of_type_Aoer.jdField_a_of_type_Aoea));
    paramString5 = paramBundle.getString("strHttpsDomain");
    int i = paramBundle.getShort("httpsPort");
    paramString2 = "";
    if (apdq.b(aoea.a(this.jdField_a_of_type_Aoer.jdField_a_of_type_Aoea))) {
      paramString2 = paramBundle.getString("strHttpsDomain");
    }
    paramString1 = new aofm(aoea.a(this.jdField_a_of_type_Aoer.jdField_a_of_type_Aoea), paramString3, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aoer.jdField_a_of_type_Long, paramString4, paramInt, paramBoolean, paramString5, i, this.jdField_a_of_type_Aoer.b, paramString2, new aoet(this, paramString1));
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aoer.jdField_a_of_type_JavaLangString + " add to rsCenter");
    }
    aoer.a(this.jdField_a_of_type_Aoer, apck.a().longValue());
    aoea.a(this.jdField_a_of_type_Aoer.jdField_a_of_type_Aoea).a().a(aoer.a(this.jdField_a_of_type_Aoer), paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoes
 * JD-Core Version:    0.7.0.1
 */