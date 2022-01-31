package com.tencent.mobileqq.arcard;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipListPb.ReqBody;
import com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipListPb.RspBody;
import com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipSendVideoPb.ReqBody;
import com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipSendVideoPb.RspBody;
import com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipSendVideoPb.shareInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ARRelationShipHandler
  extends BusinessHandler
{
  public ARRelationShipHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = new ARRelationShipListPb.RspBody();
      int i = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
      paramFromServiceMsg = paramFromServiceMsg.extraData.getString("str_error_msg");
      if (QLog.isColorLevel()) {
        QLog.d("ARRelationShipHandler", 2, "handleStartActivity, result=" + i + ", errMsg=" + paramFromServiceMsg + ", ");
      }
      a(1, true, new Object[] { Integer.valueOf(i), paramToServiceMsg });
      return;
    }
    a(1, true, new Object[] { Integer.valueOf(-1), "网络请求超时，\n请稍后再试" });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      int i = a(paramFromServiceMsg, paramObject, new ARRelationShipSendVideoPb.RspBody());
      paramToServiceMsg = paramFromServiceMsg.extraData.getString("str_error_msg");
      if (QLog.isColorLevel()) {
        QLog.d("ARRelationShipHandler", 2, "handleStartActivity, result=" + i + ", errMsg=" + paramToServiceMsg + ", tips=" + null);
      }
      a(2, true, new Object[] { Integer.valueOf(i), null });
      return;
    }
    a(2, true, new Object[] { Integer.valueOf(-1), "网络请求超时，\n请稍后再试" });
  }
  
  protected Class a()
  {
    return ARCardObserver.class;
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, List paramList, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    QLog.d("ARRelationShipHandler", 1, "sendARRelationShip");
    ARRelationShipSendVideoPb.ReqBody localReqBody = new ARRelationShipSendVideoPb.ReqBody();
    ARRelationShipSendVideoPb.shareInfo localshareInfo = new ARRelationShipSendVideoPb.shareInfo();
    localshareInfo.uint64_from_uin.set(paramLong1);
    PBEnumField localPBEnumField = localshareInfo.enum_content_type;
    if (paramInt1 == 1) {}
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      localPBEnumField.set(paramInt1);
      localshareInfo.uint64_topic_id.set(paramLong2);
      if (!TextUtils.isEmpty(paramString1)) {
        localshareInfo.uint64_share_id.set(Long.parseLong(paramString1));
      }
      localshareInfo.uint64_create_time.set(System.currentTimeMillis());
      if (!TextUtils.isEmpty(paramString3)) {
        localshareInfo.str_cover_url.set(paramString3);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localshareInfo.str_video_url.set(paramString2);
      }
      if (!TextUtils.isEmpty(paramString4)) {
        localshareInfo.str_desc.set(paramString4);
      }
      if (!TextUtils.isEmpty(paramString5)) {
        paramString1 = paramString5;
      }
      try
      {
        paramString2 = paramString5.replaceAll("&", "&amp;");
        paramString1 = paramString2;
        paramString2 = paramString2.replaceAll("<", "&lt;");
        paramString1 = paramString2;
        paramString2 = paramString2.replaceAll(">", "&gt;");
        paramString1 = paramString2;
        paramString2 = paramString2.replaceAll("'", "&apos;");
        paramString1 = paramString2;
        paramString2 = paramString2.replaceAll("\"", "&quot;");
        paramString1 = paramString2;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          QLog.d("ARRelationShipHandler", 1, "msgtitle :" + paramString2.getMessage());
        }
      }
      localshareInfo.str_msg_title.set(paramString1);
      if (!TextUtils.isEmpty(paramString6)) {
        localshareInfo.str_msg_summary.set(paramString6);
      }
      if (!TextUtils.isEmpty(paramString7)) {
        localshareInfo.str_msg_picture_cover.set(paramString7);
      }
      localshareInfo.str_msg_url.set(paramString8);
      if (paramInt2 != 0) {
        localshareInfo.uint32_duration.set(paramInt2);
      }
      if (paramInt3 != 0) {
        localshareInfo.uint32_size.set(paramInt3);
      }
      localReqBody.msg_share_info.set(localshareInfo);
      localReqBody.rpt_uint64_to_uin.set(paramList);
      paramString1 = a("OidbSvc.0xb12", 2834, 0, localReqBody.toByteArray());
      paramString1.addAttribute("action", Integer.valueOf(2));
      b(paramString1);
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      return;
      str = paramFromServiceMsg.getServiceCmd();
      if ("OidbSvc.0xb13".equals(str))
      {
        i = ((Integer)paramToServiceMsg.getAttribute("action", Integer.valueOf(0))).intValue();
        switch (i)
        {
        default: 
          QLog.d("ARRelationShipHandler", 1, "onReceive switch default, action=" + i);
          return;
        case 1: 
          b(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xb12".equals(str));
    int i = ((Integer)paramToServiceMsg.getAttribute("action", Integer.valueOf(0))).intValue();
    switch (i)
    {
    default: 
      QLog.d("ARRelationShipHandler", 1, "onReceive switch default, action=" + i);
      return;
    }
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString1, boolean paramBoolean, int paramInt1, int paramInt2, String paramString2, String paramString3, byte[] paramArrayOfByte, int paramInt3)
  {
    QLog.d("ARRelationShipHandler", 1, "getARRelationShipList");
    ARRelationShipListPb.ReqBody localReqBody = new ARRelationShipListPb.ReqBody();
    localReqBody.uint32_req_count.set(paramInt2);
    localReqBody.uint64_topic_id.set(Long.parseLong(paramString1));
    if (paramArrayOfByte != null) {
      localReqBody.bytes_req_page_cookies.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    if (!paramBoolean)
    {
      localReqBody.uint64_share_id.set(Long.parseLong(paramString3));
      localReqBody.uint32_req_list_type.set(1);
      paramString1 = new ArrayList();
      paramString1.add(Long.valueOf(Long.parseLong(paramString2)));
      localReqBody.rpt_uint64_peer_uin.set(paramString1);
      localReqBody.uint32_send_recv_flag.set(paramInt3);
    }
    for (;;)
    {
      paramString1 = a("OidbSvc.0xb13", 2835, 0, localReqBody.toByteArray());
      paramString1.addAttribute("action", Integer.valueOf(1));
      b(paramString1);
      return;
      localReqBody.uint32_req_list_type.set(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARRelationShipHandler
 * JD-Core Version:    0.7.0.1
 */