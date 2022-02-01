package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stCollection;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaGdtAdInfo;
import com.tencent.biz.pubaccount.weishi_new.commercial.AbsWSRichWidgetData;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.Checkable;

public class WSVerticalItemData
  implements Checkable
{
  private stSimpleMetaFeed a;
  private boolean b;
  private boolean c;
  private stSimpleMetaGdtAdInfo d;
  private AbsWSRichWidgetData e;
  private WSDramaEpisodeInfo f;
  private stCollection g;
  private boolean h;
  
  public void a(stCollection paramstCollection)
  {
    this.g = paramstCollection;
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    this.a = paramstSimpleMetaFeed;
  }
  
  public void a(stSimpleMetaGdtAdInfo paramstSimpleMetaGdtAdInfo)
  {
    this.d = paramstSimpleMetaGdtAdInfo;
  }
  
  public void a(AbsWSRichWidgetData paramAbsWSRichWidgetData)
  {
    this.e = paramAbsWSRichWidgetData;
  }
  
  public void a(WSDramaEpisodeInfo paramWSDramaEpisodeInfo)
  {
    this.f = paramWSDramaEpisodeInfo;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean a()
  {
    return this.h;
  }
  
  public stSimpleMetaFeed b()
  {
    return this.a;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean c()
  {
    return this.b;
  }
  
  public boolean d()
  {
    return this.c;
  }
  
  public stSimpleMetaGdtAdInfo e()
  {
    return this.d;
  }
  
  public AbsWSRichWidgetData f()
  {
    return this.e;
  }
  
  public WSDramaEpisodeInfo g()
  {
    return this.f;
  }
  
  public stCollection h()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData
 * JD-Core Version:    0.7.0.1
 */