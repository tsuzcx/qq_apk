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
    if (this.a.isFinishing()) {
      return;
    }
    if ((Build.VERSION.SDK_INT >= 17) && (this.a.isDestroyed())) {
      return;
    }
    if (paramInt > 0)
    {
      this.a.m.d();
      this.a.m.notifyDataSetChanged();
      this.a.f.setSelectionFromBottom(paramInt, 0);
    }
    this.a.f.springBackOverScrollHeaderView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.6
 * JD-Core Version:    0.7.0.1
 */