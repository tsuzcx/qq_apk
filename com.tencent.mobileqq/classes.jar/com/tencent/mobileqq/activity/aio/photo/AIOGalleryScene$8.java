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
              this.a.B();
              QQToast.a(AIOGalleryScene.m(this.a), 2, HardCodeUtil.a(2131700281), 0).a();
              NativeVideoImage.resumeAll();
              AIOGalleryScene.a(this.a);
              return;
            }
            this.a.B();
            QQToast.a(AIOGalleryScene.l(this.a), 1, HardCodeUtil.a(2131700292), 0).a();
            NativeVideoImage.resumeAll();
            AIOGalleryScene.a(this.a);
            return;
          }
          paramMessage = this.a;
          paramMessage.n = true;
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
        paramMessage = DialogUtil.a(AIOGalleryScene.i(this.a), 232, AIOGalleryScene.j(this.a).getResources().getString(2131719107), AIOGalleryScene.k(this.a).getResources().getString(2131719106), 2131719090, 2131718205, new AIOGalleryScene.8.1(this, paramMessage), new AIOGalleryScene.8.2(this));
      }
    }
    try
    {
      paramMessage.show();
      return;
    }
    catch (Throwable paramMessage) {}
    AIOGalleryScene.f(this.a).getString(2131719076);
    paramMessage = (String)paramMessage.obj;
    ImageUtil.a(AIOGalleryScene.g(this.a), paramMessage);
    QQToast.a(AIOGalleryScene.h(this.a), 2, HardCodeUtil.a(2131700274), 0).a();
    return;
    QQToast.a(AIOGalleryScene.e(this.a), 2131719075, 0).a();
    label318:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.8
 * JD-Core Version:    0.7.0.1
 */