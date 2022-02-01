package com.tencent.biz.pubaccount.readinjoy.view.widget.banner;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo.BaseItem;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo.ImgItem;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONException;
import org.json.JSONObject;

public class BannerReportHelper
{
  public static RIJTransMergeKanDianReport.ReportR5Builder a(int paramInt)
  {
    return new RIJTransMergeKanDianReport.ReportR5Builder().b().a(paramInt);
  }
  
  public static RIJTransMergeKanDianReport.ReportR5Builder a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    localReportR5Builder = a(paramInt);
    try
    {
      paramString1 = localReportR5Builder.b(paramString1).a("URL", paramString2);
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramString1 = paramString1.a("ad_page", paramInt);
        return paramString1;
      }
      return localReportR5Builder;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static String a(int paramInt, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", paramString);
      localJSONObject.put("num", paramInt);
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, TopBannerInfo.BaseItem paramBaseItem)
  {
    if ((paramBaseItem instanceof TopBannerInfo.ImgItem)) {}
    for (String str = ((TopBannerInfo.ImgItem)paramBaseItem).f;; str = "0")
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt3), String.valueOf(paramInt1), String.valueOf(paramBaseItem.jdField_a_of_type_Int), a(paramInt2, paramBaseItem.e, str, paramBaseItem.jdField_a_of_type_Boolean).a(), false);
      return;
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = a(paramInt1);
    if (paramBoolean) {
      paramInt1 = 1;
    }
    try
    {
      for (;;)
      {
        localReportR5Builder.a("ad_page_include", paramInt1);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt2), "", "", localReportR5Builder.a(), false);
        return;
        paramInt1 = 0;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public static void a(String paramString, int paramInt, TopBannerInfo.BaseItem paramBaseItem)
  {
    if ((paramBaseItem instanceof TopBannerInfo.ImgItem)) {}
    for (paramBaseItem = ((TopBannerInfo.ImgItem)paramBaseItem).f;; paramBaseItem = "0")
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt), "", "", a(paramInt, paramBaseItem), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.banner.BannerReportHelper
 * JD-Core Version:    0.7.0.1
 */