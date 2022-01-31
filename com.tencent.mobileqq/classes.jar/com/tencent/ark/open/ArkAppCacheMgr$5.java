package com.tencent.ark.open;

import android.graphics.Bitmap;

final class ArkAppCacheMgr$5
  implements Runnable
{
  ArkAppCacheMgr$5(ArkAppCacheMgr.ApplicationIconHolder paramApplicationIconHolder) {}
  
  public void run()
  {
    if (this.val$holder.bmp != null)
    {
      this.val$holder.bmp.recycle();
      this.val$holder.bmp = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCacheMgr.5
 * JD-Core Version:    0.7.0.1
 */