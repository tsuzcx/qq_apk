package com.tencent.luggage.wxa.pp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.pu.b;
import com.tencent.luggage.wxa.qz.o;

public final class v
  extends LinearLayout
  implements ad
{
  private static final int a = 2131428536;
  private static com.tencent.luggage.wxa.nj.a h;
  private static boolean i = false;
  private View b;
  private boolean c = false;
  private v.a d;
  private w e;
  private EditText f;
  private View g;
  
  public v(Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  public static v a(View paramView)
  {
    return (v)paramView.getRootView().findViewById(a);
  }
  
  public static v a(View paramView, com.tencent.luggage.wxa.nj.a parama)
  {
    if (h != parama)
    {
      o.e("MicroMsg.AppBrandNumberKeyboardPanel", "mComponentView != componentView so we set mComponentView = componentView;");
      h = parama;
    }
    Object localObject = a(paramView);
    parama = (com.tencent.luggage.wxa.nj.a)localObject;
    if (localObject == null)
    {
      localObject = n.a(paramView);
      if (localObject == null) {
        return null;
      }
      parama = new v(paramView.getContext());
      ((n)localObject).a(parama, false);
    }
    return parama;
  }
  
  private void e()
  {
    if (!this.c)
    {
      v.a locala = this.d;
      if (locala != null)
      {
        this.c = true;
        locala.a();
        this.c = false;
      }
    }
  }
  
  private void f()
  {
    o.e("MicroMsg.AppBrandNumberKeyboardPanel", "init");
    super.setId(a);
    setOrientation(1);
    setBackgroundColor(-1);
    if (i)
    {
      this.g = h;
      localObject = this.g;
      if (localObject != null)
      {
        localObject = (ViewGroup)((View)localObject).getParent();
        if (localObject != null)
        {
          o.d("MicroMsg.AppBrandNumberKeyboardPanel", "toolbar is already exsited in a layout,the class of the parent is %s  the id is : %d", new Object[] { localObject.getClass().toString(), Integer.valueOf(((ViewGroup)localObject).getId()) });
          ((ViewGroup)localObject).removeView(this.g);
        }
      }
      addView(this.g);
    }
    Object localObject = new ViewGroup.LayoutParams(-1, com.tencent.luggage.wxa.qx.a.e(getContext(), 30));
    addView(g(), (ViewGroup.LayoutParams)localObject);
    localObject = new ViewGroup.LayoutParams(-1, com.tencent.luggage.wxa.qx.a.e(getContext(), 240));
    w localw = new w(getContext());
    this.e = localw;
    addView(localw, (ViewGroup.LayoutParams)localObject);
  }
  
  private View g()
  {
    this.b = LayoutInflater.from(getContext()).inflate(2131624244, null);
    this.b.setOnClickListener(new v.1(this));
    return this.b;
  }
  
  private void h()
  {
    EditText localEditText = this.f;
    if (localEditText != null)
    {
      localEditText.clearFocus();
      this.f = null;
      this.d = null;
      this.c = false;
    }
  }
  
  public <_Input extends EditText,  extends b> void a(_Input param_Input)
  {
    if (param_Input == null) {
      return;
    }
    if (this.f != param_Input) {
      h();
    }
    setInputEditText(param_Input);
    setVisibility(0);
  }
  
  public boolean a()
  {
    return ViewCompat.isLaidOut(this);
  }
  
  public void b()
  {
    this.b.setBackgroundResource(2131165228);
    this.b.findViewById(2131432003).setBackgroundResource(2131165352);
    this.b.findViewById(2131430131).setBackgroundResource(2131165352);
    this.e.a();
  }
  
  public void b(View paramView)
  {
    if (paramView != null)
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(paramView);
      }
    }
  }
  
  public void c()
  {
    if ((i) && (this.g == null))
    {
      this.g = h;
      b(this.g);
      addView(this.g, 0);
    }
    View localView;
    if (i)
    {
      localView = this.g;
      if (localView != h)
      {
        b(localView);
        this.g = h;
        b(this.g);
        addView(this.g, 0);
        o.e("MicroMsg.AppBrandNumberKeyboardPanel", "toolbar is changed in updateToolbar() because toolbar != mComponentView");
      }
    }
    if ((i) && (this.g.getParent() != this))
    {
      b(this.g);
      addView(this.g, 0);
    }
    if (!i)
    {
      localView = this.g;
      if ((localView != null) && (localView.getParent() == this)) {
        removeView(this.g);
      }
    }
  }
  
  public void d()
  {
    setVisibility(8);
    h();
  }
  
  public EditText getAttachedEditText()
  {
    return this.f;
  }
  
  public int getPanelHeight()
  {
    return com.tencent.luggage.wxa.qx.a.e(getContext(), 270);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeAllViews();
  }
  
  public void setComponentView(boolean paramBoolean)
  {
    i = paramBoolean;
  }
  
  public void setId(int paramInt) {}
  
  public <_Input extends EditText,  extends b> void setInputEditText(_Input param_Input)
  {
    this.f = param_Input;
    this.e.a((b)param_Input);
  }
  
  public void setOnDoneListener(v.a parama)
  {
    this.d = parama;
  }
  
  public void setVisibility(int paramInt)
  {
    if ((getVisibility() == paramInt) && ((getVisibility() == 0) || (getVisibility() == 8))) {
      return;
    }
    if (paramInt != 0)
    {
      super.setVisibility(8);
      e();
      return;
    }
    super.setVisibility(paramInt);
  }
  
  public void setXMode(int paramInt)
  {
    this.e.setXMode(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.v
 * JD-Core Version:    0.7.0.1
 */