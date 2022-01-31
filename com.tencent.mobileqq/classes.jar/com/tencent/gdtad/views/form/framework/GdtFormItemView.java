package com.tencent.gdtad.views.form.framework;

import ajya;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import com.tencent.gdtad.views.xijing.GdtTextData;
import java.lang.ref.WeakReference;
import yxp;
import zaf;
import zak;

public abstract class GdtFormItemView
  extends TableRow
{
  private GdtFormItemData jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormItemData;
  private WeakReference<zak> jdField_a_of_type_JavaLangRefWeakReference;
  
  public GdtFormItemView(Context paramContext, GdtFormItemData paramGdtFormItemData, WeakReference<zak> paramWeakReference)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    a(paramContext, paramGdtFormItemData);
  }
  
  private void a(Context paramContext)
  {
    if ((a() == null) || (!a().isValid()))
    {
      yxp.d("GdtFormItemView", "initViews error");
      return;
    }
    TableRow.LayoutParams localLayoutParams = new TableRow.LayoutParams(-2, -2);
    View localView = b(paramContext);
    Object localObject = localView;
    if (localView == null)
    {
      yxp.d("GdtFormItemView", "initViews error");
      localObject = new FrameLayout(paramContext);
    }
    addView((View)localObject, localLayoutParams);
    ((View)localObject).setPadding(a().titlePaddingLeft, a().paddingTop, a().titlePaddingRight, a().paddingBottom);
    localLayoutParams = new TableRow.LayoutParams(-1, -2);
    localView = a(paramContext);
    localObject = localView;
    if (localView == null)
    {
      yxp.d("GdtFormItemView", "initViews error");
      localObject = new FrameLayout(paramContext);
    }
    addView((View)localObject, localLayoutParams);
    ((View)localObject).setPadding(a().contentPaddingLeft, a().paddingTop, a().contentPaddingRight, a().paddingBottom);
  }
  
  private void a(Context paramContext, GdtFormItemData paramGdtFormItemData)
  {
    if ((paramGdtFormItemData == null) || (!paramGdtFormItemData.isValid()))
    {
      yxp.d("GdtFormItemView", "init error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormItemData = paramGdtFormItemData;
    a(paramContext);
  }
  
  private View b(Context paramContext)
  {
    if ((a() == null) || (!a().isValid()))
    {
      yxp.d("GdtFormItemView", "createTitleView error");
      return null;
    }
    if (a().required) {}
    for (String str = a().title.text;; str = a().title.text + ajya.a(2131705180))
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
      yxp.d("GdtFormItemView", "getIndex error");
      return -1;
    }
    return ((TableLayout)TableLayout.class.cast(getParent())).indexOfChild(this);
  }
  
  protected abstract View a(Context paramContext);
  
  protected GdtFormItemData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormItemData;
  }
  
  protected abstract void a();
  
  public void a(zaf paramzaf)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((zak)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramzaf);
    }
  }
  
  public boolean a()
  {
    if ((a() == null) || (!a().isValid())) {
      yxp.d("GdtFormItemView", "validate error");
    }
    zaf localzaf;
    do
    {
      return false;
      localzaf = a().validate();
      localzaf.b = a();
      if (localzaf == null)
      {
        yxp.d("GdtFormItemView", "validate error");
        return false;
      }
      if (localzaf.a == 2) {
        return true;
      }
    } while (localzaf.a == 5);
    a(localzaf);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.form.framework.GdtFormItemView
 * JD-Core Version:    0.7.0.1
 */