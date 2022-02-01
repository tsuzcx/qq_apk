package com.tencent.luggage.wxa.bp;

import com.tencent.luggage.wxa.du.c;
import com.tencent.magicbrush.ui.i.g;

class a$e
  implements i.g
{
  private a$e(a parama) {}
  
  public void a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMainCanvasTypeDefined received invalid input [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    if ((!((c)this.a.y()).C()) && (!((c)this.a.y()).d())) {
      return;
    }
    this.a.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bp.a.e
 * JD-Core Version:    0.7.0.1
 */