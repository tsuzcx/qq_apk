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
    int i = RFLog.CLR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getBitMapFromFile fileName:");
    localStringBuilder.append(paramFile.getName());
    RFLog.i("AnimationDrawableFactory", i, localStringBuilder.toString());
    if ((paramFile.exists()) && (paramFile.isFile())) {
      return BitmapFactory.decodeFile(paramFile.getAbsolutePath());
    }
    return null;
  }
  
  public static AnimationDrawableFactory a()
  {
    if (jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory == null) {
      try
      {
        if (jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory == null) {
          jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory = new AnimationDrawableFactory();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory;
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
      while (i < j)
      {
        File localFile = paramFile[i];
        if (localFile.exists()) {
          if (localFile.isDirectory()) {
            localLinkedList.addAll(a(localFile));
          } else {
            localLinkedList.add(localFile);
          }
        }
        i += 1;
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
    if ((paramBoolean) && (DeviceInfoUtils.b())) {
      i = 2;
    } else {
      i = 1;
    }
    return a(paramString, i);
  }
  
  public void a(int paramInt, AnimationDrawableCreateOption paramAnimationDrawableCreateOption, AnimationDrawableFactory.CreateResultListener paramCreateResultListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("@");
    ((StringBuilder)localObject).append(paramAnimationDrawableCreateOption.a());
    String str = ((StringBuilder)localObject).toString();
    paramInt = RFLog.USR;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("createFromUrl");
    ((StringBuilder)localObject).append(str);
    RFLog.d("AnimationDrawableFactory", paramInt, ((StringBuilder)localObject).toString());
    if (paramAnimationDrawableCreateOption.a()) {
      localObject = a(paramAnimationDrawableCreateOption.a());
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      RFLog.d("AnimationDrawableFactory", RFLog.USR, "getAnimationDrawable from cache success");
      paramCreateResultListener.a(true, (QQAnimationDrawable)localObject);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      paramInt = RFLog.USR;
      paramAnimationDrawableCreateOption = new StringBuilder();
      paramAnimationDrawableCreateOption.append("drawable is creating");
      paramAnimationDrawableCreateOption.append(str);
      RFLog.d("AnimationDrawableFactory", paramInt, paramAnimationDrawableCreateOption.toString());
      paramCreateResultListener.a(false, null);
      return;
    }
    paramCreateResultListener = new AnimationDrawableFactory.1(this, System.currentTimeMillis(), paramAnimationDrawableCreateOption, str, paramCreateResultListener);
    paramInt = RFLog.USR;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addKey");
    ((StringBuilder)localObject).append(str);
    RFLog.d("AnimationDrawableFactory", paramInt, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramCreateResultListener);
    RFWDownloaderFactory.getDownloader(paramAnimationDrawableCreateOption.a()).download(paramAnimationDrawableCreateOption.a(), paramCreateResultListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory
 * JD-Core Version:    0.7.0.1
 */