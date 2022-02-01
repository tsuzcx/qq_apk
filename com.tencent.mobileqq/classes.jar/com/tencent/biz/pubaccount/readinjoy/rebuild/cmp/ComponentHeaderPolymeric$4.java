package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.PolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ComponentHeaderPolymeric$4
  implements UserOperationModule.Ox978RespCallBack
{
  ComponentHeaderPolymeric$4(ComponentHeaderPolymeric paramComponentHeaderPolymeric, ArticleInfo paramArticleInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "978 resp, result : " + paramBoolean + ", data : " + paramInt + " distUin = " + paramString + ", topicID : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mPolymericInfo.f + " followStatus = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mPolymericInfo.e);
    }
    if (!paramString.equals(ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric).getTag())) {}
    label280:
    label285:
    do
    {
      return;
      ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric, true);
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mPolymericInfo.e == 1)
        {
          ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric, true);
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mPolymericInfo.e != 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mPolymericInfo.e != 2)) {
            break label285;
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mPolymericInfo.e != 1) {
            break label280;
          }
        }
        for (paramInt = 2;; paramInt = 1)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mPolymericInfo.e = paramInt;
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a != null)) {
            ((TopicRecommendFeedsInfo.TopicRecommendInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).c = (paramInt - 1);
          }
          ThreadManager.post(new ComponentHeaderPolymeric.4.1(this, paramInt), 5, null, true);
          return;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mPolymericInfo.e != 2) {
            break;
          }
          ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric, false);
          break;
        }
        QLog.e("ComponentHeaderPolymeric", 2, "978 resp error, result : " + paramBoolean + ", data : " + paramInt + ", topicID : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mPolymericInfo.f);
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mPolymericInfo.e == 1)
      {
        ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric, 1);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mPolymericInfo.e != 2);
    ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric.4
 * JD-Core Version:    0.7.0.1
 */