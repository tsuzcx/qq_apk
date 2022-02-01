package com.tencent.biz.pubaccount.weishi_new.commercial;

import UserGrowth.stBusinessAdCard;
import UserGrowth.stBusinessIconInfo;
import UserGrowth.stFeedIconOpConf;
import android.text.TextUtils;

public class WSBigCardCommercialInfo
  extends WSCommercialInfo
{
  private stFeedIconOpConf b;
  
  public WSBigCardCommercialInfo(stBusinessIconInfo paramstBusinessIconInfo, stFeedIconOpConf paramstFeedIconOpConf)
  {
    super(paramstBusinessIconInfo);
    this.b = paramstFeedIconOpConf;
  }
  
  public String e()
  {
    if ((this.a != null) && (this.a.adCard != null)) {
      return this.a.adCard.cardTitle;
    }
    return null;
  }
  
  public String f()
  {
    if ((this.a != null) && (this.a.adCard != null)) {
      return this.a.adCard.cardImage;
    }
    return null;
  }
  
  public String g()
  {
    if ((this.a != null) && (this.a.adCard != null)) {
      return this.a.adCard.cardButtonTxt;
    }
    return null;
  }
  
  public int h()
  {
    stFeedIconOpConf localstFeedIconOpConf = this.b;
    if (localstFeedIconOpConf == null) {
      return 0;
    }
    return localstFeedIconOpConf.startTime * 1000;
  }
  
  public int i()
  {
    stFeedIconOpConf localstFeedIconOpConf = this.b;
    if (localstFeedIconOpConf == null) {
      return 0;
    }
    return localstFeedIconOpConf.duringTime * 1000;
  }
  
  public boolean j()
  {
    if (this.a != null)
    {
      if (this.a.cardSwitch == 0) {
        return false;
      }
      if ((!TextUtils.isEmpty(f())) && (!TextUtils.isEmpty(e())) && (!TextUtils.isEmpty(g())) && (!TextUtils.isEmpty(c()))) {
        return !TextUtils.isEmpty(b());
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.commercial.WSBigCardCommercialInfo
 * JD-Core Version:    0.7.0.1
 */