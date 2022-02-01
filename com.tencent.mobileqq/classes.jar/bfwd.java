import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;

public class bfwd
{
  public String a;
  public ArrayList<bfvs> a;
  public String b;
  public ArrayList<bfvs> b;
  public String c;
  public ArrayList<bfvs> c;
  public String d;
  public ArrayList<bfvs> d;
  public String e;
  public String f;
  public String g;
  
  public bfwd(Context paramContext, String paramString1, String paramString2, String paramString3)
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
          this.jdField_a_of_type_JavaUtilArrayList.add(new bfvs(paramContext, paramString2, ChnToSpell.a(paramString2, 1).toLowerCase()));
          this.jdField_b_of_type_JavaUtilArrayList.add(new bfvs(paramContext, paramString2, ChnToSpell.a(paramString2, 2).toLowerCase()));
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
          this.jdField_c_of_type_JavaUtilArrayList.add(new bfvs(paramContext, paramString2, ChnToSpell.a(paramString2, 1).toLowerCase()));
          this.jdField_d_of_type_JavaUtilArrayList.add(new bfvs(paramContext, paramString2, ChnToSpell.a(paramString2, 2).toLowerCase()));
        }
        i += 1;
      }
    }
  }
  
  protected static final int a(int paramInt, String paramString, bfwd parambfwd)
  {
    int i = -1;
    if (paramInt == 5) {
      i = parambfwd.f.indexOf(paramString);
    }
    do
    {
      return i;
      if (paramInt == 6) {
        return parambfwd.g.indexOf(paramString);
      }
      if (paramInt == 2) {
        return parambfwd.jdField_c_of_type_JavaLangString.indexOf(paramString);
      }
    } while (paramInt != 3);
    return parambfwd.jdField_d_of_type_JavaLangString.indexOf(paramString);
  }
  
  protected static int a(int paramInt, ArrayList<bfvs> paramArrayList)
  {
    int k = paramArrayList.size();
    int i = 0;
    int j = 0;
    for (;;)
    {
      bfvs localbfvs;
      if (i < k)
      {
        localbfvs = (bfvs)paramArrayList.get(i);
        if (localbfvs.jdField_a_of_type_Int + j <= paramInt) {}
      }
      else
      {
        return j;
      }
      j += localbfvs.jdField_a_of_type_Int;
      i += 1;
    }
  }
  
  protected static final int a(String paramString, bfwd parambfwd)
  {
    int j = 0;
    int i;
    if ((parambfwd.f != null) && (parambfwd.f.indexOf(paramString) > -1)) {
      i = 5;
    }
    do
    {
      do
      {
        return i;
        if ((parambfwd.g != null) && (parambfwd.g.indexOf(paramString) > -1)) {
          return 6;
        }
        if ((parambfwd.jdField_c_of_type_JavaLangString != null) && (parambfwd.jdField_c_of_type_JavaLangString.indexOf(paramString) > -1)) {
          return 2;
        }
        i = j;
      } while (parambfwd.jdField_d_of_type_JavaLangString == null);
      i = j;
    } while (parambfwd.jdField_d_of_type_JavaLangString.indexOf(paramString) <= -1);
    return 3;
  }
  
  protected static final String a(int paramInt1, int paramInt2, String paramString, bfwd parambfwd)
  {
    String str = null;
    if (paramInt1 == 5) {
      parambfwd = parambfwd.jdField_c_of_type_JavaUtilArrayList;
    }
    for (;;)
    {
      if (parambfwd != null)
      {
        paramInt1 = paramString.length();
        str = a(a(paramInt2, parambfwd), b(paramInt1 + paramInt2, parambfwd), parambfwd);
      }
      return str;
      if (paramInt1 == 6) {
        parambfwd = parambfwd.jdField_d_of_type_JavaUtilArrayList;
      } else if (paramInt1 == 2) {
        parambfwd = parambfwd.jdField_a_of_type_JavaUtilArrayList;
      } else if (paramInt1 == 3) {
        parambfwd = parambfwd.jdField_b_of_type_JavaUtilArrayList;
      } else {
        parambfwd = null;
      }
    }
  }
  
  public static String a(int paramInt1, int paramInt2, ArrayList<bfvs> paramArrayList)
  {
    int m = paramArrayList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = 0;
    int k = 0;
    for (;;)
    {
      bfvs localbfvs;
      if (i < m)
      {
        localbfvs = (bfvs)paramArrayList.get(i);
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
        localStringBuilder.append(localbfvs.jdField_a_of_type_JavaLangString);
      }
      j += localbfvs.jdField_a_of_type_Int;
      i += 1;
    }
  }
  
  public static final String a(String paramString, bfwd parambfwd)
  {
    int i = a(paramString, parambfwd);
    int j = a(i, paramString, parambfwd);
    String str = null;
    if (((j == 0) && (i == 5) && (paramString.equalsIgnoreCase(parambfwd.f))) || ((i == 6) && (paramString.equalsIgnoreCase(parambfwd.g)))) {
      str = parambfwd.e;
    }
    do
    {
      return str;
      if (((j == 0) && (i == 2) && (paramString.equalsIgnoreCase(parambfwd.jdField_c_of_type_JavaLangString))) || ((i == 3) && (paramString.equalsIgnoreCase(parambfwd.jdField_d_of_type_JavaLangString)))) {
        return parambfwd.jdField_b_of_type_JavaLangString;
      }
    } while (j <= -1);
    return a(i, j, paramString, parambfwd);
  }
  
  protected static int b(int paramInt, ArrayList<bfvs> paramArrayList)
  {
    int k = paramArrayList.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j = ((bfvs)paramArrayList.get(i)).jdField_a_of_type_Int + j;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfwd
 * JD-Core Version:    0.7.0.1
 */