package com.tencent.biz.pubaccount.readinjoy.video;

import ajya;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import baww;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.common.config.AppSetting;
import qma;
import qmo;
import qmp;
import qoi;
import rej;

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
      localView = paramView.findViewById(2131361821);
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
      if ((paramViewHolder instanceof qma))
      {
        baww.a(((qma)paramViewHolder).c);
        return;
      }
    } while (!(paramViewHolder instanceof qmp));
    baww.a(((qmp)paramViewHolder).B);
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
    a(paramView, qoi.a(paramInt, ajya.a(2131716185)));
  }
  
  public static void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (!AppSetting.d) {
      return;
    }
    String str2 = qoi.a(paramInt, ajya.a(2131716158));
    String str1 = str2;
    if (paramBoolean) {
      str1 = str2 + ajya.a(2131716153);
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
        localObject = qoi.a(paramLong);
      } while (localObject == null);
      localObject = ((StringBuilder)localObject).toString();
    } while (TextUtils.isEmpty((CharSequence)localObject));
    a(paramView, ajya.a(2131716183) + (String)localObject);
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
    for (String str = ajya.a(2131716220);; str = ajya.a(2131716222))
    {
      a(paramView, str);
      return;
    }
  }
  
  public static void a(ReadInJoyNickNameTextView paramReadInJoyNickNameTextView, rej paramrej)
  {
    if ((!AppSetting.d) || (paramReadInJoyNickNameTextView == null)) {
      return;
    }
    paramReadInJoyNickNameTextView.setOnSetNickNameListener(paramrej);
  }
  
  public static void a(qmo paramqmo, View.OnClickListener paramOnClickListener)
  {
    if ((!AppSetting.d) || (paramqmo == null) || (paramqmo.b == null)) {
      return;
    }
    paramqmo.b.setOnClickListener(paramOnClickListener);
    paramqmo.b.setTag(paramqmo);
  }
  
  public static void b(View paramView, int paramInt)
  {
    if (!AppSetting.d) {
      return;
    }
    a(paramView, qoi.a(paramInt, ajya.a(2131716188)));
  }
  
  public static void b(View paramView, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!AppSetting.d)) {
      return;
    }
    a(paramView, ajya.a(2131716202) + paramString);
  }
  
  public static void c(View paramView, String paramString)
  {
    if ((!AppSetting.d) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(paramView, paramString + ajya.a(2131716198));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper
 * JD-Core Version:    0.7.0.1
 */