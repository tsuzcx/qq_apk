import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aqop
  implements aqpk
{
  aqop(aqoo paramaqoo, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aqoo.jdField_a_of_type_Aqon.jdField_a_of_type_JavaLangString + " start upload Discfile success");
      }
      aqon.a(this.jdField_a_of_type_Aqoo.jdField_a_of_type_Aqon).putString("_m_ForwardUuid", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Aqoo.jdField_a_of_type_Aqot.a(this.jdField_a_of_type_JavaLangString, aqon.a(this.jdField_a_of_type_Aqoo.jdField_a_of_type_Aqon));
    }
    for (;;)
    {
      aqnw.a(this.jdField_a_of_type_Aqoo.jdField_a_of_type_Aqon.jdField_a_of_type_Aqnw).a().a(aqon.a(this.jdField_a_of_type_Aqoo.jdField_a_of_type_Aqon));
      return;
      QLog.e("FileMultiMsg", 1, this.jdField_a_of_type_Aqoo.jdField_a_of_type_Aqon.jdField_a_of_type_JavaLangString + " sendDiscFile faild");
      this.jdField_a_of_type_Aqoo.jdField_a_of_type_Aqot.a(aqnw.a(this.jdField_a_of_type_Aqoo.jdField_a_of_type_Aqon.jdField_a_of_type_Long, false), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqop
 * JD-Core Version:    0.7.0.1
 */