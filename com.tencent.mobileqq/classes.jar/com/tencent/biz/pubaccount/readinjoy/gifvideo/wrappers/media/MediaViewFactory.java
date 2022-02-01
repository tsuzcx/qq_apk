package com.tencent.biz.pubaccount.readinjoy.gifvideo.wrappers.media;

import android.content.Context;

public class MediaViewFactory
{
  public static IMediaView a(int paramInt, Context paramContext)
  {
    switch (paramInt)
    {
    default: 
      return new MediaGifView(paramContext);
    case 0: 
      return new MediaGifView(paramContext);
    }
    return new MediaVideoView(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.wrappers.media.MediaViewFactory
 * JD-Core Version:    0.7.0.1
 */