package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import baic;
import bazo;
import bbev;
import bbms;
import bcad;
import com.tencent.common.app.AppInterface;
import java.lang.ref.WeakReference;
import xdt;

class Share$5$1
  implements Runnable
{
  Share$5$1(Share.5 param5, String paramString) {}
  
  public void run()
  {
    Object localObject = (bazo)this.jdField_a_of_type_ComTencentBizWebviewpluginShare$5.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    String str1;
    String str2;
    if ((localObject != null) && ((localObject instanceof bbev)) && (((bbev)localObject).b()) && (!this.jdField_a_of_type_ComTencentBizWebviewpluginShare$5.this$0.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      if ((this.jdField_a_of_type_ComTencentBizWebviewpluginShare$5.this$0.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_ComTencentBizWebviewpluginShare$5.this$0.jdField_a_of_type_Bbms.isShowing())) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare$5.this$0.jdField_a_of_type_Bbms.dismiss();
      }
      str1 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { this.jdField_a_of_type_ComTencentBizWebviewpluginShare$5.b });
      str2 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { this.jdField_a_of_type_ComTencentBizWebviewpluginShare$5.b });
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label431;
      }
    }
    label431:
    for (localObject = this.jdField_a_of_type_ComTencentBizWebviewpluginShare$5.jdField_a_of_type_JavaLangString;; localObject = this.jdField_a_of_type_JavaLangString)
    {
      String str3 = String.format(this.jdField_a_of_type_ComTencentBizWebviewpluginShare$5.this$0.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131630985), new Object[] { this.jdField_a_of_type_ComTencentBizWebviewpluginShare$5.c });
      baic.a(this.jdField_a_of_type_ComTencentBizWebviewpluginShare$5.this$0.jdField_a_of_type_AndroidAppActivity, 1001, 146, "struct_msg_from_h5", this.jdField_a_of_type_ComTencentBizWebviewpluginShare$5.b, (String)localObject, this.jdField_a_of_type_ComTencentBizWebviewpluginShare$5.c, this.jdField_a_of_type_ComTencentBizWebviewpluginShare$5.d, str3, this.jdField_a_of_type_ComTencentBizWebviewpluginShare$5.e, "web", null, null, null, "plugin", null, str1, str2, "http://url.cn/JS8oE7", this.jdField_a_of_type_ComTencentBizWebviewpluginShare$5.f, null);
      int j = 0;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        j = 1;
      }
      int i = j;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare$5.d)) {
        i = j | 0x2;
      }
      j = i;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare$5.c)) {
        j = i | 0x4;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "14");
      ((Bundle)localObject).putString("intext_3", "1");
      ((Bundle)localObject).putString("intext_2", "" + j);
      ((Bundle)localObject).putString("stringext_1", "" + this.jdField_a_of_type_ComTencentBizWebviewpluginShare$5.e);
      bcad.a().a((Bundle)localObject, "", this.jdField_a_of_type_ComTencentBizWebviewpluginShare$5.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.5.1
 * JD-Core Version:    0.7.0.1
 */