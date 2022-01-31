import android.opengl.GLES20;

public class bksi
{
  private static int[] a = new int[1];
  
  public static int a()
  {
    return a("precision highp float;\nattribute vec4 position;\nattribute vec2 textureCoordinateIn;\nvarying   vec2 texturecoordinateOut;\nvoid main()\n{\ntexturecoordinateOut = textureCoordinateIn;\ngl_Position = position;\n}\n", "precision mediump float;varying   vec2 texturecoordinateOut;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerU;\nuniform sampler2D SamplerV;\nvoid main()\n{\nvec3 yuv;\nvec3 rgb;\nvec4 rgba;\nyuv.x = texture2D(SamplerY, texturecoordinateOut).r;\nyuv.y = texture2D(SamplerU, texturecoordinateOut).r-0.5;\nyuv.z = texture2D(SamplerV, texturecoordinateOut).r-0.5;\nrgb = mat3(      1,       1,      1,\n0, \t\t-.34414, 1.772,\n1.402, \t-.71414, 0) * yuv;\nrgba = vec4(rgb, 1);\ngl_FragColor = rgba;\n}\n");
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    int i = GLES20.glCreateProgram();
    if (i == 0)
    {
      bksg.a("glCreateProgram:program == 0");
      return 0;
    }
    GLES20.glAttachShader(i, paramInt1);
    GLES20.glAttachShader(i, paramInt2);
    GLES20.glLinkProgram(i);
    GLES20.glGetProgramiv(i, 35714, a, 0);
    if (a[0] == 0)
    {
      String str = GLES20.glGetProgramInfoLog(i);
      GLES20.glDeleteProgram(i);
      bksg.a("linkProgram:GL_COMPILE_STATUS errorinfo =" + str);
      return 0;
    }
    return i;
  }
  
  private static int a(int paramInt, String paramString)
  {
    int i = GLES20.glCreateShader(paramInt);
    if (i == 0)
    {
      bksg.a("glCreateShader:shader==0 type=" + a(paramInt));
      return 0;
    }
    GLES20.glShaderSource(i, paramString);
    GLES20.glCompileShader(i);
    GLES20.glGetShaderiv(i, 35713, a, 0);
    if (a[0] == 0)
    {
      paramString = GLES20.glGetShaderInfoLog(i);
      GLES20.glDeleteShader(i);
      bksg.a("glGetShaderiv:GL_COMPILE_STATUS error  loginfo=" + paramString);
      return 0;
    }
    return i;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int i = a(35633, paramString1);
    int j = a(35632, paramString2);
    if ((i == 0) || (j == 0))
    {
      bksg.a("compileShader:vertext or fragment == 0");
      return 0;
    }
    int k = a(i, j);
    if (k == 0)
    {
      GLES20.glDeleteShader(i);
      GLES20.glDeleteShader(j);
      return 0;
    }
    return k;
  }
  
  private static String a(int paramInt)
  {
    if (paramInt == 35633) {
      return "GL_VERTEX_SHADER";
    }
    if (paramInt == 35632) {
      return "GL_FRAGMENT_SHADER";
    }
    return "unKnown";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bksi
 * JD-Core Version:    0.7.0.1
 */