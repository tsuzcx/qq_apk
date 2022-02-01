import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.Comparator;

public class amrk
  implements Comparator<amrm>
{
  private int a(amrm paramamrm)
  {
    if ((a(paramamrm) == 0L) || (paramamrm.jdField_a_of_type_Int == 4)) {
      return paramamrm.jdField_a_of_type_Int + 3;
    }
    return paramamrm.jdField_a_of_type_Int;
  }
  
  private long a(amrm paramamrm)
  {
    if ((paramamrm.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof TroopInfo)) {
      return ((TroopInfo)paramamrm.jdField_a_of_type_ComTencentMobileqqPersistenceEntity).lastMsgTime;
    }
    if ((paramamrm.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof DiscussionInfo)) {
      return ((DiscussionInfo)paramamrm.jdField_a_of_type_ComTencentMobileqqPersistenceEntity).lastMsgTime;
    }
    return 0L;
  }
  
  public int a(amrm paramamrm1, amrm paramamrm2)
  {
    if ((paramamrm1 == null) && (paramamrm2 == null)) {
      return 0;
    }
    if (paramamrm1 == null) {
      return -1;
    }
    if (paramamrm2 == null) {
      return 1;
    }
    if (a(paramamrm1) == a(paramamrm2)) {
      return (int)(a(paramamrm2) - a(paramamrm1));
    }
    return a(paramamrm1) - a(paramamrm2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrk
 * JD-Core Version:    0.7.0.1
 */