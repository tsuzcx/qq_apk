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
import yxp;
import yyd;
import yzd;
import yze;
import zad;

public abstract class GdtCanvasComponentView
  extends FrameLayout
  implements yze
{
  public WeakReference<zad> a;
  protected yyd a;
  protected yzd a;
  
  public GdtCanvasComponentView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Yyd = new yyd();
  }
  
  public GdtCanvasComponentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Yyd = new yyd();
  }
  
  public GdtCanvasComponentView(Context paramContext, WeakReference<zad> paramWeakReference)
  {
    super(paramContext);
    this.jdField_a_of_type_Yyd = new yyd();
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_Yyd == null)) {
      yxp.d("GdtCanvasComponentView", "notifyLoaded error");
    }
    long l;
    do
    {
      return;
      l = this.jdField_a_of_type_Yyd.a();
    } while (l < 0L);
    ((zad)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(a(), l, paramBoolean);
  }
  
  public GdtCanvasData a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      return ((zad)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
    }
    return null;
  }
  
  public abstract GdtCanvasComponentData a();
  
  public abstract yzd a();
  
  public void a()
  {
    if (a() == null) {
      return;
    }
    yxp.b("GdtCanvasComponentView", a().id + ": onViewResume");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Yyd != null) {
      this.jdField_a_of_type_Yyd.b();
    }
    b(paramBoolean);
    this.jdField_a_of_type_Yyd = null;
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
    yxp.b("GdtCanvasComponentView", a().id + ": onViewPause");
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
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (((zad)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a() == null) || (!(this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof GdtCanvasView))) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 0)
    {
      String str = ((GdtCanvasView)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a;
      if ((a() != null) && (!TextUtils.isEmpty(a().id)) && (!a().id.equals(str)) && (getContext() != null)) {
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
      }
      ((zad)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().setFormFocusd(str, false);
      if (a().id.contains("XJWebForm")) {
        ((zad)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().setFormFocusd(a().id, true);
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
    if (this.jdField_a_of_type_Yyd != null) {
      this.jdField_a_of_type_Yyd.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.GdtCanvasComponentView
 * JD-Core Version:    0.7.0.1
 */