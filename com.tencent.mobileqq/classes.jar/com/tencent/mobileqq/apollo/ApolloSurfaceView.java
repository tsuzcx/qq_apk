package com.tencent.mobileqq.apollo;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.opengl.GLSurfaceView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.barrage.ApolloBarrageUtil;
import com.tencent.mobileqq.apollo.barrage.BarrageUI;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import ymo;
import ymp;
import ymr;
import yms;
import ymt;
import ymv;

public class ApolloSurfaceView
  extends GLSurfaceView
  implements IApolloRenderView, ITriggerRenderCallback
{
  public static final int INPUT_MARGIN = 10;
  private static final int MSG_CODE_SURFACECHANGED = 255;
  public static final String TAG = "ApolloSurfaceView";
  public static final int TOUCH_MODE_GAME = 1;
  public static final int TOUCH_MODE_NORMAL = 0;
  private static Field sGLThreadField;
  private ApolloSurfaceView.TouchEvent events = new ApolloSurfaceView.TouchEvent();
  public String mApolloId;
  public ApolloRenderDriver mApolloWorker;
  protected WeakReference mBarrageViewRef;
  private WeakReference mCallbackRef;
  private boolean mCloseGame;
  private float mDensity = super.getContext().getResources().getDisplayMetrics().density;
  private boolean mDetectTouchMoved;
  private boolean mDisableParentIntercept;
  private final byte[] mEngineLock = new byte[0];
  private long mEngineWaitTime;
  private int mGameId;
  private boolean mHasPerformedLongPress;
  private int mHeight;
  public AtomicBoolean mIsDestroy = new AtomicBoolean(false);
  public boolean mIsGameReady;
  private MotionEvent mLastTouchEvent;
  private int mNode = -1;
  private float mPX;
  private float mPY;
  private ymv mPendingCheckForLongPress = new ymv(this);
  public ApolloRender mRender;
  protected ApolloRenderInterfaceImpl mRenderImpl;
  public int mRenderMode = 1;
  private long mRenderThreadId = -2147483648L;
  private boolean mSendEventToNatived;
  private float mTouchDownX;
  private float mTouchDownY;
  private int mTouchMode = 0;
  private boolean mUpdateSurfaceDirect = true;
  private int mWidth;
  public int uiOptions;
  
  public ApolloSurfaceView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet);
    super.setEGLContextClientVersion(2);
    super.setEGLConfigChooser(8, 8, 8, 8, 16, 8);
    if (paramBoolean)
    {
      super.setZOrderOnTop(true);
      super.getHolder().setFormat(-2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "[ApolloSurfaceView] constructor");
    }
    initTouchEvent();
    paramAttributeSet = BaseApplicationImpl.getApplication();
    if ((paramAttributeSet != null) && ((paramContext instanceof Activity)))
    {
      paramAttributeSet = paramAttributeSet.getRuntime();
      if ((paramAttributeSet instanceof QQAppInterface)) {
        ApolloCmdChannel.getChannel((QQAppInterface)paramAttributeSet).setActivityContext((Activity)paramContext);
      }
    }
    if (this.mDensity <= 0.0F) {}
    for (float f = 1.2F;; f = this.mDensity)
    {
      this.mEngineWaitTime = ((300.0F / f));
      return;
    }
  }
  
  private native void nativeDestroySurfaceView();
  
  public static native void nativeTouchInput(long paramLong, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
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
      ((ApolloSurfaceView.TouchEvent)localObject).jdField_a_of_type_Int += 1;
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
      queueEvent(new ymr(this, (float[])localObject, arrayOfFloat, arrayOfInt1, arrayOfInt2));
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
        QLog.d("ApolloSurfaceView", 2, "move event index =" + k + ",event.count=" + paramMotionEvent.getPointerCount());
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
    queueEvent(new yms(this, arrayOfFloat1, arrayOfFloat2, arrayOfInt1, arrayOfInt2));
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
        QLog.e("ApolloSurfaceView", 1, "send touch event err e=" + localThrowable.toString());
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
        queueEvent(new ymt(this, arrayOfFloat1, arrayOfFloat2, arrayOfInt1, arrayOfInt2));
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
              ApolloSurfaceView.TouchEvent localTouchEvent = this.events;
              localTouchEvent.jdField_a_of_type_Int -= 1;
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
      if ((this.mApolloWorker != null) && (this.mApolloWorker.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine != null)) {
        this.mApolloWorker.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine.a("mainTicker.paused = false;");
      }
      nativeTouchInput(getRender().getSavaWrapper().a, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfInt1, paramArrayOfInt2);
      return;
    }
    catch (Throwable paramArrayOfFloat1)
    {
      QLog.e("ApolloSurfaceView", 1, "send touch event err e=" + paramArrayOfFloat1.toString());
    }
  }
  
  public void bulkApolloBarrages(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((this.mBarrageViewRef != null) && (!TextUtils.isEmpty(paramString2)))
    {
      BarrageUI localBarrageUI = (BarrageUI)this.mBarrageViewRef.get();
      if (localBarrageUI != null) {
        ApolloBarrageUtil.a(localBarrageUI, BaseApplicationImpl.getContext(), paramString1, paramString2, paramBoolean);
      }
    }
  }
  
  public void exeJsOnEngine(String paramString)
  {
    if (this.mApolloWorker != null) {
      this.mApolloWorker.c(paramString);
    }
  }
  
  public int getGameId()
  {
    return this.mGameId;
  }
  
  public long getLuaState()
  {
    if ((this.mRender != null) && (this.mRender.getSavaWrapper() != null)) {
      return this.mRender.getSavaWrapper().a();
    }
    return -1L;
  }
  
  public ApolloRender getRender()
  {
    return this.mRender;
  }
  
  public ApolloRenderInterfaceImpl getRenderImpl()
  {
    return this.mRenderImpl;
  }
  
  public long getRenderThreadId()
  {
    try
    {
      if (this.mRenderThreadId != -2147483648L) {
        return this.mRenderThreadId;
      }
      if (sGLThreadField == null)
      {
        sGLThreadField = getClass().getSuperclass().getDeclaredField("mGLThread");
        sGLThreadField.setAccessible(true);
      }
      this.mRenderThreadId = ((Thread)sGLThreadField.get(this)).getId();
      long l = this.mRenderThreadId;
      return l;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloSurfaceView", 1, localException, new Object[0]);
    }
    return 0L;
  }
  
  public long getRuntimeState()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "apollochannel_,getRuntimeState,mIsGameReady:" + this.mIsGameReady + ",mIsDestroy:" + this.mIsDestroy);
    }
    if (!this.mIsDestroy.get()) {
      return getLuaState();
    }
    return -1L;
  }
  
  public int getStatus()
  {
    return this.mApolloWorker.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public ApolloRenderDriver getWorker()
  {
    return this.mApolloWorker;
  }
  
  public void init(OnApolloViewListener paramOnApolloViewListener)
  {
    try
    {
      init(paramOnApolloViewListener, 0);
      return;
    }
    finally
    {
      paramOnApolloViewListener = finally;
      throw paramOnApolloViewListener;
    }
  }
  
  /* Error */
  public void init(OnApolloViewListener paramOnApolloViewListener, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +39 -> 44
    //   8: ldc 17
    //   10: iconst_2
    //   11: new 286	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 464
    //   21: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 441	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: ldc_w 466
    //   31: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_2
    //   35: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload_0
    //   45: new 357	java/lang/ref/WeakReference
    //   48: dup
    //   49: aload_1
    //   50: invokespecial 469	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   53: putfield 198	com/tencent/mobileqq/apollo/ApolloSurfaceView:mCallbackRef	Ljava/lang/ref/WeakReference;
    //   56: aload_0
    //   57: new 337	com/tencent/mobileqq/apollo/ApolloRender
    //   60: dup
    //   61: aload_0
    //   62: getfield 130	com/tencent/mobileqq/apollo/ApolloSurfaceView:mDensity	F
    //   65: aload_1
    //   66: iload_2
    //   67: invokespecial 472	com/tencent/mobileqq/apollo/ApolloRender:<init>	(FLcom/tencent/mobileqq/apollo/OnApolloViewListener;I)V
    //   70: putfield 382	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   73: aload_0
    //   74: new 474	ymu
    //   77: dup
    //   78: aload_0
    //   79: aconst_null
    //   80: invokespecial 477	ymu:<init>	(Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;Lymo;)V
    //   83: invokespecial 481	android/opengl/GLSurfaceView:setEGLContextFactory	(Landroid/opengl/GLSurfaceView$EGLContextFactory;)V
    //   86: aload_0
    //   87: aload_0
    //   88: getfield 382	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   91: invokespecial 485	android/opengl/GLSurfaceView:setRenderer	(Landroid/opengl/GLSurfaceView$Renderer;)V
    //   94: aload_0
    //   95: aload_0
    //   96: getfield 74	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRenderMode	I
    //   99: invokespecial 488	android/opengl/GLSurfaceView:setRenderMode	(I)V
    //   102: aload_0
    //   103: new 321	com/tencent/mobileqq/apollo/ApolloRenderDriver
    //   106: dup
    //   107: aload_0
    //   108: aload_0
    //   109: getfield 382	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   112: invokevirtual 341	com/tencent/mobileqq/apollo/ApolloRender:getSavaWrapper	()Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   115: invokespecial 491	com/tencent/mobileqq/apollo/ApolloRenderDriver:<init>	(Lcom/tencent/mobileqq/apollo/ITriggerRenderCallback;Lcom/tencent/mobileqq/apollo/ApolloEngine;)V
    //   118: putfield 319	com/tencent/mobileqq/apollo/ApolloSurfaceView:mApolloWorker	Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;
    //   121: aload_0
    //   122: getfield 382	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   125: aload_0
    //   126: invokevirtual 495	com/tencent/mobileqq/apollo/ApolloRender:setRenderView	(Landroid/view/View;)V
    //   129: aload_0
    //   130: new 497	com/tencent/mobileqq/apollo/ApolloRenderInterfaceImpl
    //   133: dup
    //   134: aload_0
    //   135: getfield 319	com/tencent/mobileqq/apollo/ApolloSurfaceView:mApolloWorker	Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;
    //   138: aload_0
    //   139: getfield 382	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   142: invokespecial 500	com/tencent/mobileqq/apollo/ApolloRenderInterfaceImpl:<init>	(Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;Lcom/tencent/mobileqq/apollo/ApolloRender;)V
    //   145: putfield 390	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRenderImpl	Lcom/tencent/mobileqq/apollo/ApolloRenderInterfaceImpl;
    //   148: aload_0
    //   149: monitorexit
    //   150: return
    //   151: astore_1
    //   152: ldc 17
    //   154: iconst_1
    //   155: new 286	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   162: ldc_w 502
    //   165: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_1
    //   169: invokevirtual 505	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   172: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 317	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: goto -33 -> 148
    //   184: astore_1
    //   185: aload_0
    //   186: monitorexit
    //   187: aload_1
    //   188: athrow
    //   189: astore_1
    //   190: ldc 17
    //   192: iconst_1
    //   193: new 286	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   200: ldc_w 507
    //   203: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_1
    //   207: invokevirtual 508	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   210: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 317	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: goto -71 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	ApolloSurfaceView
    //   0	222	1	paramOnApolloViewListener	OnApolloViewListener
    //   0	222	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   44	148	151	java/lang/OutOfMemoryError
    //   2	44	184	finally
    //   44	148	184	finally
    //   152	181	184	finally
    //   190	219	184	finally
    //   44	148	189	java/lang/Throwable
  }
  
  public void initTouchEvent()
  {
    if (this.events != null)
    {
      int i = 0;
      while (i < 4)
      {
        this.events.jdField_a_of_type_ArrayOfFloat[i] = 0.0F;
        this.events.jdField_b_of_type_ArrayOfFloat[i] = 0.0F;
        this.events.jdField_a_of_type_ArrayOfInt[i] = 0;
        this.events.jdField_b_of_type_ArrayOfInt[i] = 0;
        i += 1;
      }
    }
  }
  
  public boolean isGameMode()
  {
    return this.mTouchMode == 1;
  }
  
  public boolean isJsRuntime()
  {
    return (this.mGameId != 1) && (this.mGameId != 2);
  }
  
  public native void nativeSetSurfaceView(ApolloSurfaceView paramApolloSurfaceView);
  
  protected void onAttachedToWindow()
  {
    try
    {
      super.onAttachedToWindow();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSurfaceView", 1, localThrowable, new Object[] { "[onAttachedToWindow]" });
    }
  }
  
  public void onDrawRectHeightChanged(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = SpriteUtil.a(paramQQAppInterface);
    } while (paramQQAppInterface == null);
    int j = getWidth();
    int i = paramInt;
    if (paramInt == 0) {
      i = getHeight();
    }
    paramQQAppInterface.a(j, i);
  }
  
  public void onEnterGame(String paramString)
  {
    if (this.mApolloWorker != null)
    {
      this.mApolloWorker.a();
      this.mApolloWorker.b(paramString);
      if (this.mGameId != 1000) {
        queueEvent(new ymp(this));
      }
    }
  }
  
  public float onGetLittleManHeight()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "[onGetLittleManHeight]");
    }
    ReentrantLock localReentrantLock = ApolloActionManager.a().a();
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
            QLog.d("ApolloSurfaceView", 2, "left:" + localRectF.left + ",top:" + localRectF.top + ",right:" + localRectF.right + ",bottom:" + localRectF.bottom);
            f1 = f2;
          }
          localReentrantLock.unlock();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloSurfaceView", 2, "height:" + f1);
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
  
  public void onRender()
  {
    if ((getRender() == null) || (getRender().getSavaWrapper() == null)) {
      return;
    }
    queueEvent(new ymo(this, getRender()));
  }
  
  public void onRunInRenderThread(Runnable paramRunnable)
  {
    if ((!this.mIsDestroy.get()) && (paramRunnable != null)) {
      queueEvent(paramRunnable);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    if (this.mCallbackRef == null) {}
    Object localObject1;
    do
    {
      do
      {
        do
        {
          return false;
        } while ((this.mIsDestroy != null) && (this.mIsDestroy.get()));
        localObject1 = (OnApolloViewListener)this.mCallbackRef.get();
      } while (localObject1 == null);
      if (!ApolloEngine.a())
      {
        QLog.i("ApolloSurfaceView", 1, "apollo lib NOT loaded, [onTouchEvent] return.");
        return false;
      }
    } while ((this.mApolloWorker == null) || ((this.mApolloWorker.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine != null) && (!this.mApolloWorker.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine.a("surface.touch"))));
    if (this.mTouchMode == 1)
    {
      try
      {
        switch (paramMotionEvent.getAction() & 0xFF)
        {
        case 0: 
          if (this.events.jdField_a_of_type_Int >= 4) {
            QLog.e("ApolloSurfaceView", 1, "touch down is over 4");
          }
          break;
        }
      }
      catch (Throwable paramMotionEvent)
      {
        this.events.jdField_a_of_type_Int = 0;
        QLog.e("ApolloSurfaceView", 2, "touch event err e=" + paramMotionEvent.toString());
      }
      sendDownTouchNative(MotionEvent.obtain(paramMotionEvent));
      break label1235;
      sendDownTouchNative(MotionEvent.obtain(paramMotionEvent));
      break label1235;
      sendUpTouchToNative(MotionEvent.obtain(paramMotionEvent));
      break label1235;
      sendUpTouchToNative(MotionEvent.obtain(paramMotionEvent));
      break label1235;
      sendUpTouchToNative(MotionEvent.obtain(paramMotionEvent));
      break label1235;
      if (super.getParent() != null) {
        super.getParent().requestDisallowInterceptTouchEvent(true);
      }
      sendMoveTouchToNative(MotionEvent.obtain(paramMotionEvent));
    }
    else
    {
      this.mLastTouchEvent = MotionEvent.obtain(paramMotionEvent);
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      default: 
        return super.onTouchEvent(paramMotionEvent);
      case 0: 
        this.mDetectTouchMoved = false;
        this.mSendEventToNatived = false;
        this.mHasPerformedLongPress = false;
        this.mDisableParentIntercept = false;
        if (this.mPendingCheckForLongPress == null) {
          this.mPendingCheckForLongPress = new ymv(this);
        }
        this.mPendingCheckForLongPress.a();
        super.postDelayed(this.mPendingCheckForLongPress, ViewConfiguration.getLongPressTimeout());
        this.mPY = paramMotionEvent.getY();
        this.mPX = paramMotionEvent.getX();
        this.mTouchDownX = this.mPX;
        this.mTouchDownY = this.mPY;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        f2 = super.getBottom() - super.getTop() - f2;
        this.mNode = -1;
        this.mApolloId = "";
        if (this.mRender != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloSurfaceView", 2, "list length:" + this.mRender.mBoundingList.size() + "mPY = " + this.mPY + ", pty = " + f2 + ",mPX = " + this.mPX + ", xInView = " + f1 + "super.getBottom() = " + super.getBottom() + "super.getTop()" + super.getTop());
          }
          localObject1 = ApolloUtil.a(f1, f2, this.mRender.mBoundingList);
          this.mNode = Integer.parseInt(localObject1[0]);
          this.mApolloId = localObject1[1];
          if ((isJsRuntime()) && ((this.mNode >= 0) || (!TextUtils.isEmpty(this.mApolloId))))
          {
            sendDownTouchNative(MotionEvent.obtain(paramMotionEvent));
            this.mSendEventToNatived = true;
          }
        }
        if ((this.mNode >= 0) || (!TextUtils.isEmpty(this.mApolloId))) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      case 1: 
        if (this.mPendingCheckForLongPress != null) {
          super.removeCallbacks(this.mPendingCheckForLongPress);
        }
        if ((!this.mHasPerformedLongPress) && (!this.mDetectTouchMoved) && ((this.mNode >= 0) || (!TextUtils.isEmpty(this.mApolloId))))
        {
          Object localObject2 = BaseApplicationImpl.getApplication();
          if (localObject2 != null)
          {
            localObject2 = ((BaseApplicationImpl)localObject2).getRuntime();
            if ((localObject2 instanceof QQAppInterface)) {
              localObject2 = (QQAppInterface)localObject2;
            }
          }
          if ((this.mCallbackRef == null) || (this.mCallbackRef.get() == null)) {
            break label1229;
          }
          localObject2 = (OnApolloViewListener)this.mCallbackRef.get();
          if ((!(localObject2 instanceof ChatApolloViewListener)) || (((ChatApolloViewListener)localObject2).a == null)) {
            break label1229;
          }
          localObject2 = (BaseChatPie)((ChatApolloViewListener)localObject2).a.get();
          if (localObject2 == null) {
            break label1229;
          }
          ApolloGameManager localApolloGameManager = (ApolloGameManager)((BaseChatPie)localObject2).a.getManager(210);
          if (localApolloGameManager.jdField_a_of_type_Int == -1) {
            break label1229;
          }
          ApolloManager.a(localApolloGameManager.jdField_a_of_type_Int, null, ((BaseChatPie)localObject2).a());
          localApolloGameManager.jdField_a_of_type_Int = -1;
        }
        break;
      }
      for (;;)
      {
        if (i == 0)
        {
          if (this.mNode != 1000) {
            break label972;
          }
          ((OnApolloViewListener)localObject1).onNotifyStatusChanged(7, this.mApolloId);
        }
        for (;;)
        {
          this.mApolloId = null;
          if ((this.mSendEventToNatived) && (isJsRuntime()))
          {
            sendUpTouchToNative(MotionEvent.obtain(paramMotionEvent));
            if (QLog.isColorLevel()) {
              QLog.d("ApolloSurfaceView", 2, "apollo_drag_event_ MotionEvent.ACTION_UP");
            }
          }
          this.mSendEventToNatived = false;
          break;
          label972:
          ((OnApolloViewListener)localObject1).onNotifyStatusChanged(8, this.mApolloId);
        }
        this.mPX = paramMotionEvent.getX();
        this.mPY = paramMotionEvent.getY();
        if ((!this.mDisableParentIntercept) && (super.getParent() != null))
        {
          this.mDisableParentIntercept = true;
          super.getParent().requestDisallowInterceptTouchEvent(true);
        }
        if ((Math.abs(this.mPX - this.mTouchDownX) > ViewConfiguration.get(getContext()).getScaledTouchSlop()) || (Math.abs(this.mPY - this.mTouchDownY) > ViewConfiguration.get(getContext()).getScaledTouchSlop()))
        {
          super.removeCallbacks(this.mPendingCheckForLongPress);
          this.mHasPerformedLongPress = false;
          this.mDetectTouchMoved = true;
        }
        if ((this.mSendEventToNatived) && (isJsRuntime())) {
          sendMoveTouchToNative(MotionEvent.obtain(paramMotionEvent));
        }
        return true;
        if (this.mPendingCheckForLongPress != null) {
          super.removeCallbacks(this.mPendingCheckForLongPress);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloSurfaceView", 2, "apollo_drag_event_ MotionEvent.ACTION_CANCEL,mSendEventToNatived:" + this.mSendEventToNatived);
        }
        if ((this.mSendEventToNatived) && (isJsRuntime()))
        {
          if (this.mLastTouchEvent == null) {
            break label1218;
          }
          sendUpTouchToNative(this.mLastTouchEvent);
        }
        for (;;)
        {
          this.mSendEventToNatived = false;
          break;
          label1218:
          sendUpTouchToNative(MotionEvent.obtain(paramMotionEvent));
        }
        label1229:
        i = 0;
      }
    }
    label1235:
    return true;
  }
  
  public boolean performLongClick()
  {
    return super.performLongClick();
  }
  
  public void removeAllApolloBarrages(boolean paramBoolean)
  {
    if (this.mBarrageViewRef != null)
    {
      BarrageUI localBarrageUI = (BarrageUI)this.mBarrageViewRef.get();
      if (localBarrageUI != null) {
        localBarrageUI.a(paramBoolean);
      }
    }
  }
  
  public void run()
  {
    if (this.mApolloWorker != null) {
      this.mApolloWorker.a();
    }
  }
  
  public void runRenderTask(Runnable paramRunnable)
  {
    if ((!this.mIsDestroy.get()) && (paramRunnable != null)) {
      super.queueEvent(paramRunnable);
    }
  }
  
  public void setBarrageView(BarrageUI paramBarrageUI)
  {
    this.mBarrageViewRef = new WeakReference(paramBarrageUI);
  }
  
  public void setBubbleType(int paramInt)
  {
    if (this.mRender != null) {
      this.mRender.setBubbleType(paramInt);
    }
  }
  
  public void setFrameNum(int paramInt)
  {
    if (this.mApolloWorker != null) {
      this.mApolloWorker.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void setGameId(int paramInt)
  {
    this.mGameId = paramInt;
  }
  
  public void setGameName(String paramString)
  {
    if (this.mRender != null) {
      this.mRender.setGameName(paramString);
    }
  }
  
  public void setOnDestroyCloseGame(boolean paramBoolean)
  {
    this.mCloseGame = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "setOnDestroyCloseGame, closeGame:" + paramBoolean);
    }
  }
  
  public void setRenderWidthAndHeight(int paramInt1, int paramInt2)
  {
    if (this.mRender != null) {
      this.mRender.setRenderWidthAndHeight(paramInt1, paramInt2);
    }
  }
  
  public void setStatus(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, new Object[] { "[setStatus],status:", Integer.valueOf(paramInt) });
    }
    this.mApolloWorker.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
  }
  
  public void setTouchMode(int paramInt)
  {
    this.mTouchMode = paramInt;
  }
  
  public void setVisibility(int paramInt)
  {
    try
    {
      super.setVisibility(paramInt);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloSurfaceView", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloSurfaceView
 * JD-Core Version:    0.7.0.1
 */