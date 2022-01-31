package com.tencent.mobileqq.activity.qwallet.emoj;

import ahiw;
import android.text.TextUtils;
import axio;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EmojiGifHelper$CompositeTask
  implements Runnable
{
  public EmojiGifHelper.EmojiInfo emojiInfo;
  public boolean isCancel;
  public EmojiGifHelper.OnConvertListener l;
  public EmojiGifHelper.ConvertParam publishParam;
  
  EmojiGifHelper$CompositeTask(EmojiGifHelper paramEmojiGifHelper, EmojiGifHelper.ConvertParam paramConvertParam, EmojiGifHelper.OnConvertListener paramOnConvertListener)
  {
    this.publishParam = paramConvertParam;
    this.l = paramOnConvertListener;
  }
  
  private String getGifPath()
  {
    String str = ahiw.a(null) + "Camera/";
    File localFile = new File(str + "gif");
    if ((localFile.exists()) && (!localFile.isDirectory())) {
      localFile.delete();
    }
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    return str + "gif" + File.separator + System.currentTimeMillis() + ".gif";
  }
  
  public void cancel()
  {
    synchronized (this.emojiInfo.lock)
    {
      this.isCancel = true;
      return;
    }
  }
  
  public boolean convertVideoToGif(EmojiGifHelper.ConvertParam paramConvertParam, String paramString)
  {
    boolean bool = false;
    try
    {
      int i = axio.a(paramConvertParam.inPath, paramConvertParam.videoWidth, paramConvertParam.videoHeight, paramConvertParam.videoDuration, paramString, 7, 30, 100);
      if (QLog.isColorLevel()) {
        QLog.i("EmojiGifHelper", 2, "Video2GifConverter: convert retCode=" + i);
      }
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramConvertParam)
    {
      QLog.e("EmojiGifHelper", 2, "processNotExistVideoData: convert exception" + paramConvertParam);
    }
    return false;
  }
  
  public void onTransResult(boolean paramBoolean, String paramString, EmojiGifHelper.OnConvertListener arg3, EmojiGifHelper.ConvertParam paramConvertParam)
  {
    if (this.isCancel) {}
    for (;;)
    {
      return;
      if (??? != null)
      {
        if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {
          break label96;
        }
        ???.onConvertResult(true, paramString);
      }
      while ((paramBoolean) && (this.emojiInfo != null))
      {
        synchronized (this.emojiInfo.lock)
        {
          if (!this.isCancel)
          {
            this.emojiInfo.gifPath = paramString;
            if (this.emojiInfo.isImmeSend) {
              EmojiGifHelper.access$000(this.this$0, this.emojiInfo);
            }
          }
          return;
        }
        label96:
        ???.onConvertResult(false, null);
      }
    }
  }
  
  public void run()
  {
    if (this.isCancel) {}
    String str;
    long l1;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("EmojiGifHelper", 2, "begin convert gif, publishParam=" + this.publishParam);
      }
      str = getGifPath();
      l1 = System.currentTimeMillis();
    } while (this.isCancel);
    if (convertVideoToGif(this.publishParam, str))
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmojiGifHelper", 2, "convertVideoToGif finished cost:" + (System.currentTimeMillis() - l1));
      }
      onTransResult(true, str, this.l, this.publishParam);
      return;
    }
    onTransResult(false, null, this.l, this.publishParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiGifHelper.CompositeTask
 * JD-Core Version:    0.7.0.1
 */