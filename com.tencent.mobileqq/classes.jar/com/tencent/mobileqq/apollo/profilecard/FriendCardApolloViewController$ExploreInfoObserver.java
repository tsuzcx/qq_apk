package com.tencent.mobileqq.apollo.profilecard;

import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class FriendCardApolloViewController$ExploreInfoObserver
  extends ApolloExtensionObserver
{
  private java.lang.ref.WeakReference<FriendCardApolloViewController> a;
  
  public FriendCardApolloViewController$ExploreInfoObserver(FriendCardApolloViewController paramFriendCardApolloViewController)
  {
    this.a = new mqq.util.WeakReference(paramFriendCardApolloViewController);
  }
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]FriendCardApolloViewController", 1, "[onGetExploreMsg] get info end");
        }
        localObject = new JSONObject((String)paramObject);
        if (((JSONObject)localObject).optInt("entry_id", -1) != 2) {
          return;
        }
        paramObject = (FriendCardApolloViewController)this.a.get();
        if (paramObject == null) {
          return;
        }
        FriendCardApolloViewController.a(paramObject, ((JSONObject)localObject).optString("icon_url"));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[onGetExploreMsg] iconUrl:");
        ((StringBuilder)localObject).append(FriendCardApolloViewController.a(paramObject));
        QLog.d("[cmshow]FriendCardApolloViewController", 2, ((StringBuilder)localObject).toString());
        return;
      }
      catch (Exception paramObject)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[onGetExploreMsg] error:");
        ((StringBuilder)localObject).append(paramObject);
        QLog.d("[cmshow]FriendCardApolloViewController", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    else if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("[onGetExploreMsg] result:");
      paramObject.append(paramBoolean);
      QLog.d("[cmshow]FriendCardApolloViewController", 2, paramObject.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.profilecard.FriendCardApolloViewController.ExploreInfoObserver
 * JD-Core Version:    0.7.0.1
 */