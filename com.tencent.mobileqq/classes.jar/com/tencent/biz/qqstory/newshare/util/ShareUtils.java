package com.tencent.biz.qqstory.newshare.util;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public final class ShareUtils
{
  public static <K, V, T extends V> T a(@NonNull Map<K, V> paramMap, K paramK, T paramT)
  {
    Object localObject = paramMap.get(paramK);
    if ((localObject != null) || (paramMap.containsKey(paramK))) {
      paramT = localObject;
    }
    return paramT;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_FILE_SAVE_TMP_PATH);
    localStringBuilder.append(AbsDownloader.getFileName(paramString));
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = paramString.split("&");
    int m = arrayOfString.length;
    paramString = null;
    int j = 0;
    Object localObject;
    int k;
    for (int i = 1; j < m; i = k)
    {
      localObject = arrayOfString[j];
      String str = localObject.split("=")[0];
      if ((!str.equals("src_type")) && (!str.equals("version")) && (!str.equals("type")) && (!str.equals("actionnamekey")) && (!str.equals("storysharefrom")) && ((!paramBoolean) || (!str.equals("videoId"))) && ((!paramBoolean) || (!str.equals("videoOwnerUin"))) && ((!paramBoolean) || (!str.equals("unionid"))))
      {
        localObject = paramString;
        k = i;
        if (QLog.isColorLevel())
        {
          if (paramString == null) {
            paramString = new StringBuilder();
          } else {
            paramString.append('|');
          }
          paramString.append(str);
          localObject = paramString;
          k = i;
        }
      }
      else
      {
        if (i != 0) {
          i = 0;
        } else {
          localStringBuilder.append('&');
        }
        localStringBuilder.append((String)localObject);
        k = i;
        localObject = paramString;
      }
      j += 1;
      paramString = (String)localObject;
    }
    if ((paramString != null) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("remove params:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ShareUtil", 2, ((StringBuilder)localObject).toString());
    }
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    Object localObject1 = paramString.split("\\?");
    if (localObject1.length != 2) {
      return paramString;
    }
    paramString = localObject1[0];
    Object localObject2 = localObject1[1].split("&");
    localObject1 = new StringBuilder("?");
    int i = 0;
    while (i < localObject2.length)
    {
      Object localObject3 = localObject2[i].split("=");
      if (localObject3.length == 2)
      {
        localObject3 = localObject3[0];
        if ("s".equals(localObject3))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append("=");
          localStringBuilder.append("140");
          localObject2[i] = localStringBuilder.toString();
        }
        ((StringBuilder)localObject1).append(localObject2[i]);
        if (i + 1 < localObject2.length) {
          ((StringBuilder)localObject1).append("&");
        }
      }
      i += 1;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.util.ShareUtils
 * JD-Core Version:    0.7.0.1
 */