package com.tencent.biz.troop;

import com.tencent.mobileqq.app.TroopHandler;
import cooperation.troop.TroopPluginManager.TroopPluginCallback;

class TroopMemberApiService$IncomingHandler$3
  implements TroopPluginManager.TroopPluginCallback
{
  TroopMemberApiService$IncomingHandler$3(TroopMemberApiService.IncomingHandler paramIncomingHandler, TroopHandler paramTroopHandler, String paramString1, int paramInt, String paramString2) {}
  
  public void onInstallFinish(int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), 510, 0, this.jdField_a_of_type_Int, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.3
 * JD-Core Version:    0.7.0.1
 */