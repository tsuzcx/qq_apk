package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.viola;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.biz.pubaccount.readinjoy.viola.utils.ViolaBizUtils;
import com.tencent.qphone.base.util.QLog;

public class RIJViolaUtils
{
  public static String a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    do
    {
      do
      {
        return null;
      } while ((paramBaseArticleInfo.isCardJumpUrlAvailable != 1) || (TextUtils.isEmpty(paramBaseArticleInfo.mCardJumpUrl)));
      paramBaseArticleInfo = ViolaBizUtils.d(paramBaseArticleInfo.mCardJumpUrl);
      if (QLog.isColorLevel()) {
        QLog.d("RIJViolaUtils", 2, "shortContentUrl: " + paramBaseArticleInfo);
      }
    } while (!ViolaAccessHelper.b(paramBaseArticleInfo));
    return ViolaAccessHelper.c(paramBaseArticleInfo);
  }
  
  public static String b(BaseArticleInfo paramBaseArticleInfo)
  {
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (paramBaseArticleInfo != null)
    {
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleContentUrl)) {
        break label22;
      }
      localObject = localStringBuilder;
    }
    label22:
    do
    {
      do
      {
        return localObject;
        paramBaseArticleInfo = ViolaBizUtils.d(paramBaseArticleInfo.mArticleContentUrl);
        localObject = localStringBuilder;
      } while (!ViolaAccessHelper.b(paramBaseArticleInfo));
      paramBaseArticleInfo = ViolaAccessHelper.c(paramBaseArticleInfo);
      localObject = paramBaseArticleInfo;
    } while (!QLog.isColorLevel());
    localStringBuilder = new StringBuilder().append("get viola url from articleContentUrl: ");
    if (paramBaseArticleInfo != null) {}
    for (localObject = paramBaseArticleInfo;; localObject = "null")
    {
      QLog.d("RIJViolaUtils", 2, (String)localObject);
      return paramBaseArticleInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.viola.RIJViolaUtils
 * JD-Core Version:    0.7.0.1
 */