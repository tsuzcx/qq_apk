import android.content.Context;

public class apuy
  extends apuz
{
  private int c = 4;
  private int d = 27;
  
  public apuy(Context paramContext, appt paramappt, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramappt, paramInt);
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
    if (this.jdField_a_of_type_Appz != null) {
      this.jdField_a_of_type_Appz.a(this.c, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apuy
 * JD-Core Version:    0.7.0.1
 */