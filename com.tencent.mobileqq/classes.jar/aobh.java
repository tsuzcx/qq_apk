import android.opengl.GLSurfaceView;
import com.tencent.qphone.base.util.QLog;

public final class aobh
{
  public static aobb a(aobd paramaobd, aobf paramaobf, GLSurfaceView paramGLSurfaceView)
  {
    if (paramaobf == null) {
      return null;
    }
    switch (paramaobf.a)
    {
    default: 
      return null;
    case 0: 
      paramaobd = new aobq(paramaobd, (aobr)paramaobf);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_3D here " + paramaobf.toString());
      return paramaobd;
    case 2: 
    case 3: 
      paramaobd = new aoby(paramaobd, (aoca)paramaobf);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_NORAML_2D_VIDEO here" + paramaobf.toString());
      return paramaobd;
    case 4: 
      paramaobd = new aocb(paramaobd, (aocd)paramaobf);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_ONLINE_VIDEO here" + paramaobf.toString());
      return paramaobd;
    case 5: 
      paramaobd = new aobx(paramaobd, (aobw)paramaobf);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_MULTI_ANIM here" + paramaobf.toString());
      return paramaobd;
    case 100: 
      paramaobd = new aobu(paramaobd, (aobv)paramaobf, paramGLSurfaceView);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_BINHAI_3D here" + paramaobf.toString());
      return paramaobd;
    }
    return new aobk(paramaobd, (aobm)paramaobf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aobh
 * JD-Core Version:    0.7.0.1
 */