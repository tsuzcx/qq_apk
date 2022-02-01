package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter$ViewHolder;", "appId", "", "context", "Landroid/content/Context;", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Landroid/content/Context;Ljava/util/ArrayList;)V", "getAppId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "resetPhoneItems", "ViewHolder", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class q
  extends RecyclerView.Adapter<q.a>
{
  @NotNull
  private final String a;
  @NotNull
  private final Context b;
  @NotNull
  private ArrayList<r> c;
  
  public q(@NotNull String paramString, @NotNull Context paramContext, @NotNull ArrayList<r> paramArrayList)
  {
    this.a = paramString;
    this.b = paramContext;
    this.c = paramArrayList;
  }
  
  private final void c()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((r)localIterator.next()).b(false);
    }
  }
  
  @NotNull
  public final Context a()
  {
    return this.b;
  }
  
  @NotNull
  public q.a a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624218, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "v");
    return new q.a(this, paramViewGroup);
  }
  
  public void a(@NotNull q.a parama, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(parama, "holder");
    Object localObject = this.c.get(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "phoneItems[position]");
    localObject = (r)localObject;
    if (localObject != null) {
      parama.a((r)localObject);
    }
    parama.itemView.setOnClickListener((View.OnClickListener)new q.b(this, (r)localObject));
  }
  
  @NotNull
  public final ArrayList<r> b()
  {
    return this.c;
  }
  
  public int getItemCount()
  {
    return this.c.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.q
 * JD-Core Version:    0.7.0.1
 */