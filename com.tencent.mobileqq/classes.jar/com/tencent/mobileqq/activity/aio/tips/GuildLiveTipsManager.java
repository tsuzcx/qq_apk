package com.tencent.mobileqq.activity.aio.tips;

import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XPanelContainer;

public class GuildLiveTipsManager
  extends TipsManager
{
  public GuildLiveTipsManager(AIOContext paramAIOContext, QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, AIOTipsController paramAIOTipsController, XPanelContainer paramXPanelContainer)
  {
    super(paramAIOContext, paramQQAppInterface, paramBaseSessionInfo, paramAIOTipsController, paramXPanelContainer);
  }
  
  public boolean a(TipsBarTask paramTipsBarTask, Object... paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.GuildLiveTipsManager
 * JD-Core Version:    0.7.0.1
 */