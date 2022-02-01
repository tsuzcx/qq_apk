package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetCommentListRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Map;

class CommentBusiness$9
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetCommentListRsp>
{
  CommentBusiness$9(CommentBusiness paramCommentBusiness, CertifiedAccountMeta.StFeed paramStFeed, String paramString) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetCommentListRsp paramStGetCommentListRsp)
  {
    CommentBusiness.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBusiness, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get(), true);
    if (paramStGetCommentListRsp == null)
    {
      QLog.d(CommentBusiness.a(), 1, "getCommentSize: rsp is null");
      return;
    }
    if (CommentBusiness.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBusiness).get(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get()) != null)
    {
      paramBaseRequest = CommentBusiness.a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCommentSize:");
      ((StringBuilder)localObject).append(paramStGetCommentListRsp.vecComment.size());
      ((StringBuilder)localObject).append(", attachInfo:");
      ((StringBuilder)localObject).append(paramStGetCommentListRsp.extInfo.attachInfo.get());
      ((StringBuilder)localObject).append("isFinish：");
      ((StringBuilder)localObject).append(paramStGetCommentListRsp.isFinish.get());
      QLog.d(paramBaseRequest, 2, ((StringBuilder)localObject).toString());
      ((ArrayList)CommentBusiness.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBusiness).get(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get())).addAll(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBusiness.a(paramStGetCommentListRsp.vecComment.get(), this.jdField_a_of_type_JavaLangString));
    }
    paramBaseRequest = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBusiness;
    Object localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get();
    COMM.StCommonExt localStCommonExt = paramStGetCommentListRsp.extInfo;
    if (paramStGetCommentListRsp.isFinish.get() == 0) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    CommentBusiness.a(paramBaseRequest, (String)localObject, localStCommonExt, paramBoolean, true);
    StoryDispatcher.a().dispatch(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBusiness.a(new Object[] { Integer.valueOf(9), Long.valueOf(paramLong), paramString, paramStGetCommentListRsp, Integer.valueOf(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBusiness.hashCode()), this.jdField_a_of_type_JavaLangString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentBusiness.9
 * JD-Core Version:    0.7.0.1
 */