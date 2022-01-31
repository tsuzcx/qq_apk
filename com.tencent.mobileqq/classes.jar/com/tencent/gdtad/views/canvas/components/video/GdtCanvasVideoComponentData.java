package com.tencent.gdtad.views.canvas.components.video;

import android.text.TextUtils;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;

public class GdtCanvasVideoComponentData
  extends GdtCanvasComponentData
{
  public long duration;
  public boolean loop;
  public long size;
  public String thumbUrl;
  public String url;
  public String videoId;
  
  public boolean isValid()
  {
    return (super.isValid()) && (this.duration > 0L) && (!TextUtils.isEmpty(this.url));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.video.GdtCanvasVideoComponentData
 * JD-Core Version:    0.7.0.1
 */