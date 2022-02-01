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
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<Context> b;
  
  GrayTipsItemBuilder$SougouInputTipClickableSpan(GrayTipsItemBuilder paramGrayTipsItemBuilder, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramContext);
  }
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject1 = (Context)this.b.get();
    if (paramView != null)
    {
      if (localObject1 == null) {
        return;
      }
      if ((localObject1 instanceof Activity))
      {
        if (!NetworkUtil.isNetSupport((Context)localObject1))
        {
          QQToast.a((Context)localObject1, 2131692183, 0).b(((Context)localObject1).getResources().getDimensionPixelSize(2131299168));
          return;
        }
        long l = System.currentTimeMillis();
        if ((GrayTipsItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder) != 0L) && (l > GrayTipsItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder)) && (l - GrayTipsItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder) <= 800L))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GrayTipsItemBuilder", 2, "click too often...ignore click envent");
          }
          return;
        }
        GrayTipsItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder, l);
        Object localObject2;
        if (NetworkUtil.isWifiConnected((Context)localObject1))
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString(DownloadConstants.b, "100868074");
          ((Bundle)localObject2).putString(DownloadConstants.j, "https://shouji.sogou.com/proxy/linkto.php?site=20141110sogouinputapk");
          ((Bundle)localObject2).putString(DownloadConstants.f, "com.sohu.inputmethod.sogou");
          ((Bundle)localObject2).putInt(DownloadConstants.k, 2);
          ((Bundle)localObject2).putString(DownloadConstants.i, "ANDROIDQQ.MSG.SOUGOU");
          ((Bundle)localObject2).putString(DownloadConstants.l, HardCodeUtil.a(2131705422));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.SougouInputTipClickableSpan
 * JD-Core Version:    0.7.0.1
 */