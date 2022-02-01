package com.tencent.biz.game;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import OnlinePushPack.SvcRespPushMsg;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import tencent.im.s2c.msgtype0x210.submsgtype0x42.Submsgtype0x42.GameStatusSync;

public class MSFToWebViewConnector
{
  protected Context a;
  protected String b;
  protected MSFToWebViewConnector.IOnMsgReceiveListener c;
  ArrayList<MSFToWebViewConnector.GameCacheMsg> d;
  protected String e = "";
  protected String f = "";
  
  public String a(String paramString)
  {
    if ((!TextUtils.isEmpty(this.e)) && (this.e.equals(paramString))) {
      return this.f;
    }
    return "";
  }
  
  public void a()
  {
    this.c = null;
    ArrayList localArrayList = this.d;
    if (localArrayList != null) {
      try
      {
        this.d.clear();
        this.d = null;
        return;
      }
      finally {}
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    paramIntent = paramFromServiceMsg.getServiceCmd();
    Object localObject1;
    int i;
    Object localObject2;
    if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("OnlinePush.ReqPush.GameStatusPush")))
    {
      paramIntent = paramFromServiceMsg.getWupBuffer();
      if (paramIntent == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSFToWebViewConnector", 2, "data is null");
        }
        return;
      }
      localObject1 = new SvcReqPushMsg();
      i = 1;
      localObject2 = new UniPacket(true);
    }
    for (;;)
    {
      try
      {
        ((UniPacket)localObject2).setEncodeName("utf-8");
        ((UniPacket)localObject2).decode(paramIntent);
        paramIntent = (SvcReqPushMsg)((UniPacket)localObject2).getByClass("req", localObject1);
        if (this.d == null) {
          this.d = new ArrayList();
        }
        int j = paramFromServiceMsg.getRequestSsoSeq();
        localObject1 = this.d;
        Object localObject3;
        if (localObject1 != null) {
          try
          {
            localObject2 = this.d.iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break label873;
            }
            localObject3 = (MSFToWebViewConnector.GameCacheMsg)((Iterator)localObject2).next();
            if ((((MSFToWebViewConnector.GameCacheMsg)localObject3).a != j) || (((MSFToWebViewConnector.GameCacheMsg)localObject3).b != paramIntent.lUin)) {
              continue;
            }
          }
          finally {}
        } else {
          i = 0;
        }
        localObject1 = this.d;
        if (localObject1 != null)
        {
          if (i != 0) {}
          try
          {
            if (QLog.isColorLevel())
            {
              paramIntent = new StringBuilder();
              paramIntent.append("duplicate msg ssoSeq=");
              paramIntent.append(j);
              QLog.d("MSFToWebViewConnector", 2, paramIntent.toString());
            }
            return;
          }
          finally {}
          if (this.d.size() < 60)
          {
            localObject2 = new MSFToWebViewConnector.GameCacheMsg(this, null);
            ((MSFToWebViewConnector.GameCacheMsg)localObject2).a = j;
            ((MSFToWebViewConnector.GameCacheMsg)localObject2).b = paramIntent.lUin;
            this.d.add(localObject2);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("add msg ssqSeq=");
              ((StringBuilder)localObject2).append(j);
              QLog.d("MSFToWebViewConnector", 2, ((StringBuilder)localObject2).toString());
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSFToWebViewConnector", 2, "remove first cache msg");
            }
            this.d.remove(0);
          }
        }
        localObject1 = new ArrayList();
        localObject2 = paramIntent.vMsgInfos;
        if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (MsgInfo)((Iterator)localObject2).next();
            if (528 == ((MsgInfo)localObject3).shMsgType)
            {
              Object localObject4 = new DelMsgInfo();
              ((DelMsgInfo)localObject4).lFromUin = ((MsgInfo)localObject3).lFromUin;
              ((DelMsgInfo)localObject4).shMsgSeq = ((MsgInfo)localObject3).shMsgSeq;
              ((DelMsgInfo)localObject4).uMsgTime = ((MsgInfo)localObject3).uMsgTime;
              ((DelMsgInfo)localObject4).vMsgCookies = ((MsgInfo)localObject3).vMsgCookies;
              ((ArrayList)localObject1).add(localObject4);
              try
              {
                localObject4 = new JceInputStream(((MsgInfo)localObject3).vMsg);
                ((JceInputStream)localObject4).setServerEncoding("utf-8");
                localObject3 = new MsgType0x210();
                ((MsgType0x210)localObject3).readFrom((JceInputStream)localObject4);
                if ((((MsgType0x210)localObject3).uSubMsgType != 66L) || (((MsgType0x210)localObject3).vProtobuf == null)) {
                  continue;
                }
                localObject4 = new Submsgtype0x42.GameStatusSync();
                ((Submsgtype0x42.GameStatusSync)localObject4).mergeFrom(((MsgType0x210)localObject3).vProtobuf);
                i = ((Submsgtype0x42.GameStatusSync)localObject4).uint32_game_appid.get();
                localObject3 = ((Submsgtype0x42.GameStatusSync)localObject4).bytes_data.get();
                if ((this.c != null) && (localObject3 != null))
                {
                  localObject3 = new String(((ByteStringMicro)localObject3).toByteArray());
                  this.c.a(i, (String)localObject3);
                  continue;
                }
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("MSFToWebViewConnector", 2, "no regist lisener or data is null");
              }
              catch (Exception localException) {}
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("MSFToWebViewConnector", 2, localException.getMessage());
              continue;
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("MSFToWebViewConnector", 2, "msgtype is not notify!");
            continue;
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("MSFToWebViewConnector", 2, "msgInfo is null or size=0");
        }
        if (((ArrayList)localObject1).size() <= 0) {
          break label872;
        }
        localObject2 = new SvcRespPushMsg();
        i = paramFromServiceMsg.getRequestSsoSeq();
        ((SvcRespPushMsg)localObject2).lUin = paramIntent.lUin;
        ((SvcRespPushMsg)localObject2).svrip = paramIntent.svrip;
        ((SvcRespPushMsg)localObject2).vDelInfos = ((ArrayList)localObject1);
        paramIntent = this.c;
        if (paramIntent == null) {
          break label872;
        }
        paramIntent.a(i, (SvcRespPushMsg)localObject2);
        return;
      }
      catch (Exception paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSFToWebViewConnector", 2, paramIntent.getMessage(), paramIntent);
        }
        return;
      }
      catch (RuntimeException paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSFToWebViewConnector", 2, paramIntent.getMessage(), paramIntent);
        }
        return;
      }
      if ((paramIntent != null) && (QLog.isColorLevel()))
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("receive cmd=");
        paramFromServiceMsg.append(paramIntent);
        QLog.d("MSFToWebViewConnector", 2, paramFromServiceMsg.toString());
      }
      label872:
      return;
      label873:
      i = 0;
    }
  }
  
  public void a(String paramString1, String paramString2, AppRuntime paramAppRuntime, Context paramContext, MSFToWebViewConnector.IOnMsgReceiveListener paramIOnMsgReceiveListener)
  {
    this.e = paramString1;
    this.f = paramString2;
    this.a = paramContext;
    this.c = paramIOnMsgReceiveListener;
    this.b = MsfSdkUtils.getProcessName(paramContext);
    if (this.b.equals("com.tencent.mobileqq:MSF")) {
      return;
    }
    a(paramAppRuntime);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime.isLogin())
    {
      paramAppRuntime.setCmdCallbacker();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSFToWebViewConnector", 2, "not login");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.game.MSFToWebViewConnector
 * JD-Core Version:    0.7.0.1
 */