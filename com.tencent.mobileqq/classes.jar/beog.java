import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.mobileqq.theme.ThemeUtil;

public class beog
{
  public static int a;
  public static int b;
  public static int c = 3;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  boolean jdField_a_of_type_Boolean = true;
  boolean b;
  int d;
  private int e = jdField_a_of_type_Int;
  private int f = ThemeUtil.NIGHTMODE_MASKCOLOR;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
  }
  
  public beog()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
    this.d = this.jdField_a_of_type_AndroidGraphicsPaint.getColor();
  }
  
  public static boolean a()
  {
    return ("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId));
  }
  
  public static boolean b()
  {
    return "2920".equals(ThemeUtil.curThemeId);
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(Canvas paramCanvas, beoh parambeoh)
  {
    if ((paramCanvas == null) || (parambeoh == null)) {
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (a()))
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, parambeoh.getWidth(), parambeoh.getHeight());
      int i = this.e;
      if (b()) {
        i = c;
      }
      if (i == jdField_a_of_type_Int)
      {
        parambeoh.a(paramCanvas);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(null);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.f);
        paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY(), this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
      }
      if (i == jdField_b_of_type_Int)
      {
        parambeoh.a(paramCanvas);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(null);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.f);
        paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
      }
      if (this.jdField_a_of_type_AndroidGraphicsPaint.getColorFilter() == null) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.d);
      paramCanvas.saveLayer(null, this.jdField_a_of_type_AndroidGraphicsPaint, 31);
      parambeoh.a(paramCanvas);
      paramCanvas.restore();
      return;
    }
    parambeoh.a(paramCanvas);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     beog
 * JD-Core Version:    0.7.0.1
 */