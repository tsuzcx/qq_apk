import android.support.annotation.Nullable;
import java.io.File;

public class biqn
{
  public static biqn a;
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
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
  public int f = 0;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  
  static
  {
    jdField_a_of_type_Biqn = a();
  }
  
  public biqn()
  {
    this.jdField_d_of_type_Int = 0;
  }
  
  private static biqn a()
  {
    biqn localbiqn = new biqn();
    localbiqn.jdField_a_of_type_JavaLangString = "0";
    localbiqn.jdField_a_of_type_Int = 0;
    return localbiqn;
  }
  
  public static boolean a(biqn parambiqn)
  {
    if (parambiqn == null) {}
    while ((parambiqn.jdField_a_of_type_JavaLangString != null) && (!parambiqn.jdField_a_of_type_JavaLangString.equals("0"))) {
      return false;
    }
    return true;
  }
  
  public static boolean b(@Nullable biqn parambiqn)
  {
    return (parambiqn != null) && ((parambiqn.f == 0) || (parambiqn.f == 4) || (parambiqn.f == 5) || (parambiqn.f == 6) || (parambiqn.f == 7));
  }
  
  public int a()
  {
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      return -1;
    case 1: 
      return 2130843766;
    case 2: 
      return 2130843767;
    case 3: 
      return 2130843769;
    }
    return 2130843768;
  }
  
  public String a()
  {
    File localFile = new File(biid.e);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile.getPath(), this.jdField_a_of_type_JavaLangString).getPath() + File.separator;
  }
  
  public void a(biqn parambiqn)
  {
    if (!equals(jdField_a_of_type_Biqn))
    {
      this.jdField_d_of_type_Boolean = parambiqn.jdField_d_of_type_Boolean;
      this.e = parambiqn.e;
      this.jdField_a_of_type_Boolean = parambiqn.jdField_a_of_type_Boolean;
    }
  }
  
  public boolean a()
  {
    return this.c == 12;
  }
  
  public String b()
  {
    File localFile = new File(biid.e);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getPath() + File.separator;
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Int != 0;
  }
  
  public String c()
  {
    return new File(biqk.b(), this.jdField_a_of_type_JavaLangString).getPath();
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
      } while (!(paramObject instanceof biqn));
      paramObject = (biqn)paramObject;
      if ((paramObject.jdField_a_of_type_JavaLangString == null) && (this.jdField_a_of_type_JavaLangString == null)) {
        return true;
      }
    } while (((paramObject.jdField_a_of_type_JavaLangString == null) && (this.jdField_a_of_type_JavaLangString != null)) || ((paramObject.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString == null)));
    return paramObject.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString);
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (int n = 0;; n = this.jdField_a_of_type_JavaLangString.hashCode()) {
      return n + 31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biqn
 * JD-Core Version:    0.7.0.1
 */