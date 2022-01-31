package com.tencent.biz.pubaccount.readinjoy.biu;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;

public class BiuEditText
  extends EditText
{
  public BiuEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public BiuEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
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
      BiuNicknameSpan[] arrayOfBiuNicknameSpan = (BiuNicknameSpan[])localEditable.getSpans(paramInt1, paramInt2, BiuNicknameSpan.class);
      if ((arrayOfBiuNicknameSpan != null) && (arrayOfBiuNicknameSpan.length > 0))
      {
        int i = arrayOfBiuNicknameSpan.length;
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          BiuNicknameSpan localBiuNicknameSpan = arrayOfBiuNicknameSpan[paramInt2];
          int j = localEditable.getSpanStart(localBiuNicknameSpan);
          int k = localEditable.getSpanEnd(localBiuNicknameSpan);
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