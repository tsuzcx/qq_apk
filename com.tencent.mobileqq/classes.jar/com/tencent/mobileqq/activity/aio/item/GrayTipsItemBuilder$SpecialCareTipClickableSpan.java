package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

class GrayTipsItemBuilder$SpecialCareTipClickableSpan
  extends ClickableSpan
{
  private WeakReference<QQAppInterface> b;
  private WeakReference<Context> c;
  
  GrayTipsItemBuilder$SpecialCareTipClickableSpan(GrayTipsItemBuilder paramGrayTipsItemBuilder, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.b = new WeakReference(paramQQAppInterface);
    this.c = new WeakReference(paramContext);
  }
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)this.b.get();
    Context localContext = (Context)this.c.get();
    if (paramView != null)
    {
      if (localContext == null) {
        return;
      }
      if ((localContext instanceof Activity))
      {
        if (!NetworkUtil.isNetSupport(localContext))
        {
          QQToast.makeText(localContext, 2131889169, 0).show(localContext.getResources().getDimensionPixelSize(2131299920));
          return;
        }
        Intent localIntent = new Intent(localContext, QQSpecialCareSettingActivity.class);
        localIntent.putExtra("key_friend_uin", this.a.d.b);
        localContext.startActivity(localIntent);
        VipUtils.a(paramView, "Vip_SpecialRemind", "0X8005057", "0X8005057", 0, 1, new String[0]);
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.SpecialCareTipClickableSpan
 * JD-Core Version:    0.7.0.1
 */