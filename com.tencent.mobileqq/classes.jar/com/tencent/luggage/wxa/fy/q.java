package com.tencent.luggage.wxa.fy;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.o;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class q
{
  @Nullable
  private static final Field a;
  @NonNull
  private final SurfaceTexture b;
  @NonNull
  private final List<q.b> c = new ArrayList();
  
  static
  {
    Object localObject = null;
    try
    {
      Field localField = SurfaceTexture.class.getDeclaredField("mOnFrameAvailableHandler");
      localObject = localField;
      localField.setAccessible(true);
      localObject = localField;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get mOnFrameAvailableHandler fail since ");
      localStringBuilder.append(localException.toString());
      o.c("MicroMsg.AppBrand.SurfaceTextureWrapper", localStringBuilder.toString());
    }
    a = localObject;
  }
  
  private q(@NonNull SurfaceTexture paramSurfaceTexture)
  {
    this.b = paramSurfaceTexture;
  }
  
  /* Error */
  @Nullable
  public static q a(@NonNull SurfaceTexture paramSurfaceTexture)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 58	com/tencent/luggage/wxa/fy/q:a	Ljava/lang/reflect/Field;
    //   5: ifnonnull +7 -> 12
    //   8: aload_0
    //   9: monitorexit
    //   10: aconst_null
    //   11: areturn
    //   12: getstatic 58	com/tencent/luggage/wxa/fy/q:a	Ljava/lang/reflect/Field;
    //   15: aload_0
    //   16: invokevirtual 75	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast 77	android/os/Handler
    //   22: astore_2
    //   23: aload_2
    //   24: ifnonnull +14 -> 38
    //   27: ldc 50
    //   29: ldc 79
    //   31: invokestatic 56	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload_0
    //   35: monitorexit
    //   36: aconst_null
    //   37: areturn
    //   38: aload_2
    //   39: instanceof 81
    //   42: ifeq +22 -> 64
    //   45: ldc 50
    //   47: ldc 83
    //   49: invokestatic 86	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_2
    //   53: checkcast 81	com/tencent/luggage/wxa/fy/q$a
    //   56: getfield 89	com/tencent/luggage/wxa/fy/q$a:a	Lcom/tencent/luggage/wxa/fy/q;
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: areturn
    //   64: new 2	com/tencent/luggage/wxa/fy/q
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 91	com/tencent/luggage/wxa/fy/q:<init>	(Landroid/graphics/SurfaceTexture;)V
    //   72: astore_1
    //   73: new 81	com/tencent/luggage/wxa/fy/q$a
    //   76: dup
    //   77: aload_2
    //   78: aload_1
    //   79: invokespecial 94	com/tencent/luggage/wxa/fy/q$a:<init>	(Landroid/os/Handler;Lcom/tencent/luggage/wxa/fy/q;)V
    //   82: astore_2
    //   83: getstatic 58	com/tencent/luggage/wxa/fy/q:a	Ljava/lang/reflect/Field;
    //   86: aload_0
    //   87: aload_2
    //   88: invokevirtual 98	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: areturn
    //   95: astore_1
    //   96: new 35	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   103: astore_2
    //   104: aload_2
    //   105: ldc 100
    //   107: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_2
    //   112: aload_1
    //   113: invokevirtual 48	java/lang/Exception:toString	()Ljava/lang/String;
    //   116: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: ldc 50
    //   122: aload_2
    //   123: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 56	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_0
    //   130: monitorexit
    //   131: aconst_null
    //   132: areturn
    //   133: astore_1
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramSurfaceTexture	SurfaceTexture
    //   59	35	1	localq	q
    //   95	18	1	localException	Exception
    //   133	4	1	localObject1	Object
    //   22	101	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	23	95	java/lang/Exception
    //   27	34	95	java/lang/Exception
    //   38	60	95	java/lang/Exception
    //   64	91	95	java/lang/Exception
    //   2	10	133	finally
    //   12	23	133	finally
    //   27	34	133	finally
    //   34	36	133	finally
    //   38	60	133	finally
    //   60	62	133	finally
    //   64	91	133	finally
    //   91	93	133	finally
    //   96	131	133	finally
    //   134	136	133	finally
  }
  
  private void a()
  {
    try
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        q.b localb = (q.b)localIterator.next();
        if (localb.b == null) {
          localb.a.onFrameAvailable(this.b);
        } else {
          localb.b.post(new q.1(this, localb));
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(@NonNull SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    try
    {
      this.c.remove(new q.b(paramOnFrameAvailableListener, null));
      return;
    }
    finally
    {
      paramOnFrameAvailableListener = finally;
      throw paramOnFrameAvailableListener;
    }
  }
  
  public void a(@NonNull SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, @Nullable Handler paramHandler)
  {
    try
    {
      paramOnFrameAvailableListener = new q.b(paramOnFrameAvailableListener, paramHandler);
      this.c.remove(paramOnFrameAvailableListener);
      this.c.add(paramOnFrameAvailableListener);
      return;
    }
    finally
    {
      paramOnFrameAvailableListener = finally;
      throw paramOnFrameAvailableListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.q
 * JD-Core Version:    0.7.0.1
 */