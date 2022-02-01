package com.tencent.mobileqq.apollo.drawer.impl;

import android.view.ViewGroup;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerContext;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerStrategy;
import com.tencent.mobileqq.apollo.drawer.ExploreDrawerStrategy;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class SettingMeApolloViewControllerImpl$2
  extends ApolloExtensionObserver
{
  SettingMeApolloViewControllerImpl$2(SettingMeApolloViewControllerImpl paramSettingMeApolloViewControllerImpl) {}
  
  protected void e(boolean paramBoolean, Object paramObject)
  {
    super.e(paramBoolean, paramObject);
    if (!paramBoolean)
    {
      paramObject = new StringBuilder();
      paramObject.append("[onGetExploreMsg] result:");
      paramObject.append(paramBoolean);
      QLog.d("[cmshow][SettingMeApolloViewController]", 1, paramObject.toString());
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][SettingMeApolloViewController]", 1, "[onGetExploreMsg] get info end");
      }
      Object localObject2 = (QQSettingMe)SettingMeApolloViewControllerImpl.access$500(this.a).get();
      if (localObject2 == null) {
        return;
      }
      localObject1 = (QQAppInterface)((QQSettingMe)localObject2).h();
      if (localObject1 == null) {
        return;
      }
      ViewGroup localViewGroup = (ViewGroup)SettingMeApolloViewControllerImpl.access$600(this.a).get();
      if (localViewGroup == null) {
        return;
      }
      JSONObject localJSONObject = new JSONObject((String)paramObject);
      if (localJSONObject.optInt("entry_id", -1) != 1) {
        return;
      }
      localObject2 = new ExploreDrawerStrategy((QQAppInterface)localObject1, localJSONObject, (QQSettingMe)localObject2);
      SettingMeApolloViewControllerImpl.access$700(this.a).a((ApolloDrawerStrategy)localObject2);
      if ((QQSettingMe.i()) && (SettingMeApolloViewControllerImpl.access$800(this.a) > 0)) {
        SettingMeApolloViewControllerImpl.access$700(this.a).a(SettingMeApolloViewControllerImpl.access$900(this.a), localViewGroup.getContext(), (QQAppInterface)localObject1, SettingMeApolloViewControllerImpl.access$1000(this.a));
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[onGetExploreMsg] onGetExploreMsg data:");
      ((StringBuilder)localObject1).append(paramObject.toString());
      QLog.d("[cmshow][SettingMeApolloViewController]", 2, ((StringBuilder)localObject1).toString());
      return;
    }
    catch (Exception paramObject)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[onGetExploreMsg] error:");
      ((StringBuilder)localObject1).append(paramObject);
      QLog.d("[cmshow][SettingMeApolloViewController]", 1, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.impl.SettingMeApolloViewControllerImpl.2
 * JD-Core Version:    0.7.0.1
 */