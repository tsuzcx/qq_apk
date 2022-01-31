package com.tencent.biz.pubaccount.readinjoy.video;

import ajya;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import qjn;
import qro;

public class VideoFeedsFollowTextView
  extends TextView
  implements qjn
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
      for (paramVideoInfo = ajya.a(2131716229);; paramVideoInfo = ajya.a(2131716216))
      {
        setText(paramVideoInfo);
        setBackgroundDrawable(qro.a(getContext(), 2130842557));
        setCompoundDrawables(null, null, null, null);
        return;
      }
    }
    if (paramVideoInfo.e()) {}
    for (paramVideoInfo = ajya.a(2131716251);; paramVideoInfo = ajya.a(2131716238))
    {
      setText(paramVideoInfo);
      setBackgroundDrawable(qro.a(getContext(), 2130842419));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFollowTextView
 * JD-Core Version:    0.7.0.1
 */