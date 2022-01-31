import com.tencent.mobileqq.search.mostused.MostUsedSearchItem;
import java.util.Comparator;

final class awpt
  implements Comparator<awpv>
{
  public int a(awpv paramawpv1, awpv paramawpv2)
  {
    int j = Long.signum(paramawpv2.jdField_a_of_type_Int - paramawpv1.jdField_a_of_type_Int);
    int i = j;
    if (j == 0) {
      i = Long.signum(paramawpv2.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.timeStamp - paramawpv1.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.timeStamp);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awpt
 * JD-Core Version:    0.7.0.1
 */