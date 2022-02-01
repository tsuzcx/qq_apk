import android.opengl.GLSurfaceView;
import com.tencent.qphone.base.util.QLog;

public final class apej
{
  public static aped a(apef paramapef, apeh paramapeh, GLSurfaceView paramGLSurfaceView)
  {
    if (paramapeh == null) {
      return null;
    }
    switch (paramapeh.a)
    {
    default: 
      return null;
    case 0: 
      paramapef = new apes(paramapef, (apet)paramapeh);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_3D here " + paramapeh.toString());
      return paramapef;
    case 2: 
    case 3: 
      paramapef = new apfa(paramapef, (apfc)paramapeh);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_NORAML_2D_VIDEO here" + paramapeh.toString());
      return paramapef;
    case 4: 
      paramapef = new apfd(paramapef, (apff)paramapeh);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_ONLINE_VIDEO here" + paramapeh.toString());
      return paramapef;
    case 5: 
      paramapef = new apez(paramapef, (apey)paramapeh);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_MULTI_ANIM here" + paramapeh.toString());
      return paramapef;
    case 100: 
      paramapef = new apew(paramapef, (apex)paramapeh, paramGLSurfaceView);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_BINHAI_3D here" + paramapeh.toString());
      return paramapef;
    }
    return new apem(paramapef, (apeo)paramapeh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apej
 * JD-Core Version:    0.7.0.1
 */