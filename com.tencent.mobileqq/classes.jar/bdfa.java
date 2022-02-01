import androidx.annotation.NonNull;

public class bdfa
  extends bdfb
{
  int jdField_a_of_type_Int = 0;
  private bdfb jdField_a_of_type_Bdfb = new bdfb();
  bdfd jdField_a_of_type_Bdfd = new bdfd();
  
  public void a()
  {
    a(false);
  }
  
  public void a(bdfd parambdfd)
  {
    bdfd localbdfd;
    if (parambdfd.jdField_a_of_type_Int > 0)
    {
      if ((this.jdField_a_of_type_Bdfd.jdField_a_of_type_Char != parambdfd.jdField_a_of_type_Char) || (!bdfn.a(this.jdField_a_of_type_Bdfd.jdField_a_of_type_JavaLangString, parambdfd.jdField_a_of_type_JavaLangString))) {
        break label135;
      }
      if (parambdfd.b > 0)
      {
        localbdfd = this.jdField_a_of_type_Bdfd;
        localbdfd.jdField_a_of_type_Int += this.jdField_a_of_type_Int + parambdfd.jdField_a_of_type_Int;
        localbdfd = this.jdField_a_of_type_Bdfd;
        localbdfd.b += parambdfd.b;
        this.jdField_a_of_type_Int = 0;
      }
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_Bdfd.b == 0)
    {
      localbdfd = this.jdField_a_of_type_Bdfd;
      localbdfd.jdField_a_of_type_Int += parambdfd.jdField_a_of_type_Int;
      return;
    }
    this.jdField_a_of_type_Int += parambdfd.jdField_a_of_type_Int;
    return;
    label135:
    a();
    bdej.a(parambdfd, this.jdField_a_of_type_Bdfd);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bdfd.jdField_a_of_type_Char != 0) {
      if ((!paramBoolean) || (this.jdField_a_of_type_Bdfd.jdField_a_of_type_Char != '=') || (!bdfn.a(this.jdField_a_of_type_Bdfd.jdField_a_of_type_JavaLangString))) {
        break label48;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdfd.jdField_a_of_type_Char = '\000';
      return;
      label48:
      this.jdField_a_of_type_Bdfb.a(this.jdField_a_of_type_Bdfd);
      if (this.jdField_a_of_type_Int > 0)
      {
        this.jdField_a_of_type_Bdfd.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Bdfd.b = 0;
        this.jdField_a_of_type_Bdfb.a(this.jdField_a_of_type_Bdfd);
        this.jdField_a_of_type_Int = 0;
      }
    }
  }
  
  public void b()
  {
    a(true);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bdfb.c();
    bdej.a(this.jdField_a_of_type_Bdfd);
  }
  
  @NonNull
  public String toString()
  {
    a();
    return this.jdField_a_of_type_Bdfb.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdfa
 * JD-Core Version:    0.7.0.1
 */