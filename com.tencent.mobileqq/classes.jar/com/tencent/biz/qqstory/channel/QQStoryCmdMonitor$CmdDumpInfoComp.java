package com.tencent.biz.qqstory.channel;

import java.util.Comparator;

class QQStoryCmdMonitor$CmdDumpInfoComp
  implements Comparator<QQStoryCmdHandler.CmdDumpInfo>
{
  private QQStoryCmdMonitor$CmdDumpInfoComp(QQStoryCmdMonitor paramQQStoryCmdMonitor) {}
  
  public int a(QQStoryCmdHandler.CmdDumpInfo paramCmdDumpInfo1, QQStoryCmdHandler.CmdDumpInfo paramCmdDumpInfo2)
  {
    return paramCmdDumpInfo2.d - paramCmdDumpInfo1.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.QQStoryCmdMonitor.CmdDumpInfoComp
 * JD-Core Version:    0.7.0.1
 */