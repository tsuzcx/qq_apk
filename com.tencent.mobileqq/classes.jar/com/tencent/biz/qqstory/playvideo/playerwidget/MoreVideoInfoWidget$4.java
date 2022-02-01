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
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      MoreVideoInfoWidget.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetMoreVideoInfoWidget, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.4
 * JD-Core Version:    0.7.0.1
 */