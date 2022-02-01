package com.tencent.mobileqq.activity.pendant;

import android.widget.TextView;

class AvatarPendantActivity$RemoveTips
  implements Runnable
{
  private boolean a;
  private boolean b;
  
  public AvatarPendantActivity$RemoveTips(AvatarPendantActivity paramAvatarPendantActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  public void run()
  {
    if (this.b) {
      this.this$0.b.setVisibility(8);
    }
    if (this.a) {
      this.this$0.a.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.RemoveTips
 * JD-Core Version:    0.7.0.1
 */