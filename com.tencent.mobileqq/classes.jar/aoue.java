import android.opengl.GLSurfaceView;
import com.tencent.qphone.base.util.QLog;

public final class aoue
{
  public static aoty a(aoua paramaoua, aouc paramaouc, GLSurfaceView paramGLSurfaceView)
  {
    if (paramaouc == null) {
      return null;
    }
    switch (paramaouc.a)
    {
    default: 
      return null;
    case 0: 
      paramaoua = new aoun(paramaoua, (aouo)paramaouc);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_3D here " + paramaouc.toString());
      return paramaoua;
    case 2: 
    case 3: 
      paramaoua = new aouv(paramaoua, (aoux)paramaouc);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_NORAML_2D_VIDEO here" + paramaouc.toString());
      return paramaoua;
    case 4: 
      paramaoua = new aouy(paramaoua, (aova)paramaouc);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_ONLINE_VIDEO here" + paramaouc.toString());
      return paramaoua;
    case 5: 
      paramaoua = new aouu(paramaoua, (aout)paramaouc);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_MULTI_ANIM here" + paramaouc.toString());
      return paramaoua;
    case 100: 
      paramaoua = new aour(paramaoua, (aous)paramaouc, paramGLSurfaceView);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_BINHAI_3D here" + paramaouc.toString());
      return paramaoua;
    }
    return new aouh(paramaoua, (aouj)paramaouc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoue
 * JD-Core Version:    0.7.0.1
 */