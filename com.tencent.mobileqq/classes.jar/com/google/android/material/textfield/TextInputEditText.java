package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class TextInputEditText
  extends AppCompatEditText
{
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_a_of_type_Boolean;
  
  public TextInputEditText(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TextInputEditText(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.editTextStyle);
  }
  
  public TextInputEditText(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, 0), paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.az, paramInt, R.style.p, new int[0]);
    setTextInputLayoutFocusedRectEnabled(paramContext.getBoolean(R.styleable.ft, false));
    paramContext.recycle();
  }
  
  @Nullable
  private TextInputLayout a()
  {
    for (ViewParent localViewParent = getParent(); (localViewParent instanceof View); localViewParent = localViewParent.getParent()) {
      if ((localViewParent instanceof TextInputLayout)) {
        return (TextInputLayout)localViewParent;
      }
    }
    return null;
  }
  
  @Nullable
  private CharSequence a()
  {
    TextInputLayout localTextInputLayout = a();
    if (localTextInputLayout != null) {
      return localTextInputLayout.a();
    }
    return null;
  }
  
  @NonNull
  private String a(@NonNull TextInputLayout paramTextInputLayout)
  {
    Editable localEditable = getText();
    paramTextInputLayout = paramTextInputLayout.a();
    boolean bool1 = TextUtils.isEmpty(localEditable);
    boolean bool2 = TextUtils.isEmpty(paramTextInputLayout);
    if (Build.VERSION.SDK_INT >= 17) {
      setLabelFor(R.id.ah);
    }
    Object localObject = "";
    if ((bool2 ^ true)) {
      paramTextInputLayout = paramTextInputLayout.toString();
    } else {
      paramTextInputLayout = "";
    }
    if ((bool1 ^ true))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localEditable);
      if (!TextUtils.isEmpty(paramTextInputLayout))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramTextInputLayout);
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      return localStringBuilder.toString();
    }
    if (!TextUtils.isEmpty(paramTextInputLayout)) {
      return paramTextInputLayout;
    }
    return "";
  }
  
  public void getFocusedRect(@Nullable Rect paramRect)
  {
    super.getFocusedRect(paramRect);
    TextInputLayout localTextInputLayout = a();
    if ((localTextInputLayout != null) && (this.jdField_a_of_type_Boolean) && (paramRect != null))
    {
      localTextInputLayout.getFocusedRect(this.jdField_a_of_type_AndroidGraphicsRect);
      paramRect.bottom = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
    }
  }
  
  public boolean getGlobalVisibleRect(@Nullable Rect paramRect, @Nullable Point paramPoint)
  {
    boolean bool = super.getGlobalVisibleRect(paramRect, paramPoint);
    TextInputLayout localTextInputLayout = a();
    if ((localTextInputLayout != null) && (this.jdField_a_of_type_Boolean) && (paramRect != null))
    {
      localTextInputLayout.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect, paramPoint);
      paramRect.bottom = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
    }
    return bool;
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
  
  @Nullable
  public InputConnection onCreateInputConnection(@NonNull EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    if ((localInputConnection != null) && (paramEditorInfo.hintText == null)) {
      paramEditorInfo.hintText = a();
    }
    return localInputConnection;
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    TextInputLayout localTextInputLayout = a();
    if ((Build.VERSION.SDK_INT < 23) && (localTextInputLayout != null)) {
      paramAccessibilityNodeInfo.setText(a(localTextInputLayout));
    }
  }
  
  public boolean requestRectangleOnScreen(@Nullable Rect paramRect)
  {
    boolean bool = super.requestRectangleOnScreen(paramRect);
    paramRect = a();
    if ((paramRect != null) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, paramRect.getHeight() - getResources().getDimensionPixelOffset(R.dimen.ab), paramRect.getWidth(), paramRect.getHeight());
      paramRect.requestRectangleOnScreen(this.jdField_a_of_type_AndroidGraphicsRect, true);
    }
    return bool;
  }
  
  public void setTextInputLayoutFocusedRectEnabled(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.TextInputEditText
 * JD-Core Version:    0.7.0.1
 */