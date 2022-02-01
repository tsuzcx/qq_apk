package com.tencent.mobileqq.activity;

import android.widget.LinearLayout;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

class SubAccountBindActivity$6
  extends AvatarObserver
{
  SubAccountBindActivity$6(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
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
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity.6
 * JD-Core Version:    0.7.0.1
 */