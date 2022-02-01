package com.tencent.mobileqq.activity.aio.helper;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyAddFriendHelper$4
  implements View.OnClickListener
{
  NearbyAddFriendHelper$4(NearbyAddFriendHelper paramNearbyAddFriendHelper) {}
  
  public void onClick(View paramView)
  {
    NearbyAddFriendHelper.a(this.a, "airplane_button", "click");
    Bundle localBundle = new Bundle();
    localBundle.putString("roomid", NearbyAddFriendHelper.b(this.a));
    localBundle.putString("startsrc", "10009");
    localBundle.putString("first_jump_mode", "h5");
    localBundle.putString("can_ues_h5_first", "true");
    localBundle.putString("mqqScheme", NearbyAddFriendHelper.a(this.a));
    localBundle.putString("big_brother_source_key", "biz_src_ads");
    localBundle.putString("big_brother_ref_source_key", "biz_src_jc_aio");
    ((IDynamicNowManager)this.a.a.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).a(localBundle);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.NearbyAddFriendHelper.4
 * JD-Core Version:    0.7.0.1
 */