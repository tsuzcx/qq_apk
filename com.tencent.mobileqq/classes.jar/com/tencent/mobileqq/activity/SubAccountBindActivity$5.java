package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

class SubAccountBindActivity$5
  extends FriendListObserver
{
  SubAccountBindActivity$5(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    int j = 0;
    if ((!paramBoolean) || (paramString == null)) {}
    for (;;)
    {
      return;
      int i;
      if (SubAccountBindActivity.a(this.a) != null) {
        i = SubAccountBindActivity.a(this.a).getChildCount();
      }
      while (j < SubAccountBindActivity.a(this.a).size())
      {
        if ((i > j) && (SubAccountBindActivity.a(this.a).get(j) != null) && (paramString.equals(((SimpleAccount)SubAccountBindActivity.a(this.a).get(j)).getUin())))
        {
          TextView localTextView1 = (TextView)SubAccountBindActivity.a(this.a).getChildAt(j).findViewById(2131372115);
          TextView localTextView2 = (TextView)SubAccountBindActivity.a(this.a).getChildAt(j).findViewById(2131361857);
          localTextView1.setText(ContactUtils.h(this.a.app, paramString));
          localTextView2.setText(paramString);
          this.a.a(paramString, j);
          return;
        }
        j += 1;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity.5
 * JD-Core Version:    0.7.0.1
 */