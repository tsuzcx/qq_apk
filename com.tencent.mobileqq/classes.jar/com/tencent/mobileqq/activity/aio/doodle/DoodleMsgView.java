package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.TimerTask;
import mqq.util.WeakReference;

public class DoodleMsgView
  extends BaseDoodleMsgView
{
  private DoodleDrawer a;
  private TimerTask b;
  private Timer c;
  private long d = -1L;
  private Bitmap e;
  private Canvas f;
  private DoodleDrawer.DoodleDrawerListener g;
  private Paint h;
  private Paint i;
  private Handler j = new Handler();
  private WeakReference<DoodleMsgViewListener> k = null;
  private int l;
  private int m;
  
  public DoodleMsgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  /* Error */
  private boolean a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 61	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgView:f	Landroid/graphics/Canvas;
    //   6: ifnull +14 -> 20
    //   9: aload_0
    //   10: getfield 63	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgView:e	Landroid/graphics/Bitmap;
    //   13: ifnull +7 -> 20
    //   16: aload_0
    //   17: monitorexit
    //   18: iconst_1
    //   19: ireturn
    //   20: iconst_0
    //   21: istore 4
    //   23: aload_0
    //   24: getfield 63	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgView:e	Landroid/graphics/Bitmap;
    //   27: ifnull +18 -> 45
    //   30: invokestatic 68	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	()Lcom/tencent/mobileqq/activity/aio/doodle/DoodleResHelper;
    //   33: aload_0
    //   34: getfield 63	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgView:e	Landroid/graphics/Bitmap;
    //   37: invokevirtual 71	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	(Landroid/graphics/Bitmap;)V
    //   40: aload_0
    //   41: aconst_null
    //   42: putfield 63	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgView:e	Landroid/graphics/Bitmap;
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 61	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgView:f	Landroid/graphics/Canvas;
    //   50: aload_0
    //   51: invokestatic 68	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	()Lcom/tencent/mobileqq/activity/aio/doodle/DoodleResHelper;
    //   54: iload_1
    //   55: iload_2
    //   56: invokevirtual 74	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:i	(II)Landroid/graphics/Bitmap;
    //   59: putfield 63	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgView:e	Landroid/graphics/Bitmap;
    //   62: iload 4
    //   64: istore_3
    //   65: aload_0
    //   66: getfield 63	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgView:e	Landroid/graphics/Bitmap;
    //   69: ifnull +148 -> 217
    //   72: aload_0
    //   73: new 76	android/graphics/Canvas
    //   76: dup
    //   77: aload_0
    //   78: getfield 63	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgView:e	Landroid/graphics/Bitmap;
    //   81: invokespecial 78	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   84: putfield 61	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgView:f	Landroid/graphics/Canvas;
    //   87: aload_0
    //   88: getfield 61	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgView:f	Landroid/graphics/Canvas;
    //   91: new 80	android/graphics/PaintFlagsDrawFilter
    //   94: dup
    //   95: iconst_0
    //   96: iconst_3
    //   97: invokespecial 83	android/graphics/PaintFlagsDrawFilter:<init>	(II)V
    //   100: invokevirtual 87	android/graphics/Canvas:setDrawFilter	(Landroid/graphics/DrawFilter;)V
    //   103: iconst_1
    //   104: istore_3
    //   105: goto +112 -> 217
    //   108: ldc 89
    //   110: iconst_2
    //   111: ldc 91
    //   113: invokestatic 96	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload_0
    //   117: getfield 63	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgView:e	Landroid/graphics/Bitmap;
    //   120: ifnull +18 -> 138
    //   123: invokestatic 68	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	()Lcom/tencent/mobileqq/activity/aio/doodle/DoodleResHelper;
    //   126: aload_0
    //   127: getfield 63	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgView:e	Landroid/graphics/Bitmap;
    //   130: invokevirtual 71	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	(Landroid/graphics/Bitmap;)V
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield 63	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgView:e	Landroid/graphics/Bitmap;
    //   138: aload_0
    //   139: aconst_null
    //   140: putfield 61	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgView:f	Landroid/graphics/Canvas;
    //   143: iload 4
    //   145: istore_3
    //   146: goto +71 -> 217
    //   149: astore 5
    //   151: new 98	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   158: astore 6
    //   160: aload 6
    //   162: ldc 101
    //   164: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 6
    //   170: aload 5
    //   172: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: ldc 89
    //   178: iconst_2
    //   179: aload 6
    //   181: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 96	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload_0
    //   188: getfield 63	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgView:e	Landroid/graphics/Bitmap;
    //   191: ifnull +18 -> 209
    //   194: invokestatic 68	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	()Lcom/tencent/mobileqq/activity/aio/doodle/DoodleResHelper;
    //   197: aload_0
    //   198: getfield 63	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgView:e	Landroid/graphics/Bitmap;
    //   201: invokevirtual 71	com/tencent/mobileqq/activity/aio/doodle/DoodleResHelper:a	(Landroid/graphics/Bitmap;)V
    //   204: aload_0
    //   205: aconst_null
    //   206: putfield 63	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgView:e	Landroid/graphics/Bitmap;
    //   209: aload_0
    //   210: aconst_null
    //   211: putfield 61	com/tencent/mobileqq/activity/aio/doodle/DoodleMsgView:f	Landroid/graphics/Canvas;
    //   214: iload 4
    //   216: istore_3
    //   217: aload_0
    //   218: monitorexit
    //   219: iload_3
    //   220: ireturn
    //   221: astore 5
    //   223: aload_0
    //   224: monitorexit
    //   225: aload 5
    //   227: athrow
    //   228: astore 5
    //   230: goto -122 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	DoodleMsgView
    //   0	233	1	paramInt1	int
    //   0	233	2	paramInt2	int
    //   64	156	3	bool1	boolean
    //   21	194	4	bool2	boolean
    //   149	22	5	localException	java.lang.Exception
    //   221	5	5	localObject	Object
    //   228	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   158	22	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   23	45	149	java/lang/Exception
    //   45	62	149	java/lang/Exception
    //   65	103	149	java/lang/Exception
    //   2	18	221	finally
    //   23	45	221	finally
    //   45	62	221	finally
    //   65	103	221	finally
    //   108	138	221	finally
    //   138	143	221	finally
    //   151	209	221	finally
    //   209	214	221	finally
    //   217	219	221	finally
    //   223	225	221	finally
    //   23	45	228	java/lang/OutOfMemoryError
    //   45	62	228	java/lang/OutOfMemoryError
    //   65	103	228	java/lang/OutOfMemoryError
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (this.a != null) {
      return;
    }
    this.a = new DoodleDrawer();
    this.g = new DoodleMsgView.1(this);
    this.a.a(this.g, 1, paramInt1, paramInt2);
  }
  
  private void b(long paramLong)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    long l1 = ((DoodleDrawer)localObject).f();
    float f1;
    float f2;
    if (l1 <= 3000L)
    {
      f1 = (float)l1 * 1.0F;
      f2 = 1.2F;
    }
    for (;;)
    {
      l1 = (int)(f1 / f2);
      break;
      if (l1 <= 20000L)
      {
        f1 = (float)l1 * 1.0F;
        f2 = 1.5F;
      }
      else
      {
        f1 = (float)l1 * 1.0F;
        f2 = 1.8F;
      }
    }
    l1 /= 25L;
    long l2 = this.a.f();
    this.b = new DoodleMsgView.2(this, l2, l2 / (l1 + 1L));
    this.c = new Timer();
    this.d = 0L;
    localObject = this.c;
    TimerTask localTimerTask = this.b;
    if (paramLong <= 0L) {
      paramLong = 0L;
    }
    ((Timer)localObject).schedule(localTimerTask, paramLong, 25L);
    localObject = this.k;
    if (localObject != null)
    {
      localObject = (DoodleMsgViewListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((DoodleMsgViewListener)localObject).h();
      }
    }
  }
  
  private void e()
  {
    try
    {
      if (this.h == null)
      {
        this.h = new Paint();
        this.h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      }
      if ((this.f != null) && (this.h != null)) {
        this.f.drawPaint(this.h);
      }
      return;
    }
    finally {}
  }
  
  private void f()
  {
    try
    {
      if (this.b != null)
      {
        this.b.cancel();
        this.b = null;
      }
      if (this.c != null)
      {
        this.c.cancel();
        this.c = null;
      }
      return;
    }
    finally {}
  }
  
  private boolean g()
  {
    return this.b != null;
  }
  
  protected void a()
  {
    if (this.a != null)
    {
      d();
      this.a.a();
      this.a = null;
    }
    this.g = null;
    if (this.e != null)
    {
      DoodleResHelper.a().a(this.e);
      this.e = null;
    }
    QLog.d("DoodleMsgView", 2, "DoodleMsgView unInit");
  }
  
  public void a(long paramLong)
  {
    QLog.d("DoodleMsgView", 2, "play:");
    Object localObject = this.a;
    if ((localObject != null) && (((DoodleDrawer)localObject).e() != 0))
    {
      if (g()) {
        d();
      }
      b(paramLong);
      return;
    }
    localObject = this.k;
    if (localObject != null)
    {
      localObject = (DoodleMsgViewListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((DoodleMsgViewListener)localObject).i();
      }
    }
  }
  
  public void a(DoodleMsgViewListener paramDoodleMsgViewListener, int paramInt1, int paramInt2)
  {
    QLog.d("DoodleMsgView", 2, "DoodleMsgView init begin");
    this.k = new WeakReference(paramDoodleMsgViewListener);
    this.f = null;
    this.l = paramInt1;
    this.m = paramInt2;
    b(paramInt1, paramInt2);
    QLog.d("DoodleMsgView", 2, "DoodleMsgView init end");
  }
  
  protected void a(Runnable paramRunnable)
  {
    this.j.post(paramRunnable);
  }
  
  public void a(boolean paramBoolean)
  {
    DoodleDrawer localDoodleDrawer = this.a;
    if (localDoodleDrawer != null) {
      localDoodleDrawer.a(paramBoolean);
    }
  }
  
  public void b()
  {
    DoodleDrawer localDoodleDrawer = this.a;
    if (localDoodleDrawer != null) {
      localDoodleDrawer.c();
    }
  }
  
  public void c()
  {
    e();
    invalidate();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleMsgView", 2, "stop");
    }
    f();
    this.d = -9223372036854775808L;
    if ((this.a != null) && (isShown()))
    {
      this.a.a(2147483647L, false);
      if (QLog.isColorLevel()) {
        QLog.d("DoodleMsgView", 2, "preparesegments");
      }
    }
    QLog.d("DoodleMsgView", 2, "stop end");
  }
  
  public int getDataState()
  {
    DoodleDrawer localDoodleDrawer = this.a;
    if (localDoodleDrawer != null) {
      return localDoodleDrawer.d();
    }
    return 4;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    DoodleDrawer localDoodleDrawer = this.a;
    if ((localDoodleDrawer != null) && (localDoodleDrawer.d() != 0))
    {
      QLog.d("DoodleMsgView", 2, "onDraw not ready");
      return;
    }
    try
    {
      if (this.e != null) {
        paramCanvas.drawBitmap(this.e, new Rect(0, 0, this.e.getWidth(), this.e.getHeight()), new Rect(0, 0, this.l, this.m), null);
      }
      return;
    }
    finally {}
  }
  
  public void setContent(String paramString, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setContent:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" prepare:");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("DoodleMsgView", 2, ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject == null) {
      return;
    }
    if (((DoodleDrawer)localObject).a(paramString, paramBoolean, getContext()))
    {
      QLog.d("DoodleMsgView", 2, "drawer setdata return true:");
      f();
      return;
    }
    paramString = new StringBuilder();
    paramString.append("drawer setdata same data:");
    paramString.append(getDataState());
    QLog.d("DoodleMsgView", 2, paramString.toString());
    paramString = this.k;
    if (paramString != null)
    {
      paramString = (DoodleMsgViewListener)paramString.get();
      if (paramString != null) {
        paramString.a(getDataState());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView
 * JD-Core Version:    0.7.0.1
 */