package com.tencent.luggage.wxa.rj;

import android.text.InputFilter;
import android.widget.EditText;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ri.a.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class b
  extends a
{
  protected WeakReference<EditText> a;
  protected b.a b;
  private boolean c = true;
  private String d;
  private int e;
  private int f;
  private a.a g;
  private ArrayList<InputFilter> h;
  
  public b(String paramString)
  {
    this.d = paramString;
    this.g = a.a.b;
    this.c = false;
  }
  
  public b(WeakReference<EditText> paramWeakReference)
  {
    this.a = paramWeakReference;
    this.g = a.a.b;
    this.c = false;
  }
  
  public static b a(String paramString)
  {
    return new b(paramString);
  }
  
  protected int a()
  {
    if (af.c(this.d))
    {
      WeakReference localWeakReference = this.a;
      if (localWeakReference == null) {
        return 1;
      }
      this.d = ((EditText)localWeakReference.get()).getText().toString().trim();
    }
    int i = com.tencent.luggage.wxa.ri.a.a(this.d, this.g);
    if (a(i))
    {
      o.c("MicroMsg.InputTextBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
      return 2;
    }
    if (i < this.f) {
      return 1;
    }
    if (i > this.e) {
      return 2;
    }
    return 0;
  }
  
  protected com.tencent.luggage.wxa.ri.a a(int paramInt, a.a parama)
  {
    return new com.tencent.luggage.wxa.ri.a(paramInt, parama);
  }
  
  public b a(a.a parama)
  {
    this.g = parama;
    return this;
  }
  
  public b a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public void a(b.a parama)
  {
    this.b = parama;
    b();
  }
  
  public b b(int paramInt)
  {
    this.f = 0;
    this.e = paramInt;
    return this;
  }
  
  protected void b()
  {
    if (!this.c)
    {
      if (this.a == null)
      {
        o.c("MicroMsg.InputTextBoundaryCheck", "edit text view is null");
        return;
      }
      Object localObject;
      if (af.a(this.h))
      {
        localObject = a(this.e, this.g);
        ((EditText)this.a.get()).setFilters(new InputFilter[] { localObject });
      }
      else
      {
        this.h.add(a(this.e, this.g));
        localObject = this.h;
        localObject = (InputFilter[])((ArrayList)localObject).toArray(new InputFilter[((ArrayList)localObject).size()]);
        ((EditText)this.a.get()).setFilters((InputFilter[])localObject);
      }
    }
    if (this.b != null)
    {
      int i = a();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          this.b.a(this.d);
          return;
        }
        this.b.c(this.d);
        return;
      }
      this.b.b(this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rj.b
 * JD-Core Version:    0.7.0.1
 */