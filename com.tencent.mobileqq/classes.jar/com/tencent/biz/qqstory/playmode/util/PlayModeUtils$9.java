package com.tencent.biz.qqstory.playmode.util;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.ReportEvilToXinanHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class PlayModeUtils$9
  implements ActionSheet.OnButtonClickListener
{
  PlayModeUtils$9(StoryVideoItem paramStoryVideoItem, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramView = "16384";
      QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).b(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid);
      if ((localQQUserUIItem != null) && (!TextUtils.isEmpty(localQQUserUIItem.qq))) {
        new ReportEvilToXinanHandler().a(localQQUserUIItem.qq, localQQUserUIItem.isFriend(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramView, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getVideoUrl());
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramView = "2";
      break;
      paramView = "1";
      break;
      paramView = "4";
      break;
      SLog.d("Q.qqstory.player.PlayModeUtils", "report video error because evil uin is empty.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.9
 * JD-Core Version:    0.7.0.1
 */