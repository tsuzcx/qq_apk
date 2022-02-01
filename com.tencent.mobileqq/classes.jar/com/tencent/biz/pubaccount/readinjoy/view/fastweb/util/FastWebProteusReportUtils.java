package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class FastWebProteusReportUtils
{
  public static void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((paramTemplateBean == null) || (paramViewBase == null)) {
      return;
    }
    paramArticleInfo = (String)paramTemplateBean.getDataAttribute(paramViewBase.getName(), "click_T");
    if (TextUtils.isEmpty(paramArticleInfo))
    {
      QLog.d("FastWebProteusReportUtils", 2, "customClickReport bigT is null");
      return;
    }
    paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getName());
    paramFastWebArticleInfo = new RIJTransMergeKanDianReport.ReportR5Builder();
    if (paramTemplateBean != null)
    {
      paramTemplateBean = paramTemplateBean.entrySet().iterator();
      while (paramTemplateBean.hasNext())
      {
        Object localObject = (Map.Entry)paramTemplateBean.next();
        paramViewBase = (String)((Map.Entry)localObject).getKey();
        localObject = ((Map.Entry)localObject).getValue();
        if (!TextUtils.equals(paramViewBase, "click_T")) {
          paramFastWebArticleInfo.b(paramViewBase, localObject.toString());
        }
      }
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramArticleInfo, paramArticleInfo, 0, 0, "", "", "", paramFastWebArticleInfo.a(), false);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, ProteusItemData paramProteusItemData)
  {
    paramBaseArticleInfo = paramProteusItemData.a;
    if (paramBaseArticleInfo == null) {
      QLog.d("FastWebProteusReportUtils", 2, "data is null!");
    }
    do
    {
      return;
      if (a(paramProteusItemData))
      {
        a(paramFastWebArticleInfo);
        return;
      }
      paramFastWebArticleInfo = paramBaseArticleInfo.getDataAttribute(null);
      if ((paramFastWebArticleInfo == null) || (paramFastWebArticleInfo.isEmpty()))
      {
        QLog.d("FastWebProteusReportUtils", 2, "cellDataAttr null or empty!");
        return;
      }
      paramBaseArticleInfo = new RIJTransMergeKanDianReport.ReportR5Builder();
      paramProteusItemData = paramFastWebArticleInfo.entrySet().iterator();
      while (paramProteusItemData.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramProteusItemData.next();
        paramBaseArticleInfo.b((String)localEntry.getKey(), localEntry.getValue().toString());
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B303", "0X800B303", 0, 0, "", "", "", paramBaseArticleInfo.a(), false);
    } while (paramFastWebArticleInfo.get("expose_T") == null);
    paramFastWebArticleInfo = paramFastWebArticleInfo.get("expose_T").toString();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramFastWebArticleInfo, paramFastWebArticleInfo, 0, 0, "", "", "", paramBaseArticleInfo.a(), false);
  }
  
  private static void a(FastWebArticleInfo paramFastWebArticleInfo)
  {
    ThreadManager.getSubThreadHandler().post(new FastWebProteusReportUtils.1(paramFastWebArticleInfo));
  }
  
  private static boolean a(ProteusItemData paramProteusItemData)
  {
    if (paramProteusItemData == null) {}
    while (paramProteusItemData.c == null) {
      return false;
    }
    return TextUtils.equals(paramProteusItemData.c.optString("style_ID", ""), "readinjoy_native_tag");
  }
  
  public static void b(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((paramTemplateBean == null) || (paramViewBase == null)) {
      return;
    }
    paramArticleInfo = new HashMap();
    paramFastWebArticleInfo = paramTemplateBean.getDataAttribute(null);
    paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getViewId());
    if (paramFastWebArticleInfo != null) {
      paramArticleInfo.putAll(paramFastWebArticleInfo);
    }
    if (paramTemplateBean != null) {
      paramArticleInfo.putAll(paramTemplateBean);
    }
    paramFastWebArticleInfo = new RIJTransMergeKanDianReport.ReportR5Builder();
    paramArticleInfo = paramArticleInfo.entrySet().iterator();
    while (paramArticleInfo.hasNext())
    {
      paramTemplateBean = (Map.Entry)paramArticleInfo.next();
      paramFastWebArticleInfo.b((String)paramTemplateBean.getKey(), paramTemplateBean.getValue().toString());
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B304", "0X800B304", 0, 0, "", "", "", paramFastWebArticleInfo.a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebProteusReportUtils
 * JD-Core Version:    0.7.0.1
 */