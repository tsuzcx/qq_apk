package com.tencent.mobileqq.activity.contact.newfriend;

import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.OnTabSelectedListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.Tab;
import com.tencent.mobileqq.activity.contact.connections.ListviewScrollStatus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;

class SystemMsgListView$2
  implements TabLayoutCompat.OnTabSelectedListener
{
  SystemMsgListView$2(SystemMsgListView paramSystemMsgListView) {}
  
  public void a(TabLayoutCompat.Tab paramTab)
  {
    int j;
    if (paramTab != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "setStickHead onTabSelected : position = " + paramTab.a() + " tabid = " + (Integer)paramTab.a());
      }
      SystemMsgListView.a(this.a).a(((Integer)paramTab.a()).intValue(), paramTab.a());
      i = SystemMsgListView.a(this.a).b();
      paramTab = (ListviewScrollStatus)SystemMsgListView.a(this.a).get(i);
      if (paramTab == null) {
        break label141;
      }
      j = paramTab.b;
    }
    for (int i = paramTab.c;; i = SystemMsgListView.a(this.a).c)
    {
      SystemMsgListView.a(this.a).setSelectionFromTop(j, i);
      SystemMsgListView.a(this.a).a(0L);
      return;
      label141:
      j = SystemMsgListView.a(this.a).b;
    }
  }
  
  public void b(TabLayoutCompat.Tab paramTab) {}
  
  public void c(TabLayoutCompat.Tab paramTab) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView.2
 * JD-Core Version:    0.7.0.1
 */