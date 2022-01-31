import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.TroopInfo;

public class badq
  implements Comparable<badq>
{
  public int a;
  public TroopInfo a;
  public String a;
  public int b;
  
  public int a(@NonNull badq parambadq)
  {
    if (this.b != parambadq.b) {
      return this.b - parambadq.b;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime != parambadq.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime) {
      return (int)(parambadq.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime - this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime);
    }
    if (parambadq.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime != this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime) {
      return (int)(parambadq.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime - this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime);
    }
    if (this.jdField_a_of_type_Int != parambadq.jdField_a_of_type_Int) {
      return this.jdField_a_of_type_Int - parambadq.jdField_a_of_type_Int;
    }
    return this.jdField_a_of_type_JavaLangString.compareTo(parambadq.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     badq
 * JD-Core Version:    0.7.0.1
 */