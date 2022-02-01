package com.tencent.biz.pubaccount.readinjoy.video;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import anzj;
import bhga;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.common.config.AppSetting;
import rog;
import roq;
import rot;
import rpt;
import sjf;

public class VideoFeedsAccessibilityHelper
{
  public static View a(View paramView)
  {
    if ((!AppSetting.c) || (paramView == null)) {
      paramView = null;
    }
    View localView;
    do
    {
      return paramView;
      localView = paramView.findViewById(2131361855);
      paramView = localView;
    } while (localView == null);
    localView.setVisibility(0);
    return localView;
  }
  
  public static void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((!AppSetting.c) || (paramViewHolder == null)) {}
    do
    {
      return;
      if ((paramViewHolder instanceof rog))
      {
        bhga.a(((rog)paramViewHolder).c);
        return;
      }
    } while (!(paramViewHolder instanceof rot));
    bhga.a(((rot)paramViewHolder).z);
  }
  
  public static void a(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView == null) || (!AppSetting.c)) {
      return;
    }
    paramRecyclerView.setAccessibilityDelegateCompat(new VideoFeedsAccessibilityHelper.VideoFeedsRVAccessibilityDelegate(paramRecyclerView));
  }
  
  public static void a(View paramView, int paramInt)
  {
    if (!AppSetting.c) {
      return;
    }
    a(paramView, rpt.a(paramInt, anzj.a(2131714955)));
  }
  
  public static void a(View paramView, long paramLong)
  {
    if (!AppSetting.c) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = rpt.a(paramLong);
      } while (localObject == null);
      localObject = ((StringBuilder)localObject).toString();
    } while (TextUtils.isEmpty((CharSequence)localObject));
    a(paramView, anzj.a(2131714953) + (String)localObject);
  }
  
  public static void a(View paramView, String paramString)
  {
    if (paramView == null) {
      return;
    }
    paramView.setContentDescription(paramString);
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    if (!AppSetting.c) {
      return;
    }
    if (paramBoolean) {}
    for (String str = anzj.a(2131714990);; str = anzj.a(2131714992))
    {
      a(paramView, str);
      return;
    }
  }
  
  public static void a(ReadInJoyNickNameTextView paramReadInJoyNickNameTextView, sjf paramsjf)
  {
    if ((!AppSetting.c) || (paramReadInJoyNickNameTextView == null)) {
      return;
    }
    paramReadInJoyNickNameTextView.setOnSetNickNameListener(paramsjf);
  }
  
  public static void a(roq paramroq, View.OnClickListener paramOnClickListener)
  {
    if ((!AppSetting.c) || (paramroq == null) || (paramroq.b == null)) {
      return;
    }
    paramroq.b.setOnClickListener(paramOnClickListener);
    paramroq.b.setTag(paramroq);
  }
  
  public static void b(View paramView, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!AppSetting.c)) {
      return;
    }
    a(paramView, anzj.a(2131714972) + paramString);
  }
  
  public static void c(View paramView, String paramString)
  {
    if ((!AppSetting.c) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(paramView, paramString + anzj.a(2131714968));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper
 * JD-Core Version:    0.7.0.1
 */