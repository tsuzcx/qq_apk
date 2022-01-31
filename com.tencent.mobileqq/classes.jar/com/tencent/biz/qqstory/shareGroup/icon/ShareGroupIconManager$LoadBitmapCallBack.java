package com.tencent.biz.qqstory.shareGroup.icon;

import android.support.annotation.NonNull;
import nrl;
import nrn;

public abstract class ShareGroupIconManager$LoadBitmapCallBack
  implements nrn
{
  public void a(RestrictedBitmap paramRestrictedBitmap) {}
  
  public void a(Error paramError) {}
  
  public final void a(@NonNull nrl paramnrl)
  {
    a(new RestrictedBitmap(paramnrl.a()));
  }
  
  public final void b(@NonNull nrl paramnrl)
  {
    a(paramnrl.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager.LoadBitmapCallBack
 * JD-Core Version:    0.7.0.1
 */