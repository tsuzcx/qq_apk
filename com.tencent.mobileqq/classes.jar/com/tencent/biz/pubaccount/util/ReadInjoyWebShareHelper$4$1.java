package com.tencent.biz.pubaccount.util;

import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;

class ReadInjoyWebShareHelper$4$1
  implements WxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener
{
  ReadInjoyWebShareHelper$4$1(ReadInjoyWebShareHelper.4 param4) {}
  
  public void a(BaseResp paramBaseResp)
  {
    boolean bool = true;
    if ((this.a.this$0.a == null) || (!this.a.this$0.a.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QRUtils.a(1, 2131719291);
      bool = false;
    }
    while (this.a.a)
    {
      ReadInjoyWebShareHelper.a(this.a.this$0, "we_chat", bool);
      return;
      QRUtils.a(2, 2131719309);
      continue;
      bool = false;
    }
    ReadInjoyWebShareHelper.a(this.a.this$0, "we_chat_circle", bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.4.1
 * JD-Core Version:    0.7.0.1
 */