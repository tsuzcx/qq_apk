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
import com.tencent.ark.Logger;
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
    ArkDelegateManager.setupArkEnvironment(true);
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
      localStringBuilder.append(",gpuRenderingEnabled=");
      localStringBuilder.append(this.mHardwareRenderingEnable);
      setInputCallback(ArkDelegateManager.getInstance().getInputCallback());
      WeakReference localWeakReference = this.mArkViewCallback;
      if (localWeakReference != null) {
        setLoadCallback((ArkViewImplement.LoadCallback)localWeakReference.get());
      }
      float f2 = this.mScale;
      float f1 = f2;
      if (f2 == 0.0F) {
        f1 = this.mContext.getResources().getDisplayMetrics().scaledDensity;
      }
      this.mArkModel.setAppPath(paramInitInfo.appPath);
      this.mArkModel.setResPath(paramInitInfo.resPath);
      this.mArkModel.init(paramInitInfo.appID, paramInitInfo.view, paramInitInfo.minVersion, paramInitInfo.meta, paramInitInfo.config, f1);
      paramInitInfo = this.mMinSize;
      if (paramInitInfo != null)
      {
        this.mArkModel.setMinSize(paramInitInfo.width, this.mMinSize.height);
        localStringBuilder.append(".mMinSize=(");
        localStringBuilder.append(this.mMinSize.width);
        localStringBuilder.append(",");
        localStringBuilder.append(this.mMinSize.height);
        localStringBuilder.append(")");
      }
      paramInitInfo = this.mMaxSize;
      if (paramInitInfo != null)
      {
        this.mArkModel.setMaxSize(paramInitInfo.width, this.mMaxSize.height);
        localStringBuilder.append(".mMaxSize=(");
        localStringBuilder.append(this.mMaxSize.width);
        localStringBuilder.append(",");
        localStringBuilder.append(this.mMaxSize.height);
        localStringBuilder.append(")");
      }
      paramInitInfo = this.mPrefferSize;
      if (paramInitInfo != null)
      {
        this.mArkModel.setMaxSize(paramInitInfo.width, this.mPrefferSize.height);
        localStringBuilder.append(".mPrefferSize=(");
        localStringBuilder.append(this.mPrefferSize.width);
        localStringBuilder.append(",");
        localStringBuilder.append(this.mPrefferSize.height);
        localStringBuilder.append(")");
      }
      f1 = this.mRadius;
      if (f1 > 0.0F) {
        super.setClipRadius(f1);
      }
      f1 = this.mRadiusTop;
      if (f1 > 0.0F) {
        super.setClipRadiusTop(f1);
      }
      int i = this.mBorderType;
      if (i >= 0) {
        super.setBorderType(i);
      }
      Logger.logI("ArkApp.ArkView", localStringBuilder.toString());
      super.initArkView(this.mArkModel);
    }
  }
  
  public boolean load(ArkView.InitInfo paramInitInfo, ArkViewImplement.LoadCallback paramLoadCallback)
  {
    if ((paramInitInfo != null) && (paramInitInfo.isValid()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load app=");
      localStringBuilder.append(paramInitInfo.appID);
      localStringBuilder.append(", view=");
      localStringBuilder.append(paramInitInfo.view);
      Logger.logI("ArkApp.ArkView", localStringBuilder.toString());
      this.mArkViewCallback = new WeakReference(paramLoadCallback);
      if (this.mGetArkViewSize)
      {
        loadImpl(paramInitInfo);
        this.mInfo = null;
      }
      else
      {
        this.mInfo = paramInitInfo;
      }
      return true;
    }
    return false;
  }
  
  public boolean load(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, ArkViewImplement.LoadCallback paramLoadCallback)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load appname=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", appView=");
      localStringBuilder.append(paramString2);
      Logger.logI("ArkApp.ArkView", localStringBuilder.toString());
      this.mArkViewCallback = new WeakReference(paramLoadCallback);
      paramLoadCallback = new ArkView.InitInfo();
      paramLoadCallback.appPath = "";
      paramLoadCallback.appID = paramString1;
      paramLoadCallback.view = paramString2;
      paramLoadCallback.minVersion = paramString3;
      paramLoadCallback.meta = paramString4;
      paramLoadCallback.config = paramString5;
      if (this.mGetArkViewSize)
      {
        loadImpl(paramLoadCallback);
        this.mInfo = null;
      }
      else
      {
        this.mInfo = paramLoadCallback;
      }
      return true;
    }
    return false;
  }
  
  public boolean loadPath(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, ArkViewImplement.LoadCallback paramLoadCallback)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      this.mArkViewCallback = new WeakReference(paramLoadCallback);
      paramLoadCallback = new StringBuilder();
      paramLoadCallback.append("loadPath appname=");
      paramLoadCallback.append(paramString2);
      paramLoadCallback.append(", appView=");
      paramLoadCallback.append(paramString3);
      Logger.logI("ArkApp.ArkView", paramLoadCallback.toString());
      paramLoadCallback = new ArkView.InitInfo();
      paramLoadCallback.appPath = paramString1;
      paramLoadCallback.appID = paramString2;
      paramLoadCallback.view = paramString3;
      paramLoadCallback.minVersion = "";
      paramLoadCallback.meta = paramString4;
      paramLoadCallback.config = paramString5;
      if (this.mGetArkViewSize)
      {
        loadImpl(paramLoadCallback);
        this.mInfo = null;
      }
      else
      {
        this.mInfo = paramLoadCallback;
      }
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    if (this.mArkModel != null)
    {
      Logger.logI("ArkApp.ArkView", "onDestroy()");
      this.mArkModel.doOnEvent(2);
      this.mArkModel = null;
    }
  }
  
  public void onPause()
  {
    if (this.mArkModel != null)
    {
      Logger.logI("ArkApp.ArkView", "onPause()");
      this.mArkModel.doOnEvent(0);
    }
  }
  
  public void onResume()
  {
    if (this.mArkModel != null)
    {
      Logger.logI("ArkApp.ArkView", "onResume()");
      this.mArkModel.doOnEvent(1);
    }
  }
  
  public void setBorderType(int paramInt)
  {
    if (paramInt < 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setBorderType invalid type=");
      localStringBuilder.append(paramInt);
      Logger.logI("ArkApp.ArkView", localStringBuilder.toString());
      return;
    }
    this.mBorderType = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setBorderType invalid type=");
    localStringBuilder.append(this.mBorderType);
    Logger.logI("ArkApp.ArkView", localStringBuilder.toString());
  }
  
  public void setClipRadius(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setClipRadius invalid radius=");
      localStringBuilder.append(paramFloat);
      Logger.logI("ArkApp.ArkView", localStringBuilder.toString());
      return;
    }
    this.mRadius = paramFloat;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setClipRadius radius=");
    localStringBuilder.append(paramFloat);
    Logger.logI("ArkApp.ArkView", localStringBuilder.toString());
  }
  
  public void setClipRadiusTop(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setClipRadiusTop invalid radiusTop=");
      localStringBuilder.append(paramFloat);
      Logger.logI("ArkApp.ArkView", localStringBuilder.toString());
      return;
    }
    this.mRadiusTop = paramFloat;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setClipRadiusTop radiusTop=");
    localStringBuilder.append(paramFloat);
    Logger.logI("ArkApp.ArkView", localStringBuilder.toString());
  }
  
  public void setHardwareRenderingEnable(boolean paramBoolean)
  {
    this.mHardwareRenderingEnable = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setHardwareRenderingEnable:");
    localStringBuilder.append(paramBoolean);
    Logger.logI("ArkApp.ArkView", localStringBuilder.toString());
  }
  
  public void setOnStartTemporaryDetach(boolean paramBoolean)
  {
    this.mOnStartTemporaryDetach = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setOnStartTemporaryDetach:");
    localStringBuilder.append(paramBoolean);
    Logger.logI("ArkApp.ArkView", localStringBuilder.toString());
  }
  
  public void setScaleDensity(float paramFloat)
  {
    this.mScale = paramFloat;
  }
  
  public boolean setSize(ArkAppInfo.Size paramSize1, ArkAppInfo.Size paramSize2, ArkAppInfo.Size paramSize3)
  {
    if ((paramSize1 == null) && (paramSize2 == null) && (paramSize3 == null)) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder("setSize");
    localStringBuilder.append(".hitSize=(");
    localStringBuilder.append(this.mHintSize.width);
    localStringBuilder.append(",");
    localStringBuilder.append(this.mHintSize.height);
    localStringBuilder.append(")");
    if (paramSize1 != null)
    {
      this.mPrefferSize.width = paramSize1.width;
      this.mPrefferSize.height = paramSize1.height;
      localStringBuilder.append(".prefferSize=(");
      localStringBuilder.append(this.mPrefferSize.width);
      localStringBuilder.append(",");
      localStringBuilder.append(this.mPrefferSize.height);
      localStringBuilder.append(")");
    }
    if (paramSize2 != null)
    {
      this.mMinSize.width = paramSize2.width;
      this.mMinSize.height = paramSize2.height;
      localStringBuilder.append(".minSize=(");
      localStringBuilder.append(this.mMinSize.width);
      localStringBuilder.append(",");
      localStringBuilder.append(this.mMinSize.height);
      localStringBuilder.append(")");
    }
    if (paramSize3 != null)
    {
      this.mMaxSize.width = paramSize3.width;
      this.mMaxSize.height = paramSize3.height;
      localStringBuilder.append(".maxSize=(");
      localStringBuilder.append(this.mMaxSize.width);
      localStringBuilder.append(",");
      localStringBuilder.append(this.mMaxSize.height);
      localStringBuilder.append(")");
    }
    Logger.logI("ArkApp.ArkView", localStringBuilder.toString());
    return true;
  }
  
  public boolean updateSize(ArkAppInfo.Size paramSize)
  {
    if (paramSize != null)
    {
      setViewRect(paramSize.width, paramSize.height);
      StringBuilder localStringBuilder = new StringBuilder("updateSize");
      localStringBuilder.append(".setViewRect=(");
      localStringBuilder.append(paramSize.width);
      localStringBuilder.append(",");
      localStringBuilder.append(paramSize.height);
      localStringBuilder.append(")");
      Logger.logI("ArkApp.ArkView", localStringBuilder.toString());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkView
 * JD-Core Version:    0.7.0.1
 */