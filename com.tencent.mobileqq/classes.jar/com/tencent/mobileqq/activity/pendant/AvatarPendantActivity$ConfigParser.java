package com.tencent.mobileqq.activity.pendant;

import java.lang.ref.WeakReference;

public class AvatarPendantActivity$ConfigParser
  implements Runnable
{
  private String a;
  private WeakReference<AvatarPendantActivity> b;
  
  public AvatarPendantActivity$ConfigParser(String paramString, AvatarPendantActivity paramAvatarPendantActivity)
  {
    this.a = paramString;
    this.b = new WeakReference(paramAvatarPendantActivity);
  }
  
  public void run()
  {
    AvatarPendantActivity localAvatarPendantActivity = (AvatarPendantActivity)this.b.get();
    if (localAvatarPendantActivity != null) {
      localAvatarPendantActivity.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.ConfigParser
 * JD-Core Version:    0.7.0.1
 */