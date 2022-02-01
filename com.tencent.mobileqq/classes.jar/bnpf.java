import android.support.annotation.Nullable;
import java.io.File;

public class bnpf
{
  public static bnpf a;
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
    jdField_a_of_type_Bnpf = a();
  }
  
  private static bnpf a()
  {
    bnpf localbnpf = new bnpf();
    localbnpf.jdField_a_of_type_JavaLangString = "0";
    localbnpf.jdField_a_of_type_Int = 0;
    return localbnpf;
  }
  
  public static boolean a(bnpf parambnpf)
  {
    if (parambnpf == null) {}
    while ((parambnpf.jdField_a_of_type_JavaLangString != null) && (!parambnpf.jdField_a_of_type_JavaLangString.equals("0"))) {
      return false;
    }
    return true;
  }
  
  public static boolean b(@Nullable bnpf parambnpf)
  {
    return (parambnpf != null) && ((parambnpf.g == 0) || (parambnpf.g == 4) || (parambnpf.g == 5) || (parambnpf.g == 6) || (parambnpf.g == 7));
  }
  
  public int a()
  {
    switch (this.d)
    {
    default: 
      return -1;
    case 1: 
      return 2130844578;
    case 2: 
      return 2130844579;
    case 3: 
      return 2130844581;
    }
    return 2130844580;
  }
  
  public String a()
  {
    File localFile = new File(bndm.e);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile.getPath(), this.jdField_a_of_type_JavaLangString).getPath() + File.separator;
  }
  
  public void a(bnpf parambnpf)
  {
    if (!equals(jdField_a_of_type_Bnpf))
    {
      this.e = parambnpf.e;
      this.f = parambnpf.f;
      this.jdField_a_of_type_Boolean = parambnpf.jdField_a_of_type_Boolean;
    }
  }
  
  public boolean a()
  {
    return this.c == 12;
  }
  
  public String b()
  {
    File localFile = new File(bndm.e);
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
    return new File(bnpc.b(), this.jdField_a_of_type_JavaLangString).getPath();
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
      } while (!(paramObject instanceof bnpf));
      paramObject = (bnpf)paramObject;
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
 * Qualified Name:     bnpf
 * JD-Core Version:    0.7.0.1
 */