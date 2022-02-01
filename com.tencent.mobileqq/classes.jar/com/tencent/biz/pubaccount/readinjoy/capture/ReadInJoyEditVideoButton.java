package com.tencent.biz.pubaccount.readinjoy.capture;

import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoButton;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;

public class ReadInJoyEditVideoButton
  extends EditVideoButton
{
  public ReadInJoyEditVideoButton(@NonNull EditVideoPartManager paramEditVideoPartManager, int paramInt)
  {
    super(paramEditVideoPartManager, paramInt);
  }
  
  private void d()
  {
    a(2131379680).setVisibility(8);
    ((TextView)a(2131365359)).setText(HardCodeUtil.a(2131712830));
  }
  
  public void a()
  {
    super.a();
    d();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    Long localLong = (Long)this.a.get(i);
    if (localLong != null) {
      switch ((int)localLong.longValue())
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80092F5", "0X80092F5", 0, 0, "3", "", "", "", false);
      continue;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80092F5", "0X80092F5", 0, 0, "1", "", "", "", false);
      continue;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80092F5", "0X80092F5", 0, 0, "2", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyEditVideoButton
 * JD-Core Version:    0.7.0.1
 */