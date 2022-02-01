import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;

public class awxl
  extends Drawable
  implements awxk
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private awxn jdField_a_of_type_Awxn;
  private awxw jdField_a_of_type_Awxw;
  
  private awxl(awxn paramawxn, Resources paramResources)
  {
    this.jdField_a_of_type_Awxn = paramawxn;
    if (paramResources != null) {}
    for (this.jdField_a_of_type_Int = paramResources.getDisplayMetrics().densityDpi;; this.jdField_a_of_type_Int = paramawxn.d)
    {
      a();
      return;
    }
  }
  
  public awxl(awxy paramawxy, Resources paramResources)
  {
    this(new awxn(paramawxy), paramResources);
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameDrawable", 2, "func initGifEngine");
    }
    awxx localawxx = new awxx();
    localawxx.jdField_a_of_type_Awxk = this;
    localawxx.jdField_a_of_type_Int = this.jdField_a_of_type_Awxn.jdField_b_of_type_Int;
    localawxx.jdField_b_of_type_Int = this.jdField_a_of_type_Awxn.jdField_a_of_type_Int;
    if (!this.jdField_a_of_type_Awxn.jdField_a_of_type_Boolean) {}
    for (localawxx.jdField_a_of_type_ArrayOfJavaLangString = null;; localawxx.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_Awxn.jdField_a_of_type_ArrayOfJavaLangString)
    {
      this.jdField_a_of_type_Awxw = new awxw();
      this.jdField_a_of_type_Awxw.a(localawxx);
      return;
    }
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Awxw == null) {
      return;
    }
    if ((this.jdField_a_of_type_Awxn.jdField_b_of_type_ArrayOfJavaLangString != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_Awxn.jdField_b_of_type_ArrayOfJavaLangString.length)) {
      this.jdField_a_of_type_Awxw.a(this.jdField_a_of_type_Awxn.jdField_b_of_type_ArrayOfJavaLangString[paramInt]);
    }
    this.jdField_a_of_type_Awxw.a();
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
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, getBounds(), this.jdField_a_of_type_Awxn.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.jdField_a_of_type_Awxn;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_Awxn.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_Awxn.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_Awxn.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxl
 * JD-Core Version:    0.7.0.1
 */