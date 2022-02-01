package com.tencent.mobileqq.apollo.api.player.action;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/player/action/MODE;", "", "(Ljava/lang/String;I)V", "toReportFeatureId", "", "ACTION_MODE_PLAY", "ACTION_MODE_RECORD_APNG", "ACTION_MODE_RECORD_GIF", "ACTION_MODE_FRAME", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public enum MODE
{
  static
  {
    MODE localMODE1 = new MODE("ACTION_MODE_PLAY", 0);
    ACTION_MODE_PLAY = localMODE1;
    MODE localMODE2 = new MODE("ACTION_MODE_RECORD_APNG", 1);
    ACTION_MODE_RECORD_APNG = localMODE2;
    MODE localMODE3 = new MODE("ACTION_MODE_RECORD_GIF", 2);
    ACTION_MODE_RECORD_GIF = localMODE3;
    MODE localMODE4 = new MODE("ACTION_MODE_FRAME", 3);
    ACTION_MODE_FRAME = localMODE4;
    $VALUES = new MODE[] { localMODE1, localMODE2, localMODE3, localMODE4 };
  }
  
  private MODE() {}
  
  public final int toReportFeatureId()
  {
    switch (MODE.WhenMappings.a[ordinal()])
    {
    default: 
      return -1;
    case 1: 
      return 134;
    case 2: 
      return 135;
    }
    return 140;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.player.action.MODE
 * JD-Core Version:    0.7.0.1
 */