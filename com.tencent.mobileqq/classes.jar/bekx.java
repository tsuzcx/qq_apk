import com.tencent.util.Pair;
import java.util.List;
import java.util.regex.Matcher;

final class bekx
  implements belv
{
  bekx(beko parambeko, List paramList, boolean paramBoolean) {}
  
  public String a(Matcher paramMatcher)
  {
    int k = 0;
    paramMatcher = this.jdField_a_of_type_Beko.a(beks.a(paramMatcher.group(1)));
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        Pair localPair = (Pair)this.jdField_a_of_type_JavaUtilList.get(i);
        if (!((String)localPair.first).equals(paramMatcher.first)) {
          break label174;
        }
        if ((belw.a((String)paramMatcher.second)) && (!this.jdField_a_of_type_Boolean)) {
          break label161;
        }
        localPair = new Pair(localPair.first, paramMatcher.second);
        this.jdField_a_of_type_JavaUtilList.set(i, localPair);
      }
      for (;;)
      {
        j = 1;
        if ((j == 0) && ((!belw.a((String)paramMatcher.second)) || (this.jdField_a_of_type_Boolean))) {
          this.jdField_a_of_type_JavaUtilList.add(paramMatcher);
        }
        return "";
        label161:
        belw.a(this.jdField_a_of_type_JavaUtilList, i, 1);
      }
      label174:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bekx
 * JD-Core Version:    0.7.0.1
 */