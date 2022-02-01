package com.tencent.biz.qcircleshadow.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlRsp;
import com.tencent.avatarinfo.QQHeadUrl.RspHeadInfo;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.helper.QCircleChatBoxHelper;
import com.tencent.mobileqq.qcircle.api.helper.QCircleObserver;
import com.tencent.mobileqq.qcircle.tempapi.avatar.IAvatarListener;
import com.tencent.mobileqq.qcircle.tempapi.avatar.QCircleAvatarInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class QCircleHandler
  extends BusinessHandler
{
  private ConcurrentHashMap<String, IAvatarListener> a = new ConcurrentHashMap();
  
  protected QCircleHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private QCircleHandler.HeadInfo a(String paramString, byte paramByte, QQHeadUrl.QQHeadUrlRsp paramQQHeadUrlRsp)
  {
    Iterator localIterator = paramQQHeadUrlRsp.dstHeadInfos.get().iterator();
    while (localIterator.hasNext())
    {
      QQHeadUrl.RspHeadInfo localRspHeadInfo = (QQHeadUrl.RspHeadInfo)localIterator.next();
      String str;
      if (paramQQHeadUrlRsp.dstEncryptType.get() == 1) {
        str = localRspHeadInfo.dstUid.get();
      } else {
        str = String.valueOf(localRspHeadInfo.dstUin.get());
      }
      if (paramString.equals(str))
      {
        paramString = new QCircleHandler.HeadInfo(this);
        QCircleHandler.HeadInfo.a(paramString, (byte)localRspHeadInfo.faceFlag.get());
        paramByte = AvatarDownloadUtil.getQQHeadImageSize(QCircleHandler.HeadInfo.a(paramString));
        paramQQHeadUrlRsp = new StringBuilder();
        paramQQHeadUrlRsp.append(localRspHeadInfo.url.get());
        paramQQHeadUrlRsp.append(paramByte);
        paramString.a = paramQQHeadUrlRsp.toString();
        paramQQHeadUrlRsp = new StringBuilder();
        paramQQHeadUrlRsp.append("  size:");
        paramQQHeadUrlRsp.append(paramByte);
        paramQQHeadUrlRsp.append("url :");
        paramQQHeadUrlRsp.append(paramString.a);
        QLog.d("QCircleHandler", 4, paramQQHeadUrlRsp.toString());
        return paramString;
      }
    }
    return null;
  }
  
  public static QCircleHandler a()
  {
    if ((MobileQQ.sMobileQQ.waitAppRuntime(null) instanceof AppInterface)) {
      return (QCircleHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(QCircleHandler.class.getName());
    }
    return null;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    localObject2 = null;
    localObject1 = localObject2;
    if (paramFromServiceMsg != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localObject1 = localObject2;
        if (paramObject != null)
        {
          localObject1 = new QQHeadUrl.QQHeadUrlRsp();
          ((QQHeadUrl.QQHeadUrlRsp)localObject1).mergeFrom((byte[])paramObject);
        }
      }
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        int i;
        localObject1 = localObject2;
      }
    }
    paramToServiceMsg = paramToServiceMsg.extraData.getString("dstUin", "");
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000) && (localObject1 != null) && (((QQHeadUrl.QQHeadUrlRsp)localObject1).result.get() == 0))
    {
      paramFromServiceMsg = a(paramToServiceMsg, (byte)1, (QQHeadUrl.QQHeadUrlRsp)localObject1);
      if (paramFromServiceMsg != null)
      {
        a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      a(paramToServiceMsg, -1);
      return;
    }
    i = 65535;
    if (localObject1 != null) {
      i = ((QQHeadUrl.QQHeadUrlRsp)localObject1).result.get();
    } else if (paramFromServiceMsg != null) {
      i = paramFromServiceMsg.getResultCode();
    }
    a(paramToServiceMsg, i);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      IAvatarListener localIAvatarListener = (IAvatarListener)this.a.get(paramString);
      if (localIAvatarListener != null)
      {
        localIAvatarListener.onAvatarBack(false, paramInt, null);
        this.a.remove(paramString);
      }
    }
  }
  
  private void a(String paramString, QCircleHandler.HeadInfo paramHeadInfo)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      IAvatarListener localIAvatarListener = (IAvatarListener)this.a.get(paramString);
      if (localIAvatarListener != null)
      {
        QCircleAvatarInfo localQCircleAvatarInfo = new QCircleAvatarInfo();
        localQCircleAvatarInfo.setTimestamp(String.valueOf(System.currentTimeMillis())).setDownLoadUrl(paramHeadInfo.a).setUin(paramString);
        localIAvatarListener.onAvatarBack(true, 0, localQCircleAvatarInfo);
        this.a.remove(paramString);
      }
    }
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(String paramString, IAvatarListener paramIAvatarListener)
  {
    this.a.put(paramString, paramIAvatarListener);
  }
  
  public void b()
  {
    int i = QCircleChatBoxHelper.getInstance().getUnReadChatNum();
    int j = RFLog.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateRedPoint:");
    localStringBuilder.append(i);
    RFLog.d("QCircleHandler", j, localStringBuilder.toString());
    notifyUI(1, true, Integer.valueOf(i));
  }
  
  public void c()
  {
    RFLog.d("QCircleHandler", RFLog.USR, "clearRedPoint");
    QCircleChatBoxHelper.getInstance().clearUnReadInfo();
    notifyUI(1, true, Integer.valueOf(0));
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("IncreaseURLSvr.QQHeadUrlReq");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return QCircleObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((!msgCmdFilter(paramToServiceMsg.getServiceCmd())) && ("IncreaseURLSvr.QQHeadUrlReq".equals(paramFromServiceMsg.getServiceCmd())) && (paramToServiceMsg.extraData.getBoolean("qcircle"))) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.handler.QCircleHandler
 * JD-Core Version:    0.7.0.1
 */