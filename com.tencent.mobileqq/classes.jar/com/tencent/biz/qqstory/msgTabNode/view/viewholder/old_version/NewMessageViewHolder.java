package com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version;

import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;

public class NewMessageViewHolder
  extends BaseViewHolder
{
  protected TextView g = (TextView)a(2131449122);
  
  public NewMessageViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if (paramMsgTabNodeInfo.i > 99)
    {
      this.g.setText("99+");
      return;
    }
    this.g.setText(String.valueOf(paramMsgTabNodeInfo.i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.NewMessageViewHolder
 * JD-Core Version:    0.7.0.1
 */