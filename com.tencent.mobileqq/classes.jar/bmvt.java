import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.ArrayList;

public class bmvt
  extends bmuu
{
  public static final int a;
  public float a;
  public Paint a;
  bmuq a;
  public bmvs a;
  public float b;
  public int b;
  public Paint b;
  public int c = aepi.a(6.0F, BaseApplicationImpl.getContext().getResources());
  
  static
  {
    jdField_a_of_type_Int = bnfa.a[1];
  }
  
  public bmvt(bmuq parambmuq)
  {
    this.jdField_b_of_type_Int = jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.c);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(jdField_a_of_type_Int);
    this.jdField_a_of_type_Bmuq = parambmuq;
  }
  
  private void a(Paint paramPaint, bmvs parambmvs)
  {
    paramPaint.setXfermode(null);
    paramPaint.setColor(parambmvs.jdField_b_of_type_Int);
    paramPaint.setStrokeWidth(parambmvs.c);
    paramPaint.setShader(null);
  }
  
  public Paint a()
  {
    return this.jdField_b_of_type_AndroidGraphicsPaint;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.c);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(Canvas paramCanvas, bmur parambmur, Paint paramPaint)
  {
    if ((parambmur instanceof bmvs))
    {
      parambmur = (bmvs)parambmur;
      if (parambmur.jdField_a_of_type_AndroidGraphicsPath != null)
      {
        a(paramPaint, parambmur);
        paramCanvas.drawPath(parambmur.jdField_a_of_type_AndroidGraphicsPath, paramPaint);
      }
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_a_of_type_Bmvs = new bmvs(new Path(), 101, this.jdField_a_of_type_AndroidGraphicsPaint.getColor(), this.c);
      if (this.jdField_a_of_type_Bmuq != null) {
        this.jdField_a_of_type_Bmuq.a(this.jdField_a_of_type_Bmvs);
      }
      DoodleLayout.a("use_graffiti");
      this.jdField_a_of_type_Bmvs.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_Bmvs.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, f2);
      this.jdField_a_of_type_Bmvs.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1 + 1.0F, f2 + 1.0F);
      this.jdField_a_of_type_Bmvs.jdField_a_of_type_JavaUtilArrayList.add(new bmvr(bmvr.jdField_a_of_type_Int, f1, f2));
      this.jdField_a_of_type_Bmvs.jdField_a_of_type_JavaUtilArrayList.add(new bmvr(bmvr.jdField_b_of_type_Int, f1 + 1.0F, f2 + 1.0F));
      continue;
      float f3 = (this.jdField_a_of_type_Float + f1) / 2.0F;
      float f4 = (this.jdField_b_of_type_Float + f2) / 2.0F;
      if (this.jdField_a_of_type_Bmvs != null)
      {
        this.jdField_a_of_type_Bmvs.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, f3, f4);
        this.jdField_a_of_type_Bmvs.jdField_a_of_type_JavaUtilArrayList.add(new bmvr(bmvr.c, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, f3, f4));
      }
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
    }
  }
  
  public Paint b()
  {
    return this.jdField_a_of_type_AndroidGraphicsPaint;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Int = jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(jdField_a_of_type_Int);
    this.jdField_a_of_type_Bmvs = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvt
 * JD-Core Version:    0.7.0.1
 */