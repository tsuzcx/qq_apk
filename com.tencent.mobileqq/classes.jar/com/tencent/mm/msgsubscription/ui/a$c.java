package com.tencent.mm.msgsubscription.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$Holder;", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "dialog", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "(Ljava/util/List;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "itemsChecked", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Holder", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public final class a$c
  extends RecyclerView.Adapter<a.c.a>
{
  private final List<a.b> a;
  @NotNull
  private List<a.b> b;
  private final a c;
  
  public a$c(@NotNull List<a.b> paramList, @NotNull a parama)
  {
    this.b = paramList;
    this.c = parama;
    this.a = ((List)new ArrayList());
    paramList = this.a;
    Object localObject1 = (Iterable)this.b;
    parama = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((a.b)localObject2).a()) {
        parama.add(localObject2);
      }
    }
    paramList.addAll((Collection)parama);
    a.a(this.c, this.a.size());
  }
  
  @NotNull
  public a.c.a a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131629345, null);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "LayoutInflater.from(pare…be_msg_item_layout, null)");
    return new a.c.a(paramViewGroup);
  }
  
  @NotNull
  public final List<a.b> a()
  {
    return this.b;
  }
  
  public void a(@NotNull a.c.a parama, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(parama, "holder");
    parama.a().setChecked(((a.b)this.b.get(paramInt)).a());
    parama.b().setText((CharSequence)((a.b)this.b.get(paramInt)).b());
    parama.c().setOnClickListener((View.OnClickListener)new a.c.b(this, paramInt));
    parama.itemView.setOnClickListener((View.OnClickListener)new a.c.c(this, parama, paramInt));
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.a.c
 * JD-Core Version:    0.7.0.1
 */