import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;

public class azwg
  extends BitmapDrawable
{
  private static int d;
  private static int e;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private AccelerateInterpolator jdField_a_of_type_AndroidViewAnimationAccelerateInterpolator = new AccelerateInterpolator(1.5F);
  private float jdField_b_of_type_Float = 0.5F;
  private int jdField_b_of_type_Int = 50;
  private int c;
  
  public azwg(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
  }
  
  public static azwg[] a(int paramInt, Resources paramResources, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramResources != null))
    {
      azwg[] arrayOfazwg2 = new azwg[paramInt];
      e = paramBitmap.getWidth() / 2;
      d = paramBitmap.getHeight() / 2;
      int i = 0;
      for (;;)
      {
        arrayOfazwg1 = arrayOfazwg2;
        if (i >= paramInt) {
          break;
        }
        arrayOfazwg2[i] = new azwg(paramResources, paramBitmap);
        i += 1;
      }
    }
    azwg[] arrayOfazwg1 = null;
    return arrayOfazwg1;
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Float = ((float)paramLong);
    this.jdField_a_of_type_Int = paramInt;
    this.c = 1;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    int j = 1;
    int i = j;
    switch (this.c)
    {
    default: 
      i = j;
    }
    float f2;
    for (;;)
    {
      if (i == 0) {
        invalidateSelf();
      }
      return;
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.c = 2;
      i = 0;
      continue;
      f2 = (float)(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) / this.jdField_a_of_type_Float;
      if (f2 <= 1.0F) {
        break;
      }
      this.c = 3;
      i = j;
    }
    paramCanvas.save();
    float f3 = this.jdField_a_of_type_AndroidViewAnimationAccelerateInterpolator.getInterpolation(f2);
    if (f3 > 0.5F) {}
    for (float f1 = -f3 * this.jdField_b_of_type_Int;; f1 = -(1.0F - f3) * this.jdField_b_of_type_Int)
    {
      paramCanvas.translate(f1, this.jdField_a_of_type_Int - f3 * this.jdField_a_of_type_Int);
      paramCanvas.scale(this.jdField_b_of_type_Float * f2, this.jdField_b_of_type_Float * f2, e, d);
      setAlpha((int)(255.0F - f2 * 255.0F));
      super.draw(paramCanvas);
      paramCanvas.restore();
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azwg
 * JD-Core Version:    0.7.0.1
 */