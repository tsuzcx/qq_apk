package com.tencent.biz.qqstory.shareGroup.icon;

import android.support.annotation.NonNull;
import nwb;
import nwd;

public abstract class ShareGroupIconManager$LoadBitmapCallBack
  implements nwd
{
  public void a(RestrictedBitmap paramRestrictedBitmap) {}
  
  public void a(Error paramError) {}
  
  public final void a(@NonNull nwb paramnwb)
  {
    a(new RestrictedBitmap(paramnwb.a()));
  }
  
  public final void b(@NonNull nwb paramnwb)
  {
    a(paramnwb.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager.LoadBitmapCallBack
 * JD-Core Version:    0.7.0.1
 */