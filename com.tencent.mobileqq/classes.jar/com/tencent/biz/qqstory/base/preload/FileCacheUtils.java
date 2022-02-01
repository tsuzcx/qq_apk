package com.tencent.biz.qqstory.base.preload;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.OneObjectCacheList;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.SVUtils;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@TargetApi(14)
public class FileCacheUtils
{
  protected static OneObjectCacheList<String, FileCacheUtils.StringObj> a = new OneObjectCacheList(200);
  
  public static File a(String paramString, int paramInt)
  {
    QQStoryContext.a();
    paramString = TroopStoryUtil.a(QQStoryContext.a(), paramString);
    if ((paramString instanceof MessageForShortVideo)) {
      paramString = (MessageForShortVideo)paramString;
    } else {
      paramString = null;
    }
    if (paramString != null)
    {
      if (paramInt == 0) {
        paramString = SVUtils.a(paramString, "mp4");
      } else if (paramInt == 2) {
        paramString = SVUtils.a(paramString.thumbMD5, "jpg");
      } else {
        paramString = null;
      }
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new File(paramString);
        if (paramString.exists()) {
          return paramString;
        }
        return null;
      }
    }
    return null;
  }
  
  public static File a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(paramString);
    Object localObject;
    if ((localStoryVideoItem != null) && (localStoryVideoItem.isMine())) {
      localObject = a(paramString, localStoryVideoItem.mCreateTime, paramInt, false, paramBoolean2);
    } else {
      localObject = a(paramString, paramInt, false, paramBoolean2);
    }
    File localFile = new File((String)localObject);
    if (localFile.exists())
    {
      if (localStoryVideoItem != null) {
        a(localStoryVideoItem, (String)localObject, paramInt);
      }
      return localFile;
    }
    if (localStoryVideoItem != null) {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if ((paramInt == 2) && (!TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)))
          {
            localObject = new File(localStoryVideoItem.mVideoLocalThumbnailPath);
            if (((File)localObject).exists()) {
              return localObject;
            }
          }
        }
        else if (!TextUtils.isEmpty(localStoryVideoItem.mLocalMaskPath))
        {
          localObject = new File(localStoryVideoItem.mLocalMaskPath);
          if (((File)localObject).exists()) {
            return localObject;
          }
        }
      }
      else if (!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath))
      {
        localObject = new File(localStoryVideoItem.mLocalVideoPath);
        if (((File)localObject).exists()) {
          return localObject;
        }
      }
    }
    if ((TroopStoryUtil.a(paramString)) && (a(paramString, paramInt) != null)) {
      return a(paramString, paramInt);
    }
    if (paramBoolean1)
    {
      if ((localStoryVideoItem != null) && (localStoryVideoItem.isMine())) {
        paramString = a(paramString, localStoryVideoItem.mCreateTime, paramInt, true, paramBoolean2);
      } else {
        paramString = a(paramString, paramInt, true, paramBoolean2);
      }
      return new File(paramString);
    }
    return null;
  }
  
  protected static String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 5) {
              return ".file";
            }
            return "at.png";
          }
          return ".png";
        }
        return "thumb.jpeg";
      }
      return "mask.png";
    }
    return ".mp4";
  }
  
  public static String a(File paramFile)
  {
    if (paramFile.exists())
    {
      String str = paramFile.getParentFile().getAbsolutePath();
      Object localObject2 = paramFile.getName();
      if (((String)localObject2).endsWith(".tmp"))
      {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 4);
      }
      else
      {
        localObject1 = localObject2;
        if (((String)localObject2).endsWith(".stmp")) {
          localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 5);
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append((String)localObject1);
      Object localObject1 = ((StringBuilder)localObject2).toString();
      paramFile.renameTo(new File((String)localObject1));
      return localObject1;
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = a(MessageDigest.getInstance("MD5").digest(paramString.getBytes()));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new IllegalStateException(paramString);
    }
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QQStoryConstant.i);
    localStringBuilder.append(a(paramString, false, 0L));
    localStringBuilder.append("/");
    localStringBuilder.append(b(paramString, paramInt, paramBoolean1, paramBoolean2));
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (TroopStoryUtil.a(paramString)) {
      str = QQStoryConstant.i;
    } else {
      str = QQStoryConstant.j;
    }
    localStringBuilder.append(str);
    localStringBuilder.append(a(paramString, true, paramLong));
    localStringBuilder.append("/");
    localStringBuilder.append(b(paramString, paramLong, paramInt, paramBoolean1, paramBoolean2));
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, boolean paramBoolean, long paramLong)
  {
    if (TroopStoryUtil.a(paramString)) {
      return StoryVideoItem.getCacheKey(paramString);
    }
    if (paramBoolean) {
      return String.valueOf(paramLong);
    }
    String str = b(paramString);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    str = a(paramString);
    a(paramString, str);
    return str;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append(String.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static void a(StoryVideoItem paramStoryVideoItem, String paramString, int paramInt)
  {
    a(paramStoryVideoItem, paramString, paramInt, "");
  }
  
  public static void a(StoryVideoItem paramStoryVideoItem, String paramString1, int paramInt, String paramString2)
  {
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        if (!TextUtils.equals(paramStoryVideoItem.mVideoLocalThumbnailPath, paramString1))
        {
          paramStoryVideoItem.mVideoLocalThumbnailPath = paramString1;
          if (!TextUtils.isEmpty(paramString2)) {
            paramStoryVideoItem.mDownloadNetType = paramString2;
          }
          localStoryManager.a(paramStoryVideoItem.mVid, paramStoryVideoItem);
        }
      }
      else if (!TextUtils.equals(paramStoryVideoItem.mLocalMaskPath, paramString1))
      {
        paramStoryVideoItem.mLocalMaskPath = paramString1;
        if (!TextUtils.isEmpty(paramString2)) {
          paramStoryVideoItem.mDownloadNetType = paramString2;
        }
        localStoryManager.a(paramStoryVideoItem.mVid, paramStoryVideoItem);
      }
    }
    else if (!TextUtils.equals(paramStoryVideoItem.mLocalVideoPath, paramString1))
    {
      paramStoryVideoItem.mLocalVideoPath = paramString1;
      if (!TextUtils.isEmpty(paramString2)) {
        paramStoryVideoItem.mDownloadNetType = paramString2;
      }
      localStoryManager.a(paramStoryVideoItem.mVid, paramStoryVideoItem);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    FileCacheUtils.StringObj localStringObj = new FileCacheUtils.StringObj();
    localStringObj.a = paramString2;
    a.a(paramString1, localStringObj);
  }
  
  public static boolean a(File paramFile)
  {
    boolean bool1 = paramFile.exists();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    bool1 = bool2;
    if (!paramFile.getName().endsWith(".tmp"))
    {
      bool1 = bool2;
      if (!paramFile.getName().endsWith(".stmp")) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static String b(String paramString)
  {
    paramString = (FileCacheUtils.StringObj)a.a(paramString);
    if (paramString != null) {
      return paramString.a;
    }
    return null;
  }
  
  public static String b(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(paramInt);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramString = a(paramString, false, 0L);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(paramString, false, 0L));
      localStringBuilder.append((String)localObject);
      paramString = localStringBuilder.toString();
    }
    localObject = paramString;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(".stmp");
        return ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".tmp");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static String b(String paramString, long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = a(paramInt);
    Object localObject = a(paramString, true, paramLong);
    paramString = (String)localObject;
    if (!TextUtils.isEmpty(str))
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append(str);
      paramString = paramString.toString();
    }
    localObject = paramString;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(".stmp");
        return ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".tmp");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.FileCacheUtils
 * JD-Core Version:    0.7.0.1
 */