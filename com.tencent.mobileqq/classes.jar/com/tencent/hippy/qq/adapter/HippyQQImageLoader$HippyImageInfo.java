package com.tencent.hippy.qq.adapter;

import android.text.TextUtils;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader.Callback;
import com.tencent.mtt.hippy.common.HippyMap;

public class HippyQQImageLoader$HippyImageInfo
{
  public static final String RESZIE_MODE_COVER = "cover";
  private HippyImageLoader.Callback callback;
  public boolean isApng;
  public boolean isGif;
  public int repeatCount;
  public int reqHeight;
  public int reqWidth;
  public String resizeMode = "";
  private String type = "";
  public String url;
  
  protected HippyQQImageLoader$HippyImageInfo(String paramString, HippyMap paramHippyMap, HippyImageLoader.Callback paramCallback)
  {
    setUrl(paramString);
    setProperties(paramHippyMap);
    this.callback = paramCallback;
  }
  
  private void setProperties(HippyMap paramHippyMap)
  {
    if (paramHippyMap == null) {
      return;
    }
    this.reqWidth = paramHippyMap.getInt("width");
    this.reqHeight = paramHippyMap.getInt("height");
    this.type = paramHippyMap.getString("imageType");
    if ((this.type != null) && (this.type.equals("apng"))) {}
    for (boolean bool = true;; bool = false)
    {
      this.isApng = bool;
      this.isGif = paramHippyMap.getBoolean("isGif");
      this.resizeMode = paramHippyMap.getString("resizeMode");
      this.repeatCount = paramHippyMap.getInt("repeatCount");
      if (this.repeatCount < 0) {
        this.repeatCount = 0;
      }
      if (this.type == null) {
        this.type = "";
      }
      if (this.resizeMode != null) {
        break;
      }
      this.resizeMode = "";
      return;
    }
  }
  
  private void setUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      return;
      str = paramString;
      if (paramString.startsWith("//")) {
        str = "https:" + paramString;
      }
    } while (!str.startsWith("http"));
    this.url = str;
  }
  
  public void onRequestFail(Throwable paramThrowable, String paramString)
  {
    if (this.callback != null) {
      this.callback.onRequestFail(paramThrowable, paramString);
    }
  }
  
  public void onRequestSuccess(HippyDrawable paramHippyDrawable)
  {
    if (this.callback != null) {
      this.callback.onRequestSuccess(paramHippyDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQImageLoader.HippyImageInfo
 * JD-Core Version:    0.7.0.1
 */