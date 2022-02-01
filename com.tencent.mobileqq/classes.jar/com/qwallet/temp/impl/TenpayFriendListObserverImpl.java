package com.qwallet.temp.impl;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.qwallet.temp.IQwTemp;
import com.qwallet.temp.ITenpayFriendListObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.ipc.CorpReq;
import cooperation.qwallet.plugin.ipc.CorpResp;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class TenpayFriendListObserverImpl
  extends FriendListObserver
  implements ITenpayFriendListObserver
{
  private HashMap<String, ResultReceiver> mRecieverMap = new HashMap();
  
  public void add(String paramString, ResultReceiver paramResultReceiver)
  {
    this.mRecieverMap.put(paramString, paramResultReceiver);
  }
  
  public void destroy()
  {
    this.mRecieverMap.clear();
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    Object localObject = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getRuntime();
    if ((paramBoolean) && (paramString != null))
    {
      if (localObject == null) {
        return;
      }
      CorpResp localCorpResp = new CorpResp();
      localCorpResp.corpReqType = CorpReq.corpReqType;
      localCorpResp.userNick = ((IQwTemp)QRoute.api(IQwTemp.class)).ContactUtils$getBuddyName((AppRuntime)localObject, paramString, false);
      localObject = new Bundle();
      localCorpResp.toBundle((Bundle)localObject);
      paramString = (ResultReceiver)this.mRecieverMap.remove(paramString);
      if (paramString == null) {
        return;
      }
      paramString.send(0, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.qwallet.temp.impl.TenpayFriendListObserverImpl
 * JD-Core Version:    0.7.0.1
 */