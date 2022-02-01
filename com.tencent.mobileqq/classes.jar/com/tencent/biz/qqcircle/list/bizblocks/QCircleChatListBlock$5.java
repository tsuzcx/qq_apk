package com.tencent.biz.qqcircle.list.bizblocks;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.fragments.chat.QCircleRecentChatListData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class QCircleChatListBlock$5
  implements View.OnClickListener
{
  QCircleChatListBlock$5(QCircleChatListBlock paramQCircleChatListBlock, int paramInt) {}
  
  public void onClick(View paramView)
  {
    QCircleRecentChatListData localQCircleRecentChatListData = (QCircleRecentChatListData)QCircleChatListBlock.access$500(this.this$0).get(this.val$pos);
    String str = localQCircleRecentChatListData.getRecentUserUin();
    if (!TextUtils.isEmpty(str)) {
      QCircleChatListBlock.access$600(this.this$0, str, localQCircleRecentChatListData.a());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleChatListBlock.5
 * JD-Core Version:    0.7.0.1
 */