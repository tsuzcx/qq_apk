import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class apom
  implements aubp<EmoticonPackage>
{
  apom(apoj paramapoj, aptm paramaptm) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool;
    if (paramEmoticonPackage != null)
    {
      this.jdField_a_of_type_Aptm.j = paramEmoticonPackage.type;
      aptm localaptm = this.jdField_a_of_type_Aptm;
      if (paramEmoticonPackage.isAPNG == 2)
      {
        bool = true;
        localaptm.c = bool;
      }
    }
    for (;;)
    {
      apoj.a(this.jdField_a_of_type_Apoj).a(this.jdField_a_of_type_Aptm);
      if (QLog.isColorLevel()) {
        QLog.d("SogouEmoji", 2, "func sendEmoji ends, type:" + this.jdField_a_of_type_Aptm.j);
      }
      return;
      bool = false;
      break;
      this.jdField_a_of_type_Aptm.j = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apom
 * JD-Core Version:    0.7.0.1
 */