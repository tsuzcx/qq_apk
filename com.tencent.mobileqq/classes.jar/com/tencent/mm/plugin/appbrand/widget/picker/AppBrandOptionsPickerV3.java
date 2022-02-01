package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.ip.a;
import com.tencent.luggage.wxa.it.b;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.Arrays;

public class AppBrandOptionsPickerV3
  implements com.tencent.luggage.wxa.lo.c<String>
{
  private String[] a;
  private b<String> b;
  private Context c;
  private int d;
  private int e;
  
  @Keep
  public AppBrandOptionsPickerV3(Context paramContext)
  {
    this.c = paramContext;
    this.b = new b(paramContext);
  }
  
  private void d(int paramInt)
  {
    this.b.d.c(paramInt);
  }
  
  public void a()
  {
    new a(this.c, new AppBrandOptionsPickerV3.1(this)).b(this.e).a(ContextCompat.getColor(this.c, 2131165199)).a(this.b);
    a(this.c.getResources().getDimensionPixelSize(2131296955));
    c(this.c.getResources().getDimensionPixelSize(2131298211));
    d(ContextCompat.getColor(this.c, 2131165199));
    this.b.d.a(0, this.c.getResources().getDimensionPixelSize(2131296336), 0, this.c.getResources().getDimensionPixelSize(2131296336));
    this.b.d.c().b(ContextCompat.getColor(this.c, 2131165207)).a(this.c.getResources().getDimensionPixelSize(2131296336)).setBackgroundColor(ContextCompat.getColor(this.c, 2131165193));
  }
  
  public void a(float paramFloat)
  {
    this.b.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(com.tencent.luggage.wxa.ir.c paramc)
  {
    this.b.a(paramc);
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.a = paramArrayOfString;
    this.b.a(Arrays.asList(paramArrayOfString));
  }
  
  public int b()
  {
    this.b.i();
    return this.d;
  }
  
  public void b(int paramInt)
  {
    this.b.j().setCurrentItem(paramInt);
  }
  
  public int c()
  {
    return b();
  }
  
  public void c(int paramInt)
  {
    this.b.b(paramInt);
  }
  
  public String d()
  {
    this.b.i();
    return this.a[this.d];
  }
  
  public WheelView e()
  {
    return this.b.j();
  }
  
  public void onAttach(d paramd) {}
  
  public void onDetach(d paramd) {}
  
  public void onHide(d paramd) {}
  
  public void onShow(d paramd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV3
 * JD-Core Version:    0.7.0.1
 */