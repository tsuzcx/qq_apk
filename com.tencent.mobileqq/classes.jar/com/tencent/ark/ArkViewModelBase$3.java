package com.tencent.ark;

import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import java.util.HashMap;

class ArkViewModelBase$3
  implements Runnable
{
  ArkViewModelBase$3(ArkViewModelBase paramArkViewModelBase, ArkViewModelBase.AppInfo paramAppInfo, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    if (!ArkViewModelBase.sAppInit)
    {
      this.this$0.initLibrary();
      ArkViewModelBase.sAppInit = true;
    }
    ??? = this.this$0;
    ((ArkViewModelBase)???).mHasLoaded = true;
    ((ArkViewModelBase)???).mSyncRectLock = true;
    ((ArkViewModelBase)???).mTimeRecord.beginOfCreateView = System.currentTimeMillis();
    ArkAppPreloader.preloadCommon(this.val$info.scale, this.val$storagePath, this.val$cachePath);
    ??? = this.this$0.mApplication;
    ArkViewModelBase localArkViewModelBase;
    if (this.this$0.mApplication != null)
    {
      localArkViewModelBase = this.this$0;
      Logger.logD("ArkApp.ViewModel", String.format("profiling.doLoadArkApp.find.preApplication.this.%h.application.%h", new Object[] { localArkViewModelBase, localArkViewModelBase.mApplication }));
    }
    if (ArkViewModelBase.ENV.mIsDebug)
    {
      localArkViewModelBase = this.this$0;
      Logger.logD("ArkApp.ViewModel", String.format("doLoadArkApp.beginOfCreateApplication.this.%h.queueKey=%s", new Object[] { localArkViewModelBase, localArkViewModelBase.mQueueKey }));
    }
    this.this$0.mTimeRecord.beginOfCreateApplication = System.currentTimeMillis();
    this.this$0.mApplication = ark.Application.Create(this.val$info.name, this.val$info.path);
    if (this.this$0.mApplication == null)
    {
      Logger.logI("ArkApp.ViewModel", "loadArkApp.mApplication.create.fail!!");
      this.this$0.onLoadReport(104);
    }
    else
    {
      if (??? != null)
      {
        Logger.logD("ArkApp.ViewModel", String.format("profiling.doLoadArkApp.release.preApplication.this.%h.application.%h", new Object[] { this.this$0, ??? }));
        this.this$0.applicationRelease((ark.Application)???);
        ((ark.Application)???).Release();
      }
      ArkStateCenter.getInstance().addArkViewModel(this.this$0);
      ??? = this.this$0;
      ((ArkViewModelBase)???).applicationCreate(((ArkViewModelBase)???).mApplication);
      this.this$0.mTimeRecord.beginOfRunApplication = System.currentTimeMillis();
      if (!this.this$0.mApplication.Load(this.val$storagePath, this.val$resPath, this.val$cachePath))
      {
        if ((this.this$0.mApplication.GetScriptType() == 2) && (!ark.Application.JSCLoaded()))
        {
          ??? = this.this$0;
          ((ArkViewModelBase)???).mInit = false;
          ((ArkViewModelBase)???).mLoadFailed = true;
          ((ArkViewModelBase)???).onLoadReport(107);
        }
        else
        {
          this.this$0.onLoadReport(106);
        }
      }
      else if (!this.this$0.mApplication.Run(this.this$0.mAppCallback, this.this$0.mAppInfo.appConfig))
      {
        this.this$0.onLoadReport(102);
      }
      else
      {
        if (this.this$0.mContainer != null)
        {
          Logger.logI("ArkApp.ViewModel", "loadArkApp.mContainer.not.null");
          this.this$0.mContainer.DeletePtr();
        }
        this.this$0.mTimeRecord.beginOfCreateContainer = System.currentTimeMillis();
        this.this$0.beforeContainerCreate();
        this.this$0.mContainer = new ark.Container();
        this.this$0.mContainer.SetDisableGPURendering(this.this$0.mIsGpuRendering ^ true);
        ??? = this.this$0.mContainer;
        boolean bool;
        if ((this.this$0.mIsGpuRendering) && (!EGLContextHolder.sIsGPURasterDisabled)) {
          bool = false;
        } else {
          bool = true;
        }
        ((ark.Container)???).SetDisableGPURasterization(bool);
        this.this$0.mContainer.SetShowFps(ArkViewModelBase.ENV.mShowFps);
        this.this$0.mContainer.SetContainerCallback(this.this$0);
        if (this.this$0.mContainer.CreateRootView(this.this$0.mApplication, this.val$info.view)) {
          break label637;
        }
        Logger.logI("ArkApp.ViewModel", "loadArkApp.CreateRootView.fail!!");
        this.this$0.onLoadReport(105);
      }
    }
    int i = 0;
    break label639;
    label637:
    i = 1;
    label639:
    if (i == 0)
    {
      ??? = this.this$0;
      ((ArkViewModelBase)???).mHasLoaded = false;
      ((ArkViewModelBase)???).mSyncRectLock = false;
      if (((ArkViewModelBase)???).mAppScriptType == 2) {
        this.this$0.mLoadFailed = true;
      }
      this.this$0.onRunAppFailed();
      return;
    }
    this.this$0.mTimeRecord.beginOfInitContainer = System.currentTimeMillis();
    if (!TextUtils.isEmpty(this.val$viewId)) {
      this.this$0.mContainer.SetID(this.val$viewId);
    }
    int j = this.val$info.width;
    int k = this.val$info.height;
    i = j;
    if (j <= 0) {
      i = this.this$0.mRectArkContainer.width();
    }
    j = k;
    if (k <= 0) {
      j = this.this$0.mRectArkContainer.height();
    }
    ??? = this.this$0.limitToSizeRange(i, j);
    this.this$0.mContainer.SetSize(((ArkViewModelBase.Size)???).width, ((ArkViewModelBase.Size)???).height);
    this.this$0.mContainer.SetMetadata(this.val$info.meta, "json");
    this.this$0.mTimeRecord.endOfCreateView = System.currentTimeMillis();
    ??? = this.this$0;
    ((ArkViewModelBase)???).mSyncRectLock = false;
    if (((ArkViewModelBase)???).notInSizeRange(((ArkViewModelBase)???).mRectArkContainer.width(), this.this$0.mRectArkContainer.height()))
    {
      ??? = this.this$0;
      ??? = ((ArkViewModelBase)???).limitToSizeRange(((ArkViewModelBase)???).mRectArkContainer.width(), this.this$0.mRectArkContainer.height());
      this.this$0.mRectContainer.set(0, 0, ((ArkViewModelBase.Size)???).width, ((ArkViewModelBase.Size)???).height);
    }
    else
    {
      ??? = this.this$0;
      ((ArkViewModelBase)???).mRectContainer = ((ArkViewModelBase)???).mRectArkContainer;
    }
    ??? = this.this$0.mViewImpl;
    if ((this.this$0.mAttached) && (??? != null))
    {
      this.this$0.mNeedFirstPaint = true;
      ArkVsync.getInstance().addFrameCallback(this.this$0.mQueueKey, this.this$0);
      this.this$0.mContainer.SetBorderType(((ArkViewImplement)???).mBorderType);
      this.this$0.mContainer.SetBorderRadiusTop(((ArkViewImplement)???).mClipRadiusTop);
      this.this$0.mContainer.SetBorderRadius(((ArkViewImplement)???).mClipRadius);
      this.this$0.mContainer.SetBorderHornLeft(((ArkViewImplement)???).mAlignLeft);
      ??? = this.this$0;
      ((ArkViewModelBase)???).SyncRect(((ArkViewModelBase)???).mRectContainerF.left, this.this$0.mRectContainerF.top, this.this$0.mRectContainerF.right, this.this$0.mRectContainerF.bottom);
      this.this$0.mTimeRecord.endOfDisplyView = System.currentTimeMillis();
      if (ArkViewModelBase.ENV.mIsDebug) {
        Logger.logD("ArkApp.ViewModel", String.format("doLoadArkApp.endOfDisplyView.this.%h", new Object[] { this.this$0 }));
      }
      synchronized (ArkViewModelBase.sAppSizeHint)
      {
        ArkViewModelBase.sAppSizeHint.put(String.format("%s_%s", new Object[] { this.val$info.path, this.val$info.view }), new ArkViewModelBase.Size(this.this$0.mRectContainer.width(), this.this$0.mRectContainer.height()));
        ??? = this.this$0;
        ((ArkViewModelBase)???).onAppDisplay(((ArkViewModelBase)???).mTimeRecord);
        this.this$0.onLoadReport(100);
        return;
      }
    }
    Logger.logI("ArkApp.ViewModel", "loadArkApp.mViewImpl.null");
    this.this$0.onLoadReport(103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.3
 * JD-Core Version:    0.7.0.1
 */