package com.tencent.biz.pubaccount.weishi_new.commercial;

import UserGrowth.stBusinessAdCard;
import UserGrowth.stBusinessIconInfo;
import UserGrowth.stFeedIconOpConf;
import android.text.TextUtils;

public class WSBigCardCommercialInfo
  extends WSCommercialInfo
{
  private stFeedIconOpConf a;
  
  public WSBigCardCommercialInfo(stBusinessIconInfo paramstBusinessIconInfo, stFeedIconOpConf paramstFeedIconOpConf)
  {
    super(paramstBusinessIconInfo);
    this.jdField_a_of_type_UserGrowthStFeedIconOpConf = paramstFeedIconOpConf;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_UserGrowthStBusinessIconInfo != null)
    {
      if (this.jdField_a_of_type_UserGrowthStBusinessIconInfo.cardSwitch == 0) {
        return false;
      }
      if ((!TextUtils.isEmpty(d())) && (!TextUtils.isEmpty(c())) && (!TextUtils.isEmpty(e())) && (!TextUtils.isEmpty(b()))) {
        return !TextUtils.isEmpty(a());
      }
    }
    return false;
  }
  
  public int b()
  {
    stFeedIconOpConf localstFeedIconOpConf = this.jdField_a_of_type_UserGrowthStFeedIconOpConf;
    if (localstFeedIconOpConf == null) {
      return 0;
    }
    return localstFeedIconOpConf.startTime * 1000;
  }
  
  public int c()
  {
    stFeedIconOpConf localstFeedIconOpConf = this.jdField_a_of_type_UserGrowthStFeedIconOpConf;
    if (localstFeedIconOpConf == null) {
      return 0;
    }
    return localstFeedIconOpConf.duringTime * 1000;
  }
  
  public String c()
  {
    if ((this.jdField_a_of_type_UserGrowthStBusinessIconInfo != null) && (this.jdField_a_of_type_UserGrowthStBusinessIconInfo.adCard != null)) {
      return this.jdField_a_of_type_UserGrowthStBusinessIconInfo.adCard.cardTitle;
    }
    return null;
  }
  
  public String d()
  {
    if ((this.jdField_a_of_type_UserGrowthStBusinessIconInfo != null) && (this.jdField_a_of_type_UserGrowthStBusinessIconInfo.adCard != null)) {
      return this.jdField_a_of_type_UserGrowthStBusinessIconInfo.adCard.cardImage;
    }
    return null;
  }
  
  public String e()
  {
    if ((this.jdField_a_of_type_UserGrowthStBusinessIconInfo != null) && (this.jdField_a_of_type_UserGrowthStBusinessIconInfo.adCard != null)) {
      return this.jdField_a_of_type_UserGrowthStBusinessIconInfo.adCard.cardButtonTxt;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.commercial.WSBigCardCommercialInfo
 * JD-Core Version:    0.7.0.1
 */