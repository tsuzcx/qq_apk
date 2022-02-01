package com.tencent.gdtad.views.videoimax;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.mobileqq.pb.PBStringField;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class GdtImaxData
  implements Serializable
{
  private GdtAd ad;
  private String[] danmakuContents;
  private Boolean isDanmakuAdv;
  private GdtVideoData videoData;
  private int videoSplicePageStyle;
  private String webUrl;
  
  public GdtAd getAd()
  {
    return this.ad;
  }
  
  public String[] getDanmakuContents()
  {
    return this.danmakuContents;
  }
  
  public GdtVideoData getVideoData()
  {
    return this.videoData;
  }
  
  public int getVideoSplicePageStyle()
  {
    return this.videoSplicePageStyle;
  }
  
  public String getWebUrl()
  {
    return this.webUrl;
  }
  
  public boolean isDanmakuAdv()
  {
    Object localObject = this.isDanmakuAdv;
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    int i = 0;
    this.isDanmakuAdv = Boolean.valueOf(false);
    localObject = this.ad;
    if ((localObject != null) && (((GdtAd)localObject).isValid())) {}
    try
    {
      localObject = new JSONObject(this.ad.info.ext_json.get());
      if (((JSONObject)localObject).has("bullet_screen"))
      {
        localObject = ((JSONObject)localObject).getJSONArray("bullet_screen");
        if (((JSONArray)localObject).length() != 0)
        {
          this.danmakuContents = new String[((JSONArray)localObject).length()];
          while (i < ((JSONArray)localObject).length())
          {
            this.danmakuContents[i] = ((JSONArray)localObject).get(i).toString();
            i += 1;
          }
          this.isDanmakuAdv = Boolean.valueOf(true);
        }
      }
    }
    catch (Exception localException)
    {
      label132:
      break label132;
    }
    return this.isDanmakuAdv.booleanValue();
  }
  
  public void setAd(GdtAd paramGdtAd)
  {
    this.ad = paramGdtAd;
  }
  
  public void setVideoData(GdtVideoData paramGdtVideoData)
  {
    this.videoData = paramGdtVideoData;
  }
  
  public void setVideoSplicePageStyle(int paramInt)
  {
    this.videoSplicePageStyle = paramInt;
  }
  
  public void setWebUrl(String paramString)
  {
    this.webUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.GdtImaxData
 * JD-Core Version:    0.7.0.1
 */