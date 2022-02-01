package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter.IForwardRecentListAdapterCallback;
import com.tencent.qphone.base.util.QLog;

class ForwardRecentActivity$16
  implements ForwardRecentListAdapter.IForwardRecentListAdapterCallback
{
  ForwardRecentActivity$16(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void a(View paramView)
  {
    boolean bool = ForwardRecentActivity.access$400(this.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onItemViewClicked");
      localStringBuilder.append(bool);
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      ForwardRecentActivity.access$2300(this.a, paramView);
      return;
    }
    this.a.onListViewItemClickedInDefaultStatus(paramView);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return ForwardRecentActivity.access$500(this.a, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.16
 * JD-Core Version:    0.7.0.1
 */