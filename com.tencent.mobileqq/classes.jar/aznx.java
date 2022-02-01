import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;

public class aznx
{
  private static final float jdField_c_of_type_Float = Resources.getSystem().getDisplayMetrics().density;
  private float jdField_a_of_type_Float;
  public int a;
  private long jdField_a_of_type_Long;
  public Context a;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  public View a;
  private ArrayList<aznw> jdField_a_of_type_JavaUtilArrayList;
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
      aznw localaznw = aznw.a(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j], this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, j, this.jdField_a_of_type_AndroidContentContext.getResources());
      localaznw.jdField_a_of_type_Long = System.currentTimeMillis();
      localaznw.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaUtilArrayList.add(localaznw);
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
    aznw localaznw;
    float f1;
    float f2;
    if (i < this.jdField_b_of_type_Int)
    {
      localaznw = (aznw)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localaznw.e = ((float)(System.currentTimeMillis() - localaznw.jdField_a_of_type_Long) / 1000.0F);
      f1 = localaznw.jdField_c_of_type_Float;
      f2 = localaznw.e;
      float f3 = localaznw.d;
      float f4 = localaznw.e;
      float f5 = a(400);
      float f6 = localaznw.e;
      float f7 = localaznw.e;
      localaznw.jdField_a_of_type_ArrayOfFloat[0] = (f1 * f2 + this.jdField_a_of_type_Float);
      localaznw.jdField_a_of_type_ArrayOfFloat[1] = (this.jdField_b_of_type_Float - (f3 * f4 - 0.5F * f5 * f6 * f7));
      if (localaznw.jdField_c_of_type_Int > 200)
      {
        localaznw.jdField_c_of_type_Int -= 1;
        label206:
        if ((localaznw.jdField_c_of_type_Int < 0) || ((this.e > 0) && (localaznw.jdField_a_of_type_ArrayOfFloat[1] > this.e)))
        {
          localaznw.jdField_a_of_type_ArrayOfFloat[0] = this.jdField_a_of_type_Float;
          localaznw.jdField_a_of_type_ArrayOfFloat[1] = this.jdField_b_of_type_Float;
          localaznw.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
          localaznw.jdField_a_of_type_Long = System.currentTimeMillis();
          localaznw.jdField_a_of_type_Double = (Math.random() * 3.141592653589793D / 6.0D + 1.308996938995747D);
          localaznw.jdField_b_of_type_Float = (a(90) + (float)Math.random() * a(50));
          localaznw.jdField_c_of_type_Float = ((float)(localaznw.jdField_b_of_type_Float * Math.cos(localaznw.jdField_a_of_type_Double)));
          localaznw.d = ((float)(localaznw.jdField_b_of_type_Float * Math.sin(localaznw.jdField_a_of_type_Double)));
          localaznw.jdField_a_of_type_Float = ((float)Math.random() * a(18) - a(18));
          int j = (int)(Math.random() * 5.0D);
          Bitmap localBitmap = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j];
          localaznw.jdField_a_of_type_AndroidGraphicsBitmap = aznw.a(j, localaznw.jdField_a_of_type_Int, localaznw.jdField_b_of_type_Int, localBitmap);
          if (j != 0) {
            break label514;
          }
        }
      }
      label514:
      for (localaznw.jdField_a_of_type_Int = AIOUtils.dp2px(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());; localaznw.jdField_a_of_type_Int = AIOUtils.dp2px(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()))
      {
        localaznw.jdField_b_of_type_Int = ((int)(localaznw.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / localaznw.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * localaznw.jdField_a_of_type_Int));
        i += 1;
        break;
        localaznw.jdField_c_of_type_Int -= (int)(Math.random() * 5.0D + 26.0D);
        break label206;
      }
    }
    i = 0;
    while (i < this.jdField_b_of_type_Int)
    {
      localaznw = (aznw)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localaznw.jdField_a_of_type_ArrayOfFloat[0] < this.jdField_c_of_type_Int) && (localaznw.jdField_a_of_type_ArrayOfFloat[0] > 0.0F) && (localaznw.jdField_a_of_type_ArrayOfFloat[1] < this.d) && (localaznw.jdField_a_of_type_ArrayOfFloat[1] > 0.0F))
      {
        f1 = localaznw.jdField_a_of_type_Int * 1.0F / localaznw.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
        f2 = localaznw.jdField_b_of_type_Int * 1.0F / localaznw.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
        this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(-localaznw.jdField_a_of_type_Int / 2 / f1, -localaznw.jdField_b_of_type_Int / 2 / f2);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(localaznw.jdField_a_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localaznw.jdField_a_of_type_ArrayOfFloat[0] / f1, localaznw.jdField_a_of_type_ArrayOfFloat[1] / f2);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f1, f2);
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(localaznw.jdField_c_of_type_Int);
        paramCanvas.drawBitmap(localaznw.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
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
 * Qualified Name:     aznx
 * JD-Core Version:    0.7.0.1
 */