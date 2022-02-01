package com.tencent.biz.qqcircle.widgets.polymerization;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleCommonClick;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;
import qqcircle.QQCircleFeedBase.StTagPageData;

public class QCirclePolymerizationFuelListView
  implements View.OnClickListener, ReportBean<QCircleReportBean>
{
  private View a;
  private RecyclerView b;
  private QQCircleFeedBase.StTagPageData c;
  private QCirclePolymerizationFuelListView.QCircleFuelListAdapter d;
  private QCircleReportBean e;
  private TextView f;
  private TextView g;
  private ImageView h;
  private RelativeLayout i;
  private QCirclePolymerizationBean j;
  
  static {}
  
  protected String a()
  {
    return "QCircleFuelListView";
  }
  
  protected void a(View paramView)
  {
    this.a = paramView;
    this.f = ((TextView)paramView.findViewById(2131448478));
    this.g = ((TextView)paramView.findViewById(2131448479));
    this.h = ((ImageView)paramView.findViewById(2131436260));
    this.b = ((RecyclerView)paramView.findViewById(2131445210));
    this.i = ((RelativeLayout)paramView.findViewById(2131444954));
    this.b.setLayoutManager(new LinearLayoutManager(paramView.getContext(), 0, false));
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
  }
  
  public void a(QCirclePolymerizationBean paramQCirclePolymerizationBean)
  {
    this.j = paramQCirclePolymerizationBean;
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.e = QCircleReportBean.setReportBean(a(), paramQCircleReportBean);
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof QQCircleFeedBase.StTagPageData)) {
      return;
    }
    this.c = ((QQCircleFeedBase.StTagPageData)paramObject);
    if (this.c.fuelCircleRankItem.get().size() == 0)
    {
      this.i.setVisibility(8);
      this.b.setVisibility(8);
    }
    else
    {
      this.i.setVisibility(0);
      this.b.setVisibility(0);
    }
    if (!TextUtils.isEmpty(this.c.rankName.get())) {
      this.f.setText(this.c.rankName.get());
    }
    if (this.d == null) {
      this.d = new QCirclePolymerizationFuelListView.QCircleFuelListAdapter(this, null);
    }
    this.b.setAdapter(this.d);
    this.d.notifyDataSetChanged();
  }
  
  public QCircleReportBean b()
  {
    return QCircleReportBean.getReportBean(a(), this.e);
  }
  
  protected int c()
  {
    return QCircleReportBean.getPageId(a(), this.e);
  }
  
  @QCircleCommonClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(k, this, this, paramView);
    a(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.polymerization.QCirclePolymerizationFuelListView
 * JD-Core Version:    0.7.0.1
 */