package com.tencent.ad.tangram.canvas.views.canvas.components.picture;

import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.canvas.views.canvas.components.pictures.c;
import java.util.ArrayList;

public class a
  extends AdCanvasComponentData
{
  public String actionUrl;
  public String borderColor = "#E3E3E3";
  public int borderWidth = 0;
  public boolean enableRoundRectBackground = false;
  public int floatingBarBackgroundColor;
  public int floatingBarTextColor;
  public String guassianUrl;
  public int height = 0;
  public ArrayList<c> hotAreaList;
  public String imageId;
  public int radius = 0;
  public String url;
  public int width = 0;
  
  public boolean isHotAreaValild()
  {
    return (this.hotAreaList != null) && (this.hotAreaList.size() > 0);
  }
  
  public boolean isValid()
  {
    return (super.isValid()) && (this.width > 0) && (this.height > 0) && (!TextUtils.isEmpty(this.url));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.picture.a
 * JD-Core Version:    0.7.0.1
 */