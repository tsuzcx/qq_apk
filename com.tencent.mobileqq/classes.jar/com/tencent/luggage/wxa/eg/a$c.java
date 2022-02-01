package com.tencent.luggage.wxa.eg;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/setting/adapter/SubscribeMsgListAdapter$SubscribeMsgListItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "infoIcon", "Landroid/widget/ImageView;", "getInfoIcon", "()Landroid/widget/ImageView;", "setInfoIcon", "(Landroid/widget/ImageView;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "topLine", "getTopLine", "()Landroid/view/View;", "setTopLine", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a$c
  extends RecyclerView.ViewHolder
{
  private CheckBox a;
  private TextView b;
  private ImageView c;
  private View d;
  
  public a$c(@NotNull View paramView)
  {
    super(paramView);
    this.a = ((CheckBox)paramView.findViewById(2131430688));
    this.b = ((TextView)paramView.findViewById(2131446581));
    this.c = ((ImageView)paramView.findViewById(2131446578));
    this.d = paramView.findViewById(2131447733);
  }
  
  public final CheckBox a()
  {
    return this.a;
  }
  
  public final TextView b()
  {
    return this.b;
  }
  
  public final ImageView c()
  {
    return this.c;
  }
  
  public final View d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eg.a.c
 * JD-Core Version:    0.7.0.1
 */