package com.tencent.av.wtogether.adapter;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;

class QGroupExpandableListAdapter$4
  implements Runnable
{
  QGroupExpandableListAdapter$4(QGroupExpandableListAdapter paramQGroupExpandableListAdapter) {}
  
  public void run()
  {
    ((TroopManager)this.this$0.a.getManager(QQManagerFactory.TROOP_MANAGER)).a();
    this.this$0.a.runOnUiThread(new QGroupExpandableListAdapter.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.QGroupExpandableListAdapter.4
 * JD-Core Version:    0.7.0.1
 */