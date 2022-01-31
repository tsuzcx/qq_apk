package com.tencent.gdtad.views.canvas.components.video;

import android.text.TextUtils;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;

public class GdtCanvasVideoComponentData
  extends GdtCanvasComponentData
{
  public long duration;
  public int height;
  private boolean loop = true;
  public long size;
  public String thumbUrl;
  public String url;
  public String videoId;
  public int width;
  
  public boolean isLoop()
  {
    return this.loop;
  }
  
  public boolean isValid()
  {
    return (super.isValid()) && (this.width > 0) && (this.height > 0) && (this.duration > 0L) && (!TextUtils.isEmpty(this.url));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.video.GdtCanvasVideoComponentData
 * JD-Core Version:    0.7.0.1
 */