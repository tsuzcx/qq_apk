package com.tencent.luggage.game.widget.input;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.luggage.util.k;
import com.tencent.luggage.wxa.oq.e.b;
import com.tencent.luggage.wxa.pp.n;
import com.tencent.luggage.wxa.pp.x;
import com.tencent.luggage.wxa.pw.b;
import com.tencent.luggage.wxa.qz.o;

public class a
  extends x
{
  private static final int a = 2131428532;
  private a.a b;
  private WAGamePanelInputEditText c;
  private View.OnClickListener d;
  
  public a(Context paramContext)
  {
    super(paramContext, null);
    b(a);
  }
  
  public static a a(@NonNull View paramView)
  {
    return (a)paramView.getRootView().findViewById(a);
  }
  
  public static a b(@NonNull View paramView)
  {
    n localn = n.a(paramView);
    n.c(paramView);
    Object localObject = x.c(paramView);
    if ((localObject != null) && ((((x)localObject).getParent() instanceof ViewGroup))) {
      ((ViewGroup)((x)localObject).getParent()).removeView((View)localObject);
    }
    a locala = a(paramView);
    localObject = locala;
    if (locala == null)
    {
      if ((paramView instanceof a)) {
        paramView = (a)paramView;
      } else {
        paramView = new a(paramView.getContext());
      }
      localn.b(paramView);
      localObject = paramView;
    }
    return localObject;
  }
  
  private boolean l()
  {
    return (this.c.getInputType() & 0x20000) > 0;
  }
  
  public void a(b paramb, Context paramContext, e.b paramb1)
  {
    if ((paramb1 == e.b.c) || (paramb1 == e.b.d) || (e.b.e == paramb1) || (e.b.f == paramb1))
    {
      i = com.tencent.mm.ui.a.g(paramContext);
      int j = k.a.a(paramContext);
      paramContext = (LinearLayout.LayoutParams)this.c.getLayoutParams();
      o.d("MicroMsg.WAGameInputPanel", "EditBar setmEditText cutoutHeight(%d),leftMargin(%d).", new Object[] { Integer.valueOf(j), Integer.valueOf(paramContext.leftMargin) });
      if (j > 0) {
        paramContext.setMargins(j, paramContext.topMargin, paramContext.rightMargin, paramContext.bottomMargin);
      } else {
        paramContext.setMargins(paramContext.leftMargin, paramContext.topMargin, paramContext.rightMargin, paramContext.bottomMargin);
      }
      this.c.setLayoutParams(paramContext);
      this.b.a(i);
    }
    paramContext = paramb;
    if (paramb == null) {
      paramContext = b.a;
    }
    getAttachedEditText().setImeOptions(paramContext.g);
    getAttachedEditText().setFocusable(true);
    getAttachedEditText().setFocusableInTouchMode(true);
    f();
    int i = a.2.a[paramContext.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return;
            }
            ((Button)this.b.a()).setText(2131886948);
            return;
          }
          ((Button)this.b.a()).setText(2131886945);
          return;
        }
        ((Button)this.b.a()).setText(2131886946);
        return;
      }
      ((Button)this.b.a()).setText(2131886947);
      return;
    }
    ((Button)this.b.a()).setText(2131886944);
  }
  
  protected void b()
  {
    this.b.a(false);
  }
  
  protected a.a c()
  {
    a.a locala = new a.a(getContext());
    this.c = ((WAGamePanelInputEditText)locala.findViewById(2131433982));
    locala.a().setOnClickListener(new a.1(this));
    a(this.c);
    this.b = locala;
    return locala;
  }
  
  protected void d()
  {
    View localView = this.b.a();
    int i;
    if (l()) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  protected void e() {}
  
  public void f()
  {
    a(this.c);
    this.c.requestFocus();
    super.f();
  }
  
  public WAGamePanelInputEditText getAttachedEditText()
  {
    return (WAGamePanelInputEditText)super.getAttachedEditText();
  }
  
  protected void j_()
  {
    b(this);
  }
  
  public void setOnConfirmClickListener(View.OnClickListener paramOnClickListener)
  {
    this.d = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.widget.input.a
 * JD-Core Version:    0.7.0.1
 */