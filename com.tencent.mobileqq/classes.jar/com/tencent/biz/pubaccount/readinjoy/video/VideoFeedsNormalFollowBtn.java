package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import anzj;
import com.tencent.biz.pubaccount.VideoInfo;
import rlm;
import rsr;

public class VideoFeedsNormalFollowBtn
  extends TextView
  implements rlm
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
      setText(anzj.a(2131714986));
      setBackgroundDrawable(rsr.a(getContext(), 2130843111));
      setCompoundDrawables(null, null, null, null);
      return;
    }
    setText(anzj.a(2131715008));
    setBackgroundDrawable(rsr.a(getContext(), 2130842952));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsNormalFollowBtn
 * JD-Core Version:    0.7.0.1
 */