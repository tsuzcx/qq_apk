import android.support.annotation.Nullable;
import java.io.File;

public class bgya
{
  public static bgya a;
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b = 0;
  public long b;
  public String b;
  public boolean b;
  public int c = 0;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  
  static
  {
    jdField_a_of_type_Bgya = a();
  }
  
  public bgya()
  {
    this.jdField_e_of_type_Int = 0;
  }
  
  private static bgya a()
  {
    bgya localbgya = new bgya();
    localbgya.jdField_a_of_type_JavaLangString = "0";
    localbgya.jdField_a_of_type_Int = 0;
    return localbgya;
  }
  
  public static boolean a(bgya parambgya)
  {
    if (parambgya == null) {}
    while ((parambgya.jdField_a_of_type_JavaLangString != null) && (!parambgya.jdField_a_of_type_JavaLangString.equals("0"))) {
      return false;
    }
    return true;
  }
  
  public static boolean b(@Nullable bgya parambgya)
  {
    return (parambgya != null) && ((parambgya.jdField_e_of_type_Int == 0) || (parambgya.jdField_e_of_type_Int == 4) || (parambgya.jdField_e_of_type_Int == 5) || (parambgya.jdField_e_of_type_Int == 6) || (parambgya.jdField_e_of_type_Int == 7));
  }
  
  public int a()
  {
    switch (this.c)
    {
    default: 
      return -1;
    case 1: 
      return 2130843685;
    case 2: 
      return 2130843686;
    case 3: 
      return 2130843688;
    }
    return 2130843687;
  }
  
  public String a()
  {
    return new File(bgxx.d, this.jdField_a_of_type_JavaLangString).getPath();
  }
  
  public void a(bgya parambgya)
  {
    if (!equals(jdField_a_of_type_Bgya))
    {
      this.d = parambgya.d;
      this.jdField_e_of_type_Boolean = parambgya.jdField_e_of_type_Boolean;
      this.jdField_a_of_type_Boolean = parambgya.jdField_a_of_type_Boolean;
    }
  }
  
  public boolean a()
  {
    return this.b == 12;
  }
  
  public String b()
  {
    return bgxx.d;
  }
  
  public boolean b()
  {
    return this.c != 0;
  }
  
  public String c()
  {
    return new File(bgxx.b(), this.jdField_a_of_type_JavaLangString).getPath();
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.equals("0"));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof bgya));
      paramObject = (bgya)paramObject;
      if ((paramObject.jdField_a_of_type_JavaLangString == null) && (this.jdField_a_of_type_JavaLangString == null)) {
        return true;
      }
    } while (((paramObject.jdField_a_of_type_JavaLangString == null) && (this.jdField_a_of_type_JavaLangString != null)) || ((paramObject.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString == null)));
    return paramObject.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString);
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (int m = 0;; m = this.jdField_a_of_type_JavaLangString.hashCode()) {
      return m + 31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bgya
 * JD-Core Version:    0.7.0.1
 */