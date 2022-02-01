package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.WendaInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class OnSuperTopicClickListener
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public OnSuperTopicClickListener(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.proteusItemsData))) {}
    try
    {
      Object localObject = new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.proteusItemsData);
      QLog.d("OnSuperTopicClickListener", 2, new Object[] { "mArticleInfo.proteusItemsData = ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.proteusItemsData });
      Iterator localIterator = ((JSONObject)localObject).keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ("id_super_topic".equals(str))
        {
          localObject = ((JSONObject)localObject).getJSONObject(str).getString("super_topic_jump_url");
          QLog.d("OnSuperTopicClickListener", 2, new Object[] { "jumpToSuperTopic, jumpUrl = ", localObject });
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject, null);
          }
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("OnSuperTopicClickListener", 2, "jumpToSuperTopic", localJSONException);
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, Context paramContext)
  {
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.a;
    if (paramArticleInfo != null)
    {
      paramArticleInfo = paramArticleInfo.d;
      RIJJumpUtils.b(paramContext, paramArticleInfo);
      QLog.i("OnSuperTopicClickListener", 2, "jumpToWendaRefer jumpUrl +" + paramArticleInfo);
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((RIJFeedsType.m(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (RIJFeedsType.n(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_AndroidContentContext);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportLabelsClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return;
    }
    a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportLabelsClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSuperTopicClickListener
 * JD-Core Version:    0.7.0.1
 */