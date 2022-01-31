import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.TroopInfo;

public class baee
  implements Comparable<baee>
{
  public int a;
  public TroopInfo a;
  public String a;
  public int b;
  
  public int a(@NonNull baee parambaee)
  {
    if (this.b != parambaee.b) {
      return this.b - parambaee.b;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime != parambaee.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime) {
      return (int)(parambaee.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime - this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime);
    }
    if (parambaee.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime != this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime) {
      return (int)(parambaee.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime - this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime);
    }
    if (this.jdField_a_of_type_Int != parambaee.jdField_a_of_type_Int) {
      return this.jdField_a_of_type_Int - parambaee.jdField_a_of_type_Int;
    }
    return this.jdField_a_of_type_JavaLangString.compareTo(parambaee.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baee
 * JD-Core Version:    0.7.0.1
 */