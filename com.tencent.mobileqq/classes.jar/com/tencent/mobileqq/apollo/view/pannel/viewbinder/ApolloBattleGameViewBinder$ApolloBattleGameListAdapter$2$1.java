package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import org.json.JSONObject;

class ApolloBattleGameViewBinder$ApolloBattleGameListAdapter$2$1
  implements Runnable
{
  ApolloBattleGameViewBinder$ApolloBattleGameListAdapter$2$1(ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.2 param2, JSONObject paramJSONObject) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject != null)
    {
      String str = this.jdField_a_of_type_OrgJsonJSONObject.optString("errMsg");
      if (!TextUtils.isEmpty(str)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloBattleGameViewBinder$ApolloBattleGameListAdapter$2.a, str, 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */