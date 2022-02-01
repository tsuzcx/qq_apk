package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizeDetailViewModel;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import qqcircle.QQCircleFeedBase.StCommSchemaCollectPageData;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;

public class QCirclePolymerizeDetailTitlePart
  extends QCircleBasePart
  implements View.OnClickListener
{
  private TextView a;
  private ImageView c;
  private QCirclePolymerizeDetailViewModel d;
  
  private void a(QQCircleFeedBase.StFeedListBusiRspData paramStFeedListBusiRspData)
  {
    if (paramStFeedListBusiRspData == null) {
      return;
    }
    this.a.setText(paramStFeedListBusiRspData.commSchemaCollectPageData.title.get());
  }
  
  public String a()
  {
    return "QCirclePolymerizeDetailTitlePart";
  }
  
  public void a(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131448814));
    this.c = ((ImageView)paramView.findViewById(2131436275));
    this.c.setOnClickListener(this);
    if ((j() instanceof QCircleBaseFragment)) {
      ((QCircleBaseFragment)j()).a(this.c);
    }
    this.d = ((QCirclePolymerizeDetailViewModel)a(QCirclePolymerizeDetailViewModel.class));
    this.d.b.observe(j(), new QCirclePolymerizeDetailTitlePart.1(this));
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131436275) && (!j().onBackEvent()) && (c() != null)) {
      c().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePolymerizeDetailTitlePart
 * JD-Core Version:    0.7.0.1
 */