import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aovr
  implements aowm
{
  aovr(aovq paramaovq, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aovq.jdField_a_of_type_Aovp.jdField_a_of_type_JavaLangString + " start upload Discfile success");
      }
      aovp.a(this.jdField_a_of_type_Aovq.jdField_a_of_type_Aovp).putString("_m_ForwardUuid", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Aovq.jdField_a_of_type_Aovv.a(this.jdField_a_of_type_JavaLangString, aovp.a(this.jdField_a_of_type_Aovq.jdField_a_of_type_Aovp));
    }
    for (;;)
    {
      aouy.a(this.jdField_a_of_type_Aovq.jdField_a_of_type_Aovp.jdField_a_of_type_Aouy).a().a(aovp.a(this.jdField_a_of_type_Aovq.jdField_a_of_type_Aovp));
      return;
      QLog.e("FileMultiMsg", 1, this.jdField_a_of_type_Aovq.jdField_a_of_type_Aovp.jdField_a_of_type_JavaLangString + " sendDiscFile faild");
      this.jdField_a_of_type_Aovq.jdField_a_of_type_Aovv.a(aouy.a(this.jdField_a_of_type_Aovq.jdField_a_of_type_Aovp.jdField_a_of_type_Long, false), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aovr
 * JD-Core Version:    0.7.0.1
 */