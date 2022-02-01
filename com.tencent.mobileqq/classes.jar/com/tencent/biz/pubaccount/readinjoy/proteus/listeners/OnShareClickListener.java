package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.QShareUtils;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class OnShareClickListener
  implements ViewBase.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
  private FastWebShareUtils jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebShareUtils;
  private QShareUtils jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesQShareUtils;
  private ReadInJoyShareHelperV2 jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString;
  
  public OnShareClickListener(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static String a(ArticleInfo paramArticleInfo)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      RIJTransMergeKanDianReport.a(localJSONObject, paramArticleInfo);
      localJSONObject.put("feed_type", 1043);
      localJSONObject.put("version", VideoReporter.jdField_a_of_type_JavaLangString);
      localJSONObject.put("os", "1");
      if (paramArticleInfo != null)
      {
        localJSONObject.put("comment_id", paramArticleInfo.commentId);
        localJSONObject.put("entry", paramArticleInfo.commentSrc);
      }
      if ((paramArticleInfo != null) && (paramArticleInfo.mChannelID == 0L)) {
        localJSONObject.put("place", 1);
      }
      for (;;)
      {
        return localJSONObject.toString();
        if ((paramArticleInfo != null) && (paramArticleInfo.mChannelID == 70L)) {
          localJSONObject.put("place", 2);
        }
      }
      return "";
    }
    catch (JSONException paramArticleInfo)
    {
      QLog.d("OnShareClickListener", 2, paramArticleInfo.getMessage());
    }
  }
  
  private List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(13));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(9));
    localArrayList.add(Integer.valueOf(10));
    return localArrayList;
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    String str = a(paramArticleInfo);
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramArticleInfo.mSubscribeID, "0X800AB52", "0X800AB52", 0, 0, String.valueOf(localSocializeFeedsInfo.a), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str, false);
  }
  
  private void a(ViewBase paramViewBase)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2 = new ReadInJoyShareHelperV2((Activity)paramViewBase.getNativeView().getContext(), (AppInterface)localObject, new OnShareClickListener.ItemSheetClickProcessor(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, new WeakReference((Activity)paramViewBase.getNativeView().getContext())));
    paramViewBase.getNativeView().addOnAttachStateChangeListener(new OnShareClickListener.1(this));
    paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a().getIntent();
    if ((paramViewBase != null) && (TextUtils.isEmpty(paramViewBase.getStringExtra("big_brother_source_key")))) {
      paramViewBase.putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a().setActionSheetTitle(HardCodeUtil.a(2131713537));
    paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl;
    int i;
    if (RIJItemViewType.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
      i = 15;
    }
    for (;;)
    {
      localObject = paramViewBase;
      if (paramViewBase != null) {
        localObject = paramViewBase + "&rowkey=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
      }
      paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2;
      List localList = a();
      ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      paramViewBase.a(new List[] { localList }, i, (String)localObject, localArticleInfo);
      return;
      if (RIJItemViewType.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
      {
        i = 16;
      }
      else if (RIJItemViewType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
      {
        i = 12;
      }
      else if (RIJItemViewType.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
      {
        i = 28;
        paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mOriginalUrl;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    a(paramViewBase);
    com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    RIJFeedsDynamicInsertController.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_SHARE, 0, 0, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnShareClickListener
 * JD-Core Version:    0.7.0.1
 */