package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.FastWebContentGetCallback;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.TimeUtil;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$34
  implements FastWebModule.FastWebContentGetCallback
{
  FastWebActivity$34(FastWebActivity paramFastWebActivity) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, FastWebArticleInfo paramFastWebArticleInfo)
  {
    QLog.d("FastWebActivity", 2, " isSucc " + paramBoolean1 + "  useWebView :" + paramBoolean2 + "  data : " + paramFastWebArticleInfo);
    if ((paramBoolean1) && (!paramBoolean2) && (paramFastWebArticleInfo != null))
    {
      paramBoolean1 = true;
      TimeUtil.b("fast_web_show_light_house_2");
    }
    for (;;)
    {
      if (paramFastWebArticleInfo != null) {
        FastWebActivity.a(this.a, paramFastWebArticleInfo);
      }
      FastWebActivity.c(this.a, paramBoolean1);
      return;
      paramBoolean1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.34
 * JD-Core Version:    0.7.0.1
 */