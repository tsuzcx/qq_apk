package com.tencent.biz.pubaccount.readinjoy.video;

import alud;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import bczz;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.common.config.AppSetting;
import rbi;
import rbs;
import rbt;
import rdm;
import ruf;

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
      localView = paramView.findViewById(2131361821);
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
      if ((paramViewHolder instanceof rbi))
      {
        bczz.a(((rbi)paramViewHolder).c);
        return;
      }
    } while (!(paramViewHolder instanceof rbt));
    bczz.a(((rbt)paramViewHolder).B);
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
    a(paramView, rdm.a(paramInt, alud.a(2131716569)));
  }
  
  public static void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (!AppSetting.c) {
      return;
    }
    String str2 = rdm.a(paramInt, alud.a(2131716542));
    String str1 = str2;
    if (paramBoolean) {
      str1 = str2 + alud.a(2131716537);
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
        localObject = rdm.a(paramLong);
      } while (localObject == null);
      localObject = ((StringBuilder)localObject).toString();
    } while (TextUtils.isEmpty((CharSequence)localObject));
    a(paramView, alud.a(2131716567) + (String)localObject);
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
    for (String str = alud.a(2131716604);; str = alud.a(2131716606))
    {
      a(paramView, str);
      return;
    }
  }
  
  public static void a(ReadInJoyNickNameTextView paramReadInJoyNickNameTextView, ruf paramruf)
  {
    if ((!AppSetting.c) || (paramReadInJoyNickNameTextView == null)) {
      return;
    }
    paramReadInJoyNickNameTextView.setOnSetNickNameListener(paramruf);
  }
  
  public static void a(rbs paramrbs, View.OnClickListener paramOnClickListener)
  {
    if ((!AppSetting.c) || (paramrbs == null) || (paramrbs.b == null)) {
      return;
    }
    paramrbs.b.setOnClickListener(paramOnClickListener);
    paramrbs.b.setTag(paramrbs);
  }
  
  public static void b(View paramView, int paramInt)
  {
    if (!AppSetting.c) {
      return;
    }
    a(paramView, rdm.a(paramInt, alud.a(2131716572)));
  }
  
  public static void b(View paramView, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!AppSetting.c)) {
      return;
    }
    a(paramView, alud.a(2131716586) + paramString);
  }
  
  public static void c(View paramView, String paramString)
  {
    if ((!AppSetting.c) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(paramView, paramString + alud.a(2131716582));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper
 * JD-Core Version:    0.7.0.1
 */