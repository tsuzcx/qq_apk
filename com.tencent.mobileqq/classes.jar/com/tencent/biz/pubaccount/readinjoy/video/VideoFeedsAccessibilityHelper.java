package com.tencent.biz.pubaccount.readinjoy.video;

import amtj;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import bfpm;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.common.config.AppSetting;
import rvi;
import rvs;
import rvv;
import rwv;
import snl;

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
      if ((paramViewHolder instanceof rvi))
      {
        bfpm.a(((rvi)paramViewHolder).c);
        return;
      }
    } while (!(paramViewHolder instanceof rvv));
    bfpm.a(((rvv)paramViewHolder).z);
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
    a(paramView, rwv.a(paramInt, amtj.a(2131715189)));
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
        localObject = rwv.a(paramLong);
      } while (localObject == null);
      localObject = ((StringBuilder)localObject).toString();
    } while (TextUtils.isEmpty((CharSequence)localObject));
    a(paramView, amtj.a(2131715187) + (String)localObject);
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
    for (String str = amtj.a(2131715224);; str = amtj.a(2131715226))
    {
      a(paramView, str);
      return;
    }
  }
  
  public static void a(ReadInJoyNickNameTextView paramReadInJoyNickNameTextView, snl paramsnl)
  {
    if ((!AppSetting.c) || (paramReadInJoyNickNameTextView == null)) {
      return;
    }
    paramReadInJoyNickNameTextView.setOnSetNickNameListener(paramsnl);
  }
  
  public static void a(rvs paramrvs, View.OnClickListener paramOnClickListener)
  {
    if ((!AppSetting.c) || (paramrvs == null) || (paramrvs.b == null)) {
      return;
    }
    paramrvs.b.setOnClickListener(paramOnClickListener);
    paramrvs.b.setTag(paramrvs);
  }
  
  public static void b(View paramView, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!AppSetting.c)) {
      return;
    }
    a(paramView, amtj.a(2131715206) + paramString);
  }
  
  public static void c(View paramView, String paramString)
  {
    if ((!AppSetting.c) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(paramView, paramString + amtj.a(2131715202));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper
 * JD-Core Version:    0.7.0.1
 */