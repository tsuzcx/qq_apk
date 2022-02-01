import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class bfxy
  implements Comparable<bfxy>
{
  public int a;
  public TroopInfo a;
  public String a;
  public int b;
  
  public int a(@NonNull bfxy parambfxy)
  {
    if (this.b != parambfxy.b) {
      return this.b - parambfxy.b;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.lastMsgTime != parambfxy.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.lastMsgTime) {
      return (int)(parambfxy.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.lastMsgTime - this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.lastMsgTime);
    }
    if (parambfxy.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopCreateTime != this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopCreateTime) {
      return (int)(parambfxy.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopCreateTime - this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopCreateTime);
    }
    if (this.jdField_a_of_type_Int != parambfxy.jdField_a_of_type_Int) {
      return this.jdField_a_of_type_Int - parambfxy.jdField_a_of_type_Int;
    }
    return this.jdField_a_of_type_JavaLangString.compareTo(parambfxy.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxy
 * JD-Core Version:    0.7.0.1
 */