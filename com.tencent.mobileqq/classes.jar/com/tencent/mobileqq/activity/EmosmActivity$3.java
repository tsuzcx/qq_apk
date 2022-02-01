package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EmosmActivity$3
  implements View.OnClickListener
{
  EmosmActivity$3(EmosmActivity paramEmosmActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.mIsEdited)
    {
      this.a.mTitleRight.setText(2131692129);
      this.a.mListView.setDragEnabled(true);
      this.a.mAdapter.a(true);
      localEmosmActivity = this.a;
      localEmosmActivity.mIsEdited = true;
      localEmosmActivity.mAdapter.notifyDataSetChanged();
      this.a.mDeleteButton.setVisibility(0);
      EmosmActivity.access$100(this.a).setVisibility(0);
      EmosmActivity.access$200(this.a).setVisibility(0);
      this.a.mDeleteButton.setEnabled(false);
      localEmosmActivity = this.a;
      localEmosmActivity.setTitle(String.format(localEmosmActivity.getResources().getString(2131692128), new Object[] { Integer.valueOf(0) }));
      this.a.mListView.setPadding(0, 0, 0, ViewUtils.a(44.0F));
      ReportController.b(this.a.app, "CliOper", "", "", "EmosSetting", "EpsEdit", 0, 0, "", "", "", "");
      if (this.a.mLaunchMode == 1) {
        ReportController.b(this.a.app, "dc00898", "", "", "0X800AB0F", "0X800AB0F", 0, 0, "", "", "", "");
      } else {
        ReportController.b(this.a.app, "dc00898", "", "", "0X800AB16", "0X800AB16", 0, 0, "", "", "", "");
      }
    }
    else if ((this.a.mLaunchSource == 2) || (this.a.mLaunchSource == 1))
    {
      this.a.mTitleRight.setText(2131692127);
      this.a.mListView.setDragEnabled(false);
      this.a.mAdapter.a(false);
      this.a.saveChangeToDB();
      localEmosmActivity = this.a;
      localEmosmActivity.mIsEdited = false;
      localEmosmActivity.mAdapter.notifyDataSetChanged();
      this.a.mAdapter.a();
      this.a.mDeleteButton.setVisibility(8);
      EmosmActivity.access$100(this.a).setVisibility(8);
      EmosmActivity.access$200(this.a).setVisibility(8);
      if (this.a.mLaunchMode == 2) {
        this.a.setTitle(2131691917);
      } else {
        this.a.setTitle(2131692136);
      }
      this.a.mListView.setPadding(0, 0, 0, 0);
    }
    EmosmActivity localEmosmActivity = this.a;
    localEmosmActivity.editChange(localEmosmActivity.mIsEdited);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity.3
 * JD-Core Version:    0.7.0.1
 */