import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

public class bfww
{
  private TypedArray a;
  
  public bfww(TypedArray paramTypedArray)
  {
    this.a = paramTypedArray;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 >= 0) {
      i = this.a.getInt(paramInt1, paramInt2);
    }
    return i;
  }
  
  public Drawable a(int paramInt)
  {
    if (paramInt >= 0) {
      return this.a.getDrawable(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.a.recycle();
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramInt >= 0) {
      bool = this.a.getBoolean(paramInt, paramBoolean);
    }
    return bool;
  }
  
  public CharSequence[] a(int paramInt)
  {
    if (paramInt >= 0) {
      return this.a.getTextArray(paramInt);
    }
    return null;
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 >= 0) {
      i = this.a.getColor(paramInt1, paramInt2);
    }
    return i;
  }
  
  public int c(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 >= 0) {
      i = this.a.getDimensionPixelSize(paramInt1, paramInt2);
    }
    return i;
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfww
 * JD-Core Version:    0.7.0.1
 */