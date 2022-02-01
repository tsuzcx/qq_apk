package com.tencent.biz.pubaccount.readinjoy.activity;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJDeliverUGCReportUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoyBaseDeliverActivity$12
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoyBaseDeliverActivity$12(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.a) {
      return;
    }
    this.a.a = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.b.dismiss();
      return;
      this.a.i();
      RIJDeliverUGCReportUtil.d("1");
      this.a.finish();
      continue;
      this.a.j();
      RIJDeliverUGCReportUtil.d("2");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity.12
 * JD-Core Version:    0.7.0.1
 */