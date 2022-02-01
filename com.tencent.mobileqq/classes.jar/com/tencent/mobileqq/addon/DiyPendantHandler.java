package com.tencent.mobileqq.addon;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.pendant.DiyAddonPbInfo.AddonGetDiyInfoReq;
import com.tencent.pb.pendant.DiyAddonPbInfo.AddonGetDiyInfoRsp;
import com.tencent.pb.pendant.DiyAddonPbInfo.AddonReqComm;
import com.tencent.pb.pendant.DiyAddonPbInfo.ReadAddonReq;
import com.tencent.pb.pendant.DiyAddonPbInfo.ReadAddonRsp;
import com.tencent.pb.pendant.DiyAddonUser.UserDiyInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DiyPendantHandler
  extends BusinessHandler
{
  private QQAppInterface a;
  
  public DiyPendantHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  public void a(List<Long> paramList, BusinessObserver paramBusinessObserver)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("try fetchDiyPendants: ");
        ((StringBuilder)localObject).append(TextUtils.join(",", paramList));
        QLog.i("DiyPendantHandler", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new DiyAddonPbInfo.AddonReqComm();
      ((DiyAddonPbInfo.AddonReqComm)localObject).platform.set(109L);
      ((DiyAddonPbInfo.AddonReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((DiyAddonPbInfo.AddonReqComm)localObject).mqqver.set("8.7.0");
      DiyAddonPbInfo.AddonGetDiyInfoReq localAddonGetDiyInfoReq = new DiyAddonPbInfo.AddonGetDiyInfoReq();
      localAddonGetDiyInfoReq.uin.set(paramList);
      paramList = new DiyAddonPbInfo.ReadAddonReq();
      paramList.cmd.set(1);
      paramList.comm.set((MessageMicro)localObject);
      paramList.packetseq.set(System.currentTimeMillis());
      paramList.reqcmd0x01.set(localAddonGetDiyInfoReq);
      paramBusinessObserver = super.createToServiceMsg("ReadDiyAddonInfo.1", paramBusinessObserver);
      paramBusinessObserver.putWupBuffer(paramList.toByteArray());
      super.sendPbReq(paramBusinessObserver);
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("ReadDiyAddonInfo.1"))
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      Object localObject1 = String.valueOf(paramToServiceMsg.getAttribute("_tag_LOGSTR"));
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("key_seq=");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" isSuccess=");
        ((StringBuilder)localObject2).append(bool);
        ((StringBuilder)localObject2).append(" resultCode=");
        ((StringBuilder)localObject2).append(paramFromServiceMsg.getResultCode());
        QLog.d("DiyPendantHandler", 2, ((StringBuilder)localObject2).toString());
      }
      if (bool)
      {
        paramFromServiceMsg = new DiyAddonPbInfo.ReadAddonRsp();
        try
        {
          paramFromServiceMsg = (DiyAddonPbInfo.ReadAddonRsp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        }
        catch (Exception paramFromServiceMsg)
        {
          QLog.e("DiyPendantHandler", 1, "fetch diy pendant info on response err", paramFromServiceMsg);
          paramFromServiceMsg = null;
        }
        if (paramFromServiceMsg != null)
        {
          if (paramFromServiceMsg.ret.get() != 0L)
          {
            paramObject = new StringBuilder();
            paramObject.append("fetch diy pendant info 回包 sso 成功 ，server 失败，ret = ");
            paramObject.append(paramFromServiceMsg.ret.get());
            QLog.d("DiyPendantHandler", 1, paramObject.toString());
            super.notifyUI(paramToServiceMsg, 1, false, null);
            return;
          }
          if ((paramFromServiceMsg.rspcmd0x01.has()) && (paramFromServiceMsg.rspcmd0x01.userdiyinfo.has()))
          {
            paramObject = paramFromServiceMsg.rspcmd0x01.userdiyinfo.get();
            paramFromServiceMsg = new ArrayList();
            if (paramObject != null)
            {
              paramObject = paramObject.iterator();
              while (paramObject.hasNext())
              {
                localObject1 = (DiyAddonUser.UserDiyInfo)paramObject.next();
                if ((((DiyAddonUser.UserDiyInfo)localObject1).uin.has()) && (((DiyAddonUser.UserDiyInfo)localObject1).curid.has()))
                {
                  localObject2 = new DiyPendantEntity();
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append(((DiyAddonUser.UserDiyInfo)localObject1).uin.get());
                  localStringBuilder.append("_");
                  localStringBuilder.append(((DiyAddonUser.UserDiyInfo)localObject1).curid.get());
                  ((DiyPendantEntity)localObject2).uinAndDiyId = localStringBuilder.toString();
                  ((DiyPendantEntity)localObject2).diyId = ((DiyAddonUser.UserDiyInfo)localObject1).curid.get();
                  ((DiyPendantEntity)localObject2).borderId = ((DiyAddonUser.UserDiyInfo)localObject1).frameid.get();
                  ((DiyPendantEntity)localObject2).updateTs = ((DiyAddonUser.UserDiyInfo)localObject1).updatets.get();
                  ((DiyPendantEntity)localObject2).setStickerInfoList(((DiyAddonUser.UserDiyInfo)localObject1).stickerinfo.get());
                  paramFromServiceMsg.add(localObject2);
                }
              }
            }
            DiyPendantFetcher.a().a(this.a, true, paramFromServiceMsg);
            super.notifyUI(paramToServiceMsg, 1, true, paramFromServiceMsg);
            return;
          }
          super.notifyUI(paramToServiceMsg, 1, false, null);
          return;
        }
        super.notifyUI(paramToServiceMsg, 1, false, null);
        return;
      }
      super.notifyUI(paramToServiceMsg, 1, false, null);
      if (QLog.isColorLevel()) {
        QLog.d("DiyPendantHandler", 2, "DiyText isSuccess is false sso通道  异常");
      }
    }
    else if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("cmdfilter error=");
      paramToServiceMsg.append(paramFromServiceMsg.getServiceCmd());
      QLog.d("DiyPendantHandler", 2, paramToServiceMsg.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantHandler
 * JD-Core Version:    0.7.0.1
 */