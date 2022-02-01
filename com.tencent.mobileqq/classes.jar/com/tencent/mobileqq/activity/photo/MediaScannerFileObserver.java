package com.tencent.mobileqq.activity.photo;

import android.os.FileObserver;

public class MediaScannerFileObserver
  extends FileObserver
{
  private static final String TAG = "MediaScannerFileObserver";
  private String mFolderPath = null;
  private MediaScanner mMediaScanner = null;
  
  public MediaScannerFileObserver(MediaScanner paramMediaScanner, String paramString)
  {
    super(paramString);
    this.mFolderPath = paramString;
    this.mMediaScanner = paramMediaScanner;
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if (this.mMediaScanner == null) {}
    do
    {
      return;
      switch (paramInt)
      {
      default: 
        return;
      }
    } while ((paramString == null) || (!paramString.endsWith(".mp4")));
    this.mMediaScanner.handleFileObserverEvent(paramInt, this.mFolderPath, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaScannerFileObserver
 * JD-Core Version:    0.7.0.1
 */