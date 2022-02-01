package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.app.face.DynamicFaceDrawable;

class DynamicAvatarView$1
  implements Runnable
{
  DynamicAvatarView$1(DynamicAvatarView paramDynamicAvatarView) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      DynamicAvatarView localDynamicAvatarView = this.this$0;
      localDynamicAvatarView.setImageDrawable(localDynamicAvatarView.a.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView.1
 * JD-Core Version:    0.7.0.1
 */