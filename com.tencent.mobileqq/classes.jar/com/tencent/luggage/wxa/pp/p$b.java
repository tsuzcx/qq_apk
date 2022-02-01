package com.tencent.luggage.wxa.pp;

import android.text.Spanned;
import android.widget.EditText;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.ri.a;
import com.tencent.luggage.wxa.ri.a.a;
import com.tencent.luggage.wxa.rj.b.a;
import java.lang.ref.WeakReference;

final class p$b
  extends a
{
  private final int b;
  private final a.a c;
  
  p$b(p paramp, int paramInt, a.a parama)
  {
    super(paramInt, parama);
    this.b = paramInt;
    this.c = parama;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    Object localObject = new StringBuilder();
    int i = 0;
    ((StringBuilder)localObject).append(paramSpanned.subSequence(0, paramInt3).toString());
    ((StringBuilder)localObject).append(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString());
    if (a(((StringBuilder)localObject).toString(), this.c) + a(paramCharSequence.subSequence(paramInt1, paramInt2).toString(), this.c) > this.b) {
      i = 1;
    }
    if (i != 0) {
      paramCharSequence = paramCharSequence.subSequence(paramInt1, Math.max(paramInt1, Math.min(this.b - (paramSpanned.length() - (paramInt4 - paramInt3)), paramInt2)));
    }
    if ((i != 0) && (af.a(paramCharSequence)))
    {
      if (p.a(this.a) == null) {
        paramSpanned = null;
      } else {
        paramSpanned = (EditText)p.b(this.a).get();
      }
      b.a locala = p.c(this.a);
      if ((paramSpanned != null) && (locala != null))
      {
        if (paramSpanned.getText() != null) {
          localObject = paramSpanned.getText().toString();
        } else {
          localObject = "";
        }
        paramSpanned.post(new p.b.1(this, locala, (String)localObject));
      }
    }
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.p.b
 * JD-Core Version:    0.7.0.1
 */