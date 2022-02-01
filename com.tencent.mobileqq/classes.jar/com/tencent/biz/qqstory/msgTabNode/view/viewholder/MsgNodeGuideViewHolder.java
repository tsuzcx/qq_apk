package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.mobileqq.app.HardCodeUtil;

@Deprecated
public class MsgNodeGuideViewHolder
  extends MsgNodeViewHolder
{
  public MsgNodeGuideViewHolder(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561863);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    this.a.setDisplayState(5);
    this.a.setNodeName(HardCodeUtil.a(2131706957), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.MsgNodeGuideViewHolder
 * JD-Core Version:    0.7.0.1
 */