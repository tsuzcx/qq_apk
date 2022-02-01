package com.tencent.biz.qqstory.model.filter;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.biz.qqstory.base.download.Downloader;
import com.tencent.biz.qqstory.model.pendant.FileDownloadTask;
import com.tencent.biz.qqstory.model.pendant.FileDownloadTask.Input;
import com.tencent.biz.qqstory.model.pendant.FileDownloadTask.Output;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import java.io.File;
import java.util.Map;

class VideoFilterManager$1
  extends FileDownloadTask
{
  VideoFilterManager$1(VideoFilterManager paramVideoFilterManager, Downloader paramDownloader)
  {
    super(paramDownloader);
  }
  
  protected FileDownloadTask.Output a(FileDownloadTask.Input... paramVarArgs)
  {
    FileDownloadTask.Output localOutput = super.a(paramVarArgs);
    paramVarArgs = paramVarArgs[0];
    String str;
    if (localOutput.b == 0) {
      str = paramVarArgs.b.substring(0, paramVarArgs.b.length() - 4);
    }
    try
    {
      FileUtils.e(str);
      label44:
      int i = ZipUtils.unZipFolder(paramVarArgs.b, str);
      if (i == 0)
      {
        if (VideoFilterManager.a(str, false))
        {
          paramVarArgs = null;
          try
          {
            PictureFilterConfig localPictureFilterConfig = this.a.a(new File(str, "config.json"));
            paramVarArgs = localPictureFilterConfig;
          }
          catch (Exception localException1)
          {
            SLog.c("FileDownloadTask", "parse config failed", localException1);
          }
          if (paramVarArgs != null)
          {
            SLog.d("FileDownloadTask", "parse config file success !");
            this.a.f.put(str, paramVarArgs);
            return localOutput;
          }
          SLog.e("FileDownloadTask", "parse config failed : %s, %s", new Object[] { str, "config.json" });
          return new FileDownloadTask.Output(localOutput.a, -1, "illegal config file");
        }
        SLog.e("FileDownloadTask", "unzip success, but this is an illegal filter folder : %s", new Object[] { str });
        return new FileDownloadTask.Output(localOutput.a, -1, "illegal folder");
      }
      SLog.e("FileDownloadTask", "download success, but unzip failed : %d", new Object[] { Integer.valueOf(i) });
      return new FileDownloadTask.Output(localOutput.a, i, "unzip failed");
      return localOutput;
    }
    catch (Exception localException2)
    {
      break label44;
    }
  }
  
  protected void a(FileDownloadTask.Output arg1)
  {
    SLog.a("FileDownloadTask", "downloadConfigFile onPostExecute : %s", ???);
    if (???.b == 0) {
      SLog.d("FileDownloadTask", "get filter resource success : %s", new Object[] { ???.a.a });
    } else {
      SLog.d("FileDownloadTask", "get filter resource failed : %d : %s : %s", new Object[] { Integer.valueOf(???.b), ???.c, ???.a.a });
    }
    synchronized (this.a.e)
    {
      VideoFilterManager.a(this.a, null);
      this.a.d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.filter.VideoFilterManager.1
 * JD-Core Version:    0.7.0.1
 */