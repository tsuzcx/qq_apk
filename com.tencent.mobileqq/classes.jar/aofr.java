import android.text.TextUtils;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;

public class aofr
  implements aofo
{
  public int a;
  public String a;
  public String b;
  
  private aofr(TroopManager paramTroopManager) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if ((paramTroopMemberInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.b)) || (!this.jdField_a_of_type_JavaLangString.equals(paramTroopMemberInfo.memberuin))) {
      return;
    }
    paramTroopMemberInfo.newRealLevel = this.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "newRealLevel:" + this.jdField_a_of_type_Int + ",troopUin : " + this.b + ",memberUin" + this.jdField_a_of_type_JavaLangString);
    }
    if (paramTroopMemberInfo.getStatus() == 1000) {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.b, this.jdField_a_of_type_JavaLangString, paramTroopMemberInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.b, this.jdField_a_of_type_JavaLangString, paramTroopMemberInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aofr
 * JD-Core Version:    0.7.0.1
 */