import android.support.annotation.Nullable;
import java.io.File;

public class bnke
{
  public static final bnke a;
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
  public int d = 0;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  public int f;
  public String f;
  public boolean f;
  public int g = 0;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  
  static
  {
    jdField_a_of_type_Bnke = a();
  }
  
  private static bnke a()
  {
    bnke localbnke = new bnke();
    localbnke.jdField_a_of_type_JavaLangString = "0";
    localbnke.jdField_a_of_type_Int = 0;
    return localbnke;
  }
  
  public static boolean a(bnke parambnke)
  {
    if (parambnke == null) {}
    while ((parambnke.jdField_a_of_type_JavaLangString != null) && (!parambnke.jdField_a_of_type_JavaLangString.equals("0"))) {
      return false;
    }
    return true;
  }
  
  public static boolean b(@Nullable bnke parambnke)
  {
    return (parambnke != null) && ((parambnke.g == 0) || (parambnke.g == 4) || (parambnke.g == 5) || (parambnke.g == 6) || (parambnke.g == 7));
  }
  
  public int a()
  {
    switch (this.d)
    {
    default: 
      return -1;
    case 1: 
      return 2130844535;
    case 2: 
      return 2130844536;
    case 3: 
      return 2130844538;
    }
    return 2130844537;
  }
  
  public String a()
  {
    File localFile = new File(bmwk.e);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile.getPath(), this.jdField_a_of_type_JavaLangString).getPath() + File.separator;
  }
  
  public void a(bnke parambnke)
  {
    if (!equals(jdField_a_of_type_Bnke))
    {
      this.e = parambnke.e;
      this.f = parambnke.f;
      this.jdField_a_of_type_Boolean = parambnke.jdField_a_of_type_Boolean;
    }
  }
  
  public boolean a()
  {
    return this.c == 12;
  }
  
  public String b()
  {
    File localFile = new File(bmwk.e);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getPath() + File.separator;
  }
  
  public boolean b()
  {
    return this.d != 0;
  }
  
  public String c()
  {
    return new File(bnkb.c(), this.jdField_a_of_type_JavaLangString).getPath();
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
      } while (!(paramObject instanceof bnke));
      paramObject = (bnke)paramObject;
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
 * Qualified Name:     bnke
 * JD-Core Version:    0.7.0.1
 */