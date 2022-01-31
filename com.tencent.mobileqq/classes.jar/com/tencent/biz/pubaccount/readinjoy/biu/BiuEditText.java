package com.tencent.biz.pubaccount.readinjoy.biu;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;
import rqz;
import rra;

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
    addTextChangedListener(new rra());
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
      rqz[] arrayOfrqz = (rqz[])localEditable.getSpans(paramInt1, paramInt2, rqz.class);
      if ((arrayOfrqz != null) && (arrayOfrqz.length > 0))
      {
        int i = arrayOfrqz.length;
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          rqz localrqz = arrayOfrqz[paramInt2];
          int j = localEditable.getSpanStart(localrqz);
          int k = localEditable.getSpanEnd(localrqz);
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