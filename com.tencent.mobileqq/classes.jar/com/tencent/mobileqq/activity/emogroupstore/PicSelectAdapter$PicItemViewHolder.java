package com.tencent.mobileqq.activity.emogroupstore;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PicSelectAdapter$PicItemViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public ImageView a;
  public NumberCheckBox b;
  public ImageView c;
  public ImageView d;
  public NumberCheckBox e;
  public ImageView f;
  public ImageView g;
  public NumberCheckBox h;
  public ImageView i;
  public ImageView[] j;
  public NumberCheckBox[] k;
  public ImageView[] l;
  private PicSelectAdapter.OnImgClickListener m;
  
  public PicSelectAdapter$PicItemViewHolder(View paramView)
  {
    super(paramView);
    this.a = ((ImageView)paramView.findViewById(2131435573));
    this.b = ((NumberCheckBox)paramView.findViewById(2131430691));
    this.c = ((ImageView)paramView.findViewById(2131435608));
    this.d = ((ImageView)paramView.findViewById(2131435574));
    this.e = ((NumberCheckBox)paramView.findViewById(2131430692));
    this.f = ((ImageView)paramView.findViewById(2131435609));
    this.g = ((ImageView)paramView.findViewById(2131435575));
    this.h = ((NumberCheckBox)paramView.findViewById(2131430693));
    this.i = ((ImageView)paramView.findViewById(2131435610));
    this.j = new ImageView[] { this.a, this.d, this.g };
    paramView = this.j;
    int i1 = paramView.length;
    int n = 0;
    while (n < i1)
    {
      paramView[n].setOnClickListener(this);
      n += 1;
    }
    this.k = new NumberCheckBox[] { this.b, this.e, this.h };
    this.l = new ImageView[] { this.c, this.f, this.i };
  }
  
  void a(PicSelectAdapter.OnImgClickListener paramOnImgClickListener)
  {
    this.m = paramOnImgClickListener;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("v.getId: ");
      ((StringBuilder)localObject).append(paramView.getId());
      ((StringBuilder)localObject).append(" itemView.getTag: ");
      ((StringBuilder)localObject).append(this.itemView.getTag());
      QLog.i("picOnClick.1", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.m;
    if (localObject != null) {
      ((PicSelectAdapter.OnImgClickListener)localObject).a(((Integer)this.itemView.getTag()).intValue(), paramView.getId());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.PicSelectAdapter.PicItemViewHolder
 * JD-Core Version:    0.7.0.1
 */