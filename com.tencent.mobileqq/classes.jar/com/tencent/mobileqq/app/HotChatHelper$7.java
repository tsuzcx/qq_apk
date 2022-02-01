package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class HotChatHelper$7
  implements AdapterView.OnItemClickListener
{
  HotChatHelper$7(ShareActionSheetBuilder paramShareActionSheetBuilder, int paramInt, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (localObject != null)
    {
      this.a.dismiss();
      int n = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).c.action;
      int m = this.b;
      localObject = "";
      if (1 == m) {
        localObject = "0X8005D50";
      }
      for (;;)
      {
        break;
        if (2 == m) {
          localObject = "0X8005D51";
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        if (n != 2)
        {
          if (n != 3)
          {
            if (n != 9)
            {
              if (n == 10) {
                ReportController.b(this.c, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "4", "", "", "");
              }
            }
            else {
              ReportController.b(this.c, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "3", "", "", "");
            }
          }
          else {
            ReportController.b(this.c, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "2", "", "", "");
          }
        }
        else {
          ReportController.b(this.c, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "1", "", "", "");
        }
      }
      if ((n == 9) || (n == 10))
      {
        if (!WXShareHelper.a().b()) {
          m = 2131918154;
        } else if (!WXShareHelper.a().c()) {
          m = 2131918155;
        } else {
          m = -1;
        }
        if (m != -1)
        {
          localObject = this.d;
          QQToast.makeText((Context)localObject, ((BaseActivity)localObject).getString(m), 0).show(this.d.getResources().getDimensionPixelSize(2131299920));
          break label548;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("邀请加入QQ热聊：");
      ((StringBuilder)localObject).append(this.e);
      localObject = ((StringBuilder)localObject).toString();
      if (n != 2)
      {
        if (n != 3)
        {
          if (n != 9)
          {
            if (n == 10) {
              HotChatHelper.b(this.d, this.e, (String)localObject, this.f, this.j, this.g, this.k);
            }
          }
          else {
            HotChatHelper.a(this.d, this.e, (String)localObject, "立即加入，一起热聊！\nQQ热聊有上百个热门话题，与同兴趣的人一起群聊。", this.j, this.g, this.k);
          }
        }
        else {
          HotChatHelper.a(this.d, this.e, (String)localObject, this.f, this.g, this.i);
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131903525));
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131903526));
        localObject = ((StringBuilder)localObject).toString();
        HotChatHelper.a(this.d, this.e, (String)localObject, this.f, this.g, this.h, this.i, false);
      }
    }
    label548:
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatHelper.7
 * JD-Core Version:    0.7.0.1
 */