import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageForLimitChatConfirm;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.extendfriend.bean.GroupInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.ReqBody;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.RspBody;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.StrangerInfo;
import com.tencent.pb.extendfriend.GetExtendFriendInfo.ReqBody;
import com.tencent.pb.profilecard.EditExtendFriendInfo.ReqBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import tencent.im.oidb.cmd0x5e3.oidb_0xb4a.GroupInfo;
import tencent.im.oidb.cmd0x5e3.oidb_0xb4a.ReqBody;
import tencent.im.oidb.cmd0x5e3.oidb_0xb4a.RspBody;
import tencent.im.oidb.cmd0xb9b.oidb_0xb9b.MatchInfo;
import tencent.im.oidb.cmd0xb9b.oidb_0xb9b.RspBody;
import tencent.im.oidb.cmd0xcb5.cmd0xcb5.ReqBody;
import tencent.im.oidb.cmd0xcb5.cmd0xcb5.RspBody;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.ReqBody;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.RspBody;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.MatchInfo;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.MatchUinData;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.ProfileTagInfo;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.ReqBody;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.RspBody;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.TagInfo;
import tencent.im.oidb.cmd0xe09.oidb_0xe09.OnlineInfo;
import tencent.im.oidb.cmd0xe09.oidb_0xe09.ReqBody;
import tencent.im.oidb.cmd0xe09.oidb_0xe09.RspBody;
import tencent.im.oidb.cmd0xe09.oidb_0xe09.reqItem;
import tencent.im.s2c.msgtype0x210.submsgtype0x128.submsgtype0x128.MsgBody;

