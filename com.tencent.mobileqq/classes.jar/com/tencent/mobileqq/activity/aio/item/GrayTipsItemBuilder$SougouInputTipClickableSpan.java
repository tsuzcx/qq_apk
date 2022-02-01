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
    Object localObject = (Context)this.b.get();
    if ((paramView == null) || (localObject == null)) {}
    long l;
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof Activity));
      if (!NetworkUtil.d((Context)localObject))
      {
        QQToast.a((Context)localObject, 2131692257, 0).b(((Context)localObject).getResources().getDimensionPixelSize(2131299166));
        return;
      }
      l = System.currentTimeMillis();
      if ((GrayTipsItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder) == 0L) || (l <= GrayTipsItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder)) || (l - GrayTipsItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder) > 800L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("GrayTipsItemBuilder", 2, "click too often...ignore click envent");
    return;
    GrayTipsItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder, l);
    if (NetworkUtil.h((Context)localObject))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString(DownloadConstants.b, "100868074");
      localBundle.putString(DownloadConstants.j, "https://shouji.sogou.com/proxy/linkto.php?site=20141110sogouinputapk");
      localBundle.putString(DownloadConstants.f, "com.sohu.inputmethod.sogou");
      localBundle.putInt(DownloadConstants.k, 2);
      localBundle.putString(DownloadConstants.i, "ANDROIDQQ.MSG.SOUGOU");
      localBundle.putString(DownloadConstants.l, HardCodeUtil.a(2131705348));
      localBundle.putBoolean(DownloadConstants.x, false);
      DownloadApi.a((Activity)localObject, localBundle, "biz_src_yyb", null, 0);
    }
    for (;;)
    {
      ReportController.b(paramView, "CliOper", "", "", "0X80047CF", "0X80047CF", 0, 0, "", "", "", "");
      return;
      localObject = JumpParser.a(paramView, (Context)localObject, "qapp://detail?param=" + GrayTipsItemBuilder.a("id=100868074&channelId=2800&packageName=com.sohu.inputmethod.sogou&via=MSG.SOUGOU"));
      if (localObject != null) {
        ((JumpAction)localObject).a();
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