package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.concurrent.atomic.AtomicBoolean;

class MoreVideoInfoWidget$4
  implements ActionSheet.OnButtonClickListener
{
  MoreVideoInfoWidget$4(MoreVideoInfoWidget paramMoreVideoInfoWidget, StoryVideoItem paramStoryVideoItem, AtomicBoolean paramAtomicBoolean, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      MoreVideoInfoWidget.a(this.d, this.a);
      this.b.set(true);
    }
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.4
 * JD-Core Version:    0.7.0.1
 */