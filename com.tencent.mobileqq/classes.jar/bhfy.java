import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class bhfy
{
  private static final float[] jdField_a_of_type_ArrayOfFloat = { 1.0F, 1.0F, 1.0F, 1.0F, -1.0F, 1.0F, 0.0F, 1.0F, -1.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, -1.0F, -1.0F, 0.0F, 0.0F, 1.0F, -1.0F, 1.0F, 0.0F };
  private final int jdField_a_of_type_Int = a(a(35633, "attribute vec4 aPosition;\nuniform mat4 uTextureMatrix;\nattribute vec4 aTextureCoordinate;\nvarying vec2 vTextureCoord;\nvoid main()\n{\n  vTextureCoord = (uTextureMatrix * aTextureCoordinate).xy;\n  gl_Position = aPosition;\n}"), a(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES uTextureSampler;\nvarying vec2 vTextureCoord;\nvoid main()\n{\n  gl_FragColor = texture2D(uTextureSampler, vTextureCoord);\n}"));
  private final FloatBuffer jdField_a_of_type_JavaNioFloatBuffer = b();
  
  private int a(int paramInt1, int paramInt2)
  {
    int i = GLES20.glCreateProgram();
    if (i == 0) {
      throw new RuntimeException("Create Program Failed!" + GLES20.glGetError());
    }
    GLES20.glAttachShader(i, paramInt1);
    GLES20.glAttachShader(i, paramInt2);
    GLES20.glLinkProgram(i);
    GLES20.glUseProgram(i);
    return i;
  }
  
  private int a(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    if (paramInt == 0) {
      throw new RuntimeException("Create Shader Failed!" + GLES20.glGetError());
    }
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    return paramInt;
  }
  
  private FloatBuffer b()
  {
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(jdField_a_of_type_ArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    localFloatBuffer.put(jdField_a_of_type_ArrayOfFloat, 0, jdField_a_of_type_ArrayOfFloat.length).position(0);
    return localFloatBuffer;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public FloatBuffer a()
  {
    return this.jdField_a_of_type_JavaNioFloatBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhfy
 * JD-Core Version:    0.7.0.1
 */