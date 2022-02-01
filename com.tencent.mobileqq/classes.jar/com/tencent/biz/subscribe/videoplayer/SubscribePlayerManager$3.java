package com.tencent.biz.subscribe.videoplayer;

import android.widget.TextView;
import com.tencent.biz.subscribe.framework.BaseVideoViewListenerSets;
import com.tencent.mobileqq.activity.aio.item.AutoVideoItemBuilder.AutoVideoMsgViewHolder;
import java.util.Map;

class SubscribePlayerManager$3
  extends BaseVideoViewListenerSets
{
  SubscribePlayerManager$3(SubscribePlayerManager paramSubscribePlayerManager, AutoVideoItemBuilder.AutoVideoMsgViewHolder paramAutoVideoMsgViewHolder) {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)SubscribePlayerManager.e(this.b).get(Integer.valueOf(this.a.l));
    if ((localInteger != null) && (localInteger.intValue() > paramInt2) && (paramInt1 != localInteger.intValue()) && (Math.abs(paramInt1 - localInteger.intValue()) > 100))
    {
      this.a.d.setText((CharSequence)SubscribePlayerManager.f(this.b).get(Integer.valueOf(this.a.l)));
      return;
    }
    SubscribePlayerManager.e(this.b).put(Integer.valueOf(this.a.l), Integer.valueOf(paramInt2));
    SubscribePlayerManager.f(this.b).put(Integer.valueOf(this.a.l), paramString);
    this.a.d.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.SubscribePlayerManager.3
 * JD-Core Version:    0.7.0.1
 */