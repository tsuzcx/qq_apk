package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendServlet;
import com.tencent.mobileqq.widget.QQToast;

class ActivateFriendActivity$8
  extends CardObserver
{
  ActivateFriendActivity$8(ActivateFriendActivity paramActivateFriendActivity) {}
  
  protected void onGetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((ActivateFriendActivity.a(this.a) != paramBoolean2) && (paramBoolean2 == true))
    {
      ActivateFriendServlet.a(this.a.app, false, true, false, true);
      this.a.a();
    }
    ActivateFriendActivity.a(this.a, paramBoolean2);
  }
  
  protected void onSetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((ActivateFriendActivity.a(this.a) != paramBoolean2) && (paramBoolean2 == true))
    {
      ActivateFriendServlet.a(this.a.app, false, true, false, true);
      this.a.a();
    }
    if (!this.a.isFinishing())
    {
      Object localObject;
      if (paramBoolean1)
      {
        ActivateFriendActivity.a(this.a, paramBoolean2);
        int i;
        if (ActivateFriendActivity.a(this.a))
        {
          localObject = this.a;
          i = 2131689561;
        }
        else
        {
          localObject = this.a;
          i = 2131689562;
        }
        localObject = ((ActivateFriendActivity)localObject).getString(i);
        localObject = this.a.getString(2131689564, new Object[] { localObject });
        QQToast.a(this.a, 2, (CharSequence)localObject, 0).b(this.a.getTitleBarHeight());
        if (ActivateFriendActivity.a(this.a) != null)
        {
          ActivateFriendActivity.a(this.a).c();
          ActivateFriendActivity.b(this.a);
        }
      }
      else
      {
        localObject = this.a;
        QQToast.a((Context)localObject, 1, ((ActivateFriendActivity)localObject).getResources().getString(2131718834), 0).b(this.a.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity.8
 * JD-Core Version:    0.7.0.1
 */