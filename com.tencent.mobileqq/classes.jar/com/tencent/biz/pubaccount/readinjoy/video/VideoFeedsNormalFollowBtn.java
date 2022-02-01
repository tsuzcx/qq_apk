package com.tencent.biz.pubaccount.readinjoy.video;

import amtj;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import rsm;
import rzv;

public class VideoFeedsNormalFollowBtn
  extends TextView
  implements rsm
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
      setText(amtj.a(2131715220));
      setBackgroundDrawable(rzv.a(getContext(), 2130843169));
      setCompoundDrawables(null, null, null, null);
      return;
    }
    setText(amtj.a(2131715242));
    setBackgroundDrawable(rzv.a(getContext(), 2130843006));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsNormalFollowBtn
 * JD-Core Version:    0.7.0.1
 */