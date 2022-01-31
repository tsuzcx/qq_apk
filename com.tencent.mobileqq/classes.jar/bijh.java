import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class bijh
  extends bika
{
  public int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private PointF jdField_a_of_type_AndroidGraphicsPointF;
  private bira jdField_a_of_type_Bira;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 45.0F;
  public int b;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  public int d;
  int e = 0;
  int f = 0;
  private int g;
  
  public bijh(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#12B7F5"));
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint.setPathEffect(new DashPathEffect(new float[] { 5.0F, 5.0F, 5.0F, 5.0F }, 1.0F));
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getResources().getDisplayMetrics();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = localDisplayMetrics.widthPixels;
    this.c = 0;
    this.d = localDisplayMetrics.heightPixels;
    if (bjeh.b()) {
      this.d = (localDisplayMetrics.heightPixels - bjeh.e - bjeh.jdField_a_of_type_Int);
    }
    double d1 = Math.pow(localDisplayMetrics.heightPixels, 2.0D);
    this.g = ((int)Math.sqrt(Math.pow(localDisplayMetrics.widthPixels, 2.0D) + d1));
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(this.jdField_b_of_type_Int / 2, this.d / 2);
    this.jdField_a_of_type_Bira = new bira();
    this.jdField_a_of_type_Bira.a(true);
    this.jdField_a_of_type_Bira.a(18.0F);
    this.jdField_a_of_type_Bira.b(0.5F);
  }
  
  public String a()
  {
    return "GuideLineLayer";
  }
  
  public void a() {}
  
  public void a(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return;
    }
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  protected void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    if (QLog.isColorLevel()) {
      QLog.d("GuideLineLayer", 2, "onLayerDraw  showGuideLine : " + this.jdField_b_of_type_Boolean + " currentDegree : " + this.jdField_b_of_type_Float + " centerPoint.x " + this.jdField_a_of_type_AndroidGraphicsPointF.x + " centerPoint.y : " + this.jdField_a_of_type_AndroidGraphicsPointF.y + " isDualFinger : " + this.jdField_a_of_type_Boolean + " transX : " + this.e + " transY : " + this.f + " maxLength : " + this.g);
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (Math.abs((int)this.jdField_b_of_type_Float % 45) < 3))
    {
      paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
      paramCanvas.translate(this.e, this.f);
      int i = Math.round(this.jdField_b_of_type_Float / 45.0F) * 45;
      if (QLog.isColorLevel()) {
        QLog.d("GuideLineLayer", 2, "currentDegree : " + this.jdField_b_of_type_Float + "   guideLine Angle : " + i);
      }
      paramCanvas.rotate(i);
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(-this.g, 0.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.g, 0.0F);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
      if (QLog.isColorLevel()) {
        QLog.d("GuideLineLayer", 2, "draw angle guide line");
      }
    }
    paramCanvas.restore();
    paramCanvas.save();
    if ((this.jdField_b_of_type_Boolean) && (Math.abs(this.jdField_a_of_type_AndroidGraphicsPointF.x + this.e - (this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2) < 4.0F))
    {
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2, 0.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2, this.d);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (QLog.isColorLevel()) {
        QLog.d("GuideLineLayer", 2, "draw X guide line");
      }
    }
    if ((this.jdField_b_of_type_Boolean) && (Math.abs(this.jdField_a_of_type_AndroidGraphicsPointF.y + this.f - (this.c + this.d) / 2) < 4.0F))
    {
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_Int, (this.c + this.d) / 2);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_b_of_type_Int, (this.c + this.d) / 2);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (QLog.isColorLevel()) {
        QLog.d("GuideLineLayer", 2, "draw Y guide line");
      }
    }
    paramCanvas.restore();
  }
  
  public void a(PointF paramPointF)
  {
    if (paramPointF == null) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPointF.set(paramPointF);
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuideLineLayer", 2, "GuideLineLayer refreshed, entrance : " + paramInt3);
    }
    this.jdField_b_of_type_Boolean = paramBoolean1;
    a(paramFloat);
    b(paramInt1);
    c(paramInt2);
    a(paramPointF);
    this.jdField_a_of_type_Boolean = paramBoolean2;
    k();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(long paramLong)
  {
    return true;
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void b(Canvas paramCanvas) {}
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void c(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bijh
 * JD-Core Version:    0.7.0.1
 */