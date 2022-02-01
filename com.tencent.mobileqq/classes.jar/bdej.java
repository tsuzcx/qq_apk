import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bdej
{
  public static int a;
  static bdey jdField_a_of_type_Bdey;
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern;
  public static boolean a;
  private static Pattern b;
  public String a;
  public int b;
  public String b;
  public int c;
  
  static
  {
    jdField_a_of_type_Int = 36;
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("[^\n]*(?:\n|[^\n]$)");
    jdField_a_of_type_Boolean = true;
  }
  
  static int a(String paramString)
  {
    return Integer.parseInt(paramString, bdfn.jdField_a_of_type_Int);
  }
  
  public static bdee a(bdee parambdee)
  {
    return new bdee(parambdee.jdField_a_of_type_JavaLangString, parambdee.jdField_b_of_type_JavaLangString);
  }
  
  public static bdee a(String paramString, bdee parambdee, bdef parambdef)
  {
    return new bdee(a(paramString, parambdee.jdField_a_of_type_JavaLangString), a(paramString, parambdee.jdField_b_of_type_JavaLangString, parambdef));
  }
  
  public static bdee a(String paramString1, String paramString2)
  {
    if (!bdfn.a(paramString2)) {}
    for (;;)
    {
      return new bdee(paramString1, paramString2);
      paramString2 = b(paramString1);
    }
  }
  
  public static bdee a(String paramString, List<Pair<String, String>> paramList, bdef parambdef)
  {
    bdfg localbdfg = new bdfg();
    localbdfg.a('+', paramString, paramList, parambdef);
    return new bdee(paramString, localbdfg.toString());
  }
  
  static bdei a(Pair<String, String> paramPair, bdef parambdef)
  {
    bder localbder = new bder();
    if (parambdef == null) {}
    int i;
    do
    {
      return localbder;
      i = parambdef.a(paramPair, true);
    } while (i < 0);
    return new bdes(Pattern.compile("\\*" + a(i) + "(?!\\w)"));
  }
  
  public static bdej a(String paramString)
  {
    int i = 1;
    bdej localbdej = new bdej();
    if (jdField_a_of_type_Boolean)
    {
      if (jdField_a_of_type_Bdey == null) {
        jdField_a_of_type_Bdey = new bdey();
      }
      for (;;)
      {
        jdField_a_of_type_Bdey.a(paramString);
        localbdej.c = jdField_a_of_type_Bdey.c;
        localbdej.jdField_b_of_type_Int = jdField_a_of_type_Bdey.jdField_b_of_type_Int;
        i = jdField_a_of_type_Bdey.jdField_a_of_type_Int;
        int k = paramString.indexOf("$");
        int j = k;
        if (k < 0) {
          j = paramString.length();
        }
        localbdej.jdField_a_of_type_JavaLangString = paramString.substring(i, j);
        localbdej.jdField_b_of_type_JavaLangString = paramString.substring(j + 1);
        return localbdej;
        jdField_a_of_type_Bdey.a();
      }
    }
    if (jdField_b_of_type_JavaUtilRegexPattern == null) {
      jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("Z:([0-9a-z]+)([><])([0-9a-z]+)|");
    }
    Matcher localMatcher = jdField_b_of_type_JavaUtilRegexPattern.matcher(paramString);
    if ((!localMatcher.find()) || (localMatcher.group().length() == 0)) {
      throw new IllegalArgumentException("Not a exports: " + paramString);
    }
    localbdej.jdField_b_of_type_Int = a(localMatcher.group(1));
    if (">".equals(localMatcher.group(2))) {}
    for (;;)
    {
      localbdej.c = (i * a(localMatcher.group(3)) + localbdej.jdField_b_of_type_Int);
      i = localMatcher.group().length();
      break;
      i = -1;
    }
  }
  
  public static bdew a(String paramString, bdef parambdef)
  {
    bdef localbdef = new bdef();
    return new bdew(a(paramString, parambdef, localbdef), localbdef);
  }
  
  public static bdfd a(char paramChar)
  {
    bdfd localbdfd = new bdfd();
    localbdfd.jdField_a_of_type_Char = paramChar;
    return localbdfd;
  }
  
  public static String a(char paramChar, List<Pair<String, String>> paramList, bdef parambdef)
  {
    if ((parambdef == null) || (paramList == null) || (paramList.size() <= 0)) {
      return "";
    }
    Object localObject = paramList;
    if (paramList.size() > 1)
    {
      localObject = new ArrayList(paramList);
      Collections.sort((List)localObject, new bdfl());
    }
    paramList = new StringBuilder();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Pair localPair = (Pair)((Iterator)localObject).next();
      if ((paramChar == '=') || ((paramChar == '+') && (!bdfn.a((String)localPair.second)))) {
        paramList.append('*').append(a(parambdef.a(localPair)));
      }
    }
    return paramList.toString();
  }
  
  static String a(int paramInt)
  {
    return Integer.toString(paramInt, bdfn.jdField_a_of_type_Int);
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    paramInt2 -= paramInt1;
    if (paramInt2 >= 0) {}
    for (String str = '>' + a(paramInt2);; str = '<' + a(-paramInt2)) {
      return String.valueOf('Z') + ':' + a(paramInt1) + str + paramString1 + "$" + paramString2;
    }
  }
  
  public static String a(String paramString)
  {
    Object localObject1 = a(paramString);
    int m = ((bdej)localObject1).jdField_b_of_type_Int;
    int n = ((bdej)localObject1).c;
    Object localObject2 = ((bdej)localObject1).jdField_a_of_type_JavaLangString;
    localObject1 = ((bdej)localObject1).jdField_b_of_type_JavaLangString;
    bdfg localbdfg = new bdfg();
    localObject2 = a((String)localObject2);
    int j = 0;
    int i = 0;
    int k = 0;
    if (((Iterator)localObject2).hasNext())
    {
      bdfd localbdfd = (bdfd)((Iterator)localObject2).next();
      switch (localbdfd.jdField_a_of_type_Char)
      {
      default: 
      case '=': 
        for (;;)
        {
          localbdfg.a(localbdfd);
          break;
          j += localbdfd.jdField_a_of_type_Int;
          i += localbdfd.jdField_a_of_type_Int;
        }
      case '-': 
        j = localbdfd.jdField_a_of_type_Int + j;
        if (j <= m) {}
        for (bool = true;; bool = false)
        {
          a(bool, new Object[] { Integer.valueOf(j), " > ", Integer.valueOf(m), " in ", paramString });
          break;
        }
      }
      i = localbdfd.jdField_a_of_type_Int + i;
      int i1 = localbdfd.jdField_a_of_type_Int;
      if (i <= n) {}
      for (boolean bool = true;; bool = false)
      {
        a(bool, new Object[] { Integer.valueOf(i), " > ", Integer.valueOf(n), " in ", paramString });
        k = i1 + k;
        break;
      }
    }
    for (localObject1 = ((String)localObject1).substring(0, k); ((String)localObject1).length() < k; localObject1 = (String)localObject1 + "?") {}
    localbdfg.a();
    a(a(m, i + (m - j), localbdfg.toString(), (String)localObject1).equals(paramString), new Object[] { "Invalid changeset (checkRep failed)" });
    return paramString;
  }
  
  public static String a(String paramString1, int paramInt1, String paramString2, int paramInt2, bdfc parambdfc)
  {
    Iterator localIterator1 = a(paramString1, paramInt1);
    Iterator localIterator2 = a(paramString2, paramInt2);
    bdfg localbdfg = new bdfg();
    paramString1 = new bdfd();
    paramString2 = new bdfd();
    bdfd localbdfd = new bdfd();
    if ((paramString1.jdField_a_of_type_Char != 0) || (localIterator1.hasNext()) || (paramString2.jdField_a_of_type_Char != 0) || (localIterator2.hasNext()))
    {
      if ((paramString1.jdField_a_of_type_Char != 0) || (!localIterator1.hasNext())) {
        break label190;
      }
      paramString1 = (bdfd)localIterator1.next();
    }
    label190:
    for (;;)
    {
      if ((paramString2.jdField_a_of_type_Char == 0) && (localIterator2.hasNext())) {
        paramString2 = (bdfd)localIterator2.next();
      }
      for (;;)
      {
        parambdfc.a(paramString1, paramString2, localbdfd);
        if (localbdfd.jdField_a_of_type_Char != 0)
        {
          localbdfg.a(localbdfd);
          localbdfd.jdField_a_of_type_Char = '\000';
          break;
          localbdfg.a();
          return localbdfg.toString();
        }
        break;
      }
    }
  }
  
  public static String a(String paramString, bdef parambdef1, bdef parambdef2)
  {
    int j = paramString.indexOf('$');
    int i = j;
    if (j < 0) {
      i = paramString.length();
    }
    String str = paramString.substring(0, i);
    paramString = paramString.substring(i);
    return bdfn.a(str, "\\*([0-9a-z]+)", new bdet(parambdef1, parambdef2)) + paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject = a(paramString1);
    boolean bool;
    StringBuilder localStringBuilder;
    if (paramString2.length() == ((bdej)localObject).jdField_b_of_type_Int)
    {
      bool = true;
      a(bool, new Object[] { "mismatched apply: ", Integer.valueOf(paramString2.length()), " / ", Integer.valueOf(((bdej)localObject).jdField_b_of_type_Int) });
      paramString1 = a(((bdej)localObject).jdField_a_of_type_JavaLangString);
      localObject = new bdfi(((bdej)localObject).jdField_b_of_type_JavaLangString);
      paramString2 = new bdfi(paramString2);
      localStringBuilder = new StringBuilder();
    }
    for (;;)
    {
      if (!paramString1.hasNext()) {
        break label212;
      }
      bdfd localbdfd = (bdfd)paramString1.next();
      switch (localbdfd.jdField_a_of_type_Char)
      {
      default: 
        break;
      case '+': 
        localStringBuilder.append(((bdfi)localObject).a(localbdfd.jdField_a_of_type_Int));
        continue;
        bool = false;
        break;
      case '-': 
        paramString2.a(localbdfd.jdField_a_of_type_Int);
        break;
      case '=': 
        localStringBuilder.append(paramString2.a(localbdfd.jdField_a_of_type_Int));
      }
    }
    label212:
    localStringBuilder.append(paramString2.a(paramString2.a()));
    return localStringBuilder.toString();
  }
  
  static String a(String paramString1, String paramString2, bdef parambdef)
  {
    return a(paramString2, 0, a(paramString1).jdField_a_of_type_JavaLangString, 0, new bdep(parambdef));
  }
  
  static String a(String paramString1, String paramString2, boolean paramBoolean, bdef parambdef)
  {
    if ((bdfn.a(paramString1)) && (paramBoolean)) {
      return paramString2;
    }
    if (bdfn.a(paramString2)) {
      return paramString1;
    }
    ArrayList localArrayList = new ArrayList();
    bdfn.a(paramString1, "\\*([0-9a-z]+)", new bdek(localArrayList, parambdef));
    bdfn.a(paramString2, "\\*([0-9a-z]+)", new bdeo(parambdef, localArrayList, paramBoolean));
    Collections.sort(localArrayList, new bdfl());
    paramString1 = new StringBuilder();
    int i = 0;
    while (i < localArrayList.size())
    {
      paramString1.append('*');
      paramString1.append(a(parambdef.a((Pair)localArrayList.get(i))));
      i += 1;
    }
    return paramString1.toString();
  }
  
  public static Iterator<bdfd> a(String paramString)
  {
    return a(paramString, 0);
  }
  
  public static Iterator<bdfd> a(String paramString, int paramInt)
  {
    return new bdfe(paramString.substring(paramInt));
  }
  
  public static List<bdfh> a(String paramString)
  {
    Object localObject1 = a(paramString);
    paramString = new ArrayList();
    Iterator localIterator = a(((bdej)localObject1).jdField_a_of_type_JavaLangString);
    localObject1 = new bdfi(((bdej)localObject1).jdField_b_of_type_JavaLangString);
    int i = 0;
    int j = 0;
    bdfd localbdfd;
    int k;
    while (localIterator.hasNext())
    {
      localbdfd = (bdfd)localIterator.next();
      if (localbdfd.jdField_a_of_type_Char == '=')
      {
        k = localbdfd.jdField_a_of_type_Int;
        i = 0;
        j += k;
      }
      else
      {
        if (i != 0) {
          break label249;
        }
        paramString.add(new bdfh(j, j, ""));
        i = 1;
      }
    }
    label249:
    for (;;)
    {
      Object localObject2;
      if (localbdfd.jdField_a_of_type_Char == '-')
      {
        k = localbdfd.jdField_a_of_type_Int;
        localObject2 = (bdfh)paramString.get(paramString.size() - 1);
        int m = ((bdfh)localObject2).jdField_b_of_type_Int;
        ((bdfh)localObject2).jdField_b_of_type_Int = (localbdfd.jdField_a_of_type_Int + m);
        j += k;
        break;
      }
      if (localbdfd.jdField_a_of_type_Char == '+')
      {
        localObject2 = new StringBuilder();
        bdfh localbdfh = (bdfh)paramString.get(paramString.size() - 1);
        localbdfh.jdField_a_of_type_JavaLangString += ((bdfi)localObject1).a(localbdfd.jdField_a_of_type_Int);
      }
      break;
      return paramString;
    }
  }
  
  public static void a(bdfd parambdfd)
  {
    parambdfd.jdField_a_of_type_Char = '\000';
    parambdfd.jdField_a_of_type_Int = 0;
    parambdfd.jdField_b_of_type_Int = 0;
    parambdfd.jdField_a_of_type_JavaLangString = "";
  }
  
  public static void a(bdfd parambdfd1, bdfd parambdfd2)
  {
    parambdfd2.jdField_a_of_type_Char = parambdfd1.jdField_a_of_type_Char;
    parambdfd2.jdField_a_of_type_Int = parambdfd1.jdField_a_of_type_Int;
    parambdfd2.jdField_b_of_type_Int = parambdfd1.jdField_b_of_type_Int;
    parambdfd2.jdField_a_of_type_JavaLangString = parambdfd1.jdField_a_of_type_JavaLangString;
  }
  
  static void a(bdfd parambdfd1, bdfd parambdfd2, bdfd parambdfd3, @NonNull bdef parambdef)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (parambdfd1.jdField_a_of_type_Char == '-')
    {
      a(parambdfd1, parambdfd3);
      parambdfd1.jdField_a_of_type_Char = '\000';
    }
    do
    {
      return;
      if (parambdfd1.jdField_a_of_type_Char == 0)
      {
        a(parambdfd2, parambdfd3);
        parambdfd2.jdField_a_of_type_Char = '\000';
        return;
      }
      switch (parambdfd2.jdField_a_of_type_Char)
      {
      default: 
        return;
      case '\000': 
        a(parambdfd1, parambdfd3);
        parambdfd1.jdField_a_of_type_Char = '\000';
        return;
      case '-': 
        if (parambdfd2.jdField_a_of_type_Int > parambdfd1.jdField_a_of_type_Int) {
          break label196;
        }
        if (parambdfd1.jdField_a_of_type_Char == '=')
        {
          parambdfd3.jdField_a_of_type_Char = '-';
          parambdfd3.jdField_a_of_type_Int = parambdfd2.jdField_a_of_type_Int;
          parambdfd3.jdField_b_of_type_Int = parambdfd2.jdField_b_of_type_Int;
          parambdfd3.jdField_a_of_type_JavaLangString = "";
        }
        parambdfd1.jdField_a_of_type_Int -= parambdfd2.jdField_a_of_type_Int;
        parambdfd1.jdField_b_of_type_Int -= parambdfd2.jdField_b_of_type_Int;
        parambdfd2.jdField_a_of_type_Char = '\000';
      }
    } while (parambdfd1.jdField_a_of_type_Int != 0);
    parambdfd1.jdField_a_of_type_Char = '\000';
    return;
    label196:
    if (parambdfd1.jdField_a_of_type_Char == '=')
    {
      parambdfd3.jdField_a_of_type_Char = '-';
      parambdfd3.jdField_a_of_type_Int = parambdfd1.jdField_a_of_type_Int;
      parambdfd3.jdField_b_of_type_Int = parambdfd1.jdField_b_of_type_Int;
      parambdfd3.jdField_a_of_type_JavaLangString = "";
    }
    parambdfd2.jdField_a_of_type_Int -= parambdfd1.jdField_a_of_type_Int;
    parambdfd2.jdField_b_of_type_Int -= parambdfd1.jdField_b_of_type_Int;
    parambdfd1.jdField_a_of_type_Char = '\000';
    return;
    a(parambdfd2, parambdfd3);
    parambdfd2.jdField_a_of_type_Char = '\000';
    return;
    if (parambdfd2.jdField_a_of_type_Int <= parambdfd1.jdField_a_of_type_Int)
    {
      parambdfd3.jdField_a_of_type_Char = parambdfd1.jdField_a_of_type_Char;
      parambdfd3.jdField_a_of_type_Int = parambdfd2.jdField_a_of_type_Int;
      parambdfd3.jdField_b_of_type_Int = parambdfd2.jdField_b_of_type_Int;
      str1 = parambdfd1.jdField_a_of_type_JavaLangString;
      str2 = parambdfd2.jdField_a_of_type_JavaLangString;
      if (parambdfd1.jdField_a_of_type_Char == '=') {}
      for (;;)
      {
        parambdfd3.jdField_a_of_type_JavaLangString = a(str1, str2, bool1, parambdef);
        parambdfd2.jdField_a_of_type_Char = '\000';
        parambdfd1.jdField_a_of_type_Int -= parambdfd2.jdField_a_of_type_Int;
        parambdfd1.jdField_b_of_type_Int -= parambdfd2.jdField_b_of_type_Int;
        if (parambdfd1.jdField_a_of_type_Int != 0) {
          break;
        }
        parambdfd1.jdField_a_of_type_Char = '\000';
        return;
        bool1 = false;
      }
    }
    parambdfd3.jdField_a_of_type_Char = parambdfd1.jdField_a_of_type_Char;
    parambdfd3.jdField_a_of_type_Int = parambdfd1.jdField_a_of_type_Int;
    parambdfd3.jdField_b_of_type_Int = parambdfd1.jdField_b_of_type_Int;
    String str1 = parambdfd1.jdField_a_of_type_JavaLangString;
    String str2 = parambdfd2.jdField_a_of_type_JavaLangString;
    if (parambdfd1.jdField_a_of_type_Char == '=') {}
    for (bool1 = bool2;; bool1 = false)
    {
      parambdfd3.jdField_a_of_type_JavaLangString = a(str1, str2, bool1, parambdef);
      parambdfd1.jdField_a_of_type_Char = '\000';
      parambdfd2.jdField_a_of_type_Int -= parambdfd1.jdField_a_of_type_Int;
      parambdfd2.jdField_b_of_type_Int -= parambdfd1.jdField_b_of_type_Int;
      return;
    }
  }
  
  static void a(boolean paramBoolean, Object... paramVarArgs)
  {
    if (!paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder("Changeset: ");
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(paramVarArgs[i]);
        i += 1;
      }
      throw new RuntimeException(localStringBuilder.toString());
    }
  }
  
  public static boolean a(String paramString)
  {
    paramString = a(paramString);
    return ("".equals(paramString.jdField_a_of_type_JavaLangString)) && (paramString.jdField_b_of_type_Int == paramString.c);
  }
  
  public static int[] a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramString = a(paramString).iterator();
    int j = 0;
    int k = paramInt2;
    int m = paramInt1;
    if (paramString.hasNext())
    {
      bdfh localbdfh = (bdfh)paramString.next();
      int i = localbdfh.jdField_a_of_type_Int + j;
      int i1 = localbdfh.jdField_b_of_type_Int + j;
      int i2 = localbdfh.jdField_a_of_type_JavaLangString.length();
      int n = i2 - (i1 - i);
      if ((i <= m) && (i1 >= k)) {
        if (paramBoolean)
        {
          paramInt1 = i;
          paramInt2 = i;
        }
      }
      for (;;)
      {
        j += n;
        m = paramInt2;
        k = paramInt1;
        break;
        paramInt1 = i + i2;
        paramInt2 = paramInt1;
        continue;
        if (i1 <= m)
        {
          paramInt2 = m + n;
          paramInt1 = k + n;
        }
        else
        {
          paramInt2 = m;
          paramInt1 = k;
          if (i < k) {
            if ((i >= m) && (i1 <= k))
            {
              paramInt1 = k + n;
              paramInt2 = m;
            }
            else if (i1 < k)
            {
              paramInt2 = i + i2;
              paramInt1 = k + n;
            }
            else
            {
              paramInt1 = i;
              paramInt2 = m;
            }
          }
        }
      }
    }
    return new int[] { m, k };
  }
  
  public static int b(String paramString)
  {
    return a(paramString).c;
  }
  
  public static String b(int paramInt)
  {
    return a(paramInt, paramInt, "", "");
  }
  
  public static String b(String paramString)
  {
    bdfg localbdfg = new bdfg();
    localbdfg.a('+', paramString);
    return localbdfg.toString();
  }
  
  public static String b(String paramString1, String paramString2, bdef parambdef)
  {
    paramString1 = a(paramString1);
    paramString2 = a(paramString2);
    int i = paramString1.jdField_b_of_type_Int;
    if (paramString1.c == paramString2.jdField_b_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, new Object[] { "mismatched composition" });
      int j = paramString2.c;
      bdfi localbdfi1 = new bdfi(paramString1.jdField_b_of_type_JavaLangString);
      bdfi localbdfi2 = new bdfi(paramString2.jdField_b_of_type_JavaLangString);
      StringBuilder localStringBuilder = new StringBuilder();
      return a(i, j, a(paramString1.jdField_a_of_type_JavaLangString, 0, paramString2.jdField_a_of_type_JavaLangString, 0, new bdeq(localbdfi1, parambdef, localStringBuilder, localbdfi2)), localStringBuilder.toString());
    }
  }
  
  public static String b(String paramString1, String paramString2, boolean paramBoolean, bdef parambdef)
  {
    bdej localbdej2 = a(paramString1);
    bdej localbdej1 = a(paramString2);
    if (localbdej2.jdField_b_of_type_Int == localbdej1.jdField_b_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, new Object[] { "mismatched follow:" + paramString1 + " " + paramString2 });
      bdfi localbdfi1 = new bdfi(localbdej2.jdField_b_of_type_JavaLangString);
      bdfi localbdfi2 = new bdfi(localbdej1.jdField_b_of_type_JavaLangString);
      int i = localbdej2.c;
      paramString1 = new int[1];
      paramString2 = new int[1];
      bdei localbdei = a(new Pair("insertorder", "first"), parambdef);
      parambdef = a(localbdej2.jdField_a_of_type_JavaLangString, 0, localbdej1.jdField_a_of_type_JavaLangString, 0, new bdel(localbdfi1, localbdfi2, localbdei, paramBoolean, parambdef, paramString1, paramString2));
      paramString2[0] += i - paramString1[0];
      return a(i, paramString2[0], parambdef, localbdej1.jdField_b_of_type_JavaLangString);
    }
  }
  
  private static void b(bdfd parambdfd1, bdfd parambdfd2, bdfd parambdfd3)
  {
    a(parambdfd2, parambdfd3);
    if (parambdfd1.jdField_a_of_type_Char == 0) {
      parambdfd2.jdField_a_of_type_Char = '\000';
    }
    do
    {
      return;
      if (parambdfd2.jdField_a_of_type_Int > parambdfd1.jdField_a_of_type_Int) {
        break;
      }
      parambdfd1.jdField_a_of_type_Int -= parambdfd2.jdField_a_of_type_Int;
      parambdfd1.jdField_b_of_type_Int -= parambdfd2.jdField_b_of_type_Int;
      parambdfd2.jdField_a_of_type_Char = '\000';
    } while (parambdfd1.jdField_a_of_type_Int != 0);
    parambdfd1.jdField_a_of_type_Char = '\000';
    return;
    parambdfd3.jdField_b_of_type_Int = parambdfd1.jdField_b_of_type_Int;
    parambdfd3.jdField_a_of_type_Int = parambdfd1.jdField_a_of_type_Int;
    parambdfd2.jdField_b_of_type_Int -= parambdfd1.jdField_b_of_type_Int;
    parambdfd2.jdField_a_of_type_Int -= parambdfd1.jdField_a_of_type_Int;
    parambdfd1.jdField_a_of_type_Char = '\000';
  }
  
  private static void b(bdfd parambdfd1, bdfd parambdfd2, bdfd parambdfd3, bdfi parambdfi1, bdfi parambdfi2, bdei parambdei, boolean paramBoolean)
  {
    int j = 2;
    int i;
    if (parambdfd2.jdField_a_of_type_Char != '+') {
      i = 1;
    }
    while (i == 1)
    {
      parambdfi1.a(parambdfd1.jdField_a_of_type_Int);
      parambdfd3.jdField_a_of_type_Char = '=';
      parambdfd3.jdField_b_of_type_Int = parambdfd1.jdField_b_of_type_Int;
      parambdfd3.jdField_a_of_type_Int = parambdfd1.jdField_a_of_type_Int;
      parambdfd3.jdField_a_of_type_JavaLangString = "";
      parambdfd1.jdField_a_of_type_Char = '\000';
      return;
      i = j;
      if (parambdfd1.jdField_a_of_type_Char == '+')
      {
        String str1 = parambdfi1.b(1);
        String str2 = parambdfi2.b(1);
        boolean bool1 = parambdei.a(parambdfd1.jdField_a_of_type_JavaLangString);
        boolean bool2 = parambdei.a(parambdfd2.jdField_a_of_type_JavaLangString);
        if ((bool1) && (!bool2))
        {
          i = 1;
        }
        else if (bool2)
        {
          i = j;
          if (!bool1) {}
        }
        else if (str1.equals("\n"))
        {
          i = j;
          if (!str2.equals("\n")) {}
        }
        else if ((!str1.equals("\n")) && (str2.equals("\n")))
        {
          i = 1;
        }
        else
        {
          i = j;
          if (!paramBoolean) {
            i = 1;
          }
        }
      }
    }
    parambdfi2.a(parambdfd2.jdField_a_of_type_Int);
    a(parambdfd2, parambdfd3);
    parambdfd2.jdField_a_of_type_Char = '\000';
  }
  
  public static String c(String paramString1, String paramString2, bdef parambdef)
  {
    if ((bdfn.a(paramString2)) || (parambdef == null)) {
      localObject = "";
    }
    do
    {
      return localObject;
      localObject = paramString2;
    } while (bdfn.a(paramString1));
    Object localObject = new ArrayList();
    bdfn.a(paramString2, "\\*([0-9a-z]+)", new bdem((List)localObject, parambdef));
    bdfn.a(paramString1, "\\*([0-9a-z]+)", new bden(parambdef, (List)localObject));
    paramString1 = new StringBuilder();
    int i = 0;
    while (i < ((List)localObject).size())
    {
      paramString1.append('*');
      paramString1.append(a(parambdef.a((Pair)((List)localObject).get(i))));
      i += 1;
    }
    return paramString1.toString();
  }
  
  private static void c(bdfd parambdfd1, bdfd parambdfd2)
  {
    if (parambdfd2.jdField_a_of_type_Char == 0) {
      parambdfd1.jdField_a_of_type_Char = '\000';
    }
    do
    {
      return;
      if (parambdfd1.jdField_a_of_type_Int > parambdfd2.jdField_a_of_type_Int) {
        break;
      }
      parambdfd2.jdField_a_of_type_Int -= parambdfd1.jdField_a_of_type_Int;
      parambdfd2.jdField_b_of_type_Int -= parambdfd1.jdField_b_of_type_Int;
      parambdfd1.jdField_a_of_type_Char = '\000';
    } while (parambdfd2.jdField_a_of_type_Int > 0);
    parambdfd2.jdField_a_of_type_Char = '\000';
    return;
    parambdfd1.jdField_a_of_type_Int -= parambdfd2.jdField_a_of_type_Int;
    parambdfd1.jdField_b_of_type_Int -= parambdfd2.jdField_b_of_type_Int;
    parambdfd2.jdField_a_of_type_Char = '\000';
  }
  
  private static void c(bdfd parambdfd1, bdfd parambdfd2, bdfd parambdfd3, bdef parambdef)
  {
    parambdfd3.jdField_a_of_type_Char = '=';
    parambdfd3.jdField_a_of_type_JavaLangString = c(parambdfd1.jdField_a_of_type_JavaLangString, parambdfd2.jdField_a_of_type_JavaLangString, parambdef);
    if (parambdfd1.jdField_a_of_type_Int <= parambdfd2.jdField_a_of_type_Int)
    {
      parambdfd3.jdField_a_of_type_Int = parambdfd1.jdField_a_of_type_Int;
      parambdfd3.jdField_b_of_type_Int = parambdfd1.jdField_b_of_type_Int;
      parambdfd2.jdField_a_of_type_Int -= parambdfd1.jdField_a_of_type_Int;
      parambdfd2.jdField_b_of_type_Int -= parambdfd1.jdField_b_of_type_Int;
      parambdfd1.jdField_a_of_type_Char = '\000';
      if (parambdfd2.jdField_a_of_type_Int == 0) {
        parambdfd2.jdField_a_of_type_Char = '\000';
      }
      return;
    }
    parambdfd3.jdField_a_of_type_Int = parambdfd2.jdField_a_of_type_Int;
    parambdfd3.jdField_b_of_type_Int = parambdfd2.jdField_b_of_type_Int;
    parambdfd1.jdField_a_of_type_Int -= parambdfd2.jdField_a_of_type_Int;
    parambdfd1.jdField_b_of_type_Int -= parambdfd2.jdField_b_of_type_Int;
    parambdfd2.jdField_a_of_type_Char = '\000';
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof bdej)) {
        return false;
      }
      paramObject = (bdej)paramObject;
    } while ((this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int) && (this.c == paramObject.c) && (bdfn.a(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (bdfn.a(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)));
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.c), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString });
  }
  
  @NonNull
  public String toString()
  {
    return "[Changeset@" + hashCode() + "]: oldLen: " + this.jdField_b_of_type_Int + ", newLen: " + this.c + ", ops: " + this.jdField_a_of_type_JavaLangString + ", charBank: " + this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdej
 * JD-Core Version:    0.7.0.1
 */