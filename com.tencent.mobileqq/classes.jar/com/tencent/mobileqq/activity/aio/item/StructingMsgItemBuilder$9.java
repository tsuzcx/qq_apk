package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StructingMsgItemBuilder$9
  implements View.OnClickListener
{
  StructingMsgItemBuilder$9(StructingMsgItemBuilder paramStructingMsgItemBuilder, AbsShareMsg paramAbsShareMsg) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.a.mMsgActionData;
    int i = this.a.uinType;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = JumpParser.a(this.b.d, this.b.e, (String)localObject);
      if (localObject != null)
      {
        ((JumpAction)localObject).c("webview");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(i);
        localStringBuilder.append("");
        ((JumpAction)localObject).a("uin_type", localStringBuilder.toString());
        ((JumpAction)localObject).a();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.9
 * JD-Core Version:    0.7.0.1
 */