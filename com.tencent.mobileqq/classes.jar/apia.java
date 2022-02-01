import android.content.Context;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class apia
{
  private static final String jdField_a_of_type_JavaLangString = apia.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  private boolean jdField_a_of_type_Boolean;
  public final float[] a;
  private int jdField_b_of_type_Int;
  private final String jdField_b_of_type_JavaLangString = "attribute vec4 a_Position;\nattribute vec2 a_TexCoord;\n\nvarying vec2 v_TexCoord;\n\nvoid main() {\n   gl_Position = a_Position;\n   v_TexCoord = a_TexCoord;\n}";
  private FloatBuffer jdField_b_of_type_JavaNioFloatBuffer;
  public final float[] b;
  private int jdField_c_of_type_Int;
  private final String jdField_c_of_type_JavaLangString = "\n#extension GL_OES_EGL_image_external : require\n\nprecision mediump float;\nvarying vec2 v_TexCoord;\nuniform samplerExternalOES sTexture;\n\n\nvoid main() {\n    gl_FragColor = texture2D(sTexture, v_TexCoord);\n}";
  private FloatBuffer jdField_c_of_type_JavaNioFloatBuffer;
  private int d;
  private int e = -1;
  private int f = 36197;
  
  public apia()
  {
    this.jdField_a_of_type_ArrayOfFloat = new float[] { -1.0F, -1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F, 1.0F };
    this.jdField_b_of_type_ArrayOfFloat = new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  }
  
  public int a()
  {
    return this.e;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    float f1 = paramInt1 / paramInt2;
    float f2 = paramInt3 / paramInt4;
    Object localObject;
    if (f1 < f2)
    {
      f1 = f2 / f1;
      localObject = this.jdField_a_of_type_ArrayOfFloat;
      localObject[1] *= f1;
      localObject = this.jdField_a_of_type_ArrayOfFloat;
      localObject[3] *= f1;
      localObject = this.jdField_a_of_type_ArrayOfFloat;
      localObject[5] *= f1;
      localObject = this.jdField_a_of_type_ArrayOfFloat;
      localObject[7] = (f1 * localObject[7]);
    }
    for (;;)
    {
      localObject = ByteBuffer.allocateDirect(this.jdField_a_of_type_ArrayOfFloat.length * 4);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      this.jdField_a_of_type_JavaNioFloatBuffer = ((ByteBuffer)localObject).asFloatBuffer();
      this.jdField_a_of_type_JavaNioFloatBuffer.put(this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
      localObject = ByteBuffer.allocateDirect(32);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      this.jdField_b_of_type_JavaNioFloatBuffer = ((ByteBuffer)localObject).asFloatBuffer();
      this.jdField_b_of_type_JavaNioFloatBuffer.put(this.jdField_b_of_type_ArrayOfFloat);
      this.jdField_b_of_type_JavaNioFloatBuffer.position(0);
      return;
      f1 /= f2;
      localObject = this.jdField_a_of_type_ArrayOfFloat;
      localObject[0] *= f1;
      localObject = this.jdField_a_of_type_ArrayOfFloat;
      localObject[2] *= f1;
      localObject = this.jdField_a_of_type_ArrayOfFloat;
      localObject[4] *= f1;
      localObject = this.jdField_a_of_type_ArrayOfFloat;
      localObject[6] = (f1 * localObject[6]);
    }
  }
  
  public void a(Context paramContext)
  {
    Object localObject = new int[1];
    GLES20.glGenTextures(1, (int[])localObject, 0);
    this.e = localObject[0];
    GLES20.glBindTexture(this.f, this.e);
    GLES20.glTexParameteri(this.f, 10242, 33071);
    GLES20.glTexParameteri(this.f, 10243, 33071);
    GLES20.glTexParameteri(this.f, 10241, 9728);
    GLES20.glTexParameteri(this.f, 10240, 9728);
    if (4 != this.jdField_a_of_type_ArrayOfFloat.length / 2) {
      throw new RuntimeException("Unexpected number of vertices in BackgroundRenderer.");
    }
    localObject = ByteBuffer.allocateDirect(32);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    this.jdField_c_of_type_JavaNioFloatBuffer = ((ByteBuffer)localObject).asFloatBuffer();
    int i = apsv.a(jdField_a_of_type_JavaLangString, paramContext, 35633, "attribute vec4 a_Position;\nattribute vec2 a_TexCoord;\n\nvarying vec2 v_TexCoord;\n\nvoid main() {\n   gl_Position = a_Position;\n   v_TexCoord = a_TexCoord;\n}");
    int j = apsv.a(jdField_a_of_type_JavaLangString, paramContext, 35632, "\n#extension GL_OES_EGL_image_external : require\n\nprecision mediump float;\nvarying vec2 v_TexCoord;\nuniform samplerExternalOES sTexture;\n\n\nvoid main() {\n    gl_FragColor = texture2D(sTexture, v_TexCoord);\n}");
    this.jdField_a_of_type_Int = GLES20.glCreateProgram();
    GLES20.glAttachShader(this.jdField_a_of_type_Int, i);
    GLES20.glAttachShader(this.jdField_a_of_type_Int, j);
    GLES20.glLinkProgram(this.jdField_a_of_type_Int);
    GLES20.glUseProgram(this.jdField_a_of_type_Int);
    apsv.a(jdField_a_of_type_JavaLangString, "program creation");
    this.jdField_b_of_type_Int = GLES20.glGetAttribLocation(this.jdField_a_of_type_Int, "a_Position");
    this.jdField_c_of_type_Int = GLES20.glGetAttribLocation(this.jdField_a_of_type_Int, "a_TexCoord");
    this.d = GLES20.glGetAttribLocation(this.jdField_a_of_type_Int, "sTexture");
    apsv.a(jdField_a_of_type_JavaLangString, "program parameters");
  }
  
  public void a(FloatBuffer paramFloatBuffer)
  {
    apsv.a(jdField_a_of_type_JavaLangString, "before draw");
    this.jdField_c_of_type_JavaNioFloatBuffer = paramFloatBuffer;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glColorMask(true, true, true, true);
    GLES20.glClear(16640);
    GLES20.glDepthMask(false);
    GLES20.glDisable(2929);
    GLES20.glDisable(3042);
    GLES20.glUseProgram(this.jdField_a_of_type_Int);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, this.e);
    GLES20.glUniform1i(this.d, 0);
    GLES20.glVertexAttribPointer(this.jdField_b_of_type_Int, 2, 5126, false, 0, this.jdField_a_of_type_JavaNioFloatBuffer);
    GLES20.glVertexAttribPointer(this.jdField_c_of_type_Int, 2, 5126, false, 0, this.jdField_c_of_type_JavaNioFloatBuffer);
    GLES20.glEnableVertexAttribArray(this.jdField_b_of_type_Int);
    GLES20.glEnableVertexAttribArray(this.jdField_c_of_type_Int);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.jdField_b_of_type_Int);
    GLES20.glDisableVertexAttribArray(this.jdField_c_of_type_Int);
    GLES20.glEnable(2929);
    apsv.a(jdField_a_of_type_JavaLangString, "after draw");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apia
 * JD-Core Version:    0.7.0.1
 */