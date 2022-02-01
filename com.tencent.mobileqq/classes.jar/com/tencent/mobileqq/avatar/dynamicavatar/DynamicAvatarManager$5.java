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
    synchronized (this.a.c)
    {
      i = this.a.c.size() - 1;
      if (i >= 0)
      {
        ??? = (WeakReference)this.a.c.get(i);
        if ((??? != null) && (((WeakReference)???).get() != null))
        {
          if (???.equals(((DynamicFaceDrawable)((WeakReference)this.a.c.get(i)).get()).jdField_b_of_type_JavaLangString))
          {
            ??? = (WeakReference)this.a.c.remove(i);
            if (paramBoolean1)
            {
              this.a.b.add(???);
              if (QLog.isColorLevel()) {
                QLog.i("Q.dynamicAvatar", 2, "onFileDownloadFinish add to wait play list.");
              }
            }
          }
        }
        else {
          this.a.c.remove(i);
        }
      }
      else
      {
        if (!DynamicFaceDrawable.jdField_b_of_type_Boolean)
        {
          ??? = null;
          synchronized (this.a.d)
          {
            i = this.a.d.size() - 1;
            for (;;)
            {
              ??? = (String)???;
              if (i < 0) {
                break;
              }
              if ((this.a.d.get(i) != null) && (((WeakReference)this.a.d.get(i)).get() != null))
              {
                ??? = (WeakReference)this.a.d.get(i);
                break;
              }
              this.a.d.remove(i);
              i -= 1;
            }
            if ((??? != null) && (???.get() != null)) {
              this.a.a((DynamicFaceDrawable)???.get(), false, false);
            }
          }
        }
        synchronized (this.a.a)
        {
          i = this.a.a.size() - 1;
          if (i >= 0)
          {
            if (((WeakReference)this.a.a.get(i)).get() == null) {
              this.a.a.remove(i);
            }
          }
          else
          {
            i = this.a.b.size() - 1;
            if (i >= 0)
            {
              ??? = (WeakReference)this.a.b.get(i);
              if ((??? != null) && (((WeakReference)???).get() != null))
              {
                if (this.a.a.size() < DynamicAvatarManager.a(this.a).a)
                {
                  this.a.b.remove(i);
                  if (this.a.a.contains(???)) {
                    break label782;
                  }
                  paramBoolean1 = this.a.a((DynamicFaceDrawable)((WeakReference)???).get());
                  if (paramBoolean1) {
                    this.a.a.add(???);
                  }
                  if (!QLog.isColorLevel()) {
                    break label782;
                  }
                  ??? = new StringBuilder();
                  ((StringBuilder)???).append("onFileDownloadFinish to play.02 result : ");
                  ((StringBuilder)???).append(paramBoolean1);
                  ((StringBuilder)???).append(" playing size: ");
                  ((StringBuilder)???).append(this.a.a.size());
                  QLog.i("Q.dynamicAvatar", 2, ((StringBuilder)???).toString());
                  break label782;
                }
                if (!QLog.isColorLevel()) {
                  break label782;
                }
                ??? = new StringBuilder();
                ((StringBuilder)???).append("onFileDownloadFinish to play.02 beyond maxPlayingCount : ");
                ((StringBuilder)???).append(DynamicAvatarManager.a(this.a).a);
                QLog.i("Q.dynamicAvatar", 2, ((StringBuilder)???).toString());
                break label782;
              }
              this.a.b.remove(i);
              break label782;
            }
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.5
 * JD-Core Version:    0.7.0.1
 */