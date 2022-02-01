package com.tencent.mobileqq.activity.photo.album;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AbstractPhotoListActivity$CheckBoxClickedListener
  implements View.OnClickListener
{
  CheckBox mCheckBox;
  int mPosition;
  
  public AbstractPhotoListActivity$CheckBoxClickedListener(AbstractPhotoListActivity paramAbstractPhotoListActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.mPhotoListLogic != null) {
      this.this$0.mPhotoListLogic.onCheckBoxClick(paramView, this.mPosition, this.mCheckBox);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setCheckBox(CheckBox paramCheckBox)
  {
    this.mCheckBox = paramCheckBox;
  }
  
  public void setPosition(int paramInt)
  {
    this.mPosition = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.CheckBoxClickedListener
 * JD-Core Version:    0.7.0.1
 */