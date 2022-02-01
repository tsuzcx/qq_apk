package com.tencent.mobileqq.apollo.meme.action;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/meme/action/MODE;", "", "(Ljava/lang/String;I)V", "ACTION_MODE_RECORD_APNG", "ACTION_MODE_RECORD_GIF", "ACTION_MODE_FRAME", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public enum MODE
{
  static
  {
    MODE localMODE1 = new MODE("ACTION_MODE_RECORD_APNG", 0);
    ACTION_MODE_RECORD_APNG = localMODE1;
    MODE localMODE2 = new MODE("ACTION_MODE_RECORD_GIF", 1);
    ACTION_MODE_RECORD_GIF = localMODE2;
    MODE localMODE3 = new MODE("ACTION_MODE_FRAME", 2);
    ACTION_MODE_FRAME = localMODE3;
    $VALUES = new MODE[] { localMODE1, localMODE2, localMODE3 };
  }
  
  private MODE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.action.MODE
 * JD-Core Version:    0.7.0.1
 */