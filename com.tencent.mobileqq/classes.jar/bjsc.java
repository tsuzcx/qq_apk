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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class bjsc
{
  private static final int i = Color.parseColor("#6BCB1F");
  private static final int j = Color.parseColor("#9CF05B");
  private static final int k = Color.parseColor("#50A80C");
  private static final int l = Color.parseColor("#FA4242");
  private static final int m = Color.parseColor("#FFA194");
  private static final int n = Color.parseColor("#E91D32");
  private int jdField_a_of_type_Int;
  private LinearGradient jdField_a_of_type_AndroidGraphicsLinearGradient;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private int jdField_b_of_type_Int;
  private LinearGradient jdField_b_of_type_AndroidGraphicsLinearGradient;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  private void a(int paramInt)
  {
    float f2 = 3.0F;
    this.h = paramInt;
    Object localObject = BaseApplicationImpl.getContext().getApplicationContext();
    if (this.h == 0)
    {
      f1 = 1.0F;
      this.jdField_a_of_type_Int = AIOUtils.dp2px(f1, ((Context)localObject).getResources());
      if (this.h != 0) {
        break label351;
      }
      f1 = 3.0F;
      label48:
      this.jdField_b_of_type_Int = AIOUtils.dp2px(f1, ((Context)localObject).getResources());
      if (this.h != 0) {
        break label357;
      }
      f1 = f2;
      label70:
      this.c = AIOUtils.dp2px(f1, ((Context)localObject).getResources());
      if (this.h != 0) {
        break label363;
      }
      f1 = 2.0F;
      label92:
      paramInt = AIOUtils.dp2px(f1, ((Context)localObject).getResources());
      if (this.h != 0) {
        break label369;
      }
    }
    label351:
    label357:
    label363:
    label369:
    for (float f1 = 12.0F;; f1 = 24.0F)
    {
      int i1 = AIOUtils.dp2px(f1, ((Context)localObject).getResources());
      this.e = i1;
      this.d = i1;
      this.f = (this.d - this.jdField_a_of_type_Int - paramInt);
      f1 = this.jdField_a_of_type_Int;
      f2 = this.jdField_b_of_type_Int;
      float f3 = this.jdField_a_of_type_Int;
      float f4 = this.e - this.c;
      paramInt = i;
      i1 = j;
      int i2 = k;
      int i3 = k;
      localObject = Shader.TileMode.MIRROR;
      this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(f1, f2, f3, f4, new int[] { paramInt, i1, i2, i3 }, null, (Shader.TileMode)localObject);
      f1 = this.jdField_a_of_type_Int;
      f2 = this.jdField_b_of_type_Int;
      f3 = this.jdField_a_of_type_Int;
      f4 = this.e - this.c;
      paramInt = l;
      i1 = m;
      i2 = n;
      i3 = n;
      localObject = Shader.TileMode.MIRROR;
      this.jdField_b_of_type_AndroidGraphicsLinearGradient = new LinearGradient(f1, f2, f3, f4, new int[] { paramInt, i1, i2, i3 }, null, (Shader.TileMode)localObject);
      return;
      f1 = 5.0F;
      break;
      f1 = 8.0F;
      break label48;
      f1 = 8.0F;
      break label70;
      f1 = 6.0F;
      break label92;
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
    for (int i1 = 2130838124;; i1 = 2130839467)
    {
      paramContext = paramContext.getDrawable(i1);
      paramContext.setBounds(0, 0, this.d, this.e);
      paramContext.draw(paramCanvas);
      return;
    }
  }
  
  public Drawable a(int paramInt1, int paramInt2)
  {
    if ((this.g == paramInt1) && (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) && (paramInt2 == this.h)) {
      return this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
    }
    a(paramInt2);
    this.g = paramInt1;
    long l1 = System.currentTimeMillis();
    Context localContext = BaseApplicationImpl.getContext().getApplicationContext();
    Bitmap localBitmap = Bitmap.createBitmap(this.d, this.e, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    a(localCanvas, localContext);
    a(localCanvas, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineBatteryProducer", 2, "createBatteryDrawable cost time : " + (System.currentTimeMillis() - l1));
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(localContext.getResources(), localBitmap);
    this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.setBounds(0, 0, this.d, this.e);
    return this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjsc
 * JD-Core Version:    0.7.0.1
 */