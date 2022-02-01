package com.tencent.biz.pubaccount.util;

import android.text.TextUtils;

public class BasePublicAccountUtil
{
  public static boolean a(String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3) {
      if ((!paramString.contains("article.mp.qq.com")) && (!paramString.contains("post.mp.qq.com")) && (!paramString.contains("kandian.qq.com")) && (!paramString.contains("sqimg.qq.com")) && (!paramString.contains("web.kandian.qq.com")))
      {
        bool1 = bool2;
        if (!paramString.contains("webtest.kandian.qq.com")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.BasePublicAccountUtil
 * JD-Core Version:    0.7.0.1
 */