package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialAutoCompleteTextView
  extends AppCompatAutoCompleteTextView
{
  @NonNull
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  @Nullable
  private final AccessibilityManager jdField_a_of_type_AndroidViewAccessibilityAccessibilityManager;
  @NonNull
  private final ListPopupWindow jdField_a_of_type_AndroidxAppcompatWidgetListPopupWindow;
  
  public MaterialAutoCompleteTextView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialAutoCompleteTextView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.autoCompleteTextViewStyle);
  }
  
  public MaterialAutoCompleteTextView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, 0), paramAttributeSet, paramInt);
    paramContext = getContext();
    paramAttributeSet = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.O, paramInt, R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
    if ((paramAttributeSet.hasValue(R.styleable.cg)) && (paramAttributeSet.getInt(R.styleable.cg, 0) == 0)) {
      setKeyListener(null);
    }
    this.jdField_a_of_type_AndroidViewAccessibilityAccessibilityManager = ((AccessibilityManager)paramContext.getSystemService("accessibility"));
    this.jdField_a_of_type_AndroidxAppcompatWidgetListPopupWindow = new ListPopupWindow(paramContext);
    this.jdField_a_of_type_AndroidxAppcompatWidgetListPopupWindow.setModal(true);
    this.jdField_a_of_type_AndroidxAppcompatWidgetListPopupWindow.setAnchorView(this);
    this.jdField_a_of_type_AndroidxAppcompatWidgetListPopupWindow.setInputMethodMode(2);
    this.jdField_a_of_type_AndroidxAppcompatWidgetListPopupWindow.setAdapter(getAdapter());
    this.jdField_a_of_type_AndroidxAppcompatWidgetListPopupWindow.setOnItemClickListener(new MaterialAutoCompleteTextView.1(this));
    paramAttributeSet.recycle();
  }
  
  private int a()
  {
    ListAdapter localListAdapter = getAdapter();
    TextInputLayout localTextInputLayout = a();
    int k = 0;
    if (localListAdapter != null)
    {
      if (localTextInputLayout == null) {
        return 0;
      }
      int i1 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
      int i2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
      int i = Math.max(0, this.jdField_a_of_type_AndroidxAppcompatWidgetListPopupWindow.getSelectedItemPosition());
      int i3 = Math.min(localListAdapter.getCount(), i + 15);
      int j = Math.max(0, i3 - 15);
      Object localObject = null;
      i = 0;
      while (j < i3)
      {
        int n = localListAdapter.getItemViewType(j);
        int m = k;
        if (n != k)
        {
          localObject = null;
          m = n;
        }
        localObject = localListAdapter.getView(j, (View)localObject, localTextInputLayout);
        if (((View)localObject).getLayoutParams() == null) {
          ((View)localObject).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        ((View)localObject).measure(i1, i2);
        i = Math.max(i, ((View)localObject).getMeasuredWidth());
        j += 1;
        k = m;
      }
      localObject = this.jdField_a_of_type_AndroidxAppcompatWidgetListPopupWindow.getBackground();
      j = i;
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(this.jdField_a_of_type_AndroidGraphicsRect);
        j = i + (this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.right);
      }
      return j + localTextInputLayout.a().getMeasuredWidth();
    }
    return 0;
  }
  
  @Nullable
  private TextInputLayout a()
  {
    for (ViewParent localViewParent = getParent(); localViewParent != null; localViewParent = localViewParent.getParent()) {
      if ((localViewParent instanceof TextInputLayout)) {
        return (TextInputLayout)localViewParent;
      }
    }
    return null;
  }
  
  private <T extends ListAdapter,  extends Filterable> void a(Object paramObject)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      setText(convertSelectionToString(paramObject), false);
      return;
    }
    ListAdapter localListAdapter = getAdapter();
    setAdapter(null);
    setText(convertSelectionToString(paramObject));
    setAdapter(localListAdapter);
  }
  
  @Nullable
  public CharSequence getHint()
  {
    TextInputLayout localTextInputLayout = a();
    if ((localTextInputLayout != null) && (localTextInputLayout.a())) {
      return localTextInputLayout.a();
    }
    return super.getHint();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    TextInputLayout localTextInputLayout = a();
    if ((localTextInputLayout != null) && (localTextInputLayout.a()) && (super.getHint() == null) && (ManufacturerUtils.a())) {
      setHint("");
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (View.MeasureSpec.getMode(paramInt1) == -2147483648) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a()), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public <T extends ListAdapter,  extends Filterable> void setAdapter(@Nullable T paramT)
  {
    super.setAdapter(paramT);
    this.jdField_a_of_type_AndroidxAppcompatWidgetListPopupWindow.setAdapter(getAdapter());
  }
  
  public void showDropDown()
  {
    AccessibilityManager localAccessibilityManager = this.jdField_a_of_type_AndroidViewAccessibilityAccessibilityManager;
    if ((localAccessibilityManager != null) && (localAccessibilityManager.isTouchExplorationEnabled()))
    {
      this.jdField_a_of_type_AndroidxAppcompatWidgetListPopupWindow.show();
      return;
    }
    super.showDropDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.MaterialAutoCompleteTextView
 * JD-Core Version:    0.7.0.1
 */