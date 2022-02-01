package com.tencent.biz.qqstory.view.widget;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.Utils;
import friendlist.GetOnlineInfoResp;
import mqq.os.MqqHandler;

class StoryQIMBadgeView$1
  extends FriendListObserver
{
  StoryQIMBadgeView$1(StoryQIMBadgeView paramStoryQIMBadgeView) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    super.onGetOnlineInfoByUinOrMobile(paramBoolean, paramLong, paramString, paramGetOnlineInfoResp);
    if ((StoryQIMBadgeView.a(this.a) != null) && (paramGetOnlineInfoResp != null))
    {
      if (TextUtils.isEmpty(StoryQIMBadgeView.a(this.a).qq)) {
        return;
      }
      if ((paramBoolean) && (Utils.a(StoryQIMBadgeView.a(this.a).qq, paramString))) {
        ThreadManager.getUIHandler().post(new StoryQIMBadgeView.1.1(this, paramGetOnlineInfoResp, paramString));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView.1
 * JD-Core Version:    0.7.0.1
 */