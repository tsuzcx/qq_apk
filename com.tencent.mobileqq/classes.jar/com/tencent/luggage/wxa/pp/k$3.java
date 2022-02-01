package com.tencent.luggage.wxa.pp;

import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.or.n;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.pd.w;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.page.u;

class k$3
  implements Runnable
{
  k$3(k paramk) {}
  
  private int a()
  {
    View localView = k.b(this.a);
    if (localView != null) {
      return localView.getScrollY();
    }
    return 0;
  }
  
  private void a(int paramInt)
  {
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandInputPageOffsetHelper", "[TextAreaHeight] offsetRoot %d", new Object[] { Integer.valueOf(paramInt) });
    View localView = k.b(this.a);
    if (localView != null)
    {
      localView.scrollTo(0, paramInt);
      k.i(this.a);
    }
  }
  
  private <Input extends EditText,  extends ac> void a(Input paramInput, int paramInt)
  {
    am localam = k.a(this.a).aj();
    if (localam != null)
    {
      View localView = localam.getContentView();
      if (localView != null)
      {
        if (paramInput == null) {
          return;
        }
        paramInt = -(localam.getWebScrollY() - paramInput.getTop());
        localView.scrollBy(localView.getScrollX(), paramInt);
      }
    }
  }
  
  private <Input extends EditText,  extends ac> void a(@NonNull ab<Input> paramab)
  {
    if (paramab.n() != null)
    {
      if (paramab.f() == null) {
        return;
      }
      EditText localEditText = paramab.f();
      Object localObject = paramab.n();
      if (w.a(localEditText))
      {
        a(paramab, 0);
        return;
      }
      if (!((ad)localObject).a())
      {
        com.tencent.luggage.wxa.qz.o.f("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panel height %d, tryCount %d", new Object[] { Integer.valueOf(((View)localObject).getHeight()), Integer.valueOf(k.e(this.a)) });
        if (k.f(this.a) < 5) {
          k.a(this.a, false);
        }
      }
      else
      {
        k.b(this.a, 0);
        com.tencent.luggage.wxa.qz.o.f("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panelHeight %d", new Object[] { Integer.valueOf(((View)localObject).getHeight()) });
      }
      a(paramab, ((View)localObject).getHeight());
      if (!paramab.o())
      {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] beginOffset, no need adjust position, notify height %d", new Object[] { Integer.valueOf(((View)localObject).getHeight()) });
        return;
      }
      if (((k.a(this.a).y() instanceof n)) && (k.a(this.a).v()))
      {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] beginOffset, in landscape skip adjust position, notify height %d", new Object[] { Integer.valueOf(((View)localObject).getHeight()) });
        return;
      }
      int[] arrayOfInt = new int[2];
      localEditText.getLocationOnScreen(arrayOfInt);
      int k = arrayOfInt[1];
      com.tencent.luggage.wxa.qz.o.f("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] inputHeight %d, inputTop %d, inputAttached %B", new Object[] { Integer.valueOf(localEditText.getHeight()), Integer.valueOf(k), Boolean.valueOf(ViewCompat.isAttachedToWindow(localEditText)) });
      k.g(this.a);
      int j = localEditText.getHeight() + k;
      ((View)localObject).getLocationOnScreen(arrayOfInt);
      int i1 = arrayOfInt[1];
      localObject = (ac)localEditText;
      int i;
      if ((((ac)localObject).c()) && (localEditText.getLayout() != null))
      {
        int n = ((ac)localObject).a(localEditText.getLayout().getLineForOffset(localEditText.getSelectionStart())) + k;
        int m = ((ac)localObject).a(localEditText.getLayout().getLineForOffset(localEditText.getSelectionStart()) + 1) + k;
        i = n;
        if (n - k >= localEditText.getHeight()) {
          i = j - localEditText.getLineHeight();
        }
        if (m - k < localEditText.getHeight()) {
          j = m;
        }
      }
      else
      {
        i = k;
      }
      k = j;
      if (!k.a(this.a).v()) {
        k = j + paramab.p();
      }
      if (i1 == k) {
        return;
      }
      if (i < k.h(this.a))
      {
        a(localEditText, i);
        return;
      }
      b(localEditText, Math.max(-a(), Math.min(k - i1, i - k.h(this.a))));
    }
  }
  
  private void a(@NonNull ab paramab, int paramInt)
  {
    t.a(new k.3.1(this, paramab, paramInt));
  }
  
  private <Input extends EditText,  extends ac> void b(Input paramInput, int paramInt)
  {
    am localam = k.a(this.a).aj();
    if (localam != null)
    {
      View localView = localam.getContentView();
      if (localView != null)
      {
        if (paramInput == null) {
          return;
        }
        ac localac = (ac)paramInput;
        if (localac.b())
        {
          a(paramInt + a());
          return;
        }
        int i = localam.getHeight();
        int j = localam.getWebScrollY();
        int k = g.c(localam.getContentHeight());
        int m = paramInput.getHeight();
        paramInput.getTop();
        if ((!localac.c()) && (paramInput.getTop() + m - j <= i))
        {
          a(paramInt + a());
          return;
        }
        i = Math.max(0, Math.min(k - j - i, paramInt));
        localView.scrollBy(localView.getScrollX(), i);
        k.a(this.a, i);
        a(paramInt - i + a());
      }
    }
  }
  
  public void run()
  {
    com.tencent.luggage.wxa.qz.o.f("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] offsetRunner enter");
    ab localab = o.c(k.a(this.a));
    if (localab == null) {
      return;
    }
    if (!k.a(this.a).d()) {
      return;
    }
    k.a(this.a, 0);
    a(localab);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.k.3
 * JD-Core Version:    0.7.0.1
 */