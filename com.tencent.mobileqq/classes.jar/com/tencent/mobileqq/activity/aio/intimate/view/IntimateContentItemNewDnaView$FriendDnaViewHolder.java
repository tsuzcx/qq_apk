package com.tencent.mobileqq.activity.aio.intimate.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.activity.aio.intimate.info.NewDnaInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRectImageView;

class IntimateContentItemNewDnaView$FriendDnaViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, View.OnTouchListener
{
  public RelativeLayout a;
  public TextView b;
  public LinearLayout c;
  public RoundRectImageView d;
  
  public IntimateContentItemNewDnaView$FriendDnaViewHolder(IntimateContentItemNewDnaView paramIntimateContentItemNewDnaView, @NonNull View paramView)
  {
    super(paramView);
    this.a = ((RelativeLayout)paramView.findViewById(2131435971));
    this.b = ((TextView)paramView.findViewById(2131433763));
    this.c = ((LinearLayout)paramView.findViewById(2131433760));
    this.d = ((RoundRectImageView)paramView.findViewById(2131435974));
    paramView.setOnClickListener(this);
    paramView.setOnTouchListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (IntimateContentItemNewDnaView.b(this.e) != null) {
      IntimateContentItemNewDnaView.c(this.e).a(paramView, getLayoutPosition(), (NewDnaInfo)this.itemView.getTag());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (((i == 1) || (i == 3)) && (Build.VERSION.SDK_INT >= 11)) {
        paramView.setAlpha(1.0F);
      }
    }
    else if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemNewDnaView.FriendDnaViewHolder
 * JD-Core Version:    0.7.0.1
 */