package com.google.android.material.textfield;

import android.os.Build.VERSION;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R.id;

public class TextInputLayout$AccessibilityDelegate
  extends AccessibilityDelegateCompat
{
  private final TextInputLayout a;
  
  public TextInputLayout$AccessibilityDelegate(@NonNull TextInputLayout paramTextInputLayout)
  {
    this.a = paramTextInputLayout;
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull View paramView, @NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    EditText localEditText = this.a.a();
    Editable localEditable;
    if (localEditText != null) {
      localEditable = localEditText.getText();
    } else {
      localEditable = null;
    }
    paramView = this.a.a();
    CharSequence localCharSequence1 = this.a.e();
    Object localObject = this.a.b();
    int j = this.a.c();
    CharSequence localCharSequence2 = this.a.d();
    boolean bool2 = TextUtils.isEmpty(localEditable) ^ true;
    boolean bool4 = TextUtils.isEmpty(paramView);
    boolean bool5 = this.a.e();
    boolean bool1 = TextUtils.isEmpty(localCharSequence1) ^ true;
    boolean bool3 = false;
    int i;
    if ((!bool1) && (TextUtils.isEmpty(localCharSequence2))) {
      i = 0;
    } else {
      i = 1;
    }
    if ((bool4 ^ true)) {
      paramView = paramView.toString();
    } else {
      paramView = "";
    }
    if (bool2)
    {
      paramAccessibilityNodeInfoCompat.setText(localEditable);
    }
    else if (!TextUtils.isEmpty(paramView))
    {
      paramAccessibilityNodeInfoCompat.setText(paramView);
      if (((bool5 ^ true)) && (localObject != null))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramView);
        localStringBuilder.append(", ");
        localStringBuilder.append(localObject);
        paramAccessibilityNodeInfoCompat.setText(localStringBuilder.toString());
      }
    }
    else if (localObject != null)
    {
      paramAccessibilityNodeInfoCompat.setText((CharSequence)localObject);
    }
    if (!TextUtils.isEmpty(paramView))
    {
      if (Build.VERSION.SDK_INT >= 26)
      {
        paramAccessibilityNodeInfoCompat.setHintText(paramView);
      }
      else
      {
        localObject = paramView;
        if (bool2)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localEditable);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(paramView);
          localObject = ((StringBuilder)localObject).toString();
        }
        paramAccessibilityNodeInfoCompat.setText((CharSequence)localObject);
      }
      if (!bool2) {
        bool3 = true;
      }
      paramAccessibilityNodeInfoCompat.setShowingHintText(bool3);
    }
    if ((localEditable == null) || (localEditable.length() != j)) {
      j = -1;
    }
    paramAccessibilityNodeInfoCompat.setMaxTextLength(j);
    if (i != 0)
    {
      if (bool1) {
        paramView = localCharSequence1;
      } else {
        paramView = localCharSequence2;
      }
      paramAccessibilityNodeInfoCompat.setError(paramView);
    }
    if ((Build.VERSION.SDK_INT >= 17) && (localEditText != null)) {
      localEditText.setLabelFor(R.id.ah);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate
 * JD-Core Version:    0.7.0.1
 */