package com.tencent.mobileqq.app.friendlist.receiver;

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
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;

public class DeviceLoginInfoReceiver
  extends BaseHandlerReceiver
{
  public DeviceLoginInfoReceiver(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRespKikOut paramSvcRespKikOut)
  {
    Object localObject = paramToServiceMsg.extraData;
    paramToServiceMsg = Integer.valueOf(-1);
    int i = ((Bundle)localObject).getInt("index", -1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlerKickOutDev index = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRespKikOut == null)
      {
        a(51, false, new Object[] { Long.valueOf(-1L), paramToServiceMsg, Integer.valueOf(i) });
        return;
      }
      a(51, true, new Object[] { Long.valueOf(paramSvcRespKikOut.appid), Integer.valueOf(paramSvcRespKikOut.result), Integer.valueOf(i) });
      return;
    }
    if (paramSvcRespKikOut == null)
    {
      a(51, false, new Object[] { Long.valueOf(-1L), paramToServiceMsg, Integer.valueOf(i) });
      return;
    }
    a(51, false, new Object[] { Long.valueOf(-1L), paramToServiceMsg, Integer.valueOf(i) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspBindUin paramSvcRspBindUin)
  {
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "handlerBindUinStaus() success");
      }
      if (paramSvcRspBindUin != null)
      {
        paramToServiceMsg = paramSvcRspBindUin.vecResult;
        if (paramToServiceMsg != null) {
          i = 0;
        }
      }
    }
    else
    {
      while (i < paramToServiceMsg.size())
      {
        paramFromServiceMsg = (BindUinResult)paramToServiceMsg.get(i);
        if ((paramFromServiceMsg != null) && (QLog.isColorLevel()))
        {
          paramSvcRspBindUin = new StringBuilder();
          paramSvcRspBindUin.append("result iResult = ");
          paramSvcRspBindUin.append(paramFromServiceMsg.iResult);
          paramSvcRspBindUin.append("; lUin = ");
          paramSvcRspBindUin.append(paramFromServiceMsg.lUin);
          paramSvcRspBindUin.append("; strResult = ");
          paramSvcRspBindUin.append(paramFromServiceMsg.strResult);
          QLog.d("SUB_ACCOUNT", 2, paramSvcRspBindUin.toString());
        }
        i += 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerBindUinStaus res no success");
        }
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspDelLoginInfo paramSvcRspDelLoginInfo)
  {
    int i = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handlerDelMultiClient index = ");
      paramToServiceMsg.append(i);
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramToServiceMsg.toString());
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
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(57, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        if ((paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size() > 0))
        {
          int i = 0;
          while (i < paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.get(i);
            if (paramToServiceMsg != null) {
              if (paramToServiceMsg.vecGuid == null)
              {
                if (QLog.isColorLevel())
                {
                  paramFromServiceMsg = new StringBuilder();
                  paramFromServiceMsg.append("handlerLoginDevList info.vecGuid is null n =");
                  paramFromServiceMsg.append(paramToServiceMsg.strDeviceTypeInfo);
                  QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramFromServiceMsg.toString());
                }
              }
              else
              {
                if (NetConnInfoCenter.GUID == null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerLoginDevList NetConnInfoCenter.GUID is null");
                  }
                }
                else {
                  try
                  {
                    if (QLog.isColorLevel())
                    {
                      paramFromServiceMsg = new StringBuilder();
                      paramFromServiceMsg.append("handlerLoginDevList NetConnInfoCenter.GUID =");
                      paramFromServiceMsg.append(PkgTools.toHexStr(NetConnInfoCenter.GUID));
                      paramFromServiceMsg.append("; info.guid = ");
                      paramFromServiceMsg.append(PkgTools.toHexStr(paramToServiceMsg.vecGuid));
                      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramFromServiceMsg.toString());
                    }
                  }
                  catch (Exception paramFromServiceMsg)
                  {
                    paramFromServiceMsg.printStackTrace();
                  }
                }
                if (Arrays.equals(paramToServiceMsg.vecGuid, NetConnInfoCenter.GUID))
                {
                  paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.remove(i);
                  paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.add(0, paramToServiceMsg);
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerMultiClientList Arrays true");
                  break;
                }
              }
            }
            i += 1;
          }
        }
        a(57, true, paramSvcRspGetDevLoginInfo);
        return;
      }
      a(57, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(57, false, null);
      return;
    }
    a(57, false, null);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspDelLoginInfo paramSvcRspDelLoginInfo)
  {
    int i = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handlerDelMultiClient index = ");
      paramToServiceMsg.append(i);
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramToServiceMsg.toString());
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspDelLoginInfo == null)
      {
        a(60, false, new Object[] { null, Integer.valueOf(i) });
        return;
      }
      if (paramSvcRspDelLoginInfo.iResult == 0)
      {
        a(60, true, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
        return;
      }
      a(60, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
      return;
    }
    if (paramSvcRspDelLoginInfo == null)
    {
      a(60, false, new Object[] { null, Integer.valueOf(i) });
      return;
    }
    a(60, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    int i = 0;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(58, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        if ((paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo.size() > 0))
        {
          int k;
          for (int j = 0; i < paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo.size(); j = k)
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo.get(i);
            if (paramToServiceMsg == null)
            {
              k = j;
            }
            else if (paramToServiceMsg.vecGuid == null)
            {
              k = j;
              if (QLog.isColorLevel())
              {
                paramFromServiceMsg = new StringBuilder();
                paramFromServiceMsg.append("handlerRecentLoginDevList info.vecGuid is null n =");
                paramFromServiceMsg.append(paramToServiceMsg.strDeviceTypeInfo);
                QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramFromServiceMsg.toString());
                k = j;
              }
            }
            else
            {
              if (NetConnInfoCenter.GUID == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerRecentLoginDevList NetConnInfoCenter.GUID is null");
                }
              }
              else {
                try
                {
                  if (QLog.isColorLevel())
                  {
                    paramFromServiceMsg = new StringBuilder();
                    paramFromServiceMsg.append("handlerRecentLoginDevList NetConnInfoCenter.GUID =");
                    paramFromServiceMsg.append(PkgTools.toHexStr(NetConnInfoCenter.GUID));
                    paramFromServiceMsg.append("; info.guid = ");
                    paramFromServiceMsg.append(PkgTools.toHexStr(paramToServiceMsg.vecGuid));
                    QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramFromServiceMsg.toString());
                  }
                }
                catch (Exception paramFromServiceMsg)
                {
                  paramFromServiceMsg.printStackTrace();
                }
              }
              k = j;
              if (System.currentTimeMillis() / 1000L - paramToServiceMsg.iLoginTime < 2592000L)
              {
                k = j;
                if (j == 0)
                {
                  k = j;
                  if (paramToServiceMsg.iTerType == 3L)
                  {
                    a(100, true, null);
                    k = 1;
                  }
                }
              }
            }
            i += 1;
          }
        }
        a(58, true, paramSvcRspGetDevLoginInfo);
        return;
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
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspDelLoginInfo paramSvcRspDelLoginInfo)
  {
    int i = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handlerDelMultiClient index = ");
      paramToServiceMsg.append(i);
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramToServiceMsg.toString());
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspDelLoginInfo == null)
      {
        a(50, false, new Object[] { null, Integer.valueOf(i) });
        return;
      }
      if (paramSvcRspDelLoginInfo.iResult == 0)
      {
        a(50, true, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
        return;
      }
      a(50, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
      return;
    }
    if (paramSvcRspDelLoginInfo == null)
    {
      a(50, false, new Object[] { null, Integer.valueOf(i) });
      return;
    }
    a(50, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    int i = 0;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(59, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        if ((paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo.size() > 0)) {
          while (i < paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo.get(i);
            if (paramToServiceMsg != null) {
              if (paramToServiceMsg.vecGuid == null)
              {
                if (QLog.isColorLevel())
                {
                  paramFromServiceMsg = new StringBuilder();
                  paramFromServiceMsg.append("handlerAuthLoginDevList info.vecGuid is null n =");
                  paramFromServiceMsg.append(paramToServiceMsg.strDeviceTypeInfo);
                  QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramFromServiceMsg.toString());
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
                  if (QLog.isColorLevel())
                  {
                    paramFromServiceMsg = new StringBuilder();
                    paramFromServiceMsg.append("handlerAuthLoginDevList NetConnInfoCenter.GUID =");
                    paramFromServiceMsg.append(PkgTools.toHexStr(NetConnInfoCenter.GUID));
                    paramFromServiceMsg.append("; info.guid = ");
                    paramFromServiceMsg.append(PkgTools.toHexStr(paramToServiceMsg.vecGuid));
                    QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramFromServiceMsg.toString());
                  }
                }
                catch (Exception paramToServiceMsg)
                {
                  paramToServiceMsg.printStackTrace();
                }
              }
            }
            i += 1;
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
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(49, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        if ((paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size() > 0))
        {
          int i = 0;
          while (i < paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.get(i);
            if (paramToServiceMsg != null) {
              if (paramToServiceMsg.vecGuid == null)
              {
                if (QLog.isColorLevel())
                {
                  paramFromServiceMsg = new StringBuilder();
                  paramFromServiceMsg.append("handlerMultiClientList info.vecGuid is null n =");
                  paramFromServiceMsg.append(paramToServiceMsg.strDeviceTypeInfo);
                  QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramFromServiceMsg.toString());
                }
              }
              else
              {
                if (NetConnInfoCenter.GUID == null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerMultiClientList NetConnInfoCenter.GUID is null");
                  }
                }
                else {
                  try
                  {
                    if (QLog.isColorLevel())
                    {
                      paramFromServiceMsg = new StringBuilder();
                      paramFromServiceMsg.append("handlerMultiClientList NetConnInfoCenter.GUID =");
                      paramFromServiceMsg.append(PkgTools.toHexStr(NetConnInfoCenter.GUID));
                      paramFromServiceMsg.append("; info.guid = ");
                      paramFromServiceMsg.append(PkgTools.toHexStr(paramToServiceMsg.vecGuid));
                      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramFromServiceMsg.toString());
                    }
                  }
                  catch (Exception paramFromServiceMsg)
                  {
                    paramFromServiceMsg.printStackTrace();
                  }
                }
                if (Arrays.equals(paramToServiceMsg.vecGuid, NetConnInfoCenter.GUID))
                {
                  paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.remove(i);
                  paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.add(0, paramToServiceMsg);
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handlerMultiClientList Arrays true");
                  break;
                }
              }
            }
            i += 1;
          }
        }
        a(49, true, new Object[] { paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo, paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo });
        return;
      }
      a(49, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(49, false, null);
      return;
    }
    a(49, false, null);
  }
  
  public boolean a(String paramString)
  {
    return ("StatSvc.GetDevLoginInfo".equals(paramString)) || ("StatSvc.DelDevLoginInfo".equals(paramString)) || ("StatSvc.SvcReqKikOut".equals(paramString)) || ("StatSvc.BindUin".equals(paramString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("StatSvc.GetDevLoginInfo".equals(str))
    {
      if (paramToServiceMsg.extraData.getLong("iGetDevListType") == 1L)
      {
        a(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
        return;
      }
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
    }
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
    if ("StatSvc.BindUin".equals(str)) {
      a(paramToServiceMsg, paramFromServiceMsg, (SvcRspBindUin)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.receiver.DeviceLoginInfoReceiver
 * JD-Core Version:    0.7.0.1
 */