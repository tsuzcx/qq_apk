import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;

public class bfxj
{
  private int jdField_a_of_type_Int;
  private bfxi jdField_a_of_type_Bfxi;
  private int b;
  private int c = 12;
  private int d = 8;
  
  public bfxj(bfxi parambfxi)
  {
    this.jdField_a_of_type_Bfxi = parambfxi;
  }
  
  private int a(float paramFloat)
  {
    return bawz.a(bfxi.a(this.jdField_a_of_type_Bfxi), paramFloat);
  }
  
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 32;
    case 49: 
      return 33;
    case 50: 
      return 34;
    case 51: 
      return 36;
    }
    return 35;
  }
  
  private static Drawable a(float paramFloat, int paramInt)
  {
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat }, null, null));
    localShapeDrawable.getPaint().setColor(paramInt);
    return localShapeDrawable;
  }
  
  private static Drawable a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = new bfxl(a(paramInt3));
    ((bfxl)localObject).resize(paramInt1, paramInt2);
    localObject = new ShapeDrawable((Shape)localObject);
    ((ShapeDrawable)localObject).setIntrinsicWidth(paramInt1);
    ((ShapeDrawable)localObject).setIntrinsicHeight(paramInt2);
    ((ShapeDrawable)localObject).getPaint().setColor(paramInt4);
    return localObject;
  }
  
  public bfxi a()
  {
    Drawable localDrawable1 = a(a(this.jdField_a_of_type_Int), this.b);
    this.jdField_a_of_type_Bfxi.c(localDrawable1);
    localDrawable1 = a(a(this.c), a(this.d), 49, this.b);
    Drawable localDrawable2 = a(a(this.d), a(this.c), 51, this.b);
    this.jdField_a_of_type_Bfxi.b(localDrawable2);
    this.jdField_a_of_type_Bfxi.a(localDrawable1);
    return this.jdField_a_of_type_Bfxi;
  }
  
  public bfxj a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public bfxj b(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfxj
 * JD-Core Version:    0.7.0.1
 */