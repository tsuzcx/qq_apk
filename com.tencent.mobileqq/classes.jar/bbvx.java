import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;

public class bbvx
{
  public String a;
  public ArrayList<bbvm> a;
  public String b;
  public ArrayList<bbvm> b;
  public String c;
  public ArrayList<bbvm> c;
  public String d;
  public ArrayList<bbvm> d;
  public String e;
  public String f;
  public String g;
  
  public bbvx(Context paramContext, String paramString1, String paramString2, String paramString3)
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
          this.jdField_a_of_type_JavaUtilArrayList.add(new bbvm(paramContext, paramString2, ChnToSpell.a(paramString2, 1).toLowerCase()));
          this.jdField_b_of_type_JavaUtilArrayList.add(new bbvm(paramContext, paramString2, ChnToSpell.a(paramString2, 2).toLowerCase()));
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
          this.jdField_c_of_type_JavaUtilArrayList.add(new bbvm(paramContext, paramString2, ChnToSpell.a(paramString2, 1).toLowerCase()));
          this.jdField_d_of_type_JavaUtilArrayList.add(new bbvm(paramContext, paramString2, ChnToSpell.a(paramString2, 2).toLowerCase()));
        }
        i += 1;
      }
    }
  }
  
  protected static final int a(int paramInt, String paramString, bbvx parambbvx)
  {
    int i = -1;
    if (paramInt == 5) {
      i = parambbvx.f.indexOf(paramString);
    }
    do
    {
      return i;
      if (paramInt == 6) {
        return parambbvx.g.indexOf(paramString);
      }
      if (paramInt == 2) {
        return parambbvx.jdField_c_of_type_JavaLangString.indexOf(paramString);
      }
    } while (paramInt != 3);
    return parambbvx.jdField_d_of_type_JavaLangString.indexOf(paramString);
  }
  
  protected static int a(int paramInt, ArrayList<bbvm> paramArrayList)
  {
    int k = paramArrayList.size();
    int i = 0;
    int j = 0;
    for (;;)
    {
      bbvm localbbvm;
      if (i < k)
      {
        localbbvm = (bbvm)paramArrayList.get(i);
        if (localbbvm.jdField_a_of_type_Int + j <= paramInt) {}
      }
      else
      {
        return j;
      }
      j += localbbvm.jdField_a_of_type_Int;
      i += 1;
    }
  }
  
  protected static final int a(String paramString, bbvx parambbvx)
  {
    int j = 0;
    int i;
    if ((parambbvx.f != null) && (parambbvx.f.indexOf(paramString) > -1)) {
      i = 5;
    }
    do
    {
      do
      {
        return i;
        if ((parambbvx.g != null) && (parambbvx.g.indexOf(paramString) > -1)) {
          return 6;
        }
        if ((parambbvx.jdField_c_of_type_JavaLangString != null) && (parambbvx.jdField_c_of_type_JavaLangString.indexOf(paramString) > -1)) {
          return 2;
        }
        i = j;
      } while (parambbvx.jdField_d_of_type_JavaLangString == null);
      i = j;
    } while (parambbvx.jdField_d_of_type_JavaLangString.indexOf(paramString) <= -1);
    return 3;
  }
  
  protected static final String a(int paramInt1, int paramInt2, String paramString, bbvx parambbvx)
  {
    String str = null;
    if (paramInt1 == 5) {
      parambbvx = parambbvx.jdField_c_of_type_JavaUtilArrayList;
    }
    for (;;)
    {
      if (parambbvx != null)
      {
        paramInt1 = paramString.length();
        str = a(a(paramInt2, parambbvx), b(paramInt1 + paramInt2, parambbvx), parambbvx);
      }
      return str;
      if (paramInt1 == 6) {
        parambbvx = parambbvx.jdField_d_of_type_JavaUtilArrayList;
      } else if (paramInt1 == 2) {
        parambbvx = parambbvx.jdField_a_of_type_JavaUtilArrayList;
      } else if (paramInt1 == 3) {
        parambbvx = parambbvx.jdField_b_of_type_JavaUtilArrayList;
      } else {
        parambbvx = null;
      }
    }
  }
  
  public static String a(int paramInt1, int paramInt2, ArrayList<bbvm> paramArrayList)
  {
    int m = paramArrayList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = 0;
    int k = 0;
    for (;;)
    {
      bbvm localbbvm;
      if (i < m)
      {
        localbbvm = (bbvm)paramArrayList.get(i);
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
        localStringBuilder.append(localbbvm.jdField_a_of_type_JavaLangString);
      }
      j += localbbvm.jdField_a_of_type_Int;
      i += 1;
    }
  }
  
  public static final String a(String paramString, bbvx parambbvx)
  {
    int i = a(paramString, parambbvx);
    int j = a(i, paramString, parambbvx);
    String str = null;
    if (((j == 0) && (i == 5) && (paramString.equalsIgnoreCase(parambbvx.f))) || ((i == 6) && (paramString.equalsIgnoreCase(parambbvx.g)))) {
      str = parambbvx.e;
    }
    do
    {
      return str;
      if (((j == 0) && (i == 2) && (paramString.equalsIgnoreCase(parambbvx.jdField_c_of_type_JavaLangString))) || ((i == 3) && (paramString.equalsIgnoreCase(parambbvx.jdField_d_of_type_JavaLangString)))) {
        return parambbvx.jdField_b_of_type_JavaLangString;
      }
    } while (j <= -1);
    return a(i, j, paramString, parambbvx);
  }
  
  protected static int b(int paramInt, ArrayList<bbvm> paramArrayList)
  {
    int k = paramArrayList.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j = ((bbvm)paramArrayList.get(i)).jdField_a_of_type_Int + j;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbvx
 * JD-Core Version:    0.7.0.1
 */