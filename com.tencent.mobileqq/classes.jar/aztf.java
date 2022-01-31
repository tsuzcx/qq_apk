import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;

public class aztf
{
  public String a;
  public ArrayList<azsu> a;
  public String b;
  public ArrayList<azsu> b;
  public String c;
  public ArrayList<azsu> c;
  public String d;
  public ArrayList<azsu> d;
  public String e;
  public String f;
  public String g;
  
  public aztf(Context paramContext, String paramString1, String paramString2, String paramString3)
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
          this.jdField_a_of_type_JavaUtilArrayList.add(new azsu(paramContext, paramString2, ChnToSpell.a(paramString2, 1).toLowerCase()));
          this.jdField_b_of_type_JavaUtilArrayList.add(new azsu(paramContext, paramString2, ChnToSpell.a(paramString2, 2).toLowerCase()));
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
          this.jdField_c_of_type_JavaUtilArrayList.add(new azsu(paramContext, paramString2, ChnToSpell.a(paramString2, 1).toLowerCase()));
          this.jdField_d_of_type_JavaUtilArrayList.add(new azsu(paramContext, paramString2, ChnToSpell.a(paramString2, 2).toLowerCase()));
        }
        i += 1;
      }
    }
  }
  
  protected static final int a(int paramInt, String paramString, aztf paramaztf)
  {
    int i = -1;
    if (paramInt == 5) {
      i = paramaztf.f.indexOf(paramString);
    }
    do
    {
      return i;
      if (paramInt == 6) {
        return paramaztf.g.indexOf(paramString);
      }
      if (paramInt == 2) {
        return paramaztf.jdField_c_of_type_JavaLangString.indexOf(paramString);
      }
    } while (paramInt != 3);
    return paramaztf.jdField_d_of_type_JavaLangString.indexOf(paramString);
  }
  
  protected static int a(int paramInt, ArrayList<azsu> paramArrayList)
  {
    int k = paramArrayList.size();
    int i = 0;
    int j = 0;
    for (;;)
    {
      azsu localazsu;
      if (i < k)
      {
        localazsu = (azsu)paramArrayList.get(i);
        if (localazsu.jdField_a_of_type_Int + j <= paramInt) {}
      }
      else
      {
        return j;
      }
      j += localazsu.jdField_a_of_type_Int;
      i += 1;
    }
  }
  
  protected static final int a(String paramString, aztf paramaztf)
  {
    int j = 0;
    int i;
    if ((paramaztf.f != null) && (paramaztf.f.indexOf(paramString) > -1)) {
      i = 5;
    }
    do
    {
      do
      {
        return i;
        if ((paramaztf.g != null) && (paramaztf.g.indexOf(paramString) > -1)) {
          return 6;
        }
        if ((paramaztf.jdField_c_of_type_JavaLangString != null) && (paramaztf.jdField_c_of_type_JavaLangString.indexOf(paramString) > -1)) {
          return 2;
        }
        i = j;
      } while (paramaztf.jdField_d_of_type_JavaLangString == null);
      i = j;
    } while (paramaztf.jdField_d_of_type_JavaLangString.indexOf(paramString) <= -1);
    return 3;
  }
  
  protected static final String a(int paramInt1, int paramInt2, String paramString, aztf paramaztf)
  {
    String str = null;
    if (paramInt1 == 5) {
      paramaztf = paramaztf.jdField_c_of_type_JavaUtilArrayList;
    }
    for (;;)
    {
      if (paramaztf != null)
      {
        paramInt1 = paramString.length();
        str = a(a(paramInt2, paramaztf), b(paramInt1 + paramInt2, paramaztf), paramaztf);
      }
      return str;
      if (paramInt1 == 6) {
        paramaztf = paramaztf.jdField_d_of_type_JavaUtilArrayList;
      } else if (paramInt1 == 2) {
        paramaztf = paramaztf.jdField_a_of_type_JavaUtilArrayList;
      } else if (paramInt1 == 3) {
        paramaztf = paramaztf.jdField_b_of_type_JavaUtilArrayList;
      } else {
        paramaztf = null;
      }
    }
  }
  
  public static String a(int paramInt1, int paramInt2, ArrayList<azsu> paramArrayList)
  {
    int m = paramArrayList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = 0;
    int k = 0;
    for (;;)
    {
      azsu localazsu;
      if (i < m)
      {
        localazsu = (azsu)paramArrayList.get(i);
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
        localStringBuilder.append(localazsu.jdField_a_of_type_JavaLangString);
      }
      j += localazsu.jdField_a_of_type_Int;
      i += 1;
    }
  }
  
  public static final String a(String paramString, aztf paramaztf)
  {
    int i = a(paramString, paramaztf);
    int j = a(i, paramString, paramaztf);
    String str = null;
    if (((j == 0) && (i == 5) && (paramString.equalsIgnoreCase(paramaztf.f))) || ((i == 6) && (paramString.equalsIgnoreCase(paramaztf.g)))) {
      str = paramaztf.e;
    }
    do
    {
      return str;
      if (((j == 0) && (i == 2) && (paramString.equalsIgnoreCase(paramaztf.jdField_c_of_type_JavaLangString))) || ((i == 3) && (paramString.equalsIgnoreCase(paramaztf.jdField_d_of_type_JavaLangString)))) {
        return paramaztf.jdField_b_of_type_JavaLangString;
      }
    } while (j <= -1);
    return a(i, j, paramString, paramaztf);
  }
  
  protected static int b(int paramInt, ArrayList<azsu> paramArrayList)
  {
    int k = paramArrayList.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j = ((azsu)paramArrayList.get(i)).jdField_a_of_type_Int + j;
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
 * Qualified Name:     aztf
 * JD-Core Version:    0.7.0.1
 */