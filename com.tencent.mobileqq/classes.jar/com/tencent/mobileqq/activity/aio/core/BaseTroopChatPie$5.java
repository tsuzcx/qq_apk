package com.tencent.mobileqq.activity.aio.core;

import afii;
import android.text.Editable;
import android.text.SpannableString;
import bcef;
import bevq;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

public class BaseTroopChatPie$5
  implements Runnable
{
  public BaseTroopChatPie$5(afii paramafii, boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      i = this.this$0.input.getSelectionStart();
      this.this$0.input.getEditableText().delete(i - 1, i);
    }
    SpannableString localSpannableString = bevq.a(this.this$0.app, this.this$0.mActivity, this.this$0.sessionInfo.curFriendUin, this.jdField_a_of_type_JavaLangString, this.b, this.this$0.b(), this.this$0.input, true);
    if ((localSpannableString == null) || (localSpannableString.length() == 0)) {}
    do
    {
      return;
      int j = this.this$0.input.getSelectionStart();
      i = j;
      if (j < 0) {
        i = 0;
      }
      this.this$0.input.getEditableText().insert(i, localSpannableString);
      this.this$0.root.a(1);
      if (this.jdField_a_of_type_Int == 1)
      {
        bcef.b(this.this$0.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Press_AIOhead_sendatmsg", 0, 0, this.this$0.sessionInfo.curFriendUin, "", "", "");
        return;
      }
    } while (this.jdField_a_of_type_Int != 4);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("0")))
    {
      bcef.b(this.this$0.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_atallmber_sendatallmsg", 0, 0, this.this$0.sessionInfo.curFriendUin, "", "", "");
      return;
    }
    bcef.b(this.this$0.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Input_atmber_sendatmsg", 0, 0, this.this$0.sessionInfo.curFriendUin, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie.5
 * JD-Core Version:    0.7.0.1
 */