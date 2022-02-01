package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaReply;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.HashMap;
import java.util.Map;

public class WSCommentRestoreManager
{
  private static volatile WSCommentRestoreManager a;
  private final Map<String, String> b = new HashMap();
  private String c;
  private stSimpleMetaComment d;
  private stSimpleMetaReply e;
  private String f = "0";
  private int g;
  
  public static WSCommentRestoreManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new WSCommentRestoreManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1)) {
      localStringBuilder.append(paramString1);
    } else {
      localStringBuilder.append("0");
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      localStringBuilder.append("&&");
      localStringBuilder.append(paramString2);
    }
    else
    {
      localStringBuilder.append("&&");
      localStringBuilder.append("0");
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      localStringBuilder.append("&&");
      localStringBuilder.append(paramString3);
    }
    else
    {
      localStringBuilder.append("&&");
      localStringBuilder.append("0");
    }
    return localStringBuilder.toString();
  }
  
  private void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSCommentRestoreManager][storeComment] storeKey: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" comment: ");
    localStringBuilder.append(paramString2);
    WSLog.b("WSCommentRestoreManager", localStringBuilder.toString());
    this.b.put(paramString1, paramString2);
  }
  
  private String c(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    String str = "";
    if (paramstSimpleMetaFeed != null) {
      paramstSimpleMetaFeed = paramstSimpleMetaFeed.id;
    } else {
      paramstSimpleMetaFeed = "";
    }
    if (paramstSimpleMetaComment != null) {
      paramstSimpleMetaComment = paramstSimpleMetaComment.id;
    } else {
      paramstSimpleMetaComment = "";
    }
    if (paramstSimpleMetaReply != null) {
      str = paramstSimpleMetaReply.id;
    }
    return a(paramstSimpleMetaFeed, paramstSimpleMetaComment, str);
  }
  
  public stSimpleMetaComment a(String paramString)
  {
    if (!TextUtils.equals(this.c, paramString)) {
      this.d = null;
    }
    return this.d;
  }
  
  public String a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    paramstSimpleMetaFeed = c(paramstSimpleMetaFeed, paramstSimpleMetaComment, paramstSimpleMetaReply);
    return (String)this.b.remove(paramstSimpleMetaFeed);
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply, String paramString, int paramInt)
  {
    if (paramstSimpleMetaFeed != null) {
      this.c = paramstSimpleMetaFeed.id;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.d = paramstSimpleMetaComment;
      this.e = paramstSimpleMetaReply;
    }
    else
    {
      this.d = null;
      this.e = null;
      a(paramstSimpleMetaFeed, null, null);
      paramInt = 0;
    }
    paramstSimpleMetaFeed = c(paramstSimpleMetaFeed, paramstSimpleMetaComment, paramstSimpleMetaReply);
    a(paramstSimpleMetaFeed, paramString);
    this.f = paramstSimpleMetaFeed;
    this.g = paramInt;
  }
  
  public int b(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    if (!TextUtils.equals(c(paramstSimpleMetaFeed, paramstSimpleMetaComment, paramstSimpleMetaReply), this.f))
    {
      this.g = 0;
      this.f = "0";
    }
    return this.g;
  }
  
  public stSimpleMetaReply b(String paramString)
  {
    if (!TextUtils.equals(this.c, paramString)) {
      this.e = null;
    }
    return this.e;
  }
  
  public String b()
  {
    if (TextUtils.isEmpty(this.c)) {
      return "0";
    }
    return this.c;
  }
  
  public void c()
  {
    this.d = null;
    this.e = null;
    this.c = "0";
    this.g = 0;
    this.f = "0";
    this.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentRestoreManager
 * JD-Core Version:    0.7.0.1
 */