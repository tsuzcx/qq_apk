import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aoxp
  extends aowi
{
  aoxp(aoxo paramaoxo, aoxt paramaoxt, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, Bundle paramBundle)
  {
    super.a(paramBoolean, paramLong, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aoxo.jdField_a_of_type_JavaLangString + " start DiscUploadTaskExcuter isSuccess:" + paramBoolean + " retCode:" + paramLong + " retMsg:" + paramString6);
    }
    if (!paramBoolean)
    {
      if ((paramLong == -100001L) || (paramLong == -100002L))
      {
        this.jdField_a_of_type_Aoxt.a(aowx.a(this.jdField_a_of_type_Aoxo.jdField_a_of_type_Long, false), true);
        return;
      }
      this.jdField_a_of_type_Aoxt.a(aowx.a(this.jdField_a_of_type_Aoxo.jdField_a_of_type_Long, false), false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aoxo.jdField_a_of_type_JavaLangString + " start upload Discfile");
    }
    paramBoolean = apei.e(aowx.a(this.jdField_a_of_type_Aoxo.jdField_a_of_type_Aowx));
    paramString5 = paramBundle.getString("strHttpsDomain");
    int i = paramBundle.getShort("httpsPort");
    paramString2 = "";
    if (apvm.b(aowx.a(this.jdField_a_of_type_Aoxo.jdField_a_of_type_Aowx))) {
      paramString2 = paramBundle.getString("strHttpsDomain");
    }
    paramString1 = new aowk(aowx.a(this.jdField_a_of_type_Aoxo.jdField_a_of_type_Aowx), paramString3, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aoxo.jdField_a_of_type_Long, paramString4, paramInt, paramBoolean, paramString5, i, this.jdField_a_of_type_Aoxo.b, paramString2, new aoxq(this, paramString1));
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aoxo.jdField_a_of_type_JavaLangString + " add to rsCenter");
    }
    aoxo.a(this.jdField_a_of_type_Aoxo, apug.a().longValue());
    aowx.a(this.jdField_a_of_type_Aoxo.jdField_a_of_type_Aowx).a().a(aoxo.a(this.jdField_a_of_type_Aoxo), paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoxp
 * JD-Core Version:    0.7.0.1
 */