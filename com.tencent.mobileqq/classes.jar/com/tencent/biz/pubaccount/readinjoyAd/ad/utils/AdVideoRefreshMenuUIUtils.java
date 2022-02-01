package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJStringUtils;
import com.tencent.biz.pubaccount.readinjoy.video.IVideoFeedsFollowButton;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.view.CircleCountdownView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.AdDownloadScene;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.IDownloadStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdVideoRefreshMenuUIUtils;", "", "()V", "drawAdTag", "", "context", "Landroid/content/Context;", "videoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "videoHolder", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/ADVideoItemHolder;", "listener", "Landroid/view/View$OnClickListener;", "isTiktokStyle", "", "clickableSpan", "Landroid/text/style/ClickableSpan;", "fillDpaTags", "activity", "Landroid/app/Activity;", "fillDpaUIData", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "drawable", "Landroid/graphics/drawable/Drawable;", "fillUIData", "fillUIDataForAllAdType", "fillUIDataForAllAdTypeWithBusiType", "fillUIDataForTypeNewVideo", "fillUIDataForTypeVideo", "getExtraJson", "Lorg/json/JSONObject;", "setIcon", "imageView", "Landroid/widget/ImageView;", "width", "", "radius", "mDefaultFaceDrawable", "setRealClickListener", "view", "Landroid/view/View;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AdVideoRefreshMenuUIUtils
{
  public static final AdVideoRefreshMenuUIUtils a = new AdVideoRefreshMenuUIUtils();
  
  private final JSONObject a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo != null)
    {
      paramVideoInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
      if (paramVideoInfo != null)
      {
        paramVideoInfo = paramVideoInfo.v;
        if (paramVideoInfo != null) {
          return new JSONObject(paramVideoInfo);
        }
      }
    }
    return null;
  }
  
  private final void a(View paramView, ADVideoItemHolder paramADVideoItemHolder, View.OnClickListener paramOnClickListener)
  {
    if (paramView != null) {
      paramView.setTag(paramADVideoItemHolder);
    }
    if (paramView != null) {
      paramView.setOnClickListener(paramOnClickListener);
    }
  }
  
  private final void b(QQAppInterface paramQQAppInterface, Context paramContext, Drawable paramDrawable, VideoInfo paramVideoInfo, ADVideoItemHolder paramADVideoItemHolder, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    int j = 0;
    if ((paramContext == null) || (paramQQAppInterface == null)) {
      return;
    }
    label56:
    label79:
    label102:
    int i;
    if ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_Int != 0))
    {
      if (paramADVideoItemHolder != null)
      {
        paramQQAppInterface = paramADVideoItemHolder.jdField_j_of_type_AndroidViewViewGroup;
        if (paramQQAppInterface != null) {
          paramQQAppInterface.setVisibility(0);
        }
      }
      if (paramADVideoItemHolder != null)
      {
        paramQQAppInterface = paramADVideoItemHolder.jdField_j_of_type_AndroidViewViewGroup;
        a((View)paramQQAppInterface, paramADVideoItemHolder, paramOnClickListener);
        if (paramADVideoItemHolder == null) {
          break label397;
        }
        paramQQAppInterface = paramADVideoItemHolder.jdField_a_of_type_AndroidWidgetLinearLayout;
        a((View)paramQQAppInterface, paramADVideoItemHolder, paramOnClickListener);
      }
    }
    else
    {
      if (paramADVideoItemHolder == null) {
        break label402;
      }
      paramQQAppInterface = paramADVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
      a((View)paramQQAppInterface, paramADVideoItemHolder, paramOnClickListener);
      if (paramADVideoItemHolder != null)
      {
        paramQQAppInterface = paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetTextView;
        if (paramQQAppInterface != null)
        {
          paramDrawable = paramContext.getResources();
          if (paramDrawable == null) {
            break label407;
          }
          paramDrawable = paramDrawable.getDisplayMetrics();
          if (paramDrawable == null) {
            break label407;
          }
          i = MathKt.roundToInt(paramDrawable.widthPixels * 0.7D);
          label161:
          paramQQAppInterface.setMaxWidth(i);
        }
      }
      if (paramVideoInfo == null) {
        break label413;
      }
      paramQQAppInterface = paramVideoInfo.c;
      if (paramQQAppInterface == null) {
        break label413;
      }
      label182:
      if (TextUtils.isEmpty((CharSequence)paramQQAppInterface)) {
        break label440;
      }
      paramQQAppInterface = paramContext.getResources();
      if (paramQQAppInterface == null) {
        break label419;
      }
      paramQQAppInterface = paramQQAppInterface.getText(2131718430);
      if (paramQQAppInterface == null) {
        break label419;
      }
      paramQQAppInterface = paramQQAppInterface.toString();
      if (paramQQAppInterface == null) {
        break label419;
      }
    }
    label397:
    label402:
    label407:
    label413:
    label419:
    label431:
    label437:
    label438:
    label440:
    for (;;)
    {
      label221:
      if (paramADVideoItemHolder != null)
      {
        paramDrawable = paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetTextView;
        if (paramDrawable != null) {
          paramDrawable.setText((CharSequence)paramQQAppInterface);
        }
      }
      if (paramADVideoItemHolder != null)
      {
        paramQQAppInterface = paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetTextView;
        if (paramQQAppInterface != null)
        {
          paramDrawable = paramContext.getResources();
          i = j;
          if (paramDrawable != null)
          {
            paramDrawable = paramDrawable.getDisplayMetrics();
            i = j;
            if (paramDrawable != null) {
              i = MathKt.roundToInt(paramDrawable.widthPixels * 0.224D);
            }
          }
          paramQQAppInterface.setMaxWidth(i);
        }
      }
      if (paramVideoInfo != null)
      {
        paramQQAppInterface = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.l;
          if (paramQQAppInterface != null)
          {
            label329:
            if (TextUtils.isEmpty((CharSequence)paramQQAppInterface)) {
              break label437;
            }
            paramQQAppInterface = paramContext.getResources();
            if (paramQQAppInterface == null) {
              break label431;
            }
            paramQQAppInterface = paramQQAppInterface.getText(2131718429);
            if (paramQQAppInterface == null) {
              break label431;
            }
            paramQQAppInterface = paramQQAppInterface.toString();
            if (paramQQAppInterface == null) {
              break label431;
            }
          }
        }
      }
      for (;;)
      {
        if (paramADVideoItemHolder == null) {
          break label438;
        }
        paramContext = paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetTextView;
        if (paramContext == null) {
          break;
        }
        paramContext.setText((CharSequence)paramQQAppInterface);
        return;
        paramQQAppInterface = null;
        break label56;
        paramQQAppInterface = null;
        break label79;
        paramQQAppInterface = null;
        break label102;
        i = 0;
        break label161;
        paramQQAppInterface = "";
        break label182;
        paramQQAppInterface = "";
        break label221;
        paramQQAppInterface = "";
        break label329;
        paramQQAppInterface = "";
      }
      break;
    }
  }
  
  private final void c(QQAppInterface paramQQAppInterface, Context paramContext, Drawable paramDrawable, VideoInfo paramVideoInfo, ADVideoItemHolder paramADVideoItemHolder, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramQQAppInterface == null)) {
      return;
    }
    boolean bool = ReadInJoyAdUtils.a(paramVideoInfo);
    Object localObject2;
    label221:
    float f;
    if ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_Int != 0))
    {
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.jdField_j_of_type_AndroidViewViewGroup;
        if (localObject1 != null) {
          ((ViewGroup)localObject1).setVisibility(8);
        }
      }
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.jdField_a_of_type_AndroidWidgetTextView;
        a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      }
    }
    else
    {
      localObject1 = a(paramVideoInfo);
      int j = 0;
      int i = j;
      if (localObject1 != null)
      {
        i = j;
        if (((JSONObject)localObject1).has("down_time") == true) {
          i = ((JSONObject)localObject1).optInt("down_time") * 1000;
        }
      }
      if ((i > 0) && (paramADVideoItemHolder != null))
      {
        localObject1 = paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView;
        if (localObject1 != null) {
          ((CircleCountdownView)localObject1).setDuration(i);
        }
      }
      localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setCornerRadius(Utils.dp2px(2.0D));
      ((GradientDrawable)localObject1).setColor(Color.parseColor("#12B7F6"));
      if (Build.VERSION.SDK_INT < 16) {
        break label1033;
      }
      if (paramADVideoItemHolder != null)
      {
        localObject2 = paramADVideoItemHolder.jdField_g_of_type_AndroidViewView;
        if (localObject2 != null) {
          ((View)localObject2).setBackground((Drawable)localObject1);
        }
      }
      if (!paramBoolean) {
        break label1063;
      }
      f = Utils.dp2px(10.0D);
      label235:
      ((GradientDrawable)localObject1).setCornerRadius(f);
      ((GradientDrawable)localObject1).setColor(Color.parseColor("#FFFFFF"));
      if (Build.VERSION.SDK_INT < 16) {
        break label1075;
      }
      if (paramADVideoItemHolder != null)
      {
        localObject2 = paramADVideoItemHolder.jdField_m_of_type_AndroidViewView;
        if (localObject2 != null) {
          ((View)localObject2).setBackground((Drawable)localObject1);
        }
      }
      label287:
      if (bool) {}
      j = 2;
      i = j;
      if (bool)
      {
        i = j;
        if (paramBoolean) {
          i = 12;
        }
      }
      if (paramADVideoItemHolder == null) {
        break label1105;
      }
      localObject1 = paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetImageView;
      label329:
      a(paramQQAppInterface, (ImageView)localObject1, paramVideoInfo, paramADVideoItemHolder, 60, i, paramOnClickListener, paramDrawable, paramBoolean);
      if (paramADVideoItemHolder == null) {
        break label1111;
      }
      localObject1 = paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetImageView;
      label361:
      a(paramQQAppInterface, (ImageView)localObject1, paramVideoInfo, paramADVideoItemHolder, 70, 11, paramOnClickListener, paramDrawable, paramBoolean);
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.jdField_h_of_type_AndroidViewView;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
      }
      if (paramADVideoItemHolder == null) {
        break label1117;
      }
      localObject1 = paramADVideoItemHolder.jdField_i_of_type_AndroidViewView;
      label417:
      a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.jdField_l_of_type_AndroidViewView;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
      }
      if (paramADVideoItemHolder == null) {
        break label1123;
      }
      localObject1 = paramADVideoItemHolder.jdField_l_of_type_AndroidViewView;
      label463:
      a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.jdField_l_of_type_AndroidViewView;
        if (localObject1 != null)
        {
          localObject1 = ((View)localObject1).getParent();
          if (localObject1 != null) {
            ((ViewParent)localObject1).requestDisallowInterceptTouchEvent(true);
          }
        }
      }
      if (paramADVideoItemHolder == null) {
        break label1129;
      }
      localObject1 = paramADVideoItemHolder.n;
      label522:
      a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      AdVideoButtonUIUtils.a(paramContext, paramADVideoItemHolder);
      if (paramADVideoItemHolder != null)
      {
        localObject2 = paramADVideoItemHolder.jdField_g_of_type_AndroidWidgetTextView;
        if (localObject2 != null)
        {
          if (paramVideoInfo == null) {
            break label1135;
          }
          localObject1 = paramVideoInfo.k;
          if (localObject1 == null) {
            break label1135;
          }
          localObject1 = (CharSequence)localObject1;
          label579:
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      if (paramADVideoItemHolder == null) {
        break label1145;
      }
      localObject1 = paramADVideoItemHolder.jdField_g_of_type_AndroidWidgetTextView;
      label598:
      a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      if (paramADVideoItemHolder != null)
      {
        localObject2 = paramADVideoItemHolder.jdField_h_of_type_AndroidWidgetTextView;
        if (localObject2 != null)
        {
          if (paramVideoInfo == null) {
            break label1151;
          }
          localObject1 = paramVideoInfo.c;
          if (localObject1 == null) {
            break label1151;
          }
          localObject1 = (CharSequence)localObject1;
          label652:
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      if (paramADVideoItemHolder == null) {
        break label1161;
      }
      localObject1 = paramADVideoItemHolder.jdField_h_of_type_AndroidWidgetTextView;
      label671:
      a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.jdField_a_of_type_AndroidViewView;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
      }
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
        if (localObject1 != null) {
          ((RelativeLayout)localObject1).setVisibility(8);
        }
      }
      if (paramADVideoItemHolder == null) {
        break label1167;
      }
      localObject1 = paramADVideoItemHolder.jdField_d_of_type_AndroidViewView;
      label743:
      if ((localObject1 != null) && (paramADVideoItemHolder != null))
      {
        localObject1 = paramADVideoItemHolder.jdField_d_of_type_AndroidViewView;
        if (localObject1 != null) {
          ((View)localObject1).setOnClickListener(null);
        }
      }
      if (paramADVideoItemHolder != null)
      {
        localObject2 = paramADVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView;
        if (localObject2 != null)
        {
          if (paramVideoInfo == null) {
            break label1173;
          }
          localObject1 = paramVideoInfo.k;
          if (localObject1 == null) {
            break label1173;
          }
          localObject1 = (CharSequence)localObject1;
          label812:
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      if (paramADVideoItemHolder == null) {
        break label1183;
      }
      localObject1 = paramADVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView;
      label831:
      a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.e;
        if (localObject1 != null)
        {
          ((TextView)localObject1).setText((CharSequence)HardCodeUtil.a(2131715979));
          i = AIOUtils.a(12.0F, paramContext.getResources());
          localObject2 = paramContext.getResources().getDrawable(2130843300);
          ((Drawable)localObject2).setBounds(0, 0, i, i);
          ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
        }
      }
      if (paramADVideoItemHolder == null) {
        break label1189;
      }
      localObject1 = paramADVideoItemHolder.f;
      label932:
      a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      if (paramADVideoItemHolder == null) {
        break label1195;
      }
    }
    label1033:
    label1063:
    label1195:
    for (Object localObject1 = paramADVideoItemHolder.jdField_g_of_type_AndroidViewView;; localObject1 = null)
    {
      a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout;
        if (localObject1 != null) {
          ((RelativeLayout)localObject1).setVisibility(8);
        }
      }
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetLinearLayout;
        if (localObject1 != null) {
          ((LinearLayout)localObject1).setVisibility(0);
        }
      }
      d(paramQQAppInterface, paramContext, paramDrawable, paramVideoInfo, paramADVideoItemHolder, paramOnClickListener, paramBoolean);
      return;
      localObject1 = null;
      break;
      if (paramADVideoItemHolder == null) {
        break label221;
      }
      localObject2 = paramADVideoItemHolder.jdField_g_of_type_AndroidViewView;
      if (localObject2 == null) {
        break label221;
      }
      ((View)localObject2).setBackgroundDrawable((Drawable)localObject1);
      break label221;
      f = Utils.dp2px(6.0D);
      break label235;
      label1075:
      if (paramADVideoItemHolder == null) {
        break label287;
      }
      localObject2 = paramADVideoItemHolder.jdField_m_of_type_AndroidViewView;
      if (localObject2 == null) {
        break label287;
      }
      ((View)localObject2).setBackgroundDrawable((Drawable)localObject1);
      break label287;
      label1105:
      localObject1 = null;
      break label329;
      label1111:
      localObject1 = null;
      break label361;
      label1117:
      localObject1 = null;
      break label417;
      label1123:
      localObject1 = null;
      break label463;
      label1129:
      localObject1 = null;
      break label522;
      label1135:
      localObject1 = (CharSequence)"";
      break label579;
      label1145:
      localObject1 = null;
      break label598;
      label1151:
      localObject1 = (CharSequence)"";
      break label652;
      localObject1 = null;
      break label671;
      localObject1 = null;
      break label743;
      localObject1 = (CharSequence)"";
      break label812;
      localObject1 = null;
      break label831;
      localObject1 = null;
      break label932;
    }
  }
  
  private final void d(QQAppInterface paramQQAppInterface, Context paramContext, Drawable paramDrawable, VideoInfo paramVideoInfo, ADVideoItemHolder paramADVideoItemHolder, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (!ReadInJoyAdUtils.a(paramVideoInfo))) {}
    Object localObject1;
    VideoAdInfo localVideoAdInfo;
    do
    {
      do
      {
        return;
        if (paramADVideoItemHolder != null)
        {
          localObject1 = paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout;
          if (localObject1 != null) {
            ((RelativeLayout)localObject1).setVisibility(0);
          }
        }
        if (paramADVideoItemHolder != null)
        {
          localObject1 = paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetLinearLayout;
          if (localObject1 != null) {
            ((LinearLayout)localObject1).setVisibility(8);
          }
        }
      } while (paramVideoInfo == null);
      localVideoAdInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
    } while (localVideoAdInfo == null);
    if (paramADVideoItemHolder != null)
    {
      localObject2 = paramADVideoItemHolder.k;
      if (localObject2 != null)
      {
        localObject1 = localVideoAdInfo.G;
        if (localObject1 == null) {
          break label702;
        }
        localObject1 = (CharSequence)localObject1;
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
    }
    Object localObject2 = a;
    label141:
    label237:
    label497:
    int i;
    if (paramADVideoItemHolder != null)
    {
      localObject1 = paramADVideoItemHolder.k;
      ((AdVideoRefreshMenuUIUtils)localObject2).a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      if (!paramBoolean) {
        break label724;
      }
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.k;
        if (localObject1 != null) {
          ((TextView)localObject1).setTextSize(18.0F);
        }
      }
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.k;
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(Color.parseColor("#FF6404"));
        }
      }
      if (paramADVideoItemHolder == null) {
        break label718;
      }
      localObject1 = paramADVideoItemHolder.k;
      if (localObject1 == null) {
        break label718;
      }
      localObject1 = ((TextView)localObject1).getLayoutParams();
      localObject2 = localObject1;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        localObject2 = null;
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject2;
      if (localObject1 != null) {
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.a(10.0F, paramContext.getResources());
      }
      if (paramADVideoItemHolder != null)
      {
        localObject2 = paramADVideoItemHolder.k;
        if (localObject2 != null) {
          ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
      label306:
      if (!TextUtils.isEmpty((CharSequence)localVideoAdInfo.H)) {
        break label752;
      }
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.jdField_j_of_type_AndroidWidgetTextView;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localVideoAdInfo.F))
      {
        if (paramADVideoItemHolder != null)
        {
          localObject1 = paramADVideoItemHolder.jdField_l_of_type_AndroidWidgetTextView;
          if (localObject1 != null) {
            ((TextView)localObject1).setText((CharSequence)localVideoAdInfo.F);
          }
        }
        localObject2 = a;
        if (paramADVideoItemHolder == null) {
          break label845;
        }
        localObject1 = paramADVideoItemHolder.jdField_l_of_type_AndroidWidgetTextView;
        label405:
        ((AdVideoRefreshMenuUIUtils)localObject2).a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
        if (paramADVideoItemHolder != null)
        {
          localObject1 = paramADVideoItemHolder.jdField_i_of_type_AndroidWidgetTextView;
          if (localObject1 != null) {
            ((TextView)localObject1).setText((CharSequence)localVideoAdInfo.F);
          }
        }
        localObject2 = a;
        if (paramADVideoItemHolder == null) {
          break label851;
        }
        localObject1 = paramADVideoItemHolder.jdField_i_of_type_AndroidWidgetTextView;
        label466:
        ((AdVideoRefreshMenuUIUtils)localObject2).a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      }
      localObject2 = a;
      if (paramADVideoItemHolder == null) {
        break label857;
      }
      localObject1 = paramADVideoItemHolder.jdField_m_of_type_AndroidWidgetTextView;
      ((AdVideoRefreshMenuUIUtils)localObject2).a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      localObject2 = a;
      if (paramADVideoItemHolder == null) {
        break label863;
      }
      localObject1 = paramADVideoItemHolder.jdField_d_of_type_AndroidWidgetImageView;
      label528:
      ((AdVideoRefreshMenuUIUtils)localObject2).a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      localObject2 = a;
      if (paramADVideoItemHolder == null) {
        break label869;
      }
      localObject1 = paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetRelativeLayout;
      label559:
      ((AdVideoRefreshMenuUIUtils)localObject2).a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      if (!paramBoolean) {
        break label875;
      }
      i = 5;
      label581:
      localObject2 = a;
      if (paramADVideoItemHolder == null) {
        break label882;
      }
      localObject1 = paramADVideoItemHolder.jdField_d_of_type_AndroidWidgetImageView;
      label598:
      ((AdVideoRefreshMenuUIUtils)localObject2).a(paramQQAppInterface, (ImageView)localObject1, paramVideoInfo, paramADVideoItemHolder, 32, i, paramOnClickListener, paramDrawable, paramBoolean);
      if (paramBoolean)
      {
        if (paramADVideoItemHolder == null) {
          break label888;
        }
        paramQQAppInterface = paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout;
        if (paramQQAppInterface == null) {
          break label888;
        }
      }
    }
    label702:
    label718:
    label724:
    label752:
    label882:
    label888:
    for (paramQQAppInterface = paramQQAppInterface.getLayoutParams();; paramQQAppInterface = null)
    {
      paramDrawable = paramQQAppInterface;
      if (!(paramQQAppInterface instanceof LinearLayout.LayoutParams)) {
        paramDrawable = null;
      }
      paramQQAppInterface = (LinearLayout.LayoutParams)paramDrawable;
      if (paramQQAppInterface != null) {
        paramQQAppInterface.leftMargin = AIOUtils.a(10.0F, paramContext.getResources());
      }
      if (paramADVideoItemHolder != null)
      {
        paramContext = paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout;
        if (paramContext != null) {
          paramContext.setLayoutParams((ViewGroup.LayoutParams)paramQQAppInterface);
        }
      }
      return;
      localObject1 = (CharSequence)"";
      break;
      localObject1 = null;
      break label141;
      localObject1 = null;
      break label237;
      if (paramADVideoItemHolder == null) {
        break label306;
      }
      localObject1 = paramADVideoItemHolder.k;
      if (localObject1 == null) {
        break label306;
      }
      ((TextView)localObject1).setTextSize(15.0F);
      break label306;
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.jdField_j_of_type_AndroidWidgetTextView;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(0);
        }
      }
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.jdField_j_of_type_AndroidWidgetTextView;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)localVideoAdInfo.H);
        }
      }
      localObject2 = a;
      if (paramADVideoItemHolder != null) {}
      for (localObject1 = paramADVideoItemHolder.jdField_j_of_type_AndroidWidgetTextView;; localObject1 = null)
      {
        ((AdVideoRefreshMenuUIUtils)localObject2).a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
        break;
      }
      localObject1 = null;
      break label405;
      localObject1 = null;
      break label466;
      localObject1 = null;
      break label497;
      localObject1 = null;
      break label528;
      localObject1 = null;
      break label559;
      i = 6;
      break label581;
      localObject1 = null;
      break label598;
    }
  }
  
  private final void e(QQAppInterface paramQQAppInterface, Context paramContext, Drawable paramDrawable, VideoInfo paramVideoInfo, ADVideoItemHolder paramADVideoItemHolder, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    Object localObject = null;
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    if ((paramVideoInfo != null) && (paramVideoInfo.jdField_a_of_type_Int == 0))
    {
      if (paramADVideoItemHolder != null)
      {
        paramQQAppInterface = paramADVideoItemHolder.jdField_j_of_type_AndroidViewViewGroup;
        if (paramQQAppInterface != null) {
          paramQQAppInterface.setVisibility(8);
        }
      }
      if (paramBoolean)
      {
        if (paramADVideoItemHolder != null)
        {
          paramQQAppInterface = paramADVideoItemHolder.jdField_j_of_type_AndroidViewViewGroup;
          if (paramQQAppInterface != null) {
            paramQQAppInterface.setVisibility(0);
          }
        }
        if (paramADVideoItemHolder == null) {
          break label437;
        }
        paramQQAppInterface = paramADVideoItemHolder.jdField_j_of_type_AndroidViewViewGroup;
        label82:
        a((View)paramQQAppInterface, paramADVideoItemHolder, paramOnClickListener);
        if (paramADVideoItemHolder == null) {
          break label442;
        }
        paramQQAppInterface = paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoFeedsFollowButton;
        if (paramQQAppInterface == null) {
          break label442;
        }
        paramQQAppInterface = paramQQAppInterface.a();
        label116:
        a(paramQQAppInterface, paramADVideoItemHolder, paramOnClickListener);
        if (paramADVideoItemHolder == null) {
          break label447;
        }
        paramQQAppInterface = paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
        if (paramQQAppInterface == null) {
          break label447;
        }
        paramQQAppInterface = paramQQAppInterface.getLayoutParams();
        label145:
        if ((paramQQAppInterface instanceof LinearLayout.LayoutParams)) {
          ((LinearLayout.LayoutParams)paramQQAppInterface).leftMargin = AIOUtils.a(15.0F, paramContext.getResources());
        }
        if (paramADVideoItemHolder != null)
        {
          paramQQAppInterface = paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetTextView;
          if (paramQQAppInterface != null) {
            paramQQAppInterface.setTextSize(14.0F);
          }
        }
      }
      if (paramVideoInfo == null) {
        Intrinsics.throwNpe();
      }
      paramDrawable = ReadInJoyVideoFeedsAdUtils.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      if (paramADVideoItemHolder == null) {
        break label452;
      }
      paramQQAppInterface = paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      label219:
      if ((paramQQAppInterface != null) && (paramDrawable != null))
      {
        paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setAdvertisementInfo(paramDrawable);
        paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setDownloadScene(AdDownloadScene.VideoFloatButton);
        if ((paramContext instanceof Activity)) {
          paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setActivity(new SoftReference(paramContext));
        }
        a((View)paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, paramADVideoItemHolder, paramOnClickListener);
        if (!paramBoolean) {
          break label457;
        }
        paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setProgressStyle((IDownloadStyle)HorizontalProgressStyle.VideoStyleTikTok);
      }
      label305:
      paramQQAppInterface = localObject;
      if (paramADVideoItemHolder != null) {
        paramQQAppInterface = paramADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      }
      if ((paramQQAppInterface != null) && (paramDrawable != null))
      {
        paramADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setAdvertisementInfo(paramDrawable);
        paramADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setDownloadScene(AdDownloadScene.VideoFloatCardButton);
        if ((paramContext instanceof Activity)) {
          paramADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setActivity(new SoftReference(paramContext));
        }
        a((View)paramADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, paramADVideoItemHolder, paramOnClickListener);
        if (!paramBoolean) {
          break label474;
        }
        paramADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setProgressStyle((IDownloadStyle)HorizontalProgressStyle.VideoCardStyleTikTok);
      }
    }
    for (;;)
    {
      ReadInJoyAdUtils.a(paramVideoInfo, paramADVideoItemHolder);
      AdVideoButtonUIUtils.a(false, paramADVideoItemHolder);
      return;
      f(paramQQAppInterface, paramContext, paramDrawable, paramVideoInfo, paramADVideoItemHolder, paramOnClickListener, paramBoolean);
      break;
      label437:
      paramQQAppInterface = null;
      break label82;
      label442:
      paramQQAppInterface = null;
      break label116;
      label447:
      paramQQAppInterface = null;
      break label145;
      label452:
      paramQQAppInterface = null;
      break label219;
      label457:
      paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setProgressStyle((IDownloadStyle)HorizontalProgressStyle.VideoStyleNormal);
      break label305;
      label474:
      paramADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setProgressStyle((IDownloadStyle)HorizontalProgressStyle.VideoCardStyleNormal);
    }
  }
  
  private final void f(QQAppInterface paramQQAppInterface, Context paramContext, Drawable paramDrawable, VideoInfo paramVideoInfo, ADVideoItemHolder paramADVideoItemHolder, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramADVideoItemHolder != null)
    {
      paramQQAppInterface = paramADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
      if (paramQQAppInterface != null) {
        paramQQAppInterface.setImagePlaceHolder(paramDrawable);
      }
    }
    if (paramADVideoItemHolder != null)
    {
      paramContext = paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
      if (paramContext != null)
      {
        if (paramVideoInfo == null) {
          break label172;
        }
        paramQQAppInterface = paramVideoInfo.k;
        if (paramQQAppInterface == null) {
          break label172;
        }
        paramQQAppInterface = (CharSequence)paramQQAppInterface;
        paramContext.setText(paramQQAppInterface);
      }
    }
    label72:
    label95:
    long l;
    if (paramADVideoItemHolder != null)
    {
      paramQQAppInterface = paramADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
      a((View)paramQQAppInterface, paramADVideoItemHolder, paramOnClickListener);
      if (paramVideoInfo == null) {
        break label186;
      }
      paramQQAppInterface = paramVideoInfo.j;
      if (TextUtils.isEmpty((CharSequence)paramQQAppInterface)) {
        break label197;
      }
      if (paramADVideoItemHolder != null)
      {
        paramQQAppInterface = paramADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
        if (paramQQAppInterface != null)
        {
          if (paramVideoInfo == null) {
            break label191;
          }
          paramContext = paramVideoInfo.j;
          if (paramContext == null) {
            break label191;
          }
          l = Long.parseLong(paramContext);
          label141:
          paramQQAppInterface.setHeadImgByUin(l, false);
        }
      }
      label148:
      if (paramADVideoItemHolder == null) {
        break label262;
      }
    }
    label257:
    label262:
    for (paramQQAppInterface = paramADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;; paramQQAppInterface = null)
    {
      a((View)paramQQAppInterface, paramADVideoItemHolder, paramOnClickListener);
      return;
      label172:
      paramQQAppInterface = (CharSequence)"";
      break;
      paramQQAppInterface = null;
      break label72;
      label186:
      paramQQAppInterface = null;
      break label95;
      label191:
      l = 0L;
      break label141;
      label197:
      if (paramVideoInfo != null)
      {
        paramQQAppInterface = paramVideoInfo.p;
        label208:
        if ((TextUtils.isEmpty((CharSequence)paramQQAppInterface)) || (paramADVideoItemHolder == null)) {
          break label255;
        }
        paramContext = paramADVideoItemHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
        if (paramContext == null) {
          break label148;
        }
        if (paramVideoInfo == null) {
          break label257;
        }
      }
      for (paramQQAppInterface = paramVideoInfo.p;; paramQQAppInterface = null)
      {
        paramContext.setImageSrc(paramQQAppInterface);
        break;
        paramQQAppInterface = null;
        break label208;
        label255:
        break;
      }
    }
  }
  
  public final void a(@Nullable Activity paramActivity, @Nullable VideoInfo paramVideoInfo, @Nullable ADVideoItemHolder paramADVideoItemHolder, @Nullable View.OnClickListener paramOnClickListener)
  {
    if ((paramActivity != null) && (paramVideoInfo != null))
    {
      if (paramADVideoItemHolder == null) {
        break label24;
      }
      localObject1 = paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetLinearLayout;
      if (localObject1 != null) {
        break label30;
      }
    }
    label24:
    label30:
    do
    {
      do
      {
        return;
        localObject1 = null;
        break;
        localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
      } while (localObject1 == null);
      localObject1 = ((VideoAdInfo)localObject1).h;
    } while (localObject1 == null);
    paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
    Object localObject2 = paramADVideoItemHolder.jdField_j_of_type_AndroidWidgetTextView;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "videoHolder.dpaReducedTab");
    int j = ((TextView)localObject2).getWidth();
    localObject2 = (Iterable)localObject1;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label167:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label167;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    int i = j;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = AdVideoDpaTagUtils.a((Context)paramActivity, paramVideoInfo, (String)localObject2);
      if (localObject3 != null) {
        ((TextView)localObject3).setOnClickListener(paramOnClickListener);
      }
      j = com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.device.RIJDisplayStyleManager.a(paramActivity)[0];
      int k = AIOUtils.a(125.0F, paramActivity.getResources());
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "dpaTagTextView");
      int m = (int)((TextView)localObject3).getPaint().measureText((String)localObject2);
      if (i + m >= j - k) {
        break label314;
      }
      paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
      i = m + 6 + i;
    }
    label314:
    for (;;)
    {
      break;
      return;
    }
  }
  
  public final void a(@NotNull Context paramContext, @Nullable VideoInfo paramVideoInfo, @Nullable ADVideoItemHolder paramADVideoItemHolder, @Nullable View.OnClickListener paramOnClickListener, boolean paramBoolean, @NotNull ClickableSpan paramClickableSpan)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramClickableSpan, "clickableSpan");
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (paramVideoInfo != null)
    {
      localObject = paramVideoInfo.c;
      if (localObject != null)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localSpannableStringBuilder.append((CharSequence)RIJStringUtils.a((String)localObject, 72));
          localSpannableStringBuilder.append((CharSequence)"  ");
        }
        HardCodeUtil.a(2131716063);
        paramVideoInfo = a(paramVideoInfo);
        if (paramVideoInfo == null) {
          break label130;
        }
      }
    }
    label130:
    for (paramVideoInfo = paramVideoInfo.optString("AdsIconText");; paramVideoInfo = null)
    {
      if (!TextUtils.isEmpty((CharSequence)paramVideoInfo)) {
        break label135;
      }
      ReadInJoyAdLog.a("Q.pubaccount.video.feeds.VideoFeedsAdapter", "detail ad  video in new style adsIconText: null");
      return;
      localObject = "";
      break;
    }
    label135:
    Object localObject = new Paint();
    ((Paint)localObject).setAntiAlias(true);
    ((Paint)localObject).setStyle(Paint.Style.FILL);
    ((Paint)localObject).setTextSize(AIOUtils.a(10.0F, paramContext.getResources()));
    ((Paint)localObject).setColor((int)3003121663L);
    float f = ((Paint)localObject).measureText(paramVideoInfo);
    int i;
    label200:
    Bitmap localBitmap;
    Canvas localCanvas;
    if (paramBoolean)
    {
      i = 10;
      int j = AIOUtils.a(i, paramContext.getResources());
      j = (int)f + j;
      int k = AIOUtils.a(1.0F, paramContext.getResources()) / 2;
      int m = AIOUtils.a(14.0F, paramContext.getResources());
      localBitmap = Bitmap.createBitmap(j, m, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      localCanvas.drawText(paramVideoInfo, AIOUtils.a(i / 2.0F, paramContext.getResources()), m / 2 - (((Paint)localObject).descent() + ((Paint)localObject).ascent()) / 2, (Paint)localObject);
      paramVideoInfo = new RectF(0.0F, k, j, m - k);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      ((Paint)localObject).setStrokeWidth(0.5F);
      if (!paramBoolean) {
        break label488;
      }
      localCanvas.drawRoundRect(paramVideoInfo, 19.0F, 19.0F, (Paint)localObject);
    }
    for (;;)
    {
      label488:
      try
      {
        localSpannableStringBuilder.setSpan(new VerticalCenterImageSpan(paramContext, localBitmap), localSpannableStringBuilder.length() - 1, localSpannableStringBuilder.length(), 33);
        localSpannableStringBuilder.setSpan(paramClickableSpan, localSpannableStringBuilder.length() - 1, localSpannableStringBuilder.length(), 33);
        if (paramADVideoItemHolder == null) {
          break;
        }
        paramVideoInfo = paramADVideoItemHolder.jdField_c_of_type_AndroidWidgetTextView;
        if (paramVideoInfo == null) {
          break;
        }
        paramVideoInfo.setPadding(paramVideoInfo.getPaddingLeft(), paramVideoInfo.getPaddingTop(), paramVideoInfo.getPaddingRight(), AIOUtils.a(1.0F, paramContext.getResources()));
        paramVideoInfo.setMovementMethod(LinkMovementMethod.getInstance());
        paramVideoInfo.setText((CharSequence)localSpannableStringBuilder);
        a.a((View)paramVideoInfo, paramADVideoItemHolder, paramOnClickListener);
        return;
      }
      catch (Throwable paramContext) {}
      i = 6;
      break label200;
      localCanvas.drawRoundRect(paramVideoInfo, 2.0F, 2.0F, (Paint)localObject);
    }
  }
  
  public final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, @Nullable Drawable paramDrawable, @Nullable VideoInfo paramVideoInfo, @Nullable ADVideoItemHolder paramADVideoItemHolder, @Nullable View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramQQAppInterface == null)) {
      return;
    }
    Integer localInteger;
    if (paramADVideoItemHolder != null)
    {
      localInteger = Integer.valueOf(paramADVideoItemHolder.jdField_a_of_type_Int);
      if (localInteger != null) {
        break label66;
      }
      label29:
      c(paramQQAppInterface, paramContext, paramDrawable, paramVideoInfo, paramADVideoItemHolder, paramOnClickListener, paramBoolean);
    }
    for (;;)
    {
      e(paramQQAppInterface, paramContext, paramDrawable, paramVideoInfo, paramADVideoItemHolder, paramOnClickListener, paramBoolean);
      return;
      localInteger = null;
      break;
      label66:
      if (localInteger.intValue() != 4) {
        break label29;
      }
      b(paramQQAppInterface, paramContext, paramDrawable, paramVideoInfo, paramADVideoItemHolder, paramOnClickListener, paramBoolean);
    }
  }
  
  public final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable ImageView paramImageView, @Nullable VideoInfo paramVideoInfo, @Nullable ADVideoItemHolder paramADVideoItemHolder, int paramInt1, int paramInt2, @Nullable View.OnClickListener paramOnClickListener, @Nullable Drawable paramDrawable, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramImageView == null) || (paramVideoInfo == null) || (paramADVideoItemHolder == null)) {
      return;
    }
    if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.j))
    {
      paramImageView.setImageDrawable((Drawable)FaceDrawable.getFaceDrawable((AppInterface)paramQQAppInterface, 1, paramVideoInfo.j, 1, paramDrawable, paramDrawable));
      return;
    }
    Context localContext = paramImageView.getContext();
    paramQQAppInterface = URLDrawable.URLDrawableOptions.obtain();
    float f;
    boolean bool;
    if (paramQQAppInterface != null)
    {
      f = paramInt1;
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      paramQQAppInterface.mRequestWidth = AIOUtils.a(f, localContext.getResources());
      paramQQAppInterface.mRequestHeight = AIOUtils.a(paramInt1, localContext.getResources());
      paramQQAppInterface.mLoadingDrawable = paramDrawable;
      paramQQAppInterface.mFailedDrawable = paramDrawable;
      paramDrawable = paramQQAppInterface;
      bool = ReadInJoyAdUtils.a(paramVideoInfo);
    }
    for (paramQQAppInterface = (URL)null;; paramQQAppInterface = localURL)
    {
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty((CharSequence)paramVideoInfo.p))
          {
            localURL = new URL("https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
            paramQQAppInterface = localURL;
            if (!bool) {
              continue;
            }
          }
        }
        catch (Exception paramVideoInfo)
        {
          URL localURL;
          continue;
          paramVideoInfo = null;
          continue;
          if (paramQQAppInterface == null) {
            continue;
          }
          paramQQAppInterface.setDecodeHandler(URLDrawableDecodeHandler.j);
          continue;
          continue;
        }
        try
        {
          paramVideoInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
          if (paramVideoInfo == null) {
            continue;
          }
          paramVideoInfo = paramVideoInfo.E;
          if (TextUtils.isEmpty((CharSequence)paramVideoInfo)) {
            continue;
          }
          paramVideoInfo = new URL(paramVideoInfo);
          paramQQAppInterface = paramVideoInfo;
        }
        catch (Exception paramVideoInfo) {}
      }
      paramQQAppInterface = URLDrawable.getDrawable(paramQQAppInterface, paramDrawable);
      if (paramQQAppInterface != null)
      {
        f = paramInt1;
        Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
        paramQQAppInterface.setTag(URLDrawableDecodeHandler.b(AIOUtils.a(f, localContext.getResources()), AIOUtils.a(paramInt1, localContext.getResources()), AIOUtils.a(paramInt2, localContext.getResources())));
      }
      if ((!bool) || (paramBoolean) || (paramADVideoItemHolder.jdField_d_of_type_AndroidWidgetImageView == null) || (paramADVideoItemHolder.jdField_d_of_type_AndroidWidgetImageView != paramImageView)) {
        break label394;
      }
      if (paramQQAppInterface != null) {
        paramQQAppInterface.setTag(new int[] { 0, 0, paramInt2, 3 });
      }
      if (paramQQAppInterface != null) {
        paramQQAppInterface.setDecodeHandler(URLDrawableDecodeHandler.k);
      }
      if (paramQQAppInterface != null) {
        paramImageView.setImageDrawable((Drawable)paramQQAppInterface);
      }
      a((View)paramImageView, paramADVideoItemHolder, paramOnClickListener);
      return;
      paramDrawable = null;
      break;
      localURL = new URL(paramVideoInfo.p);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoRefreshMenuUIUtils
 * JD-Core Version:    0.7.0.1
 */