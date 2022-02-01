package com.tencent.luggage.wxa.pp;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.AlignmentSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import androidx.collection.ArrayMap;
import com.tencent.luggage.wxa.qt.a;
import com.tencent.luggage.wxa.qt.c;
import com.tencent.luggage.wxa.qz.af;
import java.util.Map;
import java.util.Set;

final class z$a
  implements TextWatcher
{
  final Map<TextWatcher, Object> a = new ArrayMap();
  
  private z$a(z paramz) {}
  
  private <T> void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, Class<T> paramClass)
  {
    try
    {
      if ((paramCharSequence instanceof SpannableStringBuilder))
      {
        paramCharSequence = (SpannableStringBuilder)paramCharSequence;
        paramClass = paramCharSequence.getSpans(paramInt1, paramInt2 + paramInt1, paramClass);
        if ((paramClass != null) && (paramClass.length > 0))
        {
          paramInt2 = paramClass.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            paramCharSequence.removeSpan(paramClass[paramInt1]);
            paramInt1 += 1;
          }
        }
      }
      return;
    }
    catch (Throwable paramCharSequence) {}
  }
  
  void a()
  {
    this.a.clear();
  }
  
  void a(Editable paramEditable)
  {
    Object localObject;
    int i;
    int j;
    if ((f.a()) && (f.b()))
    {
      localObject = new a();
      c localc = new c();
      String str = z.a(this.b, paramEditable, (a)localObject, localc);
      i = localc.a;
      if ((((a)localObject).a) && (!af.c(str)))
      {
        j = Selection.getSelectionEnd(paramEditable);
        boolean bool = z.c(this.b);
        this.b.post(new z.a.1(this, bool, str, j, i));
        return;
      }
    }
    if (z.c(this.b)) {
      return;
    }
    z.d(this.b);
    if (!this.a.isEmpty())
    {
      localObject = (TextWatcher[])this.a.keySet().toArray(new TextWatcher[this.a.size()]);
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localObject[i].afterTextChanged(paramEditable);
        i += 1;
      }
    }
  }
  
  void a(TextWatcher paramTextWatcher)
  {
    if (paramTextWatcher != null) {
      this.a.put(paramTextWatcher, this);
    }
  }
  
  void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (z.c(this.b)) {
      return;
    }
    if (!this.a.isEmpty())
    {
      TextWatcher[] arrayOfTextWatcher = (TextWatcher[])this.a.keySet().toArray(new TextWatcher[this.a.size()]);
      int j = arrayOfTextWatcher.length;
      int i = 0;
      while (i < j)
      {
        arrayOfTextWatcher[i].beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
        i += 1;
      }
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    a(paramEditable);
  }
  
  void b(TextWatcher paramTextWatcher)
  {
    if (paramTextWatcher != null) {
      this.a.remove(paramTextWatcher);
    }
  }
  
  void b(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (z.c(this.b)) {
      return;
    }
    a(paramCharSequence, paramInt1, paramInt3, StyleSpan.class);
    a(paramCharSequence, paramInt1, paramInt3, RelativeSizeSpan.class);
    a(paramCharSequence, paramInt1, paramInt3, AlignmentSpan.class);
    if (!this.a.isEmpty())
    {
      TextWatcher[] arrayOfTextWatcher = (TextWatcher[])this.a.keySet().toArray(new TextWatcher[this.a.size()]);
      int j = arrayOfTextWatcher.length;
      int i = 0;
      while (i < j)
      {
        arrayOfTextWatcher[i].onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
        i += 1;
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.z.a
 * JD-Core Version:    0.7.0.1
 */