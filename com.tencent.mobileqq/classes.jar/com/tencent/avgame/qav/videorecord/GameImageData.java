package com.tencent.avgame.qav.videorecord;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class GameImageData
{
  public Bitmap a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public String g = "";
  public String h = "";
  public boolean i;
  
  public static GameImageData a(View paramView)
  {
    int j = paramView.getVisibility();
    Object localObject1 = null;
    Object localObject2 = null;
    if (j == 0)
    {
      paramView.setDrawingCacheEnabled(true);
      Bitmap localBitmap = paramView.getDrawingCache();
      if (localBitmap == null)
      {
        QLog.e("GameImageData", 1, "mTipsWrapper, get drawingCache return null");
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = new GameImageData();
        ((GameImageData)localObject1).a = localBitmap.copy(Bitmap.Config.ARGB_8888, false);
        ((GameImageData)localObject1).d = paramView.getLeft();
        ((GameImageData)localObject1).e = paramView.getTop();
      }
      paramView.setDrawingCacheEnabled(false);
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.videorecord.GameImageData
 * JD-Core Version:    0.7.0.1
 */