package com.tencent.luggage.setting.ui;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "changed", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "invoke", "com/tencent/luggage/setting/ui/WxaUserInfoListAdapter$onBindViewHolder$1$1"}, k=3, mv={1, 1, 16})
final class a$e
  extends Lambda
  implements Function1<ArrayList<Integer>, Unit>
{
  a$e(a parama, a.d paramd, int paramInt)
  {
    super(1);
  }
  
  public final void a(@NotNull ArrayList<Integer> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "changed");
    paramArrayList = ((Iterable)paramArrayList).iterator();
    while (paramArrayList.hasNext())
    {
      int i = ((Number)paramArrayList.next()).intValue();
      this.a.notifyItemChanged(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.a.e
 * JD-Core Version:    0.7.0.1
 */