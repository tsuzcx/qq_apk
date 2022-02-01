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
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class AdVideoDpaTagUtils
{
  public static TextView a(Context paramContext, VideoInfo paramVideoInfo, String paramString)
  {
    if ((paramVideoInfo == null) || (paramVideoInfo.a == null)) {
      return null;
    }
    int i = AdVideoButtonUIUtils.a(paramVideoInfo.a);
    paramVideoInfo = new LinearLayout.LayoutParams(-2, -2);
    paramVideoInfo.rightMargin = AIOUtils.a(6.0F, paramContext.getResources());
    paramContext = new TextView(paramContext);
    paramContext.setIncludeFontPadding(false);
    if (i == 3)
    {
      paramContext.setBackgroundResource(2130849715);
      paramContext.setTextColor(Color.parseColor("#757575"));
      paramContext.setTextSize(11.0F);
    }
    for (;;)
    {
      paramContext.setMaxLines(1);
      paramContext.setEllipsize(TextUtils.TruncateAt.END);
      paramContext.setGravity(17);
      paramContext.setText(paramString);
      paramContext.setLayoutParams(paramVideoInfo);
      return paramContext;
      paramContext.setBackgroundResource(2130849713);
      paramContext.setTextSize(10.0F);
      paramContext.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  public static void a(ADVideoItemHolder paramADVideoItemHolder)
  {
    if ((paramADVideoItemHolder == null) || (paramADVideoItemHolder.c == null)) {}
    Context localContext;
    do
    {
      boolean bool1;
      do
      {
        return;
        boolean bool2 = false;
        bool1 = bool2;
        if (paramADVideoItemHolder.a != null)
        {
          bool1 = bool2;
          if (paramADVideoItemHolder.a.a != null) {
            bool1 = ReadInJoyAdUtils.a(paramADVideoItemHolder.a.a);
          }
        }
      } while (!bool1);
      localContext = paramADVideoItemHolder.c.getContext();
    } while (localContext == null);
    Object localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.c.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.a(245.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.a(48.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(65.0F, localContext.getResources());
    paramADVideoItemHolder.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#7F4D4D4D"));
    ((GradientDrawable)localObject).setCornerRadius(AIOUtils.a(6.0F, localContext.getResources()));
    paramADVideoItemHolder.c.setBackgroundDrawable((Drawable)localObject);
    localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.d.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.a(40.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.a(40.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(4.0F, localContext.getResources());
    paramADVideoItemHolder.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramADVideoItemHolder.l.setTextSize(14.0F);
    localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.l.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(10.0F, localContext.getResources());
    paramADVideoItemHolder.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.m.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(25.0F, localContext.getResources());
    paramADVideoItemHolder.m.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(10.0F, localContext.getResources());
    paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramADVideoItemHolder.m.setTextSize(14.0F);
    paramADVideoItemHolder.m.setTypeface(Typeface.DEFAULT);
    paramADVideoItemHolder.i.setTypeface(Typeface.DEFAULT);
    paramADVideoItemHolder.k.setTypeface(Typeface.DEFAULT);
    paramADVideoItemHolder.j.setTextColor(Color.parseColor("#FFFFFF"));
    paramADVideoItemHolder.j.setTextSize(11.0F);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#FF6522"));
    ((GradientDrawable)localObject).setCornerRadius(AIOUtils.a(3.0F, localContext.getResources()));
    paramADVideoItemHolder.j.setBackgroundDrawable((Drawable)localObject);
    localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(50.0F, localContext.getResources());
    paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public static void b(ADVideoItemHolder paramADVideoItemHolder)
  {
    if ((paramADVideoItemHolder == null) || (paramADVideoItemHolder.c == null)) {}
    Context localContext;
    do
    {
      boolean bool1;
      do
      {
        return;
        boolean bool2 = false;
        bool1 = bool2;
        if (paramADVideoItemHolder.a != null)
        {
          bool1 = bool2;
          if (paramADVideoItemHolder.a.a != null) {
            bool1 = ReadInJoyAdUtils.a(paramADVideoItemHolder.a.a);
          }
        }
      } while (!bool1);
      localContext = paramADVideoItemHolder.c.getContext();
    } while (localContext == null);
    Object localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.c.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.a(31.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(10.0F, localContext.getResources());
    paramADVideoItemHolder.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#33FFFFFF"));
    ((GradientDrawable)localObject).setCornerRadius(AIOUtils.a(6.0F, localContext.getResources()));
    paramADVideoItemHolder.c.setBackgroundDrawable((Drawable)localObject);
    localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.d.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.a(31.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.a(31.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(0.0F, localContext.getResources());
    paramADVideoItemHolder.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramADVideoItemHolder.l.setTextSize(16.0F);
    paramADVideoItemHolder.m.setTextSize(14.0F);
    paramADVideoItemHolder.m.setTypeface(Typeface.DEFAULT);
    paramADVideoItemHolder.i.setTypeface(Typeface.DEFAULT_BOLD);
    localObject = (RelativeLayout.LayoutParams)paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(0.0F, localContext.getResources());
    paramADVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoDpaTagUtils
 * JD-Core Version:    0.7.0.1
 */