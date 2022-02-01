import androidx.annotation.NonNull;

public class belj
  extends belk
{
  int jdField_a_of_type_Int = 0;
  private belk jdField_a_of_type_Belk = new belk();
  belm jdField_a_of_type_Belm = new belm();
  
  public void a()
  {
    a(false);
  }
  
  public void a(belm parambelm)
  {
    belm localbelm;
    if (parambelm.jdField_a_of_type_Int > 0)
    {
      if ((this.jdField_a_of_type_Belm.jdField_a_of_type_Char != parambelm.jdField_a_of_type_Char) || (!belw.a(this.jdField_a_of_type_Belm.jdField_a_of_type_JavaLangString, parambelm.jdField_a_of_type_JavaLangString))) {
        break label135;
      }
      if (parambelm.b > 0)
      {
        localbelm = this.jdField_a_of_type_Belm;
        localbelm.jdField_a_of_type_Int += this.jdField_a_of_type_Int + parambelm.jdField_a_of_type_Int;
        localbelm = this.jdField_a_of_type_Belm;
        localbelm.b += parambelm.b;
        this.jdField_a_of_type_Int = 0;
      }
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_Belm.b == 0)
    {
      localbelm = this.jdField_a_of_type_Belm;
      localbelm.jdField_a_of_type_Int += parambelm.jdField_a_of_type_Int;
      return;
    }
    this.jdField_a_of_type_Int += parambelm.jdField_a_of_type_Int;
    return;
    label135:
    a();
    beks.a(parambelm, this.jdField_a_of_type_Belm);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Belm.jdField_a_of_type_Char != 0) {
      if ((!paramBoolean) || (this.jdField_a_of_type_Belm.jdField_a_of_type_Char != '=') || (!belw.a(this.jdField_a_of_type_Belm.jdField_a_of_type_JavaLangString))) {
        break label48;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Belm.jdField_a_of_type_Char = '\000';
      return;
      label48:
      this.jdField_a_of_type_Belk.a(this.jdField_a_of_type_Belm);
      if (this.jdField_a_of_type_Int > 0)
      {
        this.jdField_a_of_type_Belm.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Belm.b = 0;
        this.jdField_a_of_type_Belk.a(this.jdField_a_of_type_Belm);
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
    this.jdField_a_of_type_Belk.c();
    beks.a(this.jdField_a_of_type_Belm);
  }
  
  @NonNull
  public String toString()
  {
    a();
    return this.jdField_a_of_type_Belk.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     belj
 * JD-Core Version:    0.7.0.1
 */