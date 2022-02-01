package com.tencent.mobileqq.apollo;

import amme;
import amnw;
import amop;
import amoq;
import ampv;
import ampx;
import ampy;
import amqw;
import amqy;
import amrm;
import anbt;
import anck;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import anhn;
import anmh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ApolloTextureView
  extends GLTextureView
  implements ampv, ampx
{
  public static final String TAG = "ApolloTextureView";
  public static long sReAttachTime;
  private amop events = new amop();
  private String mApolloId;
  protected ApolloRenderDriver mApolloWorker;
  private int mAttachCount;
  private WeakReference<amqy> mBarrageViewRef;
  private ampy mCallback;
  private float mDensity = super.getContext().getResources().getDisplayMetrics().density;
  private boolean mDetectTouchMoved;
  private boolean mDisableParentIntercept;
  private boolean mDisableTouchEvent;
  private boolean mDispatchEvent2native;
  private final byte[] mEngineLock = new byte[0];
  private boolean mHasPerformedLongPress;
  private int mInitHeight;
  public AtomicBoolean mIsDestroy;
  public boolean mIsDrawerView;
  boolean mIsReAttach;
  private long mLastClickT;
  private MotionEvent mLastTouchEvent;
  private long mLongPressTimeout;
  public float mManHeight;
  private int mNode;
  private int mOffscreenHeight;
  private int mOffscreenWidth;
  private float mPX;
  private float mPY;
  private ApolloTextureView.CheckForLongPress mPendingCheckForLongPress = new ApolloTextureView.CheckForLongPress(this);
  public ApolloRender mRender;
  protected amnw mRenderImpl;
  private boolean mSendEventToNatived;
  private float mTouchDownX;
  private float mTouchDownY;
  private RectF mTouchableRect;
  
  @TargetApi(14)
  public ApolloTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setEGLContextClientVersion(amme.a());
    int i = ApolloUtil.a();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTextureView", 2, "ApolloTextureView MSAA_level:" + i);
    }
    if (i != 0) {
      if (1 == i) {
        super.setEGLConfigChooser(new amoq(4));
      }
    }
    for (;;)
    {
      super.setOpaque(false);
      this.mLongPressTimeout = ViewConfiguration.getLongPressTimeout();
      this.mIsDestroy = new AtomicBoolean(false);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloTextureView", 2, "[ApolloSurfaceView4Drawer] constructor");
      }
      paramAttributeSet = BaseApplicationImpl.getApplication();
      if ((paramAttributeSet != null) && ((paramContext instanceof Activity)))
      {
        paramAttributeSet = paramAttributeSet.getRuntime();
        if ((paramAttributeSet instanceof QQAppInterface))
        {
          paramAttributeSet = ApolloCmdChannel.getChannel((QQAppInterface)paramAttributeSet);
          if (paramAttributeSet != null) {
            paramAttributeSet.setActivityContext((Activity)paramContext);
          }
        }
      }
      return;
      if (2 == i)
      {
        super.setEGLConfigChooser(new amoq(2));
      }
      else
      {
        super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        continue;
        super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
      }
    }
  }
  
  private native void nativeDestroyTextureView();
  
  private void sendDownTouchNative(MotionEvent paramMotionEvent)
  {
    int j = 0;
    if (this.events.jdField_a_of_type_Int >= 4) {
      return;
    }
    if ((paramMotionEvent.getAction() & 0xFF) == 5) {}
    for (int i = paramMotionEvent.getActionIndex();; i = 0)
    {
      this.events.jdField_a_of_type_ArrayOfFloat[this.events.jdField_a_of_type_Int] = paramMotionEvent.getX(i);
      this.events.jdField_b_of_type_ArrayOfFloat[this.events.jdField_a_of_type_Int] = (getMeasuredHeight() - paramMotionEvent.getY(i));
      this.events.jdField_a_of_type_ArrayOfInt[this.events.jdField_a_of_type_Int] = 2;
      this.events.jdField_b_of_type_ArrayOfInt[this.events.jdField_a_of_type_Int] = paramMotionEvent.getPointerId(i);
      Object localObject = this.events;
      ((amop)localObject).jdField_a_of_type_Int += 1;
      if (this.events.jdField_a_of_type_Int <= 0) {
        break;
      }
      localObject = new float[this.events.jdField_a_of_type_Int];
      float[] arrayOfFloat = new float[this.events.jdField_a_of_type_Int];
      int[] arrayOfInt1 = new int[this.events.jdField_a_of_type_Int];
      int[] arrayOfInt2 = new int[this.events.jdField_a_of_type_Int];
      i = j;
      while (i < this.events.jdField_a_of_type_Int)
      {
        localObject[i] = this.events.jdField_a_of_type_ArrayOfFloat[i];
        arrayOfFloat[i] = this.events.jdField_b_of_type_ArrayOfFloat[i];
        arrayOfInt1[i] = this.events.jdField_a_of_type_ArrayOfInt[i];
        arrayOfInt2[i] = this.events.jdField_b_of_type_ArrayOfInt[i];
        i += 1;
      }
      queueEvent(new ApolloTextureView.4(this, (float[])localObject, arrayOfFloat, arrayOfInt1, arrayOfInt2));
      paramMotionEvent.recycle();
      return;
    }
  }
  
  private void sendMoveTouchToNative(MotionEvent paramMotionEvent)
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      if ((i >= this.events.jdField_a_of_type_Int) || (i > paramMotionEvent.getPointerCount() - 1) || (i >= 4)) {}
      int k;
      do
      {
        if (this.events.jdField_a_of_type_Int > 0) {
          break;
        }
        return;
        k = paramMotionEvent.findPointerIndex(this.events.jdField_b_of_type_ArrayOfInt[i]);
      } while ((k > paramMotionEvent.getPointerCount() - 1) || (k < 0));
      if (QLog.isColorLevel()) {
        QLog.d("ApolloTextureView", 2, "move event index =" + k + ",event.count=" + paramMotionEvent.getPointerCount());
      }
      if ((paramMotionEvent.getX(k) != this.events.jdField_a_of_type_ArrayOfFloat[i]) || (paramMotionEvent.getY(k) != this.events.jdField_b_of_type_ArrayOfFloat[i]))
      {
        this.events.jdField_a_of_type_ArrayOfFloat[i] = paramMotionEvent.getX(k);
        this.events.jdField_b_of_type_ArrayOfFloat[i] = (getMeasuredHeight() - paramMotionEvent.getY(k));
        this.events.jdField_a_of_type_ArrayOfInt[i] = 3;
      }
      i += 1;
    }
    float[] arrayOfFloat1 = new float[this.events.jdField_a_of_type_Int];
    float[] arrayOfFloat2 = new float[this.events.jdField_a_of_type_Int];
    int[] arrayOfInt1 = new int[this.events.jdField_a_of_type_Int];
    int[] arrayOfInt2 = new int[this.events.jdField_a_of_type_Int];
    i = j;
    while (i < this.events.jdField_a_of_type_Int)
    {
      arrayOfFloat1[i] = this.events.jdField_a_of_type_ArrayOfFloat[i];
      arrayOfFloat2[i] = this.events.jdField_b_of_type_ArrayOfFloat[i];
      arrayOfInt1[i] = this.events.jdField_a_of_type_ArrayOfInt[i];
      arrayOfInt2[i] = this.events.jdField_b_of_type_ArrayOfInt[i];
      i += 1;
    }
    queueEvent(new ApolloTextureView.2(this, arrayOfFloat1, arrayOfFloat2, arrayOfInt1, arrayOfInt2));
    paramMotionEvent.recycle();
  }
  
  private void sendUpTouchToNative(MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        if ((paramMotionEvent.getAction() & 0xFF) != 6) {
          break label506;
        }
        i = paramMotionEvent.getActionIndex();
        if ((paramMotionEvent.getAction() & 0xFF) != 1) {
          break label503;
        }
        i = -1;
      }
      catch (Throwable localThrowable)
      {
        float[] arrayOfFloat1;
        float[] arrayOfFloat2;
        int[] arrayOfInt1;
        int[] arrayOfInt2;
        paramMotionEvent.recycle();
        QLog.e("ApolloTextureView", 1, "send touch event err e=" + localThrowable.toString());
        return;
      }
      if (j < this.events.jdField_a_of_type_Int)
      {
        if (i == -1)
        {
          this.events.jdField_a_of_type_ArrayOfInt[j] = 1;
        }
        else if (paramMotionEvent.getPointerId(i) == this.events.jdField_b_of_type_ArrayOfInt[j])
        {
          this.events.jdField_a_of_type_ArrayOfFloat[j] = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.events.jdField_b_of_type_ArrayOfInt[j]));
          this.events.jdField_b_of_type_ArrayOfFloat[j] = (getMeasuredHeight() - paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.events.jdField_b_of_type_ArrayOfInt[j])));
          this.events.jdField_a_of_type_ArrayOfInt[j] = 1;
        }
      }
      else
      {
        if (this.events.jdField_a_of_type_Int <= 0) {
          return;
        }
        arrayOfFloat1 = new float[this.events.jdField_a_of_type_Int];
        arrayOfFloat2 = new float[this.events.jdField_a_of_type_Int];
        arrayOfInt1 = new int[this.events.jdField_a_of_type_Int];
        arrayOfInt2 = new int[this.events.jdField_a_of_type_Int];
        j = 0;
        if (j < this.events.jdField_a_of_type_Int)
        {
          arrayOfFloat1[j] = this.events.jdField_a_of_type_ArrayOfFloat[j];
          arrayOfFloat2[j] = this.events.jdField_b_of_type_ArrayOfFloat[j];
          arrayOfInt1[j] = this.events.jdField_a_of_type_ArrayOfInt[j];
          arrayOfInt2[j] = this.events.jdField_b_of_type_ArrayOfInt[j];
          j += 1;
          continue;
        }
        queueEvent(new ApolloTextureView.3(this, arrayOfFloat1, arrayOfFloat2, arrayOfInt1, arrayOfInt2));
        if (i == -1)
        {
          this.events.jdField_a_of_type_Int = 0;
          return;
        }
        i = 0;
        for (;;)
        {
          if (i < this.events.jdField_a_of_type_Int)
          {
            if (this.events.jdField_a_of_type_ArrayOfInt[i] == 1)
            {
              while (i < this.events.jdField_a_of_type_Int - 1)
              {
                this.events.jdField_a_of_type_ArrayOfFloat[i] = this.events.jdField_a_of_type_ArrayOfFloat[(i + 1)];
                this.events.jdField_b_of_type_ArrayOfFloat[i] = this.events.jdField_b_of_type_ArrayOfFloat[(i + 1)];
                this.events.jdField_a_of_type_ArrayOfInt[i] = this.events.jdField_a_of_type_ArrayOfInt[(i + 1)];
                this.events.jdField_b_of_type_ArrayOfInt[i] = this.events.jdField_b_of_type_ArrayOfInt[(i + 1)];
                i += 1;
              }
              amop localamop = this.events;
              localamop.jdField_a_of_type_Int -= 1;
            }
          }
          else
          {
            paramMotionEvent.recycle();
            return;
          }
          i += 1;
        }
        label503:
        break label511;
        label506:
        i = 0;
        continue;
        label511:
        j = 0;
        continue;
      }
      j += 1;
    }
  }
  
  private void touchDownToNativeDirect(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    try
    {
      if ((this.mApolloWorker != null) && (this.mApolloWorker.a != null)) {
        this.mApolloWorker.a.a("mainTicker.paused = false;");
      }
      ApolloSurfaceView.nativeTouchInput(getRender().getSavaWrapper().a, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfInt1, paramArrayOfInt2);
      return;
    }
    catch (Throwable paramArrayOfFloat1)
    {
      QLog.e("ApolloTextureView", 1, "send touch event err e=" + paramArrayOfFloat1.toString());
    }
  }
  
  public void bulkApolloBarrages(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((this.mBarrageViewRef != null) && (!TextUtils.isEmpty(paramString2)))
    {
      amqy localamqy = (amqy)this.mBarrageViewRef.get();
      if (localamqy != null) {
        amqw.a(localamqy, BaseApplicationImpl.getContext(), paramString1, paramString2, paramBoolean);
      }
    }
  }
  
  public void disableTouchEvent(boolean paramBoolean)
  {
    this.mDisableTouchEvent = paramBoolean;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    QLog.d("sava", 2, "texture view dispatchDraw");
  }
  
  public void exeJsOnEngine(String paramString)
  {
    if (this.mApolloWorker != null) {
      this.mApolloWorker.c(paramString);
    }
  }
  
  public int getInitHeight()
  {
    if (isOffscreen()) {
      return this.mOffscreenHeight;
    }
    return this.mInitHeight;
  }
  
  public long getLuaState()
  {
    if ((this.mRender != null) && (this.mRender.getSavaWrapper() != null)) {
      return this.mRender.getSavaWrapper().a();
    }
    return -1L;
  }
  
  public float getManRectMaxHeight()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTextureView", 2, "[getManRectMaxHeight]");
    }
    if (this.mRender == null) {
      return 0.0F;
    }
    Iterator localIterator = this.mRender.mBoundingList.iterator();
    for (float f = 0.0F; localIterator.hasNext(); f = Math.max(f, ((amrm)localIterator.next()).d)) {}
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTextureView", 2, new Object[] { "[getManRectMaxHeight] height:", Float.valueOf(f) });
    }
    return f;
  }
  
  public ApolloRender getRender()
  {
    return this.mRender;
  }
  
  public int getRenderHeight()
  {
    if (isOffscreen()) {
      return this.mOffscreenHeight;
    }
    return super.getHeight();
  }
  
  public amnw getRenderImpl()
  {
    return this.mRenderImpl;
  }
  
  public long getRenderThreadId()
  {
    if (this.mGLThread != null) {
      return this.mGLThread.getId();
    }
    return -1L;
  }
  
  public String getRenderThreadName()
  {
    return "Apollo_GL";
  }
  
  public int getRenderWidth()
  {
    if (isOffscreen()) {
      return this.mOffscreenWidth;
    }
    return super.getWidth();
  }
  
  public long getRuntimeState()
  {
    if ((this.mRender != null) && (this.mRender.getSavaWrapper() != null)) {
      return this.mRender.getSavaWrapper().a();
    }
    return -1L;
  }
  
  public ApolloRenderDriver getWorker()
  {
    return this.mApolloWorker;
  }
  
  public void init(ampy paramampy)
  {
    try
    {
      init(paramampy, 0, null);
      return;
    }
    finally
    {
      paramampy = finally;
      throw paramampy;
    }
  }
  
  public void init(ampy paramampy, int paramInt)
  {
    try
    {
      init(paramampy, paramInt, null);
      return;
    }
    finally
    {
      paramampy = finally;
      throw paramampy;
    }
  }
  
  public void init(ampy paramampy, int paramInt, ApolloRender paramApolloRender)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloTextureView", 2, "[init], callback:" + paramampy + ",engineType:" + paramInt + ", sLoadEngineLibDone: " + ApolloEngine.a());
      }
      init(paramampy, paramInt, paramApolloRender, false);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void init(ampy paramampy, int paramInt, ApolloRender paramApolloRender, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +62 -> 67
    //   8: ldc 12
    //   10: iconst_2
    //   11: new 129	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 482
    //   21: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: ldc_w 487
    //   31: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_2
    //   35: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: ldc_w 489
    //   41: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokestatic 491	com/tencent/mobileqq/apollo/ApolloEngine:a	()Z
    //   47: invokevirtual 494	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: ldc_w 499
    //   53: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload 4
    //   58: invokevirtual 494	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   61: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: aload_0
    //   68: aload_1
    //   69: putfield 234	com/tencent/mobileqq/apollo/ApolloTextureView:mCallback	Lampy;
    //   72: aload_3
    //   73: ifnull +148 -> 221
    //   76: aload_0
    //   77: aload_3
    //   78: putfield 395	com/tencent/mobileqq/apollo/ApolloTextureView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   81: ldc 12
    //   83: iconst_1
    //   84: ldc_w 501
    //   87: invokestatic 504	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: aload_0
    //   91: new 506	amor
    //   94: dup
    //   95: aload_0
    //   96: aconst_null
    //   97: invokespecial 509	amor:<init>	(Lcom/tencent/mobileqq/apollo/ApolloTextureView;Lcom/tencent/mobileqq/apollo/ApolloTextureView$1;)V
    //   100: invokespecial 513	com/tencent/mobileqq/apollo/GLTextureView:setEGLContextFactory	(Lampo;)V
    //   103: aload_0
    //   104: iload 4
    //   106: invokespecial 516	com/tencent/mobileqq/apollo/GLTextureView:setOffscreenMode	(Z)V
    //   109: iload 4
    //   111: ifeq +15 -> 126
    //   114: aload_0
    //   115: aload_0
    //   116: getfield 468	com/tencent/mobileqq/apollo/ApolloTextureView:mOffscreenWidth	I
    //   119: aload_0
    //   120: getfield 389	com/tencent/mobileqq/apollo/ApolloTextureView:mOffscreenHeight	I
    //   123: invokespecial 520	com/tencent/mobileqq/apollo/GLTextureView:setOffscreenSize	(II)V
    //   126: aload_0
    //   127: aload_0
    //   128: getfield 395	com/tencent/mobileqq/apollo/ApolloTextureView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   131: invokespecial 524	com/tencent/mobileqq/apollo/GLTextureView:setRenderer	(Landroid/opengl/GLSurfaceView$Renderer;)V
    //   134: iload 4
    //   136: ifeq +22 -> 158
    //   139: aload_0
    //   140: aconst_null
    //   141: invokevirtual 528	com/tencent/mobileqq/apollo/ApolloTextureView:surfaceCreated	(Landroid/graphics/SurfaceTexture;)V
    //   144: aload_0
    //   145: aconst_null
    //   146: iconst_0
    //   147: aload_0
    //   148: getfield 468	com/tencent/mobileqq/apollo/ApolloTextureView:mOffscreenWidth	I
    //   151: aload_0
    //   152: getfield 389	com/tencent/mobileqq/apollo/ApolloTextureView:mOffscreenHeight	I
    //   155: invokevirtual 532	com/tencent/mobileqq/apollo/ApolloTextureView:surfaceChanged	(Landroid/graphics/SurfaceTexture;III)V
    //   158: aload_0
    //   159: iconst_0
    //   160: invokespecial 535	com/tencent/mobileqq/apollo/GLTextureView:setRenderMode	(I)V
    //   163: aload_0
    //   164: new 314	com/tencent/mobileqq/apollo/ApolloRenderDriver
    //   167: dup
    //   168: aload_0
    //   169: aload_0
    //   170: getfield 395	com/tencent/mobileqq/apollo/ApolloTextureView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   173: invokevirtual 334	com/tencent/mobileqq/apollo/ApolloRender:getSavaWrapper	()Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   176: invokespecial 538	com/tencent/mobileqq/apollo/ApolloRenderDriver:<init>	(Lampx;Lcom/tencent/mobileqq/apollo/ApolloEngine;)V
    //   179: putfield 312	com/tencent/mobileqq/apollo/ApolloTextureView:mApolloWorker	Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;
    //   182: aload_0
    //   183: getfield 395	com/tencent/mobileqq/apollo/ApolloTextureView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   186: aload_0
    //   187: invokevirtual 542	com/tencent/mobileqq/apollo/ApolloRender:setRenderView	(Landroid/view/View;)V
    //   190: aload_0
    //   191: getfield 395	com/tencent/mobileqq/apollo/ApolloTextureView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   194: iload 4
    //   196: invokevirtual 545	com/tencent/mobileqq/apollo/ApolloRender:setOffscreen	(Z)V
    //   199: aload_0
    //   200: new 547	amnw
    //   203: dup
    //   204: aload_0
    //   205: getfield 312	com/tencent/mobileqq/apollo/ApolloTextureView:mApolloWorker	Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;
    //   208: aload_0
    //   209: getfield 395	com/tencent/mobileqq/apollo/ApolloTextureView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   212: invokespecial 550	amnw:<init>	(Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;Lcom/tencent/mobileqq/apollo/ApolloRender;)V
    //   215: putfield 452	com/tencent/mobileqq/apollo/ApolloTextureView:mRenderImpl	Lamnw;
    //   218: aload_0
    //   219: monitorexit
    //   220: return
    //   221: aload_0
    //   222: new 330	com/tencent/mobileqq/apollo/ApolloRender
    //   225: dup
    //   226: aload_0
    //   227: getfield 108	com/tencent/mobileqq/apollo/ApolloTextureView:mDensity	F
    //   230: aload_0
    //   231: getfield 234	com/tencent/mobileqq/apollo/ApolloTextureView:mCallback	Lampy;
    //   234: iload_2
    //   235: invokespecial 553	com/tencent/mobileqq/apollo/ApolloRender:<init>	(FLampy;I)V
    //   238: putfield 395	com/tencent/mobileqq/apollo/ApolloTextureView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   241: goto -151 -> 90
    //   244: astore_1
    //   245: aload_0
    //   246: monitorexit
    //   247: aload_1
    //   248: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	ApolloTextureView
    //   0	249	1	paramampy	ampy
    //   0	249	2	paramInt	int
    //   0	249	3	paramApolloRender	ApolloRender
    //   0	249	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	67	244	finally
    //   67	72	244	finally
    //   76	90	244	finally
    //   90	109	244	finally
    //   114	126	244	finally
    //   126	134	244	finally
    //   139	158	244	finally
    //   158	218	244	finally
    //   221	241	244	finally
  }
  
  public boolean isJsRuntime()
  {
    return true;
  }
  
  public boolean isOffscreen()
  {
    if (this.mRender != null) {
      return this.mRender.isOffscreen();
    }
    return false;
  }
  
  public native void nativeSetTextureView(ApolloTextureView paramApolloTextureView);
  
  protected void onAttachedToWindow()
  {
    this.mAttachCount += 1;
    if ((this.mAttachCount > 1) && (!this.mIsDrawerView) && (BaseApplicationImpl.sProcessId == 1))
    {
      this.mIsReAttach = true;
      Object localObject = Thread.currentThread().getStackTrace();
      if (localObject != null)
      {
        localObject = Arrays.toString((Object[])localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          QLog.i("ApolloTextureView", 1, "onAttachedToWindow found re_attach:" + (String)localObject);
          sReAttachTime = System.currentTimeMillis();
        }
      }
    }
    super.onAttachedToWindow();
  }
  
  public void onDrawRectHeightChanged(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = anck.a(paramQQAppInterface);
    } while (paramQQAppInterface == null);
    int j = getWidth();
    int i = paramInt;
    if (paramInt == 0) {
      i = getHeight();
    }
    paramQQAppInterface.a(j, i);
  }
  
  public void onExecDispose()
  {
    if (this.mRenderImpl != null) {
      this.mRenderImpl.a();
    }
  }
  
  public void onExecDispose(String paramString)
  {
    if (this.mRenderImpl != null) {
      this.mRenderImpl.a(paramString);
    }
  }
  
  public RectF onGetDressRect(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTextureView", 2, "[onGetDressRect], dressName:" + paramString);
    }
    RectF localRectF = new RectF();
    ReentrantLock localReentrantLock = anhn.a().a();
    QLog.d("ApolloLock", 2, "onGetDressRect");
    localReentrantLock.lock();
    try
    {
      if (this.mRender != null)
      {
        paramString = this.mRender.getSavaWrapper().a(paramString);
        if (paramString != null)
        {
          localRectF.left = paramString.left;
          localRectF.bottom = paramString.top;
          paramString.top += paramString.bottom;
          float f = paramString.right;
          localRectF.right = (paramString.left + f);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloTextureView", 2, "x:" + localRectF.left + ",deltaY:" + localRectF.top + ",width:" + localRectF.right + ",height:" + localRectF.bottom);
          }
        }
      }
      return localRectF;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public float onGetLittleManHeight()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTextureView", 2, "[onGetLittleManHeight]");
    }
    ReentrantLock localReentrantLock = anhn.a().a();
    QLog.d("ApolloLock", 2, "onGetManHeight");
    localReentrantLock.lock();
    for (;;)
    {
      try
      {
        if ((this.mRender == null) || (this.mRender.getSavaWrapper() == null))
        {
          localReentrantLock.unlock();
          return 0.0F;
        }
        RectF localRectF = this.mRender.getSavaWrapper().a();
        if (localRectF != null)
        {
          float f2 = localRectF.top + localRectF.bottom;
          f1 = f2;
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloTextureView", 2, "left:" + localRectF.left + ",top:" + localRectF.top + ",right:" + localRectF.right + ",bottom:" + localRectF.bottom);
            f1 = f2;
          }
          localReentrantLock.unlock();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloTextureView", 2, "height:" + f1);
          }
          return f1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return 0.0F;
      }
      finally
      {
        localReentrantLock.unlock();
      }
      float f1 = 0.0F;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    QLog.d("sava", 2, "texture view onLayout");
  }
  
  public void onRender()
  {
    queueEvent(new ApolloTextureView.1(this));
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.d("sava", 2, "texture view onresume");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    if (this.mDisableTouchEvent) {}
    label103:
    do
    {
      do
      {
        float f1;
        float f2;
        float f3;
        float f4;
        do
        {
          do
          {
            do
            {
              do
              {
                return false;
              } while ((this.mIsDestroy != null) && (this.mIsDestroy.get()));
              if (!ApolloEngine.a())
              {
                QLog.w("ApolloTextureView", 1, "apollo lib NOT loaded, textureview ontouch return.");
                return false;
              }
              if (this.mTouchableRect == null) {
                break label103;
              }
              if (this.mTouchableRect.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("ApolloTextureView", 2, "touch not in mTouchableRect!");
            return false;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloTextureView", 2, "touch in mTouchableRect!");
            }
            this.mLastTouchEvent = MotionEvent.obtain(paramMotionEvent);
            switch (paramMotionEvent.getAction())
            {
            default: 
              return false;
            case 0: 
              this.mDetectTouchMoved = false;
              this.mHasPerformedLongPress = false;
              if (this.mPendingCheckForLongPress == null) {
                this.mPendingCheckForLongPress = new ApolloTextureView.CheckForLongPress(this);
              }
              if (!this.mIsDrawerView)
              {
                this.mPendingCheckForLongPress.a();
                super.postDelayed(this.mPendingCheckForLongPress, this.mLongPressTimeout);
              }
              this.mPY = paramMotionEvent.getY();
              this.mPX = paramMotionEvent.getX();
              this.mDisableParentIntercept = false;
              f1 = this.mPX;
              f2 = this.mPY;
              f2 = super.getBottom() - super.getTop() - f2;
            }
          } while (this.mCallback == null);
          System.currentTimeMillis();
          long l = this.mLastClickT;
          this.mLastClickT = System.currentTimeMillis();
          this.mPY = paramMotionEvent.getY();
          this.mPX = paramMotionEvent.getX();
          this.mTouchDownX = this.mPX;
          this.mTouchDownY = this.mPY;
          this.mNode = -1;
          this.mApolloId = "";
          if (this.mRender != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloTextureView", 2, "list length:" + this.mRender.mBoundingList.size() + "mPY = " + this.mPY + ", pty = " + f2 + ",mPX = " + this.mPX + ", xInView = " + f1 + "super.getBottom() = " + super.getBottom() + "super.getTop()" + super.getTop());
            }
            paramMotionEvent = ApolloUtil.a(f1, f2, this.mRender.mBoundingList);
            this.mNode = paramMotionEvent.jdField_a_of_type_Int;
            this.mApolloId = paramMotionEvent.jdField_a_of_type_JavaLangString;
          }
          if (!this.mIsDrawerView) {
            break;
          }
          f3 = getWidth();
          f4 = getHeight();
        } while ((f3 > 0.0F) && (f4 > 0.0F) && (((f1 < f3 / 2.0F) && (f2 < f4) && (this.mNode != 1000)) || (f2 > f4)));
        boolean bool1 = bool2;
        if (this.mNode < 0) {
          if (TextUtils.isEmpty(this.mApolloId)) {
            break label561;
          }
        }
        for (bool1 = bool2;; bool1 = false) {
          return bool1;
        }
        if (this.mPendingCheckForLongPress != null) {
          super.removeCallbacks(this.mPendingCheckForLongPress);
        }
      } while ((this.mCallback == null) || (this.mHasPerformedLongPress) || (this.mDetectTouchMoved) || ((this.mNode < 0) && (TextUtils.isEmpty(this.mApolloId))));
      paramMotionEvent = BaseApplicationImpl.getApplication();
      if (paramMotionEvent != null)
      {
        paramMotionEvent = paramMotionEvent.getRuntime();
        if ((paramMotionEvent instanceof QQAppInterface)) {
          paramMotionEvent = (QQAppInterface)paramMotionEvent;
        }
      }
      int i = 8;
      switch (this.mNode)
      {
      }
      for (;;)
      {
        this.mCallback.onNotifyStatusChanged(i, this.mApolloId);
        this.mApolloId = null;
        return false;
        i = 7;
        continue;
        i = 9;
        continue;
        i = 10;
        continue;
        i = 11;
        continue;
        i = 12;
      }
      this.mPX = paramMotionEvent.getX();
      this.mPY = paramMotionEvent.getY();
      if ((Math.abs(this.mPX - this.mTouchDownX) > ViewConfiguration.get(getContext()).getScaledTouchSlop()) || (Math.abs(this.mPY - this.mTouchDownY) > ViewConfiguration.get(getContext()).getScaledTouchSlop()))
      {
        super.removeCallbacks(this.mPendingCheckForLongPress);
        this.mHasPerformedLongPress = false;
        this.mDetectTouchMoved = true;
      }
      return true;
    } while (this.mPendingCheckForLongPress == null);
    label561:
    super.removeCallbacks(this.mPendingCheckForLongPress);
    return false;
  }
  
  @Deprecated
  public void queueEvent(Runnable paramRunnable)
  {
    if ((paramRunnable instanceof IApolloRunnableTask)) {
      if (this.mRender != null) {
        this.mRender.queueRenderTask((IApolloRunnableTask)paramRunnable);
      }
    }
    for (;;)
    {
      requestRender();
      return;
      QLog.e("ApolloTextureView", 1, "queueEvent mRender== null");
      continue;
      if (this.mRender != null) {
        this.mRender.queueRenderTask(new ApolloTextureView.5(this, paramRunnable));
      } else {
        QLog.e("ApolloTextureView", 1, "queueEvent mRender== null");
      }
    }
  }
  
  public void removeAllApolloBarrages(boolean paramBoolean)
  {
    if (this.mBarrageViewRef != null)
    {
      amqy localamqy = (amqy)this.mBarrageViewRef.get();
      if (localamqy != null) {
        localamqy.a(paramBoolean);
      }
    }
  }
  
  public void runRenderTask(IApolloRunnableTask paramIApolloRunnableTask)
  {
    if ((!this.mIsDestroy.get()) && (paramIApolloRunnableTask != null)) {
      queueEvent(paramIApolloRunnableTask);
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setBarrageView(amqy paramamqy)
  {
    this.mBarrageViewRef = new WeakReference(paramamqy);
  }
  
  public void setBubbleType(int paramInt)
  {
    if (this.mRender != null) {
      this.mRender.setBubbleType(paramInt);
    }
  }
  
  public void setDispatchEvent2Native(boolean paramBoolean)
  {
    this.mDispatchEvent2native = paramBoolean;
  }
  
  public void setDumplicateCreateRenderThread(boolean paramBoolean)
  {
    this.mDisableCreateRenderThread = paramBoolean;
  }
  
  public void setForeground(Drawable paramDrawable) {}
  
  public void setInitHeight(int paramInt)
  {
    this.mInitHeight = paramInt;
  }
  
  public void setLongPressTimeout(int paramInt)
  {
    this.mLongPressTimeout = paramInt;
  }
  
  public void setOffscreenSize(int paramInt1, int paramInt2)
  {
    QLog.d("ApolloTextureView", 1, new Object[] { "FrameRecorder setOffscreenSize, width=", Integer.valueOf(paramInt1), ", height=", Integer.valueOf(paramInt2) });
    this.mOffscreenWidth = paramInt1;
    this.mOffscreenHeight = paramInt2;
  }
  
  public void setTouchableRect(RectF paramRectF)
  {
    this.mTouchableRect = paramRectF;
  }
  
  public void stopLoopDelayed(long paramLong)
  {
    if (this.mRenderImpl != null) {
      this.mRenderImpl.a(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloTextureView
 * JD-Core Version:    0.7.0.1
 */