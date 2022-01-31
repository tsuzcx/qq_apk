import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.TroopInfo;

public class bccq
  implements Comparable<bccq>
{
  public int a;
  public TroopInfo a;
  public String a;
  public int b;
  
  public int a(@NonNull bccq parambccq)
  {
    if (this.b != parambccq.b) {
      return this.b - parambccq.b;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime != parambccq.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime) {
      return (int)(parambccq.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime - this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.lastMsgTime);
    }
    if (parambccq.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime != this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime) {
      return (int)(parambccq.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime - this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopCreateTime);
    }
    if (this.jdField_a_of_type_Int != parambccq.jdField_a_of_type_Int) {
      return this.jdField_a_of_type_Int - parambccq.jdField_a_of_type_Int;
    }
    return this.jdField_a_of_type_JavaLangString.compareTo(parambccq.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bccq
 * JD-Core Version:    0.7.0.1
 */