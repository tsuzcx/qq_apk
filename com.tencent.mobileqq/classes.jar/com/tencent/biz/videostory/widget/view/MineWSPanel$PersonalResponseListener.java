package com.tencent.biz.videostory.widget.view;

import WEISHI_USER_GROWTH.WEISHI.stGetPersonalPageRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import java.lang.ref.WeakReference;

final class MineWSPanel$PersonalResponseListener
  implements VSDispatchObserver.onVSRspCallBack<WEISHI.stGetPersonalPageRsp>
{
  private final WeakReference<MineWSPanel> a;
  
  public MineWSPanel$PersonalResponseListener(MineWSPanel paramMineWSPanel)
  {
    this.a = new WeakReference(paramMineWSPanel);
  }
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, WEISHI.stGetPersonalPageRsp paramstGetPersonalPageRsp)
  {
    paramBaseRequest = (MineWSPanel)this.a.get();
    if (paramBaseRequest == null) {
      return;
    }
    paramBaseRequest.a(paramstGetPersonalPageRsp, false);
    if (paramstGetPersonalPageRsp != null) {
      MineWSPanel.a(paramBaseRequest, paramstGetPersonalPageRsp.toByteArray());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.MineWSPanel.PersonalResponseListener
 * JD-Core Version:    0.7.0.1
 */