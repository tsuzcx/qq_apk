package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.utils.ImageUtil;

public class ZBitmapDrawable
  extends BitmapDrawable
{
  public ZBitmapDrawable(Bitmap paramBitmap)
  {
    super(paramBitmap);
  }
  
  public ZBitmapDrawable(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    super(ImageUtil.c(paramBitmap, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZBitmapDrawable
 * JD-Core Version:    0.7.0.1
 */