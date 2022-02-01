package com.tencent.mobileqq.activity.aio.photo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AIOPhotoListAdapter$5
  implements View.OnClickListener
{
  AIOPhotoListAdapter$5(AIOPhotoListAdapter paramAIOPhotoListAdapter, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((AIOPhotoListAdapter.a(this.b) != null) && (AIOPhotoListAdapter.a(this.b).t.b(this.a) != null))
    {
      boolean bool = AIOPhotoListAdapter.a(this.b).t.a(this.a, AIOPhotoListAdapter.a(this.b).m, AIOPhotoListAdapter.a(this.b).l);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AIOPhotoListAdapter.b(this.b));
      ((StringBuilder)localObject).append("");
      String str = ((StringBuilder)localObject).toString();
      if (bool) {
        localObject = "1";
      } else {
        localObject = "2";
      }
      ReportController.b(null, "dc00898", "", "", "0X800AC87", "0X800AC87", 1, 0, str, (String)localObject, "", "");
      this.b.notifyDataSetChanged();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter.5
 * JD-Core Version:    0.7.0.1
 */