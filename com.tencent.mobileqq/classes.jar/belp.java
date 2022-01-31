import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class belp
{
  private int jdField_a_of_type_Int;
  private LinearGradient jdField_a_of_type_AndroidGraphicsLinearGradient;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private int jdField_b_of_type_Int;
  private LinearGradient jdField_b_of_type_AndroidGraphicsLinearGradient;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private final int h;
  
  public belp(int paramInt)
  {
    this.h = paramInt;
    Object localObject = BaseApplicationImpl.getContext().getApplicationContext();
    this.jdField_a_of_type_Int = aciy.a(1.0F, ((Context)localObject).getResources());
    if (this.h == 0)
    {
      f1 = 3.0F;
      this.jdField_b_of_type_Int = aciy.a(f1, ((Context)localObject).getResources());
      f1 = f3;
      if (this.h == 0) {
        f1 = 3.0F;
      }
      this.c = aciy.a(f1, ((Context)localObject).getResources());
      f1 = f2;
      if (this.h == 0) {
        f1 = 2.0F;
      }
      paramInt = aciy.a(f1, ((Context)localObject).getResources());
      if (this.h != 0) {
        break label384;
      }
    }
    label384:
    for (float f1 = 12.0F;; f1 = 16.0F)
    {
      int i = aciy.a(f1, ((Context)localObject).getResources());
      this.e = i;
      this.d = i;
      this.f = (this.d - this.jdField_a_of_type_Int - paramInt);
      paramInt = Color.parseColor("#6BCB1F");
      i = Color.parseColor("#9CF05B");
      int j = Color.parseColor("#50A80C");
      int k = Color.parseColor("#50A80C");
      f1 = this.jdField_a_of_type_Int;
      f2 = this.jdField_b_of_type_Int;
      f3 = this.jdField_a_of_type_Int;
      float f4 = this.e - this.c;
      localObject = Shader.TileMode.MIRROR;
      this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(f1, f2, f3, f4, new int[] { paramInt, i, j, k }, null, (Shader.TileMode)localObject);
      paramInt = Color.parseColor("#FA4242");
      i = Color.parseColor("#FFA194");
      j = Color.parseColor("#E91D32");
      k = Color.parseColor("#E91D32");
      f1 = this.jdField_a_of_type_Int;
      f2 = this.jdField_b_of_type_Int;
      f3 = this.jdField_a_of_type_Int;
      f4 = this.e - this.c;
      localObject = Shader.TileMode.MIRROR;
      this.jdField_b_of_type_AndroidGraphicsLinearGradient = new LinearGradient(f1, f2, f3, f4, new int[] { paramInt, i, j, k }, null, (Shader.TileMode)localObject);
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
      return;
      f1 = 4.0F;
      break;
    }
  }
  
  private void a(Canvas paramCanvas, int paramInt)
  {
    paramInt = Math.min(Math.max(paramInt, 1), 100);
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    if (paramInt > 20) {}
    for (LinearGradient localLinearGradient = this.jdField_a_of_type_AndroidGraphicsLinearGradient;; localLinearGradient = this.jdField_b_of_type_AndroidGraphicsLinearGradient)
    {
      localPaint.setShader(localLinearGradient);
      paramInt = this.f * paramInt / 100;
      paramCanvas.drawRect(new Rect(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt + this.jdField_a_of_type_Int, this.e - this.c), this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
  }
  
  private void a(Canvas paramCanvas, Context paramContext)
  {
    paramContext = paramContext.getResources();
    if (this.h == 0) {}
    for (int i = 2130837929;; i = 2130839137)
    {
      paramContext = paramContext.getDrawable(i);
      paramContext.setBounds(0, 0, this.d, this.e);
      paramContext.draw(paramCanvas);
      return;
    }
  }
  
  public Drawable a(int paramInt)
  {
    if ((this.g == paramInt) && (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null)) {
      return this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
    }
    this.g = paramInt;
    long l = System.currentTimeMillis();
    Context localContext = BaseApplicationImpl.getContext().getApplicationContext();
    Bitmap localBitmap = Bitmap.createBitmap(this.d, this.e, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    a(localCanvas, localContext);
    a(localCanvas, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineBatteryProducer", 2, "createBatteryDrawable cost time : " + (System.currentTimeMillis() - l));
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(localContext.getResources(), localBitmap);
    this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.setBounds(0, 0, this.d, this.e);
    return this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     belp
 * JD-Core Version:    0.7.0.1
 */