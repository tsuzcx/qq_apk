import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aqux
  implements aqtt
{
  aqux(aquw paramaquw, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aquw.jdField_a_of_type_Aquv.jdField_a_of_type_JavaLangString + " start upload Discfile success");
      }
      aquv.a(this.jdField_a_of_type_Aquw.jdField_a_of_type_Aquv).putString("_m_ForwardUuid", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Aquw.jdField_a_of_type_Aqva.a(this.jdField_a_of_type_JavaLangString, aquv.a(this.jdField_a_of_type_Aquw.jdField_a_of_type_Aquv));
    }
    for (;;)
    {
      aque.a(this.jdField_a_of_type_Aquw.jdField_a_of_type_Aquv.jdField_a_of_type_Aque).a().a(aquv.a(this.jdField_a_of_type_Aquw.jdField_a_of_type_Aquv));
      return;
      QLog.e("FileMultiMsg", 1, this.jdField_a_of_type_Aquw.jdField_a_of_type_Aquv.jdField_a_of_type_JavaLangString + " sendDiscFile faild");
      this.jdField_a_of_type_Aquw.jdField_a_of_type_Aqva.a(aque.a(this.jdField_a_of_type_Aquw.jdField_a_of_type_Aquv.jdField_a_of_type_Long, false), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqux
 * JD-Core Version:    0.7.0.1
 */