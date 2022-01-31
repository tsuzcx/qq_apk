abstract class bmaa
{
  int jdField_a_of_type_Int = -1;
  final bmac<? super T> jdField_a_of_type_Bmac;
  boolean jdField_a_of_type_Boolean;
  
  bmaa(bmac<? super T> parambmac)
  {
    Object localObject;
    this.jdField_a_of_type_Bmac = localObject;
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
    blzx localblzx;
    int k;
    if (blzx.a(this.b) == 0)
    {
      i = 1;
      localblzx = this.b;
      k = blzx.a(localblzx);
      if (!this.jdField_a_of_type_Boolean) {
        break label121;
      }
    }
    for (;;)
    {
      blzx.a(localblzx, j + k);
      if ((i != 0) && (this.jdField_a_of_type_Boolean)) {
        this.b.a();
      }
      if ((blzx.a(this.b) == 0) && (!this.jdField_a_of_type_Boolean)) {
        this.b.b();
      }
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      blzx.a(this.b, this);
      return;
      i = 0;
      break label28;
      label121:
      j = -1;
    }
  }
  
  abstract boolean a();
  
  boolean a(blzb paramblzb)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmaa
 * JD-Core Version:    0.7.0.1
 */