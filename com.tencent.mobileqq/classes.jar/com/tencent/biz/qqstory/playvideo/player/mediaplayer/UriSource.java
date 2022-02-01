package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.content.Context;
import android.net.Uri;
import java.util.Map;

public class UriSource
  implements MediaSource
{
  private Context a;
  private Uri b;
  private Uri c;
  private Map<String, String> d;
  private Map<String, String> e;
  
  public UriSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    this.a = paramContext;
    this.b = paramUri;
    this.d = paramMap;
  }
  
  public MediaExtractor a()
  {
    MediaExtractor localMediaExtractor = new MediaExtractor();
    localMediaExtractor.a(this.a, this.b, this.d);
    return localMediaExtractor;
  }
  
  public MediaExtractor b()
  {
    if (this.c != null)
    {
      MediaExtractor localMediaExtractor = new MediaExtractor();
      localMediaExtractor.a(this.a, this.c, this.e);
      return localMediaExtractor;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.UriSource
 * JD-Core Version:    0.7.0.1
 */