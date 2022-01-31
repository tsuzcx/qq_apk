package com.tencent.component.network.downloader.impl;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.FutureListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class DownloaderImpl$1
  implements FutureListener<DownloadResult>
{
  DownloaderImpl$1(DownloaderImpl paramDownloaderImpl, DownloadTask paramDownloadTask) {}
  
  public void onFutureBegin(Future<DownloadResult> arg1)
  {
    if (this.val$task.mOriginalIsHttp2) {
      DownloaderImpl.access$108();
    }
    for (;;)
    {
      synchronized (DownloaderImpl.access$300(this.this$0).obtaionLock(this.val$task.getUrl()))
      {
        synchronized (DownloaderImpl.access$400(this.this$0))
        {
          WeakReference localWeakReference1 = new WeakReference(this.val$task);
          Object localObject4;
          if (localWeakReference1 != null)
          {
            localObject4 = (List)DownloaderImpl.access$500(this.this$0).get(this.val$task.getUrl());
            if (localObject4 == null)
            {
              localObject4 = new ArrayList();
              ((List)localObject4).add(localWeakReference1);
              DownloaderImpl.access$500(this.this$0).put(this.val$task.getUrl(), localObject4);
            }
          }
          else
          {
            return;
            DownloaderImpl.access$208();
            continue;
          }
          Iterator localIterator = ((List)localObject4).iterator();
          if (localIterator.hasNext())
          {
            WeakReference localWeakReference2 = (WeakReference)localIterator.next();
            if ((localWeakReference2 == null) || ((DownloadTask)localWeakReference2.get() != this.val$task)) {
              continue;
            }
            i = 0;
            if (i == 0) {
              continue;
            }
            ((List)localObject4).add(localWeakReference1);
          }
        }
      }
      int i = 1;
    }
  }
  
  /* Error */
  public void onFutureDone(Future<DownloadResult> paramFuture)
  {
    // Byte code:
    //   0: invokestatic 110	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   3: ifeq +33 -> 36
    //   6: ldc 112
    //   8: new 114	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   15: ldc 117
    //   17: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_0
    //   21: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   24: invokevirtual 43	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   27: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 128	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   40: getfield 29	com/tencent/component/network/downloader/impl/DownloadTask:mOriginalIsHttp2	Z
    //   43: ifeq +555 -> 598
    //   46: invokestatic 131	com/tencent/component/network/downloader/impl/DownloaderImpl:access$110	()I
    //   49: pop
    //   50: aload_0
    //   51: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   54: invokevirtual 134	com/tencent/component/network/downloader/impl/DownloadTask:getUrlKey	()Ljava/lang/String;
    //   57: astore 14
    //   59: aload_0
    //   60: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   63: invokestatic 138	com/tencent/component/network/downloader/impl/DownloaderImpl:access$600	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Ljava/util/HashMap;
    //   66: astore 13
    //   68: aload 13
    //   70: monitorenter
    //   71: aload_0
    //   72: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   75: invokestatic 138	com/tencent/component/network/downloader/impl/DownloaderImpl:access$600	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Ljava/util/HashMap;
    //   78: aload 14
    //   80: invokevirtual 143	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: aload 13
    //   86: monitorexit
    //   87: aload_1
    //   88: invokeinterface 146 1 0
    //   93: checkcast 148	com/tencent/component/network/downloader/DownloadResult
    //   96: astore 19
    //   98: invokestatic 110	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   101: ifeq +92 -> 193
    //   104: aload 19
    //   106: ifnull +505 -> 611
    //   109: ldc2_w 149
    //   112: lstore 8
    //   114: aload 19
    //   116: invokevirtual 153	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   119: ifnull +20 -> 139
    //   122: new 155	java/io/File
    //   125: dup
    //   126: aload 19
    //   128: invokevirtual 153	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   131: invokespecial 158	java/io/File:<init>	(Ljava/lang/String;)V
    //   134: invokevirtual 162	java/io/File:length	()J
    //   137: lstore 8
    //   139: ldc 112
    //   141: new 114	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   148: ldc 164
    //   150: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload 19
    //   155: invokevirtual 168	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   158: invokevirtual 173	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   161: invokevirtual 176	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   164: ldc 178
    //   166: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 19
    //   171: invokevirtual 153	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   174: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc 180
    //   179: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: lload 8
    //   184: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   187: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 128	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload 19
    //   195: ifnull +41 -> 236
    //   198: aload 19
    //   200: invokevirtual 187	com/tencent/component/network/downloader/DownloadResult:getReport	()Lcom/tencent/component/network/downloader/DownloadReport;
    //   203: astore 13
    //   205: aload 19
    //   207: invokevirtual 168	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   210: astore 15
    //   212: aload 13
    //   214: ifnull +22 -> 236
    //   217: aload 15
    //   219: ifnull +17 -> 236
    //   222: aload 13
    //   224: aload 15
    //   226: aload_0
    //   227: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   230: getfield 29	com/tencent/component/network/downloader/impl/DownloadTask:mOriginalIsHttp2	Z
    //   233: invokestatic 191	com/tencent/component/network/downloader/impl/DownloaderImpl:access$700	(Lcom/tencent/component/network/downloader/DownloadReport;Lcom/tencent/component/network/downloader/DownloadResult$Status;Z)V
    //   236: invokestatic 196	java/lang/System:currentTimeMillis	()J
    //   239: pop2
    //   240: aload_0
    //   241: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   244: invokestatic 39	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/impl/DownloaderImpl$LockManager;
    //   247: aload_0
    //   248: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   251: invokevirtual 43	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   254: invokevirtual 49	com/tencent/component/network/downloader/impl/DownloaderImpl$LockManager:obtaionLock	(Ljava/lang/String;)Ljava/lang/Object;
    //   257: astore 18
    //   259: aload 18
    //   261: monitorenter
    //   262: aload_0
    //   263: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   266: invokestatic 53	com/tencent/component/network/downloader/impl/DownloaderImpl:access$400	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Ljava/lang/Object;
    //   269: astore 15
    //   271: aload 15
    //   273: monitorenter
    //   274: aload_0
    //   275: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   278: invokestatic 62	com/tencent/component/network/downloader/impl/DownloaderImpl:access$500	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Ljava/util/Map;
    //   281: aload_0
    //   282: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   285: invokevirtual 43	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   288: invokeinterface 199 2 0
    //   293: ifeq +128 -> 421
    //   296: aload_0
    //   297: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   300: invokestatic 62	com/tencent/component/network/downloader/impl/DownloaderImpl:access$500	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Ljava/util/Map;
    //   303: aload_0
    //   304: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   307: invokevirtual 43	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   310: invokeinterface 68 2 0
    //   315: checkcast 70	java/util/List
    //   318: astore 16
    //   320: aload 16
    //   322: ifnull +99 -> 421
    //   325: aload 16
    //   327: invokeinterface 88 1 0
    //   332: astore 17
    //   334: aload 17
    //   336: invokeinterface 94 1 0
    //   341: ifeq +1459 -> 1800
    //   344: aload 17
    //   346: invokeinterface 98 1 0
    //   351: checkcast 55	java/lang/ref/WeakReference
    //   354: astore 13
    //   356: aload 13
    //   358: ifnull -24 -> 334
    //   361: aload 13
    //   363: invokevirtual 100	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   366: checkcast 25	com/tencent/component/network/downloader/impl/DownloadTask
    //   369: aload_0
    //   370: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   373: if_acmpne -39 -> 334
    //   376: aload 13
    //   378: ifnull +43 -> 421
    //   381: aload 16
    //   383: aload 13
    //   385: invokeinterface 201 2 0
    //   390: pop
    //   391: aload 16
    //   393: invokeinterface 204 1 0
    //   398: ifgt +23 -> 421
    //   401: aload_0
    //   402: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   405: invokestatic 62	com/tencent/component/network/downloader/impl/DownloaderImpl:access$500	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Ljava/util/Map;
    //   408: aload_0
    //   409: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   412: invokevirtual 43	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   415: invokeinterface 205 2 0
    //   420: pop
    //   421: aload 15
    //   423: monitorexit
    //   424: aload 19
    //   426: ifnull +368 -> 794
    //   429: aload 19
    //   431: invokevirtual 168	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   434: invokevirtual 208	com/tencent/component/network/downloader/DownloadResult$Status:isRetrying	()Z
    //   437: ifeq +357 -> 794
    //   440: invokestatic 110	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   443: ifeq +38 -> 481
    //   446: ldc 112
    //   448: new 114	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   455: ldc 164
    //   457: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload_0
    //   461: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   464: invokevirtual 43	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   467: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: ldc 210
    //   472: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   478: invokestatic 128	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   481: aload 19
    //   483: ifnull +94 -> 577
    //   486: aload_1
    //   487: invokeinterface 213 1 0
    //   492: ifne +85 -> 577
    //   495: aload_0
    //   496: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   499: invokestatic 217	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1200	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   502: ifnull +28 -> 530
    //   505: aload_0
    //   506: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   509: invokestatic 220	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   512: aload 19
    //   514: invokevirtual 221	com/tencent/component/network/downloader/DownloadResult:getUrl	()Ljava/lang/String;
    //   517: aload 19
    //   519: invokevirtual 168	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   522: invokevirtual 173	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   525: invokeinterface 227 3 0
    //   530: aload 19
    //   532: invokevirtual 168	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   535: invokevirtual 173	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   538: ifne +13 -> 551
    //   541: aload_0
    //   542: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   545: invokestatic 230	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1400	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   548: ifnonnull +29 -> 577
    //   551: aload 19
    //   553: invokevirtual 153	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   556: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   559: ifne +18 -> 577
    //   562: new 155	java/io/File
    //   565: dup
    //   566: aload 19
    //   568: invokevirtual 153	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   571: invokespecial 158	java/io/File:<init>	(Ljava/lang/String;)V
    //   574: invokestatic 242	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   577: aload_0
    //   578: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   581: invokestatic 39	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/impl/DownloaderImpl$LockManager;
    //   584: aload_0
    //   585: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   588: invokevirtual 43	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   591: invokevirtual 245	com/tencent/component/network/downloader/impl/DownloaderImpl$LockManager:releaseLock	(Ljava/lang/String;)V
    //   594: aload 18
    //   596: monitorexit
    //   597: return
    //   598: invokestatic 248	com/tencent/component/network/downloader/impl/DownloaderImpl:access$210	()I
    //   601: pop
    //   602: goto -552 -> 50
    //   605: astore_1
    //   606: aload 13
    //   608: monitorexit
    //   609: aload_1
    //   610: athrow
    //   611: ldc 112
    //   613: ldc 250
    //   615: invokestatic 128	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   618: goto -425 -> 193
    //   621: astore 13
    //   623: aload 15
    //   625: monitorexit
    //   626: aload 13
    //   628: athrow
    //   629: astore 13
    //   631: aload 19
    //   633: ifnull +94 -> 727
    //   636: aload_1
    //   637: invokeinterface 213 1 0
    //   642: ifne +85 -> 727
    //   645: aload_0
    //   646: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   649: invokestatic 217	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1200	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   652: ifnull +28 -> 680
    //   655: aload_0
    //   656: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   659: invokestatic 220	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   662: aload 19
    //   664: invokevirtual 221	com/tencent/component/network/downloader/DownloadResult:getUrl	()Ljava/lang/String;
    //   667: aload 19
    //   669: invokevirtual 168	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   672: invokevirtual 173	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   675: invokeinterface 227 3 0
    //   680: aload 19
    //   682: invokevirtual 168	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   685: invokevirtual 173	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   688: ifne +13 -> 701
    //   691: aload_0
    //   692: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   695: invokestatic 230	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1400	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   698: ifnonnull +29 -> 727
    //   701: aload 19
    //   703: invokevirtual 153	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   706: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   709: ifne +18 -> 727
    //   712: new 155	java/io/File
    //   715: dup
    //   716: aload 19
    //   718: invokevirtual 153	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   721: invokespecial 158	java/io/File:<init>	(Ljava/lang/String;)V
    //   724: invokestatic 242	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   727: aload_0
    //   728: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   731: invokestatic 39	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/impl/DownloaderImpl$LockManager;
    //   734: aload_0
    //   735: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   738: invokevirtual 43	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   741: invokevirtual 245	com/tencent/component/network/downloader/impl/DownloaderImpl$LockManager:releaseLock	(Ljava/lang/String;)V
    //   744: aload 13
    //   746: athrow
    //   747: astore_1
    //   748: aload 18
    //   750: monitorexit
    //   751: aload_1
    //   752: athrow
    //   753: astore_1
    //   754: aload_0
    //   755: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   758: invokestatic 39	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/impl/DownloaderImpl$LockManager;
    //   761: aload_0
    //   762: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   765: invokevirtual 43	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   768: invokevirtual 245	com/tencent/component/network/downloader/impl/DownloaderImpl$LockManager:releaseLock	(Ljava/lang/String;)V
    //   771: goto -177 -> 594
    //   774: astore_1
    //   775: aload_0
    //   776: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   779: invokestatic 39	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/impl/DownloaderImpl$LockManager;
    //   782: aload_0
    //   783: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   786: invokevirtual 43	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   789: invokevirtual 245	com/tencent/component/network/downloader/impl/DownloaderImpl$LockManager:releaseLock	(Ljava/lang/String;)V
    //   792: aload_1
    //   793: athrow
    //   794: aload_0
    //   795: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   798: aload 14
    //   800: iconst_1
    //   801: aconst_null
    //   802: invokestatic 254	com/tencent/component/network/downloader/impl/DownloaderImpl:access$800	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;Ljava/lang/String;ZLjava/util/Collection;)Ljava/util/Collection;
    //   805: astore 20
    //   807: aload 19
    //   809: ifnull +14 -> 823
    //   812: aload 19
    //   814: invokevirtual 168	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   817: invokevirtual 173	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   820: ifne +131 -> 951
    //   823: aload_0
    //   824: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   827: aload 20
    //   829: aload 19
    //   831: invokestatic 258	com/tencent/component/network/downloader/impl/DownloaderImpl:access$900	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;Ljava/util/Collection;Lcom/tencent/component/network/downloader/DownloadResult;)V
    //   834: aload 19
    //   836: ifnull +94 -> 930
    //   839: aload_1
    //   840: invokeinterface 213 1 0
    //   845: ifne +85 -> 930
    //   848: aload_0
    //   849: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   852: invokestatic 217	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1200	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   855: ifnull +28 -> 883
    //   858: aload_0
    //   859: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   862: invokestatic 220	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   865: aload 19
    //   867: invokevirtual 221	com/tencent/component/network/downloader/DownloadResult:getUrl	()Ljava/lang/String;
    //   870: aload 19
    //   872: invokevirtual 168	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   875: invokevirtual 173	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   878: invokeinterface 227 3 0
    //   883: aload 19
    //   885: invokevirtual 168	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   888: invokevirtual 173	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   891: ifne +13 -> 904
    //   894: aload_0
    //   895: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   898: invokestatic 230	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1400	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   901: ifnonnull +29 -> 930
    //   904: aload 19
    //   906: invokevirtual 153	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   909: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   912: ifne +18 -> 930
    //   915: new 155	java/io/File
    //   918: dup
    //   919: aload 19
    //   921: invokevirtual 153	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   924: invokespecial 158	java/io/File:<init>	(Ljava/lang/String;)V
    //   927: invokestatic 242	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   930: aload_0
    //   931: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   934: invokestatic 39	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/impl/DownloaderImpl$LockManager;
    //   937: aload_0
    //   938: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   941: invokevirtual 43	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   944: invokevirtual 245	com/tencent/component/network/downloader/impl/DownloaderImpl$LockManager:releaseLock	(Ljava/lang/String;)V
    //   947: aload 18
    //   949: monitorexit
    //   950: return
    //   951: iconst_0
    //   952: istore_2
    //   953: aload 20
    //   955: ifnull +713 -> 1668
    //   958: new 72	java/util/ArrayList
    //   961: dup
    //   962: invokespecial 73	java/util/ArrayList:<init>	()V
    //   965: astore 21
    //   967: new 155	java/io/File
    //   970: dup
    //   971: aload 19
    //   973: invokevirtual 153	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   976: invokespecial 158	java/io/File:<init>	(Ljava/lang/String;)V
    //   979: astore 16
    //   981: aconst_null
    //   982: astore 13
    //   984: aload 16
    //   986: invokevirtual 162	java/io/File:length	()J
    //   989: lstore 8
    //   991: aload 20
    //   993: invokeinterface 261 1 0
    //   998: astore 22
    //   1000: iconst_0
    //   1001: istore_2
    //   1002: aload 22
    //   1004: invokeinterface 94 1 0
    //   1009: ifeq +842 -> 1851
    //   1012: aload 22
    //   1014: invokeinterface 98 1 0
    //   1019: checkcast 263	com/tencent/component/network/downloader/DownloadRequest
    //   1022: astore 23
    //   1024: aload 23
    //   1026: ifnull -24 -> 1002
    //   1029: aload 23
    //   1031: invokevirtual 266	com/tencent/component/network/downloader/DownloadRequest:isCanceled	()Z
    //   1034: ifne -32 -> 1002
    //   1037: aload 23
    //   1039: invokevirtual 269	com/tencent/component/network/downloader/DownloadRequest:shouldCacheEntry	()Z
    //   1042: ifeq +742 -> 1784
    //   1045: iconst_1
    //   1046: istore_2
    //   1047: aload 23
    //   1049: invokevirtual 273	com/tencent/component/network/downloader/DownloadRequest:getPaths	()[Ljava/lang/String;
    //   1052: astore 24
    //   1054: aload 24
    //   1056: ifnull +579 -> 1635
    //   1059: iconst_0
    //   1060: istore 5
    //   1062: aload 24
    //   1064: arraylength
    //   1065: istore 6
    //   1067: iconst_0
    //   1068: istore_3
    //   1069: iload 5
    //   1071: istore 4
    //   1073: iload_3
    //   1074: iload 6
    //   1076: if_icmpge +730 -> 1806
    //   1079: aload 21
    //   1081: aload 24
    //   1083: iload_3
    //   1084: aaload
    //   1085: invokeinterface 276 2 0
    //   1090: ifeq +724 -> 1814
    //   1093: iconst_1
    //   1094: istore 4
    //   1096: goto +710 -> 1806
    //   1099: aload 24
    //   1101: arraylength
    //   1102: istore 7
    //   1104: iconst_0
    //   1105: istore 5
    //   1107: aload 13
    //   1109: astore 14
    //   1111: iload 5
    //   1113: iload 7
    //   1115: if_icmpge +729 -> 1844
    //   1118: aload 24
    //   1120: iload 5
    //   1122: aaload
    //   1123: astore 25
    //   1125: aload 25
    //   1127: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1130: ifeq +10 -> 1140
    //   1133: aload 13
    //   1135: astore 14
    //   1137: goto +684 -> 1821
    //   1140: aload 13
    //   1142: astore 14
    //   1144: aload_0
    //   1145: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   1148: aload 19
    //   1150: aload 23
    //   1152: invokestatic 280	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1000	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadRequest;)Z
    //   1155: ifne +666 -> 1821
    //   1158: aload 13
    //   1160: astore 14
    //   1162: aload 19
    //   1164: invokevirtual 153	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   1167: ifnull +654 -> 1821
    //   1170: aload 21
    //   1172: aload 25
    //   1174: invokeinterface 276 2 0
    //   1179: istore 12
    //   1181: aload 13
    //   1183: astore 14
    //   1185: iload 12
    //   1187: ifne +634 -> 1821
    //   1190: iconst_1
    //   1191: istore 4
    //   1193: iconst_0
    //   1194: istore_3
    //   1195: iload 4
    //   1197: iflt +393 -> 1590
    //   1200: iload_3
    //   1201: ifne +389 -> 1590
    //   1204: iload 4
    //   1206: iconst_1
    //   1207: isub
    //   1208: istore 6
    //   1210: new 155	java/io/File
    //   1213: dup
    //   1214: aload 25
    //   1216: invokespecial 158	java/io/File:<init>	(Ljava/lang/String;)V
    //   1219: astore 17
    //   1221: aload 13
    //   1223: ifnull +11 -> 1234
    //   1226: aload 13
    //   1228: invokevirtual 283	java/io/File:exists	()Z
    //   1231: ifne +559 -> 1790
    //   1234: aload 16
    //   1236: aload 17
    //   1238: invokestatic 287	com/tencent/component/network/utils/FileUtils:rename	(Ljava/io/File;Ljava/io/File;)Z
    //   1241: istore 12
    //   1243: iload 12
    //   1245: ifeq +542 -> 1787
    //   1248: iconst_1
    //   1249: istore_3
    //   1250: aload 17
    //   1252: astore 13
    //   1254: aload 13
    //   1256: astore 14
    //   1258: ldc 112
    //   1260: new 114	java/lang/StringBuilder
    //   1263: dup
    //   1264: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   1267: ldc_w 289
    //   1270: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1273: aload 16
    //   1275: invokevirtual 290	java/io/File:getPath	()Ljava/lang/String;
    //   1278: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1281: ldc_w 292
    //   1284: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1287: aload 25
    //   1289: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: ldc_w 294
    //   1295: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1298: aload_0
    //   1299: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   1302: invokevirtual 43	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   1305: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1308: ldc_w 296
    //   1311: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: iload 12
    //   1316: invokevirtual 176	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1319: ldc_w 298
    //   1322: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: lload 8
    //   1327: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1330: ldc_w 300
    //   1333: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: aload 17
    //   1338: invokevirtual 162	java/io/File:length	()J
    //   1341: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1344: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1347: invokestatic 303	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1350: iload_3
    //   1351: istore 4
    //   1353: iload_3
    //   1354: ifne +480 -> 1834
    //   1357: aload 13
    //   1359: ifnull +434 -> 1793
    //   1362: aload 13
    //   1364: astore 14
    //   1366: aload 13
    //   1368: invokevirtual 283	java/io/File:exists	()Z
    //   1371: ifeq +422 -> 1793
    //   1374: aload 13
    //   1376: astore 15
    //   1378: aload 13
    //   1380: astore 14
    //   1382: aload 15
    //   1384: aload 17
    //   1386: invokestatic 306	com/tencent/component/network/utils/FileUtils:copyFiles	(Ljava/io/File;Ljava/io/File;)Z
    //   1389: istore 12
    //   1391: aload 13
    //   1393: astore 14
    //   1395: aload 17
    //   1397: invokevirtual 162	java/io/File:length	()J
    //   1400: lstore 10
    //   1402: aload 13
    //   1404: astore 14
    //   1406: ldc 112
    //   1408: new 114	java/lang/StringBuilder
    //   1411: dup
    //   1412: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   1415: ldc_w 308
    //   1418: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1421: aload 15
    //   1423: invokevirtual 290	java/io/File:getPath	()Ljava/lang/String;
    //   1426: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1429: ldc_w 292
    //   1432: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1435: aload 25
    //   1437: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1440: ldc_w 294
    //   1443: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: aload_0
    //   1447: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   1450: invokevirtual 43	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   1453: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1456: ldc_w 296
    //   1459: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1462: iload 12
    //   1464: invokevirtual 176	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1467: ldc_w 298
    //   1470: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1473: lload 8
    //   1475: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1478: ldc_w 300
    //   1481: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: lload 10
    //   1486: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1489: ldc_w 310
    //   1492: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: iload 6
    //   1497: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1500: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1503: invokestatic 303	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1506: iload 12
    //   1508: ifeq +17 -> 1525
    //   1511: lload 8
    //   1513: lload 10
    //   1515: lcmp
    //   1516: ifne +9 -> 1525
    //   1519: iconst_1
    //   1520: istore 4
    //   1522: goto +312 -> 1834
    //   1525: aload 13
    //   1527: astore 14
    //   1529: aload 17
    //   1531: invokestatic 242	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   1534: iload_3
    //   1535: istore 4
    //   1537: goto +297 -> 1834
    //   1540: astore 15
    //   1542: aload 14
    //   1544: astore 13
    //   1546: aload 15
    //   1548: astore 14
    //   1550: ldc 112
    //   1552: new 114	java/lang/StringBuilder
    //   1555: dup
    //   1556: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   1559: ldc_w 315
    //   1562: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1565: aload_0
    //   1566: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   1569: invokevirtual 43	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   1572: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1575: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1578: aload 14
    //   1580: invokestatic 319	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1583: aload 13
    //   1585: astore 14
    //   1587: goto +234 -> 1821
    //   1590: iload_3
    //   1591: ifeq +20 -> 1611
    //   1594: aload 21
    //   1596: aload 25
    //   1598: invokeinterface 77 2 0
    //   1603: pop
    //   1604: aload 13
    //   1606: astore 14
    //   1608: goto +236 -> 1844
    //   1611: new 155	java/io/File
    //   1614: dup
    //   1615: aload 25
    //   1617: invokespecial 158	java/io/File:<init>	(Ljava/lang/String;)V
    //   1620: invokestatic 242	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   1623: aload 13
    //   1625: astore 14
    //   1627: goto +194 -> 1821
    //   1630: astore 14
    //   1632: goto -82 -> 1550
    //   1635: aload 13
    //   1637: astore 14
    //   1639: aload 23
    //   1641: getfield 323	com/tencent/component/network/downloader/DownloadRequest:outputStream	Ljava/io/OutputStream;
    //   1644: ifnull +200 -> 1844
    //   1647: aload 19
    //   1649: invokevirtual 153	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   1652: aload 23
    //   1654: getfield 323	com/tencent/component/network/downloader/DownloadRequest:outputStream	Ljava/io/OutputStream;
    //   1657: invokestatic 327	com/tencent/component/network/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/io/OutputStream;)Z
    //   1660: pop
    //   1661: aload 13
    //   1663: astore 14
    //   1665: goto +179 -> 1844
    //   1668: aload_0
    //   1669: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   1672: aload 20
    //   1674: aload 19
    //   1676: invokestatic 330	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1100	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;Ljava/util/Collection;Lcom/tencent/component/network/downloader/DownloadResult;)V
    //   1679: iload_2
    //   1680: ifeq -846 -> 834
    //   1683: aload_0
    //   1684: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   1687: aload_0
    //   1688: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   1691: invokevirtual 43	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   1694: aload 19
    //   1696: invokevirtual 334	com/tencent/component/network/downloader/impl/DownloaderImpl:addCacheEntry	(Ljava/lang/String;Lcom/tencent/component/network/downloader/DownloadResult;)V
    //   1699: goto -865 -> 834
    //   1702: astore_1
    //   1703: aload_0
    //   1704: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   1707: invokestatic 39	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/impl/DownloaderImpl$LockManager;
    //   1710: aload_0
    //   1711: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   1714: invokevirtual 43	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   1717: invokevirtual 245	com/tencent/component/network/downloader/impl/DownloaderImpl$LockManager:releaseLock	(Ljava/lang/String;)V
    //   1720: goto -773 -> 947
    //   1723: astore_1
    //   1724: aload_0
    //   1725: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   1728: invokestatic 39	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/impl/DownloaderImpl$LockManager;
    //   1731: aload_0
    //   1732: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   1735: invokevirtual 43	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   1738: invokevirtual 245	com/tencent/component/network/downloader/impl/DownloaderImpl$LockManager:releaseLock	(Ljava/lang/String;)V
    //   1741: aload_1
    //   1742: athrow
    //   1743: astore_1
    //   1744: aload_0
    //   1745: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   1748: invokestatic 39	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/impl/DownloaderImpl$LockManager;
    //   1751: aload_0
    //   1752: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   1755: invokevirtual 43	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   1758: invokevirtual 245	com/tencent/component/network/downloader/impl/DownloaderImpl$LockManager:releaseLock	(Ljava/lang/String;)V
    //   1761: goto -1017 -> 744
    //   1764: astore_1
    //   1765: aload_0
    //   1766: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   1769: invokestatic 39	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/impl/DownloaderImpl$LockManager;
    //   1772: aload_0
    //   1773: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   1776: invokevirtual 43	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   1779: invokevirtual 245	com/tencent/component/network/downloader/impl/DownloaderImpl$LockManager:releaseLock	(Ljava/lang/String;)V
    //   1782: aload_1
    //   1783: athrow
    //   1784: goto -737 -> 1047
    //   1787: goto -533 -> 1254
    //   1790: goto -440 -> 1350
    //   1793: aload 16
    //   1795: astore 15
    //   1797: goto -419 -> 1378
    //   1800: aconst_null
    //   1801: astore 13
    //   1803: goto -1427 -> 376
    //   1806: iload 4
    //   1808: ifeq -709 -> 1099
    //   1811: goto -809 -> 1002
    //   1814: iload_3
    //   1815: iconst_1
    //   1816: iadd
    //   1817: istore_3
    //   1818: goto -749 -> 1069
    //   1821: iload 5
    //   1823: iconst_1
    //   1824: iadd
    //   1825: istore 5
    //   1827: aload 14
    //   1829: astore 13
    //   1831: goto -724 -> 1107
    //   1834: iload 4
    //   1836: istore_3
    //   1837: iload 6
    //   1839: istore 4
    //   1841: goto -646 -> 1195
    //   1844: aload 14
    //   1846: astore 13
    //   1848: goto -846 -> 1002
    //   1851: goto -183 -> 1668
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1854	0	this	1
    //   0	1854	1	paramFuture	Future<DownloadResult>
    //   952	728	2	i	int
    //   1068	769	3	j	int
    //   1071	769	4	k	int
    //   1060	766	5	m	int
    //   1065	773	6	n	int
    //   1102	14	7	i1	int
    //   112	1400	8	l1	long
    //   1400	114	10	l2	long
    //   1179	328	12	bool	boolean
    //   66	541	13	localObject1	Object
    //   621	6	13	localObject2	Object
    //   629	116	13	localObject3	Object
    //   982	865	13	localObject4	Object
    //   57	1569	14	localObject5	Object
    //   1630	1	14	localThrowable1	java.lang.Throwable
    //   1637	208	14	localObject6	Object
    //   210	1212	15	localObject7	Object
    //   1540	7	15	localThrowable2	java.lang.Throwable
    //   1795	1	15	localObject8	Object
    //   318	1476	16	localObject9	Object
    //   332	1198	17	localObject10	Object
    //   257	691	18	localObject11	Object
    //   96	1599	19	localDownloadResult	DownloadResult
    //   805	868	20	localCollection	java.util.Collection
    //   965	630	21	localArrayList	ArrayList
    //   998	15	22	localIterator	Iterator
    //   1022	631	23	localDownloadRequest	com.tencent.component.network.downloader.DownloadRequest
    //   1052	67	24	arrayOfString	java.lang.String[]
    //   1123	493	25	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   71	87	605	finally
    //   606	609	605	finally
    //   274	320	621	finally
    //   325	334	621	finally
    //   334	356	621	finally
    //   361	376	621	finally
    //   381	421	621	finally
    //   421	424	621	finally
    //   623	626	621	finally
    //   262	274	629	finally
    //   429	481	629	finally
    //   626	629	629	finally
    //   794	807	629	finally
    //   812	823	629	finally
    //   823	834	629	finally
    //   958	981	629	finally
    //   984	1000	629	finally
    //   1002	1024	629	finally
    //   1029	1045	629	finally
    //   1047	1054	629	finally
    //   1062	1067	629	finally
    //   1079	1093	629	finally
    //   1099	1104	629	finally
    //   1125	1133	629	finally
    //   1144	1158	629	finally
    //   1162	1181	629	finally
    //   1210	1221	629	finally
    //   1226	1234	629	finally
    //   1234	1243	629	finally
    //   1258	1350	629	finally
    //   1366	1374	629	finally
    //   1382	1391	629	finally
    //   1395	1402	629	finally
    //   1406	1506	629	finally
    //   1529	1534	629	finally
    //   1550	1583	629	finally
    //   1594	1604	629	finally
    //   1611	1623	629	finally
    //   1639	1661	629	finally
    //   1668	1679	629	finally
    //   1683	1699	629	finally
    //   577	594	747	finally
    //   594	597	747	finally
    //   727	744	747	finally
    //   744	747	747	finally
    //   748	751	747	finally
    //   754	771	747	finally
    //   775	794	747	finally
    //   930	947	747	finally
    //   947	950	747	finally
    //   1703	1720	747	finally
    //   1724	1743	747	finally
    //   1744	1761	747	finally
    //   1765	1784	747	finally
    //   486	530	753	java/lang/Throwable
    //   530	551	753	java/lang/Throwable
    //   551	577	753	java/lang/Throwable
    //   486	530	774	finally
    //   530	551	774	finally
    //   551	577	774	finally
    //   1258	1350	1540	java/lang/Throwable
    //   1366	1374	1540	java/lang/Throwable
    //   1382	1391	1540	java/lang/Throwable
    //   1395	1402	1540	java/lang/Throwable
    //   1406	1506	1540	java/lang/Throwable
    //   1529	1534	1540	java/lang/Throwable
    //   1210	1221	1630	java/lang/Throwable
    //   1226	1234	1630	java/lang/Throwable
    //   1234	1243	1630	java/lang/Throwable
    //   1594	1604	1630	java/lang/Throwable
    //   1611	1623	1630	java/lang/Throwable
    //   839	883	1702	java/lang/Throwable
    //   883	904	1702	java/lang/Throwable
    //   904	930	1702	java/lang/Throwable
    //   839	883	1723	finally
    //   883	904	1723	finally
    //   904	930	1723	finally
    //   636	680	1743	java/lang/Throwable
    //   680	701	1743	java/lang/Throwable
    //   701	727	1743	java/lang/Throwable
    //   636	680	1764	finally
    //   680	701	1764	finally
    //   701	727	1764	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.DownloaderImpl.1
 * JD-Core Version:    0.7.0.1
 */