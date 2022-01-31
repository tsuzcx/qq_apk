package com.tencent.biz.pubaccount.readinjoy.video;

import ajjy;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import azve;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.common.config.AppSetting;
import qab;
import qap;
import qaq;
import qcn;
import qsa;

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
      localView = paramView.findViewById(2131296286);
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
      if ((paramViewHolder instanceof qab))
      {
        azve.a(((qab)paramViewHolder).c);
        return;
      }
    } while (!(paramViewHolder instanceof qaq));
    azve.a(((qaq)paramViewHolder).w);
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
    a(paramView, qcn.a(paramInt, ajjy.a(2131650383)));
  }
  
  public static void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (!AppSetting.c) {
      return;
    }
    String str2 = qcn.a(paramInt, ajjy.a(2131650356));
    String str1 = str2;
    if (paramBoolean) {
      str1 = str2 + ajjy.a(2131650351);
    }
    a(paramView, str1);
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
        localObject = qcn.a(paramLong);
      } while (localObject == null);
      localObject = ((StringBuilder)localObject).toString();
    } while (TextUtils.isEmpty((CharSequence)localObject));
    a(paramView, ajjy.a(2131650381) + (String)localObject);
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
    for (String str = ajjy.a(2131650418);; str = ajjy.a(2131650420))
    {
      a(paramView, str);
      return;
    }
  }
  
  public static void a(ReadInJoyNickNameTextView paramReadInJoyNickNameTextView, qsa paramqsa)
  {
    if ((!AppSetting.c) || (paramReadInJoyNickNameTextView == null)) {
      return;
    }
    paramReadInJoyNickNameTextView.setOnSetNickNameListener(paramqsa);
  }
  
  public static void a(qap paramqap, View.OnClickListener paramOnClickListener)
  {
    if ((!AppSetting.c) || (paramqap == null) || (paramqap.a == null)) {
      return;
    }
    paramqap.a.setOnClickListener(paramOnClickListener);
    paramqap.a.setTag(paramqap);
  }
  
  public static void b(View paramView, int paramInt)
  {
    if (!AppSetting.c) {
      return;
    }
    a(paramView, qcn.a(paramInt, ajjy.a(2131650386)));
  }
  
  public static void b(View paramView, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!AppSetting.c)) {
      return;
    }
    a(paramView, ajjy.a(2131650400) + paramString);
  }
  
  public static void c(View paramView, String paramString)
  {
    if ((!AppSetting.c) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(paramView, paramString + ajjy.a(2131650396));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper
 * JD-Core Version:    0.7.0.1
 */