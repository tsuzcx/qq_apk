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

public class ayjc
{
  private static final float jdField_c_of_type_Float = Resources.getSystem().getDisplayMetrics().density;
  private float jdField_a_of_type_Float;
  public int a;
  private long jdField_a_of_type_Long;
  public Context a;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  public View a;
  private ArrayList<ayjb> jdField_a_of_type_JavaUtilArrayList;
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
      ayjb localayjb = ayjb.a(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j], this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, j, this.jdField_a_of_type_AndroidContentContext.getResources());
      localayjb.jdField_a_of_type_Long = System.currentTimeMillis();
      localayjb.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaUtilArrayList.add(localayjb);
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
    ayjb localayjb;
    float f1;
    float f2;
    if (i < this.jdField_b_of_type_Int)
    {
      localayjb = (ayjb)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localayjb.e = ((float)(System.currentTimeMillis() - localayjb.jdField_a_of_type_Long) / 1000.0F);
      f1 = localayjb.jdField_c_of_type_Float;
      f2 = localayjb.e;
      float f3 = localayjb.d;
      float f4 = localayjb.e;
      float f5 = a(400);
      float f6 = localayjb.e;
      float f7 = localayjb.e;
      localayjb.jdField_a_of_type_ArrayOfFloat[0] = (f1 * f2 + this.jdField_a_of_type_Float);
      localayjb.jdField_a_of_type_ArrayOfFloat[1] = (this.jdField_b_of_type_Float - (f3 * f4 - 0.5F * f5 * f6 * f7));
      if (localayjb.jdField_c_of_type_Int > 200)
      {
        localayjb.jdField_c_of_type_Int -= 1;
        label206:
        if ((localayjb.jdField_c_of_type_Int < 0) || ((this.e > 0) && (localayjb.jdField_a_of_type_ArrayOfFloat[1] > this.e)))
        {
          localayjb.jdField_a_of_type_ArrayOfFloat[0] = this.jdField_a_of_type_Float;
          localayjb.jdField_a_of_type_ArrayOfFloat[1] = this.jdField_b_of_type_Float;
          localayjb.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
          localayjb.jdField_a_of_type_Long = System.currentTimeMillis();
          localayjb.jdField_a_of_type_Double = (Math.random() * 3.141592653589793D / 6.0D + 1.308996938995747D);
          localayjb.jdField_b_of_type_Float = (a(90) + (float)Math.random() * a(50));
          localayjb.jdField_c_of_type_Float = ((float)(localayjb.jdField_b_of_type_Float * Math.cos(localayjb.jdField_a_of_type_Double)));
          localayjb.d = ((float)(localayjb.jdField_b_of_type_Float * Math.sin(localayjb.jdField_a_of_type_Double)));
          localayjb.jdField_a_of_type_Float = ((float)Math.random() * a(18) - a(18));
          int j = (int)(Math.random() * 5.0D);
          Bitmap localBitmap = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j];
          localayjb.jdField_a_of_type_AndroidGraphicsBitmap = ayjb.a(j, localayjb.jdField_a_of_type_Int, localayjb.jdField_b_of_type_Int, localBitmap);
          if (j != 0) {
            break label514;
          }
        }
      }
      label514:
      for (localayjb.jdField_a_of_type_Int = AIOUtils.dp2px(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());; localayjb.jdField_a_of_type_Int = AIOUtils.dp2px(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()))
      {
        localayjb.jdField_b_of_type_Int = ((int)(localayjb.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / localayjb.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * localayjb.jdField_a_of_type_Int));
        i += 1;
        break;
        localayjb.jdField_c_of_type_Int -= (int)(Math.random() * 5.0D + 26.0D);
        break label206;
      }
    }
    i = 0;
    while (i < this.jdField_b_of_type_Int)
    {
      localayjb = (ayjb)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localayjb.jdField_a_of_type_ArrayOfFloat[0] < this.jdField_c_of_type_Int) && (localayjb.jdField_a_of_type_ArrayOfFloat[0] > 0.0F) && (localayjb.jdField_a_of_type_ArrayOfFloat[1] < this.d) && (localayjb.jdField_a_of_type_ArrayOfFloat[1] > 0.0F))
      {
        f1 = localayjb.jdField_a_of_type_Int * 1.0F / localayjb.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
        f2 = localayjb.jdField_b_of_type_Int * 1.0F / localayjb.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
        this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(-localayjb.jdField_a_of_type_Int / 2 / f1, -localayjb.jdField_b_of_type_Int / 2 / f2);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(localayjb.jdField_a_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localayjb.jdField_a_of_type_ArrayOfFloat[0] / f1, localayjb.jdField_a_of_type_ArrayOfFloat[1] / f2);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f1, f2);
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(localayjb.jdField_c_of_type_Int);
        paramCanvas.drawBitmap(localayjb.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
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
 * Qualified Name:     ayjc
 * JD-Core Version:    0.7.0.1
 */