package com.tencent.luggage.setting.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/setting/ui/WxaUserInfoListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/luggage/setting/ui/WxaUserInfoListAdapter$ViewHolder;", "items", "", "Lcom/tencent/luggage/setting/ui/WxaUserInfoListAdapter$Item;", "(Ljava/util/List;)V", "itemCheckedListener", "Lcom/tencent/luggage/setting/ui/WxaUserInfoListAdapter$ItemCheckedListener;", "getItemCheckedListener", "()Lcom/tencent/luggage/setting/ui/WxaUserInfoListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/luggage/setting/ui/WxaUserInfoListAdapter$ItemCheckedListener;)V", "getItems", "()Ljava/util/List;", "setItems", "value", "Lcom/tencent/luggage/setting/ui/WxaUserInfoListAdapter$OnListItemLongClickListener;", "onListItemLongClickListener", "getOnListItemLongClickListener", "()Lcom/tencent/luggage/setting/ui/WxaUserInfoListAdapter$OnListItemLongClickListener;", "setOnListItemLongClickListener", "(Lcom/tencent/luggage/setting/ui/WxaUserInfoListAdapter$OnListItemLongClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Item", "ItemCheckedListener", "OnListItemLongClickListener", "ViewHolder", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a
  extends RecyclerView.Adapter<a.d>
{
  @Nullable
  private a.b a;
  @Nullable
  private a.c b;
  @NotNull
  private List<a.a> c;
  
  public a(@NotNull List<a.a> paramList)
  {
    this.c = paramList;
  }
  
  @Nullable
  public final a.b a()
  {
    return this.a;
  }
  
  @NotNull
  public a.d a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624215, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "v");
    return new a.d(paramViewGroup, this.c, this);
  }
  
  public final void a(@Nullable a.b paramb)
  {
    this.a = paramb;
  }
  
  public final void a(@Nullable a.c paramc)
  {
    this.b = paramc;
  }
  
  public void a(@NotNull a.d paramd, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "holder");
    a.a locala = (a.a)this.c.get(paramInt);
    if (locala != null) {
      paramd.a(locala, paramInt, (Function1)new a.e(this, paramd, paramInt));
    }
  }
  
  @Nullable
  public final a.c b()
  {
    return this.b;
  }
  
  public int getItemCount()
  {
    return this.c.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.a
 * JD-Core Version:    0.7.0.1
 */