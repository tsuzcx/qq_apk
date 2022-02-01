package com.tencent.biz.richframework.animation.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class AnimationDrawableFactory
{
  private static volatile AnimationDrawableFactory a;
  private LruCache<String, AnimationDrawable> b = new LruCache(10);
  private LruCache<String, QQAnimationDrawable> c;
  private final ConcurrentHashMap<String, RFWDownloader.RFWDownloadListener> d = new ConcurrentHashMap();
  
  private Bitmap a(File paramFile)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getBitMapFromFile fileName:");
    localStringBuilder.append(paramFile.getName());
    QLog.i("AnimationDrawableFactory", 2, localStringBuilder.toString());
    if ((paramFile.exists()) && (paramFile.isFile())) {
      return BitmapFactory.decodeFile(paramFile.getAbsolutePath());
    }
    return null;
  }
  
  public static AnimationDrawableFactory a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new AnimationDrawableFactory();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(String paramString, QQAnimationDrawable paramQQAnimationDrawable)
  {
    if (this.c == null) {
      this.c = new LruCache(10);
    }
    this.c.put(paramString, paramQQAnimationDrawable);
  }
  
  public static String[] a(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      QLog.i("AnimationDrawableFactory", 2, "exist Animation Pic!");
      paramString = b(paramString);
      if ((paramString != null) && (paramString.size() > 0))
      {
        paramString = (File[])paramString.toArray(new File[paramString.size()]);
        if ((paramString != null) && (paramString.length > 0))
        {
          Arrays.sort(paramString, new AnimationDrawableFactory.4());
          ArrayList localArrayList = new ArrayList();
          int j = paramString.length;
          int i = 0;
          while (i < j)
          {
            localArrayList.add(paramString[i].getPath());
            i += 1;
          }
          return (String[])localArrayList.toArray(new String[localArrayList.size()]);
        }
      }
    }
    return null;
  }
  
  private static String[] a(String paramString, int paramInt)
  {
    String[] arrayOfString = a(paramString);
    paramString = arrayOfString;
    if (arrayOfString != null)
    {
      paramString = arrayOfString;
      if (arrayOfString.length > 0)
      {
        paramString = arrayOfString;
        if (paramInt > 1)
        {
          paramString = new ArrayList();
          int i = 0;
          while (i < arrayOfString.length)
          {
            paramString.add(arrayOfString[i]);
            i += paramInt;
          }
          if (arrayOfString.length % paramInt != 0) {
            paramString.add(arrayOfString[(arrayOfString.length - 1)]);
          }
          paramString = (String[])paramString.toArray(new String[paramString.size()]);
        }
      }
    }
    return paramString;
  }
  
  public static String[] a(String paramString, boolean paramBoolean)
  {
    int i;
    if ((paramBoolean) && (DeviceInfoUtils.isLowPerfDevice())) {
      i = 2;
    } else {
      i = 1;
    }
    return a(paramString, i);
  }
  
  private QQAnimationDrawable b(String paramString)
  {
    if ((this.c != null) && (!TextUtils.isEmpty(paramString))) {
      return (QQAnimationDrawable)this.c.get(paramString);
    }
    return null;
  }
  
  private static List<File> b(File paramFile)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      paramFile = paramFile.listFiles(new AnimationDrawableFactory.3());
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          File localFile = paramFile[i];
          if (localFile.exists()) {
            if (localFile.isDirectory()) {
              localLinkedList.addAll(b(localFile));
            } else {
              localLinkedList.add(localFile);
            }
          }
          i += 1;
        }
      }
    }
    return localLinkedList;
  }
  
  public void a(int paramInt, AnimationDrawableCreateOption paramAnimationDrawableCreateOption, AnimationDrawableFactory.CreateResultListener paramCreateResultListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("@");
    ((StringBuilder)localObject).append(paramAnimationDrawableCreateOption.a());
    String str = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("createFromUrl");
    ((StringBuilder)localObject).append(str);
    QLog.d("AnimationDrawableFactory", 1, ((StringBuilder)localObject).toString());
    if (paramAnimationDrawableCreateOption.b()) {
      localObject = b(paramAnimationDrawableCreateOption.a());
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      QLog.d("AnimationDrawableFactory", 1, "getAnimationDrawable from cache success");
      paramCreateResultListener.a(true, (QQAnimationDrawable)localObject);
      return;
    }
    if (this.d.containsKey(str))
    {
      paramAnimationDrawableCreateOption = new StringBuilder();
      paramAnimationDrawableCreateOption.append("drawable is creating");
      paramAnimationDrawableCreateOption.append(str);
      QLog.d("AnimationDrawableFactory", 1, paramAnimationDrawableCreateOption.toString());
      paramCreateResultListener.a(false, null);
      return;
    }
    paramCreateResultListener = new AnimationDrawableFactory.1(this, System.currentTimeMillis(), paramAnimationDrawableCreateOption, str, paramCreateResultListener);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addKey");
    ((StringBuilder)localObject).append(str);
    QLog.d("AnimationDrawableFactory", 1, ((StringBuilder)localObject).toString());
    this.d.put(str, paramCreateResultListener);
    RFWDownloaderFactory.getDownloader(paramAnimationDrawableCreateOption.g()).downloadOrUpdateFile(paramAnimationDrawableCreateOption.a(), paramCreateResultListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory
 * JD-Core Version:    0.7.0.1
 */