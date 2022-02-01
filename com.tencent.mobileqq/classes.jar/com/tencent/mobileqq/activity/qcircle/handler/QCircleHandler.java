package com.tencent.mobileqq.activity.qcircle.handler;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
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
      if (paramQQHeadUrlRsp.dstEncryptType.get() == 1) {}
      for (String str = localRspHeadInfo.dstUid.get(); paramString.equals(str); str = String.valueOf(localRspHeadInfo.dstUin.get()))
      {
        paramString = new QCircleHandler.HeadInfo(this);
        QCircleHandler.HeadInfo.a(paramString, (byte)localRspHeadInfo.faceFlag.get());
        paramByte = AvatarDownloadUtil.getQQHeadImageSize(QCircleHandler.HeadInfo.a(paramString));
        paramString.a = (localRspHeadInfo.url.get() + paramByte);
        QLog.d("QCircleHandler", 4, "  size:" + paramByte + "url :" + paramString.a);
        return paramString;
      }
    }
    return null;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = null;
    if (paramFromServiceMsg != null) {}
    for (;;)
    {
      try
      {
        if ((paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null)) {
          break label157;
        }
        QQHeadUrl.QQHeadUrlRsp localQQHeadUrlRsp = new QQHeadUrl.QQHeadUrlRsp();
        localQQHeadUrlRsp.mergeFrom((byte[])paramObject);
        paramObject = localQQHeadUrlRsp;
      }
      catch (Exception paramObject)
      {
        int i;
        paramObject = localObject;
        continue;
      }
      paramToServiceMsg = paramToServiceMsg.extraData.getString("dstUin", "");
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null) || (paramObject.result.get() != 0))
      {
        i = 65535;
        if (paramObject != null)
        {
          i = paramObject.result.get();
          a(paramToServiceMsg, i);
          return;
        }
        if (paramFromServiceMsg == null) {
          continue;
        }
        i = paramFromServiceMsg.getResultCode();
        continue;
      }
      paramFromServiceMsg = a(paramToServiceMsg, (byte)1, paramObject);
      if (paramFromServiceMsg != null)
      {
        a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      a(paramToServiceMsg, -1);
      return;
      label157:
      paramObject = null;
    }
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
    Pair localPair = QCircleChatBoxHelper.getInstance().getUnReadInfo();
    if (localPair != null)
    {
      RFLog.d("QCircleHandler", RFLog.USR, "updateRedPoint:" + localPair.first);
      notifyUI(1, true, localPair.first);
      return;
    }
    RFLog.e("QCircleHandler", RFLog.USR, "updateRedPoint null");
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
  
  public Class<? extends BusinessObserver> observerClass()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.handler.QCircleHandler
 * JD-Core Version:    0.7.0.1
 */