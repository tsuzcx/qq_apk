package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "(Ljava/util/List;)V", "itemCheckedListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;)V", "getItems", "()Ljava/util/List;", "setItems", "onListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "getOnListItemLongClickListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "setOnListItemLongClickListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Item", "ItemCheckedListener", "OnListItemLongClickListener", "ViewHolder", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class n
  extends RecyclerView.Adapter<n.d>
{
  @Nullable
  private n.b a;
  @Nullable
  private n.c b;
  @NotNull
  private List<n.a> c;
  
  public n(@NotNull List<n.a> paramList)
  {
    this.c = paramList;
  }
  
  @Nullable
  public final n.b a()
  {
    return this.a;
  }
  
  @NotNull
  public n.d a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624215, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "v");
    return new n.d(paramViewGroup, this.c, this);
  }
  
  public final void a(@Nullable n.b paramb)
  {
    this.a = paramb;
  }
  
  public void a(@NotNull n.d paramd, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "holder");
    n.a locala = (n.a)this.c.get(paramInt);
    if (locala != null) {
      paramd.a(locala, paramInt, (Function1)new n.e(this, paramd, paramInt));
    }
  }
  
  @Nullable
  public final n.c b()
  {
    return this.b;
  }
  
  @NotNull
  public final List<n.a> c()
  {
    return this.c;
  }
  
  public int getItemCount()
  {
    return this.c.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.n
 * JD-Core Version:    0.7.0.1
 */