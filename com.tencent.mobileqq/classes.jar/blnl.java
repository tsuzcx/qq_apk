import android.graphics.Bitmap;
import android.graphics.Rect;

public class blnl
{
  public final int a;
  public final boolean a;
  public final int b;
  public final int c;
  public final int d;
  public final int e;
  public final int f;
  public final int g;
  
  public blnl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6, int paramInt7)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.f = paramInt5;
    this.e = paramInt6;
    this.g = paramInt7;
  }
  
  public static blnl a(Bitmap paramBitmap, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    return new blnl(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramBoolean, paramInt1, paramInt2, paramInt3);
  }
  
  public static blnl a(Rect paramRect, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    return new blnl(paramRect.left, paramRect.top, paramRect.width(), paramRect.height(), paramBoolean, paramInt1, paramInt2, paramInt3);
  }
  
  public String toString()
  {
    return "CropConfig{x=" + this.jdField_a_of_type_Int + ", y=" + this.b + ", width=" + this.c + ", height=" + this.d + ", addPadding=" + this.jdField_a_of_type_Boolean + ", verticalPadding=" + this.e + ", horizontalPadding=" + this.f + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blnl
 * JD-Core Version:    0.7.0.1
 */