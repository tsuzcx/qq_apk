package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

class GrayTipsItemBuilder$TeamWorkFileImportTipsClickableSpan
  extends ClickableSpan
{
  private WeakReference<QQAppInterface> a;
  private WeakReference<Context> b;
  private MessageRecord c;
  
  GrayTipsItemBuilder$TeamWorkFileImportTipsClickableSpan(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramContext);
    this.c = paramMessageRecord;
  }
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)this.a.get();
    Object localObject = (Context)this.b.get();
    if (paramView != null)
    {
      if (localObject == null) {
        return;
      }
      ReportController.b(paramView, "dc00898", "", "", "0X800906D", "0X800906D", 0, 0, "", "", "", "");
      if ((localObject instanceof Activity))
      {
        if (!NetworkUtil.isNetSupport((Context)localObject))
        {
          QQToast.makeText((Context)localObject, 2131889169, 0).show(((Context)localObject).getResources().getDimensionPixelSize(2131299920));
          return;
        }
        if ((this.c != null) && (this.b.get() != null))
        {
          localObject = this.c.getExtInfoFromExtStr("key_team_work_ext_info_new_url");
          boolean bool = Boolean.parseBoolean(this.c.getExtInfoFromExtStr("team_work_is_message_convert"));
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            Bundle localBundle = new Bundle();
            localBundle.putString("url", (String)localObject);
            localBundle.putString("tdsourcetag", "s_qq_aio_grey");
            TeamWorkDocEditBrowserActivity.a((Context)this.b.get(), localBundle, false);
            if (!bool)
            {
              ReportController.b(paramView, "CliOper", "", "", "0X8008A35", "0X8008A35", 0, 0, "", "", "", "");
              return;
            }
            ReportController.b(paramView, "CliOper", "", "", "0X8009075", "0X8009075", 0, 0, "", "", "", "");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.TeamWorkFileImportTipsClickableSpan
 * JD-Core Version:    0.7.0.1
 */