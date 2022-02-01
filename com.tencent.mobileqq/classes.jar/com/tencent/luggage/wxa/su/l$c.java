package com.tencent.luggage.wxa.su;

import com.tencent.xweb.util.h;
import com.tencent.xweb.xwalk.updater.c;
import org.xwalk.core.XWalkLibraryLoader.DownloadInfo;
import org.xwalk.core.XWalkLibraryLoader.DownloadListener;

public class l$c
  implements XWalkLibraryLoader.DownloadListener
{
  private l a;
  private g b;
  private c c;
  private boolean d;
  
  l$c(l paraml, g paramg, c paramc)
  {
    this.a = paraml;
    this.b = paramg;
    this.c = paramc;
    if (paramc != null)
    {
      this.d = paramc.f;
      return;
    }
    this.d = false;
  }
  
  public void onDownloadCancelled()
  {
    this.a.b(this.b.a(), -3);
    h.c(this.b.a(), this.d);
    a.a(this.b.a()).b(null);
  }
  
  public void onDownloadCompleted(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
  {
    h.b(this.b.a(), this.d);
    a.a(this.b.a()).b(null);
    new l.c.1(this).execute(new Void[0]);
  }
  
  public void onDownloadFailed(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
  {
    this.a.b(this.b.a(), -1);
    h.c(this.b.a(), this.d);
    a.a(this.b.a()).b(null);
  }
  
  public void onDownloadStarted(int paramInt)
  {
    h.a(this.b.a(), this.d);
  }
  
  public void onDownloadUpdated(int paramInt)
  {
    this.a.a(this.b.a(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.su.l.c
 * JD-Core Version:    0.7.0.1
 */