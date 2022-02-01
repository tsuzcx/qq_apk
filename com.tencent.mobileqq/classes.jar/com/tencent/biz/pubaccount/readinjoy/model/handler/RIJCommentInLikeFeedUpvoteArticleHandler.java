package com.tencent.biz.pubaccount.readinjoy.model.handler;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.ReqBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.RspBody;

public class RIJCommentInLikeFeedUpvoteArticleHandler
  extends RIJCommentInLikeFeedHandler
{
  public RIJCommentInLikeFeedUpvoteArticleHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  public void a(long paramLong, boolean paramBoolean, FastWebArticleInfo paramFastWebArticleInfo)
  {
    oidb_cmd0x83e.ReqBody localReqBody = new oidb_cmd0x83e.ReqBody();
    int i;
    Object localObject;
    int j;
    if (paramBoolean)
    {
      i = 12;
      localReqBody.uint64_uin.set(paramLong);
      localObject = localReqBody.uint32_operation;
      if (!paramBoolean) {
        break label134;
      }
      j = 2;
      label40:
      ((PBUInt32Field)localObject).set(j);
      localObject = localReqBody.bytes_inner_uniq_id;
      if (paramFastWebArticleInfo == null) {
        break label140;
      }
    }
    label134:
    label140:
    for (paramFastWebArticleInfo = paramFastWebArticleInfo.j;; paramFastWebArticleInfo = "")
    {
      ((PBBytesField)localObject).set(ByteStringMicro.copyFromUtf8(paramFastWebArticleInfo));
      paramFastWebArticleInfo = ReadInJoyOidbHelper.a("OidbSvc.0x83e", 2110, 0, localReqBody.toByteArray());
      paramFastWebArticleInfo.addAttribute("0x83e_upvote_fast_web_article", Integer.valueOf(1));
      paramFastWebArticleInfo.addAttribute("0x83e_upvote_operation_type", Integer.valueOf(i));
      this.a.a(paramFastWebArticleInfo);
      return;
      i = 13;
      break;
      j = 3;
      break label40;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = true;
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    paramToServiceMsg = new oidb_cmd0x83e.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0)
    {
      QLog.d("RIJCommentInLikeFeedUpvoteArticleHandler", 1, "handle0x83eUpvoteFastWebArticleAction result OK");
      if (paramToServiceMsg.uint32_operation.has())
      {
        paramFromServiceMsg = new StringBuilder().append("handle0x83eUpvoteFastWebArticleAction | upvote status :");
        if (paramToServiceMsg.uint32_operation.get() != 2) {
          break label89;
        }
      }
      for (;;)
      {
        QLog.d("RIJCommentInLikeFeedUpvoteArticleHandler", 2, bool);
        return;
        label89:
        bool = false;
      }
    }
    QLog.d("RIJCommentInLikeFeedUpvoteArticleHandler", 1, "handle0x83eUpvoteFastWebArticleAction failed result " + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.handler.RIJCommentInLikeFeedUpvoteArticleHandler
 * JD-Core Version:    0.7.0.1
 */