import android.content.Context;
import android.view.SurfaceHolder;

public class bnun
{
  private Object a = bnjq.a("com.tencent.tar.TarInterface", null, new Object[0]);
  
  public int a()
  {
    Object localObject = bnjq.a(this.a, "getConfigWith", false, null, new Object[0]);
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    return -1;
  }
  
  public int a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean)
  {
    paramSurfaceHolder = bnjq.a(this.a, "onDrawFrame", false, a(new Class[] { SurfaceHolder.class, Boolean.TYPE }), new Object[] { paramSurfaceHolder, Boolean.valueOf(paramBoolean) });
    if ((paramSurfaceHolder instanceof Integer)) {
      return ((Integer)paramSurfaceHolder).intValue();
    }
    return 0;
  }
  
  public void a()
  {
    bnjq.a(this.a, "onResume", false, null, new Object[0]);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    bnjq.a(this.a, "setTrackingPoint", false, a(new Class[] { Float.TYPE, Float.TYPE }), new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    bnjq.a(this.a, "onSurfaceChanged", false, a(new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE }), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
  }
  
  public void a(Context paramContext, int paramInt)
  {
    bnjq.a(this.a, "init", false, a(new Class[] { Context.class, Integer.TYPE }), new Object[] { paramContext, Integer.valueOf(paramInt) });
  }
  
  public float[] a()
  {
    Object localObject = bnjq.a(this.a, "getModelMatrix", false, null, new Object[0]);
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
    Object localObject = bnjq.a(this.a, "getConfigHeight", false, null, new Object[0]);
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    return -1;
  }
  
  public void b()
  {
    bnjq.a(this.a, "onStop", false, null, new Object[0]);
  }
  
  public float[] b()
  {
    Object localObject = bnjq.a(this.a, "getViewMatrix", false, null, new Object[0]);
    if ((localObject instanceof float[])) {
      return (float[])localObject;
    }
    return null;
  }
  
  public void c()
  {
    bnjq.a(this.a, "onDestroy", false, null, new Object[0]);
  }
  
  public float[] c()
  {
    Object localObject = bnjq.a(this.a, "getProjectionMatrix", false, null, new Object[0]);
    if ((localObject instanceof float[])) {
      return (float[])localObject;
    }
    return null;
  }
  
  public void d()
  {
    bnjq.a(this.a, "onSurfaceCreated", false, null, new Object[0]);
  }
  
  public float[] d()
  {
    Object localObject = bnjq.a(this.a, "getScaleMatrix", false, null, new Object[0]);
    if ((localObject instanceof float[])) {
      return (float[])localObject;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnun
 * JD-Core Version:    0.7.0.1
 */