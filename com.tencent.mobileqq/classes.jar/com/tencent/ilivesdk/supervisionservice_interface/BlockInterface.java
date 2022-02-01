package com.tencent.ilivesdk.supervisionservice_interface;

public abstract interface BlockInterface
{
  public abstract void blockUser(long paramLong, BlockInterface.BlockItem paramBlockItem, BlockInterface.SetBlockCallback paramSetBlockCallback);
  
  public abstract void cancelBlockUser(long paramLong, BlockInterface.BlockItem paramBlockItem, BlockInterface.SetBlockCallback paramSetBlockCallback);
  
  public abstract void isBlocked(long paramLong, BlockInterface.QueryIsBlockedUserCallback paramQueryIsBlockedUserCallback);
  
  public abstract void queryBlockHistory(BlockInterface.BlockItem paramBlockItem, int paramInt1, int paramInt2, BlockInterface.QueryBlockHistoryCallback paramQueryBlockHistoryCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.supervisionservice_interface.BlockInterface
 * JD-Core Version:    0.7.0.1
 */