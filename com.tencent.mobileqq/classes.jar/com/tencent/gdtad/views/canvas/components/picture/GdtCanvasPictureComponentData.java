package com.tencent.gdtad.views.canvas.components.picture;

import android.text.TextUtils;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import com.tencent.gdtad.views.canvas.components.pictures.HotArea;
import java.util.ArrayList;

public class GdtCanvasPictureComponentData
  extends GdtCanvasComponentData
{
  public String actionUrl;
  public int floatingBarBackgroundColor;
  public int floatingBarTextColor;
  public String guassianUrl;
  public int height;
  public ArrayList<HotArea> hotAreaList;
  public String imageId;
  public String url;
  public int width;
  
  public boolean isHotAreaValild()
  {
    return (this.hotAreaList != null) && (this.hotAreaList.size() > 0);
  }
  
  public boolean isValid()
  {
    return (super.isValid()) && (this.width > 0) && (this.height > 0) && (!TextUtils.isEmpty(this.url));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentData
 * JD-Core Version:    0.7.0.1
 */