package com.tencent.biz.pubaccount.util;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.ReqBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.RspBody;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.ControlParam;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.FeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.ReqBody;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.RspBody;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfo;

public class VideoPlayDianZanHandler
  extends BusinessHandler
{
  static final String a = "Q.pubaccount.video." + VideoPlayDianZanObserver.class.getSimpleName();
  
  public VideoPlayDianZanHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_cmd0x8c8.RspBody();
    int k = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    paramObject = new Bundle();
    paramToServiceMsg = "";
    if (k == 0)
    {
      if ((((oidb_cmd0x8c8.RspBody)localObject).rpt_social_feeds_info.has()) && (((oidb_cmd0x8c8.RspBody)localObject).rpt_social_feeds_info.get() != null))
      {
        localObject = ((oidb_cmd0x8c8.RspBody)localObject).rpt_social_feeds_info.get().iterator();
        int i = 2;
        paramFromServiceMsg = paramToServiceMsg;
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break label311;
        }
        oidb_cmd0x8c8.FeedsInfo localFeedsInfo = (oidb_cmd0x8c8.FeedsInfo)((Iterator)localObject).next();
        if ((localFeedsInfo.bytes_rowkey.has()) && (localFeedsInfo.bytes_rowkey.get() != null))
        {
          paramFromServiceMsg = localFeedsInfo.bytes_rowkey.get().toStringUtf8();
          label136:
          if ((!localFeedsInfo.has()) || (localFeedsInfo.get() == null) || (!localFeedsInfo.msg_social_fees_info.has()) || (localFeedsInfo.msg_social_fees_info.get() == null)) {
            break label288;
          }
          paramToServiceMsg = (oidb_cmd0x8c8.SocializeFeedsInfo)localFeedsInfo.msg_social_fees_info.get();
          if (!paramToServiceMsg.uint32_myself_like_status.has()) {
            break label273;
          }
          j = paramToServiceMsg.uint32_myself_like_status.get();
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d(a, 2, "getFavoriteState，faviriteState为:" + j);
            i = j;
          }
        }
        label273:
        label288:
        for (;;)
        {
          paramToServiceMsg = paramFromServiceMsg;
          break;
          paramFromServiceMsg = paramToServiceMsg;
          if (!QLog.isColorLevel()) {
            break label136;
          }
          QLog.e(a, 2, "getFavoriteState, 返回的articleId空");
          paramFromServiceMsg = paramToServiceMsg;
          break label136;
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "getFavoriteState，faviriteState为空");
          }
        }
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.e(a, 2, "getFavoriteState, 返回直接出错了");
    }
    int j = 2;
    paramFromServiceMsg = paramToServiceMsg;
    label311:
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "getFavoriteState articleId :" + paramFromServiceMsg + " faviriteState :" + j);
    }
    paramObject.putInt("VALUE_VIDEO_FAVORITE_STATE", j);
    paramObject.putString("VALUE_VIDEO_ARTICLE_ID", paramFromServiceMsg);
    if (k == 0) {}
    for (boolean bool = true;; bool = false)
    {
      super.a(1, bool, paramObject);
      return;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = true;
    paramToServiceMsg = new oidb_cmd0x83e.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0)
    {
      QLog.d(a, 1, "handle0x83eUpvoteAction result OK");
      if (QLog.isColorLevel())
      {
        if (paramToServiceMsg.uint64_feeds_id.has()) {
          QLog.d(a, 2, "upvote feeds id:" + paramToServiceMsg.uint64_feeds_id.get());
        }
        if (paramToServiceMsg.uint32_operation.has())
        {
          paramFromServiceMsg = a;
          paramObject = new StringBuilder().append("upvote status:");
          if (paramToServiceMsg.uint32_operation.get() != 2) {
            break label134;
          }
          QLog.d(paramFromServiceMsg, 2, bool);
        }
      }
    }
    label134:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        bool = false;
      }
    }
    QLog.d(a, 1, "handle0x83eUpvoteAction result wrong:" + i);
  }
  
  protected Class a()
  {
    return VideoPlayDianZanObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "handleGetPlayCount onReceive");
    }
    if (a(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      do
      {
        return;
        try
        {
          if (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x8c8")) {
            break;
          }
          b(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        catch (Exception paramToServiceMsg) {}
      } while (!QLog.isColorLevel());
      QLog.e(a, 2, "onReceive ERROR e=" + paramToServiceMsg.getMessage() + paramFromServiceMsg.getServiceCmd());
      return;
    } while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x83e"));
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    oidb_cmd0x8c8.ReqBody localReqBody = new oidb_cmd0x8c8.ReqBody();
    localReqBody.uint64_uin.set(Long.valueOf(ReadInJoyUtils.a()).longValue());
    localReqBody.uint32_version.set(1);
    localReqBody.rpt_bytes_rowkey.add(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new oidb_cmd0x8c8.ControlParam();
    paramString.uint32_need_like_count.set(1);
    paramString.uint32_need_basic_info.set(1);
    paramString.uint32_need_article_info.set(1);
    localReqBody.control_req_param.set(paramString);
    super.b(super.a("OidbSvc.0x8c8", 2248, 0, localReqBody.toByteArray()));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    oidb_cmd0x83e.ReqBody localReqBody = new oidb_cmd0x83e.ReqBody();
    localReqBody.uint64_uin.set(Long.valueOf(ReadInJoyUtils.a()).longValue());
    localReqBody.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(paramString));
    if (paramBoolean) {
      localReqBody.uint32_operation.set(2);
    }
    for (;;)
    {
      super.b(super.a("OidbSvc.0x83e", 2110, 0, localReqBody.toByteArray()));
      return;
      localReqBody.uint32_operation.set(3);
    }
  }
  
  protected boolean a(String paramString)
  {
    if (this.b == null)
    {
      this.b = new HashSet();
      this.b.add("OidbSvc.0x8c8");
      this.b.add("OidbSvc.0x83e");
    }
    return !this.b.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.VideoPlayDianZanHandler
 * JD-Core Version:    0.7.0.1
 */