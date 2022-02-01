package com.tencent.mobileqq.activity.aio.helper;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;

class TogetherControlHelper$2
  extends RedpointObserver
{
  TogetherControlHelper$2(TogetherControlHelper paramTogetherControlHelper) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedpointHandler", 2, "troopChatPie RedpointObserver  onDataChange");
    }
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)TogetherControlHelper.a(this.a).a.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(4, String.valueOf(130500));
    if (this.a.b == null) {
      this.a.b = ((ImageView)TogetherControlHelper.a(this.a).c.findViewById(2131376828));
    }
    if (this.a.b == null) {
      return;
    }
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1))
    {
      this.a.b.setVisibility(0);
      return;
    }
    this.a.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper.2
 * JD-Core Version:    0.7.0.1
 */