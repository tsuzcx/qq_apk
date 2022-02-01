package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.FriendListObserverCallback;
import com.tencent.mobileqq.utils.api.IContactUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

class SubAccountBindActivity$5
  implements ISubAccountApi.FriendListObserverCallback
{
  SubAccountBindActivity$5(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramString == null) {
        return;
      }
      Object localObject = SubAccountBindActivity.access$100(this.a);
      int j = 0;
      int i;
      if (localObject != null) {
        i = SubAccountBindActivity.access$100(this.a).getChildCount();
      } else {
        i = 0;
      }
      while (j < SubAccountBindActivity.access$000(this.a).size())
      {
        if ((i > j) && (SubAccountBindActivity.access$000(this.a).get(j) != null) && (paramString.equals(((SimpleAccount)SubAccountBindActivity.access$000(this.a).get(j)).getUin())))
        {
          localObject = (TextView)SubAccountBindActivity.access$100(this.a).getChildAt(j).findViewById(2131439121);
          TextView localTextView = (TextView)SubAccountBindActivity.access$100(this.a).getChildAt(j).findViewById(2131427416);
          ((TextView)localObject).setText(((IContactUtils)QRoute.api(IContactUtils.class)).getAccountNickName(this.a.app, paramString));
          localTextView.setText(paramString);
          this.a.updateFace(paramString, j);
          return;
        }
        j += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity.5
 * JD-Core Version:    0.7.0.1
 */