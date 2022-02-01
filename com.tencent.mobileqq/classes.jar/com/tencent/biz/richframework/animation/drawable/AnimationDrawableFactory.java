package com.tencent.biz.richframework.animation.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.util.LruCache;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class AnimationDrawableFactory
{
  private static volatile AnimationDrawableFactory jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory;
  private LruCache<String, AnimationDrawable> jdField_a_of_type_AndroidUtilLruCache = new LruCache(10);
  private final ConcurrentHashMap<String, RFWDownloader.RFWDownloadListener> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private LruCache<String, QQAnimationDrawable> b;
  
  private Bitmap a(File paramFile)
  {
    RFLog.i("AnimationDrawableFactory", RFLog.CLR, "getBitMapFromFile fileName:" + paramFile.getName());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramFile.exists())
    {
      localObject1 = localObject2;
      if (paramFile.isFile()) {
        localObject1 = BitmapFactory.decodeFile(paramFile.getAbsolutePath());
      }
    }
    return localObject1;
  }
  
  public static AnimationDrawableFactory a()
  {
    if (jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory == null) {
        jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory = new AnimationDrawableFactory();
      }
      return jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory;
    }
    finally {}
  }
  
  private QQAnimationDrawable a(String paramString)
  {
    if ((this.b != null) && (!StringUtil.a(paramString))) {
      return (QQAnimationDrawable)this.b.get(paramString);
    }
    return null;
  }
  
  private static List<File> a(File paramFile)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      paramFile = paramFile.listFiles(new AnimationDrawableFactory.3());
      int j = paramFile.length;
      int i = 0;
      if (i < j)
      {
        File localFile = paramFile[i];
        if (!localFile.exists()) {}
        for (;;)
        {
          i += 1;
          break;
          if (localFile.isDirectory()) {
            localLinkedList.addAll(a(localFile));
          } else {
            localLinkedList.add(localFile);
          }
        }
      }
    }
    return localLinkedList;
  }
  
  private void a(String paramString, QQAnimationDrawable paramQQAnimationDrawable)
  {
    if (this.b == null) {
      this.b = new LruCache(10);
    }
    this.b.put(paramString, paramQQAnimationDrawable);
  }
  
  public static String[] a(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      RFLog.i("AnimationDrawableFactory", RFLog.CLR, "exist Animation Pic!");
      paramString = a(paramString);
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
    paramString = a(paramString);
    if ((paramString != null) && (paramString.length > 0) && (paramInt > 1))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length)
      {
        localArrayList.add(paramString[i]);
        i += paramInt;
      }
      if (paramString.length % paramInt != 0) {
        localArrayList.add(paramString[(paramString.length - 1)]);
      }
      return (String[])localArrayList.toArray(new String[localArrayList.size()]);
    }
    return paramString;
  }
  
  public static String[] a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (DeviceInfoUtils.b())) {}
    for (int i = 2;; i = 1) {
      return a(paramString, i);
    }
  }
  
  public void a(int paramInt, AnimationDrawableCreateOption paramAnimationDrawableCreateOption, AnimationDrawableFactory.CreateResultListener paramCreateResultListener)
  {
    String str = paramInt + "@" + paramAnimationDrawableCreateOption.a();
    RFLog.d("AnimationDrawableFactory", RFLog.USR, "createFromUrl" + str);
    if (paramAnimationDrawableCreateOption.a()) {}
    for (QQAnimationDrawable localQQAnimationDrawable = a(paramAnimationDrawableCreateOption.a());; localQQAnimationDrawable = null)
    {
      if (localQQAnimationDrawable != null)
      {
        RFLog.d("AnimationDrawableFactory", RFLog.USR, "getAnimationDrawable from cache success");
        paramCreateResultListener.a(true, localQQAnimationDrawable);
        return;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
      {
        RFLog.d("AnimationDrawableFactory", RFLog.USR, "drawable is creating" + str);
        paramCreateResultListener.a(false, null);
        return;
      }
      paramCreateResultListener = new AnimationDrawableFactory.1(this, System.currentTimeMillis(), paramAnimationDrawableCreateOption, str, paramCreateResultListener);
      RFLog.d("AnimationDrawableFactory", RFLog.USR, "addKey" + str);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramCreateResultListener);
      RFWDownloaderFactory.getDownloader(paramAnimationDrawableCreateOption.a()).download(paramAnimationDrawableCreateOption.a(), paramCreateResultListener);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory
 * JD-Core Version:    0.7.0.1
 */