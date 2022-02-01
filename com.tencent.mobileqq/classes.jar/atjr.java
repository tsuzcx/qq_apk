import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class atjr
  implements atif
{
  atjr(atjq paramatjq, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Atjq.jdField_a_of_type_Atjp.jdField_a_of_type_JavaLangString + " start upload Discfile success");
      }
      atjp.a(this.jdField_a_of_type_Atjq.jdField_a_of_type_Atjp).putString("_m_ForwardUuid", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Atjq.jdField_a_of_type_Atju.a(this.jdField_a_of_type_JavaLangString, atjp.a(this.jdField_a_of_type_Atjq.jdField_a_of_type_Atjp));
    }
    for (;;)
    {
      atiy.a(this.jdField_a_of_type_Atjq.jdField_a_of_type_Atjp.jdField_a_of_type_Atiy).getFileManagerRSCenter().a(atjp.a(this.jdField_a_of_type_Atjq.jdField_a_of_type_Atjp));
      return;
      QLog.e("FileMultiMsg", 1, this.jdField_a_of_type_Atjq.jdField_a_of_type_Atjp.jdField_a_of_type_JavaLangString + " sendDiscFile faild");
      this.jdField_a_of_type_Atjq.jdField_a_of_type_Atju.a(atiy.a(this.jdField_a_of_type_Atjq.jdField_a_of_type_Atjp.jdField_a_of_type_Long, false), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atjr
 * JD-Core Version:    0.7.0.1
 */