package com.tencent.mm.ui.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class MMBottomSheet$RecycleViewAdapter$ViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  TextView a;
  TextView b;
  WeImageView c;
  ImageView d;
  RadioButton e;
  ImageView f;
  LinearLayout g;
  View h;
  View i;
  
  public MMBottomSheet$RecycleViewAdapter$ViewHolder(MMBottomSheet.RecycleViewAdapter paramRecycleViewAdapter, View paramView)
  {
    super(paramView);
    paramView.setOnClickListener(this);
    this.a = ((TextView)paramView.findViewById(2131447463));
    this.c = ((WeImageView)paramView.findViewById(2131435219));
    this.g = ((LinearLayout)paramView.findViewById(2131445137));
    this.h = paramView.findViewById(2131439259);
    this.i = paramView.findViewById(2131444531);
    if (MMBottomSheet.B(paramRecycleViewAdapter.b)) {
      this.d = ((ImageView)paramView.findViewById(2131435231));
    }
    if (MMBottomSheet.v(paramRecycleViewAdapter.b)) {
      this.e = ((RadioButton)paramView.findViewById(2131444152));
    }
    if ((MMBottomSheet.v(paramRecycleViewAdapter.b)) || (MMBottomSheet.C(paramRecycleViewAdapter.b)))
    {
      this.b = ((TextView)paramView.findViewById(2131431733));
      this.f = ((ImageView)paramView.findViewById(2131432003));
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.j.a != null) {
      this.j.a.onItemClick(null, paramView, getPosition(), getPosition());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMBottomSheet.RecycleViewAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */