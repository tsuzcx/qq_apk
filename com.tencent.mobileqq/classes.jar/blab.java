import android.support.annotation.Nullable;
import java.io.File;

public class blab
{
  public static blab a;
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
  public String n;
  
  static
  {
    jdField_a_of_type_Blab = a();
  }
  
  public blab()
  {
    this.jdField_d_of_type_Int = 0;
  }
  
  private static blab a()
  {
    blab localblab = new blab();
    localblab.jdField_a_of_type_JavaLangString = "0";
    localblab.jdField_a_of_type_Int = 0;
    return localblab;
  }
  
  public static boolean a(blab paramblab)
  {
    if (paramblab == null) {}
    while ((paramblab.jdField_a_of_type_JavaLangString != null) && (!paramblab.jdField_a_of_type_JavaLangString.equals("0"))) {
      return false;
    }
    return true;
  }
  
  public static boolean b(@Nullable blab paramblab)
  {
    return (paramblab != null) && ((paramblab.f == 0) || (paramblab.f == 4) || (paramblab.f == 5) || (paramblab.f == 6) || (paramblab.f == 7));
  }
  
  public int a()
  {
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      return -1;
    case 1: 
      return 2130844182;
    case 2: 
      return 2130844183;
    case 3: 
      return 2130844185;
    }
    return 2130844184;
  }
  
  public String a()
  {
    File localFile = new File(bkoz.e);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile.getPath(), this.jdField_a_of_type_JavaLangString).getPath() + File.separator;
  }
  
  public void a(blab paramblab)
  {
    if (!equals(jdField_a_of_type_Blab))
    {
      this.jdField_d_of_type_Boolean = paramblab.jdField_d_of_type_Boolean;
      this.e = paramblab.e;
      this.jdField_a_of_type_Boolean = paramblab.jdField_a_of_type_Boolean;
    }
  }
  
  public boolean a()
  {
    return this.c == 12;
  }
  
  public String b()
  {
    File localFile = new File(bkoz.e);
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
    return new File(bkzy.b(), this.jdField_a_of_type_JavaLangString).getPath();
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
      } while (!(paramObject instanceof blab));
      paramObject = (blab)paramObject;
      if ((paramObject.jdField_a_of_type_JavaLangString == null) && (this.jdField_a_of_type_JavaLangString == null)) {
        return true;
      }
    } while (((paramObject.jdField_a_of_type_JavaLangString == null) && (this.jdField_a_of_type_JavaLangString != null)) || ((paramObject.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString == null)));
    return paramObject.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString);
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (int i1 = 0;; i1 = this.jdField_a_of_type_JavaLangString.hashCode()) {
      return i1 + 31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blab
 * JD-Core Version:    0.7.0.1
 */