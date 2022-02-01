package com.tencent.biz.pubaccount.readinjoy.gifvideo.wrappers.media;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.gif.GifView;
import pme;

public class MediaGifView
  extends GifView
  implements pme
{
  public MediaGifView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MediaGifView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MediaGifView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    displayGif();
  }
  
  public void b()
  {
    displayCover();
  }
  
  public void c() {}
  
  public void d() {}
  
  public boolean isPlaying()
  {
    return false;
  }
  
  public void setMediaCoverUrl(String paramString)
  {
    setCoverUrl(paramString);
  }
  
  public void setMediaPlayUrl(String paramString)
  {
    setNeedGifUrl(false);
    setGifUrl(paramString);
  }
  
  public void setMediaPlayVid(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.wrappers.media.MediaGifView
 * JD-Core Version:    0.7.0.1
 */