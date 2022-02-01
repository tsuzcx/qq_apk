package com.tencent.av.redpacket.ui;

import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;

class RedPacketShareFragment$3$1$2
  implements WXShareHelper.WXShareListener
{
  RedPacketShareFragment$3$1$2(RedPacketShareFragment.3.1 param1) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((RedPacketShareFragment.d(this.a.a.this$0) == null) || (!RedPacketShareFragment.d(this.a.a.this$0).equals(paramBaseResp.transaction))) {
      return;
    }
    QLog.d("RedPacketShareFragment", 1, "WL_DEBUG ActionSheetAdapter.CHANNEL_WX_FRIEND_CIRCLE onWXShareResp resp.errCode = " + paramBaseResp.errCode);
    switch (paramBaseResp.errCode)
    {
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      RedPacketShareFragment.a("0X8008CF8", 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketShareFragment.3.1.2
 * JD-Core Version:    0.7.0.1
 */