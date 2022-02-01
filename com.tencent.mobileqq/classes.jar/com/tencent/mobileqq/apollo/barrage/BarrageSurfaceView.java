package com.tencent.mobileqq.apollo.barrage;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.util.WeakReferenceHandler;
import java.util.List;

public class BarrageSurfaceView
  extends SurfaceView
  implements Handler.Callback, SurfaceHolder.Callback, BarrageUI
{
  private int jdField_a_of_type_Int;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private AbsBarrageCache jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache;
  private AbsDrawer<Canvas> jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private int b;
  
  public BarrageSurfaceView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public BarrageSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    super.setZOrderOnTop(true);
    this.jdField_a_of_type_AndroidViewSurfaceHolder = super.getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setFormat(-3);
  }
  
  private void b()
  {
    WeakReferenceHandler localWeakReferenceHandler = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (localWeakReferenceHandler == null) {
      return;
    }
    localWeakReferenceHandler.removeMessages(16);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(16);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public AbsBarrageCache a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache = new ApolloBarrageCache();
    }
    return this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache;
  }
  
  public void a(List<Barrage> paramList, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(boolean paramBoolean)
  {
    WeakReferenceHandler localWeakReferenceHandler = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (localWeakReferenceHandler == null) {
      return;
    }
    localWeakReferenceHandler.obtainMessage(15).sendToTarget();
  }
  
  public int b()
  {
    return this.b;
  }
  
  /* Error */
  public boolean handleMessage(Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 101	android/os/Message:what	I
    //   4: tableswitch	default:+32 -> 36, 13:+393->397, 14:+363->367, 15:+343->347, 16:+34->38
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 103	com/tencent/mobileqq/apollo/barrage/BarrageSurfaceView:jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer	Lcom/tencent/mobileqq/apollo/barrage/AbsDrawer;
    //   42: ifnull +447 -> 489
    //   45: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   48: lstore_2
    //   49: aconst_null
    //   50: astore_1
    //   51: aconst_null
    //   52: astore 7
    //   54: iconst_1
    //   55: istore 5
    //   57: iconst_1
    //   58: istore 6
    //   60: aload_0
    //   61: getfield 40	com/tencent/mobileqq/apollo/barrage/BarrageSurfaceView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   64: astore 9
    //   66: aload 9
    //   68: monitorenter
    //   69: iload 5
    //   71: istore 4
    //   73: aload_0
    //   74: getfield 40	com/tencent/mobileqq/apollo/barrage/BarrageSurfaceView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   77: invokeinterface 113 1 0
    //   82: astore 8
    //   84: iload 6
    //   86: istore 4
    //   88: aload 8
    //   90: ifnull +83 -> 173
    //   93: aload 8
    //   95: astore 7
    //   97: iload 5
    //   99: istore 4
    //   101: aload 8
    //   103: astore_1
    //   104: aload 8
    //   106: invokevirtual 118	android/graphics/Canvas:save	()I
    //   109: pop
    //   110: aload 8
    //   112: astore 7
    //   114: iload 5
    //   116: istore 4
    //   118: aload 8
    //   120: astore_1
    //   121: aload 8
    //   123: iconst_0
    //   124: getstatic 124	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   127: invokevirtual 128	android/graphics/Canvas:drawColor	(ILandroid/graphics/PorterDuff$Mode;)V
    //   130: aload 8
    //   132: astore 7
    //   134: iload 5
    //   136: istore 4
    //   138: aload 8
    //   140: astore_1
    //   141: aload_0
    //   142: getfield 103	com/tencent/mobileqq/apollo/barrage/BarrageSurfaceView:jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer	Lcom/tencent/mobileqq/apollo/barrage/AbsDrawer;
    //   145: aload 8
    //   147: fconst_1
    //   148: invokevirtual 133	com/tencent/mobileqq/apollo/barrage/AbsDrawer:a	(Ljava/lang/Object;F)Z
    //   151: istore 5
    //   153: aload 8
    //   155: astore 7
    //   157: iload 5
    //   159: istore 4
    //   161: aload 8
    //   163: astore_1
    //   164: aload 8
    //   166: invokevirtual 136	android/graphics/Canvas:restore	()V
    //   169: iload 5
    //   171: istore 4
    //   173: iload 4
    //   175: istore 5
    //   177: aload 8
    //   179: ifnull +73 -> 252
    //   182: aload_0
    //   183: getfield 40	com/tencent/mobileqq/apollo/barrage/BarrageSurfaceView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   186: astore 7
    //   188: aload 8
    //   190: astore_1
    //   191: aload 7
    //   193: aload_1
    //   194: invokeinterface 140 2 0
    //   199: iload 4
    //   201: istore 5
    //   203: goto +49 -> 252
    //   206: astore_1
    //   207: goto +116 -> 323
    //   210: astore 8
    //   212: aload_1
    //   213: astore 7
    //   215: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq +17 -> 235
    //   221: aload_1
    //   222: astore 7
    //   224: ldc 148
    //   226: iconst_2
    //   227: aload 8
    //   229: invokevirtual 152	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   232: invokestatic 156	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: iload 4
    //   237: istore 5
    //   239: aload_1
    //   240: ifnull +12 -> 252
    //   243: aload_0
    //   244: getfield 40	com/tencent/mobileqq/apollo/barrage/BarrageSurfaceView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   247: astore 7
    //   249: goto -58 -> 191
    //   252: iload 5
    //   254: ifeq +23 -> 277
    //   257: aload_0
    //   258: getfield 52	com/tencent/mobileqq/apollo/barrage/BarrageSurfaceView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   261: ifnull +16 -> 277
    //   264: aload_0
    //   265: getfield 52	com/tencent/mobileqq/apollo/barrage/BarrageSurfaceView:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   268: bipush 16
    //   270: ldc2_w 157
    //   273: invokevirtual 162	com/tencent/util/WeakReferenceHandler:sendEmptyMessageDelayed	(IJ)Z
    //   276: pop
    //   277: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +38 -> 318
    //   283: new 164	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   290: astore_1
    //   291: aload_1
    //   292: ldc 167
    //   294: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload_1
    //   299: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   302: lload_2
    //   303: lsub
    //   304: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: ldc 148
    //   310: iconst_2
    //   311: aload_1
    //   312: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: aload 9
    //   320: monitorexit
    //   321: iconst_0
    //   322: ireturn
    //   323: aload 7
    //   325: ifnull +14 -> 339
    //   328: aload_0
    //   329: getfield 40	com/tencent/mobileqq/apollo/barrage/BarrageSurfaceView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   332: aload 7
    //   334: invokeinterface 140 2 0
    //   339: aload_1
    //   340: athrow
    //   341: astore_1
    //   342: aload 9
    //   344: monitorexit
    //   345: aload_1
    //   346: athrow
    //   347: aload_0
    //   348: getfield 103	com/tencent/mobileqq/apollo/barrage/BarrageSurfaceView:jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer	Lcom/tencent/mobileqq/apollo/barrage/AbsDrawer;
    //   351: astore_1
    //   352: aload_1
    //   353: ifnull +136 -> 489
    //   356: aload_1
    //   357: iconst_0
    //   358: invokevirtual 182	com/tencent/mobileqq/apollo/barrage/AbsDrawer:a	(Z)V
    //   361: aload_0
    //   362: invokespecial 184	com/tencent/mobileqq/apollo/barrage/BarrageSurfaceView:b	()V
    //   365: iconst_0
    //   366: ireturn
    //   367: aload_0
    //   368: getfield 103	com/tencent/mobileqq/apollo/barrage/BarrageSurfaceView:jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer	Lcom/tencent/mobileqq/apollo/barrage/AbsDrawer;
    //   371: ifnull +118 -> 489
    //   374: aload_1
    //   375: getfield 188	android/os/Message:obj	Ljava/lang/Object;
    //   378: checkcast 190	com/tencent/mobileqq/apollo/barrage/Barrage
    //   381: astore_1
    //   382: aload_0
    //   383: getfield 103	com/tencent/mobileqq/apollo/barrage/BarrageSurfaceView:jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer	Lcom/tencent/mobileqq/apollo/barrage/AbsDrawer;
    //   386: aload_1
    //   387: invokevirtual 193	com/tencent/mobileqq/apollo/barrage/AbsDrawer:a	(Lcom/tencent/mobileqq/apollo/barrage/Barrage;)Z
    //   390: pop
    //   391: aload_0
    //   392: invokespecial 184	com/tencent/mobileqq/apollo/barrage/BarrageSurfaceView:b	()V
    //   395: iconst_0
    //   396: ireturn
    //   397: aload_0
    //   398: getfield 103	com/tencent/mobileqq/apollo/barrage/BarrageSurfaceView:jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer	Lcom/tencent/mobileqq/apollo/barrage/AbsDrawer;
    //   401: ifnull +88 -> 489
    //   404: aload_1
    //   405: getfield 188	android/os/Message:obj	Ljava/lang/Object;
    //   408: checkcast 195	java/util/List
    //   411: astore 7
    //   413: aload_1
    //   414: getfield 198	android/os/Message:arg1	I
    //   417: ifle +11 -> 428
    //   420: aload_0
    //   421: getfield 103	com/tencent/mobileqq/apollo/barrage/BarrageSurfaceView:jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer	Lcom/tencent/mobileqq/apollo/barrage/AbsDrawer;
    //   424: iconst_0
    //   425: invokevirtual 182	com/tencent/mobileqq/apollo/barrage/AbsDrawer:a	(Z)V
    //   428: aload 7
    //   430: ifnull +45 -> 475
    //   433: aload 7
    //   435: invokeinterface 201 1 0
    //   440: ifne +35 -> 475
    //   443: aload 7
    //   445: invokeinterface 205 1 0
    //   450: astore_1
    //   451: aload_1
    //   452: invokeinterface 210 1 0
    //   457: ifeq +18 -> 475
    //   460: aload_1
    //   461: invokeinterface 214 1 0
    //   466: checkcast 190	com/tencent/mobileqq/apollo/barrage/Barrage
    //   469: invokevirtual 215	com/tencent/mobileqq/apollo/barrage/Barrage:a	()V
    //   472: goto -21 -> 451
    //   475: aload_0
    //   476: getfield 103	com/tencent/mobileqq/apollo/barrage/BarrageSurfaceView:jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer	Lcom/tencent/mobileqq/apollo/barrage/AbsDrawer;
    //   479: aload 7
    //   481: invokevirtual 218	com/tencent/mobileqq/apollo/barrage/AbsDrawer:a	(Ljava/util/List;)Z
    //   484: pop
    //   485: aload_0
    //   486: invokespecial 184	com/tencent/mobileqq/apollo/barrage/BarrageSurfaceView:b	()V
    //   489: iconst_0
    //   490: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	491	0	this	BarrageSurfaceView
    //   0	491	1	paramMessage	Message
    //   48	255	2	l	long
    //   71	165	4	bool1	boolean
    //   55	198	5	bool2	boolean
    //   58	27	6	bool3	boolean
    //   52	428	7	localObject	java.lang.Object
    //   82	107	8	localCanvas	Canvas
    //   210	18	8	localException	java.lang.Exception
    //   64	279	9	localSurfaceHolder	SurfaceHolder
    // Exception table:
    //   from	to	target	type
    //   73	84	206	finally
    //   104	110	206	finally
    //   121	130	206	finally
    //   141	153	206	finally
    //   164	169	206	finally
    //   215	221	206	finally
    //   224	235	206	finally
    //   73	84	210	java/lang/Exception
    //   104	110	210	java/lang/Exception
    //   121	130	210	java/lang/Exception
    //   141	153	210	java/lang/Exception
    //   164	169	210	java/lang/Exception
    //   182	188	341	finally
    //   191	199	341	finally
    //   243	249	341	finally
    //   257	277	341	finally
    //   277	318	341	finally
    //   318	321	341	finally
    //   328	339	341	finally
    //   339	341	341	finally
    //   342	345	341	finally
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt3;
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsBarrageCache = new ApolloBarrageCache();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageAbsDrawer = new CanvasDrawer();
    }
    paramSurfaceHolder = this.jdField_a_of_type_AndroidOsHandlerThread;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.quit();
    }
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Barrage-Surface-Thread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.barrage.BarrageSurfaceView
 * JD-Core Version:    0.7.0.1
 */