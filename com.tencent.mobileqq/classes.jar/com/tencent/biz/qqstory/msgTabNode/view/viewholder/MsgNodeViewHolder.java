package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.view.ViewGroup;
import com.tencent.biz.qqstory.common.recyclerview.BaseViewHolder;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import java.util.List;

public class MsgNodeViewHolder
  extends BaseViewHolder
{
  public StoryMsgNodeFrameLayout a = (StoryMsgNodeFrameLayout)this.itemView;
  
  public MsgNodeViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    super.a(paramMsgTabNodeInfo);
    this.a.setTag(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
    b(paramMsgTabNodeInfo);
  }
  
  protected void b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.a.setDisplayState(0);
    if ((paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList != null) && (!paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.a.a(paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.size(), paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.size() - paramMsgTabNodeInfo.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.MsgNodeViewHolder
 * JD-Core Version:    0.7.0.1
 */