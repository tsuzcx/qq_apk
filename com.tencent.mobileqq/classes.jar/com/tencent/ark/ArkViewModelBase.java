package com.tencent.ark;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;

public class ArkViewModelBase
  implements ArkVsync.ArkFrameCallback, ark.ContainerCallback
{
  public static final int APP_CREATE_FAILED = 104;
  public static final int APP_CREATE_ROOTVIEW_FAILED = 105;
  public static final int APP_JSCORE_NOT_LOADED = 107;
  public static final int APP_LOAD_APPLICATION_FAILED = 106;
  public static final int APP_LOAD_FAILED = 101;
  public static final int APP_LOAD_SUCCESS = 100;
  public static final int APP_RUN_FAILED = 102;
  public static final int APP_VIEW_IMPL_EMPTY = 103;
  public static final int ARKAPP_TYPE_DESTROY = 2;
  public static final int ARKAPP_TYPE_PAUSE = 0;
  public static final int ARKAPP_TYPE_RELOAD = 3;
  public static final int ARKAPP_TYPE_RESUME = 1;
  protected static final ArkEnvironmentManager ENV = ;
  protected static final String KEY_FORMAT = "%s_%s";
  protected static final String TAG = "ArkApp.ArkViewModelBase";
  protected static boolean sAppInit = false;
  protected static HashMap<String, ArkViewModelBase.Size> sAppSizeHint = new HashMap(8);
  protected ark.ApplicationCallback mAppCallback;
  public ArkViewModelBase.AppInfo mAppInfo = new ArkViewModelBase.AppInfo();
  protected int mAppScriptType = 0;
  protected ark.Application mApplication;
  protected volatile boolean mAttached = false;
  protected ark.Container mContainer;
  protected int mDrawCount = 0;
  public ArkViewModelBase.ErrorInfo mErrorInfo = new ArkViewModelBase.ErrorInfo();
  protected boolean mFirstDraw = true;
  protected boolean mHasLoaded = false;
  protected boolean mInActivateStatus = true;
  protected boolean mInSyncRect = false;
  protected boolean mInit = false;
  protected volatile boolean mIsActivated = true;
  protected volatile boolean mIsForeground = true;
  protected boolean mIsGpuRendering = false;
  protected volatile boolean mIsVisible = true;
  protected boolean mLoadFailed = false;
  protected boolean mNeedFirstPaint = false;
  protected boolean mPerfTaskRunning = false;
  private Runnable mPostInvalid = new ArkViewModelBase.15(this);
  protected Runnable mPostRedraw = new ArkViewModelBase.14(this);
  protected String mQueueKey;
  protected Rect mRectArkContainer = new Rect();
  protected Rect mRectContainer = new Rect();
  protected RectF mRectContainerF = new RectF();
  protected RectF mRectInvalidF = new RectF();
  protected boolean mRoundCorner = false;
  protected volatile boolean mSyncRectLock = false;
  protected ArkViewModelBase.TimeRecord mTimeRecord = new ArkViewModelBase.TimeRecord();
  public ArkViewImplement mViewImpl;
  
  public ArkViewModelBase(ark.ApplicationCallback paramApplicationCallback)
  {
    this.mAppCallback = paramApplicationCallback;
  }
  
  public static void clearArkHttpProxy()
  {
    if (ENV.isLibraryLoad()) {
      ark.arkHTTPSetDefaultHttpProxy("", 0);
    }
  }
  
  public static Rect convertRect(RectF paramRectF)
  {
    Rect localRect = new Rect();
    localRect.left = ((int)paramRectF.left);
    localRect.top = ((int)paramRectF.top);
    localRect.right = ((int)Math.ceil(paramRectF.right));
    localRect.bottom = ((int)Math.ceil(paramRectF.bottom));
    return localRect;
  }
  
  public static Rect descaleRect(Rect paramRect, float paramFloat)
  {
    if (paramRect == null) {
      return null;
    }
    Rect localRect = new Rect();
    localRect.left = ((int)Math.ceil(paramRect.left / paramFloat));
    localRect.top = ((int)Math.ceil(paramRect.top / paramFloat));
    localRect.right = ((int)(paramRect.right / paramFloat));
    localRect.bottom = ((int)(paramRect.bottom / paramFloat));
    return localRect;
  }
  
  private void reportPerfStat()
  {
    if ((this.mAppInfo != null) && (this.mAppInfo.name != null) && (this.mAppInfo.view != null)) {
      ArkPerfMonitor.getInstance().doReport(this.mAppInfo.name, this.mAppInfo.view, new ArkViewModelBase.9(this));
    }
  }
  
  public static Rect scaleRect(Rect paramRect, float paramFloat)
  {
    if (paramRect == null) {
      return null;
    }
    Rect localRect = new Rect();
    localRect.left = ((int)(paramRect.left * paramFloat));
    localRect.top = ((int)(paramRect.top * paramFloat));
    localRect.right = ((int)Math.ceil(paramRect.right * paramFloat));
    localRect.bottom = ((int)Math.ceil(paramRect.bottom * paramFloat));
    return localRect;
  }
  
  public static void setArkHttpProxy()
  {
    String str;
    int i;
    if (ENV.isLibraryLoad())
    {
      str = ENV.getProxyHost();
      i = ENV.getProxyPort();
      if ((!TextUtils.isEmpty(str)) && (i != 0)) {
        break label70;
      }
      ark.arkHTTPSetDefaultHttpProxy("", 0);
    }
    for (;;)
    {
      ENV.logI("ArkApp.ArkViewModelBase", String.format("setArkHttpProxy, host=%s, port=%d", new Object[] { str, Integer.valueOf(i) }));
      return;
      label70:
      ark.arkHTTPSetDefaultHttpProxy(str, i);
    }
  }
  
  public int GetAppScriptType()
  {
    return this.mAppScriptType;
  }
  
  public boolean InputCanRedo()
  {
    if (this.mContainer != null) {
      return this.mContainer.InputCanRedo();
    }
    return false;
  }
  
  public boolean InputCanUndo()
  {
    if (this.mContainer != null) {
      return this.mContainer.InputCanUndo();
    }
    return false;
  }
  
  public boolean InputDeleteBackward()
  {
    if (this.mContainer != null) {
      return this.mContainer.InputDeleteBackward();
    }
    return false;
  }
  
  public void InputFocusChanged(boolean paramBoolean1, boolean paramBoolean2, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    ArkViewImplement localArkViewImplement = this.mViewImpl;
    if (localArkViewImplement == null) {
      return;
    }
    Rect localRect = new Rect((int)paramFloat1, (int)paramFloat2, (int)paramFloat3, (int)paramFloat4);
    ArkDispatchTask.getInstance().postToMainThread(new ArkViewModelBase.18(this, localArkViewImplement, paramBoolean1, paramBoolean2, paramInt, localRect));
  }
  
  public String InputGetSelectText()
  {
    if (this.mContainer != null) {
      return this.mContainer.InputGetSelectText();
    }
    return null;
  }
  
  public boolean InputInsertText(String paramString)
  {
    if (this.mContainer != null) {
      return this.mContainer.InputInsertText(paramString);
    }
    return false;
  }
  
  public boolean InputIsFocused()
  {
    if (this.mContainer != null) {
      return this.mContainer.InputIsFocused();
    }
    return false;
  }
  
  public void InputMenuChanged(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ArkViewImplement localArkViewImplement = this.mViewImpl;
    if (localArkViewImplement == null) {
      return;
    }
    paramInt1 = (int)(paramInt1 * this.mAppInfo.scale);
    paramInt2 = (int)(paramInt2 * this.mAppInfo.scale);
    paramInt3 = (int)(paramInt3 * this.mAppInfo.scale);
    ArkDispatchTask.getInstance().postToMainThread(new ArkViewModelBase.19(this, localArkViewImplement, paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public boolean InputRedo()
  {
    if (this.mContainer != null) {
      return this.mContainer.InputRedo();
    }
    return false;
  }
  
  public boolean InputSelect()
  {
    if (this.mContainer != null) {
      return this.mContainer.InputSelect();
    }
    return false;
  }
  
  public boolean InputSelectAll()
  {
    if (this.mContainer != null) {
      return this.mContainer.InputSelectAll();
    }
    return false;
  }
  
  public void InputSelectChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    ArkViewImplement localArkViewImplement = this.mViewImpl;
    if (localArkViewImplement == null) {
      return;
    }
    Rect localRect = new Rect((int)paramFloat1, (int)paramFloat2, (int)paramFloat3, (int)paramFloat4);
    paramInt1 = (int)(paramInt1 * this.mAppInfo.scale);
    paramInt2 = (int)(paramInt2 * this.mAppInfo.scale);
    paramInt3 = (int)(paramInt3 * this.mAppInfo.scale);
    paramInt4 = (int)(paramInt4 * this.mAppInfo.scale);
    ArkDispatchTask.getInstance().postToMainThread(new ArkViewModelBase.20(this, localArkViewImplement, paramInt1, paramInt2, paramInt3, paramInt4, localRect));
  }
  
  public boolean InputSetCaretHolderSize(int paramInt1, int paramInt2)
  {
    if (this.mContainer != null)
    {
      paramInt1 = (int)(paramInt1 / this.mAppInfo.scale);
      paramInt2 = (int)(paramInt2 / this.mAppInfo.scale);
      return this.mContainer.InputSetCaretHolderSize(paramInt1, paramInt2);
    }
    return false;
  }
  
  public boolean InputSetSelectHolderSize(int paramInt1, int paramInt2)
  {
    if (this.mContainer != null)
    {
      paramInt1 = (int)(paramInt1 / this.mAppInfo.scale);
      paramInt2 = (int)(paramInt2 / this.mAppInfo.scale);
      return this.mContainer.InputSetSelectHolderSize(paramInt1, paramInt2);
    }
    return false;
  }
  
  public boolean InputUndo()
  {
    if (this.mContainer != null) {
      return this.mContainer.InputUndo();
    }
    return false;
  }
  
  public void SafeAsyncRun(Runnable paramRunnable)
  {
    if ((!this.mInit) && (TextUtils.isEmpty(this.mQueueKey)))
    {
      ENV.logE("ArkApp.ArkViewModelBase", "SafeAsyncRun mInit == false && mQueueKey == null ");
      return;
    }
    try
    {
      ArkDispatchQueue.asyncRun(this.mQueueKey, paramRunnable);
      return;
    }
    catch (UnsatisfiedLinkError paramRunnable)
    {
      ENV.logE("ArkApp.ArkViewModelBase", String.format("SafeAsyncRun, exception=%s", new Object[] { paramRunnable.getMessage() }));
    }
  }
  
  public void SafeAsyncRunDelay(Runnable paramRunnable, long paramLong)
  {
    if ((!this.mInit) && (TextUtils.isEmpty(this.mQueueKey)))
    {
      ENV.logE("ArkApp.ArkViewModelBase", "SafeAsyncRun mInit == false && mQueueKey == null ");
      return;
    }
    try
    {
      ArkDispatchQueue.asyncRun(this.mQueueKey, paramRunnable, paramLong);
      return;
    }
    catch (UnsatisfiedLinkError paramRunnable)
    {
      ENV.logE("ArkApp.ArkViewModelBase", String.format("SafeAsyncRun, exception=%s", new Object[] { paramRunnable.getMessage() }));
    }
  }
  
  public void SyncRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mRectContainerF.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    this.mRectArkContainer = convertRect(this.mRectContainerF);
    ArkViewImplement localArkViewImplement = this.mViewImpl;
    if ((this.mSyncRectLock) || (localArkViewImplement == null)) {
      if (localArkViewImplement == null) {
        ENV.logWithLimit("SyncRect.1.rect", "ArkApp.ArkViewModelBase", String.format("SyncRect.1.rect: %s, this.%h has return incorrect.", new Object[] { this.mRectArkContainer.toString(), this }));
      }
    }
    do
    {
      return;
      if (!this.mInSyncRect) {
        break;
      }
    } while (notInSizeRange(this.mRectArkContainer.width(), this.mRectArkContainer.height()));
    this.mRectContainer = this.mRectArkContainer;
    return;
    this.mInSyncRect = true;
    if (notInSizeRange(this.mRectArkContainer.width(), this.mRectArkContainer.height()))
    {
      ArkViewModelBase.Size localSize = limitToSizeRange(this.mRectArkContainer.width(), this.mRectArkContainer.height());
      this.mRectContainer.set(0, 0, localSize.width, localSize.height);
    }
    for (;;)
    {
      this.mContainer.SetSize(this.mRectContainer.width(), this.mRectContainer.height());
      this.mInSyncRect = false;
      createDrawTarget(localArkViewImplement);
      ArkDispatchTask.getInstance().postToMainThread(new ArkViewModelBase.17(this, localArkViewImplement));
      return;
      this.mRectContainer = this.mRectArkContainer;
    }
  }
  
  public void Update(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (this.mSyncRectLock) {
      return;
    }
    this.mRectInvalidF.union(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    this.mRectInvalidF.intersect(this.mRectContainerF);
  }
  
  public void activateView(boolean paramBoolean)
  {
    if (this.mIsActivated == paramBoolean) {
      return;
    }
    this.mIsActivated = paramBoolean;
    int i = 0;
    if (!paramBoolean) {
      i = 200;
    }
    SafeAsyncRunDelay(new ArkViewModelBase.13(this, paramBoolean), i);
  }
  
  protected void applicationCreate(ark.Application paramApplication) {}
  
  protected void applicationRelease(ark.Application paramApplication) {}
  
  public boolean attachView(ArkViewImplement paramArkViewImplement)
  {
    this.mAttached = true;
    ENV.logI("ArkApp.ArkViewModelBase", String.format("attachView.1.this.%h", new Object[] { this }));
    if ((this.mViewImpl != null) && (this.mViewImpl != paramArkViewImplement))
    {
      this.mViewImpl.doDetach(this);
      this.mViewImpl = null;
    }
    return initArkContainer(paramArkViewImplement);
  }
  
  protected void beforeContainerCreate() {}
  
  protected void beginDraw()
  {
    if (this.mFirstDraw) {
      this.mTimeRecord.beginOfFirstDraw = System.currentTimeMillis();
    }
    int i = this.mDrawCount + 1;
    this.mDrawCount = i;
    if (i % 2 == 0) {
      runPerfStat();
    }
  }
  
  protected void changeContainerActivateStatus()
  {
    boolean bool2 = this.mInActivateStatus;
    if ((this.mIsActivated) && (this.mIsForeground) && (this.mIsVisible)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.mInActivateStatus = bool1;
      ENV.logI("ArkApp.ArkViewModelBase", String.format("changeContainerActivateStatus, this=%h, app=%s, container=%h, mInActivateStatus=%s, oldActivateStatus=%s", new Object[] { this, this.mAppInfo.name, this.mContainer, Boolean.toString(this.mInActivateStatus), Boolean.toString(bool2) }));
      if (this.mContainer != null) {
        break;
      }
      ENV.logE("ArkApp.ArkViewModelBase", "changeContainerActivateStatus error mContainer == null");
      return;
    }
    if (this.mInActivateStatus)
    {
      invalidateRect();
      if (this.mInActivateStatus != bool2) {
        this.mContainer.ActivateRootView();
      }
      ArkVsync.getInstance().addFrameCallback(getQueueKey(), this);
      this.mPostRedraw.run();
      return;
    }
    if (this.mInActivateStatus != bool2) {
      this.mContainer.DeactivateRootView();
    }
    ArkVsync.getInstance().removeFrameCallback(this);
  }
  
  public boolean checkShare()
  {
    if (this.mContainer == null) {
      return false;
    }
    return this.mContainer.CheckShare();
  }
  
  public void createDrawTarget(ArkViewImplement paramArkViewImplement)
  {
    this.mTimeRecord.beginOfCreateDrawTarget = System.currentTimeMillis();
    paramArkViewImplement = paramArkViewImplement.recreateBitmapBuffer(this.mRectContainer);
    if (paramArkViewImplement != null) {
      if (this.mContainer != null)
      {
        if (this.mApplication != null) {
          this.mApplication.IncreaseGraphicMemSize(paramArkViewImplement.getWidth() * paramArkViewImplement.getHeight() * 4 * 2);
        }
        this.mContainer.DetachBitmap(null);
        if (!this.mContainer.AttachBitmap(paramArkViewImplement)) {
          ENV.logE("ArkApp.ArkViewModelBase", String.format("createDrawTarget.1.rect.%s.this.%h.attach.failed", new Object[] { this.mRectContainer.toString(), this }));
        }
        this.mRectInvalidF.set(this.mRectContainerF);
      }
    }
    for (;;)
    {
      this.mTimeRecord.endOfCreateDrawTarget = System.currentTimeMillis();
      return;
      ENV.logE("ArkApp.ArkViewModelBase", String.format("createDrawTarget.2.rect.%s.this.%h.bmp.null", new Object[] { this.mRectContainer.toString(), this }));
    }
  }
  
  public Rect descaleRect(Rect paramRect)
  {
    return descaleRect(paramRect, this.mAppInfo.scale);
  }
  
  protected void destroy()
  {
    ENV.logD("ArkApp.ArkViewModelBase", String.format("ArkViewModelBase.destroy", new Object[0]));
    reportPerfStat();
    if (this.mViewImpl != null) {
      this.mViewImpl.onDestroy();
    }
    SafeAsyncRun(new ArkViewModelBase.10(this));
    detachView();
    SafeAsyncRun(new ArkViewModelBase.11(this));
    String str = this.mAppInfo.name;
    ENV.logI("ArkApp.ArkViewModelBase", String.format("destroy. this.%h,and.delay to release preloadApp:%s", new Object[] { this, str }));
    if (ArkAppPreloader.isAppPreloaded(str)) {
      SafeAsyncRunDelay(new ArkViewModelBase.12(this, str), 5000L);
    }
    this.mInit = false;
    this.mAppInfo.canceled = true;
    this.mLoadFailed = false;
  }
  
  public void destroyDrawTarget()
  {
    ENV.logD("ArkApp.ArkViewModelBase", String.format("ArkViewModelBase.destroyDrawTarget", new Object[0]));
    if (this.mContainer != null) {
      this.mContainer.DetachBitmap(null);
    }
  }
  
  public void detachView()
  {
    ENV.logI("ArkApp.ArkViewModelBase", String.format("ArkViewModelBase.detachView.mViewImpl=%h.app.%s", new Object[] { this.mViewImpl, this.mAppInfo.name }));
    this.mAttached = false;
    if (this.mViewImpl != null)
    {
      this.mViewImpl.doDetach(this);
      this.mViewImpl = null;
    }
    activateView(false);
    ENV.logI("ArkApp.ArkViewModelBase", String.format("detachView.1.this.%h.app.%s", new Object[] { this, this.mAppInfo.name }));
    SafeAsyncRun(new ArkViewModelBase.4(this));
  }
  
  protected void didFirstPaint()
  {
    if (this.mViewImpl == null) {}
    ArkViewImplement localArkViewImplement;
    do
    {
      return;
      localArkViewImplement = this.mViewImpl;
    } while (!this.mNeedFirstPaint);
    ArkDispatchTask.getInstance().postToMainThread(new ArkViewModelBase.21(this, localArkViewImplement));
    this.mNeedFirstPaint = false;
  }
  
  public void doFrame()
  {
    ArkViewImplement localArkViewImplement = this.mViewImpl;
    if ((localArkViewImplement == null) || (this.mRectInvalidF.isEmpty()) || (this.mSyncRectLock) || (!this.mAttached)) {}
    do
    {
      do
      {
        return;
      } while (localArkViewImplement.getBitmapBuffer() == null);
      beginDraw();
    } while (!this.mContainer.Paint(this.mRectInvalidF.left, this.mRectInvalidF.top, this.mRectInvalidF.right, this.mRectInvalidF.bottom));
    localArkViewImplement.mOpaque = this.mContainer.GetViewOpaque();
    localArkViewImplement.onInvalidate(convertRect(this.mRectInvalidF));
    this.mRectInvalidF.setEmpty();
    endDraw();
    didFirstPaint();
  }
  
  protected void doLoadArkApp(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString5)
  {
    ArkViewModelBase.AppInfo localAppInfo = this.mAppInfo;
    localAppInfo.path = paramString1;
    this.mLoadFailed = false;
    this.mHasLoaded = false;
    ENV.logD("ArkApp.ArkViewModelBase", String.format("doLoadArkApp.enter.this.%h", new Object[] { this }));
    if ((paramBoolean1) || (localAppInfo.canceled))
    {
      this.mLoadFailed = true;
      this.mInit = false;
      this.mErrorInfo.msg = paramString5;
      this.mErrorInfo.retCode = paramInt;
      this.mErrorInfo.canRetry = paramBoolean2;
      if (ArkDispatchTask.getInstance().isMainThread())
      {
        paramString1 = this.mViewImpl;
        if (paramString1 != null) {
          paramString1.onLoadFailed(this.mErrorInfo.msg, this.mErrorInfo.retCode, this.mErrorInfo.canRetry);
        }
        paramString1 = ENV;
        paramBoolean2 = this.mLoadFailed;
        if ((localAppInfo == null) || (!localAppInfo.canceled)) {
          break label219;
        }
      }
      label219:
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        paramString1.logI("ArkApp.ArkViewModelBase", String.format("doLoadArkApp.Failed.mLoadFailed.%b.info.canceled.%b", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) }));
        onLoadReport(101);
        return;
        ArkDispatchTask.getInstance().postToMainThread(new ArkViewModelBase.2(this));
        break;
      }
    }
    if (ENV.mIsDebug) {
      ENV.logD("ArkApp.ArkViewModelBase", String.format("doLoadArkApp.beginOfDisplyView.this.%h.queueKey=%s", new Object[] { this, this.mQueueKey }));
    }
    this.mTimeRecord.beginOfDisplyView = System.currentTimeMillis();
    SafeAsyncRun(new ArkViewModelBase.3(this, localAppInfo, paramString3, paramString2, paramString4, getViewId()));
    ENV.logD("ArkApp.ArkViewModelBase", String.format("doLoadArkApp.leave.this.%h", new Object[] { this }));
  }
  
  public void doOnEvent(int paramInt)
  {
    if (paramInt == 0) {
      if (this.mHasLoaded) {
        SafeAsyncRun(new ArkViewModelBase.7(this));
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt != 1) {
          break;
        }
      } while (!this.mHasLoaded);
      SafeAsyncRun(new ArkViewModelBase.8(this));
      return;
      if (paramInt == 2)
      {
        destroy();
        return;
      }
    } while ((paramInt != 3) || (this.mAppScriptType != 2));
    this.mErrorInfo.retCode = -1;
    reinitArkContainer();
  }
  
  protected void endDraw()
  {
    if (this.mFirstDraw)
    {
      this.mTimeRecord.endOfFirstDraw = System.currentTimeMillis();
      this.mFirstDraw = false;
      onFirstDrawEnd();
    }
  }
  
  public String getAppName()
  {
    return this.mAppInfo.name;
  }
  
  public ark.Container getContainer()
  {
    return this.mContainer;
  }
  
  public Rect getContainerRect()
  {
    return this.mRectContainer;
  }
  
  public ArkViewModelBase.ErrorInfo getErrorInfo()
  {
    return this.mErrorInfo;
  }
  
  public int getHeight()
  {
    if (!this.mRectContainer.isEmpty()) {
      return this.mRectContainer.height();
    }
    synchronized (sAppSizeHint)
    {
      ArkViewModelBase.Size localSize = (ArkViewModelBase.Size)sAppSizeHint.get(String.format("%s_%s", new Object[] { this.mAppInfo.path, this.mAppInfo.view }));
      if (localSize != null)
      {
        int i = localSize.height;
        return i;
      }
    }
    if (this.mAppInfo.height > 0) {
      return this.mAppInfo.height;
    }
    return this.mAppInfo.hintHeight;
  }
  
  public String getQueueKey()
  {
    return this.mQueueKey;
  }
  
  public float getScale()
  {
    return this.mAppInfo.scale;
  }
  
  public boolean getShowRoundCorner()
  {
    return this.mRoundCorner;
  }
  
  public long getViewHandle()
  {
    if (this.mContainer != null) {
      return this.mContainer.GetViewHandle();
    }
    return 0L;
  }
  
  public String getViewId()
  {
    return null;
  }
  
  public String getViewShare()
  {
    if (this.mContainer == null) {
      return null;
    }
    return this.mContainer.GetViewShare();
  }
  
  public int getWidth()
  {
    if (!this.mRectContainer.isEmpty()) {
      return this.mRectContainer.width();
    }
    synchronized (sAppSizeHint)
    {
      ArkViewModelBase.Size localSize = (ArkViewModelBase.Size)sAppSizeHint.get(String.format("%s_%s", new Object[] { this.mAppInfo.path, this.mAppInfo.view }));
      if (localSize != null)
      {
        int i = localSize.width;
        return i;
      }
    }
    if (this.mAppInfo.width > 0) {
      return this.mAppInfo.width;
    }
    return this.mAppInfo.hintWidth;
  }
  
  public boolean init(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, float paramFloat)
  {
    if ((paramString1 == null) || (paramString2 == null))
    {
      ENV.logD("ArkApp.ArkViewModelBase", "init got null app name and viewImpl name.");
      return false;
    }
    this.mQueueKey = paramString1;
    if ((this.mLoadFailed) || (this.mQueueKey == null))
    {
      paramString1 = this.mViewImpl;
      if (paramString1 != null) {
        paramString1.onLoadFailed(this.mErrorInfo.msg, this.mErrorInfo.retCode, this.mErrorInfo.canRetry);
      }
      ENV.logI("ArkApp.ArkViewModelBase", String.format("init mLoadFailed true!!! viewModel: %h.", new Object[] { this }));
      return true;
    }
    if ((!paramString1.equals(this.mAppInfo.name)) || (!paramString2.equals(this.mAppInfo.view)) || (Math.abs(paramFloat - this.mAppInfo.scale) >= 1.E-005D)) {
      this.mInit = false;
    }
    if (this.mInit)
    {
      ENV.logD("ArkApp.ArkViewModelBase", String.format("init mInit is true!!! viewModel: %h.", new Object[] { this }));
      return true;
    }
    ENV.logI("ArkApp.ArkViewModelBase", String.format("init app:%s, appView=%s, scale=%f, appMinVersion=%s, viewModel: %h.", new Object[] { paramString1, paramString2, Float.valueOf(paramFloat), paramString3, this }));
    this.mAppInfo.scale = paramFloat;
    this.mAppInfo.name = paramString1;
    this.mAppInfo.view = paramString2;
    this.mAppInfo.meta = paramString4;
    this.mAppInfo.appConfig = paramString5;
    this.mAppInfo.appMinVersion = paramString3;
    this.mAppInfo.canceled = false;
    this.mTimeRecord.appName = paramString1;
    this.mTimeRecord.view = paramString2;
    return true;
  }
  
  protected boolean initArkContainer(ArkViewImplement paramArkViewImplement)
  {
    ENV.logI("ArkApp.ArkViewModelBase", String.format("initArkContainer.0.viewModel: %h, container:%h", new Object[] { this, this.mContainer }));
    this.mViewImpl = paramArkViewImplement;
    if (this.mLoadFailed)
    {
      if (this.mViewImpl != null) {
        this.mViewImpl.onLoadFailed(this.mErrorInfo.msg, this.mErrorInfo.retCode, this.mErrorInfo.canRetry);
      }
      ENV.logI("ArkApp.ArkViewModelBase", String.format("initArkContainer.mLoadFailed.true!.viewModel: %h.", new Object[] { this }));
      return true;
    }
    this.mViewImpl.mViewInterface.createViewContext();
    if (this.mInit)
    {
      SafeAsyncRun(new ArkViewModelBase.1(this));
      activateView(true);
      ENV.logI("ArkApp.ArkViewModelBase", String.format("init.finished.and.mInit.true!.viewModel: %h.", new Object[] { this }));
      return true;
    }
    this.mInit = true;
    return onLoadApp(this.mAppInfo);
  }
  
  protected void initLibrary() {}
  
  public void invalidateRect()
  {
    this.mRectInvalidF.set(this.mRectContainerF);
  }
  
  protected ArkViewModelBase.Size limitToSizeRange(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (this.mAppInfo.minWidth > 0)
    {
      i = paramInt1;
      if (paramInt1 < this.mAppInfo.minWidth) {
        i = this.mAppInfo.minWidth;
      }
    }
    paramInt1 = paramInt2;
    if (this.mAppInfo.minHeight > 0)
    {
      paramInt1 = paramInt2;
      if (paramInt2 < this.mAppInfo.minHeight) {
        paramInt1 = this.mAppInfo.minHeight;
      }
    }
    paramInt2 = i;
    if (this.mAppInfo.maxWidth > 0)
    {
      paramInt2 = i;
      if (i > this.mAppInfo.maxWidth) {
        paramInt2 = this.mAppInfo.maxWidth;
      }
    }
    i = paramInt1;
    if (this.mAppInfo.maxHeight > 0)
    {
      i = paramInt1;
      if (paramInt1 > this.mAppInfo.maxHeight) {
        i = this.mAppInfo.maxHeight;
      }
    }
    return new ArkViewModelBase.Size(paramInt2, i);
  }
  
  protected boolean notInSizeRange(int paramInt1, int paramInt2)
  {
    if (((this.mAppInfo.minWidth > 0) && (paramInt1 < this.mAppInfo.minWidth)) || ((this.mAppInfo.minHeight > 0) && (paramInt2 < this.mAppInfo.minHeight))) {}
    while (((this.mAppInfo.maxWidth > 0) && (paramInt1 > this.mAppInfo.maxWidth)) || ((this.mAppInfo.maxHeight > 0) && (paramInt2 > this.mAppInfo.maxHeight))) {
      return true;
    }
    return false;
  }
  
  protected void onAppDisplay(ArkViewModelBase.TimeRecord paramTimeRecord) {}
  
  protected void onFirstDrawEnd()
  {
    if (ENV.mShowProfilingLog) {
      if (this.mAppInfo == null) {
        break label423;
      }
    }
    label423:
    for (String str = this.mAppInfo.name;; str = "")
    {
      ENV.logI("ArkApp.ArkViewModelBase", String.format(Locale.CHINA, "profiling.%h.app.%s\n.DisplayView.%d (%d-%d)\n.CreateApplication.%d (%d-%d)\n.CreateContainer.%d (%d-%d)\n.CreateView.%d.(%d-%d)\n.CreateContext.%d.(%d-%d)\n.CreateDrawTarget.%d.(%d-%d)\n.FirstDraw.%d. (%d-%d)\n.total.%d", new Object[] { this, str, Long.valueOf(this.mTimeRecord.endOfDisplyView - this.mTimeRecord.beginOfDisplyView), Long.valueOf(this.mTimeRecord.beginOfDisplyView), Long.valueOf(this.mTimeRecord.endOfDisplyView), Long.valueOf(this.mTimeRecord.beginOfRunApplication - this.mTimeRecord.beginOfCreateApplication), Long.valueOf(this.mTimeRecord.beginOfCreateApplication), Long.valueOf(this.mTimeRecord.beginOfRunApplication), Long.valueOf(this.mTimeRecord.beginOfInitContainer - this.mTimeRecord.beginOfCreateContainer), Long.valueOf(this.mTimeRecord.beginOfCreateContainer), Long.valueOf(this.mTimeRecord.beginOfInitContainer), Long.valueOf(this.mTimeRecord.endOfCreateView - this.mTimeRecord.beginOfCreateView), Long.valueOf(this.mTimeRecord.beginOfCreateView), Long.valueOf(this.mTimeRecord.endOfCreateView), Long.valueOf(this.mTimeRecord.endOfCreateContext - this.mTimeRecord.beginOfCreateContext), Long.valueOf(this.mTimeRecord.beginOfCreateContext), Long.valueOf(this.mTimeRecord.endOfCreateContext), Long.valueOf(this.mTimeRecord.endOfCreateDrawTarget - this.mTimeRecord.beginOfCreateDrawTarget), Long.valueOf(this.mTimeRecord.beginOfCreateDrawTarget), Long.valueOf(this.mTimeRecord.endOfCreateDrawTarget), Long.valueOf(this.mTimeRecord.endOfFirstDraw - this.mTimeRecord.beginOfFirstDraw), Long.valueOf(this.mTimeRecord.beginOfFirstDraw), Long.valueOf(this.mTimeRecord.endOfFirstDraw), Long.valueOf(this.mTimeRecord.endOfFirstDraw - this.mTimeRecord.beginOfDisplyView) }));
      return;
    }
  }
  
  protected boolean onLoadApp(ArkViewModelBase.AppInfo paramAppInfo)
  {
    return true;
  }
  
  protected void onLoadReport(int paramInt)
  {
    ENV.logD("ArkApp.ArkViewModelBase", String.format("doLoadArkApp.onLoadReport.loadstate.%d", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  protected void onRunAppFailed()
  {
    if (this.mViewImpl == null) {
      return;
    }
    ArkDispatchTask.getInstance().postToMainThread(new ArkViewModelBase.16(this));
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.mContainer == null) {
      return false;
    }
    float f = this.mAppInfo.scale;
    SafeAsyncRun(new ArkViewModelBase.TouchRunnable(paramMotionEvent, this.mContainer, f));
    return true;
  }
  
  public boolean onViewEvent(String paramString1, String paramString2)
  {
    if (this.mContainer == null)
    {
      ENV.logE("ArkApp.ArkViewModelBase", "onViewEvent mContainer is null");
      return false;
    }
    SafeAsyncRun(new ArkViewModelBase.6(this, paramString1, paramString2));
    return true;
  }
  
  public void postInvalid()
  {
    SafeAsyncRun(this.mPostInvalid);
  }
  
  public void postRedraw()
  {
    SafeAsyncRun(this.mPostRedraw);
  }
  
  public void reinitArkContainer()
  {
    if (this.mLoadFailed)
    {
      this.mLoadFailed = false;
      if (!this.mInit) {}
    }
    else
    {
      return;
    }
    initArkContainer(this.mViewImpl);
  }
  
  protected void runPerfStat()
  {
    if ((!this.mAttached) || (!this.mInActivateStatus)) {}
    while (this.mPerfTaskRunning) {
      return;
    }
    this.mPerfTaskRunning = true;
    WeakReference localWeakReference = new WeakReference(this);
    String str1 = this.mAppInfo.name;
    String str2 = this.mAppInfo.view;
    SafeAsyncRun(new ArkViewModelBase.22(this, System.currentTimeMillis(), str1, str2, localWeakReference));
  }
  
  public Rect scaleRect(Rect paramRect)
  {
    return scaleRect(paramRect, this.mAppInfo.scale);
  }
  
  public void setFixSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      this.mAppInfo.width = ((int)(paramInt1 / this.mAppInfo.scale));
    }
    if (paramInt2 > 0) {
      this.mAppInfo.height = ((int)(paramInt2 / this.mAppInfo.scale));
    }
  }
  
  public void setForeground(boolean paramBoolean)
  {
    ENV.logE("ArkApp.ArkViewModelBase", "setForeground isForeground = " + paramBoolean);
    if (this.mIsForeground == paramBoolean) {
      return;
    }
    this.mIsForeground = paramBoolean;
    SafeAsyncRun(new ArkViewModelBase.23(this, paramBoolean));
  }
  
  public void setHintSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      this.mAppInfo.hintWidth = ((int)(paramInt1 / this.mAppInfo.scale));
    }
    if (paramInt2 > 0) {
      this.mAppInfo.hintHeight = ((int)(paramInt2 / this.mAppInfo.scale));
    }
  }
  
  public void setMaxSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      this.mAppInfo.maxWidth = ((int)(paramInt1 / this.mAppInfo.scale));
    }
    if (paramInt2 > 0) {
      this.mAppInfo.maxHeight = ((int)(paramInt2 / this.mAppInfo.scale));
    }
  }
  
  public void setMinSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      this.mAppInfo.minWidth = ((int)(paramInt1 / this.mAppInfo.scale));
    }
    if (paramInt2 > 0) {
      this.mAppInfo.minHeight = ((int)(paramInt2 / this.mAppInfo.scale));
    }
  }
  
  public void setViewRect(Rect paramRect)
  {
    if (paramRect == null)
    {
      ENV.logE("ArkApp.ArkViewModelBase", "setViewRect.1.rect return for null param");
      return;
    }
    ENV.logI("ArkApp.ArkViewModelBase", String.format("setViewRect.1.rect: %s, this.%h", new Object[] { paramRect.toString(), this }));
    SafeAsyncRun(new ArkViewModelBase.5(this, paramRect));
  }
  
  public void updateMetaData(String paramString)
  {
    SafeAsyncRun(new ArkViewModelBase.24(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase
 * JD-Core Version:    0.7.0.1
 */