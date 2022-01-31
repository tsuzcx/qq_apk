abstract class bjnz
{
  int jdField_a_of_type_Int = -1;
  final bjob<? super T> jdField_a_of_type_Bjob;
  boolean jdField_a_of_type_Boolean;
  
  bjnz(bjob<? super T> parambjob)
  {
    Object localObject;
    this.jdField_a_of_type_Bjob = localObject;
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
    bjnx localbjnx;
    int k;
    if (bjnx.a(this.b) == 0)
    {
      i = 1;
      localbjnx = this.b;
      k = bjnx.a(localbjnx);
      if (!this.jdField_a_of_type_Boolean) {
        break label121;
      }
    }
    for (;;)
    {
      bjnx.a(localbjnx, j + k);
      if ((i != 0) && (this.jdField_a_of_type_Boolean)) {
        this.b.a();
      }
      if ((bjnx.a(this.b) == 0) && (!this.jdField_a_of_type_Boolean)) {
        this.b.b();
      }
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      bjnx.a(this.b, this);
      return;
      i = 0;
      break label28;
      label121:
      j = -1;
    }
  }
  
  abstract boolean a();
  
  boolean a(bjnb parambjnb)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjnz
 * JD-Core Version:    0.7.0.1
 */