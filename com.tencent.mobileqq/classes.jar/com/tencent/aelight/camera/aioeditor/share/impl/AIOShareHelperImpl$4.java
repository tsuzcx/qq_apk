package com.tencent.aelight.camera.aioeditor.share.impl;

import com.tencent.aelight.camera.aioeditor.share.AIOShareObject;
import com.tencent.aelight.camera.aioeditor.share.IAIOShareHelper.AIOWXShareListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class AIOShareHelperImpl$4
  implements WXShareHelper.WXShareListener
{
  AIOShareHelperImpl$4(AIOShareHelperImpl paramAIOShareHelperImpl, IAIOShareHelper.AIOWXShareListener paramAIOWXShareListener, int paramInt, String paramString, AIOShareObject paramAIOShareObject) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("send to wechat result, errCode = ");
    ((StringBuilder)localObject).append(paramBaseResp.errCode);
    ((StringBuilder)localObject).append(", errStr = ");
    ((StringBuilder)localObject).append(paramBaseResp.errStr);
    AEQLog.b("AIOShareHelperImpl", ((StringBuilder)localObject).toString());
    WXShareHelper.a().b(this);
    localObject = this.a;
    boolean bool;
    if ((paramBaseResp != null) && (paramBaseResp.errCode == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    ((IAIOShareHelper.AIOWXShareListener)localObject).a(bool, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.share.impl.AIOShareHelperImpl.4
 * JD-Core Version:    0.7.0.1
 */