package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class GrayTipsItemBuilder$RecommandInputClickableSpan
  extends ClickableSpan
{
  public final String a = "mqqapi://nearby_entry/nearby_profile?src_type=web&version=1&from=10003&from_type=0&uin=%s&mode=3";
  private WeakReference<QQAppInterface> c;
  private WeakReference<Context> d;
  private String e;
  
  GrayTipsItemBuilder$RecommandInputClickableSpan(GrayTipsItemBuilder paramGrayTipsItemBuilder, QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    this.c = new WeakReference(paramQQAppInterface);
    this.d = new WeakReference(paramContext);
    this.e = paramString;
  }
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)this.c.get();
    Object localObject = (Context)this.d.get();
    if (paramView != null)
    {
      if (localObject == null) {
        return;
      }
      if ((localObject instanceof Activity))
      {
        if (!NetworkUtil.isNetSupport((Context)localObject))
        {
          QQToast.makeText((Context)localObject, 2131889169, 0).show(((Context)localObject).getResources().getDimensionPixelSize(2131299920));
          return;
        }
        long l = System.currentTimeMillis();
        if ((GrayTipsItemBuilder.f(this.b) != 0L) && (l > GrayTipsItemBuilder.f(this.b)) && (l - GrayTipsItemBuilder.f(this.b) <= 800L))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GrayTipsItemBuilder", 2, "click too often...ignore click envent");
          }
          return;
        }
        GrayTipsItemBuilder.a(this.b, l);
        localObject = JumpParser.a(paramView, (Context)localObject, String.format("mqqapi://nearby_entry/nearby_profile?src_type=web&version=1&from=10003&from_type=0&uin=%s&mode=3", new Object[] { this.e }));
        if (localObject != null) {
          ((JumpAction)localObject).a();
        }
        ReportController.b(paramView, "CliOper", "", "", "0X80055FD", "0X80055FD", 0, 0, ((com.tencent.mobileqq.nearpeople.api.INearbyRecommenderUtils)com.tencent.mobileqq.qroute.QRoute.api(com.tencent.mobileqq.nearpeople.api.INearbyRecommenderUtils.class)).getReasonTypeAndUins(paramView)[0], this.e, "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.RecommandInputClickableSpan
 * JD-Core Version:    0.7.0.1
 */