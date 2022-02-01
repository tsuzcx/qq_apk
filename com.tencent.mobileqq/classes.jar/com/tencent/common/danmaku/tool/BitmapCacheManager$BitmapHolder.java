package com.tencent.common.danmaku.tool;

import android.graphics.Bitmap;
import com.tencent.common.danmaku.DanmakuDependImp;
import com.tencent.common.danmaku.IDanmakuDepend;

class BitmapCacheManager$BitmapHolder
{
  private Bitmap a;
  private int b;
  private int c;
  private int d;
  private int e;
  
  private void a()
  {
    this.a = null;
    this.b = 0;
    this.c = 0;
    this.d = 0;
    this.e = 0;
  }
  
  private void a(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
    this.b = paramBitmap.getWidth();
    this.c = paramBitmap.getHeight();
    this.d = (paramBitmap.getHeight() * paramBitmap.getWidth());
    this.e = (paramBitmap.getRowBytes() * paramBitmap.getHeight());
  }
  
  private Bitmap b()
  {
    Bitmap localBitmap = this.a;
    a();
    return localBitmap;
  }
  
  private void c()
  {
    Bitmap localBitmap = this.a;
    if ((localBitmap != null) && (!localBitmap.isRecycled()) && (!DanmakuDependImp.a().b().e())) {
      this.a.recycle();
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.tool.BitmapCacheManager.BitmapHolder
 * JD-Core Version:    0.7.0.1
 */