import android.content.Context;
import android.view.SurfaceHolder;
import cooperation.qzone.util.JarReflectUtil;

public class bkzu
{
  private Object a = JarReflectUtil.creatSpecifiedObject("com.tencent.tar.TarInterface", null, new Object[0]);
  
  public int a()
  {
    Object localObject = JarReflectUtil.callSpecifiedMethod(this.a, "getConfigWith", false, null, new Object[0]);
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    return -1;
  }
  
  public int a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean)
  {
    paramSurfaceHolder = JarReflectUtil.callSpecifiedMethod(this.a, "onDrawFrame", false, a(new Class[] { SurfaceHolder.class, Boolean.TYPE }), new Object[] { paramSurfaceHolder, Boolean.valueOf(paramBoolean) });
    if ((paramSurfaceHolder instanceof Integer)) {
      return ((Integer)paramSurfaceHolder).intValue();
    }
    return 0;
  }
  
  public void a()
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "onResume", false, null, new Object[0]);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "setTrackingPoint", false, a(new Class[] { Float.TYPE, Float.TYPE }), new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "onSurfaceChanged", false, a(new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE }), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
  }
  
  public void a(Context paramContext, int paramInt)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "init", false, a(new Class[] { Context.class, Integer.TYPE }), new Object[] { paramContext, Integer.valueOf(paramInt) });
  }
  
  public float[] a()
  {
    Object localObject = JarReflectUtil.callSpecifiedMethod(this.a, "getModelMatrix", false, null, new Object[0]);
    if ((localObject instanceof float[])) {
      return (float[])localObject;
    }
    return null;
  }
  
  public Class[] a(Class... paramVarArgs)
  {
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfClass[i] = paramVarArgs[i];
      i += 1;
    }
    return arrayOfClass;
  }
  
  public int b()
  {
    Object localObject = JarReflectUtil.callSpecifiedMethod(this.a, "getConfigHeight", false, null, new Object[0]);
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    return -1;
  }
  
  public void b()
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "onStop", false, null, new Object[0]);
  }
  
  public float[] b()
  {
    Object localObject = JarReflectUtil.callSpecifiedMethod(this.a, "getViewMatrix", false, null, new Object[0]);
    if ((localObject instanceof float[])) {
      return (float[])localObject;
    }
    return null;
  }
  
  public void c()
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "onDestroy", false, null, new Object[0]);
  }
  
  public float[] c()
  {
    Object localObject = JarReflectUtil.callSpecifiedMethod(this.a, "getProjectionMatrix", false, null, new Object[0]);
    if ((localObject instanceof float[])) {
      return (float[])localObject;
    }
    return null;
  }
  
  public void d()
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "onSurfaceCreated", false, null, new Object[0]);
  }
  
  public float[] d()
  {
    Object localObject = JarReflectUtil.callSpecifiedMethod(this.a, "getScaleMatrix", false, null, new Object[0]);
    if ((localObject instanceof float[])) {
      return (float[])localObject;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzu
 * JD-Core Version:    0.7.0.1
 */