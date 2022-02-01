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
    int j = ((ShareActionSheetBuilder.ActionSheetItem)IntimateInfoShareHelper.d(this.a)[0].get(paramInt)).action;
    IntimateInfoShareHelper.c(this.a).dismiss();
    int i;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 4)
            {
              if (j != 5) {
                i = 0;
              } else {
                i = 6;
              }
            }
            else {
              i = 4;
            }
          }
          else {
            i = 3;
          }
        }
        else {
          i = 2;
        }
      }
      else {
        i = 1;
      }
    }
    else {
      i = 5;
    }
    if (i != 0) {
      ReportController.b(null, "dc00898", "", "", "0X800A11B", "0X800A11B", i, 0, "", "", "", "");
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("intimate shareAction: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(j);
      QLog.i("IntimateInfoShareHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    ((IntimateInfoShareHelper)localObject).a(j, IntimateInfoShareHelper.b((IntimateInfoShareHelper)localObject));
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.2
 * JD-Core Version:    0.7.0.1
 */