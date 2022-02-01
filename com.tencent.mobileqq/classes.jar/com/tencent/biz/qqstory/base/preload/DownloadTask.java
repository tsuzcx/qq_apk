package com.tencent.biz.qqstory.base.preload;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.transfile.HttpNetReq;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
public class DownloadTask
{
  public String a;
  public String b;
  public int c;
  public int d;
  public String e;
  public String f;
  public String g;
  public String h;
  public int i;
  public int j = -1;
  public boolean k = false;
  public Map<String, Object> l = new HashMap();
  public AsyncFileDownloader.DownloadResult m;
  public AsyncFileDownloader.InnerDownloader n;
  public int o = 0;
  public long p;
  public long q;
  public int r = 0;
  public int s = 1;
  public boolean t = false;
  public HttpNetReq u;
  public MessageForShortVideo v;
  public boolean w;
  
  public static DownloadTask a(String paramString, int paramInt)
  {
    return a(paramString, null, paramInt, false);
  }
  
  public static DownloadTask a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, null, paramInt, paramBoolean);
  }
  
  private static DownloadTask a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    DownloadTask localDownloadTask = new DownloadTask();
    Object localObject = ((StoryManager)SuperManager.a(5)).a(paramString1);
    if ((localObject != null) && (((StoryVideoItem)localObject).isMine()))
    {
      localDownloadTask.g = FileCacheUtils.a(paramString1, ((StoryVideoItem)localObject).mCreateTime, paramInt, false, false);
      localDownloadTask.h = FileCacheUtils.a(paramString1, ((StoryVideoItem)localObject).mCreateTime, paramInt, true, false);
    }
    else
    {
      localDownloadTask.g = FileCacheUtils.b(paramString1, paramInt, false, false);
      localDownloadTask.h = FileCacheUtils.b(paramString1, paramInt, true, false);
    }
    localDownloadTask.d = 0;
    localDownloadTask.b = paramString1;
    localDownloadTask.c = paramInt;
    localDownloadTask.a = b(paramString1, paramInt);
    localObject = "";
    if (paramBoolean) {
      paramString1 = "";
    } else {
      paramString1 = paramString2;
    }
    localDownloadTask.e = paramString1;
    if (paramBoolean) {
      paramString2 = (String)localObject;
    }
    localDownloadTask.f = paramString2;
    localDownloadTask.w = paramBoolean;
    return localDownloadTask;
  }
  
  public static String b(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof DownloadTask))
    {
      paramObject = (DownloadTask)paramObject;
      if (TextUtils.equals(this.a, paramObject.a)) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DownloadTask{vid='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileType=");
    localStringBuilder.append(QQStoryConstant.a(this.c));
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", downloadUrl='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", localPath='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", localTmpPath='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.DownloadTask
 * JD-Core Version:    0.7.0.1
 */