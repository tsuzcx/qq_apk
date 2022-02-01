package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOAssist;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddFriendHelper$1
  implements View.OnClickListener
{
  AddFriendHelper$1(AddFriendHelper paramAddFriendHelper) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (((localObject instanceof Integer)) && (!AIOAssist.c()))
    {
      String str = this.a.b();
      if (this.a.e.a == 1006) {
        str = this.a.e.g;
      }
      int i = ((Integer)localObject).intValue();
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 4) {
              this.a.e();
            }
          }
          else {
            this.a.d();
          }
        }
        else {
          this.a.a(str);
        }
      }
      else {
        this.a.b(str);
      }
      this.a.a.d().a(i, this.a.e.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AddFriendHelper.1
 * JD-Core Version:    0.7.0.1
 */