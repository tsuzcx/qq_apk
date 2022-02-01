package com.tencent.aelight.camera.struct.editor;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;

public abstract class MusicDownloadListener
  extends DownloadListener
{
  public abstract void a(int paramInt);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void a(String paramString, boolean paramBoolean, int paramInt);
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    super.onCancel(paramDownloadTask);
    a(paramDownloadTask.b);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    String str = paramDownloadTask.b;
    boolean bool;
    if (paramDownloadTask.e() == 3) {
      bool = true;
    } else {
      bool = false;
    }
    a(str, bool, paramDownloadTask.c);
  }
  
  public void onNetMobile2None()
  {
    super.onNetMobile2None();
    a(2);
  }
  
  public void onNetWifi2Mobile()
  {
    super.onNetWifi2Mobile();
    a(1);
  }
  
  public void onNetWifi2None()
  {
    super.onNetWifi2None();
    a(3);
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    super.onProgress(paramDownloadTask);
    int i = (int)paramDownloadTask.l;
    a(paramDownloadTask.b, i);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    super.onStart(paramDownloadTask);
    a(paramDownloadTask.b, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.struct.editor.MusicDownloadListener
 * JD-Core Version:    0.7.0.1
 */