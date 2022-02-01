package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class MultiIncomingCallsActivity$10
  implements Runnable
{
  MultiIncomingCallsActivity$10(MultiIncomingCallsActivity paramMultiIncomingCallsActivity, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    ArrayList localArrayList = this.this$0.f.a(this.a, this.b);
    if (MultiIncomingCallsActivity.h(this.this$0) != null)
    {
      ThreadManager.getUIHandler().removeCallbacks(MultiIncomingCallsActivity.h(this.this$0));
      MultiIncomingCallsActivity.b(this.this$0, null);
    }
    MultiIncomingCallsActivity.b(this.this$0, new MultiIncomingCallsActivity.10.1(this, localArrayList));
    ThreadManager.getUIHandler().post(MultiIncomingCallsActivity.h(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.10
 * JD-Core Version:    0.7.0.1
 */