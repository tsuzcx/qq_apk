package com.tencent.mobileqq.app;

import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import java.util.HashSet;

class TroopHandler$9
  implements WadlTrpcListener
{
  TroopHandler$9(TroopHandler paramTroopHandler) {}
  
  public HashSet<String> a()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("/v1/3");
    localHashSet.add("/v1/4");
    return localHashSet;
  }
  
  public void a(Intent paramIntent, String paramString, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    if (paramString.equals("/v1/3")) {
      TroopHandler.a(this.a, paramIntent, paramLong, paramTrpcInovkeRsp);
    }
    while (!paramString.equals("/v1/4")) {
      return;
    }
    TroopHandler.b(this.a, paramIntent, paramLong, paramTrpcInovkeRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopHandler.9
 * JD-Core Version:    0.7.0.1
 */