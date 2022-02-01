package com.tencent.mobileqq.app.friendlist.processor;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.friend.data.ExtRspData;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class RichStatusProcessor
  extends BaseFriendProcessor
{
  public RichStatusProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public void onGetFriendInfoFinish(String paramString)
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      QLog.d("IMCore.friend.RichStatusProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
      return;
    }
    ((FriendListHandler)((QQAppInterface)this.mApp).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getRichStatus(new String[] { paramString });
  }
  
  public void onGetFriendListFinish(boolean paramBoolean, ArrayList<String> paramArrayList, ExtRspData paramExtRspData)
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      QLog.d("IMCore.friend.RichStatusProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
      return;
    }
    ((FriendListHandler)((QQAppInterface)this.mApp).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).fetchRichStatusIfNeed(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.processor.RichStatusProcessor
 * JD-Core Version:    0.7.0.1
 */