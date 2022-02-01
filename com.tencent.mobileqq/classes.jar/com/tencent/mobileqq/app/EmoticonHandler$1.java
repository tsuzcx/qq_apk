package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;

class EmoticonHandler$1
  implements Runnable
{
  EmoticonHandler$1(EmoticonHandler paramEmoticonHandler, IEmoticonManagerService paramIEmoticonManagerService, EmoticonResp paramEmoticonResp, int paramInt) {}
  
  public void run()
  {
    this.a.handleFetchEmoticonPackagesResp(true, 2, this.b, this.c);
    this.this$0.notifyUI(2, true, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.EmoticonHandler.1
 * JD-Core Version:    0.7.0.1
 */