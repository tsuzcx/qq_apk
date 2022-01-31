import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;

public class aztd
{
  public String a;
  public ArrayList<azss> a;
  public String b;
  public ArrayList<azss> b;
  public String c;
  public ArrayList<azss> c;
  public String d;
  public ArrayList<azss> d;
  public String e;
  public String f;
  public String g;
  
  public aztd(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.e = paramString3;
    this.jdField_c_of_type_JavaLangString = ChnToSpell.a(paramString2, 1).toLowerCase();
    this.jdField_d_of_type_JavaLangString = ChnToSpell.a(paramString2, 2).toLowerCase();
    this.f = ChnToSpell.a(paramString3, 1).toLowerCase();
    this.g = ChnToSpell.a(paramString3, 2).toLowerCase();
    int j;
    int i;
    int k;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString2.trim();
      j = paramString1.length();
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(j);
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(j);
      i = 0;
      while (i < j)
      {
        k = paramString1.charAt(i);
        if ((k >= 19968) && (k <= 40869))
        {
          paramString2 = paramString1.substring(i, i + 1);
          this.jdField_a_of_type_JavaUtilArrayList.add(new azss(paramContext, paramString2, ChnToSpell.a(paramString2, 1).toLowerCase()));
          this.jdField_b_of_type_JavaUtilArrayList.add(new azss(paramContext, paramString2, ChnToSpell.a(paramString2, 2).toLowerCase()));
        }
        i += 1;
      }
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = paramString3.trim();
      j = paramString1.length();
      this.jdField_c_of_type_JavaUtilArrayList = new ArrayList(j);
      this.jdField_d_of_type_JavaUtilArrayList = new ArrayList(j);
      i = 0;
      while (i < j)
      {
        k = paramString1.charAt(i);
        if ((k >= 19968) && (k <= 40869))
        {
          paramString2 = paramString1.substring(i, i + 1);
          this.jdField_c_of_type_JavaUtilArrayList.add(new azss(paramContext, paramString2, ChnToSpell.a(paramString2, 1).toLowerCase()));
          this.jdField_d_of_type_JavaUtilArrayList.add(new azss(paramContext, paramString2, ChnToSpell.a(paramString2, 2).toLowerCase()));
        }
        i += 1;
      }
    }
  }
  
  protected static final int a(int paramInt, String paramString, aztd paramaztd)
  {
    int i = -1;
    if (paramInt == 5) {
      i = paramaztd.f.indexOf(paramString);
    }
    do
    {
      return i;
      if (paramInt == 6) {
        return paramaztd.g.indexOf(paramString);
      }
      if (paramInt == 2) {
        return paramaztd.jdField_c_of_type_JavaLangString.indexOf(paramString);
      }
    } while (paramInt != 3);
    return paramaztd.jdField_d_of_type_JavaLangString.indexOf(paramString);
  }
  
  protected static int a(int paramInt, ArrayList<azss> paramArrayList)
  {
    int k = paramArrayList.size();
    int i = 0;
    int j = 0;
    for (;;)
    {
      azss localazss;
      if (i < k)
      {
        localazss = (azss)paramArrayList.get(i);
        if (localazss.jdField_a_of_type_Int + j <= paramInt) {}
      }
      else
      {
        return j;
      }
      j += localazss.jdField_a_of_type_Int;
      i += 1;
    }
  }
  
  protected static final int a(String paramString, aztd paramaztd)
  {
    int j = 0;
    int i;
    if ((paramaztd.f != null) && (paramaztd.f.indexOf(paramString) > -1)) {
      i = 5;
    }
    do
    {
      do
      {
        return i;
        if ((paramaztd.g != null) && (paramaztd.g.indexOf(paramString) > -1)) {
          return 6;
        }
        if ((paramaztd.jdField_c_of_type_JavaLangString != null) && (paramaztd.jdField_c_of_type_JavaLangString.indexOf(paramString) > -1)) {
          return 2;
        }
        i = j;
      } while (paramaztd.jdField_d_of_type_JavaLangString == null);
      i = j;
    } while (paramaztd.jdField_d_of_type_JavaLangString.indexOf(paramString) <= -1);
    return 3;
  }
  
  protected static final String a(int paramInt1, int paramInt2, String paramString, aztd paramaztd)
  {
    String str = null;
    if (paramInt1 == 5) {
      paramaztd = paramaztd.jdField_c_of_type_JavaUtilArrayList;
    }
    for (;;)
    {
      if (paramaztd != null)
      {
        paramInt1 = paramString.length();
        str = a(a(paramInt2, paramaztd), b(paramInt1 + paramInt2, paramaztd), paramaztd);
      }
      return str;
      if (paramInt1 == 6) {
        paramaztd = paramaztd.jdField_d_of_type_JavaUtilArrayList;
      } else if (paramInt1 == 2) {
        paramaztd = paramaztd.jdField_a_of_type_JavaUtilArrayList;
      } else if (paramInt1 == 3) {
        paramaztd = paramaztd.jdField_b_of_type_JavaUtilArrayList;
      } else {
        paramaztd = null;
      }
    }
  }
  
  public static String a(int paramInt1, int paramInt2, ArrayList<azss> paramArrayList)
  {
    int m = paramArrayList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = 0;
    int k = 0;
    for (;;)
    {
      azss localazss;
      if (i < m)
      {
        localazss = (azss)paramArrayList.get(i);
        if (j == paramInt1) {
          k = 1;
        }
        if (j != paramInt2) {}
      }
      else
      {
        return localStringBuilder.toString();
      }
      if (k != 0) {
        localStringBuilder.append(localazss.jdField_a_of_type_JavaLangString);
      }
      j += localazss.jdField_a_of_type_Int;
      i += 1;
    }
  }
  
  public static final String a(String paramString, aztd paramaztd)
  {
    int i = a(paramString, paramaztd);
    int j = a(i, paramString, paramaztd);
    String str = null;
    if (((j == 0) && (i == 5) && (paramString.equalsIgnoreCase(paramaztd.f))) || ((i == 6) && (paramString.equalsIgnoreCase(paramaztd.g)))) {
      str = paramaztd.e;
    }
    do
    {
      return str;
      if (((j == 0) && (i == 2) && (paramString.equalsIgnoreCase(paramaztd.jdField_c_of_type_JavaLangString))) || ((i == 3) && (paramString.equalsIgnoreCase(paramaztd.jdField_d_of_type_JavaLangString)))) {
        return paramaztd.jdField_b_of_type_JavaLangString;
      }
    } while (j <= -1);
    return a(i, j, paramString, paramaztd);
  }
  
  protected static int b(int paramInt, ArrayList<azss> paramArrayList)
  {
    int k = paramArrayList.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j = ((azss)paramArrayList.get(i)).jdField_a_of_type_Int + j;
      if (j >= paramInt) {
        return j;
      }
      i += 1;
    }
    return j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_JavaLangString != null) {
      localStringBuilder.append("uin = " + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_b_of_type_JavaLangString != null) {
      localStringBuilder.append(", name = " + this.jdField_b_of_type_JavaLangString);
    }
    if (this.e != null) {
      localStringBuilder.append(", remark = " + this.e);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aztd
 * JD-Core Version:    0.7.0.1
 */