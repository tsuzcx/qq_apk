import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class bacw
  implements akig
{
  bacw(bacv parambacv, String paramString1, String paramString2, bacx parambacx) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    List localList = null;
    if (paramTroopMemberInfo != null) {
      localList = this.jdField_a_of_type_Bacv.a(paramTroopMemberInfo.honorList);
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopHonor.manager", 2, String.format("getTroopHonorList, troopUin: %s, memberUin: %s, honorList: %s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b, localList }));
    }
    if (this.jdField_a_of_type_Bacx != null) {
      this.jdField_a_of_type_Bacx.a(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bacw
 * JD-Core Version:    0.7.0.1
 */