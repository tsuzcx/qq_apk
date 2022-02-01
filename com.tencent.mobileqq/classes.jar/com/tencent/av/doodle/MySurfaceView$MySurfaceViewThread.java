package com.tencent.av.doodle;

import android.view.SurfaceHolder;
import com.tencent.qphone.base.util.QLog;

class MySurfaceView$MySurfaceViewThread
  extends Thread
{
  private boolean a = false;
  private boolean b = true;
  private SurfaceHolder c;
  
  public MySurfaceView$MySurfaceViewThread(MySurfaceView paramMySurfaceView)
  {
    this.c = paramMySurfaceView.getHolder();
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WL_DEBUG MySurfaceViewThread.setRunning running = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("MySurfaceView", 2, localStringBuilder.toString());
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:this$0	Lcom/tencent/av/doodle/MySurfaceView;
    //   4: iconst_1
    //   5: invokevirtual 66	com/tencent/av/doodle/MySurfaceView:a	(Z)V
    //   8: aload_0
    //   9: getfield 20	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:a	Z
    //   12: ifeq +356 -> 368
    //   15: aconst_null
    //   16: astore 6
    //   18: aconst_null
    //   19: astore 5
    //   21: aload_0
    //   22: getfield 30	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:c	Landroid/view/SurfaceHolder;
    //   25: aconst_null
    //   26: invokeinterface 72 2 0
    //   31: astore 7
    //   33: aload 7
    //   35: astore 5
    //   37: aload 7
    //   39: astore 6
    //   41: aload_0
    //   42: getfield 30	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:c	Landroid/view/SurfaceHolder;
    //   45: astore 8
    //   47: aload 7
    //   49: astore 5
    //   51: aload 7
    //   53: astore 6
    //   55: aload 8
    //   57: monitorenter
    //   58: aload_0
    //   59: getfield 22	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:b	Z
    //   62: ifeq +33 -> 95
    //   65: invokestatic 78	android/os/SystemClock:elapsedRealtime	()J
    //   68: lstore_1
    //   69: aload_0
    //   70: getfield 15	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:this$0	Lcom/tencent/av/doodle/MySurfaceView;
    //   73: getfield 81	com/tencent/av/doodle/MySurfaceView:b	J
    //   76: lstore_3
    //   77: aload_0
    //   78: getfield 15	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:this$0	Lcom/tencent/av/doodle/MySurfaceView;
    //   81: lload_1
    //   82: putfield 81	com/tencent/av/doodle/MySurfaceView:b	J
    //   85: aload_0
    //   86: getfield 15	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:this$0	Lcom/tencent/av/doodle/MySurfaceView;
    //   89: lload_1
    //   90: lload_3
    //   91: lsub
    //   92: invokevirtual 84	com/tencent/av/doodle/MySurfaceView:a	(J)V
    //   95: aload 7
    //   97: ifnull +12 -> 109
    //   100: aload_0
    //   101: getfield 15	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:this$0	Lcom/tencent/av/doodle/MySurfaceView;
    //   104: aload 7
    //   106: invokevirtual 87	com/tencent/av/doodle/MySurfaceView:a	(Landroid/graphics/Canvas;)V
    //   109: aload 8
    //   111: monitorexit
    //   112: aload 7
    //   114: ifnull -106 -> 8
    //   117: aload_0
    //   118: getfield 30	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:c	Landroid/view/SurfaceHolder;
    //   121: aload 7
    //   123: invokeinterface 90 2 0
    //   128: goto -120 -> 8
    //   131: astore 5
    //   133: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq -128 -> 8
    //   139: new 41	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   146: astore 6
    //   148: aload 6
    //   150: ldc 92
    //   152: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 6
    //   158: aload 5
    //   160: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: ldc 53
    //   166: iconst_2
    //   167: aload 6
    //   169: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: goto -167 -> 8
    //   178: astore 9
    //   180: aload 8
    //   182: monitorexit
    //   183: aload 7
    //   185: astore 5
    //   187: aload 7
    //   189: astore 6
    //   191: aload 9
    //   193: athrow
    //   194: astore 6
    //   196: goto +106 -> 302
    //   199: astore 7
    //   201: aload 6
    //   203: astore 5
    //   205: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +55 -> 263
    //   211: aload 6
    //   213: astore 5
    //   215: new 41	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   222: astore 8
    //   224: aload 6
    //   226: astore 5
    //   228: aload 8
    //   230: ldc 92
    //   232: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload 6
    //   238: astore 5
    //   240: aload 8
    //   242: aload 7
    //   244: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 6
    //   250: astore 5
    //   252: ldc 53
    //   254: iconst_2
    //   255: aload 8
    //   257: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: aload 6
    //   265: ifnull -257 -> 8
    //   268: aload_0
    //   269: getfield 30	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:c	Landroid/view/SurfaceHolder;
    //   272: aload 6
    //   274: invokeinterface 90 2 0
    //   279: goto -271 -> 8
    //   282: astore 5
    //   284: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   287: ifeq -279 -> 8
    //   290: new 41	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   297: astore 6
    //   299: goto -151 -> 148
    //   302: aload 5
    //   304: ifnull +61 -> 365
    //   307: aload_0
    //   308: getfield 30	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:c	Landroid/view/SurfaceHolder;
    //   311: aload 5
    //   313: invokeinterface 90 2 0
    //   318: goto +47 -> 365
    //   321: astore 5
    //   323: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq +39 -> 365
    //   329: new 41	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   336: astore 7
    //   338: aload 7
    //   340: ldc 92
    //   342: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload 7
    //   348: aload 5
    //   350: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: ldc 53
    //   356: iconst_2
    //   357: aload 7
    //   359: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: aload 6
    //   367: athrow
    //   368: aload_0
    //   369: getfield 15	com/tencent/av/doodle/MySurfaceView$MySurfaceViewThread:this$0	Lcom/tencent/av/doodle/MySurfaceView;
    //   372: iconst_0
    //   373: invokevirtual 66	com/tencent/av/doodle/MySurfaceView:a	(Z)V
    //   376: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	this	MySurfaceViewThread
    //   68	22	1	l1	long
    //   76	15	3	l2	long
    //   19	31	5	localObject1	java.lang.Object
    //   131	28	5	localException1	java.lang.Exception
    //   185	66	5	localObject2	java.lang.Object
    //   282	30	5	localException2	java.lang.Exception
    //   321	28	5	localException3	java.lang.Exception
    //   16	174	6	localObject3	java.lang.Object
    //   194	79	6	localCanvas1	android.graphics.Canvas
    //   297	69	6	localStringBuilder1	StringBuilder
    //   31	157	7	localCanvas2	android.graphics.Canvas
    //   199	44	7	localException4	java.lang.Exception
    //   336	22	7	localStringBuilder2	StringBuilder
    //   45	211	8	localObject4	java.lang.Object
    //   178	14	9	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   117	128	131	java/lang/Exception
    //   58	95	178	finally
    //   100	109	178	finally
    //   109	112	178	finally
    //   180	183	178	finally
    //   21	33	194	finally
    //   41	47	194	finally
    //   55	58	194	finally
    //   191	194	194	finally
    //   205	211	194	finally
    //   215	224	194	finally
    //   228	236	194	finally
    //   240	248	194	finally
    //   252	263	194	finally
    //   21	33	199	java/lang/Exception
    //   41	47	199	java/lang/Exception
    //   55	58	199	java/lang/Exception
    //   191	194	199	java/lang/Exception
    //   268	279	282	java/lang/Exception
    //   307	318	321	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.MySurfaceView.MySurfaceViewThread
 * JD-Core Version:    0.7.0.1
 */