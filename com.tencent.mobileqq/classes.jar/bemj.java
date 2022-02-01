import androidx.annotation.NonNull;
import com.tencent.util.Pair;
import java.util.List;

public class bemj
  extends beme
{
  private char jdField_a_of_type_Char;
  private int jdField_a_of_type_Int;
  private bemd jdField_a_of_type_Bemd = new bemd();
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private bemd b = new bemd();
  private bemd c = new bemd();
  
  private void a(bemg parambemg, String paramString)
  {
    int i = paramString.lastIndexOf('\n');
    if (i < 0)
    {
      parambemg.jdField_a_of_type_Int = paramString.length();
      parambemg.b = 0;
      a(parambemg);
      return;
    }
    parambemg.jdField_a_of_type_Int = (i + 1);
    parambemg.b = (paramString.split("\n", -1).length - 1);
    a(parambemg);
    parambemg.jdField_a_of_type_Int = (paramString.length() - (i + 1));
    parambemg.b = 0;
    a(parambemg);
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.c.toString());
    this.c.c();
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_Bemd.toString());
    this.jdField_a_of_type_Bemd.c();
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.b.toString());
    this.b.c();
  }
  
  int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    this.c.b();
  }
  
  void a(char paramChar, String paramString)
  {
    bemg localbemg = belm.a(paramChar);
    localbemg.jdField_a_of_type_JavaLangString = "";
    a(localbemg, paramString);
  }
  
  void a(char paramChar, String paramString, List<Pair<String, String>> paramList, beli parambeli)
  {
    bemg localbemg = belm.a(paramChar);
    localbemg.jdField_a_of_type_JavaLangString = belm.a(paramChar, paramList, parambeli);
    a(localbemg, paramString);
  }
  
  public void a(bemg parambemg)
  {
    if (parambemg.jdField_a_of_type_Char == 0) {}
    while (parambemg.jdField_a_of_type_Int == 0) {
      return;
    }
    if (parambemg.jdField_a_of_type_Char == '-')
    {
      if (this.jdField_a_of_type_Char == '=') {
        b();
      }
      this.jdField_a_of_type_Bemd.a(parambemg);
      this.jdField_a_of_type_Int -= parambemg.jdField_a_of_type_Int;
    }
    for (;;)
    {
      this.jdField_a_of_type_Char = parambemg.jdField_a_of_type_Char;
      return;
      if (parambemg.jdField_a_of_type_Char == '+')
      {
        if (this.jdField_a_of_type_Char == '=') {
          b();
        }
        this.b.a(parambemg);
        this.jdField_a_of_type_Int += parambemg.jdField_a_of_type_Int;
      }
      else if (parambemg.jdField_a_of_type_Char == '=')
      {
        if (this.jdField_a_of_type_Char != '=') {
          d();
        }
        this.c.a(parambemg);
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bemd.c();
    this.b.c();
    this.c.c();
    this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
    this.jdField_a_of_type_Int = 0;
  }
  
  @NonNull
  public String toString()
  {
    d();
    b();
    return this.jdField_a_of_type_JavaLangStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bemj
 * JD-Core Version:    0.7.0.1
 */