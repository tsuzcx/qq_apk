import androidx.annotation.NonNull;
import com.tencent.util.Pair;
import java.util.List;

public class bdfg
  extends bdfb
{
  private char jdField_a_of_type_Char;
  private int jdField_a_of_type_Int;
  private bdfa jdField_a_of_type_Bdfa = new bdfa();
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private bdfa b = new bdfa();
  private bdfa c = new bdfa();
  
  private void a(bdfd parambdfd, String paramString)
  {
    int i = paramString.lastIndexOf('\n');
    if (i < 0)
    {
      parambdfd.jdField_a_of_type_Int = paramString.length();
      parambdfd.b = 0;
      a(parambdfd);
      return;
    }
    parambdfd.jdField_a_of_type_Int = (i + 1);
    parambdfd.b = (paramString.split("\n", -1).length - 1);
    a(parambdfd);
    parambdfd.jdField_a_of_type_Int = (paramString.length() - (i + 1));
    parambdfd.b = 0;
    a(parambdfd);
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.c.toString());
    this.c.c();
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_Bdfa.toString());
    this.jdField_a_of_type_Bdfa.c();
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
    bdfd localbdfd = bdej.a(paramChar);
    localbdfd.jdField_a_of_type_JavaLangString = "";
    a(localbdfd, paramString);
  }
  
  void a(char paramChar, String paramString, List<Pair<String, String>> paramList, bdef parambdef)
  {
    bdfd localbdfd = bdej.a(paramChar);
    localbdfd.jdField_a_of_type_JavaLangString = bdej.a(paramChar, paramList, parambdef);
    a(localbdfd, paramString);
  }
  
  public void a(bdfd parambdfd)
  {
    if (parambdfd.jdField_a_of_type_Char == 0) {}
    while (parambdfd.jdField_a_of_type_Int == 0) {
      return;
    }
    if (parambdfd.jdField_a_of_type_Char == '-')
    {
      if (this.jdField_a_of_type_Char == '=') {
        b();
      }
      this.jdField_a_of_type_Bdfa.a(parambdfd);
      this.jdField_a_of_type_Int -= parambdfd.jdField_a_of_type_Int;
    }
    for (;;)
    {
      this.jdField_a_of_type_Char = parambdfd.jdField_a_of_type_Char;
      return;
      if (parambdfd.jdField_a_of_type_Char == '+')
      {
        if (this.jdField_a_of_type_Char == '=') {
          b();
        }
        this.b.a(parambdfd);
        this.jdField_a_of_type_Int += parambdfd.jdField_a_of_type_Int;
      }
      else if (parambdfd.jdField_a_of_type_Char == '=')
      {
        if (this.jdField_a_of_type_Char != '=') {
          d();
        }
        this.c.a(parambdfd);
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bdfa.c();
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
 * Qualified Name:     bdfg
 * JD-Core Version:    0.7.0.1
 */