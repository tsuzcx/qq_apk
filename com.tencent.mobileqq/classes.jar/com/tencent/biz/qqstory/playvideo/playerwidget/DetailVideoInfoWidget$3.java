package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.concurrent.atomic.AtomicBoolean;

class DetailVideoInfoWidget$3
  implements ActionSheet.OnButtonClickListener
{
  DetailVideoInfoWidget$3(DetailVideoInfoWidget paramDetailVideoInfoWidget, StoryVideoItem paramStoryVideoItem, VideoViewVideoHolder paramVideoViewVideoHolder, AtomicBoolean paramAtomicBoolean, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      PlayModeUtils.a(this.e.y(), this.a, new DetailVideoInfoWidget.3.1(this));
      this.c.set(true);
    }
    this.d.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.DetailVideoInfoWidget.3
 * JD-Core Version:    0.7.0.1
 */