package com.tencent.ad.tangram.canvas.views.canvas.components.appbutton;

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
    if (Looper.myLooper() != Looper.getMainLooper()) {
      new Handler(Looper.getMainLooper()).post(new a.2(this));
    }
    while (this.mAdProgressButton == null) {
      return;
    }
    this.mAdProgressButton.resetUI();
    this.mAdProgressButton.setText("安装");
  }
  
  void installSucceedUpdateUI()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      new Handler(Looper.getMainLooper()).post(new a.3(this));
    }
    while (this.mAdProgressButton == null) {
      return;
    }
    this.mAdProgressButton.resetUI();
    this.mAdProgressButton.setText("打开");
  }
  
  public void onDownloadProgressUpdate(List<Object> paramList, List<Pair<String, String>> paramList1) {}
  
  public void onDownloadStatusChanged(int paramInt1, int paramInt2, Pair<String, String> paramPair, String paramString) {}
  
  void updateBtnProgressUI(int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      new Handler(Looper.getMainLooper()).post(new a.1(this, paramInt));
    }
    while ((this.mAdProgressButton == null) || (paramInt < 0)) {
      return;
    }
    AdLog.i("AdCanvasAppBtnUIAdapter", "updateBtnProgressUI " + paramInt);
    this.mAdProgressButton.setDownloadingUI("下载中, " + paramInt + "%");
    this.mAdProgressButton.setProgress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.a
 * JD-Core Version:    0.7.0.1
 */