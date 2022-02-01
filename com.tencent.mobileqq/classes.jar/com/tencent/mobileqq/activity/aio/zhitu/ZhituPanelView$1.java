package com.tencent.mobileqq.activity.aio.zhitu;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class ZhituPanelView$1
  implements Runnable
{
  ZhituPanelView$1(ZhituPanelView paramZhituPanelView, ZhituPicData paramZhituPicData) {}
  
  public void run()
  {
    Object localObject3;
    Object localObject2;
    if (!this.a.k)
    {
      localObject3 = ZhituManager.a(this.this$0.b.d).b(this.a.a, this.a.c);
      Object localObject1;
      if ((this.a.i instanceof BitmapDrawable)) {
        localObject1 = ((BitmapDrawable)this.a.i).getBitmap();
      } else {
        localObject1 = null;
      }
      if (localObject1 == null) {
        return;
      }
      try
      {
        if (!((File)localObject3).exists())
        {
          ((File)localObject3).getParentFile().mkdirs();
          ((File)localObject3).createNewFile();
        }
        boolean bool = FileUtils.saveBitmapToFile((Bitmap)localObject1, ((File)localObject3).getAbsolutePath());
        localObject1 = localObject3;
        if (bool) {
          break label239;
        }
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        ZhituManager.a(localOutOfMemoryError1);
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return;
      }
    }
    else if (this.a.b == null)
    {
      try
      {
        String str = ZhituManager.a(this.this$0.b.d).c(this.a);
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        QLog.e(ZhituPanelView.c(), 1, "oom when save bitmap");
        ZhituManager.a(localOutOfMemoryError2);
        localObject2 = null;
      }
      if (localObject2 == null) {
        return;
      }
      localObject2 = new File((String)localObject2);
    }
    else
    {
      localObject2 = ZhituManager.a(this.this$0.b.d).b(this.a.a, this.a.c);
      FileUtils.copyFile(this.a.b, ((File)localObject2).getAbsolutePath());
    }
    label239:
    if (ZhituManager.a(this.this$0.b.d).a() == 7220)
    {
      this.a.b = ((File)localObject2).getAbsolutePath();
      ZhituManager.a(this.this$0.b.d).h(this.a);
    }
    else
    {
      localObject3 = new Intent();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(((File)localObject2).getAbsolutePath());
      ((Intent)localObject3).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      ((Intent)localObject3).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1049);
      ((Intent)localObject3).putExtra("uin", this.this$0.b.ah.b);
      ((Intent)localObject3).putExtra("uintype", this.this$0.b.ah.a);
      ((Intent)localObject3).putExtra("troop_uin", this.this$0.b.ah.c);
      ((Intent)localObject3).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      ((Intent)localObject3).putExtra("send_in_background", true);
      ((Intent)localObject3).putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
      new SendPhotoTask(this.this$0.b.aX(), (Intent)localObject3, null).run();
    }
    ReportController.b(this.this$0.b.d, "dc00898", "", "", "0X8008C72", "0X8008C72", ZhituManager.a(ZhituManager.a(this.this$0.b.d).a()), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView.1
 * JD-Core Version:    0.7.0.1
 */