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

public class belm
{
  public static int a;
  static bemb jdField_a_of_type_Bemb;
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
    return Integer.parseInt(paramString, bemq.jdField_a_of_type_Int);
  }
  
  public static belh a(belh parambelh)
  {
    return new belh(parambelh.jdField_a_of_type_JavaLangString, parambelh.jdField_b_of_type_JavaLangString);
  }
  
  public static belh a(String paramString, belh parambelh, beli parambeli)
  {
    return new belh(a(paramString, parambelh.jdField_a_of_type_JavaLangString), a(paramString, parambelh.jdField_b_of_type_JavaLangString, parambeli));
  }
  
  public static belh a(String paramString1, String paramString2)
  {
    if (!bemq.a(paramString2)) {}
    for (;;)
    {
      return new belh(paramString1, paramString2);
      paramString2 = b(paramString1);
    }
  }
  
  public static belh a(String paramString, List<Pair<String, String>> paramList, beli parambeli)
  {
    bemj localbemj = new bemj();
    localbemj.a('+', paramString, paramList, parambeli);
    return new belh(paramString, localbemj.toString());
  }
  
  static bell a(Pair<String, String> paramPair, beli parambeli)
  {
    belu localbelu = new belu();
    if (parambeli == null) {}
    int i;
    do
    {
      return localbelu;
      i = parambeli.a(paramPair, true);
    } while (i < 0);
    return new belv(Pattern.compile("\\*" + a(i) + "(?!\\w)"));
  }
  
  public static belm a(String paramString)
  {
    int i = 1;
    belm localbelm = new belm();
    if (jdField_a_of_type_Boolean)
    {
      if (jdField_a_of_type_Bemb == null) {
        jdField_a_of_type_Bemb = new bemb();
      }
      for (;;)
      {
        jdField_a_of_type_Bemb.a(paramString);
        localbelm.c = jdField_a_of_type_Bemb.c;
        localbelm.jdField_b_of_type_Int = jdField_a_of_type_Bemb.jdField_b_of_type_Int;
        i = jdField_a_of_type_Bemb.jdField_a_of_type_Int;
        int k = paramString.indexOf("$");
        int j = k;
        if (k < 0) {
          j = paramString.length();
        }
        localbelm.jdField_a_of_type_JavaLangString = paramString.substring(i, j);
        localbelm.jdField_b_of_type_JavaLangString = paramString.substring(j + 1);
        return localbelm;
        jdField_a_of_type_Bemb.a();
      }
    }
    if (jdField_b_of_type_JavaUtilRegexPattern == null) {
      jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("Z:([0-9a-z]+)([><])([0-9a-z]+)|");
    }
    Matcher localMatcher = jdField_b_of_type_JavaUtilRegexPattern.matcher(paramString);
    if ((!localMatcher.find()) || (localMatcher.group().length() == 0)) {
      throw new IllegalArgumentException("Not a exports: " + paramString);
    }
    localbelm.jdField_b_of_type_Int = a(localMatcher.group(1));
    if (">".equals(localMatcher.group(2))) {}
    for (;;)
    {
      localbelm.c = (i * a(localMatcher.group(3)) + localbelm.jdField_b_of_type_Int);
      i = localMatcher.group().length();
      break;
      i = -1;
    }
  }
  
  public static belz a(String paramString, beli parambeli)
  {
    beli localbeli = new beli();
    return new belz(a(paramString, parambeli, localbeli), localbeli);
  }
  
  public static bemg a(char paramChar)
  {
    bemg localbemg = new bemg();
    localbemg.jdField_a_of_type_Char = paramChar;
    return localbemg;
  }
  
  public static String a(char paramChar, List<Pair<String, String>> paramList, beli parambeli)
  {
    if ((parambeli == null) || (paramList == null) || (paramList.size() <= 0)) {
      return "";
    }
    Object localObject = paramList;
    if (paramList.size() > 1)
    {
      localObject = new ArrayList(paramList);
      Collections.sort((List)localObject, new bemo());
    }
    paramList = new StringBuilder();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Pair localPair = (Pair)((Iterator)localObject).next();
      if ((paramChar == '=') || ((paramChar == '+') && (!bemq.a((String)localPair.second)))) {
        paramList.append('*').append(a(parambeli.a(localPair)));
      }
    }
    return paramList.toString();
  }
  
  static String a(int paramInt)
  {
    return Integer.toString(paramInt, bemq.jdField_a_of_type_Int);
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
    int m = ((belm)localObject1).jdField_b_of_type_Int;
    int n = ((belm)localObject1).c;
    Object localObject2 = ((belm)localObject1).jdField_a_of_type_JavaLangString;
    localObject1 = ((belm)localObject1).jdField_b_of_type_JavaLangString;
    bemj localbemj = new bemj();
    localObject2 = a((String)localObject2);
    int j = 0;
    int i = 0;
    int k = 0;
    if (((Iterator)localObject2).hasNext())
    {
      bemg localbemg = (bemg)((Iterator)localObject2).next();
      switch (localbemg.jdField_a_of_type_Char)
      {
      default: 
      case '=': 
        for (;;)
        {
          localbemj.a(localbemg);
          break;
          j += localbemg.jdField_a_of_type_Int;
          i += localbemg.jdField_a_of_type_Int;
        }
      case '-': 
        j = localbemg.jdField_a_of_type_Int + j;
        if (j <= m) {}
        for (bool = true;; bool = false)
        {
          a(bool, new Object[] { Integer.valueOf(j), " > ", Integer.valueOf(m), " in ", paramString });
          break;
        }
      }
      i = localbemg.jdField_a_of_type_Int + i;
      int i1 = localbemg.jdField_a_of_type_Int;
      if (i <= n) {}
      for (boolean bool = true;; bool = false)
      {
        a(bool, new Object[] { Integer.valueOf(i), " > ", Integer.valueOf(n), " in ", paramString });
        k = i1 + k;
        break;
      }
    }
    for (localObject1 = ((String)localObject1).substring(0, k); ((String)localObject1).length() < k; localObject1 = (String)localObject1 + "?") {}
    localbemj.a();
    a(a(m, i + (m - j), localbemj.toString(), (String)localObject1).equals(paramString), new Object[] { "Invalid changeset (checkRep failed)" });
    return paramString;
  }
  
  public static String a(String paramString1, int paramInt1, String paramString2, int paramInt2, bemf parambemf)
  {
    Iterator localIterator1 = a(paramString1, paramInt1);
    Iterator localIterator2 = a(paramString2, paramInt2);
    bemj localbemj = new bemj();
    paramString1 = new bemg();
    paramString2 = new bemg();
    bemg localbemg = new bemg();
    if ((paramString1.jdField_a_of_type_Char != 0) || (localIterator1.hasNext()) || (paramString2.jdField_a_of_type_Char != 0) || (localIterator2.hasNext()))
    {
      if ((paramString1.jdField_a_of_type_Char != 0) || (!localIterator1.hasNext())) {
        break label190;
      }
      paramString1 = (bemg)localIterator1.next();
    }
    label190:
    for (;;)
    {
      if ((paramString2.jdField_a_of_type_Char == 0) && (localIterator2.hasNext())) {
        paramString2 = (bemg)localIterator2.next();
      }
      for (;;)
      {
        parambemf.a(paramString1, paramString2, localbemg);
        if (localbemg.jdField_a_of_type_Char != 0)
        {
          localbemj.a(localbemg);
          localbemg.jdField_a_of_type_Char = '\000';
          break;
          localbemj.a();
          return localbemj.toString();
        }
        break;
      }
    }
  }
  
  public static String a(String paramString, beli parambeli1, beli parambeli2)
  {
    int j = paramString.indexOf('$');
    int i = j;
    if (j < 0) {
      i = paramString.length();
    }
    String str = paramString.substring(0, i);
    paramString = paramString.substring(i);
    return bemq.a(str, "\\*([0-9a-z]+)", new belw(parambeli1, parambeli2)) + paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject = a(paramString1);
    boolean bool;
    StringBuilder localStringBuilder;
    if (paramString2.length() == ((belm)localObject).jdField_b_of_type_Int)
    {
      bool = true;
      a(bool, new Object[] { "mismatched apply: ", Integer.valueOf(paramString2.length()), " / ", Integer.valueOf(((belm)localObject).jdField_b_of_type_Int) });
      paramString1 = a(((belm)localObject).jdField_a_of_type_JavaLangString);
      localObject = new beml(((belm)localObject).jdField_b_of_type_JavaLangString);
      paramString2 = new beml(paramString2);
      localStringBuilder = new StringBuilder();
    }
    for (;;)
    {
      if (!paramString1.hasNext()) {
        break label212;
      }
      bemg localbemg = (bemg)paramString1.next();
      switch (localbemg.jdField_a_of_type_Char)
      {
      default: 
        break;
      case '+': 
        localStringBuilder.append(((beml)localObject).a(localbemg.jdField_a_of_type_Int));
        continue;
        bool = false;
        break;
      case '-': 
        paramString2.a(localbemg.jdField_a_of_type_Int);
        break;
      case '=': 
        localStringBuilder.append(paramString2.a(localbemg.jdField_a_of_type_Int));
      }
    }
    label212:
    localStringBuilder.append(paramString2.a(paramString2.a()));
    return localStringBuilder.toString();
  }
  
  static String a(String paramString1, String paramString2, beli parambeli)
  {
    return a(paramString2, 0, a(paramString1).jdField_a_of_type_JavaLangString, 0, new bels(parambeli));
  }
  
  static String a(String paramString1, String paramString2, boolean paramBoolean, beli parambeli)
  {
    if ((bemq.a(paramString1)) && (paramBoolean)) {
      return paramString2;
    }
    if (bemq.a(paramString2)) {
      return paramString1;
    }
    ArrayList localArrayList = new ArrayList();
    bemq.a(paramString1, "\\*([0-9a-z]+)", new beln(localArrayList, parambeli));
    bemq.a(paramString2, "\\*([0-9a-z]+)", new belr(parambeli, localArrayList, paramBoolean));
    Collections.sort(localArrayList, new bemo());
    paramString1 = new StringBuilder();
    int i = 0;
    while (i < localArrayList.size())
    {
      paramString1.append('*');
      paramString1.append(a(parambeli.a((Pair)localArrayList.get(i))));
      i += 1;
    }
    return paramString1.toString();
  }
  
  public static Iterator<bemg> a(String paramString)
  {
    return a(paramString, 0);
  }
  
  public static Iterator<bemg> a(String paramString, int paramInt)
  {
    return new bemh(paramString.substring(paramInt));
  }
  
  public static List<bemk> a(String paramString)
  {
    Object localObject1 = a(paramString);
    paramString = new ArrayList();
    Iterator localIterator = a(((belm)localObject1).jdField_a_of_type_JavaLangString);
    localObject1 = new beml(((belm)localObject1).jdField_b_of_type_JavaLangString);
    int i = 0;
    int j = 0;
    bemg localbemg;
    int k;
    while (localIterator.hasNext())
    {
      localbemg = (bemg)localIterator.next();
      if (localbemg.jdField_a_of_type_Char == '=')
      {
        k = localbemg.jdField_a_of_type_Int;
        i = 0;
        j += k;
      }
      else
      {
        if (i != 0) {
          break label249;
        }
        paramString.add(new bemk(j, j, ""));
        i = 1;
      }
    }
    label249:
    for (;;)
    {
      Object localObject2;
      if (localbemg.jdField_a_of_type_Char == '-')
      {
        k = localbemg.jdField_a_of_type_Int;
        localObject2 = (bemk)paramString.get(paramString.size() - 1);
        int m = ((bemk)localObject2).jdField_b_of_type_Int;
        ((bemk)localObject2).jdField_b_of_type_Int = (localbemg.jdField_a_of_type_Int + m);
        j += k;
        break;
      }
      if (localbemg.jdField_a_of_type_Char == '+')
      {
        localObject2 = new StringBuilder();
        bemk localbemk = (bemk)paramString.get(paramString.size() - 1);
        localbemk.jdField_a_of_type_JavaLangString += ((beml)localObject1).a(localbemg.jdField_a_of_type_Int);
      }
      break;
      return paramString;
    }
  }
  
  public static void a(bemg parambemg)
  {
    parambemg.jdField_a_of_type_Char = '\000';
    parambemg.jdField_a_of_type_Int = 0;
    parambemg.jdField_b_of_type_Int = 0;
    parambemg.jdField_a_of_type_JavaLangString = "";
  }
  
  public static void a(bemg parambemg1, bemg parambemg2)
  {
    parambemg2.jdField_a_of_type_Char = parambemg1.jdField_a_of_type_Char;
    parambemg2.jdField_a_of_type_Int = parambemg1.jdField_a_of_type_Int;
    parambemg2.jdField_b_of_type_Int = parambemg1.jdField_b_of_type_Int;
    parambemg2.jdField_a_of_type_JavaLangString = parambemg1.jdField_a_of_type_JavaLangString;
  }
  
  static void a(bemg parambemg1, bemg parambemg2, bemg parambemg3, @NonNull beli parambeli)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (parambemg1.jdField_a_of_type_Char == '-')
    {
      a(parambemg1, parambemg3);
      parambemg1.jdField_a_of_type_Char = '\000';
    }
    do
    {
      return;
      if (parambemg1.jdField_a_of_type_Char == 0)
      {
        a(parambemg2, parambemg3);
        parambemg2.jdField_a_of_type_Char = '\000';
        return;
      }
      switch (parambemg2.jdField_a_of_type_Char)
      {
      default: 
        return;
      case '\000': 
        a(parambemg1, parambemg3);
        parambemg1.jdField_a_of_type_Char = '\000';
        return;
      case '-': 
        if (parambemg2.jdField_a_of_type_Int > parambemg1.jdField_a_of_type_Int) {
          break label196;
        }
        if (parambemg1.jdField_a_of_type_Char == '=')
        {
          parambemg3.jdField_a_of_type_Char = '-';
          parambemg3.jdField_a_of_type_Int = parambemg2.jdField_a_of_type_Int;
          parambemg3.jdField_b_of_type_Int = parambemg2.jdField_b_of_type_Int;
          parambemg3.jdField_a_of_type_JavaLangString = "";
        }
        parambemg1.jdField_a_of_type_Int -= parambemg2.jdField_a_of_type_Int;
        parambemg1.jdField_b_of_type_Int -= parambemg2.jdField_b_of_type_Int;
        parambemg2.jdField_a_of_type_Char = '\000';
      }
    } while (parambemg1.jdField_a_of_type_Int != 0);
    parambemg1.jdField_a_of_type_Char = '\000';
    return;
    label196:
    if (parambemg1.jdField_a_of_type_Char == '=')
    {
      parambemg3.jdField_a_of_type_Char = '-';
      parambemg3.jdField_a_of_type_Int = parambemg1.jdField_a_of_type_Int;
      parambemg3.jdField_b_of_type_Int = parambemg1.jdField_b_of_type_Int;
      parambemg3.jdField_a_of_type_JavaLangString = "";
    }
    parambemg2.jdField_a_of_type_Int -= parambemg1.jdField_a_of_type_Int;
    parambemg2.jdField_b_of_type_Int -= parambemg1.jdField_b_of_type_Int;
    parambemg1.jdField_a_of_type_Char = '\000';
    return;
    a(parambemg2, parambemg3);
    parambemg2.jdField_a_of_type_Char = '\000';
    return;
    if (parambemg2.jdField_a_of_type_Int <= parambemg1.jdField_a_of_type_Int)
    {
      parambemg3.jdField_a_of_type_Char = parambemg1.jdField_a_of_type_Char;
      parambemg3.jdField_a_of_type_Int = parambemg2.jdField_a_of_type_Int;
      parambemg3.jdField_b_of_type_Int = parambemg2.jdField_b_of_type_Int;
      str1 = parambemg1.jdField_a_of_type_JavaLangString;
      str2 = parambemg2.jdField_a_of_type_JavaLangString;
      if (parambemg1.jdField_a_of_type_Char == '=') {}
      for (;;)
      {
        parambemg3.jdField_a_of_type_JavaLangString = a(str1, str2, bool1, parambeli);
        parambemg2.jdField_a_of_type_Char = '\000';
        parambemg1.jdField_a_of_type_Int -= parambemg2.jdField_a_of_type_Int;
        parambemg1.jdField_b_of_type_Int -= parambemg2.jdField_b_of_type_Int;
        if (parambemg1.jdField_a_of_type_Int != 0) {
          break;
        }
        parambemg1.jdField_a_of_type_Char = '\000';
        return;
        bool1 = false;
      }
    }
    parambemg3.jdField_a_of_type_Char = parambemg1.jdField_a_of_type_Char;
    parambemg3.jdField_a_of_type_Int = parambemg1.jdField_a_of_type_Int;
    parambemg3.jdField_b_of_type_Int = parambemg1.jdField_b_of_type_Int;
    String str1 = parambemg1.jdField_a_of_type_JavaLangString;
    String str2 = parambemg2.jdField_a_of_type_JavaLangString;
    if (parambemg1.jdField_a_of_type_Char == '=') {}
    for (bool1 = bool2;; bool1 = false)
    {
      parambemg3.jdField_a_of_type_JavaLangString = a(str1, str2, bool1, parambeli);
      parambemg1.jdField_a_of_type_Char = '\000';
      parambemg2.jdField_a_of_type_Int -= parambemg1.jdField_a_of_type_Int;
      parambemg2.jdField_b_of_type_Int -= parambemg1.jdField_b_of_type_Int;
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
      bemk localbemk = (bemk)paramString.next();
      int i = localbemk.jdField_a_of_type_Int + j;
      int i1 = localbemk.jdField_b_of_type_Int + j;
      int i2 = localbemk.jdField_a_of_type_JavaLangString.length();
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
    bemj localbemj = new bemj();
    localbemj.a('+', paramString);
    return localbemj.toString();
  }
  
  public static String b(String paramString1, String paramString2, beli parambeli)
  {
    paramString1 = a(paramString1);
    paramString2 = a(paramString2);
    int i = paramString1.jdField_b_of_type_Int;
    if (paramString1.c == paramString2.jdField_b_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, new Object[] { "mismatched composition" });
      int j = paramString2.c;
      beml localbeml1 = new beml(paramString1.jdField_b_of_type_JavaLangString);
      beml localbeml2 = new beml(paramString2.jdField_b_of_type_JavaLangString);
      StringBuilder localStringBuilder = new StringBuilder();
      return a(i, j, a(paramString1.jdField_a_of_type_JavaLangString, 0, paramString2.jdField_a_of_type_JavaLangString, 0, new belt(localbeml1, parambeli, localStringBuilder, localbeml2)), localStringBuilder.toString());
    }
  }
  
  public static String b(String paramString1, String paramString2, boolean paramBoolean, beli parambeli)
  {
    belm localbelm2 = a(paramString1);
    belm localbelm1 = a(paramString2);
    if (localbelm2.jdField_b_of_type_Int == localbelm1.jdField_b_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, new Object[] { "mismatched follow:" + paramString1 + " " + paramString2 });
      beml localbeml1 = new beml(localbelm2.jdField_b_of_type_JavaLangString);
      beml localbeml2 = new beml(localbelm1.jdField_b_of_type_JavaLangString);
      int i = localbelm2.c;
      paramString1 = new int[1];
      paramString2 = new int[1];
      bell localbell = a(new Pair("insertorder", "first"), parambeli);
      parambeli = a(localbelm2.jdField_a_of_type_JavaLangString, 0, localbelm1.jdField_a_of_type_JavaLangString, 0, new belo(localbeml1, localbeml2, localbell, paramBoolean, parambeli, paramString1, paramString2));
      paramString2[0] += i - paramString1[0];
      return a(i, paramString2[0], parambeli, localbelm1.jdField_b_of_type_JavaLangString);
    }
  }
  
  private static void b(bemg parambemg1, bemg parambemg2, bemg parambemg3)
  {
    a(parambemg2, parambemg3);
    if (parambemg1.jdField_a_of_type_Char == 0) {
      parambemg2.jdField_a_of_type_Char = '\000';
    }
    do
    {
      return;
      if (parambemg2.jdField_a_of_type_Int > parambemg1.jdField_a_of_type_Int) {
        break;
      }
      parambemg1.jdField_a_of_type_Int -= parambemg2.jdField_a_of_type_Int;
      parambemg1.jdField_b_of_type_Int -= parambemg2.jdField_b_of_type_Int;
      parambemg2.jdField_a_of_type_Char = '\000';
    } while (parambemg1.jdField_a_of_type_Int != 0);
    parambemg1.jdField_a_of_type_Char = '\000';
    return;
    parambemg3.jdField_b_of_type_Int = parambemg1.jdField_b_of_type_Int;
    parambemg3.jdField_a_of_type_Int = parambemg1.jdField_a_of_type_Int;
    parambemg2.jdField_b_of_type_Int -= parambemg1.jdField_b_of_type_Int;
    parambemg2.jdField_a_of_type_Int -= parambemg1.jdField_a_of_type_Int;
    parambemg1.jdField_a_of_type_Char = '\000';
  }
  
  private static void b(bemg parambemg1, bemg parambemg2, bemg parambemg3, beml parambeml1, beml parambeml2, bell parambell, boolean paramBoolean)
  {
    int j = 2;
    int i;
    if (parambemg2.jdField_a_of_type_Char != '+') {
      i = 1;
    }
    while (i == 1)
    {
      parambeml1.a(parambemg1.jdField_a_of_type_Int);
      parambemg3.jdField_a_of_type_Char = '=';
      parambemg3.jdField_b_of_type_Int = parambemg1.jdField_b_of_type_Int;
      parambemg3.jdField_a_of_type_Int = parambemg1.jdField_a_of_type_Int;
      parambemg3.jdField_a_of_type_JavaLangString = "";
      parambemg1.jdField_a_of_type_Char = '\000';
      return;
      i = j;
      if (parambemg1.jdField_a_of_type_Char == '+')
      {
        String str1 = parambeml1.b(1);
        String str2 = parambeml2.b(1);
        boolean bool1 = parambell.a(parambemg1.jdField_a_of_type_JavaLangString);
        boolean bool2 = parambell.a(parambemg2.jdField_a_of_type_JavaLangString);
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
    parambeml2.a(parambemg2.jdField_a_of_type_Int);
    a(parambemg2, parambemg3);
    parambemg2.jdField_a_of_type_Char = '\000';
  }
  
  public static String c(String paramString1, String paramString2, beli parambeli)
  {
    if ((bemq.a(paramString2)) || (parambeli == null)) {
      localObject = "";
    }
    do
    {
      return localObject;
      localObject = paramString2;
    } while (bemq.a(paramString1));
    Object localObject = new ArrayList();
    bemq.a(paramString2, "\\*([0-9a-z]+)", new belp((List)localObject, parambeli));
    bemq.a(paramString1, "\\*([0-9a-z]+)", new belq(parambeli, (List)localObject));
    paramString1 = new StringBuilder();
    int i = 0;
    while (i < ((List)localObject).size())
    {
      paramString1.append('*');
      paramString1.append(a(parambeli.a((Pair)((List)localObject).get(i))));
      i += 1;
    }
    return paramString1.toString();
  }
  
  private static void c(bemg parambemg1, bemg parambemg2)
  {
    if (parambemg2.jdField_a_of_type_Char == 0) {
      parambemg1.jdField_a_of_type_Char = '\000';
    }
    do
    {
      return;
      if (parambemg1.jdField_a_of_type_Int > parambemg2.jdField_a_of_type_Int) {
        break;
      }
      parambemg2.jdField_a_of_type_Int -= parambemg1.jdField_a_of_type_Int;
      parambemg2.jdField_b_of_type_Int -= parambemg1.jdField_b_of_type_Int;
      parambemg1.jdField_a_of_type_Char = '\000';
    } while (parambemg2.jdField_a_of_type_Int > 0);
    parambemg2.jdField_a_of_type_Char = '\000';
    return;
    parambemg1.jdField_a_of_type_Int -= parambemg2.jdField_a_of_type_Int;
    parambemg1.jdField_b_of_type_Int -= parambemg2.jdField_b_of_type_Int;
    parambemg2.jdField_a_of_type_Char = '\000';
  }
  
  private static void c(bemg parambemg1, bemg parambemg2, bemg parambemg3, beli parambeli)
  {
    parambemg3.jdField_a_of_type_Char = '=';
    parambemg3.jdField_a_of_type_JavaLangString = c(parambemg1.jdField_a_of_type_JavaLangString, parambemg2.jdField_a_of_type_JavaLangString, parambeli);
    if (parambemg1.jdField_a_of_type_Int <= parambemg2.jdField_a_of_type_Int)
    {
      parambemg3.jdField_a_of_type_Int = parambemg1.jdField_a_of_type_Int;
      parambemg3.jdField_b_of_type_Int = parambemg1.jdField_b_of_type_Int;
      parambemg2.jdField_a_of_type_Int -= parambemg1.jdField_a_of_type_Int;
      parambemg2.jdField_b_of_type_Int -= parambemg1.jdField_b_of_type_Int;
      parambemg1.jdField_a_of_type_Char = '\000';
      if (parambemg2.jdField_a_of_type_Int == 0) {
        parambemg2.jdField_a_of_type_Char = '\000';
      }
      return;
    }
    parambemg3.jdField_a_of_type_Int = parambemg2.jdField_a_of_type_Int;
    parambemg3.jdField_b_of_type_Int = parambemg2.jdField_b_of_type_Int;
    parambemg1.jdField_a_of_type_Int -= parambemg2.jdField_a_of_type_Int;
    parambemg1.jdField_b_of_type_Int -= parambemg2.jdField_b_of_type_Int;
    parambemg2.jdField_a_of_type_Char = '\000';
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof belm)) {
        return false;
      }
      paramObject = (belm)paramObject;
    } while ((this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int) && (this.c == paramObject.c) && (bemq.a(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (bemq.a(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)));
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
 * Qualified Name:     belm
 * JD-Core Version:    0.7.0.1
 */