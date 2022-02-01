package com.tencent.mobileqq.apollo.view.hippy;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class CmBattleGameNativeModule$sendUpdatableMsg$1$1
  implements Runnable
{
  CmBattleGameNativeModule$sendUpdatableMsg$1$1(CmBattleGameNativeModule.sendUpdatableMsg.1 param1, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (CharSequence)((JSONObject)localObject).optString("errMsg");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        QQToast.makeText((Context)CmBattleGameNativeModule.access$getActivity(this.this$0.a), (CharSequence)localObject, 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.hippy.CmBattleGameNativeModule.sendUpdatableMsg.1.1
 * JD-Core Version:    0.7.0.1
 */