package com.tencent.mobileqq.activity.activateFriend;

import android.content.res.Resources;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendServlet;
import com.tencent.mobileqq.widget.QQToast;

class ActivateFriendActivity$8
  extends CardObserver
{
  ActivateFriendActivity$8(ActivateFriendActivity paramActivateFriendActivity) {}
  
  public void onGetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((ActivateFriendActivity.a(this.a) != paramBoolean2) && (paramBoolean2 == true))
    {
      ActivateFriendServlet.a(this.a.app, false, true, false, true);
      this.a.a();
    }
    ActivateFriendActivity.a(this.a, paramBoolean2);
  }
  
  public void onSetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((ActivateFriendActivity.a(this.a) != paramBoolean2) && (paramBoolean2 == true))
    {
      ActivateFriendServlet.a(this.a.app, false, true, false, true);
      this.a.a();
    }
    if (!this.a.isFinishing())
    {
      if (!paramBoolean1) {
        break label161;
      }
      ActivateFriendActivity.a(this.a, paramBoolean2);
      if (!ActivateFriendActivity.a(this.a)) {
        break label148;
      }
    }
    label148:
    for (String str = this.a.getString(2131689534);; str = this.a.getString(2131689535))
    {
      str = this.a.getString(2131689537, new Object[] { str });
      QQToast.a(this.a, 2, str, 0).b(this.a.getTitleBarHeight());
      if (ActivateFriendActivity.a(this.a) != null)
      {
        ActivateFriendActivity.a(this.a).c();
        ActivateFriendActivity.b(this.a);
      }
      return;
    }
    label161:
    QQToast.a(this.a, 1, this.a.getResources().getString(2131719116), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity.8
 * JD-Core Version:    0.7.0.1
 */