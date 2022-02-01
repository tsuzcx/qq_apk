package com.tencent.mobileqq.activity.aio;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareWithPictureActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class IntimateInfoShareHelper$2
  implements AdapterView.OnItemClickListener
{
  IntimateInfoShareHelper$2(IntimateInfoShareHelper paramIntimateInfoShareHelper) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int j = ((ShareActionSheetBuilder.ActionSheetItem)IntimateInfoShareHelper.a(this.a)[0].get(paramInt)).action;
    IntimateInfoShareHelper.a(this.a).dismiss();
    int i = 0;
    switch (j)
    {
    }
    for (;;)
    {
      if (i != 0) {
        ReportController.b(null, "dc00898", "", "", "0X800A11B", "0X800A11B", i, 0, "", "", "", "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("IntimateInfoShareHelper", 2, "intimate shareAction: " + paramInt + "," + j);
      }
      this.a.a(j, IntimateInfoShareHelper.a(this.a));
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.2
 * JD-Core Version:    0.7.0.1
 */