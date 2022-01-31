import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;

public class arfx
  extends Drawable
  implements arfw
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private arfz jdField_a_of_type_Arfz;
  private argi jdField_a_of_type_Argi;
  
  private arfx(arfz paramarfz, Resources paramResources)
  {
    this.jdField_a_of_type_Arfz = paramarfz;
    if (paramResources != null) {}
    for (this.jdField_a_of_type_Int = paramResources.getDisplayMetrics().densityDpi;; this.jdField_a_of_type_Int = paramarfz.d)
    {
      a();
      return;
    }
  }
  
  public arfx(argk paramargk, Resources paramResources)
  {
    this(new arfz(paramargk), paramResources);
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameDrawable", 2, "func initGifEngine");
    }
    argj localargj = new argj();
    localargj.jdField_a_of_type_Arfw = this;
    localargj.jdField_a_of_type_Int = this.jdField_a_of_type_Arfz.jdField_b_of_type_Int;
    localargj.jdField_b_of_type_Int = this.jdField_a_of_type_Arfz.jdField_a_of_type_Int;
    if (!this.jdField_a_of_type_Arfz.jdField_a_of_type_Boolean) {}
    for (localargj.jdField_a_of_type_ArrayOfJavaLangString = null;; localargj.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_Arfz.jdField_a_of_type_ArrayOfJavaLangString)
    {
      this.jdField_a_of_type_Argi = new argi();
      this.jdField_a_of_type_Argi.a(localargj);
      return;
    }
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Argi == null) {
      return;
    }
    if ((this.jdField_a_of_type_Arfz.jdField_b_of_type_ArrayOfJavaLangString != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_Arfz.jdField_b_of_type_ArrayOfJavaLangString.length)) {
      this.jdField_a_of_type_Argi.a(this.jdField_a_of_type_Arfz.jdField_b_of_type_ArrayOfJavaLangString[paramInt]);
    }
    this.jdField_a_of_type_Argi.a();
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameDrawable", 2, "func onBitmapReady,bitmap:" + paramBitmap);
    }
    if (paramBitmap == null) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    invalidateSelf();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled());
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameDrawable", 2, "func draw,bitmap:" + this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, getBounds(), this.jdField_a_of_type_Arfz.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.jdField_a_of_type_Arfz;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_Arfz.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_Arfz.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_Arfz.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arfx
 * JD-Core Version:    0.7.0.1
 */