package com.tencent.mobileqq.activity.aio.helper;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
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
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)TogetherControlHelper.a(this.a).d.getRuntimeService(IRedTouchManager.class, "")).getAppInfo(4, String.valueOf(130500));
    if (this.a.c == null)
    {
      TogetherControlHelper localTogetherControlHelper = this.a;
      localTogetherControlHelper.c = ((ImageView)TogetherControlHelper.a(localTogetherControlHelper).aZ.findViewById(2131444531));
    }
    if (this.a.c == null) {
      return;
    }
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1))
    {
      this.a.c.setVisibility(0);
      return;
    }
    this.a.c.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper.2
 * JD-Core Version:    0.7.0.1
 */