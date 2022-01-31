package com.tencent.gdtad.views.canvas.components.form;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasTextData;
import java.lang.ref.WeakReference;

public abstract class GdtCanvasFormItemView
  extends TableRow
{
  private GdtCanvasFormItemData jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormItemData;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public GdtCanvasFormItemView(Context paramContext, GdtCanvasFormItemData paramGdtCanvasFormItemData, WeakReference paramWeakReference)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    a(paramContext, paramGdtCanvasFormItemData);
  }
  
  private void a(Context paramContext)
  {
    if ((a() == null) || (!a().isValid()))
    {
      GdtLog.d("GdtCanvasFormItemView", "initViews error");
      return;
    }
    TableRow.LayoutParams localLayoutParams = new TableRow.LayoutParams(-2, -2);
    View localView = b(paramContext);
    Object localObject = localView;
    if (localView == null)
    {
      GdtLog.d("GdtCanvasFormItemView", "initViews error");
      localObject = new FrameLayout(paramContext);
    }
    addView((View)localObject, localLayoutParams);
    ((View)localObject).setPadding(a().titlePaddingLeft, a().paddingTop, a().titlePaddingRight, a().paddingBottom);
    localLayoutParams = new TableRow.LayoutParams(-1, -2);
    localView = a(paramContext);
    localObject = localView;
    if (localView == null)
    {
      GdtLog.d("GdtCanvasFormItemView", "initViews error");
      localObject = new FrameLayout(paramContext);
    }
    addView((View)localObject, localLayoutParams);
    ((View)localObject).setPadding(a().contentPaddingLeft, a().paddingTop, a().contentPaddingRight, a().paddingBottom);
  }
  
  private void a(Context paramContext, GdtCanvasFormItemData paramGdtCanvasFormItemData)
  {
    if ((paramGdtCanvasFormItemData == null) || (!paramGdtCanvasFormItemData.isValid()))
    {
      GdtLog.d("GdtCanvasFormItemView", "init error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormItemData = paramGdtCanvasFormItemData;
    a(paramContext);
  }
  
  private View b(Context paramContext)
  {
    if ((a() == null) || (!a().isValid()))
    {
      GdtLog.d("GdtCanvasFormItemView", "createTitleView error");
      return null;
    }
    if (a().required) {}
    for (String str = a().title.text;; str = a().title.text + "(选填)")
    {
      paramContext = new TextView(paramContext);
      paramContext.setGravity(16);
      paramContext.setText(str);
      paramContext.setTextColor(a().title.color);
      paramContext.setTextSize(0, a().title.size);
      return paramContext;
    }
  }
  
  public int a()
  {
    if (!(getParent() instanceof TableLayout))
    {
      GdtLog.d("GdtCanvasFormItemView", "getIndex error");
      return -1;
    }
    return ((TableLayout)TableLayout.class.cast(getParent())).indexOfChild(this);
  }
  
  public abstract View a(Context paramContext);
  
  public GdtCanvasFormItemData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormItemData;
  }
  
  public abstract void a();
  
  public void a(GdtCanvasFormError paramGdtCanvasFormError)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((GdtCanvasFormListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramGdtCanvasFormError);
    }
  }
  
  public boolean a()
  {
    if ((a() == null) || (!a().isValid())) {
      GdtLog.d("GdtCanvasFormItemView", "validate error");
    }
    GdtCanvasFormError localGdtCanvasFormError;
    do
    {
      return false;
      localGdtCanvasFormError = a().validate();
      localGdtCanvasFormError.b = a();
      if (localGdtCanvasFormError == null)
      {
        GdtLog.d("GdtCanvasFormItemView", "validate error");
        return false;
      }
      if (localGdtCanvasFormError.a == 2) {
        return true;
      }
    } while (localGdtCanvasFormError.a == 5);
    a(localGdtCanvasFormError);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormItemView
 * JD-Core Version:    0.7.0.1
 */