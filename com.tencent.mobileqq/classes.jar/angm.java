import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class angm
  implements arok<EmoticonPackage>
{
  angm(angj paramangj, anla paramanla) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool;
    if (paramEmoticonPackage != null)
    {
      this.jdField_a_of_type_Anla.j = paramEmoticonPackage.type;
      anla localanla = this.jdField_a_of_type_Anla;
      if (paramEmoticonPackage.isAPNG == 2)
      {
        bool = true;
        localanla.c = bool;
      }
    }
    for (;;)
    {
      angj.a(this.jdField_a_of_type_Angj).a(this.jdField_a_of_type_Anla);
      if (QLog.isColorLevel()) {
        QLog.d("SogouEmoji", 2, "func sendEmoji ends, type:" + this.jdField_a_of_type_Anla.j);
      }
      return;
      bool = false;
      break;
      this.jdField_a_of_type_Anla.j = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     angm
 * JD-Core Version:    0.7.0.1
 */