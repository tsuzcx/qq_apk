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

class QQGamePubAIOHelper$10
  implements WadlTrpcListener
{
  QQGamePubAIOHelper$10(QQGamePubAIOHelper paramQQGamePubAIOHelper) {}
  
  public HashSet<String> getFilterCmds()
  {
    return new QQGamePubAIOHelper.10.1(this);
  }
  
  public void onTrpcRsp(Intent paramIntent, String paramString, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    if (!"/v1/10".equals(paramString)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onTrpcRs,:request:");
      ((StringBuilder)localObject1).append(paramIntent);
      ((StringBuilder)localObject1).append(",cmd:");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",ret:");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(",rsp:");
      ((StringBuilder)localObject1).append(paramTrpcInovkeRsp);
      ((StringBuilder)localObject1).append(",cost:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - QQGamePubAIOHelper.e(this.a));
      QLog.i("QQGamePub_QQGamePubAIOHelper", 2, ((StringBuilder)localObject1).toString());
    }
    QQGamePubAIOHelper.b(this.a, false);
    Object localObject1 = null;
    paramString = null;
    Object localObject2 = null;
    paramIntent = null;
    if ((paramLong == 0L) && (paramTrpcInovkeRsp != null) && (paramTrpcInovkeRsp.data.get() != null)) {
      localObject2 = new QQGameMakeTeamInfo.QueryGameTeamInfoRsp();
    }
    for (;;)
    {
      try
      {
        ((QQGameMakeTeamInfo.QueryGameTeamInfoRsp)localObject2).mergeFrom(paramTrpcInovkeRsp.data.get().toByteArray());
        QQGamePubAIOHelper.a(QQGamePubAIOHelper.a(this.a, (QQGameMakeTeamInfo.QueryGameTeamInfoRsp)localObject2));
        localObject2 = ((QQGameMakeTeamInfo.QueryGameTeamInfoRsp)localObject2).teams.get();
        paramString = (String)localObject1;
        try
        {
          localObject1 = ((List)localObject2).iterator();
          paramString = paramIntent;
          if (((Iterator)localObject1).hasNext())
          {
            paramString = paramIntent;
            paramTrpcInovkeRsp = (QQGameMakeTeamInfo.TeamInfo)((Iterator)localObject1).next();
            paramString = paramIntent;
            if (paramTrpcInovkeRsp.status.get() == 0) {
              break label516;
            }
            paramString = paramIntent;
            if (paramTrpcInovkeRsp.status.get() == 5) {
              break label516;
            }
            paramString = paramIntent;
            QQGamePubAIOHelper.a(this.a, paramTrpcInovkeRsp);
            continue;
          }
          paramString = paramIntent;
          paramTrpcInovkeRsp = paramIntent;
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            break label440;
          }
          paramString = paramIntent;
          paramTrpcInovkeRsp = new StringBuilder();
          paramString = paramIntent;
          paramTrpcInovkeRsp.append("doLoopTeamInfo onReceive: conf:");
          paramString = paramIntent;
          paramTrpcInovkeRsp.append(QQGamePubAIOHelper.e());
          paramString = paramIntent;
          paramTrpcInovkeRsp.append(",teams:");
          paramString = paramIntent;
          paramTrpcInovkeRsp.append(localObject2);
          paramString = paramIntent;
          QLog.i("QQGamePub_QQGamePubAIOHelper", 2, paramTrpcInovkeRsp.toString());
          paramTrpcInovkeRsp = paramIntent;
          localObject1 = localObject2;
        }
        catch (Exception paramTrpcInovkeRsp)
        {
          paramIntent = (Intent)localObject2;
          localObject2 = paramTrpcInovkeRsp;
        }
        paramTrpcInovkeRsp = paramString;
      }
      catch (Exception localException)
      {
        paramIntent = null;
      }
      localObject1 = paramIntent;
      if (QLog.isColorLevel())
      {
        QLog.e("QQGamePub_QQGamePubAIOHelper", 2, localException, new Object[0]);
        paramTrpcInovkeRsp = paramString;
        localObject1 = paramIntent;
        break label440;
        localObject1 = null;
        paramTrpcInovkeRsp = localException;
      }
      label440:
      if (QQGamePubAIOHelper.b(this.a, paramTrpcInovkeRsp))
      {
        ThreadManagerV2.getUIHandlerV2().post(new QQGamePubAIOHelper.10.2(this, paramTrpcInovkeRsp));
        return;
      }
      QQGamePubAIOHelper.b(this.a, (List)localObject1);
      paramIntent = this.a;
      paramString = new StringBuilder();
      paramString.append("from onTrpcRsp,teamInfo:");
      paramString.append(paramTrpcInovkeRsp);
      paramIntent.a(paramString.toString());
      return;
      label516:
      if (paramIntent == null) {
        paramIntent = paramTrpcInovkeRsp;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.10
 * JD-Core Version:    0.7.0.1
 */