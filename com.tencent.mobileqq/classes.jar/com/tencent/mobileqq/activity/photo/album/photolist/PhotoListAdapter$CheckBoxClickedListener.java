package com.tencent.mobileqq.activity.photo.album.photolist;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PhotoListAdapter$CheckBoxClickedListener
  implements View.OnClickListener
{
  int a;
  CheckBox b;
  
  public PhotoListAdapter$CheckBoxClickedListener(PhotoListAdapter paramPhotoListAdapter) {}
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(CheckBox paramCheckBox)
  {
    this.b = paramCheckBox;
  }
  
  public void onClick(View paramView)
  {
    if (this.c.g != null) {
      this.c.g.a(paramView, this.a, this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter.CheckBoxClickedListener
 * JD-Core Version:    0.7.0.1
 */