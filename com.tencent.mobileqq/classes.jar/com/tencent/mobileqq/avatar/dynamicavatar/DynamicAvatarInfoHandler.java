package com.tencent.mobileqq.avatar.dynamicavatar;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.ReqBody;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;

public class DynamicAvatarInfoHandler
  extends BusinessHandler
{
  private AppInterface a;
  
  public DynamicAvatarInfoHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.a = paramAppInterface;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      oidb_0x74b.RspBody localRspBody = new oidb_0x74b.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      paramFromServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("id"));
      int j = paramToServiceMsg.extraData.getInt("type");
      int k = paramToServiceMsg.extraData.getInt("headType");
      int m = paramToServiceMsg.extraData.getInt("sizeType");
      boolean bool = paramToServiceMsg.extraData.getBoolean("isSmartMode");
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleDynamicAvatarInfo, result : ");
      paramToServiceMsg.append(i);
      QLog.i("Q.dynamicAvatar", 2, paramToServiceMsg.toString());
      if (i == 0)
      {
        paramToServiceMsg = DynamicAvatarInfo.a(localRspBody);
        notifyUI(1001, true, new Object[] { paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
        paramFromServiceMsg = (DynamicAvatarManager)this.a.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER);
        if (paramFromServiceMsg != null)
        {
          if ((this.a instanceof QQAppInterface))
          {
            paramFromServiceMsg.a(paramToServiceMsg);
            return;
          }
          paramFromServiceMsg.a(localRspBody.toByteArray());
        }
        return;
      }
      QLog.i("Q.dynamicAvatar", 1, "handleGetDynamicAvatarInfo result not success.");
      notifyUI(1001, false, new Object[] { null, paramFromServiceMsg, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
      return;
    }
    notifyUI(1001, false, null);
  }
  
  public void a(Long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(Integer.valueOf(17));
    localArrayList2.add(Integer.valueOf(18));
    ArrayList localArrayList1 = null;
    if (paramInt1 != 18)
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramLong);
    }
    else
    {
      localArrayList1 = new ArrayList();
      localArrayList1.add(paramLong);
      localObject = null;
    }
    oidb_0x74b.ReqBody localReqBody = new oidb_0x74b.ReqBody();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      localReqBody.rpt_uint64_uin.set((List)localObject);
    }
    if ((localArrayList1 != null) && (!localArrayList1.isEmpty())) {
      localReqBody.rpt_uint64_tinyid.set(localArrayList1);
    }
    if (!localArrayList2.isEmpty()) {
      localReqBody.rpt_head_type.set(localArrayList2);
    }
    Object localObject = makeOIDBPkg("OidbSvc.0x74b", 1867, 0, localReqBody.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("id", paramLong.longValue());
    ((ToServiceMsg)localObject).extraData.putInt("type", paramInt1);
    ((ToServiceMsg)localObject).extraData.putInt("headType", paramInt2);
    ((ToServiceMsg)localObject).extraData.putInt("sizeType", paramInt3);
    ((ToServiceMsg)localObject).extraData.putBoolean("isSmartMode", paramBoolean);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x74b");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return DynamicAvatarInfoObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
        return;
      }
      paramFromServiceMsg.getServiceCmd();
      if ("OidbSvc.0x74b".equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarInfoHandler
 * JD-Core Version:    0.7.0.1
 */