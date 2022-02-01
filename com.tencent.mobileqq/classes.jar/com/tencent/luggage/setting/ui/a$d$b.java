package com.tencent.luggage.setting.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class a$d$b
  implements View.OnClickListener
{
  a$d$b(a.d paramd, a.a parama, int paramInt, Function1 paramFunction1) {}
  
  public final void onClick(View paramView)
  {
    this.b.a(true);
    a.d.a(this.a, this.b.d(), this.b);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)this.a.b()).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject = (a.a)localObject;
      localArrayList.add(Integer.valueOf(i));
      if ((this.c != i) && (localObject != null) && (((a.a)localObject).d() == true))
      {
        ((a.a)localObject).a(false);
        localArrayList.add(Integer.valueOf(this.c));
      }
      i += 1;
    }
    this.d.invoke(localArrayList);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.a.d.b
 * JD-Core Version:    0.7.0.1
 */