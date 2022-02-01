package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;

public class QFSLayerPageTitleViewPart
  extends QFSBasePart
  implements View.OnClickListener
{
  private ImageView a;
  private RelativeLayout b;
  
  public String a()
  {
    return "FSLayerBarViewPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.b = ((RelativeLayout)paramView.findViewById(2131447588));
    this.a = ((ImageView)paramView.findViewById(2131433374));
    this.a.setOnClickListener(this);
    VideoReport.setElementId(this.a, "em_xsj_back_button");
    VideoReport.setElementParams(this.a, new QCircleDTParamBuilder().buildElementParams());
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131433374) {
      c().onBackPressed();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSLayerPageTitleViewPart
 * JD-Core Version:    0.7.0.1
 */