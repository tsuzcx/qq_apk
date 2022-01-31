package com.tencent.mobileqq.app;

import com.tencent.common.config.AppSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.ServerConfigManager;
import mqq.observer.ServerConfigObserver;
import mqq.os.MqqHandler;
import protocol.KQQConfig.GPS;
import protocol.KQQConfig.GetResourceRespV2;
import protocol.KQQConfig.ReqUserInfo;
import zqj;

public class PluginConfigProxy
  extends ServerConfigObserver
{
  private int jdField_a_of_type_Int = 0;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList b = new ArrayList();
  
  public void a(int paramInt, List paramList, ServerConfigObserver paramServerConfigObserver)
  {
    this.b.addAll(paramList);
    this.jdField_a_of_type_Int |= paramInt;
    if (paramServerConfigObserver != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramServerConfigObserver);
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
    ((ServerConfigManager)paramQQAppInterface.getManager(4)).getPluginConfig(this.jdField_a_of_type_Int, localReqUserInfo, this.b, this, AppSetting.jdField_a_of_type_Int);
  }
  
  public void onGetPluginConfig(boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2)
  {
    if ((this.jdField_a_of_type_Int & paramInt) == 0) {}
    for (;;)
    {
      return;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          ServerConfigObserver localServerConfigObserver = (ServerConfigObserver)localIterator.next();
          ThreadManager.getSubThreadHandler().post(new zqj(this, localServerConfigObserver, paramBoolean, paramInt, paramGetResourceRespV2));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PluginConfigProxy
 * JD-Core Version:    0.7.0.1
 */