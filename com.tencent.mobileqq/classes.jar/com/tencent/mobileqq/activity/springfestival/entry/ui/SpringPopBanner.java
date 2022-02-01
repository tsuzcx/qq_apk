package com.tencent.mobileqq.activity.springfestival.entry.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.tencent.av.utils.UITools;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.springfestival.entry.model.PopBannerData;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;

public class SpringPopBanner
{
  private View a;
  private View b;
  private DragFrameLayout c;
  private ImageView d;
  private final Conversation e;
  
  public SpringPopBanner(Conversation paramConversation)
  {
    this.e = paramConversation;
    c();
  }
  
  @Nullable
  private URLDrawable a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      return URLDrawable.getFileDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    }
    if (paramInt == 1)
    {
      boolean bool = FileUtils.fileExists(paramString);
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showHongbaoLayer apng exist = ");
        ((StringBuilder)localObject).append(bool);
        QLog.d("shua2021_SpringPopBanner", 2, ((StringBuilder)localObject).toString());
      }
      if (bool)
      {
        localObject = new ApngOptions();
        ((ApngOptions)localObject).a(URLDrawableHelperConstants.a);
        return ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", (ApngOptions)localObject, paramString);
      }
    }
    return null;
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showHongbaoLayer | imgUrl is: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" actionUrl: ");
      localStringBuilder.append(paramString3);
      QLog.d("shua2021_SpringPopBanner", 2, localStringBuilder.toString());
    }
    if (!HttpUtil.isValidUrl(paramString2))
    {
      QLog.d("shua2021_SpringPopBanner", 1, "error, invalide url...");
      return;
    }
    this.d.setOnClickListener(new SpringPopBanner.3(this, paramString1, paramString3));
    PreloadStaticApi.a().getResPath(paramString2, new SpringPopBanner.4(this, paramInt, paramString1));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QLog.d("shua2021_SpringPopBanner", 1, String.format("setHasShown id=%s shown=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    SharedPreferences localSharedPreferences = b();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean(paramString, paramBoolean).apply();
    }
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    SharedPreferences localSharedPreferences = b();
    if (localSharedPreferences == null) {
      return false;
    }
    boolean bool = localSharedPreferences.getBoolean(paramString, false);
    QLog.d("shua2021_SpringPopBanner", 1, String.format("hasShown id=%s %b", new Object[] { paramString, Boolean.valueOf(bool) }));
    return bool;
  }
  
  public static SharedPreferences b()
  {
    try
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((QQAppInterface)localObject).getCurrentAccountUin());
      localStringBuilder.append("_2021_shuayishua_popbanner");
      localObject = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      label50:
      break label50;
    }
    return null;
  }
  
  private void b(int paramInt, String paramString)
  {
    paramInt = ViewUtils.getScreenHeight();
    int i = ViewUtils.getScreenWidth() - AIOUtils.b(20.0F, this.e.Q()) * 2;
    paramInt = (int)(paramInt * 0.6666667F);
    float f1 = i;
    float f2 = paramInt;
    if (0.8571429F > f1 / f2) {
      paramInt = (int)(f1 / 0.8571429F);
    } else {
      i = (int)(f2 * 0.8571429F);
    }
    if ((paramInt > 0) && (i > 0))
    {
      paramString = this.d.getLayoutParams();
      paramString.height = paramInt;
      paramString.width = i;
      this.d.setLayoutParams(paramString);
    }
  }
  
  private static void b(View paramView)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation.setDuration(300L);
    paramView.startAnimation(localTranslateAnimation);
  }
  
  private void b(String paramString)
  {
    QLog.d("shua2021_SpringPopBanner", 1, String.format("clickAction url=%s", new Object[] { paramString }));
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      if (URLUtil.isNetworkUrl(paramString))
      {
        Intent localIntent = new Intent(this.e.P(), QQBrowserActivity.class);
        localIntent.putExtra("url", paramString);
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_aio");
        this.e.P().startActivity(localIntent);
        return;
      }
      paramString = JumpParser.a((QQAppInterface)this.e.aF, this.e.P(), paramString);
      if (paramString != null)
      {
        paramString.a();
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("shua2021_SpringPopBanner", 2, "gotoWeb jumpUrl is illegal");
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.d("shua2021_SpringPopBanner", 1, paramString.getMessage(), paramString);
    }
  }
  
  private void c()
  {
    this.c = ((DragFrameLayout)this.e.P().findViewById(2131431325));
    this.a = this.e.P().getLayoutInflater().inflate(2131625140, this.c, false);
    this.a.setId(2131442522);
    this.b = this.a.findViewById(2131429355);
    this.a.findViewById(2131429352).setBackgroundColor(this.e.Q().getColor(2131165803));
    this.d = ((ImageView)this.a.findViewById(2131435106));
    this.a.setOnTouchListener(new SpringPopBanner.1(this));
    ImageView localImageView = (ImageView)this.a.findViewById(2131435108);
    localImageView.setOnTouchListener(UITools.a);
    localImageView.setOnClickListener(new SpringPopBanner.2(this));
  }
  
  public void a(PopBannerData paramPopBannerData)
  {
    boolean bool = a(paramPopBannerData.id);
    QLog.d("shua2021_SpringPopBanner", 1, String.format("show popBannerData hasShown=%b id=%s type=%d", new Object[] { Boolean.valueOf(bool), paramPopBannerData.id, Integer.valueOf(paramPopBannerData.type) }));
    if (!bool) {
      a(paramPopBannerData.id, paramPopBannerData.imgUrl, paramPopBannerData.jumpUrl, paramPopBannerData.type);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("shua2021_SpringPopBanner", 1, "hide");
    if (paramBoolean) {
      ViewUtils.removeViewFromParent(this.a);
    }
  }
  
  public boolean a()
  {
    return this.c.findViewById(2131442522) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.ui.SpringPopBanner
 * JD-Core Version:    0.7.0.1
 */