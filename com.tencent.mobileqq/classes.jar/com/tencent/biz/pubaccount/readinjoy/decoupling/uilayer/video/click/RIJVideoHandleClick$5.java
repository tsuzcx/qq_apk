package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ClickHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.ChannelInfo;

class RIJVideoHandleClick$5
  implements ClickHandler
{
  RIJVideoHandleClick$5(RIJVideoHandleClick paramRIJVideoHandleClick) {}
  
  public void onClick(View paramView)
  {
    paramView = (articlesummary.ChannelInfo)paramView.getTag();
    if (paramView != null)
    {
      if ((!paramView.bytes_channel_url.has()) || (paramView.bytes_channel_url.get() == null)) {
        break label76;
      }
      if (!TextUtils.isEmpty(paramView.bytes_channel_url.get().toStringUtf8())) {
        ReadInJoyUtils.a(RIJVideoHandleClick.a(this.a).a().a(), paramView.bytes_channel_url.get().toStringUtf8());
      }
    }
    return;
    label76:
    ReadInJoyActivityHelper.b(RIJVideoHandleClick.a(this.a).a().a(), paramView.uint32_channel_id.get(), RIJFeedsType.a(paramView), paramView.uint32_channel_type.get(), 6, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick.5
 * JD-Core Version:    0.7.0.1
 */