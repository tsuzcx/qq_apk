import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.Comparator;

public class amfq
  implements Comparator<amfs>
{
  private int a(amfs paramamfs)
  {
    if ((a(paramamfs) == 0L) || (paramamfs.jdField_a_of_type_Int == 4)) {
      return paramamfs.jdField_a_of_type_Int + 3;
    }
    return paramamfs.jdField_a_of_type_Int;
  }
  
  private long a(amfs paramamfs)
  {
    if ((paramamfs.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof TroopInfo)) {
      return ((TroopInfo)paramamfs.jdField_a_of_type_ComTencentMobileqqPersistenceEntity).lastMsgTime;
    }
    if ((paramamfs.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof DiscussionInfo)) {
      return ((DiscussionInfo)paramamfs.jdField_a_of_type_ComTencentMobileqqPersistenceEntity).lastMsgTime;
    }
    return 0L;
  }
  
  public int a(amfs paramamfs1, amfs paramamfs2)
  {
    if ((paramamfs1 == null) && (paramamfs2 == null)) {
      return 0;
    }
    if (paramamfs1 == null) {
      return -1;
    }
    if (paramamfs2 == null) {
      return 1;
    }
    if (a(paramamfs1) == a(paramamfs2)) {
      return (int)(a(paramamfs2) - a(paramamfs1));
    }
    return a(paramamfs1) - a(paramamfs2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfq
 * JD-Core Version:    0.7.0.1
 */