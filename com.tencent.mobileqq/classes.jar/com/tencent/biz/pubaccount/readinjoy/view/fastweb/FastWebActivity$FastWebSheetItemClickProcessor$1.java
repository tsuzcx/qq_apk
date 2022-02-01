package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.net.URLEncoder;
import ozs;
import soj;

public class FastWebActivity$FastWebSheetItemClickProcessor$1
  implements Runnable
{
  public FastWebActivity$FastWebSheetItemClickProcessor$1(soj paramsoj) {}
  
  public void run()
  {
    String str3 = "https://post.mp.qq.com/jubao/index?";
    String str1 = str3;
    if (this.a.a.a != null) {}
    try
    {
      str1 = "https://post.mp.qq.com/jubao/index?" + "articleId=" + this.a.a.a.mArticleID + "&puin=" + this.a.a.a.mSubscribeID + "&url=" + URLEncoder.encode(this.a.a.a.mArticleContentUrl, "utf-8") + "&key=" + this.a.a.a.innerUniqueID + "&type=7&_wv=3";
      ozs.a(this.a.a, str1);
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.FastWebSheetItemClickProcessor.1
 * JD-Core Version:    0.7.0.1
 */