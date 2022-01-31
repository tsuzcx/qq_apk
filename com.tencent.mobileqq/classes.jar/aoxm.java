import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aoxm
  implements aowi
{
  aoxm(aoxl paramaoxl, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aoxl.jdField_a_of_type_Aoxk.jdField_a_of_type_JavaLangString + " start upload Discfile success");
      }
      aoxk.a(this.jdField_a_of_type_Aoxl.jdField_a_of_type_Aoxk).putString("_m_ForwardUuid", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Aoxl.jdField_a_of_type_Aoxp.a(this.jdField_a_of_type_JavaLangString, aoxk.a(this.jdField_a_of_type_Aoxl.jdField_a_of_type_Aoxk));
    }
    for (;;)
    {
      aowt.a(this.jdField_a_of_type_Aoxl.jdField_a_of_type_Aoxk.jdField_a_of_type_Aowt).a().a(aoxk.a(this.jdField_a_of_type_Aoxl.jdField_a_of_type_Aoxk));
      return;
      QLog.e("FileMultiMsg", 1, this.jdField_a_of_type_Aoxl.jdField_a_of_type_Aoxk.jdField_a_of_type_JavaLangString + " sendDiscFile faild");
      this.jdField_a_of_type_Aoxl.jdField_a_of_type_Aoxp.a(aowt.a(this.jdField_a_of_type_Aoxl.jdField_a_of_type_Aoxk.jdField_a_of_type_Long, false), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoxm
 * JD-Core Version:    0.7.0.1
 */