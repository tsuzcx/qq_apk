package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GrayTipsItemBuilder$14
  implements View.OnClickListener
{
  GrayTipsItemBuilder$14(GrayTipsItemBuilder paramGrayTipsItemBuilder, MessageRecord paramMessageRecord, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = UITools.a(this.c.a, this.a.frienduin);
    ReportController.b(null, "CliOper", "", "", "0X800A8D8", "0X800A8D8", this.b, 0, "", "", "", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tel:");
      localStringBuilder.append((String)localObject);
      localObject = new Intent("android.intent.action.DIAL", Uri.parse(localStringBuilder.toString()));
      paramView.getContext().startActivity((Intent)localObject);
    }
    else
    {
      QQToast.makeText(BaseApplicationImpl.getContext(), 2131893469, 0).show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.14
 * JD-Core Version:    0.7.0.1
 */