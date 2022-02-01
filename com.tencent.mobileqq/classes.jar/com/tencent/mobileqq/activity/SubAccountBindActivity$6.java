package com.tencent.mobileqq.activity;

import android.widget.LinearLayout;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

class SubAccountBindActivity$6
  extends AvatarObserver
{
  SubAccountBindActivity$6(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (paramString == null) {
        return;
      }
      LinearLayout localLinearLayout = SubAccountBindActivity.access$100(this.a);
      int j = 0;
      int i;
      if (localLinearLayout != null) {
        i = SubAccountBindActivity.access$100(this.a).getChildCount();
      } else {
        i = 0;
      }
      while (j < SubAccountBindActivity.access$000(this.a).size())
      {
        if ((i > j) && (SubAccountBindActivity.access$000(this.a).get(j) != null) && (paramString.equals(((SimpleAccount)SubAccountBindActivity.access$000(this.a).get(j)).getUin())))
        {
          this.a.updateFace(paramString, j);
          return;
        }
        j += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity.6
 * JD-Core Version:    0.7.0.1
 */