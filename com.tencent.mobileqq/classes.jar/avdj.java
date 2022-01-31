import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.FeedsProtocol.GetMediaDetailReq;
import com.tencent.pb.now.ilive_feeds_like.FeedsLikeReq;
import com.tencent.pb.now.ilive_feeds_like.FeedsUnLikeReq;
import com.tencent.pb.now.ilive_feeds_source.CollectFeedsDataReq;
import com.tencent.pb.now.ilive_new_anchor_follow_interface.FollowActionReq;
import com.tencent.pb.now.ilive_short_video_label.GetShortVideoVideoLabelReq;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0xada.oidb_0xada.ReqBody;

public class avdj
{
  AppInterface a = null;
  
  public avdj(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
  }
  
  private boolean a(oidb_0xada.ReqBody paramReqBody)
  {
    paramReqBody.uid.set(Long.parseLong(this.a.getCurrentAccountUin()));
    paramReqBody.tinyid.set(Long.parseLong(this.a.getCurrentAccountUin()));
    Object localObject = (TicketManager)this.a.getManager(2);
    String str = ((TicketManager)localObject).getA2(this.a.getCurrentAccountUin());
    localObject = ((TicketManager)localObject).getSkey(this.a.getCurrentAccountUin());
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramReqBody.a2.set(str);
      paramReqBody.platform.set(1);
      paramReqBody.version.set("8.3.5");
      paramReqBody.original_id.set(this.a.getCurrentAccountUin());
      paramReqBody.original_key.set((String)localObject);
      paramReqBody.original_id_type.set(1);
      return true;
    }
    return false;
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean, avdq paramavdq)
  {
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    ilive_new_anchor_follow_interface.FollowActionReq localFollowActionReq;
    PBUInt32Field localPBUInt32Field;
    if (a(localReqBody))
    {
      localReqBody.cmd.set(536);
      localReqBody.subcmd.set(64);
      localFollowActionReq = new ilive_new_anchor_follow_interface.FollowActionReq();
      localFollowActionReq.anchor_uin.set(paramLong1);
      localFollowActionReq.client_type.set(401);
      localFollowActionReq.source.set(paramInt2);
      localPBUInt32Field = localFollowActionReq.action;
      if (!paramBoolean) {
        break label166;
      }
    }
    label166:
    for (paramInt2 = 1;; paramInt2 = 2)
    {
      localPBUInt32Field.set(paramInt2);
      localFollowActionReq.anchor_nowid.set(paramLong2);
      localFollowActionReq.id_type.set(paramInt1);
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localFollowActionReq.toByteArray()));
      mzy.a(this.a, new avdo(this, paramavdq), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
      return;
    }
  }
  
  public void a(long paramLong, String paramString, avdq paramavdq)
  {
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (a(localReqBody))
    {
      localReqBody.cmd.set(30481);
      localReqBody.subcmd.set(1);
      ilive_short_video_label.GetShortVideoVideoLabelReq localGetShortVideoVideoLabelReq = new ilive_short_video_label.GetShortVideoVideoLabelReq();
      if (!TextUtils.isEmpty(paramString)) {
        localGetShortVideoVideoLabelReq.feed_id.set(ByteStringMicro.copyFromUtf8(paramString));
      }
      localGetShortVideoVideoLabelReq.uid.set(paramLong);
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localGetShortVideoVideoLabelReq.toByteArray()));
      mzy.a(this.a, new avdp(this, paramavdq), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
    }
  }
  
  public void a(String paramString, avdq paramavdq)
  {
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (a(localReqBody))
    {
      localReqBody.cmd.set(24640);
      localReqBody.subcmd.set(3);
      ilive_feeds_source.CollectFeedsDataReq localCollectFeedsDataReq = new ilive_feeds_source.CollectFeedsDataReq();
      localCollectFeedsDataReq.client_type.set(2);
      localCollectFeedsDataReq.feeds_id.set(ByteStringMicro.copyFromUtf8(paramString));
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localCollectFeedsDataReq.toByteArray()));
      mzy.a(this.a, new avdl(this, paramavdq), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
    }
  }
  
  public void a(String paramString, avdq paramavdq, Bundle paramBundle)
  {
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (a(localReqBody))
    {
      localReqBody.cmd.set(24640);
      localReqBody.subcmd.set(1);
      ilive_feeds_like.FeedsLikeReq localFeedsLikeReq = new ilive_feeds_like.FeedsLikeReq();
      localFeedsLikeReq.id.set(ByteStringMicro.copyFromUtf8(paramString));
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localFeedsLikeReq.toByteArray()));
      mzy.a(this.a, new avdk(this, paramavdq), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, paramBundle, 0L);
    }
  }
  
  public void b(String paramString, avdq paramavdq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("getMediaDetailInfo", 2, "mQueryString = " + paramString);
    }
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (a(localReqBody))
    {
      localReqBody.cmd.set(30577);
      localReqBody.subcmd.set(1);
      FeedsProtocol.GetMediaDetailReq localGetMediaDetailReq = new FeedsProtocol.GetMediaDetailReq();
      localGetMediaDetailReq.querystring.set(ByteStringMicro.copyFrom(paramString.getBytes()));
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localGetMediaDetailReq.toByteArray()));
      mzy.a(this.a, new avdn(this, paramString, paramavdq), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
    }
  }
  
  public void b(String paramString, avdq paramavdq, Bundle paramBundle)
  {
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (a(localReqBody))
    {
      localReqBody.cmd.set(24640);
      localReqBody.subcmd.set(2);
      ilive_feeds_like.FeedsUnLikeReq localFeedsUnLikeReq = new ilive_feeds_like.FeedsUnLikeReq();
      localFeedsUnLikeReq.id.set(ByteStringMicro.copyFromUtf8(paramString));
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localFeedsUnLikeReq.toByteArray()));
      mzy.a(this.a, new avdm(this, paramavdq), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, paramBundle, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avdj
 * JD-Core Version:    0.7.0.1
 */