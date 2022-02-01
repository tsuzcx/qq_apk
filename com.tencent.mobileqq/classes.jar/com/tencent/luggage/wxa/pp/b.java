package com.tencent.luggage.wxa.pp;

import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.EditText;
import com.tencent.luggage.wxa.pw.c;
import com.tencent.luggage.wxa.pw.g;
import com.tencent.luggage.wxa.pw.h;
import com.tencent.luggage.wxa.qz.o;

 enum b
{
  static Spanned a(h paramh)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramh.w);
    int i = paramh.w.length();
    localSpannableStringBuilder.setSpan(new StyleSpan(c.a(paramh.x).c), 0, i, 18);
    if (paramh.z != null) {
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramh.z.intValue()), 0, i, 18);
    }
    if (paramh.y != null) {
      localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(paramh.y.intValue(), false), 0, i, 18);
    }
    return localSpannableStringBuilder;
  }
  
  static <Input extends EditText,  extends ac> void a(Input paramInput, int paramInt1, int paramInt2)
  {
    if ((paramInput != null) && (paramInput.getEditableText() != null))
    {
      int i;
      if (paramInt1 <= -2)
      {
        i = paramInput.getSelectionStart();
      }
      else if (paramInt1 != -1)
      {
        i = paramInt1;
        if (paramInt1 <= paramInput.getText().length()) {}
      }
      else
      {
        i = paramInput.getText().length();
      }
      if (paramInt2 <= -2)
      {
        paramInt1 = paramInput.getSelectionEnd();
      }
      else if (paramInt2 != -1)
      {
        paramInt1 = paramInt2;
        if (paramInt2 <= paramInput.getText().length()) {}
      }
      else
      {
        paramInt1 = paramInput.getText().length();
      }
      paramInt2 = i;
      if (i > paramInt1) {
        paramInt2 = paramInt1;
      }
      Selection.removeSelection(paramInput.getEditableText());
      paramInput.setSelection(paramInt2, paramInt1);
      return;
    }
    o.c("MicroMsg.AppBrandInputCommStyleHelper", "applySelection, invalid input %s", new Object[] { paramInput });
  }
  
  static <Input extends EditText,  extends ac> void a(Input paramInput, h paramh)
  {
    if (paramInput != null)
    {
      if (paramh == null) {
        return;
      }
      if ((paramh.s != null) && (paramh.s.floatValue() != paramInput.getTextSize())) {
        paramInput.setTextSize(paramh.s.floatValue());
      }
      if (paramh.r != null) {
        paramInput.setTextColor(paramh.r.intValue());
      }
      if (paramh.q != null)
      {
        if ((paramInput.getBackground() == null) || (!(paramInput.getBackground() instanceof ColorDrawable)) || (((ColorDrawable)paramInput.getBackground()).getColor() != paramh.q.intValue())) {
          paramInput.setBackground(new ColorDrawable(paramh.q.intValue()));
        }
      }
      else {
        paramInput.setBackground(null);
      }
      if (paramh.w != null) {
        if (TextUtils.isEmpty(paramh.w)) {
          paramInput.setHint("");
        } else {
          paramInput.setHint(a(paramh));
        }
      }
      if (paramh.u != null)
      {
        localObject = Typeface.create("sans-serif", c.a(paramh.u).c);
        if (localObject != null) {
          paramInput.setTypeface((Typeface)localObject);
        }
      }
      Object localObject = g.a(paramh.p);
      ac localac = (ac)paramInput;
      ((g)localObject).a(localac);
      int i;
      if (ak.a(paramh.B)) {
        i = 8;
      } else {
        i = 0;
      }
      paramInput.setVisibility(i);
      localac.setFixed(ak.a(paramh.F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.b
 * JD-Core Version:    0.7.0.1
 */