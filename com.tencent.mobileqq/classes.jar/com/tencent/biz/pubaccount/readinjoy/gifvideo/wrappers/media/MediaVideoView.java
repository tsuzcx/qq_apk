package com.tencent.biz.pubaccount.readinjoy.gifvideo.wrappers.media;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import pme;

public class MediaVideoView
  extends VideoView
  implements pme
{
  public MediaVideoView(Context paramContext)
  {
    super(paramContext);
    setScaleType(2);
  }
  
  public MediaVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MediaVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    startPlay();
  }
  
  public void b()
  {
    stop();
  }
  
  public void c()
  {
    pause();
  }
  
  public void d()
  {
    destroy();
  }
  
  public boolean isPlaying()
  {
    return getCurrentState() == 7;
  }
  
  public void setMediaCoverUrl(String paramString)
  {
    setCoverUrl(paramString);
  }
  
  public void setMediaPlayUrl(String paramString)
  {
    setVideoUrl(paramString);
  }
  
  public void setMediaPlayVid(String paramString)
  {
    setVideoVid(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.wrappers.media.MediaVideoView
 * JD-Core Version:    0.7.0.1
 */