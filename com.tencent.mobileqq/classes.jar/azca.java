import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;
import java.util.ArrayList;

public class azca
{
  private static final float jdField_c_of_type_Float = Resources.getSystem().getDisplayMetrics().density;
  private float jdField_a_of_type_Float;
  public int a;
  private long jdField_a_of_type_Long;
  public Context a;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  public View a;
  private ArrayList<azbz> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private Bitmap[] jdField_a_of_type_ArrayOfAndroidGraphicsBitmap;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private int jdField_c_of_type_Int;
  private int d;
  private int e;
  
  public static int a(int paramInt)
  {
    return Math.round(paramInt * jdField_c_of_type_Float);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = (int)(5.0D * Math.random());
      azbz localazbz = azbz.a(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j], this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, j, this.jdField_a_of_type_AndroidContentContext.getResources());
      localazbz.jdField_a_of_type_Long = System.currentTimeMillis();
      localazbz.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaUtilArrayList.add(localazbz);
      i += 1;
    }
    this.jdField_b_of_type_Int += paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Float = paramInt1;
    this.jdField_b_of_type_Float = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.d = paramInt2;
    this.e = (paramInt2 * 3 / 8);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > 400L)
    {
      this.jdField_a_of_type_Long = l;
      if (this.jdField_b_of_type_Int <= 5) {
        a(1);
      }
    }
    int i = 0;
    azbz localazbz;
    float f1;
    float f2;
    if (i < this.jdField_b_of_type_Int)
    {
      localazbz = (azbz)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localazbz.e = ((float)(System.currentTimeMillis() - localazbz.jdField_a_of_type_Long) / 1000.0F);
      f1 = localazbz.jdField_c_of_type_Float;
      f2 = localazbz.e;
      float f3 = localazbz.d;
      float f4 = localazbz.e;
      float f5 = a(400);
      float f6 = localazbz.e;
      float f7 = localazbz.e;
      localazbz.jdField_a_of_type_ArrayOfFloat[0] = (f1 * f2 + this.jdField_a_of_type_Float);
      localazbz.jdField_a_of_type_ArrayOfFloat[1] = (this.jdField_b_of_type_Float - (f3 * f4 - 0.5F * f5 * f6 * f7));
      if (localazbz.jdField_c_of_type_Int > 200)
      {
        localazbz.jdField_c_of_type_Int -= 1;
        label206:
        if ((localazbz.jdField_c_of_type_Int < 0) || ((this.e > 0) && (localazbz.jdField_a_of_type_ArrayOfFloat[1] > this.e)))
        {
          localazbz.jdField_a_of_type_ArrayOfFloat[0] = this.jdField_a_of_type_Float;
          localazbz.jdField_a_of_type_ArrayOfFloat[1] = this.jdField_b_of_type_Float;
          localazbz.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
          localazbz.jdField_a_of_type_Long = System.currentTimeMillis();
          localazbz.jdField_a_of_type_Double = (Math.random() * 3.141592653589793D / 6.0D + 1.308996938995747D);
          localazbz.jdField_b_of_type_Float = (a(90) + (float)Math.random() * a(50));
          localazbz.jdField_c_of_type_Float = ((float)(localazbz.jdField_b_of_type_Float * Math.cos(localazbz.jdField_a_of_type_Double)));
          localazbz.d = ((float)(localazbz.jdField_b_of_type_Float * Math.sin(localazbz.jdField_a_of_type_Double)));
          localazbz.jdField_a_of_type_Float = ((float)Math.random() * a(18) - a(18));
          int j = (int)(Math.random() * 5.0D);
          Bitmap localBitmap = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j];
          localazbz.jdField_a_of_type_AndroidGraphicsBitmap = azbz.a(j, localazbz.jdField_a_of_type_Int, localazbz.jdField_b_of_type_Int, localBitmap);
          if (j != 0) {
            break label514;
          }
        }
      }
      label514:
      for (localazbz.jdField_a_of_type_Int = afur.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());; localazbz.jdField_a_of_type_Int = afur.a(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()))
      {
        localazbz.jdField_b_of_type_Int = ((int)(localazbz.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / localazbz.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * localazbz.jdField_a_of_type_Int));
        i += 1;
        break;
        localazbz.jdField_c_of_type_Int -= (int)(Math.random() * 5.0D + 26.0D);
        break label206;
      }
    }
    i = 0;
    while (i < this.jdField_b_of_type_Int)
    {
      localazbz = (azbz)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localazbz.jdField_a_of_type_ArrayOfFloat[0] < this.jdField_c_of_type_Int) && (localazbz.jdField_a_of_type_ArrayOfFloat[0] > 0.0F) && (localazbz.jdField_a_of_type_ArrayOfFloat[1] < this.d) && (localazbz.jdField_a_of_type_ArrayOfFloat[1] > 0.0F))
      {
        f1 = localazbz.jdField_a_of_type_Int * 1.0F / localazbz.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
        f2 = localazbz.jdField_b_of_type_Int * 1.0F / localazbz.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
        this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(-localazbz.jdField_a_of_type_Int / 2 / f1, -localazbz.jdField_b_of_type_Int / 2 / f2);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(localazbz.jdField_a_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localazbz.jdField_a_of_type_ArrayOfFloat[0] / f1, localazbz.jdField_a_of_type_ArrayOfFloat[1] / f2);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f1, f2);
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(localazbz.jdField_c_of_type_Int);
        paramCanvas.drawBitmap(localazbz.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      i += 1;
    }
    a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    a();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azca
 * JD-Core Version:    0.7.0.1
 */