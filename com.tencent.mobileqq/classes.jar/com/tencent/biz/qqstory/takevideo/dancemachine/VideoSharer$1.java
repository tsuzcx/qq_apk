package com.tencent.biz.qqstory.takevideo.dancemachine;

import ajya;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import vkg;
import vkh;

public class VideoSharer$1
  implements Runnable
{
  public VideoSharer$1(vkg paramvkg, int paramInt) {}
  
  public void run()
  {
    int i;
    if (this.a == 0)
    {
      i = this.this$0.a(this.this$0.j, this.this$0.i, this.this$0.h);
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachinePKVideoSharer", 2, "[DanceMachine Share]  shareToSinaResult : " + i);
      }
      if (i != 0) {
        this.this$0.a.runOnUiThread(new VideoSharer.1.1(this, i));
      }
    }
    Bitmap localBitmap;
    do
    {
      for (;;)
      {
        return;
        Object localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.this$0.h, (BitmapFactory.Options)localObject);
        if (((BitmapFactory.Options)localObject).outHeight == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DanceMachinePKVideoSharer", 2, "decode bitmap failed, outHeight == 0");
          }
        }
        else
        {
          i = ((BitmapFactory.Options)localObject).outHeight / 120;
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
          ((BitmapFactory.Options)localObject).inSampleSize = i;
          try
          {
            localObject = BitmapFactory.decodeFile(this.this$0.h, (BitmapFactory.Options)localObject);
            if (localObject == null)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("DanceMachinePKVideoSharer", 2, "decode bitmap failed : iconBitmap is null");
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            for (;;)
            {
              localBitmap = null;
            }
            int j = localBitmap.getRowBytes();
            int k = localBitmap.getHeight();
            if (QLog.isColorLevel()) {
              QLog.d("DanceMachinePKVideoSharer", 2, "share to wechat bitmap ratio  : " + i + "   size : " + j * k / 1024 + "KB  fileSize : " + new File(this.this$0.h).length());
            }
            if (vkg.a(this.this$0) == null) {
              vkg.a(this.this$0, new vkh(this, localBitmap));
            }
            if (this.a == 1)
            {
              WXShareHelper.a().d(String.valueOf(System.currentTimeMillis()), this.this$0.j, localBitmap, ajya.a(2131716391), this.this$0.i);
              WXShareHelper.a().a(vkg.a(this.this$0));
              vkg.a(this.this$0, 1);
              return;
            }
          }
        }
      }
    } while (this.a != 2);
    WXShareHelper.a().c(String.valueOf(System.currentTimeMillis()), this.this$0.j, localBitmap, ajya.a(2131716387), this.this$0.i);
    WXShareHelper.a().a(vkg.a(this.this$0));
    vkg.a(this.this$0, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.dancemachine.VideoSharer.1
 * JD-Core Version:    0.7.0.1
 */