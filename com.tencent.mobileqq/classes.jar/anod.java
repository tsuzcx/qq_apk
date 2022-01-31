import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageForLimitChatConfirm;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.extendfriend.ExtendFriendHandler.1;
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
import mqq.os.MqqHandler;
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
import tencent.im.oidb.cmd0xdc7.oidb_0xdc7.MatchInfo;
import tencent.im.oidb.cmd0xdc7.oidb_0xdc7.MatchUinData;
import tencent.im.oidb.cmd0xdc7.oidb_0xdc7.ReqBody;
import tencent.im.oidb.cmd0xdc7.oidb_0xdc7.RspBody;
import tencent.im.oidb.cmd0xdc7.oidb_0xdc7.TagInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x128.submsgtype0x128.MsgBody;

public class anod
  extends ajfb
{
  public static AtomicInteger a;
  public static String[] a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "http://img4.duitang.com/uploads/item/201511/26/20151126112617_vUaQf.jpeg", "http://imgsrc.baidu.com/forum/w=580/sign=6ade238c064f78f0800b9afb49300a83/6cbb60d0f703918f31df8012543d269758eec47c.jpg", "http://cdnq.duitang.com/uploads/item/201504/04/20150404H3338_N8Wir.jpeg", "http://up.qqya.com/allimg/201710-t/17-101804_132321.jpg", "http://www.qqzhi.com/uploadpic/2014-05-14/051120936.jpg", "http://f.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=3b3771dd93529822056631c7e2fa57fd/024f78f0f736afc30425727fb019ebc4b74512fa.jpg", "http://www.qqzhi.com/uploadpic/2014-10-05/161337745.jpg" };
  }
  
  public anod(QQAppInterface paramQQAppInterface)
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
    ajjj localajjj = (ajjj)this.app.getManager(51);
    Card localCard = localajjj.c(paramString1);
    localCard.declaration = paramString2;
    localCard.voiceUrl = paramString3;
    if (paramInt1 != 0) {
      localCard.popularity = paramInt1;
    }
    localCard.updateTime = paramLong;
    localCard.extendFriendVoiceDuration = paramInt2;
    localajjj.a(localCard);
    QLog.e("ExtendFriendHandler", 1, new Object[] { "saveExtendFriendInfo uin=%s declaration=%s voiceUrl=%s popularity=%d updateTime=%ld extendFriendVoiceDuration=%d", paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    return localCard;
  }
  
  public int a(String paramString, boolean paramBoolean)
  {
    QLog.i("ExtendFriendHandler", 1, String.format("getExtendFriendInfo uin=%s", new Object[] { paramString }));
    int i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
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
        localObject1 = new anpf();
        ((anpf)localObject1).jdField_a_of_type_Boolean = paramMessageRecord.bEnterMsg;
        ((anpf)localObject1).jdField_a_of_type_Int = paramMessageRecord.leaveChatType;
        ((anpf)localObject1).jdField_a_of_type_Long = paramMessageRecord.timeStamp;
        ((anpf)localObject1).jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
        ((anpf)localObject1).jdField_b_of_type_JavaLangString = paramMessageRecord.SenderNickName;
        ((anpf)localObject1).d = paramMessageRecord.c2cExpiredTime;
        ((anpf)localObject1).jdField_b_of_type_Int = paramMessageRecord.leftChatTime;
        ((anpf)localObject1).jdField_c_of_type_JavaLangString = paramMessageRecord.tipsWording;
        ((anpf)localObject1).jdField_c_of_type_Int = paramMessageRecord.matchExpiredTime;
        ((anpf)localObject1).jdField_b_of_type_Long = paramMessageRecord.readyTs;
        QLog.i("ExtendFriendHandlerExtendFriendLimitChat", 2, "HandleC2CConfirmOrCancelMsg  info：" + ((anpf)localObject1).toString());
        i = 1;
        j = i;
        if (!bado.b(paramMessageRecord.issend)) {
          l1 = paramMessageRecord.time;
        }
      }
    }
    label406:
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
            break label406;
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
      bbmy.a(this.app.getApp(), 1, 2131628946, 0).a();
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
      localReqBody.bytes_req_buff.set(ByteStringMicro.copyFrom(bgqd.a().a()));
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
          awqx.b(paramString1, "dc00898", "", "", "0X8009423", "0X8009423", paramInt, 0, "", "", paramString2, "");
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
  
  public void a(submsgtype0x128.MsgBody paramMsgBody)
  {
    if (paramMsgBody != null)
    {
      anpe localanpe = new anpe();
      localanpe.jdField_a_of_type_JavaLangString = this.app.c();
      localanpe.jdField_a_of_type_ArrayOfByte = paramMsgBody.bytes_sig.get().toByteArray();
      label91:
      long l;
      label116:
      int i;
      if (paramMsgBody.uint64_match_uin.has())
      {
        str = String.valueOf(paramMsgBody.uint64_match_uin.get());
        localanpe.jdField_b_of_type_JavaLangString = str;
        if (!paramMsgBody.bytes_tips_wording.has()) {
          break label304;
        }
        str = paramMsgBody.bytes_tips_wording.get().toStringUtf8();
        localanpe.jdField_c_of_type_JavaLangString = str;
        if (!paramMsgBody.uint64_time_stamp.has()) {
          break label312;
        }
        l = paramMsgBody.uint64_time_stamp.get();
        localanpe.jdField_a_of_type_Long = l;
        if (!paramMsgBody.uint32_match_expired_time.has()) {
          break label317;
        }
        i = paramMsgBody.uint32_match_expired_time.get();
        label140:
        localanpe.jdField_a_of_type_Int = i;
        if (!paramMsgBody.bytes_nick.has()) {
          break label322;
        }
      }
      label304:
      label312:
      label317:
      label322:
      for (String str = paramMsgBody.bytes_nick.get().toStringUtf8();; str = "")
      {
        localanpe.d = str;
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
        localanpe.e = paramMsgBody;
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleGetUnlimitMatchOfflinePush push matchInfo = ", localanpe });
        }
        paramMsgBody = (ansl)this.app.getManager(292);
        if (paramMsgBody != null) {
          paramMsgBody.a();
        }
        notifyUI(16, true, new Object[] { localanpe });
        return;
        str = "0";
        break;
        str = "";
        break label91;
        l = 0L;
        break label116;
        i = 0;
        break label140;
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
      oidb_0xdc7.ReqBody localReqBody = new oidb_0xdc7.ReqBody();
      localReqBody.uint64_uin.set(a(paramString, "cancleUnlimitMatch"));
      localReqBody.enum_matchopcode.set(2);
      paramString = makeOIDBPkg("OidbSvc.0xdc7", 3527, 0, localReqBody.toByteArray());
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
  
  public boolean a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "requestUnlimitMatch. uin = " + paramString + " sexType= " + paramInt);
    }
    try
    {
      oidb_0xdc7.ReqBody localReqBody = new oidb_0xdc7.ReqBody();
      localReqBody.uint64_uin.set(a(paramString, "requestUnlimitMatch"));
      localReqBody.enum_matchopcode.set(1);
      localReqBody.uint32_tag_id.set(1);
      localReqBody.uint32_sex.set(paramInt);
      paramString = makeOIDBPkg("OidbSvc.0xdc7", 3527, 0, localReqBody.toByteArray());
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
  
  public boolean a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "requestMatch. uin = " + paramString1 + " matchUin:" + paramString2);
    }
    try
    {
      oidb_0xdc7.ReqBody localReqBody = new oidb_0xdc7.ReqBody();
      localReqBody.uint64_uin.set(a(paramString1, "getUnlimitMatchUserInfo"));
      localReqBody.uint64_match_uin.set(a(paramString2, "getUnlimitMatchUserInfo"));
      localReqBody.enum_matchopcode.set(5);
      paramString1 = makeOIDBPkg("OidbSvc.0xdc7", 3527, 0, localReqBody.toByteArray());
      paramString1.extraData.putInt("match_op", 5);
      sendPbReq(paramString1);
      return true;
    }
    catch (NumberFormatException paramString1)
    {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "requestMatch. error = " + paramString1);
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
      oidb_0xdc7.ReqBody localReqBody = new oidb_0xdc7.ReqBody();
      localReqBody.uint64_uin.set(a(paramString, "setUnlimitMatchStatus"));
      if (paramBoolean) {
        localReqBody.uint32_switch.set(1);
      }
      for (;;)
      {
        localReqBody.enum_matchopcode.set(4);
        paramString = makeOIDBPkg("OidbSvc.0xdc7", 3527, 0, localReqBody.toByteArray());
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
    if (!arjg.a(this.app))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ExtendFriendHandler", 2, "calcMatchChatBoxUnreadCount isMatchChatRedPointSwitchOn false");
      }
      return;
    }
    if (!arjg.a(this.app, "matchchat_redpoint_show")) {
      arjg.a(this.app, "matchchat_redpoint_show", true);
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
        anpv localanpv;
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
          localanpv = new anpv();
          localanpv.mUin = String.valueOf(localStrangerInfo.uint64_uin.get());
          localanpv.mNickName = localStrangerInfo.bytes_nick.get().toStringUtf8();
          localanpv.mGender = localStrangerInfo.uint32_gender.get();
          if (localStrangerInfo.uint32_is_my_like.get() != 1) {
            break label775;
          }
          bool4 = true;
          localanpv.mLiked = bool4;
          localanpv.mAvailLikeCount = localStrangerInfo.uint32_my_left_like_count.get();
          if (localStrangerInfo.uint32_addfri_status.get() != 1) {
            break label781;
          }
          bool4 = true;
          localanpv.mAddFriendVerified = bool4;
          localanpv.mPopularity = localStrangerInfo.uint32_popularity.get();
          localanpv.mDeclaration = localStrangerInfo.bytes_declaration.get().toStringUtf8();
          localanpv.mVoiceUrl = localStrangerInfo.bytes_voice_url.get().toStringUtf8();
          localanpv.mVoiceDuration = localStrangerInfo.uint32_voice_duration.get();
          if (localStrangerInfo.uint32_vote_switch.get() != 0) {
            break label787;
          }
          bool4 = true;
          localanpv.mbAllowStrangerVote = bool4;
          localanpv.mStrRecomTrace = localStrangerInfo.str_recom_trace.get();
          if (!TextUtils.isEmpty(localanpv.mDeclaration))
          {
            localanpv.mDeclaration = localanpv.mDeclaration.replace('\n', ' ');
            localanpv.mDeclaration = localanpv.mDeclaration.trim();
          }
          if (localStrangerInfo.uint32_show_vip_info_flag.get() != 0) {
            break label793;
          }
          bool4 = true;
          localanpv.mVipHide = bool4;
          if (localStrangerInfo.uint32_bigvip_open.get() == 0) {
            break label1270;
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
        localanpv.mBigVipHide = bool4;
        localanpv.mBigVipLevel = localStrangerInfo.uint32_bigvip_level.get();
        localanpv.mVipType = localStrangerInfo.uint32_vip_flag.get();
        localanpv.mVipLevel = localStrangerInfo.uint32_svip_level.get();
        localanpv.mTemplateId = localStrangerInfo.uint32_vipicon_id.get();
        if (localStrangerInfo.bytes_ad_content.has())
        {
          paramToServiceMsg = AlumBasicData.a(localStrangerInfo.bytes_ad_content.get().toByteArray());
          localanpv.mAlumbasicdata = paramToServiceMsg;
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendHandler", 2, "handleGetSquareStrangerList: " + localanpv.mUin + " " + localStrangerInfo.uint32_vip_flag.get() + " " + localStrangerInfo.uint32_svip_level.get());
          }
          if ((!TextUtils.isEmpty(localanpv.mNickName)) || (localanpv.mAlumbasicdata != null))
          {
            localArrayList.add(localanpv);
            continue;
            anty.a().c(paramFromServiceMsg.isSuccess(), paramFromServiceMsg.getResultCode());
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
          QLog.w("ExtendFriendHandler", 2, String.format("handleGetSquareStrangerList nick name is empty, uin=%s", new Object[] { localanpv.mUin }));
        }
      }
      paramToServiceMsg = new anpd();
      paramToServiceMsg.jdField_a_of_type_Int = ((ExtendFriendSquareInfo.RspBody)localObject1).uint32_match_count.get();
      paramToServiceMsg.jdField_b_of_type_Int = ((ExtendFriendSquareInfo.RspBody)localObject1).uint32_match_time.get();
      paramToServiceMsg.jdField_c_of_type_Int = ((ExtendFriendSquareInfo.RspBody)localObject1).uint32_online_num.get();
      localObject1 = new ArrayList();
      n = localArrayList.size();
      if (n <= 12)
      {
        ((List)localObject1).addAll(localArrayList);
        break label1276;
        label925:
        while (i < ((List)localObject1).size())
        {
          paramToServiceMsg.jdField_a_of_type_JavaUtilList.add(((anpv)((List)localObject1).get(i)).mUin);
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
          break label1282;
        }
        ((List)localObject1).add(localArrayList.get(i));
        k = j - 1;
        break label1282;
        if (this.app != null) {
          ((ansl)this.app.getManager(292)).a(true, paramToServiceMsg);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, String.format("handleGetSquareStrangerList isOver=%s cookies=%s isProfileComplete=%s isShowCard=%s maxLikeCount=%s resultCount=%d matchCount=%d limitDuration=%d onlineNum=%d", new Object[] { Boolean.valueOf(bool1), arrayOfByte, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(m), Integer.valueOf(localArrayList.size()), Integer.valueOf(paramToServiceMsg.jdField_a_of_type_Int), Integer.valueOf(paramToServiceMsg.jdField_b_of_type_Int), Integer.valueOf(paramToServiceMsg.jdField_c_of_type_Int) }));
        }
        notifyUI(2, true, new Object[] { Long.valueOf(l), paramObject, Boolean.valueOf(bool1), arrayOfByte, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(m), localArrayList, paramToServiceMsg });
        break label742;
        notifyUI(2, false, new Object[] { Long.valueOf(l), paramObject });
        break label742;
        label1270:
        bool4 = true;
        break;
      }
      label1276:
      i = 0;
      break label925;
      label1282:
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
      oidb_0xdc7.ReqBody localReqBody = new oidb_0xdc7.ReqBody();
      localReqBody.uint64_uin.set(a(paramString, "getUnlimitMatchBaseInfo"));
      localReqBody.enum_matchopcode.set(3);
      paramString = makeOIDBPkg("OidbSvc.0xdc7", 3527, 0, localReqBody.toByteArray());
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
    notifyUI(17, true, Integer.valueOf(arjg.a(this.app)));
  }
  
  /* Error */
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 412	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   4: istore 4
    //   6: ldc 42
    //   8: iconst_1
    //   9: ldc_w 1014
    //   12: iconst_1
    //   13: anewarray 126	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: iload 4
    //   20: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   23: aastore
    //   24: invokestatic 149	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   27: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: iconst_0
    //   31: istore 6
    //   33: iload 4
    //   35: sipush 1000
    //   38: if_icmpne +746 -> 784
    //   41: new 1016	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   44: dup
    //   45: invokespecial 1017	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   48: astore_2
    //   49: aload_2
    //   50: aload_3
    //   51: checkcast 1018	[B
    //   54: checkcast 1018	[B
    //   57: invokevirtual 1022	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   60: pop
    //   61: aload_2
    //   62: getfield 1025	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   65: invokevirtual 634	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   68: ifne +622 -> 690
    //   71: iconst_1
    //   72: istore 6
    //   74: ldc 42
    //   76: iconst_1
    //   77: new 63	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 1027
    //   87: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: iload 6
    //   92: invokevirtual 741	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   95: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: iload 6
    //   103: ifeq +718 -> 821
    //   106: aload_2
    //   107: getfield 1030	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   110: invokevirtual 620	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   113: ifeq +708 -> 821
    //   116: aload_2
    //   117: getfield 1030	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   120: invokevirtual 600	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   123: ifnull +698 -> 821
    //   126: new 1032	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody
    //   129: dup
    //   130: invokespecial 1033	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:<init>	()V
    //   133: astore 12
    //   135: aload 12
    //   137: aload_2
    //   138: getfield 1030	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   141: invokevirtual 600	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   144: invokevirtual 601	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   147: invokevirtual 1034	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   150: pop
    //   151: aload_1
    //   152: getfield 185	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   155: ldc 187
    //   157: invokevirtual 418	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   160: astore 13
    //   162: aload 12
    //   164: getfield 1035	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   167: invokevirtual 610	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   170: ifeq +651 -> 821
    //   173: aload 12
    //   175: getfield 1035	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   178: invokevirtual 612	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   181: invokestatic 615	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   184: aload 13
    //   186: invokevirtual 542	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   189: ifeq +632 -> 821
    //   192: aload 12
    //   194: getfield 1036	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:bytes_declaration	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   197: invokevirtual 620	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   200: ifeq +496 -> 696
    //   203: aload 12
    //   205: getfield 1036	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:bytes_declaration	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   208: invokevirtual 600	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   211: invokevirtual 623	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   214: astore_2
    //   215: aload 12
    //   217: getfield 1037	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:bytes_voice_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   220: invokevirtual 620	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   223: ifeq +478 -> 701
    //   226: aload 12
    //   228: getfield 1037	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:bytes_voice_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   231: invokevirtual 600	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   234: invokevirtual 623	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   237: astore_3
    //   238: aload 12
    //   240: getfield 1038	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_popularity	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   243: invokevirtual 632	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   246: ifeq +460 -> 706
    //   249: aload 12
    //   251: getfield 1038	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_popularity	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   254: invokevirtual 634	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   257: istore 4
    //   259: aload 12
    //   261: getfield 1041	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint64_update_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   264: invokevirtual 610	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   267: ifeq +445 -> 712
    //   270: aload 12
    //   272: getfield 1041	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint64_update_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   275: invokevirtual 612	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   278: lstore 8
    //   280: aload 12
    //   282: getfield 1042	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_is_show_card	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   285: invokevirtual 632	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   288: ifeq +15 -> 303
    //   291: aload 12
    //   293: getfield 1042	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_is_show_card	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   296: invokevirtual 634	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   299: iconst_1
    //   300: if_icmpne +3 -> 303
    //   303: aload 12
    //   305: getfield 1043	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_voice_duration	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   308: invokevirtual 632	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   311: ifeq +407 -> 718
    //   314: aload 12
    //   316: getfield 1043	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_voice_duration	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   319: invokevirtual 634	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   322: istore 5
    //   324: aload_0
    //   325: aload 13
    //   327: aload_2
    //   328: aload_3
    //   329: iload 4
    //   331: lload 8
    //   333: iload 5
    //   335: invokespecial 434	anod:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJI)Lcom/tencent/mobileqq/data/Card;
    //   338: astore 11
    //   340: new 827	anpv
    //   343: dup
    //   344: invokespecial 828	anpv:<init>	()V
    //   347: astore 10
    //   349: aload 10
    //   351: aload 13
    //   353: putfield 832	anpv:mUin	Ljava/lang/String;
    //   356: aload 10
    //   358: aload_2
    //   359: putfield 870	anpv:mDeclaration	Ljava/lang/String;
    //   362: aload 10
    //   364: aload_3
    //   365: putfield 874	anpv:mVoiceUrl	Ljava/lang/String;
    //   368: aload 10
    //   370: iload 4
    //   372: putfield 866	anpv:mPopularity	I
    //   375: aload 10
    //   377: iload 5
    //   379: putfield 878	anpv:mVoiceDuration	I
    //   382: aload 10
    //   384: aload 12
    //   386: getfield 1044	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_gender	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   389: invokevirtual 634	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   392: putfield 842	anpv:mGender	I
    //   395: aload 10
    //   397: aload 12
    //   399: getfield 1047	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:str_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   402: invokevirtual 646	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   405: putfield 836	anpv:mNickName	Ljava/lang/String;
    //   408: aload 12
    //   410: getfield 1048	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_show_vip_info_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   413: invokevirtual 634	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   416: ifne +308 -> 724
    //   419: iconst_1
    //   420: istore 7
    //   422: aload 10
    //   424: iload 7
    //   426: putfield 900	anpv:mVipHide	Z
    //   429: aload 12
    //   431: getfield 1049	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_bigvip_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   434: invokevirtual 634	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   437: ifeq +391 -> 828
    //   440: aload 12
    //   442: getfield 1050	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_bigvip_hide	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   445: invokevirtual 634	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   448: ifeq +282 -> 730
    //   451: goto +377 -> 828
    //   454: aload 10
    //   456: iload 7
    //   458: putfield 909	anpv:mBigVipHide	Z
    //   461: aload 10
    //   463: aload 12
    //   465: getfield 1051	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_bigvip_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   468: invokevirtual 634	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   471: putfield 915	anpv:mBigVipLevel	I
    //   474: aload 10
    //   476: aload 12
    //   478: getfield 1052	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_vip_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   481: invokevirtual 634	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   484: putfield 921	anpv:mVipType	I
    //   487: aload 10
    //   489: aload 12
    //   491: getfield 1053	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_svip_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   494: invokevirtual 634	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   497: putfield 927	anpv:mVipLevel	I
    //   500: aload 10
    //   502: aload 12
    //   504: getfield 1054	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_vipicon_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   507: invokevirtual 634	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   510: putfield 933	anpv:mTemplateId	I
    //   513: aload 10
    //   515: astore_2
    //   516: aload 11
    //   518: astore_3
    //   519: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   522: ifeq +90 -> 612
    //   525: ldc 42
    //   527: iconst_2
    //   528: new 63	java/lang/StringBuilder
    //   531: dup
    //   532: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   535: ldc_w 1056
    //   538: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: aload 10
    //   543: getfield 832	anpv:mUin	Ljava/lang/String;
    //   546: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: ldc_w 949
    //   552: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload 12
    //   557: getfield 1048	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_show_vip_info_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   560: invokevirtual 634	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   563: invokevirtual 719	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   566: ldc_w 949
    //   569: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: aload 12
    //   574: getfield 1052	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_vip_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   577: invokevirtual 634	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   580: invokevirtual 719	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   583: ldc_w 949
    //   586: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: aload 12
    //   591: getfield 1053	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_svip_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   594: invokevirtual 634	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   597: invokevirtual 719	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   600: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   606: aload 11
    //   608: astore_3
    //   609: aload 10
    //   611: astore_2
    //   612: iload 6
    //   614: istore 7
    //   616: aload_1
    //   617: getfield 185	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   620: ldc 195
    //   622: iconst_0
    //   623: invokevirtual 1059	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   626: ifne +31 -> 657
    //   629: iload 6
    //   631: istore 7
    //   633: iload 6
    //   635: ifeq +14 -> 649
    //   638: iload 6
    //   640: istore 7
    //   642: aload_3
    //   643: ifnonnull +6 -> 649
    //   646: iconst_0
    //   647: istore 7
    //   649: aload_0
    //   650: iconst_3
    //   651: iload 7
    //   653: aload_3
    //   654: invokevirtual 440	anod:notifyUI	(IZLjava/lang/Object;)V
    //   657: aload_0
    //   658: bipush 9
    //   660: iload 7
    //   662: iconst_2
    //   663: anewarray 126	java/lang/Object
    //   666: dup
    //   667: iconst_0
    //   668: aload_2
    //   669: aastore
    //   670: dup
    //   671: iconst_1
    //   672: aload_1
    //   673: getfield 185	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   676: ldc 201
    //   678: iconst_0
    //   679: invokevirtual 1062	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   682: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   685: aastore
    //   686: invokevirtual 440	anod:notifyUI	(IZLjava/lang/Object;)V
    //   689: return
    //   690: iconst_0
    //   691: istore 6
    //   693: goto -619 -> 74
    //   696: aconst_null
    //   697: astore_2
    //   698: goto -483 -> 215
    //   701: aconst_null
    //   702: astore_3
    //   703: goto -465 -> 238
    //   706: iconst_0
    //   707: istore 4
    //   709: goto -450 -> 259
    //   712: lconst_0
    //   713: lstore 8
    //   715: goto -435 -> 280
    //   718: iconst_0
    //   719: istore 5
    //   721: goto -397 -> 324
    //   724: iconst_0
    //   725: istore 7
    //   727: goto -305 -> 422
    //   730: iconst_0
    //   731: istore 7
    //   733: goto -279 -> 454
    //   736: astore_3
    //   737: aconst_null
    //   738: astore_2
    //   739: aload_3
    //   740: invokevirtual 1063	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   743: iconst_0
    //   744: istore 6
    //   746: aconst_null
    //   747: astore 10
    //   749: ldc 42
    //   751: iconst_1
    //   752: new 63	java/lang/StringBuilder
    //   755: dup
    //   756: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   759: ldc_w 1065
    //   762: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: aload_3
    //   766: invokevirtual 1066	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   769: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   775: invokestatic 50	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   778: aload 10
    //   780: astore_3
    //   781: goto -169 -> 612
    //   784: ldc 42
    //   786: iconst_1
    //   787: ldc_w 1068
    //   790: iconst_1
    //   791: anewarray 126	java/lang/Object
    //   794: dup
    //   795: iconst_0
    //   796: aload_2
    //   797: invokevirtual 443	com/tencent/qphone/base/remote/FromServiceMsg:getStringForLog	()Ljava/lang/String;
    //   800: aastore
    //   801: invokestatic 149	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   804: invokestatic 50	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   807: aconst_null
    //   808: astore_3
    //   809: aconst_null
    //   810: astore_2
    //   811: goto -199 -> 612
    //   814: astore_3
    //   815: aload 10
    //   817: astore_2
    //   818: goto -79 -> 739
    //   821: aconst_null
    //   822: astore_3
    //   823: aconst_null
    //   824: astore_2
    //   825: goto -213 -> 612
    //   828: iconst_1
    //   829: istore 7
    //   831: goto -377 -> 454
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	834	0	this	anod
    //   0	834	1	paramToServiceMsg	ToServiceMsg
    //   0	834	2	paramFromServiceMsg	FromServiceMsg
    //   0	834	3	paramObject	Object
    //   4	704	4	i	int
    //   322	398	5	j	int
    //   31	714	6	bool1	boolean
    //   420	410	7	bool2	boolean
    //   278	436	8	l	long
    //   347	469	10	localanpv	anpv
    //   338	269	11	localCard	Card
    //   133	457	12	localRspBody	com.tencent.pb.extendfriend.GetExtendFriendInfo.RspBody
    //   160	192	13	str	String
    // Exception table:
    //   from	to	target	type
    //   49	71	736	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   74	101	736	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   106	215	736	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   215	238	736	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   238	259	736	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   259	280	736	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   280	303	736	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   303	324	736	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   324	349	736	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   349	419	814	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   422	451	814	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   454	513	814	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   519	606	814	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
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
        paramToServiceMsg = anty.a();
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
    label193:
    label463:
    label469:
    label475:
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
            break label463;
          }
          j = paramToServiceMsg.enum_matchopretcode.get();
          if (!paramToServiceMsg.uint32_match_count.has()) {
            break label469;
          }
        }
        for (int k = paramToServiceMsg.uint32_match_count.get();; k = -1)
        {
          if (!paramToServiceMsg.msg_match_info.has()) {
            break label475;
          }
          paramFromServiceMsg = (oidb_0xb9b.MatchInfo)paramToServiceMsg.msg_match_info.get();
          paramObject = new anpe();
          paramObject.jdField_a_of_type_JavaLangString = String.valueOf(paramToServiceMsg.uint64_uin.get());
          paramObject.jdField_a_of_type_ArrayOfByte = paramFromServiceMsg.bytes_sig.get().toByteArray();
          paramObject.jdField_b_of_type_JavaLangString = String.valueOf(paramFromServiceMsg.uint64_match_uin.get());
          paramObject.jdField_c_of_type_JavaLangString = paramFromServiceMsg.bytes_tips_wording.get().toStringUtf8();
          paramObject.jdField_a_of_type_Long = paramFromServiceMsg.uint64_time_stamp.get();
          paramObject.jdField_a_of_type_Int = paramFromServiceMsg.uint32_match_expired_time.get();
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. uin = ", str, ", match_op = ", Integer.valueOf(i), " retCode = ", Integer.valueOf(j), " matchInfo = ", paramObject, "leftcount=", Integer.valueOf(k) });
          }
          if ((ansl)this.app.getManager(292) != null) {}
          notifyUI(6, true, new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramObject, Integer.valueOf(k) }, true);
          return;
          break;
          j = -1;
          break label193;
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
    label95:
    label115:
    long l2;
    label136:
    int j;
    label157:
    boolean bool;
    if (i == 0) {
      if (localRspBody.uint64_allow_kuolie.has())
      {
        l1 = localRspBody.uint64_allow_kuolie.get();
        if (!localRspBody.uint32_match_count.has()) {
          break label321;
        }
        i = localRspBody.uint32_match_count.get();
        if (!localRspBody.str_func_name.has()) {
          break label327;
        }
        paramToServiceMsg = localRspBody.str_func_name.get();
        if (!localRspBody.uint64_expire_time.has()) {
          break label334;
        }
        l2 = localRspBody.uint64_expire_time.get();
        if (!localRspBody.uint32_left_chat_time.has()) {
          break label342;
        }
        j = localRspBody.uint32_left_chat_time.get();
        if (l1 == 0L) {
          break label348;
        }
        bool = true;
        label167:
        ThreadManager.getSubThreadHandler().post(new ExtendFriendHandler.1(this, bool, j, i, paramToServiceMsg, l2));
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "handlePlusSettingResponse. lShow = " + l1 + " leftCount = " + i + " funcName = " + paramToServiceMsg + " expireTime=" + l2 + " chatTime:" + j);
        }
        notifyUI(10, true, new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), paramToServiceMsg, Long.valueOf(l2), Integer.valueOf(j) });
      }
    }
    label321:
    label327:
    label334:
    label342:
    label348:
    do
    {
      return;
      l1 = 0L;
      break;
      i = -1;
      break label95;
      paramToServiceMsg = "";
      break label115;
      l2 = -1L;
      break label136;
      j = -1;
      break label157;
      bool = false;
      break label167;
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
    localObject1 = new oidb_0xdc7.RspBody();
    j = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "handleMatchResponse. uin = " + str + " match_op = " + i + " result = " + j);
    }
    label173:
    int k;
    label214:
    label237:
    Object localObject2;
    label321:
    label348:
    long l;
    if (((oidb_0xdc7.RspBody)localObject1).enum_matchopcode.has())
    {
      i = ((oidb_0xdc7.RspBody)localObject1).enum_matchopcode.get();
      k = a(i);
      if (j != 0) {
        break label1668;
      }
      if (k != 11) {
        break label740;
      }
      if (!((oidb_0xdc7.RspBody)localObject1).enum_matchopretcode.has()) {
        break label595;
      }
      j = ((oidb_0xdc7.RspBody)localObject1).enum_matchopretcode.get();
      if (!((oidb_0xdc7.RspBody)localObject1).bytes_match_fail_wording.has()) {
        break label601;
      }
      paramFromServiceMsg = ((oidb_0xdc7.RspBody)localObject1).bytes_match_fail_wording.get().toStringUtf8();
      if (!((oidb_0xdc7.RspBody)localObject1).msg_match_info.has()) {
        break label644;
      }
      paramObject = (oidb_0xdc7.MatchInfo)((oidb_0xdc7.RspBody)localObject1).msg_match_info.get();
      localObject2 = new anpe();
      ((anpe)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(((oidb_0xdc7.RspBody)localObject1).uint64_uin.get());
      ((anpe)localObject2).jdField_a_of_type_ArrayOfByte = paramObject.bytes_sig.get().toByteArray();
      if (!paramObject.uint64_match_uin.has()) {
        break label608;
      }
      paramToServiceMsg = String.valueOf(paramObject.uint64_match_uin.get());
      ((anpe)localObject2).jdField_b_of_type_JavaLangString = paramToServiceMsg;
      if (!paramObject.bytes_tips_wording.has()) {
        break label615;
      }
      paramToServiceMsg = paramObject.bytes_tips_wording.get().toStringUtf8();
      ((anpe)localObject2).jdField_c_of_type_JavaLangString = paramToServiceMsg;
      if (!paramObject.uint64_time_stamp.has()) {
        break label622;
      }
      l = paramObject.uint64_time_stamp.get();
      label373:
      ((anpe)localObject2).jdField_a_of_type_Long = l;
      if (!paramObject.uint32_match_expired_time.has()) {
        break label630;
      }
      k = paramObject.uint32_match_expired_time.get();
      label399:
      ((anpe)localObject2).jdField_a_of_type_Int = k;
      if (!paramObject.bytes_nick.has()) {
        break label637;
      }
      paramToServiceMsg = paramObject.bytes_nick.get().toStringUtf8();
      label427:
      ((anpe)localObject2).d = paramToServiceMsg;
      if (!paramObject.string_report_id.has()) {
        break label1710;
      }
    }
    label644:
    label1428:
    label1710:
    for (paramToServiceMsg = paramObject.string_report_id.get();; paramToServiceMsg = "")
    {
      paramObject = paramToServiceMsg;
      if (TextUtils.isEmpty(paramToServiceMsg))
      {
        paramObject = "0";
        QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "string_report_id EMPTY");
      }
      ((anpe)localObject2).e = paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse TYPE_GET_UNLIMIT_MATCH. uin = ", str, ", match_op = ", Integer.valueOf(i), " retCode = ", Integer.valueOf(j), " matchInfo = ", ((anpe)localObject2).toString(), " errMsg = ", paramFromServiceMsg });
      }
      notifyUI(11, true, new Object[] { Integer.valueOf(j), localObject2, paramFromServiceMsg });
      return;
      break label173;
      label595:
      j = -1;
      break label214;
      label601:
      paramFromServiceMsg = "";
      break label237;
      label608:
      paramToServiceMsg = "0";
      break label321;
      label615:
      paramToServiceMsg = "";
      break label348;
      label622:
      l = -1L;
      break label373;
      label630:
      k = 30;
      break label399;
      label637:
      paramToServiceMsg = "";
      break label427;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse TYPE_GET_UNLIMIT_MATCH. uin = ", str, ", match_op = ", Integer.valueOf(i), " retCode = ", Integer.valueOf(j), " errMsg = ", paramFromServiceMsg });
      }
      notifyUI(11, true, new Object[] { Integer.valueOf(j), null, paramFromServiceMsg });
      return;
      label740:
      boolean bool;
      if (k == 12)
      {
        if (((oidb_0xdc7.RspBody)localObject1).enum_matchopretcode.has())
        {
          j = ((oidb_0xdc7.RspBody)localObject1).enum_matchopretcode.get();
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse TYPE_CANCLE_UNLIMIT_MATCH. uin = ", str, ", match_op = ", Integer.valueOf(i), " retCode = ", Integer.valueOf(j) });
          }
          if (j != 0) {
            break label848;
          }
        }
        label848:
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
        if (((oidb_0xdc7.RspBody)localObject1).uint32_switch.has())
        {
          j = ((oidb_0xdc7.RspBody)localObject1).uint32_switch.get();
          paramFromServiceMsg = new ArrayList();
          if (((oidb_0xdc7.RspBody)localObject1).rpt_tag.has()) {
            k = 0;
          }
        }
        else
        {
          for (;;)
          {
            if (k >= ((oidb_0xdc7.RspBody)localObject1).rpt_tag.size()) {
              break label1091;
            }
            paramObject = new anpw();
            localObject2 = (oidb_0xdc7.TagInfo)((oidb_0xdc7.RspBody)localObject1).rpt_tag.get(k);
            paramObject.jdField_a_of_type_Int = ((oidb_0xdc7.TagInfo)localObject2).uint32_tag_id.get();
            if (((oidb_0xdc7.TagInfo)localObject2).bytes_tag.has()) {}
            for (paramToServiceMsg = ((oidb_0xdc7.TagInfo)localObject2).bytes_tag.get().toStringUtf8();; paramToServiceMsg = "")
            {
              paramObject.jdField_a_of_type_JavaLangString = paramToServiceMsg;
              paramObject.jdField_b_of_type_Int = ((oidb_0xdc7.TagInfo)localObject2).uint32_count.get();
              paramObject.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
              if (!((oidb_0xdc7.TagInfo)localObject2).uint64_uin_list.has()) {
                break label1076;
              }
              int m = 0;
              while (m < ((oidb_0xdc7.TagInfo)localObject2).uint64_uin_list.size())
              {
                paramObject.jdField_a_of_type_JavaUtilArrayList.add(((Long)((oidb_0xdc7.TagInfo)localObject2).uint64_uin_list.get(m)).toString());
                m += 1;
              }
              j = 0;
              break;
            }
            label1076:
            paramFromServiceMsg.add(paramObject);
            k += 1;
          }
        }
        label1091:
        if (j != 0) {}
        for (bool = true;; bool = false)
        {
          ansl.a(this.app, Boolean.valueOf(bool));
          notifyUI(13, true, new Object[] { paramFromServiceMsg, Boolean.valueOf(bool) });
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
        ansl.a(this.app, Boolean.valueOf(bool));
        notifyUI(14, true, null);
        return;
      }
      if (k != 15) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. TYPE_GET_UNLIMIT_FRIEND_INFO uin = ", str, ", match_op = ", Integer.valueOf(i) });
      }
      if (((oidb_0xdc7.RspBody)localObject1).msg_match_uin_data.has())
      {
        paramFromServiceMsg = new anor();
        if (((oidb_0xdc7.RspBody)localObject1).msg_match_uin_data.bytes_age.has())
        {
          paramToServiceMsg = ((oidb_0xdc7.RspBody)localObject1).msg_match_uin_data.bytes_age.get().toStringUtf8();
          paramFromServiceMsg.jdField_b_of_type_JavaLangString = paramToServiceMsg;
          if (!((oidb_0xdc7.RspBody)localObject1).msg_match_uin_data.bytes_constellation.has()) {
            break label1582;
          }
          paramToServiceMsg = ((oidb_0xdc7.RspBody)localObject1).msg_match_uin_data.bytes_constellation.get().toStringUtf8();
          paramFromServiceMsg.jdField_c_of_type_JavaLangString = paramToServiceMsg;
          if (!((oidb_0xdc7.RspBody)localObject1).msg_match_uin_data.bytes_city.has()) {
            break label1589;
          }
          paramToServiceMsg = ((oidb_0xdc7.RspBody)localObject1).msg_match_uin_data.bytes_city.get().toStringUtf8();
          label1462:
          paramFromServiceMsg.d = paramToServiceMsg;
          if (!((oidb_0xdc7.RspBody)localObject1).msg_match_uin_data.bytes_school.has()) {
            break label1596;
          }
        }
        label1582:
        label1589:
        label1596:
        for (paramToServiceMsg = ((oidb_0xdc7.RspBody)localObject1).msg_match_uin_data.bytes_school.get().toStringUtf8();; paramToServiceMsg = "")
        {
          paramFromServiceMsg.e = paramToServiceMsg;
          paramToServiceMsg = new ArrayList();
          if (!((oidb_0xdc7.RspBody)localObject1).msg_match_uin_data.bytes_tag.has()) {
            break label1603;
          }
          i = 0;
          while (i < ((oidb_0xdc7.RspBody)localObject1).msg_match_uin_data.bytes_tag.size())
          {
            paramToServiceMsg.add(((ByteStringMicro)((oidb_0xdc7.RspBody)localObject1).msg_match_uin_data.bytes_tag.get(i)).toStringUtf8());
            i += 1;
          }
          paramToServiceMsg = "";
          break;
          paramToServiceMsg = "";
          break label1428;
          paramToServiceMsg = "";
          break label1462;
        }
        label1603:
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "ChatFriendInfo. " + paramFromServiceMsg.toString());
        }
        paramFromServiceMsg.jdField_a_of_type_JavaUtilArrayList = paramToServiceMsg;
        notifyUI(15, true, new Object[] { paramFromServiceMsg });
        return;
      }
      notifyUI(15, false, null);
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
      this.allowCmdSet.add("OidbSvc.0xdc7");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends ajfe> observerClass()
  {
    return anoj.class;
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
    } while (!"OidbSvc.0xdc7".equals(paramFromServiceMsg.getServiceCmd()));
    h(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anod
 * JD-Core Version:    0.7.0.1
 */