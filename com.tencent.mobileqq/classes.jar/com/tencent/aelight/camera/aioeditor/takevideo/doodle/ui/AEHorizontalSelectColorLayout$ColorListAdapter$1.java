package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class AEHorizontalSelectColorLayout$ColorListAdapter$1
  implements View.OnClickListener
{
  AEHorizontalSelectColorLayout$ColorListAdapter$1(AEHorizontalSelectColorLayout.ColorListAdapter paramColorListAdapter, AEHorizontalSelectColorLayout.ColorVH paramColorVH) {}
  
  public void onClick(View paramView)
  {
    int i = this.a.getAdapterPosition();
    AEHorizontalSelectColorLayout.ColorListAdapter.b(this.b, i);
    if (i < AEHorizontalSelectColorLayout.ColorListAdapter.a(this.b))
    {
      if (AEHorizontalSelectColorLayout.ColorListAdapter.b(this.b) != null) {
        AEHorizontalSelectColorLayout.ColorListAdapter.b(this.b).a(0, 0);
      }
    }
    else
    {
      i = ((Integer)AEHorizontalSelectColorLayout.ColorListAdapter.c(this.b).get(i - AEHorizontalSelectColorLayout.ColorListAdapter.a(this.b))).intValue();
      if (AEHorizontalSelectColorLayout.ColorListAdapter.b(this.b) != null) {
        AEHorizontalSelectColorLayout.ColorListAdapter.b(this.b).a(1, i);
      }
    }
    this.b.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.AEHorizontalSelectColorLayout.ColorListAdapter.1
 * JD-Core Version:    0.7.0.1
 */