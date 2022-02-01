package com.tencent.biz.pubaccount.weishi_new.wsqqscheme;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.mobileqq.app.parser.WeishiPublicAccountParser;
import com.tencent.mobileqq.app.parser.WeishiPublicAccountUniversalParser;
import com.tencent.mobileqq.app.parser.WeishiPublicAccountVideoParser;
import com.tencent.mobileqq.utils.JumpAction;
import java.util.List;

public class WSQQSchemeUtils
{
  private static String a(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      return (String)paramList.get(0);
    }
    return "";
  }
  
  public static boolean a(Context paramContext, String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSQQSchemeUtils.java][jump] schema:");
    localStringBuilder.append(paramString);
    WSLog.d("WSQQSchemeUtilsLog", localStringBuilder.toString());
    paramContext = b(paramContext, paramString, paramObject);
    if (paramContext != null) {
      return paramContext.a();
    }
    return false;
  }
  
  private static boolean a(Uri paramUri)
  {
    return (paramUri == null) || (!TextUtils.equals(paramUri.getScheme(), "mqqapi")) || (!TextUtils.equals(paramUri.getHost(), "wsgzh"));
  }
  
  public static JumpAction b(Context paramContext, String paramString, Object paramObject)
  {
    Object localObject = WeishiUtils.d(paramString);
    if (a((Uri)localObject)) {
      return null;
    }
    localObject = a(((Uri)localObject).getPathSegments());
    int i = -1;
    int j = ((String)localObject).hashCode();
    if (j != -1505392042)
    {
      if (j != -213632750)
      {
        if ((j == 113021637) && (((String)localObject).equals("wesee"))) {
          i = 0;
        }
      }
      else if (((String)localObject).equals("waterfall")) {
        i = 1;
      }
    }
    else if (((String)localObject).equals("miniapp_player")) {
      i = 2;
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return null;
        }
        return new WeishiPublicAccountVideoParser().a(WeishiUtils.h(), paramContext, paramString, null);
      }
      return new WeishiPublicAccountParser().a(WeishiUtils.h(), paramContext, paramString, null);
    }
    return new WeishiPublicAccountUniversalParser(paramObject).a(WeishiUtils.h(), paramContext, paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.wsqqscheme.WSQQSchemeUtils
 * JD-Core Version:    0.7.0.1
 */