package com.tencent.biz.pubaccount.readinjoy.video;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ShortVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView.OnSetNickNameListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;

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
      localView = paramView.findViewById(2131361856);
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
      if ((paramViewHolder instanceof ADVideoItemHolder))
      {
        AccessibilityUtil.a(((ADVideoItemHolder)paramViewHolder).c);
        return;
      }
    } while (!(paramViewHolder instanceof VideoItemHolder));
    AccessibilityUtil.a(((VideoItemHolder)paramViewHolder).v);
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
    a(paramView, VideoFeedsHelper.b(paramInt, HardCodeUtil.a(2131716003)));
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
        localObject = VideoFeedsHelper.a(paramLong);
      } while (localObject == null);
      localObject = ((StringBuilder)localObject).toString();
    } while (TextUtils.isEmpty((CharSequence)localObject));
    a(paramView, HardCodeUtil.a(2131716001) + (String)localObject);
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
    for (String str = HardCodeUtil.a(2131716038);; str = HardCodeUtil.a(2131716040))
    {
      a(paramView, str);
      return;
    }
  }
  
  public static void a(ShortVideoItemHolder paramShortVideoItemHolder, View.OnClickListener paramOnClickListener)
  {
    if ((!AppSetting.d) || (paramShortVideoItemHolder == null) || (paramShortVideoItemHolder.a == null)) {
      return;
    }
    paramShortVideoItemHolder.a.setOnClickListener(paramOnClickListener);
    paramShortVideoItemHolder.a.setTag(paramShortVideoItemHolder);
  }
  
  public static void a(ReadInJoyNickNameTextView paramReadInJoyNickNameTextView, ReadInJoyNickNameTextView.OnSetNickNameListener paramOnSetNickNameListener)
  {
    if ((!AppSetting.d) || (paramReadInJoyNickNameTextView == null)) {
      return;
    }
    paramReadInJoyNickNameTextView.setOnSetNickNameListener(paramOnSetNickNameListener);
  }
  
  public static void b(View paramView, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!AppSetting.d)) {
      return;
    }
    a(paramView, HardCodeUtil.a(2131716020) + paramString);
  }
  
  public static void c(View paramView, String paramString)
  {
    if ((!AppSetting.d) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(paramView, paramString + HardCodeUtil.a(2131716016));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper
 * JD-Core Version:    0.7.0.1
 */