import com.tencent.mobileqq.search.mostused.MostUsedSearchItem;
import java.util.Comparator;

final class bbol
  implements Comparator<bbon>
{
  public int a(bbon parambbon1, bbon parambbon2)
  {
    int j = Long.signum(parambbon2.jdField_a_of_type_Int - parambbon1.jdField_a_of_type_Int);
    int i = j;
    if (j == 0) {
      i = Long.signum(parambbon2.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.timeStamp - parambbon1.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.timeStamp);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbol
 * JD-Core Version:    0.7.0.1
 */