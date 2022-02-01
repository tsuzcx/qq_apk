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
    synchronized (this.this$0.a)
    {
      if (!this.this$0.a.remove(this.a.b)) {
        return;
      }
      i = this.this$0.a.size() - 1;
      if (i >= 0)
      {
        if (((WeakReference)this.this$0.a.get(i)).get() == null) {
          this.this$0.a.remove(i);
        }
      }
      else
      {
        i = this.this$0.b.size() - 1;
        if (i >= 0)
        {
          WeakReference localWeakReference = (WeakReference)this.this$0.b.remove(i);
          if ((localWeakReference == null) || (localWeakReference.get() == null) || (this.this$0.a.contains(localWeakReference))) {
            break label249;
          }
          boolean bool = this.this$0.a((DynamicFaceDrawable)localWeakReference.get());
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onPlayFinished to play. result : ");
            localStringBuilder.append(bool);
            QLog.i("Q.dynamicAvatar", 2, localStringBuilder.toString());
          }
          if (bool) {
            this.this$0.a.add(localWeakReference);
          }
          return;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.7
 * JD-Core Version:    0.7.0.1
 */