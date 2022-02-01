package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalFeedInfo;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleReportBean;

public class QFSPersonalOutBoxFeedItemView
  extends QCircleBaseWidgetView<QFSPersonalFeedInfo>
  implements View.OnClickListener
{
  public ImageView a;
  public TextView b;
  private QFSPersonalFeedInfo c;
  
  public QFSPersonalOutBoxFeedItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    Option localOption = new Option().setUrl(this.c.c()).setTargetView(this.a);
    localOption.setLoadingDrawable(new ColorDrawable(getResources().getColor(2131166091)));
    QCircleFeedPicLoader.g().loadImage(localOption, null);
  }
  
  private boolean a(View paramView)
  {
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setFromReportBean(getReportBean().clone());
    QCircleLauncher.g(paramView.getContext(), localQCircleInitBean);
    return true;
  }
  
  protected void a(QFSPersonalFeedInfo paramQFSPersonalFeedInfo, int paramInt)
  {
    if (paramQFSPersonalFeedInfo != null)
    {
      if (paramQFSPersonalFeedInfo.equals(this.c)) {
        return;
      }
      this.c = paramQFSPersonalFeedInfo;
      if (this.a != null) {
        a();
      }
      if ((this.b != null) && (paramQFSPersonalFeedInfo.f() > 0))
      {
        this.b.setText(getResources().getString(2131895759, new Object[] { Integer.valueOf(paramQFSPersonalFeedInfo.f()) }));
        this.b.setVisibility(0);
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131626793;
  }
  
  protected String getLogTag()
  {
    return "QCircleDraftItemView";
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131436354) {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((ImageView)paramView.findViewById(2131436354));
    this.b = ((TextView)paramView.findViewById(2131448867));
    this.a.setOnClickListener(this);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1) * 4 / 3, 1073741824));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalOutBoxFeedItemView
 * JD-Core Version:    0.7.0.1
 */