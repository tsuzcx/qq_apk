package com.tencent.mobileqq.activity;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool.GetChoiceListCallback;
import com.tencent.qphone.base.util.QLog;
import ttv;

public class TroopClassChoiceActivity$GetClassChoiceCallBack
  implements GroupCatalogTool.GetChoiceListCallback
{
  protected TroopClassChoiceActivity$GetClassChoiceCallBack(TroopClassChoiceActivity paramTroopClassChoiceActivity) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.a = GroupCatalogTool.a(BaseApplicationImpl.getContext()).a(BaseApplicationImpl.getContext(), TroopClassChoiceActivity.a(this.a));
      this.a.runOnUiThread(new ttv(this));
      return;
    }
    QLog.e("IphoneTitleBarActivity", 1, "getClassChoiceFromServer failed!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopClassChoiceActivity.GetClassChoiceCallBack
 * JD-Core Version:    0.7.0.1
 */