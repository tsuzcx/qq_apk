package com.tencent.mobileqq.apollo;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl.ClickInfo;
import com.tencent.mobileqq.apollo.barrage.ApolloBarrageUtil;
import com.tencent.mobileqq.apollo.barrage.BarrageUI;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.view.opengl.ApolloConfigChooser;
import com.tencent.mobileqq.apollo.view.opengl.GLSurfaceView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.AppRuntime;

public class ApolloSurfaceView
  extends GLSurfaceView
  implements IApolloRenderView, ITriggerRenderCallback
{
  public static final String TAG = "ApolloSurfaceView";
  public static final int TOUCH_MODE_GAME = 1;
  public static final int TOUCH_MODE_NORMAL = 0;
  private static final int UI_STATE_DETACHFROMWINDOW = 2;
  private static final int UI_STATE_SURFACECREATE = 1;
  private static final int UI_STATE_SURFACEDESTROY = 3;
  private static Field sGLThreadField;
  private ApolloSurfaceView.TouchEvent events = new ApolloSurfaceView.TouchEvent();
  String mApolloId;
  protected ApolloRenderDriver mApolloWorker;
  protected WeakReference<BarrageUI> mBarrageViewRef;
  private WeakReference<OnApolloViewListener> mCallbackRef;
  private boolean mCloseGame;
  private float mDensity = super.getContext().getResources().getDisplayMetrics().density;
  private boolean mDetectTouchMoved;
  private boolean mDisableParentIntercept;
  private int mGameId;
  private boolean mHasPerformedLongPress;
  private int mHeight;
  private int mInitHeight;
  public AtomicBoolean mIsDestroy = new AtomicBoolean(false);
  public boolean mIsGameReady;
  private int mNode = -1;
  private float mPX;
  private float mPY;
  private ApolloSurfaceView.CheckForLongPress mPendingCheckForLongPress = new ApolloSurfaceView.CheckForLongPress(this);
  ApolloRender mRender;
  protected ApolloRenderInterfaceImpl mRenderImpl;
  public int mRenderMode = 1;
  private long mRenderThreadId = -2147483648L;
  public ApolloSurfaceView.SurfaceCallBackData mSurfaceCallBackData;
  private Runnable mSurfaceChangeRunnable = new ApolloSurfaceView.6(this);
  private float mTouchDownX;
  private float mTouchDownY;
  private int mTouchMode = 0;
  private AtomicInteger mUIState = new AtomicInteger();
  private int mWidth;
  public int uiOptions;
  
  public ApolloSurfaceView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet);
    super.setEGLContextClientVersion(ApolloManagerServiceImpl.getOpenGLVersion());
    int i = ApolloUtilImpl.getDeviceMSAALevel();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "ApolloSurfaceView MSAA_level:" + i);
    }
    if (i != 0) {
      if (1 == i) {
        super.setEGLConfigChooser(new ApolloConfigChooser(4));
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        super.setZOrderOnTop(true);
        super.getHolder().setFormat(-2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloSurfaceView", 2, "[ApolloSurfaceView] constructor");
      }
      initTouchEvent();
      if ((paramContext instanceof Activity)) {
        ApolloUtilImpl.getCmdChannel().setActivityContext((Activity)paramContext);
      }
      return;
      if (2 == i)
      {
        super.setEGLConfigChooser(new ApolloConfigChooser(2));
      }
      else
      {
        super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        continue;
        super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
      }
    }
  }
  
  public ApolloSurfaceView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramContext, paramAttributeSet);
    super.setEGLContextClientVersion(2);
    if (!paramBoolean2) {
      super.setEGLConfigChooser(8, 8, 8, 8, 16, 8);
    }
    for (;;)
    {
      if (paramBoolean1) {
        super.setZOrderOnTop(true);
      }
      if (paramBoolean3) {
        super.getHolder().setFormat(-2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloSurfaceView", 2, "[ApolloSurfaceView] constructor");
      }
      initTouchEvent();
      if ((paramContext instanceof Activity)) {
        ApolloUtilImpl.getCmdChannel().setActivityContext((Activity)paramContext);
      }
      return;
      int i = CmGameUtil.e();
      if (1 == i) {
        super.setEGLConfigChooser(new ApolloConfigChooser(4));
      } else if (2 == i) {
        super.setEGLConfigChooser(new ApolloConfigChooser(2));
      } else {
        super.setEGLConfigChooser(8, 8, 8, 8, 16, 8);
      }
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
      runRenderTask(new ApolloSurfaceView.2(this, (float[])localObject, arrayOfFloat, arrayOfInt1, arrayOfInt2));
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
    runRenderTask(new ApolloSurfaceView.3(this, arrayOfFloat1, arrayOfFloat2, arrayOfInt1, arrayOfInt2));
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
        runRenderTask(new ApolloSurfaceView.4(this, arrayOfFloat1, arrayOfFloat2, arrayOfInt1, arrayOfInt2));
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
  
  private void superSurfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceRedrawNeeded(paramSurfaceHolder);
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
  
  public String getQtaTestResult()
  {
    return this.mRender.getQtaTestResult();
  }
  
  public ApolloRender getRender()
  {
    return this.mRender;
  }
  
  public int getRenderHeight()
  {
    return super.getHeight();
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
  
  public int getRenderWidth()
  {
    return super.getWidth();
  }
  
  public long getRuntimeState()
  {
    if (!this.mIsDestroy.get()) {
      return getLuaState();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "apollochannel_,getRuntimeState,mIsGameReady:" + this.mIsGameReady + ",mIsDestroy:" + this.mIsDestroy);
    }
    return -1L;
  }
  
  public int getStatus()
  {
    return this.mApolloWorker.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public AtomicInteger getUIState()
  {
    return this.mUIState;
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
  
  public void init(OnApolloViewListener paramOnApolloViewListener, int paramInt)
  {
    try
    {
      init(paramOnApolloViewListener, paramInt, null);
      return;
    }
    finally
    {
      paramOnApolloViewListener = finally;
      throw paramOnApolloViewListener;
    }
  }
  
  public void init(OnApolloViewListener paramOnApolloViewListener, int paramInt, ApolloRender paramApolloRender)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloSurfaceView", 2, "[init], callback:" + paramOnApolloViewListener + ",engineType:" + paramInt);
      }
      init(paramOnApolloViewListener, paramInt, paramApolloRender, false);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void init(OnApolloViewListener paramOnApolloViewListener, int paramInt, ApolloRender paramApolloRender, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +50 -> 55
    //   8: ldc 12
    //   10: iconst_2
    //   11: new 162	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 513
    //   21: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 494	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: ldc_w 515
    //   31: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_2
    //   35: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: ldc_w 522
    //   41: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: iload 4
    //   46: invokevirtual 489	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_0
    //   56: new 392	java/lang/ref/WeakReference
    //   59: dup
    //   60: aload_1
    //   61: invokespecial 525	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   64: putfield 231	com/tencent/mobileqq/apollo/ApolloSurfaceView:mCallbackRef	Ljava/lang/ref/WeakReference;
    //   67: aload_3
    //   68: ifnull +104 -> 172
    //   71: aload_0
    //   72: aload_3
    //   73: putfield 420	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   76: ldc 12
    //   78: iconst_1
    //   79: ldc_w 527
    //   82: invokestatic 530	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: aload_0
    //   86: new 532	com/tencent/mobileqq/apollo/ApolloSurfaceView$ApolloContextFactory
    //   89: dup
    //   90: aload_0
    //   91: aconst_null
    //   92: invokespecial 535	com/tencent/mobileqq/apollo/ApolloSurfaceView$ApolloContextFactory:<init>	(Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;Lcom/tencent/mobileqq/apollo/ApolloSurfaceView$1;)V
    //   95: invokespecial 539	com/tencent/mobileqq/apollo/view/opengl/GLSurfaceView:setEGLContextFactory	(Lcom/tencent/mobileqq/apollo/view/opengl/EGLContextFactory;)V
    //   98: aload_0
    //   99: aload_0
    //   100: getfield 420	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   103: invokespecial 543	com/tencent/mobileqq/apollo/view/opengl/GLSurfaceView:setRenderer	(Lcom/tencent/mobileqq/apollo/view/opengl/Renderer;)V
    //   106: aload_0
    //   107: aload_0
    //   108: getfield 77	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRenderMode	I
    //   111: invokespecial 546	com/tencent/mobileqq/apollo/view/opengl/GLSurfaceView:setRenderMode	(I)V
    //   114: aload_0
    //   115: new 356	com/tencent/mobileqq/apollo/ApolloRenderDriver
    //   118: dup
    //   119: aload_0
    //   120: aload_0
    //   121: getfield 420	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   124: invokevirtual 376	com/tencent/mobileqq/apollo/ApolloRender:getSavaWrapper	()Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   127: invokespecial 549	com/tencent/mobileqq/apollo/ApolloRenderDriver:<init>	(Lcom/tencent/mobileqq/apollo/ITriggerRenderCallback;Lcom/tencent/mobileqq/apollo/ApolloEngine;)V
    //   130: putfield 354	com/tencent/mobileqq/apollo/ApolloSurfaceView:mApolloWorker	Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;
    //   133: aload_0
    //   134: getfield 420	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   137: aload_0
    //   138: invokevirtual 553	com/tencent/mobileqq/apollo/ApolloRender:setRenderView	(Landroid/view/View;)V
    //   141: aload_0
    //   142: new 555	com/tencent/mobileqq/apollo/ApolloRenderInterfaceImpl
    //   145: dup
    //   146: aload_0
    //   147: getfield 354	com/tencent/mobileqq/apollo/ApolloSurfaceView:mApolloWorker	Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;
    //   150: aload_0
    //   151: getfield 420	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   154: invokespecial 558	com/tencent/mobileqq/apollo/ApolloRenderInterfaceImpl:<init>	(Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;Lcom/tencent/mobileqq/apollo/ApolloRender;)V
    //   157: putfield 435	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRenderImpl	Lcom/tencent/mobileqq/apollo/ApolloRenderInterfaceImpl;
    //   160: aload_0
    //   161: getfield 420	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   164: iload 4
    //   166: invokevirtual 561	com/tencent/mobileqq/apollo/ApolloRender:setOffscreen	(Z)V
    //   169: aload_0
    //   170: monitorexit
    //   171: return
    //   172: aload_0
    //   173: new 372	com/tencent/mobileqq/apollo/ApolloRender
    //   176: dup
    //   177: aload_0
    //   178: getfield 139	com/tencent/mobileqq/apollo/ApolloSurfaceView:mDensity	F
    //   181: aload_1
    //   182: iload_2
    //   183: invokespecial 564	com/tencent/mobileqq/apollo/ApolloRender:<init>	(FLcom/tencent/mobileqq/apollo/api/listener/OnApolloViewListener;I)V
    //   186: putfield 420	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   189: goto -104 -> 85
    //   192: astore_1
    //   193: ldc 12
    //   195: iconst_1
    //   196: new 162	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 566
    //   206: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_1
    //   210: invokevirtual 569	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   213: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: goto -53 -> 169
    //   225: astore_1
    //   226: aload_0
    //   227: monitorexit
    //   228: aload_1
    //   229: athrow
    //   230: astore_1
    //   231: ldc 12
    //   233: iconst_1
    //   234: new 162	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   241: ldc_w 571
    //   244: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_1
    //   248: invokevirtual 572	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   251: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 349	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: goto -91 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	ApolloSurfaceView
    //   0	263	1	paramOnApolloViewListener	OnApolloViewListener
    //   0	263	2	paramInt	int
    //   0	263	3	paramApolloRender	ApolloRender
    //   0	263	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   55	67	192	java/lang/OutOfMemoryError
    //   71	85	192	java/lang/OutOfMemoryError
    //   85	169	192	java/lang/OutOfMemoryError
    //   172	189	192	java/lang/OutOfMemoryError
    //   2	55	225	finally
    //   55	67	225	finally
    //   71	85	225	finally
    //   85	169	225	finally
    //   172	189	225	finally
    //   193	222	225	finally
    //   231	260	225	finally
    //   55	67	230	java/lang/Throwable
    //   71	85	230	java/lang/Throwable
    //   85	169	230	java/lang/Throwable
    //   172	189	230	java/lang/Throwable
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
  
  public boolean isOffscreen()
  {
    if (this.mRender != null) {
      return this.mRender.isOffscreen();
    }
    return false;
  }
  
  public native void nativeSetSurfaceView(ApolloSurfaceView paramApolloSurfaceView);
  
  public void onAttachedToWindow()
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
  
  public void onDetachedFromWindow()
  {
    this.mUIState.set(2);
    super.onDetachedFromWindow();
    this.mUIState.set(0);
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
      if (this.mGameId == 1000) {}
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
    runRenderTask(new ApolloSurfaceView.1(this, getRender()));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mCallbackRef == null) {}
    OnApolloViewListener localOnApolloViewListener;
    do
    {
      do
      {
        do
        {
          return false;
        } while ((this.mIsDestroy != null) && (this.mIsDestroy.get()));
        localOnApolloViewListener = (OnApolloViewListener)this.mCallbackRef.get();
      } while (localOnApolloViewListener == null);
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
      break label975;
      sendDownTouchNative(MotionEvent.obtain(paramMotionEvent));
      break label975;
      sendUpTouchToNative(MotionEvent.obtain(paramMotionEvent));
      break label975;
      sendUpTouchToNative(MotionEvent.obtain(paramMotionEvent));
      break label975;
      sendUpTouchToNative(MotionEvent.obtain(paramMotionEvent));
      break label975;
      if (super.getParent() != null) {
        super.getParent().requestDisallowInterceptTouchEvent(true);
      }
      sendMoveTouchToNative(MotionEvent.obtain(paramMotionEvent));
    }
    else
    {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        this.mDetectTouchMoved = false;
        this.mHasPerformedLongPress = false;
        this.mDisableParentIntercept = false;
        if (this.mPendingCheckForLongPress == null) {
          this.mPendingCheckForLongPress = new ApolloSurfaceView.CheckForLongPress(this);
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
          paramMotionEvent = ApolloUtilImpl.hitTest(f1, f2, this.mRender.mBoundingList);
          this.mNode = paramMotionEvent.jdField_a_of_type_Int;
          this.mApolloId = paramMotionEvent.jdField_a_of_type_JavaLangString;
        }
        if ((this.mNode >= 0) || (!TextUtils.isEmpty(this.mApolloId))) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
        if (this.mPendingCheckForLongPress != null) {
          super.removeCallbacks(this.mPendingCheckForLongPress);
        }
        if ((!this.mHasPerformedLongPress) && (!this.mDetectTouchMoved) && ((this.mNode >= 0) || (!TextUtils.isEmpty(this.mApolloId))))
        {
          Object localObject = BaseApplicationImpl.getApplication();
          if (localObject != null)
          {
            localObject = ((BaseApplicationImpl)localObject).getRuntime();
            if ((localObject instanceof QQAppInterface)) {
              localObject = (QQAppInterface)localObject;
            }
          }
          int i = 8;
          switch (this.mNode)
          {
          }
          for (;;)
          {
            localOnApolloViewListener.onNotifyStatusChanged(i, this.mApolloId);
            this.mApolloId = null;
            break;
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
          return true;
          if (this.mPendingCheckForLongPress != null) {
            super.removeCallbacks(this.mPendingCheckForLongPress);
          }
        }
      }
    }
    label975:
    return true;
  }
  
  public boolean performLongClick()
  {
    return super.performLongClick();
  }
  
  @Deprecated
  public void queueEvent(Runnable paramRunnable)
  {
    if ((paramRunnable instanceof IApolloRunnableTask))
    {
      if (this.mRender != null) {
        this.mRender.queueRenderTask((IApolloRunnableTask)paramRunnable);
      }
      for (;;)
      {
        requestRender();
        return;
        QLog.e("ApolloSurfaceView", 1, "queueEvent mRender== null");
      }
    }
    throw new RuntimeException("queueEvent r must instanceof IApolloRunnableTask");
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
  
  public void runRenderTask(IApolloRunnableTask paramIApolloRunnableTask)
  {
    if ((!this.mIsDestroy.get()) && (paramIApolloRunnableTask != null)) {
      queueEvent(paramIApolloRunnableTask);
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
  
  public void setGameStatListener(ApolloRenderDriver.GameStatListener paramGameStatListener)
  {
    if (this.mApolloWorker != null) {
      this.mApolloWorker.a(paramGameStatListener);
    }
  }
  
  public void setInitHeight(int paramInt)
  {
    this.mInitHeight = paramInt;
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
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, new Object[] { "surfaceChanged h:", Integer.valueOf(paramInt3) });
    }
    try
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (localObject == null) {
        break label173;
      }
      i = ((ApolloManagerServiceImpl)((AppRuntime)localObject).getRuntimeService(IApolloManagerService.class, "all")).queryApolloSwitchSet("surfaceChangeClose");
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject;
        QLog.e("ApolloSurfaceView", 1, "[onCreate] init error!", localThrowable);
        label173:
        int i = 0;
      }
      super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    }
    if (i == 0)
    {
      if ((this.mWidth != paramInt2) || (this.mHeight != paramInt3))
      {
        this.mWidth = paramInt2;
        this.mHeight = paramInt3;
        localObject = new ApolloSurfaceView.SurfaceCallBackData();
        ((ApolloSurfaceView.SurfaceCallBackData)localObject).jdField_a_of_type_Int = paramInt1;
        ((ApolloSurfaceView.SurfaceCallBackData)localObject).jdField_a_of_type_AndroidViewSurfaceHolder = paramSurfaceHolder;
        ((ApolloSurfaceView.SurfaceCallBackData)localObject).b = paramInt2;
        ((ApolloSurfaceView.SurfaceCallBackData)localObject).c = paramInt3;
        this.mSurfaceCallBackData = ((ApolloSurfaceView.SurfaceCallBackData)localObject);
        ThreadManagerV2.removeJobFromThreadPool(this.mSurfaceChangeRunnable, 16);
        ThreadManagerV2.excute(this.mSurfaceChangeRunnable, 16, null, false);
      }
      return;
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.mUIState.set(1);
    super.surfaceCreated(paramSurfaceHolder);
    this.mUIState.set(0);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.mUIState.set(3);
    super.surfaceDestroyed(paramSurfaceHolder);
    this.mUIState.set(0);
  }
  
  public void surfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder)
  {
    if ((Build.VERSION.SDK_INT == 24) || (Build.VERSION.SDK_INT == 25)) {
      if (this.mRender != null) {
        if (this.mRender.isDrawTaskRunning())
        {
          ThreadManagerV2.excute(new ApolloSurfaceView.5(this, paramSurfaceHolder), 16, null, false);
          QLog.i("ApolloSurfaceView", 1, "surfaceRedrawNeeded mRender.isDrawTaskRunning()");
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ApolloSurfaceView", 2, "surfaceRedrawNeeded width:" + getWidth() + " height:" + getHeight());
      }
      return;
      super.surfaceRedrawNeeded(paramSurfaceHolder);
      continue;
      super.surfaceRedrawNeeded(paramSurfaceHolder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloSurfaceView
 * JD-Core Version:    0.7.0.1
 */