package com.tencent.biz.pubaccount.readinjoy.video;

import alpo;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import qyu;
import rha;

public class VideoFeedsFollowTextView
  extends TextView
  implements qyu
{
  public VideoFeedsFollowTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoFeedsFollowTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoFeedsFollowTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
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
      if (paramVideoInfo.e()) {}
      for (paramVideoInfo = alpo.a(2131716601);; paramVideoInfo = alpo.a(2131716588))
      {
        setText(paramVideoInfo);
        setBackgroundDrawable(rha.a(getContext(), 2130842736));
        setCompoundDrawables(null, null, null, null);
        return;
      }
    }
    if (paramVideoInfo.e()) {}
    for (paramVideoInfo = alpo.a(2131716623);; paramVideoInfo = alpo.a(2131716610))
    {
      setText(paramVideoInfo);
      setBackgroundDrawable(rha.a(getContext(), 2130842590));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFollowTextView
 * JD-Core Version:    0.7.0.1
 */