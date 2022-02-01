package com.tencent.biz.troopgift;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class TroopGiftPanel$GiftNumInputDialog$2
  implements TextView.OnEditorActionListener
{
  TroopGiftPanel$GiftNumInputDialog$2(TroopGiftPanel.GiftNumInputDialog paramGiftNumInputDialog, TroopGiftPanel paramTroopGiftPanel) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (paramInt == 6)
    {
      this.b.c();
      String str1 = this.b.d.getEditableText().toString();
      if (!TextUtils.isEmpty(str1)) {
        this.b.e.a(str1);
      } else {
        this.b.e.a("1");
      }
      this.b.b();
      int i;
      if (AnonymousChatHelper.a().a(this.b.e.getTroopUin())) {
        i = 2;
      } else {
        i = 1;
      }
      str1 = this.b.e.getTroopUin();
      String str2 = this.b.e.H;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(TroopMemberUtil.a((AppInterface)this.b.e.l.get(), ((AppInterface)this.b.e.l.get()).getCurrentAccountUin(), this.b.e.getTroopUin()));
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_numok", i, 0, str1, "", str2, localStringBuilder.toString());
    }
    else
    {
      bool = false;
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.GiftNumInputDialog.2
 * JD-Core Version:    0.7.0.1
 */