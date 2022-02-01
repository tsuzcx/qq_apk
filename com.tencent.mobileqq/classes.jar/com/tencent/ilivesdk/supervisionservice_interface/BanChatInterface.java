package com.tencent.ilivesdk.supervisionservice_interface;

import com.tencent.ilivesdk.supervisionservice_interface.model.AdminReason;
import java.util.List;

public abstract interface BanChatInterface
{
  public abstract void banChat(long paramLong1, long paramLong2, long paramLong3, int paramInt, BanChatInterface.SetBanChatCallback paramSetBanChatCallback);
  
  public abstract void cancelBanChat(long paramLong1, long paramLong2, long paramLong3, BanChatInterface.SetBanChatCallback paramSetBanChatCallback);
  
  public abstract List<AdminReason> getBanChatReasonList();
  
  public abstract void isBanedChat(long paramLong1, long paramLong2, long paramLong3, BanChatInterface.QueryIsBanedChatCallback paramQueryIsBanedChatCallback);
  
  public abstract void queryBanedHistory(long paramLong1, long paramLong2, int paramInt1, int paramInt2, BanChatInterface.QueryBanedHistoryCallback paramQueryBanedHistoryCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.supervisionservice_interface.BanChatInterface
 * JD-Core Version:    0.7.0.1
 */