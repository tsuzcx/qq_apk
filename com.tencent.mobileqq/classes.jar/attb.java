import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;

public class attb
  extends Drawable
  implements atta
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private attd jdField_a_of_type_Attd;
  private attm jdField_a_of_type_Attm;
  
  private attb(attd paramattd, Resources paramResources)
  {
    this.jdField_a_of_type_Attd = paramattd;
    if (paramResources != null) {}
    for (this.jdField_a_of_type_Int = paramResources.getDisplayMetrics().densityDpi;; this.jdField_a_of_type_Int = paramattd.d)
    {
      a();
      return;
    }
  }
  
  public attb(atto paramatto, Resources paramResources)
  {
    this(new attd(paramatto), paramResources);
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameDrawable", 2, "func initGifEngine");
    }
    attn localattn = new attn();
    localattn.jdField_a_of_type_Atta = this;
    localattn.jdField_a_of_type_Int = this.jdField_a_of_type_Attd.jdField_b_of_type_Int;
    localattn.jdField_b_of_type_Int = this.jdField_a_of_type_Attd.jdField_a_of_type_Int;
    if (!this.jdField_a_of_type_Attd.jdField_a_of_type_Boolean) {}
    for (localattn.jdField_a_of_type_ArrayOfJavaLangString = null;; localattn.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_Attd.jdField_a_of_type_ArrayOfJavaLangString)
    {
      this.jdField_a_of_type_Attm = new attm();
      this.jdField_a_of_type_Attm.a(localattn);
      return;
    }
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Attm == null) {
      return;
    }
    if ((this.jdField_a_of_type_Attd.jdField_b_of_type_ArrayOfJavaLangString != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_Attd.jdField_b_of_type_ArrayOfJavaLangString.length)) {
      this.jdField_a_of_type_Attm.a(this.jdField_a_of_type_Attd.jdField_b_of_type_ArrayOfJavaLangString[paramInt]);
    }
    this.jdField_a_of_type_Attm.a();
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
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, getBounds(), this.jdField_a_of_type_Attd.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.jdField_a_of_type_Attd;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_Attd.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_Attd.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_Attd.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     attb
 * JD-Core Version:    0.7.0.1
 */