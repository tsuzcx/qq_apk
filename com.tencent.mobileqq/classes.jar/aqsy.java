import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aqsy
  implements aqtt
{
  aqsy(aqsx paramaqsx, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aqsx.jdField_a_of_type_Aqsw.jdField_a_of_type_JavaLangString + " start upload Discfile success");
      }
      aqsw.a(this.jdField_a_of_type_Aqsx.jdField_a_of_type_Aqsw).putString("_m_ForwardUuid", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Aqsx.jdField_a_of_type_Aqtc.a(this.jdField_a_of_type_JavaLangString, aqsw.a(this.jdField_a_of_type_Aqsx.jdField_a_of_type_Aqsw));
    }
    for (;;)
    {
      aqsf.a(this.jdField_a_of_type_Aqsx.jdField_a_of_type_Aqsw.jdField_a_of_type_Aqsf).a().a(aqsw.a(this.jdField_a_of_type_Aqsx.jdField_a_of_type_Aqsw));
      return;
      QLog.e("FileMultiMsg", 1, this.jdField_a_of_type_Aqsx.jdField_a_of_type_Aqsw.jdField_a_of_type_JavaLangString + " sendDiscFile faild");
      this.jdField_a_of_type_Aqsx.jdField_a_of_type_Aqtc.a(aqsf.a(this.jdField_a_of_type_Aqsx.jdField_a_of_type_Aqsw.jdField_a_of_type_Long, false), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqsy
 * JD-Core Version:    0.7.0.1
 */