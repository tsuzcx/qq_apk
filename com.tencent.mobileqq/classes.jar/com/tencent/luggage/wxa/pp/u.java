package com.tencent.luggage.wxa.pp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.px.a;
import com.tencent.luggage.wxa.qz.l;
import com.tencent.luggage.wxa.qz.r;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class u
  implements a
{
  private static Integer g;
  private int a = 0;
  private final int[] b = new int[2];
  private final Rect c = new Rect();
  private boolean d = false;
  private View e;
  private u.b f;
  private final LinkedHashSet<u.c> h = new LinkedHashSet();
  
  private View a()
  {
    View localView = this.e;
    if (localView == null) {
      return null;
    }
    return localView.getRootView();
  }
  
  private void a(int paramInt)
  {
    if (this.a == 0)
    {
      this.a = paramInt;
      return;
    }
    paramInt = c() - paramInt;
    if (paramInt <= 0) {
      return;
    }
    boolean bool = a(b(), paramInt);
    a(new u.1(this, paramInt));
    u.b localb = this.f;
    if (localb == null) {
      return;
    }
    if ((bool) || (localb.getHeight() != paramInt)) {
      this.f.a(paramInt);
    }
  }
  
  private void a(Rect paramRect)
  {
    View localView = this.e;
    if (localView != null)
    {
      localView.getWindowVisibleDisplayFrame(paramRect);
      this.e.getLocationInWindow(this.b);
      paramRect.top = this.b[1];
    }
  }
  
  private void a(@NonNull u.a parama)
  {
    Iterator localIterator = ((LinkedHashSet)this.h.clone()).iterator();
    while (localIterator.hasNext()) {
      parama.a((u.c)localIterator.next());
    }
  }
  
  private void a(boolean paramBoolean)
  {
    u.b localb = this.f;
    if (localb != null) {
      localb.a(paramBoolean);
    }
  }
  
  private static boolean a(Context paramContext, int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    if (g == null) {
      g = Integer.valueOf(l.d(paramContext));
    }
    if (g.intValue() != paramInt)
    {
      g = Integer.valueOf(paramInt);
      return true;
    }
    return false;
  }
  
  private Context b()
  {
    View localView = this.e;
    if (localView == null) {
      return r.a();
    }
    return localView.getContext();
  }
  
  private void b(int paramInt)
  {
    int j = c();
    int i = 1;
    boolean bool;
    if (j > paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    if (this.d != bool) {
      paramInt = i;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      a(bool);
      a(new u.2(this, bool));
    }
    this.d = bool;
  }
  
  private int c()
  {
    if (a() == null) {
      return 0;
    }
    Rect localRect = this.c;
    a(localRect);
    int i;
    if (ViewCompat.isLaidOut(this.e)) {
      i = this.e.getMeasuredHeight();
    } else {
      i = b().getResources().getDisplayMetrics().heightPixels;
    }
    return i - localRect.top;
  }
  
  public void a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.e = paramView;
    paramView = this.c;
    a(paramView);
    paramInt1 = paramView.height();
    a(paramInt1);
    b(paramInt1);
    this.a = paramInt1;
    this.e = null;
  }
  
  void a(u.b paramb)
  {
    this.f = paramb;
  }
  
  public void a(u.c paramc)
  {
    if ((paramc != null) && (!this.h.contains(paramc))) {
      this.h.add(paramc);
    }
  }
  
  public void b(u.c paramc)
  {
    if (paramc != null) {
      this.h.remove(paramc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.u
 * JD-Core Version:    0.7.0.1
 */