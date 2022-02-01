package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AIOJubaoDialogHelper$1
  implements View.OnClickListener
{
  AIOJubaoDialogHelper$1(AIOJubaoDialogHelper paramAIOJubaoDialogHelper) {}
  
  public void onClick(View paramView)
  {
    AIOJubaoDialogHelper.a(this.a).dismissDialog(230);
    NewReportPlugin.a(AIOJubaoDialogHelper.a(this.a), AIOJubaoDialogHelper.a(this.a).jdField_a_of_type_Int, AIOJubaoDialogHelper.a(this.a).jdField_a_of_type_JavaLangString, AIOJubaoDialogHelper.a(this.a).getAccount());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOJubaoDialogHelper.1
 * JD-Core Version:    0.7.0.1
 */