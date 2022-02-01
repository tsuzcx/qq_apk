package com.tencent.mobileqq.activity;

import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppView.Callback;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.qphone.base.util.QLog;

class ArkFullScreenAppActivity$4
  implements ArkAppView.Callback
{
  ArkFullScreenAppActivity$4(ArkFullScreenAppActivity paramArkFullScreenAppActivity) {}
  
  public void a() {}
  
  public void b()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("arkview loadSucc: ");
      ((StringBuilder)localObject).append(ArkFullScreenAppActivity.b(this.a));
      QLog.i("ArkFullScreenAppActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (ArkFullScreenAppActivity.b(this.a) != null)
    {
      localObject = ArkFullScreenAppActivity.b(this.a).g;
      if (localObject != null)
      {
        boolean bool = ((ArkAppContainer)localObject).checkShare();
        int i = 0;
        if ((bool) && (ArkFullScreenAppActivity.b(this.a).i)) {
          bool = true;
        } else {
          bool = false;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("supportShare: ");
          ((StringBuilder)localObject).append(bool);
          QLog.i("ArkFullScreenAppActivity", 2, ((StringBuilder)localObject).toString());
        }
        localObject = this.a.rightViewImg;
        if (!bool) {
          i = 4;
        }
        ((ImageView)localObject).setVisibility(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ArkFullScreenAppActivity.4
 * JD-Core Version:    0.7.0.1
 */