package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import java.util.List;

class QCircleTroopTagListView$RecommendLabelAdapter$TagViewHolder
  extends RecyclerView.ViewHolder
{
  public TextView a;
  public ImageView b;
  public ImageView c;
  public RelativeLayout d;
  
  public QCircleTroopTagListView$RecommendLabelAdapter$TagViewHolder(QCircleTroopTagListView.RecommendLabelAdapter paramRecommendLabelAdapter, View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(2131436836));
    this.b = ((ImageView)paramView.findViewById(2131436829));
    this.c = ((ImageView)paramView.findViewById(2131436828));
    this.d = ((RelativeLayout)paramView.findViewById(2131436834));
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.b.setVisibility(8);
    if (QCircleTroopTagListView.a(this.e.b) == 0)
    {
      this.c.setVisibility(8);
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Q群: ");
      localStringBuilder.append(paramLong);
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    else
    {
      this.c.setVisibility(0);
      this.a.setText(String.valueOf(paramLong));
    }
    Object localObject = (FrameLayout.LayoutParams)this.d.getLayoutParams();
    if (paramInt == 0) {
      ((FrameLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
    } else if (paramInt == this.e.a.size() - 1) {
      ((FrameLayout.LayoutParams)localObject).setMargins(ViewUtils.a(5.0F), 0, ViewUtils.a(38.0F), 0);
    } else {
      ((FrameLayout.LayoutParams)localObject).setMargins(ViewUtils.a(5.0F), 0, 0, 0);
    }
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.d.setPadding(ViewUtils.a(5.0F), 0, ViewUtils.a(5.0F), 0);
    this.d.setOnClickListener(new QCircleTroopTagListView.RecommendLabelAdapter.TagViewHolder.1(this, paramLong));
    this.c.setOnClickListener(new QCircleTroopTagListView.RecommendLabelAdapter.TagViewHolder.2(this, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTroopTagListView.RecommendLabelAdapter.TagViewHolder
 * JD-Core Version:    0.7.0.1
 */