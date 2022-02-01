package com.tencent.mobileqq.activity.aio.tips;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ArkTipsBar$1
  implements View.OnClickListener
{
  ArkTipsBar$1(ArkTipsBar paramArkTipsBar) {}
  
  public void onClick(View paramView)
  {
    if ((BaseActivity.sTopActivity instanceof BaseActivity))
    {
      Object localObject = BaseActivity.sTopActivity.getChatFragment();
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).k();
        if (localObject != null) {
          ((BaseChatPie)localObject).b(ArkTipsBar.a(this.a));
        }
      }
      ArkTipsManager.b().d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.ArkTipsBar.1
 * JD-Core Version:    0.7.0.1
 */