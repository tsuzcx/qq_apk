package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleExpandableTextView$1
  implements View.OnClickListener
{
  QCircleExpandableTextView$1(QCircleExpandableTextView paramQCircleExpandableTextView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.a;
    ((QCircleExpandableTextView)localObject).i ^= true;
    if (this.a.i)
    {
      this.a.b.setText(this.a.f);
      if (this.a.m != null)
      {
        this.a.m.b(false);
        this.a.m.a(false);
      }
      localObject = this.a;
      localObject = new QCircleExpandableTextView.ExpandCollapseAnimation((QCircleExpandableTextView)localObject, ((QCircleExpandableTextView)localObject).getHeight(), this.a.j, null);
    }
    else
    {
      this.a.b.setText(this.a.e);
      if (this.a.m != null)
      {
        this.a.m.b(true);
        this.a.m.a(true);
      }
      localObject = this.a;
      localObject = new QCircleExpandableTextView.ExpandCollapseAnimation((QCircleExpandableTextView)localObject, ((QCircleExpandableTextView)localObject).getHeight(), this.a.h + this.a.k, null);
    }
    ((QCircleExpandableTextView.ExpandCollapseAnimation)localObject).setFillAfter(true);
    ((QCircleExpandableTextView.ExpandCollapseAnimation)localObject).setAnimationListener(new QCircleExpandableTextView.1.1(this));
    this.a.clearAnimation();
    this.a.startAnimation((Animation)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView.1
 * JD-Core Version:    0.7.0.1
 */