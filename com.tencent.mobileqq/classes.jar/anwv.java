import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class anwv
  implements asko<EmoticonPackage>
{
  anwv(anws paramanws, aobk paramaobk) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool;
    if (paramEmoticonPackage != null)
    {
      this.jdField_a_of_type_Aobk.j = paramEmoticonPackage.type;
      aobk localaobk = this.jdField_a_of_type_Aobk;
      if (paramEmoticonPackage.isAPNG == 2)
      {
        bool = true;
        localaobk.c = bool;
      }
    }
    for (;;)
    {
      anws.a(this.jdField_a_of_type_Anws).a(this.jdField_a_of_type_Aobk);
      if (QLog.isColorLevel()) {
        QLog.d("SogouEmoji", 2, "func sendEmoji ends, type:" + this.jdField_a_of_type_Aobk.j);
      }
      return;
      bool = false;
      break;
      this.jdField_a_of_type_Aobk.j = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anwv
 * JD-Core Version:    0.7.0.1
 */