package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import android.app.Activity;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ApolloBattleGameViewBinder$ApolloBattleGameListAdapter$2
  implements MiniAppCmdInterface
{
  ApolloBattleGameViewBinder$ApolloBattleGameListAdapter$2(ApolloBattleGameViewBinder.ApolloBattleGameListAdapter paramApolloBattleGameListAdapter, Activity paramActivity) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      QLog.d("ApolloBattleGameViewBinder", 1, "createUpdatableMsg success!");
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.2.1(this, paramJSONObject));
    QLog.e("ApolloBattleGameViewBinder", 1, "createUpdatableMsg failed! ret = " + paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.2
 * JD-Core Version:    0.7.0.1
 */