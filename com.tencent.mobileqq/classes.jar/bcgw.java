import com.tencent.mobileqq.search.mostused.MostUsedSearchItem;
import java.util.Comparator;

final class bcgw
  implements Comparator<bcgy>
{
  public int a(bcgy parambcgy1, bcgy parambcgy2)
  {
    int j = Long.signum(parambcgy2.jdField_a_of_type_Int - parambcgy1.jdField_a_of_type_Int);
    int i = j;
    if (j == 0) {
      i = Long.signum(parambcgy2.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.timeStamp - parambcgy1.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.timeStamp);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcgw
 * JD-Core Version:    0.7.0.1
 */