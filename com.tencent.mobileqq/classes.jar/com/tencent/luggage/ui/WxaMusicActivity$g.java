package com.tencent.luggage.ui;

import android.os.Message;
import com.tencent.luggage.wxa.ql.d.a;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "onProgress"}, k=3, mv={1, 1, 16})
final class WxaMusicActivity$g
  implements d.a
{
  WxaMusicActivity$g(WxaMusicActivity paramWxaMusicActivity) {}
  
  public final void a(int paramInt1, int paramInt2)
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    WxaMusicActivity.d(this.a).b(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaMusicActivity.g
 * JD-Core Version:    0.7.0.1
 */