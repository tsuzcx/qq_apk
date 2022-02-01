package com.tencent.biz.qqstory.playmode.util;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.ReportEvilToXinanHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class PlayModeUtils$8
  implements ActionSheet.OnButtonClickListener
{
  PlayModeUtils$8(CommentEntry paramCommentEntry, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          paramView = "16384";
        } else {
          paramView = "4";
        }
      }
      else {
        paramView = "1";
      }
    }
    else {
      paramView = "2";
    }
    QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).b(this.a.authorUnionId);
    if ((localQQUserUIItem != null) && (!TextUtils.isEmpty(localQQUserUIItem.qq))) {
      new ReportEvilToXinanHandler().a(localQQUserUIItem.qq, localQQUserUIItem.isFriend(), paramView, this.a.content);
    } else {
      SLog.d("Q.qqstory.player.PlayModeUtils", "report comment error because evil uin is empty.");
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.8
 * JD-Core Version:    0.7.0.1
 */