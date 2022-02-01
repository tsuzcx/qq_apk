package com.tencent.mobileqq.activity.aio.panel.chatpanelbar;

import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.UpdateParams;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.reporter.IChatPanelReporter;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public abstract interface IChatPanelBarController
{
  public abstract List<int[]> a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie);
  
  public abstract void a();
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(BaseChatPie paramBaseChatPie, UpdateParams paramUpdateParams);
  
  public abstract void a(HelperProvider paramHelperProvider);
  
  public abstract void a(IChatPanelReporter paramIChatPanelReporter);
  
  public abstract void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie);
  
  public abstract void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int[] paramArrayOfInt, int paramInt);
  
  public abstract void a(List<int[]> paramList);
  
  public abstract void a(boolean paramBoolean, BaseChatPie paramBaseChatPie);
  
  public abstract boolean a(View paramView);
  
  public abstract void b(boolean paramBoolean, BaseChatPie paramBaseChatPie);
  
  public abstract boolean b(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarController
 * JD-Core Version:    0.7.0.1
 */