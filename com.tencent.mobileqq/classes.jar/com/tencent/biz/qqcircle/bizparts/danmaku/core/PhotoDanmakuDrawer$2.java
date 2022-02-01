package com.tencent.biz.qqcircle.bizparts.danmaku.core;

import android.graphics.Paint;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.AbsDanmaku;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;

class PhotoDanmakuDrawer$2
  extends QCirclePicStateListener
{
  PhotoDanmakuDrawer$2(PhotoDanmakuDrawer paramPhotoDanmakuDrawer, AbsDanmaku paramAbsDanmaku, float paramFloat1, float paramFloat2, Paint paramPaint) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    super.onStateChang(paramInt, paramOption);
    if (paramInt == 6)
    {
      paramOption = paramOption.getResultBitMap();
      if (paramOption != null)
      {
        PhotoDanmakuDrawer.a(this.e, this.a, this.b, this.c, paramOption);
        return;
      }
      PhotoDanmakuDrawer.a(this.e, this.a, this.d, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuDrawer.2
 * JD-Core Version:    0.7.0.1
 */