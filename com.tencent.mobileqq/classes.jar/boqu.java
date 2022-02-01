import android.support.annotation.Nullable;
import java.io.File;

public class boqu
{
  public static final boqu a;
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
    jdField_a_of_type_Boqu = a();
  }
  
  private static boqu a()
  {
    boqu localboqu = new boqu();
    localboqu.jdField_a_of_type_JavaLangString = "0";
    localboqu.jdField_a_of_type_Int = 0;
    return localboqu;
  }
  
  public static boolean a(boqu paramboqu)
  {
    if (paramboqu == null) {}
    while ((paramboqu.jdField_a_of_type_JavaLangString != null) && (!paramboqu.jdField_a_of_type_JavaLangString.equals("0"))) {
      return false;
    }
    return true;
  }
  
  public static boolean b(@Nullable boqu paramboqu)
  {
    return (paramboqu != null) && ((paramboqu.g == 0) || (paramboqu.g == 4) || (paramboqu.g == 5) || (paramboqu.g == 6) || (paramboqu.g == 7));
  }
  
  public int a()
  {
    switch (this.d)
    {
    default: 
      return -1;
    case 1: 
      return 2130844592;
    case 2: 
      return 2130844593;
    case 3: 
      return 2130844595;
    }
    return 2130844594;
  }
  
  public String a()
  {
    File localFile = new File(boev.e);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile.getPath(), this.jdField_a_of_type_JavaLangString).getPath() + File.separator;
  }
  
  public void a(boqu paramboqu)
  {
    if (!equals(jdField_a_of_type_Boqu))
    {
      this.e = paramboqu.e;
      this.f = paramboqu.f;
      this.jdField_a_of_type_Boolean = paramboqu.jdField_a_of_type_Boolean;
    }
  }
  
  public boolean a()
  {
    return this.c == 12;
  }
  
  public String b()
  {
    File localFile = new File(boev.e);
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
    return new File(boqr.c(), this.jdField_a_of_type_JavaLangString).getPath();
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
      } while (!(paramObject instanceof boqu));
      paramObject = (boqu)paramObject;
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
 * Qualified Name:     boqu
 * JD-Core Version:    0.7.0.1
 */