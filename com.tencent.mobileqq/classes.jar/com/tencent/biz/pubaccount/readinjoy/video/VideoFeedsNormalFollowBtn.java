package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import anni;
import com.tencent.biz.pubaccount.VideoInfo;
import ruq;
import sby;

public class VideoFeedsNormalFollowBtn
  extends TextView
  implements ruq
{
  public VideoFeedsNormalFollowBtn(Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoFeedsNormalFollowBtn(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoFeedsNormalFollowBtn(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public long a()
  {
    return 3000L;
  }
  
  public View a()
  {
    return this;
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setText(anni.a(2131714877));
      setBackgroundDrawable(sby.a(getContext(), 2130843091));
      setCompoundDrawables(null, null, null, null);
      return;
    }
    setText(anni.a(2131714899));
    setBackgroundDrawable(sby.a(getContext(), 2130842932));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsNormalFollowBtn
 * JD-Core Version:    0.7.0.1
 */