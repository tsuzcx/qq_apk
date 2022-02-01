package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ProfileLabelEditorActivity$MyLabelGridViewAdapter$1
  implements View.OnClickListener
{
  ProfileLabelEditorActivity$MyLabelGridViewAdapter$1(ProfileLabelEditorActivity.MyLabelGridViewAdapter paramMyLabelGridViewAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof ProfileLabelEditorActivity.Holder))
    {
      localObject = (ProfileLabelEditorActivity.Holder)localObject;
      if ((((ProfileLabelEditorActivity.Holder)localObject).b >= 0) && (((ProfileLabelEditorActivity.Holder)localObject).b < this.a.b.l.size()))
      {
        localObject = (ProfileLabelInfo)this.a.b.l.remove(((ProfileLabelEditorActivity.Holder)localObject).b);
        this.a.b.a(this.a.b.l.size());
        this.a.notifyDataSetChanged();
        ProfileLabelEditorActivity.MyLabelGridViewAdapter.a(this.a, (ProfileLabelInfo)localObject);
        ReportController.b(this.a.b.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "2", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileLabelEditorActivity.MyLabelGridViewAdapter.1
 * JD-Core Version:    0.7.0.1
 */