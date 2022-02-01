package com.tencent.biz.qqcircle.bizparts.danmaku.core;

import android.graphics.Bitmap;
import android.graphics.Paint;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleFaceBitmapListener;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.AbsDanmaku;

class PhotoDanmakuDrawer$3
  implements QCircleFaceBitmapListener
{
  PhotoDanmakuDrawer$3(PhotoDanmakuDrawer paramPhotoDanmakuDrawer, AbsDanmaku paramAbsDanmaku, float paramFloat1, float paramFloat2, Paint paramPaint) {}
  
  public void getFaceBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      PhotoDanmakuDrawer.a(this.e, this.a, this.b, this.c, paramBitmap);
      return;
    }
    PhotoDanmakuDrawer.a(this.e, this.a, this.d, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuDrawer.3
 * JD-Core Version:    0.7.0.1
 */