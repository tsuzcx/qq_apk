package com.tencent.biz.qqstory.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThumbnailUrlHelper
{
  private static final List<Integer> a;
  private static final List<Integer> b;
  private static Map<String, List<Integer>> c;
  private static final List<Integer> d;
  
  static
  {
    Integer localInteger1 = Integer.valueOf(120);
    Integer localInteger2 = Integer.valueOf(200);
    Integer localInteger3 = Integer.valueOf(320);
    a = Arrays.asList(new Integer[] { localInteger1, localInteger2, localInteger3, Integer.valueOf(512), Integer.valueOf(640), Integer.valueOf(750), Integer.valueOf(1000) });
    b = Arrays.asList(new Integer[] { Integer.valueOf(40), Integer.valueOf(60), Integer.valueOf(80), Integer.valueOf(100), localInteger1, Integer.valueOf(140), Integer.valueOf(160), localInteger2 });
    d = Arrays.asList(new Integer[] { Integer.valueOf(180), localInteger2, localInteger3 });
  }
  
  private static int a(int paramInt)
  {
    Object localObject = c;
    if (localObject == null) {
      localObject = a;
    } else {
      localObject = (List)((Map)localObject).get("qqstory_pic");
    }
    int j = 2147483647;
    int k = ((List)localObject).size() - 1;
    int i = 0;
    while (i < ((List)localObject).size())
    {
      int n = Math.abs(((Integer)((List)localObject).get(i)).intValue() - paramInt);
      int m = j;
      if (n <= j)
      {
        k = i;
        m = n;
      }
      i += 1;
      j = m;
    }
    return ((Integer)((List)localObject).get(k)).intValue();
  }
  
  private static int a(String paramString, int paramInt)
  {
    if (paramString == null)
    {
      SLog.d("Q.qqstory.home.ThumbnailUrlHelper", "origPath is null");
      return -1;
    }
    if (f(paramString)) {
      return a(a, paramInt);
    }
    if (g(paramString)) {
      return a(b, paramInt);
    }
    if (i(paramString)) {
      return a(d, paramInt);
    }
    return -1;
  }
  
  private static int a(List<Integer> paramList, int paramInt)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      int j = 0;
      int i = paramList.size() - 1;
      while (j < i - 1)
      {
        int k = (i - j) / 2 + j;
        if (((Integer)paramList.get(k)).intValue() > paramInt) {
          i = k;
        } else {
          j = k;
        }
      }
      if (((Integer)paramList.get(i)).intValue() == paramInt) {
        return paramInt;
      }
      return ((Integer)paramList.get(j)).intValue();
    }
    return -1;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (!f(paramString))
    {
      paramContext = new StringBuilder();
      paramContext.append("not qqstory url for getFullScreenThumbnailPath ");
      paramContext.append(paramString);
      SLog.d("Q.qqstory.home.ThumbnailUrlHelper", paramContext.toString());
      return paramString;
    }
    paramString = d(paramString);
    int i = a(UIUtils.b(paramContext));
    paramContext = new StringBuilder();
    paramContext.append("get fullscreen thumbnail url ");
    paramContext.append(paramString);
    paramContext.append(i);
    SLog.b("Q.qqstory.home.ThumbnailUrlHelper", paramContext.toString());
    paramContext = new StringBuilder();
    paramContext.append(paramString);
    paramContext.append(i);
    return paramContext.toString();
  }
  
  public static String a(String paramString)
  {
    int i = b(paramString, 120);
    if (i < 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("cannot find thumbsize in getMinimumThumbnailPath ");
      localStringBuilder.append(paramString);
      SLog.d("Q.qqstory.home.ThumbnailUrlHelper", localStringBuilder.toString());
      return paramString;
    }
    paramString = d(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getMinimumThumbnailPath ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(i);
    SLog.b("Q.qqstory.home.ThumbnailUrlHelper", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  private static void a()
  {
    Object localObject1 = StoryConfigManager.u();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Json config in string ");
    ((StringBuilder)localObject2).append((String)localObject1);
    SLog.b("Q.qqstory.home.ThumbnailUrlHelper", ((StringBuilder)localObject2).toString());
    if (((String)localObject1).isEmpty())
    {
      SLog.d("Q.qqstory.home.ThumbnailUrlHelper", "no thumb config found in sp, check later");
      return;
    }
    try
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("json ");
      ((StringBuilder)localObject2).append((String)localObject1);
      SLog.b("Q.qqstory.home.ThumbnailUrlHelper", ((StringBuilder)localObject2).toString());
      localObject1 = new JSONObject((String)localObject1);
      localObject2 = ((JSONObject)localObject1).names();
      c = new HashMap();
      int i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        String str = ((JSONArray)localObject2).getString(i);
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("get key ");
        ((StringBuilder)localObject3).append(str);
        SLog.b("Q.qqstory.home.ThumbnailUrlHelper", ((StringBuilder)localObject3).toString());
        localObject3 = ((JSONObject)localObject1).getJSONArray(str);
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("get specs ");
        ((StringBuilder)localObject4).append(localObject3);
        SLog.b("Q.qqstory.home.ThumbnailUrlHelper", ((StringBuilder)localObject4).toString());
        localObject4 = new ArrayList();
        int j = 0;
        while (j < ((JSONArray)localObject3).length())
        {
          ((List)localObject4).add(Integer.valueOf(((JSONArray)localObject3).getInt(j)));
          j += 1;
        }
        c.put(str, localObject4);
        i += 1;
      }
    }
    catch (JSONException localJSONException)
    {
      label262:
      break label262;
    }
    SLog.e("Q.qqstory.home.ThumbnailUrlHelper", "Invalid json format, fredguo look look");
  }
  
  private static int b(String paramString, int paramInt)
  {
    if (paramString == null)
    {
      SLog.d("Q.qqstory.home.ThumbnailUrlHelper", "origPath is null");
      return -1;
    }
    if (c == null) {
      a();
    }
    if (c == null) {
      return a(paramString, paramInt);
    }
    Object localObject = h(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cannot find bid with url ");
      ((StringBuilder)localObject).append(paramString);
      SLog.d("Q.qqstory.home.ThumbnailUrlHelper", ((StringBuilder)localObject).toString());
      return -1;
    }
    paramString = (List)c.get(localObject);
    if (paramString == null)
    {
      paramString = new StringBuilder();
      paramString.append("cannot find specs with bid ");
      paramString.append((String)localObject);
      paramString.append(", check log");
      SLog.d("Q.qqstory.home.ThumbnailUrlHelper", paramString.toString());
      return -1;
    }
    return a(paramString, paramInt);
  }
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get thumbnail in 200 ");
    localStringBuilder.append(paramString);
    SLog.b("Q.qqstory.home.ThumbnailUrlHelper", localStringBuilder.toString());
    int i = b(paramString, 200);
    if (i < 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("get invalid thumbsize 200 with url ");
      localStringBuilder.append(paramString);
      SLog.d("Q.qqstory.home.ThumbnailUrlHelper", localStringBuilder.toString());
      return paramString;
    }
    paramString = d(paramString);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("return thumbnail in 200 ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(i);
    SLog.b("Q.qqstory.home.ThumbnailUrlHelper", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  public static String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get thumbnail in 320 ");
    localStringBuilder.append(paramString);
    SLog.b("Q.qqstory.home.ThumbnailUrlHelper", localStringBuilder.toString());
    int i = b(paramString, 320);
    if (i < 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("get invalid thumbsize 320 with url ");
      localStringBuilder.append(paramString);
      SLog.d("Q.qqstory.home.ThumbnailUrlHelper", localStringBuilder.toString());
      return paramString;
    }
    paramString = d(paramString);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("return thumbnail in 320 ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(i);
    SLog.b("Q.qqstory.home.ThumbnailUrlHelper", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  public static String d(String paramString)
  {
    if (i(paramString)) {
      return e(paramString);
    }
    if (paramString.endsWith("/")) {
      return paramString;
    }
    int k = paramString.lastIndexOf("/");
    int j;
    int i;
    if ((k >= 0) && (k < paramString.length() - 1))
    {
      str = paramString.substring(k + 1, paramString.length());
      j = str.length() - 1;
      i = 0;
    }
    while (j >= 0) {
      if (Character.isDigit(str.charAt(j)))
      {
        j -= 1;
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
    String str = paramString;
    if (i != 0) {
      str = paramString.substring(0, k);
    }
    paramString = new StringBuilder();
    paramString.append(str);
    paramString.append("/");
    return paramString.toString();
  }
  
  public static String e(String paramString)
  {
    if (paramString.endsWith("/")) {
      return paramString;
    }
    int k = paramString.lastIndexOf("/");
    int j;
    int i;
    if ((k >= 0) && (k < paramString.length() - 1))
    {
      str = paramString.substring(k + 1, paramString.length());
      j = 0;
      i = 0;
    }
    while (j < str.length())
    {
      char c1 = str.charAt(j);
      if (!Character.isDigit(c1))
      {
        if (c1 == '?')
        {
          i = 1;
          break;
        }
      }
      else
      {
        j += 1;
        i = 1;
        continue;
      }
      i = 0;
    }
    String str = paramString;
    if (i != 0) {
      str = paramString.substring(0, k + 1);
    }
    return str;
  }
  
  public static boolean f(@NonNull String paramString)
  {
    if ((paramString.length() >= 30) && (paramString.startsWith("/qqstory_pic/", 17))) {
      return true;
    }
    return paramString.contains("/qqstory_pic/");
  }
  
  @Deprecated
  public static boolean g(@NonNull String paramString)
  {
    if ((paramString.length() >= 26) && (paramString.startsWith("/qqstory/", 17))) {
      return true;
    }
    return paramString.contains("/qqstory/");
  }
  
  @Nullable
  private static String h(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      paramString = paramString.split("/");
      if (paramString.length < 4) {
        return null;
      }
      return paramString[3];
    }
    return null;
  }
  
  private static boolean i(@NonNull String paramString)
  {
    int i;
    if (paramString.startsWith("http://"))
    {
      i = 7;
    }
    else
    {
      if (!paramString.startsWith("https://")) {
        break label73;
      }
      i = 8;
    }
    if (!paramString.startsWith("qqpublic.qpic.cn/", i)) {
      return false;
    }
    i += 17;
    if (paramString.startsWith("qq_public_cover/", i)) {
      return true;
    }
    if (paramString.startsWith("qq_public/", i)) {
      return true;
    }
    label73:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ThumbnailUrlHelper
 * JD-Core Version:    0.7.0.1
 */