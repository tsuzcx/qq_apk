package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.util.ShareUtils.ShareImageUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.screendetect.ScreenShotFragment.ActionSheetItemViewHolder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import org.json.JSONException;
import org.json.JSONObject;

class NativeShareView$2
  implements AdapterView.OnItemClickListener
{
  NativeShareView$2(NativeShareView paramNativeShareView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeShareView", 2, "OnItemClickListener : position = " + paramInt + ", view = " + paramView + ", id = " + paramLong);
    }
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    if (NativeShareView.a(this.a) != null) {
      NativeShareView.a(this.a).run();
    }
    int i = ((ScreenShotFragment.ActionSheetItemViewHolder)paramAdapterView).a.action;
    paramInt = 0;
    switch (i)
    {
    }
    for (;;)
    {
      paramAdapterView = new JSONObject();
      try
      {
        paramAdapterView.put("channel_type", paramInt);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800A3BE", "0X800A3BE", 0, 0, "", "", "", paramAdapterView.toString(), false);
        return;
        paramInt = 6;
        ShareImageUtils.a(NativeShareView.a(this.a));
        continue;
        ShareImageUtils.a((Activity)NativeShareView.a(this.a));
        paramInt = 1;
        continue;
        ShareImageUtils.a((BaseActivity)NativeShareView.a(this.a));
        paramInt = 2;
        continue;
        ShareImageUtils.b((Activity)NativeShareView.a(this.a));
        paramInt = 3;
        continue;
        ShareImageUtils.c((Activity)NativeShareView.a(this.a));
        paramInt = 4;
      }
      catch (JSONException paramView)
      {
        for (;;)
        {
          QLog.e("NativeShareView", 1, paramView, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeShareView.2
 * JD-Core Version:    0.7.0.1
 */