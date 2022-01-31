import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import java.io.IOException;

public class axsa
  extends axrx
{
  private static String jdField_a_of_type_JavaLangString = GlUtil.readTextFromRawResource(BaseApplicationImpl.getContext(), 2131230756);
  private float jdField_a_of_type_Float = 30.0F;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private int d = -1;
  private int e;
  
  public axsa()
  {
    super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", jdField_a_of_type_JavaLangString);
    this.mTextureType = 3553;
    this.mFilterType = 106;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(Bitmap paramBitmap)
  {
    a(paramBitmap, 0);
  }
  
  public void a(@NonNull Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {
      return;
    }
    if ((paramInt == 0) || (paramInt == 180))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      return;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(360 - paramInt);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
      Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      RectF localRectF1 = new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight());
      RectF localRectF2 = new RectF();
      localMatrix.mapRect(localRectF2, localRectF1);
      localCanvas.translate(-localRectF2.left, -localRectF2.top);
      localCanvas.concat(localMatrix);
      localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localCanvas.drawBitmap(paramBitmap, localRect, localRectF1, new Paint());
      localCanvas.setBitmap(null);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = xmn.a(paramString, null);
      return;
    }
    catch (IOException paramString)
    {
      wsv.c("Q.qqstory.publish.edit GPUImagePixelationFilter", "setMosaicPath OutOfMemoryError", paramString);
    }
  }
  
  public void onDestroy()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      wsv.b("Q.qqstory.publish.edit GPUImagePixelationFilter", "mosaic bitmap recycle");
    }
    if (this.d != -1) {
      GlUtil.deleteTexture(this.d);
    }
  }
  
  public void onDrawTexture()
  {
    super.onDrawTexture();
    GLES20.glUniform1f(this.jdField_a_of_type_Int, this.jdField_b_of_type_Float);
    GLES20.glUniform1f(this.jdField_b_of_type_Int, this.jdField_c_of_type_Float);
    GLES20.glUniform1f(this.jdField_c_of_type_Int, this.jdField_a_of_type_Float);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      wsv.e("Q.qqstory.publish.edit GPUImagePixelationFilter", "mosaic bitmap can't be null");
      return;
    }
    GLES20.glActiveTexture(33985);
    if ((this.d == -1) || (this.jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())
      {
        wsv.e("Q.qqstory.publish.edit GPUImagePixelationFilter", "mosaic bitmap is recycled");
        return;
      }
      if (this.d != -1) {
        GlUtil.deleteTexture(this.d);
      }
      this.d = GlUtil.createTexture(3553, this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
    }
    GLES20.glBindTexture(3553, this.d);
    GLES20.glUniform1i(this.e, 1);
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    this.jdField_a_of_type_Int = GLES20.glGetUniformLocation(getProgram(), "imageWidthFactor");
    checkLocation(this.jdField_a_of_type_Int, "imageWidthFactor");
    this.jdField_b_of_type_Int = GLES20.glGetUniformLocation(getProgram(), "imageHeightFactor");
    checkLocation(this.jdField_b_of_type_Int, "imageHeightFactor");
    this.jdField_c_of_type_Int = GLES20.glGetUniformLocation(getProgram(), "pixel");
    checkLocation(this.jdField_c_of_type_Int, "mPixelLocation");
    this.e = GLES20.glGetUniformLocation(getProgram(), "sTexture2");
    a(this.jdField_a_of_type_Float);
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    wsv.a("Q.qqstory.publish.edit GPUImagePixelationFilter", "onOutputSizeChanged width=%s, height=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.jdField_b_of_type_Float = 0.0009259259F;
    this.jdField_c_of_type_Float = 0.0005208334F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axsa
 * JD-Core Version:    0.7.0.1
 */