import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;

public class axce
  extends axci
{
  private Paint a;
  private String b = "";
  private int g = 20;
  private int h = -1;
  
  public axce(SpriteGLView paramSpriteGLView, Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    e(paramInt1);
    f(paramInt2);
    a(paramSpriteGLView, paramString);
  }
  
  public void a(SpriteGLView paramSpriteGLView, String paramString)
  {
    if (paramString.equals(this.b)) {
      return;
    }
    this.b = paramString;
    paramString = Bitmap.createBitmap((int)this.jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString), this.g, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramString);
    localCanvas.drawColor(-16777216, PorterDuff.Mode.CLEAR);
    localCanvas.drawText(this.b, 0.0F, this.g * 0.8F, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (this.jdField_a_of_type_Axcl != null) {
      this.jdField_a_of_type_Axcl.c();
    }
    this.jdField_a_of_type_Axcl = new axcl(paramSpriteGLView, paramString);
    g();
    f();
  }
  
  public void e(int paramInt)
  {
    this.h = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.h);
  }
  
  public void f(int paramInt)
  {
    this.g = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axce
 * JD-Core Version:    0.7.0.1
 */