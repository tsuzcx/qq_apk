package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.net.URLEncoder;
import ors;
import rzp;

public class FastWebActivity$FastWebSheetItemClickProcessor$1
  implements Runnable
{
  public FastWebActivity$FastWebSheetItemClickProcessor$1(rzp paramrzp) {}
  
  public void run()
  {
    String str3 = "https://post.mp.qq.com/jubao/index?";
    String str1 = str3;
    if (FastWebActivity.a(this.a.a) != null) {}
    try
    {
      str1 = "https://post.mp.qq.com/jubao/index?" + "articleId=" + FastWebActivity.a(this.a.a).mArticleID + "&puin=" + FastWebActivity.a(this.a.a).mSubscribeID + "&url=" + URLEncoder.encode(FastWebActivity.a(this.a.a).mArticleContentUrl, "utf-8") + "&key=" + FastWebActivity.a(this.a.a).innerUniqueID + "&type=7&_wv=3";
      ors.a(this.a.a, str1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.FastWebSheetItemClickProcessor.1
 * JD-Core Version:    0.7.0.1
 */