package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.os.Handler;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tencent.im.qqgame.QQGameMakeTeamInfo.QueryGameTeamInfoRsp;
import tencent.im.qqgame.QQGameMakeTeamInfo.TeamInfo;

class QQGamePubAIOHelper$9
  implements WadlTrpcListener
{
  QQGamePubAIOHelper$9(QQGamePubAIOHelper paramQQGamePubAIOHelper) {}
  
  public HashSet<String> a()
  {
    return new QQGamePubAIOHelper.9.1(this);
  }
  
  public void a(Intent paramIntent, String paramString, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    if (!"/v1/10".equals(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQGamePubAIOHelper", 2, "onTrpcRs,:request:" + paramIntent + ",cmd:" + paramString + ",ret:" + paramLong + ",rsp:" + paramTrpcInovkeRsp + ",cost:" + (System.currentTimeMillis() - QQGamePubAIOHelper.a(this.a)));
    }
    QQGamePubAIOHelper.b(this.a, false);
    Object localObject5 = null;
    Object localObject3 = null;
    Iterator localIterator = null;
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject4 = null;
    paramString = localObject4;
    paramIntent = localObject5;
    if (paramLong == 0L)
    {
      paramString = localObject4;
      paramIntent = localObject5;
      if (paramTrpcInovkeRsp != null)
      {
        paramString = localObject4;
        paramIntent = localObject5;
        if (paramTrpcInovkeRsp.data.get() != null) {
          paramIntent = new QQGameMakeTeamInfo.QueryGameTeamInfoRsp();
        }
      }
    }
    try
    {
      paramIntent.mergeFrom(paramTrpcInovkeRsp.data.get().toByteArray());
      QQGamePubAIOHelper.a(QQGamePubAIOHelper.a(this.a, paramIntent));
      paramTrpcInovkeRsp = paramIntent.teams.get();
      paramString = localIterator;
      if (paramIntent != null) {
        break label460;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          localIterator = paramTrpcInovkeRsp.iterator();
          paramIntent = (Intent)localObject1;
          paramString = paramIntent;
          if (localIterator.hasNext())
          {
            paramString = paramIntent;
            localObject1 = (QQGameMakeTeamInfo.TeamInfo)localIterator.next();
            paramString = paramIntent;
            if (((QQGameMakeTeamInfo.TeamInfo)localObject1).status.get() == 0) {
              break label450;
            }
            paramString = paramIntent;
            if (((QQGameMakeTeamInfo.TeamInfo)localObject1).status.get() == 5) {
              break label450;
            }
            paramString = paramIntent;
            QQGamePubAIOHelper.a(this.a, (QQGameMakeTeamInfo.TeamInfo)localObject1);
            break label460;
          }
          paramString = paramIntent;
          if (QLog.isColorLevel())
          {
            paramString = paramIntent;
            QLog.i("QQGamePubAIOHelper", 2, "doLoopTeamInfo onReceive: conf:" + QQGamePubAIOHelper.a() + ",teams:" + paramTrpcInovkeRsp);
          }
          paramString = paramTrpcInovkeRsp;
          if (!QQGamePubAIOHelper.a(this.a, paramIntent)) {
            continue;
          }
          ThreadManagerV2.getUIHandlerV2().post(new QQGamePubAIOHelper.9.2(this, paramIntent));
          return;
        }
        catch (Exception localException2)
        {
          localObject1 = paramString;
          continue;
        }
        localException1 = localException1;
        localObject1 = localObject3;
        paramTrpcInovkeRsp = localObject2;
        paramString = paramTrpcInovkeRsp;
        paramIntent = (Intent)localObject1;
        if (QLog.isColorLevel())
        {
          QLog.e("QQGamePubAIOHelper", 2, localException1, new Object[0]);
          paramString = paramTrpcInovkeRsp;
          paramIntent = (Intent)localObject1;
        }
      }
      QQGamePubAIOHelper.b(this.a, paramString);
      this.a.a("from onTrpcRsp,teamInfo:" + paramIntent);
      return;
    }
    label450:
    paramIntent = (Intent)localObject1;
    label460:
    for (;;)
    {
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.9
 * JD-Core Version:    0.7.0.1
 */