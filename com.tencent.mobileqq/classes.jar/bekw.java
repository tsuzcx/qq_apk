import com.tencent.util.Pair;
import java.util.List;
import java.util.regex.Matcher;

final class bekw
  implements belv
{
  bekw(beko parambeko, List paramList) {}
  
  public String a(Matcher paramMatcher)
  {
    paramMatcher = this.jdField_a_of_type_Beko.a(beks.a(paramMatcher.group(1)));
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        Pair localPair = (Pair)this.jdField_a_of_type_JavaUtilList.get(i);
        if (!((String)paramMatcher.first).equals(localPair.first)) {
          break label95;
        }
        if (((String)paramMatcher.second).compareTo((String)localPair.second) <= 0) {
          belw.a(this.jdField_a_of_type_JavaUtilList, i, 1);
        }
      }
      return "";
      label95:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bekw
 * JD-Core Version:    0.7.0.1
 */