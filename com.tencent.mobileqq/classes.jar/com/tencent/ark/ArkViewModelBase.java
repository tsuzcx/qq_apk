package com.tencent.ark;

import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import java.util.HashMap;
import java.util.Locale;

public class ArkViewModelBase
  implements ark.ContainerCallback, ArkVsync.ArkFrameCallback
{
  public static final int ARKAPP_TYPE_DESTROY = 2;
  public static final int ARKAPP_TYPE_PAUSE = 0;
  public static final int ARKAPP_TYPE_RESUME = 1;
  protected static final ArkEnvironmentManager ENV = ;
  protected static final String KEY_FORMAT = "%s_%s";
  protected static final String TAG = "ArkApp.ArkViewModelBase";
  protected static boolean sAppInit = false;
  protected static HashMap<String, Size> sAppSizeHint = new HashMap();
  protected ark.ApplicationCallback mAppCallback;
  protected AppInfo mAppInfo = new AppInfo();
  protected ark.Application mApplication;
  protected volatile boolean mAttached = false;
  protected ark.Container mContainer;
  public ErrorInfo mErrorInfo = new ErrorInfo();
  protected boolean mFirstDraw = true;
  protected boolean mHasLoaded = false;
  protected boolean mInActivateStatus = true;
  protected boolean mInSyncRect = false;
  protected boolean mInit = false;
  protected volatile boolean mIsActivated = true;
  protected boolean mLoadFailed = false;
  private Runnable mPostInvalid = new Runnable()
  {
    public void run()
    {
      ArkViewImplement localArkViewImplement = ArkViewModelBase.this.mViewImpl;
      if ((localArkViewImplement != null) && (!ArkViewModelBase.this.mRectArkContainer.isEmpty())) {
        localArkViewImplement.onInvalidate(ArkViewModelBase.this.mRectArkContainer);
      }
    }
  };
  protected Runnable mPostRedraw = new Runnable()
  {
    public void run()
    {
      if (!ArkViewModelBase.this.mRectContainerF.isEmpty()) {
        ArkViewModelBase.this.Update(ArkViewModelBase.this.mRectContainerF.left, ArkViewModelBase.this.mRectContainerF.top, ArkViewModelBase.this.mRectContainerF.right, ArkViewModelBase.this.mRectContainerF.bottom);
      }
    }
  };
  protected Rect mRectArkContainer = new Rect();
  protected Rect mRectContainer = new Rect();
  protected RectF mRectContainerF = new RectF();
  protected RectF mRectInvalidF = new RectF();
  protected boolean mRoundCorner = false;
  protected volatile boolean mSyncRectLock = false;
  protected TimeRecord mTimeRecord = new TimeRecord();
  protected ArkViewImplement mViewImpl;
  
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
        break label69;
      }
      ark.arkHTTPSetDefaultHttpProxy("", 0);
    }
    for (;;)
    {
      ENV.logI("ArkApp.ArkViewModelBase", String.format("setArkHttpProxy, host=%s, port=%d", new Object[] { str, Integer.valueOf(i) }));
      return;
      label69:
      ark.arkHTTPSetDefaultHttpProxy(str, i);
    }
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
  
  public void InputFocusChanged(final boolean paramBoolean1, final boolean paramBoolean2, final int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    final ArkViewImplement localArkViewImplement = this.mViewImpl;
    if (localArkViewImplement == null) {
      return;
    }
    final Rect localRect = new Rect((int)paramFloat1, (int)paramFloat2, (int)paramFloat3, (int)paramFloat4);
    ArkDispatchTask.getInstance().postToMainThread(new Runnable()
    {
      public void run()
      {
        localArkViewImplement.onInputFocusChanged(paramBoolean1, paramBoolean2, paramInt, localRect);
      }
    });
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
  
  public void InputMenuChanged(final boolean paramBoolean, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    final ArkViewImplement localArkViewImplement = this.mViewImpl;
    if (localArkViewImplement == null) {
      return;
    }
    paramInt1 = (int)(paramInt1 * this.mAppInfo.scale);
    paramInt2 = (int)(paramInt2 * this.mAppInfo.scale);
    paramInt3 = (int)(paramInt3 * this.mAppInfo.scale);
    ArkDispatchTask.getInstance().postToMainThread(new Runnable()
    {
      public void run()
      {
        localArkViewImplement.onInputMenuChanged(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      }
    });
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
  
  public void InputSelectChanged(final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    final ArkViewImplement localArkViewImplement = this.mViewImpl;
    if (localArkViewImplement == null) {
      return;
    }
    final Rect localRect = new Rect((int)paramFloat1, (int)paramFloat2, (int)paramFloat3, (int)paramFloat4);
    paramInt1 = (int)(paramInt1 * this.mAppInfo.scale);
    paramInt2 = (int)(paramInt2 * this.mAppInfo.scale);
    paramInt3 = (int)(paramInt3 * this.mAppInfo.scale);
    paramInt4 = (int)(paramInt4 * this.mAppInfo.scale);
    ArkDispatchTask.getInstance().postToMainThread(new Runnable()
    {
      public void run()
      {
        localArkViewImplement.onInputSelectChanged(paramInt1, paramInt2, paramInt3, paramInt4, localRect);
      }
    });
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
  
  public void SyncRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mRectContainerF.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    this.mRectArkContainer = convertRect(this.mRectContainerF);
    final ArkViewImplement localArkViewImplement = this.mViewImpl;
    if ((this.mSyncRectLock) || (localArkViewImplement == null)) {
      if (localArkViewImplement == null) {
        ENV.logE("ArkApp.ArkViewModelBase", String.format("SyncRect.1.rect: %s, this.%h has return incorrect.", new Object[] { this.mRectArkContainer.toString(), this }));
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
      Size localSize = limitToSizeRange(this.mRectArkContainer.width(), this.mRectArkContainer.height());
      this.mRectContainer.set(0, 0, localSize.width, localSize.height);
    }
    for (;;)
    {
      this.mContainer.SetSize(this.mRectContainer.width(), this.mRectContainer.height());
      this.mInSyncRect = false;
      createDrawTarget(localArkViewImplement);
      ArkDispatchTask.getInstance().postToMainThread(new Runnable()
      {
        public void run()
        {
          localArkViewImplement.onSyncRect(ArkViewModelBase.this.mRectContainer);
        }
      });
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
  
  public void activateView(final boolean paramBoolean)
  {
    ArkDispatchTask.getInstance().post(new Runnable()
    {
      public void run()
      {
        ArkViewModelBase.this.mIsActivated = paramBoolean;
        if (ArkViewModelBase.this.mContainer == null) {}
        do
        {
          do
          {
            return;
          } while (!ArkViewModelBase.this.mHasLoaded);
          ArkViewModelBase.this.changeContainerActivateStatus(paramBoolean);
        } while (!paramBoolean);
        ArkVsync.getInstance().addFrameCallback(ArkViewModelBase.this);
      }
    });
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
  }
  
  protected void changeContainerActivateStatus(boolean paramBoolean)
  {
    if ((this.mContainer == null) || (this.mInActivateStatus == paramBoolean)) {
      return;
    }
    if (paramBoolean)
    {
      this.mInActivateStatus = true;
      this.mContainer.ActivateRootView();
      return;
    }
    this.mInActivateStatus = false;
    this.mContainer.DeactivateRootView();
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
    if (this.mViewImpl != null) {
      this.mViewImpl.onDestroy();
    }
    ArkDispatchTask.getInstance().post(new Runnable()
    {
      public void run()
      {
        ArkViewImplement localArkViewImplement = ArkViewModelBase.this.mViewImpl;
        if (localArkViewImplement != null) {
          localArkViewImplement.destroyBitmapBuffer();
        }
      }
    });
    detachView();
    ArkDispatchTask.getInstance().post(new Runnable()
    {
      public void run()
      {
        ArkVsync.getInstance().removeFrameCallback(ArkViewModelBase.this);
        if (ArkViewModelBase.this.mContainer != null)
        {
          ArkViewModelBase.this.mContainer.DeletePtr();
          ArkViewModelBase.this.mContainer = null;
        }
        if (ArkViewModelBase.this.mApplication != null)
        {
          ArkViewModelBase.this.applicationRelease(ArkViewModelBase.this.mApplication);
          ArkViewModelBase.this.mApplication.Release();
          ArkViewModelBase.this.mApplication = null;
        }
      }
    });
    ENV.logI("ArkApp.ArkViewModelBase", String.format("destroy. this.%h", new Object[] { this }));
    this.mInit = false;
    this.mAppInfo.canceled = true;
    this.mLoadFailed = false;
  }
  
  public void destroyDrawTarget()
  {
    if (this.mContainer != null) {
      this.mContainer.DetachBitmap(null);
    }
  }
  
  public void detachView()
  {
    this.mAttached = false;
    if (this.mViewImpl != null)
    {
      this.mViewImpl.doDetach(this);
      this.mViewImpl = null;
    }
    activateView(false);
    ENV.logI("ArkApp.ArkViewModelBase", String.format("detachView.1.this.%h", new Object[] { this }));
    ArkDispatchTask.getInstance().post(new Runnable()
    {
      public void run()
      {
        ArkVsync.getInstance().removeFrameCallback(ArkViewModelBase.this);
        if (ArkViewModelBase.this.mContainer != null)
        {
          ArkViewModelBase.this.mContainer.SetContainerCallback(null);
          ArkViewModelBase.ENV.logI("ArkApp.ArkViewModelBase", String.format("detachViewArkThread.this.%h", new Object[] { ArkViewModelBase.this }));
        }
        ArkViewModelBase.this.destroyDrawTarget();
      }
    });
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
  }
  
  protected void doLoadArkApp(final String paramString1, final String paramString2, final String paramString3, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString4)
  {
    final AppInfo localAppInfo = this.mAppInfo;
    localAppInfo.path = paramString1;
    this.mLoadFailed = false;
    this.mHasLoaded = false;
    ENV.logD("ArkApp.ArkViewModelBase", String.format("doLoadArkApp.enter.this.%h", new Object[] { this }));
    if ((paramBoolean1) || (localAppInfo.canceled))
    {
      this.mLoadFailed = true;
      this.mInit = false;
      this.mErrorInfo.msg = paramString4;
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
          break label213;
        }
      }
      label213:
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        paramString1.logI("ArkApp.ArkViewModelBase", String.format("doLoadArkApp.Failed.mLoadFailed.%b.info.canceled.%b", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) }));
        return;
        ArkDispatchTask.getInstance().postToMainThread(new Runnable()
        {
          public void run()
          {
            ArkViewImplement localArkViewImplement = ArkViewModelBase.this.mViewImpl;
            if (localArkViewImplement != null) {
              localArkViewImplement.onLoadFailed(ArkViewModelBase.this.mErrorInfo.msg, ArkViewModelBase.this.mErrorInfo.retCode, ArkViewModelBase.this.mErrorInfo.canRetry);
            }
          }
        });
        break;
      }
    }
    if (ENV.mIsDebug) {
      ENV.logD("ArkApp.ArkViewModelBase", String.format("doLoadArkApp.beginOfDisplyView.this.%h", new Object[] { this }));
    }
    this.mTimeRecord.beginOfDisplyView = System.currentTimeMillis();
    paramString1 = getViewId();
    ArkDispatchTask.getInstance().post(new Runnable()
    {
      public void run()
      {
        if (!ArkViewModelBase.sAppInit)
        {
          ark.arkHTTPStartup();
          ark.arkSetPixelScale(localAppInfo.scale);
          ArkViewModelBase.this.initLibrary();
          ArkViewModelBase.sAppInit = true;
        }
        ark.arkSetStoragePath(paramString3, paramString2);
        ark.arkHTTPSetDownloadDirectory(paramString2);
        ArkViewModelBase.setArkHttpProxy();
        ArkViewModelBase.this.mHasLoaded = true;
        ArkViewModelBase.this.mSyncRectLock = true;
        ArkViewModelBase.this.mTimeRecord.beginOfCreateView = System.currentTimeMillis();
        if (ArkViewModelBase.this.mApplication != null)
        {
          ArkViewModelBase.this.applicationRelease(ArkViewModelBase.this.mApplication);
          ArkViewModelBase.this.mApplication.Release();
        }
        if (ArkViewModelBase.ENV.mIsDebug) {
          ArkViewModelBase.ENV.logD("ArkApp.ArkViewModelBase", String.format("doLoadArkApp.beginOfCreateApplication.this.%h", new Object[] { ArkViewModelBase.this }));
        }
        ArkViewModelBase.this.mTimeRecord.beginOfCreateApplication = System.currentTimeMillis();
        ArkViewModelBase.this.mApplication = ark.Application.Create(localAppInfo.path);
        if (ArkViewModelBase.this.mApplication == null)
        {
          ArkViewModelBase.ENV.logI("ArkApp.ArkViewModelBase", "loadArkApp.mApplication.create.fail!!");
          i = 0;
        }
        while (i == 0)
        {
          ArkViewModelBase.this.mHasLoaded = false;
          ArkViewModelBase.this.mSyncRectLock = false;
          ArkViewModelBase.this.onRunAppFailed();
          return;
          ArkViewModelBase.this.applicationCreate(ArkViewModelBase.this.mApplication);
          ArkViewModelBase.this.mTimeRecord.beginOfRunApplication = System.currentTimeMillis();
          ArkViewModelBase.this.mApplication.Run(paramString3, null, paramString2, ArkViewModelBase.this.mAppCallback);
          if (ArkViewModelBase.this.mContainer != null)
          {
            ArkViewModelBase.ENV.logI("ArkApp.ArkViewModelBase", "loadArkApp.mContainer.not.null");
            ArkViewModelBase.this.mContainer.DeletePtr();
          }
          ArkViewModelBase.this.mTimeRecord.beginOfCreateContainer = System.currentTimeMillis();
          ArkViewModelBase.this.beforeContainerCreate();
          ArkViewModelBase.this.mContainer = new ark.Container();
          ArkViewModelBase.this.mContainer.SetContainerCallback(ArkViewModelBase.this);
          if (!ArkViewModelBase.this.mContainer.CreateRootView(ArkViewModelBase.this.mApplication, localAppInfo.name, localAppInfo.path, localAppInfo.view))
          {
            ArkViewModelBase.ENV.logI("ArkApp.ArkViewModelBase", "loadArkApp.CreateRootView.fail!!");
            i = 0;
          }
          else
          {
            i = 1;
          }
        }
        ArkViewModelBase.this.mTimeRecord.beginOfInitContainer = System.currentTimeMillis();
        if (!TextUtils.isEmpty(paramString1)) {
          ArkViewModelBase.this.mContainer.SetID(paramString1);
        }
        int j = localAppInfo.width;
        int k = localAppInfo.height;
        int i = j;
        if (j <= 0) {
          i = ArkViewModelBase.this.mRectArkContainer.width();
        }
        j = k;
        if (k <= 0) {
          j = ArkViewModelBase.this.mRectArkContainer.height();
        }
        ??? = ArkViewModelBase.this.limitToSizeRange(i, j);
        ArkViewModelBase.this.mContainer.SetSize(((ArkViewModelBase.Size)???).width, ((ArkViewModelBase.Size)???).height);
        ArkViewModelBase.this.mContainer.SetMetadata(localAppInfo.meta, "json");
        ArkViewModelBase.this.mTimeRecord.endOfCreateView = System.currentTimeMillis();
        ArkViewModelBase.this.mSyncRectLock = false;
        if (ArkViewModelBase.this.notInSizeRange(ArkViewModelBase.this.mRectArkContainer.width(), ArkViewModelBase.this.mRectArkContainer.height()))
        {
          ??? = ArkViewModelBase.this.limitToSizeRange(ArkViewModelBase.this.mRectArkContainer.width(), ArkViewModelBase.this.mRectArkContainer.height());
          ArkViewModelBase.this.mRectContainer.set(0, 0, ((ArkViewModelBase.Size)???).width, ((ArkViewModelBase.Size)???).height);
        }
        for (;;)
        {
          ??? = ArkViewModelBase.this.mViewImpl;
          if ((ArkViewModelBase.this.mAttached) && (??? != null)) {
            break;
          }
          ArkViewModelBase.ENV.logI("ArkApp.ArkViewModelBase", "loadArkApp.mViewImpl.null");
          return;
          ArkViewModelBase.this.mRectContainer = ArkViewModelBase.this.mRectArkContainer;
        }
        ArkVsync.getInstance().addFrameCallback(ArkViewModelBase.this);
        ArkViewModelBase.this.mContainer.SetBorderType(((ArkViewImplement)???).mBorderType);
        ArkViewModelBase.this.mContainer.SetBorderRadiusTop(((ArkViewImplement)???).mClipRadiusTop);
        ArkViewModelBase.this.mContainer.SetBorderRadius(((ArkViewImplement)???).mClipRadius);
        ArkViewModelBase.this.mContainer.SetBorderHornLeft(((ArkViewImplement)???).mAlignLeft);
        ArkViewModelBase.this.SyncRect(ArkViewModelBase.this.mRectContainerF.left, ArkViewModelBase.this.mRectContainerF.top, ArkViewModelBase.this.mRectContainerF.right, ArkViewModelBase.this.mRectContainerF.bottom);
        ArkViewModelBase.this.mTimeRecord.endOfDisplyView = System.currentTimeMillis();
        if (ArkViewModelBase.ENV.mIsDebug) {
          ArkViewModelBase.ENV.logD("ArkApp.ArkViewModelBase", String.format("doLoadArkApp.endOfDisplyView.this.%h", new Object[] { ArkViewModelBase.this }));
        }
        synchronized (ArkViewModelBase.sAppSizeHint)
        {
          ArkViewModelBase.sAppSizeHint.put(String.format("%s_%s", new Object[] { localAppInfo.path, localAppInfo.view }), new ArkViewModelBase.Size(ArkViewModelBase.this.mRectContainer.width(), ArkViewModelBase.this.mRectContainer.height()));
          ArkViewModelBase.this.onAppDisplay(ArkViewModelBase.this.mTimeRecord);
          return;
        }
      }
    });
    ENV.logD("ArkApp.ArkViewModelBase", String.format("doLoadArkApp.leave.this.%h", new Object[] { this }));
  }
  
  public void doOnEvent(int paramInt)
  {
    if (paramInt == 0) {
      if ((this.mHasLoaded) && (this.mIsActivated)) {
        ArkDispatchTask.getInstance().post(new Runnable()
        {
          public void run()
          {
            ArkViewModelBase.this.changeContainerActivateStatus(false);
            ArkVsync.getInstance().removeFrameCallback(ArkViewModelBase.this);
          }
        });
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
      } while ((!this.mHasLoaded) || (!this.mIsActivated));
      ArkDispatchTask.getInstance().post(new Runnable()
      {
        public void run()
        {
          ArkViewModelBase.this.changeContainerActivateStatus(true);
          if (ArkViewModelBase.this.mContainer != null) {
            ArkVsync.getInstance().addFrameCallback(ArkViewModelBase.this);
          }
          ArkViewModelBase.this.mPostRedraw.run();
        }
      });
      return;
    } while (paramInt != 2);
    destroy();
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
  
  public ErrorInfo getErrorInfo()
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
      Size localSize = (Size)sAppSizeHint.get(String.format("%s_%s", new Object[] { this.mAppInfo.path, this.mAppInfo.view }));
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
      Size localSize = (Size)sAppSizeHint.get(String.format("%s_%s", new Object[] { this.mAppInfo.path, this.mAppInfo.view }));
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
  
  public boolean init(String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat)
  {
    if ((paramString1 == null) || (paramString2 == null))
    {
      ENV.logD("ArkApp.ArkViewModelBase", "init got null app name and viewImpl name.");
      return false;
    }
    if (this.mLoadFailed)
    {
      paramString1 = this.mViewImpl;
      if (paramString1 != null) {
        paramString1.onLoadFailed(this.mErrorInfo.msg, this.mErrorInfo.retCode, this.mErrorInfo.canRetry);
      }
      ENV.logI("ArkApp.ArkViewModelBase", String.format("init mLoadFailed true!!! viewModel: %h.", new Object[] { this }));
      return true;
    }
    if ((!paramString1.equals(this.mAppInfo.name)) || (!paramString2.equals(this.mAppInfo.view))) {
      this.mInit = false;
    }
    if (this.mInit)
    {
      ENV.logD("ArkApp.ArkViewModelBase", String.format("init mInit is true!!! viewModel: %h.", new Object[] { this }));
      return true;
    }
    this.mAppInfo.scale = paramFloat;
    this.mAppInfo.name = paramString1;
    this.mAppInfo.view = paramString2;
    this.mAppInfo.meta = paramString4;
    this.mAppInfo.appMinVersion = paramString3;
    this.mAppInfo.canceled = false;
    this.mTimeRecord.appName = paramString1;
    this.mTimeRecord.view = paramString2;
    return true;
  }
  
  protected boolean initArkContainer(ArkViewImplement paramArkViewImplement)
  {
    this.mViewImpl = paramArkViewImplement;
    if (this.mLoadFailed)
    {
      if (this.mViewImpl != null) {
        this.mViewImpl.onLoadFailed(this.mErrorInfo.msg, this.mErrorInfo.retCode, this.mErrorInfo.canRetry);
      }
      ENV.logI("ArkApp.ArkViewModelBase", String.format("initArkContainer.mLoadFailed.true!.viewModel: %h.", new Object[] { this }));
      return true;
    }
    if (this.mInit)
    {
      ArkDispatchTask.getInstance().post(new Runnable()
      {
        public void run()
        {
          if ((ArkViewModelBase.this.mContainer == null) || (!ArkViewModelBase.this.mAttached))
          {
            ArkViewModelBase.ENV.logE("ArkApp.ArkViewModelBase", String.format("initArkContainer.0.viewModel: %h", new Object[] { ArkViewModelBase.this }));
            return;
          }
          ArkViewModelBase.this.mContainer.SetContainerCallback(ArkViewModelBase.this);
          ArkViewModelBase.ENV.logI("ArkApp.ArkViewModelBase", String.format("initArkContainer.1.viewModel: %h", new Object[] { ArkViewModelBase.this }));
          ArkViewImplement localArkViewImplement = ArkViewModelBase.this.mViewImpl;
          if ((ArkViewModelBase.this.mRectContainerF.isEmpty()) || (localArkViewImplement == null))
          {
            ArkViewModelBase.ENV.logE("ArkApp.ArkViewModelBase", String.format("initArkContainer.2.viewModel: %h", new Object[] { this }));
            return;
          }
          ArkViewModelBase.this.mContainer.SetBorderType(localArkViewImplement.mBorderType);
          ArkViewModelBase.this.mContainer.SetBorderRadiusTop(localArkViewImplement.mClipRadiusTop);
          ArkViewModelBase.this.mContainer.SetBorderRadius(localArkViewImplement.mClipRadius);
          ArkViewModelBase.this.SyncRect(ArkViewModelBase.this.mRectContainerF.left, ArkViewModelBase.this.mRectContainerF.top, ArkViewModelBase.this.mRectContainerF.right, ArkViewModelBase.this.mRectContainerF.bottom);
        }
      });
      activateView(true);
      ENV.logD("ArkApp.ArkViewModelBase", String.format("init.finished.and.mInit.true!.viewModel: %h.", new Object[] { this }));
      return true;
    }
    this.mInit = true;
    return onLoadApp(this.mAppInfo);
  }
  
  protected void initLibrary() {}
  
  protected Size limitToSizeRange(int paramInt1, int paramInt2)
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
    return new Size(paramInt2, i);
  }
  
  protected boolean notInSizeRange(int paramInt1, int paramInt2)
  {
    if (((this.mAppInfo.minWidth > 0) && (paramInt1 < this.mAppInfo.minWidth)) || ((this.mAppInfo.minHeight > 0) && (paramInt2 < this.mAppInfo.minHeight))) {}
    while (((this.mAppInfo.maxWidth > 0) && (paramInt1 > this.mAppInfo.maxWidth)) || ((this.mAppInfo.maxHeight > 0) && (paramInt2 > this.mAppInfo.maxHeight))) {
      return true;
    }
    return false;
  }
  
  protected void onAppDisplay(TimeRecord paramTimeRecord) {}
  
  protected void onFirstDrawEnd()
  {
    if (ENV.mShowProfilingLog) {
      ENV.logI("ArkApp.ArkViewModelBase", String.format(Locale.CHINA, "profiling.%h.beginOfDisplyView.%d.endOfDisplyView.%d\n.beginOfCreateApplication.%d.beginOfRunApplication.%d\n.beginOfCreateContainer.%d.beginOfInitContainer.%d\n.beginOfCreateView.%d.endOfCreateView.%d\n.beginOfCreateContext.%d\n.beginOfCreateDrawTarget.%d.endOfCreateDrawTarget.%d\n.beginOfFirstDraw.%d.endOfFirstDraw.%d\n.total.%d", new Object[] { this, Long.valueOf(this.mTimeRecord.beginOfDisplyView), Long.valueOf(this.mTimeRecord.endOfDisplyView), Long.valueOf(this.mTimeRecord.beginOfCreateApplication), Long.valueOf(this.mTimeRecord.beginOfRunApplication), Long.valueOf(this.mTimeRecord.beginOfCreateContainer), Long.valueOf(this.mTimeRecord.beginOfInitContainer), Long.valueOf(this.mTimeRecord.beginOfCreateView), Long.valueOf(this.mTimeRecord.endOfCreateView), Long.valueOf(this.mTimeRecord.beginOfCreateContext), Long.valueOf(this.mTimeRecord.beginOfCreateDrawTarget), Long.valueOf(this.mTimeRecord.endOfCreateDrawTarget), Long.valueOf(this.mTimeRecord.beginOfFirstDraw), Long.valueOf(this.mTimeRecord.endOfFirstDraw), Long.valueOf(this.mTimeRecord.endOfFirstDraw - this.mTimeRecord.beginOfDisplyView) }));
    }
  }
  
  protected boolean onLoadApp(AppInfo paramAppInfo)
  {
    return true;
  }
  
  protected void onRunAppFailed()
  {
    if (this.mViewImpl == null) {
      return;
    }
    ArkDispatchTask.getInstance().postToMainThread(new Runnable()
    {
      public void run()
      {
        if (ArkViewModelBase.this.mViewImpl != null) {
          ArkViewModelBase.this.mViewImpl.onLoadFailed(ArkViewModelBase.this.mErrorInfo.msg, ArkViewModelBase.this.mErrorInfo.retCode, ArkViewModelBase.this.mErrorInfo.canRetry);
        }
      }
    });
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.mContainer == null) {
      return false;
    }
    float f = this.mAppInfo.scale;
    ArkDispatchTask.getInstance().post(new TouchRunnable(paramMotionEvent, this.mContainer, f));
    return true;
  }
  
  public void postInvalid()
  {
    ArkDispatchTask.getInstance().post(this.mPostInvalid);
  }
  
  public void postRedraw()
  {
    ArkDispatchTask.getInstance().post(this.mPostRedraw);
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
  
  public void setViewRect(final Rect paramRect)
  {
    ENV.logI("ArkApp.ArkViewModelBase", String.format("setViewRect.1.rect: %s, this.%h", new Object[] { paramRect.toString(), this }));
    ArkDispatchTask.getInstance().post(new Runnable()
    {
      public void run()
      {
        if ((ArkViewModelBase.this.mContainer != null) && (!paramRect.equals(ArkViewModelBase.this.mRectContainer)))
        {
          ArkViewModelBase.ENV.logI("ArkApp.ArkViewModelBase", String.format("setViewRect.2.rect: %s, this.%h", new Object[] { paramRect.toString(), this }));
          ArkViewModelBase.Size localSize = ArkViewModelBase.this.limitToSizeRange(paramRect.width(), paramRect.height());
          ArkViewModelBase.this.mContainer.SetSize(localSize.width, localSize.height);
        }
      }
    });
  }
  
  public static class AppInfo
  {
    public String appMinVersion;
    public boolean canceled = false;
    public int height = 0;
    public int hintHeight = -1;
    public int hintWidth = -1;
    public int maxHeight = -1;
    public int maxWidth = -1;
    public String meta;
    public int minHeight = -1;
    public int minWidth = -1;
    public String name;
    public String path;
    public float scale;
    public String view;
    public int width = 0;
  }
  
  public static class ErrorInfo
  {
    public boolean canRetry = true;
    public String msg;
    public int retCode;
  }
  
  public static class Size
  {
    public int height = 0;
    public int width = 0;
    
    public Size(int paramInt1, int paramInt2)
    {
      this.width = paramInt1;
      this.height = paramInt2;
    }
  }
  
  public static class TimeRecord
  {
    public String appName;
    public long beginOfCreateApplication = 0L;
    public long beginOfCreateContainer = 0L;
    public long beginOfCreateContext = 0L;
    public long beginOfCreateDrawTarget = 0L;
    public long beginOfCreateView = 0L;
    public long beginOfDisplyView = 0L;
    public long beginOfFirstDraw = 0L;
    public long beginOfInitContainer = 0L;
    public long beginOfRunApplication = 0L;
    public long endOfCreateDrawTarget = 0L;
    public long endOfCreateView = 0L;
    public long endOfDisplyView = 0L;
    public long endOfFirstDraw = 0L;
    public String view;
  }
  
  static final class TouchRunnable
    implements Runnable
  {
    private int mAction;
    private ark.Container mContainer;
    private int[] mId;
    private float[] mX;
    private float[] mY;
    
    public TouchRunnable(MotionEvent paramMotionEvent, ark.Container paramContainer, float paramFloat)
    {
      this.mAction = paramMotionEvent.getActionMasked();
      this.mContainer = paramContainer;
      int i;
      if ((this.mAction == 5) || (this.mAction == 6))
      {
        this.mId = new int[1];
        this.mX = new float[1];
        this.mY = new float[1];
        i = paramMotionEvent.getActionIndex();
        this.mId[0] = paramMotionEvent.getPointerId(i);
        this.mX[0] = (paramMotionEvent.getX(i) / paramFloat);
        this.mY[0] = (paramMotionEvent.getY(i) / paramFloat);
      }
      for (;;)
      {
        return;
        int k = paramMotionEvent.getPointerCount();
        i = k;
        if (k > ark.arkGetMaxTouchPoints()) {
          i = ark.arkGetMaxTouchPoints();
        }
        this.mId = new int[i];
        this.mX = new float[i];
        this.mY = new float[i];
        while (j < i)
        {
          this.mId[j] = paramMotionEvent.getPointerId(j);
          this.mX[j] = (paramMotionEvent.getX(j) / paramFloat);
          this.mY[j] = (paramMotionEvent.getY(j) / paramFloat);
          j += 1;
        }
      }
    }
    
    public void run()
    {
      if ((ArkViewModelBase.ENV.mIsDebug) && (this.mAction != 2)) {
        ArkViewModelBase.ENV.logD("ArkApp.ArkViewModelBase", String.format("TouchRunnable.action.%d.count.%d", new Object[] { Integer.valueOf(this.mAction), Integer.valueOf(this.mId.length) }));
      }
      switch (this.mAction)
      {
      case 4: 
      default: 
        return;
      case 0: 
      case 5: 
        this.mContainer.TouchStart(this.mX, this.mY, this.mId, this.mId.length);
        return;
      case 2: 
        this.mContainer.TouchMove(this.mX, this.mY, this.mId, this.mId.length);
        return;
      case 1: 
      case 6: 
        this.mContainer.TouchEnd(this.mX, this.mY, this.mId, this.mId.length);
        return;
      }
      this.mContainer.TouchCancel(this.mX, this.mY, this.mId, this.mId.length);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase
 * JD-Core Version:    0.7.0.1
 */