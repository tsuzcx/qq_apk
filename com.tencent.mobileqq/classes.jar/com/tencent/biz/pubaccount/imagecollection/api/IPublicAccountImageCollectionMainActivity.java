package com.tencent.biz.pubaccount.imagecollection.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPublicAccountImageCollectionMainActivity
  extends QRouteApi
{
  public static final String ARTICLE_ID = "articleid";
  public static final String CLICK_SOURCE = "click_source";
  public static final String RECOMMEND_POSITION = "recommend_position";
  public static final String RECOMMEND_SOURCE = "recommend_source";
  public static final String SOURCE_FOR_REPORT = "source_for_report";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionMainActivity
 * JD-Core Version:    0.7.0.1
 */