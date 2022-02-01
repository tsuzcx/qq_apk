import androidx.annotation.NonNull;

public class bemd
  extends beme
{
  int jdField_a_of_type_Int = 0;
  private beme jdField_a_of_type_Beme = new beme();
  bemg jdField_a_of_type_Bemg = new bemg();
  
  public void a()
  {
    a(false);
  }
  
  public void a(bemg parambemg)
  {
    bemg localbemg;
    if (parambemg.jdField_a_of_type_Int > 0)
    {
      if ((this.jdField_a_of_type_Bemg.jdField_a_of_type_Char != parambemg.jdField_a_of_type_Char) || (!bemq.a(this.jdField_a_of_type_Bemg.jdField_a_of_type_JavaLangString, parambemg.jdField_a_of_type_JavaLangString))) {
        break label135;
      }
      if (parambemg.b > 0)
      {
        localbemg = this.jdField_a_of_type_Bemg;
        localbemg.jdField_a_of_type_Int += this.jdField_a_of_type_Int + parambemg.jdField_a_of_type_Int;
        localbemg = this.jdField_a_of_type_Bemg;
        localbemg.b += parambemg.b;
        this.jdField_a_of_type_Int = 0;
      }
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_Bemg.b == 0)
    {
      localbemg = this.jdField_a_of_type_Bemg;
      localbemg.jdField_a_of_type_Int += parambemg.jdField_a_of_type_Int;
      return;
    }
    this.jdField_a_of_type_Int += parambemg.jdField_a_of_type_Int;
    return;
    label135:
    a();
    belm.a(parambemg, this.jdField_a_of_type_Bemg);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bemg.jdField_a_of_type_Char != 0) {
      if ((!paramBoolean) || (this.jdField_a_of_type_Bemg.jdField_a_of_type_Char != '=') || (!bemq.a(this.jdField_a_of_type_Bemg.jdField_a_of_type_JavaLangString))) {
        break label48;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bemg.jdField_a_of_type_Char = '\000';
      return;
      label48:
      this.jdField_a_of_type_Beme.a(this.jdField_a_of_type_Bemg);
      if (this.jdField_a_of_type_Int > 0)
      {
        this.jdField_a_of_type_Bemg.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Bemg.b = 0;
        this.jdField_a_of_type_Beme.a(this.jdField_a_of_type_Bemg);
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
    this.jdField_a_of_type_Beme.c();
    belm.a(this.jdField_a_of_type_Bemg);
  }
  
  @NonNull
  public String toString()
  {
    a();
    return this.jdField_a_of_type_Beme.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bemd
 * JD-Core Version:    0.7.0.1
 */