package com.tencent.ad.tangram.views.canvas.components.appbutton;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.tencent.ad.tangram.log.AdLog;
import java.util.List;

public class a
  extends h
{
  public static final String TAG = "AdCanvasAppBtnUIAdapter";
  public boolean addToDownloadCallbacks;
  private String btnTitle;
  private AdAppDownloadManager mAdAppDownloadManager;
  private f mAdProgressButton;
  public boolean resumeDownload = false;
  
  public a(String paramString, f paramf, AdAppDownloadManager paramAdAppDownloadManager, boolean paramBoolean)
  {
    this.mAdProgressButton = paramf;
    this.mAdAppDownloadManager = paramAdAppDownloadManager;
    this.btnTitle = paramString;
    this.addToDownloadCallbacks = paramBoolean;
  }
  
  void finishDownloadUpdateUI()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      new Handler(Looper.getMainLooper()).post(new a.2(this));
      return;
    }
    f localf = this.mAdProgressButton;
    if (localf != null)
    {
      localf.setProgress(100);
      this.mAdProgressButton.setText("安装");
    }
  }
  
  void installSucceedUpdateUI()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      new Handler(Looper.getMainLooper()).post(new a.3(this));
      return;
    }
    f localf = this.mAdProgressButton;
    if (localf != null)
    {
      localf.setProgress(100);
      this.mAdProgressButton.setText("打开");
    }
  }
  
  public void onDownloadProgressUpdate(List<Object> paramList, List<Pair<String, String>> paramList1) {}
  
  public void onDownloadStatusChanged(int paramInt1, int paramInt2, Pair<String, String> paramPair, String paramString) {}
  
  void updateBtnProgressUI(int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      new Handler(Looper.getMainLooper()).post(new a.1(this, paramInt));
      return;
    }
    if ((this.mAdProgressButton != null) && (paramInt >= 0))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateBtnProgressUI ");
      ((StringBuilder)localObject).append(paramInt);
      AdLog.i("AdCanvasAppBtnUIAdapter", ((StringBuilder)localObject).toString());
      localObject = this.mAdProgressButton;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("下载中, ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("%");
      ((f)localObject).setText(localStringBuilder.toString());
      this.mAdProgressButton.setProgress(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.appbutton.a
 * JD-Core Version:    0.7.0.1
 */