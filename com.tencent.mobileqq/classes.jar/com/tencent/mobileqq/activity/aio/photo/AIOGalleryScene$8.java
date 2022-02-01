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
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
      do
      {
        do
        {
          return;
          QQToast.a(AIOGalleryScene.e(this.a), 2131719357, 0).a();
          return;
          AIOGalleryScene.f(this.a).getString(2131719358);
          paramMessage = (String)paramMessage.obj;
          ImageUtil.a(AIOGalleryScene.g(this.a), paramMessage);
          QQToast.a(AIOGalleryScene.h(this.a), 2, HardCodeUtil.a(2131700133), 0).a();
          return;
        } while (paramMessage.obj == null);
        paramMessage = new File((String)paramMessage.obj);
      } while (!paramMessage.exists());
      paramMessage = DialogUtil.a(AIOGalleryScene.i(this.a), 232, AIOGalleryScene.j(this.a).getResources().getString(2131719389), AIOGalleryScene.k(this.a).getResources().getString(2131719388), 2131719372, 2131718540, new AIOGalleryScene.8.1(this, paramMessage), new AIOGalleryScene.8.2(this));
      try
      {
        paramMessage.show();
        return;
      }
      catch (Throwable paramMessage)
      {
        return;
      }
    case 10001: 
      this.a.B();
      QQToast.a(AIOGalleryScene.l(this.a), 1, HardCodeUtil.a(2131700151), 0).a();
      NativeVideoImage.resumeAll();
      AIOGalleryScene.a(this.a);
      return;
    case 10000: 
      this.a.n = true;
      this.a.d(100);
      sendEmptyMessageDelayed(10003, 200L);
      return;
    }
    this.a.B();
    QQToast.a(AIOGalleryScene.m(this.a), 2, HardCodeUtil.a(2131700140), 0).a();
    NativeVideoImage.resumeAll();
    AIOGalleryScene.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.8
 * JD-Core Version:    0.7.0.1
 */