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
  private final ListPopupWindow a;
  @Nullable
  private final AccessibilityManager b;
  @NonNull
  private final Rect c = new Rect();
  
  public MaterialAutoCompleteTextView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialAutoCompleteTextView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.c);
  }
  
  public MaterialAutoCompleteTextView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, 0), paramAttributeSet, paramInt);
    paramContext = getContext();
    paramAttributeSet = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.dB, paramInt, R.style.i, new int[0]);
    if ((paramAttributeSet.hasValue(R.styleable.dC)) && (paramAttributeSet.getInt(R.styleable.dC, 0) == 0)) {
      setKeyListener(null);
    }
    this.b = ((AccessibilityManager)paramContext.getSystemService("accessibility"));
    this.a = new ListPopupWindow(paramContext);
    this.a.setModal(true);
    this.a.setAnchorView(this);
    this.a.setInputMethodMode(2);
    this.a.setAdapter(getAdapter());
    this.a.setOnItemClickListener(new MaterialAutoCompleteTextView.1(this));
    paramAttributeSet.recycle();
  }
  
  private int a()
  {
    ListAdapter localListAdapter = getAdapter();
    TextInputLayout localTextInputLayout = b();
    int k = 0;
    if (localListAdapter != null)
    {
      if (localTextInputLayout == null) {
        return 0;
      }
      int i1 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
      int i2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
      int i = Math.max(0, this.a.getSelectedItemPosition());
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
      localObject = this.a.getBackground();
      j = i;
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(this.c);
        j = i + (this.c.left + this.c.right);
      }
      return j + localTextInputLayout.getEndIconView().getMeasuredWidth();
    }
    return 0;
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
  private TextInputLayout b()
  {
    for (ViewParent localViewParent = getParent(); localViewParent != null; localViewParent = localViewParent.getParent()) {
      if ((localViewParent instanceof TextInputLayout)) {
        return (TextInputLayout)localViewParent;
      }
    }
    return null;
  }
  
  @Nullable
  public CharSequence getHint()
  {
    TextInputLayout localTextInputLayout = b();
    if ((localTextInputLayout != null) && (localTextInputLayout.a())) {
      return localTextInputLayout.getHint();
    }
    return super.getHint();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    TextInputLayout localTextInputLayout = b();
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
    this.a.setAdapter(getAdapter());
  }
  
  public void showDropDown()
  {
    AccessibilityManager localAccessibilityManager = this.b;
    if ((localAccessibilityManager != null) && (localAccessibilityManager.isTouchExplorationEnabled()))
    {
      this.a.show();
      return;
    }
    super.showDropDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.MaterialAutoCompleteTextView
 * JD-Core Version:    0.7.0.1
 */