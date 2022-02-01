package com.tencent.biz.qqstory.shareGroup.icon;

import android.support.annotation.NonNull;

public abstract class ShareGroupIconManager$LoadBitmapCallBack
  implements ShareGroupDrawableState.CallBack
{
  protected void a(RestrictedBitmap paramRestrictedBitmap) {}
  
  public final void a(@NonNull ShareGroupDrawableState paramShareGroupDrawableState)
  {
    a(new RestrictedBitmap(paramShareGroupDrawableState.a()));
  }
  
  protected void a(Error paramError) {}
  
  public final void b(@NonNull ShareGroupDrawableState paramShareGroupDrawableState)
  {
    a(paramShareGroupDrawableState.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager.LoadBitmapCallBack
 * JD-Core Version:    0.7.0.1
 */