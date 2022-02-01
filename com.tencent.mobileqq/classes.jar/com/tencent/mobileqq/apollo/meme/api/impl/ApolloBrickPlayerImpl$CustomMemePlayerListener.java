package com.tencent.mobileqq.apollo.meme.api.impl;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.meme.IGetGifFrameCallback;
import com.tencent.mobileqq.apollo.meme.IMemePlayerListener;
import com.tencent.mobileqq.apollo.meme.MemeHelper;
import com.tencent.mobileqq.apollo.meme.action.MODE;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ApolloBrickPlayerImpl$CustomMemePlayerListener
  implements IMemePlayerListener
{
  private int a;
  private int b;
  private int c;
  private int d;
  private WeakReference<ImageView> e;
  private WeakReference<ImageView> f;
  private WeakReference<RelativeLayout> g;
  private WeakReference<Handler> h;
  private WeakReference<Map<String, URLDrawable.URLDrawableOptions>> i;
  private WeakReference<IGetGifFrameCallback> j;
  private volatile boolean k = false;
  private volatile boolean l = true;
  
  public ApolloBrickPlayerImpl$CustomMemePlayerListener(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  private Drawable a(boolean paramBoolean, MemeAction paramMemeAction, String paramString)
  {
    URLDrawable localURLDrawable2 = null;
    Object localObject = paramMemeAction.a(null, null);
    if (paramBoolean) {
      localURLDrawable1 = localURLDrawable2;
    }
    try
    {
      ApolloBrickPlayerImpl.access$100().put(localObject, paramString);
      localURLDrawable1 = localURLDrawable2;
      ((IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class)).putAction2GifFilePath(this.a, paramMemeAction.c().j, paramString);
      localURLDrawable1 = localURLDrawable2;
      if (paramMemeAction.i() == MODE.ACTION_MODE_RECORD_GIF)
      {
        localURLDrawable1 = localURLDrawable2;
        localURLDrawable2 = ApolloBrickPlayerImpl.access$400(paramString, (Map)a(this.i), this.d);
        localURLDrawable1 = localURLDrawable2;
        localObject = localURLDrawable2;
        if (this.j.get() == null) {
          break label185;
        }
        localURLDrawable1 = localURLDrawable2;
        ((IGetGifFrameCallback)this.j.get()).a(paramBoolean, paramString, paramMemeAction);
        return localURLDrawable2;
      }
      localURLDrawable1 = localURLDrawable2;
      return ApolloBrickPlayerImpl.access$600(paramString, (Map)a(this.i));
    }
    catch (Exception paramMemeAction)
    {
      QLog.e("[cmshow]ApolloBrickPlayer", 1, "getDrawableByAction exception, :", paramMemeAction);
      localObject = localURLDrawable1;
    }
    URLDrawable localURLDrawable1 = localURLDrawable2;
    paramMemeAction = URLDrawableHelper.getFailedDrawable();
    return paramMemeAction;
    label185:
    return localObject;
  }
  
  private URLDrawable.URLDrawableListener a(String paramString)
  {
    return new ApolloBrickPlayerImpl.CustomMemePlayerListener.3(this, paramString);
  }
  
  private <T> T a(WeakReference<T> paramWeakReference)
  {
    if ((paramWeakReference != null) && (paramWeakReference.get() != null)) {
      return paramWeakReference.get();
    }
    return null;
  }
  
  private void a(@NotNull MemeAction paramMemeAction, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3, int paramInt4)
  {
    ImageView localImageView = (ImageView)a(this.f);
    if ((localImageView != null) && (localImageView.getVisibility() == 0))
    {
      String str = paramMemeAction.a(null, null);
      Object localObject2 = (ApolloRepeatPngDrawable)localImageView.getTag();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ApolloRepeatPngDrawable(str, paramInt1);
        localImageView.setTag(localObject1);
      }
      localObject2 = localObject1;
      if (!str.equals(((ApolloRepeatPngDrawable)localObject1).d()))
      {
        ((ApolloRepeatPngDrawable)localObject1).a();
        localObject2 = new ApolloRepeatPngDrawable(str, paramInt1);
        localImageView.setTag(localObject2);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("showFrameOnPreImageView create new pngDrawable:");
        ((StringBuilder)localObject1).append(localObject2);
        ((StringBuilder)localObject1).append(" for preview:");
        ((StringBuilder)localObject1).append(a(this.f));
        ((StringBuilder)localObject1).append(", actionKey:");
        ((StringBuilder)localObject1).append(str);
        QLog.w("[cmshow]ApolloBrickPlayer", 1, ((StringBuilder)localObject1).toString());
      }
      int m = CmShowWnsUtils.x();
      if (((ApolloRepeatPngDrawable)localObject2).c() >= m)
      {
        paramMemeAction = new StringBuilder();
        paramMemeAction.append("showFrameOnPreImageView ");
        paramMemeAction.append(localObject2);
        paramMemeAction.append(" totalFrameCount exceed maxFrameCount, return");
        QLog.w("[cmshow]ApolloBrickPlayer", 1, paramMemeAction.toString());
        return;
      }
      if ((((ApolloRepeatPngDrawable)localObject2).b() == -1) && (((ApolloRepeatPngDrawable)localObject2).c() == 0) && (paramInt2 > 0))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("showFrameOnPreImageView ");
        ((StringBuilder)localObject1).append(localObject2);
        ((StringBuilder)localObject1).append(" correct index from ");
        ((StringBuilder)localObject1).append(paramInt2);
        ((StringBuilder)localObject1).append(" to ");
        ((StringBuilder)localObject1).append(0);
        QLog.w("[cmshow]ApolloBrickPlayer", 1, ((StringBuilder)localObject1).toString());
        m = 0;
      }
      else
      {
        m = paramInt2;
      }
      if (((ApolloRepeatPngDrawable)localObject2).a(m))
      {
        paramMemeAction = new StringBuilder();
        paramMemeAction.append("showFrameOnPreImageView ");
        paramMemeAction.append(localObject2);
        paramMemeAction.append(" already contain ");
        paramMemeAction.append(m);
        QLog.e("[cmshow]ApolloBrickPlayer", 1, paramMemeAction.toString());
        return;
      }
      ((ApolloRepeatPngDrawable)localObject2).a(m, paramArrayOfByte, paramInt3, paramInt4, this.b, this.c, paramInt1);
      if (this.l)
      {
        this.l = false;
        paramArrayOfByte = new RelativeLayout.LayoutParams(this.b, this.c);
        paramArrayOfByte.addRule(13);
        localImageView.setLayoutParams(paramArrayOfByte);
        localImageView.setImageDrawable((Drawable)localObject2);
        if (paramInt2 == 0) {
          TraceReportUtil.a(MemeHelper.a.a(paramMemeAction.i()), str, 5, 0, new Object[] { paramMemeAction.h() });
        }
      }
    }
  }
  
  private void a(MemeAction paramMemeAction, Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      QLog.w("[cmshow]ApolloBrickPlayer", 1, "refreshViewOnRecordDone, but drawable is null");
      return;
    }
    a(new ApolloBrickPlayerImpl.CustomMemePlayerListener.2(this, paramMemeAction.m(), paramDrawable, paramMemeAction.a(null, null)));
  }
  
  private void a(Runnable paramRunnable)
  {
    Handler localHandler = (Handler)a(this.h);
    if (localHandler != null) {
      localHandler.post(paramRunnable);
    }
  }
  
  private void b()
  {
    ImageView localImageView = (ImageView)a(this.f);
    if (localImageView != null)
    {
      localImageView.setVisibility(8);
      ApolloRepeatPngDrawable localApolloRepeatPngDrawable = (ApolloRepeatPngDrawable)localImageView.getTag();
      if (localApolloRepeatPngDrawable != null)
      {
        localApolloRepeatPngDrawable.a();
        localImageView.setTag(null);
      }
    }
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this);
    localStringBuilder.append(" destroy. mActionId:");
    localStringBuilder.append(this.a);
    QLog.e("[cmshow]ApolloBrickPlayer", 1, localStringBuilder.toString());
    this.k = true;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = null;
    this.i = null;
    this.j = null;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(Handler paramHandler)
  {
    this.h = new WeakReference(paramHandler);
  }
  
  public void a(ImageView paramImageView)
  {
    this.e = new WeakReference(paramImageView);
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    this.g = new WeakReference(paramRelativeLayout);
  }
  
  public void a(IGetGifFrameCallback paramIGetGifFrameCallback)
  {
    this.j = new WeakReference(paramIGetGifFrameCallback);
  }
  
  public void a(@NotNull MemeAction paramMemeAction, int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.k) {
      return;
    }
    if (!CmShowWnsUtils.v()) {
      return;
    }
    int m;
    if (paramMemeAction.i() == MODE.ACTION_MODE_RECORD_GIF) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0) {
      return;
    }
    String str = paramMemeAction.a(null, null);
    if (this.a != paramMemeAction.m())
    {
      paramMemeAction = new StringBuilder();
      paramMemeAction.append(this);
      paramMemeAction.append(" onRecordFrame return, mActionId ");
      paramMemeAction.append(this.a);
      paramMemeAction.append(", actionKey:");
      paramMemeAction.append(str);
      QLog.w("[cmshow]ApolloBrickPlayer", 2, paramMemeAction.toString());
      return;
    }
    if ((Handler)a(this.h) == null) {
      return;
    }
    ThreadManager.excute(new ApolloBrickPlayerImpl.CustomMemePlayerListener.1(this, paramArrayOfByte, str, paramInt1, paramInt2, paramInt3, paramInt4, paramMemeAction), 128, null, false);
  }
  
  public void a(@NotNull MemeAction paramMemeAction, boolean paramBoolean, @NotNull String paramString1, @Nullable String paramString2)
  {
    if (this.k) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("onRecordDone ");
      paramString1.append(paramBoolean);
      paramString1.append(" mActionId ");
      paramString1.append(this.a);
      paramString1.append(" ");
      paramString1.append(paramString2);
      QLog.w("[cmshow]ApolloBrickPlayer", 2, paramString1.toString());
    }
    a(paramMemeAction, a(paramBoolean, paramMemeAction, paramString2));
    paramMemeAction = paramMemeAction.a(null, null);
    if (ApolloBrickPlayerImpl.access$1200().containsKey(paramMemeAction)) {
      ApolloBrickPlayerImpl.access$1200().remove(paramMemeAction);
    }
  }
  
  public void a(Map<String, URLDrawable.URLDrawableOptions> paramMap)
  {
    this.i = new WeakReference(paramMap);
  }
  
  public void b(ImageView paramImageView)
  {
    this.f = new WeakReference(paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.api.impl.ApolloBrickPlayerImpl.CustomMemePlayerListener
 * JD-Core Version:    0.7.0.1
 */