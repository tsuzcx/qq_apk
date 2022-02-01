package com.tencent.luggage.wxa.bi;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.luggage.wxa.cy.b;
import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.dg.d;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

class a$1$1
  implements Runnable
{
  a$1$1(a.1 param1, Object paramObject) {}
  
  public void run()
  {
    Object localObject = this.a;
    boolean bool = localObject instanceof b;
    String str = "";
    if (bool)
    {
      int i = ((b)localObject).a();
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 4) {
              str = this.b.b.s().g().getApplicationContext().getResources().getString(2131886781);
            }
          }
          else {
            str = this.b.b.s().g().getApplicationContext().getResources().getString(2131886782);
          }
        }
        else {
          str = this.b.b.s().g().getApplicationContext().getResources().getString(2131886839);
        }
      }
      else {
        str = this.b.b.s().g().getApplicationContext().getResources().getString(2131886779);
      }
      if (!af.c(str))
      {
        Toast.makeText(this.b.b.s().g().getApplicationContext(), str, 0).show();
        o.b("Luggage.AppBrandRuntimeContainerStandaloneImpl", "DemoInfoError: errMsg:%s hasLogin:%b hasActivateDevice:%b", new Object[] { str, Boolean.valueOf(i.a.g()), Boolean.valueOf(d.a.g()) });
      }
    }
    else if ((localObject instanceof com.tencent.luggage.wxa.cy.a))
    {
      switch (((com.tencent.luggage.wxa.cy.a)localObject).a())
      {
      default: 
        break;
      case 7: 
        str = this.b.b.s().g().getApplicationContext().getResources().getString(2131886838);
        break;
      case 6: 
        str = this.b.b.s().g().getApplicationContext().getResources().getString(2131886838);
        break;
      case 5: 
        str = this.b.b.s().g().getApplicationContext().getResources().getString(2131886835);
        break;
      case 4: 
        str = this.b.b.s().g().getApplicationContext().getResources().getString(2131886837);
        break;
      case 3: 
        str = this.b.b.s().g().getApplicationContext().getResources().getString(2131886833);
        break;
      case 2: 
        str = this.b.b.s().g().getApplicationContext().getResources().getString(2131886836);
        break;
      case 1: 
        str = this.b.b.s().g().getApplicationContext().getResources().getString(2131886834);
      }
      if (!af.c(str))
      {
        Toast.makeText(this.b.b.s().g().getApplicationContext(), str, 0).show();
        o.b("Luggage.AppBrandRuntimeContainerStandaloneImpl", "DebugPkgInfoError: errMsg:%s hasLogin:%b hasActivateDevice:%b", new Object[] { str, Boolean.valueOf(i.a.g()), Boolean.valueOf(d.a.g()) });
      }
    }
    else if ((localObject instanceof String))
    {
      str = (String)localObject;
      o.b("Luggage.AppBrandRuntimeContainerStandaloneImpl", "Error Loading WxaAttrs, errMsg:%s hasLogin:%b hasActivateDevice:%b", new Object[] { str, Boolean.valueOf(i.a.g()), Boolean.valueOf(d.a.g()) });
      localObject = this.b.b.s().g().getApplicationContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error Loading WxaAttrs:");
      localStringBuilder.append(str);
      Toast.makeText((Context)localObject, localStringBuilder.toString(), 0).show();
    }
    else
    {
      o.b("Luggage.AppBrandRuntimeContainerStandaloneImpl", "Error Loading WxaAttrs, hasLogin:%b hasActivateDevice:%b", new Object[] { Boolean.valueOf(i.a.g()), Boolean.valueOf(d.a.g()) });
      Toast.makeText(this.b.b.s().g().getApplicationContext(), "Error Loading WxaAttrs", 0).show();
    }
    if (!this.b.b.g()) {
      a.a(this.b.b, true, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bi.a.1.1
 * JD-Core Version:    0.7.0.1
 */