import com.tencent.mobileqq.search.mostused.MostUsedSearchItem;
import java.util.Comparator;

final class ayph
  implements Comparator<aypj>
{
  public int a(aypj paramaypj1, aypj paramaypj2)
  {
    int j = Long.signum(paramaypj2.jdField_a_of_type_Int - paramaypj1.jdField_a_of_type_Int);
    int i = j;
    if (j == 0) {
      i = Long.signum(paramaypj2.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.timeStamp - paramaypj1.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.timeStamp);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayph
 * JD-Core Version:    0.7.0.1
 */