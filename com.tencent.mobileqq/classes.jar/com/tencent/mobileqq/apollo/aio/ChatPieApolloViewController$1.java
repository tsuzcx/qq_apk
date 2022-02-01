package com.tencent.mobileqq.apollo.aio;

import com.tencent.mobileqq.apollo.statistics.CmShowStatUtil;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.mobileqq.cmshow.engine.statistic.IScriptStatistic;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

class ChatPieApolloViewController$1
  implements IScriptStatistic
{
  ChatPieApolloViewController$1(ChatPieApolloViewController paramChatPieApolloViewController) {}
  
  public void a(@NotNull Script paramScript) {}
  
  public void b(@NotNull Script paramScript)
  {
    if (QLog.isColorLevel())
    {
      paramScript = paramScript.e();
      if (paramScript.contains("CMShowDefActionName"))
      {
        CmShowStatUtil.b("exeCmshow0");
        return;
      }
      if (paramScript.contains("commonInit")) {
        CmShowStatUtil.b("exeCommon");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ChatPieApolloViewController.1
 * JD-Core Version:    0.7.0.1
 */