package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.content.Context;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FastWebDislikeUtils
{
  private static final String a = HardCodeUtil.a(2131716710);
  private static final String b = HardCodeUtil.a(2131715781);
  
  public static String a(int paramInt)
  {
    return ReadInJoyHelper.a(paramInt, 99990000L, "9999万+", a);
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    ThreadManager.executeOnSubThread(new FastWebDislikeUtils.1(paramArticleInfo, paramContext));
    a(paramArticleInfo, "0X80101DC");
  }
  
  public static void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramFastWebArticleInfo.jdField_a_of_type_Boolean)
    {
      paramFastWebArticleInfo.jdField_a_of_type_Boolean = false;
      paramFastWebArticleInfo.jdField_a_of_type_Int -= 1;
      ReportUtil.b(paramArticleInfo, "0X8009765", "2");
    }
    for (;;)
    {
      ReadInJoyLogicEngineEventDispatcher.a().e();
      ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), paramFastWebArticleInfo.jdField_a_of_type_Boolean, paramFastWebArticleInfo);
      return;
      paramFastWebArticleInfo.jdField_a_of_type_Boolean = true;
      paramFastWebArticleInfo.jdField_a_of_type_Int += 1;
      ReportUtil.b(paramArticleInfo, "0X8009764", "2");
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString)
  {
    a(paramArticleInfo, paramString, null);
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString, Map<String, Object> paramMap)
  {
    int j = 0;
    if (paramArticleInfo == null) {
      return;
    }
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = ReportUtil.a(paramArticleInfo);
    for (;;)
    {
      try
      {
        localReportR5Builder.b("source_from", "2");
        localReportR5Builder.j();
        localReportR5Builder.k();
        localReportR5Builder.l();
        localReportR5Builder.a(paramArticleInfo.mAlgorithmID);
        localReportR5Builder.b(paramArticleInfo.mStrategyId);
        AladdinConfig localAladdinConfig = Aladdin.getConfig(151);
        if (localAladdinConfig != null)
        {
          i = localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_business_id", -1);
          localReportR5Builder.b("interact_style", localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_style", -1));
          localReportR5Builder.b("businessID", i);
        }
        a(paramMap, localReportR5Builder);
        if (RIJAladdinUtils.e())
        {
          i = 1;
          localReportR5Builder.b("artical_interact_area", i);
          localReportR5Builder.b("artical_interact_type", RIJAladdinUtils.d());
          if ((paramString.equals("0X80101DC")) || (paramString.equals("0X80100DB")))
          {
            i = j;
            if (RIJAladdinUtils.f()) {
              i = 1;
            }
            localReportR5Builder.b("ad_relative_pos", i);
          }
          ReportUtil.a(paramArticleInfo, paramString, localReportR5Builder.a());
          return;
        }
      }
      catch (Exception paramArticleInfo)
      {
        QLog.d("FastWebDislikeUtils", 1, "report error! msg=" + paramArticleInfo);
        return;
      }
      int i = 0;
    }
  }
  
  public static void a(Map<String, Object> paramMap, RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder)
  {
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramReportR5Builder.a(str, paramMap.get(str));
      }
    }
  }
  
  public static String b(int paramInt)
  {
    return ReadInJoyHelper.a(paramInt, 99990000L, "9999万+", b);
  }
  
  public static void b(Context paramContext, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    a(paramArticleInfo, "0X8009A5B");
    if ((paramContext instanceof FastWebActivity)) {
      ((FastWebActivity)paramContext).a(false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebDislikeUtils
 * JD-Core Version:    0.7.0.1
 */