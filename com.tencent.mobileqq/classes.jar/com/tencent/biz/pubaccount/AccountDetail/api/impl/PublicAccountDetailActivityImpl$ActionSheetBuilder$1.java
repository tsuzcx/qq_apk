package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;

class PublicAccountDetailActivityImpl$ActionSheetBuilder$1
  implements ActionSheet.OnButtonClickListener
{
  PublicAccountDetailActivityImpl$ActionSheetBuilder$1(PublicAccountDetailActivityImpl.ActionSheetBuilder paramActionSheetBuilder) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < PublicAccountDetailActivityImpl.ActionSheetBuilder.a(this.a).size()))
    {
      switch (((Integer)PublicAccountDetailActivityImpl.ActionSheetBuilder.a(this.a).get(paramInt)).intValue())
      {
      default: 
        break;
      case 2131893006: 
        this.a.a.showUnFollowActionSheet();
        break;
      case 2131892987: 
        this.a.a.share();
        break;
      case 2131892983: 
        PublicAccountDetailActivityImpl.access$700(this.a.a);
        break;
      case 2131892972: 
        this.a.a.report();
        break;
      case 2131892905: 
      case 2131892984: 
        PublicAccountDetailActivityImpl.access$800(this.a.a, this.a.a.uin);
      }
      PublicAccountDetailActivityImpl.ActionSheetBuilder.b(this.a).dismiss();
      return;
    }
    PublicAccountDetailActivityImpl.ActionSheetBuilder.b(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.ActionSheetBuilder.1
 * JD-Core Version:    0.7.0.1
 */