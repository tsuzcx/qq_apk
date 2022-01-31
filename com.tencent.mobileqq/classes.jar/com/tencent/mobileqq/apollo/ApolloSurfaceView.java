package com.tencent.mobileqq.apollo;

import airx;
import aitj;
import aitk;
import aitr;
import aitt;
import aitu;
import aiuz;
import aivb;
import aivc;
import aiwa;
import aiwc;
import ajac;
import ajeq;
import ajfh;
import ajkj;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.opengl.GLSurfaceView;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ApolloSurfaceView
  extends GLSurfaceView
  implements aiuz, aivb
{
  public static final int INPUT_MARGIN = 10;
  private static final int MSG_CODE_SURFACECHANGED = 255;
  public static final String TAG = "ApolloSurfaceView";
  public static final int TOUCH_MODE_GAME = 1;
  public static final int TOUCH_MODE_NORMAL = 0;
  private static final int UI_STATE_DETACHFROMWINDOW = 2;
  private static final int UI_STATE_SURFACECREATE = 1;
  private static final int UI_STATE_SURFACEDESTROY = 3;
  private static Field sGLThreadField;
  private aitu events = new aitu();
  private boolean mAddPredrawListener;
  String mApolloId;
  public ApolloRenderDriver mApolloWorker;
  protected WeakReference<aiwc> mBarrageViewRef;
  private WeakReference<aivc> mCallbackRef;
  private boolean mCanDraw;
  private boolean mCloseGame;
  private float mDensity = super.getContext().getResources().getDisplayMetrics().density;
  private boolean mDetectTouchMoved;
  private boolean mDisableParentIntercept;
  private final byte[] mEngineLock = new byte[0];
  private long mEngineWaitTime;
  private int mGameId;
  private boolean mHasPerformedLongPress;
  private int mHeight;
  private int mInitHeight;
  public AtomicBoolean mIsDestroy = new AtomicBoolean(false);
  public boolean mIsGameReady;
  private MotionEvent mLastTouchEvent;
  private int mNode = -1;
  private float mPX;
  private float mPY;
  private ApolloSurfaceView.CheckForLongPress mPendingCheckForLongPress = new ApolloSurfaceView.CheckForLongPress(this);
  public ApolloRender mRender;
  protected aitk mRenderImpl;
  public int mRenderMode = 1;
  private long mRenderThreadId = -2147483648L;
  private boolean mSendEventToNatived;
  public aitt mSurfaceCallBackData;
  private Runnable mSurfaceChangeRunnable = new ApolloSurfaceView.6(this);
  private float mTouchDownX;
  private float mTouchDownY;
  private int mTouchMode = 0;
  private AtomicInteger mUIState = new AtomicInteger();
  private boolean mUpdateSurfaceDirect = true;
  private boolean mWaitGameDrawed;
  private int mWidth;
  public int uiOptions;
  
  public ApolloSurfaceView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet);
    super.setEGLContextClientVersion(2);
    int i = ApolloUtil.a();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, "ApolloSurfaceView MSAA_level:" + i);
    }
    if (i != 0) {
      if (1 == i)
      {
        super.setEGLConfigChooser(new aitr(4));
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
        if (this.mDensity > 0.0F) {
          break label340;
        }
      }
    }
    label340:
    for (float f = 1.2F;; f = this.mDensity)
    {
      this.mEngineWaitTime = ((300.0F / f));
      return;
      if (2 == i)
      {
        super.setEGLConfigChooser(new aitr(2));
        break;
      }
      super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
      break;
      super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
      break;
    }
  }
  
  public ApolloSurfaceView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramContext, paramAttributeSet);
    super.setEGLContextClientVersion(2);
    if (!paramBoolean2)
    {
      super.setEGLConfigChooser(8, 8, 8, 8, 16, 8);
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
      paramAttributeSet = BaseApplicationImpl.getApplication();
      if ((paramAttributeSet != null) && ((paramContext instanceof Activity)))
      {
        paramAttributeSet = paramAttributeSet.getRuntime();
        if ((paramAttributeSet instanceof QQAppInterface)) {
          ApolloCmdChannel.getChannel((QQAppInterface)paramAttributeSet).setActivityContext((Activity)paramContext);
        }
      }
      if (this.mDensity > 0.0F) {
        break label315;
      }
    }
    label315:
    for (float f = 1.2F;; f = this.mDensity)
    {
      this.mEngineWaitTime = ((300.0F / f));
      return;
      int i = ajac.e();
      if (1 == i)
      {
        super.setEGLConfigChooser(new aitr(4));
        break;
      }
      if (2 == i)
      {
        super.setEGLConfigChooser(new aitr(2));
        break;
      }
      super.setEGLConfigChooser(8, 8, 8, 8, 16, 8);
      break;
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
      ((aitu)localObject).jdField_a_of_type_Int += 1;
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
              aitu localaitu = this.events;
              localaitu.jdField_a_of_type_Int -= 1;
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
      aiwc localaiwc = (aiwc)this.mBarrageViewRef.get();
      if (localaiwc != null) {
        aiwa.a(localaiwc, BaseApplicationImpl.getContext(), paramString1, paramString2, paramBoolean);
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
  
  public aitk getRenderImpl()
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
  
  public void init(aivc paramaivc)
  {
    try
    {
      init(paramaivc, 0);
      return;
    }
    finally
    {
      paramaivc = finally;
      throw paramaivc;
    }
  }
  
  public void init(aivc paramaivc, int paramInt)
  {
    try
    {
      init(paramaivc, paramInt, null);
      return;
    }
    finally
    {
      paramaivc = finally;
      throw paramaivc;
    }
  }
  
  /* Error */
  public void init(aivc paramaivc, int paramInt, ApolloRender paramApolloRender)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +39 -> 44
    //   8: ldc 17
    //   10: iconst_2
    //   11: new 175	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 533
    //   21: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 512	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: ldc_w 535
    //   31: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_2
    //   35: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload_0
    //   45: new 418	java/lang/ref/WeakReference
    //   48: dup
    //   49: aload_1
    //   50: invokespecial 538	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   53: putfield 260	com/tencent/mobileqq/apollo/ApolloSurfaceView:mCallbackRef	Ljava/lang/ref/WeakReference;
    //   56: aload_3
    //   57: ifnull +95 -> 152
    //   60: aload_0
    //   61: aload_3
    //   62: putfield 446	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   65: ldc 17
    //   67: iconst_1
    //   68: ldc_w 540
    //   71: invokestatic 543	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_0
    //   75: new 545	aits
    //   78: dup
    //   79: aload_0
    //   80: aconst_null
    //   81: invokespecial 548	aits:<init>	(Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;Lcom/tencent/mobileqq/apollo/ApolloSurfaceView$1;)V
    //   84: invokespecial 552	android/opengl/GLSurfaceView:setEGLContextFactory	(Landroid/opengl/GLSurfaceView$EGLContextFactory;)V
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 446	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   92: invokespecial 556	android/opengl/GLSurfaceView:setRenderer	(Landroid/opengl/GLSurfaceView$Renderer;)V
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 91	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRenderMode	I
    //   100: invokespecial 559	android/opengl/GLSurfaceView:setRenderMode	(I)V
    //   103: aload_0
    //   104: new 382	com/tencent/mobileqq/apollo/ApolloRenderDriver
    //   107: dup
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 446	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   113: invokevirtual 402	com/tencent/mobileqq/apollo/ApolloRender:getSavaWrapper	()Lcom/tencent/mobileqq/apollo/ApolloEngine;
    //   116: invokespecial 562	com/tencent/mobileqq/apollo/ApolloRenderDriver:<init>	(Laivb;Lcom/tencent/mobileqq/apollo/ApolloEngine;)V
    //   119: putfield 380	com/tencent/mobileqq/apollo/ApolloSurfaceView:mApolloWorker	Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;
    //   122: aload_0
    //   123: getfield 446	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   126: aload_0
    //   127: invokevirtual 566	com/tencent/mobileqq/apollo/ApolloRender:setRenderView	(Landroid/view/View;)V
    //   130: aload_0
    //   131: new 568	aitk
    //   134: dup
    //   135: aload_0
    //   136: getfield 380	com/tencent/mobileqq/apollo/ApolloSurfaceView:mApolloWorker	Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;
    //   139: aload_0
    //   140: getfield 446	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   143: invokespecial 571	aitk:<init>	(Lcom/tencent/mobileqq/apollo/ApolloRenderDriver;Lcom/tencent/mobileqq/apollo/ApolloRender;)V
    //   146: putfield 457	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRenderImpl	Laitk;
    //   149: aload_0
    //   150: monitorexit
    //   151: return
    //   152: aload_0
    //   153: new 398	com/tencent/mobileqq/apollo/ApolloRender
    //   156: dup
    //   157: aload_0
    //   158: getfield 157	com/tencent/mobileqq/apollo/ApolloSurfaceView:mDensity	F
    //   161: aload_1
    //   162: iload_2
    //   163: invokespecial 574	com/tencent/mobileqq/apollo/ApolloRender:<init>	(FLaivc;I)V
    //   166: putfield 446	com/tencent/mobileqq/apollo/ApolloSurfaceView:mRender	Lcom/tencent/mobileqq/apollo/ApolloRender;
    //   169: goto -95 -> 74
    //   172: astore_1
    //   173: ldc 17
    //   175: iconst_1
    //   176: new 175	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 576
    //   186: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_1
    //   190: invokevirtual 579	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   193: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 375	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: goto -53 -> 149
    //   205: astore_1
    //   206: aload_0
    //   207: monitorexit
    //   208: aload_1
    //   209: athrow
    //   210: astore_1
    //   211: ldc 17
    //   213: iconst_1
    //   214: new 175	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   221: ldc_w 581
    //   224: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_1
    //   228: invokevirtual 582	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   231: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 375	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: goto -91 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	ApolloSurfaceView
    //   0	243	1	paramaivc	aivc
    //   0	243	2	paramInt	int
    //   0	243	3	paramApolloRender	ApolloRender
    // Exception table:
    //   from	to	target	type
    //   44	56	172	java/lang/OutOfMemoryError
    //   60	74	172	java/lang/OutOfMemoryError
    //   74	149	172	java/lang/OutOfMemoryError
    //   152	169	172	java/lang/OutOfMemoryError
    //   2	44	205	finally
    //   44	56	205	finally
    //   60	74	205	finally
    //   74	149	205	finally
    //   152	169	205	finally
    //   173	202	205	finally
    //   211	240	205	finally
    //   44	56	210	java/lang/Throwable
    //   60	74	210	java/lang/Throwable
    //   74	149	210	java/lang/Throwable
    //   152	169	210	java/lang/Throwable
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
  
  protected void onDetachedFromWindow()
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
      paramQQAppInterface = ajfh.a(paramQQAppInterface);
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
    ReentrantLock localReentrantLock = ajkj.a().a();
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
    aivc localaivc;
    do
    {
      do
      {
        do
        {
          return false;
        } while ((this.mIsDestroy != null) && (this.mIsDestroy.get()));
        localaivc = (aivc)this.mCallbackRef.get();
      } while (localaivc == null);
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
      break label946;
      sendDownTouchNative(MotionEvent.obtain(paramMotionEvent));
      break label946;
      sendUpTouchToNative(MotionEvent.obtain(paramMotionEvent));
      break label946;
      sendUpTouchToNative(MotionEvent.obtain(paramMotionEvent));
      break label946;
      sendUpTouchToNative(MotionEvent.obtain(paramMotionEvent));
      break label946;
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
      }
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        this.mDetectTouchMoved = false;
        this.mSendEventToNatived = false;
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
          paramMotionEvent = ApolloUtil.a(f1, f2, this.mRender.mBoundingList);
          this.mNode = Integer.parseInt(paramMotionEvent[0]);
          this.mApolloId = paramMotionEvent[1];
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
          if (this.mNode == 1000) {
            localaivc.onNotifyStatusChanged(7, this.mApolloId);
          }
          for (;;)
          {
            this.mApolloId = null;
            break;
            if (this.mNode == 2) {
              localaivc.onNotifyStatusChanged(9, this.mApolloId);
            } else {
              localaivc.onNotifyStatusChanged(8, this.mApolloId);
            }
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
    label946:
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
      aiwc localaiwc = (aiwc)this.mBarrageViewRef.get();
      if (localaiwc != null) {
        localaiwc.a(paramBoolean);
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
  
  public void setBarrageView(aiwc paramaiwc)
  {
    this.mBarrageViewRef = new WeakReference(paramaiwc);
  }
  
  public void setBubbleType(int paramInt)
  {
    if (this.mRender != null) {
      this.mRender.setBubbleType(paramInt);
    }
  }
  
  public void setCanDraw(boolean paramBoolean)
  {
    this.mCanDraw = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloSurfaceView", 2, new Object[] { "setCanDraw canDraw:", Boolean.valueOf(paramBoolean) });
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
  
  public void setGameStatListener(aitj paramaitj)
  {
    if (this.mApolloWorker != null) {
      this.mApolloWorker.a(paramaitj);
    }
  }
  
  public void setInitHeight(int paramInt)
  {
    this.mInitHeight = paramInt;
  }
  
  public void setMainLoadingGameMode(boolean paramBoolean)
  {
    this.mWaitGameDrawed = paramBoolean;
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
    if (airx.c("surfaceChangeClose") == 0)
    {
      if ((this.mWidth != paramInt2) || (this.mHeight != paramInt3))
      {
        this.mWidth = paramInt2;
        this.mHeight = paramInt3;
        aitt localaitt = new aitt();
        localaitt.jdField_a_of_type_Int = paramInt1;
        localaitt.jdField_a_of_type_AndroidViewSurfaceHolder = paramSurfaceHolder;
        localaitt.b = paramInt2;
        localaitt.c = paramInt3;
        this.mSurfaceCallBackData = localaitt;
        ThreadManagerV2.removeJobFromThreadPool(this.mSurfaceChangeRunnable, 16);
        ThreadManagerV2.excute(this.mSurfaceChangeRunnable, 16, null, false);
      }
      return;
    }
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloSurfaceView
 * JD-Core Version:    0.7.0.1
 */