package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.biz.pubaccount.readinjoy.config.QQAladdinUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class ReadInJoyLogicManager
  implements Manager
{
  private AppInterface a;
  
  public ReadInJoyLogicManager(AppInterface paramAppInterface)
  {
    QLog.i("ReadInJoyLogicManager", 1, "[ReadInJoyLogicManager] constructed.");
    this.a = paramAppInterface;
    a();
  }
  
  public ReadInJoyLogicEngine a()
  {
    return ReadInJoyLogicEngine.a();
  }
  
  public void a()
  {
    QQAladdinUtils.a();
    ReadInJoyLogicEngine.a().a(this.a);
  }
  
  public void b()
  {
    ReadInJoyLogicEngine.a().a(false);
  }
  
  public void onDestroy()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager
 * JD-Core Version:    0.7.0.1
 */