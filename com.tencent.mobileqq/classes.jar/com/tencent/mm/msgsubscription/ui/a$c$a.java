package com.tencent.mm.msgsubscription.ui;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "desc", "Landroid/widget/TextView;", "getDesc", "()Landroid/widget/TextView;", "setDesc", "(Landroid/widget/TextView;)V", "sample", "getSample", "()Landroid/view/View;", "setSample", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public final class a$c$a
  extends RecyclerView.ViewHolder
{
  @NotNull
  private CheckBox a;
  @NotNull
  private TextView b;
  @NotNull
  private View c;
  
  public a$c$a(@NotNull View paramView)
  {
    super(paramView);
    paramView = this.itemView.findViewById(2131430688);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "itemView.findViewById(R.id.checkbox)");
    this.a = ((CheckBox)paramView);
    paramView = this.itemView.findViewById(2131431733);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "itemView.findViewById(R.id.desc)");
    this.b = ((TextView)paramView);
    paramView = this.itemView.findViewById(2131445224);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "itemView.findViewById(R.id.sample)");
    this.c = paramView;
  }
  
  @NotNull
  public final CheckBox a()
  {
    return this.a;
  }
  
  @NotNull
  public final TextView b()
  {
    return this.b;
  }
  
  @NotNull
  public final View c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.a.c.a
 * JD-Core Version:    0.7.0.1
 */