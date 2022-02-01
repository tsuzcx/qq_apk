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

public class beks
{
  public static int a;
  static belh jdField_a_of_type_Belh;
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
    return Integer.parseInt(paramString, belw.jdField_a_of_type_Int);
  }
  
  public static bekn a(bekn parambekn)
  {
    return new bekn(parambekn.jdField_a_of_type_JavaLangString, parambekn.jdField_b_of_type_JavaLangString);
  }
  
  public static bekn a(String paramString, bekn parambekn, beko parambeko)
  {
    return new bekn(a(paramString, parambekn.jdField_a_of_type_JavaLangString), a(paramString, parambekn.jdField_b_of_type_JavaLangString, parambeko));
  }
  
  public static bekn a(String paramString1, String paramString2)
  {
    if (!belw.a(paramString2)) {}
    for (;;)
    {
      return new bekn(paramString1, paramString2);
      paramString2 = b(paramString1);
    }
  }
  
  public static bekn a(String paramString, List<Pair<String, String>> paramList, beko parambeko)
  {
    belp localbelp = new belp();
    localbelp.a('+', paramString, paramList, parambeko);
    return new bekn(paramString, localbelp.toString());
  }
  
  static bekr a(Pair<String, String> paramPair, beko parambeko)
  {
    bela localbela = new bela();
    if (parambeko == null) {}
    int i;
    do
    {
      return localbela;
      i = parambeko.a(paramPair, true);
    } while (i < 0);
    return new belb(Pattern.compile("\\*" + a(i) + "(?!\\w)"));
  }
  
  public static beks a(String paramString)
  {
    int i = 1;
    beks localbeks = new beks();
    if (jdField_a_of_type_Boolean)
    {
      if (jdField_a_of_type_Belh == null) {
        jdField_a_of_type_Belh = new belh();
      }
      for (;;)
      {
        jdField_a_of_type_Belh.a(paramString);
        localbeks.c = jdField_a_of_type_Belh.c;
        localbeks.jdField_b_of_type_Int = jdField_a_of_type_Belh.jdField_b_of_type_Int;
        i = jdField_a_of_type_Belh.jdField_a_of_type_Int;
        int k = paramString.indexOf("$");
        int j = k;
        if (k < 0) {
          j = paramString.length();
        }
        localbeks.jdField_a_of_type_JavaLangString = paramString.substring(i, j);
        localbeks.jdField_b_of_type_JavaLangString = paramString.substring(j + 1);
        return localbeks;
        jdField_a_of_type_Belh.a();
      }
    }
    if (jdField_b_of_type_JavaUtilRegexPattern == null) {
      jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("Z:([0-9a-z]+)([><])([0-9a-z]+)|");
    }
    Matcher localMatcher = jdField_b_of_type_JavaUtilRegexPattern.matcher(paramString);
    if ((!localMatcher.find()) || (localMatcher.group().length() == 0)) {
      throw new IllegalArgumentException("Not a exports: " + paramString);
    }
    localbeks.jdField_b_of_type_Int = a(localMatcher.group(1));
    if (">".equals(localMatcher.group(2))) {}
    for (;;)
    {
      localbeks.c = (i * a(localMatcher.group(3)) + localbeks.jdField_b_of_type_Int);
      i = localMatcher.group().length();
      break;
      i = -1;
    }
  }
  
  public static belf a(String paramString, beko parambeko)
  {
    beko localbeko = new beko();
    return new belf(a(paramString, parambeko, localbeko), localbeko);
  }
  
  public static belm a(char paramChar)
  {
    belm localbelm = new belm();
    localbelm.jdField_a_of_type_Char = paramChar;
    return localbelm;
  }
  
  public static String a(char paramChar, List<Pair<String, String>> paramList, beko parambeko)
  {
    if ((parambeko == null) || (paramList == null) || (paramList.size() <= 0)) {
      return "";
    }
    Object localObject = paramList;
    if (paramList.size() > 1)
    {
      localObject = new ArrayList(paramList);
      Collections.sort((List)localObject, new belu());
    }
    paramList = new StringBuilder();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Pair localPair = (Pair)((Iterator)localObject).next();
      if ((paramChar == '=') || ((paramChar == '+') && (!belw.a((String)localPair.second)))) {
        paramList.append('*').append(a(parambeko.a(localPair)));
      }
    }
    return paramList.toString();
  }
  
  static String a(int paramInt)
  {
    return Integer.toString(paramInt, belw.jdField_a_of_type_Int);
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
    int m = ((beks)localObject1).jdField_b_of_type_Int;
    int n = ((beks)localObject1).c;
    Object localObject2 = ((beks)localObject1).jdField_a_of_type_JavaLangString;
    localObject1 = ((beks)localObject1).jdField_b_of_type_JavaLangString;
    belp localbelp = new belp();
    localObject2 = a((String)localObject2);
    int j = 0;
    int i = 0;
    int k = 0;
    if (((Iterator)localObject2).hasNext())
    {
      belm localbelm = (belm)((Iterator)localObject2).next();
      switch (localbelm.jdField_a_of_type_Char)
      {
      default: 
      case '=': 
        for (;;)
        {
          localbelp.a(localbelm);
          break;
          j += localbelm.jdField_a_of_type_Int;
          i += localbelm.jdField_a_of_type_Int;
        }
      case '-': 
        j = localbelm.jdField_a_of_type_Int + j;
        if (j <= m) {}
        for (bool = true;; bool = false)
        {
          a(bool, new Object[] { Integer.valueOf(j), " > ", Integer.valueOf(m), " in ", paramString });
          break;
        }
      }
      i = localbelm.jdField_a_of_type_Int + i;
      int i1 = localbelm.jdField_a_of_type_Int;
      if (i <= n) {}
      for (boolean bool = true;; bool = false)
      {
        a(bool, new Object[] { Integer.valueOf(i), " > ", Integer.valueOf(n), " in ", paramString });
        k = i1 + k;
        break;
      }
    }
    for (localObject1 = ((String)localObject1).substring(0, k); ((String)localObject1).length() < k; localObject1 = (String)localObject1 + "?") {}
    localbelp.a();
    a(a(m, i + (m - j), localbelp.toString(), (String)localObject1).equals(paramString), new Object[] { "Invalid changeset (checkRep failed)" });
    return paramString;
  }
  
  public static String a(String paramString1, int paramInt1, String paramString2, int paramInt2, bell parambell)
  {
    Iterator localIterator1 = a(paramString1, paramInt1);
    Iterator localIterator2 = a(paramString2, paramInt2);
    belp localbelp = new belp();
    paramString1 = new belm();
    paramString2 = new belm();
    belm localbelm = new belm();
    if ((paramString1.jdField_a_of_type_Char != 0) || (localIterator1.hasNext()) || (paramString2.jdField_a_of_type_Char != 0) || (localIterator2.hasNext()))
    {
      if ((paramString1.jdField_a_of_type_Char != 0) || (!localIterator1.hasNext())) {
        break label190;
      }
      paramString1 = (belm)localIterator1.next();
    }
    label190:
    for (;;)
    {
      if ((paramString2.jdField_a_of_type_Char == 0) && (localIterator2.hasNext())) {
        paramString2 = (belm)localIterator2.next();
      }
      for (;;)
      {
        parambell.a(paramString1, paramString2, localbelm);
        if (localbelm.jdField_a_of_type_Char != 0)
        {
          localbelp.a(localbelm);
          localbelm.jdField_a_of_type_Char = '\000';
          break;
          localbelp.a();
          return localbelp.toString();
        }
        break;
      }
    }
  }
  
  public static String a(String paramString, beko parambeko1, beko parambeko2)
  {
    int j = paramString.indexOf('$');
    int i = j;
    if (j < 0) {
      i = paramString.length();
    }
    String str = paramString.substring(0, i);
    paramString = paramString.substring(i);
    return belw.a(str, "\\*([0-9a-z]+)", new belc(parambeko1, parambeko2)) + paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject = a(paramString1);
    boolean bool;
    StringBuilder localStringBuilder;
    if (paramString2.length() == ((beks)localObject).jdField_b_of_type_Int)
    {
      bool = true;
      a(bool, new Object[] { "mismatched apply: ", Integer.valueOf(paramString2.length()), " / ", Integer.valueOf(((beks)localObject).jdField_b_of_type_Int) });
      paramString1 = a(((beks)localObject).jdField_a_of_type_JavaLangString);
      localObject = new belr(((beks)localObject).jdField_b_of_type_JavaLangString);
      paramString2 = new belr(paramString2);
      localStringBuilder = new StringBuilder();
    }
    for (;;)
    {
      if (!paramString1.hasNext()) {
        break label212;
      }
      belm localbelm = (belm)paramString1.next();
      switch (localbelm.jdField_a_of_type_Char)
      {
      default: 
        break;
      case '+': 
        localStringBuilder.append(((belr)localObject).a(localbelm.jdField_a_of_type_Int));
        continue;
        bool = false;
        break;
      case '-': 
        paramString2.a(localbelm.jdField_a_of_type_Int);
        break;
      case '=': 
        localStringBuilder.append(paramString2.a(localbelm.jdField_a_of_type_Int));
      }
    }
    label212:
    localStringBuilder.append(paramString2.a(paramString2.a()));
    return localStringBuilder.toString();
  }
  
  static String a(String paramString1, String paramString2, beko parambeko)
  {
    return a(paramString2, 0, a(paramString1).jdField_a_of_type_JavaLangString, 0, new beky(parambeko));
  }
  
  static String a(String paramString1, String paramString2, boolean paramBoolean, beko parambeko)
  {
    if ((belw.a(paramString1)) && (paramBoolean)) {
      return paramString2;
    }
    if (belw.a(paramString2)) {
      return paramString1;
    }
    ArrayList localArrayList = new ArrayList();
    belw.a(paramString1, "\\*([0-9a-z]+)", new bekt(localArrayList, parambeko));
    belw.a(paramString2, "\\*([0-9a-z]+)", new bekx(parambeko, localArrayList, paramBoolean));
    Collections.sort(localArrayList, new belu());
    paramString1 = new StringBuilder();
    int i = 0;
    while (i < localArrayList.size())
    {
      paramString1.append('*');
      paramString1.append(a(parambeko.a((Pair)localArrayList.get(i))));
      i += 1;
    }
    return paramString1.toString();
  }
  
  public static Iterator<belm> a(String paramString)
  {
    return a(paramString, 0);
  }
  
  public static Iterator<belm> a(String paramString, int paramInt)
  {
    return new beln(paramString.substring(paramInt));
  }
  
  public static List<belq> a(String paramString)
  {
    Object localObject1 = a(paramString);
    paramString = new ArrayList();
    Iterator localIterator = a(((beks)localObject1).jdField_a_of_type_JavaLangString);
    localObject1 = new belr(((beks)localObject1).jdField_b_of_type_JavaLangString);
    int i = 0;
    int j = 0;
    belm localbelm;
    int k;
    while (localIterator.hasNext())
    {
      localbelm = (belm)localIterator.next();
      if (localbelm.jdField_a_of_type_Char == '=')
      {
        k = localbelm.jdField_a_of_type_Int;
        i = 0;
        j += k;
      }
      else
      {
        if (i != 0) {
          break label249;
        }
        paramString.add(new belq(j, j, ""));
        i = 1;
      }
    }
    label249:
    for (;;)
    {
      Object localObject2;
      if (localbelm.jdField_a_of_type_Char == '-')
      {
        k = localbelm.jdField_a_of_type_Int;
        localObject2 = (belq)paramString.get(paramString.size() - 1);
        int m = ((belq)localObject2).jdField_b_of_type_Int;
        ((belq)localObject2).jdField_b_of_type_Int = (localbelm.jdField_a_of_type_Int + m);
        j += k;
        break;
      }
      if (localbelm.jdField_a_of_type_Char == '+')
      {
        localObject2 = new StringBuilder();
        belq localbelq = (belq)paramString.get(paramString.size() - 1);
        localbelq.jdField_a_of_type_JavaLangString += ((belr)localObject1).a(localbelm.jdField_a_of_type_Int);
      }
      break;
      return paramString;
    }
  }
  
  public static void a(belm parambelm)
  {
    parambelm.jdField_a_of_type_Char = '\000';
    parambelm.jdField_a_of_type_Int = 0;
    parambelm.jdField_b_of_type_Int = 0;
    parambelm.jdField_a_of_type_JavaLangString = "";
  }
  
  public static void a(belm parambelm1, belm parambelm2)
  {
    parambelm2.jdField_a_of_type_Char = parambelm1.jdField_a_of_type_Char;
    parambelm2.jdField_a_of_type_Int = parambelm1.jdField_a_of_type_Int;
    parambelm2.jdField_b_of_type_Int = parambelm1.jdField_b_of_type_Int;
    parambelm2.jdField_a_of_type_JavaLangString = parambelm1.jdField_a_of_type_JavaLangString;
  }
  
  static void a(belm parambelm1, belm parambelm2, belm parambelm3, @Nullable beko parambeko)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (parambelm1.jdField_a_of_type_Char == '-')
    {
      a(parambelm1, parambelm3);
      parambelm1.jdField_a_of_type_Char = '\000';
    }
    do
    {
      return;
      if (parambelm1.jdField_a_of_type_Char == 0)
      {
        a(parambelm2, parambelm3);
        parambelm2.jdField_a_of_type_Char = '\000';
        return;
      }
      switch (parambelm2.jdField_a_of_type_Char)
      {
      default: 
        return;
      case '\000': 
        a(parambelm1, parambelm3);
        parambelm1.jdField_a_of_type_Char = '\000';
        return;
      case '-': 
        if (parambelm2.jdField_a_of_type_Int > parambelm1.jdField_a_of_type_Int) {
          break label196;
        }
        if (parambelm1.jdField_a_of_type_Char == '=')
        {
          parambelm3.jdField_a_of_type_Char = '-';
          parambelm3.jdField_a_of_type_Int = parambelm2.jdField_a_of_type_Int;
          parambelm3.jdField_b_of_type_Int = parambelm2.jdField_b_of_type_Int;
          parambelm3.jdField_a_of_type_JavaLangString = "";
        }
        parambelm1.jdField_a_of_type_Int -= parambelm2.jdField_a_of_type_Int;
        parambelm1.jdField_b_of_type_Int -= parambelm2.jdField_b_of_type_Int;
        parambelm2.jdField_a_of_type_Char = '\000';
      }
    } while (parambelm1.jdField_a_of_type_Int != 0);
    parambelm1.jdField_a_of_type_Char = '\000';
    return;
    label196:
    if (parambelm1.jdField_a_of_type_Char == '=')
    {
      parambelm3.jdField_a_of_type_Char = '-';
      parambelm3.jdField_a_of_type_Int = parambelm1.jdField_a_of_type_Int;
      parambelm3.jdField_b_of_type_Int = parambelm1.jdField_b_of_type_Int;
      parambelm3.jdField_a_of_type_JavaLangString = "";
    }
    parambelm2.jdField_a_of_type_Int -= parambelm1.jdField_a_of_type_Int;
    parambelm2.jdField_b_of_type_Int -= parambelm1.jdField_b_of_type_Int;
    parambelm1.jdField_a_of_type_Char = '\000';
    return;
    a(parambelm2, parambelm3);
    parambelm2.jdField_a_of_type_Char = '\000';
    return;
    if (parambelm2.jdField_a_of_type_Int <= parambelm1.jdField_a_of_type_Int)
    {
      parambelm3.jdField_a_of_type_Char = parambelm1.jdField_a_of_type_Char;
      parambelm3.jdField_a_of_type_Int = parambelm2.jdField_a_of_type_Int;
      parambelm3.jdField_b_of_type_Int = parambelm2.jdField_b_of_type_Int;
      str1 = parambelm1.jdField_a_of_type_JavaLangString;
      str2 = parambelm2.jdField_a_of_type_JavaLangString;
      if (parambelm1.jdField_a_of_type_Char == '=') {}
      for (;;)
      {
        parambelm3.jdField_a_of_type_JavaLangString = a(str1, str2, bool1, parambeko);
        parambelm2.jdField_a_of_type_Char = '\000';
        parambelm1.jdField_a_of_type_Int -= parambelm2.jdField_a_of_type_Int;
        parambelm1.jdField_b_of_type_Int -= parambelm2.jdField_b_of_type_Int;
        if (parambelm1.jdField_a_of_type_Int != 0) {
          break;
        }
        parambelm1.jdField_a_of_type_Char = '\000';
        return;
        bool1 = false;
      }
    }
    parambelm3.jdField_a_of_type_Char = parambelm1.jdField_a_of_type_Char;
    parambelm3.jdField_a_of_type_Int = parambelm1.jdField_a_of_type_Int;
    parambelm3.jdField_b_of_type_Int = parambelm1.jdField_b_of_type_Int;
    String str1 = parambelm1.jdField_a_of_type_JavaLangString;
    String str2 = parambelm2.jdField_a_of_type_JavaLangString;
    if (parambelm1.jdField_a_of_type_Char == '=') {}
    for (bool1 = bool2;; bool1 = false)
    {
      parambelm3.jdField_a_of_type_JavaLangString = a(str1, str2, bool1, parambeko);
      parambelm1.jdField_a_of_type_Char = '\000';
      parambelm2.jdField_a_of_type_Int -= parambelm1.jdField_a_of_type_Int;
      parambelm2.jdField_b_of_type_Int -= parambelm1.jdField_b_of_type_Int;
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
      belq localbelq = (belq)paramString.next();
      int i = localbelq.jdField_a_of_type_Int + j;
      int i1 = localbelq.jdField_b_of_type_Int + j;
      int i2 = localbelq.jdField_a_of_type_JavaLangString.length();
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
    belp localbelp = new belp();
    localbelp.a('+', paramString);
    return localbelp.toString();
  }
  
  public static String b(String paramString1, String paramString2, beko parambeko)
  {
    paramString1 = a(paramString1);
    paramString2 = a(paramString2);
    int i = paramString1.jdField_b_of_type_Int;
    if (paramString1.c == paramString2.jdField_b_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, new Object[] { "mismatched composition" });
      int j = paramString2.c;
      belr localbelr1 = new belr(paramString1.jdField_b_of_type_JavaLangString);
      belr localbelr2 = new belr(paramString2.jdField_b_of_type_JavaLangString);
      StringBuilder localStringBuilder = new StringBuilder();
      return a(i, j, a(paramString1.jdField_a_of_type_JavaLangString, 0, paramString2.jdField_a_of_type_JavaLangString, 0, new bekz(localbelr1, parambeko, localStringBuilder, localbelr2)), localStringBuilder.toString());
    }
  }
  
  public static String b(String paramString1, String paramString2, boolean paramBoolean, beko parambeko)
  {
    beks localbeks2 = a(paramString1);
    beks localbeks1 = a(paramString2);
    if (localbeks2.jdField_b_of_type_Int == localbeks1.jdField_b_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, new Object[] { "mismatched follow:" + paramString1 + " " + paramString2 });
      belr localbelr1 = new belr(localbeks2.jdField_b_of_type_JavaLangString);
      belr localbelr2 = new belr(localbeks1.jdField_b_of_type_JavaLangString);
      int i = localbeks2.c;
      paramString1 = new int[1];
      paramString2 = new int[1];
      bekr localbekr = a(new Pair("insertorder", "first"), parambeko);
      parambeko = a(localbeks2.jdField_a_of_type_JavaLangString, 0, localbeks1.jdField_a_of_type_JavaLangString, 0, new beku(paramString1, paramString2, parambeko, localbelr1, localbelr2, localbekr, paramBoolean));
      int j = paramString2[0];
      paramString2[0] = (i - paramString1[0] + j);
      return a(i, paramString2[0], parambeko, localbeks1.jdField_b_of_type_JavaLangString);
    }
  }
  
  public static String c(String paramString1, String paramString2, beko parambeko)
  {
    if ((belw.a(paramString2)) || (parambeko == null)) {
      localObject = "";
    }
    do
    {
      return localObject;
      localObject = paramString2;
    } while (belw.a(paramString1));
    Object localObject = new ArrayList();
    belw.a(paramString2, "\\*([0-9a-z]+)", new bekv((List)localObject, parambeko));
    belw.a(paramString1, "\\*([0-9a-z]+)", new bekw(parambeko, (List)localObject));
    paramString1 = new StringBuilder();
    int i = 0;
    while (i < ((List)localObject).size())
    {
      paramString1.append('*');
      paramString1.append(a(parambeko.a((Pair)((List)localObject).get(i))));
      i += 1;
    }
    return paramString1.toString();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof beks)) {
        return false;
      }
      paramObject = (beks)paramObject;
    } while ((this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int) && (this.c == paramObject.c) && (belw.a(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (belw.a(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)));
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
 * Qualified Name:     beks
 * JD-Core Version:    0.7.0.1
 */