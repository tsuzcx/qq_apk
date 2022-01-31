abstract class bjoq
{
  int jdField_a_of_type_Int = -1;
  final bjos<? super T> jdField_a_of_type_Bjos;
  boolean jdField_a_of_type_Boolean;
  
  bjoq(bjos<? super T> parambjos)
  {
    Object localObject;
    this.jdField_a_of_type_Bjos = localObject;
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
    bjoo localbjoo;
    int k;
    if (bjoo.a(this.b) == 0)
    {
      i = 1;
      localbjoo = this.b;
      k = bjoo.a(localbjoo);
      if (!this.jdField_a_of_type_Boolean) {
        break label121;
      }
    }
    for (;;)
    {
      bjoo.a(localbjoo, j + k);
      if ((i != 0) && (this.jdField_a_of_type_Boolean)) {
        this.b.a();
      }
      if ((bjoo.a(this.b) == 0) && (!this.jdField_a_of_type_Boolean)) {
        this.b.b();
      }
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      bjoo.a(this.b, this);
      return;
      i = 0;
      break label28;
      label121:
      j = -1;
    }
  }
  
  abstract boolean a();
  
  boolean a(bjns parambjns)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjoq
 * JD-Core Version:    0.7.0.1
 */