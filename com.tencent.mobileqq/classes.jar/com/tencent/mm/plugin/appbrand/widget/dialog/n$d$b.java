package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class n$d$b
  implements View.OnClickListener
{
  n$d$b(n.d paramd, n.a parama, int paramInt, Function1 paramFunction1) {}
  
  public final void onClick(View paramView)
  {
    this.b.a(true);
    n.d.a(this.a, this.b.e(), this.b);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)this.a.b()).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject = (n.a)localObject;
      localArrayList.add(Integer.valueOf(i));
      if ((this.c != i) && (localObject != null) && (((n.a)localObject).e() == true))
      {
        ((n.a)localObject).a(false);
        localArrayList.add(Integer.valueOf(this.c));
      }
      i += 1;
    }
    this.d.invoke(localArrayList);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.n.d.b
 * JD-Core Version:    0.7.0.1
 */