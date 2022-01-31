import com.tencent.mobileqq.search.mostused.MostUsedSearchItem;
import java.util.Comparator;

final class ayky
  implements Comparator<ayla>
{
  public int a(ayla paramayla1, ayla paramayla2)
  {
    int j = Long.signum(paramayla2.jdField_a_of_type_Int - paramayla1.jdField_a_of_type_Int);
    int i = j;
    if (j == 0) {
      i = Long.signum(paramayla2.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.timeStamp - paramayla1.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.timeStamp);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayky
 * JD-Core Version:    0.7.0.1
 */