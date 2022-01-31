import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;
import java.util.ArrayList;

public class aurn
{
  private static final float jdField_c_of_type_Float = Resources.getSystem().getDisplayMetrics().density;
  private float jdField_a_of_type_Float;
  public int a;
  private long jdField_a_of_type_Long;
  public Context a;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  public View a;
  private ArrayList<aurm> jdField_a_of_type_JavaUtilArrayList;
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
      aurm localaurm = aurm.a(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j], this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, j, this.jdField_a_of_type_AndroidContentContext.getResources());
      localaurm.jdField_a_of_type_Long = System.currentTimeMillis();
      localaurm.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaUtilArrayList.add(localaurm);
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
    aurm localaurm;
    float f1;
    float f2;
    if (i < this.jdField_b_of_type_Int)
    {
      localaurm = (aurm)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localaurm.e = ((float)(System.currentTimeMillis() - localaurm.jdField_a_of_type_Long) / 1000.0F);
      f1 = localaurm.jdField_c_of_type_Float;
      f2 = localaurm.e;
      float f3 = localaurm.d;
      float f4 = localaurm.e;
      float f5 = a(400);
      float f6 = localaurm.e;
      float f7 = localaurm.e;
      localaurm.jdField_a_of_type_ArrayOfFloat[0] = (f1 * f2 + this.jdField_a_of_type_Float);
      localaurm.jdField_a_of_type_ArrayOfFloat[1] = (this.jdField_b_of_type_Float - (f3 * f4 - 0.5F * f5 * f6 * f7));
      if (localaurm.jdField_c_of_type_Int > 200)
      {
        localaurm.jdField_c_of_type_Int -= 1;
        label206:
        if ((localaurm.jdField_c_of_type_Int < 0) || ((this.e > 0) && (localaurm.jdField_a_of_type_ArrayOfFloat[1] > this.e)))
        {
          localaurm.jdField_a_of_type_ArrayOfFloat[0] = this.jdField_a_of_type_Float;
          localaurm.jdField_a_of_type_ArrayOfFloat[1] = this.jdField_b_of_type_Float;
          localaurm.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
          localaurm.jdField_a_of_type_Long = System.currentTimeMillis();
          localaurm.jdField_a_of_type_Double = (Math.random() * 3.141592653589793D / 6.0D + 1.308996938995747D);
          localaurm.jdField_b_of_type_Float = (a(90) + (float)Math.random() * a(50));
          localaurm.jdField_c_of_type_Float = ((float)(localaurm.jdField_b_of_type_Float * Math.cos(localaurm.jdField_a_of_type_Double)));
          localaurm.d = ((float)(localaurm.jdField_b_of_type_Float * Math.sin(localaurm.jdField_a_of_type_Double)));
          localaurm.jdField_a_of_type_Float = ((float)Math.random() * a(18) - a(18));
          int j = (int)(Math.random() * 5.0D);
          Bitmap localBitmap = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j];
          localaurm.jdField_a_of_type_AndroidGraphicsBitmap = aurm.a(j, localaurm.jdField_a_of_type_Int, localaurm.jdField_b_of_type_Int, localBitmap);
          if (j != 0) {
            break label514;
          }
        }
      }
      label514:
      for (localaurm.jdField_a_of_type_Int = actn.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());; localaurm.jdField_a_of_type_Int = actn.a(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()))
      {
        localaurm.jdField_b_of_type_Int = ((int)(localaurm.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / localaurm.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * localaurm.jdField_a_of_type_Int));
        i += 1;
        break;
        localaurm.jdField_c_of_type_Int -= (int)(Math.random() * 5.0D + 26.0D);
        break label206;
      }
    }
    i = 0;
    while (i < this.jdField_b_of_type_Int)
    {
      localaurm = (aurm)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localaurm.jdField_a_of_type_ArrayOfFloat[0] < this.jdField_c_of_type_Int) && (localaurm.jdField_a_of_type_ArrayOfFloat[0] > 0.0F) && (localaurm.jdField_a_of_type_ArrayOfFloat[1] < this.d) && (localaurm.jdField_a_of_type_ArrayOfFloat[1] > 0.0F))
      {
        f1 = localaurm.jdField_a_of_type_Int * 1.0F / localaurm.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
        f2 = localaurm.jdField_b_of_type_Int * 1.0F / localaurm.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
        this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(-localaurm.jdField_a_of_type_Int / 2 / f1, -localaurm.jdField_b_of_type_Int / 2 / f2);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(localaurm.jdField_a_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localaurm.jdField_a_of_type_ArrayOfFloat[0] / f1, localaurm.jdField_a_of_type_ArrayOfFloat[1] / f2);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f1, f2);
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(localaurm.jdField_c_of_type_Int);
        paramCanvas.drawBitmap(localaurm.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aurn
 * JD-Core Version:    0.7.0.1
 */