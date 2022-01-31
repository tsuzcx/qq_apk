package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;

public class AllStoryViewHolder
  extends BaseViewHolder
{
  public AllStoryViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText("全部");
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.AllStoryViewHolder
 * JD-Core Version:    0.7.0.1
 */