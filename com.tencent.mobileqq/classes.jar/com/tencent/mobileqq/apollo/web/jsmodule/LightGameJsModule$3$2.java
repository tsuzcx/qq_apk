package com.tencent.mobileqq.apollo.web.jsmodule;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.apollo.game.CmGameStartChecker.ICmGameConfirmListener;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.utils.VipUtils;

class LightGameJsModule$3$2
  implements DialogInterface.OnClickListener
{
  LightGameJsModule$3$2(LightGameJsModule.3 param3, CmGameStartChecker.ICmGameConfirmListener paramICmGameConfirmListener, StartCheckParam paramStartCheckParam) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = this.a;
    if (paramDialogInterface != null) {
      paramDialogInterface.a(this.b);
    }
    VipUtils.a(null, "cmshow", "Apollo", "download_confirm", 0, 3, new String[] { String.valueOf(this.b.game.gameId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.LightGameJsModule.3.2
 * JD-Core Version:    0.7.0.1
 */