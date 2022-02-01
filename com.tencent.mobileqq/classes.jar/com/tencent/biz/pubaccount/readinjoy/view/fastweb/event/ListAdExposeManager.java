package com.tencent.biz.pubaccount.readinjoy.view.fastweb.event;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import java.util.HashSet;
import org.json.JSONObject;

public class ListAdExposeManager
{
  private HashSet<ListAdExposeData> a;
  private HashSet<ListAdExposeData> b;
  private HashSet<ListAdExposeData> c;
  
  private void a(ListAdExposeData paramListAdExposeData)
  {
    if (this.c.contains(paramListAdExposeData)) {}
    do
    {
      return;
      this.c.add(paramListAdExposeData);
    } while ((!this.b.contains(paramListAdExposeData)) || (this.a.contains(paramListAdExposeData)));
    this.a.add(paramListAdExposeData);
    b(paramListAdExposeData);
  }
  
  private void b(ListAdExposeData paramListAdExposeData)
  {
    float f = paramListAdExposeData.jdField_a_of_type_Float;
    long l = paramListAdExposeData.b;
    paramListAdExposeData = paramListAdExposeData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if (paramListAdExposeData == null) {
      return;
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject1.put("article_id", String.valueOf(paramListAdExposeData.mArticleID));
      localJSONObject1.put("rowkey", String.valueOf(paramListAdExposeData.mRowKey));
      paramListAdExposeData.mBusiJson = localJSONObject1;
      localJSONObject2.put("exposureArea", f);
      localJSONObject2.put("exposureTime", l);
      paramListAdExposeData.mReportDataJson = localJSONObject2;
      ReadInJoyAdReportUtils.a(paramListAdExposeData, 38, 2, 2);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ReadInJoyAdLog.a("ListAdExposeManager", localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ListAdExposeManager
 * JD-Core Version:    0.7.0.1
 */