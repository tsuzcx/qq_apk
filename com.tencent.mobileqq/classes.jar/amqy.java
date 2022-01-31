import android.opengl.GLSurfaceView;
import com.tencent.qphone.base.util.QLog;

public final class amqy
{
  public static amqs a(amqu paramamqu, amqw paramamqw, GLSurfaceView paramGLSurfaceView)
  {
    if (paramamqw == null) {
      return null;
    }
    switch (paramamqw.a)
    {
    default: 
      return null;
    case 0: 
      paramamqu = new amrh(paramamqu, (amri)paramamqw);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_3D here " + paramamqw.toString());
      return paramamqu;
    case 2: 
    case 3: 
      paramamqu = new amrp(paramamqu, (amrr)paramamqw);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_NORAML_2D_VIDEO here" + paramamqw.toString());
      return paramamqu;
    case 4: 
      paramamqu = new amrs(paramamqu, (amru)paramamqw);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_ONLINE_VIDEO here" + paramamqw.toString());
      return paramamqu;
    case 5: 
      paramamqu = new amro(paramamqu, (amrn)paramamqw);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_MULTI_ANIM here" + paramamqw.toString());
      return paramamqu;
    case 100: 
      paramamqu = new amrl(paramamqu, (amrm)paramamqw, paramGLSurfaceView);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_BINHAI_3D here" + paramamqw.toString());
      return paramamqu;
    }
    return new amrb(paramamqu, (amrd)paramamqw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqy
 * JD-Core Version:    0.7.0.1
 */