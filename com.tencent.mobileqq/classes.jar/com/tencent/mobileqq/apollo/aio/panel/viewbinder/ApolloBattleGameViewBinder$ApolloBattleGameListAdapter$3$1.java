package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import org.json.JSONObject;

class ApolloBattleGameViewBinder$ApolloBattleGameListAdapter$3$1
  implements Runnable
{
  ApolloBattleGameViewBinder$ApolloBattleGameListAdapter$3$1(ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.3 param3, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optString("errMsg");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloBattleGameViewBinder$ApolloBattleGameListAdapter$3.a, (CharSequence)localObject, 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.3.1
 * JD-Core Version:    0.7.0.1
 */