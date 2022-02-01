package com.tencent.luggage.wxa.pp;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.RelativeSizeSpan;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.lang.reflect.Method;

 enum ak$a
{
  static int a(EditText paramEditText, float paramFloat1, float paramFloat2)
  {
    if (paramEditText == null) {
      return -1;
    }
    int j = paramEditText.getPaddingTop();
    Layout localLayout = paramEditText.getLayout();
    if (localLayout == null) {
      return -1;
    }
    Editable localEditable = paramEditText.getEditableText();
    if (localEditable == null) {
      return -1;
    }
    paramEditText = paramEditText.getPaint();
    if (paramEditText == null) {
      return -1;
    }
    Rect localRect = new Rect();
    int i = 0;
    while (i < localLayout.getLineCount())
    {
      localLayout.getLineBounds(i, localRect);
      int m = j + localRect.height();
      if (m >= paramFloat2)
      {
        int n = localLayout.getLineStart(i);
        int k = localLayout.getLineEnd(i);
        j = k;
        if (i != localLayout.getLineCount() - 1) {
          j = Math.max(k - 1, n);
        }
        if (n == j) {
          return n;
        }
        Object localObject = (RelativeSizeSpan[])localEditable.getSpans(n, j, RelativeSizeSpan.class);
        if (localObject != null)
        {
          int i1 = localObject.length;
          k = 0;
          f1 = 1.0F;
          while (k < i1)
          {
            f1 = localObject[k].getSizeChange();
            k += 1;
          }
        }
        float f1 = 1.0F;
        localObject = localEditable.subSequence(n, j).toString();
        float[] arrayOfFloat = new float[((String)localObject).length()];
        paramEditText.getTextWidths((String)localObject, arrayOfFloat);
        j = 0;
        float f2 = 0.0F;
        while (j < ((String)localObject).length())
        {
          f2 += arrayOfFloat[j] * f1;
          if ((j == ((String)localObject).length() - 1) && (paramFloat1 >= f2)) {
            return n + ((String)localObject).length();
          }
          if ((f2 < paramFloat1) && (j != ((String)localObject).length() - 1)) {
            j += 1;
          } else {
            return n + j;
          }
        }
      }
      i += 1;
      j = m;
    }
    return -1;
  }
  
  static void a(EditText paramEditText)
  {
    if (paramEditText == null) {
      return;
    }
    ak.a(paramEditText).hideSoftInputFromInputMethod(paramEditText.getWindowToken(), 0);
  }
  
  static void b(EditText paramEditText)
  {
    if (paramEditText == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramEditText.setShowSoftInputOnFocus(false);
      return;
    }
    try
    {
      localMethod = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[] { Boolean.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(paramEditText, new Object[] { Boolean.valueOf(false) });
      localMethod.setAccessible(false);
      return;
    }
    catch (Exception paramEditText)
    {
      Method localMethod;
      o.b("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", new Object[] { af.a(paramEditText) });
      return;
      o.d("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      try
      {
        localMethod = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[] { Boolean.TYPE });
        localMethod.setAccessible(true);
        localMethod.invoke(paramEditText, new Object[] { Boolean.valueOf(false) });
        localMethod.setAccessible(false);
        return;
      }
      catch (Exception localException)
      {
        o.b("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", new Object[] { af.a(localException) });
        if ((paramEditText.getContext() != null) && ((paramEditText.getContext() instanceof ae))) {
          ((ae)paramEditText.getContext()).hideVKB(paramEditText);
        }
        return;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label85:
      break label85;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.ak.a
 * JD-Core Version:    0.7.0.1
 */