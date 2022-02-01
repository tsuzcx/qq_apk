import com.tencent.util.Pair;
import java.util.List;
import java.util.regex.Matcher;

final class belr
  implements bemp
{
  belr(beli parambeli, List paramList, boolean paramBoolean) {}
  
  public String a(Matcher paramMatcher)
  {
    int k = 0;
    Pair localPair = this.jdField_a_of_type_Beli.a(belm.a(paramMatcher.group(1)));
    if (localPair == null) {
      throw new IllegalArgumentException("can't find attribute: " + paramMatcher.group(1));
    }
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        paramMatcher = (Pair)this.jdField_a_of_type_JavaUtilList.get(i);
        if (!((String)paramMatcher.first).equals(localPair.first)) {
          break label211;
        }
        if ((bemq.a((String)localPair.second)) && (!this.jdField_a_of_type_Boolean)) {
          break label198;
        }
        paramMatcher = new Pair(paramMatcher.first, localPair.second);
        this.jdField_a_of_type_JavaUtilList.set(i, paramMatcher);
      }
      for (;;)
      {
        j = 1;
        if ((j == 0) && ((!bemq.a((String)localPair.second)) || (this.jdField_a_of_type_Boolean))) {
          this.jdField_a_of_type_JavaUtilList.add(localPair);
        }
        return "";
        label198:
        bemq.a(this.jdField_a_of_type_JavaUtilList, i, 1);
      }
      label211:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     belr
 * JD-Core Version:    0.7.0.1
 */