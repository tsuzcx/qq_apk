import android.opengl.GLES20;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;

public class anax
{
  public static final String a;
  public static final float[] a;
  public static String b;
  public static String c;
  public static String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = alpo.a(2131706331);
    b = "    //抠像逻辑片段\n";
    c = "    //用户定义，抠像后逻辑片段\n";
    d = "}\n";
    jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  }
  
  public static int a(int paramInt, String paramString)
  {
    int i = GLES20.glCreateShader(paramInt);
    a("glCreateShader type=" + paramInt);
    GLES20.glShaderSource(i, paramString);
    GLES20.glCompileShader(i);
    paramString = new int[1];
    GLES20.glGetShaderiv(i, 35713, paramString, 0);
    if (paramString[0] == 0)
    {
      Log.e("KeyingUtil", "Could not compile shader " + paramInt + ":" + GLES20.glGetShaderInfoLog(i));
      GLES20.glDeleteShader(i);
      return 0;
    }
    return i;
  }
  
  public static int a(String paramString1, String paramString2)
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
      Log.e("KeyingUtil", "Could not create program");
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
      Log.e("KeyingUtil", "Could not link program:" + GLES20.glGetProgramInfoLog(k));
      GLES20.glDeleteProgram(k);
      return 0;
    }
    return k;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isDevelopLevel()) {
        throw new IllegalArgumentException("invalid textureType!");
      }
      break;
    case 1: 
      return "#define TEXTURE_TYPE_OES\n";
    case 2: 
      return "#define TEXTURE_TYPE_SAMPLER2D\n";
    case 3: 
      return "#define TEXTURE_TYPE_Y_U_V\n";
    case 4: 
      return "#define TEXTURE_TYPE_Y_UV\n";
    }
    return "";
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      int i = GLES20.glGetError();
      if (i != 0) {
        Log.e("KeyingUtil", paramString + ": glError 0x" + Integer.toHexString(i));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anax
 * JD-Core Version:    0.7.0.1
 */