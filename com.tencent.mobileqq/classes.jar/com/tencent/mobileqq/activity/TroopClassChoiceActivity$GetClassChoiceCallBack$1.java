package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogBean;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogTool;
import java.util.ArrayList;

class TroopClassChoiceActivity$GetClassChoiceCallBack$1
  implements Runnable
{
  TroopClassChoiceActivity$GetClassChoiceCallBack$1(TroopClassChoiceActivity.GetClassChoiceCallBack paramGetClassChoiceCallBack) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a.a.c))
    {
      this.a.a.a = GroupCatalogTool.a(this.a.a).b();
    }
    else
    {
      this.a.a.a = GroupCatalogTool.a(this.a.a).a(this.a.a.c);
      if ((this.a.a.a != null) && (this.a.a.a.size() > 0))
      {
        GroupCatalogBean localGroupCatalogBean = (GroupCatalogBean)this.a.a.a.get(0);
        if (localGroupCatalogBean.e != null) {
          this.a.a.setTitle(localGroupCatalogBean.e.b);
        }
      }
    }
    TroopClassChoiceActivity.b(this.a.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopClassChoiceActivity.GetClassChoiceCallBack.1
 * JD-Core Version:    0.7.0.1
 */