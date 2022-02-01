import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class atta
  extends atrl
{
  atta(atsz paramatsz, atte paramatte, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, Bundle paramBundle)
  {
    super.a(paramBoolean, paramLong, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Atsz.jdField_a_of_type_JavaLangString + " start DiscUploadTaskExcuter isSuccess:" + paramBoolean + " retCode:" + paramLong + " retMsg:" + paramString6);
    }
    if (!paramBoolean)
    {
      if ((paramLong == -100001L) || (paramLong == -100002L))
      {
        this.jdField_a_of_type_Atte.a(atsi.a(this.jdField_a_of_type_Atsz.jdField_a_of_type_Long, false), true);
        return;
      }
      this.jdField_a_of_type_Atte.a(atsi.a(this.jdField_a_of_type_Atsz.jdField_a_of_type_Long, false), false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Atsz.jdField_a_of_type_JavaLangString + " start upload Discfile");
    }
    paramBoolean = atyt.e(atsi.a(this.jdField_a_of_type_Atsz.jdField_a_of_type_Atsi));
    paramString2 = "";
    int i = 0;
    paramString5 = "";
    if (paramBundle != null)
    {
      paramString2 = paramBundle.getString("strHttpsDomain");
      i = paramBundle.getShort("httpsPort");
      paramString5 = paramBundle.getString("strHttpsDomain");
    }
    paramString1 = new atrn(atsi.a(this.jdField_a_of_type_Atsz.jdField_a_of_type_Atsi), paramString3, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Atsz.jdField_a_of_type_Long, paramString4, paramInt, paramBoolean, paramString2, i, this.jdField_a_of_type_Atsz.b, paramString5, new attb(this, paramString1));
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Atsz.jdField_a_of_type_JavaLangString + " add to rsCenter");
    }
    atsz.a(this.jdField_a_of_type_Atsz, aunj.a().longValue());
    atsi.a(this.jdField_a_of_type_Atsz.jdField_a_of_type_Atsi).a().a(atsz.a(this.jdField_a_of_type_Atsz), paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atta
 * JD-Core Version:    0.7.0.1
 */