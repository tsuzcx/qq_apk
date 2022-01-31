import android.content.Context;

public class aocy
  extends aocz
{
  private int c = 4;
  private int d = 27;
  
  public aocy(Context paramContext, anyg paramanyg, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramanyg, paramInt);
    a(paramBoolean);
  }
  
  private int a(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt.length + this.d - 1) / this.d;
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c = 5;
      this.d = 34;
      return;
    }
    this.c = 4;
    this.d = 27;
  }
  
  public void a()
  {
    super.a();
  }
  
  public int b()
  {
    return a(this.jdField_a_of_type_ArrayOfInt);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Anyk != null) {
      this.jdField_a_of_type_Anyk.a(this.c, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aocy
 * JD-Core Version:    0.7.0.1
 */