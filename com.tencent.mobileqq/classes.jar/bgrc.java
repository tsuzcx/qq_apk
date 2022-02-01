import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
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

public class bgrc
  extends BusinessHandler
{
  private QQAppInterface a;
  
  public bgrc(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  private void a(int paramInt, VipFunCallAndRing.TSsoRsp paramTSsoRsp, String paramString, bgqr parambgqr)
  {
    long l;
    if (paramInt == 0)
    {
      localObject = (VipFunCallAndRing.TSsoCmd0x1Rsp)paramTSsoRsp.st_cmd0x1_rsp.get();
      l = ((VipFunCallAndRing.TSsoCmd0x1Rsp)localObject).u64_server_ver.get();
      paramTSsoRsp = bgqr.a(this.a, 1, null);
      if (paramTSsoRsp.getLong("local_version", 0L) != l) {
        break label66;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipSetFunCallHandler", 2, "onReceive localVer == ver.");
      }
    }
    return;
    label66:
    Object localObject = (VipFunCallAndRing.TUserInfo)((VipFunCallAndRing.TSsoCmd0x1Rsp)localObject).st_User_Info.get();
    paramTSsoRsp.edit().putLong("local_version", l).apply();
    if (QLog.isColorLevel()) {
      QLog.d("VipSetFunCallHandler", 2, "onReceive~ localVer=" + paramString + ", ver=" + l);
    }
    if (localObject != null)
    {
      parambgqr.a(this.a, 0, this.app.getAccount(), ((VipFunCallAndRing.TUserInfo)localObject).i32_common_id.get(), ((VipFunCallAndRing.TUserInfo)localObject).i32_ring_id.get(), null, l);
      paramString = (VipFunCallAndRing.TSourceInfo)((VipFunCallAndRing.TUserInfo)localObject).st_src_info.get();
      bgqr.a(this.a, ((VipFunCallAndRing.TUserInfo)localObject).i32_common_id.get(), null, paramString, true);
      paramString = ((VipFunCallAndRing.TUserInfo)localObject).rpt_user_groups.get();
      if ((paramString != null) && (paramString.size() > 0))
      {
        paramTSsoRsp.edit().putString("group", "").commit();
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          VipFunCallAndRing.TGroupInfo localTGroupInfo = (VipFunCallAndRing.TGroupInfo)paramString.next();
          parambgqr.a(this.a, 1, null, localTGroupInfo.i32_group_id.get(), localTGroupInfo.i32_ring_id.get(), localTGroupInfo.u64_group_uins.get(), 0L);
          VipFunCallAndRing.TSourceInfo localTSourceInfo = (VipFunCallAndRing.TSourceInfo)localTGroupInfo.st_src_info.get();
          bgqr.a(this.a, localTGroupInfo.i32_group_id.get(), null, localTSourceInfo, true);
        }
      }
      if (bgqr.b()) {
        parambgqr.a(((VipFunCallAndRing.TUserInfo)localObject).i32_common_id.get(), ((VipFunCallAndRing.TUserInfo)localObject).i32_ring_id.get(), false, 0, null);
      }
    }
    paramTSsoRsp.edit().putLong("update_time", System.currentTimeMillis()).commit();
  }
  
  private void a(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (!TextUtils.isEmpty(paramString)))
    {
      amsw localamsw = (amsw)this.a.getManager(51);
      ExtensionInfo localExtensionInfo2 = localamsw.a(paramString);
      ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
      if (localExtensionInfo2 == null)
      {
        localExtensionInfo1 = new ExtensionInfo();
        localExtensionInfo1.uin = paramString;
      }
      localExtensionInfo1.colorRingId = paramInt;
      localExtensionInfo1.commingRingId = paramInt;
      localamsw.a(localExtensionInfo1);
    }
  }
  
  private void a(VipFunCallAndRing.TSsoReq paramTSsoReq, int paramInt1, Bundle paramBundle, int paramInt2, VipFunCallAndRing.TSsoRsp paramTSsoRsp, bgqr parambgqr)
  {
    paramTSsoReq = (VipFunCallAndRing.TSsoCmd0x4Req)paramTSsoReq.st_cmd0x4_req.get();
    paramBundle.putInt("callId", paramTSsoReq.i32_funcall_id.get());
    if (paramInt2 == 0)
    {
      paramBundle = (VipFunCallAndRing.TSsoCmd0x4Rsp)paramTSsoRsp.st_cmd0x4_rsp.get();
      parambgqr.a(this.a, 1, null, paramTSsoReq.i32_funcall_id.get(), paramTSsoReq.i32_ring_id.get(), paramTSsoReq.rpt_uins.get(), 0L);
    }
    if (1 == paramInt1)
    {
      paramBundle = this.app;
      paramInt1 = paramTSsoReq.i32_funcall_id.get();
      if (paramInt2 != 0) {
        break label121;
      }
    }
    label121:
    for (paramTSsoReq = "0";; paramTSsoReq = "1")
    {
      VasWebviewUtil.reportVASTo00145(paramBundle, String.valueOf(paramInt1), "preview", "SetGroupCall", paramTSsoReq, new String[0]);
      return;
    }
  }
  
  private void a(VipFunCallAndRing.TSsoReq paramTSsoReq, int paramInt, VipFunCallAndRing.TSsoRsp paramTSsoRsp, bgqr parambgqr)
  {
    if (paramInt == 0)
    {
      paramTSsoRsp = (VipFunCallAndRing.TSsoCmd0x5Rsp)paramTSsoRsp.st_cmd0x5_rsp.get();
      paramTSsoReq = (VipFunCallAndRing.TSsoCmd0x5Req)paramTSsoReq.st_cmd0x5_req.get();
      parambgqr.a(this.a, 2, null, paramTSsoReq.i32_funcall_id.get(), 0, null, 0L);
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, int paramInt1, Bundle paramBundle, int paramInt2)
  {
    QLog.e("VipSetFunCallHandler", 1, "onReceive~ isSuccess=false ,data=" + PkgTools.toHexStr(paramArrayOfByte) + ", funcType=" + paramInt1);
    bhvw.a().a("FunCallSvr.call", 100, paramFromServiceMsg.getBusinessFailCode(), this.app.getCurrentAccountUin(), 1000277, amtj.a(2131715787), true);
    paramBundle.putInt("result", paramInt2);
    notifyUI(paramInt1, false, paramBundle);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      if (paramInt2 == 0) {
        bgqr.a(this.a, paramString, 2, this.a.getAccount(), paramInt1);
      }
    }
    else {
      return;
    }
    bgqr.a(this.a, paramString, 1, this.a.getAccount(), paramInt1);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("FunCallSvr.call");
    VipFunCallAndRing.TSsoReq localTSsoReq = new VipFunCallAndRing.TSsoReq();
    localTSsoReq.i32_implat.set(109);
    localTSsoReq.i32_cmd.set(paramInt);
    localTSsoReq.str_qq_ver.set("8.4.8");
    if ((paramObject instanceof Bundle)) {}
    for (Bundle localBundle1 = (Bundle)paramObject;; localBundle1 = null)
    {
      localBundle2 = localBundle1;
      if (localBundle1 != null) {
        break label127;
      }
      if ((2 != paramInt) && (3 != paramInt) && (5 != paramInt)) {
        break;
      }
      QLog.e("VipSetFunCallHandler", 1, "sendReqToSVR Error fcBundle==null funcType=" + paramInt);
      return;
    }
    Bundle localBundle2 = new Bundle();
    label127:
    int i = localBundle2.getInt("from");
    int j;
    switch (paramInt)
    {
    default: 
      QLog.e("VipSetFunCallHandler", 1, "sendReqToSVR Error funcType=" + paramInt);
      return;
    case 1: 
      paramObject = new VipFunCallAndRing.TSsoCmd0x1Req();
      long l = bgqr.a(this.a, 1, null).getLong("local_version", 0L);
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
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return bgqy.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"FunCallSvr.call".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    Object localObject1;
    int j;
    int n;
    int m;
    Bundle localBundle;
    int i;
    for (;;)
    {
      try
      {
        localObject1 = new VipFunCallAndRing.TSsoReq();
        ((VipFunCallAndRing.TSsoReq)localObject1).mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
        if (((VipFunCallAndRing.TSsoReq)localObject1).i32_cmd.has())
        {
          j = ((VipFunCallAndRing.TSsoReq)localObject1).i32_cmd.get();
          n = paramToServiceMsg.extraData.getInt("srcType", 0);
          m = paramToServiceMsg.extraData.getInt("from");
          localBundle = new Bundle();
          localBundle.putInt("srcType", n);
          if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
            break label180;
          }
          i = 1;
          if (i != 0) {
            break;
          }
          a(paramFromServiceMsg, (byte[])paramObject, j, localBundle, -1);
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
      label180:
      i = 0;
    }
    Object localObject2 = new VipFunCallAndRing.TSsoRsp();
    ((VipFunCallAndRing.TSsoRsp)localObject2).mergeFrom((byte[])paramObject);
    int k = ((VipFunCallAndRing.TSsoRsp)localObject2).i32_ret.get();
    paramObject = ((VipFunCallAndRing.TSsoRsp)localObject2).str_msg.get();
    String str1 = ((VipFunCallAndRing.TSsoRsp)localObject2).str_url.get();
    String str2 = ((VipFunCallAndRing.TSsoRsp)localObject2).str_act_wording.get();
    localBundle.putInt("result", k);
    paramFromServiceMsg = (bgqr)this.app.getManager(84);
    label390:
    boolean bool;
    if (QLog.isColorLevel())
    {
      QLog.d("VipSetFunCallHandler", 2, "VipSetFunCallHandler onReceive~ ret=" + k + ",msg=" + paramObject + ", url=" + str1 + ", funcType=" + j + ", srcType=" + n + ", actStr=" + str2);
      break label863;
      QLog.e("VipSetFunCallHandler", 1, "sendReqToSVR Error funcType=" + j);
      break label907;
      for (;;)
      {
        localBundle.putString("message", paramObject);
        localBundle.putString("svr_url", str1);
        localBundle.putString("svr_actStr", str2);
        if (k != 0) {
          break;
        }
        bool = true;
        label427:
        notifyUI(j, bool, localBundle);
        a(i, paramToServiceMsg);
        return;
        a(k, (VipFunCallAndRing.TSsoRsp)localObject2, paramObject, paramFromServiceMsg);
        paramToServiceMsg = null;
        i = -1;
        continue;
        if (k != 0) {
          break label907;
        }
        localObject2 = (VipFunCallAndRing.TSsoCmd0x2Rsp)((VipFunCallAndRing.TSsoRsp)localObject2).st_cmd0x2_rsp.get();
        localObject1 = (VipFunCallAndRing.TSsoCmd0x2Req)((VipFunCallAndRing.TSsoReq)localObject1).st_cmd0x2_req.get();
        paramToServiceMsg = String.valueOf(((VipFunCallAndRing.TSsoCmd0x2Req)localObject1).u64_friend_uin.get());
        i = ((VipFunCallAndRing.TSsoCmd0x2Rsp)localObject2).i32_funcall_id.get();
        m = bgqr.a(this.a, paramToServiceMsg, 6, true, null);
        paramFromServiceMsg.a(this.a, 0, paramToServiceMsg, i, ((VipFunCallAndRing.TSsoCmd0x2Rsp)localObject2).i32_ring_id.get(), null, 0L);
        bgqr.a(this.a, ((VipFunCallAndRing.TSsoCmd0x2Rsp)localObject2).i32_funcall_id.get(), null, (VipFunCallAndRing.TSourceInfo)((VipFunCallAndRing.TSsoCmd0x2Rsp)localObject2).st_src_info.get(), true);
        if (bgqr.b()) {
          paramFromServiceMsg.a(i, ((VipFunCallAndRing.TSsoCmd0x2Rsp)localObject2).i32_ring_id.get(), false, 0, null);
        }
        a(paramToServiceMsg, i, m);
        localBundle.putString("uin", ((VipFunCallAndRing.TSsoCmd0x2Req)localObject1).u64_friend_uin.get() + "");
        i = ((VipFunCallAndRing.TSsoCmd0x2Rsp)localObject2).i32_ring_id.get();
      }
      localObject1 = (VipFunCallAndRing.TSsoCmd0x3Req)((VipFunCallAndRing.TSsoReq)localObject1).st_cmd0x3_req.get();
      localBundle.putInt("callId", ((VipFunCallAndRing.TSsoCmd0x3Req)localObject1).i32_funcall_id.get());
      if (k == 0)
      {
        paramToServiceMsg = (VipFunCallAndRing.TSsoCmd0x3Rsp)((VipFunCallAndRing.TSsoRsp)localObject2).st_cmd0x3_rsp.get();
        paramFromServiceMsg.a(this.a, 0, this.app.getAccount(), ((VipFunCallAndRing.TSsoCmd0x3Req)localObject1).i32_funcall_id.get(), ((VipFunCallAndRing.TSsoCmd0x3Req)localObject1).i32_ring_id.get(), null, 0L);
        i = ((VipFunCallAndRing.TSsoCmd0x3Req)localObject1).i32_ring_id.get();
        paramToServiceMsg = this.a.getAccount();
      }
      if (1 == m)
      {
        localObject2 = this.app;
        m = ((VipFunCallAndRing.TSsoCmd0x3Req)localObject1).i32_funcall_id.get();
        if (k != 0) {
          break label915;
        }
      }
    }
    label907:
    label915:
    for (paramFromServiceMsg = "0";; paramFromServiceMsg = "1")
    {
      VasWebviewUtil.reportVASTo00145((AppInterface)localObject2, String.valueOf(m), "preview", "SetComCall", paramFromServiceMsg, new String[0]);
      break label390;
      a((VipFunCallAndRing.TSsoReq)localObject1, m, localBundle, k, (VipFunCallAndRing.TSsoRsp)localObject2, paramFromServiceMsg);
      paramToServiceMsg = null;
      i = -1;
      break label390;
      a((VipFunCallAndRing.TSsoReq)localObject1, k, (VipFunCallAndRing.TSsoRsp)localObject2, paramFromServiceMsg);
      paramToServiceMsg = null;
      i = -1;
      break label390;
      bool = false;
      break label427;
      break label390;
      label863:
      i = -1;
      paramToServiceMsg = null;
      switch (j)
      {
      }
      break;
      paramToServiceMsg = null;
      i = -1;
      break label390;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgrc
 * JD-Core Version:    0.7.0.1
 */