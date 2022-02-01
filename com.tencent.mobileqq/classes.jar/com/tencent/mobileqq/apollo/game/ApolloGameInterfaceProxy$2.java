package com.tencent.mobileqq.apollo.game;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.game.process.data.CmGameOpenIdFinder.OpenIdListener;
import com.tencent.mobileqq.qipc.QIPCClientHelper;

class ApolloGameInterfaceProxy$2
  implements CmGameOpenIdFinder.OpenIdListener
{
  ApolloGameInterfaceProxy$2(ApolloGameInterfaceProxy paramApolloGameInterfaceProxy, int paramInt, String paramString) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = new Bundle();
    paramString1.putInt("type", this.jdField_a_of_type_Int);
    paramString1.putString("uin", paramString2);
    paramString2 = new ApolloGameInterfaceProxy.2.1(this);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_get_accountInfo", paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameInterfaceProxy.2
 * JD-Core Version:    0.7.0.1
 */