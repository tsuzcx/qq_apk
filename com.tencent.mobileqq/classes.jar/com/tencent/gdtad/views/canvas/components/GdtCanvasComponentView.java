package com.tencent.gdtad.views.canvas.components;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.gdtad.views.canvas.GdtCanvasData;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasPageView;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasView;
import java.lang.ref.WeakReference;
import yny;
import yon;
import ypm;
import ypn;
import yqo;

public abstract class GdtCanvasComponentView
  extends FrameLayout
  implements ypn
{
  public WeakReference<yqo> a;
  protected yon a;
  protected ypm a;
  
  public GdtCanvasComponentView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Yon = new yon();
  }
  
  public GdtCanvasComponentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Yon = new yon();
  }
  
  public GdtCanvasComponentView(Context paramContext, WeakReference<yqo> paramWeakReference)
  {
    super(paramContext);
    this.jdField_a_of_type_Yon = new yon();
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_Yon == null)) {
      yny.d("GdtCanvasComponentView", "notifyLoaded error");
    }
    long l;
    do
    {
      return;
      l = this.jdField_a_of_type_Yon.a();
    } while (l < 0L);
    ((yqo)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(a(), l, paramBoolean);
  }
  
  public GdtCanvasData a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      return ((yqo)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
    }
    return null;
  }
  
  public abstract GdtCanvasComponentData a();
  
  public abstract ypm a();
  
  public void a()
  {
    if (a() == null) {
      return;
    }
    yny.b("GdtCanvasComponentView", a().id + ": onViewResume");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Yon != null) {
      this.jdField_a_of_type_Yon.b();
    }
    b(paramBoolean);
    this.jdField_a_of_type_Yon = null;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    if (a() == null) {
      return;
    }
    yny.b("GdtCanvasComponentView", a().id + ": onViewPause");
  }
  
  public void c()
  {
    if (a() != null) {
      a().d();
    }
  }
  
  public void d()
  {
    if (a() != null) {
      a().a();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (((yqo)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a() == null) || (!(this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof GdtCanvasView))) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 0)
    {
      String str = ((GdtCanvasView)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a;
      if ((a() != null) && (!TextUtils.isEmpty(a().id)) && (!a().id.equals(str)) && (getContext() != null)) {
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
      }
      ((yqo)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().setFormFocusd(str, false);
      if (a().id.contains("XJWebForm")) {
        ((yqo)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().setFormFocusd(a().id, true);
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e()
  {
    if (a() != null) {
      a().c();
    }
  }
  
  public void f()
  {
    if (a() != null) {
      a().b();
    }
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_Yon != null) {
      this.jdField_a_of_type_Yon.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.GdtCanvasComponentView
 * JD-Core Version:    0.7.0.1
 */