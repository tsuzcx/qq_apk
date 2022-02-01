import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.TroopInfo;

public class bgho
  implements Comparable<bgho>
{
  public int a;
  public TroopInfo a;
  public String a;
  public int b;
  
  public int a(@NonNull bgho parambgho)
  {
    if (this.b != parambgho.b) {
      return this.b - parambgho.b;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime != parambgho.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime) {
      return (int)(parambgho.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime - this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime);
    }
    if (parambgho.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime != this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime) {
      return (int)(parambgho.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime - this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime);
    }
    if (this.jdField_a_of_type_Int != parambgho.jdField_a_of_type_Int) {
      return this.jdField_a_of_type_Int - parambgho.jdField_a_of_type_Int;
    }
    return this.jdField_a_of_type_JavaLangString.compareTo(parambgho.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgho
 * JD-Core Version:    0.7.0.1
 */