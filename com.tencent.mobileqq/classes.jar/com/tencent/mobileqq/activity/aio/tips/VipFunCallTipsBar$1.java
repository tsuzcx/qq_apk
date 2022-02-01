package com.tencent.mobileqq.activity.aio.tips;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VipFunCallTipsBar$1
  implements View.OnClickListener
{
  private long b = 0L;
  
  VipFunCallTipsBar$1(VipFunCallTipsBar paramVipFunCallTipsBar) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.b >= 200L)
    {
      this.b = l;
      this.a.a.c();
      Object localObject1 = new Intent(VipFunCallTipsBar.a(this.a), QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("hide_left_button", false);
      ((Intent)localObject1).putExtra("show_right_close_button", false);
      ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
      Object localObject2 = IndividuationUrlHelper.a(VipFunCallTipsBar.a(this.a), "call", "mvip.gongneng.anroid.individuation.web");
      VasWebviewUtil.b(VipFunCallTipsBar.a(this.a), (String)localObject2, 524288L, (Intent)localObject1, false, -1);
      VipUtils.a(this.a.b, "QQVIPFUNCALL", "0X8004D8C", "0X8004D8C", 4, 0, new String[0]);
      localObject1 = this.a.b.getPreferences().edit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("funcall_tip_");
      ((StringBuilder)localObject2).append(this.a.d);
      ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject2).toString(), 4);
      ((SharedPreferences.Editor)localObject1).commit();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.VipFunCallTipsBar.1
 * JD-Core Version:    0.7.0.1
 */