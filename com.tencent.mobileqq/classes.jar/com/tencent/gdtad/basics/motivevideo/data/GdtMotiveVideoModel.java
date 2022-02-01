package com.tencent.gdtad.basics.motivevideo.data;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.video.GdtVideoData;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class GdtMotiveVideoModel
{
  private GdtMotiveVideoPageData a;
  private qq_ad_get.QQAdGetRsp.AdInfo b;
  private GdtVideoData c;
  private GdtAd d;
  
  public GdtMotiveVideoModel(GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[GdtMotiveVideoModel]\n");
    localStringBuilder.append(paramGdtMotiveVideoPageData.adsContent);
    GdtLog.a("GdtMotiveVideoModel", localStringBuilder.toString());
    this.a = paramGdtMotiveVideoPageData;
    b(paramGdtMotiveVideoPageData);
    a(paramGdtMotiveVideoPageData);
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    this.d = new GdtAd(this.b);
    this.c = new GdtVideoData();
    this.c.setAd(this.d);
    this.c.setPlayScene(11);
    this.c.setUrl(paramGdtMotiveVideoPageData.url);
  }
  
  private void b(GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    if (TextUtils.isEmpty(paramGdtMotiveVideoPageData.adsContent))
    {
      GdtLog.d("GdtMotiveVideoModel", "[adJson==null error]");
      return;
    }
    try
    {
      this.b = ((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramGdtMotiveVideoPageData.adsContent))));
      return;
    }
    catch (Throwable paramGdtMotiveVideoPageData)
    {
      GdtLog.d("GdtMotiveVideoModel", "GdtMotiveVideoModel error]", paramGdtMotiveVideoPageData);
    }
  }
  
  public GdtMotiveVideoPageData a()
  {
    return this.a;
  }
  
  public qq_ad_get.QQAdGetRsp.AdInfo b()
  {
    return this.b;
  }
  
  public GdtVideoData c()
  {
    return this.c;
  }
  
  public GdtAd d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel
 * JD-Core Version:    0.7.0.1
 */