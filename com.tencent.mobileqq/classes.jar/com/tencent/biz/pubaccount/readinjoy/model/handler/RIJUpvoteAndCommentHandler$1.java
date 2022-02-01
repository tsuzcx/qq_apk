package com.tencent.biz.pubaccount.readinjoy.model.handler;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import pkh;
import qep;
import qjf;
import qxp;
import rsh;
import rsj;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.ControlParam;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.ReqBody;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.ReqMsgInfo;

public class RIJUpvoteAndCommentHandler$1
  implements Runnable
{
  public RIJUpvoteAndCommentHandler$1(qjf paramqjf, String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1;
    if ("-1".equals(this.jdField_a_of_type_JavaLangString))
    {
      localObject1 = "mFeedId != 0 ";
      if (this.b == -1) {
        break label609;
      }
      localObject1 = (String)localObject1 + " and mChannelID =" + this.b;
    }
    label609:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJUpvoteAndCommentHandler", 1, "request0x8c8UpdateUpvoteAndComment selection:" + (String)localObject1);
      }
      QLog.d("RIJUpvoteAndCommentHandler", 1, new Object[] { "req 8c8, feedsId = ", this.jdField_a_of_type_JavaLangString, ", feedsType = ", Integer.valueOf(this.jdField_a_of_type_Int) });
      Object localObject3 = this.this$0.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(ArticleInfo.class, true, (String)localObject1, null, null, null, "mRecommendSeq desc", null);
      if (localObject3 == null)
      {
        QLog.d("RIJUpvoteAndCommentHandler", 1, "no soical feeds to update feedsid:" + this.jdField_a_of_type_JavaLangString);
        return;
        localObject1 = "mFeedId = " + this.jdField_a_of_type_JavaLangString + " and mFeedType =" + this.jdField_a_of_type_Int;
        break;
      }
      localObject1 = new ConcurrentHashMap();
      Object localObject2 = new oidb_cmd0x8c8.ReqBody();
      ((oidb_cmd0x8c8.ReqBody)localObject2).uint64_uin.set(Long.valueOf(pkh.a()).longValue());
      ((oidb_cmd0x8c8.ReqBody)localObject2).uint32_version.set(1);
      ArrayList localArrayList = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject3).next();
        oidb_cmd0x8c8.ReqMsgInfo localReqMsgInfo = new oidb_cmd0x8c8.ReqMsgInfo();
        localReqMsgInfo.uint64_feeds_id.set(localArticleInfo.mFeedId);
        localReqMsgInfo.uint32_business_id.set((int)localArticleInfo.businessId);
        if (localArticleInfo.mSocialFeedInfo != null) {
          localReqMsgInfo.uint32_feeds_style.set(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int);
        }
        localReqMsgInfo.feeds_type.set(localArticleInfo.mFeedType);
        if ((localArticleInfo.mFeedType == 14) && (localArticleInfo.mTopicRecommendFeedsInfo != null) && (localArticleInfo.mTopicRecommendFeedsInfo.a != null))
        {
          Iterator localIterator = localArticleInfo.mTopicRecommendFeedsInfo.a.iterator();
          while (localIterator.hasNext())
          {
            rsj localrsj = (rsj)localIterator.next();
            localReqMsgInfo.rpt_topic_id.add(Integer.valueOf(localrsj.jdField_a_of_type_Int));
          }
        }
        localArrayList.add(localReqMsgInfo);
        ((ConcurrentHashMap)localObject1).put(localArticleInfo.mFeedId + "" + localArticleInfo.mFeedType + localArticleInfo.mChannelID, localArticleInfo);
      } while (localArrayList.size() < 100);
      ((oidb_cmd0x8c8.ReqBody)localObject2).rpt_msg_info_list.set(localArrayList);
      ((oidb_cmd0x8c8.ReqBody)localObject2).control_req_param.set(new oidb_cmd0x8c8.ControlParam());
      ((oidb_cmd0x8c8.ReqBody)localObject2).control_req_param.uint32_need_follow_status.set(1);
      localObject2 = qxp.a("OidbSvc.0x8c8", 2248, 0, ((oidb_cmd0x8c8.ReqBody)localObject2).toByteArray());
      ((ToServiceMsg)localObject2).addAttribute("0x8c8_retry_times", Integer.valueOf(0));
      ((ToServiceMsg)localObject2).addAttribute("0x8c8_articleMap", localObject1);
      ((ToServiceMsg)localObject2).addAttribute("isUpdateByAccount", Boolean.valueOf(this.jdField_a_of_type_Boolean));
      this.this$0.jdField_a_of_type_Qep.a((ToServiceMsg)localObject2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.handler.RIJUpvoteAndCommentHandler.1
 * JD-Core Version:    0.7.0.1
 */