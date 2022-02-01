package com.tencent.luggage.wxa.as;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
  extends a<c.a>
{
  private List<com.tencent.luggage.wxa.az.b> a = new ArrayList();
  private List<com.tencent.luggage.wxa.az.b> b = new ArrayList();
  private com.tencent.luggage.wxa.ay.b c;
  private com.tencent.luggage.wxa.ay.c d;
  
  public c(Context paramContext, com.tencent.luggage.wxa.aw.b paramb, List<com.tencent.luggage.wxa.az.b> paramList, com.tencent.luggage.wxa.ay.b paramb1)
  {
    super(paramContext, paramb);
    this.c = paramb1;
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.b.addAll(paramList);
    }
  }
  
  private void a(com.tencent.luggage.wxa.az.b paramb, int paramInt)
  {
    a(new c.2(this, paramb, paramInt));
  }
  
  private void a(Runnable paramRunnable)
  {
    paramRunnable.run();
    paramRunnable = this.d;
    if (paramRunnable != null) {
      paramRunnable.a(this.b);
    }
  }
  
  private boolean a(com.tencent.luggage.wxa.az.b paramb)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (((com.tencent.luggage.wxa.az.b)localIterator.next()).a().equals(paramb.a())) {
        return true;
      }
    }
    return false;
  }
  
  private void b(com.tencent.luggage.wxa.az.b paramb, int paramInt)
  {
    a(new c.3(this, paramb, paramInt));
  }
  
  public c.a a(ViewGroup paramViewGroup, int paramInt)
  {
    return new c.a(c().inflate(2131625241, paramViewGroup, false));
  }
  
  public void a(c.a parama, int paramInt)
  {
    com.tencent.luggage.wxa.az.b localb = (com.tencent.luggage.wxa.az.b)this.a.get(paramInt);
    boolean bool1 = a(localb);
    a().a(localb.a(), c.a.a(parama), com.tencent.luggage.wxa.aw.c.b);
    boolean bool2 = com.tencent.image_picker.imagepicker.helper.c.a(localb);
    int k = 1;
    int j = 0;
    int i;
    if (bool2)
    {
      localObject = b().getResources().getString(2131918047);
      i = 1;
    }
    else
    {
      localObject = "";
      i = 0;
    }
    if (com.tencent.image_picker.imagepicker.helper.c.b(localb))
    {
      localObject = b().getResources().getString(2131918059);
      i = k;
    }
    c.a.b(parama).setText((CharSequence)localObject);
    Object localObject = c.a.b(parama);
    if (i != 0) {
      i = j;
    } else {
      i = 8;
    }
    ((TextView)localObject).setVisibility(i);
    localObject = c.a.c(parama);
    float f;
    if (bool1) {
      f = 0.5F;
    } else {
      f = 0.0F;
    }
    ((View)localObject).setAlpha(f);
    parama.itemView.setOnClickListener(new c.1(this, bool1, localb, paramInt));
    localObject = c.a.d(parama);
    if (bool1) {
      parama = ContextCompat.getDrawable(b(), 2130853692);
    } else {
      parama = null;
    }
    ((FrameLayout)localObject).setForeground(parama);
  }
  
  public void a(com.tencent.luggage.wxa.ay.c paramc)
  {
    this.d = paramc;
  }
  
  public void a(List<com.tencent.luggage.wxa.az.b> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
  }
  
  public void d()
  {
    a(new c.4(this));
  }
  
  public List<com.tencent.luggage.wxa.az.b> e()
  {
    return this.b;
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.as.c
 * JD-Core Version:    0.7.0.1
 */