package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;

class DrawerBizFacade$9
  implements Runnable
{
  DrawerBizFacade$9(DrawerBizFacade paramDrawerBizFacade, boolean paramBoolean) {}
  
  public void run()
  {
    Iterator localIterator = DrawerBizFacade.d(this.this$0).values().iterator();
    while (localIterator.hasNext())
    {
      IQQSettingMeProcessor localIQQSettingMeProcessor = (IQQSettingMeProcessor)localIterator.next();
      if ((!QQSettingMeConstant.a(localIQQSettingMeProcessor.b())) && (!(localIQQSettingMeProcessor instanceof QQSettingMeBaseMenuProcessor)))
      {
        localIQQSettingMeProcessor.a(this.a);
      }
      else
      {
        QQSettingMeBizBean localQQSettingMeBizBean = QQSettingMe.a(localIQQSettingMeProcessor.b());
        if (localQQSettingMeBizBean != null) {
          localIQQSettingMeProcessor.a(((IRedTouchManager)this.this$0.a.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(localQQSettingMeBizBean.f()), this.a);
        }
      }
    }
    this.this$0.j();
    DrawerBizFacade.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.DrawerBizFacade.9
 * JD-Core Version:    0.7.0.1
 */