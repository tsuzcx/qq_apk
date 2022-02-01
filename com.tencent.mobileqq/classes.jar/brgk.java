import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.FloatBuffer;

public class brgk
  extends GPUBaseFilter
{
  private float a;
  protected FloatBuffer a;
  private float b;
  protected FloatBuffer b;
  private FloatBuffer c;
  
  public brgk()
  {
    super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nvarying vec2 vTextureCoord;\nattribute vec4 aTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform vec4 a_color;\n\nuniform float widthShadowRegion;\n\nuniform float heightShadowRegion;\n\nvoid main() {\n    float x = abs(vTextureCoord.x-0.5);\n    float y = abs(vTextureCoord.y-0.5);\n    float mx = 1.0 - (1.0-(0.5-x)/widthShadowRegion)*step(0.5-widthShadowRegion,x);\n    float my = 1.0 - (1.0-(0.5-y)/heightShadowRegion)*step(0.5-heightShadowRegion,y);\n    gl_FragColor = a_color;\n    gl_FragColor.a = gl_FragColor.a*mx*my;\n}\n");
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.c = GlUtil.createFloatBuffer(new float[] { paramFloat1, paramFloat2, paramFloat3, paramFloat4 });
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    checkGlError("onDrawFrame start");
    int j = getProgram();
    float[] arrayOfFloat = paramArrayOfFloat1;
    if (paramArrayOfFloat1 == null)
    {
      arrayOfFloat = new float[16];
      Matrix.setIdentityM(arrayOfFloat, 0);
    }
    paramArrayOfFloat1 = paramArrayOfFloat2;
    if (paramArrayOfFloat2 == null)
    {
      paramArrayOfFloat1 = new float[16];
      Matrix.setIdentityM(paramArrayOfFloat1, 0);
    }
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    GLES20.glUseProgram(j);
    checkGlError("glUseProgram");
    int k = GLES20.glGetAttribLocation(j, "aPosition");
    checkLocation(k, "aPosition");
    int m = GLES20.glGetAttribLocation(j, "aTextureCoord");
    checkLocation(m, "aTextureCoord");
    int i = GLES20.glGetUniformLocation(j, "uMVPMatrix");
    checkLocation(i, "uMVPMatrix");
    int n = GLES20.glGetUniformLocation(j, "uTextureMatrix");
    checkLocation(n, "uTextureMatrix");
    GLES20.glVertexAttribPointer(k, 2, 5126, false, 8, this.jdField_a_of_type_JavaNioFloatBuffer);
    checkGlError("glVertexAttribPointer aPosition");
    GLES20.glEnableVertexAttribArray(k);
    checkGlError("glEnableVertexAttribArray mPositionHandle");
    GLES20.glVertexAttribPointer(m, 2, 5126, false, 8, this.jdField_b_of_type_JavaNioFloatBuffer);
    checkGlError("glVertexAttribPointer mTextureHandle");
    GLES20.glEnableVertexAttribArray(m);
    checkGlError("glEnableVertexAttribArray mTextureHandle");
    GLES20.glUniformMatrix4fv(i, 1, false, paramArrayOfFloat1, 0);
    GLES20.glUniformMatrix4fv(n, 1, false, arrayOfFloat, 0);
    k = GLES20.glGetUniformLocation(j, "a_color");
    checkLocation(i, "a_color");
    GLES20.glUniform4fv(k, 1, this.c);
    k = GLES20.glGetUniformLocation(j, "widthShadowRegion");
    checkLocation(i, "widthShadowRegion");
    GLES20.glUniform1f(k, this.jdField_a_of_type_Float);
    j = GLES20.glGetUniformLocation(j, "heightShadowRegion");
    checkLocation(i, "heightShadowRegion");
    GLES20.glUniform1f(j, this.jdField_b_of_type_Float);
    GLES20.glActiveTexture(33984);
    onDrawTexture();
    GLES20.glDrawArrays(5, 0, 4);
    checkGlError("glDrawArrays");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, 0);
    GLES20.glDisable(3042);
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    this.jdField_a_of_type_JavaNioFloatBuffer = GlUtil.createFloatBuffer(new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F });
    this.jdField_b_of_type_JavaNioFloatBuffer = GlUtil.createFloatBuffer(new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F });
    this.c = GlUtil.createFloatBuffer(new float[] { 1.0F, 1.0F, 1.0F, 1.0F });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brgk
 * JD-Core Version:    0.7.0.1
 */