package com.tencent.biz.pubaccount.api.impl;

import KQQ.ReqItem;
import KQQ.RespItem;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowListReq;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl;
import com.tencent.biz.subscribe.servlet.CertifiedAccountAbstractServlet;
import com.tencent.mobileqq.mp.mobileqq_mp.GetUserFollowListRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.WupUtil;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;

public class PublicAccountHandlerImpl$PublicAccountCheckUpdateItem
  implements CheckUpdateItemInterface
{
  public PublicAccountHandlerImpl$PublicAccountCheckUpdateItem(PublicAccountHandlerImpl paramPublicAccountHandlerImpl) {}
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a(int paramInt)
  {
    ReqItem localReqItem = new ReqItem();
    localReqItem.cOperType = 0;
    localReqItem.eServiceID = 102;
    boolean bool = PublicAccountConfigUtilImpl.isGetFollowListUseNewProtocol();
    long l1 = PublicAccountHandlerImpl.access$100(this.a, bool);
    long l2 = PublicAccountHandlerImpl.access$200(this.a, bool);
    Object localObject2 = PublicAccountHandlerImpl.access$300(this.a);
    if (bool)
    {
      localObject1 = new CertifiedAccountRead.StGetFollowListReq();
      ((CertifiedAccountRead.StGetFollowListReq)localObject1).seq.set(Utils.a(l1));
      ((CertifiedAccountRead.StGetFollowListReq)localObject1).count.set(Utils.a(1L));
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((CertifiedAccountRead.StGetFollowListReq)localObject1).attach_info.set((String)localObject2);
      }
      localObject2 = new PROTOCAL.StQWebReq();
      ((PROTOCAL.StQWebReq)localObject2).Seq.set(-1L);
      ((PROTOCAL.StQWebReq)localObject2).qua.set(QUA.getQUA3());
      ((PROTOCAL.StQWebReq)localObject2).deviceInfo.set(PlatformInfor.g().getDeviceInfor());
      ((PROTOCAL.StQWebReq)localObject2).busiBuff.set(ByteStringMicro.copyFrom(((CertifiedAccountRead.StGetFollowListReq)localObject1).toByteArray()));
      localObject1 = CertifiedAccountAbstractServlet.a();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((PROTOCAL.StQWebReq)localObject2).traceid.set((String)localObject1);
      }
      localObject2 = ((PROTOCAL.StQWebReq)localObject2).toByteArray();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      localReqItem.vecParam = WupUtil.a((byte[])localObject1);
      return localReqItem;
    }
    Object localObject1 = new mobileqq_mp.GetUserFollowListRequest();
    ((mobileqq_mp.GetUserFollowListRequest)localObject1).follow_seqno.set((int)l1);
    ((mobileqq_mp.GetUserFollowListRequest)localObject1).public_account_seqno.set((int)l2);
    ((mobileqq_mp.GetUserFollowListRequest)localObject1).begin.set(0);
    ((mobileqq_mp.GetUserFollowListRequest)localObject1).limit.set(1);
    ((mobileqq_mp.GetUserFollowListRequest)localObject1).version.set(1);
    ((mobileqq_mp.GetUserFollowListRequest)localObject1).is_increment.set(true);
    localReqItem.vecParam = WupUtil.a(((mobileqq_mp.GetUserFollowListRequest)localObject1).toByteArray());
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if ((paramRespItem.eServiceID == 102) && (paramRespItem.cResult == 0)) {
      this.a.setNotNeedUpdate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl.PublicAccountCheckUpdateItem
 * JD-Core Version:    0.7.0.1
 */