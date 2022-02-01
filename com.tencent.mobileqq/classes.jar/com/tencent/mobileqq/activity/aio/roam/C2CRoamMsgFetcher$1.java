package com.tencent.mobileqq.activity.aio.roam;

import com.tencent.mobileqq.app.SVIPObserver;

class C2CRoamMsgFetcher$1
  extends SVIPObserver
{
  C2CRoamMsgFetcher$1(C2CRoamMsgFetcher paramC2CRoamMsgFetcher) {}
  
  public void onGetRoamType(String paramString, int paramInt)
  {
    super.onGetRoamType(paramString, paramInt);
    C2CRoamMsgFetcher.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.roam.C2CRoamMsgFetcher.1
 * JD-Core Version:    0.7.0.1
 */