package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.struct.ADMsg;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQBroadcastActivity$Adapter$3
  implements View.OnClickListener
{
  QQBroadcastActivity$Adapter$3(QQBroadcastActivity.Adapter paramAdapter, ADMsg paramADMsg, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = this.a.e;
    Object localObject1 = this.a.f;
    if ((!((String)localObject2).equals("TMTWAPI")) && (!((String)localObject2).equals("WAPI")))
    {
      if ((!((String)localObject2).equals("TMTWAP")) && (!((String)localObject2).equals("WAP")))
      {
        if (((String)localObject2).equals("LOCAL")) {
          if ("CARD".equalsIgnoreCase((String)localObject1))
          {
            localObject1 = this.a.g.split(",")[0];
            if ((!"".equals(localObject1)) && (!this.d.b.app.getCurrentAccountUin().equals(localObject1))) {
              localObject1 = new AllInOne((String)localObject1, 19);
            } else {
              localObject1 = new AllInOne(this.d.b.app.getCurrentAccountUin(), 0);
            }
            ProfileUtils.openProfileCard(this.d.b, (AllInOne)localObject1);
          }
          else if ("CHAT".equalsIgnoreCase((String)localObject1))
          {
            localObject1 = this.a.g.split(",")[0];
            if (!"".equals(localObject1)) {
              if (((FriendsManager)this.d.b.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).n((String)localObject1))
              {
                localObject2 = this.d;
                ((QQBroadcastActivity.Adapter)localObject2).a((String)localObject1, 0, ContactUtils.c(((QQBroadcastActivity.Adapter)localObject2).b.app, (String)localObject1));
              }
              else
              {
                localObject2 = this.d;
                ((QQBroadcastActivity.Adapter)localObject2).a((String)localObject1, 1001, ContactUtils.c(((QQBroadcastActivity.Adapter)localObject2).b.app, (String)localObject1));
              }
            }
          }
          else if ("NEARBY".equalsIgnoreCase((String)localObject1))
          {
            localObject1 = new Intent();
            RouteUtils.a(this.d.b, (Intent)localObject1, "/nearby/activity");
          }
        }
      }
      else
      {
        localObject2 = new Intent(this.d.b, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("uin", this.d.b.app.getCurrentAccountUin());
        this.d.b.startActivity(((Intent)localObject2).putExtra("url", (String)localObject1));
      }
    }
    else
    {
      localObject1 = Config.a((String)localObject1, 0, null);
      localObject2 = new Intent(this.d.b, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("uin", this.d.b.app.getCurrentAccountUin());
      this.d.b.startActivity(((Intent)localObject2).putExtra("url", (String)localObject1));
    }
    this.b.edit().putBoolean(this.c, true).commit();
    this.d.b.e.sendEmptyMessageDelayed(1010, 1000L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBroadcastActivity.Adapter.3
 * JD-Core Version:    0.7.0.1
 */