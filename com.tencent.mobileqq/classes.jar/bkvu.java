import android.support.annotation.Nullable;
import java.io.File;

public class bkvu
{
  public static bkvu a;
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
    jdField_a_of_type_Bkvu = a();
  }
  
  public bkvu()
  {
    this.jdField_d_of_type_Int = 0;
  }
  
  private static bkvu a()
  {
    bkvu localbkvu = new bkvu();
    localbkvu.jdField_a_of_type_JavaLangString = "0";
    localbkvu.jdField_a_of_type_Int = 0;
    return localbkvu;
  }
  
  public static boolean a(bkvu parambkvu)
  {
    if (parambkvu == null) {}
    while ((parambkvu.jdField_a_of_type_JavaLangString != null) && (!parambkvu.jdField_a_of_type_JavaLangString.equals("0"))) {
      return false;
    }
    return true;
  }
  
  public static boolean b(@Nullable bkvu parambkvu)
  {
    return (parambkvu != null) && ((parambkvu.f == 0) || (parambkvu.f == 4) || (parambkvu.f == 5) || (parambkvu.f == 6) || (parambkvu.f == 7));
  }
  
  public int a()
  {
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      return -1;
    case 1: 
      return 2130844110;
    case 2: 
      return 2130844111;
    case 3: 
      return 2130844113;
    }
    return 2130844112;
  }
  
  public String a()
  {
    File localFile = new File(bkks.e);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile.getPath(), this.jdField_a_of_type_JavaLangString).getPath() + File.separator;
  }
  
  public void a(bkvu parambkvu)
  {
    if (!equals(jdField_a_of_type_Bkvu))
    {
      this.jdField_d_of_type_Boolean = parambkvu.jdField_d_of_type_Boolean;
      this.e = parambkvu.e;
      this.jdField_a_of_type_Boolean = parambkvu.jdField_a_of_type_Boolean;
    }
  }
  
  public boolean a()
  {
    return this.c == 12;
  }
  
  public String b()
  {
    File localFile = new File(bkks.e);
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
    return new File(bkvr.b(), this.jdField_a_of_type_JavaLangString).getPath();
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
      } while (!(paramObject instanceof bkvu));
      paramObject = (bkvu)paramObject;
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
 * Qualified Name:     bkvu
 * JD-Core Version:    0.7.0.1
 */