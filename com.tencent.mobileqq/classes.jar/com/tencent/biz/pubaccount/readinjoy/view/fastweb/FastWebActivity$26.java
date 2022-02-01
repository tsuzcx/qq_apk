package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListAdapter;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ArticleTopicData.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebPTSDataConverter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebVideoItemUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ItemDatasListUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.ModuleInfo;
import tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.TextCardInfo;

class FastWebActivity$26
  extends ReadInJoyObserver
{
  FastWebActivity$26(FastWebActivity paramFastWebActivity) {}
  
  private void c(String paramString)
  {
    if ((FastWebActivity.a(this.a) == null) || (FastWebActivity.a(this.a).b == null) || (FastWebActivity.a(this.a).b.size() <= 0) || (TextUtils.isEmpty(paramString))) {
      QLog.i("FastWebActivity", 1, "[reportTopicTagClick] jumpUrl or topicTag is empty.");
    }
    ArticleTopicData.TopicInfo localTopicInfo;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = FastWebActivity.a(this.a).b.iterator();
      }
      localTopicInfo = (ArticleTopicData.TopicInfo)localIterator.next();
    } while (!TextUtils.equals(localTopicInfo.b, paramString));
    paramString = RIJTransMergeKanDianReport.a();
    paramString.b("puin", "" + FastWebActivity.a(this.a).d);
    paramString.b("rowkey", FastWebActivity.a(this.a).j);
    paramString.b("article_id", FastWebActivity.a(this.a).o);
    paramString.b("tag_from_page", "3");
    paramString.b("tag_rk", localTopicInfo.c);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B9BC", "0X800B9BC", 0, 0, "", "", "", paramString.a(), false);
    QLog.i("FastWebActivity", 1, "[reportTopicTagClick] 0X800B9BC, r5 = " + paramString.a());
  }
  
  public void a(String paramString)
  {
    int j = 0;
    QLog.d("Q.readinjoy.fast_web", 2, " onWebCallback : " + paramString);
    if (!FastWebActivity.e(this.a)) {
      return;
    }
    int i;
    if ("onPageStarted".equals(paramString)) {
      i = 300;
    }
    for (;;)
    {
      ThreadManager.getUIHandler().postDelayed(new FastWebActivity.26.1(this), i);
      return;
      i = j;
      if ("onConversationJumpRestoreStack".equals(paramString)) {
        i = j;
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (FastWebActivity.a(this.a) == null) {
      return;
    }
    FastWebVideoItemUtils.a(FastWebActivity.a(this.a), paramString, paramInt1, paramInt2);
    FastWebActivity.d(this.a);
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {}
    for (String str = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;; str = "")
    {
      if ((TextUtils.isEmpty(str)) || (FastWebActivity.a(this.a) == null)) {
        return;
      }
      paramArrayList = FastWebRequestUtil.a(str, 23, paramArrayList);
      int i = 0;
      while (i < paramArrayList.size())
      {
        BaseData localBaseData = (BaseData)paramArrayList.get(i);
        if ((localBaseData instanceof ProteusItemData)) {
          FastWebRequestUtil.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (ProteusItemData)localBaseData, 3, this.a.jdField_a_of_type_AndroidUtilSparseArray);
        }
        ItemDatasListUtils.b(FastWebActivity.a(this.a), localBaseData, FastWebActivity.a(this.a));
        i += 1;
      }
      paramArrayList = ReadInJoyLogicEngine.a().a();
      if (paramArrayList != null) {
        paramArrayList.a(str, FastWebActivity.a(this.a));
      }
      FastWebActivity.d(this.a);
      QLog.d("FastWebActivity", 1, "m0xc6dRespObserver,onHandle0xc6dResp");
      return;
    }
  }
  
  public void aj_()
  {
    super.aj_();
    if ((FastWebActivity.c(this.a)) || (FastWebActivity.a(this.a) == null)) {
      return;
    }
    FastWebActivity.d(this.a);
  }
  
  public void b(List<oidb_cmd0xe7e.ModuleInfo> paramList, List<oidb_cmd0xe7e.TextCardInfo> paramList1)
  {
    ThreadManager.getUIHandler().post(new FastWebActivity.26.2(this, paramList, paramList1));
  }
  
  public void c()
  {
    FastWebActivity.b(this.a, true);
    if (FastWebActivity.a(this.a) != null) {
      FastWebActivity.a(this.a).notifyDataSetChanged();
    }
  }
  
  public void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str = paramString.substring(0, paramString.length() - "#native_article_topic_tag".length());
    c(str);
    RIJJumpUtils.a(this.a, str);
    QLog.i("FastWebActivity", 1, "[onTopicTagClick] url = " + paramString + ", jumpUrl = " + str);
  }
  
  public void i()
  {
    super.i();
    if ((FastWebActivity.d(this.a)) || (FastWebActivity.a(this.a) == null) || (FastWebActivity.a(this.a) == null) || (FastWebActivity.a(this.a) == null)) {
      return;
    }
    FastWebPTSDataConverter.a(FastWebActivity.a(this.a), FastWebActivity.a(this.a));
    FastWebActivity.h(this.a);
    FastWebActivity.d(this.a);
  }
  
  public void z_()
  {
    if (FastWebActivity.a(this.a) == null) {
      return;
    }
    FastWebActivity.h(this.a);
    FastWebActivity.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.26
 * JD-Core Version:    0.7.0.1
 */