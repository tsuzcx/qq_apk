package com.tencent.ilivesdk.supervisionservice_interface;

import com.tencent.ilivesdk.supervisionservice_interface.model.SpvSimpleUserInfo;
import java.util.List;

public abstract interface BlockInterface$QueryBlockHistoryCallback
  extends CallbackBase
{
  public abstract void onSuccess(BlockInterface.BlockItem paramBlockItem, List<SpvSimpleUserInfo> paramList, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.supervisionservice_interface.BlockInterface.QueryBlockHistoryCallback
 * JD-Core Version:    0.7.0.1
 */