package com.tencent.luggage.wxa.pp;

import android.widget.EditText;
import com.tencent.luggage.wxa.ri.a;
import com.tencent.luggage.wxa.ri.a.a;
import com.tencent.luggage.wxa.rj.b;
import java.lang.ref.WeakReference;

public final class p
  extends b
{
  private p(WeakReference<EditText> paramWeakReference)
  {
    super(paramWeakReference);
  }
  
  public static p a(EditText paramEditText)
  {
    return new p(new WeakReference(paramEditText));
  }
  
  protected a a(int paramInt, a.a parama)
  {
    return new p.b(this, paramInt, parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.p
 * JD-Core Version:    0.7.0.1
 */