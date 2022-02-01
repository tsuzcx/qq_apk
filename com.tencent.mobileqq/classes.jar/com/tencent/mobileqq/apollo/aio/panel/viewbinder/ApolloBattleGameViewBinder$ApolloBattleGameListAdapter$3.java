package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import android.app.Activity;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ApolloBattleGameViewBinder$ApolloBattleGameListAdapter$3
  implements MiniAppCmdInterface
{
  ApolloBattleGameViewBinder$ApolloBattleGameListAdapter$3(ApolloBattleGameViewBinder.ApolloBattleGameListAdapter paramApolloBattleGameListAdapter, Activity paramActivity) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      QLog.d("[cmshow]ApolloBattleGameViewBinder", 1, "createUpdatableMsg success!");
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.3.1(this, paramJSONObject));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createUpdatableMsg failed! ret = ");
    localStringBuilder.append(paramJSONObject);
    QLog.e("[cmshow]ApolloBattleGameViewBinder", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.3
 * JD-Core Version:    0.7.0.1
 */