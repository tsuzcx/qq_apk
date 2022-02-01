package com.tencent.mobileqq.apollo.api.impl;

import android.view.ViewGroup;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionObserverImpl;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerContext;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerStatus;
import com.tencent.mobileqq.apollo.drawer.ExploreDrawerStatus;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class SettingMeApolloViewControllerImpl$2
  extends ApolloExtensionObserverImpl
{
  SettingMeApolloViewControllerImpl$2(SettingMeApolloViewControllerImpl paramSettingMeApolloViewControllerImpl) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    if (paramBoolean) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("SettingMeApolloViewController", 1, "[onGetExploreMsg] get info end");
        }
        QQSettingMe localQQSettingMe = (QQSettingMe)SettingMeApolloViewControllerImpl.access$000(this.a).get();
        if (localQQSettingMe == null) {
          return;
        }
        QQAppInterface localQQAppInterface = localQQSettingMe.a();
        if (localQQAppInterface == null) {
          return;
        }
        ViewGroup localViewGroup = (ViewGroup)SettingMeApolloViewControllerImpl.access$100(this.a).get();
        if (localViewGroup == null) {
          return;
        }
        Object localObject = new JSONObject((String)paramObject);
        if (((JSONObject)localObject).optInt("entry_id", -1) != 1) {
          return;
        }
        localObject = new ExploreDrawerStatus(localQQAppInterface, (JSONObject)localObject, localQQSettingMe);
        this.a.mApolloDrawer.a((ApolloDrawerStatus)localObject);
        if ((localQQSettingMe.a()) && (SettingMeApolloViewControllerImpl.access$200(this.a) > 0)) {
          this.a.mApolloDrawer.a(SettingMeApolloViewControllerImpl.access$300(this.a), localViewGroup.getContext(), localQQAppInterface, this.a.mRoleId);
        }
        QLog.d("SettingMeApolloViewController", 2, "[onGetExploreMsg] onGetExploreMsg data:" + paramObject.toString());
        return;
      }
      catch (Exception paramObject) {}
    } else {
      QLog.d("SettingMeApolloViewController", 1, "[onGetExploreMsg] result:" + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.SettingMeApolloViewControllerImpl.2
 * JD-Core Version:    0.7.0.1
 */