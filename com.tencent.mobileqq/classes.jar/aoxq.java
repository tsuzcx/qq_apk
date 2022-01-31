import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aoxq
  implements aowm
{
  aoxq(aoxp paramaoxp, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aoxp.jdField_a_of_type_Aoxo.jdField_a_of_type_JavaLangString + " start upload Discfile success");
      }
      aoxo.a(this.jdField_a_of_type_Aoxp.jdField_a_of_type_Aoxo).putString("_m_ForwardUuid", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Aoxp.jdField_a_of_type_Aoxt.a(this.jdField_a_of_type_JavaLangString, aoxo.a(this.jdField_a_of_type_Aoxp.jdField_a_of_type_Aoxo));
    }
    for (;;)
    {
      aowx.a(this.jdField_a_of_type_Aoxp.jdField_a_of_type_Aoxo.jdField_a_of_type_Aowx).a().a(aoxo.a(this.jdField_a_of_type_Aoxp.jdField_a_of_type_Aoxo));
      return;
      QLog.e("FileMultiMsg", 1, this.jdField_a_of_type_Aoxp.jdField_a_of_type_Aoxo.jdField_a_of_type_JavaLangString + " sendDiscFile faild");
      this.jdField_a_of_type_Aoxp.jdField_a_of_type_Aoxt.a(aowx.a(this.jdField_a_of_type_Aoxp.jdField_a_of_type_Aoxo.jdField_a_of_type_Long, false), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoxq
 * JD-Core Version:    0.7.0.1
 */