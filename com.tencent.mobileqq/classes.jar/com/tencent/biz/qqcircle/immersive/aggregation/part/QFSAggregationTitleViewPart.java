package com.tencent.biz.qqcircle.immersive.aggregation.part;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.part.QFSBasePart;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QFSAggregationTitleViewPart
  extends QFSBasePart
  implements View.OnClickListener
{
  private ImageView a;
  
  public String a()
  {
    return "QFSAggregationTitleView";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.a = ((ImageView)paramView.findViewById(2131436618));
    if (m() != null) {
      m().a(this.a);
    }
    this.a.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131436618) && (!m().onBackEvent()) && (c() != null)) {
      c().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.aggregation.part.QFSAggregationTitleViewPart
 * JD-Core Version:    0.7.0.1
 */