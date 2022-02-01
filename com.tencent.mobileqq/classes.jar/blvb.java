import android.support.annotation.Nullable;
import java.io.File;

public class blvb
{
  public static final blvb a;
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
    jdField_a_of_type_Blvb = a();
  }
  
  private static blvb a()
  {
    blvb localblvb = new blvb();
    localblvb.jdField_a_of_type_JavaLangString = "0";
    localblvb.jdField_a_of_type_Int = 0;
    return localblvb;
  }
  
  public static boolean a(blvb paramblvb)
  {
    if (paramblvb == null) {}
    while ((paramblvb.jdField_a_of_type_JavaLangString != null) && (!paramblvb.jdField_a_of_type_JavaLangString.equals("0"))) {
      return false;
    }
    return true;
  }
  
  public static boolean b(@Nullable blvb paramblvb)
  {
    return (paramblvb != null) && ((paramblvb.g == 0) || (paramblvb.g == 4) || (paramblvb.g == 5) || (paramblvb.g == 6) || (paramblvb.g == 7));
  }
  
  public int a()
  {
    switch (this.d)
    {
    default: 
      return -1;
    case 1: 
      return 2130844468;
    case 2: 
      return 2130844469;
    case 3: 
      return 2130844471;
    }
    return 2130844470;
  }
  
  public String a()
  {
    File localFile = new File(bljm.e);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile.getPath(), this.jdField_a_of_type_JavaLangString).getPath() + File.separator;
  }
  
  public void a(blvb paramblvb)
  {
    if (!equals(jdField_a_of_type_Blvb))
    {
      this.e = paramblvb.e;
      this.f = paramblvb.f;
      this.jdField_a_of_type_Boolean = paramblvb.jdField_a_of_type_Boolean;
    }
  }
  
  public boolean a()
  {
    return this.c == 12;
  }
  
  public String b()
  {
    File localFile = new File(bljm.e);
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
    return new File(bluy.c(), this.jdField_a_of_type_JavaLangString).getPath();
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
      } while (!(paramObject instanceof blvb));
      paramObject = (blvb)paramObject;
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
 * Qualified Name:     blvb
 * JD-Core Version:    0.7.0.1
 */