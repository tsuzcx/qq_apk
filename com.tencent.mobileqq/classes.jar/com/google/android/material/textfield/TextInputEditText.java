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
  private final Rect a = new Rect();
  private boolean b;
  
  public TextInputEditText(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TextInputEditText(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.u);
  }
  
  public TextInputEditText(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, 0), paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.hZ, paramInt, R.style.r, new int[0]);
    setTextInputLayoutFocusedRectEnabled(paramContext.getBoolean(R.styleable.ia, false));
    paramContext.recycle();
  }
  
  @NonNull
  private String a(@NonNull TextInputLayout paramTextInputLayout)
  {
    Editable localEditable = getText();
    paramTextInputLayout = paramTextInputLayout.getHint();
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
  
  @Nullable
  private CharSequence getHintFromLayout()
  {
    TextInputLayout localTextInputLayout = getTextInputLayout();
    if (localTextInputLayout != null) {
      return localTextInputLayout.getHint();
    }
    return null;
  }
  
  @Nullable
  private TextInputLayout getTextInputLayout()
  {
    for (ViewParent localViewParent = getParent(); (localViewParent instanceof View); localViewParent = localViewParent.getParent()) {
      if ((localViewParent instanceof TextInputLayout)) {
        return (TextInputLayout)localViewParent;
      }
    }
    return null;
  }
  
  public void getFocusedRect(@Nullable Rect paramRect)
  {
    super.getFocusedRect(paramRect);
    TextInputLayout localTextInputLayout = getTextInputLayout();
    if ((localTextInputLayout != null) && (this.b) && (paramRect != null))
    {
      localTextInputLayout.getFocusedRect(this.a);
      paramRect.bottom = this.a.bottom;
    }
  }
  
  public boolean getGlobalVisibleRect(@Nullable Rect paramRect, @Nullable Point paramPoint)
  {
    boolean bool = super.getGlobalVisibleRect(paramRect, paramPoint);
    TextInputLayout localTextInputLayout = getTextInputLayout();
    if ((localTextInputLayout != null) && (this.b) && (paramRect != null))
    {
      localTextInputLayout.getGlobalVisibleRect(this.a, paramPoint);
      paramRect.bottom = this.a.bottom;
    }
    return bool;
  }
  
  @Nullable
  public CharSequence getHint()
  {
    TextInputLayout localTextInputLayout = getTextInputLayout();
    if ((localTextInputLayout != null) && (localTextInputLayout.a())) {
      return localTextInputLayout.getHint();
    }
    return super.getHint();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    TextInputLayout localTextInputLayout = getTextInputLayout();
    if ((localTextInputLayout != null) && (localTextInputLayout.a()) && (super.getHint() == null) && (ManufacturerUtils.a())) {
      setHint("");
    }
  }
  
  @Nullable
  public InputConnection onCreateInputConnection(@NonNull EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    if ((localInputConnection != null) && (paramEditorInfo.hintText == null)) {
      paramEditorInfo.hintText = getHintFromLayout();
    }
    return localInputConnection;
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    TextInputLayout localTextInputLayout = getTextInputLayout();
    if ((Build.VERSION.SDK_INT < 23) && (localTextInputLayout != null)) {
      paramAccessibilityNodeInfo.setText(a(localTextInputLayout));
    }
  }
  
  public boolean requestRectangleOnScreen(@Nullable Rect paramRect)
  {
    boolean bool = super.requestRectangleOnScreen(paramRect);
    paramRect = getTextInputLayout();
    if ((paramRect != null) && (this.b))
    {
      this.a.set(0, paramRect.getHeight() - getResources().getDimensionPixelOffset(R.dimen.ab), paramRect.getWidth(), paramRect.getHeight());
      paramRect.requestRectangleOnScreen(this.a, true);
    }
    return bool;
  }
  
  public void setTextInputLayoutFocusedRectEnabled(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.TextInputEditText
 * JD-Core Version:    0.7.0.1
 */