package com.tencent.biz.qqcircle.immersive.aggregation.part;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.aggregation.QFSMusicAggregationViewModel;
import com.tencent.biz.qqcircle.immersive.part.QFSBasePart;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StMusicPageData;

public class QFSAggregationPublishPart
  extends QFSBasePart
{
  private LinearLayout a;
  private QFSMusicAggregationViewModel b;
  private QQCircleFeedBase.StMusicPageData c;
  
  private void a(UIStateData<QQCircleFeedBase.StFeedListBusiRspData> paramUIStateData)
  {
    if (paramUIStateData.c() != 3) {
      return;
    }
    if (paramUIStateData.e() != null) {
      this.c = ((QQCircleFeedBase.StMusicPageData)((QQCircleFeedBase.StFeedListBusiRspData)paramUIStateData.e()).musicPageData.get());
    }
    f();
  }
  
  private void b(View paramView)
  {
    QQCircleFeedBase.StMusicPageData localStMusicPageData = this.c;
    if ((localStMusicPageData != null) && (!TextUtils.isEmpty(localStMusicPageData.publishSchema.get())))
    {
      QCircleLauncher.a(paramView.getContext(), this.c.publishSchema.get());
      return;
    }
    QLog.i("QFSAggregationPublishPart", 1, "onClickBtnPublish  mMusicPageData == null");
    QCircleToast.a(QCircleToast.c, HardCodeUtil.a(2131896230), 0);
  }
  
  private void d()
  {
    VideoReport.setElementId(this.a, "em_xsj_edit_button");
    VideoReport.setElementParams(this.a, new QCircleDTParamBuilder().buildElementParams());
  }
  
  private void e()
  {
    this.b = ((QFSMusicAggregationViewModel)a(QFSMusicAggregationViewModel.class));
    this.b.d().observe(m(), new QFSAggregationPublishPart.2(this));
  }
  
  private void f()
  {
    this.a.setVisibility(8);
    if (QCircleConfigHelper.aK() == 0)
    {
      QLog.i("QFSAggregationPublishPart", 1, "initShowBtnPublish  wns is close");
      return;
    }
    if (!QCircleConfigHelper.bh())
    {
      QLog.i("QFSAggregationPublishPart", 1, "initShowBtnPublish  JumpOldPublish");
      return;
    }
    this.a.setVisibility(0);
  }
  
  public String a()
  {
    return "QFSAggregationPublishPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.a = ((LinearLayout)paramView.findViewById(2131437522));
    e();
    f();
    d();
    this.a.setOnClickListener(new QFSAggregationPublishPart.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.aggregation.part.QFSAggregationPublishPart
 * JD-Core Version:    0.7.0.1
 */