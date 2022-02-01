package com.tencent.luggage.wxa.ax;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.image_picker.imagepicker.features.h;
import java.util.ArrayList;
import java.util.List;

public class b
{
  private final Context a;
  private final RecyclerView b;
  private final com.tencent.image_picker.imagepicker.features.c c;
  private GridLayoutManager d;
  private com.tencent.image_picker.imagepicker.view.a e;
  private com.tencent.luggage.wxa.as.c f;
  private com.tencent.luggage.wxa.as.b g;
  private Parcelable h;
  private int i;
  private int j;
  
  public b(RecyclerView paramRecyclerView, com.tencent.image_picker.imagepicker.features.c paramc, int paramInt)
  {
    this.b = paramRecyclerView;
    this.c = paramc;
    this.a = paramRecyclerView.getContext();
    a(paramInt);
  }
  
  private void b(int paramInt)
  {
    com.tencent.image_picker.imagepicker.view.a locala = this.e;
    if (locala != null) {
      this.b.removeItemDecoration(locala);
    }
    this.e = new com.tencent.image_picker.imagepicker.view.a(paramInt, this.a.getResources().getDimensionPixelSize(2131300059), false);
    this.b.addItemDecoration(this.e);
    this.d.setSpanCount(paramInt);
  }
  
  private boolean d()
  {
    return (this.b.getAdapter() == null) || ((this.b.getAdapter() instanceof com.tencent.luggage.wxa.as.b));
  }
  
  private void e()
  {
    if (this.f != null) {
      return;
    }
    throw new IllegalStateException("Must call setupAdapters first!");
  }
  
  public String a()
  {
    if (d()) {
      return com.tencent.image_picker.imagepicker.helper.a.a(this.a, this.c);
    }
    if (this.c.b() == 1) {
      return com.tencent.image_picker.imagepicker.helper.a.b(this.a, this.c);
    }
    int m = this.f.e().size();
    int k;
    if ((!com.tencent.image_picker.imagepicker.helper.c.a(this.c.g())) && (m == 0)) {
      k = 1;
    } else {
      k = 0;
    }
    if (k != 0) {
      return com.tencent.image_picker.imagepicker.helper.a.b(this.a, this.c);
    }
    if (this.c.c() == 999) {
      return String.format(this.a.getString(2131918055), new Object[] { Integer.valueOf(m) });
    }
    return String.format(this.a.getString(2131918056), new Object[] { Integer.valueOf(m), Integer.valueOf(this.c.c()) });
  }
  
  public void a(int paramInt)
  {
    int k;
    if (paramInt == 1) {
      k = 3;
    } else {
      k = 5;
    }
    this.i = k;
    if (paramInt == 1) {
      paramInt = 2;
    } else {
      paramInt = 4;
    }
    this.j = paramInt;
    if ((this.c.k()) && (d())) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0) {
      paramInt = this.j;
    } else {
      paramInt = this.i;
    }
    this.d = new GridLayoutManager(this.a, paramInt);
    this.b.setLayoutManager(this.d);
    this.b.setHasFixedSize(true);
    b(paramInt);
  }
  
  public void a(a parama)
  {
    if ((this.c.k()) && (!d()))
    {
      b(null);
      parama.a();
      return;
    }
    parama.b();
  }
  
  public void a(com.tencent.luggage.wxa.ay.b paramb, com.tencent.luggage.wxa.ay.a parama)
  {
    ArrayList localArrayList;
    if ((this.c.b() == 2) && (!this.c.i().isEmpty())) {
      localArrayList = this.c.i();
    } else {
      localArrayList = null;
    }
    com.tencent.luggage.wxa.aw.b localb = this.c.m();
    this.f = new com.tencent.luggage.wxa.as.c(this.a, localb, localArrayList, paramb);
    this.g = new com.tencent.luggage.wxa.as.b(this.a, localb, new b.1(this, parama));
  }
  
  public void a(com.tencent.luggage.wxa.ay.c paramc)
  {
    e();
    this.f.a(paramc);
  }
  
  public void a(List<com.tencent.luggage.wxa.az.b> paramList)
  {
    this.f.a(paramList);
    b(this.i);
    this.b.setAdapter(this.f);
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.c.b() == 2)
    {
      if ((this.f.e().size() >= this.c.c()) && (!paramBoolean))
      {
        Toast.makeText(this.a, 2131918050, 0).show();
        return false;
      }
    }
    else if ((this.c.b() == 1) && (this.f.e().size() > 0)) {
      this.f.d();
    }
    return true;
  }
  
  public List<com.tencent.luggage.wxa.az.b> b()
  {
    e();
    return this.f.e();
  }
  
  public void b(List<com.tencent.luggage.wxa.az.a> paramList)
  {
    this.g.a(paramList);
    b(this.j);
    this.b.setAdapter(this.g);
    if (this.h != null)
    {
      this.d.setSpanCount(this.j);
      this.b.getLayoutManager().onRestoreInstanceState(this.h);
    }
  }
  
  public boolean c()
  {
    return (!d()) && (!this.f.e().isEmpty()) && (this.c.o() != h.b) && (this.c.o() != h.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ax.b
 * JD-Core Version:    0.7.0.1
 */