package com.tencent.biz.troop;

import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.qroute.QRoute;

class TroopMemberApiService$IncomingHandler$9
  implements Runnable
{
  TroopMemberApiService$IncomingHandler$9(TroopMemberApiService.IncomingHandler paramIncomingHandler, long paramLong, int paramInt) {}
  
  public void run()
  {
    ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.9
 * JD-Core Version:    0.7.0.1
 */