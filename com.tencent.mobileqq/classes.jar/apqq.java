import NS_MINI_APP_MISC.MISC.StGetFriendPlayListV2Req;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0xcf3.oidb_0xcf3.ReqBody;
import tencent.im.oidb.oidb_0xcf3.oidb_0xcf3.RspBody;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.CommonBody;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.CommonGroupChatInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.FriendInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.MutualMarkInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.MutualScore;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.ReqBody;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.RspBody;
import tencent.im.oidb.oidb_0xd45.oidb_0xd45.ReqBody;
import tencent.im.oidb.oidb_0xd45.oidb_0xd45.RspBody;
import tencent.im.oidb.oidb_0xd4a.oidb_0xd4a.FriendData;
import tencent.im.oidb.oidb_0xd4a.oidb_0xd4a.NotFriendData;
import tencent.im.oidb.oidb_0xd4a.oidb_0xd4a.ReqBody;
import tencent.im.oidb.oidb_0xd4a.oidb_0xd4a.RspBody;
import tencent.im.oidb.oidb_0xd6c.oidb_0xd6c.ReqBody;
import tencent.im.oidb.oidb_0xd6f.oidb_0xd6f.ReqBody;
import tencent.im.oidb.oidb_0xd84.ReqBody;

public class apqq
  extends ajfb
{
  public apqq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private oidb_0xcf4.RspBody a(oidb_0xd4a.FriendData paramFriendData)
  {
    oidb_0xcf4.RspBody localRspBody = new oidb_0xcf4.RspBody();
    localRspBody.uint64_from_uin.set(paramFriendData.uint64_from_uin.get());
    localRspBody.uint64_to_uin.set(paramFriendData.uint64_to_uin.get());
    if (paramFriendData.msg_cur_mutual_mark_info.has()) {
      localRspBody.msg_cur_mutual_mark_info.set(paramFriendData.msg_cur_mutual_mark_info.get());
    }
    if (paramFriendData.msg_friend_info.has()) {
      localRspBody.msg_friend_info.set(paramFriendData.msg_friend_info.get());
    }
    if (paramFriendData.msg_common_group_chat_info.has()) {
      localRspBody.msg_common_group_chat_info.set(paramFriendData.msg_common_group_chat_info.get());
    }
    if (paramFriendData.rpt_msg_mutual_mark_info.has()) {
      localRspBody.rpt_msg_mutual_mark_info.set(paramFriendData.rpt_msg_mutual_mark_info.get());
    }
    if (paramFriendData.rpt_msg_dna_info.has()) {
      localRspBody.rpt_msg_dna_info.set(paramFriendData.rpt_msg_dna_info.get());
    }
    if (paramFriendData.rpt_msg_prefetch_mutual_mark_info.has()) {
      localRspBody.rpt_msg_prefetch_mutual_mark_info.set(paramFriendData.rpt_msg_prefetch_mutual_mark_info.get());
    }
    if (paramFriendData.rpt_msg_data_tips.has()) {
      localRspBody.rpt_msg_data_tips.set(paramFriendData.rpt_msg_data_tips.get());
    }
    if (paramFriendData.string_reddot_data.has())
    {
      oidb_0xcf4.CommonBody localCommonBody = new oidb_0xcf4.CommonBody();
      localCommonBody.uint32_oidb_cmd.set(3399);
      localCommonBody.string_oidb_body.set(paramFriendData.string_reddot_data.get());
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localCommonBody);
      localRspBody.rpt_msg_common_rspbody.set(localArrayList);
    }
    if (paramFriendData.rpt_msg_mutual_score.has()) {
      localRspBody.rpt_msg_mutual_score.set(paramFriendData.rpt_msg_mutual_score.get());
    }
    return localRspBody;
  }
  
  private oidb_0xcf4.RspBody a(oidb_0xd4a.NotFriendData paramNotFriendData)
  {
    oidb_0xcf4.RspBody localRspBody = new oidb_0xcf4.RspBody();
    localRspBody.uint64_from_uin.set(paramNotFriendData.uint64_from_uin.get());
    localRspBody.uint64_to_uin.set(paramNotFriendData.uint64_to_uin.get());
    if (paramNotFriendData.msg_common_group_chat_info.has()) {
      localRspBody.msg_common_group_chat_info.set(paramNotFriendData.msg_common_group_chat_info.get());
    }
    if (paramNotFriendData.rpt_msg_dna_info.has()) {
      localRspBody.rpt_msg_dna_info.set(paramNotFriendData.rpt_msg_dna_info.get());
    }
    return localRspBody;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_0xcf3.RspBody());
    paramToServiceMsg = paramToServiceMsg.extraData.getString("friendUin");
    if (i == 0) {
      ((apqs)this.mApp.getManager(323)).a(paramToServiceMsg);
    }
    for (boolean bool = true;; bool = false)
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, String.format("handleDisbandIntimateRelationship, friendUin: %s, isSuccess: %s, result: %s", new Object[] { paramToServiceMsg, Boolean.valueOf(bool), Integer.valueOf(i) }));
      }
      notifyUI(1, bool, new Object[] { paramToServiceMsg, Boolean.valueOf(false) });
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_0xcf4.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("friendUin");
    if (i == 0) {
      paramToServiceMsg = IntimateInfo.copyFrom(this.app, (oidb_0xcf4.RspBody)localObject);
    }
    for (boolean bool = true;; bool = false)
    {
      if (paramToServiceMsg != null)
      {
        paramObject = (apqs)this.mApp.getManager(323);
        localObject = paramObject.a(paramFromServiceMsg);
        if (localObject != null)
        {
          paramToServiceMsg.lastAnimAfterScore = ((IntimateInfo)localObject).lastAnimAfterScore;
          paramToServiceMsg.lastAnimAfterFriendDays = ((IntimateInfo)localObject).lastAnimAfterFriendDays;
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, "handleGetIntimateInfo old: " + localObject);
          }
        }
        paramObject.a(paramFromServiceMsg, paramToServiceMsg);
      }
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, String.format("handleGetIntimateInfo, isSuccess: %s, result: %s, intimateInfo: %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), paramToServiceMsg }));
      }
      notifyUI(0, bool, new Object[] { paramFromServiceMsg, paramToServiceMsg });
      return;
      paramToServiceMsg = null;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = ((Long)paramToServiceMsg.getAttribute("groupUin", Long.valueOf(0L))).longValue();
    long l2 = ((Long)paramToServiceMsg.getAttribute("fromUin", Long.valueOf(0L))).longValue();
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, "handleGetIntimateGroupRecommendUinList " + l1 + " " + l2);
    }
    paramToServiceMsg = new oidb_0xd45.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0)
    {
      l1 = paramToServiceMsg.uint64_from_uin.get();
      l2 = paramToServiceMsg.uint64_group_code.get();
      paramFromServiceMsg = new ArrayList();
      if (paramToServiceMsg.rpt_uint64_uin_list.has())
      {
        paramToServiceMsg = paramToServiceMsg.rpt_uint64_uin_list.get().iterator();
        while (paramToServiceMsg.hasNext()) {
          paramFromServiceMsg.add((Long)paramToServiceMsg.next());
        }
      }
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, "handleGetIntimateGroupRecommendUinList succ: " + l1 + " " + l2 + " " + paramFromServiceMsg.toString());
      }
      notifyUI(5, true, new Object[] { Long.valueOf(l2), paramFromServiceMsg });
      if (!paramFromServiceMsg.isEmpty()) {
        ((arwc)this.app.getManager(329)).a(l2, paramFromServiceMsg);
      }
      return;
    }
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.i("intimate_relationship", 2, "handleGetIntimateGroupRecommendUinList failed result:" + i);
    }
    notifyUI(5, false, new Object[] { Long.valueOf(l1), null });
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = ((Long)paramToServiceMsg.getAttribute("toUin", Long.valueOf(0L))).longValue();
    long l2 = ((Long)paramToServiceMsg.getAttribute("fromUin", Long.valueOf(0L))).longValue();
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, "handleSendDateTypeEventToServer " + l1 + " " + l2);
    }
    paramToServiceMsg = new oidb_0xcf4.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0)
    {
      l1 = paramToServiceMsg.uint64_from_uin.get();
      l2 = paramToServiceMsg.uint64_to_uin.get();
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, "handleSendDateTypeEventToServer succ: " + l1 + " " + l2);
      }
      notifyUI(6, true, new Object[] { Long.valueOf(l2) });
      return;
    }
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.i("intimate_relationship", 2, "handleSendDateTypeEventToServer failed result:" + i);
    }
    notifyUI(6, false, new Object[] { Long.valueOf(l1) });
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, "handleGetGroupIntimateInfos ");
    }
    Object localObject1 = paramToServiceMsg.getAttribute("exactData1");
    Object localObject2 = new oidb_0xd4a.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject2);
    if (i == 0)
    {
      paramFromServiceMsg = new HashMap(50);
      paramToServiceMsg = (arwc)this.app.getManager(329);
      paramObject = ((oidb_0xd4a.RspBody)localObject2).uint64_group_code.get() + "";
      Object localObject3;
      Object localObject4;
      if (((oidb_0xd4a.RspBody)localObject2).rpt_msg_friend_data.has())
      {
        localObject3 = ((oidb_0xd4a.RspBody)localObject2).rpt_msg_friend_data.get().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (oidb_0xd4a.FriendData)((Iterator)localObject3).next();
          Object localObject5 = a((oidb_0xd4a.FriendData)localObject4);
          localObject5 = IntimateInfo.copyFrom(this.app, (oidb_0xcf4.RspBody)localObject5);
          paramFromServiceMsg.put(Long.valueOf(((oidb_0xd4a.FriendData)localObject4).uint64_to_uin.get()), localObject5);
          paramToServiceMsg.a(paramObject, (IntimateInfo)localObject5);
        }
      }
      if (((oidb_0xd4a.RspBody)localObject2).rpt_msg_not_friend_data.has())
      {
        localObject2 = ((oidb_0xd4a.RspBody)localObject2).rpt_msg_not_friend_data.get().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (oidb_0xd4a.NotFriendData)((Iterator)localObject2).next();
          localObject4 = a((oidb_0xd4a.NotFriendData)localObject3);
          localObject4 = IntimateInfo.copyFrom(this.app, (oidb_0xcf4.RspBody)localObject4);
          paramFromServiceMsg.put(Long.valueOf(((oidb_0xd4a.NotFriendData)localObject3).uint64_to_uin.get()), localObject4);
          paramToServiceMsg.a(paramObject, (IntimateInfo)localObject4);
        }
      }
      if (com.tencent.qphone.base.util.QLog.isColorLevel())
      {
        paramObject = new StringBuilder().append("handleGetGroupIntimateInfos succ: ").append(paramObject).append(" ").append(paramFromServiceMsg.toString()).append(" ");
        if (localObject1 == null) {
          break label378;
        }
      }
      label378:
      for (paramToServiceMsg = localObject1.toString();; paramToServiceMsg = " ")
      {
        com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, paramToServiceMsg);
        notifyUI(7, true, new Object[] { paramFromServiceMsg, localObject1 });
        return;
      }
    }
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder().append("handleGetGroupIntimateInfos failed result:").append(i).append(" ");
      if (localObject1 == null) {
        break label462;
      }
    }
    label462:
    for (paramToServiceMsg = localObject1.toString();; paramToServiceMsg = " ")
    {
      com.tencent.qphone.base.util.QLog.i("intimate_relationship", 2, paramToServiceMsg);
      notifyUI(7, false, new Object[] { null, localObject1 });
      return;
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, "sendDateTypeEventToServer " + paramLong + " " + paramInt);
    }
    Object localObject = new oidb_0xcf4.ReqBody();
    long l = this.app.getLongAccountUin();
    ((oidb_0xcf4.ReqBody)localObject).uint64_from_uin.set(l);
    ((oidb_0xcf4.ReqBody)localObject).uint64_to_uin.set(paramLong);
    ((oidb_0xcf4.ReqBody)localObject).eDateType.set(paramInt);
    localObject = makeOIDBPkg("OidbSvc.0xcf4_1", 3316, 1, ((oidb_0xcf4.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("toUin", Long.valueOf(paramLong));
    ((ToServiceMsg)localObject).addAttribute("fromUin", Long.valueOf(l));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, "getIntimateGroupRecommendUinList " + paramLong1);
    }
    Object localObject = new oidb_0xd45.ReqBody();
    long l = this.app.getLongAccountUin();
    ((oidb_0xd45.ReqBody)localObject).uint64_from_uin.set(l);
    ((oidb_0xd45.ReqBody)localObject).uint64_group_code.set(paramLong1);
    localObject = makeOIDBPkg("OidbSvc.0xd45", 3397, 0, ((oidb_0xd45.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("groupUin", Long.valueOf(paramLong1));
    ((ToServiceMsg)localObject).addAttribute("fromUin", Long.valueOf(l));
    ((ToServiceMsg)localObject).setTimeout(paramLong2);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, ArrayList<Long> paramArrayList, Object paramObject)
  {
    if (paramArrayList == null) {
      return;
    }
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, "getGroupIntimateInfos " + paramLong + " " + paramArrayList.toString());
    }
    oidb_0xd4a.ReqBody localReqBody = new oidb_0xd4a.ReqBody();
    long l = this.app.getLongAccountUin();
    localReqBody.uint64_from_uin.set(l);
    localReqBody.rpt_uint64_uin_list.set(paramArrayList);
    localReqBody.uint64_group_code.set(paramLong);
    paramArrayList = makeOIDBPkg("OidbSvc.0xd4a", 3402, 0, localReqBody.toByteArray());
    if (paramObject != null) {
      paramArrayList.addAttribute("exactData1", paramObject);
    }
    sendPbReq(paramArrayList);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 1, "getIntimateInfo friendUin is empty!");
      notifyUI(0, false, null);
      return;
    }
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, String.format("getIntimateInfo, friendUin: %s", new Object[] { paramString }));
    }
    try
    {
      Object localObject1 = new oidb_0xcf4.ReqBody();
      oidb_0xcf4.CommonBody localCommonBody = new oidb_0xcf4.CommonBody();
      Object localObject2 = new ArrayList();
      Object localObject3 = new oidb_0xd6c.ReqBody();
      ((oidb_0xd6c.ReqBody)localObject3).uint64_host_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
      ((oidb_0xd6c.ReqBody)localObject3).uint64_friend_uin.set(Long.valueOf(paramString).longValue());
      localCommonBody.uint32_oidb_cmd.set(3436);
      localCommonBody.string_oidb_body.set(ByteStringMicro.copyFrom(((oidb_0xd6c.ReqBody)localObject3).toByteArray()));
      ((ArrayList)localObject2).add(localCommonBody);
      ((oidb_0xcf4.ReqBody)localObject1).rpt_msg_common_reqbody.set((List)localObject2);
      ((oidb_0xcf4.ReqBody)localObject1).uint64_from_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
      ((oidb_0xcf4.ReqBody)localObject1).uint64_to_uin.set(Long.valueOf(paramString).longValue());
      ((oidb_0xcf4.ReqBody)localObject1).bool_qzone_dna.set(true);
      localCommonBody = new oidb_0xcf4.CommonBody();
      localCommonBody.uint32_oidb_cmd.set(3460);
      localObject2 = new MISC.StGetFriendPlayListV2Req();
      ((MISC.StGetFriendPlayListV2Req)localObject2).friendUin.set(paramString);
      ((MISC.StGetFriendPlayListV2Req)localObject2).pageSize.set(1);
      localObject3 = new oidb_0xd84.ReqBody();
      ((oidb_0xd84.ReqBody)localObject3).bytes_xmitinfo.set(ByteStringMicro.copyFrom(((MISC.StGetFriendPlayListV2Req)localObject2).toByteArray()));
      localCommonBody.string_oidb_body.set(ByteStringMicro.copyFrom(((oidb_0xd84.ReqBody)localObject3).toByteArray()));
      ((oidb_0xcf4.ReqBody)localObject1).rpt_msg_common_reqbody.add(localCommonBody);
      localObject1 = makeOIDBPkg("OidbSvc.0xcf4", 3316, 0, ((oidb_0xcf4.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("friendUin", paramString);
      sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      notifyUI(0, false, new Object[] { paramString, null });
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 1, "disbandIntimateRelationship friendUin is empty!");
      notifyUI(1, false, null);
      return;
    }
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 2, String.format("disbandIntimateRelationship, friendUin: %s, relationshipType: %s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    try
    {
      Object localObject = new oidb_0xcf3.ReqBody();
      ((oidb_0xcf3.ReqBody)localObject).sub_cmd.set(2);
      ((oidb_0xcf3.ReqBody)localObject).target_uin.set(Long.valueOf(paramString).longValue());
      ((oidb_0xcf3.ReqBody)localObject).intimate_type.set(paramInt);
      localObject = makeOIDBPkg("OidbSvc.0xcf3", 3315, 0, ((oidb_0xcf3.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("friendUin", paramString);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      com.tencent.qphone.base.util.QLog.d("intimate_relationship", 1, "disbandIntimateRelationship", localException);
      notifyUI(1, false, new Object[] { paramString, Boolean.valueOf(false) });
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.i("intimate_relationship", 0, String.format("receive disband intimateLover: retcode %s, errmsg %s", new Object[] { Integer.valueOf(paramInt), paramString1 }));
    }
    notifyUI(1, paramBoolean, new Object[] { paramString2, Boolean.valueOf(false) });
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    notifyUI(4, paramBoolean, new Object[] { paramString1, paramString2, paramString3 });
  }
  
  public void b(String paramString)
  {
    try
    {
      oidb_0xd6f.ReqBody localReqBody = new oidb_0xd6f.ReqBody();
      localReqBody.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
      localReqBody.uint64_frd_uin.set(Long.valueOf(paramString).longValue());
      localReqBody.uint32_source.set(1);
      mmj.a(this.app, new apqr(this), localReqBody.toByteArray(), "OidbSvc.0xd6f_0", 3439, 0);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      notifyUI(0, false, new Object[] { paramString, null });
    }
  }
  
  public List<ajfe> getObservers(int paramInt)
  {
    return this.mApp.getBusinessObserver(paramInt);
  }
  
  protected Class<? extends ajfe> observerClass()
  {
    return apqw.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      return;
      if ("OidbSvc.0xcf3".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xcf4".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xd45".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xcf4_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xd4a".equals(paramFromServiceMsg.getServiceCmd()));
    e(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apqq
 * JD-Core Version:    0.7.0.1
 */