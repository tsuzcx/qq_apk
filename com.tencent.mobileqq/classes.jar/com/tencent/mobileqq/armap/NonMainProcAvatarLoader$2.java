package com.tencent.mobileqq.armap;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class NonMainProcAvatarLoader$2
  extends Handler
{
  NonMainProcAvatarLoader$2(NonMainProcAvatarLoader paramNonMainProcAvatarLoader, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000)
    {
      if (this.a.g.size() > 0)
      {
        paramMessage = new ArrayList(this.a.g.size());
        paramMessage.addAll(this.a.g);
        this.a.a(paramMessage);
        this.a.g.removeAll(paramMessage);
      }
    }
    else if (paramMessage.what == 1002) {
      try
      {
        Object localObject2 = (Bundle)paramMessage.obj;
        localObject1 = (Bitmap)((Bundle)localObject2).getParcelable("bmp");
        paramMessage = ((Bundle)localObject2).getString("uin");
        localObject2 = ((Bundle)localObject2).getString("path");
        if (localObject1 != null) {
          this.a.d.put(paramMessage, localObject1);
        }
        Iterator localIterator = this.a.h.iterator();
        while (localIterator.hasNext())
        {
          FaceObserver localFaceObserver = (FaceObserver)localIterator.next();
          if (localFaceObserver != null) {
            localFaceObserver.a(paramMessage, (String)localObject2, (Bitmap)localObject1);
          }
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("refreshImg, uin:");
          ((StringBuilder)localObject1).append(paramMessage);
          ((StringBuilder)localObject1).append(", path=");
          ((StringBuilder)localObject1).append((String)localObject2);
          QLog.d("NonMainAppHeadLoader", 2, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      catch (Exception paramMessage)
      {
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("refreshImg, exception:");
          ((StringBuilder)localObject1).append(paramMessage.toString());
          QLog.e("NonMainAppHeadLoader", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.NonMainProcAvatarLoader.2
 * JD-Core Version:    0.7.0.1
 */