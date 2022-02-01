package com.tencent.biz.qqstory.base.videoupload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class StoryVideoUploadManager$5
  implements ThreadExcutor.IThreadListener
{
  StoryVideoUploadManager$5(StoryVideoUploadManager paramStoryVideoUploadManager, StoryVideoTaskInfo paramStoryVideoTaskInfo) {}
  
  public void onAdded() {}
  
  public void onPostRun() {}
  
  public void onPreRun()
  {
    if (!TextUtils.isEmpty(this.a.h))
    {
      boolean bool1 = this.a.e().getBooleanExtra("landscape_video", false);
      boolean bool2 = this.a.e().isLocalPublish;
      boolean bool3 = this.a.e().getBooleanExtra("is_hw_encode", false);
      int i;
      if (this.a.e().businessId == 1) {
        i = 1;
      } else {
        i = 0;
      }
      int j = this.a.e().getIntExtra("thumb_rotation", 0);
      if (bool2) {
        j = 0;
      } else {
        j = 360 - j;
      }
      if ((i != 0) && (bool3) && ((!bool2) || (bool1)) && (j != 0)) {
        try
        {
          BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(this.a.h));
          Bitmap localBitmap1 = BitmapFactory.decodeStream(localBufferedInputStream);
          Bitmap localBitmap2 = BitmapUtils.a(localBitmap1, j);
          bool1 = BitmapUtils.a(localBitmap2, this.a.h);
          if (localBitmap2 != null) {
            localBitmap2.recycle();
          }
          localBitmap1.recycle();
          localBufferedInputStream.close();
          if (!bool1) {
            SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "compress file fail, %s", new Object[] { this.a.h });
          } else {
            SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "video local file exist %b, %s", new Object[] { Boolean.valueOf(FileUtils.c(this.a.h)), this.a.h });
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          SLog.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "OutOfMemoryError = ", localOutOfMemoryError);
        }
        catch (IOException localIOException)
        {
          SLog.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "IOException =", localIOException);
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          SLog.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "FileNotFoundException =", localFileNotFoundException);
        }
      }
    }
    StoryVideoUploadManager.a(this.b);
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "create story %s", new Object[] { this.a });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.5
 * JD-Core Version:    0.7.0.1
 */