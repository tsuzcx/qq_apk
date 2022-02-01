package com.tencent.biz.qqstory.shareGroup.icon;

import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;

class ShareGroupDrawableState$CallBackWeakWrapper
  implements ShareGroupDrawableState.CallBack
{
  private final int a;
  @NonNull
  private final WeakReference<ShareGroupDrawableState.CallBack> b;
  
  public ShareGroupDrawableState$CallBackWeakWrapper(@NonNull ShareGroupDrawableState.CallBack paramCallBack)
  {
    this.a = System.identityHashCode(paramCallBack);
    this.b = new WeakReference(paramCallBack);
  }
  
  private boolean a()
  {
    return this.b.get() != null;
  }
  
  public void a(@NonNull ShareGroupDrawableState paramShareGroupDrawableState)
  {
    ShareGroupDrawableState.CallBack localCallBack = (ShareGroupDrawableState.CallBack)this.b.get();
    if (localCallBack != null) {
      localCallBack.a(paramShareGroupDrawableState);
    }
  }
  
  public void b(@NonNull ShareGroupDrawableState paramShareGroupDrawableState)
  {
    ShareGroupDrawableState.CallBack localCallBack = (ShareGroupDrawableState.CallBack)this.b.get();
    if (localCallBack != null) {
      localCallBack.b(paramShareGroupDrawableState);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof CallBackWeakWrapper)) && (((CallBackWeakWrapper)paramObject).a == this.a);
  }
  
  public int hashCode()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.ShareGroupDrawableState.CallBackWeakWrapper
 * JD-Core Version:    0.7.0.1
 */