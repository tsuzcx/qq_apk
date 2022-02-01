package com.tencent.mobileqq.activity.aio.coreui.pluspanel;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.tianshu.ui.RedTouch;

public final class PlusPanelAppListAdapter$ViewHolder
  extends RecyclerView.ViewHolder
{
  private ImageView a;
  private ImageView b;
  private RedTouch c;
  private TextView d;
  
  public PlusPanelAppListAdapter$ViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.a = ((ImageView)paramView.findViewById(2131435389));
    this.c = new RedTouch(paramView.getContext(), this.a).c(8388661).a();
    this.b = ((ImageView)paramView.findViewById(2131433314));
    this.d = ((TextView)paramView.findViewById(2131447090));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanelAppListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */