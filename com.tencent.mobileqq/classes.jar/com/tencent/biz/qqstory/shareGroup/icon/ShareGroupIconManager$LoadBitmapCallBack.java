package com.tencent.biz.qqstory.shareGroup.icon;

import android.support.annotation.NonNull;
import npy;
import nqa;

public abstract class ShareGroupIconManager$LoadBitmapCallBack
  implements nqa
{
  public void a(RestrictedBitmap paramRestrictedBitmap) {}
  
  public void a(Error paramError) {}
  
  public final void a(@NonNull npy paramnpy)
  {
    a(new RestrictedBitmap(paramnpy.a()));
  }
  
  public final void b(@NonNull npy paramnpy)
  {
    a(paramnpy.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager.LoadBitmapCallBack
 * JD-Core Version:    0.7.0.1
 */