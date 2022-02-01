package com.tencent.liteav.beauty.b;

import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.os.Handler;
import android.os.Looper;

public class w
{
  private static final String b = "w";
  SurfaceTexture.OnFrameAvailableListener a;
  private SurfaceTexture c;
  private int d = -1;
  private boolean e = false;
  private MediaExtractor f;
  private AssetFileDescriptor g;
  private int h = -1;
  private int i = -1;
  private int j = -1;
  private int k = -1;
  private long l;
  private MediaCodec m;
  private boolean n = false;
  private boolean o;
  private Handler p;
  private Object q = new Object();
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/tencent/liteav/beauty/b/w:e	Z
    //   4: ifeq +271 -> 275
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield 44	com/tencent/liteav/beauty/b/w:e	Z
    //   12: aload_0
    //   13: getfield 61	com/tencent/liteav/beauty/b/w:f	Landroid/media/MediaExtractor;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +12 -> 30
    //   21: aload_1
    //   22: invokevirtual 66	android/media/MediaExtractor:release	()V
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 61	com/tencent/liteav/beauty/b/w:f	Landroid/media/MediaExtractor;
    //   30: aload_0
    //   31: getfield 68	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   34: invokevirtual 73	android/media/MediaCodec:stop	()V
    //   37: aload_0
    //   38: getfield 68	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   41: invokevirtual 74	android/media/MediaCodec:release	()V
    //   44: aload_0
    //   45: aconst_null
    //   46: putfield 68	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   49: return
    //   50: astore_1
    //   51: goto +43 -> 94
    //   54: astore_1
    //   55: getstatic 76	com/tencent/liteav/beauty/b/w:b	Ljava/lang/String;
    //   58: astore_2
    //   59: new 78	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   66: astore_3
    //   67: aload_3
    //   68: ldc 81
    //   70: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_3
    //   75: aload_1
    //   76: invokevirtual 89	java/lang/Exception:toString	()Ljava/lang/String;
    //   79: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_2
    //   84: aload_3
    //   85: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 95	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: goto -47 -> 44
    //   94: aload_0
    //   95: aconst_null
    //   96: putfield 68	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   99: aload_1
    //   100: athrow
    //   101: astore_1
    //   102: goto +101 -> 203
    //   105: astore_1
    //   106: getstatic 76	com/tencent/liteav/beauty/b/w:b	Ljava/lang/String;
    //   109: astore_2
    //   110: new 78	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   117: astore_3
    //   118: aload_3
    //   119: ldc 97
    //   121: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_3
    //   126: aload_1
    //   127: invokevirtual 89	java/lang/Exception:toString	()Ljava/lang/String;
    //   130: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_2
    //   135: aload_3
    //   136: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 95	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_0
    //   143: getfield 68	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   146: invokevirtual 74	android/media/MediaCodec:release	()V
    //   149: goto -105 -> 44
    //   152: astore_1
    //   153: goto +43 -> 196
    //   156: astore_1
    //   157: getstatic 76	com/tencent/liteav/beauty/b/w:b	Ljava/lang/String;
    //   160: astore_2
    //   161: new 78	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   168: astore_3
    //   169: aload_3
    //   170: ldc 81
    //   172: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload_3
    //   177: aload_1
    //   178: invokevirtual 89	java/lang/Exception:toString	()Ljava/lang/String;
    //   181: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_2
    //   186: aload_3
    //   187: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 95	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: goto -149 -> 44
    //   196: aload_0
    //   197: aconst_null
    //   198: putfield 68	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   201: aload_1
    //   202: athrow
    //   203: aload_0
    //   204: getfield 68	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   207: invokevirtual 74	android/media/MediaCodec:release	()V
    //   210: aload_0
    //   211: aconst_null
    //   212: putfield 68	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   215: goto +51 -> 266
    //   218: astore_1
    //   219: goto +49 -> 268
    //   222: astore_2
    //   223: getstatic 76	com/tencent/liteav/beauty/b/w:b	Ljava/lang/String;
    //   226: astore_3
    //   227: new 78	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   234: astore 4
    //   236: aload 4
    //   238: ldc 81
    //   240: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 4
    //   246: aload_2
    //   247: invokevirtual 89	java/lang/Exception:toString	()Ljava/lang/String;
    //   250: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_3
    //   255: aload 4
    //   257: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 95	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: goto -53 -> 210
    //   266: aload_1
    //   267: athrow
    //   268: aload_0
    //   269: aconst_null
    //   270: putfield 68	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   273: aload_1
    //   274: athrow
    //   275: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	this	w
    //   16	6	1	localMediaExtractor	MediaExtractor
    //   50	1	1	localObject1	Object
    //   54	46	1	localException1	Exception
    //   101	1	1	localObject2	Object
    //   105	22	1	localException2	Exception
    //   152	1	1	localObject3	Object
    //   156	46	1	localException3	Exception
    //   218	56	1	localObject4	Object
    //   58	128	2	str	String
    //   222	25	2	localException4	Exception
    //   66	189	3	localObject5	Object
    //   234	22	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   37	44	50	finally
    //   55	91	50	finally
    //   37	44	54	java/lang/Exception
    //   30	37	101	finally
    //   106	142	101	finally
    //   30	37	105	java/lang/Exception
    //   142	149	152	finally
    //   157	193	152	finally
    //   142	149	156	java/lang/Exception
    //   203	210	218	finally
    //   223	263	218	finally
    //   203	210	222	java/lang/Exception
  }
  
  private void c()
  {
    b();
    this.a = null;
    this.l = 0L;
    this.o = false;
    ??? = this.c;
    if (??? != null)
    {
      ((SurfaceTexture)???).release();
      this.c = null;
    }
    synchronized (this.q)
    {
      if (this.p != null)
      {
        this.p.removeCallbacksAndMessages(null);
        this.p.getLooper().quit();
        this.p = null;
        this.q.notify();
      }
      ??? = this.g;
      if (??? == null) {}
    }
    try
    {
      ((AssetFileDescriptor)???).close();
      label96:
      this.g = null;
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (Exception localException)
    {
      break label96;
    }
  }
  
  void a()
  {
    try
    {
      for (;;)
      {
        synchronized (this.q)
        {
          if (this.p != null) {
            if (Looper.myLooper() == this.p.getLooper())
            {
              c();
            }
            else
            {
              w.1 local1 = new w.1(this);
              this.p.removeCallbacksAndMessages(null);
              this.p.post(local1);
              this.p.getLooper().quitSafely();
            }
          }
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.w
 * JD-Core Version:    0.7.0.1
 */