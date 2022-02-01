package com.tencent.mobileqq.apollo.statistics.trace.sdk.state;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.WeakReferenceHandler;

public class TraceStateMachineScheduler
  implements Handler.Callback
{
  private int a;
  private final TraceStateMachineScheduler.StateMachine b;
  private final Handler c;
  private boolean d = true;
  private TraceStateMachineScheduler.TimeOutState e = null;
  private boolean f = false;
  
  public TraceStateMachineScheduler(TraceStateMachineScheduler.StateMachine paramStateMachine)
  {
    this.b = paramStateMachine;
    this.c = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
  }
  
  public void a()
  {
    this.d = false;
  }
  
  public void a(int paramInt, TraceStateMachineScheduler.TimeOutState paramTimeOutState)
  {
    this.a = paramInt;
    this.e = paramTimeOutState;
  }
  
  public void a(Bundle paramBundle)
  {
    this.f = false;
    while (!this.f)
    {
      int i = this.b.e(paramBundle);
      if (i != -1)
      {
        if ((i != 0) && (i == 1) && (this.d))
        {
          Message localMessage = this.c.obtainMessage(2);
          localMessage.setData(paramBundle);
          this.c.sendMessage(localMessage);
        }
      }
      else if ((this.e != null) && (this.a > 0))
      {
        paramBundle = this.c.obtainMessage(3);
        this.c.sendMessageDelayed(paramBundle, this.a);
      }
    }
  }
  
  public void b()
  {
    this.f = true;
    this.e = null;
    this.c.removeMessages(2);
    this.c.removeMessages(3);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 2)
    {
      if (i == 3)
      {
        paramMessage = this.e;
        if (paramMessage != null)
        {
          paramMessage.b();
          this.e = null;
        }
      }
      return false;
    }
    if (!this.f) {
      a(paramMessage.getData());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.sdk.state.TraceStateMachineScheduler
 * JD-Core Version:    0.7.0.1
 */