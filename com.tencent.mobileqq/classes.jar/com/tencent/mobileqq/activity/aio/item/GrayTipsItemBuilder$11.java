package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

class GrayTipsItemBuilder$11
  implements QQFileManagerUtil.TipsClickedInterface
{
  GrayTipsItemBuilder$11(GrayTipsItemBuilder paramGrayTipsItemBuilder, int paramInt1, int paramInt2, String paramString, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    int i = this.a;
    Object localObject;
    switch (i)
    {
    default: 
      switch (i)
      {
      default: 
        paramView = new StringBuilder();
        paramView.append("handle renewal gray tips click, action not support yet, action=");
        paramView.append(this.a);
        QLog.e("GrayTipsItemBuilder", 1, paramView.toString());
        break;
      case 103: 
      case 104: 
        VasH5PayUtil.a(this.e.c, "mvip.gexinghua.android.aio_pay", "CJCLUBT", 3, false, false);
        VasWebviewUtil.a(this.e.d.b, "aio_pay", "aio_payclk", "", 1, 0, 0, "", String.valueOf(this.d), "");
        break;
      case 101: 
      case 102: 
        VasH5PayUtil.a(this.e.c, "mvip.gexinghua.android.aio_pay", "LTMCLUB", 3, false, false);
        VasWebviewUtil.a(this.e.d.b, "aio_pay", "aio_payclk", "", 1, 0, 0, "", String.valueOf(this.d), "");
        break;
      case 100: 
        GrayTipsItemBuilder.a(this.e, this.c);
      }
      break;
    case 12: 
      paramView = new Intent();
      paramView.putExtra("individuation_url_type", 40100);
      localObject = IndividuationUrlHelper.a(this.e.c, "backgroundDetail", String.valueOf(this.b), "");
      VasWebviewUtil.b(this.e.c, (String)localObject, 33554432L, paramView, false, -1);
      VasWebviewUtil.a("", "aio_pay", "aio_detail", "", 1, 0, 0, "", "", "");
      break;
    case 11: 
      paramView = new Intent(this.e.c, QQBrowserActivity.class);
      paramView.putExtra("individuation_url_type", 40302);
      VasWebviewUtil.b(this.e.c, IndividuationUrlHelper.a(this.e.c, "fontDetailDialog", String.valueOf(this.b), "mvip.gexinghua.mobile.font.client_tab_store"), 4096L, paramView, false, -1);
      VasWebviewUtil.a("", "aio_pay", "aio_detail", "", 1, 0, 0, "", "", "");
      break;
    case 10: 
      paramView = new Intent(this.e.c, QQBrowserActivity.class);
      paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramView.putExtra("hide_left_button", false);
      paramView.putExtra("show_right_close_button", false);
      paramView.putExtra("url", IndividuationUrlHelper.a(this.e.c, "pendantDetailDialog", String.valueOf(this.b), "mvip.gexinghua.mobile.faceaddon.client_tab_store"));
      paramView.putExtra("business", 512L);
      paramView.putExtra("individuation_url_type", 40100);
      VasWebviewUtil.a(512L, paramView);
      paramView.putExtra("isShowAd", false);
      this.e.c.startActivity(paramView);
      VasWebviewUtil.a("", "aio_pay", "aio_detail", "", 1, 0, 0, "", "", "");
      break;
    case 9: 
      paramView = new Intent(this.e.c, QQBrowserActivity.class);
      paramView.putExtra("individuation_url_type", 40302);
      VasWebviewUtil.b(this.e.c, IndividuationUrlHelper.a(this.e.c, "bubbleDetailDialog", String.valueOf(this.b), "mvip.gongneng.android.bubble.index_dynamic_tab"), 64L, paramView, false, -1);
      VasWebviewUtil.a("", "aio_pay", "aio_detail", "", 1, 0, 0, "", "", "");
      break;
    case 8: 
      paramView = IndividualRedPacketManager.a(2, this.e.a);
      if (TextUtils.isEmpty(paramView)) {
        return;
      }
      localObject = new Intent(this.e.c, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("individuation_url_type", 40100);
      VasWebviewUtil.b(this.e.c, paramView, 134217728L, (Intent)localObject, true, -1);
      VasWebviewUtil.a("", "aio_pay", "aio_redbag", "", 1, 0, 0, "", "", "");
      break;
    case 7: 
      ProfileCardUtil.a((Activity)this.e.c, this.e.a.getCurrentAccountUin(), "inside.myIndividuation", 1, 2, 1, "", false, false, "", 0);
      VasWebviewUtil.a("", "aio_pay", "aio_card", "", 1, 0, 0, "", "", "");
      break;
    case 6: 
      paramView = new Intent();
      paramView.putExtra("vasUsePreWebview", true);
      paramView.putExtra("bg_replace_entrance", 8);
      paramView.putExtra("hide_left_button", false);
      paramView.putExtra("show_right_close_button", false);
      paramView.putExtra("individuation_url_type", 40306);
      VasWebviewUtil.b(this.e.c, IndividuationUrlHelper.a(this.e.c, "background", ""), 33554432L, paramView, false, -1);
      VasWebviewUtil.a("", "aio_pay", "aio_background", "", 1, 0, 0, "", "", "");
      break;
    case 5: 
      GrayTipsItemBuilder.e(this.e);
      break;
    case 4: 
      GrayTipsItemBuilder.d(this.e);
      break;
    case 3: 
      GrayTipsItemBuilder.c(this.e);
      break;
    case 2: 
      paramView = new Intent(this.e.c, QQBrowserActivity.class);
      paramView.putExtra("individuation_url_type", 40306);
      VasWebviewUtil.b(this.e.c, IndividuationUrlHelper.a(this.e.c, "bubble", "mvip.gongneng.android.bubble.index_dynamic_tab"), 64L, paramView, false, -1);
      VasWebviewUtil.a("", "aio_pay", "aio_bubble", "", 1, 0, 0, "", "", "");
      break;
    case 1: 
      GrayTipsItemBuilder.b(this.e);
      break;
    case 0: 
      GrayTipsItemBuilder.a(this.e);
    }
    FileManagerDataCenter.b(this.e.a, this.e.d.b, this.e.d.a, -4020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.11
 * JD-Core Version:    0.7.0.1
 */