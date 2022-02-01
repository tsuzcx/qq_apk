package com.tencent.component.media.image.image;

import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.utils.AssertUtils;

public class BitmapImage
  extends Image
{
  private final BitmapReference mBitmap;
  private final Image.MetaInfo mMetaInfo = new Image.MetaInfo();
  
  public BitmapImage(BitmapReference paramBitmapReference)
  {
    boolean bool;
    if (paramBitmapReference != null) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    this.mBitmap = paramBitmapReference;
    initMetaInfo();
  }
  
  private void initMetaInfo()
  {
    this.mMetaInfo.width = this.mBitmap.getWidth();
    this.mMetaInfo.height = this.mBitmap.getHeight();
  }
  
  public BitmapReference getBitmap()
  {
    return this.mBitmap;
  }
  
  public Image.MetaInfo getMetaInfo()
  {
    return this.mMetaInfo;
  }
  
  public boolean isRecycled()
  {
    return this.mBitmap.isRecycled();
  }
  
  public void recycle()
  {
    if (!this.mBitmap.isRecycled()) {
      this.mBitmap.release();
    }
  }
  
  public int size()
  {
    if (this.mBitmap.isRecycled()) {
      return 0;
    }
    return this.mBitmap.getAllocSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.image.BitmapImage
 * JD-Core Version:    0.7.0.1
 */