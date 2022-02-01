package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;

class PublicAccountDetailActivityImpl$ActionSheetBuilder$1
  implements ActionSheet.OnButtonClickListener
{
  PublicAccountDetailActivityImpl$ActionSheetBuilder$1(PublicAccountDetailActivityImpl.ActionSheetBuilder paramActionSheetBuilder) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= PublicAccountDetailActivityImpl.ActionSheetBuilder.a(this.a).size()))
    {
      PublicAccountDetailActivityImpl.ActionSheetBuilder.a(this.a).dismiss();
      return;
    }
    switch (((Integer)PublicAccountDetailActivityImpl.ActionSheetBuilder.a(this.a).get(paramInt)).intValue())
    {
    }
    for (;;)
    {
      PublicAccountDetailActivityImpl.ActionSheetBuilder.a(this.a).dismiss();
      return;
      this.a.a.share();
      continue;
      this.a.a.report();
      continue;
      this.a.a.showUnFollowActionSheet();
      continue;
      PublicAccountDetailActivityImpl.access$700(this.a.a);
      continue;
      PublicAccountDetailActivityImpl.access$800(this.a.a, this.a.a.uin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl.ActionSheetBuilder.1
 * JD-Core Version:    0.7.0.1
 */