package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class QCircleTroopTagListView
{
  private RecyclerView a;
  private View b;
  private QCircleTroopTagListView.RecommendLabelAdapter c;
  private List<Long> d;
  private QCircleTroopTagListView.EventListener e;
  private int f;
  
  public void a(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      this.a = ((RecyclerView)paramView.findViewById(2131441902));
      this.b = paramView.findViewById(2131449879);
      this.a.setOverScrollMode(2);
      this.a.setVisibility(8);
      paramView = new LinearLayoutManager(paramView.getContext());
      paramView.setOrientation(0);
      this.a.setLayoutManager(paramView);
      this.c = new QCircleTroopTagListView.RecommendLabelAdapter(this, null);
      this.a.setAdapter(this.c);
      this.f = paramInt;
    }
  }
  
  public void a(QCircleTroopTagListView.EventListener paramEventListener)
  {
    this.e = paramEventListener;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof ArrayList))
    {
      this.d = ((ArrayList)paramObject);
      if (this.d.size() > 0)
      {
        this.a.setVisibility(0);
        paramObject = this.b;
        if (paramObject != null) {
          paramObject.setVisibility(0);
        }
        paramObject = this.c;
        if (paramObject != null) {
          paramObject.a(this.d);
        }
      }
      else
      {
        this.a.setVisibility(8);
        paramObject = this.b;
        if (paramObject != null) {
          paramObject.setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTroopTagListView
 * JD-Core Version:    0.7.0.1
 */