public class aoet
  extends ajtb
{
  public static AtomicInteger a = new AtomicInteger(0);
  
  public aoet(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e("ExtendFriendHandler", 2, "un known op type");
    case 1: 
      return 11;
    case 2: 
      return 12;
    case 3: 
      return 13;
    case 4: 
      return 14;
    }
    return 15;
  }
  
  private long a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "unknown";
    }
    try
    {
      long l = Long.parseLong(paramString1);
      return l;
    }
    catch (NumberFormatException paramString1)
    {
      QLog.e("ExtendFriendHandler", 2, str + " parse err " + paramString1.toString());
    }
    return 0L;
  }
  
  private Card a(String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("ExtendFriendHandler", 1, "saveExtendFriendInfo uin is null");
      return null;
    }
    ajxl localajxl = (ajxl)this.app.getManager(51);
    Card localCard = localajxl.c(paramString1);
    localCard.declaration = paramString2;
    localCard.voiceUrl = paramString3;
    if (paramInt1 != 0) {
      localCard.popularity = paramInt1;
    }
    localCard.updateTime = paramLong;
    localCard.extendFriendVoiceDuration = paramInt2;
    localajxl.a(localCard);
    QLog.e("ExtendFriendHandler", 1, new Object[] { "saveExtendFriendInfo uin=%s declaration=%s voiceUrl=%s popularity=%d updateTime=%ld extendFriendVoiceDuration=%d", paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    return localCard;
  }
  
  private void a(List<Long> paramList1, int paramInt1, int paramInt2, List<Long> paramList2)
  {
    int i;
    awzy localawzy;
    Object localObject;
    if (paramList1 == null)
    {
      i = 0;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendHandler", 2, String.format("getExtendFriendOnlineState reqListSize=%s startIndex=%s count=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      localawzy = null;
      localObject = null;
    }
    for (;;)
    {
      try
      {
        if (this.app == null) {
          break label360;
        }
        localawzy = this.app.a();
        localObject = this.app.c();
      }
      catch (Exception paramList1)
      {
        Iterator localIterator;
        byte[] arrayOfByte;
        oidb_0xe09.reqItem localreqItem;
        QLog.e("ExtendFriendHandler", 1, "getExtendFriendOnlineState fail.", paramList1);
        return;
      }
      QLog.e("ExtendFriendHandler", 1, "getExtendFriendOnlineState invalid param.");
      return;
      i = paramList1.size();
      break;
      paramInt2 = Math.min(i - paramInt1, paramInt2);
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendHandler", 2, String.format("getExtendFriendOnlineState fixed count=%s", new Object[] { Integer.valueOf(paramInt2) }));
      }
      oidb_0xe09.ReqBody localReqBody = new oidb_0xe09.ReqBody();
      localIterator = paramList1.subList(paramInt1, paramInt1 + paramInt2).iterator();
      if (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        arrayOfByte = localawzy.c(String.valueOf(localLong), (String)localObject);
        if (arrayOfByte != null)
        {
          localreqItem = new oidb_0xe09.reqItem();
          localreqItem.uint64_uin.set(localLong.longValue());
          localreqItem.bytes_sig.set(ByteStringMicro.copyFrom(arrayOfByte));
          localReqBody.rpt_item.add(localreqItem);
        }
        else
        {
          QLog.w("ExtendFriendHandler", 1, String.format("getExtendFriendOnlineState get match chat sig fail. uin=%s", new Object[] { localLong }));
        }
      }
      else
      {
        localObject = makeOIDBPkg("OidbSvc.0xe09", 3593, 1, localReqBody.toByteArray());
        ((ToServiceMsg)localObject).addAttribute("reqList", paramList1);
        ((ToServiceMsg)localObject).addAttribute("startIndex", Integer.valueOf(paramInt1));
        ((ToServiceMsg)localObject).addAttribute("count", Integer.valueOf(paramInt2));
        ((ToServiceMsg)localObject).addAttribute("resultList", paramList2);
        sendPbReq((ToServiceMsg)localObject);
        return;
        label360:
        if ((i != 0) && (paramInt1 < i) && (paramInt2 > 0)) {
          if (localawzy != null) {}
        }
      }
    }
  }
  
  private void a(oidb_0xe03.MatchUinData paramMatchUinData, aofh paramaofh)
  {
    int j = 0;
    if ((paramMatchUinData == null) || (paramaofh == null))
    {
      QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "msg_match_uin_data || info is null. ");
      return;
    }
    Object localObject;
    label88:
    label116:
    int i;
    if (paramMatchUinData.uint32_age.has())
    {
      localObject = paramMatchUinData.uint32_age.get() + "";
      paramaofh.jdField_b_of_type_JavaLangString = ((String)localObject);
      if (!paramMatchUinData.bytes_constellation.has()) {
        break label457;
      }
      localObject = paramMatchUinData.bytes_constellation.get().toStringUtf8();
      paramaofh.jdField_c_of_type_JavaLangString = ((String)localObject);
      if (!paramMatchUinData.bytes_city.has()) {
        break label465;
      }
      localObject = paramMatchUinData.bytes_city.get().toStringUtf8();
      paramaofh.d = ((String)localObject);
      if (!paramMatchUinData.bytes_school.has()) {
        break label473;
      }
      localObject = paramMatchUinData.bytes_school.get().toStringUtf8();
      label144:
      paramaofh.e = ((String)localObject);
      if (!paramMatchUinData.bytes_company.has()) {
        break label481;
      }
      localObject = paramMatchUinData.bytes_company.get().toStringUtf8();
      label172:
      paramaofh.f = ((String)localObject);
      if (!paramMatchUinData.bytes_declaration.has()) {
        break label489;
      }
      localObject = paramMatchUinData.bytes_declaration.get().toStringUtf8();
      label200:
      paramaofh.g = ((String)localObject);
      if (!paramMatchUinData.bytes_voice_url.has()) {
        break label497;
      }
      localObject = paramMatchUinData.bytes_voice_url.get().toStringUtf8();
      label228:
      paramaofh.h = ((String)localObject);
      if (!paramMatchUinData.uint32_voice_duration.has()) {
        break label505;
      }
      i = paramMatchUinData.uint32_voice_duration.get();
      label252:
      paramaofh.jdField_b_of_type_Int = i;
      if (!paramMatchUinData.bytes_long_nick.has()) {
        break label510;
      }
      localObject = paramMatchUinData.bytes_long_nick.get().toByteArray();
      label279:
      if (localObject != null) {
        paramaofh.i = RichStatus.parseStatus((byte[])localObject).getPlainText();
      }
      if (!paramMatchUinData.uint32_sex.has()) {
        break label516;
      }
      paramaofh.jdField_a_of_type_Int = paramMatchUinData.uint32_sex.get();
    }
    for (;;)
    {
      localObject = new ArrayList();
      if (!paramMatchUinData.rpt_tag.has()) {
        break label534;
      }
      i = j;
      while (i < paramMatchUinData.rpt_tag.size())
      {
        if (((oidb_0xe03.ProfileTagInfo)paramMatchUinData.rpt_tag.get(i)).bytes_tag.has())
        {
          j = ((oidb_0xe03.ProfileTagInfo)paramMatchUinData.rpt_tag.get(i)).uint32_same_flag.get();
          String str = ((oidb_0xe03.ProfileTagInfo)paramMatchUinData.rpt_tag.get(i)).bytes_tag.get().toStringUtf8();
          aogl localaogl = new aogl();
          localaogl.jdField_a_of_type_Int = j;
          localaogl.jdField_a_of_type_JavaLangString = str;
          ((ArrayList)localObject).add(localaogl);
        }
        i += 1;
      }
      localObject = "";
      break;
      label457:
      localObject = "";
      break label88;
      label465:
      localObject = "";
      break label116;
      label473:
      localObject = "";
      break label144;
      label481:
      localObject = "";
      break label172;
      label489:
      localObject = "";
      break label200;
      label497:
      localObject = "";
      break label228;
      label505:
      i = 0;
      break label252;
      label510:
      localObject = null;
      break label279;
      label516:
      paramaofh.jdField_a_of_type_Int = 0;
      QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "mGender  is null. set 0  ");
    }
    label534:
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "ChatFriendInfo. " + paramaofh.toString());
    }
    paramaofh.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      Object localObject = new oidb_0xe09.RspBody();
      i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      if (i != 0) {
        break label265;
      }
      paramFromServiceMsg = new ArrayList();
      try
      {
        if (!((oidb_0xe09.RspBody)localObject).rpt_online_info.has()) {
          break label230;
        }
        paramObject = ((oidb_0xe09.RspBody)localObject).rpt_online_info.get().iterator();
        while (paramObject.hasNext())
        {
          localObject = (oidb_0xe09.OnlineInfo)paramObject.next();
          if (((oidb_0xe09.OnlineInfo)localObject).uint64_friend_uin.has()) {
            paramFromServiceMsg.add(Long.valueOf(((oidb_0xe09.OnlineInfo)localObject).uint64_friend_uin.get()));
          }
        }
        QLog.e("ExtendFriendHandler", 1, "handleGetExtendFriendOnlineState fail.", paramObject);
      }
      catch (Exception paramObject) {}
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        int i;
        label230:
        paramFromServiceMsg = null;
        label265:
        continue;
        label366:
        continue;
        label369:
        continue;
        label372:
        if (paramObject == null) {
          i = 0;
        }
      }
    }
    if (paramToServiceMsg != null) {}
    for (;;)
    {
      try
      {
        paramObject = (ArrayList)paramToServiceMsg.getAttribute("reqList");
        j = ((Integer)paramToServiceMsg.getAttribute("startIndex")).intValue();
        k = ((Integer)paramToServiceMsg.getAttribute("count")).intValue();
        paramToServiceMsg = (ArrayList)paramToServiceMsg.getAttribute("resultList");
        if (paramToServiceMsg != null) {
          break label366;
        }
        paramToServiceMsg = new ArrayList();
        if ((paramFromServiceMsg == null) || (paramFromServiceMsg.isEmpty())) {
          break label372;
        }
        paramToServiceMsg.addAll(paramFromServiceMsg);
      }
      catch (Exception paramToServiceMsg)
      {
        int j;
        int k;
        QLog.e("ExtendFriendHandler", 1, "handleGetExtendFriendOnlineState fail.", paramToServiceMsg);
        notifyUI(19, false, null);
        return;
      }
      if (j + k >= i) {
        continue;
      }
      a(paramObject, j + k, k, paramToServiceMsg);
      return;
      if (!QLog.isColorLevel()) {
        break label369;
      }
      QLog.d("ExtendFriendHandler", 2, String.format("handleGetExtendFriendOnlineState size=%s", new Object[] { Integer.valueOf(paramFromServiceMsg.size()) }));
      break;
      QLog.e("ExtendFriendHandler", 1, String.format("handleGetExtendFriendOnlineState result=%s", new Object[] { Integer.valueOf(i) }));
      paramFromServiceMsg = null;
      continue;
      i = paramObject.size();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, String.format("handleGetExtendFriendOnlineState request finished. resultList=%s", new Object[] { paramToServiceMsg }));
    }
    notifyUI(19, true, paramToServiceMsg);
  }
  
  public int a(String paramString, boolean paramBoolean)
  {
    QLog.i("ExtendFriendHandler", 1, String.format("getExtendFriendInfo uin=%s", new Object[] { paramString }));
    int i = a.incrementAndGet();
    try
    {
      Object localObject = new GetExtendFriendInfo.ReqBody();
      ((GetExtendFriendInfo.ReqBody)localObject).uint64_uin.set(Long.parseLong(paramString));
      localObject = makeOIDBPkg("OidbSvc.0xb51", 2897, 0, ((GetExtendFriendInfo.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString);
      ((ToServiceMsg)localObject).extraData.putBoolean("onlyStrangerInfo", paramBoolean);
      ((ToServiceMsg)localObject).extraData.putInt("getStrangerInfoSeq", i);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      sendPbReq((ToServiceMsg)localObject);
      return i;
    }
    catch (Exception paramString)
    {
      QLog.e("ExtendFriendHandler", 1, "getExtendFriendInfo exception:" + paramString.getMessage());
    }
    return i;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "requestLimitChatSettingOnPlusPanel");
    }
    try
    {
      sendPbReq(makeOIDBPkg("OidbSvc.0xdb1", 3505, 1, new oidb_0xdb1.ReqBody().toByteArray()));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "requestLimitChatSettingOnPlusPanel. error = " + localNumberFormatException);
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    Object localObject1;
    int i;
    int j;
    long l1;
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForLimitChatConfirm)))
    {
      paramMessageRecord = (MessageForLimitChatConfirm)paramMessageRecord;
      if (paramMessageRecord != null)
      {
        localObject1 = new aofv();
        ((aofv)localObject1).jdField_a_of_type_Boolean = paramMessageRecord.bEnterMsg;
        ((aofv)localObject1).jdField_a_of_type_Int = paramMessageRecord.leaveChatType;
        ((aofv)localObject1).jdField_a_of_type_Long = paramMessageRecord.timeStamp;
        ((aofv)localObject1).jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
        ((aofv)localObject1).jdField_b_of_type_JavaLangString = paramMessageRecord.SenderNickName;
        ((aofv)localObject1).d = paramMessageRecord.c2cExpiredTime;
        ((aofv)localObject1).jdField_b_of_type_Int = paramMessageRecord.leftChatTime;
        ((aofv)localObject1).jdField_c_of_type_JavaLangString = paramMessageRecord.tipsWording;
        ((aofv)localObject1).jdField_c_of_type_Int = paramMessageRecord.matchExpiredTime;
        ((aofv)localObject1).jdField_b_of_type_Long = paramMessageRecord.readyTs;
        QLog.i("ExtendFriendHandlerExtendFriendLimitChat", 2, "HandleC2CConfirmOrCancelMsg  info：" + ((aofv)localObject1).toString());
        i = 1;
        j = i;
        if (!bbfh.b(paramMessageRecord.issend)) {
          l1 = paramMessageRecord.time;
        }
      }
    }
    label408:
    for (;;)
    {
      long l2;
      try
      {
        l2 = Long.valueOf(paramMessageRecord.frienduin).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.sendReadConfirm_PB", 2, String.format("HandleC2CConfirmMsg,uin: %s,  id: %d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) }));
        }
        if ((l1 == -1L) || (l1 == 0L)) {
          return;
        }
      }
      catch (NumberFormatException paramMessageRecord)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.msg.HandleC2CConfirmMsg sendReadConfirm_PB", 2, paramMessageRecord, new Object[0]);
        return;
      }
      paramMessageRecord = new msg_svc.PbMsgReadedReportReq();
      if (l2 != -1L)
      {
        Object localObject2 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject2).peer_uin.set(l2);
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject2).last_read_time.set((int)l1);
        localObject1 = new msg_svc.PbC2CReadedReportReq();
        ((msg_svc.PbC2CReadedReportReq)localObject1).pair_info.add((MessageMicro)localObject2);
        localObject2 = this.app.a().a().a();
        if (localObject2 != null) {
          ((msg_svc.PbC2CReadedReportReq)localObject1).sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject2));
        }
        paramMessageRecord.c2c_read_report.set((MessageMicro)localObject1);
        this.app.a().a("c2c_processor").a(paramMessageRecord);
        for (j = i;; j = 0)
        {
          if (j != 0) {
            break label408;
          }
          QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "HandleC2CConfirmMsg failed");
          return;
          i = 0;
          break;
        }
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramFromServiceMsg = "success";
      paramObject = paramToServiceMsg.extraData.getString("uin");
      String str1 = paramToServiceMsg.extraData.getString("declaration");
      String str2 = paramToServiceMsg.extraData.getString("url");
      int i = paramToServiceMsg.extraData.getInt("duration");
      a(paramObject, str1, str2, 0, NetConnInfoCenter.getServerTimeMillis(), i);
      bool = true;
      paramToServiceMsg = paramFromServiceMsg;
    }
    for (;;)
    {
      QLog.i("ExtendFriendHandler", 1, String.format("handleEditExtendFriendInfo %s", new Object[] { paramToServiceMsg }));
      notifyUI(1, bool, null);
      return;
      paramToServiceMsg = paramFromServiceMsg.getStringForLog();
      bool = false;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, "reportUser, uin: " + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ExtendFriendHandler", 1, "reportUser, uin is empty!");
      return;
    }
    try
    {
      cmd0xcb5.ReqBody localReqBody = new cmd0xcb5.ReqBody();
      localReqBody.uint64_uin.set(Long.valueOf(paramString).longValue());
      localReqBody.uint32_report_type.set(0);
      localReqBody.str_report_conent.set("");
      localReqBody.uint64_report_time.set(NetConnInfoCenter.getServerTimeMillis());
      sendPbReq(makeOIDBPkg("OidbSvc.0xcb5", 3253, 0, localReqBody.toByteArray()));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.d("ExtendFriendHandler", 1, "reportUser exception:", paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    QLog.i("ExtendFriendHandler", 1, String.format("editExtendFriendInfo uin=%s, declaration=%s, url=%s, duration=%d", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) }));
    if (!NetworkState.isNetworkConnected(this.app.getApp()))
    {
      bcql.a(this.app.getApp(), 1, 2131694608, 0).a();
      notifyUI(1, false, null);
      return;
    }
    try
    {
      Object localObject = new EditExtendFriendInfo.ReqBody();
      ((EditExtendFriendInfo.ReqBody)localObject).uint64_uin.set(Long.parseLong(paramString1));
      ((EditExtendFriendInfo.ReqBody)localObject).bytes_declaration.set(ByteStringMicro.copyFromUtf8(paramString2));
      ((EditExtendFriendInfo.ReqBody)localObject).bytes_voice_url.set(ByteStringMicro.copyFromUtf8(paramString3));
      ((EditExtendFriendInfo.ReqBody)localObject).uint32_voice_duration.set(paramInt);
      localObject = makeOIDBPkg("OidbSvc.0xb4b", 2891, 0, ((EditExtendFriendInfo.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString1);
      ((ToServiceMsg)localObject).extraData.putString("declaration", paramString2);
      ((ToServiceMsg)localObject).extraData.putString("url", paramString3);
      ((ToServiceMsg)localObject).extraData.putInt("duration", paramInt);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("ExtendFriendHandler", 1, "editExtendFriendInfo exception:" + paramString1.getMessage());
    }
  }
  
  public void a(String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, long paramLong, String paramString3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, String.format("getSquareStrangerList uin=%s reqCookies=%s reqCount=%s searchKey=%s ts=%d isConfigTag:%b", new Object[] { paramString1, paramArrayOfByte, Integer.valueOf(paramInt), paramString2, Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
    }
    for (;;)
    {
      try
      {
        localReqBody = new ExtendFriendSquareInfo.ReqBody();
        localReqBody.uint64_uin.set(Long.parseLong(paramString1));
        if (paramArrayOfByte == null) {
          break label313;
        }
        localReqBody.bytes_req_page_cookies.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      catch (Exception paramString1)
      {
        ExtendFriendSquareInfo.ReqBody localReqBody;
        QLog.e("ExtendFriendHandler", 1, "getSquareStrangerList fail.", paramString1);
        return;
      }
      if ((!TextUtils.isEmpty(paramString1)) && (!paramString3.equals(paramString1))) {
        localReqBody.str_keyword.set(ByteStringMicro.copyFromUtf8(paramString1));
      }
      localReqBody.uint32_req_num.set(paramInt);
      localReqBody.bytes_req_buff.set(ByteStringMicro.copyFrom(bhzt.a().a()));
      paramArrayOfByte = makeOIDBPkg("OidbSvc.0xb4c", 2892, 0, localReqBody.toByteArray());
      paramArrayOfByte.setTimeout(10000L);
      paramArrayOfByte.extraData.putLong("reqTs", paramLong);
      if (!TextUtils.isEmpty(paramString2)) {
        paramArrayOfByte.extraData.putString("searchKey", paramString2);
      }
      sendPbReq(paramArrayOfByte);
      if ((!TextUtils.isEmpty(paramString3)) && (paramString3.equals(paramString1)))
      {
        paramInt = 1;
        if (paramInt != 0) {
          break;
        }
        paramString1 = this.app;
        if (paramBoolean)
        {
          paramInt = 1;
          axqy.b(paramString1, "dc00898", "", "", "0X8009423", "0X8009423", paramInt, 0, "", "", paramString2, "");
          return;
          paramString1 = paramString2.trim();
        }
      }
      else
      {
        paramInt = 0;
        continue;
      }
      paramInt = 2;
      continue;
      label313:
      if (paramString2 == null) {
        paramString1 = null;
      }
    }
  }
  
  public void a(List<Long> paramList)
  {
    if (paramList != null) {
      a(paramList, 0, 50, null);
    }
  }
  
  public void a(submsgtype0x128.MsgBody paramMsgBody)
  {
    if (paramMsgBody != null)
    {
      aofu localaofu = new aofu();
      localaofu.jdField_a_of_type_JavaLangString = this.app.c();
      localaofu.jdField_a_of_type_ArrayOfByte = paramMsgBody.bytes_sig.get().toByteArray();
      String str;
      label91:
      long l;
      label116:
      int i;
      if (paramMsgBody.uint64_match_uin.has())
      {
        str = String.valueOf(paramMsgBody.uint64_match_uin.get());
        localaofu.jdField_b_of_type_JavaLangString = str;
        if (!paramMsgBody.bytes_tips_wording.has()) {
          break label427;
        }
        str = paramMsgBody.bytes_tips_wording.get().toStringUtf8();
        localaofu.jdField_c_of_type_JavaLangString = str;
        if (!paramMsgBody.uint64_time_stamp.has()) {
          break label435;
        }
        l = paramMsgBody.uint64_time_stamp.get();
        localaofu.jdField_a_of_type_Long = l;
        if (!paramMsgBody.uint32_match_expired_time.has()) {
          break label440;
        }
        i = paramMsgBody.uint32_match_expired_time.get();
        label140:
        localaofu.jdField_a_of_type_Int = i;
        if (!paramMsgBody.bytes_nick.has()) {
          break label445;
        }
        str = paramMsgBody.bytes_nick.get().toStringUtf8();
        label168:
        localaofu.d = str;
        if ((!paramMsgBody.msg_tag.has()) || (!paramMsgBody.msg_tag.uint32_tag_id.has())) {
          break label461;
        }
        localaofu.jdField_b_of_type_Int = paramMsgBody.msg_tag.uint32_tag_id.get();
        if (!paramMsgBody.msg_tag.bytes_tag.has()) {
          break label453;
        }
        str = paramMsgBody.msg_tag.bytes_tag.get().toStringUtf8();
        label241:
        localaofu.f = str;
        label248:
        if (!paramMsgBody.msg_match_uin_data.has()) {
          break label480;
        }
        localaofu.jdField_a_of_type_Aofh = new aofh();
        localaofu.jdField_a_of_type_Aofh.jdField_a_of_type_JavaLangString = localaofu.jdField_b_of_type_JavaLangString;
        a(paramMsgBody.msg_match_uin_data, localaofu.jdField_a_of_type_Aofh);
      }
      for (;;)
      {
        str = "";
        if (paramMsgBody.string_report_id.has()) {
          str = paramMsgBody.string_report_id.get();
        }
        paramMsgBody = str;
        if (TextUtils.isEmpty(str))
        {
          paramMsgBody = "0";
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "string_report_id EMPTY");
        }
        localaofu.e = paramMsgBody;
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleGetUnlimitMatchOfflinePush push matchInfo = ", localaofu });
        }
        paramMsgBody = (aojc)this.app.getManager(292);
        if (paramMsgBody != null) {
          paramMsgBody.a();
        }
        notifyUI(16, true, new Object[] { localaofu });
        return;
        str = "0";
        break;
        label427:
        str = "";
        break label91;
        label435:
        l = 0L;
        break label116;
        label440:
        i = 0;
        break label140;
        label445:
        str = "";
        break label168;
        label453:
        str = "";
        break label241;
        label461:
        localaofu.jdField_b_of_type_Int = 1;
        QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "msg_tag id empty in push");
        break label248;
        label480:
        QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "msg_match_uin_data in push");
      }
    }
    notifyUI(16, false, null);
  }
  
  public void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, String.format("getExtFrdGroupList start=%d count=%d loadMore:%b reqTs:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean2), Long.valueOf(paramLong) }));
    }
    try
    {
      Object localObject = new oidb_0xb4a.ReqBody();
      ((oidb_0xb4a.ReqBody)localObject).start.set(paramInt1);
      ((oidb_0xb4a.ReqBody)localObject).num.set(paramInt2);
      localObject = makeOIDBPkg("OidbSvc.0xb4a", 2890, 0, ((oidb_0xb4a.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putInt("fetch_start", paramInt1);
      ((ToServiceMsg)localObject).extraData.putInt("fetch_count", paramInt2);
      ((ToServiceMsg)localObject).extraData.putBoolean("fetch_loadmore", paramBoolean2);
      ((ToServiceMsg)localObject).extraData.putLong("fetch_reqTs", paramLong);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendHandler", 1, "getExtFrdGroupList fail.", localException);
    }
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "cancleUnlimitMatch. uin = " + paramString);
    }
    try
    {
      oidb_0xe03.ReqBody localReqBody = new oidb_0xe03.ReqBody();
      localReqBody.uint64_uin.set(a(paramString, "cancleUnlimitMatch"));
      localReqBody.enum_matchopcode.set(2);
      paramString = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, localReqBody.toByteArray());
      paramString.extraData.putInt("match_op", 2);
      sendPbReq(paramString);
      return true;
    }
    catch (NumberFormatException paramString)
    {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "requestMatch. error = " + paramString);
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "request Unlimit Match. uin = " + paramString + " Type= " + paramInt1 + " tag:" + paramInt2);
    try
    {
      oidb_0xe03.ReqBody localReqBody = new oidb_0xe03.ReqBody();
      localReqBody.uint64_uin.set(a(paramString, "requestUnlimitMatch"));
      localReqBody.enum_matchopcode.set(1);
      localReqBody.uint32_tag_id.set(paramInt2);
      localReqBody.uint32_sex.set(paramInt1);
      paramString = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, localReqBody.toByteArray());
      paramString.extraData.putInt("match_op", 1);
      sendPbReq(paramString);
      return true;
    }
    catch (NumberFormatException paramString)
    {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "requestMatch. error = " + paramString);
    }
    return false;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "requestMatch. uin = " + paramString + " bopen: " + paramBoolean);
    }
    try
    {
      oidb_0xe03.ReqBody localReqBody = new oidb_0xe03.ReqBody();
      localReqBody.uint64_uin.set(a(paramString, "setUnlimitMatchStatus"));
      if (paramBoolean) {
        localReqBody.uint32_switch.set(1);
      }
      for (;;)
      {
        localReqBody.enum_matchopcode.set(4);
        paramString = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, localReqBody.toByteArray());
        paramString.extraData.putInt("match_op", 4);
        paramString.extraData.putBoolean("open", paramBoolean);
        sendPbReq(paramString);
        return true;
        localReqBody.uint32_switch.set(0);
      }
      return false;
    }
    catch (NumberFormatException paramString)
    {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "requestMatch. error = " + paramString);
    }
  }
  
  public void b()
  {
    if (!asfl.a(this.app))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ExtendFriendHandler", 2, "calcMatchChatBoxUnreadCount isMatchChatRedPointSwitchOn false");
      }
      return;
    }
    if (!asfl.a(this.app, "matchchat_redpoint_show")) {
      asfl.a(this.app, "matchchat_redpoint_show", true);
    }
    c();
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new ExtendFriendSquareInfo.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    long l = paramToServiceMsg.extraData.getLong("reqTs", 0L);
    paramObject = paramToServiceMsg.extraData.getString("searchKey", null);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, String.format("handleGetSquareStrangerList resultCode=%s searchKey=%s ts=%d", new Object[] { Integer.valueOf(i), paramObject, Long.valueOf(l) }));
    }
    boolean bool1;
    byte[] arrayOfByte;
    boolean bool2;
    boolean bool3;
    int m;
    ArrayList localArrayList;
    Object localObject2;
    boolean bool4;
    label742:
    label757:
    label763:
    int n;
    label769:
    label775:
    label781:
    label787:
    label793:
    label799:
    int j;
    if (i == 0)
    {
      for (;;)
      {
        aogm localaogm;
        try
        {
          if (((ExtendFriendSquareInfo.RspBody)localObject1).uint32_over.get() != 1) {
            break label757;
          }
          bool1 = true;
          arrayOfByte = ((ExtendFriendSquareInfo.RspBody)localObject1).bytes_rsp_page_cookies.get().toByteArray();
          if (((ExtendFriendSquareInfo.RspBody)localObject1).uint32_is_profile_complete.get() != 1) {
            break label763;
          }
          bool2 = true;
          if (((ExtendFriendSquareInfo.RspBody)localObject1).uint32_is_show_card.get() != 1) {
            break label769;
          }
          bool3 = true;
          m = ((ExtendFriendSquareInfo.RspBody)localObject1).uint32_friend_max_votes.get();
          paramToServiceMsg = ((ExtendFriendSquareInfo.RspBody)localObject1).rpt_msg_stranger_info.get();
          localArrayList = new ArrayList();
          if ((paramToServiceMsg == null) || (paramToServiceMsg.size() <= 0)) {
            break;
          }
          localObject2 = paramToServiceMsg.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localStrangerInfo = (ExtendFriendSquareInfo.StrangerInfo)((Iterator)localObject2).next();
          localaogm = new aogm();
          localaogm.mUin = String.valueOf(localStrangerInfo.uint64_uin.get());
          localaogm.mNickName = localStrangerInfo.bytes_nick.get().toStringUtf8();
          localaogm.mGender = localStrangerInfo.uint32_gender.get();
          if (localStrangerInfo.uint32_is_my_like.get() != 1) {
            break label775;
          }
          bool4 = true;
          localaogm.mLiked = bool4;
          localaogm.mAvailLikeCount = localStrangerInfo.uint32_my_left_like_count.get();
          if (localStrangerInfo.uint32_addfri_status.get() != 1) {
            break label781;
          }
          bool4 = true;
          localaogm.mAddFriendVerified = bool4;
          localaogm.mPopularity = localStrangerInfo.uint32_popularity.get();
          localaogm.mDeclaration = localStrangerInfo.bytes_declaration.get().toStringUtf8();
          localaogm.mVoiceUrl = localStrangerInfo.bytes_voice_url.get().toStringUtf8();
          localaogm.mVoiceDuration = localStrangerInfo.uint32_voice_duration.get();
          if (localStrangerInfo.uint32_vote_switch.get() != 0) {
            break label787;
          }
          bool4 = true;
          localaogm.mbAllowStrangerVote = bool4;
          localaogm.mStrRecomTrace = localStrangerInfo.str_recom_trace.get();
          if (!TextUtils.isEmpty(localaogm.mDeclaration))
          {
            localaogm.mDeclaration = localaogm.mDeclaration.replace('\n', ' ');
            localaogm.mDeclaration = localaogm.mDeclaration.trim();
          }
          if (localStrangerInfo.uint32_show_vip_info_flag.get() != 0) {
            break label793;
          }
          bool4 = true;
          localaogm.mVipHide = bool4;
          if (localStrangerInfo.uint32_bigvip_open.get() == 0) {
            break label1271;
          }
          if (localStrangerInfo.uint32_bigvip_hide.get() == 0) {
            break label799;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          ExtendFriendSquareInfo.StrangerInfo localStrangerInfo;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("ExtendFriendHandler", 2, paramToServiceMsg.getMessage(), paramToServiceMsg);
          notifyUI(2, false, new Object[] { Long.valueOf(l), paramObject });
        }
        localaogm.mBigVipHide = bool4;
        localaogm.mBigVipLevel = localStrangerInfo.uint32_bigvip_level.get();
        localaogm.mVipType = localStrangerInfo.uint32_vip_flag.get();
        localaogm.mVipLevel = localStrangerInfo.uint32_svip_level.get();
        localaogm.mTemplateId = localStrangerInfo.uint32_vipicon_id.get();
        if (localStrangerInfo.bytes_ad_content.has())
        {
          paramToServiceMsg = AlumBasicData.a(localStrangerInfo.bytes_ad_content.get().toByteArray());
          localaogm.mAlumbasicdata = paramToServiceMsg;
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendHandler", 2, "handleGetSquareStrangerList: " + localaogm.mUin + " " + localStrangerInfo.uint32_vip_flag.get() + " " + localStrangerInfo.uint32_svip_level.get());
          }
          if ((!TextUtils.isEmpty(localaogm.mNickName)) || (localaogm.mAlumbasicdata != null))
          {
            localArrayList.add(localaogm);
            continue;
            aokp.a().c(paramFromServiceMsg.isSuccess(), paramFromServiceMsg.getResultCode());
            return;
            bool1 = false;
            continue;
            bool2 = false;
            continue;
            bool3 = false;
            continue;
            bool4 = false;
            continue;
            bool4 = false;
            continue;
            bool4 = false;
            continue;
            bool4 = false;
            continue;
            bool4 = false;
            continue;
          }
        }
        else
        {
          paramToServiceMsg = null;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.w("ExtendFriendHandler", 2, String.format("handleGetSquareStrangerList nick name is empty, uin=%s", new Object[] { localaogm.mUin }));
        }
      }
      paramToServiceMsg = new aoft();
      paramToServiceMsg.jdField_a_of_type_Int = ((ExtendFriendSquareInfo.RspBody)localObject1).uint32_match_count.get();
      paramToServiceMsg.jdField_b_of_type_Int = ((ExtendFriendSquareInfo.RspBody)localObject1).uint32_match_time.get();
      paramToServiceMsg.jdField_c_of_type_Int = ((ExtendFriendSquareInfo.RspBody)localObject1).uint32_online_num.get();
      localObject1 = new ArrayList();
      n = localArrayList.size();
      if (n <= 12)
      {
        ((List)localObject1).addAll(localArrayList);
        break label1277;
        label925:
        while (i < ((List)localObject1).size())
        {
          paramToServiceMsg.jdField_a_of_type_JavaUtilList.add(((aogm)((List)localObject1).get(i)).mUin);
          i += 1;
        }
      }
      localObject2 = new Random();
      j = 12;
      i = 0;
    }
    for (;;)
    {
      int k;
      if (i < n)
      {
        k = j;
        if (((Random)localObject2).nextInt(n - i) >= j) {
          break label1283;
        }
        ((List)localObject1).add(localArrayList.get(i));
        k = j - 1;
        break label1283;
        if (this.app != null) {
          ((aojc)this.app.getManager(292)).a(true, paramToServiceMsg);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, String.format("handleGetSquareStrangerList isOver=%s cookies=%s isProfileComplete=%s isShowCard=%s maxLikeCount=%s resultCount=%d matchCount=%d limitDuration=%d onlineNum=%d", new Object[] { Boolean.valueOf(bool1), arrayOfByte, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(m), Integer.valueOf(localArrayList.size()), Integer.valueOf(paramToServiceMsg.jdField_a_of_type_Int), Integer.valueOf(paramToServiceMsg.jdField_b_of_type_Int), Integer.valueOf(paramToServiceMsg.jdField_c_of_type_Int) }));
        }
        notifyUI(2, true, new Object[] { Long.valueOf(l), paramObject, Boolean.valueOf(bool1), arrayOfByte, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(m), localArrayList, paramToServiceMsg });
        break label742;
        notifyUI(2, false, new Object[] { Long.valueOf(l), paramObject });
        break label742;
        label1271:
        bool4 = true;
        break;
      }
      label1277:
      i = 0;
      break label925;
      label1283:
      i += 1;
      j = k;
    }
  }
  
  public boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "requestMatch. uin = " + paramString);
    }
    try
    {
      oidb_0xe03.ReqBody localReqBody = new oidb_0xe03.ReqBody();
      localReqBody.uint64_uin.set(a(paramString, "getUnlimitMatchBaseInfo"));
      localReqBody.enum_matchopcode.set(3);
      paramString = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, localReqBody.toByteArray());
      paramString.extraData.putInt("match_op", 3);
      sendPbReq(paramString);
      return true;
    }
    catch (NumberFormatException paramString)
    {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "requestMatch. error = " + paramString);
    }
    return false;
  }
  
  public void c()
  {
    notifyUI(17, true, Integer.valueOf(asfl.a(this.app)));
  }
  
  /* Error */
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 647	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   4: istore 4
    //   6: ldc 23
    //   8: iconst_1
    //   9: ldc_w 1194
    //   12: iconst_1
    //   13: anewarray 107	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: iload 4
    //   20: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   23: aastore
    //   24: invokestatic 136	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   27: invokestatic 456	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: iconst_0
    //   31: istore 6
    //   33: iload 4
    //   35: sipush 1000
    //   38: if_icmpne +749 -> 787
    //   41: new 1196	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   44: dup
    //   45: invokespecial 1197	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   48: astore_2
    //   49: aload_2
    //   50: aload_3
    //   51: checkcast 1198	[B
    //   54: checkcast 1198	[B
    //   57: invokevirtual 1202	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   60: pop
    //   61: aload_2
    //   62: getfield 1205	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   65: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   68: ifne +625 -> 693
    //   71: iconst_1
    //   72: istore 6
    //   74: ldc 23
    //   76: iconst_1
    //   77: new 44	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 1207
    //   87: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: iload 6
    //   92: invokevirtual 957	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   95: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 456	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: iload 6
    //   103: ifeq +721 -> 824
    //   106: aload_2
    //   107: getfield 1210	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   110: invokevirtual 303	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   113: ifeq +711 -> 824
    //   116: aload_2
    //   117: getfield 1210	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   120: invokevirtual 306	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   123: ifnull +701 -> 824
    //   126: new 1212	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody
    //   129: dup
    //   130: invokespecial 1213	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:<init>	()V
    //   133: astore 12
    //   135: aload 12
    //   137: aload_2
    //   138: getfield 1210	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   141: invokevirtual 306	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   144: invokevirtual 348	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   147: invokevirtual 1214	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   150: pop
    //   151: aload_1
    //   152: getfield 470	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   155: ldc_w 472
    //   158: invokevirtual 653	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   161: astore 13
    //   163: aload 12
    //   165: getfield 1215	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   168: invokevirtual 421	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   171: ifeq +653 -> 824
    //   174: aload 12
    //   176: getfield 1215	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   179: invokevirtual 423	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   182: invokestatic 822	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   185: aload 13
    //   187: invokevirtual 763	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   190: ifeq +634 -> 824
    //   193: aload 12
    //   195: getfield 1216	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:bytes_declaration	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   198: invokevirtual 303	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   201: ifeq +498 -> 699
    //   204: aload 12
    //   206: getfield 1216	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:bytes_declaration	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   209: invokevirtual 306	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   212: invokevirtual 309	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   215: astore_2
    //   216: aload 12
    //   218: getfield 1217	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:bytes_voice_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   221: invokevirtual 303	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   224: ifeq +480 -> 704
    //   227: aload 12
    //   229: getfield 1217	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:bytes_voice_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   232: invokevirtual 306	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   235: invokevirtual 309	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   238: astore_3
    //   239: aload 12
    //   241: getfield 1218	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_popularity	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   244: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   247: ifeq +462 -> 709
    //   250: aload 12
    //   252: getfield 1218	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_popularity	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   255: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   258: istore 4
    //   260: aload 12
    //   262: getfield 1221	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint64_update_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   265: invokevirtual 421	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   268: ifeq +447 -> 715
    //   271: aload 12
    //   273: getfield 1221	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint64_update_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   276: invokevirtual 423	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   279: lstore 8
    //   281: aload 12
    //   283: getfield 1222	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_is_show_card	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   286: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   289: ifeq +15 -> 304
    //   292: aload 12
    //   294: getfield 1222	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_is_show_card	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   297: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   300: iconst_1
    //   301: if_icmpne +3 -> 304
    //   304: aload 12
    //   306: getfield 1223	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_voice_duration	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   309: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   312: ifeq +409 -> 721
    //   315: aload 12
    //   317: getfield 1223	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_voice_duration	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   320: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   323: istore 5
    //   325: aload_0
    //   326: aload 13
    //   328: aload_2
    //   329: aload_3
    //   330: iload 4
    //   332: lload 8
    //   334: iload 5
    //   336: invokespecial 669	aoet:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJI)Lcom/tencent/mobileqq/data/Card;
    //   339: astore 11
    //   341: new 1015	aogm
    //   344: dup
    //   345: invokespecial 1016	aogm:<init>	()V
    //   348: astore 10
    //   350: aload 10
    //   352: aload 13
    //   354: putfield 1020	aogm:mUin	Ljava/lang/String;
    //   357: aload 10
    //   359: aload_2
    //   360: putfield 1058	aogm:mDeclaration	Ljava/lang/String;
    //   363: aload 10
    //   365: aload_3
    //   366: putfield 1062	aogm:mVoiceUrl	Ljava/lang/String;
    //   369: aload 10
    //   371: iload 4
    //   373: putfield 1054	aogm:mPopularity	I
    //   376: aload 10
    //   378: iload 5
    //   380: putfield 1066	aogm:mVoiceDuration	I
    //   383: aload 10
    //   385: aload 12
    //   387: getfield 1224	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_gender	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   390: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   393: putfield 1030	aogm:mGender	I
    //   396: aload 10
    //   398: aload 12
    //   400: getfield 1227	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:str_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   403: invokevirtual 870	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   406: putfield 1024	aogm:mNickName	Ljava/lang/String;
    //   409: aload 12
    //   411: getfield 1228	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_show_vip_info_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   414: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   417: ifne +310 -> 727
    //   420: iconst_1
    //   421: istore 7
    //   423: aload 10
    //   425: iload 7
    //   427: putfield 1088	aogm:mVipHide	Z
    //   430: aload 12
    //   432: getfield 1229	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_bigvip_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   435: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   438: ifeq +393 -> 831
    //   441: aload 12
    //   443: getfield 1230	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_bigvip_hide	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   446: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   449: ifeq +284 -> 733
    //   452: goto +379 -> 831
    //   455: aload 10
    //   457: iload 7
    //   459: putfield 1097	aogm:mBigVipHide	Z
    //   462: aload 10
    //   464: aload 12
    //   466: getfield 1231	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_bigvip_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   469: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   472: putfield 1103	aogm:mBigVipLevel	I
    //   475: aload 10
    //   477: aload 12
    //   479: getfield 1232	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_vip_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   482: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   485: putfield 1109	aogm:mVipType	I
    //   488: aload 10
    //   490: aload 12
    //   492: getfield 1233	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_svip_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   495: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   498: putfield 1115	aogm:mVipLevel	I
    //   501: aload 10
    //   503: aload 12
    //   505: getfield 1234	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_vipicon_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   508: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   511: putfield 1121	aogm:mTemplateId	I
    //   514: aload 10
    //   516: astore_2
    //   517: aload 11
    //   519: astore_3
    //   520: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   523: ifeq +90 -> 613
    //   526: ldc 23
    //   528: iconst_2
    //   529: new 44	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   536: ldc_w 1236
    //   539: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload 10
    //   544: getfield 1020	aogm:mUin	Ljava/lang/String;
    //   547: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: ldc_w 1137
    //   553: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload 12
    //   558: getfield 1228	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_show_vip_info_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   561: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   564: invokevirtual 292	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   567: ldc_w 1137
    //   570: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: aload 12
    //   575: getfield 1232	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_vip_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   578: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   581: invokevirtual 292	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   584: ldc_w 1137
    //   587: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: aload 12
    //   592: getfield 1233	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_svip_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   595: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   598: invokevirtual 292	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   601: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   607: aload 11
    //   609: astore_3
    //   610: aload 10
    //   612: astore_2
    //   613: iload 6
    //   615: istore 7
    //   617: aload_1
    //   618: getfield 470	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   621: ldc_w 480
    //   624: iconst_0
    //   625: invokevirtual 1239	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   628: ifne +31 -> 659
    //   631: iload 6
    //   633: istore 7
    //   635: iload 6
    //   637: ifeq +14 -> 651
    //   640: iload 6
    //   642: istore 7
    //   644: aload_3
    //   645: ifnonnull +6 -> 651
    //   648: iconst_0
    //   649: istore 7
    //   651: aload_0
    //   652: iconst_3
    //   653: iload 7
    //   655: aload_3
    //   656: invokevirtual 451	aoet:notifyUI	(IZLjava/lang/Object;)V
    //   659: aload_0
    //   660: bipush 9
    //   662: iload 7
    //   664: iconst_2
    //   665: anewarray 107	java/lang/Object
    //   668: dup
    //   669: iconst_0
    //   670: aload_2
    //   671: aastore
    //   672: dup
    //   673: iconst_1
    //   674: aload_1
    //   675: getfield 470	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   678: ldc_w 486
    //   681: iconst_0
    //   682: invokevirtual 1242	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   685: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   688: aastore
    //   689: invokevirtual 451	aoet:notifyUI	(IZLjava/lang/Object;)V
    //   692: return
    //   693: iconst_0
    //   694: istore 6
    //   696: goto -622 -> 74
    //   699: aconst_null
    //   700: astore_2
    //   701: goto -485 -> 216
    //   704: aconst_null
    //   705: astore_3
    //   706: goto -467 -> 239
    //   709: iconst_0
    //   710: istore 4
    //   712: goto -452 -> 260
    //   715: lconst_0
    //   716: lstore 8
    //   718: goto -437 -> 281
    //   721: iconst_0
    //   722: istore 5
    //   724: goto -399 -> 325
    //   727: iconst_0
    //   728: istore 7
    //   730: goto -307 -> 423
    //   733: iconst_0
    //   734: istore 7
    //   736: goto -281 -> 455
    //   739: astore_3
    //   740: aconst_null
    //   741: astore_2
    //   742: aload_3
    //   743: invokevirtual 1243	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   746: iconst_0
    //   747: istore 6
    //   749: aconst_null
    //   750: astore 10
    //   752: ldc 23
    //   754: iconst_1
    //   755: new 44	java/lang/StringBuilder
    //   758: dup
    //   759: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   762: ldc_w 1245
    //   765: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: aload_3
    //   769: invokevirtual 1246	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   772: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   778: invokestatic 31	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   781: aload 10
    //   783: astore_3
    //   784: goto -171 -> 613
    //   787: ldc 23
    //   789: iconst_1
    //   790: ldc_w 1248
    //   793: iconst_1
    //   794: anewarray 107	java/lang/Object
    //   797: dup
    //   798: iconst_0
    //   799: aload_2
    //   800: invokevirtual 674	com/tencent/qphone/base/remote/FromServiceMsg:getStringForLog	()Ljava/lang/String;
    //   803: aastore
    //   804: invokestatic 136	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   807: invokestatic 31	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   810: aconst_null
    //   811: astore_3
    //   812: aconst_null
    //   813: astore_2
    //   814: goto -201 -> 613
    //   817: astore_3
    //   818: aload 10
    //   820: astore_2
    //   821: goto -79 -> 742
    //   824: aconst_null
    //   825: astore_3
    //   826: aconst_null
    //   827: astore_2
    //   828: goto -215 -> 613
    //   831: iconst_1
    //   832: istore 7
    //   834: goto -379 -> 455
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	837	0	this	aoet
    //   0	837	1	paramToServiceMsg	ToServiceMsg
    //   0	837	2	paramFromServiceMsg	FromServiceMsg
    //   0	837	3	paramObject	Object
    //   4	707	4	i	int
    //   323	400	5	j	int
    //   31	717	6	bool1	boolean
    //   421	412	7	bool2	boolean
    //   279	438	8	l	long
    //   348	471	10	localaogm	aogm
    //   339	269	11	localCard	Card
    //   133	458	12	localRspBody	com.tencent.pb.extendfriend.GetExtendFriendInfo.RspBody
    //   161	192	13	str	String
    // Exception table:
    //   from	to	target	type
    //   49	71	739	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   74	101	739	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   106	216	739	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   216	239	739	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   239	260	739	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   260	281	739	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   281	304	739	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   304	325	739	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   325	350	739	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   350	420	817	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   423	452	817	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   455	514	817	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   520	607	817	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void d()
  {
    notifyUI(17, true, Integer.valueOf(0));
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(4, false, null);
      return;
    }
    Object localObject = new oidb_0xb4a.RspBody();
    int j = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    int k = paramToServiceMsg.extraData.getInt("fetch_start", 0);
    int i = paramToServiceMsg.extraData.getInt("fetch_count", 0);
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("fetch_loadmore", false);
    long l = paramToServiceMsg.extraData.getLong("fetch_reqTs", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, String.format("handleGetExtFrdGroupList result:%s start=%s count=%s loadMore:%s reqTs:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Boolean.valueOf(bool2), Long.valueOf(l) }));
    }
    if (j == 0) {
      if (((oidb_0xb4a.RspBody)localObject).total_count.has())
      {
        i = ((oidb_0xb4a.RspBody)localObject).total_count.get();
        if (!((oidb_0xb4a.RspBody)localObject).group_list.has()) {
          break label310;
        }
        paramToServiceMsg = ((oidb_0xb4a.RspBody)localObject).group_list.get();
        label194:
        if ((paramToServiceMsg != null) && (paramToServiceMsg.size() != 0) && (paramToServiceMsg.size() + k < i)) {
          break label491;
        }
      }
    }
    label310:
    label485:
    label491:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
      {
        paramFromServiceMsg = new ArrayList(paramToServiceMsg.size());
        paramToServiceMsg = paramToServiceMsg.iterator();
        for (;;)
        {
          if (paramToServiceMsg.hasNext())
          {
            paramObject = (oidb_0xb4a.GroupInfo)paramToServiceMsg.next();
            localObject = new GroupInfo();
            ((GroupInfo)localObject).parseFromPb(paramObject);
            paramFromServiceMsg.add(localObject);
            continue;
            i = 0;
            break;
            paramToServiceMsg = null;
            break label194;
          }
        }
        paramToServiceMsg = paramFromServiceMsg;
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendHandler", 2, String.format("handleGetExtFrdGroupList loadOver:%b, total:%d size:%d content:", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), Integer.valueOf(paramToServiceMsg.size()), paramToServiceMsg.toString() }));
        }
        notifyUI(4, true, new Object[] { paramToServiceMsg, Boolean.valueOf(bool2), Long.valueOf(l), Boolean.valueOf(bool1) });
        paramToServiceMsg = aokp.a();
        if (j != 0) {
          break label485;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        paramToServiceMsg.d(bool1, j);
        return;
        paramToServiceMsg = new ArrayList(1);
        break;
        notifyUI(4, false, new Object[] { null, Boolean.valueOf(bool2), Long.valueOf(l), Boolean.valueOf(false) });
        break label412;
      }
    }
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg == null) {
      notifyUI(6, false, null);
    }
    int j;
    label194:
    label465:
    label471:
    label477:
    do
    {
      String str;
      do
      {
        return;
        str = paramToServiceMsg.getUin();
      } while (!TextUtils.equals(getCurrentAccountUin(), str));
      int i = paramToServiceMsg.extraData.getInt("match_op");
      if (paramFromServiceMsg == null)
      {
        notifyUI(6, false, new Object[] { Integer.valueOf(i), Integer.valueOf(-1), null });
        return;
      }
      paramToServiceMsg = new oidb_0xb9b.RspBody();
      j = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. uin = ", str, ", match_op = ", Integer.valueOf(i), " result = ", Integer.valueOf(j) });
      }
      if (j == 0)
      {
        if (paramToServiceMsg.uint32_match_op.has())
        {
          i = paramToServiceMsg.uint32_match_op.get();
          if (!paramToServiceMsg.enum_matchopretcode.has()) {
            break label465;
          }
          j = paramToServiceMsg.enum_matchopretcode.get();
          if (!paramToServiceMsg.uint32_match_count.has()) {
            break label471;
          }
        }
        for (int k = paramToServiceMsg.uint32_match_count.get();; k = -1)
        {
          if (!paramToServiceMsg.msg_match_info.has()) {
            break label477;
          }
          paramFromServiceMsg = (oidb_0xb9b.MatchInfo)paramToServiceMsg.msg_match_info.get();
          paramObject = new aofu();
          paramObject.jdField_a_of_type_JavaLangString = String.valueOf(paramToServiceMsg.uint64_uin.get());
          paramObject.jdField_a_of_type_ArrayOfByte = paramFromServiceMsg.bytes_sig.get().toByteArray();
          paramObject.jdField_b_of_type_JavaLangString = String.valueOf(paramFromServiceMsg.uint64_match_uin.get());
          paramObject.jdField_c_of_type_JavaLangString = paramFromServiceMsg.bytes_tips_wording.get().toStringUtf8();
          paramObject.jdField_a_of_type_Long = paramFromServiceMsg.uint64_time_stamp.get();
          paramObject.jdField_a_of_type_Int = paramFromServiceMsg.uint32_match_expired_time.get();
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. uin = ", str, ", match_op = ", Integer.valueOf(i), " retCode = ", Integer.valueOf(j), " matchInfo = ", paramObject, "leftcount=", Integer.valueOf(k) });
          }
          if ((aojc)this.app.getManager(292) != null) {}
          notifyUI(6, true, new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramObject, Integer.valueOf(k) }, true);
          return;
          break;
          j = -1;
          break label194;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. uin = ", str, ", match_op = ", Integer.valueOf(i), " retCode = ", Integer.valueOf(j), "leftcount=", Integer.valueOf(k) });
        }
        notifyUI(6, true, new Object[] { Integer.valueOf(i), Integer.valueOf(j), null, Integer.valueOf(k) });
        return;
      }
      notifyUI(6, false, new Object[] { Integer.valueOf(i), Integer.valueOf(-1), null, Integer.valueOf(-1) });
    } while (!QLog.isColorLevel());
    QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "handleMatchResponse. TYPE_UPDATE_MATCH_INFO false result：" + j);
  }
  
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null)) {
      QLog.d("ExtendFriendHandler", 1, "handleReportUserResponse error!");
    }
    int i;
    do
    {
      return;
      i = parseOIDBPkg(paramFromServiceMsg, paramObject, new cmd0xcb5.RspBody());
    } while (!QLog.isColorLevel());
    QLog.d("ExtendFriendHandler", 2, "handleReportUserResponse, result = " + i);
  }
  
  public void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0xdb1.RspBody localRspBody = new oidb_0xdb1.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handlePlusSettingResponse. result = ", Integer.valueOf(i) });
    }
    long l1;
    label96:
    label116:
    long l2;
    label137:
    int j;
    label158:
    boolean bool;
    if (i == 0) {
      if (localRspBody.uint64_allow_kuolie.has())
      {
        l1 = localRspBody.uint64_allow_kuolie.get();
        if (!localRspBody.uint32_match_count.has()) {
          break label336;
        }
        i = localRspBody.uint32_match_count.get();
        if (!localRspBody.str_func_name.has()) {
          break label342;
        }
        paramToServiceMsg = localRspBody.str_func_name.get();
        if (!localRspBody.uint64_expire_time.has()) {
          break label349;
        }
        l2 = localRspBody.uint64_expire_time.get();
        if (!localRspBody.uint32_left_chat_time.has()) {
          break label357;
        }
        j = localRspBody.uint32_left_chat_time.get();
        if (l1 == 0L) {
          break label363;
        }
        bool = true;
        label168:
        if (this.app != null)
        {
          aojt.a(this.app, bool, j, i, paramToServiceMsg, l2);
          if (bool) {
            notifyUI(18, true, null);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "handlePlusSettingResponse. lShow = " + l1 + " leftCount = " + i + " funcName = " + paramToServiceMsg + " expireTime=" + l2 + " chatTime:" + j);
        }
        notifyUI(10, true, new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), paramToServiceMsg, Long.valueOf(l2), Integer.valueOf(j) });
      }
    }
    label336:
    label342:
    label349:
    label357:
    label363:
    do
    {
      return;
      l1 = 0L;
      break;
      i = -1;
      break label96;
      paramToServiceMsg = "";
      break label116;
      l2 = -1L;
      break label137;
      j = -1;
      break label158;
      bool = false;
      break label168;
      notifyUI(10, false, new Object[] { Boolean.valueOf(false), Integer.valueOf(-1), "", Integer.valueOf(-1), Integer.valueOf(-1) });
    } while (!QLog.isColorLevel());
    QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "handlePlusSettingResponse.  false result：" + i);
  }
  
  public void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg == null)
    {
      QLog.e("ExtendFriendHandler", 2, " handleUnLimitResponse request null");
      return;
    }
    String str = paramToServiceMsg.getUin();
    Object localObject1 = getCurrentAccountUin();
    int i = paramToServiceMsg.extraData.getInt("match_op");
    int j = a(i);
    if (!TextUtils.equals((CharSequence)localObject1, str))
    {
      QLog.e("ExtendFriendHandler", 2, " handleUnLimitResponse Wrong uin");
      return;
    }
    if (paramFromServiceMsg == null)
    {
      notifyUI(j, false, null);
      return;
    }
    localObject1 = new oidb_0xe03.RspBody();
    j = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "handleMatchResponse. uin = " + str + " match_op = " + i + " result = " + j);
    }
    int k;
    label215:
    label238:
    Object localObject2;
    label322:
    label349:
    long l;
    if (((oidb_0xe03.RspBody)localObject1).enum_matchopcode.has())
    {
      i = ((oidb_0xe03.RspBody)localObject1).enum_matchopcode.get();
      k = a(i);
      if (j != 0) {
        break label1608;
      }
      if (k != 11) {
        break label933;
      }
      if (!((oidb_0xe03.RspBody)localObject1).enum_matchopretcode.has()) {
        break label751;
      }
      j = ((oidb_0xe03.RspBody)localObject1).enum_matchopretcode.get();
      if (!((oidb_0xe03.RspBody)localObject1).bytes_match_fail_wording.has()) {
        break label757;
      }
      paramFromServiceMsg = ((oidb_0xe03.RspBody)localObject1).bytes_match_fail_wording.get().toStringUtf8();
      if (!((oidb_0xe03.RspBody)localObject1).msg_match_info.has()) {
        break label836;
      }
      paramObject = (oidb_0xe03.MatchInfo)((oidb_0xe03.RspBody)localObject1).msg_match_info.get();
      localObject2 = new aofu();
      ((aofu)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(((oidb_0xe03.RspBody)localObject1).uint64_uin.get());
      ((aofu)localObject2).jdField_a_of_type_ArrayOfByte = paramObject.bytes_sig.get().toByteArray();
      if (!paramObject.uint64_match_uin.has()) {
        break label764;
      }
      paramToServiceMsg = String.valueOf(paramObject.uint64_match_uin.get());
      ((aofu)localObject2).jdField_b_of_type_JavaLangString = paramToServiceMsg;
      if (!paramObject.bytes_tips_wording.has()) {
        break label771;
      }
      paramToServiceMsg = paramObject.bytes_tips_wording.get().toStringUtf8();
      ((aofu)localObject2).jdField_c_of_type_JavaLangString = paramToServiceMsg;
      if (!paramObject.uint64_time_stamp.has()) {
        break label778;
      }
      l = paramObject.uint64_time_stamp.get();
      label374:
      ((aofu)localObject2).jdField_a_of_type_Long = l;
      if (!paramObject.uint32_match_expired_time.has()) {
        break label786;
      }
      k = paramObject.uint32_match_expired_time.get();
      label400:
      ((aofu)localObject2).jdField_a_of_type_Int = k;
      if (!paramObject.bytes_nick.has()) {
        break label793;
      }
      paramToServiceMsg = paramObject.bytes_nick.get().toStringUtf8();
      label428:
      ((aofu)localObject2).d = paramToServiceMsg;
      if (!paramObject.string_report_id.has()) {
        break label1651;
      }
    }
    label531:
    label570:
    label751:
    label1651:
    for (paramToServiceMsg = paramObject.string_report_id.get();; paramToServiceMsg = "")
    {
      paramObject = paramToServiceMsg;
      if (TextUtils.isEmpty(paramToServiceMsg))
      {
        paramObject = "0";
        QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "string_report_id EMPTY");
      }
      ((aofu)localObject2).e = paramObject;
      if (((oidb_0xe03.RspBody)localObject1).msg_match_info.msg_tag.has()) {
        if (((oidb_0xe03.RspBody)localObject1).msg_match_info.msg_tag.uint32_tag_id.has())
        {
          ((aofu)localObject2).jdField_b_of_type_Int = ((oidb_0xe03.RspBody)localObject1).msg_match_info.msg_tag.uint32_tag_id.get();
          if (((oidb_0xe03.RspBody)localObject1).msg_match_info.msg_tag.bytes_tag.has()) {
            ((aofu)localObject2).f = ((oidb_0xe03.RspBody)localObject1).msg_match_info.msg_tag.bytes_tag.get().toStringUtf8();
          }
          if (!((oidb_0xe03.RspBody)localObject1).msg_match_info.msg_match_uin_data.has()) {
            break label824;
          }
          if (((aofu)localObject2).jdField_a_of_type_Aofh == null)
          {
            ((aofu)localObject2).jdField_a_of_type_Aofh = new aofh();
            ((aofu)localObject2).jdField_a_of_type_Aofh.jdField_a_of_type_JavaLangString = ((aofu)localObject2).jdField_b_of_type_JavaLangString;
          }
          a(((oidb_0xe03.RspBody)localObject1).msg_match_info.msg_match_uin_data, ((aofu)localObject2).jdField_a_of_type_Aofh);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse TYPE_GET_UNLIMIT_MATCH. uin = ", str, ", match_op = ", Integer.valueOf(i), " retCode = ", Integer.valueOf(j), " matchInfo = ", ((aofu)localObject2).toString(), " errMsg = ", paramFromServiceMsg });
        }
        notifyUI(11, true, new Object[] { Integer.valueOf(j), localObject2, paramFromServiceMsg });
        return;
        break;
        j = -1;
        break label215;
        label757:
        paramFromServiceMsg = "";
        break label238;
        label764:
        paramToServiceMsg = "0";
        break label322;
        paramToServiceMsg = "";
        break label349;
        l = -1L;
        break label374;
        k = 30;
        break label400;
        paramToServiceMsg = "";
        break label428;
        QLog.e("ExtendFriendHandler", 2, "msg_tag pi pei zhu ti  ID IS NULL");
        break label531;
        QLog.e("ExtendFriendHandler", 2, "msg_tag pi pei zhu ti   not has");
        break label570;
        QLog.e("ExtendFriendHandler", 2, "msg_match_uin_data  not has");
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse TYPE_GET_UNLIMIT_MATCH. uin = ", str, ", match_op = ", Integer.valueOf(i), " retCode = ", Integer.valueOf(j), " errMsg = ", paramFromServiceMsg });
      }
      notifyUI(11, true, new Object[] { Integer.valueOf(j), null, paramFromServiceMsg });
      return;
      boolean bool;
      if (k == 12)
      {
        if (((oidb_0xe03.RspBody)localObject1).enum_matchopretcode.has())
        {
          j = ((oidb_0xe03.RspBody)localObject1).enum_matchopretcode.get();
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse TYPE_CANCLE_UNLIMIT_MATCH. uin = ", str, ", match_op = ", Integer.valueOf(i), " retCode = ", Integer.valueOf(j) });
          }
          if (j != 0) {
            break label1042;
          }
        }
        for (bool = true;; bool = false)
        {
          notifyUI(12, bool, null);
          return;
          j = -1;
          break;
        }
      }
      if (k == 13)
      {
        if (((oidb_0xe03.RspBody)localObject1).uint32_switch.has())
        {
          j = ((oidb_0xe03.RspBody)localObject1).uint32_switch.get();
          paramFromServiceMsg = new ArrayList();
          if (!((oidb_0xe03.RspBody)localObject1).rpt_tag.has()) {
            break label1235;
          }
          k = 0;
          if (k >= ((oidb_0xe03.RspBody)localObject1).rpt_tag.size()) {
            break label1235;
          }
          paramObject = new aogn();
          localObject2 = (oidb_0xe03.TagInfo)((oidb_0xe03.RspBody)localObject1).rpt_tag.get(k);
          paramObject.jdField_a_of_type_Int = ((oidb_0xe03.TagInfo)localObject2).uint32_tag_id.get();
          if (!((oidb_0xe03.TagInfo)localObject2).bytes_tag.has()) {
            break label1222;
          }
          paramToServiceMsg = ((oidb_0xe03.TagInfo)localObject2).bytes_tag.get().toStringUtf8();
          paramObject.jdField_a_of_type_JavaLangString = paramToServiceMsg;
          if (!((oidb_0xe03.TagInfo)localObject2).uint32_hot_flag.has()) {
            break label1229;
          }
        }
        for (int m = ((oidb_0xe03.TagInfo)localObject2).uint32_hot_flag.get();; m = 0)
        {
          paramObject.jdField_b_of_type_Int = m;
          paramFromServiceMsg.add(paramObject);
          k += 1;
          break label1098;
          j = 0;
          break;
          paramToServiceMsg = "";
          break label1169;
        }
        if (((oidb_0xe03.RspBody)localObject1).uint32_count.has()) {}
        for (k = ((oidb_0xe03.RspBody)localObject1).uint32_count.get();; k = 1212432)
        {
          paramToServiceMsg = new ArrayList();
          if (!((oidb_0xe03.RspBody)localObject1).uint64_uin_list.has()) {
            break;
          }
          m = 0;
          while (m < ((oidb_0xe03.RspBody)localObject1).uint64_uin_list.size())
          {
            paramToServiceMsg.add(((Long)((oidb_0xe03.RspBody)localObject1).uint64_uin_list.get(m)).toString());
            m += 1;
          }
        }
        if (j != 0) {}
        for (bool = true;; bool = false)
        {
          aojc.a(this.app, Boolean.valueOf(bool));
          notifyUI(13, true, new Object[] { paramFromServiceMsg, Boolean.valueOf(bool), Integer.valueOf(k), paramToServiceMsg });
          aojc.a(this.app, paramFromServiceMsg);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. TYPE_GET_UNLIMIT_TAG uin = ", str, ", match_op = ", i + " tagList  :" + paramFromServiceMsg.toString() + " switch:" + bool });
          return;
        }
      }
      if (k == 14)
      {
        bool = paramToServiceMsg.extraData.getBoolean("open", false);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. TYPE_SET_UNLIMIT_SWITCH uin = ", str, ", open = ", Boolean.valueOf(bool) });
        }
        aojc.a(this.app, Boolean.valueOf(bool));
        notifyUI(14, true, null);
        return;
      }
      if ((k != 15) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. TYPE_GET_UNLIMIT_FRIEND_INFO uin = ", str, ", match_op = ", Integer.valueOf(i) });
      return;
      notifyUI(k, false, null);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "handleMatchResponse. TYPE_UPDATE_MATCH_INFO false result：" + j);
      return;
    }
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xb4b");
      this.allowCmdSet.add("OidbSvc.0xb4c");
      this.allowCmdSet.add("OidbSvc.0xb4a");
      this.allowCmdSet.add("OidbSvc.0xb51");
      this.allowCmdSet.add("OidbSvc.0xb9b");
      this.allowCmdSet.add("OidbSvc.0xcb5");
      this.allowCmdSet.add("OidbSvc.0xdb1");
      this.allowCmdSet.add("OidbSvc.0xe03");
      this.allowCmdSet.add("OidbSvc.0xe09");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends ajte> observerClass()
  {
    return aoez.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      return;
      if ("OidbSvc.0xb4b".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xb4c".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xb51".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xb4a".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xb9b".equals(paramFromServiceMsg.getServiceCmd()))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xcb5".equals(paramFromServiceMsg.getServiceCmd()))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xdb1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xe03".equals(paramFromServiceMsg.getServiceCmd()))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xe09".equals(paramFromServiceMsg.getServiceCmd()));
    i(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aoet
 * JD-Core Version:    0.7.0.1
 */