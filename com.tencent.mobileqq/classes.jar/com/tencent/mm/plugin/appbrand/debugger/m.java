package com.tencent.mm.plugin.appbrand.debugger;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.qw.jn;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog.Builder;
import java.util.Iterator;
import java.util.LinkedList;

@SuppressLint({"ViewConstructor"})
public class m
  extends FrameLayout
{
  private e a;
  private ViewGroup b;
  private RemoteDebugMoveView c;
  private LinkedList<String> d = new LinkedList();
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private ImageView l;
  private ImageView m;
  private View n;
  private boolean o = false;
  private m.a p;
  private MMAlertDialog q;
  private View.OnClickListener r = new m.3(this);
  
  public m(@NonNull Context paramContext, e parame, m.a parama)
  {
    super(paramContext);
    this.a = parame;
    this.p = parama;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setBackgroundColor(getContext().getResources().getColor(2131168376));
    setId(2131428527);
  }
  
  private void b(String paramString)
  {
    this.d.add(0, paramString);
    while (this.d.size() > 10) {
      this.d.removeLast();
    }
    paramString = new StringBuilder();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      paramString.append((String)localIterator.next());
      paramString.append("\n");
    }
    this.k.setText(paramString.toString());
    if (this.o)
    {
      this.k.setVisibility(0);
      return;
    }
    this.k.setVisibility(8);
  }
  
  private boolean j()
  {
    return (this.a.y()) || (this.a.A()) || (this.a.B());
  }
  
  private void k()
  {
    Object localObject = this.q;
    if ((localObject != null) && (((MMAlertDialog)localObject).isShowing())) {
      return;
    }
    localObject = getContext();
    if (((localObject instanceof Activity)) && (((Activity)localObject).isFinishing())) {
      return;
    }
    this.q = new MMAlertDialog.Builder((Context)localObject).setTitle(((Context)localObject).getString(2131886890)).setMsg("").setPositiveBtnText(2131887629).setPositiveBtnListener(new m.4(this)).setNegativeBtnText(2131887626).create();
    this.q.show();
  }
  
  private void l()
  {
    if ((!this.a.u()) && (this.a.x()))
    {
      this.l.setImageResource(2130838683);
      this.e.setText(getContext().getString(2131886892));
      return;
    }
    this.l.setImageResource(2130838682);
    this.e.setText(getContext().getString(2131886891));
  }
  
  private void m()
  {
    String str = getContext().getString(2131886888, new Object[] { Integer.valueOf(this.a.f().size()), Integer.valueOf(this.a.v().size()), Long.valueOf(this.a.F()) });
    this.g.setText(str);
  }
  
  public void a()
  {
    setVisibility(8);
    if ((getParent() instanceof ViewGroup))
    {
      ((ViewGroup)getParent()).removeView(this);
      removeAllViews();
    }
    this.b = null;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, jn paramjn)
  {
    t.a(new m.8(this, paramInt, paramjn));
  }
  
  public void a(View paramView)
  {
    if (paramView.getId() == 2131428584)
    {
      this.o = true;
      f();
      this.c.a();
      return;
    }
    if (paramView.getId() == 2131428579)
    {
      this.o = false;
      f();
      return;
    }
    if (paramView.getId() == 2131428587) {
      k();
    }
  }
  
  public void a(d paramd)
  {
    this.b = paramd.ai();
    if ((getParent() instanceof ViewGroup)) {
      ((ViewGroup)getParent()).removeView(this);
    }
    paramd.a(this);
    c();
    postDelayed(new m.1(this), 100L);
  }
  
  public void a(String paramString)
  {
    if (af.c(paramString)) {
      return;
    }
    t.a(new m.9(this, paramString));
  }
  
  public void b()
  {
    t.a(new m.2(this));
  }
  
  public void bringToFront()
  {
    if (this.b == null) {
      o.c("MicroMsg.RemoteDebugView", "bringToFront mContentView is null");
    }
  }
  
  public void c()
  {
    this.c = ((RemoteDebugMoveView)LayoutInflater.from(getContext()).inflate(2131624224, null));
    this.f = ((TextView)this.c.findViewById(2131428581));
    this.e = ((TextView)this.c.findViewById(2131428590));
    this.g = ((TextView)this.c.findViewById(2131428585));
    this.h = ((TextView)this.c.findViewById(2131428587));
    this.i = ((TextView)this.c.findViewById(2131428584));
    this.j = ((TextView)this.c.findViewById(2131428579));
    this.k = ((TextView)this.c.findViewById(2131428583));
    this.m = ((ImageView)this.c.findViewById(2131428580));
    this.l = ((ImageView)this.c.findViewById(2131428588));
    this.n = this.c.findViewById(2131428582);
    f();
    d();
  }
  
  public void d()
  {
    this.i.setOnClickListener(this.r);
    this.j.setOnClickListener(this.r);
    this.h.setOnClickListener(this.r);
  }
  
  public void e()
  {
    t.a(new m.5(this));
  }
  
  public void f()
  {
    if (this.o)
    {
      this.n.setVisibility(0);
      if (this.d.size() > 0) {
        this.k.setVisibility(0);
      } else {
        this.k.setVisibility(8);
      }
      this.i.setVisibility(8);
    }
    else
    {
      this.n.setVisibility(8);
      this.k.setVisibility(8);
      this.i.setVisibility(0);
    }
    invalidate();
  }
  
  public void g()
  {
    h();
    t.a(new m.6(this));
  }
  
  public void h()
  {
    b();
    e();
  }
  
  public void i()
  {
    t.a(new m.7(this));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (j()) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.m
 * JD-Core Version:    0.7.0.1
 */