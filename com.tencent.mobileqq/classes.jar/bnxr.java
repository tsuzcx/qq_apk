import android.graphics.Rect;

public class bnxr
{
  public Rect a;
  public float[] a;
  
  public bnxr(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int a()
  {
    return Math.abs(this.a.left - this.a.right) * Math.abs(this.a.top - this.a.bottom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnxr
 * JD-Core Version:    0.7.0.1
 */