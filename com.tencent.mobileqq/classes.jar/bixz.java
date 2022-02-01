import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public class bixz
  extends Drawable
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private PathMeasure jdField_a_of_type_AndroidGraphicsPathMeasure;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private final ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private Path jdField_b_of_type_AndroidGraphicsPath;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private final ValueAnimator jdField_c_of_type_AndroidAnimationValueAnimator;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private float e;
  
  public bixz()
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(localResources.getColor(2131167023));
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_Float = agej.a(1.5F, BaseApplicationImpl.getApplication().getResources());
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Float);
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(1400L).setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatMode(1);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new biya(this));
    this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 255 });
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setRepeatCount(0);
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new biyb(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(500L).setInterpolator(new LinearInterpolator());
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setRepeatCount(0);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new biyc(this));
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(localResources, 2130845092);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
  }
  
  private float a(float paramFloat)
  {
    if (paramFloat < 0.5F) {
      return paramFloat;
    }
    return (float)(Math.sin(3.141592653589793D * (paramFloat - 0.5F)) * 0.5D + 0.5D);
  }
  
  private float b(float paramFloat)
  {
    if (paramFloat > 0.5F) {
      return (float)(0.75D * Math.sin(3.141592653589793D * (paramFloat - 0.5F)) + 0.25D);
    }
    return (float)Math.pow(paramFloat, 2.0D);
  }
  
  public void a()
  {
    this.jdField_d_of_type_Int = 2;
    this.jdField_a_of_type_AndroidAnimationValueAnimator.end();
    this.jdField_c_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void b()
  {
    this.jdField_d_of_type_Int = 1;
    this.jdField_c_of_type_Int = 255;
    if (this.jdField_c_of_type_AndroidAnimationValueAnimator.isRunning()) {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.end();
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning()) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.end();
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.end();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void c()
  {
    if (this.jdField_c_of_type_AndroidAnimationValueAnimator.isRunning()) {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.end();
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning()) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.end();
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.end();
    }
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    float f1;
    float f2;
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Int == 0))
    {
      Rect localRect = getBounds();
      this.jdField_a_of_type_Int = localRect.width();
      this.jdField_b_of_type_Int = localRect.height();
      this.e = (Math.min(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int) / 2.0F - this.jdField_a_of_type_Float);
      f1 = this.jdField_a_of_type_Int / 2.0F;
      f2 = this.e;
      float f3 = this.jdField_a_of_type_Int / 2.0F;
      float f4 = this.e;
      float f5 = this.jdField_b_of_type_Int / 2.0F;
      float f6 = this.e;
      float f7 = this.jdField_b_of_type_Int / 2.0F;
      float f8 = this.e;
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addArc(new RectF(f1 - f2, f5 - f6, f3 + f4, f7 + f8), -90.0F, 360.0F);
      this.jdField_b_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPathMeasure = new PathMeasure(this.jdField_a_of_type_AndroidGraphicsPath, false);
      this.jdField_c_of_type_Float = this.jdField_a_of_type_AndroidGraphicsPathMeasure.getLength();
      f1 = this.e * 1.3F;
      f2 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * f1 / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF((this.jdField_a_of_type_Int - f1) / 2.0F, (this.jdField_b_of_type_Int - f2) * 0.57F, (f1 + this.jdField_a_of_type_Int) / 2.0F, f2 + (this.jdField_b_of_type_Int - f2) * 0.57F);
    }
    if (this.jdField_d_of_type_Int == 1)
    {
      this.jdField_b_of_type_AndroidGraphicsPath.reset();
      f1 = b(this.jdField_b_of_type_Float);
      f2 = a(this.jdField_b_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsPathMeasure.getSegment(f1 * this.jdField_c_of_type_Float, f2 * this.jdField_c_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPath, true);
      paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    while (this.jdField_d_of_type_Int != 2) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsRect.right = ((int)(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.jdField_d_of_type_Float));
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.e * 1.3F * this.jdField_d_of_type_Float + this.jdField_a_of_type_AndroidGraphicsRectF.left);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bixz
 * JD-Core Version:    0.7.0.1
 */