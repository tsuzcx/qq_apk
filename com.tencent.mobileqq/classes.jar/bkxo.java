import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import java.io.IOException;

public class bkxo
  extends bkxl
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
  
  public bkxo()
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
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = vxy.a(paramString, null);
      return;
    }
    catch (IOException paramString)
    {
      veg.c("Q.qqstory.publish.edit GPUImagePixelationFilter", "setMosaicPath OutOfMemoryError", paramString);
    }
  }
  
  public void onDestroy()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      veg.b("Q.qqstory.publish.edit GPUImagePixelationFilter", "mosaic bitmap recycle");
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
      veg.e("Q.qqstory.publish.edit GPUImagePixelationFilter", "mosaic bitmap can't be null");
      return;
    }
    GLES20.glActiveTexture(33985);
    if ((this.d == -1) || (this.jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())
      {
        veg.e("Q.qqstory.publish.edit GPUImagePixelationFilter", "mosaic bitmap is recycled");
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
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    veg.a("Q.qqstory.publish.edit GPUImagePixelationFilter", "onOutputSizeChanged width=%s, height=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.jdField_b_of_type_Float = 0.0009259259F;
    this.jdField_c_of_type_Float = 0.0005208334F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkxo
 * JD-Core Version:    0.7.0.1
 */