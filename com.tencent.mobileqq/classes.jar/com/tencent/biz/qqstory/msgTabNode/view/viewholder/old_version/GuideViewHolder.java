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
    TextView localTextView = this.d;
    if (TextUtils.isEmpty(paramMsgTabNodeInfo.l))
    {
      paramMsgTabNodeInfo = new StringBuilder();
      paramMsgTabNodeInfo.append(QQStoryConstant.a);
      paramMsgTabNodeInfo.append(HardCodeUtil.a(2131903407));
      paramMsgTabNodeInfo = paramMsgTabNodeInfo.toString();
    }
    else
    {
      paramMsgTabNodeInfo = paramMsgTabNodeInfo.l;
    }
    localTextView.setText(paramMsgTabNodeInfo);
    this.b.setImageResource(2130848418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.GuideViewHolder
 * JD-Core Version:    0.7.0.1
 */