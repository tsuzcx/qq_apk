import android.opengl.GLES20;
import cooperation.qzone.util.QZLog;

public class bmby
{
  public static int a()
  {
    return a(a("attribute vec4 aPosition;\nuniform mat4 uProjectMatrix;\nattribute vec2 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main(){\n\tgl_Position = uProjectMatrix * aPosition;\n    vTextureCoord = aTextureCoord;\n}"), b("precision mediump float;\nuniform sampler2D uTexture;\nvarying vec2 vTextureCoord;\nvoid main(){\n\tgl_FragColor = texture2D(uTexture, vTextureCoord);\n}"));
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    int i = GLES20.glCreateProgram();
    if (i == 0)
    {
      QZLog.e("ShaderUtil", "glCreateProgram: fail");
      return 0;
    }
    GLES20.glAttachShader(i, paramInt1);
    GLES20.glAttachShader(i, paramInt2);
    GLES20.glLinkProgram(i);
    int[] arrayOfInt = new int[1];
    GLES20.glGetProgramiv(i, 35714, arrayOfInt, 0);
    QZLog.e("ShaderUtil", "glGetShaderiv: " + GLES20.glGetShaderInfoLog(i));
    if (arrayOfInt[0] == 0)
    {
      GLES20.glDeleteProgram(i);
      QZLog.e("ShaderUtil", "glGetProgramiv: fail 0 ");
      return 0;
    }
    return i;
  }
  
  private static int a(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    if (paramInt == 0)
    {
      QZLog.e("ShaderUtil", "glCreateShader: fail 0 ");
      return 0;
    }
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    paramString = new int[1];
    GLES20.glGetShaderiv(paramInt, 35713, paramString, 0);
    QZLog.e("ShaderUtil", "glGetShaderiv: " + GLES20.glGetShaderInfoLog(paramInt));
    if (paramString[0] == 0)
    {
      GLES20.glDeleteShader(paramInt);
      QZLog.e("ShaderUtil", "glGetShaderiv: fail 0 ");
      return 0;
    }
    return paramInt;
  }
  
  private static int a(String paramString)
  {
    return a(35633, paramString);
  }
  
  private static int b(String paramString)
  {
    return a(35632, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmby
 * JD-Core Version:    0.7.0.1
 */