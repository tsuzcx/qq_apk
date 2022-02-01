package com.tencent.luggage.wxa.ik;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.wxa.qx.a;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/msgsubscription/util/SubscribeMsgTemplateViewHelper;", "", "()V", "createTemplateItemView", "Landroid/view/View;", "context", "Landroid/content/Context;", "index", "", "size", "key", "", "value", "topMargin", "createTemplateView", "keyWordList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public final class c
{
  public static final c a = new c();
  
  private final View a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3)
  {
    View localView1 = LayoutInflater.from(paramContext).inflate(2131629349, null, false);
    View localView2 = localView1.findViewById(2131436780);
    Intrinsics.checkExpressionValueIsNotNull(localView2, "templateItem.findViewById<TextView>(R.id.key)");
    ((TextView)localView2).setText((CharSequence)paramString1);
    paramString1 = localView1.findViewById(2131449323);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "templateItem.findViewById<TextView>(R.id.value)");
    ((TextView)paramString1).setText((CharSequence)paramString2);
    paramString1 = new LinearLayout.LayoutParams(-1, -2);
    if (paramInt1 != paramInt2 - 1) {
      paramString1.bottomMargin = paramContext.getResources().getDimensionPixelSize(2131296368);
    }
    if (paramInt1 == 0) {
      paramString1.topMargin = paramInt3;
    }
    Intrinsics.checkExpressionValueIsNotNull(localView1, "templateItem");
    localView1.setLayoutParams((ViewGroup.LayoutParams)paramString1);
    return localView1;
  }
  
  @NotNull
  public final View a(@NotNull Context paramContext, @NotNull ArrayList<Pair<String, String>> paramArrayList, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramArrayList, "keyWordList");
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setPadding(a.e(paramContext, 25), 0, 0, 0);
    localLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      Object localObject2 = (Pair)localObject1;
      localObject1 = (String)((Pair)localObject2).getFirst();
      localObject2 = (String)((Pair)localObject2).getSecond();
      localLinearLayout.addView(a.a(paramContext, i, paramArrayList.size(), (String)localObject1, (String)localObject2, paramInt));
      i += 1;
    }
    return (View)localLinearLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ik.c
 * JD-Core Version:    0.7.0.1
 */