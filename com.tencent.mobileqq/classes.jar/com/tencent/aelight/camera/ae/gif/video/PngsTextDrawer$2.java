package com.tencent.aelight.camera.ae.gif.video;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextDrawer;
import com.tencent.aelight.camera.aebase.Util;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

class PngsTextDrawer$2
  implements Runnable
{
  PngsTextDrawer$2(PngsTextDrawer paramPngsTextDrawer, PngsTextDrawer.Callback paramCallback) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(PngsTextDrawer.d(this.this$0));
    ((StringBuilder)localObject1).append(System.currentTimeMillis());
    localObject1 = ((StringBuilder)localObject1).toString();
    try
    {
      new File((String)localObject1).mkdirs();
      PngsTextDrawer.c(this.this$0).a();
      localObject2 = PngsTextDrawer.c(this.this$0).b();
      localObject3 = this.this$0;
      localObject3 = PngsTextDrawer.a((PngsTextDrawer)localObject3, PngsTextDrawer.e((PngsTextDrawer)localObject3)).iterator();
      String str;
      for (;;)
      {
        boolean bool = ((Iterator)localObject3).hasNext();
        i = 0;
        if (!bool) {
          break label269;
        }
        str = (String)((Iterator)localObject3).next();
        Bitmap localBitmap = Util.a(str, PngsTextDrawer.a(this.this$0), PngsTextDrawer.b(this.this$0), true);
        if (localBitmap == null) {
          break;
        }
        new Canvas(localBitmap).drawBitmap((Bitmap)localObject2, PngsTextDrawer.f(this.this$0), PngsTextDrawer.g(this.this$0), new Paint());
        str = new File(str).getName();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(File.separator);
        localStringBuilder.append(str);
        Util.a(localStringBuilder.toString(), localBitmap);
        localBitmap.recycle();
      }
      QLog.d(PngsTextDrawer.a(), 4, new Object[] { "draw frame but bitmap == null, png path = ", str });
      break label271;
      label269:
      int i = 1;
      label271:
      PngsTextDrawer.c(this.this$0).c();
      localObject2 = this.a;
      if (localObject2 != null)
      {
        if (i != 0)
        {
          ((PngsTextDrawer.Callback)localObject2).a((String)localObject1);
          return;
        }
        ((PngsTextDrawer.Callback)localObject2).a();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Object localObject2 = PngsTextDrawer.a();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("start add text exception, msg = ");
      ((StringBuilder)localObject3).append(localException.getMessage());
      QLog.d((String)localObject2, 4, ((StringBuilder)localObject3).toString());
      PngsTextDrawer.Callback localCallback = this.a;
      if (localCallback != null) {
        localCallback.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.PngsTextDrawer.2
 * JD-Core Version:    0.7.0.1
 */