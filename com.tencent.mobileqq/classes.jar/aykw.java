import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class aykw
{
  static String jdField_a_of_type_JavaLangString;
  static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("(?=.*,)(?=.*#)(\\+*[0-9]+[\\-,]*)?(\\([0-9]+\\)[\\-,]*)?([0-9][0-9\\-,][0-9\\-,]+#)");
  public static final String b;
  public static final Pattern b;
  public static final Pattern c;
  static final Pattern d;
  public static final Pattern e;
  public static final Pattern f;
  public static final Pattern g = Pattern.compile(jdField_b_of_type_JavaLangString, 2);
  
  static
  {
    jdField_a_of_type_JavaLangString = "((100)(00|10|11|50|60|86))|(11185)|(12110)|((123)(10|15|18|20|33|36|45|48|51|55|58|61|65|66|69|80|95|98))|((950)(00|01|03|05|06|08|09|10|11|13|15|16|18|19|22|28|29|30|33|50|51|52|53|55|56|57|58|59|61|63|66|70|71|77|78|80|88|90|95|98|99))|((951)(00|01|02|03|05|06|07|08|09|11|13|15|16|17|18|19|21|22|23|28|30|31|32|33|35|37|38|39|48|51|55|58|60|66|68|69|77|78|80|81|85|86|88|90|95|98|99))|((955)(00|01|02|05|08|09|10|11|12|15|16|18|19|22|28|33|55|56|58|59|61|65|66|67|68|69|77|80|85|86|88|89|90|91|95|96|98|99))|((957)(00|01|02|68|77|88|98|99))|((958)(03|08|10|11|15|16|21|22|25|26|27|28|29|30|32|38|39|55|56|59|65|66|68|82|87|88))|((959)(02|06|09|33|50|51|56|59|63|68|69|93|96|98|99))|((96011))|((961)(02|03|10|30|48|56|89|98))|(96315)|(96677)|(96678)|(96822)|(\\+[0-9]+[\\-]*)?(\\([0-9]+\\)[\\-]*)?([0-9][0-9\\-][0-9\\-]+[0-9])";
    jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("[\\d]{5,15}");
    c = Pattern.compile("[\\d,]+");
    d = Pattern.compile("((100)(00|10|11|50|60|86))|(11185)|(12110)|((123)(10|15|18|20|33|36|45|48|51|55|58|61|65|66|69|80|95|98))|((950)(00|01|03|05|06|08|09|10|11|13|15|16|18|19|22|28|29|30|33|50|51|52|53|55|56|57|58|59|61|63|66|70|71|77|78|80|88|90|95|98|99))|((951)(00|01|02|03|05|06|07|08|09|11|13|15|16|17|18|19|21|22|23|28|30|31|32|33|35|37|38|39|48|51|55|58|60|66|68|69|77|78|80|81|85|86|88|90|95|98|99))|((955)(00|01|02|05|08|09|10|11|12|15|16|18|19|22|28|33|55|56|58|59|61|65|66|67|68|69|77|80|85|86|88|89|90|91|95|96|98|99))|((957)(00|01|02|68|77|88|98|99))|((958)(03|08|10|11|15|16|21|22|25|26|27|28|29|30|32|38|39|55|56|59|65|66|68|82|87|88))|((959)(02|06|09|33|50|51|56|59|63|68|69|93|96|98|99))|((96011))|((961)(02|03|10|30|48|56|89|98))|(96315)|(96677)|(96678)|(96822)");
    e = Pattern.compile(jdField_a_of_type_JavaLangString);
    f = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    jdField_b_of_type_JavaLangString = bbff.c.pattern() + "|" + bbff.d.pattern() + "|" + "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+" + "|" + "(?=.*,)(?=.*#)(\\+*[0-9]+[\\-,]*)?(\\([0-9]+\\)[\\-,]*)?([0-9][0-9\\-,][0-9\\-,]+#)" + "|" + "[\\d]{5,15}" + "|" + jdField_a_of_type_JavaLangString;
  }
  
  static List<ayjx> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (a(paramString)) {}
    for (;;)
    {
      return localArrayList;
      if (bbff.jdField_b_of_type_JavaUtilRegexPattern.matcher(paramString).find())
      {
        Matcher localMatcher1 = g.matcher(paramString);
        while (localMatcher1.find())
        {
          int i = localMatcher1.start();
          int j = localMatcher1.end();
          String str = paramString.substring(i, j);
          if (bbff.c.matcher(str).find()) {
            localArrayList.add(new ayjx(str, i, j));
          } else if (bbff.d.matcher(str).find()) {
            localArrayList.add(new ayjx(str, i, j));
          } else if (jdField_a_of_type_JavaUtilRegexPattern.matcher(str).find()) {
            localArrayList.add(new ayjx(str, i, j));
          } else if (c.matcher(str).find())
          {
            if ((j - i >= 5) && (j - i <= 16))
            {
              Matcher localMatcher2 = d.matcher(str);
              if (((j - i != 5) || (localMatcher2.find())) && ((i <= 0) || (!a(paramString.charAt(i - 1)))) && ((j >= paramString.length()) || (!a(paramString.charAt(j))))) {
                localArrayList.add(new ayjx(str, i, j));
              }
            }
          }
          else {
            localArrayList.add(new ayjx(str, i, j));
          }
        }
      }
    }
  }
  
  public static boolean a(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  private static boolean a(String paramString)
  {
    return (paramString == null) || ("".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aykw
 * JD-Core Version:    0.7.0.1
 */