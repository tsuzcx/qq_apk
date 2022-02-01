import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class bggk
  implements aojm
{
  bggk(bggj parambggj, String paramString1, String paramString2, bggm parambggm) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    List localList = null;
    if (paramTroopMemberInfo != null) {
      localList = this.jdField_a_of_type_Bggj.a(paramTroopMemberInfo.honorList);
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopHonor.manager", 2, String.format("getTroopHonorList, troopUin: %s, memberUin: %s, honorList: %s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b, localList }));
    }
    if (this.jdField_a_of_type_Bggm != null) {
      this.jdField_a_of_type_Bggm.a(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggk
 * JD-Core Version:    0.7.0.1
 */