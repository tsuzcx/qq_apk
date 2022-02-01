package com.tencent.hippy.qq.adapter;

import android.text.TextUtils;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader.Callback;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.utils.PixelUtil;

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
    if (paramHippyMap.containsKey("style"))
    {
      localObject = paramHippyMap.getMap("style");
      if (localObject != null)
      {
        this.reqWidth = Math.round(PixelUtil.dp2px(((HippyMap)localObject).getDouble("width")));
        this.reqHeight = Math.round(PixelUtil.dp2px(((HippyMap)localObject).getDouble("height")));
        this.resizeMode = ((HippyMap)localObject).getString("resizeMode");
      }
    }
    this.type = paramHippyMap.getString("imageType");
    this.repeatCount = paramHippyMap.getInt("repeatCount");
    this.isGif = paramHippyMap.getBoolean("isGif");
    this.type = paramHippyMap.getString("imageType");
    Object localObject = this.type;
    boolean bool;
    if ((localObject != null) && (((String)localObject).equals("apng"))) {
      bool = true;
    } else {
      bool = false;
    }
    this.isApng = bool;
    this.isGif = paramHippyMap.getBoolean("isGif");
    if (TextUtils.isEmpty(this.resizeMode)) {
      this.resizeMode = paramHippyMap.getString("resizeMode");
    }
    if (this.repeatCount < 0) {
      this.repeatCount = 0;
    }
    if (this.type == null) {
      this.type = "";
    }
    if (this.resizeMode == null) {
      this.resizeMode = "";
    }
  }
  
  private void setUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = paramString;
    if (paramString.startsWith("//"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https:");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    if (!((String)localObject).startsWith("http")) {
      return;
    }
    this.url = ((String)localObject);
  }
  
  public void onRequestFail(Throwable paramThrowable, String paramString)
  {
    HippyImageLoader.Callback localCallback = this.callback;
    if (localCallback != null) {
      localCallback.onRequestFail(paramThrowable, paramString);
    }
  }
  
  public void onRequestSuccess(HippyDrawable paramHippyDrawable)
  {
    HippyImageLoader.Callback localCallback = this.callback;
    if (localCallback != null) {
      localCallback.onRequestSuccess(paramHippyDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQImageLoader.HippyImageInfo
 * JD-Core Version:    0.7.0.1
 */