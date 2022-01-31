package com.tencent.litetransfersdk;

public abstract interface LiteTransferOperatorCallback
{
  public abstract void GetThumbFilePath(int paramInt, Session paramSession);
  
  public abstract void HandleSession(int paramInt1, long paramLong, int paramInt2, MsgHeader paramMsgHeader);
  
  public abstract void InvokeReport(ReportItem paramReportItem);
  
  public abstract boolean OnQueryAutoDownload(long paramLong, byte paramByte);
  
  public abstract void SendPbMsg(int paramInt, MsgCSBody paramMsgCSBody);
  
  public abstract boolean getAutoDownload();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferOperatorCallback
 * JD-Core Version:    0.7.0.1
 */