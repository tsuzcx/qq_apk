import QC.ExtendFriend;
import QC.UniBusinessItem;
import QC.UniSetExtFriendReq;
import QC.UniSetExtFriendRsp;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageForLimitChatConfirm;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.GPS;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.LBSInfo;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.ReqBody;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.RspBody;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.StrangerInfo;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.labelInfo;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.schoolInfo;
import com.tencent.pb.extendfriend.GetExtendFriendInfo.ReqBody;
import com.tencent.pb.extendfriend.GetExtendFriendInfo.RspBody;
import com.tencent.pb.extendfriend.GetExtendFriendInfo.labelInfo;
import com.tencent.pb.extendfriend.GetExtendFriendInfo.schoolInfo;
import com.tencent.pb.personal.PersonalInfo.ReqBody;
import com.tencent.pb.profilecard.EditExtendFriendInfo.ReqBody;
import com.tencent.pb.profilecard.EditExtendFriendInfo.RspBody;
import com.tencent.pb.profilecard.EditExtendFriendInfo.SchoolInfo;
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
import tencent.im.oidb.cmd0xcb5.cmd0xcb5.ReqBody;
import tencent.im.oidb.cmd0xcb5.cmd0xcb5.RspBody;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.GPS;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.LBSInfo;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.ReqBody;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.RspBody;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.GPS;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.LBSInfo;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.MatchInfo;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.MatchUinData;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.ProfileTagInfo;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.ReqBody;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.RspBody;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.TagInfo;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.schoolInfo;
import tencent.im.oidb.cmd0xe09.oidb_0xe09.OnlineInfo;
import tencent.im.oidb.cmd0xe09.oidb_0xe09.ReqBody;
import tencent.im.oidb.cmd0xe09.oidb_0xe09.RspBody;
import tencent.im.oidb.cmd0xe09.oidb_0xe09.reqItem;
import tencent.im.oidb.cmd0xe52.oidb_0xe52.RspBody;
import tencent.im.oidb.cmd0xe67.oidb_0xe67.GPS;
import tencent.im.oidb.cmd0xe67.oidb_0xe67.LBSInfo;
import tencent.im.oidb.cmd0xe67.oidb_0xe67.ReqBody;
import tencent.im.oidb.cmd0xe67.oidb_0xe67.RspBody;
import tencent.im.oidb.oidb_0xe51.ReqBody;
import tencent.im.oidb.oidb_0xe51.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x128.submsgtype0x128.MsgBody;

