import com.tencent.mobileqq.search.mostused.MostUsedSearchItem;
import java.util.Comparator;

final class bbag
  implements Comparator<bbai>
{
  public int a(bbai parambbai1, bbai parambbai2)
  {
    int j = Long.signum(parambbai2.jdField_a_of_type_Int - parambbai1.jdField_a_of_type_Int);
    int i = j;
    if (j == 0) {
      i = Long.signum(parambbai2.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.timeStamp - parambbai1.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.timeStamp);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbag
 * JD-Core Version:    0.7.0.1
 */