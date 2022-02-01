package com.tencent.av.gaudio;

import android.widget.TextView;

class GaInviteLockActivity$MainThreadRunnableTask
  implements Runnable
{
  private String a;
  private String b;
  
  public GaInviteLockActivity$MainThreadRunnableTask(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void a(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public void run()
  {
    if (this.this$0.k != null) {
      this.this$0.k.setText(this.b);
    }
    if (this.this$0.h != null)
    {
      Object localObject = this.this$0;
      localObject = ((GaInviteLockActivity)localObject).a(((GaInviteLockActivity)localObject).d, this.this$0.b, this.a, true, false);
      this.this$0.h.setText(GaInviteLockActivity.b(this.this$0, (String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.MainThreadRunnableTask
 * JD-Core Version:    0.7.0.1
 */