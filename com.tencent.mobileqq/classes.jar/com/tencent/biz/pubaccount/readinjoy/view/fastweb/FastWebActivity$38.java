package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import onk;
import org.json.JSONObject;
import osm;
import rnr;

class FastWebActivity$38
  implements Runnable
{
  FastWebActivity$38(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    FastWebActivity.o(this.this$0);
    FastWebActivity.p(this.this$0);
    osm.a().k();
    ArticleInfo localArticleInfo1 = FastWebActivity.a(this.this$0);
    FastWebActivity localFastWebActivity = this.this$0;
    ArticleInfo localArticleInfo2 = FastWebActivity.a(this.this$0);
    int i = (int)FastWebActivity.a(this.this$0).mChannelID;
    if (FastWebActivity.a(this.this$0).c()) {}
    for (String str = "2";; str = "1")
    {
      rnr.a(localArticleInfo1, "0X800A09E", onk.a(localFastWebActivity, localArticleInfo2, i, str).toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.38
 * JD-Core Version:    0.7.0.1
 */