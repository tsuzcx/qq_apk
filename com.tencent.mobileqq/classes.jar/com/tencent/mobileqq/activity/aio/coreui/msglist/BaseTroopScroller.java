package com.tencent.mobileqq.activity.aio.coreui.msglist;

import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.navigatebar.AioTips;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import java.util.Observer;

public class BaseTroopScroller
  extends Scroller
{
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.a(paramLong1, paramLong2, paramBoolean);
  }
  
  public void a(Observer paramObserver, RelativeLayout paramRelativeLayout, ChatAdapter1 paramChatAdapter1)
  {
    if (this.e == null) {
      this.e = new TroopAioTips();
    }
    if (this.d != null)
    {
      this.d.a((TroopAioTips)this.e);
      if (QLog.isColorLevel()) {
        QLog.d("BaseTroopScroller", 2, "Base#onShow_troopType#setTroopTips");
      }
    }
    super.a(paramObserver, paramRelativeLayout, paramChatAdapter1);
  }
  
  public boolean b()
  {
    return (this.e != null) && (this.e.cB_());
  }
  
  public TroopAioMsgNavigateBar c()
  {
    return (TroopAioMsgNavigateBar)this.e.k();
  }
  
  public TroopAioTips d()
  {
    return (TroopAioTips)this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.BaseTroopScroller
 * JD-Core Version:    0.7.0.1
 */