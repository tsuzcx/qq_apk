package com.tencent.luggage.wxa.eg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.luggage.wxa.ih.d;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/setting/adapter/SubscribeMsgListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/luggage/setting/adapter/SubscribeMsgListAdapter$SubscribeMsgListItemViewHolder;", "context", "Landroid/content/Context;", "listener", "Lcom/tencent/luggage/setting/adapter/SubscribeMsgListAdapter$CheckBoxStateChangedListener;", "(Landroid/content/Context;Lcom/tencent/luggage/setting/adapter/SubscribeMsgListAdapter$CheckBoxStateChangedListener;)V", "value", "", "exampleTitle", "getExampleTitle", "()Ljava/lang/String;", "setExampleTitle", "(Ljava/lang/String;)V", "mList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/ArrayList;", "fillInfoIcon", "", "holder", "item", "position", "", "fillSubscribeCheckBox", "filling", "getItem", "getItemCount", "getList", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setList", "list", "CheckBoxStateChangedListener", "Companion", "SubscribeMsgListItemViewHolder", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a
  extends RecyclerView.Adapter<a.c>
{
  public static final a.b a = new a.b(null);
  private ArrayList<d> b;
  @NotNull
  private String c;
  private final Context d;
  private final a.a e;
  
  public a(@NotNull Context paramContext, @NotNull a.a parama)
  {
    this.d = paramContext;
    this.e = parama;
    this.b = new ArrayList();
    this.c = "";
  }
  
  private final d a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return (d)this.b.get(paramInt);
    }
    return null;
  }
  
  private final void a(a.c paramc, d paramd, int paramInt)
  {
    Object localObject = paramc.d();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "holder.topLine");
    int i;
    if (paramInt == 0) {
      i = 8;
    } else {
      i = 0;
    }
    ((View)localObject).setVisibility(i);
    localObject = paramc.b();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "holder.title");
    ((TextView)localObject).setText((CharSequence)paramd.b());
    b(paramc, paramd, paramInt);
    c(paramc, paramd, paramInt);
  }
  
  private final void b(a.c paramc, d paramd, int paramInt)
  {
    CheckBox localCheckBox = paramc.a();
    Intrinsics.checkExpressionValueIsNotNull(localCheckBox, "holder.checkBox");
    localCheckBox.setChecked(this.e.a(paramd));
    paramc.itemView.setOnClickListener((View.OnClickListener)new a.e(this, paramc, paramd));
  }
  
  private final void c(a.c paramc, d paramd, int paramInt)
  {
    paramc.c().setOnClickListener((View.OnClickListener)new a.d(this, paramd));
  }
  
  @NotNull
  public a.c a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(this.d).inflate(2131629346, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "view");
    return new a.c(paramViewGroup);
  }
  
  @NotNull
  public final String a()
  {
    return this.c;
  }
  
  public void a(@NotNull a.c paramc, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "holder");
    d locald = a(paramInt);
    if (locald != null)
    {
      o.d("Mp.SubscribeMsgListAdapter", "alvinluo onBindViewHolder item: %s", new Object[] { locald.toString() });
      a(paramc, locald, paramInt);
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.c = paramString;
  }
  
  public final void a(@NotNull ArrayList<d> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "list");
    this.b.clear();
    this.b.addAll((Collection)paramArrayList);
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eg.a
 * JD-Core Version:    0.7.0.1
 */