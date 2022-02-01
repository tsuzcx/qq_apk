package com.tencent.mobileqq.app;

import com.tencent.common.config.AppSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.ServerConfigManager;
import mqq.observer.ServerConfigObserver;
import mqq.os.MqqHandler;
import protocol.KQQConfig.GPS;
import protocol.KQQConfig.GetResourceReqInfoV2;
import protocol.KQQConfig.GetResourceRespV2;
import protocol.KQQConfig.ReqUserInfo;

public class PluginConfigProxy
  extends ServerConfigObserver
{
  private final ArrayList<ServerConfigObserver> a = new ArrayList();
  private int b = 0;
  private ArrayList<GetResourceReqInfoV2> c = new ArrayList();
  
  public void a(int paramInt, List<GetResourceReqInfoV2> paramList, ServerConfigObserver paramServerConfigObserver)
  {
    this.c.addAll(paramList);
    this.b = (paramInt | this.b);
    if (paramServerConfigObserver != null) {
      this.a.add(paramServerConfigObserver);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    ReqUserInfo localReqUserInfo = new ReqUserInfo();
    localReqUserInfo.cType = 1;
    localReqUserInfo.stGps = new GPS();
    localReqUserInfo.strAuthName = "B1_QQ_Neighbor_android";
    localReqUserInfo.strAuthPassword = "NzVK_qGE";
    localReqUserInfo.vCells = new ArrayList();
    localReqUserInfo.vMacs = new ArrayList();
    ((ServerConfigManager)paramQQAppInterface.getManager(4)).getPluginConfig(this.b, localReqUserInfo, this.c, this, AppSetting.d());
  }
  
  public void onGetPluginConfig(boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2)
  {
    if ((this.b & paramInt) == 0) {
      return;
    }
    if (this.a.isEmpty()) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ServerConfigObserver localServerConfigObserver = (ServerConfigObserver)localIterator.next();
      ThreadManager.getSubThreadHandler().post(new PluginConfigProxy.CallbackRunner(this, localServerConfigObserver, paramBoolean, paramInt, paramGetResourceRespV2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PluginConfigProxy
 * JD-Core Version:    0.7.0.1
 */