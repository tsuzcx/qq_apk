package com.tencent.mobileqq.avatar.dynamicavatar;

import android.text.TextUtils;
import com.tencent.mobileqq.app.face.DynamicFaceDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

class DynamicAvatarManager$5
  implements DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback
{
  DynamicAvatarManager$5(DynamicAvatarManager paramDynamicAvatarManager) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String arg1, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onDownloadFinish url: ");
      ((StringBuilder)???).append(???);
      ((StringBuilder)???).append(" isSuccess: ");
      ((StringBuilder)???).append(paramBoolean1);
      ((StringBuilder)???).append(" isFileExist: ");
      ((StringBuilder)???).append(paramBoolean2);
      QLog.i("Q.dynamicAvatar", 2, ((StringBuilder)???).toString());
    }
    if (TextUtils.isEmpty(???)) {
      return;
    }
    int i;
    label782:
    synchronized (this.a.i)
    {
      i = this.a.i.size() - 1;
      if (i >= 0)
      {
        ??? = (WeakReference)this.a.i.get(i);
        if ((??? != null) && (((WeakReference)???).get() != null))
        {
          if (???.equals(((DynamicFaceDrawable)((WeakReference)this.a.i.get(i)).get()).n))
          {
            ??? = (WeakReference)this.a.i.remove(i);
            if (paramBoolean1)
            {
              this.a.h.add(???);
              if (QLog.isColorLevel()) {
                QLog.i("Q.dynamicAvatar", 2, "onFileDownloadFinish add to wait play list.");
              }
            }
          }
        }
        else {
          this.a.i.remove(i);
        }
      }
      else
      {
        if (!DynamicFaceDrawable.f)
        {
          ??? = null;
          synchronized (this.a.j)
          {
            i = this.a.j.size() - 1;
            for (;;)
            {
              ??? = (String)???;
              if (i < 0) {
                break;
              }
              if ((this.a.j.get(i) != null) && (((WeakReference)this.a.j.get(i)).get() != null))
              {
                ??? = (WeakReference)this.a.j.get(i);
                break;
              }
              this.a.j.remove(i);
              i -= 1;
            }
            if ((??? != null) && (???.get() != null)) {
              this.a.a((DynamicFaceDrawable)???.get(), false, false);
            }
          }
        }
        synchronized (this.a.g)
        {
          i = this.a.g.size() - 1;
          if (i >= 0)
          {
            if (((WeakReference)this.a.g.get(i)).get() == null) {
              this.a.g.remove(i);
            }
          }
          else
          {
            i = this.a.h.size() - 1;
            if (i >= 0)
            {
              ??? = (WeakReference)this.a.h.get(i);
              if ((??? != null) && (((WeakReference)???).get() != null))
              {
                if (this.a.g.size() < DynamicAvatarManager.b(this.a).j)
                {
                  this.a.h.remove(i);
                  if (this.a.g.contains(???)) {
                    break label782;
                  }
                  paramBoolean1 = this.a.c((DynamicFaceDrawable)((WeakReference)???).get());
                  if (paramBoolean1) {
                    this.a.g.add(???);
                  }
                  if (!QLog.isColorLevel()) {
                    break label782;
                  }
                  ??? = new StringBuilder();
                  ((StringBuilder)???).append("onFileDownloadFinish to play.02 result : ");
                  ((StringBuilder)???).append(paramBoolean1);
                  ((StringBuilder)???).append(" playing size: ");
                  ((StringBuilder)???).append(this.a.g.size());
                  QLog.i("Q.dynamicAvatar", 2, ((StringBuilder)???).toString());
                  break label782;
                }
                if (!QLog.isColorLevel()) {
                  break label782;
                }
                ??? = new StringBuilder();
                ((StringBuilder)???).append("onFileDownloadFinish to play.02 beyond maxPlayingCount : ");
                ((StringBuilder)???).append(DynamicAvatarManager.b(this.a).j);
                QLog.i("Q.dynamicAvatar", 2, ((StringBuilder)???).toString());
                break label782;
              }
              this.a.h.remove(i);
              break label782;
            }
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.5
 * JD-Core Version:    0.7.0.1
 */