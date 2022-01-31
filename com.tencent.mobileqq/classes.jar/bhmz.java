import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import java.util.List;

public class bhmz
  extends bhna
{
  private Paint a;
  private RectF b;
  private float c;
  private int e = Color.parseColor("#FFFFFF");
  
  public bhmz(int paramInt, List<String> paramList)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(16777215);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(230);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float + this.c * 2.0F;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(230);
    this.e = paramInt;
    if ((paramInt == Color.parseColor("#FFFFFF")) || (paramInt == Color.parseColor("#F7E368")) || (paramInt == Color.parseColor("#7ED5F8")))
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#000000"));
      return;
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#ffffff"));
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    this.c = (((int)Math.ceil(this.jdField_b_of_type_Float) + 32) / 2.0F);
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_AndroidTextStaticLayout != null)
    {
      if (this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount() == 1)
      {
        paramCanvas.save();
        paramCanvas.translate(a() / 2.0F, b() / 2.0F);
        this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
        String str2 = super.b(0);
        String str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = "　　";
        }
        int i = (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(str1);
        int j = (int)Math.ceil(this.jdField_a_of_type_AndroidTextTextPaint.descent() - this.jdField_a_of_type_AndroidTextTextPaint.ascent());
        f1 = (j + 32) / 2.0F;
        this.jdField_b_of_type_AndroidGraphicsRectF.left = (-(i + f1 * 2.0F) / 2.0F);
        this.jdField_b_of_type_AndroidGraphicsRectF.right = ((i + f1 * 2.0F) / 2.0F);
        this.jdField_b_of_type_AndroidGraphicsRectF.top = (-(j + 32) / 2.0F);
        this.jdField_b_of_type_AndroidGraphicsRectF.bottom = ((j + 32) / 2.0F);
        paramCanvas.drawRoundRect(this.jdField_b_of_type_AndroidGraphicsRectF, f1, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.drawText(str1, 0.0F, -((this.jdField_a_of_type_AndroidTextTextPaint.descent() + this.jdField_a_of_type_AndroidTextTextPaint.ascent()) / 2.0F), this.jdField_a_of_type_AndroidTextTextPaint);
        if (super.b(0))
        {
          this.jdField_a_of_type_AndroidGraphicsRectF.left = (-i / 2.0F);
          this.jdField_a_of_type_AndroidGraphicsRectF.top = (-j / 2.0F);
          this.jdField_a_of_type_AndroidGraphicsRectF.right = (i / 2.0F);
          this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (j / 2.0F);
          paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
        }
        paramCanvas.restore();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
    paramCanvas.save();
    paramCanvas.translate(this.c, 16.0F);
    float f1 = super.a(this.jdField_b_of_type_AndroidTextStaticLayout);
    float f2 = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
    float f3 = (32.0F + f2) / 2.0F;
    this.jdField_b_of_type_AndroidGraphicsRectF.left = (-f3);
    this.jdField_b_of_type_AndroidGraphicsRectF.right = (f1 + f3);
    this.jdField_b_of_type_AndroidGraphicsRectF.top = -16.0F;
    this.jdField_b_of_type_AndroidGraphicsRectF.bottom = (f2 + 16.0F);
    paramCanvas.drawRoundRect(this.jdField_b_of_type_AndroidGraphicsRectF, f3, f3, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    if (super.b(0))
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.left = 0.0F;
      this.jdField_a_of_type_AndroidGraphicsRectF.top = 0.0F;
      this.jdField_a_of_type_AndroidGraphicsRectF.right = f1;
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = f2;
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
    }
    paramCanvas.restore();
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float + 32.0F;
  }
  
  public int e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhmz
 * JD-Core Version:    0.7.0.1
 */