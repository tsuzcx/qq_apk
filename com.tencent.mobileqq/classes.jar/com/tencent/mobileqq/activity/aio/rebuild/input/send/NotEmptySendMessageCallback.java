package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import android.text.Editable;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.ISendMessageCallback;
import com.tencent.mobileqq.activity.aio.core.input.SendLogicParam;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import java.util.ArrayList;

public class NotEmptySendMessageCallback
  implements ISendMessageCallback
{
  public void afterMessageSend(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam) {}
  
  public boolean beforeMessageSend(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam)
  {
    paramSendLogicParam = (FullScreenInputHelper)paramAIOContext.a(24);
    if (paramSendLogicParam.e()) {
      paramSendLogicParam.b(false);
    }
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)paramAIOContext.q().d(4);
    int i;
    if (localPhotoListPanel != null) {
      i = localPhotoListPanel.getSelectedPhotoCount();
    } else {
      i = 0;
    }
    int j;
    if (localPhotoListPanel != null) {
      j = localPhotoListPanel.getSelectedVideoCount();
    } else {
      j = 0;
    }
    return (paramSendLogicParam.i()) && (paramAIOContext.p().d().f().a().length() <= 0) && (i + j <= 0);
  }
  
  public boolean onMessageSending(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.NotEmptySendMessageCallback
 * JD-Core Version:    0.7.0.1
 */