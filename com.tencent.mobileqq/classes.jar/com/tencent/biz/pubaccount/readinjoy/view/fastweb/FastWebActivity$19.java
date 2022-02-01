package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.net.URLEncoder;
import pkh;

class FastWebActivity$19
  implements Runnable
{
  FastWebActivity$19(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    String str3 = "https://post.mp.qq.com/jubao/index?";
    String str1 = str3;
    if (this.this$0.a != null) {}
    try
    {
      str1 = "https://post.mp.qq.com/jubao/index?" + "articleId=" + this.this$0.a.mArticleID + "&puin=" + this.this$0.a.mSubscribeID + "&url=" + URLEncoder.encode(this.this$0.a.mArticleContentUrl, "utf-8") + "&key=" + this.this$0.a.innerUniqueID + "&type=7&_wv=3";
      pkh.a(this.this$0, str1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        String str2 = str3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.19
 * JD-Core Version:    0.7.0.1
 */