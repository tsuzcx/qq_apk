package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.os.Process;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

public class PublishFileManager
{
  private static int a;
  
  public static String a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_FILE_SAVE_TMP_PATH);
    ((StringBuilder)localObject).append("edit_video/business_");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(b(paramInt));
    ((StringBuilder)localObject).append("/");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(".nomedia");
    FileUtils.createFileIfNotExits(localStringBuilder.toString());
    a((String)localObject);
    return localObject;
  }
  
  @NonNull
  public static String a(int paramInt, String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      Object localObject = paramString1;
      if (!paramString1.endsWith("/"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append("/");
        localObject = ((StringBuilder)localObject).toString();
      }
      paramString1 = new StringBuilder();
      paramString1.append((String)localObject);
      paramString1.append(System.currentTimeMillis());
      paramString1.append("_");
      paramString1.append(b(paramInt));
      paramString1.append(paramString2);
      return paramString1.toString();
    }
    throw new IllegalArgumentException("folderPath should not be null");
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    boolean bool;
    if (paramString.isFile())
    {
      bool = paramString.delete();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("delete file : ");
      localStringBuilder.append(bool);
      SLog.d("Q.qqstory.publish.edit.PublishFileManager", localStringBuilder.toString());
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      paramString = new StringBuilder();
      paramString.append("create folder : ");
      paramString.append(bool);
      SLog.d("Q.qqstory.publish.edit.PublishFileManager", paramString.toString());
    }
  }
  
  private static String b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("T");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("B");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("P");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append("T");
    localStringBuilder.append(Process.myTid());
    localStringBuilder.append("I");
    paramInt = a;
    a = paramInt + 1;
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.PublishFileManager
 * JD-Core Version:    0.7.0.1
 */