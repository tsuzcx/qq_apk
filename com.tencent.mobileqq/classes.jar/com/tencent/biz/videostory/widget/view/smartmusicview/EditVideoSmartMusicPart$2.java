package com.tencent.biz.videostory.widget.view.smartmusicview;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditVideoSmartMusicPart$2
  implements View.OnClickListener
{
  EditVideoSmartMusicPart$2(EditVideoSmartMusicPart paramEditVideoSmartMusicPart) {}
  
  public void onClick(View paramView)
  {
    EditVideoSmartMusicPart.a(this.a).setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.2
 * JD-Core Version:    0.7.0.1
 */