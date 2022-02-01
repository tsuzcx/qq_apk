package com.tencent.mobileqq.apollo.view.hippy;

import android.app.Activity;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuc", "", "ret", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "onCmdListener"}, k=3, mv={1, 1, 16})
final class CmBattleGameNativeModule$sendUpdatableMsg$1
  implements MiniAppCmdInterface
{
  CmBattleGameNativeModule$sendUpdatableMsg$1(CmBattleGameNativeModule paramCmBattleGameNativeModule, Promise paramPromise) {}
  
  public final void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      this.b.resolve("send success");
      QLog.d("CmBattleGameNativeModule", 1, "createUpdatableMsg success!");
      return;
    }
    CmBattleGameNativeModule.access$getActivity(this.a).runOnUiThread((Runnable)new CmBattleGameNativeModule.sendUpdatableMsg.1.1(this, paramJSONObject));
    this.b.reject("send error");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createUpdatableMsg failed! ret = ");
    localStringBuilder.append(paramJSONObject);
    QLog.e("CmBattleGameNativeModule", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.hippy.CmBattleGameNativeModule.sendUpdatableMsg.1
 * JD-Core Version:    0.7.0.1
 */