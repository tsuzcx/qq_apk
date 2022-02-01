import android.util.Log;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

public class aumy
{
  public static final int a;
  public static String a;
  public static final Pattern a;
  public static int b;
  public static final Pattern b;
  public static int c;
  public static final Pattern c;
  public static int d;
  public static final Pattern d;
  public static int e;
  public static final Pattern e;
  public static int f;
  public static final Pattern f;
  public static final Pattern g;
  public static final Pattern h;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QcircleFlutterTextCellParser";
    jdField_a_of_type_Int = ViewUtils.dip2px(17.0F);
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("@?\\{uin:\\d+,nick(name)?:.*?\\}");
    jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("\\{url:(.*?),text:(.*?),color:(.*?)\\}");
    jdField_c_of_type_JavaUtilRegexPattern = Pattern.compile("\\{url:.*?,text:.*?\\}");
    jdField_d_of_type_JavaUtilRegexPattern = Pattern.compile("\\<uin:.*?,nick(name)?:.*?\\>");
    jdField_e_of_type_JavaUtilRegexPattern = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]");
    jdField_f_of_type_JavaUtilRegexPattern = Pattern.compile("\\{text:.*?,color:.*?\\}");
    g = Pattern.compile("\\{img:.*?,w:\\d+,h:\\d+\\}");
    h = Pattern.compile("\\{img:.*?,w:\\d+,h:.+?\\}");
    jdField_c_of_type_Int = 1;
    jdField_d_of_type_Int = 2;
    jdField_e_of_type_Int = 3;
    jdField_f_of_type_Int = 4;
  }
  
  public static ArrayList<HashMap<String, Object>> a(CharSequence paramCharSequence)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList(5);
    localArrayList2.add(new aumz(jdField_a_of_type_JavaUtilRegexPattern));
    localArrayList2.add(new auna(jdField_e_of_type_JavaUtilRegexPattern));
    Object localObject1 = localArrayList2.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((aunb)((Iterator)localObject1).next()).a(paramCharSequence.toString());
    }
    int k = paramCharSequence.length();
    localObject1 = new StringBuilder(k);
    int i = 0;
    if (i < k)
    {
      Object localObject2 = localArrayList2.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        aunb localaunb = (aunb)((Iterator)localObject2).next();
        if (localaunb.a(i))
        {
          if (((StringBuilder)localObject1).length() > 0)
          {
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("nodeType", Integer.valueOf(jdField_b_of_type_Int));
            ((HashMap)localObject2).put("text", ((StringBuilder)localObject1).toString());
            localArrayList1.add(localObject2);
            ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
          }
          localArrayList1.add(localaunb.a(0, true, paramCharSequence));
          i = localaunb.a() - 1;
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        ((StringBuilder)localObject1).append(paramCharSequence.charAt(i));
      }
      i += 1;
      break;
      if (((StringBuilder)localObject1).length() > 0)
      {
        paramCharSequence = new HashMap();
        paramCharSequence.put("nodeType", Integer.valueOf(jdField_b_of_type_Int));
        paramCharSequence.put("text", ((StringBuilder)localObject1).toString());
        localArrayList1.add(paramCharSequence);
      }
      Log.d(jdField_a_of_type_JavaLangString, localArrayList1.toString());
      return localArrayList1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumy
 * JD-Core Version:    0.7.0.1
 */