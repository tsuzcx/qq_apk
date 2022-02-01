package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.cy.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "DELIVER", "interrupt", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class b$b<T>
  implements e.a<Object>
{
  b$b(b paramb, com.tencent.luggage.wxa.ro.b paramb1, Object paramObject) {}
  
  public final void a(Object paramObject)
  {
    if ((paramObject instanceof a))
    {
      localObject = (a)paramObject;
      int i = ((a)localObject).a();
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              if (i != 6) {
                b.a(this.a, this.c, t.d.f, t.c.d, ((a)localObject).getMessage());
              } else {
                b.a(this.a, this.c, t.d.f, t.c.d, "ERR_MISS_DATA");
              }
            }
            else {
              b.a(this.a, this.c, t.d.f, t.c.d, "ERR_NO_DEVCODE");
            }
          }
          else {
            b.a(this.a, this.c, t.d.f, t.c.d, "ERR_NO_PERMISSION");
          }
        }
        else {
          b.a(this.a, this.c, t.d.f, t.c.d, "ERR_INVALID_APPID");
        }
      }
      else {
        this.b.a(new Object[] { this.c });
      }
      this.b.a(paramObject);
      return;
    }
    if ((paramObject instanceof Throwable)) {
      paramObject = ((Throwable)paramObject).getMessage();
    } else if (paramObject != null) {
      paramObject = paramObject.toString();
    } else {
      paramObject = null;
    }
    Object localObject = b.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInterrupt ");
    localStringBuilder.append(paramObject);
    o.b((String)localObject, localStringBuilder.toString());
    b.a(this.a, this.c, t.d.f, t.c.d, paramObject);
    this.b.a(new a(1, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.b.b
 * JD-Core Version:    0.7.0.1
 */