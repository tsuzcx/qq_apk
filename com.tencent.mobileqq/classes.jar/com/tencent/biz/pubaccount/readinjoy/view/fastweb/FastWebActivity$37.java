package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import org.json.JSONObject;
import pay;
import swy;

class FastWebActivity$37
  implements Runnable
{
  FastWebActivity$37(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    FastWebActivity.n(this.this$0);
    FastWebActivity.o(this.this$0);
    ArticleInfo localArticleInfo1 = this.this$0.a;
    FastWebActivity localFastWebActivity = this.this$0;
    ArticleInfo localArticleInfo2 = this.this$0.a;
    int i = (int)this.this$0.a.mChannelID;
    if (FastWebActivity.a(this.this$0).c()) {}
    for (String str = "2";; str = "1")
    {
      swy.a(localArticleInfo1, "0X800A09E", pay.a(localFastWebActivity, localArticleInfo2, i, str).toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.37
 * JD-Core Version:    0.7.0.1
 */