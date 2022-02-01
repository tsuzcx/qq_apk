package com.tencent.luggage.wxa.op;

import androidx.annotation.NonNull;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.o.i;
import java.util.Map;

class f$2
  implements o.i
{
  f$2(f paramf) {}
  
  public void a(@NonNull m paramm)
  {
    Object localObject1 = f.a(this.a);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onPageDestroy, page: ");
    ((StringBuilder)localObject2).append(f.a(paramm));
    com.tencent.luggage.wxa.qz.o.d((String)localObject1, ((StringBuilder)localObject2).toString());
    if (!paramm.s())
    {
      localObject1 = paramm.getCurrentPageView();
      localObject2 = f.a(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageDestroy, remove ");
      localStringBuilder.append(localObject1);
      localStringBuilder.append(" from mPageView2PageScopedPipInfoMap");
      com.tencent.luggage.wxa.qz.o.d((String)localObject2, localStringBuilder.toString());
      f.p(this.a).remove(Integer.valueOf(localObject1.hashCode()));
    }
    else
    {
      localObject1 = f.a(this.a);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onPageDestroy, ");
      ((StringBuilder)localObject2).append(f.a(paramm));
      ((StringBuilder)localObject2).append(" is PipVideoRelated");
      com.tencent.luggage.wxa.qz.o.d((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    if (f.h(this.a) == null) {
      return;
    }
    if (paramm == f.h(this.a))
    {
      f.d(this.a, false);
      f.i(this.a).setPipVideoRelatedPage(f.h(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.f.2
 * JD-Core Version:    0.7.0.1
 */