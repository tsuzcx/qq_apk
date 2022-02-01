package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "adapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;Landroid/view/View;)V", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "checkIv", "Landroid/widget/ImageView;", "phoneTv", "Landroid/widget/TextView;", "remarkTv", "fillItem", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class q$a
  extends RecyclerView.ViewHolder
{
  private final TextView a;
  private final TextView b;
  private final ImageView c;
  @NotNull
  private final q d;
  
  public q$a(@NotNull q paramq, @NotNull View paramView)
  {
    super(paramView);
    this.d = paramq;
    paramq = paramView.findViewById(2131440061);
    Intrinsics.checkExpressionValueIsNotNull(paramq, "view.findViewById(R.id.p…anager_dialog_item_phone)");
    this.a = ((TextView)paramq);
    paramq = paramView.findViewById(2131440062);
    Intrinsics.checkExpressionValueIsNotNull(paramq, "view.findViewById(R.id.p…nager_dialog_item_remark)");
    this.b = ((TextView)paramq);
    paramq = paramView.findViewById(2131440059);
    Intrinsics.checkExpressionValueIsNotNull(paramq, "view.findViewById(R.id.p…anager_dialog_item_check)");
    this.c = ((ImageView)paramq);
  }
  
  public final void a(@NotNull r paramr)
  {
    Intrinsics.checkParameterIsNotNull(paramr, "phoneItem");
    this.a.setText((CharSequence)paramr.c());
    if (paramr.i()) {
      this.b.setText((CharSequence)this.d.a().getString(2131886980));
    } else {
      this.b.setText((CharSequence)"");
    }
    ImageView localImageView = this.c;
    int i;
    if (paramr.j()) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.q.a
 * JD-Core Version:    0.7.0.1
 */