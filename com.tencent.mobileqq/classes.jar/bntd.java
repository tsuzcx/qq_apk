import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class bntd
{
  private int jdField_a_of_type_Int;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(this.jdField_a_of_type_ArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
  private final float[] jdField_a_of_type_ArrayOfFloat = { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  private int jdField_b_of_type_Int = -12345;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  private int jdField_c_of_type_Int;
  private float[] jdField_c_of_type_ArrayOfFloat = new float[16];
  private int jdField_d_of_type_Int;
  private float[] jdField_d_of_type_ArrayOfFloat = new float[16];
  private int jdField_e_of_type_Int;
  private float[] jdField_e_of_type_ArrayOfFloat = new float[16];
  private int f;
  
  public bntd()
  {
    this.jdField_a_of_type_JavaNioFloatBuffer.put(this.jdField_a_of_type_ArrayOfFloat).position(0);
    Matrix.setIdentityM(this.jdField_e_of_type_ArrayOfFloat, 0);
    Matrix.setIdentityM(this.jdField_d_of_type_ArrayOfFloat, 0);
  }
  
  private int a(int paramInt, String paramString)
  {
    int i = GLES20.glCreateShader(paramInt);
    a("glCreateShader type=" + paramInt);
    GLES20.glShaderSource(i, paramString);
    GLES20.glCompileShader(i);
    paramString = new int[1];
    GLES20.glGetShaderiv(i, 35713, paramString, 0);
    if (paramString[0] == 0)
    {
      Log.e("TextureRender", "Could not compile shader " + paramInt + ":");
      Log.e("TextureRender", " " + GLES20.glGetShaderInfoLog(i));
      GLES20.glDeleteShader(i);
      return 0;
    }
    return i;
  }
  
  private int a(String paramString1, String paramString2)
  {
    int i = a(35633, paramString1);
    if (i == 0) {}
    int j;
    do
    {
      return 0;
      j = a(35632, paramString2);
    } while (j == 0);
    int k = GLES20.glCreateProgram();
    a("glCreateProgram");
    if (k == 0) {
      Log.e("TextureRender", "Could not create program");
    }
    GLES20.glAttachShader(k, i);
    a("glAttachShader");
    GLES20.glAttachShader(k, j);
    a("glAttachShader");
    GLES20.glLinkProgram(k);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(k, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      Log.e("TextureRender", "Could not link program: ");
      Log.e("TextureRender", GLES20.glGetProgramInfoLog(k));
      GLES20.glDeleteProgram(k);
      return 0;
    }
    return k;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
    if (this.jdField_a_of_type_Int == 0) {
      throw new RuntimeException("failed creating program");
    }
    this.jdField_e_of_type_Int = GLES20.glGetAttribLocation(this.jdField_a_of_type_Int, "aPosition");
    a("glGetAttribLocation aPosition");
    if (this.jdField_e_of_type_Int == -1) {
      throw new RuntimeException("Could not get attrib location for aPosition");
    }
    this.f = GLES20.glGetAttribLocation(this.jdField_a_of_type_Int, "aTextureCoord");
    a("glGetAttribLocation aTextureCoord");
    if (this.f == -1) {
      throw new RuntimeException("Could not get attrib location for aTextureCoord");
    }
    this.jdField_c_of_type_Int = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "uMVPMatrix");
    a("glGetUniformLocation uMVPMatrix");
    if (this.jdField_c_of_type_Int == -1) {
      throw new RuntimeException("Could not get attrib location for uMVPMatrix");
    }
    this.jdField_d_of_type_Int = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "uSTMatrix");
    a("glGetUniformLocation uSTMatrix");
    if (this.jdField_d_of_type_Int == -1) {
      throw new RuntimeException("Could not get attrib location for uSTMatrix");
    }
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    this.jdField_b_of_type_Int = arrayOfInt[0];
    GLES20.glBindTexture(36197, this.jdField_b_of_type_Int);
    a("glBindTexture mTextureID");
    GLES20.glTexParameterf(36197, 10241, 9728.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    a("glTexParameter");
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt7 <= 0) || (paramInt8 <= 0)) {
      return;
    }
    Matrix.setIdentityM(this.jdField_d_of_type_ArrayOfFloat, 0);
    Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
    Matrix.setIdentityM(this.jdField_c_of_type_ArrayOfFloat, 0);
    float f1 = paramInt3 / paramInt4;
    float f2 = paramInt1 / paramInt2;
    if (f1 < f2) {
      Matrix.orthoM(this.jdField_b_of_type_ArrayOfFloat, 0, -1.0F, 1.0F, -f1 / f2, f1 / f2, -1.0F, 1.0F);
    }
    for (f1 = paramInt3 / paramInt7;; f1 = paramInt4 / paramInt8)
    {
      float[] arrayOfFloat1 = new float[16];
      float[] arrayOfFloat2 = new float[16];
      Matrix.setIdentityM(arrayOfFloat1, 0);
      Matrix.setIdentityM(arrayOfFloat2, 0);
      float f4 = paramInt3 / 2.0F;
      float f5 = paramInt4 / 2.0F;
      f2 = (paramInt5 - f4) / f4;
      float f3 = -(paramInt6 - f5) / f5;
      f4 = (paramInt5 + paramInt7 - f4) / f4;
      f5 = -(paramInt6 + paramInt8 - f5) / f5;
      float f6 = (f2 + f4) / 2.0F;
      float f7 = (f3 + f5) / 2.0F;
      Matrix.translateM(arrayOfFloat1, 0, -f6, -f7, 0.0F);
      Matrix.scaleM(arrayOfFloat2, 0, f1, f1, 1.0F);
      Matrix.multiplyMM(this.jdField_c_of_type_ArrayOfFloat, 0, arrayOfFloat2, 0, arrayOfFloat1, 0);
      Log.d("TextureRender", "transform screenWidth: " + paramInt1 + ", screenHeight: " + paramInt2 + ", videoWidth: " + paramInt3 + ", videoHeight: " + paramInt4 + ", cropX: " + paramInt5 + ", cropY: " + paramInt6 + ", cropWidth: " + paramInt7 + ", cropHeight: " + paramInt8 + ", left: " + f2 + ", top: " + f3 + ", right: " + f4 + ", bottom: " + f5 + ", x: " + f6 + ", y: " + f7 + ", scale: " + f1);
      Matrix.multiplyMM(this.jdField_d_of_type_ArrayOfFloat, 0, this.jdField_b_of_type_ArrayOfFloat, 0, this.jdField_c_of_type_ArrayOfFloat, 0);
      return;
      Matrix.orthoM(this.jdField_b_of_type_ArrayOfFloat, 0, -f2 / f1, f2 / f1, -1.0F, 1.0F, -1.0F, 1.0F);
    }
  }
  
  @TargetApi(11)
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    a("onDrawFrame start");
    paramSurfaceTexture.getTransformMatrix(this.jdField_e_of_type_ArrayOfFloat);
    GLES20.glClearColor(0.0F, 1.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    GLES20.glUseProgram(this.jdField_a_of_type_Int);
    a("glUseProgram");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    GLES20.glVertexAttribPointer(this.jdField_e_of_type_Int, 3, 5126, false, 20, this.jdField_a_of_type_JavaNioFloatBuffer);
    a("glVertexAttribPointer maPositionHandle");
    GLES20.glEnableVertexAttribArray(this.jdField_e_of_type_Int);
    a("glEnableVertexAttribArray maPositionHandle");
    this.jdField_a_of_type_JavaNioFloatBuffer.position(3);
    GLES20.glVertexAttribPointer(this.f, 2, 5126, false, 20, this.jdField_a_of_type_JavaNioFloatBuffer);
    a("glVertexAttribPointer maTextureHandle");
    GLES20.glEnableVertexAttribArray(this.f);
    a("glEnableVertexAttribArray maTextureHandle");
    GLES20.glUniformMatrix4fv(this.jdField_c_of_type_Int, 1, false, this.jdField_d_of_type_ArrayOfFloat, 0);
    GLES20.glUniformMatrix4fv(this.jdField_d_of_type_Int, 1, false, this.jdField_e_of_type_ArrayOfFloat, 0);
    GLES20.glDrawArrays(5, 0, 4);
    a("glDrawArrays");
    GLES20.glFinish();
  }
  
  public void a(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0)
    {
      Log.e("TextureRender", paramString + ": glError " + i);
      throw new RuntimeException(paramString + ": glError " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bntd
 * JD-Core Version:    0.7.0.1
 */