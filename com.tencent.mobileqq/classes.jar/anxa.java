import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class anxa
  implements askq<EmoticonPackage>
{
  anxa(anwx paramanwx, aobp paramaobp) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool;
    if (paramEmoticonPackage != null)
    {
      this.jdField_a_of_type_Aobp.j = paramEmoticonPackage.type;
      aobp localaobp = this.jdField_a_of_type_Aobp;
      if (paramEmoticonPackage.isAPNG == 2)
      {
        bool = true;
        localaobp.c = bool;
      }
    }
    for (;;)
    {
      anwx.a(this.jdField_a_of_type_Anwx).a(this.jdField_a_of_type_Aobp);
      if (QLog.isColorLevel()) {
        QLog.d("SogouEmoji", 2, "func sendEmoji ends, type:" + this.jdField_a_of_type_Aobp.j);
      }
      return;
      bool = false;
      break;
      this.jdField_a_of_type_Aobp.j = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anxa
 * JD-Core Version:    0.7.0.1
 */