import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class apsv
  implements aufy<EmoticonPackage>
{
  apsv(apss paramapss, apxv paramapxv) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool;
    if (paramEmoticonPackage != null)
    {
      this.jdField_a_of_type_Apxv.j = paramEmoticonPackage.type;
      apxv localapxv = this.jdField_a_of_type_Apxv;
      if (paramEmoticonPackage.isAPNG == 2)
      {
        bool = true;
        localapxv.c = bool;
      }
    }
    for (;;)
    {
      apss.a(this.jdField_a_of_type_Apss).a(this.jdField_a_of_type_Apxv);
      if (QLog.isColorLevel()) {
        QLog.d("SogouEmoji", 2, "func sendEmoji ends, type:" + this.jdField_a_of_type_Apxv.j);
      }
      return;
      bool = false;
      break;
      this.jdField_a_of_type_Apxv.j = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsv
 * JD-Core Version:    0.7.0.1
 */