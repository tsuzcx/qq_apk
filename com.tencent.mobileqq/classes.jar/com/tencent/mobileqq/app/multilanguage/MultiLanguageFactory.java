package com.tencent.mobileqq.app.multilanguage;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.widget.AlphaClickableButton;
import com.tencent.widget.AlphaClickableTextView;

@KeepClassConstructor
public class MultiLanguageFactory
  implements LayoutInflater.Factory2
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16843087, 16843088, 16844078, 2131034729, 2131035099, 2131035265, 2131035267 };
  private Activity jdField_a_of_type_AndroidAppActivity;
  
  public MultiLanguageFactory(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private View a(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramString.equals("TextView")) {
      return new TextView(paramContext, paramAttributeSet);
    }
    if (paramString.equals("Button")) {
      return new Button(paramContext, paramAttributeSet);
    }
    if (paramString.endsWith("DragTextView")) {
      return new DragTextView(paramContext, paramAttributeSet);
    }
    if (paramString.equals("com.tencent.mobileqq.widget.FormSwitchItem")) {
      return new FormSwitchItem(paramContext, paramAttributeSet);
    }
    if (paramString.equals("com.tencent.mobileqq.widget.FormSimpleItem")) {
      return new FormSimpleItem(paramContext, paramAttributeSet);
    }
    if (paramString.equals("com.tencent.mobileqq.widget.FormSwitchSimpleItem")) {
      return new FormSwitchSimpleItem(paramContext, paramAttributeSet);
    }
    if (paramString.equals("com.tencent.mobileqq.widget.FormMultiLineSwitchItem")) {
      return new FormMultiLineSwitchItem(paramContext, paramAttributeSet);
    }
    if (paramString.equals("com.tencent.widget.AlphaClickableTextView")) {
      return new AlphaClickableTextView(paramContext, paramAttributeSet);
    }
    if (paramString.equals("com.tencent.widget.AlphaClickableButton")) {
      return new AlphaClickableButton(paramContext, paramAttributeSet);
    }
    return null;
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    paramView = a(paramString, paramContext, paramAttributeSet);
    if (paramView != null)
    {
      paramString = paramContext.obtainStyledAttributes(paramAttributeSet, jdField_a_of_type_ArrayOfInt);
      int i = 0;
      while (i < jdField_a_of_type_ArrayOfInt.length)
      {
        int j = paramString.getResourceId(i, 0);
        if (j != 0)
        {
          paramAttributeSet = paramContext.getString(j);
          switch (jdField_a_of_type_ArrayOfInt[i])
          {
          default: 
            break;
          case 2131035267: 
            if ((paramView instanceof FormSwitchItem)) {
              ((FormSwitchItem)paramView).setText(paramAttributeSet);
            }
            break;
          case 2131035265: 
            if ((paramView instanceof FormMultiLineSwitchItem)) {
              ((FormMultiLineSwitchItem)paramView).setSecendLineText(paramAttributeSet);
            }
            break;
          case 2131035099: 
            if ((paramView instanceof FormSimpleItem)) {
              ((FormSimpleItem)paramView).setRightText(paramAttributeSet);
            }
            break;
          case 2131034729: 
            if ((paramView instanceof FormSimpleItem)) {
              ((FormSimpleItem)paramView).setLeftText(paramAttributeSet);
            }
            break;
          case 16844078: 
            if ((paramView instanceof TextView)) {
              ((TextView)paramView).setContentDescription(paramAttributeSet);
            } else if ((paramView instanceof Button)) {
              ((Button)paramView).setContentDescription(paramAttributeSet);
            }
            break;
          case 16843088: 
            if ((paramView instanceof TextView)) {
              ((TextView)paramView).setHint(paramAttributeSet);
            } else if ((paramView instanceof Button)) {
              ((Button)paramView).setHint(paramAttributeSet);
            }
            break;
          case 16843087: 
            if ((paramView instanceof TextView)) {
              ((TextView)paramView).setText(paramAttributeSet);
            } else if ((paramView instanceof Button)) {
              ((Button)paramView).setText(paramAttributeSet);
            } else if ((paramView instanceof FormSwitchItem)) {
              ((FormSwitchItem)paramView).setText(paramAttributeSet);
            }
            break;
          }
        }
        i += 1;
      }
      paramString.recycle();
    }
    return paramView;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.multilanguage.MultiLanguageFactory
 * JD-Core Version:    0.7.0.1
 */