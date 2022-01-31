package com.tencent.component.media.image.drawable;

import com.tencent.component.media.image.image.BitmapImage;
import com.tencent.component.media.image.image.Image.MetaInfo;

public class BitmapImageDrawable
  extends ImageDrawable
{
  private final BitmapImage a;
  
  public BitmapImageDrawable(BitmapImage paramBitmapImage)
  {
    this(paramBitmapImage, -1, -1);
  }
  
  public BitmapImageDrawable(BitmapImage paramBitmapImage, int paramInt1, int paramInt2)
  {
    super(paramBitmapImage.getBitmap(), paramInt1, paramInt2);
    this.a = paramBitmapImage;
    a();
  }
  
  private void a()
  {
    setOriginalWidth(this.a.getMetaInfo().width);
    setOriginalHeight(this.a.getMetaInfo().height);
  }
  
  public int size()
  {
    if (this.a != null) {
      return this.a.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.BitmapImageDrawable
 * JD-Core Version:    0.7.0.1
 */