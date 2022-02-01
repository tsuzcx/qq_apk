package com.tencent.luggage.wxa.iu;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.UiThread;
import com.tencent.mm.plugin.appbrand.widget.f;

 enum z
{
  private static int h = 2131428592;
  
  private z() {}
  
  private int a(d paramd)
  {
    paramd = paramd.b;
    if (ordinal() >= paramd.getChildCount())
    {
      int j = paramd.getChildCount() - 1;
      while (j >= 0)
      {
        int k = ((Integer)paramd.getChildAt(j).getTag(h)).intValue();
        if (ordinal() < k) {
          return j;
        }
        j -= 1;
      }
    }
    return Math.min(ordinal(), paramd.getChildCount());
  }
  
  @UiThread
  void a(d paramd, View paramView)
  {
    Object localObject = (Integer)paramView.getTag(h);
    if ((localObject != null) && (ordinal() != ((Integer)localObject).intValue()))
    {
      paramd = new StringBuilder();
      paramd.append("Child has already been added with index ");
      paramd.append(localObject);
      throw new IllegalStateException(paramd.toString());
    }
    paramView.setTag(h, Integer.valueOf(ordinal()));
    localObject = paramd.b;
    int j = a(paramd);
    if ((paramView.getParent() == localObject) && (j >= ((f)localObject).getChildCount() - 1))
    {
      ((f)localObject).bringChildToFront(paramView);
      return;
    }
    if (paramView.getParent() != null) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    ((f)localObject).addView(paramView, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.z
 * JD-Core Version:    0.7.0.1
 */