package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import java.util.Locale;

class AIOGalleryScene$7
  implements MessageQueue.IdleHandler
{
  AIOGalleryScene$7(AIOGalleryScene paramAIOGalleryScene) {}
  
  public boolean queueIdle()
  {
    Object localObject = this.a.c.c();
    if ((localObject != null) && (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject).a)))
    {
      AIOImageData localAIOImageData = (AIOImageData)((AIORichMediaInfo)localObject).a;
      if ((localAIOImageData != null) && (localAIOImageData.a(4)) && (localAIOImageData.c(4) == null))
      {
        this.a.d(true);
        this.a.E();
      }
    }
    if ((localObject != null) && (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject).a)))
    {
      localObject = (AIOFilePicData)((AIORichMediaInfo)localObject).a;
      if ((localObject != null) && (((AIOFilePicData)localObject).a(20)) && (((AIOFilePicData)localObject).c(20) == null))
      {
        if ((((AIOFilePicData)localObject).k) && (MessageRecordInfo.b(((AIOFilePicData)localObject).p)))
        {
          this.a.d(true);
          this.a.c(false);
          this.a.J = null;
        }
        else if (((AIOFilePicData)localObject).n)
        {
          this.a.d(false);
        }
        else
        {
          this.a.d(true);
        }
        if (this.a.f != null) {
          this.a.f.setText(String.format(Locale.CHINA, AIOGalleryScene.i(this.a).getString(2131892727), new Object[] { FileUtil.a(((AIOFilePicData)localObject).l) }));
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.7
 * JD-Core Version:    0.7.0.1
 */