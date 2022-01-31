import android.graphics.drawable.ColorDrawable;

public class apgg
  extends ColorDrawable
{
  private int a;
  private int b;
  
  public apgg(int paramInt1, int paramInt2)
  {
    super(0);
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public apgg(int paramInt1, int paramInt2, int paramInt3)
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
 * Qualified Name:     apgg
 * JD-Core Version:    0.7.0.1
 */