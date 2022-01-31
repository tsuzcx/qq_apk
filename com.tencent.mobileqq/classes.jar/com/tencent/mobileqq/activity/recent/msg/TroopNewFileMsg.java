package com.tencent.mobileqq.activity.recent.msg;

import android.content.Context;

public class TroopNewFileMsg
  extends TroopAtMsg
{
  public int c;
  
  public TroopNewFileMsg(Context paramContext, int paramInt)
  {
    this.c = paramInt;
    if (paramInt == 0) {
      this.a = "[有新照片]";
    }
    while (paramInt != 1) {
      return;
    }
    this.a = "[有新文件]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.TroopNewFileMsg
 * JD-Core Version:    0.7.0.1
 */