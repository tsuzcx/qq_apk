package com.tencent.biz.qqstory.shareGroup.icon;

import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;

class ShareGroupDrawableState$CallBackWeakWrapper
  implements ShareGroupDrawableState.CallBack
{
  private final int jdField_a_of_type_Int;
  @NonNull
  private final WeakReference<ShareGroupDrawableState.CallBack> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ShareGroupDrawableState$CallBackWeakWrapper(@NonNull ShareGroupDrawableState.CallBack paramCallBack)
  {
    this.jdField_a_of_type_Int = System.identityHashCode(paramCallBack);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCallBack);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaLangRefWeakReference.get() != null;
  }
  
  public void a(@NonNull ShareGroupDrawableState paramShareGroupDrawableState)
  {
    ShareGroupDrawableState.CallBack localCallBack = (ShareGroupDrawableState.CallBack)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localCallBack != null) {
      localCallBack.a(paramShareGroupDrawableState);
    }
  }
  
  public void b(@NonNull ShareGroupDrawableState paramShareGroupDrawableState)
  {
    ShareGroupDrawableState.CallBack localCallBack = (ShareGroupDrawableState.CallBack)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localCallBack != null) {
      localCallBack.b(paramShareGroupDrawableState);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof CallBackWeakWrapper)) && (((CallBackWeakWrapper)paramObject).jdField_a_of_type_Int == this.jdField_a_of_type_Int);
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.ShareGroupDrawableState.CallBackWeakWrapper
 * JD-Core Version:    0.7.0.1
 */