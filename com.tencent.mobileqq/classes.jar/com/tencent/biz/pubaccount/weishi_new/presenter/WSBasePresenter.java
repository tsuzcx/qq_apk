package com.tencent.biz.pubaccount.weishi_new.presenter;

import android.support.annotation.UiThread;
import com.tencent.biz.pubaccount.weishi_new.IWSBaseView;
import com.tencent.biz.pubaccount.weishi_new.IWSPresenter;
import java.lang.ref.WeakReference;

public class WSBasePresenter<V extends IWSBaseView>
  implements IWSPresenter<V>
{
  private WeakReference<V> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  
  @UiThread
  public V a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (IWSBaseView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  @UiThread
  public void a(V paramV)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramV);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSBasePresenter
 * JD-Core Version:    0.7.0.1
 */