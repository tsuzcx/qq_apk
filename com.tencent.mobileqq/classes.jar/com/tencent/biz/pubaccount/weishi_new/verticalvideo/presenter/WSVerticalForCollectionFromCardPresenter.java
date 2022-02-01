package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;

public class WSVerticalForCollectionFromCardPresenter
  extends WSVerticalForCollectionPresenter
{
  public WSVerticalForCollectionFromCardPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  public void destroy()
  {
    super.destroy();
    WSReportUtils.d();
    WSVerticalBeaconReport.b("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForCollectionFromCardPresenter
 * JD-Core Version:    0.7.0.1
 */