package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeWatchedRequest;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.mobileqq.app.HardCodeUtil;

public class MsgNodeNewGuideViewHolder
  extends MsgNodeViewHolder
{
  public MsgNodeNewGuideViewHolder(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131628093);
  }
  
  private void c(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    paramMsgTabNodeInfo.D = false;
    MsgTabStoryManager.a(QQStoryContext.j()).a(paramMsgTabNodeInfo);
    MsgTabNodeWatchedRequest localMsgTabNodeWatchedRequest = new MsgTabNodeWatchedRequest();
    localMsgTabNodeWatchedRequest.f = paramMsgTabNodeInfo.d;
    localMsgTabNodeWatchedRequest.g = paramMsgTabNodeInfo.b;
    localMsgTabNodeWatchedRequest.h = 4;
    localMsgTabNodeWatchedRequest.i = paramMsgTabNodeInfo.j;
    CmdTaskManger.a().a(localMsgTabNodeWatchedRequest, null);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    if (!TextUtils.isEmpty(paramMsgTabNodeInfo.p)) {
      c(paramMsgTabNodeInfo.p);
    }
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout;
    String str;
    if (!TextUtils.isEmpty(paramMsgTabNodeInfo.y))
    {
      localStoryMsgNodeFrameLayout = this.c;
      if (TextUtils.isEmpty(paramMsgTabNodeInfo.l)) {
        str = HardCodeUtil.a(2131904823);
      } else {
        str = paramMsgTabNodeInfo.l;
      }
      localStoryMsgNodeFrameLayout.setNodeName(str, paramMsgTabNodeInfo.y);
    }
    else
    {
      localStoryMsgNodeFrameLayout = this.c;
      if (TextUtils.isEmpty(paramMsgTabNodeInfo.l)) {
        str = HardCodeUtil.a(2131904822);
      } else {
        str = paramMsgTabNodeInfo.l;
      }
      localStoryMsgNodeFrameLayout.setNodeName(str, 0);
    }
    if (paramMsgTabNodeInfo.D) {
      c(paramMsgTabNodeInfo);
    }
  }
  
  protected void b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.c.setDisplayState(6);
    this.c.a(paramMsgTabNodeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.MsgNodeNewGuideViewHolder
 * JD-Core Version:    0.7.0.1
 */