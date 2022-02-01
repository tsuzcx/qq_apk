import android.graphics.drawable.ColorDrawable;

public class asbg
  extends ColorDrawable
{
  private int a;
  private int b;
  
  public asbg(int paramInt1, int paramInt2)
  {
    super(0);
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public asbg(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.a = paramInt2;
    this.b = paramInt3;
  }
  
  public int getIntrinsicHeight()
  {
    return this.b;
  }
  
  public int getIntrinsicWidth()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbg
 * JD-Core Version:    0.7.0.1
 */