package com.tencent.gdtad.views.form.framework;

import ajyc;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import com.tencent.gdtad.views.xijing.GdtTextData;
import java.lang.ref.WeakReference;
import yxs;
import zai;
import zan;

public abstract class GdtFormItemView
  extends TableRow
{
  private GdtFormItemData jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormItemData;
  private WeakReference<zan> jdField_a_of_type_JavaLangRefWeakReference;
  
  public GdtFormItemView(Context paramContext, GdtFormItemData paramGdtFormItemData, WeakReference<zan> paramWeakReference)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    a(paramContext, paramGdtFormItemData);
  }
  
  private void a(Context paramContext)
  {
    if ((a() == null) || (!a().isValid()))
    {
      yxs.d("GdtFormItemView", "initViews error");
      return;
    }
    TableRow.LayoutParams localLayoutParams = new TableRow.LayoutParams(-2, -2);
    View localView = b(paramContext);
    Object localObject = localView;
    if (localView == null)
    {
      yxs.d("GdtFormItemView", "initViews error");
      localObject = new FrameLayout(paramContext);
    }
    addView((View)localObject, localLayoutParams);
    ((View)localObject).setPadding(a().titlePaddingLeft, a().paddingTop, a().titlePaddingRight, a().paddingBottom);
    localLayoutParams = new TableRow.LayoutParams(-1, -2);
    localView = a(paramContext);
    localObject = localView;
    if (localView == null)
    {
      yxs.d("GdtFormItemView", "initViews error");
      localObject = new FrameLayout(paramContext);
    }
    addView((View)localObject, localLayoutParams);
    ((View)localObject).setPadding(a().contentPaddingLeft, a().paddingTop, a().contentPaddingRight, a().paddingBottom);
  }
  
  private void a(Context paramContext, GdtFormItemData paramGdtFormItemData)
  {
    if ((paramGdtFormItemData == null) || (!paramGdtFormItemData.isValid()))
    {
      yxs.d("GdtFormItemView", "init error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormItemData = paramGdtFormItemData;
    a(paramContext);
  }
  
  private View b(Context paramContext)
  {
    if ((a() == null) || (!a().isValid()))
    {
      yxs.d("GdtFormItemView", "createTitleView error");
      return null;
    }
    if (a().required) {}
    for (String str = a().title.text;; str = a().title.text + ajyc.a(2131705169))
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
      yxs.d("GdtFormItemView", "getIndex error");
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
  
  public void a(zai paramzai)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((zan)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramzai);
    }
  }
  
  public boolean a()
  {
    if ((a() == null) || (!a().isValid())) {
      yxs.d("GdtFormItemView", "validate error");
    }
    zai localzai;
    do
    {
      return false;
      localzai = a().validate();
      localzai.b = a();
      if (localzai == null)
      {
        yxs.d("GdtFormItemView", "validate error");
        return false;
      }
      if (localzai.a == 2) {
        return true;
      }
    } while (localzai.a == 5);
    a(localzai);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.form.framework.GdtFormItemView
 * JD-Core Version:    0.7.0.1
 */