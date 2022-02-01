package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.report.ReportCenter;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

class Share$6$1
  implements Runnable
{
  Share$6$1(Share.6 param6, String paramString) {}
  
  public void run()
  {
    Object localObject1 = (WebUiBaseInterface)this.b.this$0.af.get();
    if ((localObject1 != null) && ((localObject1 instanceof WebUiUtils.WebUiMethodInterface)) && (((WebUiUtils.WebUiMethodInterface)localObject1).isActivityResume()) && (!this.b.this$0.y.isFinishing()))
    {
      if ((this.b.this$0.B != null) && (this.b.this$0.B.isShowing())) {
        this.b.this$0.B.dismiss();
      }
      int j = 1;
      Object localObject2 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=%s", new Object[] { this.b.c });
      String str1 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { this.b.c });
      if (TextUtils.isEmpty(this.a)) {
        localObject1 = this.b.b;
      } else {
        localObject1 = this.a;
      }
      String str2 = String.format(this.b.this$0.y.getResources().getString(2131894173), new Object[] { this.b.d });
      ShareMsgHelper.a(this.b.this$0.y, 1001, 146, "struct_msg_from_h5", this.b.c, (String)localObject1, this.b.d, this.b.e, str2, this.b.f, "web", null, null, null, "plugin", null, (String)localObject2, str1, "https://url.cn/JS8oE7", this.b.g, null);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        j = 0;
      }
      int i = j;
      if (TextUtils.isEmpty(this.b.e)) {
        i = j | 0x2;
      }
      j = i;
      if (TextUtils.isEmpty(this.b.d)) {
        j = i | 0x4;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("report_type", "102");
      ((Bundle)localObject1).putString("act_type", "14");
      ((Bundle)localObject1).putString("intext_3", "1");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(j);
      ((Bundle)localObject1).putString("intext_2", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(this.b.f);
      ((Bundle)localObject1).putString("stringext_1", ((StringBuilder)localObject2).toString());
      ReportCenter.a().a((Bundle)localObject1, "", this.b.this$0.G.getAccount(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.6.1
 * JD-Core Version:    0.7.0.1
 */