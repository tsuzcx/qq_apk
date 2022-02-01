package com.tencent.biz.pubaccount.readinjoy.biu;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import owd;
import tnq;
import tnr;

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
  
  private int a(int paramInt)
  {
    ForegroundColorSpan[] arrayOfForegroundColorSpan = (ForegroundColorSpan[])getEditableText().getSpans(0, getText().length(), ForegroundColorSpan.class);
    if (QLog.isColorLevel()) {
      QLog.d("BiuEditText", 2, "getValidSelPosForRichText spans num : " + arrayOfForegroundColorSpan.length);
    }
    int k = arrayOfForegroundColorSpan.length;
    int i = 0;
    for (;;)
    {
      int j = paramInt;
      if (i < k)
      {
        ForegroundColorSpan localForegroundColorSpan = arrayOfForegroundColorSpan[i];
        int m = getText().getSpanStart(localForegroundColorSpan);
        j = getText().getSpanEnd(localForegroundColorSpan);
        if ((m + 1 > paramInt) || (j < paramInt)) {}
      }
      else
      {
        return j;
      }
      i += 1;
    }
  }
  
  private String a(int paramInt1, int paramInt2, ForegroundColorSpan[] paramArrayOfForegroundColorSpan)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("BiuEditText", 2, "getValidSelPosForRichText startCalPos :" + paramInt1 + " endCalPos :" + paramInt2);
    }
    ForegroundColorSpan[] arrayOfForegroundColorSpan = a(paramArrayOfForegroundColorSpan);
    Editable localEditable = getEditableText();
    paramArrayOfForegroundColorSpan = "" + localEditable.subSequence(paramInt1, localEditable.getSpanStart(arrayOfForegroundColorSpan[0]));
    while (i < arrayOfForegroundColorSpan.length)
    {
      localObject = paramArrayOfForegroundColorSpan + localEditable.subSequence(localEditable.getSpanStart(arrayOfForegroundColorSpan[i]), localEditable.getSpanEnd(arrayOfForegroundColorSpan[i]));
      paramInt1 = localEditable.getSpanEnd(arrayOfForegroundColorSpan[i]);
      paramArrayOfForegroundColorSpan = (ForegroundColorSpan[])localObject;
      if (i < arrayOfForegroundColorSpan.length - 1)
      {
        paramArrayOfForegroundColorSpan = (String)localObject + localEditable.subSequence(localEditable.getSpanEnd(arrayOfForegroundColorSpan[i]), localEditable.getSpanStart(arrayOfForegroundColorSpan[(i + 1)]));
        paramInt1 = localEditable.getSpanStart(arrayOfForegroundColorSpan[(i + 1)]);
      }
      i += 1;
    }
    Object localObject = paramArrayOfForegroundColorSpan;
    if (paramInt1 < paramInt2) {
      localObject = paramArrayOfForegroundColorSpan + localEditable.subSequence(paramInt1, paramInt2);
    }
    return localObject;
  }
  
  private boolean a()
  {
    if (getSelectionStart() == getSelectionEnd()) {
      return false;
    }
    ForegroundColorSpan[] arrayOfForegroundColorSpan = (ForegroundColorSpan[])getEditableText().getSpans(getSelectionStart(), getSelectionEnd(), ForegroundColorSpan.class);
    if (arrayOfForegroundColorSpan.length == 0) {
      return false;
    }
    ((ClipboardManager)getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, a(getSelectionStart(), getSelectionEnd(), arrayOfForegroundColorSpan)));
    setSelection(getSelectionEnd());
    return true;
  }
  
  private ForegroundColorSpan[] a(@NotNull ForegroundColorSpan[] paramArrayOfForegroundColorSpan)
  {
    ForegroundColorSpan[] arrayOfForegroundColorSpan = new ForegroundColorSpan[paramArrayOfForegroundColorSpan.length];
    Editable localEditable = getEditableText();
    paramArrayOfForegroundColorSpan = Arrays.asList(paramArrayOfForegroundColorSpan);
    Collections.sort(paramArrayOfForegroundColorSpan, new owd(this, localEditable));
    return (ForegroundColorSpan[])paramArrayOfForegroundColorSpan.toArray(arrayOfForegroundColorSpan);
  }
  
  private void b()
  {
    this.a = new tnr();
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
    setSelection(a(paramInt1), a(paramInt2));
    if (QLog.isColorLevel()) {
      QLog.d("BiuEditText", 2, "onSelectionChanged start : " + paramInt1 + " end : " + paramInt2);
    }
    if (paramInt2 != paramInt1) {}
    for (;;)
    {
      return;
      Editable localEditable = getEditableText();
      tnq[] arrayOftnq = (tnq[])localEditable.getSpans(paramInt1, paramInt2, tnq.class);
      if ((arrayOftnq != null) && (arrayOftnq.length > 0))
      {
        int i = arrayOftnq.length;
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          tnq localtnq = arrayOftnq[paramInt2];
          int j = localEditable.getSpanStart(localtnq);
          int k = localEditable.getSpanEnd(localtnq);
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
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    if ((paramInt == 16908321) && (a())) {
      return true;
    }
    return super.onTextContextMenuItem(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.BiuEditText
 * JD-Core Version:    0.7.0.1
 */