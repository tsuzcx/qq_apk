package com.tencent.biz.qqcircle.viewmodels;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class QCirclePublishButtonViewModel$2
  implements URLDrawable.URLDrawableListener
{
  QCirclePublishButtonViewModel$2(QCirclePublishButtonViewModel paramQCirclePublishButtonViewModel) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.e("QCirclePublishButtonViewModel", 1, "backImg onLoadCanceled: ");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("QCirclePublishButtonViewModel", 1, "backImg onLoadFialed: ", paramThrowable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.i("QCirclePublishButtonViewModel", 1, "backImg onLoadSuccessed");
    if (QCirclePublishButtonViewModel.a(this.a) == null) {
      return;
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inDensity = 320;
    paramURLDrawable = BitmapFactory.decodeFile(paramURLDrawable.getFileInLocal().getAbsolutePath(), (BitmapFactory.Options)localObject);
    if (paramURLDrawable != null)
    {
      localObject = QCirclePublishButtonViewModel.a(this.a);
      Resources localResources = QCircleApplication.APP.getResources();
      Rect localRect = new Rect();
      ((QCirclePublishButtonViewModel.PublishButtonEventInfo)localObject).e = new NinePatchDrawable(localResources, paramURLDrawable, new byte[] { 1, 2, 2, 3, 32, 0, 0, 0, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 48, 0, 0, 0, -88, 0, 0, 0, -87, 0, 0, 0, 0, 0, 0, 0, -54, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }, localRect, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCirclePublishButtonViewModel.2
 * JD-Core Version:    0.7.0.1
 */