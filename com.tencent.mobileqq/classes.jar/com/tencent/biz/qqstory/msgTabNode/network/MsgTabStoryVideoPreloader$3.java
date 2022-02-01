package com.tencent.biz.qqstory.msgTabNode.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class MsgTabStoryVideoPreloader$3
  implements MsgTabVideoPreloaderDataProvider.DataProviderListener
{
  MsgTabStoryVideoPreloader$3(MsgTabStoryVideoPreloader paramMsgTabStoryVideoPreloader) {}
  
  public void a(@Nullable MsgTabNodeInfo paramMsgTabNodeInfo, Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MsgTabStoryVideoPreloader", 2, "MsgTabVideoPreloaderDataProvider load video info error", paramError);
    }
    this.a.c();
  }
  
  public void a(@Nullable MsgTabNodeInfo paramMsgTabNodeInfo, @NonNull List<StoryVideoItem> paramList)
  {
    if (!paramList.isEmpty())
    {
      if (QLog.isColorLevel())
      {
        paramMsgTabNodeInfo = new StringBuilder();
        paramMsgTabNodeInfo.append("start download video list, list = ");
        paramMsgTabNodeInfo.append(paramList.size());
        paramMsgTabNodeInfo.append("\n");
        paramMsgTabNodeInfo.append(paramList);
        QLog.i("MsgTabStoryVideoPreloader", 2, paramMsgTabNodeInfo.toString());
      }
      MsgTabStoryVideoPreloader.b(this.a, paramList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("MsgTabStoryVideoPreloader", 2, "can not find first unread video");
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabStoryVideoPreloader.3
 * JD-Core Version:    0.7.0.1
 */