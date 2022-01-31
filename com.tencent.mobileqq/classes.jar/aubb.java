import android.text.TextUtils;
import com.tencent.qphone.base.util.MD5;
import java.util.Map;

public class aubb
{
  public int a;
  public String a;
  public Map<Integer, String> a;
  public int b;
  public int c;
  public int d;
  
  public aubb(int paramInt1, int paramInt2, Map<Integer, String> paramMap)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_a_of_type_JavaLangString = null;
    this.d = paramInt2;
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      paramMap = new StringBuilder();
      paramMap.append(paramInt1);
      paramInt1 = 0;
      while (paramInt1 <= 4)
      {
        String str = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
        if (str != null) {
          paramMap.append(str);
        }
        paramInt1 += 1;
      }
      this.jdField_a_of_type_JavaLangString = paramMap.toString();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = MD5.toMD5(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private String b(int paramInt)
  {
    Object localObject = null;
    int i = 1;
    while ((TextUtils.isEmpty((CharSequence)localObject)) && (i < 5))
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf((paramInt + i) % 5));
      i += 1;
    }
    return localObject;
  }
  
  public String a()
  {
    Object localObject = null;
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      String str = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1));
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = b(1);
      }
    }
    return localObject;
  }
  
  public String a(int paramInt)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      if (paramInt > 100) {
        break label51;
      }
    }
    label51:
    for (paramInt = 3;; paramInt = 2)
    {
      String str = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = b(paramInt);
      }
      return localObject;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof aubb)) {
      bool = azzz.a(((aubb)paramObject).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubb
 * JD-Core Version:    0.7.0.1
 */