abstract class bhwe
{
  int jdField_a_of_type_Int = -1;
  final bhwg<? super T> jdField_a_of_type_Bhwg;
  boolean jdField_a_of_type_Boolean;
  
  bhwe(bhwg<? super T> parambhwg)
  {
    Object localObject;
    this.jdField_a_of_type_Bhwg = localObject;
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
    bhwc localbhwc;
    int k;
    if (bhwc.a(this.b) == 0)
    {
      i = 1;
      localbhwc = this.b;
      k = bhwc.a(localbhwc);
      if (!this.jdField_a_of_type_Boolean) {
        break label121;
      }
    }
    for (;;)
    {
      bhwc.a(localbhwc, j + k);
      if ((i != 0) && (this.jdField_a_of_type_Boolean)) {
        this.b.a();
      }
      if ((bhwc.a(this.b) == 0) && (!this.jdField_a_of_type_Boolean)) {
        this.b.b();
      }
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      bhwc.a(this.b, this);
      return;
      i = 0;
      break label28;
      label121:
      j = -1;
    }
  }
  
  abstract boolean a();
  
  boolean a(bhvg parambhvg)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhwe
 * JD-Core Version:    0.7.0.1
 */