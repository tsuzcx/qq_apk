package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class ShareModule$1
  implements AdapterView.OnItemClickListener
{
  ShareModule$1(ShareModule paramShareModule, int paramInt, APICallback paramAPICallback) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 != null)
    {
      this.c.b.dismiss();
      int i = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.action;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 9)
            {
              if (i == 10) {
                paramLong = 3L;
              }
            }
            else {
              paramLong = 2L;
            }
          }
          else {
            paramLong = 1L;
          }
        }
        else {
          paramLong = 0L;
        }
      }
      else {
        paramLong = 4L;
      }
      int j = (int)paramLong;
      if ((paramLong == 2L) || (paramLong == 3L))
      {
        if (!WXShareHelper.a().b()) {
          i = 2131918154;
        } else if (!WXShareHelper.a().c()) {
          i = 2131918155;
        } else {
          i = -1;
        }
        if (i != -1)
        {
          localObject1 = BaseApplicationImpl.getContext();
          QQToast.makeText((Context)localObject1, ((Context)localObject1).getString(i), 0).show(this.a);
        }
      }
      for (;;)
      {
        break;
        localObject1 = new JSONObject();
        Object localObject2;
        try
        {
          ((JSONObject)localObject1).put("selectChanel", j);
          DoraemonUtil.a(this.b, (JSONObject)localObject1);
        }
        catch (Exception localException)
        {
          String str = localException.getMessage();
          QLog.e("DoraemonApi.ShareModule", 1, "put channel failed!");
          APICallback localAPICallback = this.b;
          localObject2 = str;
          if (str == null) {
            localObject2 = "";
          }
          DoraemonUtil.a(localAPICallback, -1, (String)localObject2);
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onItemClick.chooseChannel: ");
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append(paramLong);
          QLog.i("DoraemonApi.ShareModule", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.ShareModule.1
 * JD-Core Version:    0.7.0.1
 */