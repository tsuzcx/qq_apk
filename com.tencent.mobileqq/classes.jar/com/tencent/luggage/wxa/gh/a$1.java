package com.tencent.luggage.wxa.gh;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.y;
import com.tencent.luggage.wxa.pp.u.c;
import com.tencent.luggage.wxa.pp.x;
import com.tencent.mm.plugin.appbrand.page.ag;

class a$1
  implements u.c
{
  private final y b = new y();
  private int c = 0;
  
  a$1(a parama) {}
  
  public void a(int paramInt)
  {
    this.c = paramInt;
    x localx = a.a(this.a);
    if (localx != null) {
      localx.a(paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = a.b(this.a).a();
    c localc = a.b(this.a).b();
    int i;
    if (localObject != null)
    {
      y localy = this.b;
      if (paramBoolean) {
        i = this.a.getToolBarHeight(this.c);
      } else {
        i = 0;
      }
      localy.a(i, localc, (c)localObject);
    }
    localObject = a.a(this.a);
    if (localObject != null)
    {
      if (paramBoolean) {
        i = this.c;
      } else {
        i = 0;
      }
      ((x)localObject).a(i);
    }
    localObject = this.a;
    if (paramBoolean) {
      i = this.c;
    } else {
      i = 0;
    }
    ((a)localObject).onKeyboardHeightChanged(paramBoolean, i, false);
  }
  
  public int getHeight()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gh.a.1
 * JD-Core Version:    0.7.0.1
 */