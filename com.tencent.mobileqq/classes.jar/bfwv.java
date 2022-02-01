import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class bfwv
  implements aofo
{
  bfwv(bfwu parambfwu, String paramString1, String paramString2, bfww parambfww) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    List localList = null;
    if (paramTroopMemberInfo != null) {
      localList = this.jdField_a_of_type_Bfwu.a(paramTroopMemberInfo.honorList);
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopHonor.manager", 2, String.format("getTroopHonorList, troopUin: %s, memberUin: %s, honorList: %s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b, localList }));
    }
    if (this.jdField_a_of_type_Bfww != null) {
      this.jdField_a_of_type_Bfww.a(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfwv
 * JD-Core Version:    0.7.0.1
 */