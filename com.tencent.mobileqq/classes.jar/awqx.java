import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;

public class awqx
  extends Drawable
  implements awqw
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private awqz jdField_a_of_type_Awqz;
  private awri jdField_a_of_type_Awri;
  
  private awqx(awqz paramawqz, Resources paramResources)
  {
    this.jdField_a_of_type_Awqz = paramawqz;
    if (paramResources != null) {}
    for (this.jdField_a_of_type_Int = paramResources.getDisplayMetrics().densityDpi;; this.jdField_a_of_type_Int = paramawqz.d)
    {
      a();
      return;
    }
  }
  
  public awqx(awrk paramawrk, Resources paramResources)
  {
    this(new awqz(paramawrk), paramResources);
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameDrawable", 2, "func initGifEngine");
    }
    awrj localawrj = new awrj();
    localawrj.jdField_a_of_type_Awqw = this;
    localawrj.jdField_a_of_type_Int = this.jdField_a_of_type_Awqz.jdField_b_of_type_Int;
    localawrj.jdField_b_of_type_Int = this.jdField_a_of_type_Awqz.jdField_a_of_type_Int;
    if (!this.jdField_a_of_type_Awqz.jdField_a_of_type_Boolean) {}
    for (localawrj.jdField_a_of_type_ArrayOfJavaLangString = null;; localawrj.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_Awqz.jdField_a_of_type_ArrayOfJavaLangString)
    {
      this.jdField_a_of_type_Awri = new awri();
      this.jdField_a_of_type_Awri.a(localawrj);
      return;
    }
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Awri == null) {
      return;
    }
    if ((this.jdField_a_of_type_Awqz.jdField_b_of_type_ArrayOfJavaLangString != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_Awqz.jdField_b_of_type_ArrayOfJavaLangString.length)) {
      this.jdField_a_of_type_Awri.a(this.jdField_a_of_type_Awqz.jdField_b_of_type_ArrayOfJavaLangString[paramInt]);
    }
    this.jdField_a_of_type_Awri.a();
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
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, getBounds(), this.jdField_a_of_type_Awqz.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.jdField_a_of_type_Awqz;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_Awqz.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_Awqz.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_Awqz.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqx
 * JD-Core Version:    0.7.0.1
 */