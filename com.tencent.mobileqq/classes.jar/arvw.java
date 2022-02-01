import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class arvw
  implements awnc<EmoticonPackage>
{
  arvw(arvt paramarvt, asbq paramasbq) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool;
    if (paramEmoticonPackage != null)
    {
      this.jdField_a_of_type_Asbq.j = paramEmoticonPackage.type;
      asbq localasbq = this.jdField_a_of_type_Asbq;
      if (paramEmoticonPackage.isAPNG == 2)
      {
        bool = true;
        localasbq.c = bool;
      }
    }
    for (;;)
    {
      arvt.a(this.jdField_a_of_type_Arvt).a(this.jdField_a_of_type_Asbq);
      if (QLog.isColorLevel()) {
        QLog.d("SogouEmoji", 2, "func sendEmoji ends, type:" + this.jdField_a_of_type_Asbq.j);
      }
      return;
      bool = false;
      break;
      this.jdField_a_of_type_Asbq.j = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvw
 * JD-Core Version:    0.7.0.1
 */