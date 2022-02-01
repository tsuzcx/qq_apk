package com.tencent.mobileqq.activity.aio;

import android.graphics.Bitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

class CustomizeStrategyFactory$PanelStrategy$1$1
  implements IPreloadService.OnGetPathListener
{
  CustomizeStrategyFactory$PanelStrategy$1$1(CustomizeStrategyFactory.PanelStrategy.1 param1) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    paramPathResult = paramPathResult.filePath;
    if (paramInt == 0) {}
    try
    {
      Bitmap localBitmap = SafeBitmapFactory.decodeFile(paramPathResult, ImageUtil.a(paramPathResult, (int)(CustomizeStrategyFactory.a * 50.0F + 0.5D)));
      if (localBitmap != null) {
        this.a.a.icon = localBitmap;
      }
      this.a.a.resPath = paramPathResult;
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "PanelStrategy info.icon=" + this.a.a.icon + ",resPath=" + this.a.a.resPath);
      }
    }
    catch (Throwable paramPathResult)
    {
      for (;;)
      {
        paramPathResult.printStackTrace();
      }
    }
    CustomizeStrategyFactory.a().a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.PanelStrategy.1.1
 * JD-Core Version:    0.7.0.1
 */