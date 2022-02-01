package com.tencent.biz.pubaccount.readinjoy.pts.lite;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJStringUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.pts.network.PTSGeneralRequestModule;
import com.tencent.biz.pubaccount.readinjoy.pts.network.PTSGeneralRequestModule.Companion;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSRijReport;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeProteus;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils.CoreReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.pts.core.PTSComposer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PTSLiteTapEventDispatcher
{
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private HashMap<String, ArticleInfo> b;
  private HashMap<String, ArticleInfo> c = new HashMap();
  
  private View a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a() == null)) {
      return null;
    }
    ListView localListView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
    return localListView.getChildAt(paramInt - localListView.getFirstVisiblePosition() + localListView.getHeaderViewsCount());
  }
  
  private ArticleInfo a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramArticleInfo.innerUniqueID))) {
      return null;
    }
    return (ArticleInfo)this.c.get(paramArticleInfo.innerUniqueID);
  }
  
  private ArticleInfo a(String paramString)
  {
    Object localObject;
    if (this.b == null) {
      localObject = null;
    }
    ArticleInfo localArticleInfo1;
    do
    {
      return localObject;
      localArticleInfo1 = (ArticleInfo)this.b.get(paramString);
      localObject = localArticleInfo1;
    } while (localArticleInfo1 != null);
    ArticleInfo localArticleInfo2;
    do
    {
      localObject = this.b.values().iterator();
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localArticleInfo1 = (ArticleInfo)((Iterator)localObject).next();
        } while (localArticleInfo1.mSubArtilceList == null);
        localIterator = localArticleInfo1.mSubArtilceList.iterator();
      }
      localArticleInfo2 = (ArticleInfo)localIterator.next();
    } while (!TextUtils.equals(paramString, localArticleInfo2.innerUniqueID));
    this.c.put(localArticleInfo2.innerUniqueID, localArticleInfo1);
    return localArticleInfo2;
    return null;
  }
  
  private void a(ArticleInfo paramArticleInfo, String paramString, HashMap<String, String> paramHashMap)
  {
    RIJJumpUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(), paramArticleInfo, paramString);
    ReadinjoyReportUtils.CoreReport.a(paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a());
    paramString = ReadinjoyReportUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a());
    if (!TextUtils.isEmpty(paramString))
    {
      String str = RIJFeedsType.b(paramArticleInfo);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, str, paramString, paramString, 0, 0, RIJStringUtils.a(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mStrategyId), PTSRijReport.a(paramArticleInfo, paramHashMap), false);
    }
    PTSLiteDataParser.c(paramArticleInfo);
    PTSLiteDataParser.b(a(paramArticleInfo));
  }
  
  private void a(PTSComposer paramPTSComposer, HashMap<String, String> paramHashMap)
  {
    String str2 = (String)paramHashMap.get("businessType");
    String str1 = (String)paramHashMap.get("requestParams");
    paramHashMap = (String)paramHashMap.get("extendInfo");
    try
    {
      i = Integer.valueOf(str2).intValue();
      PTSGeneralRequestModule.a.a(paramPTSComposer, i, str1, paramHashMap);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("PTSLiteTapEventDispatcher", 1, "[doRequest0xebf] e = " + localNumberFormatException);
        int i = 0;
      }
    }
  }
  
  private void a(String paramString, View paramView, ArticleInfo paramArticleInfo)
  {
    paramString = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    int i;
    int j;
    View localView;
    if (paramString != null)
    {
      i = paramString.intValue();
      paramString = (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.getItem(i + 1);
      j = PTSLiteItemViewBuilder.a(paramArticleInfo);
      localView = a(i);
      if ((i != -1) && (paramArticleInfo != null) && (localView != null)) {
        break label104;
      }
      QLog.e("PTSLiteTapEventDispatcher", 1, "[doDislikeClick] error, position = " + i + " ,or articleInfo is null or cellContainer is null");
    }
    label104:
    FeedItemCellTypeProteus localFeedItemCellTypeProteus;
    do
    {
      return;
      i = -1;
      break;
      ReadInJoyModelImpl localReadInJoyModelImpl = new ReadInJoyModelImpl(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(), paramArticleInfo, j, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.b(), i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.b(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.getCount(), paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter);
      localFeedItemCellTypeProteus = new FeedItemCellTypeProteus(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter);
      localFeedItemCellTypeProteus.a(localReadInJoyModelImpl);
      localFeedItemCellTypeProteus.a(localView);
      localFeedItemCellTypeProteus.a(paramView);
      paramView = a(paramArticleInfo);
    } while (paramView == null);
    localFeedItemCellTypeProteus.a(new ReadInJoyModelImpl(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(), paramView, j, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.b(), i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.b(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.getCount(), paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter));
  }
  
  private void a(String paramString1, ArticleInfo paramArticleInfo, String paramString2, String paramString3, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    QLog.i("PTSLiteTapEventDispatcher", 1, "[handleEventType], eventTypeString = " + paramString1 + ", identifier = " + paramString3);
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramString1 = paramString1.split("\\|");
    int j = paramString1.length;
    int i = 0;
    label60:
    String str;
    if (i < j)
    {
      str = paramString1[i];
      QLog.i("PTSLiteTapEventDispatcher", 1, "[handleEventType], eventType = " + str);
      if (!TextUtils.equals(str, "allInOneJump")) {
        break label154;
      }
      QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent], allInOneJump, jumpUrl = " + paramString2);
      a(paramArticleInfo, paramString2, paramHashMap);
    }
    for (;;)
    {
      i += 1;
      break label60;
      break;
      label154:
      if (TextUtils.equals(str, "dislikeClick"))
      {
        QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent], dislikeClick.");
        a(paramString3, paramView, paramArticleInfo);
      }
      else if (TextUtils.equals(str, "0xebfRequest"))
      {
        QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent], request0xebf.");
        a(paramPTSComposer, paramHashMap);
      }
    }
  }
  
  public void a(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramHashMap == null) || (paramView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter == null) || (this.jdField_a_of_type_JavaUtilHashMap == null) || (this.b == null)) {
      QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent] error, something is null.");
    }
    ArticleInfo localArticleInfo;
    String str1;
    do
    {
      return;
      localArticleInfo = a(paramString);
      if (localArticleInfo == null)
      {
        QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent] error, articleInfo is null.");
        return;
      }
      String str2 = (String)paramHashMap.get("eventType");
      String str3 = (String)paramHashMap.get("jumpUrl");
      str1 = (String)paramHashMap.get("clickReportName");
      if (TextUtils.isEmpty(str2))
      {
        QLog.e("PTSLiteTapEventDispatcher", 1, "[handleTapEvent] error, eventType is null or empty.");
        return;
      }
      a(str2, localArticleInfo, str3, paramString, paramHashMap, paramView, paramPTSComposer);
    } while (TextUtils.isEmpty(str1));
    paramString = RIJFeedsType.b(localArticleInfo);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramString, str1, str1, 0, 0, RIJStringUtils.a(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), String.valueOf(localArticleInfo.mStrategyId), PTSRijReport.a(localArticleInfo, paramHashMap), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteTapEventDispatcher
 * JD-Core Version:    0.7.0.1
 */