package com.tencent.comic.ui;

import com.tencent.comic.api.IQQComicRedTouchService;
import com.tencent.comic.utils.SimpleBiMap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

class QQComicTabBarView$7
  implements Runnable
{
  QQComicTabBarView$7(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "start getRedAppInfo");
    }
    Object localObject1 = (IQQComicRedTouchService)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web")).getRuntimeService(IQQComicRedTouchService.class, "all");
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    Object localObject2;
    if (((IQQComicRedTouchService)localObject1).isLebaItemOpen(1113))
    {
      localArrayList.addAll(this.this$0.e.keySet());
      bool = true;
    }
    else
    {
      localObject2 = this.this$0.e.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        localArrayList.add(this.this$0.f.get(str));
      }
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isLebaItemOpen=");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(", resId=");
      ((StringBuilder)localObject2).append(1113);
      QLog.d("WebViewTabBarView", 2, ((StringBuilder)localObject2).toString());
    }
    localObject1 = ((IQQComicRedTouchService)localObject1).getRedAppInfo(localArrayList);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("end getRedAppInfo map is ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("WebViewTabBarView", 2, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 != null) {
      ThreadManager.getUIHandler().post(new QQComicTabBarView.7.1(this, localArrayList, bool, (Map)localObject1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.ui.QQComicTabBarView.7
 * JD-Core Version:    0.7.0.1
 */