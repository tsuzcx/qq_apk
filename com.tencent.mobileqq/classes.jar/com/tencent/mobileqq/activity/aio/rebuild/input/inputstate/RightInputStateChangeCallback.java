package com.tencent.mobileqq.activity.aio.rebuild.input.inputstate;

import android.text.Editable;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.IInputStateChangeCallback;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.AIOInputRightHelper;
import com.tencent.mobileqq.activity.aio.helper.ReplyHelper;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomContext;
import com.tencent.mobileqq.flashchat.RichTextChatManager;

public class RightInputStateChangeCallback
  implements IInputStateChangeCallback
{
  public void a(int paramInt, AIOContext paramAIOContext)
  {
    AIOInputRightHelper localAIOInputRightHelper = (AIOInputRightHelper)paramAIOContext.a(117);
    if (paramInt == 0)
    {
      ReplyHelper localReplyHelper = (ReplyHelper)paramAIOContext.a(119);
      if ((paramAIOContext.a().a().a().a().length() > 0) && (localReplyHelper.a() == null) && (!(paramAIOContext instanceof GameRoomContext)) && (RichTextChatManager.a(paramAIOContext.a()).b(paramAIOContext.a()))) {
        localAIOInputRightHelper.a();
      }
    }
    else if (paramInt == 2)
    {
      localAIOInputRightHelper.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.inputstate.RightInputStateChangeCallback
 * JD-Core Version:    0.7.0.1
 */