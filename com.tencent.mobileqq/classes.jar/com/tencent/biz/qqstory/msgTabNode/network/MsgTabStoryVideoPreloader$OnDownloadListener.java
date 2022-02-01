package com.tencent.biz.qqstory.msgTabNode.network;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.DownloadTask;
import com.tencent.biz.qqstory.base.preload.SimplePreloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

class MsgTabStoryVideoPreloader$OnDownloadListener
  extends SimplePreloadListener
{
  private final Set<String> b = new HashSet();
  
  public MsgTabStoryVideoPreloader$OnDownloadListener(MsgTabStoryVideoPreloader paramMsgTabStoryVideoPreloader)
  {
    super("MsgTabStoryVideoPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, DownloadTask paramDownloadTask)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramDownloadTask);
    if (paramInt2 == 2)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("download error: vid=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" fileType=");
        localStringBuilder.append(paramInt1);
        QLog.e("MsgTabStoryVideoPreloader", 2, localStringBuilder.toString(), paramErrorMessage);
      }
      this.a.a(paramDownloadTask.e, true);
    }
  }
  
  public void a(String paramString, int paramInt1, File paramFile, int paramInt2, DownloadTask paramDownloadTask)
  {
    super.a(paramString, paramInt1, paramFile, paramInt2, paramDownloadTask);
    if (paramInt2 == 2)
    {
      if (QLog.isColorLevel())
      {
        paramFile = new StringBuilder();
        paramFile.append("download success before: vid=");
        paramFile.append(paramString);
        paramFile.append(" fileType=");
        paramFile.append(paramInt1);
        QLog.i("MsgTabStoryVideoPreloader", 2, paramFile.toString());
      }
      this.a.a(paramDownloadTask.e, true);
    }
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, DownloadTask paramDownloadTask)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramDownloadTask);
    if (paramInt2 == 2)
    {
      if (QLog.isColorLevel())
      {
        paramFile = new StringBuilder();
        paramFile.append("download success: vid=");
        paramFile.append(paramString);
        paramFile.append(" fileType=");
        paramFile.append(paramInt1);
        QLog.i("MsgTabStoryVideoPreloader", 2, paramFile.toString());
      }
      this.a.a(paramDownloadTask.e, this.b.add(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabStoryVideoPreloader.OnDownloadListener
 * JD-Core Version:    0.7.0.1
 */