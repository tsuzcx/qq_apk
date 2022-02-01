package com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component;

import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyMotiveAdModule;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.api.GdtAdError;
import com.tencent.gdtad.api.GdtAdListener;
import org.json.JSONObject;

class VideoFeedsSoftAdTest$1
  implements GdtAdListener
{
  VideoFeedsSoftAdTest$1(VideoFeedsSoftAdTest paramVideoFeedsSoftAdTest) {}
  
  public void a(GdtAd paramGdtAd)
  {
    paramGdtAd = ReadInJoyMotiveAdModule.a(paramGdtAd);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("adInfo", paramGdtAd);
      if (paramGdtAd == null)
      {
        localJSONObject.put("retCode", -1);
        return;
      }
      localJSONObject.put("retCode", 0);
      paramGdtAd = localJSONObject.getString("adInfo");
      ReadInJoyMotiveAdModule.a().a(VideoFeedsSoftAdTest.a(this.a), 0, paramGdtAd, 15, "MOTIVEADCALLBACK", "");
      return;
    }
    catch (Exception paramGdtAd)
    {
      paramGdtAd.printStackTrace();
    }
  }
  
  public void a(GdtAd paramGdtAd, GdtAdError paramGdtAdError) {}
  
  public void b(GdtAd paramGdtAd) {}
  
  public void c(GdtAd paramGdtAd) {}
  
  public void d(GdtAd paramGdtAd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdTest.1
 * JD-Core Version:    0.7.0.1
 */