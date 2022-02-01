package com.tencent.biz.pubaccount.readinjoy.handlers;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Map;

public class DailyHandler
  extends BaseHandler
{
  public int a()
  {
    return 3;
  }
  
  public void a(View paramView, ListView paramListView, long paramLong) {}
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ArticleInfo)a((int)paramLong);
    if (DailyModeConfigHandler.c(b())) {
      if (!RIJFeedsType.a(paramAdapterView)) {
        break label35;
      }
    }
    label35:
    for (paramInt = 4;; paramInt = 2)
    {
      KandianDailyReportUtils.a(paramInt);
      return;
    }
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean)
  {
    super.a(paramMap, paramBoolean);
    if (DailyModeConfigHandler.c(b()))
    {
      paramMap = a();
      if (ReadInJoyHelper.z()) {
        break label36;
      }
      QLog.d("DailyHandler", 1, "detachFromViewGroup,now cmd is 0x68b");
    }
    label36:
    while (paramMap == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new DailyHandler.1(this, paramMap.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.DailyHandler
 * JD-Core Version:    0.7.0.1
 */