package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;

public class NewMessageViewHolder
  extends BaseViewHolder
{
  protected TextView c = (TextView)a(2131371912);
  
  public NewMessageViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if (paramMsgTabNodeInfo.b > 99)
    {
      this.c.setText("99+");
      return;
    }
    this.c.setText(String.valueOf(paramMsgTabNodeInfo.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.NewMessageViewHolder
 * JD-Core Version:    0.7.0.1
 */