abstract class bmem
{
  int jdField_a_of_type_Int = -1;
  final bmeo<? super T> jdField_a_of_type_Bmeo;
  boolean jdField_a_of_type_Boolean;
  
  bmem(bmeo<? super T> parambmeo)
  {
    Object localObject;
    this.jdField_a_of_type_Bmeo = localObject;
  }
  
  void a() {}
  
  void a(boolean paramBoolean)
  {
    int j = 1;
    if (paramBoolean == this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    int i;
    label28:
    bmej localbmej;
    int k;
    if (bmej.a(this.b) == 0)
    {
      i = 1;
      localbmej = this.b;
      k = bmej.a(localbmej);
      if (!this.jdField_a_of_type_Boolean) {
        break label121;
      }
    }
    for (;;)
    {
      bmej.a(localbmej, j + k);
      if ((i != 0) && (this.jdField_a_of_type_Boolean)) {
        this.b.a();
      }
      if ((bmej.a(this.b) == 0) && (!this.jdField_a_of_type_Boolean)) {
        this.b.b();
      }
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      bmej.a(this.b, this);
      return;
      i = 0;
      break label28;
      label121:
      j = -1;
    }
  }
  
  abstract boolean a();
  
  boolean a(bmdn parambmdn)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmem
 * JD-Core Version:    0.7.0.1
 */