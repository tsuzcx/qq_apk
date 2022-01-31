package com.tencent.biz.pubaccount.readinjoy.video;

import ajyc;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import bawi;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.common.config.AppSetting;
import qmd;
import qmr;
import qms;
import qol;
import rem;

public class VideoFeedsAccessibilityHelper
{
  public static View a(View paramView)
  {
    if ((!AppSetting.d) || (paramView == null)) {
      paramView = null;
    }
    View localView;
    do
    {
      return paramView;
      localView = paramView.findViewById(2131361822);
      paramView = localView;
    } while (localView == null);
    localView.setVisibility(0);
    return localView;
  }
  
  public static void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((!AppSetting.d) || (paramViewHolder == null)) {}
    do
    {
      return;
      if ((paramViewHolder instanceof qmd))
      {
        bawi.a(((qmd)paramViewHolder).c);
        return;
      }
    } while (!(paramViewHolder instanceof qms));
    bawi.a(((qms)paramViewHolder).B);
  }
  
  public static void a(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView == null) || (!AppSetting.d)) {
      return;
    }
    paramRecyclerView.setAccessibilityDelegateCompat(new VideoFeedsAccessibilityHelper.VideoFeedsRVAccessibilityDelegate(paramRecyclerView));
  }
  
  public static void a(View paramView, int paramInt)
  {
    if (!AppSetting.d) {
      return;
    }
    a(paramView, qol.a(paramInt, ajyc.a(2131716174)));
  }
  
  public static void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (!AppSetting.d) {
      return;
    }
    String str2 = qol.a(paramInt, ajyc.a(2131716147));
    String str1 = str2;
    if (paramBoolean) {
      str1 = str2 + ajyc.a(2131716142);
    }
    a(paramView, str1);
  }
  
  public static void a(View paramView, long paramLong)
  {
    if (!AppSetting.d) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = qol.a(paramLong);
      } while (localObject == null);
      localObject = ((StringBuilder)localObject).toString();
    } while (TextUtils.isEmpty((CharSequence)localObject));
    a(paramView, ajyc.a(2131716172) + (String)localObject);
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
    if (!AppSetting.d) {
      return;
    }
    if (paramBoolean) {}
    for (String str = ajyc.a(2131716209);; str = ajyc.a(2131716211))
    {
      a(paramView, str);
      return;
    }
  }
  
  public static void a(ReadInJoyNickNameTextView paramReadInJoyNickNameTextView, rem paramrem)
  {
    if ((!AppSetting.d) || (paramReadInJoyNickNameTextView == null)) {
      return;
    }
    paramReadInJoyNickNameTextView.setOnSetNickNameListener(paramrem);
  }
  
  public static void a(qmr paramqmr, View.OnClickListener paramOnClickListener)
  {
    if ((!AppSetting.d) || (paramqmr == null) || (paramqmr.b == null)) {
      return;
    }
    paramqmr.b.setOnClickListener(paramOnClickListener);
    paramqmr.b.setTag(paramqmr);
  }
  
  public static void b(View paramView, int paramInt)
  {
    if (!AppSetting.d) {
      return;
    }
    a(paramView, qol.a(paramInt, ajyc.a(2131716177)));
  }
  
  public static void b(View paramView, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!AppSetting.d)) {
      return;
    }
    a(paramView, ajyc.a(2131716191) + paramString);
  }
  
  public static void c(View paramView, String paramString)
  {
    if ((!AppSetting.d) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(paramView, paramString + ajyc.a(2131716187));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper
 * JD-Core Version:    0.7.0.1
 */