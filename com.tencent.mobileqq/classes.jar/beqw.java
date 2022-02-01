import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class beqw
  implements Comparable<beqw>
{
  public int a;
  public TroopInfo a;
  public String a;
  public int b;
  
  public int a(@NonNull beqw parambeqw)
  {
    if (this.b != parambeqw.b) {
      return this.b - parambeqw.b;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.lastMsgTime != parambeqw.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.lastMsgTime) {
      return (int)(parambeqw.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.lastMsgTime - this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.lastMsgTime);
    }
    if (parambeqw.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopCreateTime != this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopCreateTime) {
      return (int)(parambeqw.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopCreateTime - this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopCreateTime);
    }
    if (this.jdField_a_of_type_Int != parambeqw.jdField_a_of_type_Int) {
      return this.jdField_a_of_type_Int - parambeqw.jdField_a_of_type_Int;
    }
    return this.jdField_a_of_type_JavaLangString.compareTo(parambeqw.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqw
 * JD-Core Version:    0.7.0.1
 */