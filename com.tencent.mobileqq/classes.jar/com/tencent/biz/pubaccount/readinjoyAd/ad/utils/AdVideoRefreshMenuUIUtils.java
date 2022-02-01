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
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
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
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.base.view.widget.ICircleCountDownView;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.common.widget.AbsReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.common.widget.IReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsFollowButton;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.qroute.QRoute;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdVideoRefreshMenuUIUtils;", "", "()V", "TAG", "", "drawAdTag", "", "context", "Landroid/content/Context;", "videoInfo", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "videoHolder", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/ADVideoItemHolder;", "listener", "Landroid/view/View$OnClickListener;", "isTiktokStyle", "", "clickableSpan", "Landroid/text/style/ClickableSpan;", "fillDpaTags", "activity", "Landroid/app/Activity;", "fillDpaUIData", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "drawable", "Landroid/graphics/drawable/Drawable;", "fillUIData", "fillUIDataForAllAdType", "fillUIDataForAllAdTypeWithBusiType", "fillUIDataForTypeNewVideo", "fillUIDataForTypeVideo", "getExtraJson", "Lorg/json/JSONObject;", "setIcon", "imageView", "Landroid/widget/ImageView;", "width", "", "radius", "mDefaultFaceDrawable", "setRealClickListener", "view", "Landroid/view/View;", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class AdVideoRefreshMenuUIUtils
{
  public static final AdVideoRefreshMenuUIUtils a = new AdVideoRefreshMenuUIUtils();
  
  private final JSONObject a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo != null)
    {
      paramVideoInfo = paramVideoInfo.as;
      if (paramVideoInfo != null)
      {
        paramVideoInfo = paramVideoInfo.R;
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
    if (paramContext != null)
    {
      if (paramQQAppInterface == null) {
        return;
      }
      int j = 0;
      paramDrawable = null;
      if ((paramVideoInfo == null) || (paramVideoInfo.a != 0))
      {
        if (paramADVideoItemHolder != null)
        {
          paramQQAppInterface = paramADVideoItemHolder.aH;
          if (paramQQAppInterface != null) {
            paramQQAppInterface.setVisibility(0);
          }
        }
        if (paramADVideoItemHolder != null) {
          paramQQAppInterface = paramADVideoItemHolder.aH;
        } else {
          paramQQAppInterface = null;
        }
        a((View)paramQQAppInterface, paramADVideoItemHolder, paramOnClickListener);
        if (paramADVideoItemHolder != null) {
          paramQQAppInterface = paramADVideoItemHolder.a;
        } else {
          paramQQAppInterface = null;
        }
        a((View)paramQQAppInterface, paramADVideoItemHolder, paramOnClickListener);
      }
      paramQQAppInterface = paramDrawable;
      if (paramADVideoItemHolder != null) {
        paramQQAppInterface = paramADVideoItemHolder.d;
      }
      a((View)paramQQAppInterface, paramADVideoItemHolder, paramOnClickListener);
      double d;
      int i;
      if (paramADVideoItemHolder != null)
      {
        paramQQAppInterface = paramADVideoItemHolder.f;
        if (paramQQAppInterface != null)
        {
          paramDrawable = paramContext.getResources();
          if (paramDrawable != null)
          {
            paramDrawable = paramDrawable.getDisplayMetrics();
            if (paramDrawable != null)
            {
              d = paramDrawable.widthPixels;
              Double.isNaN(d);
              i = MathKt.roundToInt(d * 0.7D);
              break label191;
            }
          }
          i = 0;
          label191:
          paramQQAppInterface.setMaxWidth(i);
        }
      }
      if (paramVideoInfo != null)
      {
        paramDrawable = paramVideoInfo.g;
        if (paramDrawable != null) {}
      }
      else
      {
        paramDrawable = "";
      }
      paramQQAppInterface = paramDrawable;
      if (!TextUtils.isEmpty((CharSequence)paramDrawable))
      {
        paramQQAppInterface = paramContext.getResources();
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.getText(2131915573);
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface = paramQQAppInterface.toString();
            if (paramQQAppInterface != null) {
              break label265;
            }
          }
        }
        paramQQAppInterface = "";
      }
      label265:
      if (paramADVideoItemHolder != null)
      {
        paramDrawable = paramADVideoItemHolder.e;
        if (paramDrawable != null) {
          paramDrawable.setText((CharSequence)paramQQAppInterface);
        }
      }
      if (paramADVideoItemHolder != null)
      {
        paramQQAppInterface = paramADVideoItemHolder.e;
        if (paramQQAppInterface != null)
        {
          paramDrawable = paramContext.getResources();
          i = j;
          if (paramDrawable != null)
          {
            paramDrawable = paramDrawable.getDisplayMetrics();
            i = j;
            if (paramDrawable != null)
            {
              d = paramDrawable.widthPixels;
              Double.isNaN(d);
              i = MathKt.roundToInt(d * 0.224D);
            }
          }
          paramQQAppInterface.setMaxWidth(i);
        }
      }
      if (paramVideoInfo != null)
      {
        paramQQAppInterface = paramVideoInfo.as;
        if (paramQQAppInterface != null)
        {
          paramDrawable = paramQQAppInterface.t;
          if (paramDrawable != null) {
            break label389;
          }
        }
      }
      paramDrawable = "";
      label389:
      paramQQAppInterface = paramDrawable;
      if (!TextUtils.isEmpty((CharSequence)paramDrawable))
      {
        paramQQAppInterface = paramContext.getResources();
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.getText(2131915572);
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface = paramQQAppInterface.toString();
            if (paramQQAppInterface != null) {
              break label436;
            }
          }
        }
        paramQQAppInterface = "";
      }
      label436:
      if (paramADVideoItemHolder != null)
      {
        paramContext = paramADVideoItemHolder.e;
        if (paramContext != null) {
          paramContext.setText((CharSequence)paramQQAppInterface);
        }
      }
    }
  }
  
  private final void c(QQAppInterface paramQQAppInterface, Context paramContext, Drawable paramDrawable, VideoInfo paramVideoInfo, ADVideoItemHolder paramADVideoItemHolder, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (paramQQAppInterface == null) {
        return;
      }
      boolean bool = ReadInJoyAdUtils.a(paramVideoInfo);
      if ((paramVideoInfo == null) || (paramVideoInfo.a != 0))
      {
        if (paramADVideoItemHolder != null)
        {
          localObject1 = paramADVideoItemHolder.aH;
          if (localObject1 != null) {
            ((ViewGroup)localObject1).setVisibility(8);
          }
        }
        if (paramADVideoItemHolder != null) {
          localObject1 = paramADVideoItemHolder.b;
        } else {
          localObject1 = null;
        }
        a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      }
      Object localObject1 = a(paramVideoInfo);
      int i;
      if ((localObject1 != null) && (((JSONObject)localObject1).has("down_time") == true)) {
        i = ((JSONObject)localObject1).optInt("down_time") * 1000;
      } else {
        i = 0;
      }
      if ((i > 0) && (paramADVideoItemHolder != null))
      {
        localObject1 = paramADVideoItemHolder.s;
        if (localObject1 != null) {
          ((ICircleCountDownView)localObject1).setDuration(i);
        }
      }
      localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setCornerRadius(Utils.dp2px(2.0D));
      ((GradientDrawable)localObject1).setColor(Color.parseColor("#12B7F6"));
      Object localObject2;
      if (Build.VERSION.SDK_INT >= 16)
      {
        if (paramADVideoItemHolder != null)
        {
          localObject2 = paramADVideoItemHolder.q;
          if (localObject2 != null) {
            ((View)localObject2).setBackground((Drawable)localObject1);
          }
        }
      }
      else if (paramADVideoItemHolder != null)
      {
        localObject2 = paramADVideoItemHolder.q;
        if (localObject2 != null) {
          ((View)localObject2).setBackgroundDrawable((Drawable)localObject1);
        }
      }
      if (paramBoolean) {
        i = Utils.dp2px(10.0D);
      } else {
        i = Utils.dp2px(6.0D);
      }
      ((GradientDrawable)localObject1).setCornerRadius(i);
      ((GradientDrawable)localObject1).setColor(Color.parseColor("#FFFFFF"));
      if (Build.VERSION.SDK_INT >= 16)
      {
        if (paramADVideoItemHolder != null)
        {
          localObject2 = paramADVideoItemHolder.A;
          if (localObject2 != null) {
            ((View)localObject2).setBackground((Drawable)localObject1);
          }
        }
      }
      else if (paramADVideoItemHolder != null)
      {
        localObject2 = paramADVideoItemHolder.A;
        if (localObject2 != null) {
          ((View)localObject2).setBackgroundDrawable((Drawable)localObject1);
        }
      }
      if ((bool) && (paramBoolean)) {
        i = 12;
      } else {
        i = 2;
      }
      if (paramADVideoItemHolder != null) {
        localObject1 = paramADVideoItemHolder.z;
      } else {
        localObject1 = null;
      }
      a(paramQQAppInterface, (ImageView)localObject1, paramVideoInfo, paramADVideoItemHolder, 60, i, paramOnClickListener, paramDrawable, paramBoolean);
      if (paramADVideoItemHolder != null) {
        localObject1 = paramADVideoItemHolder.m;
      } else {
        localObject1 = null;
      }
      a(paramQQAppInterface, (ImageView)localObject1, paramVideoInfo, paramADVideoItemHolder, 70, 11, paramOnClickListener, paramDrawable, paramBoolean);
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.u;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
      }
      if (paramADVideoItemHolder != null) {
        localObject1 = paramADVideoItemHolder.v;
      } else {
        localObject1 = null;
      }
      a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.y;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
      }
      if (paramADVideoItemHolder != null) {
        localObject1 = paramADVideoItemHolder.y;
      } else {
        localObject1 = null;
      }
      a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.y;
        if (localObject1 != null)
        {
          localObject1 = ((View)localObject1).getParent();
          if (localObject1 != null) {
            ((ViewParent)localObject1).requestDisallowInterceptTouchEvent(true);
          }
        }
      }
      if (paramADVideoItemHolder != null) {
        localObject1 = paramADVideoItemHolder.D;
      } else {
        localObject1 = null;
      }
      a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      AdVideoButtonUIUtils.a(paramContext, paramADVideoItemHolder);
      if (paramADVideoItemHolder != null)
      {
        localObject2 = paramADVideoItemHolder.B;
        if (localObject2 != null)
        {
          if (paramVideoInfo != null)
          {
            localObject1 = paramVideoInfo.r;
            if (localObject1 != null)
            {
              localObject1 = (CharSequence)localObject1;
              break label684;
            }
          }
          localObject1 = (CharSequence)"";
          label684:
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      if (paramADVideoItemHolder != null) {
        localObject1 = paramADVideoItemHolder.B;
      } else {
        localObject1 = null;
      }
      a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      if (paramADVideoItemHolder != null)
      {
        localObject2 = paramADVideoItemHolder.C;
        if (localObject2 != null)
        {
          if (paramVideoInfo != null)
          {
            localObject1 = paramVideoInfo.g;
            if (localObject1 != null)
            {
              localObject1 = (CharSequence)localObject1;
              break label773;
            }
          }
          localObject1 = (CharSequence)"";
          label773:
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      if (paramADVideoItemHolder != null) {
        localObject1 = paramADVideoItemHolder.C;
      } else {
        localObject1 = null;
      }
      a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.h;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
      }
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.d;
        if (localObject1 != null) {
          ((RelativeLayout)localObject1).setVisibility(8);
        }
      }
      if (paramADVideoItemHolder != null) {
        localObject1 = paramADVideoItemHolder.k;
      } else {
        localObject1 = null;
      }
      if ((localObject1 != null) && (paramADVideoItemHolder != null))
      {
        localObject1 = paramADVideoItemHolder.k;
        if (localObject1 != null) {
          ((View)localObject1).setOnClickListener(null);
        }
      }
      if (paramADVideoItemHolder != null)
      {
        localObject2 = paramADVideoItemHolder.n;
        if (localObject2 != null)
        {
          if (paramVideoInfo != null)
          {
            localObject1 = paramVideoInfo.r;
            if (localObject1 != null)
            {
              localObject1 = (CharSequence)localObject1;
              break label961;
            }
          }
          localObject1 = (CharSequence)"";
          label961:
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      if (paramADVideoItemHolder != null) {
        localObject1 = paramADVideoItemHolder.n;
      } else {
        localObject1 = null;
      }
      a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.p;
        if (localObject1 != null)
        {
          ((TextView)localObject1).setText((CharSequence)HardCodeUtil.a(2131913358));
          i = AIOUtils.b(12.0F, paramContext.getResources());
          localObject2 = paramContext.getResources().getDrawable(2130844166);
          ((Drawable)localObject2).setBounds(0, 0, i, i);
          ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
        }
      }
      if (paramADVideoItemHolder != null) {
        localObject1 = paramADVideoItemHolder.o;
      } else {
        localObject1 = null;
      }
      a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      if (paramADVideoItemHolder != null) {
        localObject1 = paramADVideoItemHolder.q;
      } else {
        localObject1 = null;
      }
      a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.F;
        if (localObject1 != null) {
          ((RelativeLayout)localObject1).setVisibility(8);
        }
      }
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.E;
        if (localObject1 != null) {
          ((LinearLayout)localObject1).setVisibility(0);
        }
      }
      d(paramQQAppInterface, paramContext, paramDrawable, paramVideoInfo, paramADVideoItemHolder, paramOnClickListener, paramBoolean);
    }
  }
  
  private final void d(QQAppInterface paramQQAppInterface, Context paramContext, Drawable paramDrawable, VideoInfo paramVideoInfo, ADVideoItemHolder paramADVideoItemHolder, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if ((paramQQAppInterface != null) && (paramContext != null))
    {
      if (!ReadInJoyAdUtils.a(paramVideoInfo)) {
        return;
      }
      Object localObject1;
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.F;
        if (localObject1 != null) {
          ((RelativeLayout)localObject1).setVisibility(0);
        }
      }
      if (paramADVideoItemHolder != null)
      {
        localObject1 = paramADVideoItemHolder.E;
        if (localObject1 != null) {
          ((LinearLayout)localObject1).setVisibility(8);
        }
      }
      if (paramVideoInfo != null)
      {
        VideoAdInfo localVideoAdInfo = paramVideoInfo.as;
        if (localVideoAdInfo != null)
        {
          if (paramADVideoItemHolder != null)
          {
            localObject2 = paramADVideoItemHolder.J;
            if (localObject2 != null)
            {
              localObject1 = localVideoAdInfo.aq;
              if (localObject1 == null) {
                localObject1 = "";
              }
              ((TextView)localObject2).setText((CharSequence)localObject1);
            }
          }
          Object localObject2 = a;
          Object localObject3 = null;
          if (paramADVideoItemHolder != null) {
            localObject1 = paramADVideoItemHolder.J;
          } else {
            localObject1 = null;
          }
          ((AdVideoRefreshMenuUIUtils)localObject2).a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
          if (paramBoolean)
          {
            if (paramADVideoItemHolder != null)
            {
              localObject1 = paramADVideoItemHolder.J;
              if (localObject1 != null) {
                ((TextView)localObject1).setTextSize(18.0F);
              }
            }
            if (paramADVideoItemHolder != null)
            {
              localObject1 = paramADVideoItemHolder.J;
              if (localObject1 != null) {
                ((TextView)localObject1).setTextColor(Color.parseColor("#FF6404"));
              }
            }
            if (paramADVideoItemHolder != null)
            {
              localObject1 = paramADVideoItemHolder.J;
              if (localObject1 != null)
              {
                localObject1 = ((TextView)localObject1).getLayoutParams();
                break label255;
              }
            }
            localObject1 = null;
            label255:
            localObject2 = localObject1;
            if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
              localObject2 = null;
            }
            localObject1 = (RelativeLayout.LayoutParams)localObject2;
            if (localObject1 != null) {
              ((RelativeLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.b(10.0F, paramContext.getResources());
            }
            if (paramADVideoItemHolder != null)
            {
              localObject2 = paramADVideoItemHolder.J;
              if (localObject2 != null) {
                ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
              }
            }
          }
          else if (paramADVideoItemHolder != null)
          {
            localObject1 = paramADVideoItemHolder.J;
            if (localObject1 != null) {
              ((TextView)localObject1).setTextSize(15.0F);
            }
          }
          if (TextUtils.isEmpty((CharSequence)localVideoAdInfo.ar))
          {
            if (paramADVideoItemHolder != null)
            {
              localObject1 = paramADVideoItemHolder.I;
              if (localObject1 != null) {
                ((TextView)localObject1).setVisibility(8);
              }
            }
          }
          else
          {
            if (paramADVideoItemHolder != null)
            {
              localObject1 = paramADVideoItemHolder.I;
              if (localObject1 != null) {
                ((TextView)localObject1).setVisibility(0);
              }
            }
            if (paramADVideoItemHolder != null)
            {
              localObject1 = paramADVideoItemHolder.I;
              if (localObject1 != null) {
                ((TextView)localObject1).setText((CharSequence)localVideoAdInfo.ar);
              }
            }
            localObject2 = a;
            if (paramADVideoItemHolder != null) {
              localObject1 = paramADVideoItemHolder.I;
            } else {
              localObject1 = null;
            }
            ((AdVideoRefreshMenuUIUtils)localObject2).a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
          }
          if (!TextUtils.isEmpty((CharSequence)localVideoAdInfo.ap))
          {
            if (paramADVideoItemHolder != null)
            {
              localObject1 = paramADVideoItemHolder.M;
              if (localObject1 != null) {
                ((TextView)localObject1).setText((CharSequence)localVideoAdInfo.ap);
              }
            }
            localObject2 = a;
            if (paramADVideoItemHolder != null) {
              localObject1 = paramADVideoItemHolder.M;
            } else {
              localObject1 = null;
            }
            ((AdVideoRefreshMenuUIUtils)localObject2).a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
            if (paramADVideoItemHolder != null)
            {
              localObject1 = paramADVideoItemHolder.H;
              if (localObject1 != null) {
                ((TextView)localObject1).setText((CharSequence)localVideoAdInfo.ap);
              }
            }
            localObject2 = a;
            if (paramADVideoItemHolder != null) {
              localObject1 = paramADVideoItemHolder.H;
            } else {
              localObject1 = null;
            }
            ((AdVideoRefreshMenuUIUtils)localObject2).a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
          }
          localObject2 = a;
          if (paramADVideoItemHolder != null) {
            localObject1 = paramADVideoItemHolder.N;
          } else {
            localObject1 = null;
          }
          ((AdVideoRefreshMenuUIUtils)localObject2).a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
          localObject2 = a;
          if (paramADVideoItemHolder != null) {
            localObject1 = paramADVideoItemHolder.L;
          } else {
            localObject1 = null;
          }
          ((AdVideoRefreshMenuUIUtils)localObject2).a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
          localObject2 = a;
          if (paramADVideoItemHolder != null) {
            localObject1 = paramADVideoItemHolder.K;
          } else {
            localObject1 = null;
          }
          ((AdVideoRefreshMenuUIUtils)localObject2).a((View)localObject1, paramADVideoItemHolder, paramOnClickListener);
          int i;
          if (paramBoolean) {
            i = 5;
          } else {
            i = 6;
          }
          localObject2 = a;
          if (paramADVideoItemHolder != null) {
            localObject1 = paramADVideoItemHolder.L;
          } else {
            localObject1 = null;
          }
          ((AdVideoRefreshMenuUIUtils)localObject2).a(paramQQAppInterface, (ImageView)localObject1, paramVideoInfo, paramADVideoItemHolder, 32, i, paramOnClickListener, paramDrawable, paramBoolean);
          if (paramBoolean)
          {
            if (paramADVideoItemHolder != null)
            {
              paramQQAppInterface = paramADVideoItemHolder.F;
              if (paramQQAppInterface != null)
              {
                paramQQAppInterface = paramQQAppInterface.getLayoutParams();
                break label831;
              }
            }
            paramQQAppInterface = null;
            label831:
            if (!(paramQQAppInterface instanceof LinearLayout.LayoutParams)) {
              paramQQAppInterface = localObject3;
            }
            paramQQAppInterface = (LinearLayout.LayoutParams)paramQQAppInterface;
            if (paramQQAppInterface != null) {
              paramQQAppInterface.leftMargin = AIOUtils.b(10.0F, paramContext.getResources());
            }
            if (paramADVideoItemHolder != null)
            {
              paramContext = paramADVideoItemHolder.F;
              if (paramContext != null) {
                paramContext.setLayoutParams((ViewGroup.LayoutParams)paramQQAppInterface);
              }
            }
          }
        }
      }
    }
  }
  
  private final void e(QQAppInterface paramQQAppInterface, Context paramContext, Drawable paramDrawable, VideoInfo paramVideoInfo, ADVideoItemHolder paramADVideoItemHolder, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      if ((paramVideoInfo != null) && (paramVideoInfo.a == 0))
      {
        if (paramADVideoItemHolder != null)
        {
          paramQQAppInterface = paramADVideoItemHolder.aH;
          if (paramQQAppInterface != null) {
            paramQQAppInterface.setVisibility(8);
          }
        }
      }
      else {
        f(paramQQAppInterface, paramContext, paramDrawable, paramVideoInfo, paramADVideoItemHolder, paramOnClickListener, paramBoolean);
      }
      paramDrawable = null;
      if (paramBoolean)
      {
        if (paramADVideoItemHolder != null)
        {
          paramQQAppInterface = paramADVideoItemHolder.aH;
          if (paramQQAppInterface != null) {
            paramQQAppInterface.setVisibility(0);
          }
        }
        if (paramADVideoItemHolder != null) {
          paramQQAppInterface = paramADVideoItemHolder.aH;
        } else {
          paramQQAppInterface = null;
        }
        a((View)paramQQAppInterface, paramADVideoItemHolder, paramOnClickListener);
        if (paramADVideoItemHolder != null)
        {
          paramQQAppInterface = paramADVideoItemHolder.aL;
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface = paramQQAppInterface.getView();
            break label143;
          }
        }
        paramQQAppInterface = null;
        label143:
        a(paramQQAppInterface, paramADVideoItemHolder, paramOnClickListener);
        if (paramADVideoItemHolder != null)
        {
          paramQQAppInterface = paramADVideoItemHolder.aJ;
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface = paramQQAppInterface.getLayoutParams();
            break label177;
          }
        }
        paramQQAppInterface = null;
        label177:
        if ((paramQQAppInterface instanceof LinearLayout.LayoutParams)) {
          ((LinearLayout.LayoutParams)paramQQAppInterface).leftMargin = AIOUtils.b(15.0F, paramContext.getResources());
        }
        if (paramADVideoItemHolder != null)
        {
          paramQQAppInterface = paramADVideoItemHolder.f;
          if (paramQQAppInterface != null) {
            paramQQAppInterface.setTextSize(14.0F);
          }
        }
      }
      paramQQAppInterface = (IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class);
      if (paramVideoInfo == null) {
        Intrinsics.throwNpe();
      }
      AdvertisementInfo localAdvertisementInfo = paramQQAppInterface.convertVideoAd2AdsInfo(paramVideoInfo.as, Integer.valueOf(5), Integer.valueOf(3));
      if (paramADVideoItemHolder != null) {
        paramQQAppInterface = paramADVideoItemHolder.U;
      } else {
        paramQQAppInterface = null;
      }
      if ((paramQQAppInterface != null) && (localAdvertisementInfo != null))
      {
        if (localAdvertisementInfo.mAdJumpMode == 3) {
          localAdvertisementInfo.mAdJumpMode = 0;
        }
        paramADVideoItemHolder.U.setAdvertisementInfo(localAdvertisementInfo);
        paramADVideoItemHolder.U.setDownloadScene(AdDownloadScene.VideoFloatButton);
        if ((paramContext instanceof Activity)) {
          paramADVideoItemHolder.U.setActivity(new SoftReference(paramContext));
        }
        a((View)paramADVideoItemHolder.U, paramADVideoItemHolder, paramOnClickListener);
        if (paramBoolean) {
          paramADVideoItemHolder.U.setProgressStyle((IDownloadStyle)HorizontalProgressStyle.VideoStyleTikTok);
        } else {
          paramADVideoItemHolder.U.setProgressStyle((IDownloadStyle)HorizontalProgressStyle.VideoStyleNormal);
        }
      }
      paramQQAppInterface = paramDrawable;
      if (paramADVideoItemHolder != null) {
        paramQQAppInterface = paramADVideoItemHolder.V;
      }
      if ((paramQQAppInterface != null) && (localAdvertisementInfo != null))
      {
        if (localAdvertisementInfo.mAdJumpMode == 3) {
          localAdvertisementInfo.mAdJumpMode = 0;
        }
        paramADVideoItemHolder.V.setAdvertisementInfo(localAdvertisementInfo);
        paramADVideoItemHolder.V.setDownloadScene(AdDownloadScene.VideoFloatCardButton);
        if ((paramContext instanceof Activity)) {
          paramADVideoItemHolder.V.setActivity(new SoftReference(paramContext));
        }
        a((View)paramADVideoItemHolder.V, paramADVideoItemHolder, paramOnClickListener);
        if (paramBoolean) {
          paramADVideoItemHolder.V.setProgressStyle((IDownloadStyle)HorizontalProgressStyle.VideoCardStyleTikTok);
        } else {
          paramADVideoItemHolder.V.setProgressStyle((IDownloadStyle)HorizontalProgressStyle.VideoCardStyleNormal);
        }
      }
      ReadInJoyAdUtils.a(paramVideoInfo, paramADVideoItemHolder);
      AdVideoButtonUIUtils.a(false, paramADVideoItemHolder);
    }
  }
  
  private final void f(QQAppInterface paramQQAppInterface, Context paramContext, Drawable paramDrawable, VideoInfo paramVideoInfo, ADVideoItemHolder paramADVideoItemHolder, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramADVideoItemHolder != null)
    {
      paramQQAppInterface = paramADVideoItemHolder.aK;
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(paramDrawable);
      }
    }
    if (paramADVideoItemHolder != null)
    {
      paramContext = paramADVideoItemHolder.aJ;
      if (paramContext != null)
      {
        if (paramVideoInfo != null)
        {
          paramQQAppInterface = paramVideoInfo.r;
          if (paramQQAppInterface != null) {}
        }
        else
        {
          paramQQAppInterface = "";
        }
        paramContext.setText((CharSequence)paramQQAppInterface);
      }
    }
    paramContext = null;
    if (paramADVideoItemHolder != null) {
      paramQQAppInterface = paramADVideoItemHolder.aJ;
    } else {
      paramQQAppInterface = null;
    }
    a((View)paramQQAppInterface, paramADVideoItemHolder, paramOnClickListener);
    if (paramVideoInfo != null) {
      paramQQAppInterface = paramVideoInfo.q;
    } else {
      paramQQAppInterface = null;
    }
    if (!TextUtils.isEmpty((CharSequence)paramQQAppInterface))
    {
      if (paramADVideoItemHolder != null)
      {
        paramQQAppInterface = paramADVideoItemHolder.aK;
        if (paramQQAppInterface != null)
        {
          if (paramVideoInfo != null)
          {
            paramDrawable = paramVideoInfo.q;
            if (paramDrawable != null)
            {
              l = Long.parseLong(paramDrawable);
              break label165;
            }
          }
          long l = 0L;
          label165:
          paramQQAppInterface.setHeadImgByUin(l, false);
        }
      }
    }
    else
    {
      if (paramVideoInfo != null) {
        paramQQAppInterface = paramVideoInfo.B;
      } else {
        paramQQAppInterface = null;
      }
      if ((!TextUtils.isEmpty((CharSequence)paramQQAppInterface)) && (paramADVideoItemHolder != null))
      {
        paramDrawable = paramADVideoItemHolder.aK;
        if (paramDrawable != null)
        {
          if (paramVideoInfo != null) {
            paramQQAppInterface = paramVideoInfo.B;
          } else {
            paramQQAppInterface = null;
          }
          paramDrawable.setImageSrc(paramQQAppInterface);
        }
      }
    }
    paramQQAppInterface = paramContext;
    if (paramADVideoItemHolder != null)
    {
      paramDrawable = paramADVideoItemHolder.aK;
      paramQQAppInterface = paramContext;
      if (paramDrawable != null) {
        paramQQAppInterface = paramDrawable.getView();
      }
    }
    a(paramQQAppInterface, paramADVideoItemHolder, paramOnClickListener);
  }
  
  public final void a(@Nullable Activity paramActivity, @Nullable VideoInfo paramVideoInfo, @Nullable ADVideoItemHolder paramADVideoItemHolder, @Nullable View.OnClickListener paramOnClickListener)
  {
    if ((paramActivity != null) && (paramVideoInfo != null))
    {
      if (paramADVideoItemHolder != null) {
        localObject1 = paramADVideoItemHolder.G;
      } else {
        localObject1 = null;
      }
      if (localObject1 == null) {
        return;
      }
      Object localObject1 = paramVideoInfo.as;
      if (localObject1 != null)
      {
        localObject1 = ((VideoAdInfo)localObject1).as;
        if (localObject1 != null)
        {
          paramADVideoItemHolder.G.removeAllViews();
          Object localObject2 = paramADVideoItemHolder.I;
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "videoHolder.dpaReducedTab");
          int i = ((TextView)localObject2).getWidth();
          localObject2 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList();
          localObject2 = ((Iterable)localObject2).iterator();
          Object localObject3;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            if ((TextUtils.isEmpty((CharSequence)localObject3) ^ true)) {
              ((Collection)localObject1).add(localObject3);
            }
          }
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            localObject3 = AdVideoDpaTagUtils.a((Context)paramActivity, paramVideoInfo, (String)localObject2);
            if (localObject3 != null) {
              ((TextView)localObject3).setOnClickListener(paramOnClickListener);
            }
            int j = ((com.tencent.mobileqq.kandian.base.utils.api.IRIJDisplayStyleManager)QRoute.api(com.tencent.mobileqq.kandian.base.utils.api.IRIJDisplayStyleManager.class)).getPhysicalDisplaySize(paramActivity)[0];
            int k = AIOUtils.b(125.0F, paramActivity.getResources());
            Intrinsics.checkExpressionValueIsNotNull(localObject3, "dpaTagTextView");
            int m = (int)((TextView)localObject3).getPaint().measureText((String)localObject2);
            if (i + m < j - k)
            {
              paramADVideoItemHolder.G.addView((View)localObject3);
              i += m + 6;
            }
          }
        }
      }
    }
  }
  
  public final void a(@NotNull Context paramContext, @Nullable VideoInfo paramVideoInfo, @Nullable ADVideoItemHolder paramADVideoItemHolder, @Nullable View.OnClickListener paramOnClickListener, boolean paramBoolean, @NotNull ClickableSpan paramClickableSpan)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramClickableSpan, "clickableSpan");
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (paramVideoInfo != null)
    {
      localObject = paramVideoInfo.g;
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localSpannableStringBuilder.append((CharSequence)RIJStringUtils.a((String)localObject, 72));
      localSpannableStringBuilder.append((CharSequence)"  ");
    }
    HardCodeUtil.a(2131913438);
    paramVideoInfo = a(paramVideoInfo);
    if (paramVideoInfo != null) {
      paramVideoInfo = paramVideoInfo.optString("AdsIconText");
    } else {
      paramVideoInfo = null;
    }
    if (TextUtils.isEmpty((CharSequence)paramVideoInfo))
    {
      ReadInJoyAdLog.a("AdVideoRefreshMenuUIUtils", "detail ad  video in new style adsIconText: null");
      return;
    }
    Object localObject = new Paint();
    ((Paint)localObject).setAntiAlias(true);
    ((Paint)localObject).setStyle(Paint.Style.FILL);
    ((Paint)localObject).setTextSize(AIOUtils.b(10.0F, paramContext.getResources()));
    ((Paint)localObject).setColor((int)3003121663L);
    float f1 = ((Paint)localObject).measureText(paramVideoInfo);
    if (paramBoolean) {
      i = 10;
    } else {
      i = 6;
    }
    float f2 = i;
    int i = AIOUtils.b(f2, paramContext.getResources()) + (int)f1;
    int j = AIOUtils.b(1.0F, paramContext.getResources()) / 2;
    int k = AIOUtils.b(14.0F, paramContext.getResources());
    Bitmap localBitmap = Bitmap.createBitmap(i, k, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawText(paramVideoInfo, AIOUtils.b(f2 / 2.0F, paramContext.getResources()), k / 2 - (((Paint)localObject).descent() + ((Paint)localObject).ascent()) / 2, (Paint)localObject);
    paramVideoInfo = new RectF(0.0F, j, i, k - j);
    ((Paint)localObject).setStyle(Paint.Style.STROKE);
    ((Paint)localObject).setStrokeWidth(0.5F);
    if (paramBoolean) {
      localCanvas.drawRoundRect(paramVideoInfo, 19.0F, 19.0F, (Paint)localObject);
    } else {
      localCanvas.drawRoundRect(paramVideoInfo, 2.0F, 2.0F, (Paint)localObject);
    }
    try
    {
      localSpannableStringBuilder.setSpan(new VerticalCenterImageSpan(paramContext, localBitmap), localSpannableStringBuilder.length() - 1, localSpannableStringBuilder.length(), 33);
      localSpannableStringBuilder.setSpan(paramClickableSpan, localSpannableStringBuilder.length() - 1, localSpannableStringBuilder.length(), 33);
      if (paramADVideoItemHolder != null)
      {
        paramVideoInfo = paramADVideoItemHolder.f;
        if (paramVideoInfo != null)
        {
          paramVideoInfo.setPadding(paramVideoInfo.getPaddingLeft(), paramVideoInfo.getPaddingTop(), paramVideoInfo.getPaddingRight(), AIOUtils.b(1.0F, paramContext.getResources()));
          paramVideoInfo.setMovementMethod(LinkMovementMethod.getInstance());
          paramVideoInfo.setText((CharSequence)localSpannableStringBuilder);
          a.a((View)paramVideoInfo, paramADVideoItemHolder, paramOnClickListener);
        }
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, @Nullable Drawable paramDrawable, @Nullable VideoInfo paramVideoInfo, @Nullable ADVideoItemHolder paramADVideoItemHolder, @Nullable View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (paramQQAppInterface == null) {
        return;
      }
      Integer localInteger;
      if (paramADVideoItemHolder != null) {
        localInteger = Integer.valueOf(paramADVideoItemHolder.X);
      } else {
        localInteger = null;
      }
      if ((localInteger != null) && (localInteger.intValue() == 4)) {
        b(paramQQAppInterface, paramContext, paramDrawable, paramVideoInfo, paramADVideoItemHolder, paramOnClickListener, paramBoolean);
      } else {
        c(paramQQAppInterface, paramContext, paramDrawable, paramVideoInfo, paramADVideoItemHolder, paramOnClickListener, paramBoolean);
      }
      e(paramQQAppInterface, paramContext, paramDrawable, paramVideoInfo, paramADVideoItemHolder, paramOnClickListener, paramBoolean);
    }
  }
  
  public final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable ImageView paramImageView, @Nullable VideoInfo paramVideoInfo, @Nullable ADVideoItemHolder paramADVideoItemHolder, int paramInt1, int paramInt2, @Nullable View.OnClickListener paramOnClickListener, @Nullable Drawable paramDrawable, boolean paramBoolean)
  {
    Context localContext;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    Object localObject2;
    float f;
    boolean bool;
    if ((paramQQAppInterface != null) && (paramImageView != null) && (paramVideoInfo != null) && (paramADVideoItemHolder != null))
    {
      if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.q))
      {
        paramImageView.setImageDrawable((Drawable)FaceDrawable.getFaceDrawable((AppInterface)paramQQAppInterface, 1, paramVideoInfo.q, 1, paramDrawable, paramDrawable));
        return;
      }
      localContext = paramImageView.getContext();
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localObject2 = null;
      if (localURLDrawableOptions != null)
      {
        f = paramInt1;
        Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
        localURLDrawableOptions.mRequestWidth = AIOUtils.b(f, localContext.getResources());
        localURLDrawableOptions.mRequestHeight = AIOUtils.b(f, localContext.getResources());
        localURLDrawableOptions.mLoadingDrawable = paramDrawable;
        localURLDrawableOptions.mFailedDrawable = paramDrawable;
      }
      else
      {
        localURLDrawableOptions = null;
      }
      bool = ReadInJoyAdUtils.a(paramVideoInfo);
      paramDrawable = (URL)null;
      paramQQAppInterface = paramDrawable;
    }
    try
    {
      if (TextUtils.isEmpty((CharSequence)paramVideoInfo.B))
      {
        paramQQAppInterface = paramDrawable;
        paramDrawable = new URL("https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
      }
      else
      {
        paramQQAppInterface = paramDrawable;
        paramDrawable = new URL(paramVideoInfo.B);
      }
      localObject1 = paramDrawable;
      if (bool)
      {
        paramQQAppInterface = paramDrawable;
        localObject1 = paramVideoInfo.as;
        paramVideoInfo = localObject2;
        if (localObject1 != null)
        {
          paramQQAppInterface = paramDrawable;
          paramVideoInfo = ((VideoAdInfo)localObject1).ao;
        }
        localObject1 = paramDrawable;
        paramQQAppInterface = paramDrawable;
        if (!TextUtils.isEmpty((CharSequence)paramVideoInfo))
        {
          paramQQAppInterface = paramDrawable;
          localObject1 = new URL(paramVideoInfo);
        }
      }
    }
    catch (Exception paramVideoInfo)
    {
      for (;;)
      {
        Object localObject1 = paramQQAppInterface;
      }
    }
    paramQQAppInterface = URLDrawable.getDrawable((URL)localObject1, localURLDrawableOptions);
    if (paramQQAppInterface != null)
    {
      f = paramInt1;
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      paramQQAppInterface.setTag(URLDrawableDecodeHandler.b(AIOUtils.b(f, localContext.getResources()), AIOUtils.b(f, localContext.getResources()), AIOUtils.b(paramInt2, localContext.getResources())));
    }
    if ((bool) && (!paramBoolean) && (paramADVideoItemHolder.L != null) && (paramADVideoItemHolder.L == paramImageView))
    {
      if (paramQQAppInterface != null) {
        paramQQAppInterface.setTag(new int[] { 0, 0, paramInt2, 3 });
      }
      if (paramQQAppInterface != null) {
        paramQQAppInterface.setDecodeHandler(URLDrawableDecodeHandler.k);
      }
    }
    else if (paramQQAppInterface != null)
    {
      paramQQAppInterface.setDecodeHandler(URLDrawableDecodeHandler.j);
    }
    if (paramQQAppInterface != null) {
      paramImageView.setImageDrawable((Drawable)paramQQAppInterface);
    }
    a((View)paramImageView, paramADVideoItemHolder, paramOnClickListener);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoRefreshMenuUIUtils
 * JD-Core Version:    0.7.0.1
 */