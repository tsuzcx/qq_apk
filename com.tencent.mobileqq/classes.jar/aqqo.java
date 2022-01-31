import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aqqo
  implements aqpk
{
  aqqo(aqqn paramaqqn, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aqqn.jdField_a_of_type_Aqqm.jdField_a_of_type_JavaLangString + " start upload Discfile success");
      }
      aqqm.a(this.jdField_a_of_type_Aqqn.jdField_a_of_type_Aqqm).putString("_m_ForwardUuid", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Aqqn.jdField_a_of_type_Aqqr.a(this.jdField_a_of_type_JavaLangString, aqqm.a(this.jdField_a_of_type_Aqqn.jdField_a_of_type_Aqqm));
    }
    for (;;)
    {
      aqpv.a(this.jdField_a_of_type_Aqqn.jdField_a_of_type_Aqqm.jdField_a_of_type_Aqpv).a().a(aqqm.a(this.jdField_a_of_type_Aqqn.jdField_a_of_type_Aqqm));
      return;
      QLog.e("FileMultiMsg", 1, this.jdField_a_of_type_Aqqn.jdField_a_of_type_Aqqm.jdField_a_of_type_JavaLangString + " sendDiscFile faild");
      this.jdField_a_of_type_Aqqn.jdField_a_of_type_Aqqr.a(aqpv.a(this.jdField_a_of_type_Aqqn.jdField_a_of_type_Aqqm.jdField_a_of_type_Long, false), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqo
 * JD-Core Version:    0.7.0.1
 */