public class asfs
  extends anii
{
  public static AtomicInteger a;
  public final String a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  public asfs(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = "request_from_login";
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e("ExtendFriendHandler", 2, "un known op type" + paramInt);
    case 1: 
      return 11;
    case 2: 
      return 12;
    case 3: 
      return 13;
    case 4: 
      return 14;
    case 5: 
      return 15;
    case 6: 
      return 24;
    }
    return 25;
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
    anmw localanmw = (anmw)this.app.getManager(51);
    Card localCard = localanmw.c(paramString1);
    localCard.declaration = paramString2;
    localCard.voiceUrl = paramString3;
    if (paramInt1 != 0) {
      localCard.popularity = paramInt1;
    }
    localCard.updateTime = paramLong;
    localCard.extendFriendVoiceDuration = paramInt2;
    localanmw.a(localCard);
    QLog.e("ExtendFriendHandler", 1, new Object[] { "saveExtendFriendInfo uin=%s declaration=%s voiceUrl=%s popularity=%d updateTime=%ld extendFriendVoiceDuration=%d", paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    return localCard;
  }
  
  private Card a(String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString4, String paramString5, long paramLong2, int paramInt6, int paramInt7)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("ExtendFriendHandler", 1, "saveExtendFriendInfo uin is null");
      return null;
    }
    anmw localanmw = (anmw)this.app.getManager(51);
    Card localCard = localanmw.c(paramString1);
    localCard.declaration = paramString2;
    localCard.voiceUrl = paramString3;
    localCard.fontId = paramInt3;
    localCard.fontType = paramInt4;
    localCard.clothesId = paramInt5;
    if (paramInt1 != 0) {
      localCard.popularity = paramInt1;
    }
    localCard.updateTime = paramLong1;
    localCard.extendFriendVoiceDuration = paramInt2;
    if ((TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString5)))
    {
      localCard.schoolName = "";
      localCard.schoolId = "";
      localCard.authState = -1L;
      localCard.idx = -1;
    }
    for (localCard.category = -1;; localCard.category = paramInt7)
    {
      localanmw.a(localCard);
      QLog.e("ExtendFriendHandler", 1, new Object[] { "saveExtendFriendInfo uin=%s declaration=%s voiceUrl=%s popularity=%d updateTime=%ld extendFriendVoiceDuration=%d schoolId=%s schoolName=%s authState=%d idx=%d category=%d", paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), paramString4, paramString5, Long.valueOf(paramLong2), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7) });
      return localCard;
      localCard.schoolName = paramString5;
      localCard.schoolId = paramString4;
      localCard.authState = paramLong2;
      localCard.idx = paramInt6;
    }
  }
  
  private void a(List<Long> paramList1, int paramInt1, int paramInt2, List<Long> paramList2)
  {
    int i;
    if (paramList1 == null)
    {
      i = 0;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendHandler", 2, String.format("getExtendFriendOnlineState reqListSize=%s startIndex=%s count=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
    }
    for (;;)
    {
      bbyp localbbyp;
      Object localObject1;
      try
      {
        if (this.app == null) {
          break label382;
        }
        localbbyp = this.app.a();
        localObject1 = this.app.c();
      }
      catch (Exception paramList1)
      {
        Iterator localIterator;
        Object localObject3;
        Object localObject2;
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
        localObject3 = localbbyp.c(String.valueOf(localLong), (String)localObject1);
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = localbbyp.a(String.valueOf(localLong), (String)localObject1, false);
        }
        if (localObject2 != null)
        {
          localObject3 = new oidb_0xe09.reqItem();
          ((oidb_0xe09.reqItem)localObject3).uint64_uin.set(localLong.longValue());
          ((oidb_0xe09.reqItem)localObject3).bytes_sig.set(ByteStringMicro.copyFrom((byte[])localObject2));
          localReqBody.rpt_item.add((MessageMicro)localObject3);
        }
        else
        {
          QLog.w("ExtendFriendHandler", 1, String.format("getExtendFriendOnlineState get match chat sig fail. uin=%s", new Object[] { localLong }));
        }
      }
      else
      {
        localObject1 = makeOIDBPkg("OidbSvc.0xe09", 3593, 1, localReqBody.toByteArray());
        ((ToServiceMsg)localObject1).addAttribute("reqList", paramList1);
        ((ToServiceMsg)localObject1).addAttribute("startIndex", Integer.valueOf(paramInt1));
        ((ToServiceMsg)localObject1).addAttribute("count", Integer.valueOf(paramInt2));
        ((ToServiceMsg)localObject1).addAttribute("resultList", paramList2);
        sendPbReq((ToServiceMsg)localObject1);
        return;
        label382:
        localbbyp = null;
        localObject1 = null;
        if ((i != 0) && (paramInt1 < i) && (paramInt2 > 0)) {
          if (localbbyp != null) {}
        }
      }
    }
  }
  
  private void a(oidb_0xe03.MatchUinData paramMatchUinData, asgn paramasgn)
  {
    int j = -1;
    int k = 0;
    if ((paramMatchUinData == null) || (paramasgn == null))
    {
      QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "msg_match_uin_data || info is null. ");
      return;
    }
    label90:
    label118:
    int i;
    if (paramMatchUinData.uint32_age.has())
    {
      localObject1 = paramMatchUinData.uint32_age.get() + "";
      paramasgn.jdField_b_of_type_JavaLangString = ((String)localObject1);
      if (!paramMatchUinData.bytes_constellation.has()) {
        break label516;
      }
      localObject1 = paramMatchUinData.bytes_constellation.get().toStringUtf8();
      paramasgn.jdField_c_of_type_JavaLangString = ((String)localObject1);
      if (!paramMatchUinData.bytes_city.has()) {
        break label523;
      }
      localObject1 = paramMatchUinData.bytes_city.get().toStringUtf8();
      paramasgn.jdField_d_of_type_JavaLangString = ((String)localObject1);
      if (!paramMatchUinData.bytes_school.has()) {
        break label530;
      }
      localObject1 = paramMatchUinData.bytes_school.get().toStringUtf8();
      label146:
      paramasgn.e = ((String)localObject1);
      if (!paramMatchUinData.bytes_company.has()) {
        break label537;
      }
      localObject1 = paramMatchUinData.bytes_company.get().toStringUtf8();
      label174:
      paramasgn.f = ((String)localObject1);
      if (!paramMatchUinData.bytes_declaration.has()) {
        break label544;
      }
      localObject1 = paramMatchUinData.bytes_declaration.get().toStringUtf8();
      label202:
      paramasgn.g = ((String)localObject1);
      if (!paramMatchUinData.bytes_voice_url.has()) {
        break label551;
      }
      localObject1 = paramMatchUinData.bytes_voice_url.get().toStringUtf8();
      label230:
      paramasgn.h = ((String)localObject1);
      if (!paramMatchUinData.uint32_voice_duration.has()) {
        break label558;
      }
      i = paramMatchUinData.uint32_voice_duration.get();
      label254:
      paramasgn.jdField_b_of_type_Int = i;
      if (!paramMatchUinData.bytes_long_nick.has()) {
        break label563;
      }
      localObject1 = paramMatchUinData.bytes_long_nick.get().toByteArray();
      label281:
      if (localObject1 != null) {
        paramasgn.i = RichStatus.parseStatus((byte[])localObject1).getPlainText();
      }
      if (!paramMatchUinData.uint32_sex.has()) {
        break label569;
      }
      paramasgn.jdField_a_of_type_Int = paramMatchUinData.uint32_sex.get();
      label319:
      if (!paramMatchUinData.uint32_popularity.has()) {
        break label587;
      }
    }
    Object localObject2;
    label516:
    label523:
    label530:
    label537:
    label544:
    label551:
    label558:
    label563:
    label569:
    label587:
    for (long l = paramMatchUinData.uint32_popularity.get();; l = 0L)
    {
      paramasgn.jdField_a_of_type_Long = l;
      localObject1 = new ArrayList();
      if (!paramMatchUinData.rpt_school_info.has()) {
        break label593;
      }
      i = 0;
      while (i < paramMatchUinData.rpt_school_info.size())
      {
        if (((oidb_0xe03.schoolInfo)paramMatchUinData.rpt_school_info.get(i)).str_school_name.has())
        {
          localObject2 = new ashs(((oidb_0xe03.schoolInfo)paramMatchUinData.rpt_school_info.get(i)).str_school_id.get(), ((oidb_0xe03.schoolInfo)paramMatchUinData.rpt_school_info.get(i)).str_school_name.get(), ((oidb_0xe03.schoolInfo)paramMatchUinData.rpt_school_info.get(i)).uint64_state.get());
          ((ArrayList)localObject1).add(localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "schoolInfo. " + ((ashs)localObject2).toString());
          }
        }
        i += 1;
      }
      localObject1 = "";
      break;
      localObject1 = "";
      break label90;
      localObject1 = "";
      break label118;
      localObject1 = "";
      break label146;
      localObject1 = "";
      break label174;
      localObject1 = "";
      break label202;
      localObject1 = "";
      break label230;
      i = 0;
      break label254;
      localObject1 = null;
      break label281;
      paramasgn.jdField_a_of_type_Int = 0;
      QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "mGender  is null. set 0  ");
      break label319;
    }
    label593:
    paramasgn.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
    Object localObject1 = new ArrayList();
    if (paramMatchUinData.rpt_tag.has())
    {
      i = k;
      while (i < paramMatchUinData.rpt_tag.size())
      {
        if (((oidb_0xe03.ProfileTagInfo)paramMatchUinData.rpt_tag.get(i)).bytes_tag.has())
        {
          k = ((oidb_0xe03.ProfileTagInfo)paramMatchUinData.rpt_tag.get(i)).uint32_same_flag.get();
          localObject2 = ((oidb_0xe03.ProfileTagInfo)paramMatchUinData.rpt_tag.get(i)).bytes_tag.get().toStringUtf8();
          ashr localashr = new ashr();
          localashr.jdField_a_of_type_Int = k;
          localashr.jdField_a_of_type_JavaLangString = ((String)localObject2);
          ((ArrayList)localObject1).add(localashr);
        }
        i += 1;
      }
    }
    paramasgn.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
    if (paramMatchUinData.uint32_distance.has())
    {
      i = paramMatchUinData.uint32_distance.get();
      label755:
      paramasgn.jdField_c_of_type_Int = i;
      i = j;
      if (paramMatchUinData.uint32_match_pool.has()) {
        i = paramMatchUinData.uint32_match_pool.get();
      }
      paramasgn.jdField_d_of_type_Int = i;
      if (!paramMatchUinData.str_from_city_name.has()) {
        break label876;
      }
      localObject1 = paramMatchUinData.str_from_city_name.get();
      label805:
      paramasgn.j = ((String)localObject1);
      if (!paramMatchUinData.str_to_city_name.has()) {
        break label883;
      }
    }
    label876:
    label883:
    for (paramMatchUinData = paramMatchUinData.str_to_city_name.get();; paramMatchUinData = "")
    {
      paramasgn.k = paramMatchUinData;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "ChatFriendInfo. " + paramasgn.toString());
      return;
      i = -1;
      break label755;
      localObject1 = "";
      break label805;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, new EditExtendFriendInfo.RspBody());
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, "handleUpdateExtendFriendCampusSchoolInfo,result = " + i);
    }
    if (i == 0)
    {
      paramFromServiceMsg = (asfu)this.mApp.getManager(264);
      if (paramFromServiceMsg != null)
      {
        i = paramToServiceMsg.extraData.getInt("idx", 0);
        paramObject = paramToServiceMsg.extraData.getString("school_name", "");
        String str = paramToServiceMsg.extraData.getString("school_id", "");
        int j = paramToServiceMsg.extraData.getInt("school_category", 0);
        paramFromServiceMsg.a(paramToServiceMsg.extraData.getInt("school_certi_status", 0), 1);
        paramFromServiceMsg.a(i, paramObject, str, j);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      notifyUI(22, bool, null);
      return;
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_0xe52.RspBody());
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, "handleCertificateConfirmSchool,result = " + i);
    }
    if (i == 0) {}
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0xdb1.RspBody localRspBody = new oidb_0xdb1.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, new Object[] { "handleGetCampusCertificateStatusResponse. result = ", Integer.valueOf(i) });
    }
    if (i == 0)
    {
      paramObject = (asfu)this.mApp.getManager(264);
      if (paramObject != null) {
        paramObject.a(paramToServiceMsg, paramFromServiceMsg, localRspBody);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      notifyUI(20, bool, new Object[] { Integer.valueOf(1) });
      return;
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      Object localObject = new oidb_0xe09.RspBody();
      i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      if (i != 0) {
        break label266;
      }
      paramFromServiceMsg = new ArrayList();
      try
      {
        if (!((oidb_0xe09.RspBody)localObject).rpt_online_info.has()) {
          break label231;
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
        label231:
        paramFromServiceMsg = null;
        label266:
        continue;
        label367:
        continue;
        label370:
        continue;
        label373:
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
          break label367;
        }
        paramToServiceMsg = new ArrayList();
        if ((paramFromServiceMsg == null) || (paramFromServiceMsg.isEmpty())) {
          break label373;
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
        break label370;
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
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      Object localObject = new oidb_0xe51.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("selfUin");
      paramObject = paramToServiceMsg.extraData.getString("friendUin");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("friendNick");
      if (i == 0)
      {
        localObject = ((oidb_0xe51.RspBody)localObject).bytes_sig.get().toByteArray();
        if ((this.app != null) && (this.app.a() != null))
        {
          this.app.a().a(paramObject, paramFromServiceMsg, (byte[])localObject, false);
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendHandler", 2, "handleGetSigByOxb4cCode() success -> addMatchChatSessionKey");
          }
          notifyUI(21, true, new Object[] { paramObject, paramToServiceMsg });
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendHandler", 2, "handleGetSigByOxb4cCode() fail result=" + i);
        }
        notifyUI(21, false, new Object[] { paramObject, Integer.valueOf(i) });
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("ExtendFriendHandler", 1, "handleGetSigByOxb4cCode() fail.", paramToServiceMsg);
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      try
      {
        oidb_0xe67.RspBody localRspBody = new oidb_0xe67.RspBody();
        int j = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
        int k = paramToServiceMsg.extraData.getInt("uint32_action", -1);
        if (localRspBody.uint32_flare_switch.has())
        {
          i = localRspBody.uint32_flare_switch.get();
          if ((k == 1) && (i == 1))
          {
            if (((asfu)this.app.getManager(264)).c())
            {
              paramToServiceMsg = "1";
              bcst.b(null, "dc00898", "", "", "0X800AE9B", "0X800AE9B", 0, 0, "", paramToServiceMsg, "", "");
            }
          }
          else
          {
            QLog.i("ExtendFriendHandler", 2, "handleExtendFriendEnterAndQuit  result=" + j + "[0is exit] type:" + k + " signalSwitch:" + i);
            return;
          }
          paramToServiceMsg = "2";
          continue;
        }
        int i = -1;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("ExtendFriendHandler", 1, "handleExtendFriendEnterAndQuitReport() fail.", paramToServiceMsg);
        return;
      }
    }
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
    if (!awie.a(this.app))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ExtendFriendHandler", 2, "calcMatchChatBoxUnreadCount isMatchChatRedPointSwitchOn false");
      }
      return;
    }
    b();
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
        localObject1 = new ashi();
        ((ashi)localObject1).jdField_a_of_type_Boolean = paramMessageRecord.bEnterMsg;
        ((ashi)localObject1).jdField_a_of_type_Int = paramMessageRecord.leaveChatType;
        ((ashi)localObject1).jdField_a_of_type_Long = paramMessageRecord.timeStamp;
        ((ashi)localObject1).jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
        ((ashi)localObject1).jdField_b_of_type_JavaLangString = paramMessageRecord.SenderNickName;
        ((ashi)localObject1).jdField_d_of_type_Int = paramMessageRecord.c2cExpiredTime;
        ((ashi)localObject1).jdField_b_of_type_Int = paramMessageRecord.leftChatTime;
        ((ashi)localObject1).jdField_c_of_type_JavaLangString = paramMessageRecord.tipsWording;
        ((ashi)localObject1).jdField_c_of_type_Int = paramMessageRecord.matchExpiredTime;
        ((ashi)localObject1).jdField_b_of_type_Long = paramMessageRecord.readyTs;
        QLog.i("ExtendFriendHandlerExtendFriendLimitChat", 2, "HandleC2CConfirmOrCancelMsg  info：" + ((ashi)localObject1).toString());
        i = 1;
        j = i;
        if (!bgnr.b(paramMessageRecord.issend)) {
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
  
  public void a(EditExtendFriendInfo.SchoolInfo paramSchoolInfo)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, "updateExtendFriendCampusSchoolInfo ");
    }
    for (;;)
    {
      try
      {
        localObject = new EditExtendFriendInfo.ReqBody();
        ((EditExtendFriendInfo.ReqBody)localObject).msg_school_info.set(paramSchoolInfo);
        ToServiceMsg localToServiceMsg = makeOIDBPkg("OidbSvc.0xb4b_6", 2891, 6, ((EditExtendFriendInfo.ReqBody)localObject).toByteArray());
        if (paramSchoolInfo.uint32_idx.has())
        {
          i = paramSchoolInfo.uint32_idx.get();
          localToServiceMsg.extraData.putInt("idx", i);
          if (!paramSchoolInfo.str_school_name.has()) {
            break label305;
          }
          localObject = paramSchoolInfo.str_school_name.get();
          localToServiceMsg.extraData.putString("school_name", (String)localObject);
          String str;
          if (paramSchoolInfo.str_school_id.has())
          {
            str = paramSchoolInfo.str_school_id.get();
            localToServiceMsg.extraData.putString("school_id", str);
            if (paramSchoolInfo.uint32_category.has())
            {
              i = paramSchoolInfo.uint32_category.get();
              localToServiceMsg.extraData.putInt("school_category", i);
              i = j;
              if (paramSchoolInfo.uint32_verified.has()) {
                i = paramSchoolInfo.uint32_verified.get();
              }
              localToServiceMsg.extraData.putInt("school_certi_status", i);
              if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendHandler", 2, "updateExtendFriendCampusSchoolInfo ,schoolName = " + (String)localObject + ",verify status = " + i);
              }
              sendPbReq(localToServiceMsg);
            }
          }
          else
          {
            str = "";
            continue;
          }
          i = 0;
          continue;
        }
        int i = 0;
      }
      catch (NumberFormatException paramSchoolInfo)
      {
        QLog.d("ExtendFriendHandler", 1, "updateExtendFriendCampusSchoolInfo. error = " + paramSchoolInfo);
        return;
      }
      continue;
      label305:
      Object localObject = "";
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
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.i("ExtendFriendHandler", 1, String.format("editExtendFriendInfo uin=%s, declaration=%s, url=%s, duration=%d", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1) }));
    if (!NetworkState.isNetworkConnected(this.app.getApp()))
    {
      QQToast.a(this.app.getApp(), 1, 2131693946, 0).a();
      notifyUI(1, false, null);
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      paramInt4 = 0;
      paramInt2 = 0;
    }
    new bhhm("QC.UniBusinessLogicServer.UniBusinessLogicObj", "QCUniBusinessLogic.UniSetExtFriend").a("UniSetExtFriend", new UniSetExtFriendReq(bhhm.a(), new UniBusinessItem(304, paramInt4), new ExtendFriend(paramInt2)), new UniSetExtFriendRsp(), new asft(this, paramString1, paramInt4, paramInt2), true);
    try
    {
      Object localObject = new EditExtendFriendInfo.ReqBody();
      ((EditExtendFriendInfo.ReqBody)localObject).uint64_uin.set(Long.parseLong(paramString1));
      ((EditExtendFriendInfo.ReqBody)localObject).bytes_declaration.set(ByteStringMicro.copyFromUtf8(paramString2));
      ((EditExtendFriendInfo.ReqBody)localObject).bytes_voice_url.set(ByteStringMicro.copyFromUtf8(paramString3));
      ((EditExtendFriendInfo.ReqBody)localObject).uint32_voice_duration.set(paramInt1);
      localObject = makeOIDBPkg("OidbSvc.0xb4b", 2891, 0, ((EditExtendFriendInfo.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString1);
      ((ToServiceMsg)localObject).extraData.putString("declaration", paramString2);
      ((ToServiceMsg)localObject).extraData.putString("url", paramString3);
      ((ToServiceMsg)localObject).extraData.putInt("duration", paramInt1);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("ExtendFriendHandler", 1, "editExtendFriendInfo exception:" + paramString1.getMessage());
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendHandler", 2, "getSigBy0xb4cCode() friendUin= " + paramString2 + " selfUin= " + paramString1 + " _0xb4cCode =" + paramArrayOfByte);
      }
      oidb_0xe51.ReqBody localReqBody = new oidb_0xe51.ReqBody();
      localReqBody.uint64_from_uin.set(Long.parseLong(paramString1));
      localReqBody.uint64_to_uin.set(Long.parseLong(paramString2));
      localReqBody.bytes_code.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      paramArrayOfByte = makeOIDBPkg("OidbSvc.0xe51", 3665, 1, localReqBody.toByteArray());
      paramArrayOfByte.extraData.putString("selfUin", paramString1);
      paramArrayOfByte.extraData.putString("friendUin", paramString2);
      paramArrayOfByte.extraData.putString("friendNick", paramString3);
      sendPbReq(paramArrayOfByte);
      return;
    }
    catch (Exception paramString1)
    {
      notifyUI(21, false, new Object[] { paramString2, Integer.valueOf(-1) });
      QLog.e("ExtendFriendHandler", 1, "getSigBy0xb4cCode() fail.", paramString1);
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
          break label421;
        }
        localReqBody.bytes_req_page_cookies.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      catch (Exception paramString1)
      {
        ExtendFriendSquareInfo.ReqBody localReqBody;
        SosoInterface.SosoLbsInfo localSosoLbsInfo;
        ExtendFriendSquareInfo.LBSInfo localLBSInfo;
        ExtendFriendSquareInfo.GPS localGPS;
        QLog.e("ExtendFriendHandler", 1, "getSquareStrangerList fail.", paramString1);
        return;
      }
      if ((!TextUtils.isEmpty(paramString1)) && (!paramString3.equals(paramString1))) {
        localReqBody.str_keyword.set(ByteStringMicro.copyFromUtf8(paramString1));
      }
      localReqBody.uint32_req_num.set(paramInt);
      localReqBody.bytes_req_buff.set(ByteStringMicro.copyFrom(bmup.a().a()));
      paramArrayOfByte = makeOIDBPkg("OidbSvc.0xb4c", 2892, 0, localReqBody.toByteArray());
      paramArrayOfByte.setTimeout(10000L);
      paramArrayOfByte.extraData.putLong("reqTs", paramLong);
      if (!TextUtils.isEmpty(paramString2)) {
        paramArrayOfByte.extraData.putString("searchKey", paramString2);
      }
      localSosoLbsInfo = SosoInterface.a(3600000L, false, 0, true);
      if (localSosoLbsInfo != null)
      {
        localLBSInfo = new ExtendFriendSquareInfo.LBSInfo();
        localGPS = new ExtendFriendSquareInfo.GPS();
        if (localSosoLbsInfo.a != null)
        {
          localGPS.int32_lon.set((int)(localSosoLbsInfo.a.b * 1000000.0D));
          localGPS.int32_lat.set((int)(localSosoLbsInfo.a.a * 1000000.0D));
          localGPS.int32_type.set(1);
        }
        localLBSInfo.msg_gps.set(localGPS);
        localReqBody.msg_lbs_info.set(localLBSInfo);
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
          bcst.b(paramString1, "dc00898", "", "", "0X8009423", "0X8009423", paramInt, 0, "", "", paramString2, "");
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
      label421:
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
  
  public void a(submsgtype0x128.MsgBody paramMsgBody, boolean paramBoolean)
  {
    if (paramMsgBody != null)
    {
      ashh localashh = new ashh();
      localashh.jdField_a_of_type_JavaLangString = this.app.c();
      localashh.jdField_a_of_type_ArrayOfByte = paramMsgBody.bytes_sig.get().toByteArray();
      String str;
      label91:
      long l;
      label117:
      int i;
      if (paramMsgBody.uint64_match_uin.has())
      {
        str = String.valueOf(paramMsgBody.uint64_match_uin.get());
        localashh.jdField_b_of_type_JavaLangString = str;
        if (!paramMsgBody.bytes_tips_wording.has()) {
          break label472;
        }
        str = paramMsgBody.bytes_tips_wording.get().toStringUtf8();
        localashh.jdField_c_of_type_JavaLangString = str;
        if (!paramMsgBody.uint64_time_stamp.has()) {
          break label479;
        }
        l = paramMsgBody.uint64_time_stamp.get();
        localashh.jdField_a_of_type_Long = l;
        if (!paramMsgBody.uint32_match_expired_time.has()) {
          break label485;
        }
        i = paramMsgBody.uint32_match_expired_time.get();
        label142:
        localashh.jdField_a_of_type_Int = i;
        if (!paramMsgBody.bytes_nick.has()) {
          break label490;
        }
        str = paramMsgBody.bytes_nick.get().toStringUtf8();
        label170:
        localashh.jdField_d_of_type_JavaLangString = str;
        if ((!paramMsgBody.msg_tag.has()) || (!paramMsgBody.msg_tag.uint32_tag_id.has())) {
          break label504;
        }
        localashh.jdField_b_of_type_Int = paramMsgBody.msg_tag.uint32_tag_id.get();
        if (!paramMsgBody.msg_tag.bytes_tag.has()) {
          break label497;
        }
        str = paramMsgBody.msg_tag.bytes_tag.get().toStringUtf8();
        label243:
        localashh.f = str;
        label250:
        if (!paramMsgBody.msg_match_uin_data.has()) {
          break label540;
        }
        localashh.jdField_a_of_type_Asgn = new asgn();
        localashh.jdField_a_of_type_Asgn.jdField_a_of_type_JavaLangString = localashh.jdField_b_of_type_JavaLangString;
        a(paramMsgBody.msg_match_uin_data, localashh.jdField_a_of_type_Asgn);
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
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "string_report_id EMPTY bUnlimitMatchPush：" + paramBoolean);
        }
        localashh.e = paramMsgBody;
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleGetUnlimitMatchOfflinePush push matchInfo = ", localashh + "bUnlimitMatchPush：" + paramBoolean });
        }
        paramMsgBody = (askk)this.app.getManager(292);
        if (paramMsgBody != null) {
          paramMsgBody.a();
        }
        if (!paramBoolean) {
          break label570;
        }
        notifyUI(16, true, new Object[] { localashh });
        return;
        str = "0";
        break;
        label472:
        str = "";
        break label91;
        label479:
        l = 0L;
        break label117;
        label485:
        i = 0;
        break label142;
        label490:
        str = "";
        break label170;
        label497:
        str = "";
        break label243;
        label504:
        localashh.jdField_b_of_type_Int = 1;
        QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "msg_tag id empty in push bUnlimitMatchPush：" + paramBoolean);
        break label250;
        label540:
        QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "msg_match_uin_data in push bUnlimitMatchPush：" + paramBoolean);
      }
      label570:
      ((asfu)this.mApp.getManager(264)).a(localashh);
      notifyUI(23, true, new Object[] { localashh.jdField_b_of_type_JavaLangString });
      return;
    }
    QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "handleGetUnlimitMatchOfflinePush failed bUnlimitMatchPush ：" + paramBoolean);
    if (paramBoolean)
    {
      notifyUI(16, false, null);
      return;
    }
    notifyUI(23, false, new Object[] { null });
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "requestLimitChatSettingOnPlusPanel+voiceMatch");
    }
    try
    {
      ToServiceMsg localToServiceMsg = makeOIDBPkg("OidbSvc.0xdb1", 3505, 1, new oidb_0xdb1.ReqBody().toByteArray());
      localToServiceMsg.extraData.putBoolean("request_from_login", paramBoolean);
      sendPbReq(localToServiceMsg);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "requestLimitChatSettingOnPlusPanel. error = " + localNumberFormatException);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, "requestCampusCertificateStatus,getSearchKeywords = " + paramBoolean1 + ",getOnlineNumber = " + paramBoolean2);
    }
    try
    {
      Object localObject1 = new oidb_0xdb1.ReqBody();
      Object localObject2 = ((oidb_0xdb1.ReqBody)localObject1).uint32_get_search_keywords;
      if (paramBoolean1) {}
      for (int i = 1;; i = 0)
      {
        ((PBUInt32Field)localObject2).set(i);
        localObject2 = ((oidb_0xdb1.ReqBody)localObject1).uint32_get_online_num;
        i = j;
        if (paramBoolean2) {
          i = 1;
        }
        ((PBUInt32Field)localObject2).set(i);
        localObject2 = (asfu)this.mApp.getManager(264);
        if (localObject2 != null)
        {
          localObject2 = ((asfu)localObject2).a();
          if (localObject2 != null)
          {
            oidb_0xdb1.LBSInfo localLBSInfo = new oidb_0xdb1.LBSInfo();
            oidb_0xdb1.GPS localGPS = new oidb_0xdb1.GPS();
            localGPS.int32_lon.set(((asgr)localObject2).jdField_b_of_type_Int);
            localGPS.int32_lat.set(((asgr)localObject2).jdField_a_of_type_Int);
            localGPS.int32_alt.set(((asgr)localObject2).jdField_c_of_type_Int);
            localGPS.int32_type.set(((asgr)localObject2).jdField_d_of_type_Int);
            localLBSInfo.msg_gps.set(localGPS);
            ((oidb_0xdb1.ReqBody)localObject1).msg_lbs_info.set(localLBSInfo);
            QLog.d("ExtendFriendHandler", 1, "requestCampusCertificateStatus. with msg_lbs_info info ");
          }
        }
        localObject1 = makeOIDBPkg("OidbSvc.0xdb1_2", 3505, 2, ((oidb_0xdb1.ReqBody)localObject1).toByteArray());
        ((ToServiceMsg)localObject1).extraData.putBoolean("key_need_get_search_keywords", paramBoolean1);
        ((ToServiceMsg)localObject1).extraData.putBoolean("key_need_get_online_number", paramBoolean2);
        sendPbReq((ToServiceMsg)localObject1);
        return;
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e("ExtendFriendHandler", 1, "requestCampusCertificateStatus. error ", localNumberFormatException);
    }
  }
  
  public boolean a()
  {
    QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "closeSignalBomb  Match.");
    try
    {
      Object localObject2 = this.mApp.getCurrentAccountUin();
      Object localObject1 = new oidb_0xe03.ReqBody();
      ((oidb_0xe03.ReqBody)localObject1).uint64_uin.set(a((String)localObject2, "closeSignalBomb"));
      ((oidb_0xe03.ReqBody)localObject1).enum_matchopcode.set(7);
      ((oidb_0xe03.ReqBody)localObject1).uint32_tag_id.set(0);
      localObject2 = (asfu)this.mApp.getManager(264);
      if (localObject2 != null)
      {
        localObject2 = ((asfu)localObject2).a();
        if (localObject2 != null)
        {
          oidb_0xe03.LBSInfo localLBSInfo = new oidb_0xe03.LBSInfo();
          oidb_0xe03.GPS localGPS = new oidb_0xe03.GPS();
          localGPS.int32_lon.set(((asgr)localObject2).jdField_b_of_type_Int);
          localGPS.int32_lat.set(((asgr)localObject2).jdField_a_of_type_Int);
          localGPS.int32_alt.set(((asgr)localObject2).jdField_c_of_type_Int);
          localGPS.int32_type.set(((asgr)localObject2).jdField_d_of_type_Int);
          localLBSInfo.msg_gps.set(localGPS);
          ((oidb_0xe03.ReqBody)localObject1).msg_lbs_info.set(localLBSInfo);
          QLog.d("ExtendFriendHandler", 1, "closeSignalBomb. with msg_lbs_info info ");
        }
      }
      localObject1 = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, ((oidb_0xe03.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putInt("match_op", 7);
      sendPbReq((ToServiceMsg)localObject1);
      return true;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "closeSignalBomb. error = " + localNumberFormatException);
    }
    return false;
  }
  
  public boolean a(int paramInt, asgr paramasgr)
  {
    asgr localasgr = paramasgr;
    if (paramasgr == null) {
      localasgr = ((asfu)this.mApp.getManager(264)).a();
    }
    QLog.e("ExtendFriendHandlerExtendFriendLimitChat", 2, "openSignalBomb  Match.   Type= " + paramInt);
    try
    {
      Object localObject = this.mApp.getCurrentAccountUin();
      paramasgr = new oidb_0xe03.ReqBody();
      paramasgr.uint64_uin.set(a((String)localObject, "openSignalBomb"));
      paramasgr.enum_matchopcode.set(6);
      paramasgr.uint32_tag_id.set(0);
      paramasgr.uint32_sex.set(paramInt);
      if (((asfu)this.mApp.getManager(264) != null) && (localasgr != null))
      {
        localObject = new oidb_0xe03.LBSInfo();
        oidb_0xe03.GPS localGPS = new oidb_0xe03.GPS();
        localGPS.int32_lon.set(localasgr.jdField_b_of_type_Int);
        localGPS.int32_lat.set(localasgr.jdField_a_of_type_Int);
        localGPS.int32_alt.set(localasgr.jdField_c_of_type_Int);
        localGPS.int32_type.set(localasgr.jdField_d_of_type_Int);
        ((oidb_0xe03.LBSInfo)localObject).msg_gps.set(localGPS);
        paramasgr.msg_lbs_info.set((MessageMicro)localObject);
        QLog.d("ExtendFriendHandler", 1, "openSignalBomb. with msg_lbs_info info ");
      }
      paramasgr = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, paramasgr.toByteArray());
      paramasgr.extraData.putInt("match_op", 6);
      sendPbReq(paramasgr);
      return true;
    }
    catch (NumberFormatException paramasgr)
    {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "openSignalBomb. error = " + paramasgr);
    }
    return false;
  }
  
  public boolean a(asgr paramasgr)
  {
    try
    {
      oidb_0xe67.ReqBody localReqBody = new oidb_0xe67.ReqBody();
      localReqBody.uint32_action.set(1);
      if (paramasgr != null)
      {
        oidb_0xe67.LBSInfo localLBSInfo = new oidb_0xe67.LBSInfo();
        oidb_0xe67.GPS localGPS = new oidb_0xe67.GPS();
        localGPS.int32_lon.set(paramasgr.jdField_b_of_type_Int);
        localGPS.int32_lat.set(paramasgr.jdField_a_of_type_Int);
        localGPS.int32_alt.set(paramasgr.jdField_c_of_type_Int);
        localGPS.int32_type.set(paramasgr.jdField_d_of_type_Int);
        localLBSInfo.msg_gps.set(localGPS);
        localReqBody.msg_lbs_info.set(localLBSInfo);
        QLog.i("ExtendFriendHandler", 1, "EnterExtendFriend. with msg_lbs_info info ");
      }
      paramasgr = makeOIDBPkg("OidbSvc.0xe67", 3687, 1, localReqBody.toByteArray());
      paramasgr.extraData.putInt("uint32_action", 1);
      sendPbReq(paramasgr);
      return true;
    }
    catch (NumberFormatException paramasgr)
    {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "EnterExtendFriend. error = " + paramasgr);
    }
    return false;
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
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "getUnlimitMatchUserInfo. uin = " + paramString1 + " matchUin:" + paramString2 + " uinType:" + paramInt);
    }
    try
    {
      oidb_0xe03.ReqBody localReqBody = new oidb_0xe03.ReqBody();
      localReqBody.uint64_uin.set(a(paramString1, "getUnlimitMatchUserInfo"));
      localReqBody.uint64_match_uin.set(a(paramString2, "getUnlimitMatchUserInfo"));
      localReqBody.enum_matchopcode.set(5);
      paramString1 = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, localReqBody.toByteArray());
      paramString1.extraData.putInt("match_op", 5);
      paramString1.extraData.putString("match_uin", paramString2);
      paramString1.extraData.putInt("uin_type", paramInt);
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
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "setUnlimitMatchStatus. uin = " + paramString + " bopen: " + paramBoolean);
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
    notifyUI(17, true, Integer.valueOf(awie.a(this.app)));
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
    label133:
    boolean bool3;
    label148:
    int m;
    ArrayList localArrayList;
    Object localObject2;
    boolean bool4;
    label288:
    label323:
    label1003:
    int n;
    label402:
    label553:
    label574:
    label1237:
    label1252:
    int j;
    if (i == 0)
    {
      for (;;)
      {
        asht localasht;
        try
        {
          if (((ExtendFriendSquareInfo.RspBody)localObject1).uint32_over.get() != 1) {
            break label1713;
          }
          bool1 = true;
          arrayOfByte = ((ExtendFriendSquareInfo.RspBody)localObject1).bytes_rsp_page_cookies.get().toByteArray();
          if (((ExtendFriendSquareInfo.RspBody)localObject1).uint32_is_profile_complete.get() != 1) {
            break label1719;
          }
          bool2 = true;
          if (((ExtendFriendSquareInfo.RspBody)localObject1).uint32_is_show_card.get() != 1) {
            break label1725;
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
          ExtendFriendSquareInfo.StrangerInfo localStrangerInfo = (ExtendFriendSquareInfo.StrangerInfo)((Iterator)localObject2).next();
          localasht = new asht();
          localasht.mUin = String.valueOf(localStrangerInfo.uint64_uin.get());
          localasht.mNickName = localStrangerInfo.bytes_nick.get().toStringUtf8();
          localasht.mGender = localStrangerInfo.uint32_gender.get();
          if (localStrangerInfo.uint32_is_my_like.get() != 1) {
            break label1731;
          }
          bool4 = true;
          localasht.mLiked = bool4;
          localasht.mAvailLikeCount = localStrangerInfo.uint32_my_left_like_count.get();
          if (localStrangerInfo.uint32_addfri_status.get() != 1) {
            break label1737;
          }
          bool4 = true;
          localasht.mAddFriendVerified = bool4;
          localasht.mPopularity = localStrangerInfo.uint32_popularity.get();
          localasht.mDeclaration = localStrangerInfo.bytes_declaration.get().toStringUtf8();
          localasht.mVoiceUrl = localStrangerInfo.bytes_voice_url.get().toStringUtf8();
          localasht.mVoiceDuration = localStrangerInfo.uint32_voice_duration.get();
          if (localStrangerInfo.uint32_vote_switch.get() != 0) {
            break label1743;
          }
          bool4 = true;
          localasht.mbAllowStrangerVote = bool4;
          localasht.mStrRecomTrace = localStrangerInfo.str_recom_trace.get();
          localasht.voiceCode = localStrangerInfo.bytes_voice_code.get().toByteArray();
          paramToServiceMsg = new PersonalInfo.ReqBody();
          paramToServiceMsg.mergeFrom(localStrangerInfo.bytes_personalization.get().toByteArray());
          localasht.fontId = paramToServiceMsg.fontid.get();
          localasht.fontType = paramToServiceMsg.fonttype.get();
          localasht.clothesId = paramToServiceMsg.itemid.get();
          if (!TextUtils.isEmpty(localasht.mDeclaration))
          {
            localasht.mDeclaration = localasht.mDeclaration.replace('\n', ' ');
            localasht.mDeclaration = localasht.mDeclaration.trim();
          }
          if (localStrangerInfo.uint32_show_vip_info_flag.get() != 0) {
            break label1749;
          }
          bool4 = true;
          localasht.mVipHide = bool4;
          if (localStrangerInfo.uint32_bigvip_open.get() != 0) {
            break label1755;
          }
          bool4 = true;
          localasht.mBigVipHide = bool4;
          localasht.mBigVipLevel = localStrangerInfo.uint32_bigvip_level.get();
          localasht.mVipType = localStrangerInfo.uint32_vip_flag.get();
          localasht.mVipLevel = localStrangerInfo.uint32_svip_level.get();
          localasht.mTemplateId = localStrangerInfo.uint32_vipicon_id.get();
          if (!localStrangerInfo.bytes_ad_content.has()) {
            break label1761;
          }
          paramToServiceMsg = AlumBasicData.a(localStrangerInfo.bytes_ad_content.get().toByteArray());
          label659:
          localasht.mAlumbasicdata = paramToServiceMsg;
          localasht.mAge = localStrangerInfo.uint32_age.get();
          localasht.mLabelInfos = new ArrayList();
          Object localObject3;
          if (localStrangerInfo.rpt_label_info.has())
          {
            i = 0;
            if (i < localStrangerInfo.rpt_label_info.get().size())
            {
              localObject3 = new ashu();
              ((ashu)localObject3).jdField_a_of_type_Long = ((ExtendFriendSquareInfo.labelInfo)localStrangerInfo.rpt_label_info.get().get(i)).uint64_label_id.get();
              if (!((ExtendFriendSquareInfo.labelInfo)localStrangerInfo.rpt_label_info.get().get(i)).str_label_name.has()) {
                break label1766;
              }
              paramToServiceMsg = ((ExtendFriendSquareInfo.labelInfo)localStrangerInfo.rpt_label_info.get().get(i)).str_label_name.get();
              label812:
              ((ashu)localObject3).jdField_a_of_type_JavaLangString = paramToServiceMsg;
              localasht.mLabelInfos.add(localObject3);
              i += 1;
              continue;
            }
          }
          localasht.mSchoolInfos = new ArrayList();
          if (localStrangerInfo.rpt_school_info.has())
          {
            i = 0;
            if (i < localStrangerInfo.rpt_school_info.get().size())
            {
              localObject3 = new ashv();
              ((ashv)localObject3).jdField_a_of_type_JavaLangString = ((ExtendFriendSquareInfo.schoolInfo)localStrangerInfo.rpt_school_info.get().get(i)).str_school_id.get();
              ((ashv)localObject3).jdField_a_of_type_Long = ((ExtendFriendSquareInfo.schoolInfo)localStrangerInfo.rpt_school_info.get().get(i)).uint64_state.get();
              if (!((ExtendFriendSquareInfo.schoolInfo)localStrangerInfo.rpt_school_info.get().get(i)).str_school_name.has()) {
                break label1771;
              }
              paramToServiceMsg = ((ExtendFriendSquareInfo.schoolInfo)localStrangerInfo.rpt_school_info.get().get(i)).str_school_name.get();
              ((ashv)localObject3).jdField_b_of_type_JavaLangString = paramToServiceMsg;
              if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendHandler", 2, "handleGetSquareStrangerList: schoolId " + ((ashv)localObject3).jdField_a_of_type_JavaLangString + " schoolName " + ((ashv)localObject3).jdField_b_of_type_JavaLangString + " authState " + ((ashv)localObject3).jdField_a_of_type_Long);
              }
              localasht.mSchoolInfos.add(localObject3);
              i += 1;
              continue;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendHandler", 2, "handleGetSquareStrangerList: " + localasht.mUin + " " + localStrangerInfo.uint32_vip_flag.get() + " " + localStrangerInfo.uint32_svip_level.get());
          }
          if ((TextUtils.isEmpty(localasht.mNickName)) && (localasht.mAlumbasicdata == null)) {
            break label1252;
          }
          localArrayList.add(localasht);
          continue;
          asmj.a().c(paramFromServiceMsg.isSuccess(), paramFromServiceMsg.getResultCode());
        }
        catch (Exception paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ExtendFriendHandler", 2, paramToServiceMsg.getMessage(), paramToServiceMsg);
          }
          notifyUI(2, false, new Object[] { Long.valueOf(l), paramObject });
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.w("ExtendFriendHandler", 2, String.format("handleGetSquareStrangerList nick name is empty, uin=%s", new Object[] { localasht.mUin }));
        }
      }
      paramToServiceMsg = new ashg();
      paramToServiceMsg.jdField_a_of_type_Int = ((ExtendFriendSquareInfo.RspBody)localObject1).uint32_match_count.get();
      paramToServiceMsg.jdField_b_of_type_Int = ((ExtendFriendSquareInfo.RspBody)localObject1).uint32_match_time.get();
      paramToServiceMsg.jdField_c_of_type_Int = ((ExtendFriendSquareInfo.RspBody)localObject1).uint32_online_num.get();
      localObject1 = new ArrayList();
      n = localArrayList.size();
      if (n <= 12)
      {
        ((List)localObject1).addAll(localArrayList);
        break label1776;
        label1367:
        while (i < ((List)localObject1).size())
        {
          paramToServiceMsg.jdField_a_of_type_JavaUtilList.add(((asht)((List)localObject1).get(i)).mUin);
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
          break label1782;
        }
        ((List)localObject1).add(localArrayList.get(i));
        k = j - 1;
        break label1782;
        if (this.app != null) {
          ((askk)this.app.getManager(292)).a(true, paramToServiceMsg);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, String.format("handleGetSquareStrangerList isOver=%s cookies=%s isProfileComplete=%s isShowCard=%s maxLikeCount=%s resultCount=%d matchCount=%d limitDuration=%d onlineNum=%d", new Object[] { Boolean.valueOf(bool1), arrayOfByte, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(m), Integer.valueOf(localArrayList.size()), Integer.valueOf(paramToServiceMsg.jdField_a_of_type_Int), Integer.valueOf(paramToServiceMsg.jdField_b_of_type_Int), Integer.valueOf(paramToServiceMsg.jdField_c_of_type_Int) }));
        }
        notifyUI(2, true, new Object[] { Long.valueOf(l), paramObject, Boolean.valueOf(bool1), arrayOfByte, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(m), localArrayList, paramToServiceMsg });
        break label1237;
        notifyUI(2, false, new Object[] { Long.valueOf(l), paramObject });
        break label1237;
        label1713:
        bool1 = false;
        break;
        label1719:
        bool2 = false;
        break label133;
        label1725:
        bool3 = false;
        break label148;
        label1731:
        bool4 = false;
        break label288;
        label1737:
        bool4 = false;
        break label323;
        label1743:
        bool4 = false;
        break label402;
        label1749:
        bool4 = false;
        break label553;
        label1755:
        bool4 = false;
        break label574;
        label1761:
        paramToServiceMsg = null;
        break label659;
        label1766:
        paramToServiceMsg = null;
        break label812;
        label1771:
        paramToServiceMsg = null;
        break label1003;
      }
      label1776:
      i = 0;
      break label1367;
      label1782:
      i += 1;
      j = k;
    }
  }
  
  public boolean b()
  {
    try
    {
      Object localObject1 = new oidb_0xe67.ReqBody();
      ((oidb_0xe67.ReqBody)localObject1).uint32_action.set(0);
      Object localObject2 = (asfu)this.mApp.getManager(264);
      if (localObject2 != null)
      {
        localObject2 = ((asfu)localObject2).a();
        if (localObject2 != null)
        {
          oidb_0xe67.LBSInfo localLBSInfo = new oidb_0xe67.LBSInfo();
          oidb_0xe67.GPS localGPS = new oidb_0xe67.GPS();
          localGPS.int32_lon.set(((asgr)localObject2).jdField_b_of_type_Int);
          localGPS.int32_lat.set(((asgr)localObject2).jdField_a_of_type_Int);
          localGPS.int32_alt.set(((asgr)localObject2).jdField_c_of_type_Int);
          localGPS.int32_type.set(((asgr)localObject2).jdField_d_of_type_Int);
          localLBSInfo.msg_gps.set(localGPS);
          ((oidb_0xe67.ReqBody)localObject1).msg_lbs_info.set(localLBSInfo);
          QLog.d("ExtendFriendHandler", 1, "QuitExtendFriend. with msg_lbs_info info ");
        }
      }
      localObject1 = makeOIDBPkg("OidbSvc.0xe67", 3687, 1, ((oidb_0xe67.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putInt("uint32_action", 0);
      sendPbReq((ToServiceMsg)localObject1);
      return true;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "QuitExtendFriend. error = " + localNumberFormatException);
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "getUnlimitMatchBaseInfo. uin = " + paramString);
    }
    try
    {
      oidb_0xe03.ReqBody localReqBody = new oidb_0xe03.ReqBody();
      localReqBody.uint64_uin.set(a(paramString, "getUnlimitMatchBaseInfo"));
      localReqBody.enum_matchopcode.set(3);
      localReqBody.uint64_client_version.set(833L);
      paramString = (asfu)this.mApp.getManager(264);
      if (paramString != null)
      {
        paramString = paramString.a();
        if (paramString != null)
        {
          oidb_0xe03.LBSInfo localLBSInfo = new oidb_0xe03.LBSInfo();
          oidb_0xe03.GPS localGPS = new oidb_0xe03.GPS();
          localGPS.int32_lon.set(paramString.jdField_b_of_type_Int);
          localGPS.int32_lat.set(paramString.jdField_a_of_type_Int);
          localGPS.int32_alt.set(paramString.jdField_c_of_type_Int);
          localGPS.int32_type.set(paramString.jdField_d_of_type_Int);
          localLBSInfo.msg_gps.set(localGPS);
          localReqBody.msg_lbs_info.set(localLBSInfo);
          QLog.d("ExtendFriendHandler", 1, "getUnlimitMatchBaseInfo. with msg_lbs_info info ");
        }
      }
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
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    QLog.i("ExtendFriendHandler", 1, String.format("handleGetExtendFriendInfo resultCode=%d", new Object[] { Integer.valueOf(i) }));
    boolean bool1 = false;
    if (i == 1000) {
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          break label1189;
        }
        bool1 = true;
        QLog.i("ExtendFriendHandler", 1, "handleGetExtendFriendInfo isSuccess=" + bool1);
        if ((!bool1) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null)) {
          break label1182;
        }
        GetExtendFriendInfo.RspBody localRspBody = new GetExtendFriendInfo.RspBody();
        localRspBody.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        String str = paramToServiceMsg.extraData.getString("uin");
        if ((!localRspBody.uint64_uin.has()) || (!String.valueOf(localRspBody.uint64_uin.get()).equals(str))) {
          break label1182;
        }
        if (!localRspBody.bytes_declaration.has()) {
          break label1195;
        }
        paramFromServiceMsg = localRspBody.bytes_declaration.get().toStringUtf8();
        if (!localRspBody.bytes_voice_url.has()) {
          break label1200;
        }
        localObject1 = localRspBody.bytes_voice_url.get().toStringUtf8();
        if (!localRspBody.uint32_popularity.has()) {
          break label1206;
        }
        i = localRspBody.uint32_popularity.get();
        if (!localRspBody.uint64_update_time.has()) {
          break label1212;
        }
        l1 = localRspBody.uint64_update_time.get();
        if (((localRspBody.uint32_is_show_card.has()) && (localRspBody.uint32_is_show_card.get() == 1)) && (!localRspBody.uint32_voice_duration.has())) {
          break label1218;
        }
        j = localRspBody.uint32_voice_duration.get();
        paramObject = new PersonalInfo.ReqBody();
        paramObject.mergeFrom(localRspBody.bytes_personalization.get().toByteArray());
        int i2 = paramObject.fontid.get();
        int i3 = paramObject.fonttype.get();
        int i4 = paramObject.itemid.get();
        paramObject = null;
        Card localCard = null;
        long l3 = -1L;
        int n = -1;
        int i1 = -1;
        Object localObject4 = paramObject;
        Object localObject3 = localCard;
        long l2 = l3;
        int m = n;
        int k = i1;
        if (localRspBody.rpt_school_info.has())
        {
          localObject4 = paramObject;
          localObject3 = localCard;
          l2 = l3;
          m = n;
          k = i1;
          if (((GetExtendFriendInfo.schoolInfo)localRspBody.rpt_school_info.get().get(0)).has())
          {
            paramObject = (GetExtendFriendInfo.schoolInfo)localRspBody.rpt_school_info.get().get(0);
            localObject4 = paramObject.str_school_id.get();
            localObject3 = paramObject.str_school_name.get();
            l2 = paramObject.uint64_state.get();
            m = paramObject.uint32_idx.get();
            k = paramObject.uint32_category.get();
          }
        }
        localCard = a(str, paramFromServiceMsg, (String)localObject1, i, l1, j, i2, i3, i4, (String)localObject4, (String)localObject3, l2, m, k);
        paramObject = new asht();
        paramObject.printStackTrace();
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        try
        {
          paramObject.mUin = str;
          paramObject.mDeclaration = paramFromServiceMsg;
          paramObject.mVoiceUrl = ((String)localObject1);
          paramObject.mPopularity = i;
          paramObject.mVoiceDuration = j;
          paramObject.mGender = localRspBody.uint32_gender.get();
          paramObject.mNickName = localRspBody.str_nick.get();
          if (localRspBody.uint32_show_vip_info_flag.get() != 0) {
            break label1224;
          }
          bool2 = true;
          paramObject.mVipHide = bool2;
          if (localRspBody.uint32_bigvip_open.get() != 0) {
            break label1230;
          }
          bool2 = true;
          paramObject.mBigVipHide = bool2;
          paramObject.mBigVipLevel = localRspBody.uint32_bigvip_level.get();
          paramObject.mVipType = localRspBody.uint32_vip_flag.get();
          paramObject.mVipLevel = localRspBody.uint32_svip_level.get();
          paramObject.mTemplateId = localRspBody.uint32_vipicon_id.get();
          if ((!TextUtils.isEmpty((CharSequence)localObject3)) || (!TextUtils.isEmpty((CharSequence)localObject4)))
          {
            paramObject.mSchoolInfos = new ArrayList();
            paramFromServiceMsg = new ashv();
            paramFromServiceMsg.jdField_b_of_type_JavaLangString = ((String)localObject3);
            paramFromServiceMsg.jdField_a_of_type_JavaLangString = ((String)localObject4);
            paramFromServiceMsg.jdField_a_of_type_Long = l2;
          }
          paramObject.mLabelInfos = new ArrayList();
          if (localRspBody.rpt_label_info.has())
          {
            i = 0;
            if (i < localRspBody.rpt_label_info.get().size())
            {
              localObject1 = new ashu();
              ((ashu)localObject1).jdField_a_of_type_Long = ((GetExtendFriendInfo.labelInfo)localRspBody.rpt_label_info.get().get(i)).uint64_label_id.get();
              if (!((GetExtendFriendInfo.labelInfo)localRspBody.rpt_label_info.get().get(i)).str_label_name.has()) {
                break label1236;
              }
              paramFromServiceMsg = ((GetExtendFriendInfo.labelInfo)localRspBody.rpt_label_info.get().get(i)).str_label_name.get();
              ((ashu)localObject1).jdField_a_of_type_JavaLangString = paramFromServiceMsg;
              paramObject.mLabelInfos.add(localObject1);
              i += 1;
              continue;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendHandler", 2, "handleGetExtendFriendInfo: " + paramObject.mUin + " " + localRspBody.uint32_show_vip_info_flag.get() + " " + localRspBody.uint32_vip_flag.get() + " " + localRspBody.uint32_svip_level.get());
          }
          paramFromServiceMsg = paramObject;
          paramObject = localCard;
          bool2 = bool1;
          if (!paramToServiceMsg.extraData.getBoolean("onlyStrangerInfo", false))
          {
            bool2 = bool1;
            if (bool1)
            {
              bool2 = bool1;
              if (paramObject == null) {
                bool2 = false;
              }
            }
            notifyUI(3, bool2, paramObject);
          }
          notifyUI(9, bool2, new Object[] { paramFromServiceMsg, Integer.valueOf(paramToServiceMsg.extraData.getInt("getStrangerInfoSeq", 0)) });
          return;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            Object localObject1;
            paramFromServiceMsg = paramObject;
            paramObject = localInvalidProtocolBufferMicroException;
          }
        }
        paramObject = paramObject;
        paramFromServiceMsg = null;
      }
      bool1 = false;
      localObject1 = null;
      QLog.e("ExtendFriendHandler", 1, "handleGetExtendFriendInfo exception:" + paramObject.getMessage());
      paramObject = localObject1;
      continue;
      QLog.e("ExtendFriendHandler", 1, String.format("handleGetExtendFriendInfo errMsg=%s", new Object[] { paramFromServiceMsg.getStringForLog() }));
      paramObject = null;
      paramFromServiceMsg = null;
      continue;
      label1182:
      paramObject = null;
      paramFromServiceMsg = null;
      continue;
      label1189:
      bool1 = false;
      continue;
      label1195:
      paramFromServiceMsg = null;
      continue;
      label1200:
      Object localObject2 = null;
      continue;
      label1206:
      i = 0;
      continue;
      label1212:
      long l1 = 0L;
      continue;
      label1218:
      int j = 0;
      continue;
      label1224:
      boolean bool2 = false;
      continue;
      label1230:
      bool2 = false;
      continue;
      label1236:
      paramFromServiceMsg = null;
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0xdb1.RspBody localRspBody = new oidb_0xdb1.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handlePlusSettingResponse. result = ", Integer.valueOf(i) });
    }
    if (paramToServiceMsg != null) {}
    for (boolean bool1 = paramToServiceMsg.extraData.getBoolean("request_from_login", false);; bool1 = false)
    {
      long l1;
      label112:
      long l2;
      label132:
      label153:
      int j;
      label174:
      boolean bool2;
      label184:
      label226:
      long l3;
      label247:
      boolean bool3;
      if (i == 0) {
        if (localRspBody.uint64_allow_kuolie.has())
        {
          l1 = localRspBody.uint64_allow_kuolie.get();
          if (!localRspBody.uint32_match_count.has()) {
            break label422;
          }
          i = localRspBody.uint32_match_count.get();
          if (!localRspBody.str_func_name.has()) {
            break label428;
          }
          paramToServiceMsg = localRspBody.str_func_name.get();
          if (!localRspBody.uint64_expire_time.has()) {
            break label434;
          }
          l2 = localRspBody.uint64_expire_time.get();
          if (!localRspBody.uint32_left_chat_time.has()) {
            break label442;
          }
          j = localRspBody.uint32_left_chat_time.get();
          if (l1 == 0L) {
            break label448;
          }
          bool2 = true;
          if (this.app != null)
          {
            if (!bool1) {
              break label454;
            }
            asli.a(this.app, bool2, j, i, paramToServiceMsg, l2);
            if (bool2) {
              notifyUI(18, true, null);
            }
          }
          if (!localRspBody.uint64_voice_match_flag.has()) {
            break label467;
          }
          l3 = localRspBody.uint64_voice_match_flag.get();
          if (l3 != 1L) {
            break label475;
          }
          bool3 = true;
          label257:
          askk.b(this.app, Boolean.valueOf(bool3));
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "handlePlusSettingResponse. lShow = " + l1 + " leftCount = " + i + " funcName = " + paramToServiceMsg + " expireTime=" + l2 + " chatTime:" + j + " voiceMatch: " + l3 + " FromLogginStep " + bool1);
          }
          notifyUI(10, true, new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), paramToServiceMsg, Long.valueOf(l2), Integer.valueOf(j) });
        }
      }
      label422:
      label428:
      label434:
      label442:
      label448:
      label454:
      label467:
      label475:
      do
      {
        return;
        l1 = 0L;
        break;
        i = -1;
        break label112;
        paramToServiceMsg = "";
        break label132;
        l2 = -1L;
        break label153;
        j = -1;
        break label174;
        bool2 = false;
        break label184;
        QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "handlePlusSettingResponse.  by voicematch not notify");
        break label226;
        l3 = -1L;
        break label247;
        bool3 = false;
        break label257;
        notifyUI(10, false, new Object[] { Boolean.valueOf(false), Integer.valueOf(-1), "", Integer.valueOf(-1), Integer.valueOf(-1) });
      } while (!QLog.isColorLevel());
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "handlePlusSettingResponse.  false result：" + i);
      return;
    }
  }
  
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
    int m;
    int n;
    label237:
    Object localObject2;
    label260:
    label368:
    long l1;
    label395:
    label420:
    int k;
    if (((oidb_0xe03.RspBody)localObject1).enum_matchopcode.has())
    {
      i = ((oidb_0xe03.RspBody)localObject1).enum_matchopcode.get();
      m = a(i);
      if (j != 0) {
        break label1956;
      }
      if ((m != 11) && (m != 15)) {
        break label1042;
      }
      n = paramToServiceMsg.extraData.getInt("uin_type", 1044);
      if (!((oidb_0xe03.RspBody)localObject1).enum_matchopretcode.has()) {
        break label830;
      }
      j = ((oidb_0xe03.RspBody)localObject1).enum_matchopretcode.get();
      if (!((oidb_0xe03.RspBody)localObject1).bytes_match_fail_wording.has()) {
        break label836;
      }
      paramFromServiceMsg = ((oidb_0xe03.RspBody)localObject1).bytes_match_fail_wording.get().toStringUtf8();
      paramToServiceMsg = (asfu)this.mApp.getManager(264);
      if (paramToServiceMsg != null) {
        paramToServiceMsg.a((oidb_0xe03.RspBody)localObject1);
      }
      if (!((oidb_0xe03.RspBody)localObject1).msg_match_info.has()) {
        break label912;
      }
      paramObject = (oidb_0xe03.MatchInfo)((oidb_0xe03.RspBody)localObject1).msg_match_info.get();
      localObject2 = new ashh();
      ((ashh)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(((oidb_0xe03.RspBody)localObject1).uint64_uin.get());
      ((ashh)localObject2).jdField_a_of_type_ArrayOfByte = paramObject.bytes_sig.get().toByteArray();
      if (!paramObject.uint64_match_uin.has()) {
        break label842;
      }
      paramToServiceMsg = String.valueOf(paramObject.uint64_match_uin.get());
      ((ashh)localObject2).jdField_b_of_type_JavaLangString = paramToServiceMsg;
      if (!paramObject.bytes_tips_wording.has()) {
        break label849;
      }
      paramToServiceMsg = paramObject.bytes_tips_wording.get().toStringUtf8();
      ((ashh)localObject2).jdField_c_of_type_JavaLangString = paramToServiceMsg;
      if (!paramObject.uint64_time_stamp.has()) {
        break label855;
      }
      l1 = paramObject.uint64_time_stamp.get();
      ((ashh)localObject2).jdField_a_of_type_Long = l1;
      if (!paramObject.uint32_match_expired_time.has()) {
        break label863;
      }
      k = paramObject.uint32_match_expired_time.get();
      label446:
      ((ashh)localObject2).jdField_a_of_type_Int = k;
      if (!paramObject.bytes_nick.has()) {
        break label870;
      }
      paramToServiceMsg = paramObject.bytes_nick.get().toStringUtf8();
      label474:
      ((ashh)localObject2).jdField_d_of_type_JavaLangString = paramToServiceMsg;
      if (!paramObject.string_report_id.has()) {
        break label1999;
      }
    }
    label577:
    label836:
    label842:
    label1999:
    for (paramToServiceMsg = paramObject.string_report_id.get();; paramToServiceMsg = "")
    {
      paramObject = paramToServiceMsg;
      if (TextUtils.isEmpty(paramToServiceMsg))
      {
        paramObject = "0";
        QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, "string_report_id EMPTY");
      }
      ((ashh)localObject2).e = paramObject;
      if (((oidb_0xe03.RspBody)localObject1).msg_match_info.msg_tag.has()) {
        if (((oidb_0xe03.RspBody)localObject1).msg_match_info.msg_tag.uint32_tag_id.has())
        {
          ((ashh)localObject2).jdField_b_of_type_Int = ((oidb_0xe03.RspBody)localObject1).msg_match_info.msg_tag.uint32_tag_id.get();
          if (((oidb_0xe03.RspBody)localObject1).msg_match_info.msg_tag.bytes_tag.has()) {
            ((ashh)localObject2).f = ((oidb_0xe03.RspBody)localObject1).msg_match_info.msg_tag.bytes_tag.get().toStringUtf8();
          }
          label616:
          if (!((oidb_0xe03.RspBody)localObject1).msg_match_info.msg_match_uin_data.has()) {
            break label900;
          }
          if (((ashh)localObject2).jdField_a_of_type_Asgn == null)
          {
            ((ashh)localObject2).jdField_a_of_type_Asgn = new asgn();
            ((ashh)localObject2).jdField_a_of_type_Asgn.jdField_a_of_type_JavaLangString = ((ashh)localObject2).jdField_b_of_type_JavaLangString;
          }
          a(((oidb_0xe03.RspBody)localObject1).msg_match_info.msg_match_uin_data, ((ashh)localObject2).jdField_a_of_type_Asgn);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse type =" + m, " uin = ", str, ", match_op = ", Integer.valueOf(i), " retCode = ", Integer.valueOf(j), " matchInfo = ", ((ashh)localObject2).toString(), " errMsg = ", paramFromServiceMsg });
        }
        notifyUI(m, true, new Object[] { Integer.valueOf(j), localObject2, Integer.valueOf(n), paramFromServiceMsg });
        return;
        break;
        j = -1;
        break label237;
        paramFromServiceMsg = "";
        break label260;
        paramToServiceMsg = "0";
        break label368;
        label849:
        paramToServiceMsg = "";
        break label395;
        label855:
        l1 = -1L;
        break label420;
        label863:
        k = 30;
        break label446;
        label870:
        paramToServiceMsg = "";
        break label474;
        QLog.e("ExtendFriendHandler", 2, "msg_tag pi pei zhu ti  ID IS NULL");
        break label577;
        QLog.e("ExtendFriendHandler", 2, "msg_tag pi pei zhu ti   not has");
        break label616;
        QLog.e("ExtendFriendHandler", 2, "msg_match_uin_data  not has");
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse type =" + m, " uin = ", str, ", match_op = ", Integer.valueOf(i), " retCode = ", Integer.valueOf(j), " errMsg = ", paramFromServiceMsg });
      }
      notifyUI(m, true, new Object[] { Integer.valueOf(j), null, Integer.valueOf(n), paramFromServiceMsg });
      return;
      boolean bool1;
      if (m == 12)
      {
        if (((oidb_0xe03.RspBody)localObject1).enum_matchopretcode.has())
        {
          j = ((oidb_0xe03.RspBody)localObject1).enum_matchopretcode.get();
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse TYPE_CANCLE_UNLIMIT_MATCH. uin = ", str, ", match_op = ", Integer.valueOf(i), " retCode = ", Integer.valueOf(j) });
          }
          if (j != 0) {
            break label1151;
          }
        }
        label1151:
        for (bool1 = true;; bool1 = false)
        {
          notifyUI(12, bool1, null);
          return;
          j = -1;
          break;
        }
      }
      if (m == 13)
      {
        if (((oidb_0xe03.RspBody)localObject1).uint32_switch.has())
        {
          j = ((oidb_0xe03.RspBody)localObject1).uint32_switch.get();
          paramFromServiceMsg = new ArrayList();
          if (!((oidb_0xe03.RspBody)localObject1).rpt_tag.has()) {
            break label1343;
          }
          k = 0;
          if (k >= ((oidb_0xe03.RspBody)localObject1).rpt_tag.size()) {
            break label1343;
          }
          paramObject = new ashw();
          localObject2 = (oidb_0xe03.TagInfo)((oidb_0xe03.RspBody)localObject1).rpt_tag.get(k);
          paramObject.jdField_a_of_type_Int = ((oidb_0xe03.TagInfo)localObject2).uint32_tag_id.get();
          if (!((oidb_0xe03.TagInfo)localObject2).bytes_tag.has()) {
            break label1331;
          }
          paramToServiceMsg = ((oidb_0xe03.TagInfo)localObject2).bytes_tag.get().toStringUtf8();
          label1278:
          paramObject.jdField_a_of_type_JavaLangString = paramToServiceMsg;
          if (!((oidb_0xe03.TagInfo)localObject2).uint32_hot_flag.has()) {
            break label1337;
          }
        }
        for (m = ((oidb_0xe03.TagInfo)localObject2).uint32_hot_flag.get();; m = 0)
        {
          paramObject.jdField_b_of_type_Int = m;
          paramFromServiceMsg.add(paramObject);
          k += 1;
          break label1207;
          j = 0;
          break;
          paramToServiceMsg = "";
          break label1278;
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
        long l2;
        label1488:
        boolean bool2;
        if (j != 0)
        {
          bool1 = true;
          if (!((oidb_0xe03.RspBody)localObject1).uint64_voice_match_flag.has()) {
            break label1701;
          }
          l1 = ((oidb_0xe03.RspBody)localObject1).uint64_voice_match_flag.get();
          if (!((oidb_0xe03.RspBody)localObject1).uint32_flare_switch.has()) {
            break label1709;
          }
          l2 = ((oidb_0xe03.RspBody)localObject1).uint32_flare_switch.get();
          if (l1 != 1L) {
            break label1717;
          }
          bool2 = true;
          label1498:
          if (l2 != 1L) {
            break label1723;
          }
        }
        for (boolean bool3 = true;; bool3 = false)
        {
          notifyUI(13, true, new Object[] { paramFromServiceMsg, Boolean.valueOf(bool1), Integer.valueOf(k), paramToServiceMsg, Boolean.valueOf(bool3) });
          askk.a(this.app, Boolean.valueOf(bool1));
          askk.b(this.app, Boolean.valueOf(bool2));
          askk.a(this.app, paramFromServiceMsg);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. TYPE_GET_UNLIMIT_TAG uin = ", str, ", match_op = ", i + " tagList  :" + paramFromServiceMsg.toString() + " 勿扰 switch:" + bool1 + " voiceMatchF: " + l1 + " bSingalBombFlagOpen" + l2 + " uinList size" + paramToServiceMsg.size() });
          return;
          bool1 = false;
          break label1445;
          l1 = -1L;
          break label1466;
          l2 = -1L;
          break label1488;
          bool2 = false;
          break label1498;
        }
      }
      if (m == 14)
      {
        bool1 = paramToServiceMsg.extraData.getBoolean("open", false);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. TYPE_SET_UNLIMIT_SWITCH uin = ", str, ", open = ", Boolean.valueOf(bool1) });
        }
        askk.a(this.app, Boolean.valueOf(bool1));
        notifyUI(14, true, null);
        return;
      }
      if (m == 15)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. TYPE_GET_UNLIMIT_FRIEND_INFO uin = ", str, ", match_op = ", Integer.valueOf(i) });
        return;
      }
      if (m == 24)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. TYPE_OPEN_SIGNAL_BOMB    match_op = ", Integer.valueOf(i) });
        return;
      }
      if (m != 25) {
        break;
      }
      ((asfu)this.mApp.getManager(264)).h();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ExtendFriendHandlerExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. TYPE_CLOSE_SIGNAL_BOMB   match_op = ", Integer.valueOf(i) });
      return;
      notifyUI(m, false, null);
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
      this.allowCmdSet.add("OidbSvc.0xb4b_6");
      this.allowCmdSet.add("OidbSvc.0xb4c");
      this.allowCmdSet.add("OidbSvc.0xb51");
      this.allowCmdSet.add("OidbSvc.0xcb5");
      this.allowCmdSet.add("OidbSvc.0xdb1");
      this.allowCmdSet.add("OidbSvc.0xdb1_2");
      this.allowCmdSet.add("OidbSvc.0xe52_3");
      this.allowCmdSet.add("OidbSvc.0xe03");
      this.allowCmdSet.add("OidbSvc.0xe09");
      this.allowCmdSet.add("OidbSvc.0xe51");
      this.allowCmdSet.add("OidbSvc.0xe67");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends anil> observerClass()
  {
    return asgf.class;
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
      if ("OidbSvc.0xcb5".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xdb1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xdb1_2".equals(paramFromServiceMsg.getServiceCmd()))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xe52_3".equals(paramFromServiceMsg.getServiceCmd()))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xb4b_6".equals(paramFromServiceMsg.getServiceCmd()))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xe03".equals(paramFromServiceMsg.getServiceCmd()))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xe09".equals(paramFromServiceMsg.getServiceCmd()))
      {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xe51".equals(paramFromServiceMsg.getServiceCmd()))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xe67".equals(paramFromServiceMsg.getServiceCmd()));
    l(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfs
 * JD-Core Version:    0.7.0.1
 */