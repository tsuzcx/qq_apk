package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import mqq.os.MqqHandler;

class AIOGalleryScene$8
  extends MqqHandler
{
  AIOGalleryScene$8(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1) {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 10000)
          {
            if (i != 10001)
            {
              if (i != 10003) {
                return;
              }
              this.a.O();
              QQToast.makeText(AIOGalleryScene.s(this.a), 2, HardCodeUtil.a(2131898321), 0).show();
              NativeVideoImage.resumeAll();
              AIOGalleryScene.r(this.a);
              return;
            }
            this.a.O();
            QQToast.makeText(AIOGalleryScene.q(this.a), 1, HardCodeUtil.a(2131898332), 0).show();
            NativeVideoImage.resumeAll();
            AIOGalleryScene.r(this.a);
            return;
          }
          paramMessage = this.a;
          paramMessage.ak = true;
          paramMessage.b(100);
          sendEmptyMessageDelayed(10003, 200L);
          return;
        }
        if (paramMessage.obj == null) {
          break label318;
        }
        paramMessage = new File((String)paramMessage.obj);
        if (!paramMessage.exists()) {
          break label318;
        }
        paramMessage = DialogUtil.a(AIOGalleryScene.n(this.a), 232, AIOGalleryScene.o(this.a).getResources().getString(2131916643), AIOGalleryScene.p(this.a).getResources().getString(2131916642), 2131916626, 2131915687, new AIOGalleryScene.8.1(this, paramMessage), new AIOGalleryScene.8.2(this));
      }
    }
    try
    {
      paramMessage.show();
      return;
    }
    catch (Throwable paramMessage) {}
    AIOGalleryScene.k(this.a).getString(2131916612);
    paramMessage = (String)paramMessage.obj;
    ImageUtil.b(AIOGalleryScene.l(this.a), paramMessage);
    QQToast.makeText(AIOGalleryScene.m(this.a), 2, HardCodeUtil.a(2131898316), 0).show();
    return;
    QQToast.makeText(AIOGalleryScene.j(this.a), 2131916611, 0).show();
    label318:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.8
 * JD-Core Version:    0.7.0.1
 */