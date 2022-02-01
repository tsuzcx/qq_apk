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
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optString("errMsg");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        QQToast.makeText(this.b.a, (CharSequence)localObject, 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.3.1
 * JD-Core Version:    0.7.0.1
 */