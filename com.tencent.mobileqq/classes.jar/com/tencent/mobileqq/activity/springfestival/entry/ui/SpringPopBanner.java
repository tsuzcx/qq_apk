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
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory.Options;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import org.jetbrains.annotations.Nullable;

public class SpringPopBanner
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final Conversation jdField_a_of_type_ComTencentMobileqqActivityHomeConversation;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private View b;
  
  public SpringPopBanner(Conversation paramConversation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation = paramConversation;
    a();
  }
  
  public static SharedPreferences a()
  {
    try
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences(((QQAppInterface)localObject).getCurrentAccountUin() + "_2021_shuayishua_popbanner", 0);
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  @Nullable
  private URLDrawable a(int paramInt, String paramString)
  {
    Object localObject2 = null;
    if (paramInt == 0) {
      localObject1 = URLDrawable.getFileDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    }
    boolean bool;
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (paramInt != 1);
      bool = FileUtils.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("shua2021_SpringPopBanner", 2, "showHongbaoLayer apng exist = " + bool);
      }
      localObject1 = localObject2;
    } while (!bool);
    Object localObject1 = new VasApngFactory.Options();
    ((VasApngFactory.Options)localObject1).a(URLDrawableHelper.TRANSPARENT);
    return VasApngFactory.a("", (VasApngFactory.Options)localObject1, paramString);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a().findViewById(2131365297));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a().getLayoutInflater().inflate(2131559345, this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout, false);
    this.jdField_a_of_type_AndroidViewView.setId(2131374815);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131363528);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363527).setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a().getColor(2131165506));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368490));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new SpringPopBanner.1(this));
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368492);
    localImageView.setOnTouchListener(UITools.a);
    localImageView.setOnClickListener(new SpringPopBanner.2(this));
  }
  
  private void a(int paramInt, String paramString)
  {
    paramInt = ViewUtils.b();
    int i = ViewUtils.a() - AIOUtils.a(20.0F, this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a()) * 2;
    paramInt = (int)(paramInt * 0.6666667F);
    if (0.8571429F > i / paramInt) {
      paramInt = (int)(i / 0.8571429F);
    }
    for (;;)
    {
      if ((paramInt > 0) && (i > 0))
      {
        paramString = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        paramString.height = paramInt;
        paramString.width = i;
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramString);
      }
      return;
      i = (int)(paramInt * 0.8571429F);
    }
  }
  
  private void a(String paramString)
  {
    QLog.d("shua2021_SpringPopBanner", 1, String.format("clickAction url=%s", new Object[] { paramString }));
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      try
      {
        if (URLUtil.isNetworkUrl(paramString))
        {
          Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), QQBrowserActivity.class);
          localIntent.putExtra("url", paramString);
          localIntent.putExtra("big_brother_source_key", "biz_src_jc_aio");
          this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a().startActivity(localIntent);
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.d("shua2021_SpringPopBanner", 1, paramString.getMessage(), paramString);
        return;
      }
      paramString = JumpParser.a((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a, this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), paramString);
      if (paramString != null)
      {
        paramString.a();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("shua2021_SpringPopBanner", 2, "gotoWeb jumpUrl is illegal");
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("shua2021_SpringPopBanner", 2, "showHongbaoLayer | imgUrl is: " + paramString2 + " actionUrl: " + paramString3);
    }
    if (!HttpUtil.isValidUrl(paramString2))
    {
      QLog.d("shua2021_SpringPopBanner", 1, "error, invalide url...");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new SpringPopBanner.3(this, paramString1, paramString3));
    PreloadStaticApi.a().getResPath(paramString2, new SpringPopBanner.4(this, paramInt, paramString1));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      QLog.d("shua2021_SpringPopBanner", 1, String.format("setHasShown id=%s shown=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
      localSharedPreferences = a();
    } while (localSharedPreferences == null);
    localSharedPreferences.edit().putBoolean(paramString, paramBoolean).apply();
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return false;
      localSharedPreferences = a();
    } while (localSharedPreferences == null);
    boolean bool = localSharedPreferences.getBoolean(paramString, false);
    QLog.d("shua2021_SpringPopBanner", 1, String.format("hasShown id=%s %b", new Object[] { paramString, Boolean.valueOf(bool) }));
    return bool;
  }
  
  private static void b(View paramView)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation.setDuration(300L);
    paramView.startAnimation(localTranslateAnimation);
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
      QwUtils.a(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.findViewById(2131374815) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.ui.SpringPopBanner
 * JD-Core Version:    0.7.0.1
 */