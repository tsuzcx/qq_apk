import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class aouq
{
  public static float[] a;
  public static float[] b;
  static float[] jdField_c_of_type_ArrayOfFloat;
  static float[] jdField_d_of_type_ArrayOfFloat;
  public static float[] e;
  static float[] jdField_f_of_type_ArrayOfFloat;
  public static float[] g;
  private static float[] jdField_i_of_type_ArrayOfFloat = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  public final int a;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ByteBuffer jdField_b_of_type_JavaNioByteBuffer;
  private int jdField_c_of_type_Int;
  private int jdField_d_of_type_Int;
  private int e;
  private int jdField_f_of_type_Int;
  private int g;
  private int jdField_h_of_type_Int;
  private float[] jdField_h_of_type_ArrayOfFloat;
  private int jdField_i_of_type_Int = -1;
  private int j = -1;
  private int k = -1;
  private int l = -1;
  private int m = -1;
  private int n = -1;
  private int o = -1;
  private int p = -1;
  private int q = -1;
  private int r = -1;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    jdField_b_of_type_ArrayOfFloat = new float[] { -1.0F, 1.0F, 1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F };
    jdField_c_of_type_ArrayOfFloat = new float[] { -1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F };
    jdField_d_of_type_ArrayOfFloat = new float[] { 0.0F, -1.0F, 1.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    jdField_e_of_type_ArrayOfFloat = new float[] { -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 0.0F, 0.0F };
    jdField_f_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
    jdField_g_of_type_ArrayOfFloat = new float[] { -1.0F, 1.0F, 1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F };
  }
  
  public aouq(int paramInt)
  {
    if (((paramInt < 0) || (paramInt > 4)) && (QLog.isColorLevel())) {
      QLog.i("GreetingYUVProgram", 1, "Index can only be 0 to 4");
    }
    this.jdField_a_of_type_Int = paramInt;
    a(this.jdField_a_of_type_Int);
  }
  
  private int a(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    if (paramInt != 0)
    {
      GLES20.glShaderSource(paramInt, paramString);
      GLES20.glCompileShader(paramInt);
      paramString = new int[1];
      GLES20.glGetShaderiv(paramInt, 35713, paramString, 0);
      if (paramString[0] == 0)
      {
        GLES20.glDeleteShader(paramInt);
        return 0;
      }
    }
    return paramInt;
  }
  
  private void a(String paramString)
  {
    int i1 = GLES20.glGetError();
    if (i1 != 0) {
      QLog.i("GreetingYUVProgram", 1, paramString + ": glError 0x" + Integer.toHexString(i1));
    }
  }
  
  public int a(String paramString1, String paramString2)
  {
    int i1 = a(35633, paramString1);
    int i2 = a(35632, paramString2);
    int i3 = GLES20.glCreateProgram();
    if (i3 != 0)
    {
      GLES20.glAttachShader(i3, i1);
      a("glAttachShader");
      GLES20.glAttachShader(i3, i2);
      a("glAttachShader");
      GLES20.glLinkProgram(i3);
      paramString1 = new int[1];
      GLES20.glGetProgramiv(i3, 35714, paramString1, 0);
      if (paramString1[0] != 1)
      {
        GLES20.glDeleteProgram(i3);
        return 0;
      }
    }
    return i3;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Int <= 0) {
      this.jdField_b_of_type_Int = a("attribute vec4 vPosition;\nattribute vec2 a_texCoord;\nvarying vec2 tc;\nvoid main() {\ngl_Position = vPosition;\ntc = a_texCoord;\n}\n", "precision mediump float;\nuniform sampler2D tex_y;\nuniform sampler2D tex_u;\nuniform sampler2D tex_v;\nvarying vec2 tc;\nvoid main() {\nvec4 c = vec4((texture2D(tex_y, tc).r - 16./255.) * 1.164);\nvec4 U = vec4(texture2D(tex_u, tc).r - 128./255.);\nvec4 V = vec4(texture2D(tex_v, tc).r - 128./255.);\nc += V * vec4(1.596, -0.813, 0, 0);\nc += U * vec4(0, -0.392, 2.017, 0);\nc.a = 1.0;\ngl_FragColor = c;\n}\n");
    }
    this.jdField_i_of_type_Int = GLES20.glGetAttribLocation(this.jdField_b_of_type_Int, "vPosition");
    a("glGetAttribLocation vPosition");
    if ((this.jdField_i_of_type_Int == -1) && (QLog.isColorLevel())) {
      QLog.i("GreetingYUVProgram", 1, "Could not get attribute location for vPosition");
    }
    this.j = GLES20.glGetAttribLocation(this.jdField_b_of_type_Int, "a_texCoord");
    a("glGetAttribLocation a_texCoord");
    if ((this.j == -1) && (QLog.isColorLevel())) {
      QLog.i("GreetingYUVProgram", 1, "Could not get attribute location for a_texCoord");
    }
    this.k = GLES20.glGetUniformLocation(this.jdField_b_of_type_Int, "tex_y");
    a("glGetUniformLocation tex_y");
    if ((this.k == -1) && (QLog.isColorLevel())) {
      QLog.i("GreetingYUVProgram", 1, "Could not get uniform location for tex_y");
    }
    this.l = GLES20.glGetUniformLocation(this.jdField_b_of_type_Int, "tex_u");
    a("glGetUniformLocation tex_u");
    if ((this.l == -1) && (QLog.isColorLevel())) {
      QLog.i("GreetingYUVProgram", 1, "Could not get uniform location for tex_u");
    }
    this.m = GLES20.glGetUniformLocation(this.jdField_b_of_type_Int, "tex_v");
    a("glGetUniformLocation tex_v");
    if ((this.m == -1) && (QLog.isColorLevel())) {
      QLog.i("GreetingYUVProgram", 1, "Could not get uniform location for tex_v");
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_h_of_type_ArrayOfFloat = jdField_a_of_type_ArrayOfFloat;
      this.jdField_c_of_type_Int = 33984;
      this.jdField_d_of_type_Int = 33985;
      this.jdField_e_of_type_Int = 33986;
      this.jdField_f_of_type_Int = 0;
      this.jdField_g_of_type_Int = 1;
      this.jdField_h_of_type_Int = 2;
      return;
    case 1: 
      this.jdField_h_of_type_ArrayOfFloat = jdField_c_of_type_ArrayOfFloat;
      this.jdField_c_of_type_Int = 33984;
      this.jdField_d_of_type_Int = 33985;
      this.jdField_e_of_type_Int = 33986;
      this.jdField_f_of_type_Int = 0;
      this.jdField_g_of_type_Int = 1;
      this.jdField_h_of_type_Int = 2;
      return;
    case 2: 
      this.jdField_h_of_type_ArrayOfFloat = jdField_d_of_type_ArrayOfFloat;
      this.jdField_c_of_type_Int = 33987;
      this.jdField_d_of_type_Int = 33988;
      this.jdField_e_of_type_Int = 33989;
      this.jdField_f_of_type_Int = 3;
      this.jdField_g_of_type_Int = 4;
      this.jdField_h_of_type_Int = 5;
      return;
    case 3: 
      this.jdField_h_of_type_ArrayOfFloat = jdField_e_of_type_ArrayOfFloat;
      this.jdField_c_of_type_Int = 33990;
      this.jdField_d_of_type_Int = 33991;
      this.jdField_e_of_type_Int = 33992;
      this.jdField_f_of_type_Int = 6;
      this.jdField_g_of_type_Int = 7;
      this.jdField_h_of_type_Int = 8;
      return;
    }
    this.jdField_h_of_type_ArrayOfFloat = jdField_f_of_type_ArrayOfFloat;
    this.jdField_c_of_type_Int = 33993;
    this.jdField_d_of_type_Int = 33994;
    this.jdField_e_of_type_Int = 33995;
    this.jdField_f_of_type_Int = 9;
    this.jdField_g_of_type_Int = 10;
    this.jdField_h_of_type_Int = 11;
  }
  
  public void a(Buffer paramBuffer1, Buffer paramBuffer2, Buffer paramBuffer3, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.q) || (paramInt2 != this.r)) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.q = paramInt1;
        this.r = paramInt2;
      }
      if ((this.n < 0) || (i1 != 0))
      {
        if (this.n >= 0)
        {
          GLES20.glDeleteTextures(1, new int[] { this.n }, 0);
          a("glDeleteTextures");
        }
        int[] arrayOfInt = new int[1];
        GLES20.glGenTextures(1, arrayOfInt, 0);
        a("glGenTextures");
        this.n = arrayOfInt[0];
      }
      QLog.d("AVGAmeRender", 1, "buildTextures : w=" + this.q + " h=" + this.r + " yData=" + paramBuffer1.capacity());
      GLES20.glBindTexture(3553, this.n);
      a("glBindTexture");
      GLES20.glTexImage2D(3553, 0, 6409, this.q, this.r, 0, 6409, 5121, paramBuffer1);
      a("glTexImage2D");
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      if ((this.o < 0) || (i1 != 0))
      {
        if (this.o >= 0)
        {
          GLES20.glDeleteTextures(1, new int[] { this.o }, 0);
          a("glDeleteTextures");
        }
        paramBuffer1 = new int[1];
        GLES20.glGenTextures(1, paramBuffer1, 0);
        a("glGenTextures");
        this.o = paramBuffer1[0];
      }
      GLES20.glBindTexture(3553, this.o);
      GLES20.glTexImage2D(3553, 0, 6409, this.q / 2, this.r / 2, 0, 6409, 5121, paramBuffer2);
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      if ((this.p < 0) || (i1 != 0))
      {
        if (this.p >= 0)
        {
          GLES20.glDeleteTextures(1, new int[] { this.p }, 0);
          a("glDeleteTextures");
        }
        paramBuffer1 = new int[1];
        GLES20.glGenTextures(1, paramBuffer1, 0);
        a("glGenTextures");
        this.p = paramBuffer1[0];
      }
      GLES20.glBindTexture(3553, this.p);
      GLES20.glTexImage2D(3553, 0, 6409, this.q / 2, this.r / 2, 0, 6409, 5121, paramBuffer3);
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      return;
    }
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    this.jdField_a_of_type_JavaNioByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioByteBuffer.asFloatBuffer().put(paramArrayOfFloat);
    this.jdField_a_of_type_JavaNioByteBuffer.position(0);
    if (this.jdField_b_of_type_JavaNioByteBuffer == null)
    {
      this.jdField_b_of_type_JavaNioByteBuffer = ByteBuffer.allocateDirect(jdField_i_of_type_ArrayOfFloat.length * 4);
      this.jdField_b_of_type_JavaNioByteBuffer.order(ByteOrder.nativeOrder());
      this.jdField_b_of_type_JavaNioByteBuffer.asFloatBuffer().put(jdField_i_of_type_ArrayOfFloat);
      this.jdField_b_of_type_JavaNioByteBuffer.position(0);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    GLES20.glUseProgram(this.jdField_b_of_type_Int);
    a("glUseProgram");
    GLES20.glVertexAttribPointer(this.jdField_i_of_type_Int, 2, 5126, false, 8, this.jdField_a_of_type_JavaNioByteBuffer);
    a("glVertexAttribPointer mPositionHandle");
    GLES20.glEnableVertexAttribArray(this.jdField_i_of_type_Int);
    GLES20.glVertexAttribPointer(this.j, 2, 5126, false, 8, this.jdField_b_of_type_JavaNioByteBuffer);
    a("glVertexAttribPointer maTextureHandle");
    GLES20.glEnableVertexAttribArray(this.j);
    GLES20.glActiveTexture(this.jdField_c_of_type_Int);
    GLES20.glBindTexture(3553, this.n);
    GLES20.glUniform1i(this.k, this.jdField_f_of_type_Int);
    GLES20.glActiveTexture(this.jdField_d_of_type_Int);
    GLES20.glBindTexture(3553, this.o);
    GLES20.glUniform1i(this.l, this.jdField_g_of_type_Int);
    GLES20.glActiveTexture(this.jdField_e_of_type_Int);
    GLES20.glBindTexture(3553, this.p);
    GLES20.glUniform1i(this.m, this.jdField_h_of_type_Int);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glFinish();
    GLES20.glDisableVertexAttribArray(this.jdField_i_of_type_Int);
    GLES20.glDisableVertexAttribArray(this.j);
    GLES20.glUseProgram(0);
  }
  
  public void c()
  {
    if (this.n != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { this.n }, 0);
      a("glDeleteTextures");
      this.n = -1;
    }
    if (this.o != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { this.o }, 0);
      a("glDeleteTextures");
      this.o = -1;
    }
    if (this.p != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { this.p }, 0);
      a("glDeleteTextures");
      this.p = -1;
    }
    if (this.jdField_b_of_type_Int > 0)
    {
      this.jdField_a_of_type_Boolean = false;
      GLES20.glDeleteProgram(this.jdField_b_of_type_Int);
      a("glDeleteProgram");
      this.jdField_b_of_type_Int = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aouq
 * JD-Core Version:    0.7.0.1
 */