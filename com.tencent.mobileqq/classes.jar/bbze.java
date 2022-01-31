import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.pb.funcall.VipFunCallAndRing.TGroupInfo;
import com.tencent.pb.funcall.VipFunCallAndRing.TSourceInfo;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x1Req;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x1Rsp;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x2Req;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x2Rsp;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x3Req;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x3Rsp;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x4Req;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x4Rsp;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x5Req;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x5Rsp;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoReq;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoRsp;
import com.tencent.pb.funcall.VipFunCallAndRing.TUserInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class bbze
  extends ajtd
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  final String jdField_a_of_type_JavaLangString = "VipSetFunCallHandler";
  
  public bbze(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("FunCallSvr.call");
    VipFunCallAndRing.TSsoReq localTSsoReq = new VipFunCallAndRing.TSsoReq();
    localTSsoReq.i32_implat.set(109);
    localTSsoReq.i32_cmd.set(paramInt);
    localTSsoReq.str_qq_ver.set("8.2.8");
    if ((paramObject instanceof Bundle)) {}
    for (Bundle localBundle1 = (Bundle)paramObject;; localBundle1 = null)
    {
      localBundle2 = localBundle1;
      if (localBundle1 != null) {
        break label124;
      }
      if ((2 != paramInt) && (3 != paramInt) && (5 != paramInt)) {
        break;
      }
      QLog.e("VipSetFunCallHandler", 1, "sendReqToSVR Error fcBundle==null funcType=" + paramInt);
      return;
    }
    Bundle localBundle2 = new Bundle();
    label124:
    int i = localBundle2.getInt("from");
    int j;
    switch (paramInt)
    {
    default: 
      QLog.e("VipSetFunCallHandler", 1, "sendReqToSVR Error funcType=" + paramInt);
      return;
    case 1: 
      paramObject = new VipFunCallAndRing.TSsoCmd0x1Req();
      long l = bbyt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, null).getLong("local_version", 0L);
      paramObject.u64_local_ver.set(l);
      localTSsoReq.st_cmd0x1_req.set(paramObject);
      j = 0;
    }
    for (;;)
    {
      localTSsoReq.setHasFlag(true);
      localToServiceMsg.extraData.putInt("srcType", j);
      localToServiceMsg.extraData.putInt("from", i);
      localToServiceMsg.putWupBuffer(localTSsoReq.toByteArray());
      if (QLog.isColorLevel()) {
        QLog.d("VipSetFunCallHandler", 2, "sendReqToSVR funcType=" + paramInt + ", srcType:" + j);
      }
      super.sendPbReq(localToServiceMsg);
      return;
      paramObject = new VipFunCallAndRing.TSsoCmd0x2Req();
      paramObject.u64_friend_uin.set(localBundle2.getLong("uin"));
      paramObject.str_friend_phone.set(localBundle2.getString("phone"));
      localTSsoReq.st_cmd0x2_req.set(paramObject);
      j = 0;
      continue;
      j = localBundle2.getInt("srcType", 0);
      int k = localBundle2.getInt("callId");
      int m = localBundle2.getInt("ringId");
      if (k == 0) {
        QLog.d("VipSetFunCallHandler", 1, "sendReqToSVR Error 3 callId=" + k);
      }
      paramObject = new VipFunCallAndRing.TSsoCmd0x3Req();
      paramObject.i32_funcall_id.set(k);
      paramObject.i32_ring_id.set(m);
      localTSsoReq.st_cmd0x3_req.set(paramObject);
      continue;
      paramObject = (VipFunCallAndRing.TSsoCmd0x4Req)paramObject;
      localTSsoReq.st_cmd0x4_req.set(paramObject);
      i = 1;
      j = 0;
      continue;
      paramObject = new VipFunCallAndRing.TSsoCmd0x5Req();
      j = localBundle2.getInt("srcType", 0);
      k = localBundle2.getInt("callId");
      if (k == 0) {
        QLog.e("VipSetFunCallHandler", 1, "sendReqToSVR Error 5 callId5=" + k);
      }
      paramObject.i32_funcall_id.set(k);
      localTSsoReq.st_cmd0x5_req.set(paramObject);
    }
  }
  
  protected Class<? extends ajtg> observerClass()
  {
    return bbza.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"FunCallSvr.call".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    Object localObject2;
    int j;
    int n;
    int m;
    Object localObject1;
    int i;
    for (;;)
    {
      try
      {
        localObject2 = new VipFunCallAndRing.TSsoReq();
        ((VipFunCallAndRing.TSsoReq)localObject2).mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
        if (((VipFunCallAndRing.TSsoReq)localObject2).i32_cmd.has())
        {
          j = ((VipFunCallAndRing.TSsoReq)localObject2).i32_cmd.get();
          n = paramToServiceMsg.extraData.getInt("srcType", 0);
          m = paramToServiceMsg.extraData.getInt("from");
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("srcType", n);
          if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
            break label254;
          }
          i = 1;
          if (i != 0) {
            break;
          }
          QLog.e("VipSetFunCallHandler", 1, "onReceive~ isSuccess=false ,data=" + bbmj.a((byte[])paramObject) + ", funcType=" + j);
          bded.a().a("FunCallSvr.call", 100, paramFromServiceMsg.getBusinessFailCode(), this.app.getCurrentAccountUin(), 1000277, ajyc.a(2131716772), true);
          ((Bundle)localObject1).putInt("result", -1);
          notifyUI(j, false, localObject1);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("VipSetFunCallHandler", 2, "onReceive prb.mergeFrom error: " + paramToServiceMsg.getMessage());
        return;
      }
      j = -1;
      continue;
      label254:
      i = 0;
    }
    paramToServiceMsg = new VipFunCallAndRing.TSsoRsp();
    paramToServiceMsg.mergeFrom((byte[])paramObject);
    int k = paramToServiceMsg.i32_ret.get();
    paramObject = paramToServiceMsg.str_msg.get();
    String str1 = paramToServiceMsg.str_url.get();
    String str2 = paramToServiceMsg.str_act_wording.get();
    ((Bundle)localObject1).putInt("result", k);
    paramFromServiceMsg = (bbyt)this.app.getManager(84);
    label457:
    boolean bool;
    if (QLog.isColorLevel())
    {
      QLog.d("VipSetFunCallHandler", 2, "VipSetFunCallHandler onReceive~ ret=" + k + ",msg=" + paramObject + ", url=" + str1 + ", funcType=" + j + ", srcType=" + n + ", actStr=" + str2);
      break label1609;
      QLog.e("VipSetFunCallHandler", 1, "sendReqToSVR Error funcType=" + j);
      break label1647;
      for (;;)
      {
        ((Bundle)localObject1).putString("message", paramObject);
        ((Bundle)localObject1).putString("svr_url", str1);
        ((Bundle)localObject1).putString("svr_actStr", str2);
        if (k != 0) {
          break label1592;
        }
        bool = true;
        label494:
        notifyUI(j, bool, localObject1);
        if ((i < 0) || (TextUtils.isEmpty(paramToServiceMsg))) {
          break;
        }
        localObject1 = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        paramObject = ((ajxn)localObject1).a(paramToServiceMsg);
        paramFromServiceMsg = paramObject;
        if (paramObject == null)
        {
          paramFromServiceMsg = new ExtensionInfo();
          paramFromServiceMsg.uin = paramToServiceMsg;
        }
        paramFromServiceMsg.colorRingId = i;
        paramFromServiceMsg.commingRingId = i;
        ((ajxn)localObject1).a(paramFromServiceMsg);
        return;
        if (k != 0) {
          break label1647;
        }
        localObject2 = (VipFunCallAndRing.TSsoCmd0x1Rsp)paramToServiceMsg.st_cmd0x1_rsp.get();
        long l = ((VipFunCallAndRing.TSsoCmd0x1Rsp)localObject2).u64_server_ver.get();
        paramToServiceMsg = bbyt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, null);
        if (paramToServiceMsg.getLong("local_version", 0L) == l)
        {
          if (!QLog.isColorLevel()) {
            break label1647;
          }
          QLog.d("VipSetFunCallHandler", 2, "onReceive localVer == ver.");
          paramToServiceMsg = null;
          i = -1;
        }
        else
        {
          localObject2 = (VipFunCallAndRing.TUserInfo)((VipFunCallAndRing.TSsoCmd0x1Rsp)localObject2).st_User_Info.get();
          paramToServiceMsg.edit().putLong("local_version", l).apply();
          if (QLog.isColorLevel()) {
            QLog.d("VipSetFunCallHandler", 2, "onReceive~ localVer=" + paramObject + ", ver=" + l);
          }
          if (localObject2 != null)
          {
            paramFromServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, this.app.getAccount(), ((VipFunCallAndRing.TUserInfo)localObject2).i32_common_id.get(), ((VipFunCallAndRing.TUserInfo)localObject2).i32_ring_id.get(), null, l);
            localObject3 = (VipFunCallAndRing.TSourceInfo)((VipFunCallAndRing.TUserInfo)localObject2).st_src_info.get();
            bbyt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((VipFunCallAndRing.TUserInfo)localObject2).i32_common_id.get(), null, (VipFunCallAndRing.TSourceInfo)localObject3, true);
            localObject3 = ((VipFunCallAndRing.TUserInfo)localObject2).rpt_user_groups.get();
            if ((localObject3 != null) && (((List)localObject3).size() > 0))
            {
              paramToServiceMsg.edit().putString("group", "").commit();
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                VipFunCallAndRing.TGroupInfo localTGroupInfo = (VipFunCallAndRing.TGroupInfo)((Iterator)localObject3).next();
                paramFromServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, null, localTGroupInfo.i32_group_id.get(), localTGroupInfo.i32_ring_id.get(), localTGroupInfo.u64_group_uins.get(), 0L);
                VipFunCallAndRing.TSourceInfo localTSourceInfo = (VipFunCallAndRing.TSourceInfo)localTGroupInfo.st_src_info.get();
                bbyt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTGroupInfo.i32_group_id.get(), null, localTSourceInfo, true);
              }
            }
            if (bbyt.b()) {
              paramFromServiceMsg.a(((VipFunCallAndRing.TUserInfo)localObject2).i32_common_id.get(), ((VipFunCallAndRing.TUserInfo)localObject2).i32_ring_id.get(), false, 0, null);
            }
          }
          paramToServiceMsg.edit().putLong("update_time", System.currentTimeMillis()).commit();
          paramToServiceMsg = null;
          i = -1;
          continue;
          if (k != 0) {
            break label1647;
          }
          Object localObject3 = (VipFunCallAndRing.TSsoCmd0x2Rsp)paramToServiceMsg.st_cmd0x2_rsp.get();
          localObject2 = (VipFunCallAndRing.TSsoCmd0x2Req)((VipFunCallAndRing.TSsoReq)localObject2).st_cmd0x2_req.get();
          paramToServiceMsg = String.valueOf(((VipFunCallAndRing.TSsoCmd0x2Req)localObject2).u64_friend_uin.get());
          i = ((VipFunCallAndRing.TSsoCmd0x2Rsp)localObject3).i32_funcall_id.get();
          m = bbyt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, 6, true, null);
          paramFromServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, paramToServiceMsg, i, ((VipFunCallAndRing.TSsoCmd0x2Rsp)localObject3).i32_ring_id.get(), null, 0L);
          bbyt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((VipFunCallAndRing.TSsoCmd0x2Rsp)localObject3).i32_funcall_id.get(), null, (VipFunCallAndRing.TSourceInfo)((VipFunCallAndRing.TSsoCmd0x2Rsp)localObject3).st_src_info.get(), true);
          if (bbyt.b()) {
            paramFromServiceMsg.a(i, ((VipFunCallAndRing.TSsoCmd0x2Rsp)localObject3).i32_ring_id.get(), false, 0, null);
          }
          if (i != m)
          {
            if (m != 0) {
              break label1227;
            }
            bbyt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, 2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), i);
          }
          for (;;)
          {
            ((Bundle)localObject1).putString("uin", ((VipFunCallAndRing.TSsoCmd0x2Req)localObject2).u64_friend_uin.get() + "");
            i = ((VipFunCallAndRing.TSsoCmd0x2Rsp)localObject3).i32_ring_id.get();
            break;
            label1227:
            bbyt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), i);
          }
          localObject2 = (VipFunCallAndRing.TSsoCmd0x3Req)((VipFunCallAndRing.TSsoReq)localObject2).st_cmd0x3_req.get();
          ((Bundle)localObject1).putInt("callId", ((VipFunCallAndRing.TSsoCmd0x3Req)localObject2).i32_funcall_id.get());
          if (k != 0) {
            break label1601;
          }
          paramToServiceMsg = (VipFunCallAndRing.TSsoCmd0x3Rsp)paramToServiceMsg.st_cmd0x3_rsp.get();
          paramFromServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, this.app.getAccount(), ((VipFunCallAndRing.TSsoCmd0x3Req)localObject2).i32_funcall_id.get(), ((VipFunCallAndRing.TSsoCmd0x3Req)localObject2).i32_ring_id.get(), null, 0L);
          i = ((VipFunCallAndRing.TSsoCmd0x3Req)localObject2).i32_ring_id.get();
          paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
          label1344:
          if (1 != m) {
            break label1598;
          }
          localObject3 = this.app;
          m = ((VipFunCallAndRing.TSsoCmd0x3Req)localObject2).i32_funcall_id.get();
          if (k != 0) {
            break label1655;
          }
          paramFromServiceMsg = "0";
          label1375:
          VasWebviewUtil.reportVASTo00145((AppInterface)localObject3, String.valueOf(m), "preview", "SetComCall", paramFromServiceMsg, new String[0]);
        }
      }
      localObject2 = (VipFunCallAndRing.TSsoCmd0x4Req)((VipFunCallAndRing.TSsoReq)localObject2).st_cmd0x4_req.get();
      ((Bundle)localObject1).putInt("callId", ((VipFunCallAndRing.TSsoCmd0x4Req)localObject2).i32_funcall_id.get());
      if (k == 0)
      {
        paramToServiceMsg = (VipFunCallAndRing.TSsoCmd0x4Rsp)paramToServiceMsg.st_cmd0x4_rsp.get();
        paramFromServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, null, ((VipFunCallAndRing.TSsoCmd0x4Req)localObject2).i32_funcall_id.get(), ((VipFunCallAndRing.TSsoCmd0x4Req)localObject2).i32_ring_id.get(), ((VipFunCallAndRing.TSsoCmd0x4Req)localObject2).rpt_uins.get(), 0L);
      }
      if (1 != m) {
        break label1647;
      }
      paramFromServiceMsg = this.app;
      i = ((VipFunCallAndRing.TSsoCmd0x4Req)localObject2).i32_funcall_id.get();
      if (k != 0) {
        break label1662;
      }
    }
    label1592:
    label1598:
    label1601:
    label1609:
    label1647:
    label1655:
    label1662:
    for (paramToServiceMsg = "0";; paramToServiceMsg = "1")
    {
      VasWebviewUtil.reportVASTo00145(paramFromServiceMsg, String.valueOf(i), "preview", "SetGroupCall", paramToServiceMsg, new String[0]);
      paramToServiceMsg = null;
      i = -1;
      break label457;
      if (k == 0)
      {
        paramToServiceMsg = (VipFunCallAndRing.TSsoCmd0x5Rsp)paramToServiceMsg.st_cmd0x5_rsp.get();
        paramToServiceMsg = (VipFunCallAndRing.TSsoCmd0x5Req)((VipFunCallAndRing.TSsoReq)localObject2).st_cmd0x5_req.get();
        paramFromServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, null, paramToServiceMsg.i32_funcall_id.get(), 0, null, 0L);
        paramToServiceMsg = null;
        i = -1;
        break label457;
        bool = false;
        break label494;
        break label457;
        paramToServiceMsg = null;
        i = -1;
        break label1344;
        switch (j)
        {
        }
        break;
      }
      paramToServiceMsg = null;
      i = -1;
      break label457;
      paramFromServiceMsg = "1";
      break label1375;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbze
 * JD-Core Version:    0.7.0.1
 */