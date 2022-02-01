package com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.mobileqq.app.HardCodeUtil;

public class GuideViewHolder
  extends BaseViewHolder
{
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.itemView.setTag(Integer.valueOf(3));
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (TextUtils.isEmpty(paramMsgTabNodeInfo.c))
    {
      paramMsgTabNodeInfo = new StringBuilder();
      paramMsgTabNodeInfo.append(QQStoryConstant.a);
      paramMsgTabNodeInfo.append(HardCodeUtil.a(2131705519));
      paramMsgTabNodeInfo = paramMsgTabNodeInfo.toString();
    }
    else
    {
      paramMsgTabNodeInfo = paramMsgTabNodeInfo.c;
    }
    localTextView.setText(paramMsgTabNodeInfo);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.GuideViewHolder
 * JD-Core Version:    0.7.0.1
 */