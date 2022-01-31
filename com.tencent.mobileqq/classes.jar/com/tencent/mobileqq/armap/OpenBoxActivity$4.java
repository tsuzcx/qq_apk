package com.tencent.mobileqq.armap;

import android.os.Handler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class OpenBoxActivity$4
  extends ArMapObserver
{
  OpenBoxActivity$4(OpenBoxActivity paramOpenBoxActivity) {}
  
  public void onOpenPOI(boolean paramBoolean1, int paramInt1, ItemInfo paramItemInfo, boolean paramBoolean2, int paramInt2, int paramInt3, boolean paramBoolean3)
  {
    StringBuilder localStringBuilder;
    if (this.this$0.mHandler.hasMessages(1001))
    {
      this.this$0.mHandler.removeMessages(1001);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("onOpenPoi isSuccess: ").append(paramBoolean1).append(" restultCode: ").append(paramInt1).append(" itemInfo is null : ");
        if (paramItemInfo != null) {
          break label128;
        }
      }
    }
    label128:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      QLog.i("ARMapActivity", 2, paramBoolean2);
      if ((!paramBoolean1) || (paramItemInfo == null)) {
        break label134;
      }
      paramItemInfo.h = OpenBoxActivity.access$200(this.this$0);
      OpenBoxActivity.access$300(this.this$0, paramItemInfo);
      return;
      OpenBoxActivity.access$100(this.this$0);
      break;
    }
    label134:
    QQToast.a(this.this$0, "跳转宝箱URL失败", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.OpenBoxActivity.4
 * JD-Core Version:    0.7.0.1
 */