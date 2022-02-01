import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class aslk
  implements axfu<EmoticonPackage>
{
  aslk(aslh paramaslh, asre paramasre) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool;
    if (paramEmoticonPackage != null)
    {
      this.jdField_a_of_type_Asre.j = paramEmoticonPackage.type;
      asre localasre = this.jdField_a_of_type_Asre;
      if (paramEmoticonPackage.isAPNG == 2)
      {
        bool = true;
        localasre.c = bool;
      }
    }
    for (;;)
    {
      aslh.a(this.jdField_a_of_type_Aslh).a(this.jdField_a_of_type_Asre);
      if (QLog.isColorLevel()) {
        QLog.d("SogouEmoji", 2, "func sendEmoji ends, type:" + this.jdField_a_of_type_Asre.j);
      }
      return;
      bool = false;
      break;
      this.jdField_a_of_type_Asre.j = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslk
 * JD-Core Version:    0.7.0.1
 */