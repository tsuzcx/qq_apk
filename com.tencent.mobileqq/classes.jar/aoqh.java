import QQService.BindUinResult;
import QQService.SvcDevLoginInfo;
import QQService.SvcRespKikOut;
import QQService.SvcRspBindUin;
import QQService.SvcRspDelLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;

public class aoqh
  extends aoqf
{
  public aoqh(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRespKikOut paramSvcRespKikOut)
  {
    int i = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerKickOutDev index = " + i);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRespKikOut == null)
      {
        a(52, false, new Object[] { Long.valueOf(-1L), Integer.valueOf(-1), Integer.valueOf(i) });
        return;
      }
      a(52, true, new Object[] { Long.valueOf(paramSvcRespKikOut.appid), Integer.valueOf(paramSvcRespKikOut.result), Integer.valueOf(i) });
      return;
    }
    if (paramSvcRespKikOut == null)
    {
      a(52, false, new Object[] { Long.valueOf(-1L), Integer.valueOf(-1), Integer.valueOf(i) });
      return;
    }
    a(52, false, new Object[] { Long.valueOf(-1L), Integer.valueOf(-1), Integer.valueOf(i) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspBindUin paramSvcRspBindUin)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "handlerBindUinStaus() success");
      }
      if (paramSvcRspBindUin != null)
      {
        paramToServiceMsg = paramSvcRspBindUin.vecResult;
        if (paramToServiceMsg != null)
        {
          int i = 0;
          if (i < paramToServiceMsg.size())
          {
            paramFromServiceMsg = (BindUinResult)paramToServiceMsg.get(i);
            if (paramFromServiceMsg == null) {}
            for (;;)
            {
              i += 1;
              break;
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "result iResult = " + paramFromServiceMsg.iResult + "; lUin = " + paramFromServiceMsg.lUin + "; strResult = " + paramFromServiceMsg.strResult);
              }
            }
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerBindUinStaus res no success");
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspDelLoginInfo paramSvcRspDelLoginInfo)
  {
    int i = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerDelMultiClient index = " + i);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspDelLoginInfo == null)
      {
        a(62, false, new Object[] { null, Integer.valueOf(i) });
        return;
      }
      if (paramSvcRspDelLoginInfo.iResult == 0)
      {
        a(62, true, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
        return;
      }
      a(62, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
      return;
    }
    if (paramSvcRspDelLoginInfo == null)
    {
      a(62, false, new Object[] { null, Integer.valueOf(i) });
      return;
    }
    a(62, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(58, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        int i;
        if ((paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size() > 0))
        {
          i = 0;
          if (i < paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.get(i);
            if (paramToServiceMsg != null) {}
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (paramToServiceMsg.vecGuid == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerLoginDevList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
            }
          }
          else
          {
            if (NetConnInfoCenter.GUID == null) {
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerLoginDevList NetConnInfoCenter.GUID is null");
              }
            }
            while (Arrays.equals(paramToServiceMsg.vecGuid, NetConnInfoCenter.GUID))
            {
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.remove(i);
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.add(0, paramToServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerMultiClientList Arrays true");
              }
              a(58, true, paramSvcRspGetDevLoginInfo);
              return;
              try
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerLoginDevList NetConnInfoCenter.GUID =" + bhvd.a(NetConnInfoCenter.GUID) + "; info.guid = " + bhvd.a(paramToServiceMsg.vecGuid));
                }
              }
              catch (Exception paramFromServiceMsg)
              {
                paramFromServiceMsg.printStackTrace();
              }
            }
          }
        }
      }
      a(58, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(58, false, null);
      return;
    }
    a(58, false, null);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspDelLoginInfo paramSvcRspDelLoginInfo)
  {
    int i = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerDelMultiClient index = " + i);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspDelLoginInfo == null)
      {
        a(61, false, new Object[] { null, Integer.valueOf(i) });
        return;
      }
      if (paramSvcRspDelLoginInfo.iResult == 0)
      {
        a(61, true, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
        return;
      }
      a(61, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
      return;
    }
    if (paramSvcRspDelLoginInfo == null)
    {
      a(61, false, new Object[] { null, Integer.valueOf(i) });
      return;
    }
    a(61, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(59, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        if ((paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo.size() > 0))
        {
          int j = 0;
          int i = 0;
          if (i < paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo.get(i);
            int k;
            if (paramToServiceMsg == null) {
              k = j;
            }
            for (;;)
            {
              i += 1;
              j = k;
              break;
              if (paramToServiceMsg.vecGuid != null) {
                break label152;
              }
              k = j;
              if (QLog.isColorLevel())
              {
                QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerRecentLoginDevList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
                k = j;
              }
            }
            label152:
            if (NetConnInfoCenter.GUID == null) {
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerRecentLoginDevList NetConnInfoCenter.GUID is null");
              }
            }
            for (;;)
            {
              k = j;
              if (System.currentTimeMillis() / 1000L - paramToServiceMsg.iLoginTime >= 2592000L) {
                break;
              }
              k = j;
              if (j != 0) {
                break;
              }
              k = j;
              if (paramToServiceMsg.iTerType != 3L) {
                break;
              }
              k = 1;
              a(102, true, null);
              break;
              try
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerRecentLoginDevList NetConnInfoCenter.GUID =" + bhvd.a(NetConnInfoCenter.GUID) + "; info.guid = " + bhvd.a(paramToServiceMsg.vecGuid));
                }
              }
              catch (Exception paramFromServiceMsg)
              {
                paramFromServiceMsg.printStackTrace();
              }
            }
          }
        }
        a(59, true, paramSvcRspGetDevLoginInfo);
        return;
      }
      a(59, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(59, false, null);
      return;
    }
    a(59, false, null);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspDelLoginInfo paramSvcRspDelLoginInfo)
  {
    int i = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerDelMultiClient index = " + i);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspDelLoginInfo == null)
      {
        a(51, false, new Object[] { null, Integer.valueOf(i) });
        return;
      }
      if (paramSvcRspDelLoginInfo.iResult == 0)
      {
        a(51, true, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
        return;
      }
      a(51, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
      return;
    }
    if (paramSvcRspDelLoginInfo == null)
    {
      a(51, false, new Object[] { null, Integer.valueOf(i) });
      return;
    }
    a(51, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(60, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        if ((paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo.size() > 0))
        {
          int i = 0;
          if (i < paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo.get(i);
            if (paramToServiceMsg == null) {}
            for (;;)
            {
              i += 1;
              break;
              if (paramToServiceMsg.vecGuid == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerAuthLoginDevList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
                }
              }
              else if (NetConnInfoCenter.GUID == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerAuthLoginDevList NetConnInfoCenter.GUID is null");
                }
              }
              else {
                try
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerAuthLoginDevList NetConnInfoCenter.GUID =" + bhvd.a(NetConnInfoCenter.GUID) + "; info.guid = " + bhvd.a(paramToServiceMsg.vecGuid));
                  }
                }
                catch (Exception paramToServiceMsg)
                {
                  paramToServiceMsg.printStackTrace();
                }
              }
            }
          }
        }
        a(60, true, paramSvcRspGetDevLoginInfo);
        return;
      }
      a(60, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(60, false, null);
      return;
    }
    a(60, false, null);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(50, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        int i;
        if ((paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size() > 0))
        {
          i = 0;
          if (i < paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.get(i);
            if (paramToServiceMsg != null) {}
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (paramToServiceMsg.vecGuid == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerMultiClientList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
            }
          }
          else
          {
            if (NetConnInfoCenter.GUID == null) {
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerMultiClientList NetConnInfoCenter.GUID is null");
              }
            }
            while (Arrays.equals(paramToServiceMsg.vecGuid, NetConnInfoCenter.GUID))
            {
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.remove(i);
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.add(0, paramToServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerMultiClientList Arrays true");
              }
              a(50, true, new Object[] { paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo, paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo });
              return;
              try
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerMultiClientList NetConnInfoCenter.GUID =" + bhvd.a(NetConnInfoCenter.GUID) + "; info.guid = " + bhvd.a(paramToServiceMsg.vecGuid));
                }
              }
              catch (Exception paramFromServiceMsg)
              {
                paramFromServiceMsg.printStackTrace();
              }
            }
          }
        }
      }
      a(50, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(50, false, null);
      return;
    }
    a(50, false, null);
  }
  
  public boolean a(String paramString)
  {
    return ("StatSvc.GetDevLoginInfo".equals(paramString)) || ("StatSvc.DelDevLoginInfo".equals(paramString)) || ("StatSvc.SvcReqKikOut".equals(paramString)) || ("StatSvc.BindUin".equals(paramString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("StatSvc.GetDevLoginInfo".equals(str)) {
      if (paramToServiceMsg.extraData.getLong("iGetDevListType") == 1L) {
        a(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
      }
    }
    do
    {
      return;
      if (paramToServiceMsg.extraData.getLong("iGetDevListType") == 2L)
      {
        b(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getLong("iGetDevListType") == 4L)
      {
        c(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
        return;
      }
      d(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
      return;
      if ("StatSvc.DelDevLoginInfo".equals(str))
      {
        if (paramToServiceMsg.extraData.getInt("iDelType") == 1)
        {
          a(paramToServiceMsg, paramFromServiceMsg, (SvcRspDelLoginInfo)paramObject);
          return;
        }
        if (paramToServiceMsg.extraData.getInt("iDelType") == 2)
        {
          b(paramToServiceMsg, paramFromServiceMsg, (SvcRspDelLoginInfo)paramObject);
          return;
        }
        c(paramToServiceMsg, paramFromServiceMsg, (SvcRspDelLoginInfo)paramObject);
        return;
      }
      if ("StatSvc.SvcReqKikOut".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, (SvcRespKikOut)paramObject);
        return;
      }
    } while (!"StatSvc.BindUin".equals(str));
    a(paramToServiceMsg, paramFromServiceMsg, (SvcRspBindUin)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoqh
 * JD-Core Version:    0.7.0.1
 */