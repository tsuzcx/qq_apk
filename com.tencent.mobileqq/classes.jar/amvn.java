import android.opengl.GLSurfaceView;
import com.tencent.qphone.base.util.QLog;

public final class amvn
{
  public static amvh a(amvj paramamvj, amvl paramamvl, GLSurfaceView paramGLSurfaceView)
  {
    if (paramamvl == null) {
      return null;
    }
    switch (paramamvl.a)
    {
    default: 
      return null;
    case 0: 
      paramamvj = new amvw(paramamvj, (amvx)paramamvl);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_3D here " + paramamvl.toString());
      return paramamvj;
    case 2: 
    case 3: 
      paramamvj = new amwe(paramamvj, (amwg)paramamvl);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_NORAML_2D_VIDEO here" + paramamvl.toString());
      return paramamvj;
    case 4: 
      paramamvj = new amwh(paramamvj, (amwj)paramamvl);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_ONLINE_VIDEO here" + paramamvl.toString());
      return paramamvj;
    case 5: 
      paramamvj = new amwd(paramamvj, (amwc)paramamvl);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_MULTI_ANIM here" + paramamvl.toString());
      return paramamvj;
    case 100: 
      paramamvj = new amwa(paramamvj, (amwb)paramamvl, paramGLSurfaceView);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_BINHAI_3D here" + paramamvl.toString());
      return paramamvj;
    }
    return new amvq(paramamvj, (amvs)paramamvl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvn
 * JD-Core Version:    0.7.0.1
 */