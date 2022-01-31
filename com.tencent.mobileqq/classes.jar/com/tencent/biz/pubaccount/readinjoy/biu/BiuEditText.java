package com.tencent.biz.pubaccount.readinjoy.biu;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;
import reo;
import rep;

public class BiuEditText
  extends EditText
{
  public BiuEditText(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public BiuEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    addTextChangedListener(new rep());
  }
  
  public boolean onPrivateIMECommand(String paramString, Bundle paramBundle)
  {
    if ("com.sogou.inputmethod.expression".equals(paramString)) {
      return true;
    }
    return super.onPrivateIMECommand(paramString, paramBundle);
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    if (paramInt2 != paramInt1) {}
    for (;;)
    {
      return;
      Editable localEditable = getEditableText();
      reo[] arrayOfreo = (reo[])localEditable.getSpans(paramInt1, paramInt2, reo.class);
      if ((arrayOfreo != null) && (arrayOfreo.length > 0))
      {
        int i = arrayOfreo.length;
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          reo localreo = arrayOfreo[paramInt2];
          int j = localEditable.getSpanStart(localreo);
          int k = localEditable.getSpanEnd(localreo);
          if ((j >= 0) && (k >= j) && (paramInt1 > j) && (paramInt1 < k))
          {
            setSelection(k);
            return;
          }
          paramInt2 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.BiuEditText
 * JD-Core Version:    0.7.0.1
 */