package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.app.HardCodeUtil;

public class VideoFeedsNormalFollowBtn
  extends TextView
  implements IVideoFeedsFollowButton
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
      setText(HardCodeUtil.a(2131716034));
      setBackgroundDrawable(VideoFeedsResourceLoader.a(getContext(), 2130843358));
      setCompoundDrawables(null, null, null, null);
      return;
    }
    setText(HardCodeUtil.a(2131716056));
    setBackgroundDrawable(VideoFeedsResourceLoader.a(getContext(), 2130843196));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsNormalFollowBtn
 * JD-Core Version:    0.7.0.1
 */