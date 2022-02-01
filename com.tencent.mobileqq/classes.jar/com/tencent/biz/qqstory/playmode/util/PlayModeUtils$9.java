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
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          paramView = "16384";
        }
      }
    }
    for (;;)
    {
      break;
      paramView = "4";
      continue;
      paramView = "1";
      continue;
      paramView = "2";
    }
    QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).b(this.a.mOwnerUid);
    if ((localQQUserUIItem != null) && (!TextUtils.isEmpty(localQQUserUIItem.qq))) {
      new ReportEvilToXinanHandler().a(localQQUserUIItem.qq, localQQUserUIItem.isFriend(), this.a.mVid, paramView, this.a.getVideoUrl());
    } else {
      SLog.d("Q.qqstory.player.PlayModeUtils", "report video error because evil uin is empty.");
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.9
 * JD-Core Version:    0.7.0.1
 */