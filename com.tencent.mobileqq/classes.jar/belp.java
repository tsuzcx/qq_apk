import androidx.annotation.NonNull;
import com.tencent.util.Pair;
import java.util.List;

public class belp
  extends belk
{
  private char jdField_a_of_type_Char;
  private int jdField_a_of_type_Int;
  private belj jdField_a_of_type_Belj = new belj();
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private belj b = new belj();
  private belj c = new belj();
  
  private void a(belm parambelm, String paramString)
  {
    int i = paramString.lastIndexOf('\n');
    if (i < 0)
    {
      parambelm.jdField_a_of_type_Int = paramString.length();
      parambelm.b = 0;
      a(parambelm);
      return;
    }
    parambelm.jdField_a_of_type_Int = (i + 1);
    parambelm.b = (paramString.split("\n", -1).length - 1);
    a(parambelm);
    parambelm.jdField_a_of_type_Int = (paramString.length() - (i + 1));
    parambelm.b = 0;
    a(parambelm);
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.c.toString());
    this.c.c();
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_Belj.toString());
    this.jdField_a_of_type_Belj.c();
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
    belm localbelm = beks.a(paramChar);
    localbelm.jdField_a_of_type_JavaLangString = "";
    a(localbelm, paramString);
  }
  
  void a(char paramChar, String paramString, List<Pair<String, String>> paramList, beko parambeko)
  {
    belm localbelm = beks.a(paramChar);
    localbelm.jdField_a_of_type_JavaLangString = beks.a(paramChar, paramList, parambeko);
    a(localbelm, paramString);
  }
  
  public void a(belm parambelm)
  {
    if (parambelm.jdField_a_of_type_Char == 0) {}
    while (parambelm.jdField_a_of_type_Int == 0) {
      return;
    }
    if (parambelm.jdField_a_of_type_Char == '-')
    {
      if (this.jdField_a_of_type_Char == '=') {
        b();
      }
      this.jdField_a_of_type_Belj.a(parambelm);
      this.jdField_a_of_type_Int -= parambelm.jdField_a_of_type_Int;
    }
    for (;;)
    {
      this.jdField_a_of_type_Char = parambelm.jdField_a_of_type_Char;
      return;
      if (parambelm.jdField_a_of_type_Char == '+')
      {
        if (this.jdField_a_of_type_Char == '=') {
          b();
        }
        this.b.a(parambelm);
        this.jdField_a_of_type_Int += parambelm.jdField_a_of_type_Int;
      }
      else if (parambelm.jdField_a_of_type_Char == '=')
      {
        if (this.jdField_a_of_type_Char != '=') {
          d();
        }
        this.c.a(parambelm);
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Belj.c();
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
 * Qualified Name:     belp
 * JD-Core Version:    0.7.0.1
 */