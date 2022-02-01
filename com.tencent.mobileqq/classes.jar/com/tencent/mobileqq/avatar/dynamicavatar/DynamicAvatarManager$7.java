package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.app.face.DynamicFaceDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

class DynamicAvatarManager$7
  implements Runnable
{
  DynamicAvatarManager$7(DynamicAvatarManager paramDynamicAvatarManager, DynamicFaceDrawable paramDynamicFaceDrawable) {}
  
  public void run()
  {
    int i;
    label249:
    synchronized (this.this$0.g)
    {
      if (!this.this$0.g.remove(this.a.x)) {
        return;
      }
      i = this.this$0.g.size() - 1;
      if (i >= 0)
      {
        if (((WeakReference)this.this$0.g.get(i)).get() == null) {
          this.this$0.g.remove(i);
        }
      }
      else
      {
        i = this.this$0.h.size() - 1;
        if (i >= 0)
        {
          WeakReference localWeakReference = (WeakReference)this.this$0.h.remove(i);
          if ((localWeakReference == null) || (localWeakReference.get() == null) || (this.this$0.g.contains(localWeakReference))) {
            break label249;
          }
          boolean bool = this.this$0.c((DynamicFaceDrawable)localWeakReference.get());
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onPlayFinished to play. result : ");
            localStringBuilder.append(bool);
            QLog.i("Q.dynamicAvatar", 2, localStringBuilder.toString());
          }
          if (bool) {
            this.this$0.g.add(localWeakReference);
          }
          return;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.7
 * JD-Core Version:    0.7.0.1
 */