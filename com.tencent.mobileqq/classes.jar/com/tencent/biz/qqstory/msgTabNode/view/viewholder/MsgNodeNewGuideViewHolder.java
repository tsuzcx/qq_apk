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
    super(paramViewGroup, 2131561714);
  }
  
  private void c(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    paramMsgTabNodeInfo.d = false;
    MsgTabStoryManager.a(QQStoryContext.a()).a(paramMsgTabNodeInfo);
    MsgTabNodeWatchedRequest localMsgTabNodeWatchedRequest = new MsgTabNodeWatchedRequest();
    localMsgTabNodeWatchedRequest.jdField_b_of_type_JavaLangString = paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString;
    localMsgTabNodeWatchedRequest.c = paramMsgTabNodeInfo.jdField_a_of_type_Int;
    localMsgTabNodeWatchedRequest.d = 4;
    localMsgTabNodeWatchedRequest.jdField_b_of_type_Long = paramMsgTabNodeInfo.e;
    CmdTaskManger.a().a(localMsgTabNodeWatchedRequest, null);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    if (!TextUtils.isEmpty(paramMsgTabNodeInfo.g)) {
      c(paramMsgTabNodeInfo.g);
    }
    StoryMsgNodeFrameLayout localStoryMsgNodeFrameLayout;
    String str;
    if (!TextUtils.isEmpty(paramMsgTabNodeInfo.j))
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramMsgTabNodeInfo.c)) {
        str = HardCodeUtil.a(2131706981);
      } else {
        str = paramMsgTabNodeInfo.c;
      }
      localStoryMsgNodeFrameLayout.setNodeName(str, paramMsgTabNodeInfo.j);
    }
    else
    {
      localStoryMsgNodeFrameLayout = this.a;
      if (TextUtils.isEmpty(paramMsgTabNodeInfo.c)) {
        str = HardCodeUtil.a(2131706980);
      } else {
        str = paramMsgTabNodeInfo.c;
      }
      localStoryMsgNodeFrameLayout.setNodeName(str, 0);
    }
    if (paramMsgTabNodeInfo.d) {
      c(paramMsgTabNodeInfo);
    }
  }
  
  protected void b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.a.setDisplayState(6);
    this.a.a(paramMsgTabNodeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.MsgNodeNewGuideViewHolder
 * JD-Core Version:    0.7.0.1
 */