package com.tencent.luggage.wxa.ng;

import com.tencent.luggage.wxa.jo.b;
import com.tencent.luggage.wxa.jo.c;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class j$a
  extends ObservableProperty<c>
{
  public j$a(Object paramObject1, Object paramObject2, j paramj)
  {
    super(paramObject2);
  }
  
  protected void afterChange(@NotNull KProperty<?> paramKProperty, c paramc1, c paramc2)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    paramKProperty = (c)paramc2;
    if (((Intrinsics.areEqual((c)paramc1, paramKProperty) ^ true)) && (paramKProperty.a() != null))
    {
      k.b(paramKProperty);
      paramc2 = ((Iterable)this.b.b()).iterator();
      e locale;
      for (;;)
      {
        boolean bool = paramc2.hasNext();
        paramc1 = null;
        if (!bool) {
          break;
        }
        locale = (e)paramc2.next();
        locale.a(false);
        locale.c(false);
        paramKProperty = locale.d().a();
        if (paramKProperty != null) {
          paramKProperty = paramKProperty.j;
        } else {
          paramKProperty = null;
        }
        b localb = this.b.a().a();
        if (localb != null) {
          paramc1 = localb.j;
        }
        if (Intrinsics.areEqual(paramKProperty, paramc1))
        {
          locale.c(true);
          locale.b(false);
          locale.a(true);
        }
      }
      paramc2 = ((Iterable)this.b.c()).iterator();
      while (paramc2.hasNext())
      {
        locale = (e)paramc2.next();
        locale.a(false);
        locale.c(false);
        paramKProperty = locale.d().a();
        if (paramKProperty != null) {
          paramKProperty = paramKProperty.j;
        } else {
          paramKProperty = null;
        }
        paramc1 = this.b.a().a();
        if (paramc1 != null) {
          paramc1 = paramc1.j;
        } else {
          paramc1 = null;
        }
        if (Intrinsics.areEqual(paramKProperty, paramc1))
        {
          locale.c(true);
          locale.b(false);
          locale.a(true);
        }
      }
      paramKProperty = this.b.d();
      if (paramKProperty != null) {
        paramKProperty = (Unit)paramKProperty.invoke();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.j.a
 * JD-Core Version:    0.7.0.1
 */