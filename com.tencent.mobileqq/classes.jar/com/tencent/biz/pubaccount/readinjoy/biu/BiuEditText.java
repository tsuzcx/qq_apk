package com.tencent.biz.pubaccount.readinjoy.biu;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import tai;
import taj;

public class BiuEditText
  extends EditText
{
  private TextWatcher a;
  
  public BiuEditText(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public BiuEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void b()
  {
    this.a = new taj();
    addTextChangedListener(this.a);
  }
  
  public void a()
  {
    if (this.a != null) {
      removeTextChangedListener(this.a);
    }
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
      tai[] arrayOftai = (tai[])localEditable.getSpans(paramInt1, paramInt2, tai.class);
      if ((arrayOftai != null) && (arrayOftai.length > 0))
      {
        int i = arrayOftai.length;
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          tai localtai = arrayOftai[paramInt2];
          int j = localEditable.getSpanStart(localtai);
          int k = localEditable.getSpanEnd(localtai);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.BiuEditText
 * JD-Core Version:    0.7.0.1
 */