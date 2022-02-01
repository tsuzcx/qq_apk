package com.tencent.mobileqq.apollo.view;

import amip;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import bgoe;
import bgog;
import bgoj;
import bjng;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import npo;

public class ApolloLottieAnim
  implements Handler.Callback
{
  public static final String FILE_DATA_JSON = "data.json";
  public static final String FILE_IMAGES = "images/";
  public static final String FILE_IMAGE_CACHE_PREFIX = "apollo://lottie_";
  private static final int MSG_CODE_PLAY_ANIMATION = 1;
  public static final int STATE_FAILED = 2;
  public static final int STATE_INIT = 0;
  public static final int STATE_LOADING = 1;
  public static final int STATE_RES_DONE = 3;
  public static final String TAG = "ApolloLottieAnim";
  private boolean mAutoPlay;
  private WeakReference<Context> mContextRef;
  private ApolloLottieAnim.DecoderRunnable mDecoderRunnable = new ApolloLottieAnim.DecoderRunnable();
  private boolean mIsDestroy;
  private boolean mIsLottieJsonLoaded;
  private String mLocalZipPath;
  private WeakReference<DiniFlyAnimationView> mLottieAnimView;
  private bjng mMainHandler = new bjng(paramContext.getMainLooper(), this);
  public int mState = 0;
  private String mZipUrl;
  
  public ApolloLottieAnim(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.mContextRef = new WeakReference(paramContext);
  }
  
  private void init(boolean paramBoolean, File paramFile, String paramString)
  {
    if (paramBoolean) {}
    try
    {
      unZipFile(paramFile, paramString);
      if (!isLottieAnimJsonDone(paramString))
      {
        QLog.e("ApolloLottieAnim", 1, "Lottie Anim data.json not exit");
        return;
      }
      this.mState = 3;
      stop();
      sendPlayAnimMsg(paramString);
      return;
    }
    catch (Exception paramFile)
    {
      QLog.e("ApolloLottieAnim", 2, paramFile.getMessage());
      this.mState = 2;
    }
  }
  
  public static String makeApolloZipPath(String paramString)
  {
    paramString = Utils.Crc64String(paramString);
    String str = amip.k;
    return str + paramString + ".zip";
  }
  
  private void sendPlayAnimMsg(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putString("folder", paramString);
    localMessage.setData(localBundle);
    this.mMainHandler.sendMessage(localMessage);
  }
  
  private void setZipData(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return;
      this.mAutoPlay = paramBoolean;
      if (!paramString2.equals(this.mLocalZipPath))
      {
        this.mLocalZipPath = paramString2;
        this.mState = 0;
      }
      paramString2 = zipPath2UnzipDir(this.mLocalZipPath);
      new File(paramString2).mkdirs();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLottieAnim", 2, new Object[] { "setZipData mState:", Integer.valueOf(this.mState), ",zipUrl:", paramString1, ",localZipPath:", this.mLocalZipPath });
      }
      paramBoolean = isLottieAnimJsonDone(paramString2);
      if (!paramBoolean)
      {
        QLog.w("ApolloLottieAnim", 1, "setZipData Lottie Anim data.json not exit");
        this.mState = 0;
      }
      if ((this.mState == 2) || (this.mState == 0))
      {
        this.mIsLottieJsonLoaded = false;
        File localFile = new File(this.mLocalZipPath);
        if (paramBoolean)
        {
          init(false, localFile, paramString2);
          return;
        }
        if (localFile.exists())
        {
          init(true, localFile, paramString2);
          return;
        }
        download(paramString1, this.mLocalZipPath, paramString2);
        return;
      }
    } while (this.mState != 3);
    init(false, null, paramString2);
  }
  
  private void unZipFile(File paramFile, String paramString)
  {
    if ((paramFile.exists()) && (!TextUtils.isEmpty(paramString))) {
      npo.a(paramFile, paramString);
    }
  }
  
  private String zipPath2UnzipDir(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf(".zip");
      String str = paramString;
      if (i > 0) {
        str = paramString.substring(0, i);
      }
      return str + File.separator;
    }
    return "";
  }
  
  public void destroy()
  {
    stop();
    this.mIsLottieJsonLoaded = false;
    this.mIsDestroy = true;
  }
  
  protected void download(String paramString1, String paramString2, String paramString3)
  {
    this.mState = 1;
    bgoe localbgoe = new bgoe(paramString1, new File(paramString2));
    localbgoe.p = true;
    localbgoe.n = true;
    localbgoe.f = "apollo_lottie";
    localbgoe.b = 1;
    localbgoe.q = true;
    localbgoe.r = true;
    localbgoe.a(new ApolloLottieAnim.2(this, paramString1, paramString2, paramString3));
    paramString1 = BaseApplicationImpl.getApplication();
    if (paramString1 != null)
    {
      paramString1 = paramString1.getRuntime();
      if (!(paramString1 instanceof QQAppInterface)) {}
    }
    for (paramString1 = (QQAppInterface)paramString1;; paramString1 = null)
    {
      if (paramString1 != null)
      {
        paramString1 = (bgog)paramString1.getManager(47);
        if (paramString1 != null)
        {
          paramString1 = paramString1.a(3);
          if (paramString1 != null) {
            paramString1.a(localbgoe, localbgoe.a(), null);
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          ThreadManager.executeOnNetWorkThread(new ApolloLottieAnim.3(this, localbgoe));
        }
        return;
      }
    }
  }
  
  public void fromFileWithCacheBitmap(Context paramContext, @NonNull DiniFlyAnimationView paramDiniFlyAnimationView, String paramString, boolean paramBoolean)
  {
    try
    {
      if (this.mLottieAnimView == null) {
        this.mLottieAnimView = new WeakReference(paramDiniFlyAnimationView);
      }
      fromInputStreamWithCacheBitmap(paramContext, paramDiniFlyAnimationView, paramString, new FileInputStream(paramString + "data.json"), paramBoolean);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("ApolloLottieAnim", 1, "fromFileWithCacheBitmap:" + paramContext);
    }
  }
  
  public void fromInputStreamWithCacheBitmap(Context paramContext, @NonNull DiniFlyAnimationView paramDiniFlyAnimationView, String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLottieAnim", 2, new Object[] { "fromFileWithCacheBitmap animPathFolder:", paramString });
      }
    } while (paramDiniFlyAnimationView.isAnimating());
    if ((this.mIsLottieJsonLoaded) && (paramBoolean))
    {
      paramDiniFlyAnimationView.playAnimation();
      return;
    }
    for (;;)
    {
      try
      {
        ApolloLottieAnim.1 local1 = new ApolloLottieAnim.1(this, paramDiniFlyAnimationView, paramBoolean);
        Bundle localBundle = new Bundle();
        StringBuilder localStringBuilder = new StringBuilder().append("apollo://lottie_");
        if (TextUtils.isEmpty(this.mZipUrl))
        {
          str = paramString;
          localBundle.putString("key", Utils.Crc64String(str));
          localBundle.putString("path", paramString + "images/");
          LottieComposition.Factory.fromInputStreamWithCacheBitmap(paramContext, paramInputStream, paramDiniFlyAnimationView.getLottieDrawable(), local1, localBundle, getMemoryCache());
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("ApolloLottieAnim", 1, "playApolloGameBoxLottieAnim:" + paramContext);
        return;
      }
      String str = this.mZipUrl;
    }
  }
  
  public void fromNetworkWithCacheBitmap(@NonNull DiniFlyAnimationView paramDiniFlyAnimationView, String paramString)
  {
    fromNetworkWithCacheBitmap(paramDiniFlyAnimationView, paramString, makeApolloZipPath(paramString), true);
  }
  
  public void fromNetworkWithCacheBitmap(@NonNull DiniFlyAnimationView paramDiniFlyAnimationView, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    this.mLottieAnimView = new WeakReference(paramDiniFlyAnimationView);
    this.mZipUrl = paramString1;
    this.mDecoderRunnable.setZipData(this, paramString1, paramString2, paramBoolean);
    ThreadManager.removeJobFromThreadPool(this.mDecoderRunnable, 16);
    ThreadManager.excute(this.mDecoderRunnable, 16, null, true);
  }
  
  protected MQLruCache<String, Object> getMemoryCache()
  {
    return BaseApplicationImpl.sImageCache;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((this.mContextRef != null) && (this.mContextRef.get() != null) && (this.mLottieAnimView != null) && (this.mLottieAnimView.get() != null))
      {
        paramMessage = paramMessage.getData().getString("folder");
        fromFileWithCacheBitmap((Context)this.mContextRef.get(), (DiniFlyAnimationView)this.mLottieAnimView.get(), paramMessage, this.mAutoPlay);
      }
    }
  }
  
  public boolean isLottieAnimJsonDone(String paramString)
  {
    return new File(paramString + "data.json").exists();
  }
  
  public void onDownloadFinish(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloLottieAnim", 2, "onDownloadFinish，result:" + paramBoolean + " url:" + paramString1 + " zipFile:" + paramString2 + " folder:" + paramString3);
    }
    if ((this.mLocalZipPath != null) && (!this.mLocalZipPath.equals(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLottieAnim", 2, "onDownloadFinish，zipFile unEqual mLocalZipPath:" + this.mLocalZipPath);
      }
      return;
    }
    if (paramBoolean)
    {
      paramString1 = new File(paramString2);
      if (paramString1.exists())
      {
        init(true, paramString1, paramString3);
        return;
      }
      this.mState = 2;
      return;
    }
    this.mState = 2;
  }
  
  public void stop()
  {
    ThreadManager.getUIHandler().post(new ApolloLottieAnim.4(this));
    if (this.mMainHandler != null) {
      this.mMainHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloLottieAnim
 * JD-Core Version:    0.7.0.1
 */