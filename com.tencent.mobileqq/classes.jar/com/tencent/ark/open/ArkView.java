package com.tencent.ark.open;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewTreeObserver;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkTextureView;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import java.lang.ref.WeakReference;

public class ArkView
  extends ArkTextureView
{
  private static final ArkEnvironmentManager ENV = ;
  private static final String TAG = "ArkApp.ArkView";
  private ArkModel mArkModel = null;
  private WeakReference<ArkViewImplement.LoadCallback> mArkViewCallback = null;
  private int mBorderType = -1;
  private Context mContext = null;
  private boolean mGetArkViewSize = false;
  private boolean mHardwareRenderingEnable = true;
  private ArkAppInfo.Size mHintSize = null;
  private ArkView.InitInfo mInfo = null;
  private ArkAppInfo.Size mMaxSize = null;
  private ArkAppInfo.Size mMinSize = null;
  private ArkAppInfo.Size mPrefferSize = null;
  private float mRadius = 0.0F;
  private float mRadiusTop = 0.0F;
  private float mScale = 0.0F;
  
  public ArkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ArkAppCacheMgr.setupArkEnvironment(true);
    this.mContext = paramContext;
    setOnTouchListener(this);
    paramContext = this.mContext.getResources().getDisplayMetrics();
    this.mPrefferSize = new ArkAppInfo.Size(-1, -1);
    this.mMinSize = new ArkAppInfo.Size(30, 30);
    this.mMaxSize = new ArkAppInfo.Size(paramContext.widthPixels, paramContext.heightPixels);
    this.mHintSize = new ArkAppInfo.Size(320, 480);
    this.mOnStartTemporaryDetach = false;
    getViewTreeObserver().addOnGlobalLayoutListener(new ArkView.1(this));
  }
  
  private void loadImpl(ArkView.InitInfo paramInitInfo)
  {
    if (paramInitInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("loadImpl() appPath=");
      localStringBuilder.append(paramInitInfo.appPath);
      this.mArkModel = new ArkModel(ArkDelegateManager.getInstance().getApplicationCallback(), this.mHardwareRenderingEnable);
      localStringBuilder.append(",gpuRenderingEnabled=").append(this.mHardwareRenderingEnable);
      setInputCallback(ArkDelegateManager.getInstance().getInputCallback());
      if (this.mArkViewCallback != null) {
        setLoadCallback((ArkViewImplement.LoadCallback)this.mArkViewCallback.get());
      }
      float f2 = this.mScale;
      float f1 = f2;
      if (f2 == 0.0F) {
        f1 = this.mContext.getResources().getDisplayMetrics().scaledDensity;
      }
      this.mArkModel.setAppPath(paramInitInfo.appPath);
      this.mArkModel.init(paramInitInfo.appName, paramInitInfo.appView, paramInitInfo.minVersion, paramInitInfo.metaData, paramInitInfo.appConfig, f1);
      if (this.mMinSize != null)
      {
        this.mArkModel.setMinSize(this.mMinSize.width, this.mMinSize.height);
        localStringBuilder.append(".mMinSize=(").append(this.mMinSize.width).append(",").append(this.mMinSize.height).append(")");
      }
      if (this.mMaxSize != null)
      {
        this.mArkModel.setMaxSize(this.mMaxSize.width, this.mMaxSize.height);
        localStringBuilder.append(".mMaxSize=(").append(this.mMaxSize.width).append(",").append(this.mMaxSize.height).append(")");
      }
      if (this.mPrefferSize != null)
      {
        this.mArkModel.setMaxSize(this.mPrefferSize.width, this.mPrefferSize.height);
        localStringBuilder.append(".mPrefferSize=(").append(this.mPrefferSize.width).append(",").append(this.mPrefferSize.height).append(")");
      }
      if (this.mRadius > 0.0F) {
        super.setClipRadius(this.mRadius);
      }
      if (this.mRadiusTop > 0.0F) {
        super.setClipRadiusTop(this.mRadiusTop);
      }
      if (this.mBorderType >= 0) {
        super.setBorderType(this.mBorderType);
      }
      ENV.logI("ArkApp.ArkView", localStringBuilder.toString());
      super.initArkView(this.mArkModel);
    }
  }
  
  public boolean load(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, ArkViewImplement.LoadCallback paramLoadCallback)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      ENV.logI("ArkApp.ArkView", "load appname=" + paramString1 + ", appView=" + paramString2);
      this.mArkViewCallback = new WeakReference(paramLoadCallback);
      paramLoadCallback = new ArkView.InitInfo(null);
      paramLoadCallback.appPath = "";
      paramLoadCallback.appName = paramString1;
      paramLoadCallback.appView = paramString2;
      paramLoadCallback.minVersion = paramString3;
      paramLoadCallback.metaData = paramString4;
      paramLoadCallback.appConfig = paramString5;
      if (this.mGetArkViewSize) {
        loadImpl(paramLoadCallback);
      }
      for (this.mInfo = null;; this.mInfo = paramLoadCallback) {
        return true;
      }
    }
    return false;
  }
  
  public boolean loadPath(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, ArkViewImplement.LoadCallback paramLoadCallback)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      this.mArkViewCallback = new WeakReference(paramLoadCallback);
      ENV.logI("ArkApp.ArkView", "loadPath appname=" + paramString2 + ", appView=" + paramString3);
      paramLoadCallback = new ArkView.InitInfo(null);
      paramLoadCallback.appPath = paramString1;
      paramLoadCallback.appName = paramString2;
      paramLoadCallback.appView = paramString3;
      paramLoadCallback.minVersion = "";
      paramLoadCallback.metaData = paramString4;
      paramLoadCallback.appConfig = paramString5;
      if (this.mGetArkViewSize) {
        loadImpl(paramLoadCallback);
      }
      for (this.mInfo = null;; this.mInfo = paramLoadCallback) {
        return true;
      }
    }
    return false;
  }
  
  public void onDestroy()
  {
    if (this.mArkModel != null)
    {
      ENV.logI("ArkApp.ArkView", "onDestroy()");
      this.mArkModel.doOnEvent(2);
      this.mArkModel = null;
    }
  }
  
  public void onPause()
  {
    if (this.mArkModel != null)
    {
      ENV.logI("ArkApp.ArkView", "onPause()");
      this.mArkModel.doOnEvent(0);
    }
  }
  
  public void onResume()
  {
    if (this.mArkModel != null)
    {
      ENV.logI("ArkApp.ArkView", "onResume()");
      this.mArkModel.doOnEvent(1);
    }
  }
  
  public void setBorderType(int paramInt)
  {
    if (paramInt < 0)
    {
      ENV.logI("ArkApp.ArkView", "setBorderType invalid type=" + paramInt);
      return;
    }
    this.mBorderType = paramInt;
    ENV.logI("ArkApp.ArkView", "setBorderType invalid type=" + this.mBorderType);
  }
  
  public void setClipRadius(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      ENV.logI("ArkApp.ArkView", "setClipRadius invalid radius=" + paramFloat);
      return;
    }
    this.mRadius = paramFloat;
    ENV.logI("ArkApp.ArkView", "setClipRadius radius=" + paramFloat);
  }
  
  public void setClipRadiusTop(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      ENV.logI("ArkApp.ArkView", "setClipRadiusTop invalid radiusTop=" + paramFloat);
      return;
    }
    this.mRadiusTop = paramFloat;
    ENV.logI("ArkApp.ArkView", "setClipRadiusTop radiusTop=" + paramFloat);
  }
  
  public void setHardwareRenderingEnable(boolean paramBoolean)
  {
    this.mHardwareRenderingEnable = paramBoolean;
    ENV.logI("ArkApp.ArkView", "setHardwareRenderingEnable:" + paramBoolean);
  }
  
  public void setOnStartTemporaryDetach(boolean paramBoolean)
  {
    this.mOnStartTemporaryDetach = paramBoolean;
    ENV.logI("ArkApp.ArkView", "setOnStartTemporaryDetach:" + paramBoolean);
  }
  
  public void setScaleDensity(float paramFloat)
  {
    this.mScale = paramFloat;
  }
  
  public boolean setSize(ArkAppInfo.Size paramSize1, ArkAppInfo.Size paramSize2, ArkAppInfo.Size paramSize3)
  {
    if ((paramSize1 != null) || (paramSize2 != null) || (paramSize3 != null))
    {
      StringBuilder localStringBuilder = new StringBuilder("setSize");
      localStringBuilder.append(".hitSize=(").append(this.mHintSize.width).append(",").append(this.mHintSize.height).append(")");
      if (paramSize1 != null)
      {
        this.mPrefferSize.width = paramSize1.width;
        this.mPrefferSize.height = paramSize1.height;
        localStringBuilder.append(".prefferSize=(").append(this.mPrefferSize.width).append(",").append(this.mPrefferSize.height).append(")");
      }
      if (paramSize2 != null)
      {
        this.mMinSize.width = paramSize2.width;
        this.mMinSize.height = paramSize2.height;
        localStringBuilder.append(".minSize=(").append(this.mMinSize.width).append(",").append(this.mMinSize.height).append(")");
      }
      if (paramSize3 != null)
      {
        this.mMaxSize.width = paramSize3.width;
        this.mMaxSize.height = paramSize3.height;
        localStringBuilder.append(".maxSize=(").append(this.mMaxSize.width).append(",").append(this.mMaxSize.height).append(")");
      }
      ENV.logI("ArkApp.ArkView", localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  public boolean updateSize(ArkAppInfo.Size paramSize)
  {
    if (paramSize != null)
    {
      setViewRect(paramSize.width, paramSize.height);
      StringBuilder localStringBuilder = new StringBuilder("updateSize");
      localStringBuilder.append(".setViewRect=(").append(paramSize.width).append(",").append(paramSize.height).append(")");
      ENV.logI("ArkApp.ArkView", localStringBuilder.toString());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkView
 * JD-Core Version:    0.7.0.1
 */