package com.tencent.mobileqq.apollo;

import aigt;
import aihd;
import aihe;
import aiii;
import aiik;
import aiil;
import aijj;
import aijl;
import aijz;
import airu;
import aisl;
import aiwj;
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
  implements aiii, aiik
{
  public static final String TAG = "ApolloTextureView";
  public static long sReAttachTime;
  private aihd events = new aihd();
  private String mApolloId;
  protected ApolloRenderDriver mApolloWorker;
  private int mAttachCount;
  private WeakReference<aijl> mBarrageViewRef;
  private aiil mCallback;
  private float mDensity = super.getContext().getResources().getDisplayMetrics().density;
  private boolean mDetectTouchMoved;
  private boolean mDisableParentIntercept;
  private boolean mDisableTouchEvent;
  private boolean mDispatchEvent2native;
  private final byte[] mEngineLock = new byte[0];
  private final long mEngineWaitTime;
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
  private float mPX;
  private float mPY;
  private ApolloTextureView.CheckForLongPress mPendingCheckForLongPress = new ApolloTextureView.CheckForLongPress(this);
  public ApolloRender mRender;
  protected aigt mRenderImpl;
  private boolean mSendEventToNatived;
  private float mTouchDownX;
  private float mTouchDownY;
  private RectF mTouchableRect;
  
  @TargetApi(14)
  public ApolloTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setEGLContextClientVersion(2);
    int i = ApolloUtil.a();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTextureView", 2, "ApolloTextureView MSAA_level:" + i);
    }
    if (i != 0) {
      if (1 == i)
      {
        super.setEGLConfigChooser(new aihe(4));
        super.setOpaque(false);
        this.mLongPressTimeout = ViewConfiguration.getLongPressTimeout();
        this.mIsDestroy = new AtomicBoolean(false);
        if (this.mDensity > 0.0F) {
          break label283;
        }
      }
    }
    label283:
    for (float f = 1.2F;; f = this.mDensity)
    {
      this.mEngineWaitTime = ((300.0F / f));
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
        super.setEGLConfigChooser(new aihe(2));
        break;
      }
      super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
      break;
      super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
      break;
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
      ((aihd)localObject).jdField_a_of_type_Int += 1;
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
              aihd localaihd = this.events;
              localaihd.jdField_a_of_type_Int -= 1;
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
      aijl localaijl = (aijl)this.mBarrageViewRef.get();
      if (localaijl != null) {
        aijj.a(localaijl, BaseApplicationImpl.getContext(), paramString1, paramString2, paramBoolean);
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
    for (float f = 0.0F; localIterator.hasNext(); f = Math.max(f, ((aijz)localIterator.next()).d)) {}
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTextureView", 2, new Object[] { "[getManRectMaxHeight] height:", Float.valueOf(f) });
    }
    return f;
  }
  
  public ApolloRender getRender()
  {
    return this.mRender;
  }
  
  public aigt getRenderImpl()
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
  
  public void init(aiil paramaiil)
  {
    try
    {
      init(paramaiil, 0, null);
      return;
    }
    finally
    {
      paramaiil = finally;
      throw paramaiil;
    }
  }
  
  public void init(aiil paramaiil, int paramInt)
  {
    try
    {
      init(paramaiil, paramInt, null);
      return;
    }
    finally
    {
      paramaiil = finally;
      throw paramaiil;
    }
  }
  
  /* Error */
  public void init(aiil paramaiil, int paramInt, ApolloRender paramApolloRender)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +51 -> 56
    //   8: ldc 12
    //   10: iconst_2
    //   11: new 125	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 467
    //   21: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 470	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: ldc_w 472
    //   31: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_2
    //   35: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: ldc_w 474
    //   41: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokestatic 476	com/tencent/mobileqq/apollo/ApolloEngine:a	()Z
    //   47: invokevirtual 479	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_0
    //   57: aload_1
    //   58: putfield 234	com/tencent/mobileqq/apollo/ApolloTextureView:mCallback	Laiil;
    //   61: aload_3
    //   62: ifnull +92 -> 154
    //   65: aload_0
    //   66: aload_3
    //   67: putfield 390	com/tencent/mobileqq/apollo/ApolloTextureView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   70: ldc 12
    //   72: iconst_1
    //   73: ldc_w 481
    //   76: invokestatic 484	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: aload_0
    //   80: new 486	aihf
    //   83: dup
    //   84: aload_0
    //   85: aconst_null
    //   86: invokespecial 489	aihf:<init>	(Lcom/tencent/mobileqq/apollo/ApolloTextureView;Lcom/tencent/mobileqq/apollo/ApolloTextureView$1;)V
    //   89: invokespecial 493	com/tencent/mobileqq/apollo/GLTextureView:setEGLContextFactory	(Laiib;)V
    //   92: aload_0
    //   93: aload_0
    //   94: getfield 390	com/tencent/mobileqq/apollo/ApolloTextureView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   97: invokespecial 497	com/tencent/mobileqq/apollo/GLTextureView:setRenderer	(Landroid/opengl/GLSurfaceView$Renderer;)V
    //   100: aload_0
    //   101: iconst_0
    //   102: invokespecial 500	com/tencent/mobileqq/apollo/GLTextureView:setRenderMode	(I)V
    //   105: aload_0
    //   106: new 314	com/tencent/mobileqq/apollo/ApolloRenderDriver
    //   109: dup
    //   110: aload_0
    //   111: aload_0
    //   112: getfield 390	com/tencent/mobileqq/apollo/ApolloTextureView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   115: invokevirtual 334	com/tencent/mobileqq/apollo/ApolloRender:getSavaWrapper	()Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   118: invokespecial 503	com/tencent/mobileqq/apollo/ApolloRenderDriver:<init>	(Laiik;Lcom/tencent/mobileqq/apollo/ApolloEngine;)V
    //   121: putfield 312	com/tencent/mobileqq/apollo/ApolloTextureView:mApolloWorker	Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;
    //   124: aload_0
    //   125: getfield 390	com/tencent/mobileqq/apollo/ApolloTextureView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   128: aload_0
    //   129: invokevirtual 507	com/tencent/mobileqq/apollo/ApolloRender:setRenderView	(Landroid/view/View;)V
    //   132: aload_0
    //   133: new 509	aigt
    //   136: dup
    //   137: aload_0
    //   138: getfield 312	com/tencent/mobileqq/apollo/ApolloTextureView:mApolloWorker	Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;
    //   141: aload_0
    //   142: getfield 390	com/tencent/mobileqq/apollo/ApolloTextureView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   145: invokespecial 512	aigt:<init>	(Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;Lcom/tencent/mobileqq/apollo/ApolloRender;)V
    //   148: putfield 443	com/tencent/mobileqq/apollo/ApolloTextureView:mRenderImpl	Laigt;
    //   151: aload_0
    //   152: monitorexit
    //   153: return
    //   154: aload_0
    //   155: new 330	com/tencent/mobileqq/apollo/ApolloRender
    //   158: dup
    //   159: aload_0
    //   160: getfield 107	com/tencent/mobileqq/apollo/ApolloTextureView:mDensity	F
    //   163: aload_0
    //   164: getfield 234	com/tencent/mobileqq/apollo/ApolloTextureView:mCallback	Laiil;
    //   167: iload_2
    //   168: invokespecial 515	com/tencent/mobileqq/apollo/ApolloRender:<init>	(FLaiil;I)V
    //   171: putfield 390	com/tencent/mobileqq/apollo/ApolloTextureView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   174: goto -95 -> 79
    //   177: astore_1
    //   178: aload_0
    //   179: monitorexit
    //   180: aload_1
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	ApolloTextureView
    //   0	182	1	paramaiil	aiil
    //   0	182	2	paramInt	int
    //   0	182	3	paramApolloRender	ApolloRender
    // Exception table:
    //   from	to	target	type
    //   2	56	177	finally
    //   56	61	177	finally
    //   65	79	177	finally
    //   79	151	177	finally
    //   154	174	177	finally
  }
  
  public boolean isJsRuntime()
  {
    return true;
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
      paramQQAppInterface = aisl.a(paramQQAppInterface);
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
    ReentrantLock localReentrantLock = aiwj.a().a();
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
    ReentrantLock localReentrantLock = aiwj.a().a();
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
            this.mNode = Integer.parseInt(paramMotionEvent[0]);
            this.mApolloId = paramMotionEvent[1];
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
            break label562;
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
      if (this.mNode == 1000) {
        this.mCallback.onNotifyStatusChanged(7, this.mApolloId);
      }
      for (;;)
      {
        this.mApolloId = null;
        return false;
        if (this.mNode == 2) {
          this.mCallback.onNotifyStatusChanged(9, this.mApolloId);
        } else {
          this.mCallback.onNotifyStatusChanged(8, this.mApolloId);
        }
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
    label562:
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
      aijl localaijl = (aijl)this.mBarrageViewRef.get();
      if (localaijl != null) {
        localaijl.a(paramBoolean);
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
  
  public void setBarrageView(aijl paramaijl)
  {
    this.mBarrageViewRef = new WeakReference(paramaijl);
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
  
  public void setForeground(Drawable paramDrawable) {}
  
  public void setInitHeight(int paramInt)
  {
    this.mInitHeight = paramInt;
  }
  
  public void setLongPressTimeout(int paramInt)
  {
    this.mLongPressTimeout = paramInt;
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