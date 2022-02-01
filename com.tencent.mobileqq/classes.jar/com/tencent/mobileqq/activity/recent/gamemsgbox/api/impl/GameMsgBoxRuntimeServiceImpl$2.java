package com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl;

import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;

class GameMsgBoxRuntimeServiceImpl$2
  implements Runnable
{
  GameMsgBoxRuntimeServiceImpl$2(GameMsgBoxRuntimeServiceImpl paramGameMsgBoxRuntimeServiceImpl, String paramString, HashMap paramHashMap) {}
  
  public void run()
  {
    VideoReport.reportEvent(this.a, GameMsgBoxRuntimeServiceImpl.access$000(this.this$0), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.api.impl.GameMsgBoxRuntimeServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */