package com.dataline.activities;

import android.os.Build.VERSION;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy.LoadMoreAioMessageCb;
import com.tencent.widget.XListView;

class LiteActivity$6
  implements DataLineMsgProxy.LoadMoreAioMessageCb
{
  LiteActivity$6(LiteActivity paramLiteActivity) {}
  
  public void a(int paramInt)
  {
    if (this.a.isFinishing()) {}
    while ((Build.VERSION.SDK_INT >= 17) && (this.a.isDestroyed())) {
      return;
    }
    if (paramInt > 0)
    {
      this.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.b();
      this.a.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromBottom(paramInt, 0);
    }
    this.a.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.6
 * JD-Core Version:    0.7.0.1
 */