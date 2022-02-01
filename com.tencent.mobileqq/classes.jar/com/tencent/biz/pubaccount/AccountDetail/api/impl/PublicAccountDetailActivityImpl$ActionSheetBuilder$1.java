package com.tencent.biz.pubaccount.accountdetail.api.impl;

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
    if ((paramInt >= 0) && (paramInt < PublicAccountDetailActivityImpl.ActionSheetBuilder.a(this.a).size()))
    {
      switch (((Integer)PublicAccountDetailActivityImpl.ActionSheetBuilder.a(this.a).get(paramInt)).intValue())
      {
      default: 
        break;
      case 2131695271: 
        this.a.a.showUnFollowActionSheet();
        break;
      case 2131695253: 
        this.a.a.share();
        break;
      case 2131695249: 
        PublicAccountDetailActivityImpl.access$700(this.a.a);
        break;
      case 2131695238: 
        this.a.a.report();
        break;
      case 2131695172: 
      case 2131695250: 
        PublicAccountDetailActivityImpl.access$800(this.a.a, this.a.a.uin);
      }
      PublicAccountDetailActivityImpl.ActionSheetBuilder.a(this.a).dismiss();
      return;
    }
    PublicAccountDetailActivityImpl.ActionSheetBuilder.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.ActionSheetBuilder.1
 * JD-Core Version:    0.7.0.1
 */