package com.peterlmeng.animate_image;

import com.peterlmeng.animate_image.support.log.LogUtils;
import java.io.File;

public class AnimateImgInitManager
{
  private static final String TAG = "AnimateImgInitManager";
  private static AnimateImgInitManager sInstance = new AnimateImgInitManager();
  AnimateImgInitInterface animateImgInitInterface;
  public boolean isSoLoad;
  
  public static AnimateImgInitManager getsInstance()
  {
    return sInstance;
  }
  
  private boolean loadPagSo(String paramString)
  {
    if (new File(paramString).exists())
    {
      System.load(paramString);
      LogUtils.a("AnimateImgInitManager", " load from outside");
      this.isSoLoad = true;
      return true;
    }
    return false;
  }
  
  public boolean init(AnimateImgInitInterface paramAnimateImgInitInterface)
  {
    try
    {
      this.animateImgInitInterface = paramAnimateImgInitInterface;
      boolean bool = loadPagSo(paramAnimateImgInitInterface.getPagLibPath());
      return bool;
    }
    catch (UnsatisfiedLinkError paramAnimateImgInitInterface)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load so UnsatisfiedLinkError:");
      localStringBuilder.append(paramAnimateImgInitInterface.getMessage());
      LogUtils.b("AnimateImgInitManager", localStringBuilder.toString());
    }
    return false;
  }
  
  public void release() {}
  
  public boolean reloadSo()
  {
    AnimateImgInitInterface localAnimateImgInitInterface = this.animateImgInitInterface;
    if (localAnimateImgInitInterface == null) {
      return false;
    }
    try
    {
      boolean bool = loadPagSo(localAnimateImgInitInterface.getPagLibPath());
      return bool;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load so UnsatisfiedLinkError:");
      localStringBuilder.append(localUnsatisfiedLinkError.getMessage());
      LogUtils.b("AnimateImgInitManager", localStringBuilder.toString());
    }
    return false;
  }
  
  public boolean soFileExist()
  {
    AnimateImgInitInterface localAnimateImgInitInterface = this.animateImgInitInterface;
    return (localAnimateImgInitInterface != null) && (new File(localAnimateImgInitInterface.getPagLibPath()).exists());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.AnimateImgInitManager
 * JD-Core Version:    0.7.0.1
 */