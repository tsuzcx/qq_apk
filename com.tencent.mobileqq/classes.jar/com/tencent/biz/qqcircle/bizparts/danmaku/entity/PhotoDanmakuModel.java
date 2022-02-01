package com.tencent.biz.qqcircle.bizparts.danmaku.entity;

import com.tencent.biz.qqcircle.bizparts.danmaku.model.QzoneBarrageEffectData.BarrageEffectInfo;
import feedcloud.FeedCloudMeta.StUser;

public class PhotoDanmakuModel
{
  public String a;
  public FeedCloudMeta.StUser b;
  public String c;
  public String d;
  public String e;
  public String f;
  public int g;
  public boolean h;
  public boolean i;
  public int j;
  public int k;
  public QzoneBarrageEffectData.BarrageEffectInfo l;
  
  public PhotoDanmakuModel(String paramString1, FeedCloudMeta.StUser paramStUser, String paramString2, String paramString3, String paramString4, String paramString5, QzoneBarrageEffectData.BarrageEffectInfo paramBarrageEffectInfo)
  {
    this.a = paramString1;
    this.b = paramStUser;
    this.c = paramString2.replace("\n", "  ");
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
    this.l = paramBarrageEffectInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.entity.PhotoDanmakuModel
 * JD-Core Version:    0.7.0.1
 */