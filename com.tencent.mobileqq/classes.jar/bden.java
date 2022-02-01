import com.tencent.util.Pair;
import java.util.List;
import java.util.regex.Matcher;

final class bden
  implements bdfm
{
  bden(bdef parambdef, List paramList) {}
  
  public String a(Matcher paramMatcher)
  {
    paramMatcher = this.jdField_a_of_type_Bdef.a(bdej.a(paramMatcher.group(1)));
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
          bdfn.a(this.jdField_a_of_type_JavaUtilList, i, 1);
        }
      }
      return "";
      label95:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bden
 * JD-Core Version:    0.7.0.1
 */