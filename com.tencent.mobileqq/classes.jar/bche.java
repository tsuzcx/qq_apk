import com.tencent.mobileqq.search.mostused.MostUsedSearchItem;
import java.util.Comparator;

final class bche
  implements Comparator<bchg>
{
  public int a(bchg parambchg1, bchg parambchg2)
  {
    int j = Long.signum(parambchg2.jdField_a_of_type_Int - parambchg1.jdField_a_of_type_Int);
    int i = j;
    if (j == 0) {
      i = Long.signum(parambchg2.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.timeStamp - parambchg1.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.timeStamp);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bche
 * JD-Core Version:    0.7.0.1
 */