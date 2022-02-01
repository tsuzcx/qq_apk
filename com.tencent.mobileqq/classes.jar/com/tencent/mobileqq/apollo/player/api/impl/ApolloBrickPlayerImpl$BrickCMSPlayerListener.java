package com.tencent.mobileqq.apollo.player.api.impl;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.player.CMSActionStatus;
import com.tencent.mobileqq.apollo.player.CMSHelper;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.mobileqq.apollo.player.IGetGifFrameCallback;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.action.MODE;
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

class ApolloBrickPlayerImpl$BrickCMSPlayerListener
  implements ICMSPlayerListener
{
  private int jdField_a_of_type_Int;
  private WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private WeakReference<ImageView> jdField_b_of_type_JavaLangRefWeakReference;
  private volatile boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private WeakReference<RelativeLayout> jdField_c_of_type_JavaLangRefWeakReference;
  private int jdField_d_of_type_Int;
  private WeakReference<Handler> jdField_d_of_type_JavaLangRefWeakReference;
  private WeakReference<Map<String, URLDrawable.URLDrawableOptions>> e;
  private WeakReference<IGetGifFrameCallback> f;
  
  public ApolloBrickPlayerImpl$BrickCMSPlayerListener(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
  }
  
  private Drawable a(boolean paramBoolean, CMSAction paramCMSAction, String paramString)
  {
    URLDrawable localURLDrawable2 = null;
    Object localObject = paramCMSAction.a(null, null);
    if (paramBoolean) {
      localURLDrawable1 = localURLDrawable2;
    }
    try
    {
      ApolloBrickPlayerImpl.access$100().put(localObject, paramString);
      localURLDrawable1 = localURLDrawable2;
      ((IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class)).putAction2GifFilePath(this.jdField_a_of_type_Int, paramCMSAction.a().a, paramString);
      localURLDrawable1 = localURLDrawable2;
      if (paramCMSAction.a() == MODE.ACTION_MODE_RECORD_GIF)
      {
        localURLDrawable1 = localURLDrawable2;
        localURLDrawable2 = ApolloBrickPlayerImpl.access$400(paramString, (Map)a(this.e), this.jdField_d_of_type_Int);
        localURLDrawable1 = localURLDrawable2;
        localObject = localURLDrawable2;
        if (this.f.get() == null) {
          break label185;
        }
        localURLDrawable1 = localURLDrawable2;
        ((IGetGifFrameCallback)this.f.get()).a(paramBoolean, paramString, paramCMSAction);
        return localURLDrawable2;
      }
      localURLDrawable1 = localURLDrawable2;
      return ApolloBrickPlayerImpl.access$600(paramString, (Map)a(this.e));
    }
    catch (Exception paramCMSAction)
    {
      QLog.e("[cmshow]ApolloBrickPlayer", 1, "getDrawableByAction exception, :", paramCMSAction);
      localObject = localURLDrawable1;
    }
    URLDrawable localURLDrawable1 = localURLDrawable2;
    paramCMSAction = URLDrawableHelper.getFailedDrawable();
    return paramCMSAction;
    label185:
    return localObject;
  }
  
  private URLDrawable.URLDrawableListener a(String paramString)
  {
    return new ApolloBrickPlayerImpl.BrickCMSPlayerListener.3(this, paramString);
  }
  
  private <T> T a(WeakReference<T> paramWeakReference)
  {
    if ((paramWeakReference != null) && (paramWeakReference.get() != null)) {
      return paramWeakReference.get();
    }
    return null;
  }
  
  private void a(@NotNull CMSAction paramCMSAction, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3, int paramInt4)
  {
    ImageView localImageView = (ImageView)a(this.jdField_b_of_type_JavaLangRefWeakReference);
    if ((localImageView != null) && (localImageView.getVisibility() == 0))
    {
      String str = paramCMSAction.a(null, null);
      Object localObject2 = (ApolloRepeatPngDrawable)localImageView.getTag();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ApolloRepeatPngDrawable(str, paramInt1);
        localImageView.setTag(localObject1);
      }
      localObject2 = localObject1;
      if (!str.equals(((ApolloRepeatPngDrawable)localObject1).a()))
      {
        ((ApolloRepeatPngDrawable)localObject1).a();
        localObject2 = new ApolloRepeatPngDrawable(str, paramInt1);
        localImageView.setTag(localObject2);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("showFrameOnPreImageView create new pngDrawable:");
        ((StringBuilder)localObject1).append(localObject2);
        ((StringBuilder)localObject1).append(" for preview:");
        ((StringBuilder)localObject1).append(a(this.jdField_b_of_type_JavaLangRefWeakReference));
        ((StringBuilder)localObject1).append(", actionKey:");
        ((StringBuilder)localObject1).append(str);
        QLog.w("[cmshow]ApolloBrickPlayer", 1, ((StringBuilder)localObject1).toString());
      }
      int i = CmShowWnsUtils.b();
      if (((ApolloRepeatPngDrawable)localObject2).b() >= i)
      {
        paramCMSAction = new StringBuilder();
        paramCMSAction.append("showFrameOnPreImageView ");
        paramCMSAction.append(localObject2);
        paramCMSAction.append(" totalFrameCount exceed maxFrameCount, return");
        QLog.w("[cmshow]ApolloBrickPlayer", 1, paramCMSAction.toString());
        return;
      }
      if ((((ApolloRepeatPngDrawable)localObject2).a() == -1) && (((ApolloRepeatPngDrawable)localObject2).b() == 0) && (paramInt2 > 0))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("showFrameOnPreImageView ");
        ((StringBuilder)localObject1).append(localObject2);
        ((StringBuilder)localObject1).append(" correct index from ");
        ((StringBuilder)localObject1).append(paramInt2);
        ((StringBuilder)localObject1).append(" to ");
        ((StringBuilder)localObject1).append(0);
        QLog.w("[cmshow]ApolloBrickPlayer", 1, ((StringBuilder)localObject1).toString());
        i = 0;
      }
      else
      {
        i = paramInt2;
      }
      if (((ApolloRepeatPngDrawable)localObject2).a(i))
      {
        paramCMSAction = new StringBuilder();
        paramCMSAction.append("showFrameOnPreImageView ");
        paramCMSAction.append(localObject2);
        paramCMSAction.append(" already contain ");
        paramCMSAction.append(i);
        QLog.e("[cmshow]ApolloBrickPlayer", 1, paramCMSAction.toString());
        return;
      }
      ((ApolloRepeatPngDrawable)localObject2).a(i, paramArrayOfByte, paramInt3, paramInt4, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, paramInt1);
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        paramArrayOfByte = new RelativeLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
        paramArrayOfByte.addRule(13);
        localImageView.setLayoutParams(paramArrayOfByte);
        localImageView.setImageDrawable((Drawable)localObject2);
        if (paramInt2 == 0) {
          TraceReportUtil.a(CMSHelper.a.a(paramCMSAction.a()), str, 5, 0, new Object[0]);
        }
      }
    }
  }
  
  private void a(CMSAction paramCMSAction, Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      QLog.w("[cmshow]ApolloBrickPlayer", 1, "refreshViewOnRecordDone, but drawable is null");
      return;
    }
    a(new ApolloBrickPlayerImpl.BrickCMSPlayerListener.2(this, paramCMSAction.d(), paramDrawable, paramCMSAction.a(null, null)));
  }
  
  private void a(Runnable paramRunnable)
  {
    Handler localHandler = (Handler)a(this.jdField_d_of_type_JavaLangRefWeakReference);
    if (localHandler != null) {
      localHandler.post(paramRunnable);
    }
  }
  
  private void b()
  {
    ImageView localImageView = (ImageView)a(this.jdField_b_of_type_JavaLangRefWeakReference);
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
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.e("[cmshow]ApolloBrickPlayer", 1, localStringBuilder.toString());
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_b_of_type_JavaLangRefWeakReference = null;
    this.jdField_c_of_type_JavaLangRefWeakReference = null;
    this.jdField_d_of_type_JavaLangRefWeakReference = null;
    this.e = null;
    this.f = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void a(Handler paramHandler)
  {
    this.jdField_d_of_type_JavaLangRefWeakReference = new WeakReference(paramHandler);
  }
  
  public void a(ImageView paramImageView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramImageView);
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(paramRelativeLayout);
  }
  
  public void a(IGetGifFrameCallback paramIGetGifFrameCallback)
  {
    this.f = new WeakReference(paramIGetGifFrameCallback);
  }
  
  public void a(@NotNull CMSAction paramCMSAction) {}
  
  public void a(@NotNull CMSAction paramCMSAction, int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (!CmShowWnsUtils.q()) {
      return;
    }
    int i;
    if (paramCMSAction.a() == MODE.ACTION_MODE_RECORD_GIF) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    String str = paramCMSAction.a(null, null);
    if (this.jdField_a_of_type_Int != paramCMSAction.d())
    {
      paramCMSAction = new StringBuilder();
      paramCMSAction.append(this);
      paramCMSAction.append(" onRecordFrame return, mActionId ");
      paramCMSAction.append(this.jdField_a_of_type_Int);
      paramCMSAction.append(", actionKey:");
      paramCMSAction.append(str);
      QLog.w("[cmshow]ApolloBrickPlayer", 2, paramCMSAction.toString());
      return;
    }
    if ((Handler)a(this.jdField_d_of_type_JavaLangRefWeakReference) == null) {
      return;
    }
    ThreadManager.excute(new ApolloBrickPlayerImpl.BrickCMSPlayerListener.1(this, paramArrayOfByte, str, paramInt1, paramInt2, paramInt3, paramInt4, paramCMSAction), 128, null, false);
  }
  
  public void a(@NotNull CMSAction paramCMSAction, @NotNull CMSActionStatus paramCMSActionStatus) {}
  
  public void a(@NotNull CMSAction paramCMSAction, boolean paramBoolean, @NotNull String paramString1, @Nullable String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("onRecordDone ");
      paramString1.append(paramBoolean);
      paramString1.append(" mActionId ");
      paramString1.append(this.jdField_a_of_type_Int);
      paramString1.append(" ");
      paramString1.append(paramString2);
      QLog.w("[cmshow]ApolloBrickPlayer", 2, paramString1.toString());
    }
    a(paramCMSAction, a(paramBoolean, paramCMSAction, paramString2));
    paramCMSAction = paramCMSAction.a(null, null);
    if (ApolloBrickPlayerImpl.access$1200().containsKey(paramCMSAction)) {
      ApolloBrickPlayerImpl.access$1200().remove(paramCMSAction);
    }
  }
  
  public void a(Map<String, URLDrawable.URLDrawableOptions> paramMap)
  {
    this.e = new WeakReference(paramMap);
  }
  
  public void b(ImageView paramImageView)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.api.impl.ApolloBrickPlayerImpl.BrickCMSPlayerListener
 * JD-Core Version:    0.7.0.1
 */