package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo.ImageItem;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo.VideoItem;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AutoVideoItemBuilder$1
  implements View.OnClickListener
{
  AutoVideoItemBuilder$1(AutoVideoItemBuilder paramAutoVideoItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 instanceof AutoVideoItemBuilder.AutoVideoMsgViewHolder))
    {
      AutoVideoItemBuilder.AutoVideoMsgViewHolder localAutoVideoMsgViewHolder = (AutoVideoItemBuilder.AutoVideoMsgViewHolder)localObject1;
      Object localObject2 = AutoVideoItemBuilder.AutoVideoMsgViewHolder.a(localAutoVideoMsgViewHolder);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        Log.i("AutoVideoItemBuilder", "onClick: empty schema");
        localObject1 = localObject2;
      }
      else
      {
        boolean bool = ((String)localObject2).contains("&width=");
        int k = 0;
        int i;
        if ((!bool) && (!((String)localObject2).contains("?width="))) {
          i = 1;
        } else {
          i = 0;
        }
        int j = k;
        if (!((String)localObject2).contains("&height="))
        {
          j = k;
          if (!((String)localObject2).contains("?height=")) {
            j = 1;
          }
        }
        if (i == 0)
        {
          localObject1 = localObject2;
          if (j == 0) {}
        }
        else
        {
          k = ((String)localObject2).indexOf("?");
          if (k < 0)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("?width=");
            ((StringBuilder)localObject1).append(localAutoVideoMsgViewHolder.e);
            ((StringBuilder)localObject1).append("&height=");
            ((StringBuilder)localObject1).append(localAutoVideoMsgViewHolder.f);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          else if (k == ((String)localObject2).length() - 1)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("width=");
            ((StringBuilder)localObject1).append(localAutoVideoMsgViewHolder.e);
            ((StringBuilder)localObject1).append("&height=");
            ((StringBuilder)localObject1).append(localAutoVideoMsgViewHolder.f);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          else
          {
            Object localObject3 = localObject2;
            if (i != 0)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append((String)localObject2);
              ((StringBuilder)localObject1).append("&width=");
              ((StringBuilder)localObject1).append(localAutoVideoMsgViewHolder.e);
              localObject3 = ((StringBuilder)localObject1).toString();
            }
            localObject1 = localObject3;
            if (j != 0)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append((String)localObject3);
              ((StringBuilder)localObject1).append("&height=");
              ((StringBuilder)localObject1).append(localAutoVideoMsgViewHolder.f);
              localObject1 = ((StringBuilder)localObject1).toString();
            }
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onClick: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        Log.i("AutoVideoItemBuilder", ((StringBuilder)localObject2).toString());
      }
      localObject1 = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.a.jdField_a_of_type_AndroidContentContext, (String)localObject1);
      if (localObject1 != null) {
        ((JumpAction)localObject1).a();
      }
      if ((localAutoVideoMsgViewHolder.a instanceof MessageForStructing))
      {
        localObject1 = (MessageForStructing)localAutoVideoMsgViewHolder.a;
        if ((((MessageForStructing)localObject1).structingMsg instanceof StructMsgSubImageVideo))
        {
          localObject2 = (StructMsgSubImageVideo)((MessageForStructing)localObject1).structingMsg;
          localObject1 = null;
          if (((StructMsgSubImageVideo)localObject2).getVideoItem() != null) {
            localObject1 = ((StructMsgSubImageVideo)localObject2).getVideoItem().title;
          } else if (((StructMsgSubImageVideo)localObject2).getImageItem() != null) {
            localObject1 = ((StructMsgSubImageVideo)localObject2).getImageItem().title;
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
            ReportController.b(null, "dc00898", "", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "auth_aio", "clk_content", 0, 0, "", "", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, (String)localObject1);
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.AutoVideoItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */