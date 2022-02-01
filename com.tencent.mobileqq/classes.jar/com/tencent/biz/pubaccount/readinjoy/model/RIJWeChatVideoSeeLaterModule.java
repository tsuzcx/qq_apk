package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.protocol.RIJPBFieldUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xf1f.oidb_cmd0xf1f.ArticleItem;
import tencent.im.oidb.cmd0xf1f.oidb_cmd0xf1f.ReqBody;
import tencent.im.oidb.cmd0xf1f.oidb_cmd0xf1f.RspBody;

public class RIJWeChatVideoSeeLaterModule
  extends ReadInJoyEngineModule
{
  private List<RIJWeChatVideoSeeLaterModule.WeChatVideoSeeLaterOptCallback> a;
  
  public RIJWeChatVideoSeeLaterModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  public static oidb_cmd0xf1f.ReqBody a(List<RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    oidb_cmd0xf1f.ReqBody localReqBody = new oidb_cmd0xf1f.ReqBody();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem localWeChatVideoArticleItem = (RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem)paramList.next();
      oidb_cmd0xf1f.ArticleItem localArticleItem = new oidb_cmd0xf1f.ArticleItem();
      localArticleItem.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(localWeChatVideoArticleItem.jdField_a_of_type_JavaLangString));
      localArticleItem.uint64_feeds_id.set(localWeChatVideoArticleItem.jdField_a_of_type_Long);
      localArticleItem.uint32_play_time.set(localWeChatVideoArticleItem.jdField_a_of_type_Int);
      localArticleItem.uint32_duration.set(localWeChatVideoArticleItem.b);
      localArrayList.add(localArticleItem);
    }
    localReqBody.rpt_article_item.set(localArrayList);
    localReqBody.opt_type.set(1);
    return localReqBody;
  }
  
  private void b(int paramInt)
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((RIJWeChatVideoSeeLaterModule.WeChatVideoSeeLaterOptCallback)localIterator.next()).a(paramInt);
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xf1f.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i != 0)
    {
      QLog.d("RIJUGCAccountCreateModule", 1, "handleWeChatVideoSeeLater result = " + i);
      return;
    }
    i = RIJPBFieldUtils.a(paramToServiceMsg.uint32_result);
    b(i);
    QLog.d("RIJUGCAccountCreateModule", 1, "handleWeChatVideoSeeLater uint32_result = " + i);
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (((Integer)paramToServiceMsg.getAttribute("KEY_SEE_LATER_OPT_TYPE")).intValue() == 1) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(List<RIJWeChatVideoSeeLaterModule.WeChatVideoArticleItem> paramList)
  {
    paramList = a(paramList);
    if (paramList == null)
    {
      QLog.d("RIJUGCAccountCreateModule", 1, "requestUgcAccountCreate weChatVideoArticleItemList is empty!");
      return;
    }
    paramList = ReadInJoyOidbHelper.a("OidbSvc.0xf1f", 3871, 0, paramList.toByteArray());
    paramList.addAttribute("KEY_SEE_LATER_OPT_TYPE", Integer.valueOf(1));
    a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.RIJWeChatVideoSeeLaterModule
 * JD-Core Version:    0.7.0.1
 */