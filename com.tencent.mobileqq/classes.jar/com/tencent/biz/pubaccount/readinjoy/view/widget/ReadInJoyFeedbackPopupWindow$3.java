package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import bcdu;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import obz;
import rfw;

public class ReadInJoyFeedbackPopupWindow$3
  implements Runnable
{
  public ReadInJoyFeedbackPopupWindow$3(rfw paramrfw) {}
  
  public void run()
  {
    if (!rfw.a(this.this$0, "reportFeeds")) {}
    String str1;
    String str3;
    String str4;
    do
    {
      return;
      str1 = obz.c(rfw.a(this.this$0));
      str3 = obz.a();
      str4 = String.valueOf(rfw.a(this.this$0).publishUin);
      QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { "reportFeeds, shareUrl = ", str1, ", uin = ", str3, ", publicUin = ", str4 });
    } while (TextUtils.isEmpty(str1));
    if (Pattern.compile("(http|https)://.*.mp.qq.com.*").matcher(str1).matches()) {}
    for (int i = 1;; i = 0)
    {
      Object localObject2 = null;
      try
      {
        str1 = URLEncoder.encode(str1, "UTF-8");
        if (i != 0)
        {
          String str5 = String.valueOf(NetConnInfoCenter.getServerTime());
          String str2 = bcdu.b(str1 + 200 + str5 + "jubao@article@123");
          localObject2 = str2;
          if (str2 != null)
          {
            localObject2 = str2;
            if (!str2.isEmpty()) {
              localObject2 = str2.toLowerCase();
            }
          }
          str1 = "https://post.mp.qq.com/jubao/index?qq=" + str3 + "&mp_uin=" + str4 + "&scene=200&sub_appname=article_webview&timestamp=" + str5 + "&sign=" + (String)localObject2 + "&article_url=" + str1 + "&_wv=3";
          QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { "reportFeeds, reportUrl = ", str1 });
          localObject2 = new Intent(this.this$0.a, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", str1);
          ((Intent)localObject2).putExtra("hide_more_button", true);
          this.this$0.a.startActivity((Intent)localObject2);
          return;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          Object localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("ReadInJoyBasePopupWindow", 2, "encode shareUrl failed, because UTF-8 is unknown");
            localObject1 = localObject2;
            continue;
            localObject1 = "https://guanjia.qq.com/online_server/m_report.html?shareUrl=" + (String)localObject1 + "&qq=" + str3 + "&_wv=7";
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyFeedbackPopupWindow.3
 * JD-Core Version:    0.7.0.1
 */