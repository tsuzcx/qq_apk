package com.tencent.biz.pubaccount.readinjoy.viola.adapter.ui;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.viola.ui.component.image.ImageAction;
import java.lang.ref.WeakReference;
import java.util.Set;

class ComponentAdapter$ViolaImageListener
  implements URLDrawable.URLDrawableListener
{
  private WeakReference<ImageAction> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public ComponentAdapter$ViolaImageListener(ComponentAdapter paramComponentAdapter, boolean paramBoolean, ImageAction paramImageAction)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramImageAction);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    ImageAction localImageAction;
    do
    {
      return;
      localImageAction = (ImageAction)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localImageAction == null);
    localImageAction.onCancel();
    ComponentAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterUiComponentAdapter).remove(paramURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ComponentAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterUiComponentAdapter, (ImageAction)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramURLDrawable, paramThrowable);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ComponentAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterUiComponentAdapter, (ImageAction)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramURLDrawable, this.jdField_a_of_type_Boolean);
    }
    ComponentAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaAdapterUiComponentAdapter).remove(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.adapter.ui.ComponentAdapter.ViolaImageListener
 * JD-Core Version:    0.7.0.1
 */