package com.tencent.avgame.qav.videorecord;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class GameImageData
{
  public int a;
  public Bitmap a;
  public String a;
  public boolean a;
  public int b;
  public String b = "";
  public int c;
  public int d;
  public int e;
  
  public GameImageData()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static GameImageData a(View paramView)
  {
    int i = paramView.getVisibility();
    Object localObject1 = null;
    Object localObject2 = null;
    if (i == 0)
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
        ((GameImageData)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = localBitmap.copy(Bitmap.Config.ARGB_8888, false);
        ((GameImageData)localObject1).c = paramView.getLeft();
        ((GameImageData)localObject1).d = paramView.getTop();
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