package com.tencent.mobileqq.app;

import android.content.Context;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class FunnyPicHelper$1
  extends DownloadListener
{
  FunnyPicHelper$1(String paramString, File paramFile, CustomEmotionData paramCustomEmotionData, boolean paramBoolean1, boolean paramBoolean2, IFavroamingDBManagerService paramIFavroamingDBManagerService, IPicDownloadListener paramIPicDownloadListener, List paramList1, List paramList2, Context paramContext, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    FunnyPicHelper.a(paramDownloadTask, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FunnyPicHelper.1
 * JD-Core Version:    0.7.0.1
 */