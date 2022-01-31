import com.tencent.mobileqq.search.mostused.MostUsedSearchItem;
import java.util.Comparator;

final class avqa
  implements Comparator<avqc>
{
  public int a(avqc paramavqc1, avqc paramavqc2)
  {
    int j = Long.signum(paramavqc2.jdField_a_of_type_Int - paramavqc1.jdField_a_of_type_Int);
    int i = j;
    if (j == 0) {
      i = Long.signum(paramavqc2.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.timeStamp - paramavqc1.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.timeStamp);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqa
 * JD-Core Version:    0.7.0.1
 */