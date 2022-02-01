package com.tencent.biz.pubaccount.weishi_new.ui.videotransition;

import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.weishi_new.main.WSMainContainerFragment;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/ui/videotransition/WSVideoTransitionAnimUtil;", "", "()V", "IMAGE_VIEW_FOR_ANIM_BOTTOM_MARGIN", "", "getIMAGE_VIEW_FOR_ANIM_BOTTOM_MARGIN", "()I", "KEY_ENTER_START_ANIM_LOCATION", "", "KEY_IS_NEED_PERFORM_END_TRANSITION_NO_START", "KEY_IS_NEED_PERFORM_TRANSITION", "TAG", "TAG_TRANSITION_ANIM", "cacheDrawableRef", "Lmqq/util/WeakReference;", "Landroid/graphics/drawable/Drawable;", "cacheEnterStartAnimRect", "Landroid/graphics/RectF;", "getCoverDrawable", "itemView", "Landroid/view/View;", "getEnterEndAnimLocation", "rootWidth", "", "rootHeight", "feed", "LUserGrowth/stSimpleMetaFeed;", "getEnterStartAnimLocation", "getVideoRatio", "getViewLocation", "bundle", "Landroid/os/Bundle;", "view", "isNeedPerformEndTransitionNoStart", "", "isNeedPerformTransition", "saveCoverDrawable", "", "coverDrawable", "saveEnterStartAnimLocation", "startActivityWithTransition", "context", "Landroid/content/Context;", "fragmentClass", "Ljava/lang/Class;", "intent", "Landroid/content/Intent;", "enterStartAnimLocation", "isPerformEndTransitionNoStart", "startActivityWithTransitionInGrid", "params", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/WSVerticalPageOpenParams;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSVideoTransitionAnimUtil
{
  public static final WSVideoTransitionAnimUtil a = new WSVideoTransitionAnimUtil();
  private static final int b = ScreenUtil.dip2px(46.0F);
  private static final RectF c = new RectF();
  private static WeakReference<Drawable> d;
  
  private final float a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    float f2 = 0.0F;
    float f1 = f2;
    if (paramstSimpleMetaFeed != null)
    {
      paramstSimpleMetaFeed = paramstSimpleMetaFeed.images;
      f1 = f2;
      if (paramstSimpleMetaFeed != null)
      {
        if (paramstSimpleMetaFeed.size() > 1)
        {
          stMetaUgcImage localstMetaUgcImage = (stMetaUgcImage)paramstSimpleMetaFeed.get(1);
          if ((localstMetaUgcImage != null) && (localstMetaUgcImage.width != 0) && (localstMetaUgcImage.height != 0)) {
            return localstMetaUgcImage.width / localstMetaUgcImage.height;
          }
        }
        f1 = f2;
        if (paramstSimpleMetaFeed.size() > 0)
        {
          paramstSimpleMetaFeed = (stMetaUgcImage)paramstSimpleMetaFeed.get(0);
          f1 = f2;
          if (paramstSimpleMetaFeed != null)
          {
            f1 = f2;
            if (paramstSimpleMetaFeed.width != 0)
            {
              f1 = f2;
              if (paramstSimpleMetaFeed.height != 0) {
                f1 = paramstSimpleMetaFeed.width / paramstSimpleMetaFeed.height;
              }
            }
          }
        }
      }
    }
    return f1;
  }
  
  @JvmStatic
  @NotNull
  public static final RectF a(float paramFloat1, float paramFloat2, @Nullable stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramFloat2 -= b;
    float f1 = a.a(paramstSimpleMetaFeed);
    if (f1 < 0.6428571F)
    {
      f1 = 0.0F;
    }
    else
    {
      float f2 = paramFloat1 / f1;
      f1 = (paramFloat2 - f2) / 2;
      paramFloat2 = f2 + f1;
    }
    return new RectF(0.0F, f1, paramFloat1, paramFloat2);
  }
  
  @JvmStatic
  public static final void a(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    d = new WeakReference(paramDrawable);
  }
  
  @JvmStatic
  public static final void a(@Nullable View paramView)
  {
    c.set(b(paramView));
  }
  
  @JvmStatic
  public static final boolean a(@NotNull Context paramContext, @NotNull Class<?> paramClass, @NotNull Intent paramIntent, @Nullable RectF paramRectF, @Nullable Drawable paramDrawable, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramClass, "fragmentClass");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    paramIntent.putExtra("public_fragment_class", WSMainContainerFragment.class.getName());
    paramIntent.putExtra("key_is_need_perform_end_transition_no_start", paramBoolean);
    if (((paramContext instanceof Activity)) && (paramDrawable != null))
    {
      paramIntent.setClass(paramContext, PublicTransFragmentActivity.class);
      paramIntent.putExtra("key_is_need_perform_transition", true);
      paramIntent.putExtra("key_enter_start_anim_location", (Parcelable)paramRectF);
      paramRectF = new StringBuilder();
      paramRectF.append("startActivityWithTransition() with animation. fragmentClass = ");
      paramRectF.append(paramClass.getSimpleName());
      WSLog.e("WSVideoTransitionAnimUtil", paramRectF.toString());
      a(paramDrawable);
      paramContext.startActivity(paramIntent);
      ((Activity)paramContext).overridePendingTransition(0, 0);
      return true;
    }
    paramRectF = new StringBuilder();
    paramRectF.append("startActivityWithTransition() no animation. context = ");
    paramRectF.append(paramContext);
    paramRectF.append(", ");
    paramRectF.append("coverDrawable = ");
    paramRectF.append(paramDrawable);
    paramRectF.append(", fragmentClass = ");
    paramRectF.append(paramClass.getSimpleName());
    WSLog.e("WSVideoTransitionAnimUtil", paramRectF.toString());
    if (paramBoolean) {
      paramClass = PublicTransFragmentActivity.class;
    } else {
      paramClass = PublicFragmentActivity.class;
    }
    paramIntent.setClass(paramContext, paramClass);
    paramContext.startActivity(paramIntent);
    return false;
  }
  
  @JvmStatic
  public static final boolean a(@Nullable Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("key_is_need_perform_transition", false);
    }
    return bool;
  }
  
  @JvmStatic
  public static final boolean a(@NotNull WSVerticalPageOpenParams paramWSVerticalPageOpenParams, @NotNull Intent paramIntent, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramWSVerticalPageOpenParams, "params");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    Context localContext = paramWSVerticalPageOpenParams.c();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "params.context");
    return a(localContext, WSMainContainerFragment.class, paramIntent, b(paramWSVerticalPageOpenParams.w()), c(paramWSVerticalPageOpenParams.w()), paramBoolean);
  }
  
  @JvmStatic
  @Nullable
  public static final RectF b(@Nullable View paramView)
  {
    if (paramView != null)
    {
      paramView = (ImageView)paramView.findViewWithTag("transitionAnim");
      if (paramView != null)
      {
        int[] arrayOfInt = new int[2];
        paramView.getLocationInWindow(arrayOfInt);
        float f1 = arrayOfInt[0];
        float f2 = arrayOfInt[1];
        return new RectF(f1, f2, paramView.getWidth() + f1, paramView.getHeight() + f2);
      }
    }
    return null;
  }
  
  @JvmStatic
  @Nullable
  public static final Drawable b()
  {
    Object localObject = d;
    if (localObject != null) {
      localObject = (Drawable)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    WeakReference localWeakReference = d;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    d = (WeakReference)null;
    return localObject;
  }
  
  @JvmStatic
  public static final boolean b(@Nullable Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("key_is_need_perform_end_transition_no_start", false);
    }
    return bool;
  }
  
  @JvmStatic
  @NotNull
  public static final RectF c()
  {
    return c;
  }
  
  @JvmStatic
  @NotNull
  public static final RectF c(@Nullable Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = (RectF)paramBundle.getParcelable("key_enter_start_anim_location");
      if (paramBundle != null) {
        return paramBundle;
      }
    }
    return new RectF();
  }
  
  @JvmStatic
  @Nullable
  public static final Drawable c(@Nullable View paramView)
  {
    Drawable localDrawable = null;
    if (paramView != null) {
      paramView = (ImageView)paramView.findViewWithTag("transitionAnim");
    } else {
      paramView = null;
    }
    if (paramView != null) {
      localDrawable = paramView.getDrawable();
    }
    return localDrawable;
  }
  
  public final int a()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSVideoTransitionAnimUtil
 * JD-Core Version:    0.7.0.1
 */