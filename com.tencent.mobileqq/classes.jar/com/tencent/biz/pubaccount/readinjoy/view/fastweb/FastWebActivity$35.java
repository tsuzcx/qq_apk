package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import obz;
import ohb;
import org.json.JSONObject;
import raz;

class FastWebActivity$35
  implements Runnable
{
  FastWebActivity$35(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    FastWebActivity.o(this.this$0);
    FastWebActivity.p(this.this$0);
    ohb.a().k();
    ArticleInfo localArticleInfo1 = FastWebActivity.a(this.this$0);
    FastWebActivity localFastWebActivity = this.this$0;
    ArticleInfo localArticleInfo2 = FastWebActivity.a(this.this$0);
    int i = (int)FastWebActivity.a(this.this$0).mChannelID;
    if (FastWebActivity.a(this.this$0).c()) {}
    for (String str = "2";; str = "1")
    {
      raz.a(localArticleInfo1, "0X800A09E", obz.a(localFastWebActivity, localArticleInfo2, i, str).toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.35
 * JD-Core Version:    0.7.0.1
 */