package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionObserverImpl;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class FriendCardApolloViewController$ExploreInfoObserver
  extends ApolloExtensionObserverImpl
{
  private java.lang.ref.WeakReference<FriendCardApolloViewController> a;
  
  public FriendCardApolloViewController$ExploreInfoObserver(FriendCardApolloViewController paramFriendCardApolloViewController)
  {
    this.a = new mqq.util.WeakReference(paramFriendCardApolloViewController);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendCardApolloViewController", 1, "[onGetExploreMsg] get info end");
        }
        paramObject = new JSONObject((String)paramObject);
        if (paramObject.optInt("entry_id", -1) != 2) {
          return;
        }
        FriendCardApolloViewController localFriendCardApolloViewController = (FriendCardApolloViewController)this.a.get();
        if (localFriendCardApolloViewController == null) {
          return;
        }
        FriendCardApolloViewController.a(localFriendCardApolloViewController, paramObject.optString("icon_url"));
        QLog.d("FriendCardApolloViewController", 2, "[onGetExploreMsg] iconUrl:" + FriendCardApolloViewController.a(localFriendCardApolloViewController));
        return;
      }
      catch (Exception paramObject) {}
    } else if (QLog.isColorLevel()) {
      QLog.d("FriendCardApolloViewController", 2, "[onGetExploreMsg] result:" + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.FriendCardApolloViewController.ExploreInfoObserver
 * JD-Core Version:    0.7.0.1
 */