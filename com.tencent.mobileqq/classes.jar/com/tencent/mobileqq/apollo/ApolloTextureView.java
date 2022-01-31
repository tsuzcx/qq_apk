package com.tencent.mobileqq.apollo;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.barrage.ApolloBarrageUtil;
import com.tencent.mobileqq.apollo.barrage.BarrageUI;
import com.tencent.mobileqq.apollo.data.ApolloSkeletonBounding;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import yjq;
import yjr;
import yjs;
import yjt;
import yju;
import yjv;
import ykj;

public class ApolloTextureView
  extends GLTextureView
  implements IApolloRenderView, ITriggerRenderCallback
{
  public static final String TAG = "ApolloTextureView";
  private ApolloSurfaceView.TouchEvent events = new ApolloSurfaceView.TouchEvent();
  private String mApolloId;
  protected ApolloRenderDriver mApolloWorker;
  private WeakReference mBarrageViewRef;
  private OnApolloViewListener mCallback;
  private float mDensity = super.getContext().getResources().getDisplayMetrics().density;
  private boolean mDetectTouchMoved;
  private boolean mDisableParentIntercept;
  private boolean mDisableTouchEvent;
  private boolean mDispatchEvent2native;
  private final byte[] mEngineLock = new byte[0];
  private final long mEngineWaitTime;
  private boolean mHasPerformedLongPress;
  public AtomicBoolean mIsDestroy;
  public boolean mIsDrawerView;
  private long mLastClickT;
  private MotionEvent mLastTouchEvent;
  private long mLongPressTimeout;
  public float mManHeight;
  private int mNode;
  private float mPX;
  private float mPY;
  private yjv mPendingCheckForLongPress = new yjv(this);
  public ApolloRender mRender;
  protected ApolloRenderInterfaceImpl mRenderImpl;
  private boolean mSendEventToNatived;
  private float mTouchDownX;
  private float mTouchDownY;
  private RectF mTouchableRect;
  
  @TargetApi(14)
  public ApolloTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setEGLContextClientVersion(2);
    super.setEGLConfigChooser(8, 8, 8, 8, 16, 8);
    super.setOpaque(false);
    this.mLongPressTimeout = ViewConfiguration.getLongPressTimeout();
    this.mIsDestroy = new AtomicBoolean(false);
    if (this.mDensity <= 0.0F) {}
    for (float f = 1.2F;; f = this.mDensity)
    {
      this.mEngineWaitTime = ((300.0F / f));
      if (QLog.isColorLevel()) {
        QLog.d("ApolloTextureView", 2, "[ApolloSurfaceView4Drawer] constructor");
      }
      return;
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
      queueEvent(new yjt(this, (float[])localObject, arrayOfFloat, arrayOfInt1, arrayOfInt2));
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
    queueEvent(new yjr(this, arrayOfFloat1, arrayOfFloat2, arrayOfInt1, arrayOfInt2));
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
        queueEvent(new yjs(this, arrayOfFloat1, arrayOfFloat2, arrayOfInt1, arrayOfInt2));
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
      BarrageUI localBarrageUI = (BarrageUI)this.mBarrageViewRef.get();
      if (localBarrageUI != null) {
        ApolloBarrageUtil.a(localBarrageUI, BaseApplicationImpl.getContext(), paramString1, paramString2, paramBoolean);
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
    for (float f = 0.0F; localIterator.hasNext(); f = Math.max(f, ((ApolloSkeletonBounding)localIterator.next()).d)) {}
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTextureView", 2, new Object[] { "[getManRectMaxHeight] height:", Float.valueOf(f) });
    }
    return f;
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
    if (this.mGLThread != null) {
      return this.mGLThread.getId();
    }
    return -1L;
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
      if (QLog.isColorLevel()) {
        QLog.d("ApolloTextureView", 2, "[init], callback:" + paramOnApolloViewListener + ",engineType:" + paramInt + ", sLoadEngineLibDone: " + ApolloEngine.a());
      }
      this.mCallback = paramOnApolloViewListener;
      this.mRender = new ApolloRender(this.mDensity, this.mCallback, paramInt);
      super.setEGLContextFactory(new yju(this, null));
      super.setRenderer(this.mRender);
      super.setRenderMode(0);
      this.mApolloWorker = new ApolloRenderDriver(this, this.mRender.getSavaWrapper());
      this.mRender.setRenderView(this);
      this.mRenderImpl = new ApolloRenderInterfaceImpl(this.mApolloWorker, this.mRender);
      return;
    }
    finally {}
  }
  
  public boolean isJsRuntime()
  {
    return true;
  }
  
  public native void nativeSetTextureView(ApolloTextureView paramApolloTextureView);
  
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
    ReentrantLock localReentrantLock = ApolloActionManager.a().a();
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
    queueEvent(new yjq(this));
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.d("sava", 2, "texture view onresume");
  }
  
  public void onRunInRenderThread(Runnable paramRunnable)
  {
    if ((!this.mIsDestroy.get()) && (paramRunnable != null)) {
      queueEvent(paramRunnable);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    if (this.mDisableTouchEvent) {}
    label103:
    float f1;
    float f2;
    Object localObject;
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
            this.mPendingCheckForLongPress = new yjv(this);
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
        localObject = ApolloUtil.a(f1, f2, this.mRender.mBoundingList);
        this.mNode = Integer.parseInt(localObject[0]);
        this.mApolloId = localObject[1];
        if ((isJsRuntime()) && ((this.mNode >= 0) || (!TextUtils.isEmpty(this.mApolloId))))
        {
          sendDownTouchNative(MotionEvent.obtain(paramMotionEvent));
          this.mSendEventToNatived = true;
        }
      }
      if (!this.mIsDrawerView) {
        break;
      }
      f3 = getWidth();
      f4 = getHeight();
    } while ((f3 > 0.0F) && (this.mManHeight > 0.0F) && (f4 > 0.0F) && (((f1 < f3 / 2.0F) && ((f2 < this.mManHeight) || (this.mNode != 1000))) || (f2 > 0.8F * f4)));
    boolean bool1 = bool2;
    if (this.mNode < 0) {
      if (TextUtils.isEmpty(this.mApolloId)) {
        break label617;
      }
    }
    label617:
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
    if (this.mPendingCheckForLongPress != null) {
      super.removeCallbacks(this.mPendingCheckForLongPress);
    }
    if ((this.mCallback != null) && (!this.mHasPerformedLongPress) && (!this.mDetectTouchMoved) && ((this.mNode >= 0) || (!TextUtils.isEmpty(this.mApolloId))))
    {
      localObject = BaseApplicationImpl.getApplication();
      if (localObject != null)
      {
        localObject = ((BaseApplicationImpl)localObject).getRuntime();
        if ((localObject instanceof QQAppInterface)) {
          localObject = (QQAppInterface)localObject;
        }
      }
      if (this.mNode != 1000) {
        break label790;
      }
      this.mCallback.onNotifyStatusChanged(7, this.mApolloId);
    }
    for (;;)
    {
      this.mApolloId = null;
      if ((this.mDispatchEvent2native) && (this.mSendEventToNatived) && (isJsRuntime()))
      {
        sendUpTouchToNative(MotionEvent.obtain(paramMotionEvent));
        if (QLog.isColorLevel()) {
          QLog.d("ApolloTextureView", 2, "apollo_drag_event_ MotionEvent.ACTION_UP");
        }
      }
      this.mSendEventToNatived = false;
      return false;
      label790:
      this.mCallback.onNotifyStatusChanged(8, this.mApolloId);
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
    if ((this.mDispatchEvent2native) && (this.mSendEventToNatived) && (isJsRuntime())) {
      sendMoveTouchToNative(MotionEvent.obtain(paramMotionEvent));
    }
    return true;
    if (this.mPendingCheckForLongPress != null) {
      super.removeCallbacks(this.mPendingCheckForLongPress);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTextureView", 2, "apollo_drag_event_ MotionEvent.ACTION_CANCEL,mSendEventToNatived:" + this.mSendEventToNatived);
    }
    if ((this.mDispatchEvent2native) && (this.mSendEventToNatived) && (isJsRuntime()))
    {
      if (this.mLastTouchEvent == null) {
        break label1051;
      }
      sendUpTouchToNative(this.mLastTouchEvent);
    }
    for (;;)
    {
      this.mSendEventToNatived = false;
      return false;
      label1051:
      sendUpTouchToNative(MotionEvent.obtain(paramMotionEvent));
    }
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
  
  public void setDispatchEvent2Native(boolean paramBoolean)
  {
    this.mDispatchEvent2native = paramBoolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloTextureView
 * JD-Core Version:    0.7.0.1
 */