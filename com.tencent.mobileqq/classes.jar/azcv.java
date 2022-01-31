import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.TroopInfo;

public class azcv
  implements Comparable<azcv>
{
  public int a;
  public TroopInfo a;
  public String a;
  public int b;
  
  public int a(@NonNull azcv paramazcv)
  {
    if (this.b != paramazcv.b) {
      return this.b - paramazcv.b;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime != paramazcv.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime) {
      return (int)(paramazcv.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime - this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime);
    }
    if (paramazcv.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime != this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime) {
      return (int)(paramazcv.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime - this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime);
    }
    if (this.jdField_a_of_type_Int != paramazcv.jdField_a_of_type_Int) {
      return this.jdField_a_of_type_Int - paramazcv.jdField_a_of_type_Int;
    }
    return this.jdField_a_of_type_JavaLangString.compareTo(paramazcv.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azcv
 * JD-Core Version:    0.7.0.1
 */