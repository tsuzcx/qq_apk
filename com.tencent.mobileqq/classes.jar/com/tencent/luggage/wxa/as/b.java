package com.tencent.luggage.wxa.as;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.luggage.wxa.aw.c;
import java.util.ArrayList;
import java.util.List;

public class b
  extends a<b.a>
{
  private final com.tencent.luggage.wxa.ay.a a;
  private List<com.tencent.luggage.wxa.az.a> b = new ArrayList();
  
  public b(Context paramContext, com.tencent.luggage.wxa.aw.b paramb, com.tencent.luggage.wxa.ay.a parama)
  {
    super(paramContext, paramb);
    this.a = parama;
  }
  
  public b.a a(ViewGroup paramViewGroup, int paramInt)
  {
    return new b.a(c().inflate(2131625240, paramViewGroup, false));
  }
  
  public void a(b.a parama, int paramInt)
  {
    com.tencent.luggage.wxa.az.a locala = (com.tencent.luggage.wxa.az.a)this.b.get(paramInt);
    a().a(((com.tencent.luggage.wxa.az.b)locala.b().get(0)).a(), b.a.a(parama), c.a);
    b.a.b(parama).setText(((com.tencent.luggage.wxa.az.a)this.b.get(paramInt)).a());
    b.a.c(parama).setText(String.valueOf(((com.tencent.luggage.wxa.az.a)this.b.get(paramInt)).b().size()));
    parama.itemView.setOnClickListener(new b.1(this, locala));
  }
  
  public void a(List<com.tencent.luggage.wxa.az.a> paramList)
  {
    if (paramList != null)
    {
      this.b.clear();
      this.b.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.as.b
 * JD-Core Version:    0.7.0.1
 */