package com.tencent.biz.qqstory.model.item;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.Column;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import com.tencent.mobileqq.utils.Patterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoLinkInfo
{
  @JsonORM.Column(a="type")
  public int a;
  @JsonORM.Column(a="linkUrl")
  public String b;
  @JsonORM.Column(a="title")
  public String c;
  @JsonORM.Column(a="body")
  public String d;
  @JsonORM.Column(a="picUrl")
  public String e;
  @JsonORM.Column(a="app")
  public String f;
  @JsonORM.Column(a="parseState")
  public int g;
  @JsonORM.Column(a="videoShare")
  public VideoLinkInfo.VipFrwrdLinkInfo h;
  @JsonORM.Column(a="game")
  public VideoLinkGameInfo i;
  @JsonORM.Column(a="gameinfo")
  public VideoGameInfo j;
  @JsonORM.Column(a="comp")
  public VideoCompInfo k;
  @JsonORM.Column(a="capture")
  public VideoCaptureInfo l;
  
  @Nullable
  public static VideoLinkInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = (VideoLinkInfo)JsonORM.a(new JSONObject(paramString), VideoLinkInfo.class);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (JsonORM.JsonParseException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    String str2 = this.b;
    Object localObject = str2;
    if (Patterns.d.matcher(str2).find())
    {
      String str1 = null;
      int m = str2.lastIndexOf("#");
      if (m > 0) {
        str1 = str2.substring(m);
      }
      str2 = URLUtil.guessUrl(str2);
      localObject = str2;
      if (str1 != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str2);
        ((StringBuilder)localObject).append(str1);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  public String a(boolean paramBoolean)
  {
    try
    {
      Object localObject = JsonORM.a(this);
      if (paramBoolean) {
        ((JSONObject)localObject).remove("parseState");
      }
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JsonORM.JsonParseException localJsonParseException)
    {
      SLog.b("Q.qqstory.tag", "VideoLinkInfo", localJsonParseException);
    }
    return "";
  }
  
  public String b()
  {
    String str1 = this.c;
    String str2 = "";
    if (str1 != null) {
      str1 = str1.trim();
    } else {
      str1 = "";
    }
    String str3 = this.d;
    if (str3 != null) {
      str2 = str3.trim();
    }
    if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2))) {
      return this.b;
    }
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      return String.format("%s-%s", new Object[] { str1, str2 });
    }
    if (!TextUtils.isEmpty(str1)) {
      return str1;
    }
    return str2;
  }
  
  public boolean c()
  {
    return (this.a == 5) && (this.h != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.VideoLinkInfo
 * JD-Core Version:    0.7.0.1
 */