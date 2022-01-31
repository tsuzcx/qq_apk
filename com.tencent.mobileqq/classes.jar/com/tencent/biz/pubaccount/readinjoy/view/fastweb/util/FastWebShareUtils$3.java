package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.content.Context;
import android.graphics.Bitmap;
import bcpq;
import bhvh;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;
import mqq.app.MobileQQ;
import onk;
import rnb;
import rnr;

public class FastWebShareUtils$3
  implements Runnable
{
  public FastWebShareUtils$3(rnb paramrnb, Map paramMap, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, AppInterface paramAppInterface, String paramString6, ArticleInfo paramArticleInfo, int paramInt) {}
  
  public void run()
  {
    int j = 1;
    int i = 1;
    if (rnb.a(this.this$0).isShowing()) {
      rnb.a(this.this$0).dismiss();
    }
    rnb.a(this.this$0, String.valueOf(System.currentTimeMillis()));
    Object localObject1 = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    Object localObject2;
    if (this.jdField_a_of_type_Boolean)
    {
      WxShareHelperFromReadInjoy.a().a(rnb.a(this.this$0), this.jdField_a_of_type_JavaLangString, (Bitmap)localObject1, this.b, this.c, this.d);
      localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getApplicationContext();
      localObject2 = this.f;
      if (!"2".equals(this.e)) {
        break label303;
      }
    }
    label303:
    for (i = 4;; i = 5)
    {
      rnb.a((Context)localObject1, (String)localObject2, i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      rnr.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Int, -1, false);
      return;
      if (bhvh.t(onk.a()) == 1)
      {
        localObject2 = WXShareHelper.a();
        str1 = rnb.a(this.this$0);
        str2 = this.jdField_a_of_type_JavaLangString;
        str3 = this.b;
        str4 = this.c;
        if ("2".equals(this.e)) {
          i = 0;
        }
        ((WXShareHelper)localObject2).b(str1, str2, (Bitmap)localObject1, str3, str4, i);
        break;
      }
      localObject2 = WxShareHelperFromReadInjoy.a();
      String str1 = rnb.a(this.this$0);
      String str2 = this.jdField_a_of_type_JavaLangString;
      String str3 = this.b;
      String str4 = this.c;
      i = j;
      if ("2".equals(this.e)) {
        i = 0;
      }
      ((WxShareHelperFromReadInjoy)localObject2).a(str1, str2, (Bitmap)localObject1, str3, str4, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils.3
 * JD-Core Version:    0.7.0.1
 */