import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aqoo
  extends aqpg
{
  aqoo(aqon paramaqon, aqot paramaqot, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, Bundle paramBundle)
  {
    super.a(paramBoolean, paramLong, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aqon.jdField_a_of_type_JavaLangString + " start DiscUploadTaskExcuter isSuccess:" + paramBoolean + " retCode:" + paramLong + " retMsg:" + paramString6);
    }
    if (!paramBoolean)
    {
      if ((paramLong == -100001L) || (paramLong == -100002L))
      {
        this.jdField_a_of_type_Aqot.a(aqnw.a(this.jdField_a_of_type_Aqon.jdField_a_of_type_Long, false), true);
        return;
      }
      this.jdField_a_of_type_Aqot.a(aqnw.a(this.jdField_a_of_type_Aqon.jdField_a_of_type_Long, false), false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aqon.jdField_a_of_type_JavaLangString + " start upload Discfile");
    }
    paramBoolean = aqxg.e(aqnw.a(this.jdField_a_of_type_Aqon.jdField_a_of_type_Aqnw));
    paramString5 = paramBundle.getString("strHttpsDomain");
    int i = paramBundle.getShort("httpsPort");
    paramString2 = "";
    if (aroo.b(aqnw.a(this.jdField_a_of_type_Aqon.jdField_a_of_type_Aqnw))) {
      paramString2 = paramBundle.getString("strHttpsDomain");
    }
    paramString1 = new aqpi(aqnw.a(this.jdField_a_of_type_Aqon.jdField_a_of_type_Aqnw), paramString3, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aqon.jdField_a_of_type_Long, paramString4, paramInt, paramBoolean, paramString5, i, this.jdField_a_of_type_Aqon.b, paramString2, new aqop(this, paramString1));
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aqon.jdField_a_of_type_JavaLangString + " add to rsCenter");
    }
    aqon.a(this.jdField_a_of_type_Aqon, arni.a().longValue());
    aqnw.a(this.jdField_a_of_type_Aqon.jdField_a_of_type_Aqnw).a().a(aqon.a(this.jdField_a_of_type_Aqon), paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqoo
 * JD-Core Version:    0.7.0.1
 */