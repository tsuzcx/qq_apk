package com.tencent.biz.pubaccount.readinjoy.reward;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.model.RIJCoinInfoModule.UserCoinInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory.Options;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJVideoRewardCoinManager;", "Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyObserver;", "context", "Landroid/app/Activity;", "callback", "Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJVideoRewardCoinManager$Callback;", "(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJVideoRewardCoinManager$Callback;)V", "btnAnimEnable", "", "coinCount", "", "curSelectItem", "curVideoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "hasRewardCoin", "headerHint", "Landroid/widget/TextView;", "lastRequestMyCoinCountTime", "", "multiCoinBtn", "Landroid/view/View;", "multiCoinIcon", "Landroid/widget/ImageView;", "multiCoinIconSelectedBg", "multiCoinText", "myCoinCountText", "oneCoinBtn", "oneCoinIcon", "oneCoinIconSelectedBg", "oneCoinText", "popupWindow", "Landroid/widget/PopupWindow;", "popupWindowView", "rewardCoinBtn", "rewardSelectedItem", "dismissPopupWindow", "", "doUpdateCoinAlpha", "doUpdateCoinImage", "doUpdateCoinText", "coinTextImageView", "itemIndex", "drawableSelected", "drawableUnselected", "drawableUrlSelected", "", "drawableUrlUnselected", "getAnimDrawable", "Lcom/tencent/image/URLDrawable;", "url", "getRewardCoinCount", "index", "initPopupwindow", "initUI", "isShowing", "onBackPress", "onDestory", "onQueryUserCoinResult", "success", "retCode", "retMsg", "userCoin", "Lcom/tencent/biz/pubaccount/readinjoy/model/RIJCoinInfoModule$UserCoinInfo;", "onRewardCoinToUinResult", "reportAction", "action", "setCoinCountText", "showRewardCoinPopupWindow", "videoInfo", "udpateCoinUI", "Callback", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJVideoRewardCoinManager
  extends ReadInJoyObserver
{
  public static final RIJVideoRewardCoinManager.Companion a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private RIJVideoRewardCoinManager.Callback jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJVideoRewardCoinManager$Callback;
  private final boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private ImageView e;
  private ImageView f;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJVideoRewardCoinManager$Companion = new RIJVideoRewardCoinManager.Companion(null);
  }
  
  public RIJVideoRewardCoinManager(@Nullable Activity paramActivity, @Nullable RIJVideoRewardCoinManager.Callback paramCallback)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJVideoRewardCoinManager$Callback = paramCallback;
    this.jdField_a_of_type_Boolean = RIJRewardTaskConfig.a.c();
    this.jdField_c_of_type_Int = -1;
    ReadInJoyLogicEngineEventDispatcher.a().a((ReadInJoyObserver)this);
    if (this.jdField_a_of_type_Boolean)
    {
      a("https://kd.qpic.cn/bankjiang/images/oneCoinApng_1108_f3a3676c.png");
      a("https://kd.qpic.cn/bankjiang/images/threeCoinApng_1108_aeb44235.png");
    }
  }
  
  private final int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return RIJRewardTaskConfig.a.e();
    }
    return RIJRewardTaskConfig.a.f();
  }
  
  private final URLDrawable a(String paramString)
  {
    VasApngFactory.Options localOptions = new VasApngFactory.Options();
    localOptions.a(1);
    return VasApngFactory.a(paramString, localOptions, null, 4, null);
  }
  
  private final void a(ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    Object localObject;
    if (paramInt1 == this.jdField_a_of_type_Int)
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label118;
      }
      localObject = this.jdField_a_of_type_AndroidAppActivity;
      if (localObject == null) {
        break label112;
      }
      localObject = ((Activity)localObject).getResources();
      if (localObject == null) {
        break label112;
      }
      localObject = ((Resources)localObject).getDrawable(paramInt2);
      label45:
      if (paramInt1 == 0) {
        break label159;
      }
      label49:
      if (TextUtils.isEmpty((CharSequence)paramString1)) {
        break label166;
      }
      paramString2 = URLDrawable.URLDrawableOptions.obtain();
      if (paramString2 != null) {
        paramString2.mFailedDrawable = ((Drawable)localObject);
      }
      paramString1 = URLDrawable.getDrawable(paramString1, paramString2);
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "URLDrawable.getDrawable(drawableUrl, options)");
      if (paramImageView != null) {
        paramImageView.setImageDrawable((Drawable)paramString1);
      }
    }
    label112:
    label118:
    while (paramImageView == null)
    {
      return;
      paramInt1 = 0;
      break;
      localObject = null;
      break label45;
      localObject = this.jdField_a_of_type_AndroidAppActivity;
      if (localObject != null)
      {
        localObject = ((Activity)localObject).getResources();
        if (localObject != null)
        {
          localObject = ((Resources)localObject).getDrawable(paramInt3);
          break label45;
        }
      }
      localObject = null;
      break label45;
      paramString1 = paramString2;
      break label49;
    }
    label159:
    label166:
    paramImageView.setImageDrawable((Drawable)localObject);
  }
  
  private final void a(String paramString, boolean paramBoolean)
  {
    int i = 1;
    Object localObject = new VideoR5.Builder(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo).a("video_mode", Integer.valueOf(1)).a("number", Integer.valueOf(this.jdField_a_of_type_Int + 1));
    VideoR5 localVideoR5;
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    if (paramBoolean)
    {
      localVideoR5 = ((VideoR5.Builder)localObject).a("result", Integer.valueOf(i)).a();
      Intrinsics.checkExpressionValueIsNotNull(localVideoR5, "VideoR5.Builder(curVideo…\n                .build()");
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject == null) {
        break label132;
      }
    }
    label132:
    for (localObject = ((VideoInfo)localObject).g;; localObject = null)
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, (String)localObject, "", "", localVideoR5.a(), false);
      return;
      i = 2;
      break;
    }
  }
  
  private final void e(int paramInt)
  {
    if (paramInt > 0) {}
    for (String str = VideoFeedsHelper.e(paramInt);; str = "0")
    {
      TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localTextView != null) {
        localTextView.setText((CharSequence)("可投硬币 " + str + " 〉"));
      }
      return;
    }
  }
  
  private final void f()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_AndroidViewView);
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setBackgroundDrawable((Drawable)new ColorDrawable(0));
    }
    localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setAnimationStyle(2131755866);
    }
    localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setWidth(-1);
    }
    localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setHeight(-1);
    }
    localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setTouchable(true);
    }
    localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setFocusable(false);
    }
    localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setSoftInputMode(2);
    }
    localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setInputMethodMode(2);
    }
    localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setClippingEnabled(false);
    }
    localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setOnDismissListener((PopupWindow.OnDismissListener)new RIJVideoRewardCoinManager.initPopupwindow.1(this));
    }
  }
  
  private final void g()
  {
    Object localObject2 = null;
    Object localObject1 = LayoutInflater.from((Context)this.jdField_a_of_type_AndroidAppActivity);
    if (localObject1 != null)
    {
      localObject1 = ((LayoutInflater)localObject1).inflate(2131560493, null);
      this.jdField_a_of_type_AndroidViewView = ((View)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break label451;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(2131377779);
      label51:
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break label456;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(2131377784);
      label76:
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break label461;
      }
      localObject1 = ((View)localObject1).findViewById(2131377772);
      label98:
      this.jdField_b_of_type_AndroidViewView = ((View)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break label466;
      }
      localObject1 = (ImageView)((View)localObject1).findViewById(2131377775);
      label123:
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break label471;
      }
      localObject1 = (ImageView)((View)localObject1).findViewById(2131377776);
      label148:
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break label476;
      }
      localObject1 = (ImageView)((View)localObject1).findViewById(2131377782);
      label173:
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break label481;
      }
      localObject1 = ((View)localObject1).findViewById(2131377771);
      label195:
      this.jdField_c_of_type_AndroidViewView = ((View)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break label486;
      }
      localObject1 = (ImageView)((View)localObject1).findViewById(2131377774);
      label220:
      this.f = ((ImageView)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break label491;
      }
      localObject1 = (ImageView)((View)localObject1).findViewById(2131377773);
      label245:
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break label496;
      }
    }
    label451:
    label456:
    label461:
    label466:
    label471:
    label476:
    label481:
    label486:
    label491:
    label496:
    for (localObject1 = (ImageView)((View)localObject1).findViewById(2131377780);; localObject1 = null)
    {
      this.e = ((ImageView)localObject1);
      View localView = this.jdField_a_of_type_AndroidViewView;
      localObject1 = localObject2;
      if (localView != null) {
        localObject1 = localView.findViewById(2131377778);
      }
      this.jdField_d_of_type_AndroidViewView = ((View)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)RIJRewardTaskConfig.a.a());
      }
      h();
      localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setOnClickListener((View.OnClickListener)new RIJVideoRewardCoinManager.initUI.1(this));
      }
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new RIJVideoRewardCoinManager.initUI.2(this));
      }
      localObject1 = this.jdField_b_of_type_AndroidViewView;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new RIJVideoRewardCoinManager.initUI.3(this));
      }
      localObject1 = this.jdField_c_of_type_AndroidViewView;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new RIJVideoRewardCoinManager.initUI.4(this));
      }
      localObject1 = this.jdField_d_of_type_AndroidViewView;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new RIJVideoRewardCoinManager.initUI.5(this));
      }
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label51;
      localObject1 = null;
      break label76;
      localObject1 = null;
      break label98;
      localObject1 = null;
      break label123;
      localObject1 = null;
      break label148;
      localObject1 = null;
      break label173;
      localObject1 = null;
      break label195;
      localObject1 = null;
      break label220;
      localObject1 = null;
      break label245;
    }
  }
  
  private final void h()
  {
    a(this.jdField_b_of_type_AndroidWidgetImageView, 0, 2130843387, 2130843388, RIJRewardTaskConfig.a.d(), RIJRewardTaskConfig.a.f());
    a(this.e, 1, 2130843391, 2130843392, RIJRewardTaskConfig.a.e(), RIJRewardTaskConfig.a.g());
    s();
    r();
  }
  
  private final void r()
  {
    View localView;
    if (this.jdField_a_of_type_Int == 0)
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      if (localView != null) {
        localView.setAlpha(1.0F);
      }
      localView = this.jdField_c_of_type_AndroidViewView;
      if (localView != null) {
        localView.setAlpha(0.7F);
      }
    }
    do
    {
      return;
      localView = this.jdField_b_of_type_AndroidViewView;
      if (localView != null) {
        localView.setAlpha(0.7F);
      }
      localView = this.jdField_c_of_type_AndroidViewView;
    } while (localView == null);
    localView.setAlpha(1.0F);
  }
  
  private final void s()
  {
    ImageView localImageView;
    if (this.jdField_a_of_type_Int == 0) {
      if (this.jdField_a_of_type_Boolean)
      {
        localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
        if (localImageView != null) {
          localImageView.setImageDrawable((Drawable)a("https://kd.qpic.cn/bankjiang/images/oneCoinApng_1108_f3a3676c.png"));
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
          if (localImageView != null) {
            localImageView.setVisibility(0);
          }
          localImageView = this.f;
        } while (localImageView == null);
        localImageView.setVisibility(8);
        return;
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        localImageView = this.jdField_d_of_type_AndroidWidgetImageView;
      } while (localImageView == null);
      localImageView.setImageDrawable((Drawable)a("https://kd.qpic.cn/bankjiang/images/threeCoinApng_1108_aeb44235.png"));
      return;
      localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      localImageView = this.f;
    } while (localImageView == null);
    localImageView.setVisibility(0);
  }
  
  private final void t()
  {
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
    this.jdField_a_of_type_AndroidViewView = ((View)null);
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Object localObject = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localObject != null) {
      ((PopupWindow)localObject).dismiss();
    }
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      ViewParent localViewParent = localView.getParent();
      localObject = localViewParent;
      if (!(localViewParent instanceof ViewGroup)) {
        localObject = null;
      }
      localObject = (ViewGroup)localObject;
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(localView);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_AndroidViewView == null) {
      g();
    }
    if (this.jdField_c_of_type_Int >= 0) {
      e(this.jdField_c_of_type_Int);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramVideoInfo = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramVideoInfo != null) {
        paramVideoInfo.postDelayed((Runnable)new RIJVideoRewardCoinManager.showRewardCoinPopupWindow.2(this), 500L);
      }
    }
    f();
    paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJVideoRewardCoinManager$Callback;
    if (paramVideoInfo != null) {
      paramVideoInfo.a(true);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localObject != null)
    {
      paramVideoInfo = this.jdField_a_of_type_AndroidAppActivity;
      if (paramVideoInfo != null)
      {
        paramVideoInfo = paramVideoInfo.getWindow();
        if (paramVideoInfo != null)
        {
          paramVideoInfo = paramVideoInfo.getDecorView();
          ((PopupWindow)localObject).showAsDropDown(paramVideoInfo, 0, -VideoFeedsHelper.b(this.jdField_a_of_type_AndroidAppActivity)[1]);
        }
      }
    }
    else
    {
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long <= RIJRewardTaskConfig.a()) {
        break label267;
      }
    }
    label267:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (RIJRewardTaskConfig.a()))
      {
        ReadInJoyLogicEngine.a().t();
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      a(this, "0X800B2E8", false, 2, null);
      return;
      paramVideoInfo = null;
      break;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJVideoRewardCoinManager", 2, "onRewardCoinToUinResult: success=" + paramBoolean + ", retCode=" + paramInt + ", retMsg=" + paramString);
    }
    t();
    this.jdField_b_of_type_Boolean = false;
    a("0X800B2EC", paramBoolean);
    if (paramBoolean)
    {
      paramInt = a(this.jdField_b_of_type_Int);
      this.jdField_c_of_type_Int -= paramInt;
      paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJVideoRewardCoinManager$Callback;
      if (paramString != null) {
        paramString.a(true, "投币成功", this.jdField_b_of_type_Int);
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt != 1034) {
          break;
        }
        paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJVideoRewardCoinManager$Callback;
      } while (paramString == null);
      paramString.a(false, "硬币不够", this.jdField_b_of_type_Int);
      return;
      paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJVideoRewardCoinManager$Callback;
    } while (paramString == null);
    paramString.a(false, "投币失败", this.jdField_b_of_type_Int);
  }
  
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString, @Nullable RIJCoinInfoModule.UserCoinInfo paramUserCoinInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJVideoRewardCoinManager", 2, "onQueryUserCoinResult: success=" + paramBoolean + ", retCode=" + paramInt + ", retMsg=" + paramString + ", userCoin=" + paramUserCoinInfo);
    }
    if (paramBoolean) {
      if (paramUserCoinInfo == null) {
        break label90;
      }
    }
    label90:
    for (paramInt = paramUserCoinInfo.jdField_a_of_type_Int;; paramInt = 0)
    {
      this.jdField_c_of_type_Int = paramInt;
      e(paramInt);
      return;
    }
  }
  
  public final boolean a()
  {
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      return localPopupWindow.isShowing();
    }
    return false;
  }
  
  public final boolean b()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView != null) && (localView.isShown() == true))
    {
      t();
      return true;
    }
    return false;
  }
  
  public final void e()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b((ReadInJoyObserver)this);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJVideoRewardCoinManager$Callback = ((RIJVideoRewardCoinManager.Callback)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJVideoRewardCoinManager
 * JD-Core Version:    0.7.0.1
 */