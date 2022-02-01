package com.tencent.biz.qqstory.takevideo.music;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;
import java.io.File;

public class QQStoryBGMusicUtils
{
  public static final String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = new File(QQStoryConstant.g);
      if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
        ((File)localObject).mkdirs();
      }
      localObject = new StringBuilder(QQStoryConstant.g);
      ((StringBuilder)localObject).append(MD5.a(paramString));
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(FileUtils.c(paramString));
      paramString = ((StringBuilder)localObject).toString();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("createMusicFilePath destPath = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("zivonchen", 2, ((StringBuilder)localObject).toString());
      }
      return paramString;
    }
    throw new NullPointerException("MusicComposeDialog.createMusicFilePath() musicUrl is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.QQStoryBGMusicUtils
 * JD-Core Version:    0.7.0.1
 */