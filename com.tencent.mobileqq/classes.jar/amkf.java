import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import java.util.Comparator;

public class amkf
  implements Comparator<amkh>
{
  private int a(amkh paramamkh)
  {
    if ((a(paramamkh) == 0L) || (paramamkh.jdField_a_of_type_Int == 4)) {
      return paramamkh.jdField_a_of_type_Int + 3;
    }
    return paramamkh.jdField_a_of_type_Int;
  }
  
  private long a(amkh paramamkh)
  {
    if ((paramamkh.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof TroopInfo)) {
      return ((TroopInfo)paramamkh.jdField_a_of_type_ComTencentMobileqqPersistenceEntity).lastMsgTime;
    }
    if ((paramamkh.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof DiscussionInfo)) {
      return ((DiscussionInfo)paramamkh.jdField_a_of_type_ComTencentMobileqqPersistenceEntity).lastMsgTime;
    }
    return 0L;
  }
  
  public int a(amkh paramamkh1, amkh paramamkh2)
  {
    if ((paramamkh1 == null) && (paramamkh2 == null)) {
      return 0;
    }
    if (paramamkh1 == null) {
      return -1;
    }
    if (paramamkh2 == null) {
      return 1;
    }
    if (a(paramamkh1) == a(paramamkh2)) {
      return (int)(a(paramamkh2) - a(paramamkh1));
    }
    return a(paramamkh1) - a(paramamkh2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkf
 * JD-Core Version:    0.7.0.1
 */