import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class badk
  implements akif
{
  badk(badj parambadj, String paramString1, String paramString2, badl parambadl) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    List localList = null;
    if (paramTroopMemberInfo != null) {
      localList = this.jdField_a_of_type_Badj.a(paramTroopMemberInfo.honorList);
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopHonor.manager", 2, String.format("getTroopHonorList, troopUin: %s, memberUin: %s, honorList: %s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b, localList }));
    }
    if (this.jdField_a_of_type_Badl != null) {
      this.jdField_a_of_type_Badl.a(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     badk
 * JD-Core Version:    0.7.0.1
 */