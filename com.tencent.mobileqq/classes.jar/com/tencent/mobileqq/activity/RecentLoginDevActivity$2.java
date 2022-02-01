package com.tencent.mobileqq.activity;

import QQService.SvcDevLoginInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class RecentLoginDevActivity$2
  implements View.OnClickListener
{
  RecentLoginDevActivity$2(RecentLoginDevActivity paramRecentLoginDevActivity, RelativeLayout paramRelativeLayout, int paramInt) {}
  
  public void onClick(View paramView)
  {
    SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)this.a.getTag();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localSvcDevLoginInfo.stDeviceItemDes);
    RecentLoginDevActivity.a(this.c, localSvcDevLoginInfo.strDeviceName, localArrayList, RecentLoginDevActivity.a(this.c), this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecentLoginDevActivity.2
 * JD-Core Version:    0.7.0.1
 */