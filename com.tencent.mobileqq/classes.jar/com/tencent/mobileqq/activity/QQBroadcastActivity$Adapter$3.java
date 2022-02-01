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
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.struct.ADMsg;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQBroadcastActivity$Adapter$3
  implements View.OnClickListener
{
  QQBroadcastActivity$Adapter$3(QQBroadcastActivity.Adapter paramAdapter, ADMsg paramADMsg, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqConfigStructADMsg.e;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqConfigStructADMsg.f;
    if ((((String)localObject2).equals("TMTWAPI")) || (((String)localObject2).equals("WAPI")))
    {
      localObject1 = Config.a((String)localObject1, 0, null);
      localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a.app.getCurrentAccountUin());
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a.startActivity(((Intent)localObject2).putExtra("url", (String)localObject1));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.jdField_a_of_type_JavaLangString, true).commit();
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a.a.sendEmptyMessageDelayed(1010, 1000L);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((((String)localObject2).equals("TMTWAP")) || (((String)localObject2).equals("WAP")))
      {
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a.app.getCurrentAccountUin());
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a.startActivity(((Intent)localObject2).putExtra("url", (String)localObject1));
      }
      else if (((String)localObject2).equals("LOCAL"))
      {
        if ("CARD".equalsIgnoreCase((String)localObject1))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqConfigStructADMsg.g.split(",")[0];
          if (("".equals(localObject1)) || (this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a.app.getCurrentAccountUin().equals(localObject1))) {}
          for (localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a.app.getCurrentAccountUin(), 0);; localObject1 = new ProfileActivity.AllInOne((String)localObject1, 19))
          {
            ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a, (ProfileActivity.AllInOne)localObject1);
            break;
          }
        }
        if ("CHAT".equalsIgnoreCase((String)localObject1))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqConfigStructADMsg.g.split(",")[0];
          if (!"".equals(localObject1)) {
            if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b((String)localObject1)) {
              this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a((String)localObject1, 0, ContactUtils.i(this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a.app, (String)localObject1));
            } else {
              this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a((String)localObject1, 1001, ContactUtils.i(this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a.app, (String)localObject1));
            }
          }
        }
        else if ("NEARBY".equalsIgnoreCase((String)localObject1))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a.startActivity(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.a, NearbyActivity.class));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBroadcastActivity.Adapter.3
 * JD-Core Version:    0.7.0.1
 */