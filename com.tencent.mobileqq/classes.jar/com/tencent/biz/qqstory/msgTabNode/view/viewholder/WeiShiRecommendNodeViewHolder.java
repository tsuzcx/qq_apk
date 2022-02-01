package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.view.ViewGroup;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;

class WeiShiRecommendNodeViewHolder
  extends MsgNodeViewHolder
{
  public WeiShiRecommendNodeViewHolder(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561863);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    SLog.a("Q.qqstory.msgTab.WeiShiRecommendNodeViewHolder", "bindData %s", paramMsgTabNodeInfo);
    a(ThumbnailUrlHelper.b(paramMsgTabNodeInfo.g));
    this.a.setNodeName(paramMsgTabNodeInfo.c, 2130847005);
  }
  
  public void a(String paramString)
  {
    b(paramString);
  }
  
  protected void b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.a.setDisplayState(6);
    this.a.a(paramMsgTabNodeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.WeiShiRecommendNodeViewHolder
 * JD-Core Version:    0.7.0.1
 */