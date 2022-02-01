package com.tencent.mobileqq.apollo.player.action;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/action/CMSAction$Companion$MODE;", "", "(Ljava/lang/String;I)V", "toReportFeatureId", "", "ACTION_MODE_PLAY", "ACTION_MODE_RECORD", "ACTION_MODE_FRAME", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public enum CMSAction$Companion$MODE
{
  static
  {
    MODE localMODE1 = new MODE("ACTION_MODE_PLAY", 0);
    ACTION_MODE_PLAY = localMODE1;
    MODE localMODE2 = new MODE("ACTION_MODE_RECORD", 1);
    ACTION_MODE_RECORD = localMODE2;
    MODE localMODE3 = new MODE("ACTION_MODE_FRAME", 2);
    ACTION_MODE_FRAME = localMODE3;
    $VALUES = new MODE[] { localMODE1, localMODE2, localMODE3 };
  }
  
  private CMSAction$Companion$MODE() {}
  
  public final int toReportFeatureId()
  {
    switch (amvn.a[ordinal()])
    {
    default: 
      return -1;
    case 1: 
      return 134;
    }
    return 135;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.action.CMSAction.Companion.MODE
 * JD-Core Version:    0.7.0.1
 */