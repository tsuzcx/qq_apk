package com.tencent.biz.pubaccount;

import com.tencent.image.NativeGifImage;
import java.io.File;

public class LooperGifImage
  extends NativeGifImage
{
  private LooperGifImage.OnPlayFinish a;
  private int b = 3;
  
  public LooperGifImage(File paramFile, boolean paramBoolean, int paramInt)
  {
    super(paramFile, paramBoolean, false, 0, 0, 0.0F);
    this.b = paramInt;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(LooperGifImage.OnPlayFinish paramOnPlayFinish)
  {
    this.a = paramOnPlayFinish;
  }
  
  protected void executeNewTask()
  {
    if (this.mCurrentLoop == this.b)
    {
      LooperGifImage.OnPlayFinish localOnPlayFinish = this.a;
      if (localOnPlayFinish != null) {
        localOnPlayFinish.a();
      }
      return;
    }
    super.executeNewTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.LooperGifImage
 * JD-Core Version:    0.7.0.1
 */