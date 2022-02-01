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
  public void a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam) {}
  
  public boolean a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam)
  {
    paramSendLogicParam = (FullScreenInputHelper)paramAIOContext.a(24);
    if (paramSendLogicParam.c()) {
      paramSendLogicParam.a(false);
    }
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)paramAIOContext.a().b(4);
    int i;
    if (localPhotoListPanel != null) {
      i = localPhotoListPanel.b();
    } else {
      i = 0;
    }
    int j;
    if (localPhotoListPanel != null) {
      j = localPhotoListPanel.c();
    } else {
      j = 0;
    }
    return (paramSendLogicParam.d()) && (paramAIOContext.a().a().a().a().length() <= 0) && (i + j <= 0);
  }
  
  public boolean a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.NotEmptySendMessageCallback
 * JD-Core Version:    0.7.0.1
 */