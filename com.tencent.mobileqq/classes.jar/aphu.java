import android.opengl.GLSurfaceView;
import com.tencent.qphone.base.util.QLog;

public final class aphu
{
  public static apho a(aphq paramaphq, aphs paramaphs, GLSurfaceView paramGLSurfaceView)
  {
    if (paramaphs == null) {
      return null;
    }
    switch (paramaphs.a)
    {
    default: 
      return null;
    case 0: 
      paramaphq = new apid(paramaphq, (apie)paramaphs);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_3D here " + paramaphs.toString());
      return paramaphq;
    case 2: 
    case 3: 
      paramaphq = new apil(paramaphq, (apin)paramaphs);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_NORAML_2D_VIDEO here" + paramaphs.toString());
      return paramaphq;
    case 4: 
      paramaphq = new apio(paramaphq, (apiq)paramaphs);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_ONLINE_VIDEO here" + paramaphs.toString());
      return paramaphq;
    case 5: 
      paramaphq = new apik(paramaphq, (apij)paramaphs);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_MULTI_ANIM here" + paramaphs.toString());
      return paramaphq;
    case 100: 
      paramaphq = new apih(paramaphq, (apii)paramaphs, paramGLSurfaceView);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_BINHAI_3D here" + paramaphs.toString());
      return paramaphq;
    }
    return new aphx(paramaphq, (aphz)paramaphs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aphu
 * JD-Core Version:    0.7.0.1
 */