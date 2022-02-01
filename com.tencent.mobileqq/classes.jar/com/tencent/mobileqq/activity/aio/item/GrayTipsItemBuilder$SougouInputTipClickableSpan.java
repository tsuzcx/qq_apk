package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class GrayTipsItemBuilder$SougouInputTipClickableSpan
  extends ClickableSpan
{
  private WeakReference<QQAppInterface> b;
  private WeakReference<Context> c;
  
  GrayTipsItemBuilder$SougouInputTipClickableSpan(GrayTipsItemBuilder paramGrayTipsItemBuilder, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.b = new WeakReference(paramQQAppInterface);
    this.c = new WeakReference(paramContext);
  }
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)this.b.get();
    Object localObject1 = (Context)this.c.get();
    if (paramView != null)
    {
      if (localObject1 == null) {
        return;
      }
      if ((localObject1 instanceof Activity))
      {
        if (!NetworkUtil.isNetSupport((Context)localObject1))
        {
          QQToast.makeText((Context)localObject1, 2131889169, 0).show(((Context)localObject1).getResources().getDimensionPixelSize(2131299920));
          return;
        }
        long l = System.currentTimeMillis();
        if ((GrayTipsItemBuilder.f(this.a) != 0L) && (l > GrayTipsItemBuilder.f(this.a)) && (l - GrayTipsItemBuilder.f(this.a) <= 800L))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GrayTipsItemBuilder", 2, "click too often...ignore click envent");
          }
          return;
        }
        GrayTipsItemBuilder.a(this.a, l);
        Object localObject2;
        if (NetworkUtil.isWifiConnected((Context)localObject1))
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString(DownloadConstants.b, "100868074");
          ((Bundle)localObject2).putString(DownloadConstants.j, "https://shouji.sogou.com/proxy/linkto.php?site=20141110sogouinputapk");
          ((Bundle)localObject2).putString(DownloadConstants.f, "com.sohu.inputmethod.sogou");
          ((Bundle)localObject2).putInt(DownloadConstants.k, 2);
          ((Bundle)localObject2).putString(DownloadConstants.i, "ANDROIDQQ.MSG.SOUGOU");
          ((Bundle)localObject2).putString(DownloadConstants.l, HardCodeUtil.a(2131903303));
          ((Bundle)localObject2).putBoolean(DownloadConstants.y, false);
          DownloadApi.a((Activity)localObject1, (Bundle)localObject2, "biz_src_yyb", null, 0);
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("qapp://detail?param=");
          ((StringBuilder)localObject2).append(GrayTipsItemBuilder.a("id=100868074&channelId=2800&packageName=com.sohu.inputmethod.sogou&via=MSG.SOUGOU"));
          localObject1 = JumpParser.a(paramView, (Context)localObject1, ((StringBuilder)localObject2).toString());
          if (localObject1 != null) {
            ((JumpAction)localObject1).a();
          }
        }
        ReportController.b(paramView, "CliOper", "", "", "0X80047CF", "0X80047CF", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.SougouInputTipClickableSpan
 * JD-Core Version:    0.7.0.1
 */