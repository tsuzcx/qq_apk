package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackQuestionAnswerExtraInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackTopicExtraInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import org.json.JSONObject;

class ComponentContentHotQuestion$1
  implements View.OnClickListener
{
  ComponentContentHotQuestion$1(ComponentContentHotQuestion paramComponentContentHotQuestion) {}
  
  public void onClick(View paramView)
  {
    Object localObject4 = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a();
    ArticleInfo localArticleInfo = ((IReadInJoyModel)localObject4).a();
    Object localObject3 = (NewPolymericInfo.PackArticleInfo)localArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
    Object localObject2;
    if ((localArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 12) && (((NewPolymericInfo.PackArticleInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackTopicExtraInfo != null))
    {
      localObject2 = new Intent(this.a.jdField_a_of_type_AndroidContentContext, ReadInJoyDeliverUGCActivity.class);
      ((Intent)localObject2).putExtra("arg_topic_id", String.valueOf(((NewPolymericInfo.PackArticleInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackTopicExtraInfo.jdField_b_of_type_Int));
      ((Intent)localObject2).putExtra("support_topic", true);
      ((Intent)localObject2).putExtra("support_linkify", true);
    }
    try
    {
      String str1 = new String(Base64Util.decode(((NewPolymericInfo.PackArticleInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackTopicExtraInfo.jdField_b_of_type_JavaLangString, 0));
      ((Intent)localObject2).putExtra("is_from_poly_topic", true);
      if (((IReadInJoyModel)localObject4).e() == 70)
      {
        bool = true;
        ((Intent)localObject2).putExtra("is_from_dian_dian", bool);
        ((Intent)localObject2).putExtra("arg_topic_name", str1);
        ((Intent)localObject2).putExtra("arg_ad_tag", ((NewPolymericInfo.PackArticleInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackTopicExtraInfo.c);
        this.a.getContext().startActivity((Intent)localObject2);
        localObject2 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject2).put("channel_id", ((IReadInJoyModel)localObject4).e());
        if (((NewPolymericInfo.PackArticleInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackQuestionAnswerExtraInfo == null) {
          break label412;
        }
        str1 = ((NewPolymericInfo.PackArticleInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackQuestionAnswerExtraInfo.a;
        ((JSONObject)localObject2).put("rowkey", str1);
        if (((NewPolymericInfo.PackArticleInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackTopicExtraInfo == null) {
          break label421;
        }
        i = ((NewPolymericInfo.PackArticleInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackTopicExtraInfo.jdField_b_of_type_Int;
        ((JSONObject)localObject2).put("topicid", i);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          int i;
          Object localObject1;
          localException2.printStackTrace();
          continue;
          String str2 = "2";
        }
      }
      localObject3 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      localObject4 = localArticleInfo.mFeedId + "";
      if (RIJFeedsType.o(localArticleInfo))
      {
        str1 = "1";
        ((IPublicAccountReportUtils)localObject3).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800982C", "0X800982C", 0, 0, (String)localObject4, str1, localArticleInfo.mStrategyId + "", ((JSONObject)localObject2).toString(), false);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localException1.printStackTrace();
        localObject1 = "";
        continue;
        boolean bool = false;
        continue;
        label412:
        localObject1 = Integer.valueOf(0);
        continue;
        label421:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotQuestion.1
 * JD-Core Version:    0.7.0.1
 */