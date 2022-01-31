import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class bjhg
  extends GPUBaseFilter
{
  private int jdField_a_of_type_Int = -1;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private String jdField_a_of_type_JavaLangString;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  private int d;
  
  public bjhg(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    int i = GLES20.glCheckFramebufferStatus(36160);
    if (i != 36053)
    {
      SLog.e("GPUPKFilter", "fbo is not ready plz fix it error:" + i);
      return paramInt1;
    }
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
    if (paramInt3 >= 0)
    {
      Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
      Matrix.translateM(this.jdField_a_of_type_ArrayOfFloat, 0, 0.0F, 0.5F, 0.0F);
      Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, 1.0F, 0.25F, 1.0F);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt3, null, this.jdField_a_of_type_ArrayOfFloat);
    }
    if (paramInt2 >= 0)
    {
      Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
      Matrix.translateM(this.jdField_a_of_type_ArrayOfFloat, 0, 0.5F, -0.24F, 0.0F);
      Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, 0.5F, 0.5F, 1.0F);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt2, null, this.jdField_a_of_type_ArrayOfFloat);
    }
    if (paramInt1 >= 0)
    {
      Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
      Matrix.translateM(this.jdField_a_of_type_ArrayOfFloat, 0, -0.5F, -0.24F, 0.0F);
      Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, 0.5F, 0.5F, 1.0F);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt1, null, this.jdField_a_of_type_ArrayOfFloat);
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
    return this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId();
  }
  
  public void destroy()
  {
    super.destroy();
  }
  
  public void drawTexture(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    super.drawTexture(a(paramInt, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int), paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    SLog.d("GPUPKFilter", "init");
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender == null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    }
    if (this.d > 720)
    {
      this.c = (this.c * 720 / this.d);
      this.d = 720;
    }
    if ((this.d == 0) || (this.c == 0))
    {
      this.d = 720;
      this.c = 1280;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.d, this.c, 33984);
    }
    if ((this.jdField_a_of_type_Int < 0) && (FileUtil.fileExistsAndNotEmpty(this.jdField_a_of_type_JavaLangString))) {}
    try
    {
      localBitmap = BitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Int = GlUtil.createTexture(3553, localBitmap);
      localBitmap.recycle();
      if (this.jdField_a_of_type_Int < 0) {
        SLog.e("GPUPKFilter", "create the pk cover texture failed");
      }
      if ((this.jdField_b_of_type_Int >= 0) || (!FileUtil.fileExistsAndNotEmpty(this.jdField_b_of_type_JavaLangString))) {}
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeFile(this.jdField_b_of_type_JavaLangString);
        this.jdField_b_of_type_Int = GlUtil.createTexture(3553, localBitmap);
        localBitmap.recycle();
        if (this.jdField_b_of_type_Int < 0) {
          SLog.e("GPUPKFilter", "create the pk title texture failed");
        }
        return;
        localOutOfMemoryError1 = localOutOfMemoryError1;
        SLog.e("GPUPKFilter", "create the pk cover texture out of memory:" + localOutOfMemoryError1);
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        for (;;)
        {
          SLog.e("GPUPKFilter", "create the pk title texture out of memory:" + localOutOfMemoryError2);
        }
      }
    }
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    this.d = paramInt1;
    this.c = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjhg
 * JD-Core Version:    0.7.0.1
 */