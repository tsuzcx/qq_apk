package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "adapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;Landroid/view/View;)V", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "deleteIv", "Landroid/widget/ImageView;", "phoneTv", "Landroid/widget/TextView;", "remarkTv", "fillItem", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class j$a
  extends RecyclerView.ViewHolder
{
  private final ImageView a;
  private final TextView b;
  private final TextView c;
  @NotNull
  private final j d;
  
  public j$a(@NotNull j paramj, @NotNull View paramView)
  {
    super(paramView);
    this.d = paramj;
    paramj = paramView.findViewById(2131440060);
    Intrinsics.checkExpressionValueIsNotNull(paramj, "view.findViewById(R.id.p…nager_dialog_item_delete)");
    this.a = ((ImageView)paramj);
    paramj = paramView.findViewById(2131440061);
    Intrinsics.checkExpressionValueIsNotNull(paramj, "view.findViewById(R.id.p…anager_dialog_item_phone)");
    this.b = ((TextView)paramj);
    paramj = paramView.findViewById(2131440062);
    Intrinsics.checkExpressionValueIsNotNull(paramj, "view.findViewById(R.id.p…nager_dialog_item_remark)");
    this.c = ((TextView)paramj);
  }
  
  @NotNull
  public final j a()
  {
    return this.d;
  }
  
  public final void a(@NotNull r paramr)
  {
    Intrinsics.checkParameterIsNotNull(paramr, "phoneItem");
    this.b.setText((CharSequence)paramr.c());
    if (paramr.i()) {
      this.c.setText((CharSequence)this.d.b().getString(2131886980));
    } else {
      this.c.setText((CharSequence)"");
    }
    if ((this.d.a()) && (!paramr.i()))
    {
      this.a.setVisibility(0);
      this.a.setOnClickListener((View.OnClickListener)new j.a.a(this, paramr));
      return;
    }
    this.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.j.a
 * JD-Core Version:    0.7.0.1
 */