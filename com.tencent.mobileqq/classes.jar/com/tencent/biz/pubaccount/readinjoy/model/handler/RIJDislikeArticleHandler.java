package com.tencent.biz.pubaccount.readinjoy.model.handler;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFHandlerUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeParam;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeResult;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.DislikeParam;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.ReqBody;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.RspBody;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.UserDisLike;

public class RIJDislikeArticleHandler
  extends RIJBaseArticleInfoHandler
{
  public int a;
  public List<DislikeResult> a;
  
  public RIJDislikeArticleHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  private oidb_cmd0x46f.DislikeParam a(DislikeParam paramDislikeParam)
  {
    oidb_cmd0x46f.DislikeParam localDislikeParam = new oidb_cmd0x46f.DislikeParam();
    localDislikeParam.uint64_articleid.set(paramDislikeParam.jdField_a_of_type_Long);
    localDislikeParam.uint32_reasonid.set(paramDislikeParam.jdField_a_of_type_Int);
    localDislikeParam.uint64_feeds_id.set(paramDislikeParam.b);
    localDislikeParam.uint64_biu_uin.set(paramDislikeParam.c);
    localDislikeParam.uint64_topic_id.set(paramDislikeParam.d);
    if ((paramDislikeParam.jdField_a_of_type_JavaLangString != null) && (paramDislikeParam.jdField_a_of_type_JavaLangString.length() > 0)) {
      localDislikeParam.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(paramDislikeParam.jdField_a_of_type_JavaLangString));
    }
    Object localObject1;
    Object localObject2;
    if ((paramDislikeParam.jdField_a_of_type_JavaUtilList != null) && (paramDislikeParam.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localObject1 = paramDislikeParam.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        localDislikeParam.rpt_uint64_tagid.add(localObject2);
      }
    }
    if ((paramDislikeParam.jdField_a_of_type_JavaUtilArrayList != null) && (paramDislikeParam.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      paramDislikeParam = paramDislikeParam.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDislikeParam.hasNext())
      {
        localObject1 = (DislikeInfo)paramDislikeParam.next();
        localObject2 = new oidb_cmd0x46f.UserDisLike();
        ((oidb_cmd0x46f.UserDisLike)localObject2).bytes_dislike_account_id.set(ByteStringMicro.copyFromUtf8(((DislikeInfo)localObject1).b));
        ((oidb_cmd0x46f.UserDisLike)localObject2).type.set(((DislikeInfo)localObject1).jdField_a_of_type_Int);
        ((oidb_cmd0x46f.UserDisLike)localObject2).uint64_dislike_tagid.set(((DislikeInfo)localObject1).jdField_a_of_type_Long);
        ((oidb_cmd0x46f.UserDisLike)localObject2).bytes_dislike_tag_name.set(ByteStringMicro.copyFromUtf8(((DislikeInfo)localObject1).jdField_a_of_type_JavaLangString));
        localDislikeParam.rpt_user_dislike_list.add((MessageMicro)localObject2);
      }
    }
    return localDislikeParam;
  }
  
  private void a(int paramInt, List<DislikeResult> paramList)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new RIJDislikeArticleHandler.1(this, paramInt, paramList));
  }
  
  public void a(long paramLong, List<DislikeParam> paramList)
  {
    oidb_cmd0x46f.ReqBody localReqBody = new oidb_cmd0x46f.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0x46f.DislikeParam localDislikeParam = a((DislikeParam)paramList.next());
      localReqBody.rpt_param_list.add(localDislikeParam);
    }
    paramList = ReadInJoyOidbHelper.a("OidbSvc.0x46f", 1135, 0, localReqBody.toByteArray());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramList);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0x46f.RspBody();
    int j = 0;
    int i = 0;
    if (ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0)
    {
      if (paramToServiceMsg.uint32_fail_count.has()) {
        i = paramToServiceMsg.uint32_fail_count.get();
      }
      j = i;
      if (!paramToServiceMsg.rpt_result_list.has()) {}
    }
    for (paramToServiceMsg = ReadInJoyMSFHandlerUtils.c(paramToServiceMsg.rpt_result_list.get());; paramToServiceMsg = null)
    {
      a(i, paramToServiceMsg);
      return;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.handler.RIJDislikeArticleHandler
 * JD-Core Version:    0.7.0.1
 */