import com.tencent.mobileqq.search.mostused.MostUsedSearchItem;
import java.util.Comparator;

final class awpv
  implements Comparator<awpx>
{
  public int a(awpx paramawpx1, awpx paramawpx2)
  {
    int j = Long.signum(paramawpx2.jdField_a_of_type_Int - paramawpx1.jdField_a_of_type_Int);
    int i = j;
    if (j == 0) {
      i = Long.signum(paramawpx2.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.timeStamp - paramawpx1.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.timeStamp);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awpv
 * JD-Core Version:    0.7.0.1
 */