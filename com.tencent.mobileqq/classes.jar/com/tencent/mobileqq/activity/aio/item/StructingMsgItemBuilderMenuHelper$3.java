package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.structmsg.AbsStructMsg;

class StructingMsgItemBuilderMenuHelper$3
  implements DialogInterface.OnClickListener
{
  StructingMsgItemBuilderMenuHelper$3(StructingMsgItemBuilderMenuHelper paramStructingMsgItemBuilderMenuHelper, MessageForStructing paramMessageForStructing, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Bundle localBundle = new Bundle();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg.source_puin != null) && (!"".equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg.source_puin))) {
      localBundle.putString("source_puin", this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg.source_puin);
    }
    localBundle.putInt("forward_type", -3);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg.mCommentText = null;
    localBundle.putInt("structmsg_service_id", this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg.mMsgServiceID);
    localBundle.putByteArray("stuctmsg_bytes", this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg.getBytes());
    localBundle.putLong("structmsg_uniseq", this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq);
    localBundle.putInt("accostType", this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg.sourceAccoutType);
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilderMenuHelper.3
 * JD-Core Version:    0.7.0.1
 */