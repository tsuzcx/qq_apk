import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.support.annotation.FloatRange;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.bighead.BigHeadBuckler;
import com.tencent.mobileqq.shortvideo.bighead.GpuGaussianBlurFilter;
import com.tencent.mobileqq.shortvideo.dancemachine.Color4f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class bhym
{
  private int jdField_a_of_type_Int;
  private Color4f jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineColor4f = new Color4f(1.0F, 1.0F, 1.0F, 1.0F);
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  protected FloatBuffer a;
  private boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  
  private void b(int paramInt, float[] paramArrayOfFloat)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      int i = this.jdField_a_of_type_Int;
      float[] arrayOfFloat = paramArrayOfFloat;
      if (paramArrayOfFloat == null) {
        arrayOfFloat = BigHeadBuckler.sGIdentity;
      }
      int j = GLES20.glGetError();
      if ((j != 0) && (QLog.isColorLevel())) {
        QLog.d("LightWeightCircleCornerFilter", 2, "drawTextureFrame errorBegin:" + j);
      }
      GLES20.glUseProgram(i);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16640);
      j = GLES20.glGetAttribLocation(i, "a_position");
      int k = GLES20.glGetAttribLocation(i, "a_texCoord");
      int m = GLES20.glGetAttribLocation(i, "a_texCoordMask");
      GLES20.glVertexAttribPointer(j, 2, 5126, false, 0, GpuGaussianBlurFilter.VERTEXT_BUF);
      GLES20.glEnableVertexAttribArray(j);
      GLES20.glVertexAttribPointer(k, 2, 5126, false, 0, GpuGaussianBlurFilter.TEXTURE_BUF);
      GLES20.glEnableVertexAttribArray(k);
      GLES20.glVertexAttribPointer(m, 2, 5126, false, 0, GpuGaussianBlurFilter.TEXTURE_BUF);
      GLES20.glEnableVertexAttribArray(m);
      j = GLES20.glGetAttribLocation(i, "a_color");
      GLES20.glVertexAttribPointer(j, 4, 5126, false, 0, this.jdField_a_of_type_JavaNioFloatBuffer);
      GLES20.glEnableVertexAttribArray(j);
      GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(i, "u_projectionMatrix"), 1, false, arrayOfFloat, 0);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt);
      GLES20.glUniform1i(GLES20.glGetUniformLocation(i, "u_texture"), 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.jdField_a_of_type_ArrayOfInt[0]);
      GLES20.glUniform1i(GLES20.glGetUniformLocation(i, "u_texture_mask"), 1);
      GLES20.glDrawArrays(5, 0, 4);
      paramInt = GLES20.glGetError();
    } while (paramInt == 0);
    if (QLog.isColorLevel()) {
      QLog.d("LightWeightCircleCornerFilter", 2, "drawTextureFrame error:" + paramInt);
    }
    throw new RuntimeException("error =" + paramInt);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      GLES20.glDeleteProgram(this.jdField_a_of_type_Int);
      GLES20.glDeleteTextures(1, this.jdField_a_of_type_ArrayOfInt, 0);
      GLES20.glDeleteTextures(1, new int[] { this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId() }, 0);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void a(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineColor4f.setValue(1.0F, 1.0F, 1.0F, paramFloat);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaNioFloatBuffer != null))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
      int i = 0;
      while (i < 4)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineColor4f.putValue(this.jdField_a_of_type_JavaNioFloatBuffer);
        i += 1;
      }
      this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    }
  }
  
  public void a(int paramInt, float[] paramArrayOfFloat)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    b(paramInt, paramArrayOfFloat);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Int = GlUtil.createProgram("precision mediump float;\nattribute vec4 a_position;\nattribute vec2 a_texCoord;\nattribute vec2 a_texCoordMask;\nattribute vec4 a_color;\nuniform mat4 u_projectionMatrix;\nvarying vec2 v_texCoord;\nvarying vec2 v_texCoord_mask;\nvarying vec4 v_color;\nvoid main()\n{\n    gl_Position = u_projectionMatrix * a_position;\n    v_texCoord = a_texCoord;\n    v_texCoord_mask = a_texCoordMask;\n    v_color = a_color;\n}", "precision mediump float;uniform sampler2D u_texture;\nuniform sampler2D u_texture_mask;\nvarying vec2 v_texCoord;\nvarying vec2 v_texCoord_mask;\nvarying vec4 v_color;\nvoid main()\n{\n    vec4 mask = texture2D(u_texture_mask, v_texCoord_mask);\n    vec4 scan = texture2D(u_texture, v_texCoord);\n    if(mask.a < 0.5){\n       gl_FragColor = v_color * scan;\n    }else{\n       discard;\n    }\n}");
      if (this.jdField_a_of_type_Int == 0)
      {
        paramContext = new RuntimeException("failed creating program " + getClass().getSimpleName());
        if (QLog.isColorLevel()) {
          QLog.d("LightWeightCircleCornerFilter", 2, "LightWeightCircleCornerFilter ", paramContext);
        }
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2130843561);
      if (paramContext != null)
      {
        this.jdField_a_of_type_ArrayOfInt[0] = GlUtil.createTexture(3553, paramContext, 9729, 9729, 33071, 33071);
        paramContext.recycle();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramInt1, paramInt2, 33984);
      }
      for (this.jdField_a_of_type_Boolean = true; this.jdField_a_of_type_Boolean; this.jdField_a_of_type_Boolean = false)
      {
        this.jdField_a_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
        a(1.0F);
        return;
        GLES20.glDeleteProgram(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhym
 * JD-Core Version:    0.7.0.1
 */