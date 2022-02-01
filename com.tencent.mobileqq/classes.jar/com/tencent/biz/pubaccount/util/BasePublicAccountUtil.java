package com.tencent.biz.pubaccount.util;

import android.text.TextUtils;

public class BasePublicAccountUtil
{
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (("article.mp.qq.com".equalsIgnoreCase(paramString)) || ("post.mp.qq.com".equalsIgnoreCase(paramString)) || ("kandian.qq.com".equalsIgnoreCase(paramString)) || ("sqimg.qq.com".equalsIgnoreCase(paramString)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.BasePublicAccountUtil
 * JD-Core Version:    0.7.0.1
 */