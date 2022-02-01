package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils.TruncateAt;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;

public class AdVideoDpaTagUtils
{
  public static TextView a(Context paramContext, VideoInfo paramVideoInfo, String paramString)
  {
    if ((paramVideoInfo != null) && (paramVideoInfo.as != null))
    {
      int i = AdVideoButtonUIUtils.a(paramVideoInfo.as);
      paramVideoInfo = new LinearLayout.LayoutParams(-2, -2);
      paramVideoInfo.rightMargin = AIOUtils.b(6.0F, paramContext.getResources());
      paramContext = new TextView(paramContext);
      paramContext.setIncludeFontPadding(false);
      if (i == 3)
      {
        paramContext.setBackgroundResource(2130851317);
        paramContext.setTextColor(Color.parseColor("#757575"));
        paramContext.setTextSize(11.0F);
      }
      else
      {
        paramContext.setBackgroundResource(2130851315);
        paramContext.setTextSize(10.0F);
        paramContext.setTextColor(Color.parseColor("#737373"));
      }
      paramContext.setMaxLines(1);
      paramContext.setEllipsize(TextUtils.TruncateAt.END);
      paramContext.setGravity(17);
      paramContext.setText(paramString);
      paramContext.setLayoutParams(paramVideoInfo);
      return paramContext;
    }
    return null;
  }
  
  public static void a(ADVideoItemHolder paramADVideoItemHolder)
  {
    if (paramADVideoItemHolder != null)
    {
      if (paramADVideoItemHolder.K == null) {
        return;
      }
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramADVideoItemHolder.az != null)
      {
        bool1 = bool2;
        if (paramADVideoItemHolder.az.c != null) {
          bool1 = ReadInJoyAdUtils.a(paramADVideoItemHolder.az.c);
        }
      }
      if (!bool1) {
        return;
      }
      Context localContext = paramADVideoItemHolder.K.getContext();
      if (localContext == null) {
        return;
      }
      Object localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.K.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.b(245.0F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.b(48.0F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(65.0F, localContext.getResources());
      paramADVideoItemHolder.K.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setColor(Color.parseColor("#7F4D4D4D"));
      ((GradientDrawable)localObject).setCornerRadius(AIOUtils.b(6.0F, localContext.getResources()));
      paramADVideoItemHolder.K.setBackgroundDrawable((Drawable)localObject);
      localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.L.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.b(40.0F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.b(40.0F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(4.0F, localContext.getResources());
      paramADVideoItemHolder.L.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramADVideoItemHolder.M.setTextSize(14.0F);
      localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.M.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(10.0F, localContext.getResources());
      paramADVideoItemHolder.M.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.N.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(25.0F, localContext.getResources());
      paramADVideoItemHolder.N.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.F.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(10.0F, localContext.getResources());
      paramADVideoItemHolder.F.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramADVideoItemHolder.N.setTextSize(14.0F);
      paramADVideoItemHolder.N.setTypeface(Typeface.DEFAULT);
      paramADVideoItemHolder.H.setTypeface(Typeface.DEFAULT);
      paramADVideoItemHolder.J.setTypeface(Typeface.DEFAULT);
      paramADVideoItemHolder.I.setTextColor(Color.parseColor("#FFFFFF"));
      paramADVideoItemHolder.I.setTextSize(11.0F);
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setColor(Color.parseColor("#FF6522"));
      ((GradientDrawable)localObject).setCornerRadius(AIOUtils.b(3.0F, localContext.getResources()));
      paramADVideoItemHolder.I.setBackgroundDrawable((Drawable)localObject);
      localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.aj.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(50.0F, localContext.getResources());
      paramADVideoItemHolder.aj.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public static void b(ADVideoItemHolder paramADVideoItemHolder)
  {
    if (paramADVideoItemHolder != null)
    {
      if (paramADVideoItemHolder.K == null) {
        return;
      }
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramADVideoItemHolder.az != null)
      {
        bool1 = bool2;
        if (paramADVideoItemHolder.az.c != null) {
          bool1 = ReadInJoyAdUtils.a(paramADVideoItemHolder.az.c);
        }
      }
      if (!bool1) {
        return;
      }
      Context localContext = paramADVideoItemHolder.K.getContext();
      if (localContext == null) {
        return;
      }
      Object localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.K.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.b(31.0F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(10.0F, localContext.getResources());
      paramADVideoItemHolder.K.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setColor(Color.parseColor("#33FFFFFF"));
      ((GradientDrawable)localObject).setCornerRadius(AIOUtils.b(6.0F, localContext.getResources()));
      paramADVideoItemHolder.K.setBackgroundDrawable((Drawable)localObject);
      localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.L.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.b(31.0F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.b(31.0F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(0.0F, localContext.getResources());
      paramADVideoItemHolder.L.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramADVideoItemHolder.M.setTextSize(16.0F);
      paramADVideoItemHolder.N.setTextSize(14.0F);
      paramADVideoItemHolder.N.setTypeface(Typeface.DEFAULT);
      paramADVideoItemHolder.H.setTypeface(Typeface.DEFAULT_BOLD);
      localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.aj.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(0.0F, localContext.getResources());
      paramADVideoItemHolder.aj.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoDpaTagUtils
 * JD-Core Version:    0.7.0.1
 */