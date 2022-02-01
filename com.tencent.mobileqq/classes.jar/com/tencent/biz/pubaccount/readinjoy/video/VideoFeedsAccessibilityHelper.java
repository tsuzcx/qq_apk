package com.tencent.biz.pubaccount.readinjoy.video;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import anvx;
import bgyd;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.common.config.AppSetting;
import six;
import swi;
import swr;
import swu;
import taw;

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
      localView = paramView.findViewById(2131361857);
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
      if ((paramViewHolder instanceof swi))
      {
        bgyd.a(((swi)paramViewHolder).c);
        return;
      }
    } while (!(paramViewHolder instanceof swu));
    bgyd.a(((swu)paramViewHolder).v);
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
    a(paramView, six.b(paramInt, anvx.a(2131715537)));
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
        localObject = six.a(paramLong);
      } while (localObject == null);
      localObject = ((StringBuilder)localObject).toString();
    } while (TextUtils.isEmpty((CharSequence)localObject));
    a(paramView, anvx.a(2131715535) + (String)localObject);
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
    for (String str = anvx.a(2131715572);; str = anvx.a(2131715574))
    {
      a(paramView, str);
      return;
    }
  }
  
  public static void a(ReadInJoyNickNameTextView paramReadInJoyNickNameTextView, taw paramtaw)
  {
    if ((!AppSetting.c) || (paramReadInJoyNickNameTextView == null)) {
      return;
    }
    paramReadInJoyNickNameTextView.setOnSetNickNameListener(paramtaw);
  }
  
  public static void a(swr paramswr, View.OnClickListener paramOnClickListener)
  {
    if ((!AppSetting.c) || (paramswr == null) || (paramswr.a == null)) {
      return;
    }
    paramswr.a.setOnClickListener(paramOnClickListener);
    paramswr.a.setTag(paramswr);
  }
  
  public static void b(View paramView, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!AppSetting.c)) {
      return;
    }
    a(paramView, anvx.a(2131715554) + paramString);
  }
  
  public static void c(View paramView, String paramString)
  {
    if ((!AppSetting.c) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(paramView, paramString + anvx.a(2131715550));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper
 * JD-Core Version:    0.7.0.1
 */