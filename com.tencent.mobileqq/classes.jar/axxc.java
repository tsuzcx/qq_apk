import android.support.annotation.NonNull;

class axxc
{
  private int jdField_a_of_type_Int;
  private axxd jdField_a_of_type_Axxd;
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  private int c;
  
  axxc(int paramInt1, int paramInt2, @NonNull axxd paramaxxd)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_Axxd = paramaxxd;
  }
  
  void a()
  {
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      i = this.jdField_a_of_type_Int;
      int j = this.c;
      this.c = (j + 1);
      if (j >= i - 1)
      {
        this.c = 0;
        if (this.jdField_a_of_type_Boolean) {
          break label72;
        }
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Axxd.a(this.jdField_a_of_type_Boolean);
      return;
      i = this.b;
      break;
    }
  }
  
  void b()
  {
    this.c = 0;
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxc
 * JD-Core Version:    0.7.0.1
 */