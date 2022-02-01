package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;

class EmoticonHandler$1
  implements Runnable
{
  EmoticonHandler$1(EmoticonHandler paramEmoticonHandler, IEmoticonManagerService paramIEmoticonManagerService, EmoticonResp paramEmoticonResp, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonManagerService.handleFetchEmoticonPackagesResp(true, 2, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonResp, this.jdField_a_of_type_Int);
    this.this$0.notifyUI(2, true, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonResp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.EmoticonHandler.1
 * JD-Core Version:    0.7.0.1
 */