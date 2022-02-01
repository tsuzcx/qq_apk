package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter$ViewHolder;", "context", "Landroid/content/Context;", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "onPhoneItemRemove", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "phoneItem", "", "(Landroid/content/Context;Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;)V", "getContext", "()Landroid/content/Context;", "getOnPhoneItemRemove", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemRemove", "(Lkotlin/jvm/functions/Function1;)V", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "showDelete", "", "getShowDelete", "()Z", "setShowDelete", "(Z)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updatePhoneItems", "", "ViewHolder", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class j
  extends RecyclerView.Adapter<j.a>
{
  private boolean a;
  @NotNull
  private final Context b;
  @NotNull
  private ArrayList<r> c;
  @NotNull
  private Function1<? super r, Unit> d;
  
  public j(@NotNull Context paramContext, @NotNull ArrayList<r> paramArrayList, @NotNull Function1<? super r, Unit> paramFunction1)
  {
    this.b = paramContext;
    this.c = paramArrayList;
    this.d = paramFunction1;
  }
  
  @NotNull
  public j.a a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624218, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "v");
    return new j.a(this, paramViewGroup);
  }
  
  public void a(@NotNull j.a parama, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(parama, "holder");
    Object localObject = this.c.get(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "phoneItems[position]");
    localObject = (r)localObject;
    if (localObject != null) {
      parama.a((r)localObject);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public final void a(boolean paramBoolean, @NotNull List<r> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "phoneItems");
    this.a = paramBoolean;
    this.c = ((ArrayList)paramList);
    notifyDataSetChanged();
  }
  
  public final boolean a()
  {
    return this.a;
  }
  
  @NotNull
  public final Context b()
  {
    return this.b;
  }
  
  @NotNull
  public final Function1<r, Unit> c()
  {
    return this.d;
  }
  
  public int getItemCount()
  {
    return this.c.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.j
 * JD-Core Version:    0.7.0.1
 */